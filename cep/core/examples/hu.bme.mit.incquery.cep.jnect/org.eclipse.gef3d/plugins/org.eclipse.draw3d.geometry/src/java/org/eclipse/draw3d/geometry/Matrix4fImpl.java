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
 * Implementation of a {@link Matrix4f} backed by single float fields.
 * <p>
 * For an explanation of row- and column-major format, see interface
 * {@link IMatrix4f}.
 * </p>
 * <p>
 * The matrix is internally stored using float fields. This is how these fields
 * are stored:
 * <table>
 * <tr>
 * <td>a11</td>
 * <td>a12</td>
 * <td>a13</td>
 * <td>a14</td>
 * </tr>
 * <tr>
 * <td>a21</td>
 * <td>a22</td>
 * <td>a23</td>
 * <td>a24</td>
 * </tr>
 * <tr>
 * <td>a31</td>
 * <td>a32</td>
 * <td>a33</td>
 * <td>a34</td>
 * </tr>
 * <tr>
 * <td>a41</td>
 * <td>a42</td>
 * <td>a43</td>
 * <td>a44</td>
 * </tr>
 * </table>
 * This is how matrix algorithms are usually explained.
 * </p>
 * 
 * @author Jens von Pilgrim, Matthias Thiele
 * @version $Revision$
 * @since Dec 16, 2008
 */
public final class Matrix4fImpl implements Matrix4f, Serializable, Cloneable {

	/**
	 * @see java.io.Serializable
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Casts any {@link IMatrix4f} matrix into a {@link Matrix4fImpl},# either
	 * by casting or copying. The returned object is of type
	 * {@link Matrix4fImpl} and thus it is mutable. Since the object may be
	 * identical to the given, immutable one, the client of this method must
	 * ensure not to modify the returned object. This method is heavily used in
	 * {@link Math3D} for performance issues.
	 * 
	 * @param i_sourceMatrix4f The source matrix.
	 * @return Matrix4fImpl which is equals to given IMatrix4f
	 */
	static Matrix4fImpl cast(IMatrix4f i_sourceMatrix4f) {

		if (i_sourceMatrix4f instanceof Matrix4fImpl) {
			return (Matrix4fImpl) i_sourceMatrix4f;
		} else {
			return new Matrix4fImpl(i_sourceMatrix4f);
		}
	}

	public float a11;

	public float a12;

	public float a13;

	public float a14;

	public float a21;

	public float a22;

	public float a23;

	public float a24;

	public float a31;

	public float a32;

	public float a33;

	public float a34;

	public float a41;

	public float a42;

	public float a43;

	public float a44;

	/**
	 * Empty constructor, creates this matrix as an identity matrix. This
	 * constructor is pretty fast.
	 */
	public Matrix4fImpl() {

		// all values are initialized with 0f, see Java Spec
		a11 = 1;
		a22 = 1;
		a33 = 1;
		a44 = 1;
	}

	/**
	 * Constructs a matrix4f from an array of float, starting at offset 0. The
	 * values are read in row-major or column-major (OpenGL) format, depending
	 * on parameter <code>i_bColumnMajor</code>.
	 * 
	 * @param i_arrayOfFloat Values are read from this array
	 * @param i_bColumnMajor the matrix is stored in column major (OpenGL)
	 *            format
	 */
	public Matrix4fImpl(final float[] i_arrayOfFloat,
			final boolean i_bColumnMajor) {

		this(i_arrayOfFloat, i_bColumnMajor, 0);
	}

