/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.geometry;


/**
 * Bais vector operations.
 * 
 * @author Jens von Pilgrim, Kristian Duske
 * @version $Revision$
 * @since 19.10.2008
 */
public class Math3DVector4f extends Math3DVector3f {

	/**
	 * Adds two vectors.
	 * 
	 * @param i_leftVector3f
	 * @param i_rightVector3f
	 * @param o_resultVector3f
	 * @return
	 */
	public static Vector4f add(IVector4f i_left, IVector4f i_right,
			Vector4f o_result) {
		if (o_result == null) {
			return new Vector4fImpl(i_left.getX() + i_right.getX(), i_left
					.getY()
					+ i_right.getY(), i_left.getZ() + i_right.getZ(), i_left
					.getW()
					+ i_right.getW());
		} else {
			o_result.set(i_left.getX() + i_right.getX(), i_left.getY()
					+ i_right.getY(), i_left.getZ() + i_right.getZ(), i_left
					.getW()
					+ i_right.getW());
			return o_result;
		}
	}

	/**
	 * Subtracts vector right from left, i.e. returns left-right.
	 * 
	 * @param i_left
	 * @param i_right
	 * @param o_result
	 * @return
	 */
	public static Vector4f sub(IVector4f i_left, IVector4f i_right,
			Vector4f o_result) {
		if (o_result == null) {
			return new Vector4fImpl(i_left.getX() - i_right.getX(), i_left
					.getY()
					- i_right.getY(), i_left.getZ() - i_right.getZ(), i_left.getW() - i_right.getW());
		} else {
			o_result.set(i_left.getX() - i_right.getX(), i_left.getY()
					- i_right.getY(), i_left.getZ() - i_right.getZ(), i_left.getW() - i_right.getW());
			return o_result;
		}
	}

	/**
	 * Calculates the negative value for each component of the given vector. The
	 * source and result vector may be the same object.
	 * 
	 * @param i_source the source vector
	 * @param o_result the result vector, if <code>null</code>, a new vector
	 *            will be created and returned
	 * @return the result vector
	 */
	public static Vector4f negate(IVector4f i_source, Vector4f o_result) {
		if (o_result == null) {
			return new Vector4fImpl(-i_source.getX(), -i_source.getY(),
					-i_source.getZ(), -i_source.getW());
		} else {
			o_result.set(-i_source.getX(), -i_source.getY(), -i_source.getZ(),
					-i_source.getW());
			return o_result;
		}
	}

	/**
	 * Returns the normalized vector, that is the vector divided by its length.
	 * 
	 * @param i_vec
	 * @param o_result
	 * @return
	 * @see http://en.wikipedia.org/wiki/Unit_vector
	 */
	public static Vector4f normalise(IVector4f i_source, Vector4f o_result) {
		float lengthInv = 1 / i_source.length();
		return scale(lengthInv, i_source, o_result);
	}

	/**
	 * Calculates the dot product (scalar product) of the two vectors.
	 * 
	 * @param i_left
	 * @param i_right
	 * @return
	 */
	public static float dot(IVector4f i_left, IVector4f i_right) {
		return i_left.getX() * i_right.getX() + i_left.getY() * i_right.getY()
				+ i_left.getZ() * i_right.getZ() + i_left.getW()
				* i_right.getW();
	}
	
	/**
	 * Returns the angle of the two vectors in the range of 0.0 through
     * <i>pi</i>.
	 * @param i_left
	 * @param i_right
	 * @return alpha [0..pi]
	 */
	public static float angle(IVector4f i_left, IVector4f i_right) {
		float cosAlpha = dot(i_left,i_right) / (i_left.length()*i_right.length());
		if (cosAlpha<=-1)
			return (float) Math.PI;
		else if (cosAlpha>=1) {
			return 0;
		}
		return (float) Math.acos(cosAlpha);
	}

	/**
	 * Multiplies all elements of the vector with the given scale value.
	 * 
	 * @param scale
	 * @param i_sourceVector4f
	 * @param o_resultVector4f
	 * @return
	 */
	public static Vector4f scale(float scale, IVector4f i_source,
			Vector4f o_result) {
		if (o_result == null) {
			return new Vector4fImpl(scale * i_source.getX(), scale
					* i_source.getY(), scale * i_source.getZ(), scale
					* i_source.getW());
		} else {
			o_result.set(scale * i_source.getX(), scale * i_source.getY(),
					scale * i_source.getZ(), scale * i_source.getW());
			return o_result;
		}
	}

	/**
	 * Translates a vector by given x, y, z, and w value. Basically it's the same
	 * as adding a vector (x,y,z,w) to the vector.
	 * 
	 * @param i_source
	 * @param x
	 * @param y
	 * @param z
	 * @param o_result
	 * @return
	 */
	public static Vector4f translate(IVector4f i_source, float x, float y,
			float z, float w, Vector4f o_result) {
		if (o_result == null) {
			return new Vector4fImpl(x + i_source.getX(), y + i_source.getY(), z
					+ i_source.getZ(), w+i_source.getW());
		} else {
			o_result.set(x + i_source.getX(), y + i_source.getY(), z
					+ i_source.getZ(), w+i_source.getW());
			return o_result;
		}
	}

	/**
	 * Calculates the absolute value for each component of the given vector. The
	 * source and result vector may be the same object.
	 * 
	 * @param i_source the source vector
	 * @param io_result the result vector, if <code>null</code>, a new vector
	 *            will be created and returned
	 * @return the result vector
	 */
	public static Vector4f abs(IVector4f i_source, Vector4f io_result) {
		if (io_result == null)
			io_result = new Vector4fImpl(Math.abs(i_source.getX()), Math
					.abs(i_source.getY()), Math.abs(i_source.getZ()), Math
					.abs(i_source.getW()));
		else
			io_result.set(Math.abs(i_source.getX()), Math.abs(i_source.getY()),
					Math.abs(i_source.getZ()), Math.abs(i_source.getW()));

		return io_result;
	}

}
