/*******************************************************************************
 * Copyright (c) 2009 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.graphics3d;

/**
 * A 2D image that renders itself.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 10.12.2009
 */
public interface RenderImage {

	/**
	 * Disposes all ressources associated with this image.
	 * 
	 * @param i_g3d the current 3D graphics instance
	 */
	public void dispose();

	/**
	 * Initializes this image.
	 * 
	 * @param i_g3d the current 3D graphics instance
	 */
	public void initialize(Graphics3D i_g3d);

	/**
	 * Renders this image.
	 * 
	 * @param i_g3d the current 3D graphics instance
	 * @param i_lodHelper a helper class for level of detail calculations
	 */
	public void render(Graphics3D i_g3d, ILodHelper i_lodHelper);
}
