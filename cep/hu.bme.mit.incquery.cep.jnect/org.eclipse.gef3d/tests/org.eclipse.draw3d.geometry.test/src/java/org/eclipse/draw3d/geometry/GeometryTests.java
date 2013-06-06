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

import java.nio.FloatBuffer;
import java.util.Random;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.draw3d.geometryext.SyncedBoundsTest;
import org.eclipse.draw3d.geometryext.SyncedVector3fTest;

/**
 * GeometryTests Test suite for package org.eclipse.daw3d.geometry
 * 
 * @author Matthias Thiele
 * @version $Revision$
 * @since 12.10.2008
 */
public class GeometryTests {
	/**
	 * @see junit.framework.Test
	 */
	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for org.eclipse.draw3d.geometryext");
		// $JUnit-BEGIN$
		suite.addTestSuite(Vector3fTest.class);
		suite.addTestSuite(Vector4fTest.class);
		suite.addTestSuite(Matrix3fTest.class);
		suite.addTestSuite(Matrix4fTest.class);
		suite.addTestSuite(Math3DTest.class);
		suite.addTestSuite(BoundingBox3fTest.class);
		suite.addTestSuite(SyncedBoundsTest.class);
		suite.addTestSuite(SyncedVector3fTest.class);
		// $JUnit-END$
		return suite;
	}

	// Helper methods, useful for testcases of this suite **********************

	/**
	 * Random object to generate some numbers.
	 */
	public static final Random random = new Random();

	/**
	 * Gets a float buffer from a float array. The float buffer will be rewinded
	 * after its creation.
	 * 
	 * @param i_sourceFloatArray Array to create the float buffer from.
	 * @return A float buffer with the same elements as the source array.
	 */
	public static FloatBuffer buffer2Array(float[] i_sourceFloatArray) {
		FloatBuffer buf = FloatBuffer.allocate(i_sourceFloatArray.length);

		for (float f : i_sourceFloatArray) {
			buf.put(f);
		}

		buf.rewind();
		return buf;
	}

	/**
	 * Gets a BoundingBox whose components have random float values.
	 * 
	 * @return The randomly filled BoundingBox.
	 */
	public static BoundingBoxImpl getRandomBoundingBox3f() {
		IVector3f v0 = getRandomVector3f();
		IVector3f v1 = getRandomVector3f();

		BoundingBoxImpl b0 = new BoundingBoxImpl(v0, v1);

		return b0;
	}

	/**
	 * Gets a vector4f with random component values.
	 * 
	 * @return The generated vector4f
	 */
	public static Vector4fImpl getRandomVector4f() {
		float x = getRandomFloat();
		float y = getRandomFloat();
		float z = getRandomFloat();
		float w = getRandomFloat();

		Vector4fImpl v0 = new Vector4fImpl(x, y, z, w);

		return v0;
	}

	/**
	 * Gets a vector3f with random component values.
	 * 
	 * @return The generated vector4f
	 */
	public static Vector3fImpl getRandomVector3f() {
		return getRandomVector3f(false, 0);
	}

	/**
	 * Gets a vector3f whose components have random float values.
	 * 
	 * @param noFloats True: Use only int values, False: Use float values
	 * @param limit <code>If noFloats</code> int values up to this limits are
	 *            generated
	 * @return The generated vector3f
	 */
	public static Vector3fImpl getRandomVector3f(boolean noFloats, int limit) {
		float x = noFloats ? getRandomInt(limit) : getRandomFloat();
		float y = noFloats ? getRandomInt(limit) : getRandomFloat();
		float z = noFloats ? getRandomInt(limit) : getRandomFloat();

		Vector3fImpl v0 = new Vector3fImpl(x, y, z);

		return v0;
	}
	
	public static Matrix2fImpl getRandomMatrix2f() {
		return new Matrix2fImpl(getRandomFloatBuffer(4), false);
	}

	/**
	 * Gets a matrix3f whose components have random float values.
	 * 
	 * @return The generated matrix3f.
	 */
	public static Matrix3fImpl getRandomMatrix3f() {
		return new Matrix3fImpl(getRandomFloatBuffer(9), false);
	}

	/**
	 * Gets a matrix3f whose components have random float values.
	 * 
	 * @return The generated matrix3f.
	 */
	public static Matrix3fAsArray getRandomMatrix3fAsArray() {
		return new Matrix3fAsArray(getRandomFloatBuffer(9), false);
	}

	/**
	 * @return
	 */
	public static Matrix3fAsBuffer getRandomMatrix3fAsBuffer() {
		return new Matrix3fAsBuffer(getRandomFloatBuffer(9), false);
	}

	/**
	 * Generates a random int value up to the given limit.
	 * 
	 * @param limit Max generated value
	 * @return The random int value
	 */
	public static int getRandomInt(int limit) {
		return random.nextInt(limit);
	}

	/**
	 * Generates a random float value.
	 * 
	 * @return The random float value
	 */
	public static float getRandomFloat() {
		return random.nextFloat();
	}

	/**
	 * Gets a float buffer with given number of elements and random content. The
	 * buffer is rewinded after creation.
	 * 
	 * @param i_iNumberOfElements Number of elements to generate for the random
	 *            buffer
	 * @return The randomly filled float buffer.
	 */
	public static FloatBuffer getRandomFloatBuffer(int i_iNumberOfElements) {
		FloatBuffer buf = FloatBuffer.allocate(i_iNumberOfElements);
		for (int i = 0; i < i_iNumberOfElements - 1; i++)
			buf.put(getRandomFloat());
		buf.rewind();

		return buf;
	}

	/**
	 * Gets a matrix4f whose components have random float values.
	 * 
	 * @return The generated matrix4f.
	 */
	public static Matrix4fImpl getRandomMatrix4f() {
		FloatBuffer buf = getRandomFloatBuffer(16);

		Matrix4fImpl m0 = new Matrix4fImpl(buf, false);

		return m0;
	}

	/**
	 * Gets a float array with given number of elements and random content.
	 * 
	 * @param i_iOffset The array content starts with this offset.
	 * @param i_iNumerOfElements This number of elements is generated and
	 *            therewith also specifies the array's length
	 * @return The generated float array.
	 */
	public static float[] getRandomFloatArray(int i_iOffset,
			int i_iNumberOfElements) {
		float[] arr = new float[i_iNumberOfElements + i_iOffset];
		for (int i = 0; i < i_iNumberOfElements - 1; i++)
			arr[i + i_iOffset] = random.nextFloat();

		return arr;
	}

	/**
	 * Emulation of JDK 1.6 <code>Arrays</code> method (for use with JDK 1.5),
	 * quick and dirty with
	 * {@link System#arraycopy(Object, int, Object, int, int)}.
	 * 
	 * @param i_iSrcArray Copy the range from this array.
	 * @param i_iIndexFrom Start copy at element with this index.
	 * @param i_iIndexTo Copy until the element with this index.
	 * @return Array containing the element in the range to copy.
	 */
	public static float[] copyOfRange(float[] i_iSrcArray, int i_iIndexFrom,
			int i_iIndexTo) {
		float[] dest = new float[i_iIndexTo - i_iIndexFrom];
		System.arraycopy(i_iSrcArray, i_iIndexFrom, dest, 0, i_iIndexTo
				- i_iIndexFrom);
		return dest;
	}

}
