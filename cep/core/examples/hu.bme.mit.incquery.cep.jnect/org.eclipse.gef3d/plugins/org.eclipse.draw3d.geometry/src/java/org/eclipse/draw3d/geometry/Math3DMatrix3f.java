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
 * Basic matrix operations
 * 
 * @author Jens von Pilgrim, Kristian Duske
 * @version $Revision$
 * @since 19.10.2008
 */
public class Math3DMatrix3f extends Math3DMatrix2f {

	/**
	 * Adds two matrices. If the result parameter is null, a new matrix will be
	 * created on the fly.
	 * 
	 * @param i_left must not be null
	 * @param i_right must not be null
	 * @param o_result may be null
	 * @return o_result (if not null), or a new instance
	 */
	public static Matrix3f add(IMatrix3f i_left, IMatrix3f i_right,
			Matrix3f o_result) {
		Matrix3fImpl left = Matrix3fImpl.cast(i_left);
		Matrix3fImpl right = Matrix3fImpl.cast(i_right);
		Matrix3fImpl result;
		if (o_result == null) {
			result = new Matrix3fImpl();
			o_result = result;
		} else {
			result = Matrix3fImpl.cast(o_result);
		}

		result.a11 = left.a11 + right.a11;
		result.a12 = left.a12 + right.a12;
		result.a13 = left.a13 + right.a13;

		result.a21 = left.a21 + right.a21;
		result.a22 = left.a22 + right.a22;
		result.a23 = left.a23 + right.a23;

		result.a31 = left.a31 + right.a31;
		result.a32 = left.a32 + right.a32;
		result.a33 = left.a33 + right.a33;

		if (o_result != result)
			o_result.set(result);

		return o_result;
	}

	/**
	 * Subtracts two matrices. If the result parameter is null, a new matrix
	 * will be created on the fly.
	 * 
	 * @param i_left must not be null
	 * @param i_right must not be null
	 * @param o_result may be null
	 * @return o_result (if not null), or a new instance
	 */
	public static Matrix3f sub(IMatrix3f i_left, IMatrix3f i_right,
			Matrix3f o_result) {
		Matrix3fImpl left = Matrix3fImpl.cast(i_left);
		Matrix3fImpl right = Matrix3fImpl.cast(i_right);
		Matrix3fImpl result;
		if (o_result == null) {
			result = new Matrix3fImpl();
			o_result = result;
		} else {
			result = Matrix3fImpl.cast(o_result);
		}

		result.a11 = left.a11 - right.a11;
		result.a12 = left.a12 - right.a12;
		result.a13 = left.a13 - right.a13;

		result.a21 = left.a21 - right.a21;
		result.a22 = left.a22 - right.a22;
		result.a23 = left.a23 - right.a23;

		result.a31 = left.a31 - right.a31;
		result.a32 = left.a32 - right.a32;
		result.a33 = left.a33 - right.a33;

		if (o_result != result)
			o_result.set(result);

		return o_result;
	}

	/**
	 * Multiplies two matrices. If the result parameter is null, a new matrix
	 * will be created on the fly. The algorithm is implemented straight
	 * forward, no optimization is used here.
	 * 
	 * @param i_left must not be null
	 * @param i_right must not be null
	 * @param o_result may be null
	 * @return o_result (if not null), or a new instance
	 * @see http://en.wikipedia.org/wiki/Matrix_multiplication
	 */
	public static Matrix3f mul(IMatrix3f i_left, IMatrix3f i_right,
			Matrix3f o_result) {
		Matrix3fImpl left = Matrix3fImpl.cast(i_left);
		Matrix3fImpl right = Matrix3fImpl.cast(i_right);
		Matrix3fImpl result;
		if (o_result == null || o_result == left || o_result == right) {
			result = new Matrix3fImpl();
			if (o_result==null)
				o_result = result;
		} else {
			result = Matrix3fImpl.cast(o_result);
		}

		result.a11 = left.a11 * right.a11 + left.a21 * right.a12 + left.a31
				* right.a13;
		result.a12 = left.a12 * right.a11 + left.a22 * right.a12 + left.a32
				* right.a13;
		result.a13 = left.a13 * right.a11 + left.a23 * right.a12 + left.a33
				* right.a13;
		result.a21 = left.a11 * right.a21 + left.a21 * right.a22 + left.a31
				* right.a23;
		result.a22 = left.a12 * right.a21 + left.a22 * right.a22 + left.a32
				* right.a23;
		result.a23 = left.a13 * right.a21 + left.a23 * right.a22 + left.a33
				* right.a23;
		result.a31 = left.a11 * right.a31 + left.a21 * right.a32 + left.a31
				* right.a33;
		result.a32 = left.a12 * right.a31 + left.a22 * right.a32 + left.a32
				* right.a33;
		result.a33 = left.a13 * right.a31 + left.a23 * right.a32 + left.a33
				* right.a33;

		if (o_result != result)
			o_result.set(result);

		return o_result;
	}

