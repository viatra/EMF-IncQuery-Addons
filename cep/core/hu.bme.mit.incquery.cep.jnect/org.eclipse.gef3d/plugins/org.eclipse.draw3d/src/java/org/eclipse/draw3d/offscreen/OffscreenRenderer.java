/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.offscreen;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import org.eclipse.draw3d.graphics3d.Graphics3D;
import org.eclipse.draw3d.graphics3d.Graphics3DDraw;
import org.eclipse.draw3d.graphics3d.Graphics3DMetaData;
import org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBufferConfig;
import org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBuffers;
import org.eclipse.draw3d.util.BufferUtils;

/**
 * An offscreen renderer that can be used to render into offscreen buffers. An
 * appropriate offscreen rendering method is automatically chosen.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 27.04.2008
 */
public class OffscreenRenderer {

	private enum State {
		/**
		 * Indicates that the renderer has been disposed.
		 */
		DISPOSED,
		/**
		 * Indicates that the renderer has been initialized, but the buffers are
		 * invalid.
		 */
		INVALID,
		/**
		 * Indicates that the renderer has been initialized, the buffers are
		 * valid and an offscreen image has been rendered.
		 */
		RENDERED,
		/**
		 * Inidicate that the renderer has not been initialized.
		 */
		UNINITIALZED,
		/**
		 * Indicates that the renderer has been initialized and the buffers are
		 * valid, but nothing has been rendered.
		 */
		VALID
	}

	private Graphics3DOffscreenBufferConfig m_bufferConfig;

	private ByteBuffer m_colorBuffer;

	private FloatBuffer m_depthBuffer;

	private int m_height;

	private Graphics3DOffscreenBuffers m_offscreenBuffers;

	private State m_state = State.UNINITIALZED;

	private int m_width;

	/**
	 * Creates a new offscreen renderer with the given configuration.
	 * 
	 * @param i_bufferConfig the buffer configuration for this renderer
	 * @throws NullPointerException if the given buffer configuration is
	 *             <code>null</code>
	 * @throws RuntimeException if no offscreen buffers are available
	 */
	public OffscreenRenderer(Graphics3DOffscreenBufferConfig i_bufferConfig) {

		setBufferConfig(i_bufferConfig);
	}

	private void checkState(boolean i_valid, State... i_states) {

		for (State state : i_states) {
			if (!i_valid && m_state == state)
				throw new IllegalStateException("offscreen renderer is "
						+ m_state);
			if (i_valid && m_state != state)
				throw new IllegalStateException("offscreen renderer must be "
						+ m_state);
		}
	}

	/**
	 * Disposes this offscreen renderer.
	 * 
	 * @throws IllegalStateException if this renderer is already disposed
	 */
	public void dispose() {

		checkState(false, State.DISPOSED);

		m_colorBuffer = null;
		m_depthBuffer = null;
		m_offscreenBuffers.dispose();

		m_state = State.DISPOSED;
	}

	/**
	 * Returns the buffer configuration of this offscreen renderer.
	 * 
	 * @return the buffer configuration
	 */
	public Graphics3DOffscreenBufferConfig getBufferConfig() {

		return m_bufferConfig;
	}

	/**
	 * Returns the color buffer.
	 * 
	 * @return the color buffer
	 * @throws IllegalStateException if the color buffer does not contain an
	 *             image or if the color buffer is disabled
	 */
	public ByteBuffer getColorBuffer() {

		checkState(true, State.RENDERED);

		if (!m_bufferConfig.isEnabled(Graphics3DDraw.GL_COLOR_BUFFER_BIT))
			throw new IllegalStateException("color buffer is disabled");

		return m_colorBuffer;
	}

	/**
	 * Returns the depth buffer.
	 * 
	 * @return the depth buffer
	 * @throws IllegalStateException if the depth buffer does not contain an
	 *             image or if the depth buffer is disabled
	 */
	public FloatBuffer getDepthBuffer() {

		checkState(true, State.RENDERED);

		if (!m_bufferConfig.isEnabled(Graphics3DDraw.GL_DEPTH_BUFFER_BIT))
			throw new IllegalStateException("depth buffer is disabled");

		return m_depthBuffer;
	}

	/**
	 * Returns the height of the offscreen image that is rendered by this
	 * renderer.
	 * 
	 * @return the offscreen image's height
	 * @throws IllegalStateException if this renderer is not initialized or
	 *             disposed
	 */
	public int getHeight() {

		checkState(false, State.UNINITIALZED, State.DISPOSED);
		return m_height;
	}

