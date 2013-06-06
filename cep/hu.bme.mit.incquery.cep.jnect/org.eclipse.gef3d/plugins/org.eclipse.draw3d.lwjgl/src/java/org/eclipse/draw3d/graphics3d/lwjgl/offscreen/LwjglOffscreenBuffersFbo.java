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
package org.eclipse.draw3d.graphics3d.lwjgl.offscreen;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.logging.Logger;

import org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBufferConfig;
import org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBuffers;
import org.eclipse.draw3d.util.Draw3DCache;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;

/**
 * Manages a framebuffer object for use as offscreen buffers. This version
 * of {@link Graphics3DOffscreenBuffers} requires the FBO extension, i.e.
 * {@link ContextCapabilities#GL_EXT_framebuffer_object} must be provided
 * by the OpenGL driver.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 27.04.2008
 */
public class LwjglOffscreenBuffersFbo implements Graphics3DOffscreenBuffers {

	@SuppressWarnings("unused")
	private static final Logger log =
		Logger.getLogger(LwjglOffscreenBuffersFbo.class.getName());

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
	 * Creates a new instance with the specified parameters.
	 * 
	 * @param i_height Create a buffer of this height.
	 * @param i_width Create a buffer of this width.
	 * @param i_bufferConfig The created buffer will use this buffer
	 *            configuration.
	 */
	public LwjglOffscreenBuffersFbo(int i_height, int i_width,
			Graphics3DOffscreenBufferConfig i_bufferConfig) {

		this.m_height = i_height;
		this.m_width = i_width;
		this.m_bufferConfig = i_bufferConfig;
	}

	private void createFbo() {

		IntBuffer buffer = Draw3DCache.getIntBuffer(1);
		try {
			EXTFramebufferObject.glGenFramebuffersEXT(buffer);
			m_glFrameBuffer = buffer.get(0);
		} finally {
			Draw3DCache.returnIntBuffer(buffer);
		}
	}

	private void createRenderBuffers() {

		Graphics3DOffscreenBufferConfig bufferConfig = m_bufferConfig;

		int numBuffers = 0;
		if (bufferConfig.isEnabled(GL11.GL_COLOR_BUFFER_BIT))
			numBuffers++;
		if (bufferConfig.isEnabled(GL11.GL_DEPTH_BUFFER_BIT))
			numBuffers++;
		if (numBuffers == 0)
			return;

		IntBuffer buffer = Draw3DCache.getIntBuffer(numBuffers - 1);
		try {
			EXTFramebufferObject.glGenRenderbuffersEXT(buffer);

			int width = m_width;
			int height = m_height;

			if (bufferConfig.isEnabled(GL11.GL_COLOR_BUFFER_BIT)) {
				m_glColorBuffer = buffer.get(0);
				EXTFramebufferObject.glBindRenderbufferEXT(
					EXTFramebufferObject.GL_RENDERBUFFER_EXT, m_glColorBuffer);

				int format = bufferConfig.getColorPixelFormat();
				EXTFramebufferObject.glRenderbufferStorageEXT(
					EXTFramebufferObject.GL_RENDERBUFFER_EXT, format, width,
					height);

				EXTFramebufferObject.glFramebufferRenderbufferEXT(
					EXTFramebufferObject.GL_FRAMEBUFFER_EXT,
					EXTFramebufferObject.GL_COLOR_ATTACHMENT0_EXT,
					EXTFramebufferObject.GL_RENDERBUFFER_EXT, m_glColorBuffer);
			}

			if (bufferConfig.isEnabled(GL11.GL_DEPTH_BUFFER_BIT)) {
				m_glDepthBuffer = buffer.get(numBuffers - 1);

				EXTFramebufferObject.glBindRenderbufferEXT(
					EXTFramebufferObject.GL_RENDERBUFFER_EXT, m_glDepthBuffer);
				EXTFramebufferObject.glRenderbufferStorageEXT(
					EXTFramebufferObject.GL_RENDERBUFFER_EXT,
					GL11.GL_DEPTH_COMPONENT, width, height);

				EXTFramebufferObject.glFramebufferRenderbufferEXT(
					EXTFramebufferObject.GL_FRAMEBUFFER_EXT,
					EXTFramebufferObject.GL_DEPTH_ATTACHMENT_EXT,
					EXTFramebufferObject.GL_RENDERBUFFER_EXT, m_glDepthBuffer);
			}
		} finally {
			Draw3DCache.returnIntBuffer(buffer);
		}
	}

