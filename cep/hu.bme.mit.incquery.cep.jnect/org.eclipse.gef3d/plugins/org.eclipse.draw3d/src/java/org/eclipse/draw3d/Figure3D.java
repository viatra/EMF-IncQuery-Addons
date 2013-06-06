/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Translatable;
import org.eclipse.draw3d.geometry.IBoundingBox;
import org.eclipse.draw3d.geometry.IHost3D;
import org.eclipse.draw3d.geometry.IPosition3D.PositionHint;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.ParaxialBoundingBox;
import org.eclipse.draw3d.geometry.ParaxialBoundingBoxImpl;
import org.eclipse.draw3d.geometry.Position3D;
import org.eclipse.draw3d.geometry.Position3DUtil;
import org.eclipse.draw3d.geometry.Transformable;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometryext.SyncedVector3f;
import org.eclipse.draw3d.geometryext.SynchronizedPosition3DImpl;
import org.eclipse.draw3d.picking.Picker;
import org.eclipse.draw3d.util.Draw3DCache;
import org.eclipse.swt.graphics.Font;

/**
 * 3D version of GEF's Figure. This class extends Figure and can be used instead
 * of a 2D figure in 2D and 3D editors.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 08.11.2007
 */
public class Figure3D extends Figure implements IFigure3D {

	
	/**
	 * The texture needs to be invalidated every time a child is moved so that
	 * the changes are drawn on the screen.
	 */
	private FigureListener childMovedListener = new FigureListener() {

		public void figureMoved(IFigure i_source) {

			repaint2DComponents = true;
		}
	};

	/**
	 * The connection layer for his figure's 2D children.
	 */
	protected ConnectionLayer connectionLayer = null;

	/**
	 * This figure's friend.
	 */
	protected Figure3DFriend friend;

	/**
	 * This figure's helper.
	 */
	protected Figure3DHelper helper;

	/**
	 * The alpha value of this figure.
	 * 
	 * @see IFigure3D#setAlpha(byte)
	 */
	protected int m_alpha = 255;

	/**
	 * The paraxial bounding box.
	 */
	protected ParaxialBoundingBox m_paraxialBounds;

	/**
	 * The position of this figure. This field is declared final, it must not be
	 * changed. Instead, its values can be changed by using the position setter
	 * methods {e.g., @link
	 * Position3D#setPosition(org.eclipse.draw3d.geometry.IPosition3D)}.
	 */
	final Position3D position3D;

	/**
	 * The preferred 3D size of this figure. The preferred 3D size is
	 * synchronized with the preferred 2D size. preferredSize object is created
	 * lazily if it has not been created before in
	 * {@link #setPreferredSize3D(IVector3f)} and {@link #getPreferredSize3D()}.
	 * Thus, if you are using this member in subclasses directly, remember that
	 * it might be null (and will be in most cases, since it is only used by
	 * some special layout managers).
	 */
	protected SyncedVector3f preferredSize3D;

	/**
	 * Used to determine whether 2D content is to be rendered again.
	 * {@link #isRepaint2DComponents()}
	 */
	protected boolean repaint2DComponents = true;

	/**
	 * Boolean semaphore used by {@link #syncSize()} and {@link #syncSize3D()}
	 * to avoid infinite loop.
	 */
	protected boolean updatingBounds = false;
	
	// Unfortunately, this is not working. Besides, it requires Draw2D 3.6.
	// Instead, getBounds() is overridden with a dirty workaround.
	/*
	static class ClippingStrategyFigure3D implements IClippingStrategy {
		public Rectangle[] getClip(IFigure i_childFigure) {
			return new Rectangle[] { new Rectangle(i_childFigure.getBounds()) {
				public boolean intersects(Rectangle i_rect) {
					return true;
				}
			}};
		}
	}
	*/

