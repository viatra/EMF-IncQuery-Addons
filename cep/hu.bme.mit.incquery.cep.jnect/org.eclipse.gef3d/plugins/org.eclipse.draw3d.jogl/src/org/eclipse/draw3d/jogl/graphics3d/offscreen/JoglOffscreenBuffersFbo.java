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
import java.nio.IntBuffer;
import java.util.logging.Logger;

import javax.media.opengl.GL;

import org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBufferConfig;
import org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBuffers;
import org.eclipse.draw3d.util.Draw3DCache;

/**
 * Manages a framebuffer object for use as offscreen buffers.
 * 
 * @author Madhu Samuel
 * @version $Revision$
 * @since 24.08.2009
 */
public class JoglOffscreenBuffersFbo implements Graphics3DOffscreenBuffers {

	@SuppressWarnings("unused")
	private static final Logger log =
		Logger.getLogger(JoglOffscreenBuffersFbo.class.getName());

	/**
	 * The buffers uses the settings from this buffer configuration.
	 */
	private Graphics3DOffscreenBufferConfig m_bufferConfig;

	private int m_glColorBuffer;

	private int m_glDepthBuffer;

	private int m_glFrameBuffer;

	/**
	 * The buffer's height.
	 */
	private int m_height;

	private boolean m_initBuffers;

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
	public JoglOffscreenBuffersFbo(int i_height, int i_width,
			Graphics3DOffscreenBufferConfig i_bufferConfig, GL gl) {
		
		if (gl == null)
			throw new NullPointerException("gl must not be null");
		this.gl = gl;

		this.m_height = i_height;
		this.m_width = i_width;
		this.m_bufferConfig = i_bufferConfig;
	}

	private void createFbo() {

		IntBuffer buffer = Draw3DCache.getIntBuffer(1);
		try {
			//FIXME gl.glGenFramebuffersEXT(buffer); modified as below - madhu
			gl.glGenFramebuffersEXT(1,buffer);
			m_glFrameBuffer = buffer.get(0);
		} finally {
			Draw3DCache.returnIntBuffer(buffer);
		}
	}

	private void createRenderBuffers() {

		Graphics3DOffscreenBufferConfig bufferConfig = m_bufferConfig;

		int numBuffers = 0;
		if (bufferConfig.isEnabled(GL.GL_COLOR_BUFFER_BIT))
			numBuffers++;
		if (bufferConfig.isEnabled(GL.GL_DEPTH_BUFFER_BIT))
			numBuffers++;
		if (numBuffers == 0)
			return;

		IntBuffer buffer = Draw3DCache.getIntBuffer(numBuffers - 1);
		try {
			//gl.glGenRenderbuffersEXT(buffer); modified as below - madhu
			gl.glGenRenderbuffersEXT(1,buffer);

			int width = m_width;
			int height = m_height;

			if (bufferConfig.isEnabled(GL.GL_COLOR_BUFFER_BIT)) {
				m_glColorBuffer = buffer.get(0);
				gl.glBindRenderbufferEXT(
					GL.GL_RENDERBUFFER_EXT, m_glColorBuffer);

				int format = bufferConfig.getColorPixelFormat();
				gl.glRenderbufferStorageEXT(
					GL.GL_RENDERBUFFER_EXT, format, width,
					height);

				gl.glFramebufferRenderbufferEXT(
					GL.GL_FRAMEBUFFER_EXT,
					GL.GL_COLOR_ATTACHMENT0_EXT,
					GL.GL_RENDERBUFFER_EXT, m_glColorBuffer);
			}

			if (bufferConfig.isEnabled(GL.GL_DEPTH_BUFFER_BIT)) {
				m_glDepthBuffer = buffer.get(numBuffers - 1);

				gl.glBindRenderbufferEXT(
						GL.GL_RENDERBUFFER_EXT, m_glDepthBuffer);
				gl.glRenderbufferStorageEXT(
						GL.GL_RENDERBUFFER_EXT,
						GL.GL_DEPTH_COMPONENT, width, height);

				gl.glFramebufferRenderbufferEXT(
						GL.GL_FRAMEBUFFER_EXT,
						GL.GL_DEPTH_ATTACHMENT_EXT,
						GL.GL_RENDERBUFFER_EXT, m_glDepthBuffer);
			}
		} finally {
			Draw3DCache.returnIntBuffer(buffer);
		}
	}