	/**
	 * Constructs a matrix4f from an array of float, starting at given offset.
	 * The values are read in row-major or column-major (OpenGL) format,
	 * depending on parameter <code>i_bColumnMajor</code>.
	 * 
	 * @param i_arrayOfFloat Values are read from this array
	 * @param i_bColumnMajor the matrix is stored in column major (OpenGL)
	 *            format
	 * @param i_offset Get values from array with this offset.
	 */
	public Matrix4fImpl(final float[] i_arrayOfFloat,
			final boolean i_bColumnMajor, int i_offset) {
		int offset = i_offset;
		if (i_bColumnMajor) {
			this.a11 = i_arrayOfFloat[offset++];
			this.a21 = i_arrayOfFloat[offset++];
			this.a31 = i_arrayOfFloat[offset++];
			this.a41 = i_arrayOfFloat[offset++];
			this.a12 = i_arrayOfFloat[offset++];
			this.a22 = i_arrayOfFloat[offset++];
			this.a32 = i_arrayOfFloat[offset++];
			this.a42 = i_arrayOfFloat[offset++];
			this.a13 = i_arrayOfFloat[offset++];
			this.a23 = i_arrayOfFloat[offset++];
			this.a33 = i_arrayOfFloat[offset++];
			this.a43 = i_arrayOfFloat[offset++];
			this.a14 = i_arrayOfFloat[offset++];
			this.a24 = i_arrayOfFloat[offset++];
			this.a34 = i_arrayOfFloat[offset++];
			this.a44 = i_arrayOfFloat[offset];
		} else {
			this.a11 = i_arrayOfFloat[offset++];
			this.a12 = i_arrayOfFloat[offset++];
			this.a13 = i_arrayOfFloat[offset++];
			this.a14 = i_arrayOfFloat[offset++];
			this.a21 = i_arrayOfFloat[offset++];
			this.a22 = i_arrayOfFloat[offset++];
			this.a23 = i_arrayOfFloat[offset++];
			this.a24 = i_arrayOfFloat[offset++];
			this.a31 = i_arrayOfFloat[offset++];
			this.a32 = i_arrayOfFloat[offset++];
			this.a33 = i_arrayOfFloat[offset++];
			this.a34 = i_arrayOfFloat[offset++];
			this.a41 = i_arrayOfFloat[offset++];
			this.a42 = i_arrayOfFloat[offset++];
			this.a43 = i_arrayOfFloat[offset++];
			this.a44 = i_arrayOfFloat[offset];
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
	public Matrix4fImpl(final FloatBuffer i_buffer, final boolean i_bColumnMajor) {

		if (!i_bColumnMajor) {
			setRowMajor(i_buffer);
		} else {
			setColumnMajor(i_buffer);
		}
	}

	/**
	 * Constructs a matrix4f from a source matrix.
	 * 
	 * @param i_sourceMatrix4f The source matrix.
	 */
	public Matrix4fImpl(final IMatrix4f i_sourceMatrix4f) {

		if (i_sourceMatrix4f == null)
			throw new NullPointerException("i_sourceMatrix4f must not be null");

		// calling set here can lead to stack overflow
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				set(i, j, i_sourceMatrix4f.get(i, j));
	}

	/**
	 * Creates this matrix and sets its values, values are given in row major as
	 * the parameter indices indicate.
	 * <p>
	 * This method is basically used for testing, as in the program, matrices
	 * are rarely created that way.
	 * </p>
	 */
	public Matrix4fImpl(float a11, float a12, float a13, float a14, //
			float a21, float a22, float a23, float a24, //
			float a31, float a32, float a33, float a34, //
			float a41, float a42, float a43, float a44) {
		this.a11 = a11;
		this.a12 = a12;
		this.a13 = a13;
		this.a14 = a14;
		this.a21 = a21;
		this.a22 = a22;
		this.a23 = a23;
		this.a24 = a24;
		this.a31 = a31;
		this.a32 = a32;
		this.a33 = a33;
		this.a34 = a34;
		this.a41 = a41;
		this.a42 = a42;
		this.a43 = a43;
		this.a44 = a44;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {

		return new Matrix4fImpl(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix4f#equals(org.eclipse.draw3d.geometry.IMatrix4f)
	 */
	public boolean equals(final IMatrix4f i_anotherMatrix4f) {

		if (this == i_anotherMatrix4f)
			return true;
		if (i_anotherMatrix4f == null)
			return false;
		Matrix4fImpl sm = cast(i_anotherMatrix4f);
		return a11 == sm.a11 && a12 == sm.a12 && a13 == sm.a13 && a14 == sm.a14
			&& //
			a21 == sm.a21 && a22 == sm.a22 && a23 == sm.a23 && a24 == sm.a24 && //
			a31 == sm.a31 && a32 == sm.a32 && a33 == sm.a33 && a34 == sm.a34 && //
			a41 == sm.a41 && a42 == sm.a42 && a43 == sm.a43 && a44 == sm.a44;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object i_obj) {
		if (i_obj == null || !(i_obj instanceof IMatrix4f))
			return false;
		return equals((IMatrix4f) i_obj);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {

		float[] af = new float[16];
		toArrayRowMajor(af);
		return Arrays.hashCode(af);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix4f#set(org.eclipse.draw3d.geometry.IMatrix4f)
	 */
	public void set(final IMatrix4f i_sourceMatrix4f) {

		Matrix4fImpl src = cast(i_sourceMatrix4f);

		this.a11 = src.a11;
		this.a12 = src.a12;
		this.a13 = src.a13;
		this.a14 = src.a14;
		this.a21 = src.a21;
		this.a22 = src.a22;
		this.a23 = src.a23;
		this.a24 = src.a24;
		this.a31 = src.a31;
		this.a32 = src.a32;
		this.a33 = src.a33;
		this.a34 = src.a34;
		this.a41 = src.a41;
		this.a42 = src.a42;
		this.a43 = src.a43;
		this.a44 = src.a44;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix4f#get(int, int)
	 */
	public float get(int i_row, int i_column) {

		if (i_row < 0 || i_row >= 4)
			throw new IllegalArgumentException("row index out of bounds: "
				+ i_row);

		if (i_column < 0 || i_column >= 4)
			throw new IllegalArgumentException("column index out of bounds: "
				+ i_column);

		if (i_row == 0) {
			if (i_column == 0)
				return a11;
			else if (i_column == 1)
				return a12;
			else if (i_column == 2)
				return a13;
			else
				return a14;
		} else if (i_row == 1) {
			if (i_column == 0)
				return a21;
			else if (i_column == 1)
				return a22;
			else if (i_column == 2)
				return a23;
			else
				return a24;
		} else if (i_row == 2) {
			if (i_column == 0)
				return a31;
			else if (i_column == 1)
				return a32;
			else if (i_column == 2)
				return a33;
			else
				return a34;
		} else {
			if (i_column == 0)
				return a41;
			else if (i_column == 1)
				return a42;
			else if (i_column == 2)
				return a43;
			else
				return a44;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix#set(int, int, float)
	 */
	public void set(int i_row, int i_column, float i_value) {

		if (i_row < 0 || i_row >= 4)
			throw new IllegalArgumentException("row index out of bounds: "
				+ i_row);

		if (i_column < 0 || i_column >= 4)
			throw new IllegalArgumentException("column index out of bounds: "
				+ i_column);

		if (i_row == 0) {
			if (i_column == 0)
				a11 = i_value;
			else if (i_column == 1)
				a12 = i_value;
			else if (i_column == 2)
				a13 = i_value;
			else
				a14 = i_value;
		} else if (i_row == 1) {
			if (i_column == 0)
				a21 = i_value;
			else if (i_column == 1)
				a22 = i_value;
			else if (i_column == 2)
				a23 = i_value;
			else
				a24 = i_value;
		} else if (i_row == 2) {
			if (i_column == 0)
				a31 = i_value;
			else if (i_column == 1)
				a32 = i_value;
			else if (i_column == 2)
				a33 = i_value;
			else
				a34 = i_value;
		} else {
			if (i_column == 0)
				a41 = i_value;
			else if (i_column == 1)
				a42 = i_value;
			else if (i_column == 2)
				a43 = i_value;
			else
				a44 = i_value;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix#setColumnMajor(float[])
	 */
	public void setColumnMajor(float[] i_arrayOfFloat) {

		this.a11 = i_arrayOfFloat[0];
		this.a21 = i_arrayOfFloat[1];
		this.a31 = i_arrayOfFloat[2];
		this.a41 = i_arrayOfFloat[3];
		this.a12 = i_arrayOfFloat[4];
		this.a22 = i_arrayOfFloat[5];
		this.a32 = i_arrayOfFloat[6];
		this.a42 = i_arrayOfFloat[7];
		this.a13 = i_arrayOfFloat[8];
		this.a23 = i_arrayOfFloat[9];
		this.a33 = i_arrayOfFloat[10];
		this.a43 = i_arrayOfFloat[11];
		this.a14 = i_arrayOfFloat[12];
		this.a24 = i_arrayOfFloat[13];
		this.a34 = i_arrayOfFloat[14];
		this.a44 = i_arrayOfFloat[15];
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix4f#setColumnMajor(java.nio.FloatBuffer)
	 */
	public void setColumnMajor(final FloatBuffer i_floatBuffer) {

		this.a11 = i_floatBuffer.get();
		this.a21 = i_floatBuffer.get();
		this.a31 = i_floatBuffer.get();
		this.a41 = i_floatBuffer.get();
		this.a12 = i_floatBuffer.get();
		this.a22 = i_floatBuffer.get();
		this.a32 = i_floatBuffer.get();
		this.a42 = i_floatBuffer.get();
		this.a13 = i_floatBuffer.get();
		this.a23 = i_floatBuffer.get();
		this.a33 = i_floatBuffer.get();
		this.a43 = i_floatBuffer.get();
		this.a14 = i_floatBuffer.get();
		this.a24 = i_floatBuffer.get();
		this.a34 = i_floatBuffer.get();
		this.a44 = i_floatBuffer.get();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix4f#setIdentity()
	 */
	public void setIdentity() {

		this.a11 = 1.0f;
		this.a12 = 0.0f;
		this.a13 = 0.0f;
		this.a14 = 0.0f;
		this.a21 = 0.0f;
		this.a22 = 1.0f;
		this.a23 = 0.0f;
		this.a24 = 0.0f;
		this.a31 = 0.0f;
		this.a32 = 0.0f;
		this.a33 = 1.0f;
		this.a34 = 0.0f;
		this.a41 = 0.0f;
		this.a42 = 0.0f;
		this.a43 = 0.0f;
		this.a44 = 1.0f;
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
		a14 = i_arrayOfFloat[3];

		a21 = i_arrayOfFloat[4];
		a22 = i_arrayOfFloat[5];
		a23 = i_arrayOfFloat[6];
		a24 = i_arrayOfFloat[7];

		a31 = i_arrayOfFloat[8];
		a32 = i_arrayOfFloat[9];
		a33 = i_arrayOfFloat[10];
		a34 = i_arrayOfFloat[11];

		a41 = i_arrayOfFloat[12];
		a42 = i_arrayOfFloat[13];
		a43 = i_arrayOfFloat[14];
		a44 = i_arrayOfFloat[15];

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix4f#setRowMajor(java.nio.FloatBuffer)
	 */
	public void setRowMajor(final FloatBuffer i_floatBuffer) {

		this.a11 = i_floatBuffer.get();
		this.a12 = i_floatBuffer.get();
		this.a13 = i_floatBuffer.get();
		this.a14 = i_floatBuffer.get();
		this.a21 = i_floatBuffer.get();
		this.a22 = i_floatBuffer.get();
		this.a23 = i_floatBuffer.get();
		this.a24 = i_floatBuffer.get();
		this.a31 = i_floatBuffer.get();
		this.a32 = i_floatBuffer.get();
		this.a33 = i_floatBuffer.get();
		this.a34 = i_floatBuffer.get();
		this.a41 = i_floatBuffer.get();
		this.a42 = i_floatBuffer.get();
		this.a43 = i_floatBuffer.get();
		this.a44 = i_floatBuffer.get();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix4f#setZero()
	 */
	public void setZero() {

		this.a11 = 0.0f;
		this.a12 = 0.0f;
		this.a13 = 0.0f;
		this.a14 = 0.0f;
		this.a21 = 0.0f;
		this.a22 = 0.0f;
		this.a23 = 0.0f;
		this.a24 = 0.0f;
		this.a31 = 0.0f;
		this.a32 = 0.0f;
		this.a33 = 0.0f;
		this.a34 = 0.0f;
		this.a41 = 0.0f;
		this.a42 = 0.0f;
		this.a43 = 0.0f;
		this.a44 = 0.0f;
	}

	/**
	 * {@inheritDoc} Returns 16.
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix#size()
	 */
	public int size() {

		return 16;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix4f#toArrayColumnMajor(float[])
	 */
	public void toArrayColumnMajor(final float[] o_arrayOfFloat) {

		this.toArrayColumnMajor(o_arrayOfFloat, 0);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix4f#toArrayColumnMajor(float[],
	 *      int)
	 */
	public void toArrayColumnMajor(final float[] o_arrayOfFloat, int i_offset) {
		int offset = i_offset;
		o_arrayOfFloat[offset++] = a11;
		o_arrayOfFloat[offset++] = a21;
		o_arrayOfFloat[offset++] = a31;
		o_arrayOfFloat[offset++] = a41;
		o_arrayOfFloat[offset++] = a12;
		o_arrayOfFloat[offset++] = a22;
		o_arrayOfFloat[offset++] = a32;
		o_arrayOfFloat[offset++] = a42;
		o_arrayOfFloat[offset++] = a13;
		o_arrayOfFloat[offset++] = a23;
		o_arrayOfFloat[offset++] = a33;
		o_arrayOfFloat[offset++] = a43;
		o_arrayOfFloat[offset++] = a14;
		o_arrayOfFloat[offset++] = a24;
		o_arrayOfFloat[offset++] = a34;
		o_arrayOfFloat[offset++] = a44;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix4f#toArrayRowMajor(float[])
	 */
	public void toArrayRowMajor(final float[] o_arrayOfFloat) {

		this.toArrayRowMajor(o_arrayOfFloat, 0);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix4f#toArrayRowMajor(float[], int)
	 */
	public void toArrayRowMajor(final float[] o_arrayOfFloat, int i_offset) {
		int offset = i_offset;
		o_arrayOfFloat[offset++] = a11;
		o_arrayOfFloat[offset++] = a12;
		o_arrayOfFloat[offset++] = a13;
		o_arrayOfFloat[offset++] = a14;
		o_arrayOfFloat[offset++] = a21;
		o_arrayOfFloat[offset++] = a22;
		o_arrayOfFloat[offset++] = a23;
		o_arrayOfFloat[offset++] = a24;
		o_arrayOfFloat[offset++] = a31;
		o_arrayOfFloat[offset++] = a32;
		o_arrayOfFloat[offset++] = a33;
		o_arrayOfFloat[offset++] = a34;
		o_arrayOfFloat[offset++] = a41;
		o_arrayOfFloat[offset++] = a42;
		o_arrayOfFloat[offset++] = a43;
		o_arrayOfFloat[offset] = a44;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix4f#toBufferColumnMajor(java.nio.FloatBuffer)
	 */
	public void toBufferColumnMajor(final FloatBuffer o_floatBuffer) {

		o_floatBuffer.put(a11);
		o_floatBuffer.put(a21);
		o_floatBuffer.put(a31);
		o_floatBuffer.put(a41);
		o_floatBuffer.put(a12);
		o_floatBuffer.put(a22);
		o_floatBuffer.put(a32);
		o_floatBuffer.put(a42);
		o_floatBuffer.put(a13);
		o_floatBuffer.put(a23);
		o_floatBuffer.put(a33);
		o_floatBuffer.put(a43);
		o_floatBuffer.put(a14);
		o_floatBuffer.put(a24);
		o_floatBuffer.put(a34);
		o_floatBuffer.put(a44);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix4f#toBufferRowMajor(java.nio.FloatBuffer)
	 */
	public void toBufferRowMajor(final FloatBuffer o_floatBuffer) {

		o_floatBuffer.put(a11);
		o_floatBuffer.put(a12);
		o_floatBuffer.put(a13);
		o_floatBuffer.put(a14);
		o_floatBuffer.put(a21);
		o_floatBuffer.put(a22);
		o_floatBuffer.put(a23);
		o_floatBuffer.put(a24);
		o_floatBuffer.put(a31);
		o_floatBuffer.put(a32);
		o_floatBuffer.put(a33);
		o_floatBuffer.put(a34);
		o_floatBuffer.put(a41);
		o_floatBuffer.put(a42);
		o_floatBuffer.put(a43);
		o_floatBuffer.put(a44);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return String.format(TO_STRING_FORMAT, String.valueOf(a11),
			String.valueOf(a12), String.valueOf(a13), String.valueOf(a14),
			String.valueOf(a21), String.valueOf(a22), String.valueOf(a23),
			String.valueOf(a24), String.valueOf(a31), String.valueOf(a32),
			String.valueOf(a33), String.valueOf(a34), String.valueOf(a41),
			String.valueOf(a42), String.valueOf(a43), String.valueOf(a44));
	}

}
