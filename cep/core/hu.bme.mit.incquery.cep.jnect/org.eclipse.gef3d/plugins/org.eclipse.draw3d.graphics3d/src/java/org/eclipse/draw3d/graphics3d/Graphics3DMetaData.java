/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Matthias Thiele - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.graphics3d;


/**
 * The Graphics3DMetaData provides information about the Graphics3D-Interface
 * and its implementors to its users.
 * 
 * @author Matthias Thiele
 * @version $Revision$
 * @since 29.11.2008
 */
public class Graphics3DMetaData {

	/**
	 * Indicates whether the specified offscreen buffer is a back buffer in
	 * terms of OpenGL.
	 * 
	 * @param offscreenBuffer The buffer to check.
	 * @return <code>true</code> if the back buffer is used or
	 *         <code>false</code> otherwise
	 */
	public static boolean isBackBuffer(
			Graphics3DOffscreenBuffers i_offscreenBuffer) {
		return i_offscreenBuffer.isBackBuffer();
	}
}
