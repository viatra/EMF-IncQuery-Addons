/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Matthias Thiele - initial API and implementation
 ******************************************************************************/

package org.eclipse.draw3d.geometry;

import java.nio.FloatBuffer;

import junit.framework.TestCase;

/**
 * Matrix4fTest Test case for org.eclipse.draw3d.geometryext.Matrix4fImpl and
 * the corresponding interfaces IMatrix4f and Matrix4f.
 * 
 * @author Matthias Thiele
 * @version $Revision$
 * @since 21.10.2008
 */
public class Matrix4fTest extends TestCase {

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
	 * {@link org.eclipse.draw3d.geometryext.Matrix4fImpl#hashCode()}.
	 */
	public void testHashCode() {
		IMatrix4f m0 = GeometryTests.getRandomMatrix4f();
		IMatrix4f m1 = new Matrix4fImpl(m0);
		IMatrix4f m2 = GeometryTests.getRandomMatrix4f();
		Matrix4f m3 = GeometryTests.getRandomMatrix4f();

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
	 * {@link org.eclipse.draw3d.geometryext.Matrix4fImpl#Matrix4fImpl()}.
	 */
	public void testMatrix4fImpl() {
		IMatrix4f m0 = new Matrix4fImpl();
		Matrix4f m1 = GeometryTests.getRandomMatrix4f();

		m1.setIdentity();
		if (!m0.equals(m1)) {
			fail("testMatrix4fImpl - Default matrix is not equals identity: "
					+ m0.toString() + " " + m1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix4fImpl#Matrix4fImpl(org.eclipse.draw3d.geometryext.IMatrix4f)}
	 * .
	 */
	public void testMatrix4fImplIMatrix4f() {
		IMatrix4f m0 = GeometryTests.getRandomMatrix4f();
		IMatrix4f m1 = new Matrix4fImpl(m0);

		if (m0 == m1 || !m0.equals(m1)) {
			fail("testMatrix4fImplIMatrix4f - New matrix is not equals source matrix: "
					+ m0.toString() + " " + m1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix4fImpl#Matrix4fImpl(java.nio.FloatBuffer, boolean)}
	 * .
	 */
	public void testMatrix4fImplFloatBufferBoolean() {
		FloatBuffer buf = GeometryTests.getRandomFloatBuffer(16);
		buf.rewind();

		// check whether all values were correctly stored with transpose = true
		Matrix4fImpl m0 = new Matrix4fImpl(buf, true);
		buf.rewind();

		if (!checkCorrectStorage(m0, buf, true)) {
			fail("testMatrix4fImplFloatBufferBoolean - Transpose = true creation failed: "
					+ m0.toString());
		}

		// check whether all values were correctly stored with transpose = false
		Matrix4fImpl m1 = new Matrix4fImpl(buf, false);
		buf.rewind();

		if (!checkCorrectStorage(m1, buf, false)) {
			fail("testMatrix4fImplFloatBufferBoolean - Transpose = false creation failed:"
					+ m1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix4fImpl#Matrix4fImpl(float[], boolean)}
	 * .
	 */
	public void testMatrix4fImplFloatArrayBoolean() {
		float[] arr = GeometryTests.getRandomFloatArray(0, 16);

		// check whether all values were correctly stored with transpose = true
		Matrix4fImpl m0 = new Matrix4fImpl(arr, true);

		if (!checkCorrectStorage(m0, GeometryTests.buffer2Array(arr), true)) {
			fail("testMatrix4fImplFloatBufferBoolean - Transpose = true creation failed: "
					+ m0.toString());
		}

		// check whether all values were correctly stored with transpose = false
		Matrix4fImpl m1 = new Matrix4fImpl(arr, false);

		if (!checkCorrectStorage(m1, GeometryTests.buffer2Array(arr), false)) {
			fail("testMatrix4fImplFloatBufferBoolean - Transpose = false creation failed."
					+ m1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix4fImpl#Matrix4fImpl(float[], boolean, int)}
	 * .
	 */
	public void testMatrix4fImplFloatArrayBooleanInt() {
		int offset = GeometryTests.getRandomInt(1000);
		float[] arr = GeometryTests.getRandomFloatArray(offset, 16);

		// check whether all values were correctly stored with transpose = true
		Matrix4fImpl m0 = new Matrix4fImpl(arr, true, offset);

		if (!checkCorrectStorage(m0, GeometryTests.buffer2Array(GeometryTests
				.copyOfRange(arr, offset, arr.length)), true)) {
			fail("testMatrix4fImplFloatBufferBoolean - Transpose = true creation failed: "
					+ m0.toString());
		}

		// check whether all values were correctly stored with transpose = false
		Matrix4fImpl m1 = new Matrix4fImpl(arr, false, offset);

		if (!checkCorrectStorage(m1, GeometryTests.buffer2Array(GeometryTests
				.copyOfRange(arr, offset, arr.length)), false)) {
			fail("testMatrix4fImplFloatBufferBoolean - Transpose = false creation failed: "
					+ m1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix4fImpl#toString()}.
	 */
	public void testToString() {
		Matrix4fImpl m0 = GeometryTests.getRandomMatrix4f();
		String s = m0.toString();
		if (!s.contains(String.valueOf(m0.a11))
				|| !s.contains(String.valueOf(m0.a12))
				|| !s.contains(String.valueOf(m0.a13))
				|| !s.contains(String.valueOf(m0.a14))
				|| !s.contains(String.valueOf(m0.a21))
				|| !s.contains(String.valueOf(m0.a22))
				|| !s.contains(String.valueOf(m0.a23))
				|| !s.contains(String.valueOf(m0.a24))
				|| !s.contains(String.valueOf(m0.a31))
				|| !s.contains(String.valueOf(m0.a32))
				|| !s.contains(String.valueOf(m0.a33))
				|| !s.contains(String.valueOf(m0.a34))
				|| !s.contains(String.valueOf(m0.a41))
				|| !s.contains(String.valueOf(m0.a42))
				|| !s.contains(String.valueOf(m0.a43))
				|| !s.contains(String.valueOf(m0.a44))) {
			fail("testToString - At least one expected string is missing: "
					+ m0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix4fImpl#set(org.eclipse.draw3d.geometryext.IMatrix4f)}
	 * .
	 */
	public void testSetIMatrix4f() {
		Matrix4f m0 = GeometryTests.getRandomMatrix4f();
		Matrix4f m1 = GeometryTests.getRandomMatrix4f();

		if (m0.equals(m1)) {
			fail("testSetIMatrix4f - Two random matrices are equal: "
					+ m0.toString() + " " + m1.toString());
		}

		m0.set(m1);
		FloatBuffer buf = FloatBuffer.allocate(16);
		m1.toBufferRowMajor(buf);

		if (!checkCorrectStorage((Matrix4fImpl) m0, buf, false)) {
			fail("testSetIMatrix4f - Source matrix not correctly set: "
					+ m0.toString() + " " + m1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix4fImpl#set(java.nio.FloatBuffer)}
	 * .
	 */
	public void testSetFloatBuffer() {
		Matrix4f m0 = GeometryTests.getRandomMatrix4f();
		FloatBuffer buf1 = GeometryTests.getRandomFloatBuffer(16);
		FloatBuffer buf2 = FloatBuffer.allocate(16);
		buf1.rewind();

		m0.setRowMajor(buf1);

		if (!checkCorrectStorage((Matrix4fImpl) m0, buf1, false)) {
			fail("testSetFloatBuffer - FloatBuffer not correctly stored: "
					+ buf1.toString() + " " + m0.toString());
		}

		m0.toBufferRowMajor(buf2);

		if (buf1.compareTo(buf2) != 0) {
			fail("testSetFloatBuffer - Source buffer not equals to result of toBuffer(): "
					+ buf1.toString() + " " + buf2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix4fImpl#setColumnMajor(java.nio.FloatBuffer)}
	 * .
	 */
	public void testSetColumnMajor() {
		Matrix4f m0 = GeometryTests.getRandomMatrix4f();
		FloatBuffer buf1 = GeometryTests.getRandomFloatBuffer(16);
		FloatBuffer buf2 = FloatBuffer.allocate(16);
		buf1.rewind();

		m0.setColumnMajor(buf1);

		if (!checkCorrectStorage((Matrix4fImpl) m0, buf1, true)) {
			fail("testSetTranspose - FloatBuffer not correctly stored: "
					+ buf1.toString() + " " + m0.toString());
		}

		m0.toBufferColumnMajor(buf2);

		if (buf1.compareTo(buf2) != 0) {
			fail("testSetTranspose - Source buffer not equals to result of toBuffer(): "
					+ buf1.toString() + " " + buf2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix4fImpl#setIdentity()}.
	 */
	public void testSetIdentity() {
		Matrix4fImpl m0 = GeometryTests.getRandomMatrix4f();
		m0.setIdentity();

		if (m0.a11 != 1.0f || m0.a12 != 0.0f || m0.a13 != 0.0f
				|| m0.a14 != 0.0f || m0.a21 != 0.0f || m0.a22 != 1.0f
				|| m0.a23 != 0.0f || m0.a24 != 0.0f || m0.a31 != 0.0f
				|| m0.a32 != 0.0f || m0.a33 != 1.0f || m0.a34 != 0.0f
				|| m0.a41 != 0.0f || m0.a42 != 0.0f || m0.a43 != 0.0f
				|| m0.a44 != 1.0f) {
			fail("testSetIdentity - This is not the identity matrix: "
					+ m0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix4fImpl#setZero()}.
	 */
	public void testSetZero() {
		Matrix4fImpl m0 = GeometryTests.getRandomMatrix4f();
		m0.setZero();

		if (m0.a11 != 0.0f || m0.a12 != 0.0f || m0.a13 != 0.0f
				|| m0.a14 != 0.0f || m0.a21 != 0.0f || m0.a22 != 0.0f
				|| m0.a23 != 0.0f || m0.a24 != 0.0f || m0.a31 != 0.0f
				|| m0.a32 != 0.0f || m0.a33 != 0.0f || m0.a34 != 0.0f
				|| m0.a41 != 0.0f || m0.a42 != 0.0f || m0.a43 != 0.0f
				|| m0.a44 != 0.0f) {
			fail("testSetZero - This is not a zero matrix: " + m0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix4fImpl#toBuffer(java.nio.FloatBuffer)}
	 * .
	 */
	public void testToBuffer() {
		IMatrix4f m0 = GeometryTests.getRandomMatrix4f();
		FloatBuffer buf1 = FloatBuffer.allocate(16);

		m0.toBufferRowMajor(buf1);

		if (!checkCorrectStorage((Matrix4fImpl) m0, buf1, false)) {
			fail("testToBuffer - Buffer not correctly stored: " + m0.toString()
					+ " " + buf1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix4fImpl#toBufferColumnMajor(java.nio.FloatBuffer)}
	 * .
	 */
	public void testToBufferColumnMajor() {
		IMatrix4f m0 = GeometryTests.getRandomMatrix4f();
		FloatBuffer buf1 = FloatBuffer.allocate(16);

		m0.toBufferColumnMajor(buf1);

		if (!checkCorrectStorage((Matrix4fImpl) m0, buf1, true)) {
			fail("testToBufferTranspose - Buffer not correctly stored: "
					+ m0.toString() + " " + buf1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix4fImpl#toArray(float[])}.
	 */
	public void testToArrayFloatArray() {
		IMatrix4f m0 = GeometryTests.getRandomMatrix4f();
		float[] arr = new float[16];

		m0.toArrayRowMajor(arr);

		if (!checkCorrectStorage((Matrix4fImpl) m0, GeometryTests
				.buffer2Array(arr), false)) {
			fail("testToArrayFloatArray - Array not correctly stored: "
					+ m0.toString() + " " + arr.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix4fImpl#toArray(float[], int)}
	 * .
	 */
	public void testToArrayFloatArrayInt() {
		IMatrix4f m0 = GeometryTests.getRandomMatrix4f();
		int offset = GeometryTests.getRandomInt(1000);
		float[] arr = new float[offset + 16];

		m0.toArrayRowMajor(arr, offset);

		if (!checkCorrectStorage((Matrix4fImpl) m0, GeometryTests
				.buffer2Array(GeometryTests
						.copyOfRange(arr, offset, arr.length)), false)) {
			fail("testToArrayFloatArray - Array not correctly stored: "
					+ m0.toString() + " " + arr.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix4fImpl#toArrayColumnMajor(float[])}
	 * .
	 */
	public void testToArrayTransposeFloatArray() {
		IMatrix4f m0 = GeometryTests.getRandomMatrix4f();
		float[] arr = new float[16];

		m0.toArrayColumnMajor(arr);

		if (!checkCorrectStorage((Matrix4fImpl) m0, GeometryTests
				.buffer2Array(arr), true)) {
			fail("testToArrayFloatArray - Array not correctly stored: "
					+ m0.toString() + " " + arr.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix4fImpl#toArrayColumnMajor(float[], int)}
	 * .
	 */
	public void testToArrayTransposeFloatArrayInt() {
		IMatrix4f m0 = GeometryTests.getRandomMatrix4f();
		int offset = GeometryTests.getRandomInt(1000);
		float[] arr = new float[offset + 16];

		m0.toArrayColumnMajor(arr, offset);

		if (!checkCorrectStorage((Matrix4fImpl) m0, GeometryTests
				.buffer2Array(GeometryTests
						.copyOfRange(arr, offset, arr.length)), true)) {
			fail("testToArrayTransposeFloatArrayInt - Array not correctly stored: "
					+ m0.toString() + " " + arr.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Matrix4fImpl#ruleEquals(org.eclipse.draw3d.geometryext.IMatrix4f)}
	 * .
	 */
	public void testEqualsIMatrix4f() {
		IMatrix4f m0 = GeometryTests.getRandomMatrix4f();
		Matrix4f m1 = new Matrix4fImpl(m0);

		// check equality to itself
		if (!m0.equals(m0)) {
			fail("testEqualsIMatrix4f - Equality to self failed with matrix: "
					+ m0.toString());
		}

		// check equality to matrix created from this
		if (!m0.equals(m1)) {
			fail("testEqualsIMatrix4f - Equality from " + m0.toString()
					+ " to " + m1.toString() + " failed");
		}

		// Test unequality to completely different matrix
		FloatBuffer buf1 = GeometryTests.getRandomFloatBuffer(16);
		buf1.rewind();
		m1.setRowMajor(buf1);

		if (m0.equals(m1)) {
			fail("testEqualsIMatrix4f - Unequality from " + m0.toString()
					+ " to " + m1.toString() + " failed.");
		}
	}

	// Helper methods **********************************************************

	/**
	 * Checks whether the content of a FloatBuffer was correctly stored in a
	 * Matrix4f. It can be differentiated between columns major and row major
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
	private static boolean checkCorrectStorage(Matrix4fImpl i_checkThisMatrix,
			FloatBuffer i_sourceFloatBuffer, boolean i_bIsTranspose) {
		Matrix4fImpl m0 = i_checkThisMatrix;
		FloatBuffer buf = i_sourceFloatBuffer;
		boolean ok = true;
		if (i_bIsTranspose) {
			if (buf.get(0) != m0.a11)
				ok = false;
			if (buf.get(1) != m0.a21)
				ok = false;
			if (buf.get(2) != m0.a31)
				ok = false;
			if (buf.get(3) != m0.a41)
				ok = false;
			if (buf.get(4) != m0.a12)
				ok = false;
			if (buf.get(5) != m0.a22)
				ok = false;
			if (buf.get(6) != m0.a32)
				ok = false;
			if (buf.get(7) != m0.a42)
				ok = false;
			if (buf.get(8) != m0.a13)
				ok = false;
			if (buf.get(9) != m0.a23)
				ok = false;
			if (buf.get(10) != m0.a33)
				ok = false;
			if (buf.get(11) != m0.a43)
				ok = false;
			if (buf.get(12) != m0.a14)
				ok = false;
			if (buf.get(13) != m0.a24)
				ok = false;
			if (buf.get(14) != m0.a34)
				ok = false;
			if (buf.get(15) != m0.a44)
				ok = false;
		} else {
			if (buf.get(0) != m0.a11)
				ok = false;
			if (buf.get(1) != m0.a12)
				ok = false;
			if (buf.get(2) != m0.a13)
				ok = false;
			if (buf.get(3) != m0.a14)
				ok = false;
			if (buf.get(4) != m0.a21)
				ok = false;
			if (buf.get(5) != m0.a22)
				ok = false;
			if (buf.get(6) != m0.a23)
				ok = false;
			if (buf.get(7) != m0.a24)
				ok = false;
			if (buf.get(8) != m0.a31)
				ok = false;
			if (buf.get(9) != m0.a32)
				ok = false;
			if (buf.get(10) != m0.a33)
				ok = false;
			if (buf.get(11) != m0.a34)
				ok = false;
			if (buf.get(12) != m0.a41)
				ok = false;
			if (buf.get(13) != m0.a42)
				ok = false;
			if (buf.get(14) != m0.a43)
				ok = false;
			if (buf.get(15) != m0.a44)
				ok = false;
		}

		return ok;
	}
}
