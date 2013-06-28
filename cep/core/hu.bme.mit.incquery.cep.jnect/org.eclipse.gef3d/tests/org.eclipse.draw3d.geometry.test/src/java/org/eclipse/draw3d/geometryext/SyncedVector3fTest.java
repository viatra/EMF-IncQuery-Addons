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

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw3d.geometry.GeometryTests;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometryext.SyncedVector3f;
import org.eclipse.draw3d.geometry.Vector3f;


/**
 * SyncedVector3fTest Test case for org.eclipse.draw3d.geometryext.SyncedVector3f.
 * 
 * @author Matthias Thiele
 * @version $Revision$
 * @since 24.10.2008
 */
public class SyncedVector3fTest extends TestCase
{
	/**
	 * {@inheritDoc}
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception
	{
		super.tearDown();
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.SyncedVector3f#SyncedVector3f()} and
	 * {@link org.eclipse.draw3d.geometryext.SyncedVector3f#setVector3f(org.eclipse.draw3d.geometryext.IVector3f)}
	 * and
	 * {@link org.eclipse.draw3d.geometryext.SyncedVector3f#setVector3fAsDimension(org.eclipse.draw3d.geometryext.IVector3f)}
	 * and
	 * {@link org.eclipse.draw3d.geometryext.SyncedVector3f#getVector3f(org.eclipse.draw2d.geometry.Dimension)}
	 * and
	 * {@link org.eclipse.draw3d.geometryext.SyncedVector3f#getVector3f(org.eclipse.draw2d.geometry.Point)}
	 */
	public void testSyncedVector3f()
	{
		/*
		 * Correct functionality of the container is verified by setting the
		 * 3D-Vector first, getting Point and Dimension afterwards (where
		 * x==with and y==height should apply) and getting 3D-Vectors back again
		 * with Point and Dimension. These Vectors should be equal to the
		 * initial one.
		 */
		SyncedVector3f sv0 = new SyncedVector3f();
		Vector3f v0 = GeometryTests.getRandomVector3f(true, 1000);

		Point p0 = sv0.setVector3f(v0);
		Dimension d0 = sv0.setVector3fAsDimension(v0);

		if (p0.x != d0.width || p0.y != d0.height)
		{
			fail("testSyncedVector3f - Resulting point not equals Dimension: "
					+ p0 + " " + d0 + v0.toString());
		}

		IVector3f v1 = sv0.getVector3f(p0);
		IVector3f v2 = sv0.getVector3f(d0);

		if (!v0.equals(v1))
		{
			fail("testSyncedVector3f - Initial and resulting vectors are not equal: "
					+ v0.toString() + v1.toString());
		}

		if (!v0.equals(v2))
		{
			fail("testSyncedVector3f - Initial and resulting vectors are not equal: "
					+ v0.toString() + v2.toString());
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometryext.SyncedVector3f#setZ(float)}.
	 */
	public void testSetZ()
	{
		/*
		 * Setting z value for the initial position vector and for the synced
		 * bounds. Expected initial and resulting position vector to be equal.
		 */

		SyncedVector3f sv0 = new SyncedVector3f();
		Vector3f v0 = GeometryTests.getRandomVector3f(true, 1000);
		float z = GeometryTests.getRandomFloat();

		Point p0 = sv0.setVector3f(v0);
		sv0.setZ(z);
		v0.setZ(z);

		if (!v0.equals(sv0.getVector3f(p0)))
		{
			fail("testSetZ - Initial and resulting vector with manipulated Z-value are not equal: "
					+ v0.toString() + sv0.getVector3f(p0).toString());
		}
	}

}
