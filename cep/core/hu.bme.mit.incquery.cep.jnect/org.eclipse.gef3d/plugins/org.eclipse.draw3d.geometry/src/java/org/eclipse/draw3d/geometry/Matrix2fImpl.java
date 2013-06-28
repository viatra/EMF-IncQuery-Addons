/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.geometry;

import java.io.Serializable;
import java.nio.FloatBuffer;
import java.util.Arrays;

/**
 * Implementation of a {@link Matrix2f} backed by single float fields.
 * <p>
 * For an explanation of row- and column-major format, see interface
 * {@link IMatrix2f}.
 * </p>
 * <p>
 * The matrix is internally stored using float fields. This is how these fields
 * are stored:
 * <table>
 * <tr>
 * <td>a11</td>
 * <td>a12</td>
 * <td>a13</td>
 * </tr>
 * <tr>
 * <td>a21</td>
 * <td>a22</td>
 * <td>a23</td>
 * </tr>
 * <tr>
 * <td>a31</td>
 * <td>a32</td>
 * <td>a33</td>
 * </tr>
 * </table>
 * This is how matrix algorithms are usually explained.
 * </p>
 * 
 * @author Jens von Pilgrim, Matthias Thiele
 * @version $Revision$
 * @since Dec 15, 2008
 */
public final class Matrix2fImpl implements Matrix2f, Serializable, Cloneable {
	/**
	 * @see java.io.Serializable
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Casts any {@link IMatrix2f} matrix into a {@link Matrix2fImpl},# either
	 * by casting or copying. The returned object is of type
	 * {@link Matrix2fImpl} and thus it is mutable. Since the object may be
	 * identical to the given, immutable one, the client of this method must
	 * ensure not to modify the returned object. This method is heavily used in
	 * {@link Math3D} for performance issues.
	 * 
	 * @param i_sourceMatrix2f The source matrix.
	 * @return Matrix2fImpl which is equals to given IMatrix4f
	 */
	static Matrix2fImpl cast(IMatrix2f i_sourceMatrix2f) {

		if (i_sourceMatrix2f instanceof Matrix2fImpl) {
			return (Matrix2fImpl) i_sourceMatrix2f;
		} else {
			return new Matrix2fImpl(i_sourceMatrix2f);
		}
	}

	public float a11;

	public float a12;

	public float a21;

	public float a22;

	/**
	 * Empty constructor, creates this matrix as an identity matrix. This
	 * constructor is pretty fast.
	 */
	public Matrix2fImpl() {

		// all values are initialized with 0f, see Java Spec
		a11 = 1;
		a22 = 1;
	}

	/**
	 * Creates this matrix and sets its values. The values are read in row-major
	 * or column-major (OpenGL) format, depending on parameter
	 * <code>i_bColumnMajor</code>.
	 * 
	 * @param i_floats , i_floats.size() >= 9 must be true
	 * @param i_bColumnMajor the matrix is stored in column major (OpenGL)
	 *            format
	 */
	public Matrix2fImpl(final float a, final float b, final float c,
			final float d, boolean i_bColumnMajor) {

		if (!i_bColumnMajor) {
			a11 = a;
			a12 = b;
			a21 = c;
			a22 = d;
		} else {
			a11 = a;
			a21 = b;
			a12 = c;
			a22 = d;
		}
	}

	/**
	 * Creates this matrix and sets its values, values are given in row major as
	 * the parameter indices indicate.
	 * <p>
	 * This method is basically used for testing, as in the program, matrices
	 * are rarely created that way.
	 * </p>
	 */
	public Matrix2fImpl(float a11, float a12, //
			float a21, float a22) {
		this.a11 = a11;
		this.a12 = a12;
		this.a21 = a21;
		this.a22 = a22;
	}

	/**
	 * Creates this matrix and sets its values. The values are read in row-major
	 * or column-major (OpenGL) format, depending on parameter
	 * <code>i_bColumnMajor</code>.
	 * 
	 * @param i_floats , i_floats.size() >= 9 must be true
	 * @param i_bColumnMajor the matrix is stored in column major (OpenGL)
	 *            format
	 */
	public Matrix2fImpl(final float[] i_floats, boolean i_bColumnMajor) {

		if (!i_bColumnMajor) {
			a11 = i_floats[0];
			a12 = i_floats[1];
			a21 = i_floats[2];
			a22 = i_floats[3];
		} else {
			a11 = i_floats[0];
			a21 = i_floats[1];
			a12 = i_floats[2];
			a22 = i_floats[3];
		}
	}

