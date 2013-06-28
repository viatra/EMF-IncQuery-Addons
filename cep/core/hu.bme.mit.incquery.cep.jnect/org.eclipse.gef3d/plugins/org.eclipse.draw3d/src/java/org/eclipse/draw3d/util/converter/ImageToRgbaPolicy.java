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

import org.eclipse.draw3d.util.converter.ConversionPolicySpecs.ConversionDirection;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.RGB;

/**
 * A policy which converts SWT images to RGBA color buffers.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 19.12.2008
 */
public class ImageToRgbaPolicy extends ConversionPolicy {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.util.converter.ConversionPolicy#getSupportedDataTypes(org.eclipse.draw3d.util.converter.ConversionPolicySpecs.ConversionDirection)
	 */
	@Override
	protected int[] getSupportedDataTypes(ConversionDirection i_direction) {

		if (i_direction != ConversionDirection.IMAGE_TO_BUFFER)
			throw new IllegalArgumentException("conversion direction "
					+ i_direction + " not supported");

		return new int[] { GL_UNSIGNED_BYTE };
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.util.converter.ConversionPolicy#getSupportedDirections()
	 */
	@Override
	protected ConversionDirection[] getSupportedDirections() {

		return new ConversionDirection[] { ConversionDirection.IMAGE_TO_BUFFER };
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.util.converter.ConversionPolicy#getSupportedImageDepths(org.eclipse.draw3d.util.converter.ConversionPolicySpecs.ConversionDirection)
	 */
	@Override
	protected int[] getSupportedImageDepths(ConversionDirection i_direction) {

		if (i_direction != ConversionDirection.IMAGE_TO_BUFFER)
			throw new IllegalArgumentException("conversion direction "
					+ i_direction + " not supported");

		return new int[] { 24, 32 };
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.util.converter.ConversionPolicy#getSupportedPixelFormats(org.eclipse.draw3d.util.converter.ConversionPolicySpecs.ConversionDirection)
	 */
	@Override
	protected int[] getSupportedPixelFormats(ConversionDirection i_direction) {

		if (i_direction != ConversionDirection.IMAGE_TO_BUFFER)
			throw new IllegalArgumentException("conversion direction "
					+ i_direction + " not supported");

		return new int[] { GL_RGBA };
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.util.converter.ConversionPolicy#toBytes(int, int,
	 *      ImageData)
	 */
	@Override
	protected byte[] toBytes(int i_x, int i_y, ImageData i_imageData) {

		int pixel = i_imageData.getPixel(i_x, i_y);
		RGB rgb = i_imageData.palette.getRGB(pixel);
		byte[] rgba = new byte[] { (byte) rgb.red, (byte) rgb.green,
				(byte) rgb.blue, getAlpha(i_x, i_y, i_imageData) };

		return rgba;
	}
}
