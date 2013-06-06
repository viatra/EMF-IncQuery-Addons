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

package org.eclipse.draw3d.util.converter;

import static org.eclipse.draw3d.graphics3d.Graphics3DDraw.*;

import java.nio.ByteBuffer;

/**
 * Contains information about a color buffer.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 19.12.2008
 */
public class ColorBufferInfo {

	private int m_alignment;

	/**
	 * The number of bytes in one line of the buffer, with alignment. This is
	 * always greater or equal to m_bytesPerLine.
	 */
	private int m_bytesPerAlignedLine;

	/**
	 * The number of bytes needed for one line of the image stored in the
	 * buffer.
	 */
	private int m_bytesPerLine;

	private int m_bytesPerPixel;

	private int m_dataType;

	/**
	 * The width of the image stored in the buffer, in pixels.
	 */
	private int m_height;

	private int m_pixelFormat;

	/**
	 * The total size of the buffer, in bytes.
	 */
	private int m_size;

	/**
	 * The width of the image stored in the buffer, in pixels.
	 */
	private int m_width;

	/**
	 * Creates a new buffer info object.
	 * 
	 * @param i_width the width of the buffer, in pixels
	 * @param i_height the height of the buffer, in pixels
	 * @param i_pixelFormat the pixel format
	 * @param i_dataType the data type
	 * @param i_alignment the byte alignment
	 * @throws IllegalArgumentException if the given width, height or alignment
	 *             is not positive
	 */
	public ColorBufferInfo(int i_width, int i_height, int i_pixelFormat,
			int i_dataType, int i_alignment) {

		if (i_width <= 0 || i_height <= 0)
			throw new IllegalArgumentException(
				"width and height must be positive");

		if (i_alignment <= 0)
			throw new IllegalArgumentException("alignment must be positive");

		m_width = i_width;
		m_height = i_height;
		m_pixelFormat = i_pixelFormat;
		m_dataType = i_dataType;
		m_alignment = i_alignment;

		m_bytesPerPixel = getColorBpp(m_pixelFormat, m_dataType);
		m_bytesPerLine = m_width * m_bytesPerPixel;
		m_bytesPerAlignedLine =
			((m_bytesPerLine - 1) / m_alignment + 1) * m_alignment;
		m_size = m_bytesPerAlignedLine * m_height;
	}

	/**
	 * Returns the byte alignment of the buffer.
	 * 
	 * @return the byte alignment
	 */
	public int getAlignment() {

		return m_alignment;
	}

	/**
	 * Returns the number of bytes per aligned line.
	 * 
	 * @return the number of bytes per aligned line
	 */
	public int getBytesPerAlignedLine() {

		return m_bytesPerAlignedLine;
	}

	/**
	 * Returns the number of bytes needed for one line of pixels.
	 * 
	 * @return the number of bytes
	 */
	public int getBytesPerLine() {

		return m_bytesPerLine;
	}

	/**
	 * Returns the number of bytes per pixel as specified by the given pixel
	 * format and data type.
	 * 
	 * @param i_pixelFormat the pixel format
	 * @param i_dataType the data type
	 * @return the number of bytes per pixel
	 * @throws IllegalArgumentException if the given pixel format or the given
	 *             data type is not supported
	 */
	public int getColorBpp(int i_pixelFormat, int i_dataType) {

		int bpp;
		switch (i_pixelFormat) {
		case GL_COLOR_INDEX:
		case GL_RED:
		case GL_GREEN:
		case GL_BLUE:
		case GL_ALPHA:
		case GL_LUMINANCE:
		case GL_STENCIL_INDEX:
			bpp = 1;
			break;
		case GL_DEPTH_COMPONENT:
		case GL_LUMINANCE_ALPHA:
			bpp = 2;
			break;
		case GL_RGB:
		case GL_BGR:
			bpp = 3;
			break;
		case GL_RGBA:
		case GL_BGRA:
			bpp = 4;
			break;
		default:
			throw new IllegalArgumentException("unuspported pixel format: "
				+ i_pixelFormat);
		}

		switch (i_dataType) {
		case GL_UNSIGNED_BYTE_3_3_2:
		case GL_UNSIGNED_BYTE_2_3_3_REV:
			bpp = 1;
			break;
		case GL_UNSIGNED_SHORT_5_6_5:
		case GL_UNSIGNED_SHORT_5_6_5_REV:
		case GL_UNSIGNED_SHORT_4_4_4_4:
		case GL_UNSIGNED_SHORT_4_4_4_4_REV:
		case GL_UNSIGNED_SHORT_5_5_5_1:
		case GL_UNSIGNED_SHORT_1_5_5_5_REV:
			bpp = 2;
			break;
		case GL_UNSIGNED_INT_8_8_8_8:
		case GL_UNSIGNED_INT_8_8_8_8_REV:
		case GL_UNSIGNED_INT_10_10_10_2:
		case GL_UNSIGNED_INT_2_10_10_10_REV:
			bpp = 4;
			break;
		case GL_UNSIGNED_BYTE:
		case GL_BYTE:
			bpp *= 1;
			break;
		case GL_UNSIGNED_SHORT:
		case GL_SHORT:
			bpp *= 2;
			break;
		case GL_UNSIGNED_INT:
		case GL_INT:
		case GL_FLOAT:
			bpp *= 4;
			break;
		default:
			throw new IllegalArgumentException("unuspported data type: "
				+ i_dataType);
		}

		return bpp;
	}

	/**
	 * Returns the data type of the buffer.
	 * 
	 * @return the data type
	 */
	public int getDataType() {

		return m_dataType;
	}

	/**
	 * Returns the height, in pixels, of the buffer.
	 * 
	 * @return the height
	 */
	public int getHeight() {

		return m_height;
	}

	/**
	 * Returns the pixel format of the buffer.
	 * 
	 * @return the pixel format
	 */
	public int getPixelFormat() {

		return m_pixelFormat;
	}

	/**
	 * Returns the number of bytes remaining in this buffer before a new line
	 * must begin.
	 * 
	 * @param i_buffer the buffer to check
	 * @return the number of remaining bytes before a new line
	 */
	public int getRemainingBytes(ByteBuffer i_buffer) {

		int pos = i_buffer.position();
		int linePos = pos % m_bytesPerAlignedLine;
		return m_bytesPerLine - linePos;
	}

	/**
	 * Returns the total size of the buffer in bytes.
	 * 
	 * @return the size of the buffer in bytes
	 */
	public int getSize() {

		return m_size;
	}

	/**
	 * Returns the width, in pixels, of the buffer.
	 * 
	 * @return the width
	 */
	public int getWidth() {

		return m_width;
	}

	/**
	 * Puts the given bytes into the given buffer while taking into account the
	 * alignment.
	 * 
	 * @param i_bytes the bytes to put
	 * @param io_buffer the buffer to append to
	 */
	public void putAlignedBytes(byte[] i_bytes, ByteBuffer io_buffer) {

		int rem = getRemainingBytes(io_buffer);
		int len = Math.min(rem, i_bytes.length);
		io_buffer.put(i_bytes, 0, len);

		if (i_bytes.length > rem) {
			int pos = io_buffer.position();
			int skip = pos & m_alignment;
			io_buffer.position(pos + skip);

			int index = len;
			len = i_bytes.length - index + 1;
			io_buffer.put(i_bytes, index, len);
		}
	}
}
