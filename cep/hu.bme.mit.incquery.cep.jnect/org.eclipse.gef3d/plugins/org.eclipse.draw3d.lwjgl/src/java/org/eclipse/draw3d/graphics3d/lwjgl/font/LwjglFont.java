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

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.draw3d.geometry.IMatrix4f;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.graphics3d.DisplayListManager;
import org.eclipse.draw3d.util.Draw3DCache;
import org.eclipse.draw3d.util.converter.ColorBufferInfo;
import org.eclipse.draw3d.util.converter.ImageConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.lwjgl.opengl.GL11;

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
 * @author Kristian Duske
 * @version $Revision$
 * @since 09.06.2008
 */
public class LwjglFont {

	// @SuppressWarnings("unused")
	private static final Logger log =
		Logger.getLogger(LwjglFont.class.getName());

	private LwjglFontChar[] m_chars;

	private final String m_description;

	private boolean m_disposed = false;

	private final char m_endChar;

	private FontMetrics m_fontMetrics;

	private DisplayListManager m_displayListManager;

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
	 * Creates a new GL font for the given SWT font that can render the
	 * characters defined by the given character range.
	 * 
	 * @param i_font the SWT font to render
	 * @param i_startChar the first available character
	 * @param i_endChar the last available character
	 * @param i_antiAliased whether or not the font should be rendered with
	 *            antialiasing
	 * @param i_displayListManager the display list manager
	 * @throws NullPointerException if the given font is <code>null</code>
	 */
	public LwjglFont(Font i_font, char i_startChar, char i_endChar,
			boolean i_antiAliased, DisplayListManager i_displayListManager) {

		if (i_font == null)
			throw new NullPointerException("i_font must not be null");

		if (i_displayListManager == null)
			throw new NullPointerException(
				"i_displayListManager must not be null");

		m_displayListManager = i_displayListManager;

		m_displayListManager.interruptDisplayList();
		try {
			m_startChar = i_startChar;
			m_endChar = i_endChar;

			int numChars = m_endChar - m_startChar + 1;
			m_chars = new LwjglFontChar[numChars];

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

					m_chars[i] = new LwjglFontChar(c, cExtent.x, height);
					area += (cExtent.x + 1) * (height + 1);
				}

				// calculate the texture dimensions needed to hold all
				// characters
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

				gc.setTextAntialias(i_antiAliased ? SWT.ON : SWT.OFF);
				gc.setFont(i_font);
				gc.setForeground(device.getSystemColor(SWT.COLOR_BLACK));
				gc.setBackground(device.getSystemColor(SWT.COLOR_WHITE));
				gc.fillRectangle(image.getBounds());

				// fill the image with the available characters
				int x = 0;
				int y = 0;
				for (int i = 0; i < numChars; i++) {

					LwjglFontChar fontChar = m_chars[i];
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
				ColorBufferInfo info =
					new ColorBufferInfo(m_width, m_height, GL11.GL_LUMINANCE_ALPHA,
						GL11.GL_UNSIGNED_BYTE, 1);

				ImageConverter converter = ImageConverter.getInstance();
				ByteBuffer buffer =
					converter.imageToBuffer(image, info, null, false);

				GL11.glPushAttrib(GL11.GL_TEXTURE_BIT);
				try {
					IntBuffer intBuf = Draw3DCache.getIntBuffer(1);
					try {
						GL11.glGenTextures(intBuf);
						m_textureId = intBuf.get(0);

						GL11.glBindTexture(GL11.GL_TEXTURE_2D, m_textureId);
						GL11.glTexParameteri(GL11.GL_TEXTURE_2D,
							GL11.GL_TEXTURE_WRAP_S, GL11.GL_REPEAT);
						GL11.glTexParameteri(GL11.GL_TEXTURE_2D,
							GL11.GL_TEXTURE_WRAP_T, GL11.GL_REPEAT);
						GL11.glTexParameteri(GL11.GL_TEXTURE_2D,
							GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
						GL11.glTexParameteri(GL11.GL_TEXTURE_2D,
							GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
						GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0,
							GL11.GL_LUMINANCE_ALPHA, m_width, m_height, 0,
							GL11.GL_LUMINANCE_ALPHA, GL11.GL_UNSIGNED_BYTE,
							buffer);

						// GLU.gluBuild2DMipmaps(m_textureId, 2, m_width,
						// m_height,
						// GL11.GL_LUMINANCE_ALPHA, GL11.GL_UNSIGNED_BYTE,
						// buffer);

						// generate a display list for each available character
						Map<Object, Runnable> requests =
							new HashMap<Object, Runnable>(m_chars.length);
						for (final LwjglFontChar c : m_chars) {
							requests.put(c, new Runnable() {
								public void run() {
									c.render();
								}
							});
						}

						m_displayListManager.createDisplayLists(requests);
					} finally {
						Draw3DCache.returnIntBuffer(intBuf);
					}
				} finally {
					GL11.glPopAttrib();
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

			builder.append(", Antialiasing: ");
			builder.append(i_antiAliased);

			m_description = builder.toString();
		} finally {
			m_displayListManager.resumeDisplayList();
		}
	}

	/**
	 * Disposes all ressources associated with this GL font.
	 */
	public void dispose() {

		if (m_disposed)
			return;

		if (log.isLoggable(Level.FINE))
			log.fine("disposing font " + this);

		if (m_textureId != -1) {
			IntBuffer intBuf = Draw3DCache.getIntBuffer(1);
			try {
				intBuf.put(0, m_textureId);
				intBuf.rewind();

				GL11.glDeleteTextures(intBuf);
				m_textureId = -1;
			} finally {
				Draw3DCache.returnIntBuffer(intBuf);
			}
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
					LwjglFontChar fontChar = m_chars[index];
					extent.x += fontChar.getWidth();
				}
				break;
			}
		}

		return extent;
	}

