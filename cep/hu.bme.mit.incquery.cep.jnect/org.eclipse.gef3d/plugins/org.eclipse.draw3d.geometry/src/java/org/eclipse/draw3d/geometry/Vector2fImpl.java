/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 *    Kristian Duske - copied from Vector3fImpl
 ******************************************************************************/

package org.eclipse.draw3d.geometry;

import java.nio.FloatBuffer;
import java.util.Arrays;

/**
 * Vector2fImpl Implementor of IVector2f and Vector2f, a class which represents
 * a two-dimensional vector. Provides simple methods to hold and manipulate the
 * vector's attributes.
 * 
 * @author Jens von Pilgrim
 * @author Kristian Duske
 * @version $Revision$
 * @since Jun 3, 2009
 */
public final class Vector2fImpl implements Vector2f /* includes Cloneable and Serializable */ {

	/**
	 * x attribute, made public for fast access. Usually, clients should use
	 * getters/setters as defined in {@link IVector3f} and {@link Vector3f}.
	 */
	public float x;

	/**
	 * y attribute, made public for fast access. Usually, clients should use
	 * getters/setters as defined in {@link IVector3f} and {@link Vector3f}.
	 */

	public float y;

	/**
	 * @see java.io.Serializable
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Casts any {@link IVector2f} vector into a {@link Vector2fImpl}, either by
	 * casting or copying. The returned object is of type {@link Vector2fImpl}
	 * and thus it is mutable. Since the object may be identical to the given,
	 * immutable one, the client of this method must ensure not to modify the
	 * returned object. This method is heavily used in {@link Math3D} for
	 * performance issues.
	 * 
	 * @param i_sourceVector2f
	 *            The source vector.
	 * @return Vector2fImpl which is equals to given IVector2f
	 */
	static Vector2fImpl cast(IVector2f i_sourceVector2f) {
		if (i_sourceVector2f instanceof Vector2fImpl) {
			return (Vector2fImpl) i_sourceVector2f;
		} else {
			return new Vector2fImpl(i_sourceVector2f);
		}
	}

	/**
	 * The standard constructor, all fields are set to zero.
	 */
	public Vector2fImpl() {

	}

	/**
	 * Constructs a vector with the given x and y values.
	 * 
	 * @param x
	 *            x value for the new Vector3f
	 * @param y
	 *            y value for the new Vector3f
	 */
	public Vector2fImpl(final float x, final float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Constructs a vector3f from a source vector.
	 * 
	 * @param i_sourceVector2f
	 *            The source vector.
	 */
	public Vector2fImpl(final IVector2f i_sourceVector2f) {
		this(i_sourceVector2f.getX(), i_sourceVector2f.getY());
	}

	/**
	 * Constructs a vector2f from a source vector.
	 * 
	 * @param i_sourceVector2f
	 *            The source vector.
	 */
	public Vector2fImpl(final Vector2fImpl i_sourceVector2f) {
		this(i_sourceVector2f.x, i_sourceVector2f.y);
	}

	/**
	 * Constructs a vector2f from a float buffer by getting the first two
	 * elements from the buffer's current position.
	 * 
	 * @param i_floatBuffer
	 *            The buffer to construct the vector2f from.
	 */
	public Vector2fImpl(final FloatBuffer i_floatBuffer) {
		this(i_floatBuffer.get(), i_floatBuffer.get());
	}

	/**
	 * Constructs a vector2f from a float array by taking the first two elements
	 * as values for x and y.
	 * 
	 * @param i_arrayOfFloat
	 *            The float array to get x and y values from.
	 */
	public Vector2fImpl(final float[] i_arrayOfFloat) {
		this(i_arrayOfFloat[0], i_arrayOfFloat[1]);
	}

	/**
	 * Constructs a vector3f from an array of float by taking two elements
	 * starting from <code>i_iOffset</code>.
	 * 
	 * @param i_arrayOfFloat
	 *            The float array to get x and y values from.
	 * @param i_iOffset
	 *            Get the array elements starting from this offset.
	 */
	public Vector2fImpl(final float[] i_arrayOfFloat, int i_iOffset) {
		this(i_arrayOfFloat[i_iOffset], i_arrayOfFloat[i_iOffset+1]);
	}
	
	/** 
	 * {@inheritDoc}
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Vector2fImpl(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Vector2f#set(org.eclipse.draw3d.geometry.IVector2f)
	 */
	public void set(final IVector2f i_vector2f) {
		x = i_vector2f.getX();
		y = i_vector2f.getY();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Vector2f#set(float, float)
	 */
	public void set(final float i_x, final float i_y) {
		x = i_x;
		y = i_y;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Vector2f#setX(float)
	 */
	public void setX(final float x) {
		this.x = x;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Vector2f#setY(float)
	 */
	public void setY(final float y) {
		this.y = y;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector2f#equals(org.eclipse.draw3d.geometry.IVector2f)
	 */
	public boolean equals(final IVector2f v) {
		if (v == this)
			return true;
		if (v == null)
			return false;
		return x == v.getX() && y == v.getY();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object i_obj) {
		if (i_obj instanceof IVector2f) {
			return equals((IVector2f) i_obj);
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector2f#equals(org.eclipse.draw3d.geometry.IVector2f,
	 *      float)
	 */
	public boolean equals(final IVector2f v, final float epsilon) {
		if (v == this)
			return true;
		if (v == null)
			return false;
		return Math.abs(x - v.getX()) <= epsilon && //
				Math.abs(y - v.getY()) <= epsilon;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector2f#length()
	 */
	public float length() {
		return (float) Math.sqrt(this.lengthSquared());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector2f#lengthSquared()
	 */
	public float lengthSquared() {
		return x * x + y * y;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector2f#getX()
	 */
	public float getX() {
		return this.x;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector2f#getY()
	 */
	public float getY() {
		return this.y;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector2f#toArray(float[])
	 */
	public void toArray(final float[] o_arrayOfFloat) {
		o_arrayOfFloat[0] = x;
		o_arrayOfFloat[1] = y;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector2f#toArray(float[], int)
	 */
	public void toArray(final float[] o_arrayOfFloat, int i_iOffset) {
		o_arrayOfFloat[i_iOffset] = x;
		o_arrayOfFloat[i_iOffset+1] = y;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector2f#toBuffer(java.nio.FloatBuffer)
	 */
	public void toBuffer(FloatBuffer o_floatBuffer) {
		o_floatBuffer.put(x);
		o_floatBuffer.put(y);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(TO_STRING_FORMAT, String.valueOf(x), String
				.valueOf(y));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		float[] af = new float[2];
		toArray(af);
		return Arrays.hashCode(af);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Transformable#scale(float)
	 */
	public void scale(final float i_factor) {
		Math3D.scale(i_factor, this, this);
	}
}
