/*******************************************************************************
 * Copyright (c) 2009-2010 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 *    Madhu Samuel	 - JOGL Implementation 
 ******************************************************************************/
package org.eclipse.draw3d.jogl.graphics3d.texture;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.media.opengl.GL;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw3d.jogl.graphics3d.font.JoglFontManager;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.opengl.GLCanvas;

/**
 * Manages textures for 2D rendering.
 * 
 * @author Madhu Samuel
 * @version $Revision$
 * @since 27.08.2009
 */
public class JoglTextureManager {

	/**
	 * The logger object.
	 */
	private static final Logger log = Logger
			.getLogger(JoglTextureManager.class.getName());

	private JoglTexture m_activeTexture;

	/**
	 * Set in constructor from parameter ({@link #LwjglTextureManager(GLCanvas)}).
	 */
	private final GLCanvas m_context;

	
	private boolean m_disposed = false;

	/**
	 * Initialized in constructor {@link #LwjglTextureManager(GLCanvas)}
	 */
	private Map<Object, JoglTexture> m_textures;

	/**
	 * Lazily created in {@link #getFontManager()}
	 */
	private JoglFontManager m_fontManager;
	
	/**
	 * Lazily created in {@link #getTextureValidator()}
	 */
	private TextureValidator m_textureValidator;
	
	/**
	 * The gl instance
	 */
	private GL m_gl;

	/**
	 * Creates a new texture manager. The main GL context is needed for pbuffer
	 * textures.
	 * 
	 * @param i_context the main GL context
	 */
	public JoglTextureManager(GLCanvas i_context, GL i_gl) {
//TODO Madhu : rename i_context and m_context to i_canvas and m_canvas respectively
		if (i_context == null)
			throw new NullPointerException("i_context must not be null");
		
		if(i_gl==null) 
			throw new NullPointerException("gl must not be null");

		m_context = i_context;
		this.m_gl = i_gl;
		m_textures = new HashMap<Object, JoglTexture>();
	}
	
	/**
	 * This method should not be called from outside, it is only defined
	 * public here for tests.
	 * @return
	 */
	public JoglFontManager getFontManager() {
		if (m_fontManager==null) { // lazy initialization
			m_fontManager = new JoglFontManager();
		}
		return m_fontManager;
	}
	
	/**
	 * @return
	 */
	public TextureValidator getTextureValidator(GL i_gl) {
		if (m_textureValidator==null) { // lazy initialization
			m_textureValidator = new TextureValidator(i_gl);
		}
		return m_textureValidator;
	}
	

	/**
	 * Activates the texture with the given key for rendering.
	 * 
	 * @param i_key the unique key to identify the texture
	 * @throws NullPointerException if the given key is <code>null</code>
	 * @throws IllegalArgumentException if the given key is unknown
	 * @throws IllegalStateException if this texture manager is disposed
	 */
	public void activateTexture(Object i_key) {

		if (m_disposed)
			throw new IllegalStateException("texture manager is disposed");

		JoglTexture lwjglTexture = getTexture(i_key);
		if (lwjglTexture.equals(m_activeTexture))
			return;

		if (m_activeTexture != null)
			m_activeTexture.deactivate();

		m_activeTexture = lwjglTexture;
		m_activeTexture.activate();
	}

	/**
	 * Clears the texture with the given key.
	 * 
	 * @param i_key the key of the texture to clear
	 * @param i_color the clear color
	 * @param i_alpha the clear alpha value
	 */
	public void clearTexture(Object i_key, Color i_color, int i_alpha) {

		if (m_disposed)
			throw new IllegalStateException("texture manager is disposed");

		if (i_color == null)
			throw new NullPointerException("i_color must not be null");

		JoglTexture joglTexture = getTexture(i_key);
		joglTexture.clear(i_color, i_alpha);
	}

	/**
	 * Indicates whether this manager contains a texture with the given key.
	 * 
	 * @param i_key the key to check
	 * @return <code>true</code> if this manager contains a texture with the
	 *         given key or <code>false</code> otherwise
	 * @throws NullPointerException if the given key is <code>null</code>
	 * @throws IllegalStateException if this texture manager is disposed
	 */
	public boolean contains(Object i_key) {

		if (m_disposed)
			throw new IllegalStateException("texture manager is disposed");

		if (i_key == null)
			throw new NullPointerException("i_key must not be null");

		return m_textures.containsKey(i_key);
	}
	
	private enum TextureSupport {
		UNKNOWN, FBO, PBUFFER, SWT;
	}

	private TextureSupport m_textureSupport = TextureSupport.UNKNOWN;

	private TextureSupport getTextureSupport() {
		TextureValidator i_textureValidator = getTextureValidator(m_gl);

		if (m_textureSupport == TextureSupport.UNKNOWN) {
			if (i_textureValidator.isSupported(TextureType.FBO)) {
				log.fine("FBO texture support detected");
				m_textureSupport = TextureSupport.FBO;
			} else if (i_textureValidator.isSupported(TextureType.PBuffer)) {
				log.fine("Pbuffer texture support detected");
				m_textureSupport = TextureSupport.PBUFFER;
			} else {
				log
					.fine("No hardware support for accelerated texture drawing detected, using SWT images");
				m_textureSupport = TextureSupport.SWT;
			}
		}

		return m_textureSupport;
	}

