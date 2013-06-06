/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 *    Kristian Duske - copied from IVector3f
 ******************************************************************************/
package org.eclipse.draw3d.geometry;

import java.io.Serializable;
import java.nio.FloatBuffer;

/**
 * Immutable vector with 2 elements, the vector is defined as a tuple here.
 * 
 * @author Jens von Pilgrim
 * @author Kristian Duske
 * @version $Revision$
 * @since Jun 3, 2009
 */
public interface IVector2f extends Serializable, Cloneable {

	/**
	 * Constant null vector (0,0), all vectors are created with (0,0).
	 */
	public final static IVector2f NULLVEC3f = new Vector2fImpl(0, 0);

	/**
	 * A vector that points in the direction of the positive X axis.
	 */
	public final static IVector2f X_AXIS = new Vector2fImpl(1, 0);

	/**
	 * A vector that points in the direction of the positive Y axis.
	 */
	public final static IVector2f Y_AXIS = new Vector2fImpl(0, 1);

	/**
	 * A vector (1,1).
	 */
	public final static IVector2f UNITVEC3f = new Vector2fImpl(1, 1);

	/**
	 * Number format of a single entry value of vectors or matrices.
	 */
	final static String NF = "%12s";

	/**
	 * Format used in toString() methods
	 */
	public final static String TO_STRING_FORMAT = "(" + NF + ", " + NF + ")";

	/**
	 * Returns the value of attribute x.
	 * 
	 * @return the X coordinate
	 */
	public float getX();

	/**
	 * Returns the value of attribute y.
	 * 
	 * @return the Y coordinate
	 */
	public float getY();

	/**
	 * Returns the length of the vector.
	 * 
	 * @return the length of the vector
	 */
	public float length();

	/**
	 * Returns the squared length of the vector.
	 * 
	 * @return the squared length of the vector
	 */
	public float lengthSquared();

	/**
	 * Store this vector in a FloatBuffer. The buffer is <em>not</em> rewinded
	 * (neither before nor after storing the vector). The entries are stored in
	 * the following order: x, y.
	 * 
	 * @param o_floatBuffer
	 *            The buffer to store it in, at the current position
	 */
	public void toBuffer(FloatBuffer o_floatBuffer);

	/**
	 * Stores this vector in an array of float with x at index 0 and y at index
	 * 1.
	 * 
	 * @param o_arrayOfFloat
	 *            The array to store in
	 */
	public void toArray(float[] o_arrayOfFloat);

	/**
	 * Stores this vector in an array of float, starting at given offset.
	 * 
	 * @param o_arrayOfFloat
	 *            The array to store in
	 * @param i_iOffset
	 *            The offset to start storing at
	 */
	public void toArray(float[] o_arrayOfFloat, int i_iOffset);

	/**
	 * Compares two vectors. A vector v0 equals a vector v1 iff v0==v1
	 * (identical instance) or (v0!=null && v1!=null && v0.x=v1.x && v0.y=v1.y)
	 * 
	 * @param v
	 *            The vector2f to compare with, may be null
	 * @return True on equality, false otherwise
	 */
	public boolean equals(IVector2f v);

	/**
	 * Compares two vectors using a delta value. A vector v0 equals a vector v1
	 * iff v0==v1 (identical instance) or (v0!=null && v1!=null &&
	 * Math.abs(v0.x-v1.x)<=epsilon && Math.abs(v0.y-v1.y)<=epsilon. Note that
	 * there are other possible strategies for comparing two vectors using a
	 * delta value, such as
	 * <code>Vector2fImpl.sub(v0,v1,null).length()<=epsilon</code>. The solution
	 * used here is primarly used for test cases.
	 * 
	 * @param v
	 *            The vector3f to compare with, may be null
	 * @param epsilon
	 *            the maximum difference between each component of the given
	 *            vectors
	 * @return True on equality, false otherwise
	 */
	public boolean equals(IVector2f v, float epsilon);

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

}
