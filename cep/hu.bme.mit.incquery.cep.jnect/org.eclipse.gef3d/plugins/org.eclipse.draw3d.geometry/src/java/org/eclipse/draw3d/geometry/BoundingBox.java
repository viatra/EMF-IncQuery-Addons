/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API
 *    Matthias Thiele -- initial implementation
 ******************************************************************************/

package org.eclipse.draw3d.geometry;

/**
 * A bounding box is a box which is defined by two vectors. One defines the
 * center position of the box while the other one specifies the box' size from
 * the center position. (Literally: x=width, y=height, z=depth). This interface
 * defines a mutable bounding box.
 * 
 * @author Matthias Thiele
 * @version $Revision$
 * @since 12.10.2008
 */
public interface BoundingBox extends IBoundingBox {

	/**
	 * Expands this bounding box by the given delta. The center of the bounding
	 * box remains the same, and the delta value is added to its dimensions in
	 * each direction.
	 * 
	 * @param i_delta the value to expand the box by
	 */
	public void expand(float i_iDelta);

	/**
	 * Resizes this bounding box by the given delta values.
	 * 
	 * @param i_dx add this value to the X dimension of this bounding box
	 * @param i_dy add this value to the Y dimension of this bounding box
	 * @param i_dz add this value to the Z dimension of this bounding box
	 */
	public void resize(float i_dx, float i_dy, float i_dz);

	/**
	 * Resizes this bounding box by the given delta vector.
	 * 
	 * @param i_deltaVector3f the vector to add to the dimensions of this
	 *            bounding box
	 */
	public void resize(IVector3f i_deltaVector3f);

	/**
	 * Sets the position and size of this bounding box to those of the given
	 * bounding box.
	 * 
	 * @param i_sourceBoundingBox3f the reference bounding box
	 */
	public void set(IBoundingBox i_sourceBoundingBox3f);

	/**
	 * Sets the opposite corner of the position of this bounding box. This may
	 * modify the size and position of the bounding box.
	 * 
	 * @param i_end the new vector
	 * @see IBoundingBox#getEnd(Vector3f)
	 */
	public void setEnd(IVector3f i_end);

	/**
	 * Sets the location of this bounding box to the given values.
	 * 
	 * @param i_x the new X position
	 * @param i_y the new Y position
	 * @param i_z the new Z position
	 */
	public void setLocation(float i_x, float i_y, float i_z);

	/**
	 * Sets the location of this bounding box to the given location.
	 * 
	 * @param i_location the locatino to set
	 */
	public void setLocation(IVector3f i_location);

	/**
	 * Sets the size of this bounding box.
	 * 
	 * @param i_width
	 * @param i_height
	 * @param i_depth
	 */
	public void setSize(float i_width, float i_height, float i_depth);

	/**
	 * Sets the size of this bounding box.
	 * 
	 * @param i_newSize
	 */
	public void setSize(IVector3f i_newSize);

	/**
	 * Translates this bounding box by the given delta values.
	 * 
	 * @param i_dx add this to the X coordinate
	 * @param i_dy add this to the Y coordinate
	 * @param i_dz add this to the Z coordinate
	 */
	public void translate(float i_dx, float i_dy, float i_dz);

	/**
	 * Translates this bounding box by the given delta vector.
	 * 
	 * @param i_delta add this vector to the position
	 */
	public void translate(IVector3f i_deltaVector3f);
}
