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
 * Math3DMatrix4fTest There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Dec 17, 2008
 */
public class Math3DMatrix4fTest {

	public final static float PREC = 0.00001f;

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometry.Math3DMatrix4f#add(org.eclipse.draw3d.geometry.IMatrix4f, org.eclipse.draw3d.geometry.IMatrix4f, org.eclipse.draw3d.geometry.Matrix4f)}
	 * .
	 */
	@Test
	public void testAddIMatrix4fIMatrix4fMatrix4f() {
		// TODO implement test testAddIMatrix4fIMatrix4fMatrix4f
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometry.Math3DMatrix4f#sub(org.eclipse.draw3d.geometry.IMatrix4f, org.eclipse.draw3d.geometry.IMatrix4f, org.eclipse.draw3d.geometry.Matrix4f)}
	 * .
	 */
	@Test
	public void testSubIMatrix4fIMatrix4fMatrix4f() {
		// TODO implement test testSubIMatrix4fIMatrix4fMatrix4f
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometry.Math3DMatrix4f#mul(org.eclipse.draw3d.geometry.IMatrix4f, org.eclipse.draw3d.geometry.IMatrix4f, org.eclipse.draw3d.geometry.Matrix4f)}
	 * .
	 */
	@Test
	public void testMulIMatrix4fIMatrix4fMatrix4f() {
		// TODO implement test testMulIMatrix4fIMatrix4fMatrix4f
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometry.Math3DMatrix4f#mul(float, org.eclipse.draw3d.geometry.IMatrix4f, org.eclipse.draw3d.geometry.Matrix4f)}
	 * .
	 */
	@Test
	public void testMulFloatIMatrix4fMatrix4f() {
		// TODO implement test testMulFloatIMatrix4fMatrix4f

	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometry.Math3DMatrix4f#determinant(org.eclipse.draw3d.geometry.IMatrix4f)}
	 * .
	 */
	@Test
	public void testDeterminantIMatrix4f() {
		assertEquals(1, Math3DMatrix4f.determinant(Matrix4f.IDENTITY), PREC);
		assertEquals(0, Math3DMatrix4f.determinant(Matrix4f.ZERO), PREC);

		Matrix4f m = new Matrix4fImpl();
		IMatrix4f i; // inverted
		IMatrix4f t; // transposed

		// IDENTITY matrix is default
		assertEquals(1f, Math3DMatrix4f.determinant(m), PREC);
		i = Math3DMatrix4f.invert(m, null);
		assertEquals(1f / 1f, Math3DMatrix4f.determinant(i), PREC);
		t = Math3DMatrix4f.transpose(m, null);
		assertEquals(1f, Math3DMatrix4f.determinant(t), PREC);

		// Example created with
		// http://people.revoledu.com/kardi/tutorial/LinearAlgebra/MatrixDeterminant.html
		m = new Matrix4fImpl(2, 2, 0, 2,//
			0, 2, 0, 2,//
			0, 1, 1, 0,//
			1, 1, 2, 0);
		assertEquals(4f, Math3DMatrix4f.determinant(m), PREC);

		i = Math3DMatrix4f.invert(m, null);
		assertEquals(1f / 4f, Math3DMatrix4f.determinant(i), PREC);
		t = Math3DMatrix4f.transpose(m, null);
		assertEquals(4f, Math3DMatrix4f.determinant(t), PREC);

		Matrix4f m2 = new Matrix4fImpl( 0,1,2,1, //
		3,1,1,1, //
		5,4,5,1, //
		1,4,4,1);
		assertEquals(21f, Math3DMatrix4f.determinant(m2), PREC);

		i = Math3DMatrix4f.invert(m2, null);
		assertEquals(1f / 21f, Math3DMatrix4f.determinant(i), PREC);
		t = Math3DMatrix4f.transpose(m2, null);
		assertEquals(21f, Math3DMatrix4f.determinant(t), PREC);

		Matrix4f p = Math3DMatrix4f.mul(m, m2, null);
		assertEquals(4f * 21f, Math3DMatrix4f.determinant(p), PREC);

		
		float[] mf = { 1, 3, 9, 1, 5, 7, 9, 2, 1, 2, 3, 4, 1, 2, 8, 1 };
		m = new Matrix4fImpl(mf, false);
		assertEquals(99, Math3D.determinant(m), PREC);
		i = Math3DMatrix4f.invert(m, null);
		assertEquals(1f / 99f, Math3DMatrix4f.determinant(i), PREC);
		t = Math3DMatrix4f.transpose(m, null);
		assertEquals(99f, Math3DMatrix4f.determinant(t), PREC);
		
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometry.Math3DMatrix4f#invert(org.eclipse.draw3d.geometry.IMatrix4f, org.eclipse.draw3d.geometry.Matrix4f)}
	 * .
	 */
	@Test
	public void testInvertIMatrix4fMatrix4f() {
		float[] mf = { 1, 3, 9, 1, 5, 7, 9, 2, 1, 2, 3, 4, 1, 2, 8, 1 };
		Matrix4f m = new Matrix4fImpl(mf, false);
		mf =
			new float[] { -1.303030303f, 0.232323232f, -0.101010101f,
				1.242424242f, 1.090909091f, 0.030303030f, 0.030303030f,
				-1.272727273f, -0.090909091f, -0.030303030f, -0.030303030f,
				0.272727273f, -0.151515152f, -0.050505051f, 0.282828283f,
				0.121212121f };
		Matrix4f e = new Matrix4fImpl(mf, false);
		Matrix4f inv = Math3D.invert(m, null);

		if (!Math3D.equals(e, inv, PREC)) {
			fail("Invert failed, expected" + e + "was" + inv);
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometry.Math3DMatrix4f#negate(org.eclipse.draw3d.geometry.IMatrix4f, org.eclipse.draw3d.geometry.Matrix4f)}
	 * .
	 */
	@Test
	public void testNegateIMatrix4fMatrix4f() {
		// TODO implement test testNegateIMatrix4fMatrix4f
	}

	/**
	 * Test method for
	 * {@link org.eclipse.draw3d.geometry.Math3DMatrix4f#transpose(org.eclipse.draw3d.geometry.IMatrix4f, org.eclipse.draw3d.geometry.Matrix4f)}
	 * .
	 */
	@Test
	public void testTransposeIMatrix4fMatrix4f() {
		// TODO implement test testTransposeIMatrix4fMatrix4f
	}

}
