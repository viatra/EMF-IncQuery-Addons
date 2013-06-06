/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.geometry;

/**
 * Math3D provides common 3D math operations. Instead of spreading all these
 * operations all over the 3D geometry classes, they are bundled here. This
 * makes it easier to create subclasses of the existing geometry classes or
 * provide adapter interfaces, since only the data has to be provided but not
 * the logic.
 * 
 * @author Jens von Pilgrim, Matthias Thiele
 * @version $Revision$
 * @since 19.10.2008
 */
public class Math3DBase {
	
	/**
	 * Float version of {@link Math#PI}.
	 */
	public final static float PI = (float) Math.PI;
	
	/**
	 * 2 * PI (180°), used for radian operations.
	 */
	public final static float _2PI = (float) (Math.PI*2);
	
	
	/**
	 * PI / 2 (90°) 
	 */
	public final static float PI_2 = (float) (Math.PI/2);

	/**
	 * In
	 * {@link Math3D#rayIntersectsPolygon(IVector3f, IVector3f, IVector3f[], IVector3f)}
	 * , we need to project the polygon and the point of intersection on one of
	 * the three 2D planes defined by the axes of the world coordinate system.
	 * It is advisable to select the plane on which the projected polygon has
	 * the largest surface area. This enum helps with the selection and with the
	 * projection of the 3D vectors onto the appropriate plane.
	 * 
	 * @author Kristian Duske
	 * @version $Revision$
	 * @since 04.08.2009
	 */
	private enum ProjectionPlane {
		/**
		 * The 2D plane defined by the X and Y axes.
		 */
		XY,
		/**
		 * The 2D plane defined by the X and Z axes.
		 */
		XZ,
		/**
		 * The 2D plane defined by the Z and Y axes.
		 */
		ZY;

		/**
		 * Returns the appropriate 2D projection plane for a polygon with the
		 * given front face normal. This is the plane on which the projection of
		 * the polygon has the largest surface area.
		 * 
		 * @param i_normal the normal of the front face of the polygon
		 * @return the plane on which the projection of the polygon has the
		 *         largest surface area
		 */
		public static ProjectionPlane getPlane(IVector3f i_normal) {

			float xy = Math.abs(Math3D.dot(XY.getNormal(), i_normal));
			float xz = Math.abs(Math3D.dot(XZ.getNormal(), i_normal));
			float zy = Math.abs(Math3D.dot(ZY.getNormal(), i_normal));

			ProjectionPlane plane = null;
			float max;
			if (xy > xz) {
				plane = XY;
				max = xy;
			} else {
				plane = XZ;
				max = xz;
			}

			if (zy > max)
				plane = ZY;

			return plane;
		}

		/**
		 * Returns the normal vector of this 2D projection plane.
		 * 
		 * @return the normal vector
		 */
		public IVector3f getNormal() {

			switch (this) {
			case XY:
				return IVector3f.Z_AXIS;
			case XZ:
				return IVector3f.Y_AXIS;
			default:
				return IVector3f.X_AXIS;
			}
		}

		/**
		 * Returns the component of the given vector that is projected onto the
		 * X axis of this 2D projection plane.
		 * 
		 * @param i_vector the vector to project
		 * @return the 2D X component of the given vector
		 */
		public float getX(IVector3f i_vector) {

			switch (this) {
			case XY:
				return i_vector.getX();
			case XZ:
				return i_vector.getX();
			default:
				return i_vector.getZ();
			}
		}

		/**
		 * Returns the component of the given vector that is projected onto the
		 * Y axis of this 2D projection plane.
		 * 
		 * @param i_vector the vector to project
		 * @return the 2D Y component of the given vector
		 */
		public float getY(IVector3f i_vector) {
			switch (this) {
			case XY:
				return i_vector.getY();
			case XZ:
				return i_vector.getZ();
			default:
				return i_vector.getY();
			}
		}
	}

	/**
	 * Enumerates the sides of a plane.
	 * 
	 * @author Kristian Duske
	 * @version $Revision$
	 * @since 31.07.2009
	 */
	public enum Side {
		/**
		 * The back side.
		 */
		BACK,
		/**
		 * The front side.
		 */
		FRONT;
	}

