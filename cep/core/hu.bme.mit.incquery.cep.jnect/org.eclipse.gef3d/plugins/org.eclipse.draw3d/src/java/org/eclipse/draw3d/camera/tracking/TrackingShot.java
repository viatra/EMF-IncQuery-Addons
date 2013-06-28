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

import java.util.TimerTask;
import java.util.logging.Logger;

import org.eclipse.draw3d.camera.CameraPosition;
import org.eclipse.draw3d.camera.ICamera;
import org.eclipse.swt.widgets.Display;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @version $Revision$
 * @since May 22, 2011
 */
public class TrackingShot extends TimerTask {
	/**
	 * Logger for this class
	 */
	@SuppressWarnings("unused") //$NON-NLS-1$
	private static final Logger log = Logger.getLogger(TrackingShot.class.getName());

	/**
	 * The duration of the shot in mili seconds.
	 */
	long duration;

	/**
	 * The camera used.
	 */
	ICamera camera;

	/**
	 * The move of this tracking shot.
	 */
	ICameraMove move;

	/**
	 * Internal state indicating first run
	 */
	long firstRun = -1;
	
	/**
	 * Internal helper variable storing camera position.
	 */
	CameraPosition cameraPosition;
	
	/**
	 * Internal helper variable storing last tick.
	 */
	float prevTick;

	/**
	 * @param i_duration
	 * @param i_camera
	 */
	public TrackingShot(long i_duration, ICamera i_camera, ICameraMove i_move) {
		duration = i_duration;
		camera = i_camera;
		move = i_move;
		cameraPosition = new CameraPosition();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.TimerTask#run()
	 */
	@Override
	public void run() {
		try {
		long current = System.currentTimeMillis();
		if (firstRun == -1) {
			firstRun = current;
			prevTick = -1f;
		}
		long delta = current - firstRun;
		float currentTick = (float) delta / (float) duration;
		if (currentTick > 1f)
			currentTick = 1f;

		camera.getCameraPosition(cameraPosition);
		move.updateCameraPosition(cameraPosition, prevTick, currentTick);

		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				camera.setCameraPosition(cameraPosition);
			}
		});

		if (currentTick == 1f)
			cancel();
		prevTick = currentTick;
		} catch (RuntimeException t) {
			cancel();
			throw t;
		}
	}

}
