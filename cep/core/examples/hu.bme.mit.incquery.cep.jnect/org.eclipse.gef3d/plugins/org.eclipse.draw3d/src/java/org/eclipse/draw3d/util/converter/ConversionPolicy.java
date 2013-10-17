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

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw3d.util.BufferUtils;
import org.eclipse.draw3d.util.converter.ConversionPolicySpecs.ConversionDirection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.ImageData;

/**
 * Abstract base class for all conversion policies.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 19.12.2008
 */
public abstract class ConversionPolicy {

	private ConversionPolicySpecs[] m_specs;

	private ConversionPolicySpecs[] createSpecs() {

		List<ConversionPolicySpecs> specs = new ArrayList<ConversionPolicySpecs>();
		ConversionDirection[] directions = getSupportedDirections();

		for (ConversionDirection direction : directions) {
			int[] pixelFormats = getSupportedPixelFormats(direction);
			int[] dataTypes = getSupportedDataTypes(direction);
			int[] imageDepths = getSupportedImageDepths(direction);

			for (int pixelFormat : pixelFormats)
				for (int dataType : dataTypes)
					for (int imageDepth : imageDepths)
						specs.add(new ConversionPolicySpecs(direction,
								pixelFormat, dataType, imageDepth));
		}

		return specs.toArray(new ConversionPolicySpecs[specs.size()]);
	}

	/**
	 * Returns the alpha value for the pixel at the given coordinates. If the
	 * image has neither alpha or transparency data associated with it, 0xFF is
	 * returned.
	 * 
	 * @param i_x the X coordinate
	 * @param i_y the Y coordinate
	 * @param i_imageData the image
	 * @return the alpha value
	 */
	protected byte getAlpha(int i_x, int i_y, ImageData i_imageData) {

		if (i_imageData.alpha != -1)
			return (byte) i_imageData.alpha;

		switch (i_imageData.getTransparencyType()) {
		case SWT.TRANSPARENCY_MASK:
			int width = i_imageData.width;
			int maskPad = i_imageData.maskPad;

			// bytes per scanline, see ImageData#maskData
			int bpl = ((width + 7) / 8 + (maskPad - 1)) / maskPad * maskPad;
			int index = i_y * bpl + i_x / 8;
			int offset = 7 - (i_x % 8); // mask data is msb first

			byte b = i_imageData.maskData[index];
			int i = (b >>> offset) & 1;
			if (i == 0)
				return 0x00;

			break;
		case SWT.TRANSPARENCY_PIXEL:
			if (i_imageData.getPixel(i_x, i_y) == i_imageData.transparentPixel)
				return 0x00;
			break;
		case SWT.TRANSPARENCY_ALPHA:
			return (byte) i_imageData.getAlpha(i_x, i_y);
		}

		return (byte) 0xFF;
	}

	private ByteBuffer getByteBuffer(ColorBufferInfo i_info, ByteBuffer io_buffer) {

		ByteBuffer buf = io_buffer;

		int size = i_info.getSize();
		if (buf == null || size > buf.capacity())
			buf = BufferUtils.createByteBuffer(size);
		else if (size < buf.capacity())
			buf.limit(size);

		return buf;
	}

	/**
	 * Returns the conversion policy specifications supported by this policy.
	 * 
	 * @return an array containing at least one conversion policy specification
	 */
	public ConversionPolicySpecs[] getSpecs() {

		if (m_specs == null)
			m_specs = createSpecs();

		return m_specs;
	}

	/**
	 * Returns the data types supported by this policy for the given conversion
	 * direction.
	 * 
	 * @param i_direction the conversion direction
	 * @return an array containing the supported data types
	 */
	protected abstract int[] getSupportedDataTypes(
			ConversionDirection i_direction);

	/**
	 * Returns the conversion directions supported by this policy.
	 * 
	 * @return an array containing the supported conversion directions
	 */
	protected abstract ConversionDirection[] getSupportedDirections();