	/**
	 * Creates this matrix and sets its values. The values are read in row-major
	 * or column-major (OpenGL) format, depending on parameter
	 * <code>i_bColumnMajor</code>.
	 * 
	 * @param i_floats , not null and i_floats.size()+i_iOffset >= 4 must be
	 *            true
	 * @param i_bColumnMajor the matrix is stored in column major (OpenGL)
	 *            format
	 * @param offset the first index to be used in array
	 */
	public Matrix2fImpl(final float[] i_floats, boolean i_bColumnMajor,
			int i_offset) {
		int offset = i_offset;
		if (!i_bColumnMajor) { // as we learned it in school:
			a11 = i_floats[offset++];
			a12 = i_floats[offset++];
			a21 = i_floats[offset++];
			a22 = i_floats[offset];
		} else { // OpenGL:
			a11 = i_floats[offset++];
			a21 = i_floats[offset++];
			a12 = i_floats[offset++];
			a22 = i_floats[offset];
		}
	}

	/**
	 * Creates this matrix and sets its values. The values are read in row-major
	 * or column-major (OpenGL) format, depending on parameter
	 * <code>i_bColumnMajor</code>.
	 * 
	 * @param i_buffer the buffer with the source values
	 * @param i_bColumnMajor the matrix is stored in column major (OpenGL)
	 *            format
	 */
	public Matrix2fImpl(final FloatBuffer i_buffer, boolean i_bColumnMajor) {

		if (!i_bColumnMajor) {
			setRowMajor(i_buffer);
		} else {
			setColumnMajor(i_buffer);
		}
	}

	/**
	 * Creates this matrix and sets its values to the given matrix.
	 */
	public Matrix2fImpl(final IMatrix2f src) {

		set(src);
	}

