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

import java.util.LinkedList;
import java.util.List;

/**
 * Implementation
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 30.07.2009
 */
public class ParaxialBoundingBoxImpl extends BoundingBoxImpl implements
		ParaxialBoundingBox {

	/**
	 * Enumerates the sides of a paraxial bounding box from the point of view of
	 * someone standing on the X axis in front of the box, with their feet on
	 * the X/Y plane (Z axis points up from their point of view).
	 * 
	 * @author Kristian Duske
	 * @version $Revision$
	 * @since 30.07.2009
	 */
	private enum Side {

		BACK, BOTTOM, FRONT, LEFT, RIGHT, TOP;

		private static final Vector3f N_BACK = new Vector3fImpl(-1, 0, 0);

		private static final Vector3f N_BOTTOM = new Vector3fImpl(0, 0, -1);

		private static final Vector3f N_FRONT = new Vector3fImpl(1, 0, 0);

		private static final Vector3f N_LEFT = new Vector3fImpl(0, -1, 0);

		private static final Vector3f N_RIGHT = new Vector3fImpl(0, 1, 0);

		private static final Vector3f N_TOP = new Vector3fImpl(0, 0, 1);

		/**
		 * Indicates whether this side of the given paraxial bounding box
		 * contains the projection of the given point. In other words, the given
		 * point is projected onto this side along the direction given by the
		 * normal vector of this side, and then it is checked whether the
		 * projection is contained within this side.
		 * 
		 * @param i_box the paraxial bounding box
		 * @param i_point the point to check
		 * @return <code>true</code> if this side contains the projection of the
		 *         given point and <code>false</code> otherwise
		 */
		public boolean contains(IParaxialBoundingBox i_box, IVector3f i_point) {

			Vector3f start = Math3DCache.getVector3f();
			Vector3f end = Math3DCache.getVector3f();
			try {
				i_box.getLocation(start);
				i_box.getEnd(end);
				switch (this) {
				case FRONT:
				case BACK:
					return Math3D.in(start.getY(), end.getY(), i_point.getY())
						&& Math3D.in(start.getZ(), end.getZ(), i_point.getZ());
				case LEFT:
				case RIGHT:
					return Math3D.in(start.getX(), end.getX(), i_point.getX())
						&& Math3D.in(start.getZ(), end.getZ(), i_point.getZ());
				case TOP:
				case BOTTOM:
					return Math3D.in(start.getX(), end.getX(), i_point.getX())
						&& Math3D.in(start.getY(), end.getY(), i_point.getY());
				}

				// cannot happen
				return false;
			} finally {
				Math3DCache.returnVector3f(start, end);
			}
		}

		/**
		 * Returns the normal vector of this side of a paraxial bounding box.
		 * 
		 * @return the normal vector of this side
		 */
		public IVector3f getNormal() {

			switch (this) {
			case LEFT:
				return N_LEFT;
			case BACK:
				return N_BACK;
			case BOTTOM:
				return N_BOTTOM;
			case FRONT:
				return N_FRONT;
			case RIGHT:
				return N_RIGHT;
			case TOP:
				return N_TOP;
			}

			// cannot happen
			return null;
		}

		/**
		 * Returns a point contained in this side of the given paraxial bounding
		 * box.
		 * 
		 * @param i_box the paraxial bounding box
		 * @param o_result the result vector, must not be <code>null</code>
		 */
		public void getPoint(IParaxialBoundingBox i_box, Vector3f o_result) {

			switch (this) {
			case LEFT:
			case BACK:
			case BOTTOM:
				i_box.getLocation(o_result);
				break;
			case FRONT:
			case RIGHT:
			case TOP:
				i_box.getEnd(o_result);
				break;
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.ParaxialBoundingBox#update(org.eclipse.draw3d.geometry.IBoundingBox,
	 *      org.eclipse.draw3d.geometry.IMatrix4f)
	 */
	public void update(IBoundingBox i_bounds3D, IMatrix4f i_matrix) {

		if (i_bounds3D == null)
			throw new NullPointerException("i_bounds3D must not be null");

		if (i_matrix == null)
			throw new NullPointerException("i_matrix must not be null");

		Vector3f boundsLoc = Math3DCache.getVector3f();
		Vector3f boundsSize = Math3DCache.getVector3f();
		Vector3f pBoundsP0 = Math3DCache.getVector3f();
		Vector3f pBoundsP1 = Math3DCache.getVector3f();
		Vector3f tmp = Math3DCache.getVector3f();
		try {
			i_bounds3D.getLocation(boundsLoc);
			i_bounds3D.getSize(boundsSize);

			tmp.set(boundsLoc);
			tmp.transform(i_matrix);

			pBoundsP0.set(tmp);
			pBoundsP1.set(tmp);

			// x 0 0
			tmp.set(boundsLoc.getX() + boundsSize.getX(), boundsLoc.getY() + 0,
				boundsLoc.getZ() + 0);
			updatePs(tmp, i_matrix, pBoundsP0, pBoundsP1);
			// 0 y 0
			tmp.set(boundsLoc.getX() + 0, boundsLoc.getY() + boundsSize.getY(),
				boundsLoc.getZ() + 0);
			updatePs(tmp, i_matrix, pBoundsP0, pBoundsP1);
			// x y 0
			tmp.set(boundsLoc.getX() + boundsSize.getX(), boundsLoc.getY()
				+ boundsSize.getY(), boundsLoc.getZ() + 0);
			updatePs(tmp, i_matrix, pBoundsP0, pBoundsP1);
			// 0 0 z
			tmp.set(boundsLoc.getX() + 0, boundsLoc.getY() + 0, boundsLoc
				.getZ()
				+ boundsSize.getZ());
			updatePs(tmp, i_matrix, pBoundsP0, pBoundsP1);
			// x 0 z
			tmp.set(boundsLoc.getX() + boundsSize.getX(), boundsLoc.getY() + 0,
				boundsLoc.getZ() + boundsSize.getZ());
			updatePs(tmp, i_matrix, pBoundsP0, pBoundsP1);
			// 0 y z
			tmp.set(boundsLoc.getX() + 0, boundsLoc.getY() + boundsSize.getY(),
				boundsLoc.getZ() + boundsSize.getZ());
			updatePs(tmp, i_matrix, pBoundsP0, pBoundsP1);
			// x y z
			tmp.set(boundsLoc.getX() + boundsSize.getX(), boundsLoc.getY()
				+ boundsSize.getY(), boundsLoc.getZ() + boundsSize.getZ());
			updatePs(tmp, i_matrix, pBoundsP0, pBoundsP1);

			setLocation(pBoundsP0);
			Math3D.sub(pBoundsP1, pBoundsP0, pBoundsP1);
			setSize(pBoundsP1);
		} finally {
			Math3DCache.returnVector3f(boundsLoc, boundsSize, pBoundsP0,
				pBoundsP1, tmp);
		}
	}

	/**
	 * {@inheritDoc} This algorithm is based on the following assumptions:
	 * <ul>
	 * <li>We are only interested in such intersections where a ray enters this
	 * bounding box.</li>
	 * <li>Any given ray can enter a bounding box on at most one of three sides
	 * of a paraxial bounding box.</li>
	 * <li>When a ray hits an edge or corner, one of the adjacent sides of the
	 * bounding box is chosen arbitrarily. This does not change the result of
	 * the calculation.</li>
	 * <li>Each side of a paraxial bounding box defines a plane. So first we
	 * select three candidates by checking the angle between the ray and the
	 * plane normals. Only such planes where the angle is between 90 and 270
	 * degrees are candidates.</li>
	 * </ul>
	 * 
	 * @see org.eclipse.draw3d.geometry.IParaxialBoundingBox#intersectRay(org.eclipse.draw3d.geometry.IVector3f,
	 *      org.eclipse.draw3d.geometry.IVector3f)
	 */
	public float intersectRay(IVector3f i_rayOrigin, IVector3f i_rayDirection) {

		Vector3f start = Math3DCache.getVector3f();
		Vector3f end = Math3DCache.getVector3f();
		Vector3f planePoint = Math3DCache.getVector3f();
		Vector3f intersection = Math3DCache.getVector3f();
		try {
			getLocation(start);
			getEnd(end);

			boolean inside =
				Math3D.in(start.getX(), end.getX(), i_rayOrigin.getX())
					&& Math3D.in(start.getY(), end.getY(), i_rayOrigin.getY())
					&& Math3D.in(start.getZ(), end.getZ(), i_rayOrigin.getZ());

			// select possible candidates
			List<Side> candidates = new LinkedList<Side>();
			float cos = Math3D.dot(Side.FRONT.getNormal(), i_rayDirection);
			if (inside)
				cos *= -1;

			if (cos < 0)
				candidates.add(Side.FRONT);
			else if (cos > 0)
				candidates.add(Side.BACK);

			cos = Math3D.dot(Side.LEFT.getNormal(), i_rayDirection);
			if (inside)
				cos *= -1;

			if (cos < 0)
				candidates.add(Side.LEFT);
			else if (cos > 0)
				candidates.add(Side.RIGHT);

			cos = Math3D.dot(Side.TOP.getNormal(), i_rayDirection);
			if (inside)
				cos *= -1;

			if (cos < 0)
				candidates.add(Side.TOP);
			else if (cos > 0)
				candidates.add(Side.BOTTOM);

			// select last candidate by calculating front most point of
			// intersection with planes defined by sides
			for (Side candidate : candidates) {
				IVector3f planeNormal = candidate.getNormal();
				candidate.getPoint(this, planePoint);

				float d =
					Math3D.rayIntersectsPlane(i_rayOrigin, i_rayDirection,
						planePoint, planeNormal);

				if (!Float.isNaN(d) && d > 0f) {
					intersection.set(i_rayDirection);
					intersection.scale(d);
					Math3D.add(i_rayOrigin, intersection, intersection);

					if (candidate.contains(this, intersection))
						return d;
				}
			}

			return Float.NaN;
		} finally {
			Math3DCache.returnVector3f(start, end, planePoint, intersection);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.ParaxialBoundingBox#union(org.eclipse.draw3d.geometry.IParaxialBoundingBox)
	 */
	public boolean union(IParaxialBoundingBox i_paraxialBoundingBox) {

		if (i_paraxialBoundingBox == null)
			throw new NullPointerException(
				"i_paraxialBoundingBox must not be null");

		Vector3f myPos = Math3DCache.getVector3f();
		Vector3f myEnd = Math3DCache.getVector3f();
		Vector3f myOldEnd = Math3DCache.getVector3f();
		Vector3f theirPos = Math3DCache.getVector3f();
		Vector3f theirEnd = Math3DCache.getVector3f();
		try {
			getLocation(myPos);
			i_paraxialBoundingBox.getLocation(theirPos);

			i_paraxialBoundingBox.getEnd(theirEnd);
			getEnd(myEnd);
			myOldEnd.set(myEnd);

			Math3D.min(myPos, theirPos, m_position);
			Math3D.max(myOldEnd, theirEnd, myEnd);
			setEnd(myEnd);

			return (!(myPos.equals(m_position) && myOldEnd.equals(myEnd)));
		} finally {
			Math3DCache.returnVector3f(myPos, myEnd, myOldEnd, theirPos,
				theirEnd);
		}
	}

	private void updatePs(Vector3f io_tmp, IMatrix4f i_modelMatrix,
		Vector3f io_p0, Vector3f io_p1) {

		io_tmp.transform(i_modelMatrix);
		Math3D.min(io_p0, io_tmp, io_p0);
		Math3D.max(io_p1, io_tmp, io_p1);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IParaxialBoundingBox#contains(org.eclipse.draw3d.geometry.IVector3f)
	 */
	public boolean contains(IVector3f i_point) {

		Vector3f start = Math3DCache.getVector3f();
		Vector3f end = Math3DCache.getVector3f();
		try {
			getLocation(start);
			getEnd(end);

			return Math3D.in(start.getX(), end.getX(), i_point.getX())
				&& Math3D.in(start.getY(), end.getY(), i_point.getY())
				&& Math3D.in(start.getZ(), end.getZ(), i_point.getZ());
		} finally {
			Math3DCache.returnVector3f(start, end);
		}
	}

}