	/**
	 * Indicates whether the absolute difference of given float values is at
	 * most the given epsilon value.
	 * 
	 * @param left the left value
	 * @param right the right value
	 * @param epsilon the maximum difference
	 * @return <code>true</code> if <i>|left-right|<=epsilon</i> or
	 *         <code>false</code> otherwise
	 */
	public static boolean equals(float left, float right, float epsilon) {

		return Math.abs(left - right) <= epsilon;
	}

	/**
	 * Indicates whether all elements in the given arrays are equal in the sense
	 * of {@link #equals(float, float, float)}. This is the case if the two
	 * arrays contain the same number of elements and for each element pair
	 * <code>(afleft[i],afright[j])</code> the following statement is true:
	 * <code> 0 <= i=j < size</code> implies
	 * <code>equals(afleft[i], afleft[j], epsilon) == true</code>.
	 * 
	 * @param afleft the left array
	 * @param afright the right array
	 * @param epsilon the maximum difference
	 * @return <code>true</code> if the two arrays are equal, <code>false</code>
	 *         otherwise
	 */
	public static boolean equals(float[] afleft, float[] afright, float epsilon) {

		if (afleft.length != afright.length)
			return false;

		for (int i = 0; i < afleft.length; i++)
			if (Math.abs(afleft[i] - afright[i]) > epsilon)
				return false;

		return true;
	}

	/**
	 * Calculates the start and size of the smallest paraxial bounding box that
	 * contains a cuboid with the given position.
	 * 
	 * @param i_position the position
	 * @param o_location the calculated location, must not be <code>null</code>
	 * @param o_size the calculated size, must not be <code>null</code>
	 * @throws NullPointerException if any of the given arguments is
	 *             <code>null</code>
	 */
	public static void getCuboidParaxialBoundingBox(IPosition3D i_position,
		Vector3f o_location, Vector3f o_size) {

		if (i_position == null)
			throw new NullPointerException("i_position must not be null");

		if (o_location == null)
			throw new NullPointerException("o_location must not be null");

		if (o_size == null)
			throw new NullPointerException("o_size must not be null");

		Position3D absolute = Math3DCache.getPosition3D();
		Vector3f end = Math3DCache.getVector3f();
		Vector3f p = Math3DCache.getVector3f();
		try {
			i_position.getAbsolute(absolute);
			if (IVector3f.NULLVEC3f.equals(absolute.getRotation3D())) {
				o_location.set(absolute.getLocation3D());
				o_size.set(absolute.getSize3D());
			} else {
				IMatrix4f matrix = absolute.getTransformationMatrix();

				p.set(0, 0, 0);
				p.transform(matrix);
				o_location.set(p);
				end.set(p);

				p.set(0, 0, 0);
				p.transform(matrix);
				Math3D.min(o_location, p, o_location);
				Math3D.max(end, p, end);

				p.set(0, 0, 1);
				p.transform(matrix);
				Math3D.min(o_location, p, o_location);
				Math3D.max(end, p, end);

				p.set(0, 1, 0);
				p.transform(matrix);
				Math3D.min(o_location, p, o_location);
				Math3D.max(end, p, end);

				p.set(0, 1, 1);
				p.transform(matrix);
				Math3D.min(o_location, p, o_location);
				Math3D.max(end, p, end);

				p.set(1, 0, 0);
				p.transform(matrix);
				Math3D.min(o_location, p, o_location);
				Math3D.max(end, p, end);

				p.set(1, 0, 1);
				p.transform(matrix);
				Math3D.min(o_location, p, o_location);
				Math3D.max(end, p, end);

				p.set(1, 1, 0);
				p.transform(matrix);
				Math3D.min(o_location, p, o_location);
				Math3D.max(end, p, end);

				p.set(1, 1, 1);
				p.transform(matrix);
				Math3D.min(o_location, p, o_location);
				Math3D.max(end, p, end);

				Math3D.sub(end, o_location, o_size);
			}
		} finally {
			Math3DCache.returnPosition3D(absolute);
			Math3DCache.returnVector3f(end, p);
		}
	}

