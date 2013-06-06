/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.util.converter;

import org.eclipse.swt.graphics.ImageData;

/**
 * ImageInfo There should really be more documentation here.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 19.12.2008
 */
public class ImageInfo {

	private int m_depth;

	/**
	 * Creates a new image info object with the given color depth.
	 * 
	 * @param i_depth the color depth
	 */
	public ImageInfo(int i_depth) {

		m_depth = i_depth;
	}

	/**
	 * Returns the color depth of the image.
	 * 
	 * @return the color depth of the image
	 * @see ImageData#depth
	 */
	public int getDepth() {

		return m_depth;
	}

}
