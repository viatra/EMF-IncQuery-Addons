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

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.logging.Logger;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw3d.graphics3d.DisplayListManager;
import org.eclipse.draw3d.graphics3d.lwjgl.font.LwjglFontManager;
import org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglGraphics;
import org.eclipse.draw3d.util.BufferUtils;
import org.eclipse.draw3d.util.ColorConverter;
import org.eclipse.draw3d.util.Draw3DCache;
import org.eclipse.draw3d.util.ImageConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.GLU;

/**
 * Allows rendering to an OpenGL texture using an instance of
 * {@link LwjglGraphics} and a framebuffer object.
 * <p>
 * We use arbitrary texture sizes for performance reasons, this only works on
 * machines with OpenGL version 2 or later. Some video cards can do it with D3D
 * and some OpenGL 2.0 cards can¬¥t. In the first group are nVidia serie 6 and
 * up and in second are ATI Radeon series 200 and 300. (since rev. 361, also see
 * mailing list: Alessandro Borges: NPOT - textures, April 7. 2008)
 * </p>
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 26.05.2008
 */
public class LwjglTextureFbo extends AbstractLwjglTexture {

	/**
	 * Enumerates FBO support states.
	 * 
	 * @author Kristian Duske
	 * @version $Revision$
	 * @since 27.08.2009
	 */
	private static enum FboSupport {
		/**
		 * FBOs are supported by the hardware.
		 */
		SUPPORTED,
		/**
		 * FBO support is not yet determined.
		 */
		UNKNOWN,
		/**
		 * FBOs are not supported by the hardware.
		 */
		UNSUPPORTED;
	}

	/**
	 * Indicates which attribute groups must be saved prior to using this.
	 */
	private static final int ATTRIB_MASK =
		GL11.GL_LIGHTING_BIT | GL11.GL_CURRENT_BIT | GL11.GL_TRANSFORM_BIT
			| GL11.GL_LINE_BIT | GL11.GL_POLYGON_BIT | GL11.GL_TEXTURE_BIT
			| GL11.GL_VIEWPORT_BIT | GL11.GL_DEPTH_BUFFER_BIT
			| GL11.GL_COLOR_BUFFER_BIT | GL13.GL_MULTISAMPLE_BIT
			| GL11.GL_ENABLE_BIT;

	/**
	 * Note that this is static, so the FBO support level is determined only
	 * once.
	 */
	private static FboSupport fboSupport = FboSupport.UNKNOWN;

	@SuppressWarnings("unused")
	private static final Logger log =
		Logger.getLogger(LwjglTextureFbo.class.getName());

	private static int createFbo() {

		IntBuffer buffer = Draw3DCache.getIntBuffer(1);
		try {
			buffer.rewind();
			EXTFramebufferObject.glGenFramebuffersEXT(buffer);
			return buffer.get(0);
		} finally {
			Draw3DCache.returnIntBuffer(buffer);
		}
	}

