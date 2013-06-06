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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw3d.camera.CameraPosition;
import org.eclipse.draw3d.camera.ICameraPosition;

/**
 * Composed camera move, all sub moves are executed simultaneously. This can be
 * used to easily combine movement and panning of a camera.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @version $Revision$
 * @since May 22, 2011
 */
public class ComposedMove implements ICameraMove {

	List<ICameraMove> moves = new ArrayList<ICameraMove>();

	public void addMove(ICameraMove move) {
		moves.add(move);
	}
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.draw3d.camera.tracking.ICameraMove#init(org.eclipse.draw3d.camera.ICameraPosition, org.eclipse.draw3d.camera.ICameraPosition)
	 */
	public ICameraPosition init(ICameraPosition i_startPosition,
		ICameraPosition i_endPosition) {
		
		ICameraPosition endPos = i_endPosition;
		for (ICameraMove move : moves) {
			endPos = move.init(i_startPosition, i_endPosition);
		}
		return endPos;
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.tracking.ICameraMove#updateCameraPosition(org.eclipse.draw3d.camera.CameraPosition,
	 *      float, float)
	 */
	public void updateCameraPosition(CameraPosition io_cameraPosition,
		float prevTick, float currentTick) {
		for (ICameraMove move : moves) {
			move.updateCameraPosition(io_cameraPosition, prevTick, currentTick);
		}

	}

}
