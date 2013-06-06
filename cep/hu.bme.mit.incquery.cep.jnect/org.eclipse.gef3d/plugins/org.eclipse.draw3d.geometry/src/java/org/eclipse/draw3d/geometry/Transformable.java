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


package org.eclipse.draw3d.geometry;

/**
 * Implementors of this interface allow certain geometric transformations to be
 * performed on them.
 * 
 * @author Matthias Thiele
 * @version $Revision$
 * @since 12.10.2008
 */
public interface Transformable {
	/**
	 * Translate this object by the given distances.
	 * 
	 * @param i_dX the distance on the X axis
	 * @param i_dY the distance on the Z axis
	 * @param i_dZ the distance on the Z axis
	 */
	public void translate(float i_dx, float i_dy, float i_dz);

	/**
	 * Scales this object by the given factor.
	 * 
	 * @param i_factor the scaling factor
	 */
	public void scale(float i_factor);

	/**
	 * Transforms this object using the given matrix.
	 * 
	 * @param i_transformationMatrix4f the transformation matrix
	 */
	public void transform(IMatrix4f i_transformationMatrix4f);
}