	/**
	 * Calculates a point on a ray from a distance like this
	 * 
	 * <pre>
	 * i_rayOrigin + i_distance * i_rayDirection
	 * </pre>
	 * 
	 * @param i_rayOrigin the origin of a ray
	 * @param i_rayDirection the direction vector of a ray, must be normalised
	 * @param i_distance the distance between the origin of the ray and the
	 *            point to return
	 * @param o_result the result vector, if <code>null</code>, a new vector
	 *            will be returned
	 * @return a point on the given ray or <code>null</code> if the given
	 *         distance is {@link Float#NaN}
	 */
	public static Vector3f getRayPoint(IVector3f i_rayOrigin,
		IVector3f i_rayDirection, float i_distance, Vector3f o_result) {

		if (i_rayOrigin == null)
			throw new NullPointerException("i_rayOrigin must not be null");

		if (i_rayDirection == null)
			throw new NullPointerException("i_rayDirection must not be null");

		if (Float.isNaN(i_distance))
			return null;

		Vector3f result = o_result;
		if (result == null)
			result = new Vector3fImpl();

		if (i_distance == 0)
			result.set(i_rayOrigin);
		else {
			result.set(i_rayDirection);
			result.scale(i_distance);
			Math3D.add(i_rayOrigin, result, result);
		}

		return result;
	}

	/**
	 * Indicates whether the given point is on the front or back of the given
	 * plane. If the given point is contained within the given plane,
	 * <code>null</code> is returned.
	 * 
	 * @param i_planePoint a point on the plane
	 * @param i_planeNormal the plane normal
	 * @param i_point the point to check
	 * @return {@link Side#FRONT} if the given point is on the front of,
	 *         {@link Side#BACK} if it is on the back of or <code>null</code> if
	 *         it is contained within the given plane
	 * @throws NullPointerException if any of the given arguments is
	 *             <code>null</code>
	 */
	public static Side getSideOfPoint(IVector3f i_planePoint,
		IVector3f i_planeNormal, IVector3f i_point) {

		if (i_planePoint == null)
			throw new NullPointerException("i_planePoint must not be null");

		if (i_planeNormal == null)
			throw new NullPointerException("i_planeNormal must not be null");

		if (i_point == null)
			throw new NullPointerException("i_point must not be null");

		if (i_planePoint.equals(i_point))
			return null;

		Vector3f tmp = Math3DCache.getVector3f();
		try {
			Math3D.sub(i_point, i_planePoint, tmp);
			float cos = Math3D.dot(i_planeNormal, tmp);
			if (cos > 0)
				return Side.FRONT;
			else if (cos < 0)
				return Side.BACK;

			return null;
		} finally {
			Math3DCache.returnVector3f(tmp);
		}
	}

	/**
	 * Indicates whether the given value is inside the interval defined by the
	 * given boundaries. The check is inclusive, so
	 * 
	 * <pre>
	 * in(x, x, x)
	 * </pre>
	 * 
	 * is always <code>true</code>. The boundaries don't have to be ordered in
	 * any way.
	 * 
	 * @param i_boundary1 one interval boundary
	 * @param i_boundary2 the other interval boundary
	 * @param i_value the value to check
	 * @return <code>true</code> if the given value is in the given interval or
	 *         <code>false</code> otherwise
	 */
	public static boolean in(float i_boundary1, float i_boundary2, float i_value) {

		if (Float.isNaN(i_boundary1) || Float.isNaN(i_boundary2))
			throw new IllegalArgumentException("boundaries must be numbers");

		if (Float.isNaN(i_value))
			return false;

		float min, max;
		if (i_boundary1 < i_boundary2) {
			min = i_boundary1;
			max = i_boundary2;
		} else {
			min = i_boundary2;
			max = i_boundary1;
		}

		return i_value >= min && i_value <= max;
	}

