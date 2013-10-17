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

import static org.eclipse.draw3d.geometry.IVector3f.NF;

import java.nio.FloatBuffer;

/**
 * Immutable vector with 4 elements, the vector is defined as a tuple here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Dec 16, 2008
 */
public interface IVector4f {

	/**
	 * Constant null vector (0,0,0,0), all created vectors (with empty
	 * constructor) equal this one.
	 */
	public final static IVector4f NULLVEC4f = new Vector4fImpl(0, 0, 0, 0);

	/**
	 * Format used in toString() methods
	 */
	public final static String TO_STRING_FORMAT = "(" + NF + ", " + NF + ", "
			+ NF + ", " + NF + ")";

	/**
	 * Compares two vectors. A vector v0 equals a vector v1 iff v0==v1
	 * (identical instance) or (v0!=null && v1!=null && v0.x=v1.x && v0.y=v1.y
	 * && v0.z=v1.z && v0.w=v1.w)
	 * 
	 * @param i_AnotherVector4f
	 *            The vector4f to compare with, may be null
	 * @return True on equality, false otherwise
	 */
	public boolean equals(IVector4f i_anotherVector4f);

	/**
	 * Compares two vectors using a delta value. A vector v0 equals a vector v1
	 * iff v0==v1 (identical instance) or (v0!=null && v1!=null &&
	 * Math.abs(v0.x-v1.x)<=epsilon && Math.abs(v0.y-v1.y)<=epsilon &&
	 * Math.abs(v0.z-v1.z)<=epsilon && Math.abs(v0.w-v1.w)<=epsilon Note that
	 * there are other possible strategies for comparing two vectors using a
	 * delta value, such as
	 * <code>Vector4fImpl.sub(v0,v1,null).length()<=epsilon</code>. The solution
	 * used here is primarly used for test cases.
	 * 
	 * @param i_AnotherVector4f
	 *            The vector4f to compare with, may be null
	 * @param epsilon
	 *            the maximum difference between each component of the given
	 *            vectors
	 * @return True on equality, false otherwise
	 */
	public boolean equals(IVector4f i_anotherVector4f, float epsilon);

	/**
	 * Returns the value of attribute w.
	 * 
	 * @return
	 */
	public float getW();

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
	 * @return The vector4f's length.
	 */
	public float length();

	/**
	 * Returns the squared length of the vector.
	 * 
	 * @return The vector4f's squared length
	 */
	public float lengthSquared();

	/**
	 * Stores this vector in an array of float with x at index 0, y at index 1,
	 * and z at index 2, and w at index 3.
	 * 
	 * @param o_arrayOfFloat
	 *            The array to store in.
	 */
	public void toArray(float[] o_arrayOfFloat);

	/**
	 * Stores this vector in an array of float, starting at given offset.
	 * 
	 * @param o_arrayOfFloat
	 *            The array to store in.
	 * @param i_iOffset
	 *            The offset to start storing at.
	 */
	public void toArray(float[] o_arrayOfFloat, int i_iOffset);

	/**
	 * Store this vector in a FloatBuffer. The buffer is <em>not</em> rewinded
	 * (neither before nor after storing the vector). The entries are stored in
	 * the following order: x, y, z, w.
	 * 
	 * @param buf
	 *            The buffer to store it in, at the current position
	 */
	public void toBuffer(FloatBuffer o_floatBuffer);

	/**
	 * Converts this fourdimensional vector to a three dimensional vector by
	 * dividing X, Y and Z by W.
	 * 
	 * @param io_vector
	 *            the result vector, if <code>null</code>, a new one will be
	 *            created
	 * @return the result vector
	 */
	public Vector3f toVector3f(Vector3f io_result);

}
