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
 * @author Jens von Pilgrim, Kristian Duske
 * @version $Revision$
 * @since 19.10.2008
 */
public class Math3DMatrixOps extends Math3DMatrix4f {

	/**
	 * Converts the given affine 2D transformation into an affine 3D
	 * transformation that performs the same transformation on the X/Y plane.
	 * 
	 * @param i_source the source transformation
	 * @param o_result the result matrix, if <code>null</code>, a new matrix
	 *            will be created
	 * @return the result matrix
	 */
	public static Matrix4f convert(IMatrix3f i_source, Matrix4f o_result) {

		Matrix4fImpl result;
		if (o_result != null)
			result = Matrix4fImpl.cast(o_result);
		else
			result = new Matrix4fImpl();

		Matrix3fImpl m = Matrix3fImpl.cast(i_source);

		result.a11 = m.a11;
		result.a12 = m.a12;
		result.a13 = m.a13;
		result.a14 = 0;
		result.a21 = m.a21;
		result.a22 = m.a22;
		result.a23 = m.a23;
		result.a24 = 0;
		result.a31 = 0;
		result.a32 = 0;
		result.a33 = 1;
		result.a34 = 0;
		result.a41 = m.a31;
		result.a42 = m.a32;
		result.a43 = 0;
		result.a44 = 1;

		return result;
	}

	/**
	 * Returns true if both matrices have the same number of elements and for
	 * each pair of elements a and b (the elements are flattened in the same
	 * format) <i>|a-b|<=epsilon</i> is true.
	 * 
	 * @param i_left
	 * @param i_right
	 * @param epsilon
	 * @return
	 */
	public static boolean equals(IMatrix i_left, IMatrix i_right, float epsilon) {

		if (i_left.size() != i_right.size())
			return false;
		int iSize = i_left.size();
		float[] a = new float[iSize];
		float[] b = new float[iSize];
		i_left.toArrayRowMajor(a);
		i_right.toArrayRowMajor(b);
		return equals(a, b, epsilon);
	}

	/**
	 * Calculates the spherical coordinates of a given vector. The spherical
	 * coordinates (rho, phi, theta) describe the distance of the vector from
	 * the origin (it's length) and it's latitude (phi) and longitude (theta)
	 * angles.
	 * 
	 * @author Kristian Duske
	 * @param i_vector the vector
	 * @param o_result the result vector, if <code>null</code>, a new vector
	 *            will be created
	 * @return a vector containing the spherical coordinates or
	 *         <code>null</code> if no spherical coordinates can be calculated
	 *         because the vector has 0 length
	 * @throws NullPointerException if the given vector is <code>null</code>
	 * @see "http://www.math.montana.edu/frankw/ccp/multiworld/multipleIVP/spherical/body.htm"
	 * @see http://en.wikipedia.org/wiki/Spherical_coordinates
	 */
	public static Vector3f getSphericalCoordinates(IVector3f i_vector,
		Vector3f o_result) {

		if (o_result == null)
			o_result = new Vector3fImpl();

		float x = i_vector.getX();
		float y = i_vector.getY();
		float z = i_vector.getZ();

		double rho = i_vector.length();
		if (rho == 0)
			return null;

		double theta;
		double phi;

		double s = Math.sqrt(x * x + y * y);
		if (s != 0) {
			phi = Math.acos(z / rho);
			theta = x >= 0 ? Math.asin(y / s) : Math.PI - Math.asin(y / s);
		} else {
			phi = 0;
			theta = 0;
		}
		o_result.set((float) rho, (float) phi, (float) theta);
		return o_result;
	}

