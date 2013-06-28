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
package org.eclipse.draw3d.graphics3d.lwjgl.font;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.draw3d.graphics3d.DisplayListManager;
import org.eclipse.draw3d.graphics3d.lwjgl.texture.LwjglTextureManager;
import org.eclipse.swt.graphics.Font;

/**
 * Manages GL fonts for a GL context.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 10.06.2008
 */
public class LwjglFontManager {

	private DisplayListManager m_displayListManager;

	/**
	 * The font manager is created by the texture manager (
	 * {@link LwjglTextureManager}), this class should not be created by other
	 * classes.
	 * 
	 * @param i_displayListManager the display list manager
	 */
	public LwjglFontManager(DisplayListManager i_displayListManager) {

		if (i_displayListManager == null)
			throw new NullPointerException(
				"i_displayListManager must not be null");

		m_displayListManager = i_displayListManager;
	}

	// @SuppressWarnings("unused")
	private static final Logger log =
		Logger.getLogger(LwjglFontManager.class.getName());

	private boolean m_disposed = false;

	private Map<GLFontKey, LwjglFont> m_fonts =
		new HashMap<GLFontKey, LwjglFont>();

	/**
	 * Disposes all managed fonts.
	 */
	public void dispose() {

		if (m_disposed)
			return;

		for (LwjglFont glFont : m_fonts.values())
			glFont.dispose();

		m_fonts = null;
		m_disposed = true;
	}

	/**
	 * Returns a GL font for the given SWT font and character range.
	 * 
	 * @param i_font the SWT font
	 * @param i_startChar the start character
	 * @param i_endChar the end character
	 * @param i_antiAliased whether or not the font should be rendered with
	 *            antialiasing
	 * @return the GL font
	 * @throws NullPointerException if the given SWT font is <code>null</code>
	 */
	public LwjglFont getFont(Font i_font, char i_startChar, char i_endChar,
		boolean i_antiAliased) {

		if (m_disposed)
			throw new IllegalStateException("font manager is disposed");

		if (i_font == null)
			throw new NullPointerException("i_font must not be null");

		GLFontKey key =
			new GLFontKey(i_font, i_startChar, i_endChar, i_antiAliased);

		LwjglFont glFont = m_fonts.get(key);
		if (glFont == null) {
			glFont =
				new LwjglFont(i_font, i_startChar, i_endChar, i_antiAliased,
					m_displayListManager);
			m_fonts.put(key, glFont);

			if (log.isLoggable(Level.FINE))
				log.fine("loaded new GL raster font " + glFont);
		}

		return glFont;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append("LwjglFontManager [");
		for (Iterator<LwjglFont> iter = m_fonts.values().iterator(); iter.hasNext();) {
			LwjglFont glFont = iter.next();

			builder.append("Font: ");
			builder.append(glFont.toString());
			if (iter.hasNext())
				builder.append(", ");
		}
		builder.append("]");

		return builder.toString();
	}
}