	/**
	 * Returns the texture ID of this font.
	 * 
	 * @return the texture ID
	 */
	public int getTextureId() {

		if (m_disposed)
			throw new IllegalStateException("font is disposed");

		return m_textureId;
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
	 * Returns the number characters that are actually rendered in the given
	 * string.
	 * 
	 * @param i_string the string to measure
	 * @return the length of the string
	 * @throws NullPointerException if the given string is <code>null</code>
	 */
	public int getLength(String i_string) {

		if (i_string == null)
			throw new NullPointerException("i_string must not be null");

		int length = 0;
		for (int i = 0; i < i_string.length(); i++) {
			char c = i_string.charAt(i);

			int index = c - m_startChar;
			if (index >= 0 && index < m_chars.length)
				length++;
		}

		return length;
	}

	/**
	 * Render the given string at the given coordinates. The characters are not
	 * rendered directly, but their vertex and texture coordinates are put into
	 * the given buffers.
	 * 
	 * @param i_string the string to render
	 * @param i_transformation the transformation to apply to the vertices, can
	 *            be <code>null</code>
	 * @param i_x the X coordinate
	 * @param i_y the Y coordinate
	 * @param i_expand specifies whether newline and tab characters should be
	 *            expanded
	 * @param i_vertexBuffer the vertex buffer
	 * @param i_coordBuffer the texture coordinate buffer
	 * @throws IllegalStateException if this GL font is disposed
	 * @throws NullPointerException if the given string is <code>null</code>
	 */
	public void renderString(String i_string, IMatrix4f i_transformation,
		int i_x, int i_y, boolean i_expand, FloatBuffer i_vertexBuffer,
		FloatBuffer i_coordBuffer) {

		if (m_disposed)
			throw new IllegalStateException("font is disposed");

		if (i_string == null)
			throw new NullPointerException("i_string must not be null");

		Vector3f p = Draw3DCache.getVector3f();
		try {
			int x = i_x, y = i_y;
			int height = m_fontMetrics.getHeight();

			int line = 0;
			for (int i = 0; i < i_string.length(); i++) {
				char c = i_string.charAt(i);

				switch (c) {
				case '\t':
					if (i_expand)
						x += m_tabWidth;
					break;

				case '\n':
					if (i_expand)
						y += ++line * height;
					break;
				default:
					int index = c - m_startChar;
					if (index >= 0 && index < m_chars.length) {
						LwjglFontChar fontChar = m_chars[index];
						fontChar.render(i_transformation, x, y, i_vertexBuffer,
							i_coordBuffer);

						x += fontChar.getWidth();
					}
					break;
				}
			}
		} finally {
			Draw3DCache.returnVector3f(p);
		}
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

		GL11.glPushAttrib(GL11.GL_TEXTURE_BIT | GL11.GL_COLOR_BUFFER_BIT);
		try {
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, m_textureId);
			GL11.glTexEnvi(GL11.GL_TEXTURE_ENV, GL11.GL_TEXTURE_ENV_MODE,
				GL11.GL_BLEND);
			GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);

			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA,
				GL11.GL_ONE_MINUS_SRC_ALPHA);

			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glPushMatrix();
			try {
				GL11.glTranslatef(i_x, i_y, 0);

				int height = m_fontMetrics.getHeight();
				int line = 0;
				for (int i = 0; i < i_string.length(); i++) {
					char c = i_string.charAt(i);

					switch (c) {
					case '\t':
						if (i_expand)
							GL11.glTranslatef(m_tabWidth, 0, 0);
						break;

					case '\n':
						if (i_expand) {
							GL11.glPopMatrix();
							GL11.glPushMatrix();
							GL11.glTranslatef(i_x, i_y + (++line * height), 0);
						}
						break;
					default:
						int index = c - m_startChar;
						if (index >= 0 && index < m_chars.length) {
							LwjglFontChar fontChar = m_chars[index];
							m_displayListManager.executeDisplayList(fontChar);
							GL11.glTranslatef(fontChar.getWidth(), 0, 0);
						}
						break;
					}
				}
			} finally {
				GL11.glPopMatrix();
			}
		} finally {
			GL11.glPopAttrib();
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
