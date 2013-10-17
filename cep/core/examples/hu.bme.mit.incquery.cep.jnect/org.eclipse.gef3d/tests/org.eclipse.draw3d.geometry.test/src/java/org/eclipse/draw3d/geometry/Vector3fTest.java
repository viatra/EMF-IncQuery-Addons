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
import java.text.DecimalFormat;

import junit.framework.TestCase;

/**
 * Vector3fTest Test case for org.eclipse.draw3d.geometryext.Vector3fImpl and
 * the corresponding interfaces IVector3f and Vector3f.
 * 
 * @author Matthias Thiele
 * @version $Revision$
 * @since 12.10.2008
 */
public class Vector3fTest extends TestCase {
	/**
	 * {@inheritDoc}
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {

		// nothing to do yet in here
		super.setUp();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {

		// nothing to do yet in here
		super.tearDown();
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector3fImpl#hashCode()}.
	 */
	public void testHashCode() {

		IVector3f v0 = new Vector3fImpl(1.0f, 2.3f, 3.3f);
		IVector3f v1 = new Vector3fImpl(1.0f, 2.3f, 3.3f);
		IVector3f v2 = new Vector3fImpl(4.56f, 5.67f, -6.78f);
		IVector3f v3 = new Vector3fImpl(0.0f, -0.0f, 0.0f);

		int hashV0 = v0.hashCode();
		int hashV1 = v1.hashCode();
		int hashV2 = v2.hashCode();
		int hashV3 = v3.hashCode();

		// v0 and v1 are not identical but equals. So, hashCode has to be equal
		assertTrue(hashV0 == hashV1);

		// v0 and v2 are not equals, so hashCode should not be equal
		assertTrue(hashV0 != hashV2);

		// same with v1 and v3, check boundaries with 0-vector
		assertTrue(hashV1 != hashV3);

		// invoking hashCode again on same object has to return same value
		assertTrue(hashV0 == v0.hashCode());

	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector3fImpl#Vector3fImpl()}.
	 */
	public void testVector3fImpl() {

		IVector3f v0 = new Vector3fImpl();

		// assert that vector was created with standard values
		assertEquals(v0.getX(), 0.0f);
		assertEquals(v0.getY(), 0.0f);
		assertEquals(v0.getZ(), 0.0f);

	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector3fImpl#Vector3fImpl(float, float, float)}
	 */
	public void testVector3fImplFloatFloatFloat() {

		IVector3f v0 = new Vector3fImpl(0.124f, -3.12f, 3456.0823f);

		// assert that vector was created with given values
		assertEquals(v0.getX(), 0.124f);
		assertEquals(v0.getY(), -3.12f);
		assertEquals(v0.getZ(), 3456.0823f);

	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector3fImpl#Vector3fImpl(org.eclipse.draw3d.geometryext.IVector3f)}
	 */
	public void testVector3fImplIVector3f() {

		IVector3f v0 = new Vector3fImpl(-0.124f, -3.12f, -3456.0823f);
		IVector3f v1 = new Vector3fImpl(v0);

		// assert equality (without being identical) of v0 and v1
		assertTrue(v0 != v1 && v0.equals(v1));
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector3fImpl#Vector3fImpl(java.nio.FloatBuffer)}
	 */
	public void testVector3fImplFloatBuffer() {

		FloatBuffer buf = FloatBuffer.allocate(3);
		buf.put(10.0f);
		buf.put(20.0f);
		buf.put(30.0f);
		buf.rewind();

		IVector3f v0 = new Vector3fImpl(buf);

		// the buffer must at its last position now,
		// all values should be used for vector3f creation
		assertEquals(buf.position(), buf.capacity());

		// assert that vector was created with given values
		assertEquals(v0.getX(), 10.0f);
		assertEquals(v0.getY(), 20.0f);
		assertEquals(v0.getZ(), 30.0f);

	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector3fImpl#Vector3fImpl(float[])}
	 * .
	 */
	public void testVector3fImplFloatArray() {
		float[] arr = { 45.23f, -1000.0f, 4000.0f };

		IVector3f v0 = new Vector3fImpl(arr);

		// assert that vector was created with given values
		assertEquals(45.23f, v0.getX());
		assertEquals(-1000.0f, v0.getY());
		assertEquals(4000.0f, v0.getZ());
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector3fImpl#Vector3fImpl(float[], int)}
	 */
	public void testVector3fImplFloatArrayInt() {
		float[] arr = { 1.1f, 2.2f, 3.3f, 4.4f, 5.5f, 6.6f };

		IVector3f v0 = new Vector3fImpl(arr, 2);

		// assert that vector was created with given values
		assertEquals(3.3f, v0.getX());
		assertEquals(4.4f, v0.getY());
		assertEquals(5.5f, v0.getZ());
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector3fImpl#set(org.eclipse.draw3d.geometryext.IVector3f)}
	 */
	public void testSet() {
		IVector3f v0 = GeometryTests.getRandomVector3f();
		Vector3f v1 = new Vector3fImpl();
		v1.set(v0);

		// assert equality (without being identical) of source and destination
		// vector
		if (!(v1.equals(v0) && v1 != v0)) {
			fail("testSet - Failed with source vector: " + v0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector3fImpl#setX(float)}.
	 */
	public void testSetX() {
		float x = GeometryTests.getRandomFloat();
		Vector3f v0 = new Vector3fImpl();

		v0.setX(x);

		if (x != v0.getX()) {
			fail("testSetX - Failed with x value: " + x);
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector3fImpl#setY(float)}.
	 */
	public void testSetY() {
		float y = GeometryTests.getRandomFloat();
		Vector3f v0 = new Vector3fImpl();

		v0.setY(y);

		if (y != v0.getY()) {
			fail("testSetY - Failed with x value: " + y);
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector3fImpl#setZ(float)}.
	 */
	public void testSetZ() {
		float z = GeometryTests.getRandomFloat();
		Vector3f v0 = new Vector3fImpl();

		v0.setZ(z);

		if (z != v0.getZ()) {
			fail("testSetZ - Failed with x value: " + z);
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector3fImpl#ruleEquals(org.eclipse.draw3d.geometryext.IVector3f)}
	 */
	public void testEqualsIVector3f() {
		float x = GeometryTests.getRandomFloat();
		float y = GeometryTests.getRandomFloat();
		float z = GeometryTests.getRandomFloat();
		IVector3f v0 = new Vector3fImpl(x, y, z);
		Vector3f v1 = new Vector3fImpl(x, y, z);

		// check equality to itself
		if (!v0.equals(v0)) {
			fail("testEqualsIVector3f - Equality to self failed with vector: "
				+ v0.toString());
		}

		// check equality to vector with same x,y,z values
		if (!v0.equals(v1)) {
			fail("testEqualsIVector3f - Equality from " + v0.toString()
				+ " to " + v1.toString() + " failed");
		}

		// check unequality to vector with different x,y,z values
		y = GeometryTests.getRandomFloat();
		v1.setY(y);

		if (v0.equals(v1)) {
			fail("testEqualsIVector3f - Unequality from " + v0.toString()
				+ " to " + v1.toString() + " failed");
		}

		v1.set(v0);
		x = GeometryTests.getRandomFloat();
		v1.setX(x);

		if (v0.equals(v1)) {
			fail("testEqualsIVector3f - Unequality from " + v0.toString()
				+ " to " + v1.toString() + " failed");
		}

		v1.set(v0);
		z = GeometryTests.getRandomFloat();
		v1.setZ(z);

		if (v0.equals(v1)) {
			fail("testEqualsIVector3f - Unequality from " + v0.toString()
				+ " to " + v1.toString() + " failed");
		}

		// Test unequality to completely different vector
		v1.setX(x);
		v1.setY(y);
		v1.setZ(z);

		if (v0.equals(v1)) {
			fail("testEqualsIVector3f - Unequality from " + v0.toString()
				+ " to " + v1.toString() + " failed");
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector3fImpl#equals(org.eclipse.draw3d.geometryext.IVector3f, float)}
	 */
	public void testEqualsIVector3fFloat() {
		float x = GeometryTests.getRandomFloat();
		float y = GeometryTests.getRandomFloat();
		float z = GeometryTests.getRandomFloat();
		float epsilon = GeometryTests.getRandomFloat();
		IVector3f v0 = new Vector3fImpl(x, y, z);
		Vector3f v1 =
			new Vector3fImpl(x + (epsilon / 2), y - (epsilon / 3), z
				- (epsilon / 4));

		// check equality to itself, which is independent from epsilon
		if (!v0.equals(v0, GeometryTests.getRandomFloat())) {
			fail("testEqualsIVector3fFloat - Equality to self failed with vector "
				+ v0.toString() + ", epsilon " + epsilon);
		}

		// check equality to vector with x,y,z within limits
		if (!v0.equals(v1, epsilon)) {
			fail("testEqualsIVector3fFloat - Equality from " + v0.toString()
				+ " to " + v1.toString() + " with epsilon " + epsilon
				+ "failed");
		}

		// check unequality to vector with x,y,z values outside the limits
		v1.setY(y + (epsilon * 5));

		if (v0.equals(v1, epsilon)) {
			fail("testEqualsIVector3fFloat - Unequality from " + v0.toString()
				+ " to " + v1.toString() + " with epsilon " + epsilon
				+ "failed");
		}

		v1.set(v0);
		v1.setX(x + (epsilon * 10));

		if (v0.equals(v1, epsilon)) {
			fail("testEqualsIVector3fFloat - Unequality from " + v0.toString()
				+ " to " + v1.toString() + " with epsilon " + epsilon
				+ "failed");
		}

		v1.set(v0);
		v1.setZ(z + (epsilon * 1000));

		if (v0.equals(v1, epsilon)) {
			fail("testEqualsIVector3fFloat - Unequality from " + v0.toString()
				+ " to " + v1.toString() + " with epsilon " + epsilon
				+ "failed");
		}

		// Test unequality to completely different vector
		v1.setX(x + (epsilon * -20));
		v1.setY(y + (epsilon * 13));
		v1.setZ(z + (epsilon * 27));

		if (v0.equals(v1, epsilon)) {
			fail("testEqualsIVector3fFloat - Unequality from " + v0.toString()
				+ " to " + v1.toString() + " with epsilon " + epsilon
				+ "failed");
		}

		// check with epsilon 0
		v1.set(v0);
		epsilon = 0;

		if (!v0.equals(v1, epsilon)) {
			fail("testEqualsIVector3fFloat - Equality from " + v0.toString()
				+ " to " + v1.toString() + " with epsilon " + epsilon
				+ "failed");
		}

		if (!v0.equals(v0, epsilon)) {
			fail("testEqualsIVector3fFloat - Equality from " + v0.toString()
				+ " to " + v1.toString() + " with epsilon " + epsilon
				+ "failed");
		}

		// check exact match
		epsilon = GeometryTests.getRandomFloat();
		v1.setX(v0.getX() + epsilon);
		v1.setY(v0.getY() - epsilon);
		v1.setZ(v0.getZ() + epsilon);

		if (!v0.equals(v0, epsilon)) {
			fail("testEqualsIVector3fFloat - Equality from " + v0.toString()
				+ " to " + v1.toString() + " with epsilon " + epsilon
				+ "failed");
		}

	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector3fImpl#length()}.
	 */
	public void testGetLength() {
		float x = GeometryTests.getRandomFloat();
		float y = GeometryTests.getRandomFloat();
		float z = GeometryTests.getRandomFloat();

		IVector3f v0 = new Vector3fImpl(x, y, z);

		// check correct calculation against length definition
		if (v0.length() != (float) Math.sqrt(x * x + y * y + z * z)) {
			fail("testGetLength - Failed for vector " + v0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector3fImpl#lengthSquared()}.
	 */
	public void testGetLengthSquared() {
		float x = GeometryTests.getRandomFloat();
		float y = GeometryTests.getRandomFloat();
		float z = GeometryTests.getRandomFloat();

		IVector3f v0 = new Vector3fImpl(x, y, z);

		// check correct calculation against length definition
		if (v0.lengthSquared() != (x * x + y * y + z * z)) {
			fail("testGetLengthSquared - Failed for vector " + v0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector3fImpl#getX()}.
	 */
	public void testGetX() {
		float x = GeometryTests.getRandomFloat();
		float y = GeometryTests.getRandomFloat();
		float z = GeometryTests.getRandomFloat();

		IVector3f v0 = new Vector3fImpl(x, y, z);

		if (v0.getX() != x) {
			fail("testGetX - Failed for vector " + v0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector3fImpl#getY()}.
	 */
	public void testGetY() {
		float x = GeometryTests.getRandomFloat();
		float y = GeometryTests.getRandomFloat();
		float z = GeometryTests.getRandomFloat();

		IVector3f v0 = new Vector3fImpl(x, y, z);

		if (v0.getY() != y) {
			fail("testGetY - Failed for vector " + v0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector3fImpl#getZ()}.
	 */
	public void testGetZ() {
		float x = GeometryTests.getRandomFloat();
		float y = GeometryTests.getRandomFloat();
		float z = GeometryTests.getRandomFloat();

		IVector3f v0 = new Vector3fImpl(x, y, z);

		if (v0.getZ() != z) {
			fail("testGetZ - Failed for vector " + v0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector3fImpl#toArray(float[])}.
	 */
	public void testToArrayFloatArray() {
		float x = GeometryTests.getRandomFloat();
		float y = GeometryTests.getRandomFloat();
		float z = GeometryTests.getRandomFloat();

		IVector3f v0 = new Vector3fImpl(x, y, z);

		float[] arr = new float[10];

		v0.toArray(arr);

		// check correct storage in array
		if (arr[0] != x || arr[1] != y || arr[2] != z) {
			fail("testToArrayFloatArray - Failed with vector " + v0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector3fImpl#toArray(float[], int)}
	 * .
	 */
	public void testToArrayFloatArrayInt() {
		float x = GeometryTests.getRandomFloat();
		float y = GeometryTests.getRandomFloat();
		float z = GeometryTests.getRandomFloat();

		IVector3f v0 = new Vector3fImpl(x, y, z);
		int capacity = GeometryTests.getRandomInt(20);
		capacity = capacity >= 4 ? capacity : 4;
		float[] arr = new float[capacity];
		int offset = GeometryTests.getRandomInt(Math.abs(capacity - 3));

		v0.toArray(arr, offset);

		// check correct storage in array
		if (arr[offset] != x || arr[offset + 1] != y || arr[offset + 2] != z) {
			fail("testToArrayFloatArray - Failed with vector " + v0.toString()
				+ ", capacity " + capacity + ", offset " + offset);
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector3fImpl#toBuffer(java.nio.FloatBuffer)}
	 */
	public void testToBuffer() {
		float x = GeometryTests.getRandomFloat();
		float y = GeometryTests.getRandomFloat();
		float z = GeometryTests.getRandomFloat();

		IVector3f v0 = new Vector3fImpl(x, y, z);
		FloatBuffer buf = FloatBuffer.allocate(10);

		v0.toBuffer(buf);

		// check correct content and position
		if (buf.position() != 3 || buf.get(0) != x || buf.get(1) != y
			|| buf.get(2) != z) {
			fail("testToBuffer - Failed with vector " + v0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector3fImpl#toString()}.
	 */
	public void testToString() {
		float x = GeometryTests.getRandomFloat();
		float y = GeometryTests.getRandomFloat();
		float z = GeometryTests.getRandomFloat();

		IVector3f v0 = new Vector3fImpl(x, y, z);
		String s = v0.toString();
		assertNotNull(s);

		DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.##");
		String[] descr = { "x", "y", "z" };
		String[] exp =
			{ DECIMAL_FORMAT.format(x), DECIMAL_FORMAT.format(y),
				DECIMAL_FORMAT.format(z) };

		for (int i = 0; i < descr.length; i++) {
			assertTrue(descr[i] + " not found in vector string",
				s.contains(exp[i]));
		}

	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector3fImpl#translate(float, float, float)}
	 */
	public void testTranslate() {
		float x = GeometryTests.getRandomFloat();
		float y = GeometryTests.getRandomFloat();
		float z = GeometryTests.getRandomFloat();
		Vector3fImpl v0 = GeometryTests.getRandomVector3f();
		Vector3fImpl v1 = new Vector3fImpl(v0);

		v0.translate(x, y, z);

		Math3D.translate(v1, x, y, z, v1);

		if (!v0.equals(v1)) {
			fail("testTranslate - Result not as expected: " + v0.toString()
				+ v1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector3fImpl#transform(org.eclipse.draw3d.geometryext.IMatrix4f)}
	 */
	public void testTransform() {
		Matrix4fImpl m0 = GeometryTests.getRandomMatrix4f();
		Vector3fImpl v0 = GeometryTests.getRandomVector3f();
		Vector3fImpl v1 = new Vector3fImpl(v0);
		Vector4fImpl v2 = new Vector4fImpl(v0.getX(), v0.getY(), v0.getZ(), 1);

		v0.transform(m0);

		Math3D.transform(v2, m0, v2);

		float x = v2.getX() / v2.getW();
		float y = v2.getY() / v2.getW();
		float z = v2.getZ() / v2.getW();

		v1.setX(x);
		v1.setY(y);
		v1.setZ(z);

		if (!v0.equals(v1)) {
			fail("testTransform - Result not as expected: " + v0.toString()
				+ v1.toString() + m0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Vector3fImpl#scale(float)} .
	 */
	public void testScale() {
		int factor = GeometryTests.getRandomInt(1000);
		Vector3fImpl v0 = GeometryTests.getRandomVector3f();
		Vector3fImpl v1 = new Vector3fImpl(v0);

		v0.scale(factor);

		Math3D.scale(factor, v1, v1);

		if (!v0.equals(v1)) {
			fail("testScale - Result not as expected: " + v0.toString()
				+ v1.toString());
		}
	}
}
