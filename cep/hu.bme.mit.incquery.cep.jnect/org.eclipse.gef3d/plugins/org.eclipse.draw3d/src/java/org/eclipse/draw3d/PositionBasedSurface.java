/*******************************************************************************
 * Copyright (c) 2011 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d;

import org.eclipse.draw3d.geometry.IMatrix4f;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Math3DCache;
import org.eclipse.draw3d.geometry.Matrix4f;
import org.eclipse.draw3d.geometry.Position3D;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;
import org.eclipse.draw3d.util.Draw3DCache;

/**
 * A surface which is defined by a {@link Position3D}.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @version $Revision$
 * @since Apr 18, 2011
 */
public abstract class PositionBasedSurface extends AbstractSurface {

	
	/**
	 * Returns the position this surface is based on.
	 * @return
	 */
	protected abstract Position3D getPosition3D();
	

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.AbstractSurface#calculateNormal(org.eclipse.draw3d.geometry.Vector3f)
	 */
	@Override
	protected void calculateNormal(Vector3f io_normal) {
		io_normal.set(IVector3f.Z_AXIS_NEG);
		IMatrix4f rotation = getPosition3D().getAbsoluteRotationMatrix();
		Math3D.transform(io_normal, rotation, io_normal);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.AbstractSurface#getOrigin(org.eclipse.draw3d.geometry.Vector3f)
	 */
	@Override
	protected Vector3f getOrigin(Vector3f io_result) {
		Vector3f result = io_result;
		if (result == null)
			result = new Vector3fImpl();

		Position3D position3d = getPosition3D();
		IMatrix4f matrix = position3d.getRotationLocationMatrix();

		result.set(IVector3f.NULLVEC3f);
		result.transform(matrix);

		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.ISurface#getSurfaceRotation(org.eclipse.draw3d.geometry.Vector3f)
	 */
	public Vector3f getSurfaceRotation(Vector3f o_result) {
		Vector3f result = o_result;
		if (result == null)
			result = new Vector3fImpl();

		Position3D absolute = Draw3DCache.getPosition3D();
		try {
			getPosition3D().getAbsolute(absolute);
			result.set(absolute.getRotation3D());

			return result;
		} finally {
			Draw3DCache.returnPosition3D(absolute);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.AbstractSurface#getXAxis(org.eclipse.draw3d.geometry.Vector3f)
	 */
	@Override
	protected Vector3f getXAxis(Vector3f io_result) {
		Vector3f result = io_result;
		if (result == null)
			result = new Vector3fImpl();

		result.set(IVector3f.X_AXIS);
		rotateVector(result);

		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.AbstractSurface#getYAxis(org.eclipse.draw3d.geometry.Vector3f)
	 */
	@Override
	protected Vector3f getYAxis(Vector3f io_result) {
		Vector3f result = io_result;
		if (result == null)
			result = new Vector3fImpl();

		result.set(IVector3f.Y_AXIS);
		rotateVector(result);

		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.AbstractSurface#getZAxis(org.eclipse.draw3d.geometry.Vector3f)
	 */
	@Override
	protected Vector3f getZAxis(Vector3f io_result) {
		Vector3f result = io_result;
		if (result == null)
			result = new Vector3fImpl();

		result.set(IVector3f.Z_AXIS);
		rotateVector(result);

		return result;
	}

	protected void rotateVector(Vector3f i_vector) {
		Matrix4f rot = Math3DCache.getMatrix4f();
		try {
			IVector3f angles = getPosition3D().getRotation3D();
			Math3D.rotate(angles, IMatrix4f.IDENTITY, rot);

			i_vector.transform(rot);
		} finally {
			Math3DCache.returnMatrix4f(rot);
		}
	}

}
