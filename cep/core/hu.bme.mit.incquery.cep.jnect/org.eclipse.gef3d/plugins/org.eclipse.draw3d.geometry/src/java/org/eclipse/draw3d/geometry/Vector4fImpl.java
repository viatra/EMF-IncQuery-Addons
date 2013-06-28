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
import java.util.Arrays;

/**
 * Vector4fImpl Implementor of IVector4f and Vector4f. Provides simple methods
 * to hold and manipulate the vector's attributes.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Dec 16, 2008
 */
public final class Vector4fImpl implements Vector4f, Serializable, Cloneable {
	/**
	 * x attribute, made public for fast access. Usually, clients should use
	 * getters/setters as defined in {@link IVector4f} and {@link Vector4f}.
	 */
	public float x;

	/**
	 * y attribute, made public for fast access. Usually, clients should use
	 * getters/setters as defined in {@link IVector4f} and {@link Vector4f}.
	 */
	public float y;

	/**
	 * z attribute, made public for fast access. Usually, clients should use
	 * getters/setters as defined in {@link IVector4f} and {@link Vector4f}.
	 */
	public float z;

	/**
	 * w attribute, made public for fast access. Usually, clients should use
	 * getters/setters as defined in {@link IVector4f} and {@link Vector4f}.
	 */
	public float w;
	
	/**
	 * @see java.io.Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Casts any {@link IVector4f} matrix into a {@link Vector4fImpl},
	 * either by casting or copying. The returned object is of type
	 * {@link Vector4fImpl} and thus it is mutable. Since the object may
	 * be identical to the given, immutable one, the client of this method
	 * must ensure not to modify the returned object. This method is
	 * heavily used in {@link Math3D} for performance issues.
	 * 
	 * @param i_sourceVector4f The source vector.
	 * @return Vector4fImpl which is equals to given IVector4f
	 */
	static Vector4fImpl cast(IVector4f i_sourceVector4f) {
		if (i_sourceVector4f instanceof Vector4fImpl) {
			return (Vector4fImpl) i_sourceVector4f;
		} else {
			return new Vector4fImpl(i_sourceVector4f);
		}
	}

	/**
	 * The standard constructor, set vector to (0,0,0,0)
	 */
	public Vector4fImpl() {
	}

