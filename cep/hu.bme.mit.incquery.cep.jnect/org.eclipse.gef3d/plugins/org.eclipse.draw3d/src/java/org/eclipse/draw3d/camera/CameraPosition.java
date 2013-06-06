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
package org.eclipse.draw3d.camera;

import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Math3DCache;
import org.eclipse.draw3d.geometry.Matrix4f;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;

/**
 * Value object storing information about camera position, view direction and up
 * vector. These three values are stored in this object, other values such as
 * right vector, are derived.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @version $Revision$
 * @since May 22, 2011
 */
public class CameraPosition extends AbstractCameraPosition {

	protected Vector3fImpl position;

	protected Vector3fImpl viewDir;

	protected Vector3fImpl upVector;

	/**
	 * 
	 */
	public CameraPosition() {
		position = new Vector3fImpl();
		viewDir = new Vector3fImpl();
		upVector = new Vector3fImpl();

		position.set(0, 0, -1000);
		viewDir.set(ICamera.VIEW_REF);
		upVector.set(ICamera.UP_REF);
	}

	public CameraPosition(ICameraPosition src) {
		position = new Vector3fImpl();
		viewDir = new Vector3fImpl();
		upVector = new Vector3fImpl();
		setCameraPosition(src);

	}

	/**
	 * @param cameraPos, must not be null
	 */
	public void setCameraPosition(ICameraPosition cameraPos) {
		if (cameraPos == null) // parameter precondition
			throw new NullPointerException("cameraPos must not be null");

		cameraPos.getPosition(position);
		cameraPos.getViewDirection(viewDir);
		cameraPos.getUpVector(upVector);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.ICameraPosition#getPosition()
	 */
	public IVector3f getPosition(Vector3f o_result) {
		if (o_result!=null) {
			o_result.set(position);
		}
		return position;
	}

	/**
	 * @param i_position the position to set
	 */
	public void setPosition(IVector3f i_position) {
		position.set(i_position);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.ICameraPosition#getViewDirection()
	 */
	public IVector3f getViewDirection(Vector3f o_result) {
		if (o_result!=null) {
			o_result.set(viewDir);
		}
		return viewDir;
	}

	/**
	 * Sets the viewing direction. The setter normalizes the vector, so clients
	 * do not have to normalize the parameter.
	 * 
	 * @param i_viewDir the viewDir to set (not necessarily normalized)
	 */
	public void setViewDirection(IVector3f i_viewDir) {
		Math3D.normalise(i_viewDir, viewDir);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.ICameraPosition#getUpVector()
	 */
	public IVector3f getUpVector(Vector3f o_result) {
		if (o_result!=null) {
			o_result.set(upVector);
		}
		return upVector;
	}

	/**
	 * Sets the up vector. The setter normalizes the vector, so clients do not
	 * have to normalize the parameter.
	 * 
	 * @param i_upVector the upVector to set (not necessarily normalized)
	 */
	public void setUpVector(IVector3f i_upVector) {
		Math3D.normalise(i_upVector, upVector);
	}

	/**
	 * Returns the right vector, which is a derived value computed from view
	 * direction and up vector.
	 * 
	 * @param rightVector, stores the result, may be null
	 * @return
	 */
	public IVector3f getRightVector(Vector3f o_result) {
		Vector3f rightVector = o_result;
		if (rightVector == null) {
			rightVector = new Vector3fImpl();
		}

		Math3D.cross(viewDir, upVector, rightVector);
		return rightVector;
	}

	/**
	 * Look at the given position. This simply calculates the view direction by
	 * subtracting the current position from the given to location, and
	 * normalizing the result.
	 * 
	 * @param i_position the position to look at
	 */
	public void lookAt(IVector3f i_to) {
		Math3D.sub(i_to, position, viewDir);
		Math3D.normalise(viewDir, viewDir);
	}

	/**
	 * Moves the camera position around a location (called orbit center) by a
	 * given angle.
	 * 
	 * @param i_center the orbit center
	 * @param i_hAngle the horizontal orbit angle, in radians
	 * @param i_vAngle the vertical orbit angle, in radians
	 */
	public void orbit(IVector3f i_center, float i_hAngle, float i_vAngle) {

		Matrix4f rot = Math3DCache.getMatrix4f();
		Vector3f tmp = Math3DCache.getVector3f();

		try {
			rot.setIdentity();
			if (i_hAngle != 0)
				Math3D.rotate(i_hAngle, upVector, rot, rot);

			if (i_vAngle != 0)
				Math3D.rotate(i_vAngle, getRightVector(tmp), rot, rot);

			// camera position
			Math3D.sub(position, i_center, tmp);
			tmp.transform(rot);
			Math3D.add(tmp, i_center, position);

			// view direction and reference vectors
			viewDir.transform(rot);
			upVector.transform(rot);

		} finally {
			Math3DCache.returnMatrix4f(rot);
			Math3DCache.returnVector3f(tmp);
		}
	}

}
