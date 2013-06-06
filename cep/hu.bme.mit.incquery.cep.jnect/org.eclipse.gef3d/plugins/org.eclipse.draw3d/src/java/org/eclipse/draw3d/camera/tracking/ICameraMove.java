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
 * ICameraMove There should really be more documentation here.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @version $Revision$
 * @since May 20, 2011
 */
public interface ICameraMove {

	/**
	 * Initializes a move by setting a start position and an end position. Some
	 * moves do not use an end position, but instead calculate the end position
	 * from the start position. In any case, the end position of the move is
	 * returned.
	 * 
	 * @param startPosition
	 * @param endPosition
	 * @return
	 */
	ICameraPosition init(ICameraPosition startPosition,
		ICameraPosition endPosition);

	/**
	 * Calculates the camera position at the time of the animation. The camera
	 * position passed to this method is updated, and used both for the result
	 * of the track step as well as for the initial camera position (when
	 * progress is 0).
	 * <p>
	 * The camera track task ensures this method is called at least with
	 * progress is 1.
	 * </p>
	 * 
	 * @param io_cameraPosition
	 * @param prevTick
	 * @param currentTick
	 */
	void updateCameraPosition(CameraPosition io_cameraPosition, float prevTick,
		float currentTick);

}
