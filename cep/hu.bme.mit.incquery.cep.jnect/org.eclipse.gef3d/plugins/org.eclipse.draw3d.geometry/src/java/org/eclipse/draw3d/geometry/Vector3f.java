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
 * Mutable vector 3f.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Dec 16, 2008
 */
public interface Vector3f extends IVector3f, Transformable {

	/**
	 * Sets the attribute x of this vector.
	 * 
	 * @param x
	 */
	public void setX(float x);

	/**
	 * Sets the attribute y of this vector.
	 * 
	 * @param y
	 */
	public void setY(float y);

	/**
	 * Sets the attribute z of this vector.
	 * 
	 * @param z
	 */
	public void setZ(float z);

	/**
	 * Sets the x, y, and z value of this vector to the values of the given
	 * vector.
	 * 
	 * @param v must not be null
	 */
	public void set(IVector3f v);
	
	/**
	 * Sets x, y, and z attribute of this vector.
	 * @param x
	 * @param y
	 * @param z
	 */
	public void set(float x, float y, float z);
}
