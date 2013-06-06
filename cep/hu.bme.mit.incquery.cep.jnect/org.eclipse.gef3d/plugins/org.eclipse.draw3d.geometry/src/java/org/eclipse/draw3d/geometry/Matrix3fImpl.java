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
 * Implementation of a {@link Matrix3f} backed by single float fields.
 * <p>
 * For an explanation of row- and column-major format, see interface
 * {@link IMatrix3f}.
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
public final class Matrix3fImpl implements Matrix3f, Serializable, Cloneable {

	/**
	 * @see java.io.Serializable
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Casts any {@link IMatrix3f} matrix into a {@link Matrix3fImpl},# either
	 * by casting or copying. The returned object is of type
	 * {@link Matrix3fImpl} and thus it is mutable. Since the object may be
	 * identical to the given, immutable one, the client of this method must
	 * ensure not to modify the returned object. This method is heavily used in
	 * {@link Math3D} for performance issues.
	 * 
	 * @param i_sourceMatrix3f The source matrix.
	 * @return Matrix3fImpl which is equals to given IMatrix4f
	 */
	static Matrix3fImpl cast(IMatrix3f i_sourceMatrix3f) {

		if (i_sourceMatrix3f instanceof Matrix3fImpl) {
			return (Matrix3fImpl) i_sourceMatrix3f;
		} else {
			return new Matrix3fImpl(i_sourceMatrix3f);
		}
	}

	public float a11;

	public float a12;

	public float a13;

	public float a21;

	public float a22;

	public float a23;

	public float a31;

	public float a32;

	public float a33;

