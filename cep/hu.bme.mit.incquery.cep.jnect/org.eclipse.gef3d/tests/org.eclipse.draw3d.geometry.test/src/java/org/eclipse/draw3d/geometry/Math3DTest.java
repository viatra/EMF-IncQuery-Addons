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

import junit.framework.TestCase;

/**
 * Math3DTest Test case for org.eclipse.draw3d.geometryext.Math3D. For creating
 * expected results, see http://www.bluebit.gr/matrix-calculator/
 * 
 * @author Matthias Thiele
 * @version $Revision$
 * @since 23.10.2008
 */
public class Math3DTest extends TestCase {

	/**
	 * Precision used in {@link Math3D#equals(float, float, float)}
	 * @todo increase precision (i.e., reduce this value)
	 */
	public static float PREC = 0.0002f;

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
	 * {@link org.eclipse.draw3d.geometryext.Math3D#negate(org.eclipse.draw3d.geometryext.IVector3f, org.eclipse.draw3d.geometryext.Vector3f)}
	 * .
	 */
	public void testNegateIVector3fVector3f() {
		Vector3fImpl v0 = GeometryTests.getRandomVector3f();
		Vector3fImpl v1 = new Vector3fImpl(-v0.x, -v0.y, -v0.z);

		Vector3f v2 = Math3D.negate(v0, null);

		if (!v1.equals(v2)) {
			fail("testNegateIVector3fVector3f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		Math3D.negate(v0, v2);
		if (!v1.equals(v2)) {
			fail("testNegateIVector3fVector3f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		v2 = Math3D.negate(v0, v0);
		if (!v1.equals(v2) || !v1.equals(v0)) {
			fail("testNegateIVector3fVector3f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link Math3D#eulerAngles(IVector3f, IVector3f, Vector3f)}.
	 */
	public void testEulerAngles() {

		Vector3f ref = GeometryTests.getRandomVector3f();
		Math3D.normalise(ref, ref);

		Vector3f v0 = new Vector3fImpl(ref);
		Vector3f v1 = new Vector3fImpl(ref);

		Vector3f a = GeometryTests.getRandomVector3f();
		a.scale((float) Math.PI);

		Matrix4f rot = Math3D.rotate(a, IMatrix4f.IDENTITY, null);
		v0.transform(rot);

		Vector3f e = Math3D.eulerAngles(v0, ref, null);
		rot = Math3D.rotate(e, IMatrix4f.IDENTITY, rot);
		v1.transform(rot);

		assertTrue(Math3D.equals(v0, v1, 0.01f));
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#normalise(org.eclipse.draw3d.geometryext.IVector3f, org.eclipse.draw3d.geometryext.Vector3f)}
	 * .
	 */
	public void testNormaliseIVector3fVector3f() {
		Vector3fImpl v0 = GeometryTests.getRandomVector3f();
		float l = v0.length();
		Vector3fImpl v1 = new Vector3fImpl(v0.x / l, v0.y / l, v0.z / l);

		Vector3f v2 = Math3D.normalise(v0, null);

		if (!v1.equals(v2, PREC)) {
			fail("testNormaliseIVector3fVector3f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		Math3D.normalise(v0, v2);
		if (!v1.equals(v2, PREC)) {
			fail("testNormaliseIVector3fVector3f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		v2 = Math3D.normalise(v0, v0);
		if (!v1.equals(v2, PREC) || !v1.equals(v0, PREC)) {
			fail("testNormaliseIVector3fVector3f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#dot(org.eclipse.draw3d.geometryext.IVector3f, org.eclipse.draw3d.geometryext.IVector3f)}
	 * .
	 */
	public void testDotIVector3fIVector3f() {
		Vector3fImpl v0 = GeometryTests.getRandomVector3f();
		Vector3fImpl v1 = GeometryTests.getRandomVector3f();
		float expDot = v0.x * v1.x + v0.y * v1.y + v0.z * v1.z;

		if (expDot != Math3D.dot(v0, v1) || expDot != Math3D.dot(v1, v0)) {
			fail("testDotIVector3fIVector3f - Expected dot " + expDot
				+ " was not returned with vectors: " + v0.toString() + " "
				+ v1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#angle(org.eclipse.draw3d.geometryext.IVector3f, org.eclipse.draw3d.geometryext.IVector3f)}
	 * .
	 */
	public void testAngleIVector3fIVector3f() {
		Vector3fImpl v0 = GeometryTests.getRandomVector3f();
		Vector3fImpl v1 = GeometryTests.getRandomVector3f();
		float expAngle =
			(float) Math
				.acos((Math3D.dot(v0, v1) / (v0.length() * v1.length())));

		if (Math3D.angle(v0, v1) != expAngle
			|| Math3D.angle(v1, v0) != expAngle) {
			fail("testAngleIVector3fIVector3f - Expected angle " + expAngle
				+ " was not returned with vectors: " + v0.toString() + " "
				+ v1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#scale(org.eclipse.draw3d.geometryext.IVector3f, float, org.eclipse.draw3d.geometryext.Vector3f)}
	 * .
	 */
	public void testScaleIVector3fFloatVector3f() {
		Vector3fImpl v0 = GeometryTests.getRandomVector3f();
		float scalar = GeometryTests.getRandomFloat();
		IVector3f v1 =
			new Vector3fImpl(v0.x * scalar, v0.y * scalar, v0.z * scalar);

		Vector3f v2 = Math3D.scale(scalar, v0, null);

		if (!v1.equals(v2)) {
			fail("testScaleIVector3fFloatVector3f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		Math3D.scale(scalar, v0, v2);
		if (!v1.equals(v2)) {
			fail("testScaleIVector3fFloatVector3f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		v2 = Math3D.scale(scalar, v0, v0);
		if (!v1.equals(v2) || !v1.equals(v0)) {
			fail("testScaleIVector3fFloatVector3f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#translate(org.eclipse.draw3d.geometryext.IVector3f, float, float, float, org.eclipse.draw3d.geometryext.Vector3f)}
	 * .
	 */
	public void testTranslateIVector3fFloatFloatFloatVector3f() {
		Vector3fImpl v0 = GeometryTests.getRandomVector3f();
		float dX = GeometryTests.getRandomFloat();
		float dY = GeometryTests.getRandomFloat();
		float dZ = GeometryTests.getRandomFloat();
		IVector3f v1 = new Vector3fImpl(v0.x + dX, v0.y + dY, v0.z + dZ);

		Vector3f v2 = Math3D.translate(v0, dX, dY, dZ, null);

		if (!v1.equals(v2)) {
			fail("testTranslateIVector3fFloatFloatFloatVector3f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		Math3D.translate(v0, dX, dY, dZ, v2);
		if (!v1.equals(v2)) {
			fail("testTranslateIVector3fFloatFloatFloatVector3f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		v2 = Math3D.translate(v0, dX, dY, dZ, v0);
		if (!v1.equals(v2) || !v1.equals(v0)) {
			fail("testTranslateIVector3fFloatFloatFloatVector3f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#add(org.eclipse.draw3d.geometryext.IVector3f, org.eclipse.draw3d.geometryext.IVector3f, org.eclipse.draw3d.geometryext.Vector3f)}
	 * .
	 */
	public void testAddIVector3fIVector3fVector3f() {
		Vector3fImpl v0a = GeometryTests.getRandomVector3f();
		Vector3fImpl v0b = GeometryTests.getRandomVector3f();
		IVector3f v1 =
			new Vector3fImpl(v0a.x + v0b.x, v0a.y + v0b.y, v0a.z + v0b.z);

		Vector3f v2 = Math3D.add(v0a, v0b, null);

		if (!v1.equals(v2)) {
			fail("testAddIVector3fIVector3fVector3f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		Math3D.add(v0a, v0b, v2);
		if (!v1.equals(v2)) {
			fail("testAddIVector3fIVector3fVector3f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		v2 = Math3D.add(v0a, v0b, v0b);
		if (!v1.equals(v2) || !v1.equals(v0b)) {
			fail("testAddIVector3fIVector3fVector3f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#sub(org.eclipse.draw3d.geometryext.IVector3f, org.eclipse.draw3d.geometryext.IVector3f, org.eclipse.draw3d.geometryext.Vector3f)}
	 * .
	 */
	public void testSubIVector3fIVector3fVector3f() {
		Vector3fImpl v0a = GeometryTests.getRandomVector3f();
		Vector3fImpl v0b = GeometryTests.getRandomVector3f();
		IVector3f v1 =
			new Vector3fImpl(v0a.x - v0b.x, v0a.y - v0b.y, v0a.z - v0b.z);
		Vector3f v2 = Math3D.sub(v0a, v0b, null);

		if (!v1.equals(v2)) {
			fail("testSubIVector3fIVector3fVector3f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		Math3D.sub(v0a, v0b, v2);
		if (!v1.equals(v2)) {
			fail("testSubIVector3fIVector3fVector3f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		v2 = Math3D.sub(v0a, v0b, v0b);
		if (!v1.equals(v2) || !v1.equals(v0b)) {
			fail("testSubIVector3fIVector3fVector3f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#cross(org.eclipse.draw3d.geometryext.IVector3f, org.eclipse.draw3d.geometryext.IVector3f, org.eclipse.draw3d.geometryext.Vector3f)}
	 * .
	 */
	public void testCross() {
		Vector3fImpl v0a = GeometryTests.getRandomVector3f();
		Vector3fImpl v0b = GeometryTests.getRandomVector3f();

		float x = v0a.y * v0b.z - v0a.z * v0b.y;
		float y = v0a.z * v0b.x - v0a.x * v0b.z;
		float z = v0a.x * v0b.y - v0a.y * v0b.x;

		IVector3f v1 = new Vector3fImpl(x, y, z);

		Vector3f v2 = Math3D.cross(v0a, v0b, null);

		if (!v1.equals(v2)) {
			fail("testCross - Expected values do not match: " + v1.toString()
				+ " " + v2.toString());
		}

		Math3D.cross(v0a, v0b, v2);
		if (!v1.equals(v2)) {
			fail("testCross - Expected values do not match: " + v1.toString()
				+ " " + v2.toString());
		}

		v2 = Math3D.cross(v0a, v0b, v0b);
		if (!v1.equals(v2) || !v1.equals(v0b)) {
			fail("testCross - Expected values do not match: " + v1.toString()
				+ " " + v2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#translate(org.eclipse.draw3d.geometryext.IVector4f, float, float, float, float, org.eclipse.draw3d.geometryext.Vector4f)}
	 * .
	 */
	public void testTranslateIVector4fFloatFloatFloatFloatVector4f() {
		Vector4fImpl v0 = GeometryTests.getRandomVector4f();
		float dX = GeometryTests.getRandomFloat();
		float dY = GeometryTests.getRandomFloat();
		float dZ = GeometryTests.getRandomFloat();
		float dW = GeometryTests.getRandomFloat();
		IVector4f v1 =
			new Vector4fImpl(v0.x + dX, v0.y + dY, v0.z + dZ, v0.w + dW);

		Vector4f v2 = Math3D.translate(v0, dX, dY, dZ, dW, null);

		if (!v1.equals(v2)) {
			fail("testTranslateIVector4fFloatFloatFloatFloatVector4f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		Math3D.translate(v0, dX, dY, dZ, dW, v2);
		if (!v1.equals(v2)) {
			fail("testTranslateIVector4fFloatFloatFloatFloatVector4f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		v2 = Math3D.translate(v0, dX, dY, dZ, dW, v0);
		if (!v1.equals(v2) || !v1.equals(v0)) {
			fail("testTranslateIVector4fFloatFloatFloatFloatVector4f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#add(org.eclipse.draw3d.geometryext.IVector4f, org.eclipse.draw3d.geometryext.IVector4f, org.eclipse.draw3d.geometryext.Vector4f)}
	 * .
	 */
	public void testAddIVector4fIVector4fVector4f() {
		Vector4fImpl v0a = GeometryTests.getRandomVector4f();
		Vector4fImpl v0b = GeometryTests.getRandomVector4f();
		IVector4f v1 =
			new Vector4fImpl(v0a.x + v0b.x, v0a.y + v0b.y, v0a.z + v0b.z, v0a.w
				+ v0b.w);

		Vector4f v2 = Math3D.add(v0a, v0b, null);

		if (!v1.equals(v2)) {
			fail("testAddIVector4fIVector4fVector4f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		Math3D.add(v0a, v0b, v2);
		if (!v1.equals(v2)) {
			fail("testAddIVector4fIVector4fVector4f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		v2 = Math3D.add(v0a, v0b, v0b);
		if (!v1.equals(v2) || !v1.equals(v0b)) {
			fail("testAddIVector4fIVector4fVector4f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#sub(org.eclipse.draw3d.geometryext.IVector4f, org.eclipse.draw3d.geometryext.IVector4f, org.eclipse.draw3d.geometryext.Vector4f)}
	 * .
	 */
	public void testSubIVector4fIVector4fVector4f() {
		Vector4fImpl v0a = GeometryTests.getRandomVector4f();
		Vector4fImpl v0b = GeometryTests.getRandomVector4f();
		IVector4f v1 =
			new Vector4fImpl(v0a.x - v0b.x, v0a.y - v0b.y, v0a.z - v0b.z, v0a.w
				- v0b.w);

		Vector4f v2 = Math3D.sub(v0a, v0b, null);

		if (!v1.equals(v2)) {
			fail("testAddIVector4fIVector4fVector4f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		Math3D.sub(v0a, v0b, v2);
		if (!v1.equals(v2)) {
			fail("testAddIVector4fIVector4fVector4f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		v2 = Math3D.sub(v0a, v0b, v0b);
		if (!v1.equals(v2) || !v1.equals(v0b)) {
			fail("testAddIVector4fIVector4fVector4f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#negate(org.eclipse.draw3d.geometryext.IVector4f, org.eclipse.draw3d.geometryext.Vector4f)}
	 * .
	 */
	public void testNegateIVector4fVector4f() {
		Vector4fImpl v0 = GeometryTests.getRandomVector4f();
		Vector4fImpl v1 = new Vector4fImpl(-v0.x, -v0.y, -v0.z, -v0.w);

		Vector4f v2 = Math3D.negate(v0, null);

		if (!v1.equals(v2)) {
			fail("testNegateIVector4fVector4f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		Math3D.negate(v0, v2);
		if (!v1.equals(v2)) {
			fail("testNegateIVector4fVector4f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		v2 = Math3D.negate(v0, v0);
		if (!v1.equals(v2) || !v1.equals(v0)) {
			fail("testNegateIVector4fVector4f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#normalise(org.eclipse.draw3d.geometryext.IVector4f, org.eclipse.draw3d.geometryext.Vector4f)}
	 * .
	 */
	public void testNormaliseIVector4fVector4f() {
		Vector4fImpl v0 = GeometryTests.getRandomVector4f();
		float l = v0.length();
		Vector4fImpl v1 =
			new Vector4fImpl(v0.x / l, v0.y / l, v0.z / l, v0.w / l);

		Vector4f v2 = Math3D.normalise(v0, null);

		if (!v1.equals(v2, PREC)) {
			fail("testNormaliseIVector4fVector4f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		Math3D.normalise(v0, v2);
		if (!v1.equals(v2, PREC)) {
			fail("testNormaliseIVector4fVector4f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		v2 = Math3D.normalise(v0, v0);
		if (!v1.equals(v2, PREC) || !v1.equals(v0, PREC)) {
			fail("testNormaliseIVector4fVector4f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#dot(org.eclipse.draw3d.geometryext.IVector4f, org.eclipse.draw3d.geometryext.IVector4f)}
	 * .
	 */
	public void testDotIVector4fIVector4f() {
		Vector4fImpl v0 = GeometryTests.getRandomVector4f();
		Vector4fImpl v1 = GeometryTests.getRandomVector4f();
		float expDot = v0.x * v1.x + v0.y * v1.y + v0.z * v1.z + v0.w * v1.w;

		if (expDot != Math3D.dot(v0, v1) || expDot != Math3D.dot(v1, v0)) {
			fail("testDotIVector4fIVector4f - Expected dot " + expDot
				+ " was not returned with vectors: " + v0.toString() + " "
				+ v1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#angle(org.eclipse.draw3d.geometryext.IVector4f, org.eclipse.draw3d.geometryext.IVector4f)}
	 * .
	 */
	public void testAngleIVector4fIVector4f() {
		Vector4fImpl v0 = GeometryTests.getRandomVector4f();
		Vector4fImpl v1 = GeometryTests.getRandomVector4f();
		float expAngle =
			(float) Math
				.acos((Math3D.dot(v0, v1) / (v0.length() * v1.length())));

		if (Math3D.angle(v0, v1) != expAngle
			|| Math3D.angle(v1, v0) != expAngle) {
			fail("testAngleIVector4fIVector4f - Expected angle " + expAngle
				+ " was not returned with vectors: " + v0.toString() + " "
				+ v1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#scale(org.eclipse.draw3d.geometryext.IVector4f, float, org.eclipse.draw3d.geometryext.Vector4f)}
	 * .
	 */
	public void testScaleIVector4fFloatVector4f() {
		Vector4fImpl v0 = GeometryTests.getRandomVector4f();
		float scalar = GeometryTests.getRandomFloat();
		IVector4f v1 =
			new Vector4fImpl(v0.x * scalar, v0.y * scalar, v0.z * scalar, v0.w
				* scalar);

		Vector4f v2 = Math3D.scale(scalar, v0, null);

		if (!v1.equals(v2)) {
			fail("testScaleIVector4fFloatVector4f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		Math3D.scale(scalar, v0, v2);
		if (!v1.equals(v2)) {
			fail("testScaleIVector4fFloatVector4f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		v2 = Math3D.scale(scalar, v0, v0);
		if (!v1.equals(v2) || !v1.equals(v0)) {
			fail("testScaleIVector4fFloatVector4f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#add(org.eclipse.draw3d.geometryext.IMatrix3f, org.eclipse.draw3d.geometryext.IMatrix3f, org.eclipse.draw3d.geometryext.Matrix3f)}
	 * .
	 */
	public void testAddIMatrix3fIMatrix3fMatrix3f() {
		Matrix3fImpl m0a = GeometryTests.getRandomMatrix3f();
		Matrix3fImpl m0b = GeometryTests.getRandomMatrix3f();
		Matrix3fImpl m1 = new Matrix3fImpl();

		m1.a11 = m0a.a11 + m0b.a11;
		m1.a12 = m0a.a12 + m0b.a12;
		m1.a13 = m0a.a13 + m0b.a13;
		m1.a21 = m0a.a21 + m0b.a21;
		m1.a22 = m0a.a22 + m0b.a22;
		m1.a23 = m0a.a23 + m0b.a23;
		m1.a31 = m0a.a31 + m0b.a31;
		m1.a32 = m0a.a32 + m0b.a32;
		m1.a33 = m0a.a33 + m0b.a33;

		Matrix3f m2 = Math3D.add(m0a, m0b, null);

		if (!m1.equals(m2)) {
			fail("testAddIMatrix3fIMatrix3fMatrix3f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}

		Math3D.add(m0a, m0b, m2);
		if (!m1.equals(m2)) {
			fail("testAddIMatrix3fIMatrix3fMatrix3f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}

		m2 = Math3D.add(m0a, m0b, m0b);
		if (!m1.equals(m2) || !m1.equals(m0b)) {
			fail("testAddIMatrix3fIMatrix3fMatrix3f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#sub(org.eclipse.draw3d.geometryext.IMatrix3f, org.eclipse.draw3d.geometryext.IMatrix3f, org.eclipse.draw3d.geometryext.Matrix3f)}
	 * .
	 */
	public void testSubIMatrix3fIMatrix3fMatrix3f() {
		Matrix3fImpl m0a = GeometryTests.getRandomMatrix3f();
		Matrix3fImpl m0b = GeometryTests.getRandomMatrix3f();
		Matrix3fImpl m1 = new Matrix3fImpl();

		m1.a11 = m0a.a11 - m0b.a11;
		m1.a12 = m0a.a12 - m0b.a12;
		m1.a13 = m0a.a13 - m0b.a13;
		m1.a21 = m0a.a21 - m0b.a21;
		m1.a22 = m0a.a22 - m0b.a22;
		m1.a23 = m0a.a23 - m0b.a23;
		m1.a31 = m0a.a31 - m0b.a31;
		m1.a32 = m0a.a32 - m0b.a32;
		m1.a33 = m0a.a33 - m0b.a33;

		Matrix3f m2 = Math3D.sub(m0a, m0b, null);

		if (!m1.equals(m2)) {
			fail("testAddIMatrix3fIMatrix3fMatrix3f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}

		Math3D.sub(m0a, m0b, m2);
		if (!m1.equals(m2)) {
			fail("testAddIMatrix3fIMatrix3fMatrix3f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}

		m2 = Math3D.sub(m0a, m0b, m0b);
		if (!m1.equals(m2) || !m1.equals(m0b)) {
			fail("testAddIMatrix3fIMatrix3fMatrix3f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#mul(org.eclipse.draw3d.geometryext.IMatrix3f, org.eclipse.draw3d.geometryext.IMatrix3f, org.eclipse.draw3d.geometryext.Matrix3f)}
	 * .
	 */
	public void testMulIMatrix3fIMatrix3fMatrix3f() {
		Matrix3fImpl m0a = GeometryTests.getRandomMatrix3f();
		Matrix3fImpl m0b = GeometryTests.getRandomMatrix3f();
		Matrix3fImpl m1 = new Matrix3fImpl();

		m1.a11 = m0a.a11 * m0b.a11 + m0a.a21 * m0b.a12 + m0a.a31 * m0b.a13;
		m1.a12 = m0a.a12 * m0b.a11 + m0a.a22 * m0b.a12 + m0a.a32 * m0b.a13;
		m1.a13 = m0a.a13 * m0b.a11 + m0a.a23 * m0b.a12 + m0a.a33 * m0b.a13;
		m1.a21 = m0a.a11 * m0b.a21 + m0a.a21 * m0b.a22 + m0a.a31 * m0b.a23;
		m1.a22 = m0a.a12 * m0b.a21 + m0a.a22 * m0b.a22 + m0a.a32 * m0b.a23;
		m1.a23 = m0a.a13 * m0b.a21 + m0a.a23 * m0b.a22 + m0a.a33 * m0b.a23;
		m1.a31 = m0a.a11 * m0b.a31 + m0a.a21 * m0b.a32 + m0a.a31 * m0b.a33;
		m1.a32 = m0a.a12 * m0b.a31 + m0a.a22 * m0b.a32 + m0a.a32 * m0b.a33;
		m1.a33 = m0a.a13 * m0b.a31 + m0a.a23 * m0b.a32 + m0a.a33 * m0b.a33;

		Matrix3f m2 = Math3D.mul(m0a, m0b, null);

		if (!m1.equals(m2)) {
			fail("testMulIMatrix3fIMatrix3fMatrix3f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}

		Math3D.mul(m0a, m0b, m2);
		if (!m1.equals(m2)) {
			fail("testMulIMatrix3fIMatrix3fMatrix3f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}

		m2 = Math3D.mul(m0a, m0b, m0b);
		if (!m1.equals(m2) || !m1.equals(m0b)) {
			fail("testMulIMatrix3fIMatrix3fMatrix3f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#transform(org.eclipse.draw3d.geometryext.IVector3f, org.eclipse.draw3d.geometryext.IMatrix3f, org.eclipse.draw3d.geometryext.Vector3f)}
	 * .
	 */
	public void testTransformIMatrix3fIVector3fVector3f() {
		Matrix3fImpl m0 = GeometryTests.getRandomMatrix3f();
		Vector3fImpl v0 = GeometryTests.getRandomVector3f();

		float x = m0.a11 * v0.x + m0.a21 * v0.y + m0.a31 * v0.z;
		float y = m0.a12 * v0.x + m0.a22 * v0.y + m0.a32 * v0.z;
		float z = m0.a13 * v0.x + m0.a23 * v0.y + m0.a33 * v0.z;

		Vector3fImpl v1 = new Vector3fImpl(x, y, z);

		Vector3f v2 = Math3D.transform(v0, m0, null);

		if (!v1.equals(v2)) {
			fail("testTransformIMatrix3fIVector3fVector3f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		Math3D.transform(v0, m0, v2);
		if (!v1.equals(v2)) {
			fail("testTransformIMatrix3fIVector3fVector3f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		v2 = Math3D.transform(v0, m0, v0);
		if (!v1.equals(v2) || !v1.equals(v0)) {
			fail("testTransformIMatrix3fIVector3fVector3f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#transpose(org.eclipse.draw3d.geometryext.IMatrix3f, org.eclipse.draw3d.geometryext.Matrix3f)}
	 * .
	 */
	public void testTransposeIMatrix3fMatrix3f() {
		Matrix3fImpl m0 = GeometryTests.getRandomMatrix3f();
		Matrix3fImpl m1 = new Matrix3fImpl();

		m1.a11 = m0.a11;
		m1.a12 = m0.a21;
		m1.a13 = m0.a31;
		m1.a21 = m0.a12;
		m1.a22 = m0.a22;
		m1.a23 = m0.a32;
		m1.a31 = m0.a13;
		m1.a32 = m0.a23;
		m1.a33 = m0.a33;

		Matrix3f m2 = Math3D.transpose(m0, null);

		if (!m1.equals(m2)) {
			fail("testTransposeIMatrix3fMatrix3f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}

		Math3D.transpose(m0, m2);
		if (!m1.equals(m2)) {
			fail("testTransposeIMatrix3fMatrix3f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}

		m2 = Math3D.transpose(m0, m0);
		if (!m1.equals(m2) || !m1.equals(m0)) {
			fail("testTransposeIMatrix3fMatrix3f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#determinant(org.eclipse.draw3d.geometryext.IMatrix3f)}
	 * .
	 */
	public void testDeterminantIMatrix3f() {
		Matrix3fImpl m0 = GeometryTests.getRandomMatrix3f();
		float expDet =
			(m0.a11 * m0.a22 * m0.a33) + (m0.a12 * m0.a23 * m0.a31)
				+ (m0.a13 * m0.a21 * m0.a32) - (m0.a11 * m0.a23 * m0.a32)
				- (m0.a12 * m0.a21 * m0.a33) - (m0.a13 * m0.a22 * m0.a31);
		float f = Math3D.determinant(m0);

		if (!Math3D.equals(f, expDet, PREC)) {
			fail("testAngleIVector4fIVector4f - Expected angle " + expDet
				+ " was not returned (" + f + ") with matrix: " + m0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#invert(org.eclipse.draw3d.geometryext.IMatrix3f, org.eclipse.draw3d.geometryext.Matrix3f)}
	 * .
	 */
	public void testInvertIMatrix3fMatrix3f() {
		Matrix3fImpl m0 = GeometryTests.getRandomMatrix3f();
		Matrix3fImpl m1 = new Matrix3fImpl();

		float det = Math3D.determinant(m0);

		m1.a11 = (m0.a22 * m0.a33 - m0.a23 * m0.a32) / det;
		m1.a12 = (m0.a13 * m0.a32 - m0.a12 * m0.a33) / det;
		m1.a13 = (m0.a12 * m0.a23 - m0.a13 * m0.a22) / det;
		m1.a21 = (m0.a23 * m0.a31 - m0.a21 * m0.a33) / det;
		m1.a22 = (m0.a11 * m0.a33 - m0.a13 * m0.a31) / det;
		m1.a23 = (m0.a13 * m0.a21 - m0.a11 * m0.a23) / det;
		m1.a31 = (m0.a21 * m0.a32 - m0.a22 * m0.a31) / det;
		m1.a32 = (m0.a12 * m0.a31 - m0.a11 * m0.a32) / det;
		m1.a33 = (m0.a11 * m0.a22 - m0.a12 * m0.a21) / det;

		Matrix3f m2 = Math3D.invert(m0, null);

		if (!Math3D.equals(m1, m2, PREC)) {
			fail("testInvertIMatrix3fMatrix3f - Expected values do not match:\n"
				+ m1.toString() + "\nvs.\n" + m2.toString());
		}

		Math3D.invert(m0, m2);
		if (!Math3D.equals(m1, m2, PREC)) {
			fail("testInvertIMatrix3fMatrix3f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}

		m2 = Math3D.invert(m0, m0);
		if (!Math3D.equals(m1, m2, PREC) || !Math3D.equals(m1, m0, PREC)) {
			fail("testInvertIMatrix3fMatrix3f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#negate(org.eclipse.draw3d.geometryext.IMatrix3f, org.eclipse.draw3d.geometryext.Matrix3f)}
	 * .
	 */
	public void testNegateIMatrix3fMatrix3f() {
		Matrix3fImpl m0 = GeometryTests.getRandomMatrix3f();
		Matrix3fImpl m1 = new Matrix3fImpl();

		m1.a11 = -m0.a11;
		m1.a12 = -m0.a12;
		m1.a13 = -m0.a13;
		m1.a21 = -m0.a21;
		m1.a22 = -m0.a22;
		m1.a23 = -m0.a23;
		m1.a31 = -m0.a31;
		m1.a32 = -m0.a32;
		m1.a33 = -m0.a33;

		Matrix3f m2 = Math3D.negate(m0, null);

		if (!m1.equals(m2)) {
			fail("testNegateIMatrix3fMatrix3f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}

		Math3D.negate(m0, m2);
		if (!m1.equals(m2)) {
			fail("testNegateIMatrix3fMatrix3f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}

		m2 = Math3D.negate(m0, m0);
		if (!m1.equals(m2) || !m1.equals(m0)) {
			fail("testNegateIMatrix3fMatrix3f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#add(org.eclipse.draw3d.geometryext.IMatrix4f, org.eclipse.draw3d.geometryext.IMatrix4f, org.eclipse.draw3d.geometryext.Matrix4f)}
	 * .
	 */
	public void testAddIMatrix4fIMatrix4fMatrix4f() {
		Matrix4fImpl m0a = GeometryTests.getRandomMatrix4f();
		Matrix4fImpl m0b = GeometryTests.getRandomMatrix4f();
		Matrix4fImpl m1 = new Matrix4fImpl();

		m1.a11 = m0a.a11 + m0b.a11;
		m1.a12 = m0a.a12 + m0b.a12;
		m1.a13 = m0a.a13 + m0b.a13;
		m1.a14 = m0a.a14 + m0b.a14;
		m1.a21 = m0a.a21 + m0b.a21;
		m1.a22 = m0a.a22 + m0b.a22;
		m1.a23 = m0a.a23 + m0b.a23;
		m1.a24 = m0a.a24 + m0b.a24;
		m1.a31 = m0a.a31 + m0b.a31;
		m1.a32 = m0a.a32 + m0b.a32;
		m1.a33 = m0a.a33 + m0b.a33;
		m1.a34 = m0a.a34 + m0b.a34;
		m1.a41 = m0a.a41 + m0b.a41;
		m1.a42 = m0a.a42 + m0b.a42;
		m1.a43 = m0a.a43 + m0b.a43;
		m1.a44 = m0a.a44 + m0b.a44;

		Matrix4f m2 = Math3D.add(m0a, m0b, null);

		if (!m1.equals(m2)) {
			fail("testAddIMatrix4fIMatrix4fMatrix4f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}

		Math3D.add(m0a, m0b, m2);
		if (!m1.equals(m2)) {
			fail("testAddIMatrix4fIMatrix4fMatrix4f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}

		m2 = Math3D.add(m0a, m0b, m0b);
		if (!m1.equals(m2) || !m1.equals(m0b)) {
			fail("testAddIMatrix4fIMatrix4fMatrix4f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#sub(org.eclipse.draw3d.geometryext.IMatrix4f, org.eclipse.draw3d.geometryext.IMatrix4f, org.eclipse.draw3d.geometryext.Matrix4f)}
	 * .
	 */
	public void testSubIMatrix4fIMatrix4fMatrix4f() {
		Matrix4fImpl m0a = GeometryTests.getRandomMatrix4f();
		Matrix4fImpl m0b = GeometryTests.getRandomMatrix4f();
		Matrix4fImpl m1 = new Matrix4fImpl();

		m1.a11 = m0a.a11 - m0b.a11;
		m1.a12 = m0a.a12 - m0b.a12;
		m1.a13 = m0a.a13 - m0b.a13;
		m1.a14 = m0a.a14 - m0b.a14;
		m1.a21 = m0a.a21 - m0b.a21;
		m1.a22 = m0a.a22 - m0b.a22;
		m1.a23 = m0a.a23 - m0b.a23;
		m1.a24 = m0a.a24 - m0b.a24;
		m1.a31 = m0a.a31 - m0b.a31;
		m1.a32 = m0a.a32 - m0b.a32;
		m1.a33 = m0a.a33 - m0b.a33;
		m1.a34 = m0a.a34 - m0b.a34;
		m1.a41 = m0a.a41 - m0b.a41;
		m1.a42 = m0a.a42 - m0b.a42;
		m1.a43 = m0a.a43 - m0b.a43;
		m1.a44 = m0a.a44 - m0b.a44;

		Matrix4f m2 = Math3D.sub(m0a, m0b, null);

		if (!m1.equals(m2)) {
			fail("testSubIMatrix4fIMatrix4fMatrix4f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}

		Math3D.sub(m0a, m0b, m2);
		if (!m1.equals(m2)) {
			fail("testSubIMatrix4fIMatrix4fMatrix4f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}

		m2 = Math3D.sub(m0a, m0b, m0b);
		if (!m1.equals(m2) || !m1.equals(m0b)) {
			fail("testSubIMatrix4fIMatrix4fMatrix4f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#mul(org.eclipse.draw3d.geometryext.IMatrix4f, org.eclipse.draw3d.geometryext.IMatrix4f, org.eclipse.draw3d.geometryext.Matrix4f)}
	 * .
	 */
	public void testMulIMatrix4fIMatrix4fMatrix4f() {
		Matrix4fImpl m0a = GeometryTests.getRandomMatrix4f();
		Matrix4fImpl m0b = GeometryTests.getRandomMatrix4f();
		Matrix4fImpl m1 = new Matrix4fImpl();

		m1.a11 =
			m0a.a11 * m0b.a11 + m0a.a21 * m0b.a12 + m0a.a31 * m0b.a13 + m0a.a41
				* m0b.a14;
		m1.a12 =
			m0a.a12 * m0b.a11 + m0a.a22 * m0b.a12 + m0a.a32 * m0b.a13 + m0a.a42
				* m0b.a14;
		m1.a13 =
			m0a.a13 * m0b.a11 + m0a.a23 * m0b.a12 + m0a.a33 * m0b.a13 + m0a.a43
				* m0b.a14;
		m1.a14 =
			m0a.a14 * m0b.a11 + m0a.a24 * m0b.a12 + m0a.a34 * m0b.a13 + m0a.a44
				* m0b.a14;
		m1.a21 =
			m0a.a11 * m0b.a21 + m0a.a21 * m0b.a22 + m0a.a31 * m0b.a23 + m0a.a41
				* m0b.a24;
		m1.a22 =
			m0a.a12 * m0b.a21 + m0a.a22 * m0b.a22 + m0a.a32 * m0b.a23 + m0a.a42
				* m0b.a24;
		m1.a23 =
			m0a.a13 * m0b.a21 + m0a.a23 * m0b.a22 + m0a.a33 * m0b.a23 + m0a.a43
				* m0b.a24;
		m1.a24 =
			m0a.a14 * m0b.a21 + m0a.a24 * m0b.a22 + m0a.a34 * m0b.a23 + m0a.a44
				* m0b.a24;
		m1.a31 =
			m0a.a11 * m0b.a31 + m0a.a21 * m0b.a32 + m0a.a31 * m0b.a33 + m0a.a41
				* m0b.a34;
		m1.a32 =
			m0a.a12 * m0b.a31 + m0a.a22 * m0b.a32 + m0a.a32 * m0b.a33 + m0a.a42
				* m0b.a34;
		m1.a33 =
			m0a.a13 * m0b.a31 + m0a.a23 * m0b.a32 + m0a.a33 * m0b.a33 + m0a.a43
				* m0b.a34;
		m1.a34 =
			m0a.a14 * m0b.a31 + m0a.a24 * m0b.a32 + m0a.a34 * m0b.a33 + m0a.a44
				* m0b.a34;
		m1.a41 =
			m0a.a11 * m0b.a41 + m0a.a21 * m0b.a42 + m0a.a31 * m0b.a43 + m0a.a41
				* m0b.a44;
		m1.a42 =
			m0a.a12 * m0b.a41 + m0a.a22 * m0b.a42 + m0a.a32 * m0b.a43 + m0a.a42
				* m0b.a44;
		m1.a43 =
			m0a.a13 * m0b.a41 + m0a.a23 * m0b.a42 + m0a.a33 * m0b.a43 + m0a.a43
				* m0b.a44;
		m1.a44 =
			m0a.a14 * m0b.a41 + m0a.a24 * m0b.a42 + m0a.a34 * m0b.a43 + m0a.a44
				* m0b.a44;

		Matrix4f m2 = Math3D.mul(m0a, m0b, null);

		if (!m1.equals(m2)) {
			fail("testMulIMatrix4fIMatrix4fMatrix4f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}

		Math3D.mul(m0a, m0b, m2);
		if (!m1.equals(m2)) {
			fail("testMulIMatrix4fIMatrix4fMatrix4f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}

		m2 = Math3D.mul(m0a, m0b, m0b);
		if (!m1.equals(m2) || !m1.equals(m0b)) {
			fail("testMulIMatrix4fIMatrix4fMatrix4f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#transform(org.eclipse.draw3d.geometryext.IVector4f, org.eclipse.draw3d.geometryext.IMatrix4f, org.eclipse.draw3d.geometryext.Vector4f)}
	 * .
	 */
	public void testTransformIMatrix4fIVector4fVector4f() {
		Matrix4fImpl m0 = GeometryTests.getRandomMatrix4f();
		Vector4fImpl v0 = GeometryTests.getRandomVector4f();

		float x = m0.a11 * v0.x + m0.a21 * v0.y + m0.a31 * v0.z + m0.a41 * v0.w;
		float y = m0.a12 * v0.x + m0.a22 * v0.y + m0.a32 * v0.z + m0.a42 * v0.w;
		float z = m0.a13 * v0.x + m0.a23 * v0.y + m0.a33 * v0.z + m0.a43 * v0.w;
		float w = m0.a14 * v0.x + m0.a24 * v0.y + m0.a34 * v0.z + m0.a44 * v0.w;

		Vector4fImpl v1 = new Vector4fImpl(x, y, z, w);

		Vector4f v2 = Math3D.transform(v0, m0, null);

		if (!v1.equals(v2)) {
			fail("testTransformIMatrix4fIVector4fVector4f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		Math3D.transform(v0, m0, v2);
		if (!v1.equals(v2)) {
			fail("testTransformIMatrix4fIVector4fVector4f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}

		v2 = Math3D.transform(v0, m0, v0);
		if (!v1.equals(v2) || !v1.equals(v0)) {
			fail("testTransformIMatrix4fIVector4fVector4f - Expected values do not match: "
				+ v1.toString() + " " + v2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#transpose(org.eclipse.draw3d.geometryext.IMatrix4f, org.eclipse.draw3d.geometryext.Matrix4f)}
	 * .
	 */
	public void testTransposeIMatrix4fMatrix4f() {
		Matrix4fImpl m0 = GeometryTests.getRandomMatrix4f();
		Matrix4fImpl m1 = new Matrix4fImpl();

		m1.a11 = m0.a11;
		m1.a12 = m0.a21;
		m1.a13 = m0.a31;
		m1.a14 = m0.a41;
		m1.a21 = m0.a12;
		m1.a22 = m0.a22;
		m1.a23 = m0.a32;
		m1.a24 = m0.a42;
		m1.a31 = m0.a13;
		m1.a32 = m0.a23;
		m1.a33 = m0.a33;
		m1.a34 = m0.a43;
		m1.a41 = m0.a14;
		m1.a42 = m0.a24;
		m1.a43 = m0.a34;
		m1.a44 = m0.a44;

		Matrix4f m2 = Math3D.transpose(m0, null);

		if (!m1.equals(m2)) {
			fail("testTransposeIMatrix4fMatrix4f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}

		Math3D.transpose(m0, m2);
		if (!m1.equals(m2)) {
			fail("testTransposeIMatrix4fMatrix4f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}

		m2 = Math3D.transpose(m0, m0);
		if (!m1.equals(m2) || !m1.equals(m0)) {
			fail("testTransposeIMatrix4fMatrix4f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#translate(org.eclipse.draw3d.geometryext.IMatrix4f, org.eclipse.draw3d.geometryext.IVector3f, org.eclipse.draw3d.geometryext.Matrix4f)}
	 * .
	 */
	public void testTranslateIVector3fIMatrix4fMatrix4f() {

		// translating with null vector must not change matrix
		Matrix4f mAct =
			Math3D.translate(IMatrix4f.IDENTITY, IVector3f.NULLVEC3f, null);
		assertEquals(mAct, IMatrix4f.IDENTITY);

		// test simple translation
		Vector3fImpl vTransl = new Vector3fImpl(2, 3, 5); // GeometryTests.getRandomVector3f();

		Matrix4fImpl mExp = new Matrix4fImpl(IMatrix4f.IDENTITY);
		mExp.set(3, 0, mExp.get(0, 3) + vTransl.getX());
		mExp.set(3, 1, mExp.get(1, 3) + vTransl.getY());
		mExp.set(3, 2, mExp.get(2, 3) + vTransl.getZ());

		Matrix4f mtrans = new Matrix4fImpl();
		mtrans.set(3, 0, vTransl.getX());
		mtrans.set(3, 1, vTransl.getY());
		mtrans.set(3, 2, vTransl.getZ());

		mAct = Math3D.translate(IMatrix4f.IDENTITY, vTransl, null);
		assertEquals(mExp, mAct);

		// check supposed effect:
		Vector3f v = GeometryTests.getRandomVector3f();
		Vector3f vExp = Math3D.add(v, vTransl, null);
		Vector3f vAct = Math3D.transform(v, mAct, null);
		assertEquals(vExp, vAct);

	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#scale(org.eclipse.draw3d.geometryext.IVector3f, org.eclipse.draw3d.geometryext.IMatrix4f, org.eclipse.draw3d.geometryext.Matrix4f)}
	 * .
	 */
	public void testScaleIVector3fIMatrix4fMatrix4f() {
		Matrix4fImpl m0 = GeometryTests.getRandomMatrix4f();
		Vector3fImpl v1 = GeometryTests.getRandomVector3f();
		Matrix4fImpl m1 = new Matrix4fImpl(m0);

		m1.a11 = m0.a11 * v1.x;
		m1.a12 = m0.a12 * v1.x;
		m1.a13 = m0.a13 * v1.x;
		m1.a14 = m0.a14 * v1.x;
		m1.a21 = m0.a21 * v1.y;
		m1.a22 = m0.a22 * v1.y;
		m1.a23 = m0.a23 * v1.y;
		m1.a24 = m0.a24 * v1.y;
		m1.a31 = m0.a31 * v1.z;
		m1.a32 = m0.a32 * v1.z;
		m1.a33 = m0.a33 * v1.z;
		m1.a34 = m0.a34 * v1.z;

		// just to be equal as m3x are not changed.
		m1.a41 = m0.a41;
		m1.a42 = m0.a42;
		m1.a43 = m0.a43;
		m1.a44 = m0.a44;

		Matrix4f m2 = Math3D.scale(v1, m0, null);

		if (!Math3D.equals(m1, m2, PREC)) {
			fail("testScaleIVector3fIMatrix4fMatrix4f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}

		Math3D.scale(v1, m0, m2);
		if (!Math3D.equals(m1, m2, PREC)) {
			fail("testScaleIVector3fIMatrix4fMatrix4f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}

		m2 = Math3D.scale(v1, m0, m0);
		if (!Math3D.equals(m1, m2, PREC) || !Math3D.equals(m1, m0, PREC)) {
			fail("testScaleIVector3fIMatrix4fMatrix4f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#rotate(float, org.eclipse.draw3d.geometryext.IVector3f, org.eclipse.draw3d.geometryext.IMatrix4f, org.eclipse.draw3d.geometryext.Matrix4f)}
	 * .
	 */
	public void testRotate() {
		Matrix4fImpl m0 = GeometryTests.getRandomMatrix4f();
		Vector3fImpl v1 = GeometryTests.getRandomVector3f();

		// Test correct algorithm with rotation by 360 degree. It should return
		// the source matrix again.
		Matrix4f m1 = Math3D.rotate((float) (2 * Math.PI), v1, m0, null);

		if (!Math3D.equals(m1, m0, PREC)) {
			fail("testRotate - Rotation with 360 degree does not match source matrix: "
				+ m0.toString() + " " + m1.toString());
		}

		Math3D.rotate((float) (2 * Math.PI), v1, m0, m1);
		if (!Math3D.equals(m1, m0, PREC)) {
			fail("testScaleIVector3fIMatrix4fMatrix4f - Expected values do not match: "
				+ m0.toString() + " " + m1.toString());
		}

		m1 = Math3D.rotate((float) (2 * Math.PI), v1, m0, m0);
		if (!Math3D.equals(m1, m0, PREC)) {
			fail("testScaleIVector3fIMatrix4fMatrix4f - Expected values do not match: "
				+ m0.toString() + " " + m1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#determinant(org.eclipse.draw3d.geometryext.IMatrix4f)}
	 * .
	 */
	public void testDeterminantIMatrix4fRandom() {
		Matrix4fImpl m0 = GeometryTests.getRandomMatrix4f();
		Matrix4fImpl m1 = GeometryTests.getRandomMatrix4f();

		float detA = Math3D.determinant(m0) * Math3D.determinant(m1);
		float detB = Math3D.determinant(Math3D.mul(m0, m1, null));

		if (!Math3D.equals(detA, detB, PREC)) {
			fail("testDeterminantIMatrix4f - Test for multiplicative transformation failed: detA "
				+ detA + ", detB " + detB + m0.toString() + m1.toString());
		}

		detA = Math3D.determinant(Math3D.invert(m0, null));
		detB = (float) Math.pow(Math3D.determinant(m0), -1);

		if (!Math3D.equals(detA, detB, PREC)) {
			fail("testDeterminantIMatrix4f - Test with inverted matrix failed: detA "
				+ detA + ", detB " + detB + m0.toString());
		}

		detA = Math3D.determinant(m0);
		detB = Math3D.determinant(Math3D.transpose(m0, null));

		if (!Math3D.equals(detA, detB, PREC)) {
			fail("testDeterminantIMatrix4f - Test with transposed matrix failed: detA "
				+ detA + ", detB " + detB + m0.toString());
		}
	}

	public void testDeterminantIMatrix4fFixed() {

		Matrix4fImpl m0 =
			new Matrix4fImpl(0.641808f, 0.6173171f, 0.3888759f, 0.3780973f,
				0.6113494f, 0.33735108f, 0.5189923f, 0.44364285f, 0.8764232f,
				0.17627525f, 0.6259386f, 0.8142215f, 0.2934872f, 0.98154485f,
				0.86022735f, 0.0f);
		Matrix4fImpl m1 = GeometryTests.getRandomMatrix4f();

		float detA = Math3D.determinant(m0) * Math3D.determinant(m1);
		float detB = Math3D.determinant(Math3D.mul(m0, m1, null));

		if (!Math3D.equals(detA, detB, PREC)) {
			fail("testDeterminantIMatrix4f - Test for multiplicative transformation failed: detA "
				+ detA + ", detB " + detB + m0.toString() + m1.toString());
		}

		detA = Math3D.determinant(Math3D.invert(m0, null));
		detB = (float) Math.pow(Math3D.determinant(m0), -1);

		if (!Math3D.equals(detA, detB, PREC)) {
			fail("testDeterminantIMatrix4f - Test with inverted matrix failed: detA "
				+ detA + ", detB " + detB + m0.toString());
		}

		detA = Math3D.determinant(m0);
		detB = Math3D.determinant(Math3D.transpose(m0, null));

		if (!Math3D.equals(detA, detB, PREC)) {
			fail("testDeterminantIMatrix4f - Test with transposed matrix failed: detA "
				+ detA + ", detB " + detB + m0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#invert(org.eclipse.draw3d.geometryext.IMatrix4f, org.eclipse.draw3d.geometryext.Matrix4f)}
	 * .
	 */
	public void testInvertIMatrix4fMatrix4f() {
		Matrix4fImpl m0 = GeometryTests.getRandomMatrix4f();
		Matrix4fImpl m1 = GeometryTests.getRandomMatrix4f();

		Matrix4f m2 = Math3D.invert(m0, null);
		Math3D.invert(m2, m1);

		if (!Math3D.equals(m0, m1, 0.0001f)) {
			fail("testInvertIMatrix4fMatrix4f - Did not get same matrix from inverted inverse: "
				+ m0.toString() + " " + m1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.Math3D#negate(org.eclipse.draw3d.geometryext.IMatrix4f, org.eclipse.draw3d.geometryext.Matrix4f)}
	 * .
	 */
	public void testNegateIMatrix4fMatrix4f() {
		Matrix4fImpl m0 = GeometryTests.getRandomMatrix4f();
		Matrix4fImpl m1 = new Matrix4fImpl();

		m1.a11 = -m0.a11;
		m1.a12 = -m0.a12;
		m1.a13 = -m0.a13;
		m1.a14 = -m0.a14;
		m1.a21 = -m0.a21;
		m1.a22 = -m0.a22;
		m1.a23 = -m0.a23;
		m1.a24 = -m0.a24;
		m1.a31 = -m0.a31;
		m1.a32 = -m0.a32;
		m1.a33 = -m0.a33;
		m1.a34 = -m0.a34;
		m1.a41 = -m0.a41;
		m1.a42 = -m0.a42;
		m1.a43 = -m0.a43;
		m1.a44 = -m0.a44;

		Matrix4f m2 = Math3D.negate(m0, null);

		if (!m1.equals(m2)) {
			fail("testNegateIMatrix4fMatrix4f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}

		Math3D.negate(m0, m2);
		if (!m1.equals(m2)) {
			fail("testNegateIMatrix4fMatrix4f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}

		m2 = Math3D.negate(m0, m0);
		if (!m1.equals(m2) || !m1.equals(m0)) {
			fail("testNegateIMatrix4fMatrix4f - Expected values do not match: "
				+ m1.toString() + " " + m2.toString());
		}
	}
}
