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
 * {@link Matrix3f} implementation backed by a buffer. This class is for test
 * purposes only, since it is slower than the field backed solution.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Dec 15, 2008
 */
public class Matrix3fAsBuffer implements Matrix3f, Serializable, Cloneable {

	private final static float[] afidentity = { 1, 0, 0, 0, 1, 0, 0, 0, 1 };

	private final static FloatBuffer identity;

	private final static FloatBuffer zero;

	static {
		identity = FloatBuffer.wrap(afidentity);
		zero = FloatBuffer.wrap(new float[9]);

	}

	/**
	 * @param i_sourceMatrix3f
	 * @return
	 */
	static Matrix3fAsBuffer castToMatrix3fAsBuffer(IMatrix3f i_sourceMatrix3f) {

		if (i_sourceMatrix3f instanceof Matrix3fAsArray) {
			return (Matrix3fAsBuffer) i_sourceMatrix3f;
		} else {
			return new Matrix3fAsBuffer(i_sourceMatrix3f);
		}
	}

	FloatBuffer buffer;

	/**
	 * 
	 */
	public Matrix3fAsBuffer() {

		buffer = FloatBuffer.allocate(9);
		identity.rewind();
		buffer.put(identity);
	}

	public Matrix3fAsBuffer(float[] i_floats, boolean i_bIsColumnMajor) {

		buffer = FloatBuffer.allocate(9);
		if (!i_bIsColumnMajor) {
			buffer.put(i_floats, 0, 9);
		} else {
			buffer.put(i_floats[0]);
			buffer.put(i_floats[3]);
			buffer.put(i_floats[6]);
			buffer.put(i_floats[1]);
			buffer.put(i_floats[4]);
			buffer.put(i_floats[7]);
			buffer.put(i_floats[2]);
			buffer.put(i_floats[5]);
			buffer.put(i_floats[8]);
		}
	}

	public Matrix3fAsBuffer(float[] i_floats, boolean i_bIsColumnMajor,
			int i_iOffset) {

		buffer = FloatBuffer.allocate(9);
		if (!i_bIsColumnMajor) {
			buffer.put(i_floats, i_iOffset, 9);
		} else {
			buffer.put(i_floats[0 + i_iOffset]);
			buffer.put(i_floats[3 + i_iOffset]);
			buffer.put(i_floats[6 + i_iOffset]);
			buffer.put(i_floats[1 + i_iOffset]);
			buffer.put(i_floats[4 + i_iOffset]);
			buffer.put(i_floats[7 + i_iOffset]);
			buffer.put(i_floats[2 + i_iOffset]);
			buffer.put(i_floats[5 + i_iOffset]);
			buffer.put(i_floats[8 + i_iOffset]);
		}
	}

	public Matrix3fAsBuffer(FloatBuffer i_buffer, boolean i_bIsColumnMajor) {

		buffer = FloatBuffer.allocate(9);
		if (!i_bIsColumnMajor) {
			buffer.put(i_buffer);
		} else {
			setColumnMajor(i_buffer);
		}
	}

	public Matrix3fAsBuffer(IMatrix3f src) {

		buffer = FloatBuffer.allocate(9);
		src.toBufferRowMajor(buffer);
	}

