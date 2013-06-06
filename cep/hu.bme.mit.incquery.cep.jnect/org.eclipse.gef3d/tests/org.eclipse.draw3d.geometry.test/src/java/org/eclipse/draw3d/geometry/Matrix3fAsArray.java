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
 * Implementation of a {@link Matrix3f} backed by an array. This implementation
 * is as nearly as fast as the field backed implementation.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Dec 15, 2008
 */
public class Matrix3fAsArray implements Matrix3f, Serializable, Cloneable {

	private final static float[] identity = { 1, 0, 0, 0, 1, 0, 0, 0, 1 };

	/**
	 * Gets a Matrix3fAsArray from a IMatrix3f either by casting or copy.
	 * 
	 * @param i_sourceMatrix3f The source matrix.
	 * @return Matrix3fImpl which is equals to given IMatrix3f
	 */
	static Matrix3fAsArray castToMatrix3fAsArray(IMatrix3f i_sourceMatrix3f) {

		if (i_sourceMatrix3f instanceof Matrix3fAsArray) {
			return (Matrix3fAsArray) i_sourceMatrix3f;
		} else {
			return new Matrix3fAsArray(i_sourceMatrix3f);
		}
	}

	float[] afloat;

	/**
	 * Empty constructor, creates this matrix as an identity matrix. This
	 * constructor is pretty fast.
	 */
	public Matrix3fAsArray() {

		afloat = new float[9]; // all values are initialized with 0f, see Java
		// Spec
		afloat[0] = 1;
		afloat[4] = 1;
		afloat[8] = 1;
	}

	/**
	 * Creates this matrix and sets its values to the values of the given float
	 * array, the matrix is optionally transposed. The array size must be equal
	 * or greater 9.
	 * 
	 * @param i_floats , i_floats.size() >= 9 must be true
	 * @param i_bColumnMajor the matrix is transposed if true
	 */
	public Matrix3fAsArray(final float[] i_floats, boolean i_bColumnMajor) {

		afloat = new float[9];
		if (!i_bColumnMajor) {
			System.arraycopy(i_floats, 0, afloat, 0, 9);
		} else {
			afloat[0] = i_floats[0];
			afloat[3] = i_floats[1];
			afloat[6] = i_floats[2];
			afloat[1] = i_floats[3];
			afloat[4] = i_floats[4];
			afloat[7] = i_floats[5];
			afloat[2] = i_floats[6];
			afloat[5] = i_floats[7];
			afloat[8] = i_floats[8];
		}
	}

	/**
	 * Creates this matrix and sets its values to the values of the given float
	 * array, the matrix is optionally transposed. The array size must be equal
	 * or greater 9+i_iOffset.
	 * 
	 * @param i_floats , i_floats.size()+i_iOffset >= 9 must be true
	 * @param i_bColumnMajor the matrix is transposed if true
	 * @param i_iOffset the first index to be used in array
	 */
	public Matrix3fAsArray(final float[] i_floats, boolean i_bColumnMajor,
			int i_iOffset) {

		afloat = new float[9];
		if (!i_bColumnMajor) {
			System.arraycopy(i_floats, i_iOffset, afloat, 0, 9);
		} else {
			afloat[0] = i_floats[i_iOffset++];
			afloat[3] = i_floats[i_iOffset++];
			afloat[6] = i_floats[i_iOffset++];
			afloat[1] = i_floats[i_iOffset++];
			afloat[4] = i_floats[i_iOffset++];
			afloat[7] = i_floats[i_iOffset++];
			afloat[2] = i_floats[i_iOffset++];
			afloat[5] = i_floats[i_iOffset++];
			afloat[8] = i_floats[i_iOffset];
		}
	}

	/**
	 * Creates this matrix and sets its values to the values of the given
	 * buffer, the matrix is optionally transposed. The buffer is not rewound
	 * before accessed.
	 * 
	 * @param i_buffer the buffer with the source values
	 * @param i_bIsTranspose the matrix is transposed if true
	 */
	public Matrix3fAsArray(final FloatBuffer i_buffer, boolean i_bIsTranspose) {

		afloat = new float[9];
		if (!i_bIsTranspose) {
			setRowMajor(i_buffer);
		} else {
			setColumnMajor(i_buffer);
		}
	}

	/**
	 * Creates this matrix and sets its values to the given matrix.
	 */
	public Matrix3fAsArray(final IMatrix3f src) {

		afloat = new float[9];
		src.toArrayRowMajor(afloat);
	}

