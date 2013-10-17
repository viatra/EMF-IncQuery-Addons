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
package org.eclipse.draw3d.camera.tracking;

import org.eclipse.draw3d.camera.CameraPosition;
import org.eclipse.draw3d.camera.ICameraPosition;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;

/**
 * Linearly moves the camera from the start position to the end position.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @version $Revision$
 * @since May 22, 2011
 * @see LinearMove
 */
public class LinearMovement extends AbstractStartEndMove {

	IVector3f direction;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.tracking.AbstractStartEndMove#init(org.eclipse.draw3d.camera.ICameraPosition,
	 *      org.eclipse.draw3d.camera.ICameraPosition)
	 */
	@Override
	public ICameraPosition init(ICameraPosition i_startPosition,
		ICameraPosition i_endPosition) {
		super.init(i_startPosition, i_endPosition);

		direction =
			Math3D.sub(i_endPosition.getPosition(),
				i_startPosition.getPosition(), null);

		return i_endPosition;

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.tracking.ICameraMove#updateCameraPosition(org.eclipse.draw3d.camera.CameraPosition,
	 *      float, float)
	 */
	public void updateCameraPosition(CameraPosition io_cameraPosition,
		float i_prevTick, float i_currentTick) {

		if (i_currentTick == 1f) {
			io_cameraPosition.setCameraPosition(getEndPosition());
		} else if (i_currentTick == 0f) {
			io_cameraPosition.setCameraPosition(getStartPosition());
		} else {
			Vector3f v = new Vector3fImpl();

			Math3D.scale(i_currentTick, direction, v);
			Math3D.add(getStartPosition().getPosition(), v, v);
			io_cameraPosition.setPosition(v);

		}
	}
}