	/**
	 * Transforms a given coordinate system (matrix) by rotating it through a
	 * counterclockwise angle about an axis.
	 * 
	 * @param angle the rotation angle, in radians
	 * @param i_rotationAxis the rotation axis
	 * @param i_matrix the matrix that is to be rotated
	 * @param o_result the result matrix, if <code>null</code>, a new matrix
	 *            will be returned
	 * @return the result matrix
	 * @see W. Strasser: Computergrafik I. FernUniversitaet in Hagen, Kurs 1278,
	 *      2007 (S. 116 ff)
	 */
	public static Matrix4f rotate(float angle, IVector3f i_rotationAxis,
		IMatrix4f i_matrix, Matrix4f o_result) {

		Matrix4fImpl m = Matrix4fImpl.cast(i_matrix);
		Vector3fImpl axis = new Vector3fImpl();
		Matrix4fImpl result;
		if (o_result == null || o_result == m) {
			result = new Matrix4fImpl();
			if (o_result == null)
				o_result = result;
		} else {
			result = Matrix4fImpl.cast(o_result);
		}

		normalise(i_rotationAxis, axis);

		float s = (float) Math.sin(angle);
		float c = (float) Math.cos(angle);
		float t = 1 - c;

		float sx = s * axis.x;
		float sy = s * axis.y;
		float sz = s * axis.z;

		float tx = t * axis.x;
		float txy = tx * axis.y;
		float txz = tx * axis.z;
		float ty = t * axis.y;
		float tyz = ty * axis.z;

		// rm is the rotation matrix, all other values are 0:
		float rm11 = tx * axis.x + c;
		float rm12 = txy + sz;
		float rm13 = txz - sy;
		float rm21 = txy - sz;
		float rm22 = ty * axis.y + c;
		float rm23 = tyz + sx;
		float rm31 = txz + sy;
		float rm32 = tyz - sx;
		float rm33 = t * axis.z * axis.z + c;
		// float rm44 = 1;

		// next, rm is multiplied by m: RESULT = RM * R
		// which complexity is reduced, since a lot of rm values are 0
		result.a11 = m.a11 * rm11 + m.a21 * rm12 + m.a31 * rm13; // +m.a41*rm14;
		result.a12 = m.a12 * rm11 + m.a22 * rm12 + m.a32 * rm13; // +m.a42*rm14;
		result.a13 = m.a13 * rm11 + m.a23 * rm12 + m.a33 * rm13; // +m.a43*rm14;
		result.a14 = m.a14 * rm11 + m.a24 * rm12 + m.a34 * rm13; // +m.a44*rm14;
		result.a21 = m.a11 * rm21 + m.a21 * rm22 + m.a31 * rm23; // +m.a41*rm24;
		result.a22 = m.a12 * rm21 + m.a22 * rm22 + m.a32 * rm23; // +m.a42*rm24;
		result.a23 = m.a13 * rm21 + m.a23 * rm22 + m.a33 * rm23; // +m.a43*rm24;
		result.a24 = m.a14 * rm21 + m.a24 * rm22 + m.a34 * rm23; // +m.a44*rm24;
		result.a31 = m.a11 * rm31 + m.a21 * rm32 + m.a31 * rm33; // +m.a41*rm34;
		result.a32 = m.a12 * rm31 + m.a22 * rm32 + m.a32 * rm33; // +m.a42*rm34;
		result.a33 = m.a13 * rm31 + m.a23 * rm32 + m.a33 * rm33; // +m.a43*rm34;
		result.a34 = m.a14 * rm31 + m.a24 * rm32 + m.a34 * rm33; // +m.a44*rm34;

		result.a41 = /* m.a11 0 + m.a21 0 + m.a31 0 + */m.a41; // *rm44=1;
		result.a42 = /* m.a12 0 + m.a22 0 + m.a32 0 + */m.a42; // *rm44=1;
		result.a43 = /* m.a13 0 + m.a23 0 + m.a33 0 + */m.a43; // *rm44=1;
		result.a44 = /* m.a14 0 + m.a24 0 + m.a34 0 + */m.a44; // *rm44=1;

		if (o_result != result)
			o_result.set(result);

		return result;

	}

	/**
	 * Converts a rotation matrix into euler vectors. The matrix is expected
	 * to be a simple rotation matrix without scale or translate information,
	 * that is the most left and bottom row of the rotation matrix are ignored.
	 * For that manner a {@link IMatrix3f} would be sufficient, however 
	 * most classes return a {@link IMatrix4f}.
	 * The euler angle rotations are
	 * applied in the following order: Y first (heading), then Z
	 * (elevation) and finally X (bank). Rotation is clockwise. 
	 * 
	 * @param i_matrix
	 * @param o_result
	 * @return
	 * @see http://www.euclideanspace.com/maths/geometry/rotations/conversions/matrixToEuler/index.htm
	 * @see http://www.gregslabaugh.name/publications/euler.pdf
	 * @see #eulerAngles(IVector3f, IVector3f, Vector3f)
	 * 
	 */
	public static Vector3f rotationMatrixToEulerAngles(IMatrix4f i_matrix,
		Vector3f o_result) {
		if (o_result == null)
			o_result = new Vector3fImpl();

		if (i_matrix.get(0, 1) > 0.998f) {
			o_result.setX(0);
			o_result.setY((float) Math.atan2(i_matrix.get(2, 0),
				i_matrix.get(2, 2)));
			o_result.setZ(Math3D.PI_2);
			
		} else if (i_matrix.get(0, 1) < -0.998f) {
			o_result.setX(0);
			o_result.setY((float) Math.atan2(i_matrix.get(2, 0),
				i_matrix.get(2, 2)));
			o_result.setZ(-Math3D.PI_2);
		} else {
			o_result.setX((float) Math.atan2(-i_matrix.get(2, 1),
				i_matrix.get(1, 1)));
			o_result.setY((float) Math.atan2(-i_matrix.get(0, 2),
				i_matrix.get(0, 0)));
			o_result.setZ((float) Math.asin(i_matrix.get(0, 1)));
		}
		return o_result;
	}

