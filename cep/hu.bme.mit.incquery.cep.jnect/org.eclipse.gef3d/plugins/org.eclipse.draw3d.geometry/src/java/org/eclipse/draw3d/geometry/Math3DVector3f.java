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
 * Basic vector operations.
 * 
 * @author Jens von Pilgrim, Kristian Duske
 * @version $Revision$
 * @since 19.10.2008
 */
public class Math3DVector3f extends Math3DVector2f {

	/**
	 * Calculates the absolute value for each component of the given vector. The
	 * source and result vector may be the same object.
	 * 
	 * @param i_source the source vector
	 * @param io_result the result vector, if <code>null</code>, a new vector
	 *            will be created and returned
	 * @return the result vector
	 */
	public static Vector3f abs(IVector3f i_source, Vector3f io_result) {

		if (io_result == null)
			io_result =
				new Vector3fImpl(Math.abs(i_source.getX()), Math.abs(i_source
					.getY()), Math.abs(i_source.getZ()));
		else
			io_result.set(Math.abs(i_source.getX()), Math.abs(i_source.getY()),
				Math.abs(i_source.getZ()));

		return io_result;
	}

	/**
	 * Adds two vectors.
	 * 
	 * @param i_leftVector3f
	 * @param i_rightVector3f
	 * @param o_resultVector3f
	 * @return
	 */
	public static Vector3f add(IVector3f i_left, IVector3f i_right,
		Vector3f o_result) {

		if (o_result == null) {
			return new Vector3fImpl(i_left.getX() + i_right.getX(),
				i_left.getY() + i_right.getY(), i_left.getZ() + i_right.getZ());
		} else {
			o_result.set(i_left.getX() + i_right.getX(), i_left.getY()
				+ i_right.getY(), i_left.getZ() + i_right.getZ());
			return o_result;
		}
	}

	/**
	 * Returns the angle of the two vectors in the range of 0.0 through
	 * <i>pi</i>.
	 * 
	 * @param i_left
	 * @param i_right
	 * @return alpha [0..pi]
	 */
	public static float angle(IVector3f i_left, IVector3f i_right) {

		float cosAlpha =
			dot(i_left, i_right) / (i_left.length() * i_right.length());
		if (cosAlpha <= -1)
			return (float) Math.PI;
		else if (cosAlpha >= 1) {
			return 0;
		}
		return (float) Math.acos(cosAlpha);
	}

	/**
	 * Returns the cross product of the two vectors, i.e. <i>left x right</i>
	 * 
	 * @param i_left
	 * @param i_right
	 * @param o_result
	 * @return
	 * @see http://en.wikipedia.org/wiki/Cross_product
	 */
	public static Vector3f cross(IVector3f i_left, IVector3f i_right,
		Vector3f o_result) {

		// a x b = (a2b3 − a3b2, a3b1 − a1b3, a1b2 − a2b1)

		float x = i_left.getY() * i_right.getZ() //
			- i_left.getZ() * i_right.getY();
		float y = i_left.getZ() * i_right.getX() //
			- i_left.getX() * i_right.getZ();
		float z = i_left.getX() * i_right.getY() //
			- i_left.getY() * i_right.getX();

		if (o_result == null) {
			return new Vector3fImpl(x, y, z);
		} else {
			o_result.set(x, y, z);
			return o_result;
		}

	}

	/**
	 * Returns the distance between the given points.
	 * 
	 * @param i_v1 a vector to the first point
	 * @param i_v2 a vector to the second point
	 * @return the distance between the two points
	 */
	public static float distance(IVector3f i_v1, IVector3f i_v2) {
		Vector3f d = Math3DCache.getVector3f();
		try {
			sub(i_v1, i_v2, d);
			return d.length();
		} finally {
			Math3DCache.returnVector3f(d);
		}
	}

	/**
	 * Returns the squared distance between the given points.
	 * 
	 * @param i_v1 a vector to the first point
	 * @param i_v2 a vector to the second point
	 * @return the squared distance between the two points
	 */
	public static float distanceSquared(IVector3f i_v1, IVector3f i_v2) {
		Vector3f d = Math3DCache.getVector3f();
		try {
			sub(i_v1, i_v2, d);
			return d.lengthSquared();
		} finally {
			Math3DCache.returnVector3f(d);
		}
	}

