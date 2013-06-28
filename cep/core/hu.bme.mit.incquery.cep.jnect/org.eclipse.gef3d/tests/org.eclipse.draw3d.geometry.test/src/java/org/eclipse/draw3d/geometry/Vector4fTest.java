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
 * Vector4fTest There should really be more documentation here.
 * 
 * @author Matthias Thiele
 * @version $Revision$
 * @since 17.10.2008
 */
public class Vector4fTest extends TestCase {

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
	 * {@link org.eclipse.draw3d.geometryext.Vector4fImpl#hashCode()}.
	 */
	public void testHashCode() {
		float x = GeometryTests.getRandomFloat();
		float y = GeometryTests.getRandomFloat();
		float z = GeometryTests.getRandomFloat();
		float w = GeometryTests.getRandomFloat();

		IVector4f v0 = new Vector4fImpl(x, y, z, w);
		IVector4f v1 = new Vector4fImpl(x, y, z, w);
		IVector4f v2 = new Vector4fImpl(x / 2, y / 3, -z * 5, w * 3);
		IVector4f v3 = new Vector4fImpl(0.0f, -0.0f, 0.0f, 0.0f);

		int hashV0 = v0.hashCode();
		int hashV1 = v1.hashCode();
		int hashV2 = v2.hashCode();
		int hashV3 = v3.hashCode();

		// v0 and v1 are not identical but equals. So, hashCode has to be equal
		if (hashV0 != hashV1) {
			fail("testHashCode - Hash code unequal for equal vectors: "
					+ v0.toString() + " " + v1.toString());
		}

		// v0 and v2 are not equals, so hashCode should not be equal
		if (hashV0 == hashV2) {
			fail("testHashCode - Hash code equal for unequal vectors: "
					+ v0.toString() + " " + v2.toString());
		}

		// same with v1 and v3, check boundaries with 0-vector
		if (hashV1 == hashV3) {
			fail("testHashCode - Hash code equal for unequal vectors: "
					+ v0.toString() + " " + v3.toString());
		}

		// invoking hashCode again on same object has to return same value
		if (hashV0 != v0.hashCode()) {
			fail("testHashCode - Hash code different on second invokation: "
					+ v0.toString() + " " + v1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector4fImpl#Vector4fImpl()}.
	 */
	public void testVector4fImpl() {
		IVector4f v0 = new Vector4fImpl();

		// assert that vector was created with standard values
		assertEquals(v0.getX(), 0.0f);
		assertEquals(v0.getY(), 0.0f);
		assertEquals(v0.getZ(), 0.0f);
		assertEquals(v0.getW(), 0.0f);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector4fImpl#Vector4fImpl(float, float, float, float)}
	 * .
	 */
	public void testVector4fImplFloatFloatFloatFloat() {
		float x = GeometryTests.getRandomFloat();
		float y = GeometryTests.getRandomFloat();
		float z = GeometryTests.getRandomFloat();
		float w = GeometryTests.getRandomFloat();

		IVector4f v0 = new Vector4fImpl(x, y, z, w);

		// assert that vector was created with given values
		if (v0.getX() != x) {
			fail("testVector4fImplFloatFloatFloatFloat - X value unexpected: "
					+ v0.toString());
		}

		if (v0.getY() != y) {
			fail("testVector4fImplFloatFloatFloatFloat - Y value unexpected: "
					+ v0.toString());
		}

		if (v0.getZ() != z) {
			fail("testVector4fImplFloatFloatFloatFloat - Z value unexpected: "
					+ v0.toString());
		}

		if (v0.getW() != w) {
			fail("testVector4fImplFloatFloatFloatFloat - W value unexpected: "
					+ v0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector4fImpl#Vector4fImpl(org.eclipse.draw3d.geometryext.IVector4f)}
	 * .
	 */
	public void testVector4fImplIVector4f() {
		float x = GeometryTests.getRandomFloat();
		float y = GeometryTests.getRandomFloat();
		float z = GeometryTests.getRandomFloat();
		float w = GeometryTests.getRandomFloat();

		IVector4f v0 = new Vector4fImpl(x, y, z, w);
		IVector4f v1 = new Vector4fImpl(v0);

		// assert equality (without being identical) of v0 and v1
		if (v0 == v1) {
			fail("testVector4fImplIVector4f - Test vectors are not allowed to be identical here.");
		}

		if (!v0.equals(v1)) {
			fail("testVector4fImplIVector4f - Test vectors are not equal, though one is created from the other: "
					+ v0.toString() + " " + v1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector4fImpl#Vector4fImpl(java.nio.FloatBuffer)}
	 * .
	 */
	public void testVector4fImplFloatBuffer() {

		float x = GeometryTests.getRandomFloat();
		float y = GeometryTests.getRandomFloat();
		float z = GeometryTests.getRandomFloat();
		float w = GeometryTests.getRandomFloat();

		FloatBuffer buf = FloatBuffer.allocate(4);
		buf.put(x);
		buf.put(y);
		buf.put(z);
		buf.put(w);
		buf.rewind();

		IVector4f v0 = new Vector4fImpl(buf);

		// the buffer must at its last position now,
		// all values should be used for vector4f creation
		if (buf.position() != buf.capacity()) {
			fail("testVector4fImplFloatArray - Buffer position unexpected. "
					+ v0.toString());
		}

		// assert that vector was created with given values
		if (v0.getY() != y) {
			fail("testVector4fImplFloatArray - Y value unexpected: "
					+ v0.toString());
		}

		if (v0.getZ() != z) {
			fail("testVector4fImplFloatArray - Z value unexpected: "
					+ v0.toString());
		}

		if (v0.getW() != w) {
			fail("testVector4fImplFloatArray - W value unexpected: "
					+ v0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector4fImpl#Vector4fImpl(float[])}
	 * .
	 */
	public void testVector4fImplFloatArray() {
		float[] arr = GeometryTests.getRandomFloatArray(0, 4);

		IVector4f v0 = new Vector4fImpl(arr);

		// assert that vector was created with given values
		if (v0.getX() != arr[0]) {
			fail("testVector4fImplFloatArrayInt - X value unexpected: "
					+ arr.toString());
		}

		if (v0.getY() != arr[1]) {
			fail("testVector4fImplFloatArrayInt - Y value unexpected: "
					+ arr.toString());
		}

		if (v0.getZ() != arr[2]) {
			fail("testVector4fImplFloatArray - Z value unexpected: "
					+ arr.toString());
		}

		if (v0.getW() != arr[3]) {
			fail("testVector4fImplFloatArray - W value unexpected: "
					+ arr.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector4fImpl#Vector4fImpl(float[], int)}
	 * .
	 */
	public void testVector4fImplFloatArrayInt() {
		float[] arr = { 1.1f, 2.2f, 3.3f, 4.4f, 5.5f, 6.6f };
		int offset = 2;

		IVector4f v0 = new Vector4fImpl(arr, offset);

		// assert that vector was created with given values
		assertEquals(3.3f, v0.getX());
		assertEquals(4.4f, v0.getY());
		assertEquals(5.5f, v0.getZ());

		if (v0.getX() != arr[offset]) {
			fail("testVector4fImplFloatArrayInt - X value unexpected: "
					+ arr.toString());
		}

		if (v0.getY() != arr[offset + 1]) {
			fail("testVector4fImplFloatArrayInt - Y value unexpected: "
					+ arr.toString());
		}

		if (v0.getZ() != arr[offset + 2]) {
			fail("testVector4fImplFloatArrayInt - Z value unexpected: "
					+ arr.toString());
		}

		if (v0.getW() != arr[offset + 3]) {
			fail("testVector4fImplFloatArrayInt - W value unexpected: "
					+ arr.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector4fImpl#toString()}.
	 */
	public void testToString() {
		float x = GeometryTests.getRandomFloat();
		float y = GeometryTests.getRandomFloat();
		float z = GeometryTests.getRandomFloat();
		float w = GeometryTests.getRandomFloat();

		IVector4f v0 = new Vector4fImpl(x, y, z, w);
		String s = v0.toString();

		if (s == null || !s.contains(String.valueOf(x))
				|| !s.contains(String.valueOf(y))
				|| !s.contains(String.valueOf(z))
				|| !s.contains(String.valueOf(w))) {
			fail("testToString - Failed with vector " + v0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector4fImpl#setX(float)}.
	 */
	public void testSetX() {
		float x = GeometryTests.getRandomFloat();
		Vector4f v0 = new Vector4fImpl();

		v0.setX(x);

		if (x != v0.getX()) {
			fail("testSetX - Failed with x value: " + x);
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector4fImpl#setY(float)}.
	 */
	public void testSetY() {
		float y = GeometryTests.getRandomFloat();
		Vector4f v0 = new Vector4fImpl();

		v0.setY(y);

		if (y != v0.getY()) {
			fail("testSetY - Failed with y value: " + y);
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector4fImpl#setZ(float)}.
	 */
	public void testSetZ() {
		float z = GeometryTests.getRandomFloat();
		Vector4f v0 = new Vector4fImpl();

		v0.setZ(z);

		if (z != v0.getZ()) {
			fail("testSetZ - Failed with z value: " + z);
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector4fImpl#setW(float)}.
	 */
	public void testSetW() {
		float w = GeometryTests.getRandomFloat();
		Vector4f v0 = new Vector4fImpl();

		v0.setW(w);

		if (w != v0.getW()) {
			fail("testSetW - Failed with w value: " + w);
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector4fImpl#set(org.eclipse.draw3d.geometryext.IVector4f)}
	 * .
	 */
	public void testSet() {
		IVector4f v0 = GeometryTests.getRandomVector4f();
		Vector4f v1 = new Vector4fImpl();
		v1.set(v0);

		// assert equality (without being identical) of source and destination
		// vector
		if (!(v1.equals(v0) && v1 != v0)) {
			fail("testSet - Failed with source vector: " + v0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector4fImpl#getX()}.
	 */
	public void testGetX() {
		float x = GeometryTests.getRandomFloat();

		IVector4f v0 = new Vector4fImpl(x, 0, 0, 0);

		if (v0.getX() != x) {
			fail("testGetX - Failed for vector " + v0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector4fImpl#getY()}.
	 */
	public void testGetY() {
		float y = GeometryTests.getRandomFloat();

		IVector4f v0 = new Vector4fImpl(0, y, 0, 0);

		if (v0.getY() != y) {
			fail("testGetY - Failed for vector " + v0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector4fImpl#getZ()}.
	 */
	public void testGetZ() {
		float z = GeometryTests.getRandomFloat();

		IVector4f v0 = new Vector4fImpl(0, 0, z, 0);

		if (v0.getZ() != z) {
			fail("testGetZ - Failed for vector " + v0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector4fImpl#getW()}.
	 */
	public void testGetW() {
		float w = GeometryTests.getRandomFloat();

		IVector4f v0 = new Vector4fImpl(0, 0, 0, w);

		if (v0.getW() != w) {
			fail("testGetW - Failed for vector " + v0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector4fImpl#length()}.
	 */
	public void testGetLength() {
		float x = GeometryTests.getRandomFloat();
		float y = GeometryTests.getRandomFloat();
		float z = GeometryTests.getRandomFloat();
		float w = GeometryTests.getRandomFloat();

		IVector4f v0 = new Vector4fImpl(x, y, z, w);

		// check correct calculation against length definition
		if (v0.length() != (float) Math.sqrt(x * x + y * y + z * z + w * w)) {
			fail("testGetLength - Failed for vector " + v0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector4fImpl#lengthSquared()}.
	 */
	public void testGetLengthSquared() {
		float x = GeometryTests.getRandomFloat();
		float y = GeometryTests.getRandomFloat();
		float z = GeometryTests.getRandomFloat();
		float w = GeometryTests.getRandomFloat();

		IVector4f v0 = new Vector4fImpl(x, y, z, w);

		// check correct calculation against length definition
		if (v0.lengthSquared() != x * x + y * y + z * z + w * w) {
			fail("testGetLengthSquared - Failed for vector " + v0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector4fImpl#toBuffer(java.nio.FloatBuffer)}
	 * .
	 */
	public void testToBuffer() {
		float x = GeometryTests.getRandomFloat();
		float y = GeometryTests.getRandomFloat();
		float z = GeometryTests.getRandomFloat();
		float w = GeometryTests.getRandomFloat();

		IVector4f v0 = new Vector4fImpl(x, y, z, w);
		FloatBuffer buf = FloatBuffer.allocate(10);

		v0.toBuffer(buf);

		// check correct content and position
		if (buf.position() != 4 || buf.get(0) != x || buf.get(1) != y
				|| buf.get(2) != z || buf.get(3) != w) {
			fail("testToBuffer - Failed with vector " + v0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector4fImpl#toArray(float[])}.
	 */
	public void testToArrayFloatArray() {
		float x = GeometryTests.getRandomFloat();
		float y = GeometryTests.getRandomFloat();
		float z = GeometryTests.getRandomFloat();
		float w = GeometryTests.getRandomFloat();

		IVector4f v0 = new Vector4fImpl(x, y, z, w);

		float[] arr = new float[10];

		v0.toArray(arr);

		// check correct storage in array
		if (arr[0] != x || arr[1] != y || arr[2] != z || arr[3] != w) {
			fail("testToArrayFloatArray - Failed with vector " + v0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector4fImpl#toArray(float[], int)}
	 * .
	 */
	public void testToArrayFloatArrayInt() {
		float x = GeometryTests.getRandomFloat();
		float y = GeometryTests.getRandomFloat();
		float z = GeometryTests.getRandomFloat();
		float w = GeometryTests.getRandomFloat();

		IVector4f v0 = new Vector4fImpl(x, y, z, w);
		int capacity = GeometryTests.getRandomInt(20);
		capacity = capacity >= 5 ? capacity : 5;
		float[] arr = new float[capacity];
		int offset = GeometryTests.getRandomInt(Math.abs(capacity - 4));

		v0.toArray(arr, offset);

		// check correct storage in array
		if (arr[offset] != x || arr[offset + 1] != y || arr[offset + 2] != z
				|| arr[offset + 3] != w) {
			fail("testToArrayFloatArray - Failed with vector " + v0.toString()
					+ ", capacity " + capacity + ", offset " + offset);
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector4fImpl#ruleEquals(org.eclipse.draw3d.geometryext.IVector4f)}
	 * .
	 */
	public void testEqualsIVector4f() {
		float x = GeometryTests.getRandomFloat();
		float y = GeometryTests.getRandomFloat();
		float z = GeometryTests.getRandomFloat();
		float w = GeometryTests.getRandomFloat();
		IVector4f v0 = new Vector4fImpl(x, y, z, w);
		Vector4f v1 = new Vector4fImpl(x, y, z, w);

		// check equality to itself
		if (!v0.equals(v0)) {
			fail("testEqualsIVector4f - Equality to self failed with vector: "
					+ v0.toString());
		}

		// check equality to vector with same x,y,z values
		if (!v0.equals(v1)) {
			fail("testEqualsIVector4f - Equality from " + v0.toString()
					+ " to " + v1.toString() + " failed");
		}

		// check unequality to vector with different x,y,z,w values
		y = GeometryTests.getRandomFloat();
		v1.setY(y);

		if (v0.equals(v1)) {
			fail("testEqualsIVector4f - Unequality from " + v0.toString()
					+ " to " + v1.toString() + " failed");
		}

		v1.set(v0);
		x = GeometryTests.getRandomFloat();
		v1.setX(x);

		if (v0.equals(v1)) {
			fail("testEqualsIVector4f - Unequality from " + v0.toString()
					+ " to " + v1.toString() + " failed");
		}

		v1.set(v0);
		z = GeometryTests.getRandomFloat();
		v1.setZ(z);

		if (v0.equals(v1)) {
			fail("testEqualsIVector4f - Unequality from " + v0.toString()
					+ " to " + v1.toString() + " failed");
		}

		v1.set(v0);
		w = GeometryTests.getRandomFloat();
		v1.setW(w);

		if (v0.equals(v1)) {
			fail("testEqualsIVector4f - Unequality from " + v0.toString()
					+ " to " + v1.toString() + " failed");
		}

		// Test unequality to completely different vector
		v1.setX(x);
		v1.setY(y);
		v1.setZ(z);
		v1.setW(w);

		if (v0.equals(v1)) {
			fail("testEqualsIVector4f - Unequality from " + v0.toString()
					+ " to " + v1.toString() + " failed");
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector4fImpl#equals(org.eclipse.draw3d.geometryext.IVector4f, float)}
	 * .
	 */
	public void testEqualsIVector4fFloat() {
		float x = GeometryTests.getRandomFloat();
		float y = GeometryTests.getRandomFloat();
		float z = GeometryTests.getRandomFloat();
		float w = GeometryTests.getRandomFloat();
		float epsilon = GeometryTests.getRandomFloat();
		IVector4f v0 = new Vector4fImpl(x, y, z, w);
		Vector4f v1 = new Vector4fImpl(x + (epsilon / 2), y - (epsilon / 3), z
				- (epsilon / 4), w + (epsilon / 100));

		// check equality to itself, which is independent from epsilon
		if (!v0.equals(v0, GeometryTests.getRandomFloat())) {
			fail("testEqualsIVector4fFloat - Equality to self failed with vector "
					+ v0.toString() + ", epsilon " + epsilon);
		}

		// check equality to vector with x,y,z,w within limits
		if (!v0.equals(v1, epsilon)) {
			fail("testEqualsIVector4fFloat - Equality from " + v0.toString()
					+ " to " + v1.toString() + " with epsilon " + epsilon
					+ "failed");
		}

		// check unequality to vector with x,y,z,w values outside the limits
		v1.setY(y + (epsilon * 5));

		if (v0.equals(v1, epsilon)) {
			fail("testEqualsIVector4fFloat - Unequality from " + v0.toString()
					+ " to " + v1.toString() + " with epsilon " + epsilon
					+ "failed");
		}

		v1.set(v0);
		v1.setX(x + (epsilon * 10));

		if (v0.equals(v1, epsilon)) {
			fail("testEqualsIVector4fFloat - Unequality from " + v0.toString()
					+ " to " + v1.toString() + " with epsilon " + epsilon
					+ "failed");
		}

		v1.set(v0);
		v1.setZ(z + (epsilon * 1000));

		if (v0.equals(v1, epsilon)) {
			fail("testEqualsIVector4fFloat - Unequality from " + v0.toString()
					+ " to " + v1.toString() + " with epsilon " + epsilon
					+ "failed");
		}

		v1.set(v0);
		v1.setW(w + (epsilon * 10000));

		if (v0.equals(v1, epsilon)) {
			fail("testEqualsIVector4fFloat - Unequality from " + v0.toString()
					+ " to " + v1.toString() + " with epsilon " + epsilon
					+ "failed");
		}

		// Test unequality to completely different vector
		v1.setX(x + (epsilon * -20));
		v1.setY(y + (epsilon * 13));
		v1.setZ(z + (epsilon * 27));
		v1.setW(w + (epsilon * 72));

		if (v0.equals(v1, epsilon)) {
			fail("testEqualsIVector4fFloat - Unequality from " + v0.toString()
					+ " to " + v1.toString() + " with epsilon " + epsilon
					+ "failed");
		}

		// check with epsilon 0
		v1.set(v0);
		epsilon = 0;

		if (!v0.equals(v1, epsilon)) {
			fail("testEqualsIVector4fFloat - Equality from " + v0.toString()
					+ " to " + v1.toString() + " with epsilon " + epsilon
					+ "failed");
		}

		if (!v0.equals(v0, epsilon)) {
			fail("testEqualsIVector4fFloat - Equality from " + v0.toString()
					+ " to " + v1.toString() + " with epsilon " + epsilon
					+ "failed");
		}

		// check exact match
		epsilon = GeometryTests.getRandomFloat();
		v1.setX(v0.getX() + epsilon);
		v1.setY(v0.getY() - epsilon);
		v1.setZ(v0.getZ() + epsilon);
		v1.setW(v0.getW() - epsilon);

		if (!v0.equals(v0, epsilon)) {
			fail("testEqualsIVector4fFloat - Equality from " + v0.toString()
					+ " to " + v1.toString() + " with epsilon " + epsilon
					+ "failed");
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector4fImpl#translate(float, float, float)}
	 * .
	 */
	public void testTranslate() {
		float x = GeometryTests.getRandomFloat();
		float y = GeometryTests.getRandomFloat();
		float z = GeometryTests.getRandomFloat();
		Vector4fImpl v0 = GeometryTests.getRandomVector4f();
		Vector4fImpl v1 = new Vector4fImpl(v0);

		v0.translate(x, y, z);

		Math3D.translate(v1, x, y, z, 0, v1);

		if (!v0.equals(v1)) {
			fail("testTranslate - Result not as expected: " + v0.toString()
					+ v1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector4fImpl#scale(float)}.
	 */
	public void testScale() {
		int factor = GeometryTests.getRandomInt(1000);
		Vector4fImpl v0 = GeometryTests.getRandomVector4f();
		Vector4fImpl v1 = new Vector4fImpl(v0);

		v0.scale(factor);

		Math3D.scale(factor, v1, v1);

		if (!v0.equals(v1)) {
			fail("testScale - Result not as expected: " + v0.toString()
					+ v1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector4fImpl#transform(org.eclipse.draw3d.geometryext.IMatrix4f)}
	 * .
	 */
	public void testTransform() {
		Matrix4fImpl m0 = GeometryTests.getRandomMatrix4f();
		Vector4fImpl v0 = GeometryTests.getRandomVector4f();
		Vector4fImpl v1 = new Vector4fImpl(v0);

		v0.transform(m0);
		Math3D.transform(v1, m0, v1);

		if (!v0.equals(v1)) {
			fail("testTransform - Result not as expected: " + v0.toString()
					+ v1.toString());
		}
	}

}
