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

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw3d.graphics3d.DisplayListManager;
import org.eclipse.draw3d.graphics3d.lwjgl.font.LwjglFontManager;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.opengl.GLCanvas;

/**
 * Manages textures for 2D rendering.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 10.06.2008
 */
public class LwjglTextureManager {

	/**
	 * The logger object.
	 */
	private static final Logger log =
		Logger.getLogger(LwjglTextureManager.class.getName());

	private LwjglTexture m_activeTexture;

	/**
	 * Set in constructor from parameter ({@link #LwjglTextureManager(GLCanvas)}
	 * ).
	 */
	private final GLCanvas m_context;

	private boolean m_disposed = false;

	/**
	 * Initialized in constructor {@link #LwjglTextureManager(GLCanvas)}
	 */
	private Map<Object, LwjglTexture> m_textures;

	/**
	 * Lazily created in {@link #getFontManager()}
	 */
	private LwjglFontManager m_fontManager;

	private DisplayListManager m_displayListManager;

	/**
	 * Creates a new texture manager. The main GL context is needed for pbuffer
	 * textures.
	 * 
	 * @param i_context the main GL context
	 * @param i_fontManager the font manager
	 */
	public LwjglTextureManager(GLCanvas i_context,
			DisplayListManager i_displayListManager,
			LwjglFontManager i_fontManager) {

		if (i_context == null)
			throw new NullPointerException("i_context must not be null");

		if (i_displayListManager == null)
			throw new NullPointerException(
				"i_displayListManager must not be null");

		if (i_fontManager == null)
			throw new NullPointerException("i_fontManager must not be null");

		m_context = i_context;
		m_textures = new HashMap<Object, LwjglTexture>();
		m_displayListManager = i_displayListManager;
		m_fontManager = i_fontManager;
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

		LwjglTexture lwjglTexture = getTexture(i_key);
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

		LwjglTexture lwjglTexture = getTexture(i_key);
		lwjglTexture.clear(i_color, i_alpha);
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

		if (m_textureSupport == TextureSupport.UNKNOWN) {
			if (LwjglTextureFbo.isSuppported()) {
				log.fine("FBO texture support detected");
				m_textureSupport = TextureSupport.FBO;
			} else if (LwjglTexturePbuffer.isSupported(m_context)) {
				log.fine("Pbuffer texture support detected");
				m_textureSupport = TextureSupport.PBUFFER;
			} else {
				log.fine("No hardware support for accelerated texture drawing detected, using SWT images");
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

		LwjglTexture texture = m_textures.get(i_key);
		if (texture != null)
			texture.dispose();

		switch (getTextureSupport()) {
		case FBO:
			texture =
				new LwjglTextureFbo(i_width, i_height, m_displayListManager,
					m_fontManager);
			break;
		case PBUFFER:
			texture =
				new LwjglTexturePbuffer(m_context, i_width, i_height,
					m_displayListManager, m_fontManager);
			break;
		case SWT:
			texture = new LwjglTextureSwt(i_width, i_height);
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

		LwjglTexture lwjglTexture = getTexture(i_key);
		lwjglTexture.dispose();
		m_textures.remove(i_key);
	}

	/**
	 * Disposes all resources associated with this texture manager, including
	 * all contained textures.
	 */
	public void dispose() {

		if (m_disposed)
			return;

		if (log.isLoggable(Level.FINE))
			log.fine("disposing texture manager " + this);

		deactivateTexture();
		for (LwjglTexture lwjglTexture : m_textures.values())
			lwjglTexture.dispose();

		m_textures = null;
		m_fontManager = null;

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

	private LwjglTexture getTexture(Object i_key) {

		if (i_key == null)
			throw new NullPointerException("i_key must not be null");

		LwjglTexture lwjglTexture = m_textures.get(i_key);
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

		LwjglTexture lwjglTexture = getTexture(i_key);
		return lwjglTexture.getTextureId();
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

		LwjglTexture lwjglTexture = getTexture(i_key);
		lwjglTexture.setDimensions(i_width, i_height);
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