	private void deleteFbo() {

		if (EXTFramebufferObject.glIsFramebufferEXT(m_glFrameBuffer)) {
			IntBuffer buffer = Draw3DCache.getIntBuffer(1);
			try {
				buffer.rewind();

				buffer.put(m_glFrameBuffer);
				EXTFramebufferObject.glDeleteFramebuffersEXT(buffer);
			} finally {
				Draw3DCache.returnIntBuffer(buffer);
			}
		}
	}

	private void deleteRenderBuffers() {

		int numBuffers = 0;
		if (EXTFramebufferObject.glIsRenderbufferEXT(m_glColorBuffer))
			numBuffers++;
		if (EXTFramebufferObject.glIsRenderbufferEXT(m_glColorBuffer))
			numBuffers++;
		if (numBuffers == 0)
			return;

		IntBuffer buffer = Draw3DCache.getIntBuffer(numBuffers);
		try {
			buffer.rewind();

			if (EXTFramebufferObject.glIsRenderbufferEXT(m_glColorBuffer))
				buffer.put(m_glColorBuffer);

			if (EXTFramebufferObject.glIsRenderbufferEXT(m_glDepthBuffer))
				buffer.put(m_glDepthBuffer);

			EXTFramebufferObject.glDeleteRenderbuffersEXT(buffer);
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
		case EXTFramebufferObject.GL_FRAMEBUFFER_COMPLETE_EXT:
			return "GL_FRAMEBUFFER_COMPLETE_EXT";
		case EXTFramebufferObject.GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT_EXT:
			return "GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT_EXT";
		case EXTFramebufferObject.GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT_EXT:
			return "GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT_EXT";
		case EXTFramebufferObject.GL_FRAMEBUFFER_INCOMPLETE_FORMATS_EXT:
			return "GL_FRAMEBUFFER_INCOMPLETE_FORMATS_EXT";
		case EXTFramebufferObject.GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER_EXT:
			return "GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER_EXT";
		case EXTFramebufferObject.GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER_EXT:
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

		if (bufferConfig.isEnabled(GL11.GL_COLOR_BUFFER_BIT)) {
			int format = bufferConfig.getColorPixelFormat();
			int type = bufferConfig.getColorDataType();

			i_colorBuffer.rewind();
			GL11.glReadPixels(0, 0, width, height, format, type, i_colorBuffer);
		}

		if (bufferConfig.isEnabled(GL11.GL_DEPTH_BUFFER_BIT)) {
			int type = bufferConfig.getDepthDataType();

			i_depthBuffer.rewind();
			GL11.glReadPixels(0, 0, width, height, GL11.GL_DEPTH_COMPONENT,
				type, i_depthBuffer);
		}

		EXTFramebufferObject.glBindFramebufferEXT(
			EXTFramebufferObject.GL_FRAMEBUFFER_EXT, 0);
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
			EXTFramebufferObject.glBindFramebufferEXT(
				EXTFramebufferObject.GL_FRAMEBUFFER_EXT, m_glFrameBuffer);

			createRenderBuffers();

			int status =
				EXTFramebufferObject
					.glCheckFramebufferStatusEXT(EXTFramebufferObject.GL_FRAMEBUFFER_EXT);
			if (status != EXTFramebufferObject.GL_FRAMEBUFFER_COMPLETE_EXT)
				throw new RuntimeException(getStatus(status));

			m_initBuffers = false;
		} else
			EXTFramebufferObject.glBindFramebufferEXT(
				EXTFramebufferObject.GL_FRAMEBUFFER_EXT, m_glFrameBuffer);
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
