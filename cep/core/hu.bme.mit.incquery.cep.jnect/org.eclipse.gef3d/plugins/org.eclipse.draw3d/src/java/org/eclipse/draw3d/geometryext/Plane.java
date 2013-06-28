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

import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Math3DCache;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;
import org.eclipse.draw3d.geometry.Math3DBase.Side;

/**
 * A plane that allows some simple geometric operations. Internally, the plane
 * is stored in hessian normal form.
 * 
 * @author Kristian Duske
 * @version $Revision:628 $
 * @since 21.04.2008
 */
public class Plane {

	private Vector3fImpl m_n = new Vector3fImpl();

	private Vector3fImpl m_p = new Vector3fImpl();

	/**
	 * Returns the normal vector of this plane.
	 * 
	 * @param o_result the result vector, if <code>null</code>, a new vector
	 *            will be returned
	 * @return the normal vector
	 */
	public Vector3f getNormal(Vector3f o_result) {

		Vector3f result = o_result;
		if (result == null)
			result = new Vector3fImpl();

		result.set(m_n);
		return result;
	}

	/**
	 * Indicates whether the given point is on the front or back of this plane.
	 * If the given point is contained within this plane, <code>null</code> is
	 * returned.
	 * 
	 * @param i_point the point to check
	 * @return {@link Side#FRONT} if the given point is on the front of,
	 *         {@link Side#BACK} if it is on the back of or <code>null</code> if
	 *         it is contained within this plane
	 * @throws NullPointerException if any of the given arguments is
	 *             <code>null</code>
	 */
	public Side getSide(IVector3f i_point) {

		return Math3D.getSideOfPoint(m_p, m_n, i_point);
	}

	/**
	 * Determines the point of intersection between this plane and a line
	 * represented by two distinct points contained in that line.
	 * 
	 * @param i_la the first point
	 * @param i_lb the second point
	 * @param o_result the result vector, if <code>null</code>, a new vector
	 *            will be created
	 * @return the point of intersection or <code>null</code> if the given line
	 *         does not intersect with this plane or if it is entirely contained
	 *         in this plane
	 * @throws NullPointerException if i_la or i_lb is <code>null</code>
	 * @see "http://en.wikipedia.org/wiki/Line-plane_intersection"
	 */
	public Vector3f intersectionWithLine(IVector3f i_la, IVector3f i_lb,
		Vector3f o_result) {

		return Math3D.lineIntersectsPlane(i_la, i_lb, m_p, m_n, o_result);
	}

	/**
	 * Determines the point of intersection of this plane and a given ray.
	 * 
	 * @param i_rayOrigin the origin of the ray
	 * @param i_rayDirection the direction vector of the ray, must be normalised
	 * @param o_result the result vector, if <code>null</code>, a new vector
	 *            will be created
	 * @return the point of intersection or <code>null</code> if the given line
	 *         does not intersect with this plane or if it is entirely contained
	 *         in this plane
	 * @throws NullPointerException if i_la or i_lb is <code>null</code>
	 */
	public Vector3f intersectionWithRay(IVector3f i_rayOrigin,
		IVector3f i_rayDirection, Vector3f o_result) {

		return Math3D.rayIntersectsPlane(i_rayOrigin, i_rayDirection, m_p, m_n,
			o_result);
	}

	/**
	 * Calculates the point of intersection between the given segment and this
	 * plane.
	 * 
	 * @param i_segmentPoint1 the first vertex of the segment
	 * @param i_segmentPoint2 the second vertex of the segment
	 * @param o_result the result vector, if <code>null</code>, a new vector
	 *            will be returned
	 * @return the point of intersection or <code>null</code> if the given
	 *         segment does not intersect with this plane
	 */
	public Vector3f intersectionWithSegment(IVector3f i_segmentPoint1,
		IVector3f i_segmentPoint2, Vector3f o_result) {

		return Math3D.segmentIntersectsPlane(i_segmentPoint1, i_segmentPoint2,
			m_p, m_n, o_result);
	}

	/**
	 * Indicates whether the given point is in front of this plane.
	 * 
	 * @param i_point the point to check
	 * @return <code>true</code> if the given point is in front of this plane
	 *         and <code>false</code> if it is either contained within or behind
	 *         this plane.
	 */
	public boolean isInFront(IVector3f i_point) {

		return Math3D.getSideOfPoint(m_p, m_n, i_point) == Side.FRONT;
	}

	/**
	 * Indicates whether the given two points are on the same side of this
	 * plane.
	 * 
	 * @param i_point1 the first point
	 * @param i_point2 the second point
	 * @return <code>true</code> if both points are on the same side of or
	 *         contained within this plane and <code>false</code> otherwise
	 */
	public boolean onSameSide(IVector3f i_point1, IVector3f i_point2) {

		return Math3D.getSideOfPoint(m_p, m_n, i_point1) == Math3D
			.getSideOfPoint(m_p, m_n, i_point2);
	}

	/**
	 * Sets the parameters of this plane using the given parameters.
	 * 
	 * @param i_planePoint a point on the plane
	 * @param i_planeNormal the plane normal
	 * @throws NullPointerException if any of the given arguments is
	 *             <code>null</code>
	 */
	public void set(IVector3f i_planePoint, IVector3f i_planeNormal) {

		if (i_planePoint == null)
			throw new NullPointerException("i_planePoint must not be null");

		if (i_planeNormal == null)
			throw new NullPointerException("i_planeNormal must not be null");

		m_p.set(i_planePoint);
		m_n.set(i_planeNormal);
	}

	/**
	 * Sets the parameters of this plane using the given vectors which describe
	 * three non-collinear points.
	 * 
	 * @param i_p0 the first point
	 * @param i_p1 the second point
	 * @param i_p2 the third point
	 * @return <code>true</code> if the given points are non-collinear,
	 *         <code>false</code> otherwise
	 * @throws NullPointerException if any of the given vectors is
	 *             <code>null</code>
	 */
	public boolean set(IVector3f i_p0, IVector3f i_p1, IVector3f i_p2) {

		if (i_p0 == null)
			throw new NullPointerException("i_p0 must not be null");

		if (i_p1 == null)
			throw new NullPointerException("i_p1 must not be null");

		if (i_p2 == null)
			throw new NullPointerException("i_p2 must not be null");

		Vector3f p0p1 = Math3DCache.getVector3f();
		Vector3f p0p2 = Math3DCache.getVector3f();
		Vector3f normal = Math3DCache.getVector3f();

		try {
			// convert to hessian normal form
			Math3D.sub(i_p1, i_p0, p0p1);
			Math3D.sub(i_p2, i_p0, p0p2);

			Math3D.cross(p0p1, p0p2, normal);
			if (normal.lengthSquared() == 0)
				return false;

			Math3D.normalise(normal, normal);
			set(i_p0, normal);

			return true;
		} finally {
			Math3DCache.returnVector3f(p0p1, p0p2, normal);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		StringBuilder buf = new StringBuilder();

		buf.append("Plane[position: ");
		buf.append(m_p);
		buf.append(", normal: ");
		buf.append(m_n);
		buf.append("]");

		return buf.toString();
	}
}
