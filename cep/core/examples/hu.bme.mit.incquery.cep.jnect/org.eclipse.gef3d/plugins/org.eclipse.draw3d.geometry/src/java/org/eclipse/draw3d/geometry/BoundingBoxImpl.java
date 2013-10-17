/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API
 *    Matthias Thiele -- initial implementation
 ******************************************************************************/
package org.eclipse.draw3d.geometry;

/**
 * Implementation of {@link BoundingBox} and, therewith, of {@link IBoundingBox}
 * .
 * 
 * @author Matthias Thiele
 * @version $Revision$
 * @since 12.10.2008
 */
public class BoundingBoxImpl implements BoundingBox {

	/**
	 * The location of this bounding box.
	 */
	public Vector3fImpl m_position;

	/**
	 * The size of this bounding box.
	 */
	public Vector3fImpl m_size;

	/**
	 * The standard constructor. Location and size are both set to (0,0,0). If
	 * you want to create a unit box, use
	 */
	public BoundingBoxImpl() {

		this.m_position = new Vector3fImpl();
		this.m_size = new Vector3fImpl();
	}

	/**
	 * Creates a bounding box, if bCreateUnitBox is true, its size is set to the
	 * unit vector, i.e. (1,1,1), otherwise the size is set to (0,0,0).
	 * <p>
	 * 
	 * @param bCreateUnitBox if set to true, size is set to (1,1,1)
	 */
	public BoundingBoxImpl(boolean bCreateUnitBox) {

		this.m_position = new Vector3fImpl();
		this.m_size = new Vector3fImpl(1, 1, 1);
	}

	/**
	 * Constructs a BoundingBox, taking position and size from a source bounding
	 * box.
	 * 
	 * @param i_sourceBoundingBox The source bounding box.
	 */
	public BoundingBoxImpl(IBoundingBox i_sourceBoundingBox) {

		this.m_position = new Vector3fImpl();
		this.m_size = new Vector3fImpl();

		i_sourceBoundingBox.getLocation(this.m_position);
		i_sourceBoundingBox.getSize(this.m_size);
	}

	/**
	 * Constructs a BoundingBox with the given size and position.
	 * 
	 * @param i_position The source position
	 * @param i_size The source size
	 */
	public BoundingBoxImpl(IVector3f i_position, IVector3f i_size) {

		this.m_position = new Vector3fImpl(i_position);
		this.m_size = new Vector3fImpl(i_size);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.BoundingBox#expand(float)
	 */
	public void expand(float i_iDelta) {

		float d = -0.5f * i_iDelta;
		Math3D.translate(m_position, d, d, d, m_position);
		Math3D.translate(m_size, i_iDelta, i_iDelta, i_iDelta, m_size);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.BoundingBox#getCenter(Vector3f)
	 */
	public Vector3f getCenter(Vector3f o_resultVector3f) {

		Vector3f result =
			o_resultVector3f != null ? o_resultVector3f : new Vector3fImpl();

		result.setX(m_position.getX() + m_size.getX() / 2);
		result.setY(m_position.getY() + m_size.getY() / 2);
		result.setZ(m_position.getZ() + m_size.getZ() / 2);

		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IBoundingBox#getEnd(org.eclipse.draw3d.geometry.Vector3f)
	 */
	public Vector3f getEnd(Vector3f o_resultVector3f) {

		Vector3f result = o_resultVector3f;
		if (result == null)
			result = new Vector3fImpl();

		Math3D.add(m_position, m_size, result);
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.BoundingBox#getLocation(Vector3f)
	 */
	public Vector3f getLocation(Vector3f o_resultVector3f) {

		Vector3f result =
			o_resultVector3f != null ? o_resultVector3f : new Vector3fImpl();
		result.set(this.m_position);

		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.BoundingBox#getSize(Vector3f)
	 */
	public Vector3f getSize(Vector3f o_resultVector3f) {

		Vector3f result =
			o_resultVector3f != null ? o_resultVector3f : new Vector3fImpl();
		result.set(this.m_size);

		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.BoundingBox#resize(float, float, float)
	 */
	public void resize(float i_dx, float i_dy, float i_dz) {

		Math3D.translate(this.m_size, i_dx, i_dy, i_dz, this.m_size);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.BoundingBox#resize(IVector3f)
	 */
	public void resize(IVector3f i_deltaVector3f) {

		Math3D.translate(m_size, i_deltaVector3f.getX(),
			i_deltaVector3f.getY(), i_deltaVector3f.getZ(), m_size);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Transformable#scale(float)
	 */
	public void scale(float i_factor) {

		Math3D.scale(i_factor, this.m_size, this.m_size);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.BoundingBox#set(IBoundingBox)
	 */
	public void set(IBoundingBox i_sourceBoundingBox3f) {

		i_sourceBoundingBox3f.getLocation(m_position);
		i_sourceBoundingBox3f.getSize(m_size);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.BoundingBox#setEnd(org.eclipse.draw3d.geometry.IVector3f)
	 */
	public void setEnd(IVector3f i_end) {

		Vector3f tmpEnd = Math3DCache.getVector3f();
		try {
			Math3D.max(getEnd(tmpEnd), i_end, tmpEnd);
			Math3D.min(m_position, i_end, m_position);
			Math3D.sub(tmpEnd, m_position, m_size);
		} finally {
			Math3DCache.returnVector3f(tmpEnd);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.BoundingBox#setLocation(float, float,
	 *      float)
	 */
	public void setLocation(float i_x, float i_y, float i_z) {

		m_position.x = i_x;
		m_position.y = i_y;
		m_position.z = i_z;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.BoundingBox#setLocation(org.eclipse.draw3d.geometry.IVector3f)
	 */
	public void setLocation(IVector3f i_location) {

		setLocation(i_location.getX(), i_location.getY(), i_location.getZ());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.BoundingBox#setSize(float, float, float)
	 */
	public void setSize(float i_width, float i_height, float i_depth) {

		m_size.x = i_width;
		m_size.y = i_height;
		m_size.z = i_depth;

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.BoundingBox#setSize(org.eclipse.draw3d.geometry.IVector3f)
	 */
	public void setSize(IVector3f i_newSize) {

		m_size.x = i_newSize.getX();
		m_size.y = i_newSize.getY();
		m_size.z = i_newSize.getZ();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("BoundingBoxImpl[ Size: ");
		sb.append(this.m_size.toString());
		sb.append(" Position: ");
		sb.append(this.m_position.toString());
		sb.append("]\n");

		return sb.toString();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Transformable#transform(IMatrix4f)
	 */
	public void transform(IMatrix4f i_transformationMatrix4f) {

		float x = this.m_position.getX();
		float y = this.m_position.getY();
		float z = this.m_position.getZ();

		Vector4f tmp = new Vector4fImpl(x, y, z, 1);
		Math3D.transform(tmp, i_transformationMatrix4f, tmp);

		float w = tmp.getW();
		x = tmp.getX() / w;
		y = tmp.getY() / w;
		z = tmp.getZ() / w;

		this.setLocation(x, y, z);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.BoundingBox#translate(float, float,
	 *      float)
	 */
	public void translate(float i_dx, float i_dy, float i_dz) {

		Math3D.translate(m_position, i_dx, i_dy, i_dz, m_position);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.BoundingBox#translate(float, float,
	 *      float)
	 */
	public void translate(IVector3f i_sourceVector3f) {

		Math3D.translate(this.m_position, i_sourceVector3f.getX(),
			i_sourceVector3f.getY(), i_sourceVector3f.getZ(), this.m_position);
	}
}
