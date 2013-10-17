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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Math3DMatrix3fTest There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Dec 17, 2008
 */
public class Math3DMatrix3fTest {

	public static float PREC = 0.00001f;

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometry.Math3DMatrix3f#add(org.eclipse.draw3d.geometry.IMatrix3f, org.eclipse.draw3d.geometry.IMatrix3f, org.eclipse.draw3d.geometry.Matrix3f)}
	 * .
	 */
	@Test
	public void testAddIMatrix3fIMatrix3fMatrix3f() {
		// TODO implement test testAddIMatrix3fIMatrix3fMatrix3f
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometry.Math3DMatrix3f#sub(org.eclipse.draw3d.geometry.IMatrix3f, org.eclipse.draw3d.geometry.IMatrix3f, org.eclipse.draw3d.geometry.Matrix3f)}
	 * .
	 */
	@Test
	public void testSubIMatrix3fIMatrix3fMatrix3f() {
		// TODO implement test testSubIMatrix3fIMatrix3fMatrix3f
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometry.Math3DMatrix3f#mul(org.eclipse.draw3d.geometry.IMatrix3f, org.eclipse.draw3d.geometry.IMatrix3f, org.eclipse.draw3d.geometry.Matrix3f)}
	 * .
	 */
	@Test
	public void testMulIMatrix3fIMatrix3fMatrix3f() {
		// TODO implement test testMulIMatrix3fIMatrix3fMatrix3f
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometry.Math3DMatrix3f#transpose(org.eclipse.draw3d.geometry.IMatrix3f, org.eclipse.draw3d.geometry.Matrix3f)}
	 * .
	 */
	@Test
	public void testTransposeIMatrix3fMatrix3f() {
		// TODO implement test testTransposeIMatrix3fMatrix3f
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometry.Math3DMatrix3f#determinant(org.eclipse.draw3d.geometry.IMatrix3f)}
	 * .
	 */
	@Test
	public void testDeterminantIMatrix3f() {
		float[] mf = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Matrix3f m = new Matrix3fImpl(mf, false);
		assertEquals(0, Math3D.determinant(m), PREC);
		mf = new float[] { 1, 3, 9, 5, 7, 9, 1, 2, 3 };
		m = new Matrix3fImpl(mf, false);
		assertEquals(12, Math3D.determinant(m), PREC);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometry.Math3DMatrix3f#invert(org.eclipse.draw3d.geometry.IMatrix3f, org.eclipse.draw3d.geometry.Matrix3f)}
	 * .
	 */
	@Test
	public void testInvertIMatrix3fMatrix3f() {
		float[] mf = { 1, 3, 9, 5, 7, 9, 1, 2, 3 };
		Matrix3f m = new Matrix3fImpl(mf, false);
		mf = new float[] { 0.25f, 0.75f, -3, -0.5f, -0.5f, 3, 0.25f,
				0.0833333f, -0.666667f };
		Matrix3f e = new Matrix3fImpl(mf, false);
		Matrix3f inv = Math3D.invert(m, null);

		if (!Math3D.equals(e, inv, PREC)) {
			fail("Invert failed, expected" + e + "was" + inv);
		}

	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometry.Math3DMatrix3f#adjugate(org.eclipse.draw3d.geometry.IMatrix3f, org.eclipse.draw3d.geometry.Matrix3f)}
	 * .
	 */
	@Test
	public void testAdjugateIMatrix3fMatrix3f() {
		// TODO implement test testAdjugateIMatrix3fMatrix3f
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometry.Math3DMatrix3f#mul(float, org.eclipse.draw3d.geometry.IMatrix3f, org.eclipse.draw3d.geometry.Matrix3f)}
	 * .
	 */
	@Test
	public void testMulFloatIMatrix3fMatrix3f() {
		// TODO implement test testMulFloatIMatrix3fMatrix3f
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometry.Math3DMatrix3f#negate(org.eclipse.draw3d.geometry.IMatrix3f, org.eclipse.draw3d.geometry.Matrix3f)}
	 * .
	 */
	@Test
	public void testNegateIMatrix3fMatrix3f() {
		// TODO implement test testNegateIMatrix3fMatrix3f
	}

	/**
	 * Tests calculations of 3x3 matrices.
	 * Also uses some formulas:
	 * <ul>
	 * <li>det(A<sup>-1</sup>) = det(A)<sup>-1</sup></li>
	 * <li>det A = det A<sup>T</sup></li>
	 * <li>det A * det B = det (A*B)</li>
	 * </ul>
	 */
	@Test
	public void testDeterminant() {
		assertEquals(1, Math3DMatrix3f.determinant(Matrix3f.IDENTITY), PREC);
		assertEquals(0, Math3DMatrix3f.determinant(Matrix3f.ZERO), PREC);
		
		Matrix3f m = new Matrix3fImpl();
		IMatrix3f i; // inverted
		IMatrix3f t; // transposed
		
		// IDENTITY matrix is default
		assertEquals(1f, Math3DMatrix3f.determinant(m), PREC);
		i = Math3DMatrix3f.invert(m, null);
		assertEquals(1f/1f, Math3DMatrix3f.determinant(i), PREC);
		t = Math3DMatrix3f.transpose(m, null);
		assertEquals(1f, Math3DMatrix3f.determinant(t), PREC);
		
		// Wikipedia example:
		// http://en.wikipedia.org/wiki/Determinant
		m = new Matrix3fImpl( //
			-2, 2, -3, //
			-1, 1, 3, //
			2, 0, -1);
		assertEquals(18f, Math3DMatrix3f.determinant(m), PREC);
		
		i = Math3DMatrix3f.invert(m, null);
		assertEquals(1f/18f, Math3DMatrix3f.determinant(i), PREC);
		t = Math3DMatrix3f.transpose(m, null);
		assertEquals(18f, Math3DMatrix3f.determinant(t), PREC);
		
		// Wikipedia example:
		// http://de.wikipedia.org/wiki/Determinante_(Mathematik)
		Matrix3f m2 = new Matrix3fImpl( //
			0,1,2, //
			3,2,1, //
			1,1,0);
		assertEquals(3f, Math3DMatrix3f.determinant(m2), PREC);
		
		i = Math3DMatrix3f.invert(m2, null);
		assertEquals(1f/3f, Math3DMatrix3f.determinant(i), PREC);
		t = Math3DMatrix3f.transpose(m2, null);
		assertEquals(3f, Math3DMatrix3f.determinant(t), PREC);
		
		Matrix3f p = Math3DMatrix3f.mul(m, m2, null);
		assertEquals(3f*18f, Math3DMatrix3f.determinant(p), PREC);
		
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometry.Math3DMatrix3f#negdet(float, float, float, float, float, float, float, float, float)}
	 * .
	 */
	@Test
	public void testNegdetFloatFloatFloatFloatFloatFloatFloatFloatFloat() {
		// TODO implement test testNegdetFloatFloatFloatFloatFloatFloatFloatFloatFloat
	}

}
