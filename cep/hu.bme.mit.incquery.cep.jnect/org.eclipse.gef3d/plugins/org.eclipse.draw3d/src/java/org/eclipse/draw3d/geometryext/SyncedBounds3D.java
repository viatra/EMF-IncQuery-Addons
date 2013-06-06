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
package org.eclipse.draw3d.geometryext;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw3d.geometry.BoundingBoxImpl;
import org.eclipse.draw3d.geometry.IBoundingBox;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Vector2f;
import org.eclipse.draw3d.geometry.Vector2fImpl;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;

/**
 * The synced classes are 3D-representations of 2D objects like points,
 * dimensions or rectangles. They are synced with a 2D object, therefore they
 * store only a delta concerning x and y as well as the absolute z value.
 * 
 * @author Kristian Duske, Jens von Pilgrim
 * @version $Revision$
 * @since 12.10.2008
 */
public class SyncedBounds3D {
	/**
	 * 3D location of this bounds.
	 */
	public Vector3f m_location3D;

	/**
	 * Delta to the 2D location to which this bounds is synced.
	 */
	public Vector2f m_locationDelta;

	/**
	 * 3D size of this bounds.
	 */
	public Vector3f m_size3D;

	/**
	 * Delta to the 2D size to which this bounds is synced.
	 */
	public Vector2f m_sizeDelta;

	/**
	 * The standard constructor.
	 */
	public SyncedBounds3D() {
		this.m_locationDelta = new Vector2fImpl();
		this.m_sizeDelta = new Vector2fImpl();

		this.m_location3D = new Vector3fImpl();
		this.m_size3D = new Vector3fImpl();
	}

	/**
	 * Gets the BoundingBox synced to the given 2D bounds.
	 * 
	 * @param i_sourceBounds2D
	 *            The source 2D bounds to get the BoundingBox from.
	 * @return Resulting BoundingBox
	 */
	public IBoundingBox getBoundingBox(Rectangle i_sourceBounds2D) {
		return new BoundingBoxImpl(getLocation3D(i_sourceBounds2D),
				getSize3D(i_sourceBounds2D));
	}

	/**
	 * Returns the 3D position synced to the 2D position specified by the given
	 * 2D bounds.
	 * 
	 * @param i_sourceBounds2D
	 *            the 2D bounds to sync to
	 * @return the current 3D position
	 */
	public IVector3f getLocation3D(Rectangle i_sourceBounds2D) {
		this.m_location3D
				.setX(i_sourceBounds2D.x + this.m_locationDelta.getX());
		this.m_location3D
				.setY(i_sourceBounds2D.y + this.m_locationDelta.getY());

		return this.m_location3D;
	}

	/**
	 * Returns the 3D size synced to the 2D size specified by the given 2D
	 * bounds.
	 * 
	 * @param i_sourceBounds2D
	 *            the 2D bounds to sync to
	 * @return the current 3D size
	 */
	public IVector3f getSize3D(Rectangle i_sourceBounds2D) {
		this.m_size3D.setX(i_sourceBounds2D.width + this.m_sizeDelta.getX());
		this.m_size3D.setY(i_sourceBounds2D.height + this.m_sizeDelta.getY());

		return this.m_size3D;
	}

	/**
	 * Sets the 3D bounds according to the given position and size. Also
	 * calculates and returns the new 2D bounds from the given parameters.
	 * 
	 * @param i_position
	 *            the new 3D position
	 * @param i_size
	 *            the new 3D dimensions
	 * @return the new 2D bounds
	 */
	public Rectangle setBounds3D(IVector3f i_position, IVector3f i_size) {
		int x = (int) i_position.getX();
		int y = (int) i_position.getY();

		int width = (int) i_size.getX();
		int height = (int) i_size.getY();

		float xDelta = i_position.getX() - x;
		float yDelta = i_position.getY() - y;
		float z = i_position.getZ();

		this.m_locationDelta.setX(xDelta);
		this.m_locationDelta.setY(yDelta);
		this.m_location3D.setZ(z);

		float widthDelta = i_size.getX() - width;
		float heightDelta = i_size.getY() - height;
		float depth = i_size.getZ();

		this.m_sizeDelta.setX(widthDelta);
		this.m_sizeDelta.setY(heightDelta);
		this.m_size3D.setZ(depth);

		return new Rectangle(x, y, width, height);
	}

	/**
	 * Sets the depth (z dimension) of the bounds.
	 * 
	 * @param i_depth
	 *            the new depth
	 */
	public void setDepth(float i_depth) {
		this.m_size3D.setZ(i_depth);
	}

	/**
	 * Sets the new z position of the bounds.
	 * 
	 * @param i_z
	 *            the new z position
	 */
	public void setZ(float i_z) {
		this.m_location3D.setZ(i_z);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "SyncedBounds3D [3D location:" + m_location3D + ", 3D size:"
				+ m_size3D + ", 2D location delta:" + m_locationDelta
				+ ", 2D size delta:" + m_sizeDelta + "]";
	}
}