	/**
	 * Calculates the dot product (scalar product) of the two vectors.
	 * 
	 * @param i_left
	 * @param i_right
	 * @return
	 */
	public static float dot(IVector3f i_left, IVector3f i_right) {

		return i_left.getX() * i_right.getX() + i_left.getY() * i_right.getY()
			+ i_left.getZ() * i_right.getZ();
	}

	/**
	 * Returns <code>true</code> if for each pair of elements a and b of the
	 * given vectors <i>|a-b|<=epsilon</i> is <code>true</code>.
	 * 
	 * @param i_left
	 * @param i_right
	 * @param epsilon
	 * @return
	 */
	public static boolean equals(IVector3f i_left, IVector3f i_right,
		float epsilon) {

		return equals(i_left.getX(), i_right.getX(), epsilon)
			&& equals(i_left.getY(), i_right.getY(), epsilon)
			&& equals(i_left.getZ(), i_right.getZ(), epsilon);
	}

	/**
	 * Returns the Euler angles for a rotation that orients a given vector into
	 * the direction specified by a given reference vector.<br />
	 * The result vector contains the rotations about the x, y and z axes. The
	 * rotations must be applied in the following order: Y first (heading), then
	 * Z (elevation), and finally (bank). Rotation is clockwise. *
	 * 
	 * @param i_vector the vector that is to be oriented, must be normalised
	 * @param i_reference the reference vector, must be normalised
	 * @param o_result the result vector, if <code>null</code>, a new vector
	 *            will be created
	 * @return the rotation angles
	 * @throws NullPointerException if the given vector or reference vector is
	 *             <code>null</code>
	 * @see "http://www.euclideanspace.com/maths/algebra/vectors/angleBetween/index.htm"
	 * @see "http://www.euclideanspace.com/maths/geometry/rotations/conversions/angleToQuaternion/index.htm"
	 * @see "http://www.euclideanspace.com/maths/geometry/rotations/conversions/quaternionToEuler/index.htm"
	 */
	public static Vector3f eulerAngles(IVector3f i_vector,
		IVector3f i_reference, Vector3f o_result) {

		if (i_vector == null)
			throw new NullPointerException("i_reference must not be null");

		if (i_reference == null)
			throw new NullPointerException("i_vector must not be null");

		Vector3f result = o_result;
		if (result == null)
			result = new Vector3fImpl();

		if (i_vector.equals(i_reference)) {
			result.set(0, 0, 0);
			return result;
		}

		Vector3f axis = Math3DCache.getVector3f();
		try {
			// convert to quaternion representation
			Math3D.cross(i_reference, i_vector, axis);

			double qx = axis.getX();
			double qy = axis.getY();
			double qz = axis.getZ();
			double qw = 1 + Math3D.dot(i_reference, i_vector);

			// convert to euler axis representation
			double qx2 = qx * qx;
			double qy2 = qy * qy;
			double qz2 = qz * qz;
			double qw2 = qw * qw;

			double h;
			double a;
			double b;

			double t = qx * qy + qz * qw;
			double u = qx2 + qy2 + qz2 + qw2;

			if (t > 0.4999999 * u) {
				h = 2 * Math.atan2(qx, qw);
				a = Math.PI / 2;
				b = 0;
			} else if (t < -0.4999999 * u) {
				h = -2 * Math.atan2(qx, qw);
				a = -Math.PI / 2;
				b = 0;
			} else {
				double xh = 2 * (qy * qw - qx * qz);
				double yh = qx2 - qy2 - qz2 + qw2;

				double xb = 2 * (qx * qw - qy * qz);
				double yb = -qx2 + qy2 - qz2 + qw2;

				h = Math.atan2(xh, yh);
				a = Math.asin(2 * t / u);
				b = Math.atan2(xb, yb);
			}

			result.set((float) b, (float) h, (float) a);
			return result;
		} finally {
			Math3DCache.returnVector3f(axis);
		}
	}