	/**
	 * Determines the point of intersection between this plane and a line
	 * represented by two distinct points contained in that line.
	 * 
	 * @param i_linePoint1 the first point contained in the line
	 * @param i_linePoint2 the second point contained in the line
	 * @param i_planePoint a point contained in the plane
	 * @param i_planeNormal the plane normal
	 * @param o_result the result vector, if <code>null</code>, a new vector
	 *            will be created
	 * @return the point of intersection or <code>null</code> if the given line
	 *         does not intersect with this plane or if it is entirely contained
	 *         in this plane
	 * @throws NullPointerException if any of the given arguments is
	 *             <code>null</code>
	 * @see "http://en.wikipedia.org/wiki/Line-plane_intersection"
	 */
	public static Vector3f lineIntersectsPlane(IVector3f i_linePoint1,
		IVector3f i_linePoint2, IVector3f i_planePoint,
		IVector3f i_planeNormal, Vector3f o_result) {

		if (i_linePoint1 == null)
			throw new NullPointerException("i_linePoint1 must not be null");

		if (i_linePoint2 == null)
			throw new NullPointerException("i_linePoint2 must not be null");

		if (i_planePoint == null)
			throw new NullPointerException("i_planePoint must not be null");

		if (i_planeNormal == null)
			throw new NullPointerException("i_planeNormal must not be null");

		Vector3f result = o_result;
		if (result == null)
			result = new Vector3fImpl();

		Vector3f tmp = Math3DCache.getVector3f();
		try {
			Math3D.sub(i_linePoint2, i_linePoint1, tmp);

			float d = Math3D.dot(i_planePoint, i_planeNormal);

			float numerator =
				d - i_planeNormal.getX() * i_linePoint1.getX()
					- i_planeNormal.getY() * i_linePoint1.getY()
					- i_planeNormal.getZ() * i_linePoint1.getZ();

			float denominator =
				i_planeNormal.getX() * tmp.getX() + i_planeNormal.getY()
					* tmp.getY() + i_planeNormal.getZ() * tmp.getZ();

			// line is parallel to or contained within the plane
			if (denominator == 0)
				return null;

			float t = numerator / denominator;

			tmp.scale(t);
			Math3D.add(i_linePoint1, tmp, result);

			return result;
		} finally {
			Math3DCache.returnVector3f(tmp);
		}
	}

	/**
	 * Returns the larger one of the given distances. If both distances are
	 * {@link Float#NaN}, {@link Float#NaN} is returned. If one of the given
	 * distances is {@link Float#NaN}, the other distance is returned.
	 * 
	 * @param i_distance1 the first distance
	 * @param i_distance2 the second distance
	 * @return the maximum distance or {@link Float#isNaN()} if both given
	 *         distances are {@link Float#NaN}
	 */
	public static float maxDistance(float i_distance1, float i_distance2) {

		if (Float.isNaN(i_distance1))
			return i_distance2;

		if (Float.isNaN(i_distance2))
			return i_distance1;

		return Math.max(i_distance1, i_distance2);
	}

	/**
	 * Returns the largest one of the distances in the given array. If all
	 * distances are {@link Float#NaN}, {@link Float#NaN} is returned.
	 * 
	 * @param i_distances the distance array
	 * @return the maximum distance or {@link Float#isNaN()} if the given array
	 *         is <code>null</code> or if all given distances are
	 *         {@link Float#NaN}
	 */
	public static float maxDistance(float[] i_distances) {

		if (i_distances == null)
			return Float.NaN;

		if (i_distances.length == 1)
			return i_distances[0];

		float d = maxDistance(i_distances[0], i_distances[1]);
		for (int i = 2; i < i_distances.length; i++)
			d = maxDistance(d, i_distances[i]);

		return d;
	}

	/**
	 * Returns the smaller one of the given distances. If both distances are
	 * {@link Float#NaN}, {@link Float#NaN} is returned. If one of the given
	 * distances is {@link Float#NaN}, the other distance is returned.
	 * 
	 * @param i_distance1 the first distance
	 * @param i_distance2 the second distance
	 * @return the minimum distance or {@link Float#isNaN()} if both given
	 *         distances are {@link Float#NaN}
	 */
	public static float minDistance(float i_distance1, float i_distance2) {

		if (Float.isNaN(i_distance1))
			return i_distance2;

		if (Float.isNaN(i_distance2))
			return i_distance1;

		return Math.min(i_distance1, i_distance2);
	}