	private static int createTexture(int i_width, int i_height) {

		IntBuffer buffer = Draw3DCache.getIntBuffer(1);
		try {
			buffer.rewind();
			GL11.glGenTextures(buffer);
			int glTexture = buffer.get(0);

			GL11.glBindTexture(GL11.GL_TEXTURE_2D, glTexture);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D,
				GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D,
				GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR_MIPMAP_LINEAR);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S,
				GL11.GL_CLAMP);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T,
				GL11.GL_CLAMP);

			GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, i_width,
				i_height, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE,
				(ByteBuffer) null);

			EXTFramebufferObject.glFramebufferTexture2DEXT(
				EXTFramebufferObject.GL_FRAMEBUFFER_EXT,
				EXTFramebufferObject.GL_COLOR_ATTACHMENT0_EXT,
				GL11.GL_TEXTURE_2D, glTexture, 0);
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);

			return glTexture;
		} finally {
			Draw3DCache.returnIntBuffer(buffer);
		}
	}

	private static void deleteFbo(int i_glFrameBuffer) {

		if (i_glFrameBuffer > 0) {
			IntBuffer buffer = Draw3DCache.getIntBuffer(1);
			try {
				buffer.rewind();
				buffer.put(i_glFrameBuffer);
				EXTFramebufferObject.glDeleteFramebuffersEXT(buffer);
			} finally {
				Draw3DCache.returnIntBuffer(buffer);
			}
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
	 * Indicates whether FBOs are supported on this system.
	 * 
	 * @return <code>true</code> if FBOs are supported or <code>false</code>
	 *         otherwise
	 */
	public static boolean isSuppported() {

		if (fboSupport == FboSupport.UNKNOWN) {
			fboSupport = FboSupport.UNSUPPORTED;

			ContextCapabilities contextCapabilities =
				GLContext.getCapabilities();

			if (contextCapabilities == null
				|| !contextCapabilities.GL_EXT_framebuffer_object)
				return false;

			// create an FBO with a texture attachment and check the status
			int glFrameBuffer = 0;
			int glTexture = 0;
			try {
				glFrameBuffer = createFbo();
				glTexture = createTexture(32, 32);
				int status =
					EXTFramebufferObject.glCheckFramebufferStatusEXT(EXTFramebufferObject.GL_FRAMEBUFFER_EXT);
				if (status != EXTFramebufferObject.GL_FRAMEBUFFER_COMPLETE_EXT) {
					return false;
				}
			} finally {
				deleteTexture(glTexture);
				deleteFbo(glFrameBuffer);
			}

			fboSupport = FboSupport.SUPPORTED;
			return true;
		}

		return fboSupport == FboSupport.SUPPORTED;

	}

	private LwjglFontManager m_fontManager;

	private int m_glFrameBuffer = 0;

	private int m_glTexture = 0;

	private Graphics m_graphics;

	private int m_height = -1;

	private int m_width = -1;

	private DisplayListManager m_displayListmanager;

	/**
	 * Creates a new texture with the given initial dimensions.
	 * 
	 * @param i_width the width of the texture
	 * @param i_height the height of the texture
	 * @param i_displayListmanager the display list manager
	 * @param i_fontManager the font manager to use
	 * @throws IllegalArgumentException if the given width or height is not
	 *             positive
	 */
	public LwjglTextureFbo(int i_width, int i_height,
			DisplayListManager i_displayListmanager,
			LwjglFontManager i_fontManager) {

		if (i_displayListmanager == null)
			throw new NullPointerException(
				"i_displayListmanager must not be null");

		if (i_fontManager == null)
			throw new NullPointerException("i_fontManager must not be null");

		m_displayListmanager = i_displayListmanager;
		m_fontManager = i_fontManager;
		setDimensions(i_width, i_height);
		m_glFrameBuffer = createFbo();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.texture.LwjglTexture#activate()
	 */
	public void activate() {

		if (m_disposed)
			throw new IllegalStateException("texture is disposed");

		GL11.glFlush();
		EXTFramebufferObject.glBindFramebufferEXT(
			EXTFramebufferObject.GL_FRAMEBUFFER_EXT, m_glFrameBuffer);
		if (!m_valid) {
			m_graphics =
				new LwjglGraphics(m_width, m_height, m_displayListmanager,
					m_fontManager);

			deleteTexture(m_glTexture);
			m_glTexture = createTexture(m_width, m_height);
			m_valid = true;

			int status =
				EXTFramebufferObject.glCheckFramebufferStatusEXT(EXTFramebufferObject.GL_FRAMEBUFFER_EXT);
			if (status != EXTFramebufferObject.GL_FRAMEBUFFER_COMPLETE_EXT) {
				throw new RuntimeException(getStatus(status));
			}
		}

		// save all state variables that may be changed by the graphics object
		GL11.glPushAttrib(ATTRIB_MASK);

		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glPushMatrix();

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glPushMatrix();

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
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.texture.LwjglTexture#clear(org.eclipse.swt.graphics.Color,
	 *      int)
	 */
	public void clear(Color i_color, int i_alpha) {

		if (i_color == null)
			throw new NullPointerException("i_color must not be null");

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

		if (m_disposed)
			throw new IllegalStateException("texture is disposed");

		GL11.glFlush();

		// calculate mipmaps
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, m_glTexture);
		EXTFramebufferObject.glGenerateMipmapEXT(GL11.GL_TEXTURE_2D);

		// restore OpenGL state
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glPopMatrix();

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glPopMatrix();

		GL11.glPopAttrib();

		EXTFramebufferObject.glBindFramebufferEXT(
			EXTFramebufferObject.GL_FRAMEBUFFER_EXT, 0);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.texture.LwjglTexture#dispose()
	 */
	public void dispose() {

		if (m_disposed)
			return;

		deleteTexture(m_glTexture);
		m_glTexture = 0;

		deleteFbo(m_glFrameBuffer);
		m_glFrameBuffer = 0;

		if (m_graphics != null) {
			m_graphics.dispose();
			m_graphics = null;
		}
	}

	@SuppressWarnings("unused")
	private void dump() {

		ByteBuffer buffer =
			BufferUtils.createByteBuffer(m_width * m_height * 4);
		GL11.glReadPixels(0, 0, m_width, m_height, GL11.GL_RGBA,
			GL11.GL_UNSIGNED_BYTE, buffer);

		ImageData imageData =
			ImageConverter.colorBufferToImage(buffer, GL11.GL_RGBA,
				GL11.GL_UNSIGNED_BYTE, m_width, m_height);
		ImageLoader imageLoader = new ImageLoader();
		imageLoader.data = new ImageData[] { imageData };

		String path =
			"/Users/kristian/Temp/texture" + m_glTexture + "_"
				+ System.currentTimeMillis() + ".png";
		imageLoader.save(path, SWT.IMAGE_PNG);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.texture.LwjglTexture#getGraphics()
	 */
	public Graphics getGraphics() {

		if (m_disposed)
			throw new IllegalStateException("texture is disposed");

		if (!m_valid)
			throw new IllegalStateException("texture not valid");

		if (m_graphics == null)
			throw new IllegalStateException("texture not initialized");

		return m_graphics;
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
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.texture.LwjglTexture#getTextureId()
	 */
	public int getTextureId() {

		if (m_disposed)
			throw new IllegalStateException("texture is disposed");

		return m_glTexture;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.texture.LwjglTexture#setDimensions(int,
	 *      int)
	 */
	public void setDimensions(int i_width, int i_height) {

		if (m_disposed)
			throw new IllegalStateException("texture is disposed");

		if (i_width <= 0 || i_height <= 0)
			throw new IllegalArgumentException(
				"texture dimensions must be positive (" + i_width + " * "
					+ i_height + ")");

		m_valid = m_valid && m_width == i_width && m_height == i_height;

		m_width = i_width;
		m_height = i_height;
	}
}
