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
package org.eclipse.draw3d.geometryext;

import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;

/**
 * A ray is a line that is finite in one direction and infinite in the other
 * direction.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 08.07.2009
 */
public class Ray {

	private Vector3f m_direction = new Vector3fImpl();

	private Vector3f m_origin = new Vector3fImpl();

	/**
	 * Creates a new, uninitialized ray.
	 */
	public Ray() {

		// nothing to initialize
	}

	/**
	 * Creates a new ray with the given origin and direction vector.
	 * 
	 * @param i_origin the origin
	 * @param i_direction the direction vector
	 * @throws NullPointerException if any of the given arguments is
	 *             <code>null</code>
	 */
	public Ray(IVector3f i_origin, IVector3f i_direction) {

		set(i_origin, i_direction);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object i_obj) {

		if (i_obj == null)
			return false;

		if (!(i_obj instanceof Ray))
			return false;

		Ray ray = (Ray) i_obj;

		return m_origin.equals(ray.m_origin)
			&& m_direction.equals(ray.m_direction);

	}

	/**
	 * Returns the direction vector of this ray.
	 * 
	 * @return the direction vector
	 */
	public IVector3f getDirection() {

		return m_direction;
	}

	/**
	 * Returns the starting point of this ray.
	 * 
	 * @return the starting point
	 */
	public IVector3f getStart() {

		return m_origin;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {

		int result = 17;
		result = 37 * result + m_origin.hashCode();
		result = 37 * result + m_direction.hashCode();

		return result;
	}

	/**
	 * Sets the origin and direction vector to the given values.
	 * 
	 * @param i_origin the origin
	 * @param i_direction the direction vector
	 * @throws NullPointerException if any of the given arguments is
	 *             <code>null</code>
	 */
	public void set(IVector3f i_origin, IVector3f i_direction) {

		if (i_origin == null)
			throw new NullPointerException("i_start must not be null");

		if (i_direction == null)
			throw new NullPointerException("i_direction must not be null");

		m_origin.set(i_origin);
		m_direction.set(i_direction);
	}
}
