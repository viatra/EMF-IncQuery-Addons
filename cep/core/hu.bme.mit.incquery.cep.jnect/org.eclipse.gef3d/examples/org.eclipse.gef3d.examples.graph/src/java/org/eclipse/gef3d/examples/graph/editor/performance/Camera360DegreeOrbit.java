/*******************************************************************************
 * Copyright (c) 2009 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.examples.graph.editor.performance;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.TimerTask;

import org.eclipse.draw3d.IScene;
import org.eclipse.draw3d.camera.ICamera;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;
import org.eclipse.swt.widgets.Display;



/**
 * CameraRotationTrack There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Feb 16, 2009
 */
public class Camera360DegreeOrbit extends TimerTask {
	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger.getLogger(Camera360DegreeOrbit.class.getName());
	
	ICamera camera;
	
	Vector3f startPos;
	Vector3f upVector;
	Vector3f center;
	
	float angle;
	
	long startTime;

	float frames = 120;
	float step = (float) ((Math.PI*2) / frames);
	
	float renderedFrames = 0;
	
	public Camera360DegreeOrbit(IScene scene) {
		upVector = new Vector3fImpl(0,0,1);
		startPos = new Vector3fImpl(400, 25000, -1000);
		center = new Vector3fImpl  (400, 400, 10000);
		
		camera = scene.getCamera();
		camera.moveTo(startPos);
		camera.lookAt(center, upVector);
		angle = 0;
		startTime = System.currentTimeMillis();
	}

	@Override
	public void run() {
		Display.getDefault().asyncExec(new Runnable() {

			public void run() {
				camera.orbit(center, step, 0);
				renderedFrames++;
				if (renderedFrames>=frames) {
					long endTime = System.currentTimeMillis();
					long duration = endTime - startTime;

					float fps = 1000 * (float)frames / (float)duration;
					
					if (log.isLoggable(Level.INFO)) {
						log.info("FPS: " + fps);
					}
				}
				
			}
		});

		angle += step;
		if (angle>Math.PI*2) {
			cancel();
		}
			



	}

}
