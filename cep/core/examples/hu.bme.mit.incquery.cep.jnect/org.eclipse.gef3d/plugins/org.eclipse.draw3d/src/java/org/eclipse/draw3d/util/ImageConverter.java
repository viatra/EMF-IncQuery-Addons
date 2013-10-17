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
package org.eclipse.draw3d.util;

import java.nio.ByteBuffer;

import org.eclipse.core.runtime.Platform;
import org.eclipse.draw3d.graphics3d.Graphics3DDraw;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.Rectangle;

/**
 * Converts images and textures.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 08.05.2008
 */
public class ImageConverter {

	/**
	 * Specifications for converting an image to a byte buffer.
	 * 
	 * @author Kristian Duske
	 * @version $Revision$
	 * @since 08.06.2008
	 * @see $HeadURL:
	 *      https://gorgo.fernuni-hagen.de/OpenglGEF/trunk/org.eclipse.draw3d
	 *      /src/java/de/feu/draw3d/util/ImageConverter.java $
	 */
	public static class ConversionSpecs {

		/**
		 * The background alpha value.
		 */
		public int backgroundAlpha;

		/**
		 * The background color.
		 */
		public Color backgroundColor;

		/**
		 * The clipping rectangle (may be <code>null</code>).
		 */
		public Rectangle clip;

		/**
		 * Flip the texture along the X axis.
		 */
		public boolean flip = false;

		/**
		 * The foreground alpha value.
		 */
		public int foregroundAlpha;

		/**
		 * The height of the resulting texture.
		 */
		public int textureHeight;

		/**
		 * The width of the resulting texture.
		 */
		public int textureWidth;

		/**
		 * The color that is interpreted as transparent.
		 */
		public Color transparentColor;
	}

	private static final int A = 3;

	private static final int B = 2;

	private static final int G = 1;

	/**
	 * Position of the blue color component in image data buffers.
	 */
	private static final int POS_B;
//	= (RenderContext.getContext()
//			.getGraphics3D().getPlatform() == Graphics3DDraw.PLATFORM_WINDOWS) ? 0
//			: 3;

	/**
	 * Position of the green color component in image data buffers.
	 */
	private static final int POS_G;
//	= (RenderContext.getContext()
//			.getGraphics3D().getPlatform() == Graphics3DDraw.PLATFORM_WINDOWS) ? 1
//			: 2;

	/**
	 * Position of the red color component in image data buffers.
	 */
	private static final int POS_R;
//	= (RenderContext.getContext()
//			.getGraphics3D().getPlatform() == Graphics3DDraw.PLATFORM_WINDOWS) ? 2
//			: 1;
	
	static {
		if (Platform.getOS().startsWith("Windows")) {
			POS_B = 0;
			POS_G = 1;
			POS_R = 2;
		} else {
			POS_B = 3;
			POS_G = 2;
			POS_R = 1;
		}
	}

	private static final int R = 0;

