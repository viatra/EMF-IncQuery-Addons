/*******************************************************************************
 * Copyright (c) 2009-2010 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 *    Madhu Samuel   - Implementation
 ******************************************************************************/
package org.eclipse.draw3d.jogl.graphics3d.texture;

import java.nio.ByteBuffer;
import java.util.logging.Logger;

import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw3d.jogl.graphics3d.font.JoglFontManager;
import org.eclipse.draw3d.jogl.graphics3d.graphics.Graphics2DJogl;
import org.eclipse.draw3d.jogl.graphics3d.util.TextureUtil;
import org.eclipse.draw3d.util.BufferUtils;
import org.eclipse.draw3d.util.ColorConverter;
import org.eclipse.draw3d.util.ImageConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;

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
 * @author Madhu Samuel
 * @version $Revision$
 * @since 27.05.2008
 */
public class JoglTextureFbo extends AbstractJoglTexture {
	
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
		GL.GL_LIGHTING_BIT | GL.GL_CURRENT_BIT | GL.GL_TRANSFORM_BIT
			| GL.GL_LINE_BIT | GL.GL_POLYGON_BIT | GL.GL_TEXTURE_BIT
			| GL.GL_VIEWPORT_BIT | GL.GL_DEPTH_BUFFER_BIT
			| GL.GL_COLOR_BUFFER_BIT | GL.GL_MULTISAMPLE_BIT
			| GL.GL_ENABLE_BIT;



	@SuppressWarnings("unused")
	private static final Logger log =
		Logger.getLogger(JoglTextureFbo.class.getName());


	




	private JoglFontManager m_fontManager;

	private int m_glFrameBuffer = 0;

	private int m_glTexture = 0;

	protected Graphics2DJogl m_graphics;

	private int m_height = -1;

	private int m_width = -1;

	/**
	 * Creates a new texture with the given initial dimensions.
	 * 
	 * @param i_width the width of the texture
	 * @param i_height the height of the texture
	 * @throws IllegalArgumentException if the given width or height is not
	 *             positive
	 */
	public JoglTextureFbo(int i_width, int i_height,
			JoglFontManager fontManager, GL i_gl) {
		if(i_gl==null) 
			throw new NullPointerException("gl must not be null");
		this.m_gl = i_gl;
		m_fontManager = fontManager;
		setDimensions(i_width, i_height);
		m_glFrameBuffer = TextureUtil.createFbo(i_gl);
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

		m_gl.glFlush();
		m_gl.glBindFramebufferEXT(
			GL.GL_FRAMEBUFFER_EXT, m_glFrameBuffer);
		
		if (!m_valid) {
			m_graphics = new Graphics2DJogl(m_width, m_height, m_fontManager, m_gl);

			TextureUtil.deleteTexture(m_glTexture, m_gl);
			m_glTexture = TextureUtil.createTexture(m_width, m_height, m_gl);
			m_valid = true;

			int status =
				m_gl.glCheckFramebufferStatusEXT(GL.GL_FRAMEBUFFER_EXT);
			if (status != GL.GL_FRAMEBUFFER_COMPLETE_EXT) {
				throw new RuntimeException(getStatus(status));
			}
		}
		
		// save all state variables that may be changed by the graphics object
		m_gl.glPushAttrib(ATTRIB_MASK);

		m_gl.glMatrixMode(GL.GL_MODELVIEW);
		m_gl.glPushMatrix();

		m_gl.glMatrixMode(GL.GL_PROJECTION);
		m_gl.glPushMatrix();

		m_gl.glDisable(GL.GL_MULTISAMPLE);
		m_gl.glShadeModel(GL.GL_FLAT);
		m_gl.glDisable(GL.GL_DEPTH_TEST);
		m_gl.glDisable(GL.GL_CULL_FACE);
		m_gl.glHint(GL.GL_LINE_SMOOTH_HINT, GL.GL_NICEST);
		m_gl.glEnable(GL.GL_LINE_SMOOTH);

		m_gl.glMatrixMode(GL.GL_MODELVIEW);
		m_gl.glLoadIdentity();

		m_gl.glMatrixMode(GL.GL_PROJECTION);
		m_gl.glLoadIdentity();
		
		GLU glu = new GLU();
		glu.gluOrtho2D(0, m_width, m_height, 0);
		m_gl.glViewport(0, 0, m_width, m_height);

		m_gl.glTranslatef(Graphics2DJogl.RASTER_OFFSET,
			Graphics2DJogl.RASTER_OFFSET, 0);
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
		m_gl.glClearColor(color[0], color[1], color[2], color[3]);
		m_gl.glClear(GL.GL_COLOR_BUFFER_BIT);
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

		m_gl.glFlush();

		// restore OpenGL state
		m_gl.glMatrixMode(GL.GL_MODELVIEW);
		m_gl.glPopMatrix();

		m_gl.glMatrixMode(GL.GL_PROJECTION);
		m_gl.glPopMatrix();

		m_gl.glPopAttrib();

		m_gl.glBindFramebufferEXT(GL.GL_FRAMEBUFFER_EXT, 0);
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

		TextureUtil.deleteTexture(m_glTexture, m_gl);
		m_glTexture = 0;

		TextureUtil.deleteFbo(m_glFrameBuffer, m_gl);
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
		m_gl.glReadPixels(0, 0, m_width, m_height, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, buffer);

		ImageData imageData =
			ImageConverter.colorBufferToImage(buffer, GL.GL_RGBA,
					GL.GL_UNSIGNED_BYTE, m_width, m_height);
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
				"texture dimensions must be positive (" + i_width + " * "
					+ i_height + ")");
		}

		m_valid = m_valid && m_width == i_width && m_height == i_height;

		m_width = i_width;
		m_height = i_height;
	}
}
