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
package org.eclipse.draw3d.graphics3d.lwjgl.texture;

import java.nio.IntBuffer;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw3d.graphics3d.DisplayListManager;
import org.eclipse.draw3d.graphics3d.lwjgl.font.LwjglFontManager;
import org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglGraphics;
import org.eclipse.draw3d.util.ColorConverter;
import org.eclipse.draw3d.util.Draw3DCache;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.opengl.GLCanvas;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.Pbuffer;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.opengl.RenderTexture;
import org.lwjgl.util.glu.GLU;

/**
 * Allows rendering to a texture using PBuffers.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 06.08.2008
 */
public class LwjglTexturePbuffer extends AbstractLwjglTexture {

	private static Pbuffer createPBuffer(int i_width, int i_height)
		throws LWJGLException {

		RenderTexture renderTexture =
			new RenderTexture(false, true, false, false,
				RenderTexture.RENDER_TEXTURE_RECTANGLE, 0);

		PixelFormat pixelFormat = new PixelFormat();

		return new Pbuffer(i_width, i_height, pixelFormat, renderTexture, null);
	}

	private static int createTexture() {

		IntBuffer buffer = Draw3DCache.getIntBuffer(1);
		try {
			buffer.rewind();
			GL11.glGenTextures(buffer);
			int glTexture = buffer.get(0);

			GL11.glBindTexture(GL11.GL_TEXTURE_2D, glTexture);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D,
				GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D,
				GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S,
				GL11.GL_CLAMP);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T,
				GL11.GL_CLAMP);

			GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);

			return glTexture;
		} finally {
			Draw3DCache.returnIntBuffer(buffer);
		}
	}

	private static void deletePBuffer(Pbuffer i_pBuffer) {

		if (i_pBuffer != null) {
			i_pBuffer.destroy();
		}
	}

	private static void deleteTexture(int i_glTexture) {

		if (i_glTexture > 0) {
			IntBuffer buffer = Draw3DCache.getIntBuffer(1);
			try {
				buffer.rewind();
				buffer.put(i_glTexture);
				GL11.glDeleteTextures(buffer);
			} finally {
				Draw3DCache.returnIntBuffer(buffer);
			}
		}
	}

	/**
	 * Indicates whether pbuffers are supported on the current system.
	 * 
	 * @param i_context the main OpenGL context
	 * @return <code>true</code> if pbuffers are supported on the current system
	 *         or <code>false</code> otherwise
	 */
	public static boolean isSupported(GLCanvas i_context) {

		if (i_context == null) {
			throw new NullPointerException("i_context must not be null");
		}

		int glTexture = 0;
		Pbuffer pBuffer = null;
		try {
			glTexture = createTexture();
			pBuffer = createPBuffer(32, 32);
			pBuffer.makeCurrent();
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, glTexture);
			pBuffer.releaseTexImage(Pbuffer.FRONT_LEFT_BUFFER);
			pBuffer.bindTexImage(Pbuffer.FRONT_LEFT_BUFFER);
		} catch (Exception ex) {
			return false;
		} finally {
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
			deleteTexture(glTexture);
			deletePBuffer(pBuffer);
			i_context.setCurrent();
		}

		return true;
	}

	private final GLCanvas m_context;

	private DisplayListManager m_displayListManager;

	private LwjglFontManager m_fontManager;

	private int m_glTexture;

	protected LwjglGraphics m_graphics;

	private int m_height;

	private Pbuffer m_pBuffer;

	private int m_width;

	/**
	 * Creates a new texture. Since using pbuffers involves a context switch, we
	 * need the main GL context here.
	 * 
	 * @param i_context the main GL context to switch to when the texture is
	 *            deactivated
	 * @param i_width the width of the texture
	 * @param i_height the height of the texture
	 * @param i_displayListManager the display list manager
	 * @param i_fontManager the font manager
	 * @throws IllegalArgumentException if the given width or height is not
	 *             positive
	 * @throws NullPointerException if the given context is <code>null</code>
	 */
	public LwjglTexturePbuffer(GLCanvas i_context, int i_width, int i_height,
			DisplayListManager i_displayListManager,
			LwjglFontManager i_fontManager) {

		if (i_context == null) {
			throw new NullPointerException("i_context must not be null");
		}

		m_context = i_context;
		setDimensions(i_width, i_height);
		m_displayListManager = i_displayListManager;
		m_fontManager = i_fontManager;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.texture.LwjglTexture#activate()
	 */
	public void activate() {

		if (m_disposed) {
			throw new IllegalStateException("texture is disposed");
		}

		try {
			if (!m_valid || (m_pBuffer != null && m_pBuffer.isBufferLost())) {
				m_graphics =
					new LwjglGraphics(m_width, m_height, m_displayListManager,
						m_fontManager);

				deleteTexture(m_glTexture);
				deletePBuffer(m_pBuffer);

				m_glTexture = createTexture();
				m_pBuffer = createPBuffer(m_width, m_height);

				m_pBuffer.makeCurrent();

				GL11.glDisable(GL13.GL_MULTISAMPLE);
				GL11.glShadeModel(GL11.GL_FLAT);
				GL11.glDisable(GL11.GL_DEPTH_TEST);
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glHint(GL11.GL_LINE_SMOOTH_HINT, GL11.GL_NICEST);
				GL11.glEnable(GL11.GL_LINE_SMOOTH);

				GL11.glMatrixMode(GL11.GL_MODELVIEW);
				GL11.glLoadIdentity();

				GL11.glMatrixMode(GL11.GL_PROJECTION);
				GL11.glLoadIdentity();

				GLU.gluOrtho2D(0, m_width, m_height, 0);
				GL11.glViewport(0, 0, m_width, m_height);

				m_valid = true;
			} else {
				m_pBuffer.makeCurrent();
			}

			GL11.glBindTexture(GL11.GL_TEXTURE_2D, m_glTexture);
			m_pBuffer.releaseTexImage(Pbuffer.FRONT_LEFT_BUFFER);
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
		} catch (LWJGLException ex) {
			throw new RuntimeException(
				"caught exception while creating pbuffer", ex);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.texture.LwjglTexture#clear(org.eclipse.swt.graphics.Color,
	 *      int)
	 */
	public void clear(Color i_color, int i_alpha) {

		if (i_color == null) {
			throw new NullPointerException("i_color must not be null");
		}

		float[] color = ColorConverter.toFloatArray(i_color, i_alpha, null);
		GL11.glClearColor(color[0], color[1], color[2], color[3]);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.texture.LwjglTexture#deactivate()
	 */
	public void deactivate() {

		if (m_disposed) {
			throw new IllegalStateException("texture is disposed");
		}

		GL11.glBindTexture(GL11.GL_TEXTURE_2D, m_glTexture);
		m_pBuffer.bindTexImage(Pbuffer.FRONT_LEFT_BUFFER);
		m_context.setCurrent();

		GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.texture.LwjglTexture#dispose()
	 */
	public void dispose() {

		if (m_disposed) {
			return;
		}

		deleteTexture(m_glTexture);
		m_glTexture = 0;

		deletePBuffer(m_pBuffer);
		m_pBuffer = null;

		m_disposed = true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.texture.LwjglTexture#getGraphics()
	 */
	public Graphics getGraphics() {

		if (m_disposed) {
			throw new IllegalStateException("texture is disposed");
		}

		if (!m_valid) {
			throw new IllegalStateException("texture not valid");
		}

		if (m_graphics == null) {
			throw new IllegalStateException("texture not initialized");
		}

		return m_graphics;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.texture.LwjglTexture#getTextureId()
	 */
	public int getTextureId() {

		if (m_disposed) {
			throw new IllegalStateException("texture is disposed");
		}

		return m_glTexture;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.texture.LwjglTexture#setDimensions(int,
	 *      int)
	 */
	public void setDimensions(int i_width, int i_height) {

		if (m_disposed) {
			throw new IllegalStateException("texture is disposed");
		}

		if (i_width <= 0 || i_height <= 0) {
			throw new IllegalArgumentException(
				"texture dimensions must not be negative");
		}

		m_valid = m_valid && m_width == i_width && m_height == i_height;

		m_width = i_width;
		m_height = i_height;
	}
}
