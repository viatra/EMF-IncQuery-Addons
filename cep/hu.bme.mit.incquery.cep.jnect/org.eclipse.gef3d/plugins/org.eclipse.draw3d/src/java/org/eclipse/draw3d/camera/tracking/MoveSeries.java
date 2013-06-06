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

import java.util.List;

import org.eclipse.draw3d.camera.CameraPosition;

/**
 * A series of camera moves, executed one after the other. Each move is added
 * with a relative weight.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @version $Revision$
 * @since May 22, 2011
 */
public abstract class MoveSeries implements ICameraMove {

	List<Float> weights;

	List<ICameraMove> moves;

	List<Float> startTicks;

	List<Float> relativeDurations;

	public void addCameraMove(ICameraMove move, float weight) {
		if (weight <= 0) // parameter precondition
			throw new IllegalArgumentException("Weight must be greater than 0");

		weights.add(weight);
		moves.add(move);
		updateStartTicks();
	}

	/**
	 * 
	 */
	protected void updateStartTicks() {
		startTicks.clear();
		relativeDurations.clear();

		// calculate total duration
		float totalWeight = 0;
		for (float weight : weights) {
			totalWeight += weight;
		}

		// calculate start ticks for each connected track
		float passedDuration = 0;
		float relativeDuration;
		for (int i = 0; i < weights.size(); i++) {
			startTicks.add(passedDuration);
			relativeDuration = weights.get(i) / totalWeight;
			passedDuration += relativeDuration;
			relativeDurations.add(relativeDuration);
		}

	}
	
	

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.tracking.ICameraMove#updateCameraPosition(org.eclipse.draw3d.camera.CameraPosition,
	 *      float, float)
	 */
	public void updateCameraPosition(CameraPosition io_cameraPosition,
		float prevTick, float currentTick) {

		int currentMoveNumber = findMove(currentTick);
		int prevMoveNumber = findMove(prevTick);

		if (prevMoveNumber >= 0 && currentMoveNumber != prevMoveNumber) {
			float relativePrevTick =
				makeTickRelative(prevTick, prevMoveNumber);
			if (relativePrevTick != 1f) {
				moves.get(prevMoveNumber).updateCameraPosition(
					io_cameraPosition, relativePrevTick, 1f);
			}
		}

		float relativePrevTick = makeTickRelative(prevTick, currentMoveNumber);
		float relativeCurrentTick =
			makeTickRelative(currentTick, currentMoveNumber);
		moves.get(currentMoveNumber).updateCameraPosition(
			io_cameraPosition, relativePrevTick, relativeCurrentTick);
	}

	/**
	 * <pre>
	 * .........s......................s+d.........
	 *          0......................1 
	 *   			  t
	 * </pre>
	 * 
	 * @param i_prevTick
	 * @param i_prevMoveNumber
	 * @return
	 */
	protected float makeTickRelative(float i_Tick, int i_MoveNumber) {
		// short cut, ensures 1f is reached
		if (i_Tick == 1f)
			return 1f;
		
		float relativeDuration = relativeDurations.get(i_MoveNumber);
		float tick =
			(i_Tick - startTicks.get(i_MoveNumber)) / relativeDuration;
		if (tick < 0)
			return -1f;
		if (tick > 1)
			tick = 1f;
		return tick;
	}

	/**
	 * @param i_lastTick
	 * @return
	 */
	protected int findMove(float i_tick) {
		if (i_tick < 0)
			return -1;
		if (i_tick > 1f)
			return moves.size() - 1;

		for (int i = moves.size() - 1; i > 0; i--) {
			if (startTicks.get(i) <= i_tick) {
				return i;
			}
		}
		return 0;

	}

}