	private void deleteFbo() {

		if (gl.glIsFramebufferEXT(m_glFrameBuffer)) {
			IntBuffer buffer = Draw3DCache.getIntBuffer(1);
			try {
				buffer.rewind();

				buffer.put(m_glFrameBuffer);
				//FIXME glDeleteFramebuffersEXT(buffer); modified as below - madhu
				gl.glDeleteFramebuffersEXT(1,buffer);
			} finally {
				Draw3DCache.returnIntBuffer(buffer);
			}
		}
	}

	private void deleteRenderBuffers() {

		int numBuffers = 0;
		if (gl.glIsRenderbufferEXT(m_glColorBuffer))
			numBuffers++;
		if (gl.glIsRenderbufferEXT(m_glColorBuffer))
			numBuffers++;
		if (numBuffers == 0)
			return;

		IntBuffer buffer = Draw3DCache.getIntBuffer(numBuffers);
		try {
			buffer.rewind();

			if (gl.glIsRenderbufferEXT(m_glColorBuffer))
				buffer.put(m_glColorBuffer);

			if (gl.glIsRenderbufferEXT(m_glDepthBuffer))
				buffer.put(m_glDepthBuffer);
			
			//FIXME glDeleteFramebuffersEXT(buffer); modified as below - madhu
			gl.glDeleteRenderbuffersEXT(1,buffer);
		} finally {
			Draw3DCache.returnIntBuffer(buffer);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBuffers#dispose()
	 */
	public void dispose() {

		deleteRenderBuffers();
		deleteFbo();
	}

	private String getStatus(int i_status) {

		switch (i_status) {
		case GL.GL_FRAMEBUFFER_COMPLETE_EXT:
			return "GL_FRAMEBUFFER_COMPLETE_EXT";
		case GL.GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT_EXT:
			return "GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT_EXT";
		case GL.GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT_EXT:
			return "GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT_EXT";
		case GL.GL_FRAMEBUFFER_INCOMPLETE_FORMATS_EXT:
			return "GL_FRAMEBUFFER_INCOMPLETE_FORMATS_EXT";
		case GL.GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER_EXT:
			return "GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER_EXT";
		case GL.GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER_EXT:
			return "GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER_EXT";
		default:
			return "unknown status code " + i_status;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBuffers#init(int)
	 */
	public void init() {

		createFbo();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBuffers#initBuffers()
	 */
	public void initBuffers() {

		// initialize lazily in #preRender()
		m_initBuffers = true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBuffers#isBackBuffer()
	 */
	public boolean isBackBuffer() {
		return false; // not an instanceof LwjglOffscreenBackBuffers;

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

			i_colorBuffer.rewind();
			gl.glReadPixels(0, 0, width, height, format, type, i_colorBuffer);
		}

		if (bufferConfig.isEnabled(GL.GL_DEPTH_BUFFER_BIT)) {
			int type = bufferConfig.getDepthDataType();

			i_depthBuffer.rewind();
			gl.glReadPixels(0, 0, width, height, GL.GL_DEPTH_COMPONENT,
				type, i_depthBuffer);
		}

		gl.glBindFramebufferEXT(
				GL.GL_FRAMEBUFFER_EXT, 0);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBuffers#preRender()
	 */
	public void preRender() {

		// must be initialized after framebuffer object is bound
		if (m_initBuffers) {
			deleteRenderBuffers();
			deleteFbo();

			createFbo();
			gl.glBindFramebufferEXT(
				GL.GL_FRAMEBUFFER_EXT, m_glFrameBuffer);

			createRenderBuffers();

			int status =
				gl.glCheckFramebufferStatusEXT(GL.GL_FRAMEBUFFER_EXT);
			if (status != GL.GL_FRAMEBUFFER_COMPLETE_EXT)
				throw new RuntimeException(getStatus(status));

			m_initBuffers = false;
		} else
			gl.glBindFramebufferEXT(
					GL.GL_FRAMEBUFFER_EXT, m_glFrameBuffer);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBuffers#setBufferConfig(org.eclipse.draw3d.graphics3d.lwjgl.LwjglOffscreenBufferConfig)
	 */
	public void setBufferConfig(Graphics3DOffscreenBufferConfig i_bufferConfig) {
		m_bufferConfig = i_bufferConfig;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBuffers#setHeight(int)
	 */
	public void setHeight(int i_height) {
		m_height = i_height;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBuffers#setWidth(int)
	 */
	public void setWidth(int i_width) {
		m_width = i_width;
	}
}
