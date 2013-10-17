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

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
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
 * @since 24.10.2008
 */
public class SyncedVector3f {
	/**
	 * z-value and cached x,y values
	 */
	public Vector3f m_vec3D;

	/**
	 * float values of x and y values
	 */
	public Vector2f m_vecDelta;

	/**
	 * The standard constructor
	 */
	public SyncedVector3f() {
		this.m_vec3D = new Vector3fImpl();
		this.m_vecDelta = new Vector2fImpl();
	}

	/**
	 * Returns the 3D position synced to the 2D position specified by the given
	 * 2D bounds.
	 * 
	 * @param i_dim2D
	 *            the 2D dimension to sync to
	 * @return the synced 3d vector
	 */
	public IVector3f getVector3f(Dimension i_dim2D) {
		this.m_vec3D.setX(i_dim2D.width + m_vecDelta.getX());
		this.m_vec3D.setY(i_dim2D.height + m_vecDelta.getY());

		return this.m_vec3D;
	}

	/**
	 * Returns the 3D position synced to the 2D position specified by the given
	 * 2D bounds.
	 * 
	 * @param i_point2D
	 *            the 2D point to sync to
	 * @return the synced 3d vector
	 */
	public IVector3f getVector3f(Point i_point2D) {
		this.m_vec3D.setX(i_point2D.x + m_vecDelta.getX());
		this.m_vec3D.setY(i_point2D.y + m_vecDelta.getY());

		return this.m_vec3D;

	}

	/**
	 * Sets delta values and z value of this synchronized vector, returns a 2D
	 * point based on this 3D vector, integer values of 2D point are simply the
	 * integer parts of the given x and y values.
	 * 
	 * @param i_sourceVector3f
	 *            The source vector
	 * @return the new 2D point based on the given vector
	 */
	public Point setVector3f(IVector3f i_sourceVector3f) {
		int x = (int) i_sourceVector3f.getX();
		int y = (int) i_sourceVector3f.getY();

		float xDelta = i_sourceVector3f.getX() - x;
		float yDelta = i_sourceVector3f.getY() - y;
		float z = i_sourceVector3f.getZ();

		m_vecDelta.setX(xDelta);
		m_vecDelta.setY(yDelta);
		m_vec3D.setZ(z);

		return new Point(x, y);
	}

	/**
	 * See {@link #setVector3f(IVector3f)}, here the appropriate 2D object is
	 * returned as Dimension (x is interpreted as width, y as height, and z as
	 * depth).
	 * 
	 * @param i_sourceVector3f
	 *            The source vector
	 * @return the new 2D dimension based on the given vector
	 * @throws NullPointerException
	 *             , if give parameter is null
	 */
	public Dimension setVector3fAsDimension(IVector3f i_sourceVector3f) {
		int x = (int) i_sourceVector3f.getX();
		int y = (int) i_sourceVector3f.getY();

		float xDelta = i_sourceVector3f.getX() - x;
		float yDelta = i_sourceVector3f.getY() - y;
		float z = i_sourceVector3f.getZ();

		m_vecDelta.setX(xDelta);
		m_vecDelta.setY(yDelta);
		m_vec3D.setZ(z);

		return new Dimension(x, y);
	}

	/**
	 * Sets the synced vector's z value.
	 * 
	 * @param i_z
	 *            The new Z value.
	 */
	public void setZ(float i_z) {
		this.m_vec3D.setZ(i_z);
	}

}