	/**
	 * 
	 */
	public Matrix3fAsBuffer(final Matrix3fAsBuffer src) {

		buffer = FloatBuffer.allocate(9);
		buffer.put(src.buffer);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {

		return new Matrix3fAsBuffer(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix3f#equals(org.eclipse.draw3d.geometry.IMatrix3f)
	 */
	public boolean equals(IMatrix3f i_anotherMatrix3f) {

		FloatBuffer ab;
		if (i_anotherMatrix3f instanceof Matrix3fAsBuffer) {
			ab = ((Matrix3fAsBuffer) i_anotherMatrix3f).buffer;
		} else {
			ab = FloatBuffer.allocate(9);
			i_anotherMatrix3f.toBufferRowMajor(ab);
		}
		ab.rewind();
		buffer.rewind();
		return buffer.equals(ab);
	}

	// /**
	// * {@inheritDoc}
	// * @see org.eclipse.draw3d.geometry.IMatrix3f#get(int)
	// */
	// public float get(int i_index) {
	// return buffer.get(i_index);
	// }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix#get(int, int)
	 */
	public float get(int i_row, int i_column) {

		return buffer.get(i_row * 3 + i_column);
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

		buffer.rewind();
		i_sourceMatrix3f.toBufferRowMajor(buffer);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix#set(int, int, float)
	 */
	public void set(int i_row, int i_column, float i_value) {

		buffer.put(i_row * 3 + i_column, i_value);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix#setColumnMajor(float[])
	 */
	public void setColumnMajor(float[] i_arrayOfFloat) {

		for (int c = 0; c < 3; c++)
			for (int r = 0; r < 3; r++)
				buffer.put(r * 3 + c, i_arrayOfFloat[c * 3 + r]);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix3f#setColumnMajor(java.nio.FloatBuffer)
	 */
	public void setColumnMajor(FloatBuffer i_floatBuffer) {

		buffer.put(0, i_floatBuffer.get());
		buffer.put(3, i_floatBuffer.get());
		buffer.put(6, i_floatBuffer.get());
		buffer.put(1, i_floatBuffer.get());
		buffer.put(4, i_floatBuffer.get());
		buffer.put(7, i_floatBuffer.get());
		buffer.put(2, i_floatBuffer.get());
		buffer.put(5, i_floatBuffer.get());
		buffer.put(8, i_floatBuffer.get());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix3f#setIdentity()
	 */
	public void setIdentity() {

		buffer.rewind();
		identity.rewind();
		buffer.put(identity);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix#setRowMajor(float[])
	 */
	public void setRowMajor(float[] i_arrayOfFloat) {

		buffer.rewind();
		buffer.put(i_arrayOfFloat, 0, 9);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix3f#setRowMajor(java.nio.FloatBuffer)
	 */
	public void setRowMajor(FloatBuffer i_floatBuffer) {

		buffer.rewind();
		buffer.put(i_floatBuffer);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Matrix3f#setZero()
	 */
	public void setZero() {

		buffer.rewind();
		zero.rewind();
		buffer.put(zero);
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
	public void toArrayColumnMajor(float[] i_ofFloat) {

		i_ofFloat[0] = buffer.get(0);
		i_ofFloat[1] = buffer.get(3);
		i_ofFloat[2] = buffer.get(6);
		i_ofFloat[3] = buffer.get(1);
		i_ofFloat[4] = buffer.get(4);
		i_ofFloat[5] = buffer.get(7);
		i_ofFloat[6] = buffer.get(2);
		i_ofFloat[7] = buffer.get(5);
		i_ofFloat[8] = buffer.get(8);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix3f#toArrayColumnMajor(float[],
	 *      int)
	 */
	public void toArrayColumnMajor(float[] i_ofFloat, int i_iOffset) {

		i_ofFloat[i_iOffset + 0] = buffer.get(0);
		i_ofFloat[i_iOffset + 1] = buffer.get(3);
		i_ofFloat[i_iOffset + 2] = buffer.get(6);
		i_ofFloat[i_iOffset + 3] = buffer.get(1);
		i_ofFloat[i_iOffset + 4] = buffer.get(4);
		i_ofFloat[i_iOffset + 5] = buffer.get(7);
		i_ofFloat[i_iOffset + 6] = buffer.get(2);
		i_ofFloat[i_iOffset + 7] = buffer.get(5);
		i_ofFloat[i_iOffset + 8] = buffer.get(8);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix3f#toArrayRowMajor(float[])
	 */
	public void toArrayRowMajor(float[] i_ofFloat) {

		buffer.rewind();
		buffer.get(i_ofFloat, 0, 9);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix3f#toArrayRowMajor(float[], int)
	 */
	public void toArrayRowMajor(float[] i_ofFloat, int i_iOffset) {

		buffer.rewind();
		buffer.get(i_ofFloat, i_iOffset, 9);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix3f#toBufferColumnMajor(java.nio.FloatBuffer)
	 */
	public void toBufferColumnMajor(FloatBuffer i_buffer) {

		i_buffer.put(buffer.get(0));
		i_buffer.put(buffer.get(3));
		i_buffer.put(buffer.get(6));
		i_buffer.put(buffer.get(1));
		i_buffer.put(buffer.get(4));
		i_buffer.put(buffer.get(7));
		i_buffer.put(buffer.get(2));
		i_buffer.put(buffer.get(5));
		i_buffer.put(buffer.get(8));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IMatrix3f#toBufferRowMajor(java.nio.FloatBuffer)
	 */
	public void toBufferRowMajor(FloatBuffer i_buffer) {

		buffer.rewind();
		i_buffer.put(buffer);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return String.format(TO_STRING_FORMAT, String.valueOf(buffer.get(0)),
			String.valueOf(buffer.get(1)), String.valueOf(buffer.get(2)),
			String.valueOf(buffer.get(3)), String.valueOf(buffer.get(4)),
			String.valueOf(buffer.get(5)), String.valueOf(buffer.get(6)),
			String.valueOf(buffer.get(7)), String.valueOf(buffer.get(8)));
	}
}