	/**
	 * Creates and initializes a new 3D figure.
	 */
	public Figure3D() {

		position3D = createPosition3D();
		friend = new Figure3DFriend(this) {

			@SuppressWarnings("synthetic-access")
			@Override
			public Font getLocalFont() {

				return Figure3D.this.getLocalFont();
			}

			/** 
			 * {@inheritDoc}
			 * @see org.eclipse.draw3d.Figure3DFriend#is2DContentDirty()
			 */
			@Override
			public boolean is2DContentDirty() {
				return Figure3D.this.isRepaint2DComponents();
			}
		};

		helper = createFigure3DHelper(friend);
		
		// setClippingStrategy(new ClippingStrategyFigure3D());
	}
	
	

	/**
	 * @return
	 */
	protected boolean isRepaint2DComponents() {
		return repaint2DComponents;
	}



	/**
	 * Called exactly once by constructor, override by sub class if
	 * a different {@link Figure3DHelper} is required.
	 * @return
	 */
	protected Figure3DHelper createFigure3DHelper(Figure3DFriend i_friend) {
		return new Figure3DHelper(i_friend);
	}



	@Override
	public void add(IFigure i_figure, Object i_constraint, int i_index) {

		super.add(i_figure, i_constraint, i_index);

		// register as figure listener with 2D children so that we know when
		// they move
		if (!(i_figure instanceof IFigure3D))
			i_figure.addFigureListener(childMovedListener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.Renderable#collectRenderFragments(org.eclipse.draw3d.RenderContext)
	 */
	public void collectRenderFragments(RenderContext i_renderContext) {

		// nothing to do
	}

	/**
	 * Creates the position instance of this figure. By default, an instance of
	 * {@link SynchronizedPosition3DImpl} is created.
	 * 
	 * @return the position instance
	 */
	protected Position3D createPosition3D() {

		return new SynchronizedPosition3DImpl(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Figure#findFigureAt(int, int,
	 *      org.eclipse.draw2d.TreeSearch)
	 * @see Figure3DHelper#findFigureAt(int, int, TreeSearch)
	 */
	@Override
	public IFigure findFigureAt(int i_mx, int i_my, TreeSearch i_search) {

		return helper.findFigureAt(i_mx, i_my, i_search);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Figure#findMouseEventTargetAt(int, int)
	 */
	@Override
	public IFigure findMouseEventTargetAt(int i_sx, int i_sy) {

		Picker picker = getScene().getPicker();
		ISurface surface = picker.getCurrentSurface();

		return surface.findFigureAt(i_sx, i_sy, null);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Overriden to invalidate position 3D after the figure moved.
	 * {@link #invalidate()} is only called after a resize.
	 * </p>
	 * 
	 * @see org.eclipse.draw2d.Figure#fireFigureMoved()
	 */
	@Override
	protected void fireFigureMoved() {

		position3D.invalidate();

		invalidateAncestorParaxialBounds();
		invalidateParaxialBoundsTree();

		super.fireFigureMoved();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.IFigure3D#getAlpha()
	 */
	public int getAlpha() {

		return m_alpha;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.IFigure3D#getAncestor3D()
	 */
	public IFigure3D getAncestor3D() {

		return Figure3DHelper.getAncestor3D(getParent());
	}

	// Overriding setBounds instead and update bounds in setSize3D/setLocatoin3D
	//
	/**
	 * Returns 2D bounds of this figure. If resolution is not disabled, the
	 * bounds are converted from the 3D bounds, simply ignoring the z values of
	 * position and size. Otherwise, the 2D bounds are returned.
	 * <p>
	 * Due to a change in Draw2D 3.6, this method contains a dirty workaround
	 * to solve a problem with clipping. In 3D, clipping is handled completely
	 * differently, as things like dirty regions do not exists in a 3D scene 
	 * (the 3D scene is always redrawn completely). Thus, {@link #intersects(Rectangle)}
	 * always returns true in the 3D version. With Draw2D 3.6, instead of
	 * calling {@link #intersects(Rectangle)}, a clipping strategy is used. If
	 * this is not set (which should be true for elder editors, as the 
	 * interface IClippingStrategy was only introduced with 3.6 and for all
	 * 3D figures), the bounds of the figure are used. However, this lead
	 * to a slightly semantic change: instead of calling
	 * {@link IFigure#intersects(Rectangle)}, {@link Rectangle#intersects(Rectangle)} 
	 * get called. Thus, the overridden method {@link #intersects(Rectangle)} is
	 * not called anymore, disabling the workaround implemented there. So we 
	 * have to add a new workaround here.
	 * </p>
	 * @todo Refactor the clipping and dirty region problem.
	 * @see org.eclipse.draw2d.Figure#getBounds()
	 */
	@Override
	public Rectangle getBounds() {
		return new Rectangle(super.getBounds()) {
			private static final long serialVersionUID = -3392742516541083249L;

			/** 
			 * {@inheritDoc}
			 * @see org.eclipse.draw2d.geometry.Rectangle#intersects(org.eclipse.draw2d.geometry.Rectangle)
			 */
			@Override
			public boolean intersects(Rectangle i_rect) {
				return true;
			}
		};
		//return super.getBounds();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.IFigure3D#getBounds3D()
	 */
	public IBoundingBox getBounds3D() {

		return position3D.getBounds3D();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.IFigure2DHost3D#getChildren2D()
	 */
	public List<IFigure> getChildren2D() {

		return helper.getChildren2D();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.IFigure3D#getChildren3D()
	 */
	public List<IFigure3D> getChildren3D() {

		return helper.getChildren3D();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.IFigure2DHost3D#getConnectionLayer(org.eclipse.draw3d.ConnectionLayerFactory)
	 */
	public ConnectionLayer getConnectionLayer(ConnectionLayerFactory i_clfactory) {

		if (connectionLayer == null && i_clfactory != null) {
			connectionLayer = i_clfactory.createConnectionLayer(this);
			// add(connectionLayer); // or else it doesn't have an update
			// manager
		}
		return connectionLayer;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.IFigure3D#getSuccessor3D()
	 */
	public List<IFigure3D> getDescendants3D() {

		return helper.getDescendants3D(true);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.picking.Pickable#getDistance(org.eclipse.draw3d.geometry.IVector3f,
	 *      org.eclipse.draw3d.geometry.IVector3f, java.util.Map)
	 */
	public float getDistance(IVector3f i_rayOrigin, IVector3f i_rayDirection,
		Map<Object, Object> i_context) {

		return Float.NaN;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.IFigure3D#getParaxialBoundingBox(org.eclipse.draw3d.geometry.ParaxialBoundingBox)
	 */
	public ParaxialBoundingBox getParaxialBoundingBox(
		ParaxialBoundingBox o_result) {

		ParaxialBoundingBox result = o_result;
		if (o_result == null)
			result = new ParaxialBoundingBoxImpl();

		Vector3f location = Draw3DCache.getVector3f();
		Vector3f size = Draw3DCache.getVector3f();
		try {
			if (m_paraxialBounds == null) {
				Math3D.getCuboidParaxialBoundingBox(getPosition3D(), location,
					size);

				m_paraxialBounds = new ParaxialBoundingBoxImpl();
				m_paraxialBounds.setLocation(location);
				m_paraxialBounds.setSize(size);
				helper.unionWithChildParaxialBounds(m_paraxialBounds);
			}

			m_paraxialBounds.getLocation(location);
			m_paraxialBounds.getSize(size);

			result.setLocation(location);
			result.setSize(size);

			return result;
		} finally {
			Draw3DCache.returnVector3f(location, size);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IHost3D#getParentHost3D()
	 */
	public IHost3D getParentHost3D() {

		return getAncestor3D();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IHost3D#getPosition3D()
	 */
	public Position3D getPosition3D() {

		return position3D;
	}

	/**
	 * Returns preferred 3D size, this size is synchronized with 2D dimension.
	 * Actually the returned vector is a synchronized version of the 2D object.
	 * {@inheritDoc}
	 * <p>
	 * Internal note: preferredSize object is created lazily if it has not been
	 * created before
	 * </p>
	 * 
	 * @see org.eclipse.draw3d.IFigure3D#getPreferredSize3D()
	 */
	public IVector3f getPreferredSize3D() {

		if (preferredSize3D == null) {
			preferredSize3D = new SyncedVector3f();
		}
		return preferredSize3D.getVector3f(getPreferredSize());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.IFigure3D#getRenderContext()
	 */
	public RenderContext getRenderContext() {

		return getAncestor3D().getRenderContext();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.IFigure3D#getScene()
	 */
	public IScene getScene() {

		IFigure p = getParent();
		if (p == null)
			return null;

		return Figure3DHelper.getAncestor3D(p).getScene();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.IFigure2DHost3D#getSurface()
	 */
	public ISurface getSurface() {

		return null;
	}

	/**
	 * Returns always true -- clipping and optimized redraw of 3D figures is
	 * handled differently. There is no way to determine whether a 3D figure
	 * intersects with a 2D rectangle. Since this method is used during redraw,
	 * it must return true in order to get 3D figures painted if they are
	 * children of 2D figures. Possible 2D parents include layers and panes,
	 * which are in fact only structural nodes and not real figures.
	 * 
	 * @todo is this really ok?
	 * @see org.eclipse.draw2d.Figure#intersects(org.eclipse.draw2d.geometry.Rectangle)
	 */
	@Override
	public boolean intersects(Rectangle i_rect) {
		return true;
	}

	
	/**
	 * {@inheritDoc}
	 * <p>
	 * Overridden to invalidate position.
	 * </p>
	 * 
	 * @see org.eclipse.draw2d.Figure#invalidate()
	 */
	@Override
	public void invalidate() {

		position3D.invalidate();

		invalidateAncestorParaxialBounds();
		invalidateParaxialBoundsTree();

		super.invalidate();
	}

	/**
	 * 
	 */
	private void invalidateAncestorParaxialBounds() {
		IFigure parent = getParent();
		while (parent != null) {
			if (parent instanceof IFigure3D)
				((IFigure3D) parent).invalidateParaxialBounds();

			parent = parent.getParent();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.IFigure3D#invalidateParaxialBounds()
	 */
	public void invalidateParaxialBounds() {

		m_paraxialBounds = null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.IFigure3D#invalidateParaxialBoundsTree()
	 */
	public void invalidateParaxialBoundsTree() {

		helper.invalidateParaxialBoundsTree();
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Overridden to mark 2D components invalid, too.
	 * </p>
	 * 
	 * @see org.eclipse.draw2d.Figure#invalidateTree()
	 */
	@Override
	public void invalidateTree() {

		repaint2DComponents = true;
		super.invalidateTree();
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * This method is overridden here because it is neccessary to change the
	 * order of paint operations: The client area must be painted before the
	 * figure itself is painted, because otherwise the texture will not have
	 * been painted yet before it needs to be rendered.
	 * </p>
	 * 
	 * @see org.eclipse.draw2d.Figure#paint(org.eclipse.draw2d.Graphics)
	 */
	@Override
	public void paint(Graphics i_graphics) {

		paintBorder(i_graphics);
		paintClientArea(i_graphics);
		paintFigure(i_graphics);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void paintBorder(Graphics i_graphics) {

		helper.paintBorder(i_graphics);
	}

	/**
	 * Calls helper's {@link Figure3DHelper#paintChildren(Graphics)} and
	 * sets {@link #repaint2DComponents} to false.
	 * 
	 * @see org.eclipse.draw2d.Figure#paintChildren(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void paintChildren(Graphics i_graphics) {

		helper.paintChildren(i_graphics);
		repaint2DComponents = false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void paintFigure(Graphics i_graphics) {

		helper.paintFigure(i_graphics);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IHost3D#positionChanged(java.util.EnumSet,
	 *      org.eclipse.draw3d.geometry.IVector3f)
	 */
	public void positionChanged(EnumSet<PositionHint> i_hint, IVector3f delta) {

		boolean bFigureMoved = false;

		if (i_hint.contains(PositionHint.SIZE)) { // from old setSize3D method
			if (!(delta.getX() == 0 && delta.getY() == 0)
				&& (delta.getZ() != 0)) {
				invalidate();
				bFigureMoved = true;
			}
		}

		if (i_hint.contains(PositionHint.ROTATION)) { // from old setRotation3D
			bFigureMoved = true;
		}

		if (i_hint.contains(PositionHint.LOCATION)) { // from old setLocation3D
			if (delta.getX() != 0 || delta.getY() != 0 || delta.getZ() != 0) {
				bFigureMoved = true;
			}
		}

		if (bFigureMoved) {
			fireFigureMoved();
			repaint();
		}

	}

	@Override
	public void remove(IFigure i_figure) {

		super.remove(i_figure);
		if (!(i_figure instanceof IFigure3D))
			i_figure.removeFigureListener(childMovedListener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Figure#revalidate()
	 */
	@Override
	public void revalidate() {

		super.revalidate();
		helper.revalidate();
	}

	/**
	 * @see org.eclipse.draw3d.IFigure3D#setAlpha(int)
	 */
	public void setAlpha(int i_alpha) {

		m_alpha = i_alpha;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Internal note: preferredSize object is created lazily if it has not been
	 * created before
	 * </p>
	 * 
	 * @param i_preferredSize3D new preferred size, must not be null and all
	 *            values must not be less 0
	 * @see org.eclipse.draw3d.IFigure3D#setPreferredSize3D(org.eclipse.draw3d.geometry.IVector3f)
	 */
	public void setPreferredSize3D(IVector3f i_preferredSize3D) {

		if (i_preferredSize3D == null) // parameter precondition
			throw new NullPointerException("i_preferredSize3D must not be null");
		if (i_preferredSize3D.getX() < 0 || i_preferredSize3D.getY() < 0
			|| i_preferredSize3D.getZ() < 0) // parameter
			// precondition
			throw new IllegalArgumentException(
				"no value of given vector must be less 0, , was "
					+ i_preferredSize3D);

		if (preferredSize3D == null) {
			preferredSize3D = new SyncedVector3f();
		}
		Dimension size =
			preferredSize3D.setVector3fAsDimension(i_preferredSize3D);
		setPreferredSize(size);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		StringBuffer strb = new StringBuffer();
		strb.append(this.getClass().getName()).append(" at (");
		strb.append(getPosition3D().getLocation3D()).append(")");
		strb.append(", size (");
		strb.append(getPosition3D().getSize3D()).append(")");
		return strb.toString();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.IFigure3D#transformFromParent(org.eclipse.draw3d.geometry.Transformable)
	 */
	public void transformFromParent(Transformable i_transformable) {

		Position3DUtil.transformFromParent(position3D, i_transformable);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.IFigure3D#transformToAbsolute(org.eclipse.draw3d.geometry.Transformable)
	 */
	public void transformToAbsolute(Transformable io_transformable) {

		Position3DUtil.transformToAbsolute(position3D, io_transformable);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.IFigure3D#transformToParent(org.eclipse.draw3d.geometry.Transformable)
	 */
	public void transformToParent(Transformable io_transformable) {

		Position3DUtil.transformToParent(position3D, io_transformable);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.IFigure3D#transformToRelative(org.eclipse.draw3d.geometry.Transformable)
	 */
	public void transformToRelative(Transformable io_transformable) {

		Position3DUtil.transformToRelative(position3D, io_transformable);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Figure#translateFromParent(org.eclipse.draw2d.geometry.Translatable)
	 */
	@Override
	public void translateFromParent(Translatable i_t) {

		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Figure#translateToParent(org.eclipse.draw2d.geometry.Translatable)
	 */
	@Override
	public void translateToParent(Translatable i_t) {

		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Figure#useLocalCoordinates()
	 */
	@Override
	protected boolean useLocalCoordinates() {

		// otherwise, 2D children get drawn at their absolute positions and are
		// not visible on the texture
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Figure#validate()
	 */
	@Override
	public void validate() {

		super.validate();
		repaint2DComponents = true;
	}
}
