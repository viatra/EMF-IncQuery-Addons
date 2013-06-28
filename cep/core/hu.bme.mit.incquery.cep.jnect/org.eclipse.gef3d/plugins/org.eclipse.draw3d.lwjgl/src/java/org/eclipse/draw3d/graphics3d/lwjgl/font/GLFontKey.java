package org.eclipse.draw3d.graphics3d.lwjgl.font;

import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;

/**
 * Key for the font map.
 * 
 * @author Kristian Duske
 * @version $Revision: 433 $
 * @since 10.06.2008
 */
public class GLFontKey {

	private int m_hashCode;

	/**
	 * Creates a new key for a given font and character range.
	 * 
	 * @param i_font the font
	 * @param i_startChar the start character
	 * @param i_endChar the end character
	 * @param i_antiAliased whether or not the font is antialiased
	 */
	public GLFontKey(Font i_font, char i_startChar, char i_endChar,
			boolean i_antiAliased) {

		m_hashCode = 17;
		m_hashCode = 37 * getFontHashCode(i_font);
		m_hashCode = 37 * m_hashCode + i_startChar;
		m_hashCode = 37 * m_hashCode + i_endChar;
		m_hashCode = 37 * m_hashCode + (i_antiAliased ? 1231 : 1237);
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

	private int getFontHashCode(Font i_font) {

		int result = 17;

		FontData[] fontData = i_font.getFontData();
		for (int i = 0; i < fontData.length; i++) {
			result = 37 * result + fontData[i].getName().hashCode();
			result = 37 * result + fontData[i].getLocale().hashCode();
			result =
				37 * result + new Integer(fontData[i].getHeight()).hashCode();
			result =
				37 * result + new Integer(fontData[i].getStyle()).hashCode();
		}

		return result;
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