	/**
	 * Constructs a vector with the given x-,y-,z-,w-values.
	 * 
	 * @param x x value for the new Vector4f
	 * @param y y value for the new Vector4f
	 * @param z y value for the new Vector4f
	 */
	public Vector4fImpl(final float x, final float y, final float z, final float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	/**
	 * Constructs a vector4f from a source vector.
	 * 
	 * @param i_sourceVector4f The source vector, must not be null
	 */
	public Vector4fImpl(final IVector4f i_sourceVector4f) {
		this(i_sourceVector4f.getX(), i_sourceVector4f.getY(), i_sourceVector4f
				.getZ(), i_sourceVector4f.getW());
	}

	/**
	 * Constructs a vector4f from a float buffer by getting the first four
	 * elements from the buffer's current position. The elements are read in
	 * the following order: x, y, z, w
	 * 
	 * @param i_floatBuffer The buffer to construct the vector4f from,
	 * must not be null and at least 4 elements must be readable.
	 */
	public Vector4fImpl(final FloatBuffer i_floatBuffer) {
		this(i_floatBuffer.get(), i_floatBuffer.get(), i_floatBuffer.get(),
				i_floatBuffer.get());
	}

	/**
	 * Constructs a vector4f from a float array by taking the first four
	 * elements as values for x,y,z and w.
	 * 
	 * @param i_arrayOfFloat The float array to get x,y,z,w values from, must
	 * not be null and contain at least 4 elements.
	 */
	public Vector4fImpl(final float[] i_arrayOfFloat) {
		this(i_arrayOfFloat[0], i_arrayOfFloat[1], i_arrayOfFloat[2],
				i_arrayOfFloat[3]);
	}

	/**
	 * Constructs a vector4f from an array of float by taking four elements
	 * starting from <code>i_iOffset</code>.
	 * 
	 * @param i_arrayOfFloat The float array to get x,y,z,w values from, must not
	 * be null
	 * @param i_iOffset Get the array elements starting from this offset.
	 */
	public Vector4fImpl(final float[] i_arrayOfFloat, int i_iOffset) {
		this(i_arrayOfFloat[i_iOffset], i_arrayOfFloat[i_iOffset+1],
				i_arrayOfFloat[i_iOffset+2], i_arrayOfFloat[i_iOffset+3]);
	}
	
	/** 
	 * {@inheritDoc}
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Vector4fImpl(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(TO_STRING_FORMAT, String.valueOf(x), String
				.valueOf(y), String.valueOf(z), String.valueOf(w));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Vector4f#setX(float)
	 */
	public void setX(final float x) {
		this.x = x;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Vector4f#setY(float)
	 */
	public void setY(final float y) {
		this.y = y;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Vector4f#setZ(float)
	 */
	public void setZ(final float z) {
		this.z = z;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Vector4f#setW(float)
	 */
	public void setW(final float w) {
		this.w = w;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Vector4f#set(float, float, float, float)
	 */
	public void set(final float i_x, final float i_y, final float i_z, final float i_w) {
		x = i_x;
		y = i_y;
		z = i_z;
		w = i_w;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Vector4f#set(org.eclipse.draw3d.geometry.IVector4f)
	 */
	public void set(final IVector4f i_sourceVector4f) {
		this.x = i_sourceVector4f.getX();
		this.y = i_sourceVector4f.getY();
		this.z = i_sourceVector4f.getZ();
		this.w = i_sourceVector4f.getW();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector4f#getX()
	 */
	public float getX() {
		return x;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector4f#getY()
	 */
	public float getY() {
		return y;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector4f#getZ()
	 */
	public float getZ() {
		return z;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector4f#getW()
	 */
	public float getW() {
		return w;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector4f#length()
	 */
	public float length() {
		return (float) Math.sqrt(this.lengthSquared());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector4f#lengthSquared()
	 */
	public float lengthSquared() {
		return x * x + y * y + z * z + w * w;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector4f#toBuffer(java.nio.FloatBuffer)
	 */
	public void toBuffer(final FloatBuffer o_floatBuffer) {
		o_floatBuffer.put(x);
		o_floatBuffer.put(y);
		o_floatBuffer.put(z);
		o_floatBuffer.put(w);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector4f#toArray(float[])
	 */
	public void toArray(final float[] o_arrayOfFloat) {
		o_arrayOfFloat[0] = x;
		o_arrayOfFloat[1] = y;
		o_arrayOfFloat[2] = z;
		o_arrayOfFloat[3] = w;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector4f#toArray(float[], int)
	 */
	public void toArray(final float[] o_arrayOfFloat, int i_iOffset) {
		o_arrayOfFloat[i_iOffset] = this.x;
		o_arrayOfFloat[i_iOffset+1] = this.y;
		o_arrayOfFloat[i_iOffset+2] = this.z;
		o_arrayOfFloat[i_iOffset+3] = this.w;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector4f#equals(org.eclipse.draw3d.geometry.IVector4f)
	 */
	public boolean equals(final IVector4f v) {
		if (v==this) return true;
		if (v==null) return false;
		return x==v.getX() && y==v.getY() && z==v.getZ() && w==v.getW();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object i_obj) {
		if (i_obj == null || !(i_obj instanceof IVector4f))
			return false;
		return equals((IVector4f) i_obj);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IVector4f#equals(org.eclipse.draw3d.geometry.IVector4f,
	 *      float)
	 */
	public boolean equals(final IVector4f v, final float epsilon) {
		if (v==this) return true;
		if (v==null) return false;

		return Math.abs(x - v.getX()) <= epsilon && //
		Math.abs(y - v.getY()) <= epsilon && //
		Math.abs(z - v.getZ()) <= epsilon && //
		Math.abs(w - v.getW()) <= epsilon;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		float[] af = new float[4];
		toArray(af);
		return Arrays.hashCode(af);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Transformable#translate(float, float,
	 *      float)
	 */
	public void translate(final float i_dx, final float i_dy, final float i_dz) {
		Math3D.translate(this, i_dx, i_dy, i_dz, 0, this);
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
	public void transform(final IMatrix4f i_transformationMatrix4f) {
		Math3D.transform(this, i_transformationMatrix4f, this);
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.draw3d.geometry.IVector4f#toVector3f(org.eclipse.draw3d.geometry.Vector3f)
	 */
	public Vector3f toVector3f(Vector3f io_result) {
		
		Vector3f result = io_result;
		if (result == null)
			result = new Vector3fImpl();
		
		result.set(x, y, z);
		result.scale(1 / w);
		
		return result;
	}
}
