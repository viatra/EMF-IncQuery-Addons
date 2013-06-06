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
package org.eclipse.draw3d.jogl.graphics3d.font;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

import javax.media.opengl.GL;

import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;

/**
 * Manages GL fonts for a GL context.
 * 
 * @author Madhu Samuel
 * @version $Revision$
 * @since 24.08.2009
 */
public class JoglFontManager {

	/**
	 * The font manager is created by the texture manager 
	 * ({@link JoglTextureManager}), this class should not be created by
	 * other classes.
	 */
	public JoglFontManager() {
	}
	
	
//	/**
//	 * The font manager instance which is shared between all graphics instances
//	 * created within the same thread.
//	 */
//	private static final ThreadLocal<LwjglFontManager> fontManager = new ThreadLocal<LwjglFontManager>() {
//		/**
//		 * {@inheritDoc}
//		 * 
//		 * @see java.lang.ThreadLocal#initialValue()
//		 */
//		@Override
//		protected LwjglFontManager initialValue() {
//
//			return new LwjglFontManager();
//		}
//	};
//
//	/**
//	 * Gets the thread's font manager instance.
//	 * 
//	 * @return
//	 */
//	public static LwjglFontManager getFontManager() {
//		return fontManager.get();
//	}
//
	/**
	 * Key for the font map.
	 * 
	 * @author Kristian Duske
	 * @version $Revision$
	 * @since 10.06.2008
	 * @see $HeadURL:
	 *      https://gorgo.fernuni-hagen.de/OpenglGEF/trunk/org.eclipse.
	 *      draw3d/src/java/de/feu/draw3d/font/LwjglFontManager.java $
	 */
	private class GLFontKey {

		private int m_hashCode;

		/**
		 * Creates a new key for a given font and character range.
		 * 
		 * @param i_font the font
		 * @param i_startChar the start character
		 * @param i_endChar the end character
		 */
		public GLFontKey(Font i_font, char i_startChar, char i_endChar) {

			m_hashCode = 17;
			m_hashCode = 37 * m_hashCode + i_font.hashCode();
			m_hashCode = 37 * m_hashCode + i_startChar;
			m_hashCode = 37 * m_hashCode + i_endChar;

			FontData[] fontDatas = i_font.getFontData();
			for (FontData fontData : fontDatas)
				m_hashCode = 37 * fontData.hashCode();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object i_obj) {

			if (i_obj == null)
				return false;

			if (i_obj == this)
				return true;

			if (!(i_obj instanceof GLFontKey))
				return false;

			GLFontKey other = (GLFontKey) i_obj;
			return other.m_hashCode == m_hashCode;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {

			return m_hashCode;
		}
	}

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(JoglFontManager.class
			.getName());

	private boolean m_disposed = false;

	private Map<GLFontKey, JoglFont> m_fonts = new HashMap<GLFontKey, JoglFont>();

	/**
	 * Disposes all managed fonts.
	 */
	public void dispose() {

		if (m_disposed)
			return;

		for (JoglFont glFont : m_fonts.values())
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
	 * @return the GL font
	 * @throws NullPointerException if the given SWT font is <code>null</code>
	 */
	public JoglFont getFont(Font i_font, char i_startChar, char i_endChar, GL gl) {

		if (m_disposed)
			throw new IllegalStateException("font manager is disposed");

		if (i_font == null)
			throw new NullPointerException("i_font must not be null");

		GLFontKey key = new GLFontKey(i_font, i_startChar, i_endChar);
		JoglFont glFont = m_fonts.get(key);
		if (glFont == null) {
			glFont = new JoglFont(i_font, i_startChar, i_endChar, gl);
			m_fonts.put(key, glFont);
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
		for (Iterator<JoglFont> iter = m_fonts.values().iterator(); iter
				.hasNext();) {
			JoglFont glFont = iter.next();

			builder.append("Font: ");
			builder.append(glFont.toString());
			if (iter.hasNext())
				builder.append(", ");
		}
		builder.append("]");

		return builder.toString();
	}
}
