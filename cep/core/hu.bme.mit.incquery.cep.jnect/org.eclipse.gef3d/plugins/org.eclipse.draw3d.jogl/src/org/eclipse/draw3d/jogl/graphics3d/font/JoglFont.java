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

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.logging.Logger;

import org.eclipse.draw3d.util.Draw3DCache;
import org.eclipse.draw3d.util.converter.BufferInfo;
import org.eclipse.draw3d.util.converter.ImageConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import javax.media.opengl.GL;

/**
 * Allows rendering an SWT font in GL using textures. Expects the following
 * OpenGL state:
 * <ul>
 * <li>{@link GL11#GL_TEXTURE_2D} enabled</li>
 * <li>{@value GL11#GL_BLEND} enabled</li>
 * <li>{@link GL11#glBlendFunc(int, int)} with arguments
 * {@link GL11#GL_SRC_ALPHA}, {@link GL11#GL_ONE_MINUS_SRC_ALPHA}</li>
 * </ul>
 * The following state variables may be changed by this class:
 * <ul>
 * <li>{@link GL11#GL_POLYGON_MODE}</li>
 * </ul>
 * 
 * @author Madhu Samuel
 * @version $Revision$
 * @since 24.08.2009
 */
public class JoglFont {

	@SuppressWarnings("unused")
	private static final Logger log =
		Logger.getLogger(JoglFont.class.getName());

	private int m_baseListId = -1;

	private JoglFontChar[] m_chars;

	private final String m_description;

	private boolean m_disposed = false;

	private final char m_endChar;

	private FontMetrics m_fontMetrics;

	/**
	 * The height of the character texture.
	 */
	private int m_height;

	private final char m_startChar;

	private int m_tabWidth;

	private int m_textureId = -1;

	/**
	 * The width of the character texture.
	 */
	private int m_width;
	
	/**
	 * The gl instance
	 */
	private GL gl;