	/**
	 * Returns the height of the offscreen image that is rendered by this
	 * renderer.
	 * 
	 * @return the offscreen image's height
	 * @throws IllegalStateException if this renderer is not initialized or
	 *             disposed
	 */
	public int getWidth() {

		checkState(false, State.UNINITIALZED, State.DISPOSED);
		return m_width;
	}

	private void initBuffers() {

		m_colorBuffer = null;
		m_depthBuffer = null;

		int size = m_width * m_height;

		if (m_bufferConfig.isEnabled(Graphics3DDraw.GL_COLOR_BUFFER_BIT))
			m_colorBuffer = BufferUtils.createByteBuffer(size
					* m_bufferConfig.getColorBpp());

		if (m_bufferConfig.isEnabled(Graphics3DDraw.GL_DEPTH_BUFFER_BIT))
			m_depthBuffer = BufferUtils.createFloatBuffer(size);
	}

	/**
	 * Indicates whether the back buffer is used as the offscreen buffer. This
	 * can lead to the offscreen image being displayed on screen on some
	 * systems, so the programmer needs to make sure that the back buffer is
	 * re-rendered when rendering the offscreen image is done.
	 * 
	 * @return <code>true</code> if the back buffer is used or
	 *         <code>false</code> otherwise
	 * @throws IllegalStateException if this renderer is not initialized or
	 *             disposed
	 */
	public boolean isBackBufferEnabled() {

		checkState(false, State.UNINITIALZED, State.DISPOSED);

		return Graphics3DMetaData.isBackBuffer(m_offscreenBuffers);
	}

	/**
	 * Renders the offscreen image using the given rendering operation.
	 * 
	 * @param i_renderOperation performs the actual rendering
	 * @throws NullPointerException if the given render operation is
	 *             <code>null</code>
	 * @throws IllegalStateException if this renderer is not initialized or
	 *             disposed
	 */
	public void render(Runnable i_renderOperation) {

		if (i_renderOperation == null)
			throw new NullPointerException("i_renderOperation must not be null");

		checkState(false, State.UNINITIALZED, State.DISPOSED);

		if (m_state == State.INVALID) {
			initBuffers();
			m_offscreenBuffers.initBuffers();

			m_state = State.VALID;
		}

		m_offscreenBuffers.preRender();
		i_renderOperation.run();
		m_offscreenBuffers.postRender(m_colorBuffer, m_depthBuffer);

		m_state = State.RENDERED;
	}

	/**
	 * Sets the given buffer configuration.
	 * 
	 * @param i_bufferConfig the buffer configuration
	 * @throws NullPointerException if the given buffer configuration is
	 *             <code>null</code>
	 * @throws RuntimeException if the offscreen buffers could not be created
	 */
	public void setBufferConfig(Graphics3DOffscreenBufferConfig i_bufferConfig) {

		checkState(false, State.DISPOSED);

		if (i_bufferConfig == null)
			throw new NullPointerException("i_bufferConfig must not be null");

		m_bufferConfig = i_bufferConfig;

		if (m_offscreenBuffers != null) {
			m_offscreenBuffers.dispose();
			m_offscreenBuffers = null;
		}

		Graphics3D g3d = i_bufferConfig.getGraphics3D();

		m_offscreenBuffers = g3d.getGraphics3DOffscreenBuffer(m_height,
				m_width, m_bufferConfig);

		m_offscreenBuffers.init();
		m_state = State.INVALID;
	}

	/**
	 * Sets the dimensions of the offscreen image that is rendered by this
	 * renderer.
	 * 
	 * @param i_width the offscreen image's width
	 * @param i_height the offscreen image's height
	 * @throws IllegalArgumentException if the given width or height is not
	 *             positive
	 * @throws IllegalStateException if this renderer is not initialized or
	 *             disposed
	 */
	public void setDimensions(int i_width, int i_height) {

		checkState(false, State.UNINITIALZED, State.DISPOSED);

		if (i_width < 1 || i_height < 1)
			throw new IllegalArgumentException(
					"width and height must be positive");

		if (i_width == m_width && i_height == m_height)
			return;

		m_width = i_width;
		m_height = i_height;

		if (m_offscreenBuffers != null) {
			m_offscreenBuffers.setHeight(i_height);
			m_offscreenBuffers.setWidth(i_width);
		}

		m_state = State.INVALID;
	}
}