	/**
	 * Transposes a matrix. If the result parameter is null, a new matrix will
	 * be created on the fly. Source and result matrix may be identically (
	 * <code>i_source==o_result</code>, this is recognized by this method and
	 * handled correctly.
	 * <p>
	 * Note: If you need a transposed matrix for serializing it to an array or
	 * stream, you may use the methods defined in {@link IMatrix4f}.
	 * 
	 * @param i_source must not be null
	 * @param o_result may be null
	 * @return o_result (if not null), or a new instance
	 */
	public static Matrix3f transpose(IMatrix3f i_source, Matrix3f o_result) {
		Matrix3fImpl m = Matrix3fImpl.cast(i_source);
		Matrix3fImpl result;
		if (o_result == null) { // identical parameters are handled below
			result = new Matrix3fImpl();
			o_result = result;
		} else {
			result = Matrix3fImpl.cast(o_result);
		}

		if (result == m) { // use temp var, do not copy diagonal entries
			float t;
			t = result.a12;
			result.a12 = m.a21;
			result.a21 = t;

			t = result.a13;
			result.a13 = m.a31;
			result.a31 = t;

			t = result.a23;
			result.a23 = m.a32;
			result.a32 = t;
		} else { // no temp var necessary, copy all entries
			result.a11 = m.a11;
			result.a22 = m.a22;
			result.a33 = m.a33;

			result.a12 = m.a21;
			result.a21 = m.a12;

			result.a13 = m.a31;
			result.a31 = m.a13;

			result.a23 = m.a32;
			result.a32 = m.a23;
		}

		if (o_result != result)
			o_result.set(result);

		return o_result;
	}

	/**
	 * Calculates the determinant of a matrix i_a.
	 * 
	 * @param a the matrix, must not be null
	 * @return det(a)
	 * @see http://en.wikipedia.org/wiki/Determinant
	 */
	public static float determinant(IMatrix3f i_matrix) {
		Matrix3fImpl m = Matrix3fImpl.cast(i_matrix);

		return det(m.a11, m.a12, m.a13, //
				m.a21, m.a22, m.a23, //
				m.a31, m.a32, m.a33);

	}

	/**
	 * Inverts a matrix. If the result parameter is null, a new matrix will be
	 * created on the fly.
	 * <p>
	 * If no inverse matrix can be calculated, null is returned. So, there's no
	 * need for testing the determinant before calling this method, since this
	 * would only lead to computing the determinant twice. Simply test the
	 * result if it is null.
	 * </p>
	 * 
	 * @param i_source must not be null
	 * @param o_result may be null
	 * @return o_result (if not null), or a new instance; returns null if matrix
	 *         cannot be inverted (i.e. det=0)
	 * @see http://en.wikipedia.org/wiki/Invertible_matrix
	 */
	public static Matrix3f invert(IMatrix3f i_source, Matrix3f o_result) {
		float det = determinant(i_source);

		if (det != 0) {
			o_result = adjugate(i_source, o_result);
			return mul(1 / det, o_result, o_result);
		} else {
			return null;
		}
	}

