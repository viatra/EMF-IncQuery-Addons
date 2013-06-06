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
public class Math3DMatrix2f extends Math3DVector4f {

	/**
	 * Adds two matrices. If the result parameter is null, a new matrix will be
	 * created on the fly.
	 * 
	 * @param i_left must not be null
	 * @param i_right must not be null
	 * @param o_result may be null
	 * @return o_result (if not null), or a new instance
	 */
	public static Matrix2f add(IMatrix2f i_left, IMatrix2f i_right,
			Matrix2f o_result) {
		Matrix2fImpl left = Matrix2fImpl.cast(i_left);
		Matrix2fImpl right = Matrix2fImpl.cast(i_right);
		Matrix2fImpl result;
		if (o_result == null) {
			result = new Matrix2fImpl();
			o_result = result;
		} else {
			result = Matrix2fImpl.cast(o_result);
		}

		result.a11 = left.a11 + right.a11;
		result.a12 = left.a12 + right.a12;

		result.a21 = left.a21 + right.a21;
		result.a22 = left.a22 + right.a22;

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
	public static Matrix2f sub(IMatrix2f i_left, IMatrix2f i_right,
			Matrix2f o_result) {
		Matrix2fImpl left = Matrix2fImpl.cast(i_left);
		Matrix2fImpl right = Matrix2fImpl.cast(i_right);
		Matrix2fImpl result;
		if (o_result == null) {
			result = new Matrix2fImpl();
			o_result = result;
		} else {
			result = Matrix2fImpl.cast(o_result);
		}

		result.a11 = left.a11 - right.a11;
		result.a12 = left.a12 - right.a12;

		result.a21 = left.a21 - right.a21;
		result.a22 = left.a22 - right.a22;

		if (o_result != result)
			o_result.set(result);

		return o_result;
	}

	/**
	 * Multiplies two matrices. If the result parameter is null, a new matrix
	 * will be created on the fly. The algorithm is implemented straight
	 * forward, no optimization is used here.
	 * <p>
	 * Any parameters can be identically.
	 * </p>
	 * 
	 * @param i_left must not be null
	 * @param i_right must not be null
	 * @param o_result may be null
	 * @return o_result (if not null), or a new instance
	 * @see http://en.wikipedia.org/wiki/Matrix_multiplication
	 */
	public static Matrix2f mul(IMatrix2f i_left, IMatrix2f i_right,
			Matrix2f o_result) {
		Matrix2fImpl left = Matrix2fImpl.cast(i_left);
		Matrix2fImpl right = Matrix2fImpl.cast(i_right);
		Matrix2fImpl result;
		if (o_result == null) {
			result = new Matrix2fImpl();
			o_result = result;
		} else {
			result = Matrix2fImpl.cast(o_result);
		}

		if (result == left && result == right) {
			float t = result.a11;
			result.a11 = t * result.a11 + result.a12 * result.a21;
			float s = result.a12; 
			result.a12 = t * s + s * result.a22;
			float u = result.a21; 
			result.a21 = u * result.a11 + result.a22 * u;
			result.a22 = u * s + result.a22 * result.a22;
		} else if (result == left) {
			float t = result.a11;
			result.a11 = t * right.a11 + result.a12 * right.a21;
			result.a12 = t * right.a12 + left.a12 * right.a22;
			t = result.a21;
			result.a21 = t * right.a11 + result.a22 * right.a21;
			result.a22 = t * right.a12 + result.a22 * right.a22;
		} else if (result == right) {
			float t = result.a11;
			result.a11 = left.a11 * t + left.a12 * result.a21;
			result.a21 = left.a21 * t + left.a22 * result.a21;
			t = result.a22;
			result.a12 = left.a11 * result.a12 + left.a12 * t;
			result.a22 = left.a21 * result.a12 + left.a22 * t;
		} else {
			result.a11 = left.a11 * right.a11 + left.a12 * right.a21;
			result.a12 = left.a11 * right.a12 + left.a12 * right.a22;
			result.a21 = left.a21 * right.a11 + left.a22 * right.a21;
			result.a22 = left.a21 * right.a12 + left.a22 * right.a22;
		}
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
	public static Matrix2f transpose(IMatrix2f i_source, Matrix2f o_result) {
		Matrix2fImpl m = Matrix2fImpl.cast(i_source);
		Matrix2fImpl result;
		if (o_result == null) {
			result = new Matrix2fImpl();
			o_result = result;
		} else {
			result = Matrix2fImpl.cast(o_result);
		}

		if (result == m) { // use temp var, do not copy diagonal entries
			float t;
			t = result.a12;
			result.a12 = m.a21;
			result.a21 = t;
		} else { // no temp var necessary, copy all entries
			result.a11 = m.a11;
			result.a22 = m.a22;

			result.a12 = m.a21;
			result.a21 = m.a12;
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
	public static float determinant(IMatrix2f i_matrix) {
		Matrix2fImpl m = Matrix2fImpl.cast(i_matrix);
		return det(m.a11, m.a12, m.a21, m.a22);

	}
	
	/**
	 * Calculates the determinant of a 3x3 matrix. The matrix is stored as
	 * follows:
	 * <table>
	 * <tr>
	 * <td>a</td>
	 * <td>b</td>
	 * </tr>
	 * <tr>
	 * <td>c</td>
	 * <td>d</td>
	 * </tr>
	 * </table>
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @return
	 * @see http://en.wikipedia.org/wiki/Determinant
	 */
	public static float det(float a, float b, float c, float d) {
		return a * d - b * c;
	}

	/**
	 * Calculates the determinant of a 2x2 matrix and negates it. That is
	 * calling this method is exactly like calling (-1)*
	 * {@link #det(float, float, float, float)}, but it is a little bit faster
	 * since it requires one mulitplication less. The matrix is stored as
	 * follows:
	 * <table>
	 * <tr>
	 * <td>a</td>
	 * <td>b</td>
	 * </tr>
	 * <tr>
	 * <td>c</td>
	 * <td>d</td>
	 * </tr>
	 * </table>
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @return
	 * @see http://en.wikipedia.org/wiki/Determinant
	 */
	public static float negdet(float a, float b, float c, float d) {
		return b * c - a * d;
	}


	/**
	 * Inverts a matrix. If the result parameter is null, a new matrix will be
	 * created on the fly.
	 * <p>
	 * If no inverse matrix can be calculated, null is returned. So, there's 
	 * no need for testing the determinant before calling this method, since
	 * this would only lead to computing the determinant twice. Simply test
	 * the result if it is null.
	 * </p>
	 * 
	 * @param i_source must not be null
	 * @param o_result may be null
	 * @return o_result (if not null), or a new instance; returns null if matrix
	 *         cannot be inverted (i.e. det=0)
	 * @see http://en.wikipedia.org/wiki/Invertible_matrix
	 */
	public static Matrix2f invert(IMatrix2f i_source, Matrix2f o_result) {
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
	public static Matrix2f adjugate(IMatrix2f i_source, Matrix2f o_result) {
		Matrix2fImpl m = Matrix2fImpl.cast(i_source);
		Matrix2fImpl result;
		if (o_result == null) {
			result = new Matrix2fImpl();
			o_result = result;
		} else {
			result = Matrix2fImpl.cast(o_result);
		}

		float t = m.a11; // just in case result==m 
		result.a11 = m.a22;
		result.a12 = -m.a12;
		result.a21 = -m.a21;
		result.a22 = t; 
		
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
	public static Matrix2f mul(final float f, IMatrix2f i_source, Matrix2f o_result) {
		Matrix2fImpl m = Matrix2fImpl.cast(i_source);
		Matrix2fImpl result;
		if (o_result == null) {
			result = new Matrix2fImpl(m);
			o_result = result;
		} else {
			result = Matrix2fImpl.cast(o_result);
			result.set(m);
		}

		result.a11 *= f;
		result.a12 *= f;
		result.a21 *= f;
		result.a22 *= f;
		
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
	public static Matrix2f negate(IMatrix2f i_source, Matrix2f o_result) {
		Matrix2fImpl m = Matrix2fImpl.cast(i_source);
		Matrix2fImpl result;
		if (o_result == null) {
			result = new Matrix2fImpl();
			o_result = result;
		} else {
			result = Matrix2fImpl.cast(o_result);
		}

		result.a11 = -m.a11;
		result.a12 = -m.a12;
		
		result.a21 = -m.a21;
		result.a22 = -m.a22;
		
		if (o_result != result)
			o_result.set(result);

		return o_result;
	}


	

}
