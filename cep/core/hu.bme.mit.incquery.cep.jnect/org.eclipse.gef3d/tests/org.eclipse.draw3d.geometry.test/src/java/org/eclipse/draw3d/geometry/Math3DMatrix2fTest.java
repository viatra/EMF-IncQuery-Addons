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

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Math3DMatrix2fTest
 * There should really be more documentation here.
 *
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	Dec 17, 2008
 */
public class Math3DMatrix2fTest {
	
	public final static float PREC = 0.00001f;

	/**
	 * Test method for {@link org.eclipse.draw3d.geometry.Math3DMatrix2f#add(org.eclipse.draw3d.geometry.IMatrix2f, org.eclipse.draw3d.geometry.IMatrix2f, org.eclipse.draw3d.geometry.Matrix2f)}.
	 */
	@Test
	public void testAddIMatrix2fIMatrix2fMatrix2f() {
		Matrix2fImpl m0 = new Matrix2fImpl(1,2,3,4, false);
		Matrix2fImpl m1 = new Matrix2fImpl(5,6,7,8, false);
		Matrix2fImpl e = new Matrix2fImpl(6,8,10, 12, false);
		
		Matrix2f r = Math3D.add(m0, m1, null);
		
		if (!Math3D.equals(e, r, PREC)) {
			fail("Add failed, exprected" + e + "was" + r);
		}
	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometry.Math3DMatrix2f#sub(org.eclipse.draw3d.geometry.IMatrix2f, org.eclipse.draw3d.geometry.IMatrix2f, org.eclipse.draw3d.geometry.Matrix2f)}.
	 */
	@Test
	public void testSubIMatrix2fIMatrix2fMatrix2f() {
		
		Matrix2fImpl m0= new Matrix2fImpl(6,8,10, 12, false);
		Matrix2fImpl m1 = new Matrix2fImpl(1,2,3,4, false);
		Matrix2fImpl e = new Matrix2fImpl(5,6,7,8, false);
		Matrix2f r = Math3D.sub(m0, m1, null);
		
		if (!Math3D.equals(e, r, PREC)) {
			fail("Sub failed, exprected" + e + "was" + r);
		}

	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometry.Math3DMatrix2f#mul(org.eclipse.draw3d.geometry.IMatrix2f, org.eclipse.draw3d.geometry.IMatrix2f, org.eclipse.draw3d.geometry.Matrix2f)}.
	 */
	@Test
	public void testMulIMatrix2fIMatrix2fMatrix2f() {
		Matrix2fImpl m0 = new Matrix2fImpl(1,2,3,4, false);
		Matrix2fImpl m1 = new Matrix2fImpl(5,6,7,8, false);
		Matrix2fImpl e1 = new Matrix2fImpl(19,22,43,50, false);
		Matrix2fImpl e2 = new Matrix2fImpl(23,34,31,46, false);
		Matrix2fImpl e3 = new Matrix2fImpl(7,10,15,22, false);
		
		Matrix2f r1 = Math3D.mul(m0, m1, null);
		Matrix2f r2 = Math3D.mul(m1, m0, null);
		Matrix2f r3 = Math3D.mul(m0, m0, null);
		
		if (!Math3D.equals(e1, r1, PREC)) {
			fail("Mul failed, exprected" + e1 + "was" + r1);
		}

		if (!Math3D.equals(e2, r2, PREC)) {
			fail("Mul failed, exprected" + e2 + "was" + r2);
		}
		
		if (!Math3D.equals(e3, r3, PREC)) {
			fail("Mul failed, exprected" + e3 + "was" + r3);
		}
	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometry.Math3DMatrix2f#transpose(org.eclipse.draw3d.geometry.IMatrix2f, org.eclipse.draw3d.geometry.Matrix2f)}.
	 */
	@Test
	public void testTranspose() {
		// TODO implement test testTranspose
	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometry.Math3DMatrix2f#determinant(org.eclipse.draw3d.geometry.IMatrix2f)}.
	 */
	@Test
	public void testDeterminant() {
		Matrix2fImpl m1 = new Matrix2fImpl(1,2,3,4, false);
		float d = Math3D.determinant(m1);
		assertEquals(-2, d, PREC);
		
	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometry.Math3DMatrix2f#det(float, float, float, float)}.
	 */
	@Test
	public void testDet() {
		// TODO implement test testDet
	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometry.Math3DMatrix2f#negdet(float, float, float, float)}.
	 */
	@Test
	public void testNegdet() {
		// TODO implement test testNegdet
	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometry.Math3DMatrix2f#invert(org.eclipse.draw3d.geometry.IMatrix2f, org.eclipse.draw3d.geometry.Matrix2f)}.
	 */
	@Test
	public void testInvert() {
		Matrix2f m = new Matrix2fImpl(1,2,3,4, false);
		Matrix2f inv = Math3D.invert(m, null);
		Matrix2f e = new Matrix2fImpl(-2, 1, 1.5f, -0.5f, false);
		
		if (!Math3D.equals(e, inv, PREC)) {
			fail("Invert failed, expected" + e + "was" + inv);
		}
		
		
		Matrix2f m0 = Math3D.mul(inv, m, null);
		
		if (!Math3D.equals(Matrix2f.IDENTITY, m0, PREC)) {
			fail("Invert failed, expected" + Matrix2f.IDENTITY + "was" + m0);
		}
		
	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometry.Math3DMatrix2f#adjugate(org.eclipse.draw3d.geometry.IMatrix2f, org.eclipse.draw3d.geometry.Matrix2f)}.
	 */
	@Test
	public void testAdjugate() {
		// TODO implement test testAdjugate
	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometry.Math3DMatrix2f#mul(float, org.eclipse.draw3d.geometry.IMatrix2f, org.eclipse.draw3d.geometry.Matrix2f)}.
	 */
	@Test
	public void testMulFloatIMatrix2fMatrix2f() {
		// TODO implement test testMulFloatIMatrix2fMatrix2f
	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometry.Math3DMatrix2f#negate(org.eclipse.draw3d.geometry.IMatrix2f, org.eclipse.draw3d.geometry.Matrix2f)}.
	 */
	@Test
	public void testNegateIMatrix2fMatrix2f() {
		// TODO implement test testNegateIMatrix2fMatrix2f
	}

}
