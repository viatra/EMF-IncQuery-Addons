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

import java.nio.FloatBuffer;

import junit.framework.TestCase;

/**
 * Matrix3fTest Test case for org.eclipse.draw3d.geometryext.Matrix3fImpl and
 * the corresponding interfaces IMatrix3f and Matrix3f.
 * 
 * @author Matthias Thiele
 * @version $Revision$
 * @since 19.10.2008
 */
public class Matrix3fAsArrayTest extends TestCase {

	/**
	 * {@inheritDoc}
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix3fAsArray#Matrix3fAsArray()}.
	 */
	public void testMatrix3fAsArray() {
		IMatrix3f m0 = new Matrix3fAsArray();
		Matrix3f m1 = GeometryTests.getRandomMatrix3fAsArray();

		m1.setIdentity();
		if (!m0.equals(m1)) {
			fail("testMatrix3fAsArray - Default matrix is not equals identity: "
					+ m0.toString() + " " + m1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix3fAsArray#Matrix3fAsArray(org.eclipse.draw3d.geometryext.IMatrix3f)}
	 * .
	 */
	public void testMatrix3fAsArrayIMatrix3f() {
		IMatrix3f m0 = GeometryTests.getRandomMatrix3fAsArray();
		IMatrix3f m1 = new Matrix3fAsArray(m0);

		if (m0 == m1 || !m0.equals(m1)) {
			fail("testMatrix3fAsArrayIMatrix3f - New matrix is not equals source matrix: "
					+ m0.toString() + " " + m1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix3fAsArray#Matrix3fAsArray(java.nio.FloatBuffer, boolean)}
	 * .
	 */
	public void testMatrix3fAsArrayFloatBufferBoolean() {
		FloatBuffer buf = GeometryTests.getRandomFloatBuffer(9);
		buf.rewind();

		// check whether all values were correctly stored with transpose = true
		Matrix3fAsArray m0 = new Matrix3fAsArray(buf, true);
		buf.rewind();

		if (!checkCorrectStorage(m0, buf, true)) {
			fail("testMatrix3fAsArrayFloatBufferBoolean - Transpose = true creation failed: "
					+ m0.toString());
		}

		// check whether all values were correctly stored with transpose = false
		Matrix3fAsArray m1 = new Matrix3fAsArray(buf, false);
		buf.rewind();

		if (!checkCorrectStorage(m1, buf, false)) {
			fail("testMatrix3fAsArrayFloatBufferBoolean - Transpose = false creation failed:"
					+ m1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix3fAsArray#Matrix3fAsArray(float[], boolean)}
	 * .
	 */
	public void testMatrix3fAsArrayFloatArrayBoolean() {
		float[] arr = GeometryTests.getRandomFloatArray(0, 9);

		// check whether all values were correctly stored with transpose = true
		Matrix3fAsArray m0 = new Matrix3fAsArray(arr, true);

		if (!checkCorrectStorage(m0, GeometryTests.buffer2Array(arr), true)) {
			fail("testMatrix3fAsArrayFloatBufferBoolean - Transpose = true creation failed: "
					+ m0.toString());
		}

		// check whether all values were correctly stored with transpose = false
		Matrix3fAsArray m1 = new Matrix3fAsArray(arr, false);

		if (!checkCorrectStorage(m1, GeometryTests.buffer2Array(arr), false)) {
			fail("testMatrix3fAsArrayFloatBufferBoolean - Transpose = false creation failed."
					+ m1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix3fAsArray#Matrix3fAsArray(float[], boolean, int)}
	 * .
	 */
	public void testMatrix3fAsArrayFloatArrayBooleanInt() {
		int offset = GeometryTests.getRandomInt(1000);
		float[] arr = GeometryTests.getRandomFloatArray(offset, 9);

		// check whether all values were correctly stored with transpose = true
		Matrix3fAsArray m0 = new Matrix3fAsArray(arr, true, offset);

		if (!checkCorrectStorage(m0, GeometryTests.buffer2Array(GeometryTests
				.copyOfRange(arr, offset, arr.length)), true)) {
			fail("testMatrix3fAsArrayFloatBufferBoolean - Transpose = true creation failed: "
					+ m0.toString());
		}

		// check whether all values were correctly stored with transpose = false
		Matrix3fAsArray m1 = new Matrix3fAsArray(arr, false, offset);

		if (!checkCorrectStorage(m1, GeometryTests.buffer2Array(GeometryTests
				.copyOfRange(arr, offset, arr.length)), false)) {
			fail("testMatrix3fAsArrayFloatBufferBoolean - Transpose = false creation failed: "
					+ m1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix3fAsArray#toString()}.
	 */
	public void testToString() {
		Matrix3fAsArray m0 = GeometryTests.getRandomMatrix3fAsArray();
		String s = m0.toString();
		String expected;
		for (int i = 0; i < 9; i++) {
			expected = String.valueOf(m0.afloat[i]);
			assertTrue('"' + expected + "\" not found in\n" + s, s
					.contains(expected));
		}

	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix3fAsArray#hashCode()}.
	 */
	public void testHashCode() {
		IMatrix3f m0 = GeometryTests.getRandomMatrix3fAsArray();
		IMatrix3f m1 = new Matrix3fAsArray(m0);
		IMatrix3f m2 = GeometryTests.getRandomMatrix3fAsArray();
		Matrix3f m3 = GeometryTests.getRandomMatrix3fAsArray();

		int hashM0 = m0.hashCode();
		int hashM1 = m1.hashCode();
		int hashM2 = m2.hashCode();
		int hashM3 = m3.hashCode();

		// m0 and m1 are not identical but equals. So, hashCode has to be equal
		if (hashM0 != hashM1) {
			fail("testHashCode - Equal matrices have different hash codes: "
					+ m0.toString() + m1.toString());
		}

		// m0 and m2 are not equals, so hashCode should not be equal
		if (hashM0 == hashM2) {
			fail("testHashCode - Unequal matrices have same hash codes: "
					+ m0.toString() + m2.toString());
		}

		// same with m1 and m3, check boundaries with 0-matrix
		m3.setZero();
		if (hashM0 == hashM3) {
			fail("testHashCode - Unequal matrices have same hash codes: "
					+ m0.toString() + m3.toString());
		}

		// invoking hashCode again on same object has to return same value
		int hashM4 = m0.hashCode();
		if (hashM0 != hashM4) {
			fail("testHashCode - Second invocation returned different result: "
					+ hashM0 + " " + hashM4 + " " + m0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix3fAsArray#set(org.eclipse.draw3d.geometryext.IMatrix3f)}
	 * .
	 */
	public void testSetIMatrix3f() {
		Matrix3f m0 = GeometryTests.getRandomMatrix3fAsArray();
		Matrix3f m1 = GeometryTests.getRandomMatrix3fAsArray();

		if (m0.equals(m1)) {
			fail("testSetIMatrix3f - Two random matrices are equal: "
					+ m0.toString() + " " + m1.toString());
		}

		m0.set(m1);
		FloatBuffer buf = FloatBuffer.allocate(10);
		m1.toBufferRowMajor(buf);

		if (!checkCorrectStorage((Matrix3fAsArray) m0, buf, false)) {
			fail("testSetIMatrix3f - Source matrix not correctly set: "
					+ m0.toString() + " " + m1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix3fAsArray#set(java.nio.FloatBuffer)}
	 * .
	 */
	public void testSetFloatBuffer() {
		Matrix3f m0 = GeometryTests.getRandomMatrix3fAsArray();
		FloatBuffer buf1 = GeometryTests.getRandomFloatBuffer(9);
		FloatBuffer buf2 = FloatBuffer.allocate(9);
		buf1.rewind();

		m0.setRowMajor(buf1);

		if (!checkCorrectStorage((Matrix3fAsArray) m0, buf1, false)) {
			fail("testSetFloatBuffer - FloatBuffer not correctly stored: "
					+ buf1.toString() + " " + m0.toString());
		}

		m0.toBufferRowMajor(buf2);

		if (buf1.compareTo(buf2) != 0) {
			fail("testSetFloatBuffer - Source buffer not equals to result of toBufferRowMajor(): "
					+ buf1.toString() + " " + buf2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix3fAsArray#setIdentity()}.
	 */
	public void testSetIdentity() {
		Matrix3fAsArray m0 = GeometryTests.getRandomMatrix3fAsArray();
		m0.setIdentity();

		if (m0.afloat[0] != 1.0f
				|| m0.afloat[1] != 0.0f
				|| m0.afloat[2] != 0.0f
				|| m0.afloat[3] != 0.0f
				|| m0.afloat[4] != 1.0f
				|| m0.afloat[5] != 0.0f
				|| m0.afloat[6] != 0.0f
				|| m0.afloat[7] != 0.0f
				|| m0.afloat[8] != 1.0f) {
			fail("testSetIdentity - This is not the identity matrix: "
					+ m0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix3fAsArray#setColumnMajor(java.nio.FloatBuffer)}
	 * .
	 */
	public void testsetColumnMajor() {
		Matrix3f m0 = GeometryTests.getRandomMatrix3fAsArray();
		FloatBuffer buf1 = GeometryTests.getRandomFloatBuffer(9);
		FloatBuffer buf2 = FloatBuffer.allocate(9);
		buf1.rewind();

		m0.setColumnMajor(buf1);

		if (!checkCorrectStorage((Matrix3fAsArray) m0, buf1, true)) {
			fail("testsetColumnMajor - FloatBuffer not correctly stored: "
					+ buf1.toString() + " " + m0.toString());
		}

		m0.toBufferColumnMajor(buf2);

		if (buf1.compareTo(buf2) != 0) {
			fail("testsetColumnMajor - Source buffer not equals to result of toBufferRowMajor(): "
					+ buf1.toString() + " " + buf2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix3fAsArray#setZero()}.
	 */
	public void testSetZero() {
		Matrix3fAsArray m0 = GeometryTests.getRandomMatrix3fAsArray();
		m0.setZero();

		if (m0.afloat[0] != 0.0f
				|| m0.afloat[1] != 0.0f
				|| m0.afloat[2] != 0.0f
				|| m0.afloat[3] != 0.0f
				|| m0.afloat[4] != 0.0f
				|| m0.afloat[5] != 0.0f
				|| m0.afloat[6] != 0.0f
				|| m0.afloat[7] != 0.0f
				|| m0.afloat[8] != 0.0f) {
			fail("testSetZero - This is not a zero matrix: " + m0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix3fAsArray#ruleEquals(org.eclipse.draw3d.geometryext.IMatrix3f)}
	 * .
	 */
	public void testEqualsIMatrix3f() {
		IMatrix3f m0 = GeometryTests.getRandomMatrix3fAsArray();
		Matrix3f m1 = new Matrix3fAsArray(m0);

		// check equality to itself
		if (!m0.equals(m0)) {
			fail("testEqualsIMatrix3f - Equality to self failed with matrix: "
					+ m0.toString());
		}

		// check equality to matrix created from this
		if (!m0.equals(m1)) {
			fail("testEqualsIMatrix3f - Equality from " + m0.toString()
					+ " to " + m1.toString() + " failed");
		}

		// Test unequality to completely different matrix
		FloatBuffer buf1 = GeometryTests.getRandomFloatBuffer(9);
		buf1.rewind();
		m1.setRowMajor(buf1);

		if (m0.equals(m1)) {
			fail("testEqualsIMatrix3f - Unequality from " + m0.toString()
					+ " to " + m1.toString() + " failed.");
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix3fAsArray#toArray(float[])}.
	 */
	public void testToArrayFloatArray() {
		IMatrix3f m0 = GeometryTests.getRandomMatrix3fAsArray();
		float[] arr = new float[10];

		m0.toArrayRowMajor(arr);

		if (!checkCorrectStorage((Matrix3fAsArray) m0, GeometryTests
				.buffer2Array(arr), false)) {
			fail("testToArrayFloatArray - Array not correctly stored: "
					+ m0.toString() + " " + arr.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix3fAsArray#toArray(float[], int)}
	 * .
	 */
	public void testToArrayFloatArrayInt() {
		IMatrix3f m0 = GeometryTests.getRandomMatrix3fAsArray();
		int offset = GeometryTests.getRandomInt(1000);
		float[] arr = new float[offset + 10];

		m0.toArrayRowMajor(arr, offset);

		if (!checkCorrectStorage((Matrix3fAsArray) m0, GeometryTests
				.buffer2Array(GeometryTests
						.copyOfRange(arr, offset, arr.length)), false)) {
			fail("testToArrayFloatArray - Array not correctly stored: "
					+ m0.toString() + " " + arr.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix3fAsArray#toArrayTranspose(float[])}
	 * .
	 */
	public void testToArrayTransposeFloatArray() {
		IMatrix3f m0 = GeometryTests.getRandomMatrix3fAsArray();
		float[] arr = new float[10];

		m0.toArrayColumnMajor(arr);

		if (!checkCorrectStorage((Matrix3fAsArray) m0, GeometryTests
				.buffer2Array(arr), true)) {
			fail("testToArrayFloatArray - Array not correctly stored: "
					+ m0.toString() + " " + arr.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix3fAsArray#toArrayTranspose(float[], int)}
	 * .
	 */
	public void testToArrayTransposeFloatArrayInt() {
		IMatrix3f m0 = GeometryTests.getRandomMatrix3fAsArray();
		int offset = GeometryTests.getRandomInt(1000);
		float[] arr = new float[offset + 10];

		m0.toArrayColumnMajor(arr, offset);

		if (!checkCorrectStorage((Matrix3fAsArray) m0, GeometryTests
				.buffer2Array(GeometryTests
						.copyOfRange(arr, offset, arr.length)), true)) {
			fail("testToArrayTransposeFloatArrayInt - Array not correctly stored: "
					+ m0.toString() + " " + arr.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix3fAsArray#toBufferRowMajor(java.nio.FloatBuffer)}
	 * .
	 */
	public void testtoBufferRowMajor() {
		IMatrix3f m0 = GeometryTests.getRandomMatrix3fAsArray();
		FloatBuffer buf1 = FloatBuffer.allocate(10);

		m0.toBufferRowMajor(buf1);

		if (!checkCorrectStorage((Matrix3fAsArray) m0, buf1, false)) {
			fail("testToBuffer - Buffer not correctly stored: " + m0.toString()
					+ " " + buf1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix3fAsArray#toBufferColumnMajor(java.nio.FloatBuffer)}
	 * .
	 */
	public void testtoBufferColumnMajor() {
		IMatrix3f m0 = GeometryTests.getRandomMatrix3fAsArray();
		FloatBuffer buf1 = FloatBuffer.allocate(10);

		m0.toBufferColumnMajor(buf1);

		if (!checkCorrectStorage((Matrix3fAsArray) m0, buf1, true)) {
			fail("testToBufferTranspose - Buffer not correctly stored: "
					+ m0.toString() + " " + buf1.toString());
		}
	}

	// Helper methods **********************************************************

	/**
	 * Checks whether the content of a FloatBuffer was correctly stored in a
	 * Matrix3f. It can be differentiated between columns major and row major
	 * storage strategy.
	 * 
	 * @param i_checkThisMatrix Check this matrix for correct storage.
	 * @param i_sourceFloatBuffer Check the matrix' content against the content
	 *            of this buffer. There is no need to rewind the Buffer before
	 *            calling this funtion.
	 * @param i_bIsTranspose True: Storage is expected to be in row major order,
	 *            False: Storage is expected to be in column major order.
	 * @return True on success, false otherwise.
	 */
	private static boolean checkCorrectStorage(
			Matrix3fAsArray i_checkThisMatrix, FloatBuffer i_sourceFloatBuffer,
			boolean i_bIsTranspose) {
		Matrix3fAsArray m0 = i_checkThisMatrix;
		FloatBuffer buf = i_sourceFloatBuffer;
		boolean ok = true;
		if (i_bIsTranspose) {
			if (buf.get(0) != m0.afloat[0])
				ok = false;
			if (buf.get(1) != m0.afloat[3])
				ok = false;
			if (buf.get(2) != m0.afloat[6])
				ok = false;
			if (buf.get(3) != m0.afloat[1])
				ok = false;
			if (buf.get(4) != m0.afloat[4])
				ok = false;
			if (buf.get(5) != m0.afloat[7])
				ok = false;
			if (buf.get(6) != m0.afloat[2])
				ok = false;
			if (buf.get(7) != m0.afloat[5])
				ok = false;
			if (buf.get(8) != m0.afloat[8])
				ok = false;
		} else {
			if (buf.get(0) != m0.afloat[0])
				ok = false;
			if (buf.get(1) != m0.afloat[1])
				ok = false;
			if (buf.get(2) != m0.afloat[2])
				ok = false;
			if (buf.get(3) != m0.afloat[3])
				ok = false;
			if (buf.get(4) != m0.afloat[4])
				ok = false;
			if (buf.get(5) != m0.afloat[5])
				ok = false;
			if (buf.get(6) != m0.afloat[6])
				ok = false;
			if (buf.get(7) != m0.afloat[7])
				ok = false;
			if (buf.get(8) != m0.afloat[8])
				ok = false;
		}

		return ok;
	}
}
