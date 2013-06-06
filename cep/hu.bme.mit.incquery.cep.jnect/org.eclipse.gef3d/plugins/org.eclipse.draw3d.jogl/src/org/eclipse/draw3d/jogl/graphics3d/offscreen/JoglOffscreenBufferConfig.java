/*******************************************************************************
 * Copyright (c) 2009-2010 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 *    Madhu Samuel   - Implementation
 ******************************************************************************/
package org.eclipse.draw3d.jogl.graphics3d.offscreen;

import org.eclipse.draw3d.graphics3d.Graphics3D;
import org.eclipse.draw3d.graphics3d.Graphics3DDraw;
import org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBufferConfig;
import org.eclipse.draw3d.util.ImageConverter;

/**
 * Configures the available buffers for the offscreen renderer. Currently, only
 * the color and depth buffer are supported.
 * 
 * @author Madhu Samuel
 * @version $Revision$
 * @since 24.08.2009
 */
public class JoglOffscreenBufferConfig implements
		Graphics3DOffscreenBufferConfig {

	private static final int SUPPORTED_BUFFERS = Graphics3DDraw.GL_COLOR_BUFFER_BIT
			| Graphics3DDraw.GL_DEPTH_BUFFER_BIT;

	private final int m_buffers;

	private int m_colorBpp;

	private int m_colorDataType;

	private int m_colorPixelFormat;

	private int m_depthDataType;

	private Graphics3D graphics3D;

	/**
	 * Creates a new buffer configuration. The given bitmask indicates the
	 * available buffers, while the rest of the arguments configure those
	 * buffers. The given arguments must be given for the available buffers only
	 * in the following order:
	 * <ol>
	 * <li>color buffer pixel format</li>
	 * <li>color buffer data type</li>
	 * <li>depth buffer data type</li>
	 * </ol>
	 * 
	 * @param i_buffers bit mask indicating the available buffers
	 * @param i_args buffer configuration arguments
	 * @throws IllegalArgumentException if any of the given buffers is not
	 *             supported or if the given configuration arguments do not
	 *             match the given buffers or if any of the given configurations
	 *             is not supported
	 */
	public JoglOffscreenBufferConfig(Graphics3D graphics3D, int i_buffers, int... i_args) {
		this.graphics3D = graphics3D;
		
		if ((i_buffers & ~SUPPORTED_BUFFERS) != 0)
			throw new IllegalArgumentException("unsupported buffers: "
					+ i_buffers);

		boolean colorBuffer = (i_buffers & Graphics3DDraw.GL_COLOR_BUFFER_BIT) != 0;
		boolean depthBuffer = (i_buffers & Graphics3DDraw.GL_DEPTH_BUFFER_BIT) != 0;

		int index = 0;
		if (colorBuffer) {
			m_colorPixelFormat = getArg(index++, i_args);
			m_colorDataType = getArg(index++, i_args);
			m_colorBpp = ImageConverter.getColorBpp(m_colorPixelFormat,
					m_colorDataType);
		}

		if (depthBuffer) {
			m_depthDataType = getArg(index++, i_args);
		}

		m_buffers = i_buffers;
	}
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBufferConfig#getGraphics3D()
	 */
	public Graphics3D getGraphics3D() {
		return graphics3D;
	}

	private int getArg(int i_index, int[] i_args) {

		if (i_index > i_args.length - 1)
			throw new IllegalArgumentException("invalid number of arguments: "
					+ i_args);

		return i_args[i_index];
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBufferConfig#getColorBpp()
	 */
	public int getColorBpp() {

		if (!isEnabled(Graphics3DDraw.GL_COLOR_BUFFER_BIT))
			throw new IllegalStateException("color buffer is disabled");

		return m_colorBpp;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBufferConfig#getColorDataType()
	 */
	public int getColorDataType() {

		if (!isEnabled(Graphics3DDraw.GL_COLOR_BUFFER_BIT))
			throw new IllegalStateException("color buffer is disabled");

		return m_colorDataType;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBufferConfig#getColorPixelFormat()
	 */
	public int getColorPixelFormat() {

		if (!isEnabled(Graphics3DDraw.GL_COLOR_BUFFER_BIT))
			throw new IllegalStateException("color buffer is disabled");

		return m_colorPixelFormat;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBufferConfig#getDepthDataType()
	 */
	public int getDepthDataType() {

		if (!isEnabled(Graphics3DDraw.GL_DEPTH_BUFFER_BIT))
			throw new IllegalStateException("depth buffer is disabled");

		return m_depthDataType;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBufferConfig#isEnabled(int)
	 */
	public boolean isEnabled(int i_buffer) {

		return (m_buffers & i_buffer) != 0;
	}

	
}