	/**
	 * Empty constructor, creates this matrix as an identity matrix. This
	 * constructor is pretty fast.
	 */
	public Matrix3fImpl() {

		// all values are initialized with 0f, see Java Spec
		a11 = 1;
		a22 = 1;
		a33 = 1;
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
	public Matrix3fImpl(final float[] i_floats, boolean i_bColumnMajor) {

		if (!i_bColumnMajor) {
			a11 = i_floats[0];
			a12 = i_floats[1];
			a13 = i_floats[2];
			a21 = i_floats[3];
			a22 = i_floats[4];
			a23 = i_floats[5];
			a31 = i_floats[6];
			a32 = i_floats[7];
			a33 = i_floats[8];
		} else {
			a11 = i_floats[0];
			a21 = i_floats[1];
			a31 = i_floats[2];
			a12 = i_floats[3];
			a22 = i_floats[4];
			a32 = i_floats[5];
			a13 = i_floats[6];
			a23 = i_floats[7];
			a33 = i_floats[8];
		}
	}

	/**
	 * Creates this matrix and sets its values. The values are read in row-major
	 * or column-major (OpenGL) format, depending on parameter
	 * <code>i_bColumnMajor</code>.
	 * 
	 * @param i_floats , not null and i_floats.size()+i_iOffset >= 9 must be
	 *            true
	 * @param i_bColumnMajor the matrix is stored in column major (OpenGL)
	 *            format
	 * @param offset the first index to be used in array
	 */
	public Matrix3fImpl(final float[] i_floats, boolean i_bColumnMajor,
			int i_offset) {
		int offset = i_offset;
		if (!i_bColumnMajor) { // as we learned it in school:
			a11 = i_floats[offset++];
			a12 = i_floats[offset++];
			a13 = i_floats[offset++];
			a21 = i_floats[offset++];
			a22 = i_floats[offset++];
			a23 = i_floats[offset++];
			a31 = i_floats[offset++];
			a32 = i_floats[offset++];
			a33 = i_floats[offset];
		} else { // OpenGL:
			a11 = i_floats[offset++];
			a21 = i_floats[offset++];
			a31 = i_floats[offset++];
			a12 = i_floats[offset++];
			a22 = i_floats[offset++];
			a32 = i_floats[offset++];
			a13 = i_floats[offset++];
			a23 = i_floats[offset++];
			a33 = i_floats[offset];
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
	public Matrix3fImpl(final FloatBuffer i_buffer, boolean i_bColumnMajor) {

		if (!i_bColumnMajor) {
			setRowMajor(i_buffer);
		} else {
			setColumnMajor(i_buffer);
		}
	}

	/**
	 * Creates this matrix and sets its values to the given matrix.
	 */
	public Matrix3fImpl(final IMatrix3f src) {

		// do not use cast here to avoid endless loop
		// if given matrix is NOT an Matrix3fImpl
		if (src instanceof Matrix3fImpl) {
			Matrix3fImpl sm = (Matrix3fImpl) src;
			a11 = sm.a11;
			a12 = sm.a12;
			a13 = sm.a13;
			a21 = sm.a21;
			a22 = sm.a22;
			a23 = sm.a23;
			a31 = sm.a31;
			a32 = sm.a32;
			a33 = sm.a33;
		} else {
			float[] af = new float[9];
			src.toArrayRowMajor(af);
			setRowMajor(af);
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
	public Matrix3fImpl(float a11, float a12, float a13, //
			float a21, float a22, float a23, //
			float a31, float a32, float a33) {
		this.a11 = a11;
		this.a12 = a12;
		this.a13 = a13;
		this.a21 = a21;
		this.a22 = a22;
		this.a23 = a23;
		this.a31 = a31;
		this.a32 = a32;
		this.a33 = a33;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {

		return new Matrix3fImpl(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix3f#equals(org.eclipse.draw3d.geometry.IMatrix3f)
	 */
	public boolean equals(final IMatrix3f i_anotherMatrix3f) {

		if (this == i_anotherMatrix3f)
			return true;
		if (i_anotherMatrix3f == null)
			return false;
		Matrix3fImpl sm = cast(i_anotherMatrix3f);
		return a11 == sm.a11 && a12 == sm.a12 && a13 == sm.a13 && a21 == sm.a21
			&& a22 == sm.a22 && a23 == sm.a23 && a31 == sm.a31 && a32 == sm.a32
			&& a33 == sm.a33;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object i_obj) {
		if (i_obj == null || !(i_obj instanceof IMatrix3f))
			return false;
		return equals((IMatrix3f) i_obj);
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix#get(int, int)
	 */
	public float get(int i_row, int i_column) {

		if (i_row < 0 || i_row >= 3)
			throw new IllegalArgumentException("row index out of bounds: "
				+ i_row);

		if (i_column < 0 || i_column >= 3)
			throw new IllegalArgumentException("column index out of bounds: "
				+ i_column);

		if (i_row == 0) {
			if (i_column == 0)
				return a11;
			else if (i_column == 1)
				return a12;
			else
				return a13;
		} else if (i_row == 1) {
			if (i_column == 0)
				return a21;
			else if (i_column == 1)
				return a22;
			else
				return a23;
		} else {
			if (i_column == 0)
				return a31;
			else if (i_column == 1)
				return a32;
			else
				return a33;
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
	 * @see org.eclipse.draw3d.geometry.Matrix3f#set(org.eclipse.draw3d.geometry.IMatrix3f)
	 */
	public void set(final IMatrix3f i_sourceMatrix3f) {

		Matrix3fImpl sm = cast(i_sourceMatrix3f);
		a11 = sm.a11;
		a12 = sm.a12;
		a13 = sm.a13;
		a21 = sm.a21;
		a22 = sm.a22;
		a23 = sm.a23;
		a31 = sm.a31;
		a32 = sm.a32;
		a33 = sm.a33;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix#set(int, int, float)
	 */
	public void set(int i_row, int i_column, float i_value) {

		if (i_row < 0 || i_row >= 3)
			throw new IllegalArgumentException("row index out of bounds: "
				+ i_row);

		if (i_column < 0 || i_column >= 3)
			throw new IllegalArgumentException("column index out of bounds: "
				+ i_column);

		if (i_row == 0) {
			if (i_column == 0)
				a11 = i_value;
			else if (i_column == 1)
				a12 = i_value;
			else
				a13 = i_value;
		} else if (i_row == 1) {
			if (i_column == 0)
				a21 = i_value;
			else if (i_column == 1)
				a22 = i_value;
			else
				a23 = i_value;
		} else {
			if (i_column == 0)
				a31 = i_value;
			else if (i_column == 1)
				a32 = i_value;
			else
				a33 = i_value;
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
		a31 = i_arrayOfFloat[2];
		a12 = i_arrayOfFloat[3];
		a22 = i_arrayOfFloat[4];
		a32 = i_arrayOfFloat[5];
		a13 = i_arrayOfFloat[6];
		a23 = i_arrayOfFloat[7];
		a33 = i_arrayOfFloat[8];
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix3f#setColumnMajor(java.nio.FloatBuffer)
	 */
	public void setColumnMajor(FloatBuffer i_floatBuffer) {

		a11 = i_floatBuffer.get();
		a21 = i_floatBuffer.get();
		a31 = i_floatBuffer.get();
		a12 = i_floatBuffer.get();
		a22 = i_floatBuffer.get();
		a32 = i_floatBuffer.get();
		a13 = i_floatBuffer.get();
		a23 = i_floatBuffer.get();
		a33 = i_floatBuffer.get();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix3f#setIdentity()
	 */
	public void setIdentity() {

		a11 = 1;
		a12 = 0;
		a13 = 0;
		a21 = 0;
		a22 = 1;
		a23 = 0;
		a31 = 0;
		a32 = 0;
		a33 = 1;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix#setRowMajor(float[])
	 */
	public void setRowMajor(float[] i_arrayOfFloat) {

		a11 = i_arrayOfFloat[0];
		a12 = i_arrayOfFloat[1];
		a13 = i_arrayOfFloat[2];
		a21 = i_arrayOfFloat[3];
		a22 = i_arrayOfFloat[4];
		a23 = i_arrayOfFloat[5];
		a31 = i_arrayOfFloat[6];
		a32 = i_arrayOfFloat[7];
		a33 = i_arrayOfFloat[8];
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix3f#setRowMajor(java.nio.FloatBuffer)
	 */
	public void setRowMajor(FloatBuffer i_floatBuffer) {

		a11 = i_floatBuffer.get();
		a12 = i_floatBuffer.get();
		a13 = i_floatBuffer.get();
		a21 = i_floatBuffer.get();
		a22 = i_floatBuffer.get();
		a23 = i_floatBuffer.get();
		a31 = i_floatBuffer.get();
		a32 = i_floatBuffer.get();
		a33 = i_floatBuffer.get();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix3f#setZero()
	 */
	public void setZero() {

		a11 = 0;
		a12 = 0;
		a13 = 0;
		a21 = 0;
		a22 = 0;
		a23 = 0;
		a31 = 0;
		a32 = 0;
		a33 = 0;
	}

	/**
	 * {@inheritDoc} Returns 9.
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix#size()
	 */
	public int size() {

		return 9;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix3f#toArrayColumnMajor(float[])
	 */
	public void toArrayColumnMajor(final float[] o_arrayOfFloat) {

		o_arrayOfFloat[0] = a11;
		o_arrayOfFloat[1] = a21;
		o_arrayOfFloat[2] = a31;
		o_arrayOfFloat[3] = a12;
		o_arrayOfFloat[4] = a22;
		o_arrayOfFloat[5] = a32;
		o_arrayOfFloat[6] = a13;
		o_arrayOfFloat[7] = a23;
		o_arrayOfFloat[8] = a33;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix3f#toArrayColumnMajor(float[],
	 *      int)
	 */
	public void toArrayColumnMajor(final float[] o_arrayOfFloat, int i_offset) {
		int offset = i_offset;
		o_arrayOfFloat[offset++] = a11;
		o_arrayOfFloat[offset++] = a21;
		o_arrayOfFloat[offset++] = a31;
		o_arrayOfFloat[offset++] = a12;
		o_arrayOfFloat[offset++] = a22;
		o_arrayOfFloat[offset++] = a32;
		o_arrayOfFloat[offset++] = a13;
		o_arrayOfFloat[offset++] = a23;
		o_arrayOfFloat[offset] = a33;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix3f#toArrayRowMajor(float[])
	 */
	public void toArrayRowMajor(final float[] o_arrayOfFloat) {

		o_arrayOfFloat[0] = a11;
		o_arrayOfFloat[1] = a12;
		o_arrayOfFloat[2] = a13;
		o_arrayOfFloat[3] = a21;
		o_arrayOfFloat[4] = a22;
		o_arrayOfFloat[5] = a23;
		o_arrayOfFloat[6] = a31;
		o_arrayOfFloat[7] = a32;
		o_arrayOfFloat[8] = a33;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix3f#toArrayRowMajor(float[], int)
	 */
	public void toArrayRowMajor(final float[] o_arrayOfFloat, int i_offset) {
		int offset = i_offset;
		o_arrayOfFloat[offset++] = a11;
		o_arrayOfFloat[offset++] = a12;
		o_arrayOfFloat[offset++] = a13;
		o_arrayOfFloat[offset++] = a21;
		o_arrayOfFloat[offset++] = a22;
		o_arrayOfFloat[offset++] = a23;
		o_arrayOfFloat[offset++] = a31;
		o_arrayOfFloat[offset++] = a32;
		o_arrayOfFloat[offset] = a33;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix3f#toBufferColumnMajor(java.nio.FloatBuffer)
	 */
	public void toBufferColumnMajor(final FloatBuffer o_buffer) {

		o_buffer.put(a11);
		o_buffer.put(a21);
		o_buffer.put(a31);
		o_buffer.put(a12);
		o_buffer.put(a22);
		o_buffer.put(a32);
		o_buffer.put(a13);
		o_buffer.put(a23);
		o_buffer.put(a33);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix3f#toBufferRowMajor(java.nio.FloatBuffer)
	 */
	public void toBufferRowMajor(final FloatBuffer o_buffer) {

		o_buffer.put(a11);
		o_buffer.put(a12);
		o_buffer.put(a13);
		o_buffer.put(a21);
		o_buffer.put(a22);
		o_buffer.put(a23);
		o_buffer.put(a31);
		o_buffer.put(a32);
		o_buffer.put(a33);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return String.format(TO_STRING_FORMAT, String.valueOf(a11), String
			.valueOf(a12), String.valueOf(a13), String.valueOf(a21), String
			.valueOf(a22), String.valueOf(a23), String.valueOf(a31), String
			.valueOf(a32), String.valueOf(a33)

		);
	}

}
