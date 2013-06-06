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

import java.io.Serializable;
import java.nio.FloatBuffer;

/**
 * Immutable vector with 3 elements, the vector is defined as a tuple here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Dec 16, 2008
 */
public interface IVector3f extends Serializable, Cloneable {

	/**
	 * Number format of a single entry value of vectors or matrices.
	 */
	final static String NF = "%s";

	/**
	 * Constant null vector (0,0,0), all vectors are created with (0,0,0).
	 */
	public final static IVector3f NULLVEC3f = new Vector3fImpl(0, 0, 0);

	/**
	 * Format used in toString() methods
	 */
	public final static String TO_STRING_FORMAT =
		"(" + NF + ", " + NF + ", " + NF + ")";

	/**
	 * A vector (1,1,1).
	 */
	public final static IVector3f UNITVEC3f = new Vector3fImpl(1, 1, 1);

	/**
	 * A vector that points in the direction of the positive X axis.
	 */
	public final static IVector3f X_AXIS = new Vector3fImpl(1, 0, 0);

	/**
	 * A vector that points in the direction of the negative X axis.
	 */
	public final static IVector3f X_AXIS_NEG = new Vector3fImpl(-1, 0, 0);

	/**
	 * A vector that points in the direction of the positive Y axis.
	 */
	public final static IVector3f Y_AXIS = new Vector3fImpl(0, 1, 0);

	/**
	 * A vector that points in the direction of the negative Y axis.
	 */
	public final static IVector3f Y_AXIS_NEG = new Vector3fImpl(0, -1, 0);

	/**
	 * A vector that points in the direction of the positive Z axis.
	 */
	public final static IVector3f Z_AXIS = new Vector3fImpl(0, 0, 1);

	/**
	 * A vector that points in the direction of the negative Z axis.
	 */
	public final static IVector3f Z_AXIS_NEG = new Vector3fImpl(0, 0, -1);

	/**
	 * Compares two vectors. A vector v0 equals a vector v1 iff v0==v1
	 * (identical instance) or (v0!=null && v1!=null && v0.x=v1.x && v0.y=v1.y
	 * && v0.z=v1.z)
	 * 
	 * @param v The vector3f to compare with, may be null
	 * @return True on equality, false otherwise
	 */
	public boolean equals(IVector3f v);

	/**
	 * Compares two vectors using a delta value. A vector v0 equals a vector v1
	 * iff v0==v1 (identical instance) or (v0!=null && v1!=null &&
	 * Math.abs(v0.x-v1.x)<=epsilon && Math.abs(v0.y-v1.y)<=epsilon &&
	 * Math.abs(v0.z-v1.z)<=epsilon Note that there are other possible
	 * strategies for comparing two vectors using a delta value, such as
	 * <code>Vector3fImpl.sub(v0,v1,null).length()<=epsilon</code>. The solution
	 * used here is primarly used for test cases.
	 * 
	 * @param v The vector3f to compare with, may be null
	 * @param epsilon the maximum difference between each component of the given
	 *            vectors
	 * @return True on equality, false otherwise
	 */
	public boolean equals(IVector3f v, float epsilon);

	/**
	 * Returns the value of attribute x.
	 * 
	 * @return
	 */
	public float getX();

	/**
	 * Returns the value of attribute y.
	 * 
	 * @return
	 */
	public float getY();

	/**
	 * Returns the value of attribute z.
	 * 
	 * @return
	 */
	public float getZ();

	/**
	 * Returns a hash code. Two instances a0 and a1 will return the same hash
	 * code, if a0.equals(a1)==true.
	 * <p>
	 * <p>
	 * All implementations must use the same strategy for computing the hash
	 * code: The entries of the structure are converted into an array, and then
	 * Arrays#hashCode(float[]) is used for calculating the code.
	 * </p>
	 * 
	 * @return the hash code
	 */
	public int hashCode();

	/**
	 * Returns the length of the vector.
	 * 
	 * @return
	 */
	public float length();

	/**
	 * Returns the squared length of the vector.
	 * 
	 * @return
	 */
	public float lengthSquared();

	/**
	 * Stores this vector in an array of float with x at index 0, y at index 1,
	 * and z at index 2.
	 * 
	 * @param o_arrayOfFloat The array to store in
	 */
	public void toArray(float[] o_arrayOfFloat);

	/**
	 * Stores this vector in an array of float, starting at given offset.
	 * 
	 * @param o_arrayOfFloat The array to store in
	 * @param i_iOffset The offset to start storing at
	 */
	public void toArray(float[] o_arrayOfFloat, int i_iOffset);

	/**
	 * Store this vector in a FloatBuffer. The buffer is <em>not</em> rewinded
	 * (neither before nor after storing the vector). The entries are stored in
	 * the following order: x, y, z.
	 * 
	 * @param buf The buffer to store it in, at the current position
	 */
	public void toBuffer(FloatBuffer o_floatBuffer);

}