	/**
	 * Creates this matrix and sets its values to the given matrix.
	 */
	public Matrix2fImpl(final Matrix2fImpl src) {

		a11 = src.a11;
		a12 = src.a12;
		a21 = src.a21;
		a22 = src.a22;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Matrix2fImpl(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix2f#equals(org.eclipse.draw3d.geometry.IMatrix2f)
	 */
	public boolean equals(final IMatrix2f i_anotherMatrix2f) {

		if (this == i_anotherMatrix2f)
			return true;
		if (i_anotherMatrix2f == null)
			return false;
		Matrix2fImpl sm = cast(i_anotherMatrix2f);
		return a11 == sm.a11 && a12 == sm.a12 && a21 == sm.a21 && a22 == sm.a22;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object i_obj) {
		if (i_obj == null || !(i_obj instanceof IMatrix2f))
			return false;
		return equals((IMatrix2f) i_obj);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix#get(int, int)
	 */
	public float get(int i_row, int i_column) {

		if (i_row < 0 || i_row >= 2)
			throw new IllegalArgumentException("row index out of bounds: "
				+ i_row);

		if (i_column < 0 || i_column >= 2)
			throw new IllegalArgumentException("column index out of bounds: "
				+ i_column);

		if (i_row == 0) {
			if (i_column == 0)
				return a11;
			else
				return a12;
		} else {
			if (i_column == 0)
				return a21;
			else
				return a22;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {

		float[] af = new float[9];
		toArrayRowMajor(af);
		return Arrays.hashCode(af);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix2f#set(org.eclipse.draw3d.geometry.IMatrix2f)
	 */
	public void set(final IMatrix2f i_sourceMatrix2f) {

		Matrix2fImpl sm = cast(i_sourceMatrix2f);
		a11 = sm.a11;
		a12 = sm.a12;
		a21 = sm.a21;
		a22 = sm.a22;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix#set(int, int, float)
	 */
	public void set(int i_row, int i_column, float i_value) {

		if (i_row < 0 || i_row >= 2)
			throw new IllegalArgumentException("row index out of bounds: "
				+ i_row);

		if (i_column < 0 || i_column >= 2)
			throw new IllegalArgumentException("column index out of bounds: "
				+ i_column);

		if (i_row == 0) {
			if (i_column == 0)
				a11 = i_value;
			else
				a12 = i_value;
		} else {
			if (i_column == 0)
				a21 = i_value;
			else
				a22 = i_value;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix#setColumnMajor(float[])
	 */
	public void setColumnMajor(float[] i_arrayOfFloat) {

		a11 = i_arrayOfFloat[0];
		a21 = i_arrayOfFloat[1];
		a12 = i_arrayOfFloat[2];
		a22 = i_arrayOfFloat[3];
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix2f#setColumnMajor(java.nio.FloatBuffer)
	 */
	public void setColumnMajor(FloatBuffer i_floatBuffer) {

		a11 = i_floatBuffer.get();
		a21 = i_floatBuffer.get();
		a12 = i_floatBuffer.get();
		a22 = i_floatBuffer.get();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix2f#setIdentity()
	 */
	public void setIdentity() {

		a11 = 1;
		a12 = 0;
		a21 = 0;
		a22 = 1;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix#setRowMajor(float[])
	 */
	public void setRowMajor(float[] i_arrayOfFloat) {

		a11 = i_arrayOfFloat[0];
		a12 = i_arrayOfFloat[1];
		a21 = i_arrayOfFloat[2];
		a22 = i_arrayOfFloat[3];

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix2f#setRowMajor(java.nio.FloatBuffer)
	 */
	public void setRowMajor(FloatBuffer i_floatBuffer) {

		a11 = i_floatBuffer.get();
		a12 = i_floatBuffer.get();
		a21 = i_floatBuffer.get();
		a22 = i_floatBuffer.get();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix2f#setZero()
	 */
	public void setZero() {

		a11 = 0;
		a12 = 0;
		a21 = 0;
		a22 = 0;
	}

	/**
	 * {@inheritDoc} Returns 4.
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix#size()
	 */
	public int size() {

		return 4;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix2f#toArrayColumnMajor(float[])
	 */
	public void toArrayColumnMajor(final float[] o_arrayOfFloat) {

		o_arrayOfFloat[0] = a11;
		o_arrayOfFloat[1] = a21;
		o_arrayOfFloat[2] = a12;
		o_arrayOfFloat[3] = a22;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix2f#toArrayColumnMajor(float[],
	 *      int)
	 */
	public void toArrayColumnMajor(final float[] o_arrayOfFloat, int i_offset) {
		int offset = i_offset;
		o_arrayOfFloat[offset++] = a11;
		o_arrayOfFloat[offset++] = a21;
		o_arrayOfFloat[offset++] = a12;
		o_arrayOfFloat[offset] = a22;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix2f#toArrayRowMajor(float[])
	 */
	public void toArrayRowMajor(final float[] o_arrayOfFloat) {

		o_arrayOfFloat[0] = a11;
		o_arrayOfFloat[1] = a12;
		o_arrayOfFloat[2] = a21;
		o_arrayOfFloat[3] = a22;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix2f#toArrayRowMajor(float[], int)
	 */
	public void toArrayRowMajor(final float[] o_arrayOfFloat, int i_offset) {
		int offset = i_offset;
		o_arrayOfFloat[offset++] = a11;
		o_arrayOfFloat[offset++] = a12;
		o_arrayOfFloat[offset++] = a21;
		o_arrayOfFloat[offset] = a22;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix2f#toBufferColumnMajor(java.nio.FloatBuffer)
	 */
	public void toBufferColumnMajor(final FloatBuffer o_buffer) {

		o_buffer.put(a11);
		o_buffer.put(a21);
		o_buffer.put(a12);
		o_buffer.put(a22);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix2f#toBufferRowMajor(java.nio.FloatBuffer)
	 */
	public void toBufferRowMajor(final FloatBuffer o_buffer) {

		o_buffer.put(a11);
		o_buffer.put(a12);
		o_buffer.put(a21);
		o_buffer.put(a22);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return String.format(TO_STRING_FORMAT, String.valueOf(a11), String
			.valueOf(a12), String.valueOf(a21), String.valueOf(a22));
	}

}
