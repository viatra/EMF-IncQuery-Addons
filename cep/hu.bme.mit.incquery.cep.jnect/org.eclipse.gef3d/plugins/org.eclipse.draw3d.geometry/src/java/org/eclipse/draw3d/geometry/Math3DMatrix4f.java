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
public class Math3DMatrix4f extends Math3DMatrix3f {

	/**
	 * Adds two matrices. If the result parameter is null, a new matrix will be
	 * created on the fly.
	 * 
	 * @param i_left must not be null
	 * @param i_right must not be null
	 * @param o_result may be null
	 * @return o_result (if not null), or a new instance
	 */
	public static Matrix4f add(IMatrix4f i_left, IMatrix4f i_right,
		Matrix4f o_result) {
		Matrix4fImpl left = Matrix4fImpl.cast(i_left);
		Matrix4fImpl right = Matrix4fImpl.cast(i_right);

		Matrix4fImpl result;
		if (o_result == null) {
			result = new Matrix4fImpl();
			o_result = result;
		} else {
			result = Matrix4fImpl.cast(o_result);
		}

		result.a11 = left.a11 + right.a11;
		result.a12 = left.a12 + right.a12;
		result.a13 = left.a13 + right.a13;
		result.a14 = left.a14 + right.a14;

		result.a21 = left.a21 + right.a21;
		result.a22 = left.a22 + right.a22;
		result.a23 = left.a23 + right.a23;
		result.a24 = left.a24 + right.a24;

		result.a31 = left.a31 + right.a31;
		result.a32 = left.a32 + right.a32;
		result.a33 = left.a33 + right.a33;
		result.a34 = left.a34 + right.a34;

		result.a41 = left.a41 + right.a41;
		result.a42 = left.a42 + right.a42;
		result.a43 = left.a43 + right.a43;
		result.a44 = left.a44 + right.a44;

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
	public static Matrix4f sub(IMatrix4f i_left, IMatrix4f i_right,
		Matrix4f o_result) {
		Matrix4fImpl left = Matrix4fImpl.cast(i_left);
		Matrix4fImpl right = Matrix4fImpl.cast(i_right);
		Matrix4fImpl result;
		if (o_result == null) {
			result = new Matrix4fImpl();
			o_result = result;
		} else {
			result = Matrix4fImpl.cast(o_result);
		}

		result.a11 = left.a11 - right.a11;
		result.a12 = left.a12 - right.a12;
		result.a13 = left.a13 - right.a13;
		result.a14 = left.a14 - right.a14;

		result.a21 = left.a21 - right.a21;
		result.a22 = left.a22 - right.a22;
		result.a23 = left.a23 - right.a23;
		result.a24 = left.a24 - right.a24;

		result.a31 = left.a31 - right.a31;
		result.a32 = left.a32 - right.a32;
		result.a33 = left.a33 - right.a33;
		result.a34 = left.a34 - right.a34;

		result.a41 = left.a41 - right.a41;
		result.a42 = left.a42 - right.a42;
		result.a43 = left.a43 - right.a43;
		result.a44 = left.a44 - right.a44;

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
	public static Matrix4f mul(IMatrix4f i_left, IMatrix4f i_right,
		Matrix4f o_result) {
		Matrix4fImpl left = Matrix4fImpl.cast(i_left);
		Matrix4fImpl right = Matrix4fImpl.cast(i_right);
		Matrix4fImpl result;
		if (o_result == null || o_result == left || o_result == right) {
			result = new Matrix4fImpl();
			if (o_result == null)
				o_result = result;
		} else {
			result = Matrix4fImpl.cast(o_result);
		}

		result.a11 =
			left.a11 * right.a11 + left.a21 * right.a12 + left.a31 * right.a13
				+ left.a41 * right.a14;
		result.a12 =
			left.a12 * right.a11 + left.a22 * right.a12 + left.a32 * right.a13
				+ left.a42 * right.a14;
		result.a13 =
			left.a13 * right.a11 + left.a23 * right.a12 + left.a33 * right.a13
				+ left.a43 * right.a14;
		result.a14 =
			left.a14 * right.a11 + left.a24 * right.a12 + left.a34 * right.a13
				+ left.a44 * right.a14;
		result.a21 =
			left.a11 * right.a21 + left.a21 * right.a22 + left.a31 * right.a23
				+ left.a41 * right.a24;
		result.a22 =
			left.a12 * right.a21 + left.a22 * right.a22 + left.a32 * right.a23
				+ left.a42 * right.a24;
		result.a23 =
			left.a13 * right.a21 + left.a23 * right.a22 + left.a33 * right.a23
				+ left.a43 * right.a24;
		result.a24 =
			left.a14 * right.a21 + left.a24 * right.a22 + left.a34 * right.a23
				+ left.a44 * right.a24;
		result.a31 =
			left.a11 * right.a31 + left.a21 * right.a32 + left.a31 * right.a33
				+ left.a41 * right.a34;
		result.a32 =
			left.a12 * right.a31 + left.a22 * right.a32 + left.a32 * right.a33
				+ left.a42 * right.a34;
		result.a33 =
			left.a13 * right.a31 + left.a23 * right.a32 + left.a33 * right.a33
				+ left.a43 * right.a34;
		result.a34 =
			left.a14 * right.a31 + left.a24 * right.a32 + left.a34 * right.a33
				+ left.a44 * right.a34;
		result.a41 =
			left.a11 * right.a41 + left.a21 * right.a42 + left.a31 * right.a43
				+ left.a41 * right.a44;
		result.a42 =
			left.a12 * right.a41 + left.a22 * right.a42 + left.a32 * right.a43
				+ left.a42 * right.a44;
		result.a43 =
			left.a13 * right.a41 + left.a23 * right.a42 + left.a33 * right.a43
				+ left.a43 * right.a44;
		result.a44 =
			left.a14 * right.a41 + left.a24 * right.a42 + left.a34 * right.a43
				+ left.a44 * right.a44;

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
	 * @param o_result, may be null
	 * @return
	 */
	public static Matrix4f mul(final float f, IMatrix4f i_source,
		Matrix4f o_result) {
		Matrix4fImpl m = Matrix4fImpl.cast(i_source);
		Matrix4fImpl result;
		if (o_result == null) {
			result = new Matrix4fImpl(m);
			o_result = result;
		} else {
			result = Matrix4fImpl.cast(o_result);
			result.set(m);
		}

		result.a11 *= f;
		result.a12 *= f;
		result.a13 *= f;
		result.a14 *= f;
		result.a21 *= f;
		result.a22 *= f;
		result.a23 *= f;
		result.a24 *= f;
		result.a31 *= f;
		result.a32 *= f;
		result.a33 *= f;
		result.a34 *= f;
		result.a41 *= f;
		result.a42 *= f;
		result.a43 *= f;
		result.a44 *= f;

		if (o_result != result)
			o_result.set(result);

		return o_result;
	}

	/**
	 * Calculates the determinant of a matrix. This algorithm uses Laplace
	 * expansion.
	 * <p>
	 * <b>Implementation note</b><br/>
	 * Due to <a href="http://bugs.eclipse.org/336900">bug 446900</a> a long
	 * documentation: Laplace formular (after i-th row): <center><i>
	 * <table cellspacing="0" cellpadding="0" border="0">
	 * <tr>
	 * <td></td>
	 * <td><center><sub>n</sub></center></td>
	 * <td></td>
	 * </tr>
	 * <tr>
	 * <td>det A =</td>
	 * <td><center>&#8721;</center></td>
	 * <td>(-1)<sup>i+j</sup>*a<sub>ij</sub>*det A<sub>ij</sub></td>
	 * </tr>
	 * <tr>
	 * <td></td>
	 * <td><center><sup>j=1</sup></center></td>
	 * <td></td>
	 * </tr>
	 * </table>
	 * </i></center> det A is calculated after row 1, n is 4 here (4x4 matrix):
	 * <center><i>
	 * <table cellspacing="0" cellpadding="0" border="0">
	 * <tr>
	 * <td></td>
	 * <td><center><sub>4</sub></center></td>
	 * <td></td>
	 * </tr>
	 * <tr>
	 * <td>det A =</td>
	 * <td><center>&#8721;</center></td>
	 * <td>(-1)<sup>1+j</sup>*a<sub>1j</sub>*det A<sub>1j</sub></td>
	 * </tr>
	 * <tr>
	 * <td></td>
	 * <td><center><sup>j=1</sup></center></td>
	 * <td></td>
	 * </tr>
	 * </table>
	 * =<br/>
	 * a<sub>11</sub>*det A<sub>11</sub> -a<sub>12</sub>*det A<sub>12</sub>
	 * +a<sub>13</sub>*det A<sub>13</sub> -a<sub>14</sub>*det A<sub>14</sub>
	 * </i></center> det A<sub>1j</sub> are similarly calculated, that is the
	 * determinant of each sub matrix is calculated by its 1st row, which
	 * actually is the 2nd row of A. That makes 6 sub-determinantes, which are
	 * 2x2 matrices of the 3rd and 4th row of the original matrix. These
	 * determinates are directly calculated.
	 * </p>
	 * 
	 * @param i_a the matrix, must not be null
	 * @return det(a)
	 * @see http://en.wikipedia.org/wiki/Determinant
	 * @see http://en.wikipedia.org/wiki/Laplace_expansion
	 * @see http://de.wikipedia.org/wiki/Determinante_(Mathematik)
	 */

	public static float determinant(IMatrix4f i_a) {
		Matrix4fImpl m = Matrix4fImpl.cast(i_a);

		// calculate the determinantes of the 6 sub matrices, the 1st row
		// of each sub matrix is from the 3rd row of the original matrix, and
		// the 2nd row of the 4th row.
		// The index name indicates the columns in the original matrix:
		float d12 = m.a31 * m.a42 - m.a32 * m.a41;
		float d13 = m.a31 * m.a43 - m.a33 * m.a41;
		float d14 = m.a31 * m.a44 - m.a34 * m.a41;
		float d23 = m.a32 * m.a43 - m.a33 * m.a42;
		float d24 = m.a32 * m.a44 - m.a34 * m.a42;
		float d34 = m.a33 * m.a44 - m.a34 * m.a43;

		// after row 1, each sub determinant is calculated after row 2
		return m.a11 * (m.a22 * d34 - m.a23 * d24 + m.a24 * d23) //
			- m.a12 * (m.a21 * d34 - m.a23 * d14 + m.a24 * d13) //
			+ m.a13 * (m.a21 * d24 - m.a22 * d14 + m.a24 * d12) //
			- m.a14 * (m.a21 * d23 - m.a22 * d13 + m.a23 * d12);
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
	 * @param o_result may be null, if matrix cannot be inverted
	 * @return o_result (if not null), or a new instance
	 * @see http://en.wikipedia.org/wiki/Invertible_matrix
	 */
	public static Matrix4f invert(IMatrix4f i_source, Matrix4f o_result) {

		float detSource = determinant(i_source);
		if (detSource == 0) {
			return null; // matrix in not invertible!
		}

		Matrix4fImpl m = Matrix4fImpl.cast(i_source);

		Matrix4fImpl result;
		if (o_result == null) {
			result = new Matrix4fImpl();
			o_result = result;
		} else {
			result = Matrix4fImpl.cast(o_result);
		}

		// use blockwise inversion
		// calculate blocks
		// AB
		// CD
		Matrix2fImpl A = new Matrix2fImpl(m.a11, m.a12, m.a21, m.a22, false);
		Matrix2fImpl B = new Matrix2fImpl(m.a13, m.a14, m.a23, m.a24, false);
		Matrix2fImpl C = new Matrix2fImpl(m.a31, m.a32, m.a41, m.a42, false);
		Matrix2fImpl D = new Matrix2fImpl(m.a33, m.a34, m.a43, m.a44, false);

		// A^{-1}
		Matrix2fImpl Ainv = new Matrix2fImpl();

		invert(A, Ainv);

		// CA^{-1}
		Matrix2fImpl C_Ainv = new Matrix2fImpl();
		mul(C, Ainv, C_Ainv);

		// D−CA^{-1}B
		Matrix2fImpl SchurInv = new Matrix2fImpl();
		mul(C_Ainv, B, SchurInv);
		sub(D, SchurInv, SchurInv);
		invert(SchurInv, SchurInv);

		// A^{-1}B
		Matrix2fImpl Ainv_B = new Matrix2fImpl();
		mul(Ainv, B, Ainv_B);

		// calculate result blocks:
		mul(Ainv_B, SchurInv, A);
		negate(A, B); // this is B
		mul(A, C_Ainv, A);
		add(Ainv, A, A); // this is A
		mul(SchurInv, C_Ainv, C);
		negate(C, C); // this is C
		D = SchurInv; // this is D

		result.a11 = A.a11;
		result.a12 = A.a12;
		result.a21 = A.a21;
		result.a22 = A.a22;

		result.a13 = B.a11;
		result.a14 = B.a12;
		result.a23 = B.a21;
		result.a24 = B.a22;

		result.a31 = C.a11;
		result.a32 = C.a12;
		result.a41 = C.a21;
		result.a42 = C.a22;

		result.a33 = D.a11;
		result.a34 = D.a12;
		result.a43 = D.a21;
		result.a44 = D.a22;

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
	public static Matrix4f negate(IMatrix4f i_source, Matrix4f o_result) {
		Matrix4fImpl m = Matrix4fImpl.cast(i_source);
		Matrix4fImpl result;
		if (o_result == null) {
			result = new Matrix4fImpl();
		} else {
			result = Matrix4fImpl.cast(o_result);
		}

		result.a11 = -m.a11;
		result.a12 = -m.a12;
		result.a13 = -m.a13;
		result.a14 = -m.a14;

		result.a21 = -m.a21;
		result.a22 = -m.a22;
		result.a23 = -m.a23;
		result.a24 = -m.a24;

		result.a31 = -m.a31;
		result.a32 = -m.a32;
		result.a33 = -m.a33;
		result.a34 = -m.a34;

		result.a41 = -m.a41;
		result.a42 = -m.a42;
		result.a43 = -m.a43;
		result.a44 = -m.a44;

		if (o_result != result && o_result != null)
			o_result.set(result);

		return result;
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
	public static Matrix4f transpose(IMatrix4f i_source, Matrix4f o_result) {
		Matrix4fImpl m = Matrix4fImpl.cast(i_source);
		Matrix4fImpl result;
		if (o_result == null) { // identical parameters are handled below
			result = new Matrix4fImpl();
			o_result = result;
		} else {
			result = Matrix4fImpl.cast(o_result);
		}

		if (result == m) { // use temp var, do not copy diagonal entries
			float t;
			t = result.a12;
			result.a12 = m.a21;
			result.a21 = t;

			t = result.a13;
			result.a13 = m.a31;
			result.a31 = t;

			t = result.a14;
			result.a14 = m.a41;
			result.a41 = t;

			t = result.a23;
			result.a23 = m.a32;
			result.a32 = t;

			t = result.a24;
			result.a24 = m.a42;
			result.a42 = t;

			t = result.a34;
			result.a34 = m.a43;
			result.a43 = t;
		} else { // no temp var necessary, copy all entries
			result.a11 = m.a11;
			result.a22 = m.a22;
			result.a33 = m.a33;
			result.a44 = m.a44;

			result.a12 = m.a21;
			result.a21 = m.a12;

			result.a13 = m.a31;
			result.a31 = m.a13;

			result.a14 = m.a41;
			result.a41 = m.a14;

			result.a23 = m.a32;
			result.a32 = m.a23;

			result.a24 = m.a42;
			result.a42 = m.a24;

			result.a34 = m.a43;
			result.a43 = m.a34;
		}

		if (o_result != result)
			o_result.set(result);

		return o_result;
	}

}