	/**
	 * Returns the world location of a point that is given by a ray and a
	 * distance. The given ray direction is scaled with the given distance and
	 * added to the given ray origin.
	 * 
	 * @param i_rayOrigin the origin of the ray
	 * @param i_rayDirection the direction of the ray
	 * @param i_distance the distance of the point to the origin of the ray
	 * @param io_result the result vector, if <code>null</code>, a new vector
	 *            will be created
	 * @return the point
	 */
	public static Vector3f getLocation(IVector3f i_rayOrigin,
		IVector3f i_rayDirection, float i_distance, Vector3f io_result) {

		Vector3f result = io_result;
		if (result == null)
			result = new Vector3fImpl();

		Vector3f tmp = Math3DCache.getVector3f();
		try {
			tmp.set(i_rayDirection);
			tmp.scale(i_distance);
			Math3D.add(i_rayOrigin, tmp, result);

			return result;
		} finally {
			Math3DCache.returnVector3f(tmp);
		}
	}

	/**
	 * Returns the normalised direction vector of a ray that starts at the given
	 * origin and that contains the given point.
	 * 
	 * @param i_origin the origin of the ray
	 * @param i_point a point contained in the ray
	 * @param o_result the result vector, if <code>null</code>, a new vector
	 *            will be returned
	 * @return the normalised direction vector or <code>null</code> if the given
	 *         origin and point are identical
	 */
	public static Vector3f getRayDirection(IVector3f i_origin,
		IVector3f i_point, Vector3f o_result) {

		if (i_origin.equals(i_point))
			return null;

		Vector3f result = o_result;
		if (result == null)
			result = new Vector3fImpl();

		sub(i_point, i_origin, result);
		normalise(result, result);

		return result;
	}

	/**
	 * Returns a vector with the component-wise maximum values of the given two
	 * vectors.
	 * 
	 * @param i_v0 the first vector
	 * @param i_v1 the second vector
	 * @param o_result the result vector, if <code>null</code>, a new vector
	 *            will be returned
	 * @return the component-wise maximum vector
	 */
	public static Vector3f max(IVector3f i_v0, IVector3f i_v1, Vector3f o_result) {

		Vector3f result = o_result;
		if (result == null)
			result = new Vector3fImpl();

		result.set( //
			Math.max(i_v0.getX(), i_v1.getX()), //
			Math.max(i_v0.getY(), i_v1.getY()), //
			Math.max(i_v0.getZ(), i_v1.getZ()));

		return result;
	}

	/**
	 * Returns a vector with the component-wise minimum values of the given two
	 * vectors.
	 * 
	 * @param i_v0 the first vector
	 * @param i_v1 the second vector
	 * @param o_result the result vector, if <code>null</code>, a new vector
	 *            will be returned
	 * @return the component-wise minimum vector
	 */
	public static Vector3f min(IVector3f i_v0, IVector3f i_v1, Vector3f o_result) {

		Vector3f result = o_result;
		if (result == null)
			result = new Vector3fImpl();

		result.set( //
			Math.min(i_v0.getX(), i_v1.getX()), //
			Math.min(i_v0.getY(), i_v1.getY()), //
			Math.min(i_v0.getZ(), i_v1.getZ()));

		return result;
	}

	/**
	 * Calculates the negative value for each component of the given vector. The
	 * source and result vector may be the same object.
	 * 
	 * @param i_source the source vector
	 * @param o_result the result vector, if <code>null</code>, a new vector
	 *            will be created and returned
	 * @return the result vector
	 */
	public static Vector3f negate(IVector3f i_source, Vector3f o_result) {

		if (o_result == null) {
			return new Vector3fImpl(-i_source.getX(), -i_source.getY(),
				-i_source.getZ());
		} else {
			o_result.set(-i_source.getX(), -i_source.getY(), -i_source.getZ());
			return o_result;
		}
	}

	/**
	 * Returns the normalized vector, that is the vector divided by its length.
	 * 
	 * @param i_vec
	 * @param o_result
	 * @return
	 * @see http://en.wikipedia.org/wiki/Unit_vector
	 */
	public static Vector3f normalise(IVector3f i_source, Vector3f o_result) {

		float lengthInv = 1 / i_source.length();
		return scale(lengthInv, i_source, o_result);
	}

