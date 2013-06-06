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
public class Math3DVector2f extends Math3DBase {

	/**
	 * Calculates the absolute value for each component of the given vector. The
	 * source and result vector may be the same object.
	 * 
	 * @param i_source
	 *            the source vector
	 * @param io_result
	 *            the result vector, if <code>null</code>, a new vector will be
	 *            created and returned
	 * @return the result vector
	 */
	public static Vector2f abs(IVector2f i_source, Vector2f io_result) {
		if (io_result == null)
			io_result = new Vector2fImpl(Math.abs(i_source.getX()), Math
					.abs(i_source.getY()));
		else
			io_result.set(Math.abs(i_source.getX()), Math.abs(i_source.getY()));

		return io_result;
	}

	/**
	 * Adds two vectors.
	 * 
	 * @param i_leftVector3f
	 * @param i_rightVector3f
	 * @param o_resultVector3f
	 * @return
	 */
	public static Vector2f add(IVector2f i_left, IVector2f i_right,
			Vector2f o_result) {
		if (o_result == null) {
			return new Vector2fImpl(i_left.getX() + i_right.getX(), i_left
					.getY()
					+ i_right.getY());
		} else {
			o_result.set(i_left.getX() + i_right.getX(), i_left.getY()
					+ i_right.getY());
			return o_result;
		}
	}

	/**
	 * Returns the angle of the two vectors in the range of 0.0 through
	 * <i>pi</i>.
	 * 
	 * @param i_left
	 * @param i_right
	 * @return alpha [0..pi]
	 */
	public static float angle(IVector2f i_left, IVector2f i_right) {
		float cosAlpha = dot(i_left, i_right)
				/ (i_left.length() * i_right.length());
		if (cosAlpha <= -1)
			return (float) Math.PI;
		else if (cosAlpha >= 1) {
			return 0;
		}
		return (float) Math.acos(cosAlpha);
	}

	/**
	 * Calculates the dot product (scalar product) of the two vectors.
	 * 
	 * @param i_left
	 * @param i_right
	 * @return
	 */
	public static float dot(IVector2f i_left, IVector2f i_right) {
		return i_left.getX() * i_right.getX() + i_left.getY() * i_right.getY();
	}

	/**
	 * Calculates the negative value for each component of the given vector. The
	 * source and result vector may be the same object.
	 * 
	 * @param i_source
	 *            the source vector
	 * @param o_result
	 *            the result vector, if <code>null</code>, a new vector will be
	 *            created and returned
	 * @return the result vector
	 */
	public static Vector2f negate(IVector2f i_source, Vector2f o_result) {
		if (o_result == null) {
			return new Vector2fImpl(-i_source.getX(), -i_source.getY());
		} else {
			o_result.set(-i_source.getX(), -i_source.getY());
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
	public static Vector2f normalise(IVector2f i_source, Vector2f o_result) {
		float lengthInv = 1 / i_source.length();
		return scale(lengthInv, i_source, o_result);
	}

	/**
	 * Multiplies all elements of the vector with the given scale value.
	 * 
	 * @param scale
	 * @param i_sourceVector2f
	 * @param o_resultVector2f
	 * @return
	 */
	public static Vector2f scale(float scale, IVector2f i_source,
			Vector2f o_result) {
		if (o_result == null) {
			return new Vector2fImpl(scale * i_source.getX(), scale
					* i_source.getY());
		} else {
			o_result.set(scale * i_source.getX(), scale * i_source.getY());
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
	public static Vector2f sub(IVector2f i_left, IVector2f i_right,
			Vector2f o_result) {
		if (o_result == null) {
			return new Vector2fImpl(i_left.getX() - i_right.getX(), i_left
					.getY()
					- i_right.getY());
		} else {
			o_result.set(i_left.getX() - i_right.getX(), i_left.getY()
					- i_right.getY());
			return o_result;
		}
	}

	/**
	 * Translates a vector by given x and y value. Basically it's the same as
	 * adding a vector (x,y) to the vector.
	 * 
	 * @param i_source
	 * @param x
	 * @param y
	 * @param z
	 * @param o_result
	 * @return
	 */
	public static Vector2f translate(IVector2f i_source, float x, float y,
			Vector2f o_result) {
		if (o_result == null) {
			return new Vector2fImpl(x + i_source.getX(), y + i_source.getY());
		} else {
			o_result.set(x + i_source.getX(), y + i_source.getY());
			return o_result;
		}
	}
}
