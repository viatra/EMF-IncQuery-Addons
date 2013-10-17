/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Matthias Thiele - initial API and implementation
 *    Kristian Duske - initial API
 *    Jens von Pilgrim - initial API
 ******************************************************************************/
package org.eclipse.draw3d.graphics3d;

/**
 * A Graphics3DOffscreenBufferConfig is used to create a
 * Graphics3DOffscreenBuffer afterwards. Implementors of this interface store
 * the configuration renderer-specific and therewith hides away the
 * configuration of an offscreen buffers.
 * 
 * @author Matthias Thiele
 * @version $Revision$
 * @since 06.12.2008
 */
public interface Graphics3DOffscreenBufferConfig {
	
	/**
	 * Returns the {@link Graphics3D} instance
	 * @return
	 */
	Graphics3D getGraphics3D();

	/**
	 * Returns the number of bytes per pixel of the color buffer.
	 * 
	 * @return the color buffer's number of bytes per pixel
	 * @throws IllegalStateException if the color buffer is disabled
	 */
	public abstract int getColorBpp();

	/**
	 * Returns the data type of the color buffer.
	 * 
	 * @return the color buffer's data type
	 * @throws IllegalStateException if the color buffer is disabled
	 */
	public abstract int getColorDataType();

	/**
	 * Returns the pixel format of the color buffer.
	 * 
	 * @return the color buffer's pixel format
	 * @throws IllegalStateException if the color buffer is disabled
	 */
	public abstract int getColorPixelFormat();

	/**
	 * Returns the data type of the depth buffer.
	 * 
	 * @return the depth buffer's data type
	 * @throws IllegalStateException if the depth buffer is disabled
	 */
	public abstract int getDepthDataType();

	/**
	 * Indicates whether the given buffer is enabled.
	 * 
	 * @param i_buffer the buffer to check
	 * @return <code>true</code> if the given buffer is enabled or
	 *         <code>false</code> otherwise
	 */
	public abstract boolean isEnabled(int i_buffer);

}