	/**
	 * Converts the given color buffer to an SWT image data object.
	 * 
	 * @param i_buffer the buffer to convert
	 * @param i_pixelFormat the pixel format of the given buffer
	 * @param i_dataType the data type of the given buffer
	 * @param i_width the width, in pixels, of the given buffer
	 * @param i_height the height, in pixels, of the given buffer
	 * @return an SWT image data object representing the given buffer
	 */
	public static ImageData colorBufferToImage(ByteBuffer i_buffer,
			int i_pixelFormat, int i_dataType, int i_width, int i_height) {

		if (i_buffer == null)
			throw new NullPointerException("i_buffer must not be null");

		int bpp = getColorBpp(i_pixelFormat, i_dataType);
		int[] offsets = getOffsets(i_pixelFormat, i_dataType);

		int size = i_width * i_height;
		int imageSize = size * 3; // SWT image contains RGB

		PaletteData palette = new PaletteData(0xFF0000, 0x00FF00, 0x0000FF);
		byte[] data = new byte[imageSize];

		ImageData imageData = new ImageData(i_width, i_height, 24, palette, 1,
				data);

		byte[] alpha = null;
		if (offsets[A] != -1) {
			alpha = new byte[size];
			imageData.alphaData = alpha;
		}

		for (int y = 0; y < i_height; y++) {
			for (int x = 0; x < i_width; x++) {
				int sIndex = ((i_height - y - 1) * i_width + x) * bpp;
				int dIndex = (y * i_width + x) * 3;
				int aIndex = y * i_width + x;

				if (offsets[R] != -1)
					data[dIndex + R] = i_buffer.get(sIndex + offsets[R]);

				if (offsets[G] != -1)
					data[dIndex + G] = i_buffer.get(sIndex + offsets[G]);

				if (offsets[B] != -1)
					data[dIndex + B] = i_buffer.get(sIndex + offsets[B]);

				if (offsets[A] != -1 && alpha != null)
					alpha[aIndex] = i_buffer.get(sIndex + offsets[A]);
			}
		}

		return imageData;
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
	public static int getColorBpp(int i_pixelFormat, int i_dataType) {

		int bpp;
		switch (i_pixelFormat) {
		case Graphics3DDraw.GL_COLOR_INDEX:
		case Graphics3DDraw.GL_RED:
		case Graphics3DDraw.GL_GREEN:
		case Graphics3DDraw.GL_BLUE:
		case Graphics3DDraw.GL_ALPHA:
		case Graphics3DDraw.GL_LUMINANCE:
		case Graphics3DDraw.GL_STENCIL_INDEX:
			bpp = 1;
			break;
		case Graphics3DDraw.GL_DEPTH_COMPONENT:
		case Graphics3DDraw.GL_LUMINANCE_ALPHA:
			bpp = 2;
			break;
		case Graphics3DDraw.GL_RGB:
		case Graphics3DDraw.GL_BGR:
			bpp = 3;
			break;
		case Graphics3DDraw.GL_RGBA:
		case Graphics3DDraw.GL_BGRA:
			bpp = 4;
			break;
		default:
			throw new IllegalArgumentException("unuspported pixel format: "
					+ i_pixelFormat);
		}

		switch (i_dataType) {
		case Graphics3DDraw.GL_UNSIGNED_BYTE_3_3_2:
		case Graphics3DDraw.GL_UNSIGNED_BYTE_2_3_3_REV:
			bpp = 1;
			break;
		case Graphics3DDraw.GL_UNSIGNED_SHORT_5_6_5:
		case Graphics3DDraw.GL_UNSIGNED_SHORT_5_6_5_REV:
		case Graphics3DDraw.GL_UNSIGNED_SHORT_4_4_4_4:
		case Graphics3DDraw.GL_UNSIGNED_SHORT_4_4_4_4_REV:
		case Graphics3DDraw.GL_UNSIGNED_SHORT_5_5_5_1:
		case Graphics3DDraw.GL_UNSIGNED_SHORT_1_5_5_5_REV:
			bpp = 2;
			break;
		case Graphics3DDraw.GL_UNSIGNED_INT_8_8_8_8:
		case Graphics3DDraw.GL_UNSIGNED_INT_8_8_8_8_REV:
		case Graphics3DDraw.GL_UNSIGNED_INT_10_10_10_2:
		case Graphics3DDraw.GL_UNSIGNED_INT_2_10_10_10_REV:
			bpp = 4;
			break;
		case Graphics3DDraw.GL_UNSIGNED_BYTE:
		case Graphics3DDraw.GL_BYTE:
			bpp *= 1;
			break;
		case Graphics3DDraw.GL_UNSIGNED_SHORT:
		case Graphics3DDraw.GL_SHORT:
			bpp *= 2;
			break;
		case Graphics3DDraw.GL_UNSIGNED_INT:
		case Graphics3DDraw.GL_INT:
		case Graphics3DDraw.GL_FLOAT:
			bpp *= 4;
			break;
		default:
			throw new IllegalArgumentException("unuspported data type: "
					+ i_dataType);
		}

		return bpp;
	}

	/**
	 * Returns the byte offsets of the RGBA values for the given pixel format
	 * and data type. If a value is not present in the given pixel format, its
	 * byte offset is -1.
	 * 
	 * @param i_pixelFormat the pixel format
	 * @param i_dataType the data type
	 * @return an array containing the byte offsets for the RGBA values.
	 * @throws IllegalArgumentException if the given pixel format or the given
	 *             data type is not supported
	 */
	public static int[] getOffsets(int i_pixelFormat, int i_dataType) {

		int r, g, b, a;
		switch (i_pixelFormat) {
		case Graphics3DDraw.GL_RGB:
			r = 0;
			g = 1;
			b = 2;
			a = -1;
			break;
		case Graphics3DDraw.GL_BGR:
			r = 2;
			g = 1;
			b = 0;
			a = -1;
			break;
		case Graphics3DDraw.GL_RGBA:
			r = 0;
			g = 1;
			b = 2;
			a = 3;
			break;
		case Graphics3DDraw.GL_BGRA:
			r = 2;
			g = 1;
			b = 0;
			a = 3;
			break;
		default:
			throw new IllegalArgumentException("unsupported pixel format: "
					+ i_pixelFormat);
		}

		switch (i_dataType) {
		case Graphics3DDraw.GL_UNSIGNED_BYTE:
			break;

		default:
			throw new IllegalArgumentException("unsupported data type: "
					+ i_dataType);
		}

		r = Math.max(r, -1);
		g = Math.max(g, -1);
		b = Math.max(b, -1);
		a = Math.max(a, -1);

		return new int[] { r, g, b, a };
	}

	/**
	 * Converts a given image to a byte buffer that can be uploaded as an OpenGL
	 * texture. The pixel format of resulting buffer is
	 * {@link Graphics3DDraw#GL_RGBA} and the data format is
	 * {@link Graphics3DDraw#GL_UNSIGNED_BYTE}.<br>
	 * If the given buffer is <code>null</code> or not large enough for the
	 * given texture dimensions, a new buffer is created.
	 * 
	 * @param i_image the image to convert
	 * @param i_specs the conversion specifications
	 * @param io_buffer the result buffer
	 * @return the result buffer
	 * @deprecated use {@link ImageConverter}
	 */
	@Deprecated
	public static ByteBuffer imageToColorBuffer(Image i_image,
			ConversionSpecs i_specs, ByteBuffer io_buffer) {

		if (i_image == null)
			throw new NullPointerException("i_image must not be null");

		if (i_specs == null)
			throw new NullPointerException("i_specs must not be null");

		Rectangle iBounds = i_image.getBounds();
		int iWidth = iBounds.width;
		int iHeight = iBounds.height;

		Rectangle clip = i_specs.clip;
		if (clip == null)
			clip = iBounds;
		else {
			if (clip.x > iWidth || clip.y > iHeight)
				throw new IllegalArgumentException(
						"clip region is outside of image bounds");

			if (clip.x + clip.width > iWidth)
				clip.width = iWidth - clip.x;

			if (clip.y + clip.height > iHeight)
				clip.height = iHeight - clip.y;
		}

		int tWidth = i_specs.textureWidth;
		int tHeight = i_specs.textureHeight;

		if (tWidth < clip.width || tHeight < clip.height)
			throw new IllegalArgumentException(
					"texture dimensions are too small for clip region");

		Color trColor = i_specs.transparentColor;
		Color bgColor = i_specs.backgroundColor;

		int bgAlpha = i_specs.backgroundAlpha;

		ImageData imageData = i_image.getImageData();

		int srcFormat = imageData.depth / 8;
		int dstFormat = 4; // texture contains RGBA data

		int size = tWidth * tHeight * dstFormat;

		ByteBuffer buffer = io_buffer;
		if (buffer == null || size > buffer.capacity())
			buffer = BufferUtils.createByteBuffer(size);
		else if (size < buffer.capacity())
			buffer.limit(size);

		final byte trR = trColor != null ? (byte) trColor.getRed() : 0;
		final byte trG = trColor != null ? (byte) trColor.getGreen() : 0;
		final byte trB = trColor != null ? (byte) trColor.getBlue() : 0;

		final byte bgR = bgColor != null ? (byte) bgColor.getRed() : 0;
		final byte bgG = bgColor != null ? (byte) bgColor.getGreen() : 0;
		final byte bgB = bgColor != null ? (byte) bgColor.getBlue() : 0;

		final byte bgAlphaByte = (byte) bgAlpha;

		for (int y = 0; y < tHeight; y++) {
			for (int x = 0; x < tWidth; x++) {
				if (x < clip.width && y < clip.height) {

					int index;
					if (i_specs.flip)
						index = ((iHeight - clip.y - y - 1) * iWidth + clip.x + x);
					else
						index = ((clip.y + y) * iWidth + clip.x + x);

					byte r = imageData.data[index * srcFormat + POS_R];
					byte g = imageData.data[index * srcFormat + POS_G];
					byte b = imageData.data[index * srcFormat + POS_B];
					byte a = imageData.alphaData[index];

					if (trColor != null && bgColor != null && r == trR
							&& g == trG && b == trB) {
						r = bgR;
						g = bgG;
						b = bgB;
						a = bgAlphaByte;
					}

					buffer.put(r);
					buffer.put(g);
					buffer.put(b);
					buffer.put(a);
				} else {
					// the texture is possibly larger than the image, paint the
					// remaining areas
					buffer.put(bgR);
					buffer.put(bgG);
					buffer.put(bgB);
					buffer.put(bgAlphaByte);
				}
			}
		}

		buffer.rewind();
		return buffer;
	}

	/**
	 * Converts a given image to a byte buffer that can be uploaded as an OpenGL
	 * luminance alpha texture. The pixel format of resulting buffer is
	 * {@link Graphics3DDraw#GL_LUMINANCE_ALPHA} and the data format is
	 * {@link Graphics3DDraw#GL_UNSIGNED_BYTE}.<br>
	 * If the given buffer is <code>null</code> or not large enough for the
	 * given texture dimensions, a new buffer is created.
	 * 
	 * @param i_image the image to convert
	 * @param i_specs the conversion specifications
	 * @param io_buffer the result buffer
	 * @return the result buffer
	 * @deprecated use {@link ImageConverter}
	 */
	@Deprecated
	public static ByteBuffer imageToLuminanceAlphaBuffer(Image i_image,
			ConversionSpecs i_specs, ByteBuffer io_buffer) {

		if (i_image == null)
			throw new NullPointerException("i_image must not be null");

		if (i_specs == null)
			throw new NullPointerException("i_specs must not be null");

		Rectangle iBounds = i_image.getBounds();
		int iWidth = iBounds.width;
		int iHeight = iBounds.height;

		Rectangle clip = i_specs.clip;
		if (clip == null)
			clip = iBounds;
		else {
			if (clip.x > iWidth || clip.y > iHeight)
				throw new IllegalArgumentException(
						"clip region is outside of image bounds");

			if (clip.x + clip.width > iWidth)
				clip.width = iWidth - clip.x;

			if (clip.y + clip.height > iHeight)
				clip.height = iHeight - clip.y;
		}

		int tWidth = i_specs.textureWidth;
		int tHeight = i_specs.textureHeight;

		if (tWidth < clip.width || tHeight < clip.height)
			throw new IllegalArgumentException(
					"texture dimensions are too small for clip region");

		ImageData imageData = i_image.getImageData();

		int srcFormat = imageData.depth / 8;
		int dstFormat = 2; // texture contains Luminanca / Alpha data

		int size = tWidth * tHeight * dstFormat;

		ByteBuffer buffer = io_buffer;
		if (buffer == null || size > buffer.capacity())
			buffer = BufferUtils.createByteBuffer(size);
		else if (size < buffer.capacity())
			buffer.limit(size);

		byte bg = (byte) 0;
		for (int y = 0; y < tHeight; y++) {
			for (int x = 0; x < tWidth; x++) {
				if (x < clip.width && y < clip.height) {
					int index = ((clip.y + y) * iWidth + clip.x + x)
							* srcFormat;

					int r = imageData.data[index + POS_R];
					int g = imageData.data[index + POS_G];
					int b = imageData.data[index + POS_B];

					byte l = (byte) Math.round((r + g + b) / 3d);
					byte a = (byte) (255 - l);

					buffer.put(l);
					buffer.put(a);
				} else {
					// the texture is possibly larger than the image, paint the
					// remaining areas
					buffer.put(bg);
					buffer.put(bg);
				}
			}
		}

		buffer.rewind();
		return buffer;
	}
}