	/**
	 * Multiplies all elements of the vector with the given scale value.
	 * 
	 * @param scale
	 * @param i_sourceVector3f
	 * @param o_resultVector3f
	 * @return
	 */
	public static Vector3f scale(float scale, IVector3f i_source,
		Vector3f o_result) {

		if (o_result == null) {
			return new Vector3fImpl(scale * i_source.getX(), scale
				* i_source.getY(), scale * i_source.getZ());
		} else {
			o_result.set(scale * i_source.getX(), scale * i_source.getY(),
				scale * i_source.getZ());
			return o_result;
		}
	}

	/**
	 * Scales the components of the given source vector by the scaling factors
	 * taken from the given vector. This is used for non-uniform scaling.
	 * 
	 * @param i_scale the scaling factors
	 * @param i_source the vector to scale
	 * @param o_result the result vector, if <code>null</code>, a new vector
	 *            will be returned
	 * @return the scaled source vector
	 */
	public static Vector3f scale(IVector3f i_scale, IVector3f i_source,
		Vector3f o_result) {

		Vector3f result = o_result;
		if (result == null)
			result = new Vector3fImpl();

		result.setX(i_scale.getX() * i_source.getX());
		result.setY(i_scale.getY() * i_source.getY());
		result.setZ(i_scale.getZ() * i_source.getZ());

		return result;
	}

	/**
	 * Subtracts vector right from left, i.e. returns left-right.
	 * 
	 * @param i_left
	 * @param i_right
	 * @param o_result
	 * @return
	 */
	public static Vector3f sub(IVector3f i_left, IVector3f i_right,
		Vector3f o_result) {

		if (o_result == null) {
			return new Vector3fImpl(i_left.getX() - i_right.getX(),
				i_left.getY() - i_right.getY(), i_left.getZ() - i_right.getZ());
		} else {
			o_result.set(i_left.getX() - i_right.getX(), i_left.getY()
				- i_right.getY(), i_left.getZ() - i_right.getZ());
			return o_result;
		}
	}

	/**
	 * Translates a vector by given x, y, and z value. Basically it's the same
	 * as adding a vector (x,y,z) to the vector.
	 * 
	 * @param i_source
	 * @param x
	 * @param y
	 * @param z
	 * @param o_result
	 * @return
	 */
	public static Vector3f translate(IVector3f i_source, float x, float y,
		float z, Vector3f o_result) {

		if (o_result == null) {
			return new Vector3fImpl(x + i_source.getX(), y + i_source.getY(), z
				+ i_source.getZ());
		} else {
			o_result.set(x + i_source.getX(), y + i_source.getY(),
				z + i_source.getZ());
			return o_result;
		}
	}

	/**
	 * Calculates the {@link Math#IEEEremainder(double, double)} for all
	 * components of the vector, using the same divisor. This is especially
	 * useful for "normalizing" a rotation by calling this method with divisor =
	 * 2 * {@link Math#PI}.
	 * 
	 * @param io_rotationVector
	 * @param divisor
	 * @param o_result may be null
	 */
	public static Vector3f IEEERemainder(IVector3f i_source, float divisor,
		Vector3f o_result) {
		if (o_result == null)
			o_result = new Vector3fImpl();

		o_result.set((float) Math.IEEEremainder(i_source.getX(), divisor),
			(float) Math.IEEEremainder(i_source.getY(), divisor),
			(float) Math.IEEEremainder(i_source.getZ(), divisor));

		return o_result;
	}

	/**
	 * Returns a string representation of the given vector, interpreted as
	 * degrees. This is often easier to read than the direct radian
	 * representation.
	 * 
	 * @param i_rotation
	 * @return
	 */
	public static String toStringDegree(IVector3f i_rotation) {
		if (i_rotation == null)
			return "null";
		StringBuilder result = new StringBuilder();
		result.append((int) (i_rotation.getX() * 180 / Math.PI));
		result.append("°/");
		result.append((int) (i_rotation.getY() * 180 / Math.PI));
		result.append("°/");
		result.append((int) (i_rotation.getZ() * 180 / Math.PI));
		result.append("°");
		return result.toString();
	}

}
