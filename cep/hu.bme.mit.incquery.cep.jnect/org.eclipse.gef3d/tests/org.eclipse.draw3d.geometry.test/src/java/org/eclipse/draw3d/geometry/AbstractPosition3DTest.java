/*******************************************************************************
 * Copyright (c) 2009 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.geometry;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * AbstractPosition3DTest There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Aug 12, 2009
 */
public class AbstractPosition3DTest {

	public static float EPS = 0.001f;

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometry.AbstractPosition3D#getAbsolute(org.eclipse.draw3d.geometry.Position3D)}
	 * .
	 */
	@Test
	public void testGetAbsolute() {
		IHost3D host = Position3DUtil.createAbsolutePosition().getHost();
		Position3D parent = host.getPosition3D();
		Position3D pos = Position3DUtil.createRelativePosition(host);

		parent.setLocation3D(new Vector3fImpl(1, 1, 0));
		pos.setLocation3D(new Vector3fImpl(1, 0, 0));

		Position3D abs = pos.getAbsolute(null);
		IVector3f v = abs.getLocation3D();
		assertEquals(2, v.getX(), EPS);
		assertEquals(1, v.getY(), EPS);
		assertEquals(0, v.getZ(), EPS);

		parent.setSize3D(new Vector3fImpl(3, 1, 1));
		parent.setRotation3D(new Vector3fImpl(0, 0, (float) (Math.PI / 2f)));

		abs = pos.getAbsolute(null);
		v = abs.getLocation3D();
		assertEquals(1, v.getX(), EPS);
		assertEquals(2, v.getY(), EPS);
		assertEquals(0, v.getZ(), EPS);

		pos.setLocation3D(new Vector3fImpl(3, 1, 0));

		abs = pos.getAbsolute(null);
		v = abs.getLocation3D();
		assertEquals(0, v.getX(), EPS);
		assertEquals(4, v.getY(), EPS);
		assertEquals(0, v.getZ(), EPS);

		v = abs.getRotation3D();
		assertEquals(0, v.getX(), EPS);
		assertEquals(0, v.getY(), EPS);
		assertEquals((float) (Math.PI / 2f), v.getZ(), EPS);

	}

	/**
	 * 
	 */
	@Test
	public void testSetPosition() {
		IHost3D host = Position3DUtil.createAbsolutePosition().getHost();
		Position3D parent = host.getPosition3D();
		Position3D pos = Position3DUtil.createRelativePosition(host);

		parent.setLocation3D(new Vector3fImpl(1, 1, 0));
		parent.setSize3D(new Vector3fImpl(3, 1, 1));
		parent.setRotation3D(new Vector3fImpl(0, 0, (float) (Math.PI / 2f)));

		pos.setSize3D(new Vector3fImpl(2, 2, 2));

		Position3D absPos = Position3DUtil.createAbsolutePosition();
		absPos.setLocation3D(new Vector3fImpl(2, 3, 0));

		pos.setPosition(absPos);
		IVector3f r = pos.getLocation3D();
		assertEquals(2, r.getX(), EPS);
		assertEquals(-1, r.getY(), EPS);
		assertEquals(0, r.getZ(), EPS);

		Position3D abs = pos.getAbsolute(null);
		IVector3f v = abs.getLocation3D();

		assertEquals(2, v.getX(), EPS); // is 1
		assertEquals(3, v.getY(), EPS);
		assertEquals(0, v.getZ(), EPS);
	}

	/**
	 * 
	 */
	@Test
	public void testAbsoluteRelativePosition() {
		Position3D parent = Position3DUtil.createAbsolutePosition();
		Position3D pos =
			Position3DUtil.createRelativePosition(parent.getHost());

		parent.setLocation3D(new Vector3fImpl(10, 20, 30));
		parent.setSize3D(new Vector3fImpl(40, 50, 60));
		parent.setRotation3D(new Vector3fImpl(1, 2, 3));

		for (int i = 0; i < 25; i++) {
			Position3D absPos = Position3DUtil.createAbsolutePosition();
			absPos.setLocation3D(new Vector3fImpl((float) Math.random(),
				(float) Math.random(), (float) Math.random()));
			// absPos.setSize3D(new Vector3fImpl(20000,
			// 20000, 20000));

			absPos.setSize3D(new Vector3fImpl((float) Math.random(),
				(float) Math.random(), (float) Math.random()));
			absPos.setRotation3D(new Vector3fImpl((float) Math.random(),
				(float) Math.random(), (float) Math.random()));
			pos.setPosition(absPos);
			Position3D posAbsPos = pos.getAbsolute(null);
			assertEquals(absPos.getLocation3D().getX(), posAbsPos
				.getLocation3D().getX(), EPS);
			assertEquals(absPos.getLocation3D().getY(), posAbsPos
				.getLocation3D().getY(), EPS);
			assertEquals(absPos.getLocation3D().getZ(), posAbsPos
				.getLocation3D().getZ(), EPS);
		}
	}

}
