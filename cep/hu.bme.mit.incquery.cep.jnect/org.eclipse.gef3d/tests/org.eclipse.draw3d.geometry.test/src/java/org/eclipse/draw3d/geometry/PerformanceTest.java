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

import org.junit.Test;

import junit.framework.TestCase;

/**
 * PerformanceTest There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Dec 15, 2008
 */
public class PerformanceTest extends TestCase {

	long start;

	void start() {
		start = System.currentTimeMillis();
	}

	long stop() {
		return System.currentTimeMillis() - start;
	}

	static final int LOOPCOUNT = 1000000;

	static String message = "%20s, Field: %8d, Array: %8d, Buffer: %8d";

	/**
	 * No real test, only a console output test for manual evaluation.
	 */
	@Test
	public void testFieldsVsArrayMatrix() {

		Matrix3fImpl fieldMatrix;
		Matrix3fAsArray arrayMatrix;
		Matrix3fAsBuffer bufferMatrix;

		Matrix3fImpl fieldMatrixSrc = new Matrix3fImpl();
		Matrix3fAsArray arrayMatrixSrc = new Matrix3fAsArray();
		Matrix3fAsBuffer bufferMatrixSrc = new Matrix3fAsBuffer();

		long timeField;
		long timeArray;
		long timeBuffer;

		// //////////////////////////////////////////////////////////////////////
		// Empty Constructor
		start();
		for (int i = 0; i < LOOPCOUNT; i++) {
			fieldMatrix = new Matrix3fImpl();
		}
		timeField = stop();

		start();
		for (int i = 0; i < LOOPCOUNT; i++) {
			arrayMatrix = new Matrix3fAsArray();
		}
		timeArray = stop();

		start();
		for (int i = 0; i < LOOPCOUNT; i++) {
			bufferMatrix = new Matrix3fAsBuffer();
		}
		timeBuffer = stop();

		out(String.format(message, "Constructor", timeField, timeArray,
			timeBuffer));

		// //////////////////////////////////////////////////////////////////////
		// Copy Constructor
		start();
		for (int i = 0; i < LOOPCOUNT; i++) {
			fieldMatrix = new Matrix3fImpl(fieldMatrixSrc);
		}
		timeField = stop();

		start();
		for (int i = 0; i < LOOPCOUNT; i++) {
			arrayMatrix = new Matrix3fAsArray(arrayMatrixSrc);
		}
		timeArray = stop();

		start();
		for (int i = 0; i < LOOPCOUNT; i++) {
			bufferMatrix = new Matrix3fAsBuffer(bufferMatrixSrc);
		}
		timeBuffer = stop();

		out(String.format(message, "Copy-Constructor", timeField, timeArray,
			timeBuffer));

		// //////////////////////////////////////////////////////////////////////
		// Set
		fieldMatrix = new Matrix3fImpl();
		arrayMatrix = new Matrix3fAsArray();
		bufferMatrix = new Matrix3fAsBuffer();

		timeField = doTestSet(fieldMatrix, fieldMatrixSrc);
		timeArray = doTestSet(arrayMatrix, arrayMatrixSrc);
		timeBuffer = doTestSet(bufferMatrix, bufferMatrixSrc);

		out(String.format(message, "set", timeField, timeArray, timeBuffer));

		// //////////////////////////////////////////////////////////////////////
		// Set with different type
		fieldMatrix = new Matrix3fImpl();
		arrayMatrix = new Matrix3fAsArray();
		fieldMatrix = new Matrix3fImpl();
		arrayMatrix = new Matrix3fAsArray();
		bufferMatrix = new Matrix3fAsBuffer();

		timeField = doTestSet(fieldMatrix, arrayMatrixSrc);
		timeArray = doTestSet(arrayMatrix, fieldMatrixSrc);
		timeBuffer = doTestSet(bufferMatrix, fieldMatrixSrc);

		out(String.format(message, "set(different type)", timeField, timeArray,
			timeBuffer));

		// //////////////////////////////////////////////////////////////////////
		// setIdentity
		timeField = doTestSetIdentity(fieldMatrix);
		timeArray = doTestSetIdentity(arrayMatrix);
		timeBuffer = doTestSetIdentity(bufferMatrix);

		out(String.format(message, "setIdentity", timeField, timeArray,
			timeBuffer));

		// //////////////////////////////////////////////////////////////////////
		// setZero
		timeField = doTestSetZero(fieldMatrix);
		timeArray = doTestSetZero(arrayMatrix);
		timeBuffer = doTestSetZero(bufferMatrix);

		out(String.format(message, "setZero", timeField, timeArray, timeBuffer));

		// //////////////////////////////////////////////////////////////////////
		// setEquals (same type)

		arrayMatrixSrc.set(fieldMatrixSrc);
		fieldMatrix.set(fieldMatrixSrc);
		arrayMatrix.set(fieldMatrixSrc);
		bufferMatrix.set(fieldMatrixSrc);

		timeField = doTestEquals(fieldMatrix, fieldMatrixSrc);
		timeArray = doTestEquals(arrayMatrix, arrayMatrixSrc);
		timeBuffer = doTestEquals(bufferMatrix, bufferMatrixSrc);

		out(String.format(message, "equals (same type)", timeField, timeArray,
			timeBuffer));

		// //////////////////////////////////////////////////////////////////////
		// Math3D.determinant

		timeField = doTestDeterminant(fieldMatrix);
		timeArray = doTestDeterminant(arrayMatrix);
		timeBuffer = doTestDeterminant(bufferMatrix);

		out(String.format(message, "determinante", timeField, timeArray,
			timeBuffer));

	}

	/**
	 * @param i_format
	 */
	private void out(String msg) {
		// System.out.println(msg);
	}

	long doTestDeterminant(IMatrix3f matrix) {
		start();

		for (int i = 0; i < LOOPCOUNT; i++) {
			Math3D.determinant(matrix);
		}
		return stop();
	}

	long doTestSetIdentity(Matrix3f matrix) {
		start();
		for (int i = 0; i < LOOPCOUNT; i++) {
			matrix.setIdentity();
		}
		return stop();
	}

	long doTestSetZero(Matrix3f matrix) {
		start();
		for (int i = 0; i < LOOPCOUNT; i++) {
			matrix.setZero();
		}
		return stop();
	}

	long doTestSet(Matrix3f matrix, IMatrix3f source) {
		start();
		for (int i = 0; i < LOOPCOUNT; i++) {
			matrix.set(source);
		}
		return stop();
	}

	long doTestEquals(Matrix3f matrix, IMatrix3f source) {
		start();
		for (int i = 0; i < LOOPCOUNT; i++) {
			matrix.equals(source);
		}
		return stop();
	}

}
