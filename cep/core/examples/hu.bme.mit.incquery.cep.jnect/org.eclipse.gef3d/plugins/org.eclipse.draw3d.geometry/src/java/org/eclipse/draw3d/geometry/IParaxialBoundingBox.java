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
package org.eclipse.draw3d.geometry;

/**
 * An {@link IBoundingBox} that is paraxial to the world coordinate system.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 30.07.2009
 */
public interface IParaxialBoundingBox extends IBoundingBox {

	/**
	 * Indicates whether this paraxial bounding box contains the given point.
	 * 
	 * @param i_point the point to check
	 * @return <code>true</code> if this bounding box contains the given point
	 *         or <code>false</code> otherwise
	 * @throws NullPointerException if the given point is <code>null</code>
	 */
	public boolean contains(IVector3f i_point);

	/**
	 * Returns the distance between the given ray start point and the point of
	 * intersection of the given ray and this bounding box, if any. The returned
	 * distance is actually the scalar value x by which the given ray direction
	 * vector must be multiplied so that the following equation is true:
	 * 
	 * <pre>
	 * p = i_rayOrigin + x * i_rayDirection
	 * </pre>
	 * 
	 * in which p is the point of intersection, if any. If the given ray does
	 * not intersect with this bounding box, {@link Float#NaN} is returned.
	 * 
	 * @param i_rayOrigin the origin of the ray
	 * @param i_rayDirection the direction vector of the ray, which must be
	 *            normalised
	 * @return the scalar value as described above or {@link Float#NaN} if the
	 *         given ray does not intersect with this bounding box
	 * @throws IllegalArgumentException if the given direction vector has a
	 *             length of zero
	 */
	public float intersectRay(IVector3f i_rayOrigin, IVector3f i_rayDirection);
}