	/**
	 * Returns the given matrix by the given angles. First, the rotation about
	 * the Y axis is applied, then the rotation about the Z axis and finally the
	 * rotation about the X axis.
	 * 
	 * @param i_angles the rotation angles, in radians
	 * @param i_matrix the matrix that is to be transformed
	 * @param o_result the result matrix, if <code>null</code>, a new matrix
	 *            will be returned
	 * @return the result matrix
	 */
	public static Matrix4f rotate(IVector3f i_angles, IMatrix4f i_matrix,
		Matrix4f o_result) {

		Matrix4f result = o_result;
		if (result == null)
			result = new Matrix4fImpl();

		result.set(i_matrix);

		float yAngle = i_angles.getY();
		if (yAngle != 0)
			Math3D.rotate(yAngle, IVector3f.Y_AXIS, result, result);

		float zAngle = i_angles.getZ();
		if (zAngle != 0)
			Math3D.rotate(zAngle, IVector3f.Z_AXIS, result, result);

		float xAngle = i_angles.getX();
		if (xAngle != 0)
			Math3D.rotate(xAngle, IVector3f.X_AXIS, result, result);

		return result;
	}

	/**
	 * Returns the source vector rotated by the given angles. First, the
	 * rotation about the Y axis is applied, then the rotation about the Z axis
	 * and finally the rotation about the X axis.
	 * <p>
	 * This operation is rather expensive, as a temporary rotation matrix has to
	 * be calculated.
	 * </p>
	 * 
	 * @param i_angles the rotation angles, in radians
	 * @param i_source the matrix that is to be transformed
	 * @param o_result the result matrix, if null, a new vector will created on
	 *            the fly
	 * @return
	 */
	public static Vector3f rotate(IVector3f i_angles, IVector3f i_source,
		Vector3f o_result) {
		if (o_result == null) {
			o_result = new Vector3fImpl();
		}
		Matrix4f rotationMatrix = Math3DCache.getMatrix4f();
		try {
			Math3D.rotate(i_angles, IMatrix4f.IDENTITY, rotationMatrix);
			Math3D.transform(i_source, rotationMatrix, o_result);
		} finally {
			Math3DCache.returnMatrix4f(rotationMatrix);
		}
		return o_result;
	}

	/**
	 * Scales the first three rows with the appropriate values of the scale
	 * vector, i.e. row 1 with x, row 2 with y, and row 3 with z. Row 4 is not
	 * changed.
	 * 
	 * @param i_scaleVector3f
	 * @param i_matrix
	 * @param o_result
	 * @return
	 */
	public static Matrix3f scale(IVector2f i_scaleVector2f, IMatrix3f i_matrix,
		Matrix3f o_result) {

		Matrix3fImpl m = Matrix3fImpl.cast(i_matrix);
		Vector2fImpl v = Vector2fImpl.cast(i_scaleVector2f);

		Matrix3fImpl result;
		if (o_result == null) {
			result = new Matrix3fImpl();
			o_result = result;
		} else {
			result = Matrix3fImpl.cast(o_result);
		}

		result.a11 = m.a11 * v.x;
		result.a12 = m.a12 * v.x;
		result.a13 = m.a13 * v.x;
		result.a21 = m.a21 * v.y;
		result.a22 = m.a22 * v.y;
		result.a23 = m.a23 * v.y;
		result.a31 = m.a31;
		result.a32 = m.a32;
		result.a33 = m.a33;

		if (o_result != result)
			o_result.set(result);

		return result;
	}

