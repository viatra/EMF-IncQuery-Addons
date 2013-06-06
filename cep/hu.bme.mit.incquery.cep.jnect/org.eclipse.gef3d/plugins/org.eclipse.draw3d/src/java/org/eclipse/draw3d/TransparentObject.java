/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d;

/**
 * Transparent objects must implement this interface so that they can be
 * rendered correctly.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 23.01.2008
 */
public interface TransparentObject {

	/**
	 * Returns a measure for distance between the camera and the object. This
	 * does not have to be the actual distance, but the returned number must be
	 * equivalent.
	 * 
	 * @param i_renderContext the current render context
	 * @return the distance
	 */
	public float getTransparencyDepth(RenderContext i_renderContext);

	/**
	 * Actually renders the transparent object.
	 * 
	 * @param i_renderContext the current render context
	 */
	public void renderTransparent(RenderContext i_renderContext);
}