	/**
	 * Returns the smallest one of the distances in the given array. If all
	 * distances are {@link Float#NaN}, {@link Float#NaN} is returned.
	 * 
	 * @param i_distances the distance array
	 * @return the minimum distance or {@link Float#isNaN()} if the given array
	 *         is <code>null</code> or if all given distances are
	 *         {@link Float#NaN}
	 */
	public static float minDistance(float[] i_distances) {

		if (i_distances == null)
			return Float.NaN;

		if (i_distances.length == 1)
			return i_distances[0];

		float d = minDistance(i_distances[0], i_distances[1]);
		for (int i = 2; i < i_distances.length; i++)
			d = minDistance(d, i_distances[i]);

		return d;
	}

	/**
	 * Calculcates the point of intersection between a ray and a plane. The ray
	 * is specified by a starting point and a direction and the plane is
	 * specified in Hessian normal form, e.g. by a contained point and a normal
	 * vector. This method returns a scalar x so that
	 * 
	 * <pre>
	 * p = i_rayOrigin + x * i_rayDirection
	 * </pre>
	 * 
	 * in which p is the point of intersection of the given ray and the given
	 * plane, if any. A result of <code>0</code> indicates that the ray starting
	 * point is contained within the plane.
	 * 
	 * @param i_rayOrigin the origin of the ray
	 * @param i_rayDirection the direction vector of the ray, which must be
	 *            normalised
	 * @param i_planePoint a point that is contained in the plane
	 * @param i_planeNormal the normal vector of the plane
	 * @return the scalar factor for the ray direction vector or
	 *         {@link Float#NaN} if the given ray does not intersect with or is
	 *         contained entirely in the given plane
	 */
	public static float rayIntersectsPlane(IVector3f i_rayOrigin,
		IVector3f i_rayDirection, IVector3f i_planePoint,
		IVector3f i_planeNormal) {

		float denominator = Math3D.dot(i_rayDirection, i_planeNormal);
		return rayIntersectsPlane(i_rayOrigin, i_rayDirection, i_planePoint,
			i_planeNormal, denominator);
	}

	/**
	 * This method only exists because we already know the denominator in
	 * {@link #rayIntersectsPolygon(IVector3f, IVector3f, IVector3f[], IVector3f)}
	 * , so there is no need to calculate it again.
	 */
	private static float rayIntersectsPlane(IVector3f i_rayOrigin, 
		IVector3f i_rayDirection, IVector3f i_planePoint,
		IVector3f i_planeNormal, float i_denominator) {

		if (i_denominator == 0)
			return Float.NaN;

		float d = Math3D.dot(i_planePoint, i_planeNormal);
		float numerator = d - Math3D.dot(i_rayOrigin, i_planeNormal);

		float t = numerator / i_denominator;
		if (t < 0)
			return Float.NaN;

		return t;
	}

	/**
	 * Calculcates the point of intersection between a ray and a plane. The ray
	 * is specified by a starting point and a direction and the plane is
	 * specified in Hessian normal form, e.g. by a contained point and a normal
	 * vector. If the result is equal to the ray starting point, the ray
	 * starting point is contained within the plane.
	 * 
	 * @param i_rayOrigin the origin of the ray
	 * @param i_rayDirection the direction vector of the ray, which must be
	 *            normalised
	 * @param i_planePoint a point that is contained in the plane
	 * @param i_planeNormal the normal vector of the plane, which must be
	 *            normalised
	 * @param io_result the result vector, if <code>null</code>, a new vector
	 *            will be returned
	 * @return the point of intersection between the given ray and plane or
	 *         <code>null</code> if the given ray either does not intersect with
	 *         or is contained entirely in the given plane
	 */
	public static Vector3f rayIntersectsPlane(IVector3f i_rayOrigin,
		IVector3f i_rayDirection, IVector3f i_planePoint,
		IVector3f i_planeNormal, Vector3f io_result) {

		float distance =
			rayIntersectsPlane(i_rayOrigin, i_rayDirection, i_planePoint,
				i_planeNormal);

		return getRayPoint(i_rayOrigin, i_rayDirection, distance, io_result);
	}

