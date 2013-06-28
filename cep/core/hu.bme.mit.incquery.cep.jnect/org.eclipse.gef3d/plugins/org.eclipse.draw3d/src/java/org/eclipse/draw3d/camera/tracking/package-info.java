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

/**
 * Simple API for camera tracking shots.
 * 
 * <h3>Timing</h3>
 * A tracking shot {@link org.eclipse.draw3d.camera.tracking.TrackingShot}
 * executes a given {@link org.eclipse.draw3d.camera.tracking.ICameraMove} 
 * stepwise.
 * The duration of the whole shot is defined in the tracking shot in 
 * milliseconds, the move itself does not deal with absolute durations, 
 * instead a progress ticker is provided counting from 0.0 (start of move) to
 * 1.0 (end of move).
 * 
 * <h3>Combination of moves</h3> 
 * In order to simplify the implementation of camera moves, some basic moves
 * are provided for composing or concatenating single moves. A composed move
 * {@link org.eclipse.draw3d.camera.tracking.ComposedMove} executes all
 * sub moves simultaneously, enabling separate implementatoins for movement
 * (such as {@link org.eclipse.draw3d.camera.tracking.LinearMovement}) or
 * panning (such as {@link org.eclipse.draw3d.camera.tracking.LinearRotation}),
 * an example is given with {@link org.eclipse.draw3d.camera.tracking.LinearMove}.
 * A {@link org.eclipse.draw3d.camera.tracking.MoveSeries} executes the sub-moves
 * one after the other, each sub-move is added wiath a given weight for timing.
 * 
 * <h3>Computing start and end position</h3>
 * Usually, the start position of a move is the current camera position. For
 * computing some special end positions, such as positions looking directly
 * on a given figure, {@link org.eclipse.draw3d.camera.tracking.TrackingUtil}
 * provides some methods (and will probably be extended as needed).
 * 
 * <h3>Running a tracking shot</h3>
 * At this moment, a tracking shot is simply run as a timer task by the
 * {@link java.util.Timer} class. A default tracking shot, moving the camera
 * in front of a double clicked figure, is implemented in
 * {@link org.eclipse.draw3d.ui.camera.CameraInputHandler.doubleClick(int, int, int, int)}.
 * The following code snippet stems from this class:
 * <pre>
 * TrackingShot shot = new TrackingShot(duration, getCamera(), move);
 * java.util.Timer timer=new Timer();
 * timer.schedule(shot, 0, 50);
 * </pre>
 * This may be not the best way, feel free to improve that mechanism.
 *  
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since   May 23 2001 	
 */
package org.eclipse.draw3d.camera.tracking;

