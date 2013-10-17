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

import java.text.DecimalFormat;

import junit.framework.TestCase;

/**
 * BoundingBox3fTest Test case for
 * org.eclipse.draw3d.geometryext.BoundingBox3fImpl and the corresponding
 * interfaces IBoundingBox and BoundingBox.
 * 
 * @author Matthias Thiele
 * @version $Revision$
 * @since 24.10.2008
 */
public class BoundingBox3fTest extends TestCase {

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
	 * {@link org.eclipse.draw3d.geometryext.BoundingBoxImpl#BoundingBox3fImpl()}
	 * .
	 */
	public void testBoundingBox3fImpl() {
		IVector3f v0 = new Vector3fImpl();
		IBoundingBox b0 = new BoundingBoxImpl();

		assertTrue(v0.equals(b0.getLocation(null)));
		assertTrue(v0.equals(b0.getLocation(null)));
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.BoundingBoxImpl#BoundingBox3fImpl(org.eclipse.draw3d.geometryext.IBoundingBox)}
	 * and
	 * {@link org.eclipse.draw3d.geometryext.BoundingBoxImpl#BoundingBox3fImpl(org.eclipse.draw3d.geometryext.IVector3f, org.eclipse.draw3d.geometryext.IVector3f)}
	 * .
	 */
	public void testBoundingBox3fImplIBoundingBox3f() {
		IVector3f v0 = GeometryTests.getRandomVector3f();
		IVector3f v1 = GeometryTests.getRandomVector3f();

		IBoundingBox b0 = new BoundingBoxImpl(v0, v1);
		IBoundingBox b1 = new BoundingBoxImpl(b0);

		if (!v0.equals(b1.getLocation(null))) {
			fail("testBoundingBox3fImplIBoundingBox3f - Source position vector not stored correctly: "
				+ v0.toString() + " " + b1.getLocation(null).toString());
		}

		if (!v1.equals(b1.getSize(null))) {
			fail("testBoundingBox3fImplIBoundingBox3f - Source position vector not stored correctly: "
				+ v0.toString() + " " + b1.getSize(null).toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.BoundingBoxImpl#toString()}.
	 */
	public void testToString() {
		IVector3f v0 = GeometryTests.getRandomVector3f();
		IVector3f v1 = GeometryTests.getRandomVector3f();

		IBoundingBox b0 = new BoundingBoxImpl(v0, v1);
		String s = b0.toString();

		DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.##");

		String[] descr =
			{ "pos.x", "pos.y", "pos.z", "size.x", "size.y", "size.z" };
		String[] exp =
			{ DECIMAL_FORMAT.format(v0.getX()),
				DECIMAL_FORMAT.format(v0.getY()),
				DECIMAL_FORMAT.format(v0.getZ()),
				DECIMAL_FORMAT.format(v1.getX()),
				DECIMAL_FORMAT.format(v1.getY()),
				DECIMAL_FORMAT.format(v1.getZ()) };
		
		for (int i=0; i<descr.length; i++) {
			assertTrue(descr[i] + " not found in bounding box string", s.contains(exp[i]));
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.BoundingBoxImpl#resize(float, float, float)}
	 * .
	 */
	public void testResizeFloatFloatFloat() {
		BoundingBox b0 = GeometryTests.getRandomBoundingBox3f();
		Vector3f v0 = new Vector3fImpl();
		b0.getSize(v0);

		float dX = GeometryTests.getRandomFloat();
		float dY = GeometryTests.getRandomFloat();
		float dZ = GeometryTests.getRandomFloat();

		b0.resize(dX, dY, dZ);
		Math3D.translate(v0, dX, dY, dZ, v0);

		if (!v0.equals(b0.getSize(null))) {
			fail("testResizeFloatFloatFloat - Size vector not equals to expected: "
				+ v0.toString() + b0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.BoundingBoxImpl#expand(float)}.
	 */
	public void testExpand() {
		Vector3f v0 = GeometryTests.getRandomVector3f();
		Vector3f v1 = GeometryTests.getRandomVector3f();
		float delta = GeometryTests.getRandomFloat();

		BoundingBox b0 = new BoundingBoxImpl(v0, v1);
		b0.expand(delta);
		Math3D.translate(v0, delta * -0.5f, delta * -0.5f, delta * -0.5f, v0);
		Math3D.translate(v1, delta, delta, delta, v1);

		if (!v0.equals(b0.getLocation(null))) {
			fail("testExpand - Position vector not equals to expected: "
				+ v0.toString() + b0.getLocation(null).toString());
		}

		if (!v1.equals(b0.getSize(null))) {
			fail("testExpand - Size vector not equals to expected: "
				+ v0.toString() + b0.getSize(null).toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.BoundingBoxImpl#resize(org.eclipse.draw3d.geometryext.IVector3f)}
	 * .
	 */
	public void testResizeIVector3f() {
		BoundingBox b0 = GeometryTests.getRandomBoundingBox3f();
		Vector3f v0 = new Vector3fImpl();
		b0.getSize(v0);
		Vector3f v1 = GeometryTests.getRandomVector3f();

		b0.resize(v1);
		Math3D.translate(v0, v1.getX(), v1.getY(), v1.getZ(), v0);

		if (!v0.equals(b0.getSize(null))) {
			fail("testResizeFloatFloatFloat - Size vector not equals to expected: "
				+ v0.toString() + v0.toString() + b0.getSize(null).toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.BoundingBoxImpl#set(org.eclipse.draw3d.geometryext.IBoundingBox)}
	 * .
	 */
	public void testSet() {
		BoundingBox b0 = GeometryTests.getRandomBoundingBox3f();
		BoundingBox b1 = GeometryTests.getRandomBoundingBox3f();

		b0.set(b1);

		IVector3f v0 = b0.getSize(null);
		IVector3f v1 = b1.getSize(null);
		if (!v0.equals(v1)) {
			fail("testSet - Size vectors to not match between source and destination: "
				+ v0.toString() + v1.toString());
		}

		v0 = b0.getLocation(null);
		v1 = b1.getLocation(null);
		if (!v0.equals(v1)) {
			fail("testSet - Position vectors to not match between source and destination: "
				+ v0.toString() + v1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.BoundingBoxImpl#setLocation(float, float, float)}
	 * .
	 */
	public void testSetLocation() {
		BoundingBox b0 = GeometryTests.getRandomBoundingBox3f();
		Vector3f v0 = GeometryTests.getRandomVector3f();

		b0.setLocation(v0.getX(), v0.getY(), v0.getZ());
		IVector3f v1 = b0.getLocation(null);

		if (!v0.equals(v1)) {
			fail("testSetLocation - Position vector not equal to source: "
				+ v0.toString() + v1.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.BoundingBoxImpl#translate(float, float, float)}
	 * .
	 */
	public void testTranslateFloatFloatFloat() {
		BoundingBox b0 = GeometryTests.getRandomBoundingBox3f();
		Vector3f v0 = new Vector3fImpl();
		b0.getLocation(v0);

		float dX = GeometryTests.getRandomFloat();
		float dY = GeometryTests.getRandomFloat();
		float dZ = GeometryTests.getRandomFloat();

		b0.translate(dX, dY, dZ);
		Math3D.translate(v0, dX, dY, dZ, v0);

		if (!v0.equals(b0.getLocation(null))) {
			fail("testTranslateFloatFloatFloat - Size vector not equals to expected: "
				+ v0.toString() + b0.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.BoundingBoxImpl#translate(org.eclipse.draw3d.geometryext.IVector3f)}
	 * .
	 */
	public void testTranslateIVector3f() {
		BoundingBox b0 = GeometryTests.getRandomBoundingBox3f();
		Vector3f v0 = new Vector3fImpl();
		b0.getLocation(v0);
		Vector3f v1 = GeometryTests.getRandomVector3f();

		b0.translate(v1);
		Math3D.translate(v0, v1.getX(), v1.getY(), v1.getZ(), v0);

		if (!v0.equals(b0.getLocation(null))) {
			fail("testResizeFloatFloatFloat - Size vector not equals to expected: "
				+ v0.toString() + v1.toString() + b0.getSize(null).toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.BoundingBoxImpl#getCenter(org.eclipse.draw3d.geometryext.Vector3f)}
	 * .
	 */
	public void testGetCenter() {
		BoundingBox b0 = GeometryTests.getRandomBoundingBox3f();
		Vector3f v0 = new Vector3fImpl();
		IVector3f v1 = b0.getLocation(null);
		IVector3f v2 = b0.getSize(null);

		v0.setX(v1.getX() + v2.getX() / 2);
		v0.setY(v1.getY() + v2.getY() / 2);
		v0.setZ(v1.getZ() + v2.getZ() / 2);

		IVector3f v3 = b0.getCenter(null);
		if (!v0.equals(v3)) {
			fail("testGetCenter - Expected values do not match: "
				+ v0.toString() + v3.toString());
		}

		Vector3f v4 = new Vector3fImpl();
		b0.getCenter(v4);
		if (!v0.equals(v4)) {
			fail("testGetCenter - Expected values do not match: "
				+ v0.toString() + v4.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.BoundingBoxImpl#getLocation(org.eclipse.draw3d.geometryext.Vector3f)}
	 * .
	 */
	public void testGetPosition() {
		Vector3f v0 = GeometryTests.getRandomVector3f();
		Vector3f v1 = GeometryTests.getRandomVector3f();
		BoundingBox b0 = new BoundingBoxImpl(v0, v1);

		IVector3f v2 = b0.getLocation(null);
		if (!v0.equals(v2)) {
			fail("testGetPosition - Expected values do not match: "
				+ v0.toString() + v2.toString());
		}

		Vector3f v3 = new Vector3fImpl();
		b0.getLocation(v3);
		if (!v0.equals(v3)) {
			fail("testGetCenter - Expected values do not match: "
				+ v0.toString() + v3.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.BoundingBoxImpl#getSize(org.eclipse.draw3d.geometryext.Vector3f)}
	 * .
	 */
	public void testGetSize() {
		Vector3f v0 = GeometryTests.getRandomVector3f();
		Vector3f v1 = GeometryTests.getRandomVector3f();
		BoundingBox b0 = new BoundingBoxImpl(v0, v1);

		IVector3f v2 = b0.getSize(null);
		if (!v1.equals(v2)) {
			fail("testGetSize - Expected values do not match: " + v1.toString()
				+ v2.toString());
		}

		Vector3f v3 = new Vector3fImpl();
		b0.getSize(v3);
		if (!v1.equals(v3)) {
			fail("testGetSize - Expected values do not match: " + v1.toString()
				+ v3.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.BoundingBoxImpl#scale(float)}.
	 */
	public void testScale() {
		BoundingBoxImpl b0 = GeometryTests.getRandomBoundingBox3f();
		Vector3f v0 = new Vector3fImpl(b0.getSize(null));
		float scale = GeometryTests.getRandomFloat();

		Math3D.scale(scale, v0, v0);
		b0.scale(scale);

		if (!v0.equals(b0.getSize(null))) {
			fail("testScale - Size vector not as expected: " + v0.toString()
				+ b0.getSize(null));
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.BoundingBoxImpl#transform(org.eclipse.draw3d.geometryext.IMatrix4f)}
	 * .
	 */
	public void testTransform() {
		IMatrix4f m0 = GeometryTests.getRandomMatrix4f();
		BoundingBoxImpl b0 = GeometryTests.getRandomBoundingBox3f();

		Vector3f v0 = new Vector3fImpl(b0.getLocation(null));
		Vector4f v1 = new Vector4fImpl(v0.getX(), v0.getY(), v0.getZ(), 1);
		Math3D.transform(v1, m0, v1);

		v0.setX(v1.getX() / v1.getW());
		v0.setY(v1.getY() / v1.getW());
		v0.setZ(v1.getZ() / v1.getW());

		b0.transform(m0);

		if (!v0.equals(b0.getLocation(null))) {
			fail("testTransform - Position vector not as expected: "
				+ v0.toString() + b0.getLocation(null));
		}
	}
}