	/**
	 * Calculates the point of intersection between the given ray and front face
	 * the given polygon and returns the distance between that point and the
	 * origin of the given picking ray. If the given ray does not intersect with
	 * the given polygon or hits its back face, {@link Float#NaN} is returned.
	 * The front and back face of the polygon are determined by the given normal
	 * vector, which points away from the front face.
	 * <p>
	 * Attention, this method does not check whether the vertices of the given
	 * polygon all lie on a plane. If they don't, the results are undefined.
	 * </p>
	 * 
	 * @param i_rayOrigin the origin of the ray
	 * @param i_rayDirection the direction vector of the ray, must be normalised
	 * @param i_polygon the vertices in counter-clockwise order
	 * @param i_normal the normal vector of the polygon's front face
	 * @param o_intersection if not null, the world coordinates of the point of
	 *            intersection will be set to this vector
	 * @return the distance between the origin of the given ray and the point of
	 *         intersection or {@link Float#NaN} if the given ray does not
	 *         intersect with the front face of the given polygon
	 * @throws NullPointerException if any of the given arguments is
	 *             <code>null</code>
	 * @throws IllegalArgumentException if the given polygon has less than 3
	 *             vertices
	 */
	public static float rayIntersectsPolygon(IVector3f i_rayOrigin,
		IVector3f i_rayDirection, IVector3f[] i_polygon, IVector3f i_normal,
		Vector3f o_intersection) {

		if (i_rayOrigin == null)
			throw new NullPointerException("i_rayOrigin must not be null");

		if (i_rayDirection == null)
			throw new NullPointerException("i_rayDirection must not be null");

		if (i_polygon == null)
			throw new NullPointerException("i_polygon must not be null");

		if (i_normal == null)
			throw new NullPointerException("i_normal must not be null");

		if (i_polygon.length < 3)
			throw new IllegalArgumentException(
				"a polygon must have at least three vertices");

		/*
		 * This algorithm works as follows: First, we check whether the given
		 * ray would hit the front or back face of the given polygon. Then, the
		 * point of intersection of the given ray and the plane defined by the
		 * given polygon is calculated. After that, we need to check whether the
		 * point of intersection is inside or outside of the polygon. In order
		 * to determine that, we project the polygon and the point of
		 * intersection onto one of the planes defined by the coordinate system
		 * axes and thereby reduce the 3D problem to a 2D problem. To find out
		 * whether a 2D point is inside or outside of a 2D polygon, you shoot a
		 * ray from the point and count how often it intersects with the edges
		 * of the polygon. If that number is odd, the point is inside the
		 * polygon, if it is even, it is outside. To make this a little easier,
		 * we translate the polygon and the point so that the point is in the
		 * origin and then check how many of the polygon edges intersect with
		 * the (positive) X axis (which acts as our ray).
		 */

		Vector3f intersection = o_intersection;
		if (intersection == null)
			intersection = Math3DCache.getVector3f();
		try {
			// do we hit the front face?
			float cos = Math3D.dot(i_rayDirection, i_normal);
			if (cos >= 0)
				return Float.NaN;

			// calculate point of intersection reusing the dot product
			float distance =
				rayIntersectsPlane(i_rayOrigin, i_rayDirection, i_polygon[0],
					i_normal, cos);
			getRayPoint(i_rayOrigin, i_rayDirection, distance, intersection);

			// which plane should we project onto?
			ProjectionPlane projectionPlane =
				ProjectionPlane.getPlane(i_normal);

			// project the point of intersection
			float ix = projectionPlane.getX(intersection);
			float iy = projectionPlane.getY(intersection);

			int c = 0; // number of edges that intersect with positive X axis
			float x0, y0, x1, y1;

			// start with last polygon edge
			IVector3f p0 = i_polygon[i_polygon.length - 1];
			for (int i = 0; i < i_polygon.length; i++) {
				IVector3f p1 = i_polygon[i];

				// translate the vertices by the coordinates of the point
				x0 = projectionPlane.getX(p0) - ix;
				y0 = projectionPlane.getY(p0) - iy;
				x1 = projectionPlane.getX(p1) - ix;
				y1 = projectionPlane.getY(p1) - iy;

				if (x0 == 0 && y0 == 0 || x1 == 0 && y1 == 0) {
					// the point is identical to a polygon vertex, cancel search
					c = 1;
					break;
				}

				/*
				 * A polygon edge intersects with the positive X axis if the
				 * following conditions are met: The Y coordinates of its
				 * vertices must have different signs (we assign a negative sign
				 * to 0 here in order to count it as a negative number) and one
				 * of the following two conditions must be met: Either the X
				 * coordinates of the vertices are both positive or the X
				 * coordinates of the edge have different signs (again, we
				 * assign a negative sign to 0 here). In the latter case, we
				 * must calculate the point of intersection between the edge and
				 * the X axis and determine whether its X coordinate is positive
				 * or zero.
				 */

				// do the Y coordinates have different signs?
				if ((y0 > 0 && y1 <= 0) || (y0 <= 0 && y1 > 0)) {
					// Is segment entirely on the positive side of the X axis?
					if (x0 > 0 && x1 > 0) {
						c += 1; // edge intersects with the X axis
						// if not, do the X coordinates have different signs?
					} else if ((x0 > 0 && x1 <= 0) || (x0 <= 0 && x1 > 0)) {
						// calculate the point of intersection between the edge
						// and the X axis
						float x = -y0 * (x1 - x0) / (y1 - y0) + x0;
						if (x >= 0)
							c += 1; // edge intersects with the X axis
					}
				}

				p0 = p1;
			}

			if (c % 2 == 0)
				return Float.NaN;

			return distance;
		} finally {
			if (o_intersection == null)
				Math3DCache.returnVector3f(intersection);
		}
	}

