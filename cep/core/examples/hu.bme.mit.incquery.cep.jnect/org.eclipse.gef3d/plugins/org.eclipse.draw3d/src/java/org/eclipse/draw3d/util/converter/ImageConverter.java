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

import java.io.File;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw3d.util.converter.ConversionPolicySpecs.ConversionDirection;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;

/**
 * Converts SWT images to color buffers and vice versa. Since there are a lot of
 * different formats to convert between, the actual conversion is handled by
 * conversion policies, which can be registered with this class. A number of
 * conversion policies is provided by Draw3D.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 19.12.2008
 */
public class ImageConverter {

	private static final ImageConverter INSTANCE = new ImageConverter();

	private Map<ConversionPolicySpecs, ConversionPolicy> m_policies = new HashMap<ConversionPolicySpecs, ConversionPolicy>();

	/**
	 * Returns the single instance.
	 * 
	 * @return the single instance
	 */
	public static ImageConverter getInstance() {

		return INSTANCE;
	}

	private ImageConverter() {

		registerPolicy(new ImageToRgbaPolicy());
		registerPolicy(new ImageToLuminanceAlphaPolicy());
	}

	public Image bufferToImage(ColorBufferInfo i_bufferInfo, ByteBuffer i_buffer,
			ImageInfo i_imageInfo) {

		if (i_bufferInfo == null)
			throw new NullPointerException("i_info must not be null");

		if (i_buffer == null)
			throw new NullPointerException("i_buffer must not be null");

		if (i_imageInfo == null)
			throw new NullPointerException("i_imageInfo must not be null");

		ConversionDirection direction = ConversionDirection.BUFFER_TO_IMAGE;
		int pixelFormat = i_bufferInfo.getPixelFormat();
		int dataType = i_bufferInfo.getDataType();

		int depth = i_imageInfo.getDepth();

		ConversionPolicySpecs specs = new ConversionPolicySpecs(direction,
				pixelFormat, dataType, depth);
		ConversionPolicy policy = m_policies.get(specs);

		if (policy == null)
			throw new IllegalArgumentException(
					"no conversion policy registered for " + specs);

		throw new UnsupportedOperationException();
	}

	/**
	 * Dump the given image data to a file. If the file already exists, it will
	 * be overwritten.
	 * 
	 * @param i_imageData the image data to dump
	 * @param i_directory the directory of the file, if <code>null</code>, the
	 *            user home directory is used
	 * @param i_fileName the file name, must not be blank
	 * @param i_fileType the file type, see ImageLoader
	 * @throws NullPointerException if the image data or file name is
	 *             <code>null</code>
	 * @throws IllegalArgumentException if the given directory does not exist
	 *             and cannot be created or if the given file name is blank or
	 *             if the file already exists and cannot be deleted
	 * @see ImageLoader#save(String, int)
	 */
	public void dump(ImageData i_imageData, String i_directory,
			String i_fileName, int i_fileType) {

		if (i_imageData == null)
			throw new NullPointerException("i_imageData must not be null");

		if (i_fileName == null)
			throw new NullPointerException("i_fileName must not be null");

		String fileName = i_fileName.trim();
		if (fileName.length() == 0)
			throw new IllegalArgumentException("invalid filename: "
					+ i_fileName);

		String directory = i_directory;
		if (directory == null)
			directory = System.getProperty("user.home");

		File dirFile = new File(directory);
		if (!dirFile.exists())
			if (!dirFile.mkdirs())
				throw new IllegalArgumentException(
						"could not create directory " + dirFile);

		File filePath = new File(dirFile, fileName);
		if (filePath.exists())
			if (!filePath.delete())
				throw new IllegalArgumentException("could not delete file "
						+ filePath);

		ImageLoader imageLoader = new ImageLoader();
		imageLoader.data = new ImageData[] { i_imageData };
		imageLoader.save(filePath.toString(), i_fileType);

	}

	/**
	 * Converts the given image into a color buffer with the properties
	 * specified by the given buffer info. Be aware that if the given target
	 * buffer is <code>null</code> or too small to fit the image data, a new one
	 * will be created.
	 * 
	 * @param i_image the image to convert
	 * @param i_info the buffer info
	 * @param io_buffer the target buffer, may be <code>null</code>
	 * @param i_flip specifies whether to flip the image vertically
	 * @return the converted image
	 * @throws NullPointerException if the given image or buffer info is
	 *             <code>null</code>
	 */
	public ByteBuffer imageToBuffer(Image i_image, ColorBufferInfo i_info,
			ByteBuffer io_buffer, boolean i_flip) {

		if (i_image == null)
			throw new NullPointerException("i_image must not be null");

		if (i_info == null)
			throw new NullPointerException("i_info must not be null");

		ConversionDirection direction = ConversionDirection.IMAGE_TO_BUFFER;
		int pixelFormat = i_info.getPixelFormat();
		int dataType = i_info.getDataType();

		ImageData imageData = i_image.getImageData();
		int depth = imageData.depth;

		ConversionPolicySpecs specs = new ConversionPolicySpecs(direction,
				pixelFormat, dataType, depth);
		ConversionPolicy policy = m_policies.get(specs);

		if (policy == null)
			throw new IllegalArgumentException(
					"no conversion policy registered for " + specs);

		return policy.toBuffer(i_info, imageData, io_buffer, i_flip);
	}

	/**
	 * Registers a conversion policy with this image converter. If a policy has
	 * already been registered for any of the conversions that the given policy
	 * supports, those will be overwritten.
	 * 
	 * @param i_policy the conversion policy to register
	 * @throws NullPointerException if any of the given arguments is
	 *             <code>null</code>
	 */
	public void registerPolicy(ConversionPolicy i_policy) {

		if (i_policy == null)
			throw new NullPointerException("i_policy must not be null");

		for (ConversionPolicySpecs spec : i_policy.getSpecs())
			m_policies.put(spec, i_policy);
	}
}
