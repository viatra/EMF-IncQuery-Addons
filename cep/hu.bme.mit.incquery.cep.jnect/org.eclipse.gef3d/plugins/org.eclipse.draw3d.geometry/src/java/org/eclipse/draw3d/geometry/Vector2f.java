/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 *    Kristian Duske - copied from Vector3f
 ******************************************************************************/

package org.eclipse.draw3d.geometry;

/**
 * Mutable vector 2f.
 * 
 * @author Jens von Pilgrim
 * @author Kristian Duske
 * @version $Revision$
 * @since Jun 3, 2009
 */
public interface Vector2f extends IVector2f {

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
	 * Sets the x and y value of this vector to the values of the given vector.
	 * 
	 * @param v
	 *            must not be null
	 */
	public void set(IVector2f v);

	/**
	 * Sets x and y attribute of this vector.
	 * 
	 * @param x
	 * @param y
	 */
	public void set(float x, float y);
}
