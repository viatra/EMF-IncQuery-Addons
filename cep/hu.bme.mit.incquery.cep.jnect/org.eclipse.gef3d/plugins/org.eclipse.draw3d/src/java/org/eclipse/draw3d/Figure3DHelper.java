/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.UpdateManager;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw3d.camera.CameraLodHelper;
import org.eclipse.draw3d.camera.ICamera;
import org.eclipse.draw3d.geometry.BoundingBox;
import org.eclipse.draw3d.geometry.BoundingBoxImpl;
import org.eclipse.draw3d.geometry.IBoundingBox;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.ParaxialBoundingBox;
import org.eclipse.draw3d.geometry.Position3D;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.graphics3d.Graphics3D;
import org.eclipse.draw3d.graphics3d.Graphics3DDraw;
import org.eclipse.draw3d.graphics3d.ILodHelper;
import org.eclipse.draw3d.graphics3d.RenderImage;
import org.eclipse.draw3d.picking.Picker;
import org.eclipse.draw3d.shapes.ParaxialBoundsFigureShape;
import org.eclipse.draw3d.util.Draw3DCache;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

/**
 * This helper class is used here as a delegator, since not all IFigure3D
 * implementations can be subclassed from Figure3D due to some design
 * restrictions in the original GEF. It implements template methods and other
 * stuff used by all IFigure3D implementations. IFigure implementations uses
 * this class with a delegator object. This is how this class is used:
 * 
 * <pre>
 * &lt;code&gt;
 *  ..
 *  protected Figure3DHelper helper;
 * .. 
 *  public Figure3D() {
 * 	helper = new Figure3DHelper(new Figure3DFriend(this) {
 * 		&#064;Override
 * 		Font getLocalFont() {
 * 			return Figure3D.this.getLocalFont();
 * 		}
 * 		&#064;Override
 * 		void paintBorder(Graphics i_graphics) {
 * 			Figure3D.this.paintBorder(i_graphics);
 * 		}
 * 		... and so on ...
 * 	});
 *      ..
 *  }
 *  
 *  ..
 *  
 *  &#064;Override
 * public void paint(Graphics graphics) {
 * 	helper.paint(graphics);
 * }
 * &lt;/code&gt;
 * </pre>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 21.11.2007
 */
public class Figure3DHelper {

	/**
	 * A render fragment that renders the {@link RenderImage} that belongs to a
	 * figure.
	 * 
	 * @author Kristian Duske
	 * @version $Revision$
	 * @since 11.01.2010
	 */
	private static class ImageRenderFragment implements RenderFragment {

		private IFigure3D m_figure;

		private RenderImage m_image;

