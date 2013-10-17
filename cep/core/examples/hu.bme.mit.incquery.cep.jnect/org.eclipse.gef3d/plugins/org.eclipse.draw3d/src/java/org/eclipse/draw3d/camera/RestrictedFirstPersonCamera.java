/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.camera;

import java.util.logging.Logger;

import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Math3DCache;
import org.eclipse.draw3d.geometry.Matrix4f;

/**
 * A camera that implements a first person strategy and that restricts movement
 * so that a sense of up and down is retained.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 19.11.2007
 */
public class RestrictedFirstPersonCamera extends FirstPersonCamera {

	private static final float HALF_PI = (float) Math.PI / 2;

	@SuppressWarnings("unused")
	private static Logger log =
		Logger.getLogger(RestrictedFirstPersonCamera.class.getName());

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.ICamera#lookAt(org.eclipse.draw3d.geometry.IVector3f,
	 *      org.eclipse.draw3d.geometry.IVector3f)
	 */
	@Override
	public void lookAt(IVector3f i_to, IVector3f i_upvector) {

		Math3D.sub(i_to, m_position, m_viewDir);
		Math3D.normalise(m_viewDir, m_viewDir);

		// p+v=t => v = t-p
		Math3D.cross(m_up, m_viewDir, m_right);
		Math3D.normalise(m_right, m_right);

		fireCameraChanged();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.ICamera#orbit(IVector3f, float, float)
	 */
	@Override
	public void orbit(IVector3f i_center, float i_hAngle, float i_vAngle) {

		// don't allow absolute pitch > 90 degrees
		float currentPitch = HALF_PI - Math3D.angle(m_viewDir, UP_REF);
		boolean allowPitch = Math.abs(currentPitch + i_vAngle) < HALF_PI;

		Matrix4f rot = Math3DCache.getMatrix4f();
		try {
			rot.setIdentity();
			if (i_hAngle != 0)
				Math3D.rotate(i_hAngle, UP_REF, rot, rot);

			if (i_vAngle != 0 && allowPitch)
				Math3D.rotate(i_vAngle, m_right, rot, rot);

			// camera position
			Math3D.sub(m_position, i_center, m_position);
			m_position.transform(rot);
			Math3D.add(m_position, i_center, m_position);

			// view direction and reference vectors
			m_viewDir.transform(rot);

			Math3D.cross(m_viewDir, UP_REF, m_right);
			Math3D.normalise(m_right, m_right);

			Math3D.cross(m_right, m_viewDir, m_up);
			Math3D.normalise(m_up, m_up);

			fireCameraChanged();
		} finally {
			Math3DCache.returnMatrix4f(rot);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.FirstPersonCamera#rotate(float, float,
	 *      float)
	 */
	@Override
	public void rotate(float i_roll, float i_pitch, float i_yaw) {

		Matrix4f rot = Math3DCache.getMatrix4f();
		try {
			rot.setIdentity();

			// don't allow absolute pitch > 90 degrees
			float currentPitch = HALF_PI - Math3D.angle(m_viewDir, UP_REF);
			boolean allowPitch = Math.abs(currentPitch + i_pitch) < HALF_PI;

			if (i_pitch != 0 && allowPitch)
				Math3D.rotate(i_pitch, m_right, rot, rot);

			if (i_yaw != 0)
				Math3D.rotate(i_yaw, UP_REF, rot, rot);

			m_viewDir.transform(rot);

			Math3D.cross(m_viewDir, UP_REF, m_right);
			Math3D.normalise(m_right, m_right);

			Math3D.cross(m_right, m_viewDir, m_up);
			Math3D.normalise(m_up, m_up);

			fireCameraChanged();
		} finally {
			Math3DCache.returnMatrix4f(rot);
		}
	}
}
