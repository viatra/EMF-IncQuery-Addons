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

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.EventDispatcher;
import org.eclipse.draw2d.EventDispatcher3D;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GraphicsSource;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.UpdateManager;
import org.eclipse.draw3d.camera.FirstPersonCamera;
import org.eclipse.draw3d.camera.ICamera;
import org.eclipse.draw3d.camera.ICameraListener;
import org.eclipse.draw3d.geometry.IBoundingBox;
import org.eclipse.draw3d.geometry.IHost3D;
import org.eclipse.draw3d.geometry.IPosition3D.PositionHint;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.NullPosition3D;
import org.eclipse.draw3d.geometry.ParaxialBoundingBox;
import org.eclipse.draw3d.geometry.ParaxialBoundingBoxImpl;
import org.eclipse.draw3d.geometry.Position3D;
import org.eclipse.draw3d.geometry.Position3DImpl;
import org.eclipse.draw3d.geometry.Transformable;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.graphics3d.DisplayListManager;
import org.eclipse.draw3d.graphics3d.Graphics3D;
import org.eclipse.draw3d.graphics3d.Graphics3DDraw;
import org.eclipse.draw3d.picking.Picker;
import org.eclipse.draw3d.util.ColorConverter;
import org.eclipse.draw3d.util.DebugPrimitives;
import org.eclipse.draw3d.util.Draw3DCache;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.opengl.GLCanvas;
import org.eclipse.swt.widgets.Canvas;

/**
 * Lightweight system for 3D scene. Its root figure renders the camera, which is
 * created and set by GraphicalViewer ({@link GraphicalViewer3DImpl}. Creates
 * RootFigure (this is not the figure of the root edit part!. GLCanvas is
 * initialized in {@link de.feu.gef3d.ui.parts.GraphicalViewer3DImpl}. The
 * default resolution defined here is 190.5. With a screen resolution of 75 dpi
 * (i.e. 190,5 dots per cm), the 3D objects can be defined in "real" metrics.
 * 
 * @todo LWD3DRootFigure
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 08.11.2007
 */