		public ImageRenderFragment(IFigure3D i_figure) {
			m_figure = i_figure;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.RenderFragment#getDistanceMeasure(org.eclipse.draw3d.RenderContext)
		 */
		public float getDistanceMeasure(RenderContext i_renderContext) {
			ISurface surface = m_figure.getSurface();
			IVector3f normal = surface.getNormal();

			Vector3f viewDir = Draw3DCache.getVector3f();
			Vector3f viewPoint = Draw3DCache.getVector3f();
			Vector3f diff = Draw3DCache.getVector3f();
			try {
				ICamera camera = i_renderContext.getScene().getCamera();
				camera.getViewDirection(viewDir);
				camera.getPosition(viewPoint);

				IVector3f figCenter = m_figure.getPosition3D().getCenter3D();
				Math3D.sub(figCenter, viewPoint, diff);
				float dist = diff.lengthSquared();

				float cos = Math3D.dot(normal, viewDir);
				if (cos > 0)
					return dist + 0.1f;

				return dist - 0.1f;
			} finally {
				Draw3DCache.returnVector3f(viewDir, viewPoint, diff);
			}
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.RenderFragment#getRenderType()
		 */
		public RenderType getRenderType() {
			// TODO: what if the figure is superimposed?
			return RenderType.getRenderType(m_figure.getAlpha(), false);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.RenderFragment#render(org.eclipse.draw3d.RenderContext)
		 */
		public void render(RenderContext i_renderContext) {
			Position3D temp = Draw3DCache.getPosition3D();
			try {
				m_figure.getPosition3D().getAbsolute(temp);
				temp.setSize3D(IVector3f.UNITVEC3f);

				Graphics3D g3d = i_renderContext.getGraphics3D();
				g3d.glPushMatrix();
				try {
					ICamera camera = i_renderContext.getScene().getCamera();
					ILodHelper lodHelper = new CameraLodHelper(camera);

					g3d.glDisable(Graphics3DDraw.GL_CULL_FACE);
					g3d.setPosition(temp);
					m_image.render(g3d, lodHelper);
				} finally {
					g3d.glPopMatrix();
					g3d.glEnable(Graphics3DDraw.GL_CULL_FACE);
				}
			} finally {
				Draw3DCache.returnPosition3D(temp);
			}
		}

		public void setImage(RenderImage i_image) {

			m_image = i_image;
		}
	}

	/**
	 * Logger for this class
	 */
	// @SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(Figure3DHelper.class
		.getName());

	/**
	 * Converts 2D bounds to 3D bounds.
	 * 
	 * @todo use normal vector of 3D ancestor for 3D bounds,
	 * @todo evaluate scale factor when converting the bounds
	 * @param i_reference a reference figure for the Z position
	 * @param i_rect the 2D bounds
	 * @return the 3D bounds
	 */
	public static IBoundingBox convertBoundsToBounds3D(IFigure i_reference,
		Rectangle i_rect) {

		return convertBoundsToBounds3D(i_reference, i_rect, 0);
	}

	/**
	 * Converts 2D bounds to 3D bounds.
	 * 
	 * @todo use normal vector of 3D ancestor for 3D bounds,
	 * @todo evaluate scale factor when converting the bounds
	 * @param i_reference a reference figure for the Z position
	 * @param i_rect the 2D bounds
	 * @param i_z the Z size of the returned 3D bounds
	 * @return the 3D bounds
	 */
	public static IBoundingBox convertBoundsToBounds3D(IFigure i_reference,
		Rectangle i_rect, float i_z) {

		Vector3f origin = Draw3DCache.getVector3f();
		try {
			IFigure3D host = getAncestor3D(i_reference);
			ISurface surface = host.getSurface();

			surface.getWorldLocation(i_rect.getTopLeft(), origin);

			BoundingBox bounds3D = new BoundingBoxImpl();
			bounds3D.setLocation(origin.getX(), origin.getY(), origin.getZ());
			bounds3D.setSize(i_rect.width, i_rect.height, i_z);

			return bounds3D;
		} finally {
			Draw3DCache.returnVector3f(origin);
		}
	}

	/**
	 * Returns this figure or an 3D ancector if this figure. 2D Connections may
	 * return the 3D ancestor of their source.
	 * 
	 * @param i_figure the figure whose 3D ancestor should be returned
	 * @return the 3D ancestor of the given figure or <code>null</code> if the
	 *         given figure does not have a 3D ancestor
	 * @todo document return value if no 3D ancestor is found (null?)
	 */
	public static IFigure3D getAncestor3D(IFigure i_figure) {

		IFigure current = i_figure;
		while (current != null && !(current instanceof IFigure3D)) {
			if (current instanceof Connection) {
				Connection conn = (Connection) current;
				return getAncestor3D(conn.getSourceAnchor().getOwner());
			}
			current = current.getParent();
		}

		return (IFigure3D) current;
	}

	/**
	 * Returns the center of a figure (2D or 3D) in world coordinates.
	 * 
	 * @param i_figure the figure whose center should be determined
	 * @param io_result the result vector, if <code>null</code> a new vector
	 *            will be created
	 * @return the center of the given figure in world coordinates
	 * @todo why is this static? why not use an instance method here?
	 */
	public static IVector3f getCenter3D(IFigure i_figure, Vector3f io_result) {

		if (i_figure instanceof IFigure3D) {
			IFigure3D figure3D = (IFigure3D) i_figure;
			return figure3D.getBounds3D().getCenter(io_result);
		}

		if (i_figure instanceof Connection) {
			Connection conn = (Connection) i_figure;
			Point midPoint = conn.getPoints().getMidpoint();

			IFigure3D host = getAncestor3D(i_figure);
			ISurface surface = host.getSurface();

			return surface.getWorldLocation(midPoint, io_result);
		}

		Rectangle rect = i_figure.getBounds();
		Point center = rect.getCenter();

		IFigure3D host = getAncestor3D(i_figure);
		ISurface surface = host.getSurface();

		return surface.getWorldLocation(center, io_result);
	}

	/**
	 * Returns the 2D surface location of a 3D point relative to the given 3D
	 * host of the given reference figure.
	 * 
	 * @param i_figure the reference figure
	 * @param i_location the 3D location in world coordinates
	 * @return the 2D surface location
	 * @throws NullPointerException if any of the given arguments is
	 *             <code>null</code>
	 * @throws IllegalArgumentException if the given figure does not have a 3D
	 *             host
	 */
	public final static Point getLocation(final IFigure i_figure,
		final IVector3f i_location) {

		if (i_figure == null)
			throw new NullPointerException("figure must not be null");

		if (i_location == null)
			throw new NullPointerException("location must not be null");

		IFigure3D host = getAncestor3D(i_figure);
		if (host == null)
			throw new IllegalArgumentException("no 3D host found for "
				+ i_figure);

		ISurface surface = host.getSurface();
		return surface.getSurfaceLocation2D(i_location, null);
	}

	/**
	 * Caches the 3D descendents of this figure.
	 */
	protected List<IFigure3D> m_decendants3DCache = new LinkedList<IFigure3D>();

	/**
	 * The figure's friend that is used to access certain protected and private
	 * properties and methods.
	 */
	protected final Figure3DFriend m_figuresFriend;

	private ImageRenderFragment m_fragment;

	// TODO: dispose render image when figure is deleted
	private RenderImage m_image;

	private boolean m_decendants3DCacheValid;

	/**
	 * Creates a new helper. The given friend provides access to the figure.
	 * 
	 * @param i_figuresFriend the figure's friend
	 * @throws NullPointerException if the given friend is <code>null</code>
	 */
	public Figure3DHelper(final Figure3DFriend i_figuresFriend) {

		if (i_figuresFriend == null)
			throw new NullPointerException("i_figuresFriend must not be null");

		m_figuresFriend = i_figuresFriend;
	}

	/**
	 * Configures the given graphics object with the figure's local foreground
	 * and background color and its local font, if any of those are not
	 * <code>null</code>. This method was extracted from
	 * {@link #paintChildren(Graphics)} to make that method easier to read and
	 * it should not be called from anywhere else.
	 * 
	 * @param i_graphics the graphics object to configure
	 */
	private void configureGraphics(Graphics i_graphics) {

		IFigure3D figure = m_figuresFriend.figure;

		Color foregroundColor = figure.getLocalForegroundColor();
		if (foregroundColor != null)
			i_graphics.setForegroundColor(foregroundColor);

		Color backgroundColor = figure.getLocalBackgroundColor();
		if (backgroundColor != null)
			i_graphics.setBackgroundColor(backgroundColor);

		Font font = m_figuresFriend.getLocalFont();
		if (font != null)
			i_graphics.setFont(font);
	}

	private void doGetDescendants3D(List<IFigure3D> o_list, IFigure i_fig) {
		@SuppressWarnings("unchecked")
		List<IFigure> children = i_fig.getChildren();
		for (IFigure child: children) {
			if (child instanceof IFigure3D)
				o_list.add((IFigure3D) child);
			else
				doGetDescendants3D(o_list, child);
		}
	}

	/**
	 * Paints 2D children and 2D connections on the surface of this 3D figure.
	 * 
	 * @param children2D the 2D children to be painted
	 * @param host the 3D ancestor (parent) of the children
	 * @param graphics the graphics object used for rendering
	 */
	private void doPaintChildrenAndConnections2D(IFigure3D host,
		Collection<IFigure> children2D, Graphics graphics) {
		graphics.pushState();
		try {
			doPaintChildren2D(host, children2D, graphics);

			ConnectionLayer connectionLayer = host.getConnectionLayer(null);
			// paint the connections
			if (connectionLayer != null) {
				connectionLayer.paint(graphics);
				graphics.restoreState();
			}
		} catch (Error er) {
			log.severe("Error painting 2d children: " + er);
		} finally {
			graphics.popState();
		}
	}

	/**
	 * Paints 2D children, this method is rather similar to
	 * {@link Figure#paintChildren(Graphics)}. However, it is still using the
	 * GEF 3.5 version's clipping strategy.
	 * 
	 * @param host the 3D ancestor (parent) of the children
	 * @param children2D
	 * @param graphics
	 */
	protected void doPaintChildren2D(IFigure3D host,
		Collection<IFigure> children2D, Graphics graphics) {

		for (IFigure child : children2D) {
			if (child.isVisible()) {
				// determine clipping areas for child
				Rectangle clipping = child.getBounds();

				// child may now paint inside the clipping areas
				if (clipping.intersects(graphics.getClip(Rectangle.SINGLETON))) {
					graphics.clipRect(clipping);
					child.paint(graphics);
					graphics.restoreState();
				}

			}
		}
	}

	/**
	 * Finds the figure at the given surface coordinates, while excluding
	 * figures in the given tree search structure. The search is delegated to
	 * the surface of this figure, if any.
	 * 
	 * @param i_sx the surface X coordinate
	 * @param i_sy the surface Y coordinate
	 * @param i_search the tree search structure
	 * @return the figure at the given coordinates or <code>null</code> if there
	 *         is no figure at the given coordinates
	 */
	public IFigure findFigureAt(int i_sx, int i_sy, TreeSearch i_search) {

		IFigure3D figure = m_figuresFriend.figure;
		ISurface surface = figure.getSurface();

		if (surface != null)
			return surface.findFigureAt(i_sx, i_sy, i_search);

		if (i_search == null
			|| (!i_search.prune(figure) && i_search.accept(figure)))
			return figure;

		return null;
	}

	/**
	 * Returns the figure's 2D children.
	 * 
	 * @return a list containing the figure's 2D children
	 * @see IFigure2DHost3D#getChildren2D()
	 */
	public List<IFigure> getChildren2D() {

		List<?> allChildren = m_figuresFriend.figure.getChildren();
		if (allChildren.isEmpty())
			return Collections.emptyList();

		List<IFigure> children2D = new LinkedList<IFigure>();
		for (Object child : allChildren) {
			if (!(child instanceof Figure3D))
				children2D.add((IFigure) child);
		}

		return Collections.unmodifiableList(children2D);
	}

	/**
	 * Returns the figure's 3D children.
	 * 
	 * @return a list containing the figure's 3D children
	 * @see IFigure3D#getChildren3D()
	 */
	public List<IFigure3D> getChildren3D() {

		List<?> allChildren = m_figuresFriend.figure.getChildren();
		if (allChildren.isEmpty())
			return Collections.emptyList();

		List<IFigure3D> children3D = new LinkedList<IFigure3D>();
		for (Object child : allChildren) {
			if (child instanceof Figure3D)
				children3D.add((IFigure3D) child);
		}

		return Collections.unmodifiableList(children3D);
	}

	/**
	 * Returns the 3D descendents of the figure.
	 * 
	 * @return a list containing the 3D descendents
	 * @see org.eclipse.draw3d.IFigure3D#getSuccessor3D()
	 */
	public List<IFigure3D> getDescendants3D(boolean i_updateCache) {

		if (!m_decendants3DCacheValid && i_updateCache)
			doGetDescendants3D(m_decendants3DCache, m_figuresFriend.figure);

		return m_decendants3DCache;
	}

	/**
	 * Returns the color picker.
	 * 
	 * @return the color picker.
	 */
	public Picker getPicker() {

		UpdateManager updateManager = m_figuresFriend.figure.getUpdateManager();
		return ((PickingUpdateManager3D) updateManager).getPicker();
	}

	/**
	 * Invalidates the paraxial bounds of the figure and of all 3D figures in
	 * its subtree.
	 */
	public void invalidateParaxialBoundsTree() {

		m_figuresFriend.figure.invalidateParaxialBounds();
		List<IFigure3D> descendants3D = getDescendants3D(false);
		for (IFigure3D descendant3D : descendants3D)
			descendant3D.invalidateParaxialBounds();
	}

	/**
	 * Paints the figure's border.
	 * 
	 * @param i_graphics the graphics to paint on
	 * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics)
	 */
	public void paintBorder(Graphics i_graphics) {

		// nothing to do
	}

	/**
	 * Paints the figure's children.
	 * 
	 * @param i_graphics the graphics object to paint on
	 * @see org.eclipse.draw2d.Figure#paintChildren(org.eclipse.draw2d.Graphics)
	 */
	public void paintChildren(Graphics i_graphics) {

		paintChildren2D(i_graphics);
		paintChildren3D(i_graphics);
	}
	
	public void disposeImage() {
		if (m_image != null) {
			m_image.dispose();
			m_image = null;
		}
	}

	/**
	 * Paints the given 2D figures. This method was extracted from
	 * {@link #paintChildren(Graphics)} to make that method easier to read and
	 * it should not be called from anywhere else.
	 * <p>
	 * In order to have the 2D children of a 3D figure paint themselves on the
	 * 3D figure's texture, a different graphics object must be passed to the
	 * children than the graphics object that is passed to this method. This
	 * graphics object is obtained from the
	 * {@link #getTextureGraphics(Graphics)} method.
	 * </p>
	 * <p>
	 * However, the texture needs only to be painted if it actually needs
	 * repainting. This is only the case if the current render mode is
	 * {@link RenderMode#PAINT} and the 2D content is dirty.
	 * </p>
	 * <p>
	 * Note that not only the direct 2D children are painted, but connections as
	 * well.
	 * </p>
	 * 
	 * @param i_graphics the graphics object to paint on
	 */
	private void paintChildren2D(final Graphics i_graphics) {

		Collection<IFigure> children2D = getChildren2D();
		if (!children2D.isEmpty()) {
			IFigure3D figure = m_figuresFriend.figure;
			ISurface surface = figure.getSurface();

			RenderContext renderContext = figure.getRenderContext();
			Graphics3D g3d = renderContext.getGraphics3D();

			if (surface != null && surface.is2DHost()) {
				if ((renderContext.isRedraw2DContent() || m_figuresFriend
					.is2DContentDirty())) {

					if (m_image != null) {
						m_image.dispose();
						m_image = null;
					}

					Rectangle bounds = figure.getBounds();
					Graphics graphics =
						g3d.begin2DRendering(figure, figure.getPosition3D(),
							bounds.width, bounds.height);

					try {
						graphics.setFont(i_graphics.getFont());
						configureGraphics(graphics);
						doPaintChildrenAndConnections2D(figure, children2D,
							graphics);
					} finally {
						m_image = g3d.deactivateGraphics2D();
						m_image.initialize(g3d);

						if (m_fragment == null)
							m_fragment = new ImageRenderFragment(figure);

						m_fragment.setImage(m_image);
					}
				}

				if (m_fragment != null)
					renderContext.addRenderFragment(m_fragment);
			} else {
				Graphics graphics = i_graphics;
				graphics.setFont(i_graphics.getFont());
				configureGraphics(graphics);
				doPaintChildrenAndConnections2D(figure, children2D, i_graphics);
			}
		}
	}

	/**
	 * Paints the 3D children. The given graphics object is passed to the 3D
	 * figures. This method was extracted from {@link #paintChildren(Graphics)}
	 * to make that method easier to read and it should not be called from
	 * anywhere else.
	 * 
	 * @param i_graphics the graphics object to pass on
	 */
	private void paintChildren3D(Graphics i_graphics) {

		List<IFigure3D> children3D = getChildren3D();
		if (!children3D.isEmpty())
			for (IFigure3D child3D : children3D)
				child3D.paint(i_graphics);
	}

	/**
	 * Paint the figure itself.
	 * 
	 * @param i_graphics the graphics object to paint on
	 * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	public void paintFigure(Graphics i_graphics) {

		IFigure3D figure = m_figuresFriend.figure;
		RenderContext renderContext = figure.getRenderContext();

		figure.collectRenderFragments(renderContext);

		IScene scene = renderContext.getScene();
		if (scene != null && scene.isDebug())
			renderContext.addRenderFragment(new ParaxialBoundsFigureShape(
				figure));
	}

	/**
	 * Revalidates caches and other stuf, should be called from friend's
	 * revalidate method.
	 */
	public void revalidate() {

		m_decendants3DCache.clear();
		m_decendants3DCacheValid = false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return super.toString() + " with " + this.m_figuresFriend;
	}

	/**
	 * Unites the given paraxial bounding box with the paraxial bounding boxes
	 * of all 3D descendents of this figure.
	 * 
	 * @param i_figureBounds the paraxial bounding box of this figure
	 */
	public void unionWithChildParaxialBounds(ParaxialBoundingBox i_figureBounds) {

		ParaxialBoundingBox tmp = Draw3DCache.getParaxialBoundingBox();
		try {
			List<IFigure3D> descendants3D = getDescendants3D(true);
			for (IFigure3D descendant3D : descendants3D) {
				ParaxialBoundingBox descBounds =
					descendant3D.getParaxialBoundingBox(tmp);
				if (descBounds != null)
					i_figureBounds.union(descBounds);

			}
		} finally {
			Draw3DCache.returnParaxialBoundingBox(tmp);
		}
	}

}
