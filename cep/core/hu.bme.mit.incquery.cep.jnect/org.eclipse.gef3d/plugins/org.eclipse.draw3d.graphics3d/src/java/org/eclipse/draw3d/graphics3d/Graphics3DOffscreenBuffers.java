/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Matthias Thiele - initial API and implementation
 *    Kristian Duske - initial API and implementation
 *    Jens von Pilgrim - initial API
 ******************************************************************************/
package org.eclipse.draw3d.graphics3d;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

/**
 * An interface that allows managing a set of offscreen buffers.
 * 
 * @author Matthias Thiele
 * @version $Revision$
 * @since 06.12.08
 */
public interface Graphics3DOffscreenBuffers {
	
	/**
	 * Indicates whether the specified offscreen buffer is a back buffer in
	 * terms of OpenGL.
	 * @return
	 */
	public boolean isBackBuffer();

	/**
	 * Disposes of the offscreen buffers.
	 */
	public void dispose();

	/**
	 * Initializes the buffers. This one-time initialization occurs when the
	 * offscreen renderer is created.
	 */
	public void init();

	/**
	 * Initializes the buffers prior to rendering. This will only happen if they
	 * have become invalid, e.g. because changed dimensions.
	 */
	public void initBuffers();

	/**
	 * Called immediately after rendering has completed. Must copy the offscreen
	 * buffers into the given local buffers.
	 * 
	 * @param i_colorBuffer the local color buffer
	 * @param i_depthBuffer the local depth buffer
	 */
	public void postRender(ByteBuffer i_colorBuffer, FloatBuffer i_depthBuffer);

	/**
	 * Called immediately before rendering begins.
	 */
	public void preRender();

	/**
	 * This methods has to be called if the user of the offscreen buffers wants
	 * to change its height.
	 * 
	 * @param i_height The new height.
	 */
	public void setHeight(int i_height);

	/**
	 * This methods has to be called if the user of the offscreen buffers wants
	 * to change its width.
	 * 
	 * @param i_width The new width.
	 */
	public void setWidth(int i_width);

	/**
	 * This methods has to be called if the user of the offscreen buffers wants
	 * to use another buffer configuration.
	 * 
	 * @param i_bufferConfig
	 */
	public void setBufferConfig(Graphics3DOffscreenBufferConfig i_bufferConfig);
}
