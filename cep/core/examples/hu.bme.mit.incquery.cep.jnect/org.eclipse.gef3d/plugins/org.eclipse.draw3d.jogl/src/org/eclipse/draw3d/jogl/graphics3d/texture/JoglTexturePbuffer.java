///*******************************************************************************
// * Copyright (c) 2009-2010 Jens von Pilgrim and others.
// * All rights reserved. This program and the accompanying materials
// * are made available under the terms of the Eclipse Public License v1.0
// * which accompanies this distribution, and is available at
// * http://www.eclipse.org/legal/epl-v10.html
// *
// * Contributors:
// *    Kristian Duske - initial API and implementation
// *    Madhu Samuel   - Implementation
// ******************************************************************************/
//
//package org.eclipse.draw3d.jogl.graphics3d.texture;
//
//import java.nio.IntBuffer;
//
//import javax.media.opengl.GL;
//import javax.media.opengl.GLException;
//import javax.media.opengl.GLPbuffer;
//import javax.media.opengl.glu.GLU;
//
//import org.eclipse.draw2d.Graphics;
//import org.eclipse.draw3d.jogl.graphics3d.font.JoglFontManager;
//import org.eclipse.draw3d.jogl.graphics3d.graphics.Graphics2DJogl;
//import org.eclipse.draw3d.util.ColorConverter;
//import org.eclipse.draw3d.util.Draw3DCache;
//import org.eclipse.swt.graphics.Color;
//import org.eclipse.swt.opengl.GLCanvas;
////import org.lwjgl.LWJGLException;
////import org.lwjgl.opengl.Pbuffer;
////import org.lwjgl.opengl.PixelFormat;
////import org.lwjgl.opengl.RenderTexture;
//
///**
// * Allows rendering to a texture using PBuffers.
// * 
// * @author Madhu Samuel
// * @version $Revision$
// * @since 24.08.2009
// */
//public class JoglTexturePbuffer extends AbstractJoglTexture {
//
//	private static GLPbuffer createPBuffer(int i_width, int i_height)/*
//		throws LWJGLException*/ {
//		
//		RenderTexture renderTexture =
//			new RenderTexture(false, true, false, false,
//				RenderTexture.RENDER_TEXTURE_RECTANGLE, 0);
//
//		PixelFormat pixelFormat = new PixelFormat();
//
//		return new GLPbuffer(i_width, i_height, pixelFormat, renderTexture, null);
//	}
//	
//	//FIXME modified from static to instance method - madhu
//	private int createTexture() {
//
//		IntBuffer buffer = Draw3DCache.getIntBuffer(1);
//		try {
//			buffer.rewind();
//			//FIXME gl.glGenTextures(buffer) modified as below - Madhu
//			gl.glGenTextures(1,buffer);
//			int glTexture = buffer.get(0);
//
//			gl.glBindTexture(GL.GL_TEXTURE_2D, glTexture);
//			gl.glTexParameteri(GL.GL_TEXTURE_2D,
//					GL.GL_TEXTURE_MAG_FILTER, GL.GL_LINEAR);
//			gl.glTexParameteri(GL.GL_TEXTURE_2D,
//					GL.GL_TEXTURE_MIN_FILTER, GL.GL_LINEAR);
//			gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S,
//					GL.GL_CLAMP);
//			gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T,
//					GL.GL_CLAMP);
//
//			gl.glBindTexture(GL.GL_TEXTURE_2D, 0);
//
//			return glTexture;
//		} finally {
//			Draw3DCache.returnIntBuffer(buffer);
//		}
//	}
//	
//	//FIXME modified from static to instance method - madhu
//	private void deletePBuffer(GLPbuffer i_pBuffer) {
//
//		if (i_pBuffer != null) {
//			i_pBuffer.destroy();
//		}
//	}
//	
//	//FIXME modified from static to instance method - madhu
//	private void deleteTexture(int i_glTexture) {
//
//		if (i_glTexture > 0) {
//			IntBuffer buffer = Draw3DCache.getIntBuffer(1);
//			try {
//				buffer.rewind();
//				buffer.put(i_glTexture);
//				//FIXME gl.glDeleteTextures(buffer); modifed as below - madhu
//				gl.glDeleteTextures(1,buffer);
//			} finally {
//				Draw3DCache.returnIntBuffer(buffer);
//			}
//		}
//	}
//
//	/**
//	 * Indicates whether pbuffers are supported on the current system.
//	 * 
//	 * @param i_context the main OpenGL context
//	 * @return <code>true</code> if pbuffers are supported on the current system
//	 *         or <code>false</code> otherwise
//	 */
//	//FIXME modified from static to instance method - madhu
//	public boolean isSupported(GLCanvas i_context) {
//
//		if (i_context == null) {
//			throw new NullPointerException("i_context must not be null");
//		}
//
//		int glTexture = 0;
//		GLPbuffer pBuffer = null;
//		try {
//			glTexture = createTexture();
//			pBuffer = createPBuffer(32, 32);
//			pBuffer.makeCurrent();
//			gl.glBindTexture(GL.GL_TEXTURE_2D, glTexture);
////			pBuffer.releaseTexImage(GLPbuffer.FRONT_LEFT_BUFFER); //commented by madhu
//			pBuffer.releaseTexImage(GL.FRONT_LEFT_BUFFER);
//			pBuffer.bindTexImage(GLPbuffer.FRONT_LEFT_BUFFER);
//		} catch (Exception ex) {
//			return false;
//		} finally {
//			gl.glBindTexture(GL.GL_TEXTURE_2D, 0);
//			deleteTexture(glTexture);
//			deletePBuffer(pBuffer);
//			i_context.setCurrent();
//		}
//
//		return true;
//	}
//
//	private final GLCanvas m_context;
//
//	private JoglFontManager m_fontManager;
//
//	private int m_glTexture;
//
//	protected Graphics2DJogl m_graphics;
//
//	private int m_height;
//
//	private GLPbuffer m_pBuffer;
//
//	private int m_width;
//	
//	/**
//	 * The gl instance
//	 */
//	private GL gl;
//
//	/**
//	 * Creates a new texture. Since using pbuffers involves a context switch, we
//	 * need the main GL context here.
//	 * 
//	 * @param i_context the main GL context to switch to when the texture is
//	 *            deactivated
//	 * @param i_width the width of the texture
//	 * @param i_height the height of the texture
//	 * @param i_fontManager the font manager
//	 * @param gl the gl instnace
//	 * @throws IllegalArgumentException if the given width or height is not
//	 *             positive
//	 * @throws NullPointerException if the given context is <code>null</code>
//	 */
//	public JoglTexturePbuffer(GLCanvas i_context, int i_width, int i_height,
//			JoglFontManager i_fontManager, GL gl) {
//
//		if (i_context == null) {
//			throw new NullPointerException("i_context must not be null");
//		}
//		if (gl == null) {
//			throw new NullPointerException("gl must not be null");
//		}
//		this.gl = gl;
//		m_context = i_context;
//		setDimensions(i_width, i_height);
//		m_fontManager = i_fontManager;
//	}
//
//	/**
//	 * {@inheritDoc}
//	 * 
//	 * @see org.eclipse.draw3d.graphics3d.lwjgl.texture.LwjglTexture#activate()
//	 */
//	public void activate() {
//
//		if (m_disposed) {
//			throw new IllegalStateException("texture is disposed");
//		}
//
//		try {
//			if (!m_valid || (m_pBuffer != null && m_pBuffer.isBufferLost())) {
//				
//				m_graphics =
//					new Graphics2DJogl(m_width, m_height, m_fontManager, gl);
//
//				deleteTexture(m_glTexture);
//				deletePBuffer(m_pBuffer);
//
//				m_glTexture = createTexture();
//				m_pBuffer = createPBuffer(m_width, m_height);
//
//				m_pBuffer.makeCurrent();
//
//				gl.glDisable(GL.GL_MULTISAMPLE);
//				gl.glShadeModel(GL.GL_FLAT);
//				gl.glDisable(GL.GL_DEPTH_TEST);
//				gl.glDisable(GL.GL_CULL_FACE);
//				gl.glHint(GL.GL_LINE_SMOOTH_HINT, GL.GL_NICEST);
//				gl.glEnable(GL.GL_LINE_SMOOTH);
//
//				gl.glMatrixMode(GL.GL_MODELVIEW);
//				gl.glLoadIdentity();
//
//				gl.glMatrixMode(GL.GL_PROJECTION);
//				gl.glLoadIdentity();
//				
//				//FIXME Madhu: Check whether this instance has to be created some where else
//				GLU glu = new GLU();
//				glu.gluOrtho2D(0, m_width, m_height, 0);
//				gl.glViewport(0, 0, m_width, m_height);
//
//				gl.glTranslatef(JoglGraphics.RASTER_OFFSET,
//					JoglGraphics.RASTER_OFFSET, 0);
//
//				m_valid = true;
//			} else {
//				m_pBuffer.makeCurrent();
//			}
//
//			gl.glBindTexture(GL.GL_TEXTURE_2D, m_glTexture);
//			m_pBuffer.releaseTexImage(GLPbuffer.FRONT_LEFT_BUFFER);
//			gl.glBindTexture(GL.GL_TEXTURE_2D, 0);
//		} catch (GLException ex) {
//			throw new RuntimeException(
//				"caught exception while creating pbuffer", ex);
//		}
//	}
//
//	/**
//	 * {@inheritDoc}
//	 * 
//	 * @see org.eclipse.draw3d.graphics3d.lwjgl.texture.LwjglTexture#clear(org.eclipse.swt.graphics.Color,
//	 *      int)
//	 */
//	public void clear(Color i_color, int i_alpha) {
//
//		if (i_color == null) {
//			throw new NullPointerException("i_color must not be null");
//		}
//
//		float[] color = ColorConverter.toFloatArray(i_color, i_alpha, null);
//		gl.glClearColor(color[0], color[1], color[2], color[3]);
//		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
//	}
//
//	/**
//	 * {@inheritDoc}
//	 * 
//	 * @see org.eclipse.draw3d.graphics3d.lwjgl.texture.LwjglTexture#deactivate()
//	 */
//	public void deactivate() {
//
//		if (m_disposed) {
//			throw new IllegalStateException("texture is disposed");
//		}
//
//		gl.glBindTexture(GL.GL_TEXTURE_2D, m_glTexture);
//		m_pBuffer.bindTexImage(GLPbuffer.FRONT_LEFT_BUFFER);
//		m_context.setCurrent();
//
//		gl.glBindTexture(GL.GL_TEXTURE_2D, 0);
//	}
//
//	/**
//	 * {@inheritDoc}
//	 * 
//	 * @see org.eclipse.draw3d.graphics3d.lwjgl.texture.LwjglTexture#dispose()
//	 */
//	public void dispose() {
//
//		if (m_disposed) {
//			return;
//		}
//
//		deleteTexture(m_glTexture);
//		m_glTexture = 0;
//
//		deletePBuffer(m_pBuffer);
//		m_pBuffer = null;
//
//		m_disposed = true;
//	}
//
//	/**
//	 * {@inheritDoc}
//	 * 
//	 * @see org.eclipse.draw3d.graphics3d.lwjgl.texture.LwjglTexture#getGraphics()
//	 */
//	public Graphics getGraphics() {
//
//		if (m_disposed) {
//			throw new IllegalStateException("texture is disposed");
//		}
//
//		if (!m_valid) {
//			throw new IllegalStateException("texture not valid");
//		}
//
//		if (m_graphics == null) {
//			throw new IllegalStateException("texture not initialized");
//		}
//
//		return m_graphics;
//	}
//
//	/**
//	 * {@inheritDoc}
//	 * 
//	 * @see org.eclipse.draw3d.graphics3d.lwjgl.texture.LwjglTexture#getTextureId()
//	 */
//	public int getTextureId() {
//
//		if (m_disposed) {
//			throw new IllegalStateException("texture is disposed");
//		}
//
//		return m_glTexture;
//	}
//
//	/**
//	 * {@inheritDoc}
//	 * 
//	 * @see org.eclipse.draw3d.graphics3d.lwjgl.texture.LwjglTexture#setDimensions(int,
//	 *      int)
//	 */
//	public void setDimensions(int i_width, int i_height) {
//
//		if (m_disposed) {
//			throw new IllegalStateException("texture is disposed");
//		}
//
//		if (i_width <= 0 || i_height <= 0) {
//			throw new IllegalArgumentException(
//				"texture dimensions must not be negative");
//		}
//
//		m_valid = m_valid && m_width == i_width && m_height == i_height;
//
//		m_width = i_width;
//		m_height = i_height;
//	}
//}
