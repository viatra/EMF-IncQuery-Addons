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

package org.eclipse.draw3d.geometryext;

import junit.framework.TestCase;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw3d.geometry.BoundingBoxImpl;
import org.eclipse.draw3d.geometry.GeometryTests;
import org.eclipse.draw3d.geometry.IBoundingBox;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometryext.SyncedBounds3D;
import org.eclipse.draw3d.geometry.Vector3f;


/**
 * SyncedBoundsTest Test case for org.eclipse.draw3d.geometryext.SyncedBounds3D.
 * 
 * @author Matthias Thiele
 * @version $Revision$
 * @since 24.10.2008
 */
public class SyncedBoundsTest extends TestCase {
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
	 * {@link org.eclipse.draw3d.geometryext.SyncedBounds3D#SyncedBounds()}. and
	 * {@link org.eclipse.draw3d.geometryext.SyncedBounds3D#getLocation3D(org.eclipse.draw2d.geometry.Rectangle)}
	 * and
	 * {@link org.eclipse.draw3d.geometryext.SyncedBounds3D#getSize3D(org.eclipse.draw2d.geometry.Rectangle)}
	 * and
	 * {@link org.eclipse.draw3d.geometryext.SyncedBounds3D#setBounds3D(org.eclipse.draw3d.geometryext.IVector3f, org.eclipse.draw3d.geometryext.IVector3f)}
	 */
	public void testSyncedBounds() {
		/*
		 * Correct functionality of the container is verified by setting the
		 * 3D-Bounds first, getting Location3D and Size3D with the calculated
		 * 2D-Bounds which should return the initial 3D-Bounds again.
		 */
		SyncedBounds3D sb0 = new SyncedBounds3D();
		Vector3f v0 = GeometryTests.getRandomVector3f(true, 1000);
		Vector3f v1 = GeometryTests.getRandomVector3f(true, 1000);

		Rectangle r0 = sb0.setBounds3D(v0, v1);

		IVector3f v2 = sb0.getLocation3D(r0);
		IVector3f v3 = sb0.getSize3D(r0);

		if (!v0.equals(v2)) {
			fail("testSyncedBounds - Initial and resulting Location3D does not fit: "
					+ v0.toString() + v2.toString());
		}

		if (!v1.equals(v3)) {
			fail("testSyncedBounds - Initial and resulting Size3D does not fit: "
					+ v1.toString() + v3.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.SyncedBounds3D#getBoundingBox(org.eclipse.draw2d.geometry.Rectangle)}
	 * .
	 */
	public void testGetBoundingBox() {
		/*
		 * The BoundingBox returned by SyncedBounds3D.getBoundingBox() has
		 * naturally to be equal to the BoundingBox which is directly created
		 * with the same 3D-Bounds.
		 */
		SyncedBounds3D sb0 = new SyncedBounds3D();
		Vector3f v0 = GeometryTests.getRandomVector3f(true, 1000);
		Vector3f v1 = GeometryTests.getRandomVector3f(true, 1000);

		Rectangle r0 = sb0.setBounds3D(v0, v1);

		IBoundingBox b0 = sb0.getBoundingBox(r0);
		IBoundingBox b1 = new BoundingBoxImpl(v0, v1);

		if (!b0.getCenter(null).equals(b1.getCenter(null))) {
			fail("testGetBoundingBox - Center vectors are not equal:"
					+ b0.getCenter(null).toString()
					+ b1.getCenter(null).toString());
		}

		if (!b0.getLocation(null).equals(b1.getLocation(null))) {
			fail("testGetBoundingBox - Position vectors are not equal:"
					+ b0.getLocation(null).toString()
					+ b1.getLocation(null).toString());
		}

		if (!b0.getSize(null).equals(b1.getSize(null))) {
			fail("testGetBoundingBox - Size vectors are not equal:"
					+ b0.getSize(null).toString() + b1.getSize(null).toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.SyncedBounds3D#setZ(float)}.
	 */
	public void testSetZ() {
		/*
		 * Setting z value for the initial position vector and for the synced
		 * bounds. Expected initial and resulting position vector to be equal.
		 */

		SyncedBounds3D sb0 = new SyncedBounds3D();
		Vector3f v0 = GeometryTests.getRandomVector3f(true, 1000);
		Vector3f v1 = GeometryTests.getRandomVector3f(true, 1000);
		float z = GeometryTests.getRandomFloat();

		Rectangle r0 = sb0.setBounds3D(v0, v1);
		sb0.setZ(z);
		v0.setZ(z);

		if (!v0.equals(sb0.getLocation3D(r0))) {
			fail("testSetZ - Initial and resulting position vector with manipulated Z-value are not equal: "
					+ v0.toString() + sb0.getLocation3D(r0).toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.SyncedBounds3D#setDepth(float)}.
	 */
	public void testSetDepth() {
		/*
		 * Setting z value for the initial size vector and depth for the synced
		 * bounds. Expected initial and resulting size vector to be equal.
		 */

		SyncedBounds3D sb0 = new SyncedBounds3D();
		Vector3f v0 = GeometryTests.getRandomVector3f(true, 1000);
		Vector3f v1 = GeometryTests.getRandomVector3f(true, 1000);
		float z = GeometryTests.getRandomFloat();

		Rectangle r0 = sb0.setBounds3D(v0, v1);
		sb0.setDepth(z);
		v1.setZ(z);

		if (!v1.equals(sb0.getSize3D(r0))) {
			fail("testSetZ - Initial and resulting size vector with manipulated Z-value are not equal: "
					+ v1.toString() + sb0.getSize3D(r0).toString());
		}
	}

}