	/**
	 * Scales the first three rows with the appropriate values of the scale
	 * vector, i.e. row 1 with x, row 2 with y, and row 3 with z. Row 4 is not
	 * changed.
	 * 
	 * @param i_scaleVector3f
	 * @param i_matrix
	 * @param o_result
	 * @return
	 */
	public static Matrix4f scale(IVector3f i_scaleVector3f, IMatrix4f i_matrix,
		Matrix4f o_result) {

		Matrix4fImpl m = Matrix4fImpl.cast(i_matrix);
		Vector3fImpl v = Vector3fImpl.cast(i_scaleVector3f);

		Matrix4fImpl result;
		if (o_result == null) {
			result = new Matrix4fImpl();
			o_result = result;
		} else {
			result = Matrix4fImpl.cast(o_result);
		}

		result.a11 = m.a11 * v.x;
		result.a12 = m.a12 * v.x;
		result.a13 = m.a13 * v.x;
		result.a14 = m.a14 * v.x;
		result.a21 = m.a21 * v.y;
		result.a22 = m.a22 * v.y;
		result.a23 = m.a23 * v.y;
		result.a24 = m.a24 * v.y;
		result.a31 = m.a31 * v.z;
		result.a32 = m.a32 * v.z;
		result.a33 = m.a33 * v.z;
		result.a34 = m.a34 * v.z;
		result.a41 = m.a41;
		result.a42 = m.a42;
		result.a43 = m.a43;
		result.a44 = m.a44;

		if (o_result != result)
			o_result.set(result);

		return result;
	}

	/**
	 * Transforms the vector i_vector with the given matrix i_matrix, putting
	 * the result in o_result: i_vector * i_matrix = o_result. The given matrix
	 * is in homogeneous coordinates, while the given vector is transformed to
	 * homogeneous coordinates by setting the W component to 1. The result
	 * vector is transformed back from homogeneous coordinates by dividing the
	 * X, Y and Z components by the W component.
	 * 
	 * @param i_vector the vector to transform, in cartesian coordinates
	 * @param i_matrix the transformation matrix, in homogeneous coordinates
	 * @param o_result the result vector, if <code>null</code>, a new vector
	 *            will be returned
	 * @return the result of the transformation, in cartesian coordinates
	 * @see "http://en.wikipedia.org/wiki/Transformation_matrix"
	 */
	public static Vector2f transform(IVector2f i_vector, IMatrix3f i_matrix,
		Vector2f o_result) {

		Matrix3fImpl m = Matrix3fImpl.cast(i_matrix);
		Vector2fImpl v = Vector2fImpl.cast(i_vector);

		Vector2fImpl result;
		if (o_result == v || o_result == null) {
			result = new Vector2fImpl();
			if (o_result == null)
				o_result = result;
		} else {
			result = Vector2fImpl.cast(o_result);
		}

		float w = m.a13 * v.x + m.a23 * v.y + m.a33;
		result.x = (m.a11 * v.x + m.a21 * v.y + m.a31) / w;
		result.y = (m.a12 * v.x + m.a22 * v.y + m.a32) / w;

		if (o_result != result) {
			o_result.set(result);
		}

		return o_result;
	}

	/**
	 * Transforms the vector i_vector with the given matrix i_matrix, putting
	 * the result in o_result: i_vector * i_matrix = o_result.
	 * 
	 * @param i_vector the vector to transform, in cartesian coordinates
	 * @param i_matrix the transformation matrix, in cartesian coordinates
	 * @param o_result the result vector, if <code>null</code>, a new vector
	 *            will be returned
	 * @return the result of the transformation, in cartesian coordinates
	 * @see "http://en.wikipedia.org/wiki/Transformation_matrix"
	 */
	public static Vector3f transform(IVector3f i_vector, IMatrix3f i_matrix,
		Vector3f o_result) {

		Matrix3fImpl m = Matrix3fImpl.cast(i_matrix);
		Vector3fImpl v = Vector3fImpl.cast(i_vector);

		Vector3fImpl result;
		if (o_result == v || o_result == null) {
			result = new Vector3fImpl();
			if (o_result == null)
				o_result = result;
		} else {
			result = Vector3fImpl.cast(o_result);
		}

		result.x = m.a11 * v.x + m.a21 * v.y + m.a31 * v.z;
		result.y = m.a12 * v.x + m.a22 * v.y + m.a32 * v.z;
		result.z = m.a13 * v.x + m.a23 * v.y + m.a33 * v.z;

		if (o_result != result) {
			o_result.set(result);
		}

		return result;
	}