public class LightweightSystem3D extends LightweightSystem implements
		ICameraListener, DisposeListener, IScene {

	/**
	 * The 3D root figure class does not extend Figure3D for design reasons.
	 * 
	 * @author Jens von Pilgrim
	 * @version $Revision$
	 * @since 08.11.2007
	 */
	protected class RootFigure3D extends LightweightSystem.RootFigure implements
			IFigure3D {

		private static final String DL_AXES = "coordinate_axes";

		private final Figure3DHelper helper;

		private ParaxialBoundingBox m_paraxialBounds;

		private ISurface m_surface = new VoidSurface(this,
			LightweightSystem3D.this, 0.1f);

		// the position of the root is the universe.. the root is the universe
		private Position3DImpl universe = new NullPosition3D(this);

		
		/**
		 * Creates and initializes a 3D new root figure.
		 */
		RootFigure3D() {
			helper = new Figure3DHelper(new Figure3DFriend(this) {

				@SuppressWarnings("synthetic-access")
				@Override
				public Font getLocalFont() {
					return RootFigure3D.this.getLocalFont();
				}

				@Override
				public boolean is2DContentDirty() {

					return false;
				}
			});
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.Renderable#collectRenderFragments(org.eclipse.draw3d.RenderContext)
		 */
		public void collectRenderFragments(RenderContext i_renderContext) {
			// TODO implement method Renderable.collectRenderFragments

		}

		private void drawCoordinateAxes() {

			final RenderContext renderContext = getRenderContext();
			DisplayListManager displayListManager =
				renderContext.getGraphics3D().getDisplayListManager();

			if (!displayListManager.isDisplayList(DL_AXES))
				displayListManager.createDisplayList(DL_AXES, new Runnable() {

					public void run() {

						int length = 1000;
						int x = 0;
						int y = 0;
						int z = 0;

						Graphics3D g3d = getRenderContext().getGraphics3D();
						g3d.glLineWidth(1f);
						float c = 150 / 255f;
						float a = 0.7f;

						g3d.glBegin(Graphics3DDraw.GL_LINES);
						g3d.glColor4f(c, 0, 0, a);
						g3d.glVertex3f(x, y, z);
						g3d.glVertex3f(x + length, y, z);
						g3d.glColor4f(0, c, 0, a);
						g3d.glVertex3f(x, y, z);
						g3d.glVertex3f(x, y + length, z);
						g3d.glColor4f(0, 0, c, a);
						g3d.glVertex3f(x, y, z);
						g3d.glVertex3f(x, y, z + length);
						g3d.glEnd();

						g3d.glLineStipple(1, (short) (1 + 4 + 16 + 64));
						g3d.glEnable(Graphics3DDraw.GL_LINE_STIPPLE);

						g3d.glBegin(Graphics3DDraw.GL_LINES);
						g3d.glColor4f(c, 0, 0, a);
						g3d.glVertex3f(x, y, z);
						g3d.glVertex3f(x - length, y, z);
						g3d.glColor4f(0, c, 0, a);
						g3d.glVertex3f(x, y, z);
						g3d.glVertex3f(x, y - length, z);
						g3d.glColor4f(0, 0, c, a);
						g3d.glVertex3f(x, y, z);
						g3d.glVertex3f(x, y, z - length);
						g3d.glEnd();

						g3d.glDisable(Graphics3DDraw.GL_LINE_STIPPLE);
					}
				});

			displayListManager.executeDisplayList(DL_AXES);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw2d.Figure#findFigureAt(int, int,
		 *      org.eclipse.draw2d.TreeSearch)
		 * @see Figure3DHelper#findFigureAt(int, int, TreeSearch)
		 */
		@Override
		public IFigure findFigureAt(int i_x, int i_y, TreeSearch i_search) {

			return helper.findFigureAt(i_x, i_y, i_search);
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
		 * 
		 * @see org.eclipse.draw3d.IFigure3D#getAlpha()
		 */
		public int getAlpha() {

			return (byte) 255;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.IFigure3D#getAncestor3D()
		 */
		public IFigure3D getAncestor3D() {

			return null;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.IFigure3D#getBounds3D()
		 */
		public IBoundingBox getBounds3D() {

			return null;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw2d.Figure#getChildren()
		 */
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public List getChildren() {

			if (isDebug()) {
				List children = new ArrayList(super.getChildren());
				children.addAll(m_debugFigures);
				return children;
			} else {
				return super.getChildren();
			}
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
		public ConnectionLayer getConnectionLayer(
			ConnectionLayerFactory i_clfactory) {

			return null;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.IFigure3D#getDescendants3D()
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
		public float getDistance(IVector3f i_rayOrigin,
			IVector3f i_rayDirection, Map<Object, Object> i_context) {

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
					m_paraxialBounds = new ParaxialBoundingBoxImpl();
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

			return universe;
		}

		/**
		 * Returns null. {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.IFigure3D#getPreferredSize3D()
		 */
		public IVector3f getPreferredSize3D() {

			return null;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.IFigure3D#getRenderContext()
		 */
		public RenderContext getRenderContext() {

			return m_renderContext;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.IFigure3D#getScene()
		 */
		public IScene getScene() {

			return LightweightSystem3D.this;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.IFigure2DHost3D#getSurface()
		 */
		public ISurface getSurface() {

			return m_surface;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw2d.Figure#invalidate()
		 */
		@Override
		public void invalidate() {

			invalidateParaxialBoundsTree();
			super.invalidate();
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
		 * 
		 * @see org.eclipse.draw2d.Figure#paint(org.eclipse.draw2d.Graphics)
		 */
		@Override
		public void paint(Graphics i_graphics) {

			RenderContext renderContext = getRenderContext();
			renderContext.setScene(LightweightSystem3D.this);

			// ignore the incoming graphics object if it is not a dummy
			Graphics graphics = i_graphics;
			if (!(graphics instanceof DummyGraphics))
				graphics = new DummyGraphics();

			try {
				for (ISceneListener listener : m_listeners)
					listener.renderPassStarted(getRenderContext());

				// the root figure needs to paint itself first
				prepareRender(renderContext);
				paintBorder(graphics);
				paintClientArea(graphics);

				renderContext.renderFragments();
			} finally {
				for (ISceneListener listener : m_listeners)
					listener.renderPassFinished(getRenderContext());

				renderContext.clear();
			}
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics)
		 */
		@Override
		protected final void paintBorder(Graphics i_graphics) {

			helper.paintBorder(i_graphics);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw2d.Figure#paintChildren(org.eclipse.draw2d.Graphics)
		 */
		@Override
		protected final void paintChildren(Graphics i_graphics) {

			helper.paintChildren(i_graphics);
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
		public void positionChanged(EnumSet<PositionHint> i_hint,
			IVector3f i_delta) {

			if (log.isLoggable(Level.WARNING)) {
				log.warning("positionChanged on root figure, this must not happen"); //$NON-NLS-1$
			}

		}

		/**
		 * Prepares the render pass.
		 * 
		 * @param i_renderContext the current render context
		 */
		protected void prepareRender(RenderContext i_renderContext) {

			// if (log.isLoggable(Level.INFO)) {
			// log.info("render "+ this); //$NON-NLS-1$
			// }

			// m_canvas.setCurrent(); now in rendercontext.activate
			i_renderContext.activate();
			Graphics3D g3d = getRenderContext().getGraphics3D();

			g3d.glClearColor(m_clearColor[0], m_clearColor[1], m_clearColor[2],
				m_clearColor[3]);

			g3d.glClear(Graphics3DDraw.GL_COLOR_BUFFER_BIT
				| Graphics3DDraw.GL_DEPTH_BUFFER_BIT);

			m_camera.render(i_renderContext);

			if (m_drawAxes)
				drawCoordinateAxes();

			if (isDebug() && DebugPrimitives.hasInstance())
				DebugPrimitives.getInstance().render(i_renderContext);
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
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.IFigure3D#setAlpha(byte)
		 */
		public void setAlpha(int i_alpha) {

			// nothing to do
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw2d.Figure#setBounds(org.eclipse.draw2d.geometry.Rectangle)
		 */
		@Override
		public void setBounds(org.eclipse.draw2d.geometry.Rectangle i_rect) {

			super.setBounds(new org.eclipse.draw2d.geometry.Rectangle(0, 0,
				Integer.MAX_VALUE, Integer.MAX_VALUE));
		}

		/**
		 * Ignored. {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.IFigure3D#setPreferredSize3D(org.eclipse.draw3d.geometry.IVector3f)
		 */
		public void setPreferredSize3D(IVector3f i_preferredSize3D) {

			// nothing to do
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.IFigure3D#transformFromParent(org.eclipse.draw3d.geometry.Transformable)
		 */
		public void transformFromParent(Transformable i_transformable) {

			// nothing to do
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.IFigure3D#transformToAbsolute(org.eclipse.draw3d.geometry.Transformable)
		 */
		public void transformToAbsolute(Transformable i_transformable) {

			// nothing to do
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.IFigure3D#transformToParent(org.eclipse.draw3d.geometry.Transformable)
		 */
		public void transformToParent(Transformable i_transformable) {

			// nothing to do
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.IFigure3D#transformToRelative(org.eclipse.draw3d.geometry.Transformable)
		 */
		public void transformToRelative(Transformable i_transformable) {

			// nothing to do
		}

	} // end of inner class RootFigure3D

	/**
	 * Logger for this class
	 */
	// @SuppressWarnings("unused")
	static final Logger log = Logger
		.getLogger(LightweightSystem3D.class.getName());

	ICamera m_camera;

	/**
	 * cached field (since super field is private)
	 */
	protected GLCanvas m_canvas;

	final float[] m_clearColor = new float[] { 0.6f, 0.6f, 0.6f, 1 };

	private boolean m_debug = false;

	Set<IFigure3D> m_debugFigures = new HashSet<IFigure3D>();

	boolean m_drawAxes;

	List<ISceneListener> m_listeners;

	RenderContext m_renderContext;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.IScene#addSceneListener(org.eclipse.draw3d.ISceneListener)
	 */
	public void addSceneListener(ISceneListener i_listener) {

		if (i_listener != null && !m_listeners.contains(i_listener))
			m_listeners.add(i_listener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.ICameraListener#cameraChanged()
	 */
	public void cameraChanged() {

		// validation not necessary, only camera was moved
		// TODO change this in future versions for enabling distance aware
		// figures

		// if (log.isLoggable(Level.INFO)) {
		// log.info("Update after camera update"); //$NON-NLS-1$
		// }

		// UpdateManager updateManager = getUpdateManager();
		//
		// updateManager.addDirtyRegion(getRootFigure(), 0, 0, 1000, 10000);
		// updateManager.performUpdate();

		render(false);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.LightweightSystem#controlResized()
	 */
	@Override
	protected void controlResized() {

		super.controlResized();
		updateViewport();
	}

	/**
	 * {@inheritDoc} Here, a 3D root figure is created.
	 * 
	 * @see org.eclipse.draw2d.LightweightSystem#createRootFigure()
	 */
	@Override
	protected RootFigure createRootFigure() {

		// TODO configure root figure 3D
		RootFigure f = new RootFigure3D();
		f.addNotify();
		f.setOpaque(true);
		f.setLayoutManager(new StackLayout() {
			/**
			 * @see org.eclipse.draw2d.LayoutManager#layout(IFigure)
			 */
			@Override
			public void layout(IFigure figure) {
				org.eclipse.draw2d.geometry.Rectangle r = figure.getClientArea();
				@SuppressWarnings("unchecked")
				List<IFigure> children = figure.getChildren();
				for (IFigure child: children) {
					if (! m_debugFigures.contains(child))
						child.setBounds(r);
				}
			}
		});
		return f;
	}

	/**
	 * @return the camera
	 */
	public ICamera getCamera() {

		return m_camera;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.LightweightSystem#getEventDispatcher()
	 */
	@Override
	protected EventDispatcher getEventDispatcher() {

		/*
		 * EventDispatcher dispatcher = super.getEventDispatcher(); if
		 * (!(dispatcher instanceof EventDispatcher3D)) { dispatcher = new
		 * EventDispatcher3D(dispatcher, this);
		 * dispatcher.setRoot(getRootFigure()); setEventDispatcher(dispatcher);
		 * } return dispatcher;
		 */

		return super.getEventDispatcher();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.IScene#getPicker()
	 */
	public Picker getPicker() {

		return getUpdateManager3D().getPicker();
	}

	/**
	 * Returns the render context
	 * 
	 * @return the render context
	 */
	public RenderContext getRenderContext() {

		return m_renderContext;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.IScene#getUpdateManager3D()
	 */
	public PickingUpdateManager3D getUpdateManager3D() {

		return (PickingUpdateManager3D) getUpdateManager();
	}

	/**
	 * {@inheritDoc} Creates a 3D update manager here, in super class, a default
	 * update manager is created on initialization.
	 * 
	 * @see org.eclipse.draw2d.LightweightSystem#init()
	 */
	@Override
	protected void init() {

		m_listeners = new ArrayList<ISceneListener>();
		m_renderContext = new RenderContext();

		setUpdateManager(new PickingUpdateManager3D(this));
		setCamera(new FirstPersonCamera());

		super.init();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.IScene#isDebug()
	 */
	public boolean isDebug() {

		return m_debug;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.IScene#removeSceneListener(org.eclipse.draw3d.ISceneListener)
	 */
	public void removeSceneListener(ISceneListener i_listener) {

		if (i_listener != null && m_listeners.contains(i_listener))
			m_listeners.remove(i_listener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.IScene#render(boolean)
	 */
	public void render(boolean i_redraw2d) {

		if (i_redraw2d)
			m_renderContext.setRedraw2DContent();

		getUpdateManager().addInvalidFigure(getRootFigure());
		getUpdateManager().performUpdate();
	}

	/**
	 * Sets the background color of the lightweight system.
	 * 
	 * @param i_backgroundColor the background color
	 */
	public void setBackgroundColor(Color i_backgroundColor) {

		ColorConverter.toFloatArray(i_backgroundColor, 1, m_clearColor);
	}

	/**
	 * Sets the camera of this lightweight system. If the current camera is the
	 * same as the given camera, the given camera is ignored.
	 * 
	 * @param i_camera the camera to set
	 */
	public void setCamera(ICamera i_camera) {

		if (i_camera != m_camera) {
			if (m_camera != null)
				m_camera.transferListeners(i_camera);
			else
				i_camera.addCameraListener(this);

			for (ISceneListener listener : m_listeners)
				listener.cameraChanged(m_camera, i_camera);

			m_camera = i_camera;
			updateViewport();
		}
	}

	/**
	 * {@inheritDoc} Keep a copy of the control here since super class defines
	 * the member private
	 * 
	 * @see org.eclipse.draw2d.LightweightSystem#setControl(org.eclipse.swt.widgets.Canvas)
	 */
	@Override
	public void setControl(Canvas i_canvas) {

		if (!(i_canvas instanceof GLCanvas))
			throw new IllegalArgumentException(
				"Control of LWS3D must be a GLCanvas, was " + i_canvas);

		GLCanvas glCanvas = (GLCanvas) i_canvas;

		m_renderContext.setCanvas(glCanvas);

		DeferredUpdateManager3D updateManager = getUpdateManager3D();
		updateManager.setCanvas(glCanvas);

		m_canvas = glCanvas;
		super.setControl(i_canvas);

		updateManager.setGraphicsSource(new GraphicsSource() {

			Graphics graphics = new DummyGraphics();

			public void flushGraphics(
				org.eclipse.draw2d.geometry.Rectangle i_region) {

				// nothing to do
			}

			public Graphics getGraphics(
				org.eclipse.draw2d.geometry.Rectangle i_region) {

				return graphics;
			}
		});
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.IScene#setDebug(boolean)
	 */
	public void setDebug(boolean i_debug) {

		m_debug = i_debug;
	}

	/**
	 * Specifies whether coordinate axes should be drawn.
	 * 
	 * @param i_drawAxes <code>true</code> if coordinate axes should be drawn or
	 *            <code>false</code> otherwise
	 */
	public void setDrawAxes(boolean i_drawAxes) {

		m_drawAxes = i_drawAxes;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.LightweightSystem#setEventDispatcher(org.eclipse.draw2d.EventDispatcher)
	 */
	@Override
	public void setEventDispatcher(EventDispatcher i_dispatcher) {

		EventDispatcher dispatcher = i_dispatcher;
		if (!(dispatcher instanceof EventDispatcher3D))
			dispatcher = new EventDispatcher3D(dispatcher, this);

		super.setEventDispatcher(dispatcher);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.IScene#setFontAntialias(org.eclipse.draw3d.IScene.FontAntialias)
	 */
	public void setFontAntialias(FontAntialias i_antialias) {

		switch (i_antialias) {
		case ON:
			m_renderContext.getGraphics3D().setProperty(
				Graphics3D.PROP_FONT_AA, Boolean.toString(true));
			break;
		case OFF:
			m_renderContext.getGraphics3D().setProperty(
				Graphics3D.PROP_FONT_AA, Boolean.toString(false));
			break;
		default:
			m_renderContext.getGraphics3D().setProperty(
				Graphics3D.PROP_FONT_AA, null);
			break;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.LightweightSystem#setUpdateManager(org.eclipse.draw2d.UpdateManager)
	 */
	@Override
	public void setUpdateManager(UpdateManager i_um) {

		if (getUpdateManager() instanceof ISceneListener) {
			ISceneListener listener = (ISceneListener) getUpdateManager();
			removeSceneListener(listener);
		}

		super.setUpdateManager(i_um);

		if (i_um instanceof ISceneListener) {
			ISceneListener listener = (ISceneListener) i_um;
			addSceneListener(listener);
		}
	}

	private void updateViewport() {

		if (m_canvas == null || m_camera == null)
			return;

		Rectangle bounds = m_canvas.getBounds();
		m_camera.setViewport(bounds.x, bounds.y, bounds.width, bounds.height);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.events.DisposeListener#widgetDisposed(org.eclipse.swt.events.DisposeEvent)
	 */
	public void widgetDisposed(DisposeEvent i_e) {

		getRenderContext().dispose();

	}

	/**
	 * @param i_fig
	 */
	public void addDebugFigure(IFigure3D i_fig) {
		m_debugFigures.add(i_fig);
		i_fig.setParent(this.getRootFigure());
	}

	public void removeDebugFigure(IFigure3D i_fig) {
		m_debugFigures.remove(i_fig);
	}

}