	/**
	 * Creates a new texture with the given key and dimensions. If a texture
	 * with the given key already exists, it is destroyed. The given conversion
	 * specs are used only if no OpenGL acceleration for texture drawing is
	 * available on this system. In such cases, 2D content is drawn using SWT
	 * images, and the resulting image is converted to a texture.
	 * 
	 * @param i_key the key of the new texture
	 * @param i_width the width of the new texture
	 * @param i_height the height of the new texure
	 * @param i_specs the conversion specs for converting non-accelerated SWT
	 *            images to textures
	 * @throws NullPointerException if the given key is <code>null</code>
	 * @throws IllegalStateException if this texture manager is disposed
	 */
	public void createTexture(Object i_key, int i_width, int i_height) {

		if (m_disposed)
			throw new IllegalStateException("texture manager is disposed");

		if (i_key == null)
			throw new NullPointerException("i_key must not be null");

		JoglTexture texture = m_textures.get(i_key);
		if (texture != null) 
			texture.dispose();
		
		//FIXME - TURNED OFF PBUFFER TEMPORARILY - MADHU
		switch (getTextureSupport()) {
		case FBO:
			texture = new JoglTextureFbo(i_width, i_height, getFontManager(), m_gl);
			break;
//		case PBUFFER:
//			texture =
//				new JoglTexturePbuffer(m_context, i_width, i_height,
//					getFontManager(), m_gl);
//			break;
		case SWT:
			texture = new JoglTextureSwt(i_width, i_height, m_gl);
			break;
		default:
			throw new IllegalStateException(
				"could not determine texture support");
		}

		m_textures.put(i_key, texture);
	}

	/**
	 * Deactivates the current texture and reactivates the main framebuffer for
	 * rendering.
	 * 
	 * @throws IllegalStateException if this texture manager is disposed
	 */
	public void deactivateTexture() {

		if (m_disposed)
			throw new IllegalStateException("texture manager is disposed");

		if (m_activeTexture != null) {
			m_activeTexture.deactivate();
			m_activeTexture = null;
		}
	}

	/**
	 * Deletes the texture with the given key.
	 * 
	 * @param i_key the key of the texture to delete
	 * @throws NullPointerException if the given texture is <code>null</code>
	 * @throws IllegalArgumentException if this texture manager does not contain
	 *             a texture with the given key
	 * @throws IllegalStateException if this texture manager is disposed
	 */
	public void deleteTexture(Object i_key) {

		if (m_disposed)
			throw new IllegalStateException("texture manager is disposed");

		JoglTexture joglTexture = getTexture(i_key);
		joglTexture.dispose();
		m_textures.remove(i_key);
	}

	/**
	 * Disposes all resources associated with this texture manager, including
	 * all contained textures.
	 */
	public void dispose() {

		if (m_disposed)
			return;

		deactivateTexture();
		for (JoglTexture lwjglTexture : m_textures.values())
			lwjglTexture.dispose();

		m_textures = null;
		
		if (m_fontManager!=null) {
			m_fontManager.dispose();
			m_fontManager = null;
		}
		
		m_disposed = true;
	}

	/**
	 * Returns the graphics object associated with the currently active texture.
	 * This graphics object can be used to render to the active texture.
	 * 
	 * @return the graphics object
	 * @throws IllegalStateException if no texture is active
	 * @throws IllegalStateException if this texture manager is disposed
	 */
	public Graphics getGraphics() {

		if (m_disposed)
			throw new IllegalStateException("texture manager is disposed");

		if (m_activeTexture == null)
			throw new IllegalStateException("no texture is active");

		return m_activeTexture.getGraphics();
	}

	private JoglTexture getTexture(Object i_key) {

		if (i_key == null)
			throw new NullPointerException("i_key must not be null");

		JoglTexture lwjglTexture = m_textures.get(i_key);
		if (lwjglTexture == null)
			throw new IllegalArgumentException("unknown texture: " + i_key);

		return lwjglTexture;
	}

	/**
	 * Returns the OpenGL texture ID of the texture with the given key.
	 * 
	 * @param i_key the key of the texture
	 * @return the texture ID
	 * @throws NullPointerException if the given key is <code>null</code>
	 * @throws IllegalArgumentException if this manager does not contain a
	 *             texture with the given key
	 * @throws IllegalStateException if this texture manager is disposed
	 */
	public int getTextureId(Object i_key) {

		if (m_disposed)
			throw new IllegalStateException("texture manager is disposed");

		JoglTexture joglTexture = getTexture(i_key);
		return joglTexture.getTextureId();
	}

	/**
	 * Resizes the texture with the given key to the given dimensions.
	 * 
	 * @param i_key the key of the texture to resize
	 * @param i_width the new width
	 * @param i_height the new height
	 * @throws NullPointerException if the given key is <code>null</code>
	 * @throws IllegalArgumentException if this manager does not contain a
	 *             texture with the given key
	 * @throws IllegalStateException if this texture manager is disposed
	 */
	public void resizeTexture(Object i_key, int i_width, int i_height) {

		if (m_disposed)
			throw new IllegalStateException("texture manager is disposed");

		JoglTexture joglTexture = getTexture(i_key);
		joglTexture.setDimensions(i_width, i_height);
	}

	/**
	 * Indicates whether this texture manager is disposed.
	 * 
	 * @return <code>true</code> if this texture manager is disposed or
	 *         <code>false</code> otherwise
	 */
	public boolean isDisposed() {
		return m_disposed;
	}
}