	/**
	 * Creates a new GL font for the given SWT font that can render the
	 * characters defined by the given character range.
	 * 
	 * @param i_font the SWT font to render
	 * @param i_startChar the first available character
	 * @param i_endChar the last available character
	 * @throws NullPointerException if the given font is <code>null</code>
	 */
	public JoglFont(Font i_font, char i_startChar, char i_endChar, GL gl) {
		
		if (gl == null)
			throw new NullPointerException("gl must not be null");
		
		if (i_font == null)
			throw new NullPointerException("i_font must not be null");
		
		this.gl = gl;

		m_startChar = i_startChar;
		m_endChar = i_endChar;

		int numChars = m_endChar - m_startChar + 1;
		m_chars = new JoglFontChar[numChars];

		Device device = i_font.getDevice();
		Image image = null;
		GC gc = null;
		try {
			image = new Image(device, 1, 1);
			gc = new GC(image);

			gc.setFont(i_font);
			m_fontMetrics = gc.getFontMetrics();

			m_tabWidth = gc.textExtent("\t").x;
			int height = m_fontMetrics.getHeight();

			// calculate the area needed to render all available characters
			long area = 0;
			for (int i = 0; i < numChars; i++) {

				char c = (char) (m_startChar + i);
				String s = Character.toString(c);
				Point cExtent = gc.stringExtent(s);

				m_chars[i] = new JoglFontChar(cExtent.x, height, gl);
				area += (cExtent.x + 1) * (height + 1);
			}

			// calculate the texture dimensions needed to hold all characters
			int sideLength = 64; // minimum texture size
			int textureArea = 0;
			while (textureArea < area) {
				sideLength *= 2;
				textureArea = sideLength * sideLength;
			}

			m_width = sideLength;
			m_height = sideLength;

			gc.dispose();
			image.dispose();

			// create and initialize the image and GC to draw the characters
			image = new Image(device, m_width, m_height);
			gc = new GC(image);

			gc.setFont(i_font);
			gc.setForeground(device.getSystemColor(SWT.COLOR_BLACK));
			gc.setBackground(device.getSystemColor(SWT.COLOR_WHITE));
			gc.fillRectangle(image.getBounds());

			// fill the image with the available characters
			int x = 0;
			int y = 0;
			for (int i = 0; i < numChars; i++) {

				JoglFontChar fontChar = m_chars[i];
				int w = fontChar.getWidth() + 1;

				if (x + w > m_width) {
					x = 0;
					y += height + 1;
				}

				char c = (char) (m_startChar + i);
				String s = Character.toString(c);
				gc.drawString(s, x, y);

				float s1 = (float) x / m_width;
				float t1 = (float) y / m_height;
				float s2 = (float) (x + fontChar.getWidth()) / m_width;
				float t2 = (float) (y + height) / m_height;
				fontChar.setTextureCoords(s1, t1, s2, t2);

				x += w;
			}

			// create a luminance alpha texture from the image
			BufferInfo info =
				new BufferInfo(m_width, m_height, GL.GL_LUMINANCE_ALPHA,
					GL.GL_UNSIGNED_BYTE, 1);

			ImageConverter converter = ImageConverter.getInstance();
			ByteBuffer buffer =
				converter.imageToBuffer(image, info, null, false);

			gl.glPushAttrib(GL.GL_TEXTURE_BIT);
			try {
				IntBuffer intBuf = Draw3DCache.getIntBuffer(1);
				try {
					//FIXME gl.glGenTextures(intBuf); is modifed as below - madhu
					gl.glGenTextures(1,intBuf);
					m_textureId = intBuf.get(0);

					gl.glBindTexture(GL.GL_TEXTURE_2D, m_textureId);
					gl.glTexParameteri(GL.GL_TEXTURE_2D,
						GL.GL_TEXTURE_WRAP_S, GL.GL_REPEAT);
					gl.glTexParameteri(GL.GL_TEXTURE_2D,
						GL.GL_TEXTURE_WRAP_T, GL.GL_REPEAT);
					gl.glTexParameteri(GL.GL_TEXTURE_2D,
						GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
					gl.glTexParameteri(GL.GL_TEXTURE_2D,
						GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
					gl.glTexImage2D(GL.GL_TEXTURE_2D, 0,
						GL.GL_LUMINANCE_ALPHA, m_width, m_height, 0,
						GL.GL_LUMINANCE_ALPHA, GL.GL_UNSIGNED_BYTE, buffer);

					// generate a display list for each available character
					m_baseListId = gl.glGenLists(numChars);
					for (int i = 0; i < m_chars.length; i++)
						m_chars[i].buildList(m_baseListId + i, m_width,
							m_height);
				} finally {
					Draw3DCache.returnIntBuffer(intBuf);
				}
			} finally {
				gl.glPopAttrib();
				gl.glBindTexture(GL.GL_TEXTURE_2D, 0);
			}
		} finally {
			if (gc != null && !gc.isDisposed())
				gc.dispose();
			if (image != null && !image.isDisposed())
				image.dispose();
		}

		FontData[] fontData = i_font.getFontData();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < fontData.length; i++) {
			builder.append(fontData[i].getName());

			int style = fontData[i].getStyle();
			if ((style & SWT.NORMAL) != 0)
				builder.append(" Normal");
			if ((style & SWT.ITALIC) != 0)
				builder.append(" Italic");
			if ((style & SWT.BOLD) != 0)
				builder.append(" Bold");

			builder.append(" ");
			builder.append(fontData[i].getHeight());

			if (i < fontData.length - 1)
				builder.append(", ");
		}

		m_description = builder.toString();
	}

	/**
	 * Disposes all ressources associated with this GL font.
	 */
	public void dispose() {

		if (m_disposed)
			return;

		if (m_textureId != -1) {
			IntBuffer intBuf = Draw3DCache.getIntBuffer(1);
			try {
				intBuf.put(0, m_textureId);
				//FIXME gl.glDeleteTextures(intBuf); is modifed as below - madhu
				gl.glDeleteTextures(1,intBuf);
				m_textureId = -1;
			} finally {
				Draw3DCache.returnIntBuffer(intBuf);
			}
		}

		if (m_baseListId != -1) {
			gl.glDeleteLists(m_baseListId, m_chars.length);
			m_baseListId = -1;
		}

		m_chars = null;
		m_disposed = true;
	}

	/**
	 * Measues the extent of the given string.
	 * 
	 * @param i_string the string to measure
	 * @param i_expand specifies whether newline and tab character should be
	 *            expanded
	 * @return a point indicating the measured extent
	 * @throws IllegalStateException if this GL font is disposed
	 * @throws NullPointerException if the given string is <code>null</code>
	 */
	public Point getExtent(String i_string, boolean i_expand) {

		if (m_disposed)
			throw new IllegalStateException("font is disposed");

		if (i_string == null)
			throw new NullPointerException("i_string must not be null");

		int height = m_fontMetrics.getHeight();
		Point extent = new Point(0, height);

		for (int i = 0; i < i_string.length(); i++) {
			char c = i_string.charAt(i);

			switch (c) {
			case '\t':
				if (i_expand)
					extent.x += m_tabWidth;
				break;

			case '\n':
				if (i_expand)
					extent.y += height;
				break;
			default:
				int index = c - m_startChar;
				if (index >= 0 && index < m_chars.length) {
					JoglFontChar fontChar = m_chars[index];
					extent.x += fontChar.getWidth();
				}
				break;
			}
		}

		return extent;
	}

	/**
	 * Returns the font metrics of this font.
	 * 
	 * @return the font metrics
	 * @throws IllegalStateException if this font is disposed
	 */
	public FontMetrics getFontMetrics() {

		if (m_disposed)
			throw new IllegalStateException("font is disposed");

		return m_fontMetrics;
	}

	/**
	 * Render the given string at the given coordinates.
	 * 
	 * @param i_string the string to render
	 * @param i_x the coordinate
	 * @param i_y the y coordinate
	 * @param i_expand specifies whether newline and tab character should be
	 *            expanded
	 * @throws IllegalStateException if this GL font is disposed
	 * @throws NullPointerException if the given string is <code>null</code>
	 */
	public void renderString(String i_string, int i_x, int i_y, boolean i_expand) {

		if (m_disposed)
			throw new IllegalStateException("font is disposed");

		if (i_string == null)
			throw new NullPointerException("i_string must not be null");

		IntBuffer intBuf = Draw3DCache.getIntBuffer(16);
		try {
			intBuf.rewind();
			gl.glGetIntegerv(GL.GL_TEXTURE_BINDING_2D, intBuf);
			int currentTexture = intBuf.get(0);

			gl.glPushAttrib(GL.GL_TEXTURE_BIT);
			try {
				gl.glBindTexture(GL.GL_TEXTURE_2D, m_textureId);
				gl.glTexEnvi(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE,
					GL.GL_BLEND);
				gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL.GL_FILL);

				gl.glMatrixMode(GL.GL_MODELVIEW);
				gl.glPushMatrix();
				try {
					gl.glTranslatef(i_x, i_y, 0);

					int height = m_fontMetrics.getHeight();
					int line = 0;
					for (int i = 0; i < i_string.length(); i++) {
						char c = i_string.charAt(i);

						switch (c) {
						case '\t':
							if (i_expand)
								gl.glTranslatef(m_tabWidth, 0, 0);
							break;

						case '\n':
							if (i_expand) {
								gl.glPopMatrix();
								gl.glPushMatrix();
								gl.glTranslatef(i_x, i_y + (++line * height),
									0);
							}
							break;
						default:
							int index = c - m_startChar;
							if (index >= 0 && index < m_chars.length) {
								JoglFontChar fontChar = m_chars[index];
								gl.glCallList(fontChar.getListId());
								gl.glTranslatef(fontChar.getWidth(), 0, 0);
							}
							break;
						}
					}
				} finally {
					gl.glPopMatrix();
				}
			} finally {
				gl.glPopAttrib();
				if (currentTexture != m_textureId)
					gl.glBindTexture(GL.GL_TEXTURE_2D, currentTexture);
			}
		} finally {
			Draw3DCache.returnIntBuffer(intBuf);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return m_description;
	}
}