	/**
	 * Transforms the vector i_vector with the given matrix i_matrix, putting
	 * the result in o_result: i_vector * i_matrix = o_result. The given matrix
	 * is in homogeneous coordinates, while the given vector is transformed to
	 * homogeneous coordinates by setting the W component to 1. The result
	 * vector is transformed back from homogeneous coordinates by dividing the
	 * X, Y and Z components by the W component.
	 * 
	 * @param i_vector the vector to transform, in cartesian coordinates
	 * @param i_matrix the transformation matrix, in homogeneous coordinates
	 * @param o_result the result vector, if <code>null</code>, a new vector
	 *            will be returned
	 * @return the result of the transformation, in cartesian coordinates
	 * @see "http://en.wikipedia.org/wiki/Transformation_matrix"
	 */
	public static Vector3f transform(IVector3f i_vector, IMatrix4f i_matrix,
		Vector3f o_result) {

		Matrix4fImpl m = Matrix4fImpl.cast(i_matrix);
		Vector3fImpl v = Vector3fImpl.cast(i_vector);

		Vector3fImpl result;
		if (o_result == v || o_result == null) {
			result = new Vector3fImpl();
			if (o_result == null)
				o_result = result;
		} else {
			result = Vector3fImpl.cast(o_result);
		}

		float w = m.a14 * v.x + m.a24 * v.y + m.a34 * v.z + m.a44;
		result.x = (m.a11 * v.x + m.a21 * v.y + m.a31 * v.z + m.a41) / w;
		result.y = (m.a12 * v.x + m.a22 * v.y + m.a32 * v.z + m.a42) / w;
		result.z = (m.a13 * v.x + m.a23 * v.y + m.a33 * v.z + m.a43) / w;

		if (o_result != result) {
			o_result.set(result);
		}

		return o_result;
	}

	/**
	 * Transforms the vector i_vector with the given matrix i_matrix, putting
	 * the result in o_result: i_vector * i_matrix = o_result.
	 * 
	 * @param i_vector the vector to transform
	 * @param i_matrix the transformation matrix
	 * @param o_result the result vector, if <code>null</code>, a new vector
	 *            will be returned
	 * @return the result of the transformation
	 * @see "http://en.wikipedia.org/wiki/Transformation_matrix"
	 */
	public static Vector4f transform(IVector4f i_vector, IMatrix4f i_matrix,
		Vector4f o_result) {

		Matrix4fImpl m = Matrix4fImpl.cast(i_matrix);
		Vector4fImpl v = Vector4fImpl.cast(i_vector);

		Vector4fImpl result;
		if (o_result == v || o_result == null) {
			result = new Vector4fImpl();
			if (o_result == null)
				o_result = result;
		} else {
			result = Vector4fImpl.cast(o_result);
		}

		result.x = m.a11 * v.x + m.a21 * v.y + m.a31 * v.z + m.a41 * v.w;
		result.y = m.a12 * v.x + m.a22 * v.y + m.a32 * v.z + m.a42 * v.w;
		result.z = m.a13 * v.x + m.a23 * v.y + m.a33 * v.z + m.a43 * v.w;
		result.w = m.a14 * v.x + m.a24 * v.y + m.a34 * v.z + m.a44 * v.w;

		if (o_result != result) {
			o_result.set(result);
		}

		return o_result;
	}

	/**
	 * Translates a matrix by a given vector.
	 * 
	 * @param i_source the matrix to be translated, in homogeneous coordinates
	 * @param i_vector the translation vector
	 * @param o_result the result matrix, if <code>null</code>, a new matrix
	 *            will be returned
	 * @return the translated matrix
	 * @see "http://en.wikipedia.org/wiki/Translation_(geometry)"
	 */
	public static Matrix3f translate(IMatrix3f i_source, IVector2f i_vector,
		Matrix3f o_result) {

		Matrix3fImpl m = Matrix3fImpl.cast(i_source);
		Vector2fImpl v = Vector2fImpl.cast(i_vector);

		Matrix3fImpl result;
		if (o_result == null) {
			result = new Matrix3fImpl(m);
			o_result = result;
		} else {
			result = Matrix3fImpl.cast(o_result);
			result.set(m);
		}

		result.a31 += v.x;
		result.a32 += v.y;

		if (o_result != result)
			o_result.set(result);

		return result;
	}

	/**
	 * Adds a translation defined by a given vector to a transformation matrix.
	 * 
	 * @param i_source the matrix to be translated, in homogeneous coordinates
	 * @param i_vector the translation vector
	 * @param o_result the result matrix, if <code>null</code>, a new matrix
	 *            will be returned
	 * @return the translated matrix
	 * @see "http://en.wikipedia.org/wiki/Translation_(geometry)"
	 */
	public static Matrix4f translate(IMatrix4f i_source, IVector3f i_vector,
		Matrix4f o_result) {

		Matrix4fImpl m = Matrix4fImpl.cast(i_source);
		Vector3fImpl v = Vector3fImpl.cast(i_vector);

		Matrix4fImpl result;
		if (o_result == null) {
			result = new Matrix4fImpl(m);
			o_result = result;
		} else {
			result = Matrix4fImpl.cast(o_result);
			result.set(m);
		}

		result.a41 += v.x;
		result.a42 += v.y;
		result.a43 += v.z;

		if (o_result != result)
			o_result.set(result);

		return result;
	}
}
