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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.eclipse.draw3d.RenderFragment.RenderType;
import org.eclipse.draw3d.graphics3d.DisplayListManager;
import org.eclipse.draw3d.graphics3d.Graphics3D;
import org.eclipse.draw3d.graphics3d.Graphics3DDraw;
import org.eclipse.swt.opengl.GLCanvas;

/**
 * The render context collects fragments to be rendered during a render pass,
 * sorts them appropriately (by render type and distance from the camera) and
 * renders them after the actual painting of the figures is finished. It also
 * functions as a container for some objects that figures may need when they
 * render themselves, for example the {@link Graphics3D} instance, the
 * {@link DisplayListManager} and the {@link IScene}.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 23.01.2008
 */
public class RenderContext {

	/**
	 * Logger for this class
	 */
	@SuppressWarnings("unused")
	private static final Logger log =
		Logger.getLogger(RenderContext.class.getName());

	private GLCanvas m_Canvas;

	private Graphics3D m_g3d = null;

	private boolean m_redraw2DContent;

	private Map<RenderType, List<RenderFragment>> m_renderFragments =
		new HashMap<RenderType, List<RenderFragment>>();

	private IScene m_scene;

	/**
	 * 
	 */
	public void activate() {
		m_Canvas.setCurrent();
	}

	/**
	 * Adds the given render fragment to be rendered later.
	 * 
	 * @param i_fragment the fragment to add
	 * @throws NullPointerException if the given fragment is <code>null</code>
	 */
	public void addRenderFragment(RenderFragment i_fragment) {

		if (i_fragment == null)
			throw new NullPointerException("i_fragment must not be null");

		RenderType renderType = i_fragment.getRenderType();
		if (renderType == RenderType.IGNORE)
			return;

		List<RenderFragment> list = m_renderFragments.get(renderType);
		if (list == null) {
			list = new ArrayList<RenderFragment>();
			m_renderFragments.put(renderType, list);
		}

		list.add(i_fragment);
	}

	/**
	 * Clears the render fragments and sets the scene to <code>null</code>.
	 */
	public void clear() {

		m_renderFragments.clear();
		// m_displayListManagers.clear();
		m_scene = null;
		m_redraw2DContent = false;
	}

	/**
	 * Disposes all {@link DisplayListManager}, clears display manager map, and
	 * disposes the current {@link Graphics3D} instance. This method is called
	 * by the {@link LightweightSystem3D} when the widget is disposed.
	 */
	public synchronized void dispose() {

		m_g3d.dispose();
	}

	/**
	 * Returns the Graphics3D instance which shall be used for rendering in this
	 * context.
	 * 
	 * @return the graphics3D instance
	 */
	public Graphics3D getGraphics3D() {
		return this.m_g3d;
	}

	/**
	 * Returns the scene
	 * 
	 * @return the scene
	 */
	public IScene getScene() {
		return m_scene;
	}

	/**
	 * Indicates whether 2D content should be redrawn.
	 * 
	 * @return <code>true</code> if 2D content should be redrawn and
	 *         <code>false</code> otherwise
	 */
	public boolean isRedraw2DContent() {

		return m_redraw2DContent;
	}

	/**
	 * Renders all render fragments.
	 */
	public void renderFragments() {

		Graphics3D g3d = getGraphics3D();

		g3d.glEnable(Graphics3DDraw.GL_DEPTH_TEST);
		renderFragments(RenderType.OPAQUE);
		renderFragments(RenderType.TRANSPARENT);

		g3d.glDisable(Graphics3DDraw.GL_DEPTH_TEST);
		try {
			renderFragments(RenderType.SUPERIMPOSED);
		} finally {
			g3d.glEnable(Graphics3DDraw.GL_DEPTH_TEST);
		}
	}

	private void renderFragments(RenderType i_type) {

		List<RenderFragment> fragments = m_renderFragments.get(i_type);
		if (fragments != null) {
			i_type.orderFragments(this, fragments);
			for (RenderFragment fragment : fragments)
				fragment.render(this);
		}
	}

	/**
	 * @param i_canvas
	 */
	public void setCanvas(GLCanvas i_canvas) {
		m_Canvas = i_canvas;

	}

	/**
	 * Sets another Graphics3D instance for further rendering within this
	 * context. The previous GRaphics3D instance has to be saved externally if
	 * re-usage is planned, the render context will keep any reference to it.
	 * 
	 * @param i_g3d The new Graphics3D instance to set.
	 */
	public void setGraphics3D(Graphics3D i_g3d) {
		this.m_g3d = i_g3d;
	}

	/**
	 * Calling this method forces all 2D content to be redrawn during the next
	 * render pass.
	 */
	public void setRedraw2DContent() {

		m_redraw2DContent = true;
	}

	/**
	 * Sets the scene
	 * 
	 * @param i_scene the scene
	 */
	public void setScene(IScene i_scene) {

		m_scene = i_scene;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append("RenderContext[render fragments: ");
		builder.append(m_renderFragments.size());
		builder.append("]");

		return builder.toString();
	}
}