	/**
	 * Returns the image color depths depths supported by this policy for the
	 * given conversion direction.
	 * 
	 * @param i_direction the conversion direction
	 * @return an array containing the supported image color depths
	 */
	protected abstract int[] getSupportedImageDepths(
			ConversionDirection i_direction);

	/**
	 * Returns the pixel formats supported by this policy for the given
	 * conversion direction.
	 * 
	 * @param i_direction the conversion direction
	 * @return an array containing the supported pixel formats
	 */
	protected abstract int[] getSupportedPixelFormats(
			ConversionDirection i_direction);

	/**
	 * Indicates whether the given image data has alpha data associated with it.
	 * 
	 * @param i_imageData the image to check
	 * @return <code>true</code> if the given image has alpha data and
	 *         <code>false</code> otherwise
	 */
	protected boolean hasAlpha(ImageData i_imageData) {

		return i_imageData.alpha != -1 || i_imageData.alphaData != null;
	}

	/**
	 * Indicates whether the given image data has transparency data associated
	 * with it.
	 * 
	 * @param i_imageData the image to check
	 * @return <code>true</code> if the given image has transparency data and
	 *         <code>false</code> otherwise
	 * @throws NullPointerException if the given image data is <code>null</code>
	 */
	protected boolean hasTransparency(ImageData i_imageData) {

		if (i_imageData == null)
			throw new NullPointerException("i_imageData must not be null");

		return i_imageData.transparentPixel != -1
				|| i_imageData.maskData != null;
	}

	/**
	 * Indicates whether the pixel at the given coordiantes is marked as
	 * transparent in the transparency mask of the given image.
	 * 
	 * @param i_x the X coordinate
	 * @param i_y the Y coordiante
	 * @param i_imageData the image
	 * @return <code>true</code> if the pixel at the given coordinates is marked
	 *         as transparent and <code>false</code> otherwise
	 */
	protected boolean isMaskedTransparent(int i_x, int i_y,
			ImageData i_imageData) {

		int width = i_imageData.width;
		int maskPad = i_imageData.maskPad;

		// bytes per scanline, see ImageData#maskData
		int bpl = ((width + 7) / 8 + (maskPad - 1)) / maskPad * maskPad;
		int index = i_y * bpl + i_x;
		int offset = i_x % 8;

		byte b = i_imageData.maskData[index];
		return ((1 << offset) & b) != 0;
	}

	/**
	 * Converts the given image to a byte buffer and returns it. If the given
	 * result buffer is <code>null</code> or too small, a new one will be
	 * created and returned.
	 * 
	 * @param i_info contains information about the conversion to take place
	 * @param i_imageData the image to convert
	 * @param io_buffer the result buffer
	 * @param i_flip specifies whether to flip the image vertically
	 * @return the result buffer, need not be identical to io_buffer!
	 */
	public ByteBuffer toBuffer(ColorBufferInfo i_info, ImageData i_imageData,
			ByteBuffer io_buffer, boolean i_flip) {

		ByteBuffer buf = getByteBuffer(i_info, io_buffer);

		if (!i_flip)
			for (int y = 0; y < i_imageData.height; y++)
				for (int x = 0; x < i_imageData.width; x++)
					i_info.putAlignedBytes(toBytes(x, y, i_imageData), buf);
		else
			for (int y = i_imageData.height - 1; y >= 0; y--)
				for (int x = 0; x < i_imageData.width; x++)
					i_info.putAlignedBytes(toBytes(x, y, i_imageData), buf);

		buf.rewind();
		return buf;
	}

	/**
	 * Converts the pixel at the given coordinates and appends the resulting
	 * bytes to the given buffer.
	 * 
	 * @param i_x the X coordinate of the pixel
	 * @param i_y the Y coordiante of the pixel
	 * @param i_imageData the image data to read from
	 * @param o_buffer the buffer to write to
	 */
	protected abstract byte[] toBytes(int i_x, int i_y, ImageData i_imageData);


}
