/*******************************************************************************
 * Copyright (c) 2009-2010 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 *    Madhu Samuel	 - Implementation
 ******************************************************************************/
package org.eclipse.draw3d.jogl.graphics3d.offscreen;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import javax.media.opengl.GL;

import org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBufferConfig;
import org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBuffers;

/**
 * Manages the back buffers for use as offscreen buffers.
 * 
 * @author Madhu Samuel
 * @version $Revision$
 * @since 24.08.2009
 */
public class JoglOffscreenBackBuffers implements
		Graphics3DOffscreenBuffers {

	/**
	 * The buffers uses the settings from this buffer configuration.
	 */
	private Graphics3DOffscreenBufferConfig m_bufferConfig;

	/**
	 * The buffer's height.
	 */
	private int m_height;

	/**
	 * The buffer's width.
	 */
	private int m_width;
	
	/**
	 * The GL instance
	 */
	private GL gl;

	/**
	 * Creates a new instance with the specified parameters.
	 * 
	 * @param i_height Create a buffer of this height.
	 * @param i_width Create a buffer of this width.
	 * @param i_bufferConfig The created buffer will use this buffer
	 *            configuration.
	 */
	public JoglOffscreenBackBuffers(int i_height, int i_width,
			Graphics3DOffscreenBufferConfig bufferConfig, GL gl) {
		
		if (gl == null)
			throw new NullPointerException("gl must not be null");
		this.gl = gl;

		this.m_height = i_height;
		this.m_width = i_width;
		this.m_bufferConfig = bufferConfig;
	}
	
	

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBuffers#isBackBuffer()
	 */
	public boolean isBackBuffer() {
		return true; //  instanceof LwjglOffscreenBackBuffers;
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBuffers#dispose()
	 */
	public void dispose() {
		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBuffers#init()
	 */
	public void init() {
		// nothing do to
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBuffers#initBuffers()
	 */
	public void initBuffers() {
		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBuffers#postRender(java.nio.ByteBuffer,
	 *      java.nio.FloatBuffer)
	 */
	public void postRender(ByteBuffer i_colorBuffer, FloatBuffer i_depthBuffer) {

		int width = m_width;
		int height = m_height;

		Graphics3DOffscreenBufferConfig bufferConfig = m_bufferConfig;

		if (bufferConfig.isEnabled(GL.GL_COLOR_BUFFER_BIT)) {
			int format = bufferConfig.getColorPixelFormat();
			int type = bufferConfig.getColorDataType();

			gl.glReadPixels(0, 0, width, height, format, type, i_colorBuffer);
		}

		if (bufferConfig.isEnabled(GL.GL_DEPTH_BUFFER_BIT)) {
			int type = bufferConfig.getDepthDataType();

			gl.glReadPixels(0, 0, width, height, GL.GL_DEPTH_COMPONENT,
					type, i_depthBuffer);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBuffers#preRender()
	 */
	public void preRender() {
		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBuffers#setHeight()
	 */
	public void setHeight(int i_height) {
		m_height = i_height;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBuffers#setWidth()
	 */
	public void setWidth(int i_width) {
		m_width = i_width;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBuffers#setBufferConfig(org.eclipse.draw3d.graphics3d.lwjgl.LwjglOffscreenBufferConfig)
	 */
	public void setBufferConfig(Graphics3DOffscreenBufferConfig i_bufferConfig) {
		m_bufferConfig = i_bufferConfig;
	}

}