	/**
	 * Calculates the point of intersection between the given ray and front face
	 * the given polygon and returns the distance between that point and the
	 * origin of the given picking ray. If the given ray does not intersect with
	 * the given polygon or hits its back face, {@link Float#NaN} is returned.
	 * The front and back face of the polygon are determined by the winding
	 * order of the vertices. The side from which the vertices appear to be
	 * wound in counter-clockwise order is considered the front.
	 * 
	 * @param i_rayOrigin the origin of the ray
	 * @param i_rayDirection the direction vector of the ray, must be normalised
	 * @param i_polygon the vertices in counter-clockwise order
	 * @param o_intersection if not null, the world coordinates of the point of
	 *            intersection will be set to this vector
	 * @return the distance between the origin of the given ray and the point of
	 *         intersection or {@link Float#NaN} if the given ray does not
	 *         intersect with the front face of the given polygon
	 * @throws NullPointerException if any of the given arguments is
	 *             <code>null</code> or if the given polygon has less than 3
	 *             vertices
	 */
	public static float rayIntersectsPolygon(IVector3f i_rayOrigin,
		IVector3f i_rayDirection, IVector3f[] i_polygon, Vector3f o_intersection) {

		if (i_polygon == null)
			throw new NullPointerException("i_polygon must not be null");

		if (i_polygon.length < 3)
			throw new IllegalArgumentException(
				"a polygon must have at least three vertices");

		Vector3f a = Math3DCache.getVector3f();
		Vector3f b = Math3DCache.getVector3f();
		Vector3f normal = Math3DCache.getVector3f();
		try {
			Math3D.sub(i_polygon[1], i_polygon[0], b);
			Math3D.sub(i_polygon[i_polygon.length - 1], i_polygon[0], b);

			Math3D.cross(a, b, normal);
			Math3D.normalise(normal, normal);

			return rayIntersectsPolygon(i_rayOrigin, i_rayDirection, i_polygon,
				normal, o_intersection);
		} finally {
			Math3DCache.returnVector3f(a, b, normal);
		}
	}