	// /**
	// * {@inheritDoc}
	// * @see org.eclipse.draw3d.geometry.IMatrix3f#get(int)
	// */
	// public float get(int i_index) {
	// return afloat[i_index];
	// }

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {

		return new Matrix3fAsArray(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix3f#equals(org.eclipse.draw3d.geometry.IMatrix3f)
	 */
	public boolean equals(final IMatrix3f i_anotherMatrix3f) {

		float[] af;
		if (i_anotherMatrix3f instanceof Matrix3fAsArray) {
			// this is very slow:
			// return Arrays.equals(afloat,
			// ((Matrix3fAsArray) i_anotherMatrix3f).afloat);

			af = ((Matrix3fAsArray) i_anotherMatrix3f).afloat;
		} else {
			af = new float[9];
			i_anotherMatrix3f.toArrayRowMajor(af);
		}
		for (int i = 0; i < 9; i++) {
			if (afloat[i] != af[i])
				return false;
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix#get(int, int)
	 */
	public float get(int i_row, int i_column) {

		return afloat[i_row * 3 + i_column];
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {

		return Arrays.hashCode(afloat);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix3f#set(org.eclipse.draw3d.geometry.IMatrix3f)
	 */
	public void set(final IMatrix3f i_sourceMatrix3f) {

		i_sourceMatrix3f.toArrayRowMajor(afloat);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix#set(int, int, float)
	 */
	public void set(int i_row, int i_column, float i_value) {

		afloat[i_row * 3 + i_column] = i_value;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix#setColumnMajor(float[])
	 */
	public void setColumnMajor(float[] i_arrayOfFloat) {

		for (int c = 0; c < 3; c++)
			for (int r = 0; r < 3; r++)
				afloat[r * 3 + c] = i_arrayOfFloat[c * 3 + r];
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix3f#setColumnMajor(java.nio.FloatBuffer)
	 */
	public void setColumnMajor(final FloatBuffer i_floatBuffer) {

		afloat[0] = i_floatBuffer.get();
		afloat[3] = i_floatBuffer.get();
		afloat[6] = i_floatBuffer.get();
		afloat[1] = i_floatBuffer.get();
		afloat[4] = i_floatBuffer.get();
		afloat[7] = i_floatBuffer.get();
		afloat[2] = i_floatBuffer.get();
		afloat[5] = i_floatBuffer.get();
		afloat[8] = i_floatBuffer.get();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix3f#setIdentity()
	 */
	public void setIdentity() {

		Arrays.fill(afloat, 1, 8, 0f);
		afloat[0] = 1;
		afloat[4] = 1;
		afloat[8] = 1;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix#setRowMajor(float[])
	 */
	public void setRowMajor(float[] i_arrayOfFloat) {

		System.arraycopy(i_arrayOfFloat, 0, afloat, 0, 9);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix#setRowMajor(java.nio.FloatBuffer)
	 */
	public void setRowMajor(FloatBuffer i_floatBuffer) {

		if (i_floatBuffer.hasArray()) {
			System.arraycopy(i_floatBuffer.array(), 0, afloat, 0, 9);
			i_floatBuffer.position(i_floatBuffer.position() + 9);
		} else {
			for (int i = 0; i < 9; i++) {
				afloat[i] = i_floatBuffer.get();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix3f#setZero()
	 */
	public void setZero() {

		Arrays.fill(afloat, 0f);
	}

	/**
	 * {@inheritDoc}
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
	public void toArrayColumnMajor(final float[] i_ofFloat) {

		i_ofFloat[0] = afloat[0];
		i_ofFloat[1] = afloat[3];
		i_ofFloat[2] = afloat[6];
		i_ofFloat[3] = afloat[1];
		i_ofFloat[4] = afloat[4];
		i_ofFloat[5] = afloat[7];
		i_ofFloat[6] = afloat[2];
		i_ofFloat[7] = afloat[5];
		i_ofFloat[8] = afloat[8];
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix3f#toArrayColumnMajor(float[],
	 *      int)
	 */
	public void toArrayColumnMajor(final float[] i_ofFloat, int i_iOffset) {

		i_ofFloat[i_iOffset++] = afloat[0];
		i_ofFloat[i_iOffset++] = afloat[3];
		i_ofFloat[i_iOffset++] = afloat[6];
		i_ofFloat[i_iOffset++] = afloat[1];
		i_ofFloat[i_iOffset++] = afloat[4];
		i_ofFloat[i_iOffset++] = afloat[7];
		i_ofFloat[i_iOffset++] = afloat[2];
		i_ofFloat[i_iOffset++] = afloat[5];
		i_ofFloat[i_iOffset] = afloat[8];
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix3f#toArrayRowMajor(float[])
	 */
	public void toArrayRowMajor(final float[] i_ofFloat) {

		System.arraycopy(afloat, 0, i_ofFloat, 0, 9);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix3f#toArrayRowMajor(float[], int)
	 */
	public void toArrayRowMajor(final float[] i_ofFloat, int i_iOffset) {

		System.arraycopy(afloat, 0, i_ofFloat, i_iOffset, 9);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix3f#toBufferColumnMajor(java.nio.FloatBuffer)
	 */
	public void toBufferColumnMajor(final FloatBuffer i_buffer) {

		i_buffer.put(afloat[0]);
		i_buffer.put(afloat[3]);
		i_buffer.put(afloat[6]);
		i_buffer.put(afloat[1]);
		i_buffer.put(afloat[4]);
		i_buffer.put(afloat[7]);
		i_buffer.put(afloat[2]);
		i_buffer.put(afloat[5]);
		i_buffer.put(afloat[8]);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix3f#toBufferRowMajor(java.nio.FloatBuffer)
	 */
	public void toBufferRowMajor(final FloatBuffer i_buffer) {

		i_buffer.put(afloat);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return String.format(TO_STRING_FORMAT, String.valueOf(afloat[0]),
			String.valueOf(afloat[1]), String.valueOf(afloat[2]),
			String.valueOf(afloat[3]), String.valueOf(afloat[4]),
			String.valueOf(afloat[5]), String.valueOf(afloat[6]),
			String.valueOf(afloat[7]), String.valueOf(afloat[8])

		);
	}
}