	/**
	 * Calculates the adjugate matrix. May be optimized.
	 * 
	 * @param i_source
	 * @param o_result
	 * @return
	 * @see http://en.wikipedia.org/wiki/Adjugate
	 */
	public static Matrix3f adjugate(IMatrix3f i_source, Matrix3f o_result) {
		Matrix3fImpl m = Matrix3fImpl.cast(i_source);
		Matrix3fImpl result;
		if (o_result == null || o_result == m) {
			result = new Matrix3fImpl();
			if (o_result==null) 
				o_result = result;
		} else {
			result = Matrix3fImpl.cast(o_result);
		}

		result.a11 = det(m.a22, m.a23, m.a32, m.a33);
		result.a12 = negdet(m.a12, m.a13, m.a32, m.a33);
		result.a13 = det(m.a12, m.a13, m.a22, m.a23);

		result.a21 = negdet(m.a21, m.a23, m.a31, m.a33);
		result.a22 = det(m.a11, m.a13, m.a31, m.a33);
		result.a23 = negdet(m.a11, m.a13, m.a21, m.a23);

		result.a31 = det(m.a21, m.a22, m.a31, m.a32);
		result.a32 = negdet(m.a11, m.a12, m.a31, m.a32);
		result.a33 = det(m.a11, m.a12, m.a21, m.a22);

		if (o_result != result)
			o_result.set(result);

		return o_result;
	}

	/**
	 * Multiplies a float with a matrix, i.e. every entry is multiplied with
	 * given float.
	 * 
	 * @param f
	 * @param i_source
	 * @param o_result
	 * @return
	 */
	public static Matrix3f mul(final float f, IMatrix3f i_source, Matrix3f o_result) {
		Matrix3fImpl m = Matrix3fImpl.cast(i_source);
		Matrix3fImpl result;
		if (o_result == null) {
			result = new Matrix3fImpl(m);
			o_result = result;
		} else {
			result = Matrix3fImpl.cast(o_result);
			result.set(m);
		}

		result.a11 *= f;
		result.a12 *= f;
		result.a13 *= f;
		result.a21 *= f;
		result.a22 *= f;
		result.a23 *= f;
		result.a31 *= f;
		result.a32 *= f;
		result.a33 *= f;

		if (o_result != result)
			o_result.set(result);

		return o_result;
	}

	/**
	 * Negates a matrix. If the result parameter is null, a new matrix will be
	 * created on the fly.
	 * 
	 * @param i_source must not be null
	 * @param o_result may be null
	 * @return o_result (if not null), or a new instance
	 */
	public static Matrix3f negate(IMatrix3f i_source, Matrix3f o_result) {
		Matrix3fImpl m = Matrix3fImpl.cast(i_source);
		Matrix3fImpl result;
		if (o_result == null || o_result==m) {
			result = new Matrix3fImpl();
			if (o_result==null) 
				o_result = result;
		} else {
			result = Matrix3fImpl.cast(o_result);
		}

		result.a11 = -m.a11;
		result.a12 = -m.a12;
		result.a13 = -m.a13;

		result.a21 = -m.a21;
		result.a22 = -m.a22;
		result.a23 = -m.a23;

		result.a31 = -m.a31;
		result.a32 = -m.a32;
		result.a33 = -m.a33;

		if (o_result != result)
			o_result.set(result);

		return o_result;
	}

	/**
	 * Calculates the determinant of a 3x3 matrix. The matrix is stored as
	 * follows:
	 * <table>
	 * <tr>
	 * <td>a</td>
	 * <td>b</td>
	 * <td>c</td>
	 * </tr>
	 * <tr>
	 * <td>d</td>
	 * <td>e</td>
	 * <td>f</td>
	 * </tr>
	 * <tr>
	 * <td>g</td>
	 * <td>h</td>
	 * <td>i</td>
	 * </tr>
	 * </table>
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param e
	 * @param f
	 * @param g
	 * @param h
	 * @param i
	 * @return
	 * @see http://en.wikipedia.org/wiki/Determinant
	 */
	public static float det(float a, float b, float c, //
			float d, float e, float f, // 
			float g, float h, float i) {
		return a * det(e, f, h, i) - b * det(d, f, g, i) + c * det(d, e, g, h);
	}

	/**
	 * Calculates the determinant of a 2x2 matrix and negates it. That is
	 * calling this method is exactly like calling (-1)*
	 * {@link #det(float, float, float, float,float, float, float, float,float)}
	 * , but it is a little bit faster since it requires one multiplication
	 * less.
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param e
	 * @param f
	 * @param g
	 * @param h
	 * @param i
	 * @return
	 */
	public static float negdet(float a, float b, float c, //
			float d, float e, float f, // 
			float g, float h, float i) {
		return b * det(d, f, g, i) - c * det(d, e, g, h) - a * det(e, f, h, i);
	}

}