	/**
	 * Calculates the point of intersection between a given line segment
	 * specified its boundaries and a plane.
	 * 
	 * @param i_segmentPoint1 the first boundary point of the segment
	 * @param i_segmentPoint2 the second boundary point of the segment
	 * @param i_planePoint a point on the plane
	 * @param i_planeNormal the plane normal
	 * @param o_result the result vector, if <code>null</code>, a new vector
	 *            will be returned
	 * @return the point of intersection or <code>null</code> if the given
	 *         segment does not intersect with the given plane
	 * @throws NullPointerException if any of the given argumentents except
	 *             <code>o_result</code> is <code>null</code>
	 */
	public static Vector3f segmentIntersectsPlane(IVector3f i_segmentPoint1,
		IVector3f i_segmentPoint2, IVector3f i_planePoint,
		IVector3f i_planeNormal, Vector3f o_result) {

		if (i_segmentPoint1 == null)
			throw new NullPointerException("i_segmentPoint1 must not be null");

		if (i_segmentPoint2 == null)
			throw new NullPointerException("i_segmentPoint2 must not be null");

		Vector3f dir = Math3DCache.getVector3f();
		try {
			Math3D.sub(i_segmentPoint2, i_segmentPoint1, dir);

			float max = dir.length();
			Math3D.normalise(dir, dir);

			float t =
				rayIntersectsPlane(i_segmentPoint1, dir, i_planePoint,
					i_planeNormal);

			if (Float.isNaN(t))
				return null;

			if (t > max)
				return null;

			Vector3f result = o_result;
			if (result == null)
				result = new Vector3fImpl();

			result.set(dir);
			result.scale(t);

			Math3D.add(i_segmentPoint1, result, result);
			return result;
		} finally {
			Math3DCache.returnVector3f(dir);
		}
	}

	/**
	 * Returns the solutions, if any, for a quadratic equation of the form
	 * <p>
	 * Ax<sup>2</sup> + Bx + C = 0
	 * </p>
	 * If two identical solutions exist, both are returned. The returned array
	 * always has its first two elements set either to the corresponding
	 * solution or {@link Float#NaN} if no solution exists.
	 * 
	 * @param A the first parameter of the equation
	 * @param B the second parameter of the equation
	 * @param C the third parameter of the equation
	 * @param o_result the result array, if <code>null</code>, a new two element
	 *            array will be returned
	 * @return an array containing the solutions of the given quadratic equation
	 */
	public static float[] solveQuadraticEquation(float A, float B, float C,
		float[] o_result) {

		float[] result = o_result;
		if (result == null)
			result = new float[2];
		else if (result.length < 2)
			throw new IllegalArgumentException("result array is too small");

		float p = B / A;
		float q = C / A;

		float p2 = p / 2;
		float r = p2 * p2 - q; // radicant

		if (r < 0) {
			result[0] = Float.NaN;
			result[1] = Float.NaN;
		} else if (r == 0) {
			result[0] = -p2;
			result[1] = Float.NaN;
		} else {
			float s = (float) Math.sqrt(r);
			result[0] = -p2 + s;
			result[1] = -p2 - s;
		}

		return result;
	}

	/**
	 * Returns the solutions, if any, for a quadratic equation of the form
	 * <p>
	 * x<sup>2</sup> + Bx + C = 0
	 * </p>
	 * If two identical solutions exist, both are returned. The returned array
	 * always has its first two elements set either to the corresponding
	 * solution or {@link Float#NaN} if no solution exists.
	 * 
	 * @param B the second parameter of the equation
	 * @param C the third parameter of the equation
	 * @param o_result the result array, if <code>null</code>, a new two element
	 *            array will be returned
	 * @return an array containing the solutions of the given quadratic equation
	 */

	public static float[] solveQuadraticEquation(float B, float C,
		float[] o_result) {

		return solveQuadraticEquation(1, B, C, o_result);
	}
}
