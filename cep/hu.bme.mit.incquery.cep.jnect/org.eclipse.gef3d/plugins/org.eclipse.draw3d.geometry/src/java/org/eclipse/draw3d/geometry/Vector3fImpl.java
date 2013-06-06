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
import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Vector3fImpl Implementor of IVector3f and Vector3f, a class which represents
 * a three-dimensional vector. Provides simple methods to hold and manipulate
 * the vector's attributes.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Dec 16, 2008
 */
public final class Vector3fImpl implements Vector3f /* includes Cloneable, Serializable */ {

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
	 * z attribute, made public for fast access. Usually, clients should use
	 * getters/setters as defined in {@link IVector3f} and {@link Vector3f}.
	 */

	public float z;

	/**
	 * @see java.io.Serializable
	 */
	private static final long serialVersionUID = 1L;

	protected final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat(
		"0.##");

	/**
	 * Casts any {@link IVector3f} matrix into a {@link Vector3fImpl}, either by
	 * casting or copying. The returned object is of type {@link Vector3fImpl}
	 * and thus it is mutable. Since the object may be identical to the given,
	 * immutable one, the client of this method must ensure not to modify the
	 * returned object. This method is heavily used in {@link Math3D} for
	 * performance issues.
	 * 
	 * @param i_sourceVector3f The source vector.
	 * @return Vector3fImpl which is equals to given IVector3f
	 */
	static Vector3fImpl cast(IVector3f i_sourceVector3f) {
		if (i_sourceVector3f instanceof Vector3fImpl) {
			return (Vector3fImpl) i_sourceVector3f;
		} else {
			return new Vector3fImpl(i_sourceVector3f);
		}
	}

	/**
	 * The standard constructor, all fields are set to zero.
	 */
	public Vector3fImpl() {

	}

	/**
	 * Constructs a vector with the given x-, y-, and z-values.
	 * 
	 * @param x x value for the new Vector3f
	 * @param y y value for the new Vector3f
	 * @param z y value for the new Vector3f
	 */
	public Vector3fImpl(final float x, final float y, final float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Constructs a vector3f from a source vector.
	 * 
	 * @param i_sourceVector3f The source vector.
	 */
	public Vector3fImpl(final IVector3f i_sourceVector3f) {
		this(i_sourceVector3f.getX(), i_sourceVector3f.getY(), i_sourceVector3f
			.getZ());
	}

	/**
	 * Constructs a vector3f from a source vector.
	 * 
	 * @param i_sourceVector3f The source vector.
	 */
	public Vector3fImpl(final Vector3fImpl i_sourceVector3f) {
		this(i_sourceVector3f.x, i_sourceVector3f.y, i_sourceVector3f.z);
	}

	/**
	 * Constructs a vector3f from a float buffer by getting the first three
	 * elements from the buffer's current position.
	 * 
	 * @param i_floatBuffer The buffer to construct the vector3f from.
	 */
	public Vector3fImpl(final FloatBuffer i_floatBuffer) {
		this(i_floatBuffer.get(), i_floatBuffer.get(), i_floatBuffer.get());
	}

	/**
	 * Constructs a vector3f from a float array by taking the first three
	 * elements as values for x, y and z.
	 * 
	 * @param i_arrayOfFloat The float array to get x,y,z values from.
	 */
	public Vector3fImpl(final float[] i_arrayOfFloat) {
		this(i_arrayOfFloat[0], i_arrayOfFloat[1], i_arrayOfFloat[2]);
	}

	/**
	 * Constructs a vector3f from an array of float by taking three elements
	 * starting from <code>i_iOffset</code>.
	 * 
	 * @param i_arrayOfFloat The float array to get x,y,z values from.
	 * @param i_iOffset Get the array elements starting from this offset.
	 */
	public Vector3fImpl(final float[] i_arrayOfFloat, int i_iOffset) {
		this(i_arrayOfFloat[i_iOffset], i_arrayOfFloat[i_iOffset+1],
			i_arrayOfFloat[i_iOffset+2]);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Vector3fImpl(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Vector3f#set(org.eclipse.draw3d.geometry.IVector3f)
	 */
	public void set(final IVector3f i_vector3f) {
		x = i_vector3f.getX();
		y = i_vector3f.getY();
		z = i_vector3f.getZ();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Vector3f#set(float, float, float)
	 */
	public void set(final float i_x, final float i_y, final float i_z) {
		x = i_x;
		y = i_y;
		z = i_z;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Vector3f#setX(float)
	 */
	public void setX(final float x) {
		this.x = x;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Vector3f#setY(float)
	 */
	public void setY(final float y) {
		this.y = y;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Vector3f#setZ(float)
	 */
	public void setZ(final float z) {
		this.z = z;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector3f#equals(org.eclipse.draw3d.geometry.IVector3f)
	 */
	public boolean equals(final IVector3f v) {
		if (v == this)
			return true;
		if (v == null)
			return false;
		return x == v.getX() && y == v.getY() && z == v.getZ();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object i_obj) {
		if (i_obj instanceof IVector3f) {
			return equals((IVector3f) i_obj);
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector3f#equals(org.eclipse.draw3d.geometry.IVector3f,
	 *      float)
	 */
	public boolean equals(final IVector3f v, final float epsilon) {
		if (v == this)
			return true;
		if (v == null)
			return false;
		return Math.abs(x - v.getX()) <= epsilon && //
			Math.abs(y - v.getY()) <= epsilon && //
			Math.abs(z - v.getZ()) <= epsilon;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector3f#length()
	 */
	public float length() {
		return (float) Math.sqrt(this.lengthSquared());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector3f#lengthSquared()
	 */
	public float lengthSquared() {
		return x * x + y * y + z * z;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector3f#getX()
	 */
	public float getX() {
		return this.x;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector3f#getY()
	 */
	public float getY() {
		return this.y;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector3f#getZ()
	 */
	public float getZ() {
		return this.z;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector3f#toArray(float[])
	 */
	public void toArray(final float[] o_arrayOfFloat) {
		o_arrayOfFloat[0] = x;
		o_arrayOfFloat[1] = y;
		o_arrayOfFloat[2] = z;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector3f#toArray(float[], int)
	 */
	public void toArray(final float[] o_arrayOfFloat, int i_iOffset) {
		o_arrayOfFloat[i_iOffset] = x;
		o_arrayOfFloat[i_iOffset+1] = y;
		o_arrayOfFloat[i_iOffset+2] = z;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector3f#toBuffer(java.nio.FloatBuffer)
	 */
	public void toBuffer(FloatBuffer o_floatBuffer) {
		o_floatBuffer.put(x);
		o_floatBuffer.put(y);
		o_floatBuffer.put(z);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return String.format(TO_STRING_FORMAT, DECIMAL_FORMAT.format(x),
			DECIMAL_FORMAT.format(y), DECIMAL_FORMAT.format(z));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		float[] af = new float[3];
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

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Transformable#transform(org.eclipse.draw3d.geometry.Matrix4f)
	 */
	public void transform(final IMatrix4f i_matrix4f) {
		Math3D.transform(this, i_matrix4f, this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Transformable#translate(float, float,
	 *      float)
	 */
	public void translate(final float i_dx, final float i_dy, final float i_dz) {
		Math3D.translate(this, i_dx, i_dy, i_dz, this);
	}

}
