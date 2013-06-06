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

/**
 * A conversion info object contains information about the kind of conversion a
 * policy provides.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 19.12.2008
 */
public class ConversionPolicySpecs {

	/**
	 * Specifies a conversion direction.
	 * 
	 * @author Kristian Duske
	 * @version $Revision$
	 * @since 19.12.2008
	 */
	public enum ConversionDirection {
		/**
		 * Convert a buffer to an image.
		 */
		BUFFER_TO_IMAGE,
		/**
		 * Convert an image to a buffer.
		 */
		IMAGE_TO_BUFFER
	}

	private int m_bufferDataType;

	private int m_bufferPixelFormat;

	private ConversionDirection m_direction;

	private int m_hashCode;

	private int m_imageDepth;

	/**
	 * Creates a new conversion info object with the given parameters.
	 * 
	 * @param i_direction specifies the conversion direction
	 * @param i_bufferPixelFormat specifies the buffer pixel format
	 * @param i_bufferDataType specifies the buffer data type
	 * @param i_imageDepth sepcifies the image color depth
	 */
	public ConversionPolicySpecs(ConversionDirection i_direction,
			int i_bufferPixelFormat, int i_bufferDataType, int i_imageDepth) {

		if (i_direction == null)
			throw new NullPointerException("i_direction must not be null");

		m_direction = i_direction;
		m_bufferPixelFormat = i_bufferPixelFormat;
		m_bufferDataType = i_bufferDataType;

		m_imageDepth = i_imageDepth;

		m_hashCode = 17;
		m_hashCode = 37 * m_hashCode + m_direction.hashCode();
		m_hashCode = 37 * m_hashCode + m_bufferPixelFormat;
		m_hashCode = 37 * m_hashCode + m_bufferDataType;
		m_hashCode = 37 * m_hashCode + m_imageDepth;
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

		if (!(i_obj instanceof ConversionPolicySpecs))
			return false;

		ConversionPolicySpecs other = (ConversionPolicySpecs) i_obj;

		if (m_direction != other.m_direction)
			return false;

		if (m_bufferPixelFormat != other.m_bufferPixelFormat)
			return false;

		if (m_bufferDataType != other.m_bufferDataType)
			return false;

		return true;
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

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append("direction: ");
		builder.append(m_direction);
		builder.append(", pixel format: ");
		builder.append(m_bufferPixelFormat);
		builder.append(", data type: ");
		builder.append(m_bufferDataType);
		builder.append(", image depth: ");
		builder.append(m_imageDepth);

		return builder.toString();
	}
}