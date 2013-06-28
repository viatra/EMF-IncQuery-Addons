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

/**
 * Pseudo move to be used in {@link MoveSeries} when camera is supposed
 * to be not moved during a given period of the whole move. This is especially
 * interesting when two {@link MoveSeries} are composed in a 
 * {@link ComposedMove}. E.g., one series defines the panning of the camera, 
 * while the second defines the movement. Sometimes, the camera should 
 * pan to the direction of the movement, while the camera is already moving.
 * Then the camera is moved to the target location, and shortly before reaching
 * this location, it should be panned again to a given target. The time 
 * between the two pannings can then be filled with a no move. 
 *
 * @author 	Jens von Pilgrim (developer@jevopi.de)
 * @version	$Revision$
 * @since 	May 22, 2011
 */
public class NoMove implements ICameraMove {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.draw3d.camera.tracking.ICameraMove#init(org.eclipse.draw3d.camera.ICameraPosition, org.eclipse.draw3d.camera.ICameraPosition)
	 */
	public ICameraPosition init(ICameraPosition i_startPosition,
		ICameraPosition i_endPosition) {
		return i_startPosition;
	}
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.draw3d.camera.tracking.ICameraMove#updateCameraPosition(org.eclipse.draw3d.camera.CameraPosition, float, float)
	 */
	public void updateCameraPosition(CameraPosition io_cameraPosition,
		float i_prevTick, float i_currentTick) {
	}

}
