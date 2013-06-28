/*******************************************************************************
 * Copyright (c) 2009 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.picking;

import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw3d.ISurface;
import org.eclipse.draw3d.geometry.IVector3f;

/**
 * A picker allows picking of 3D figures using mouse coordinates.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 31.07.2009
 */
public interface Picker {

	/**
	 * Returns the current surface.
	 * 
	 * @return the current surface
	 */
	public ISurface getCurrentSurface();

	/**
	 * Returns a hit for the figure at the given mouse coordinates.
	 * 
	 * @param i_mx the mouse X coordinate
	 * @param i_my the mouse Y coordinate
	 * @return the hit or <code>null</code> if no figure was hit at the given
	 *         coordinates
	 * @see Hit
	 */
	public Hit getHit(int i_mx, int i_my);

	/**
	 * Returns a hit for the figure at the given mouse coordinates. Only figures
	 * which are accepted and not pruned by the given search are considered.
	 * 
	 * @param i_mx the mouse X coordinate
	 * @param i_my the mouse Y coordinate
	 * @param i_search the search
	 * @return the hit or <code>null</code> if no figure was hit at the given
	 *         coordinates
	 * @see Hit
	 */
	public Hit getHit(int i_mx, int i_my, TreeSearch i_search);

	/**
	 * Returns a hit for a figure hit a given ray that has the camera position
	 * as its origin and that contains the given point.
	 * 
	 * @param i_rayPoint the point that is to be contained by the picking ray
	 * @return the hit or <code>null</code> if no figure was hit by the ray
	 * @see Hit
	 * @throws NullPointerException if the given vector is <code>null</code>
	 * @throws IllegalArgumentException if the given point is equal to the
	 *             camera position
	 */
	public Hit getHit(IVector3f i_rayPoint);

	/**
	 * Returns a hit for a figure hit by the given picking ray.
	 * 
	 * @param i_rayOrigin the origin of the picking ray
	 * @param i_rayDirection the direction of the picking ray, must be
	 *            normalised
	 * @return the hit or <code>null</code> if no figure was hit by the given
	 *         ray
	 * @see Hit
	 * @throws NullPointerException if any of the given vectors is
	 *             <code>null</code>
	 */
	public Hit getHit(IVector3f i_rayOrigin, IVector3f i_rayDirection);

	/**
	 * Returns a hit for a figure hit by the given picking ray. Only figures
	 * which are accepted and not pruned by the given search are considered.
	 * 
	 * @param i_rayOrigin the origin of the picking ray
	 * @param i_rayDirection the direction of the picking ray, must be
	 *            normalised
	 * @param i_search the search
	 * @return the hit or <code>null</code> if no figure was hit at the given
	 *         coordinates
	 * @see Hit
	 * @throws NullPointerException if any of the given vectors is
	 *             <code>null</code>
	 */
	public Hit getHit(IVector3f i_rayOrigin, IVector3f i_rayDirection,
		TreeSearch i_search);

	/**
	 * Returns a hit for a figure hit a given ray that has the camera position
	 * as its origin and that contains the given point. Only figures which are
	 * accepted and not pruned by the given search are considered.
	 * 
	 * @param i_rayPoint the point that is to be contained by the picking ray
	 * @param i_search the search
	 * @return the hit or <code>null</code> if no figure was hit by the ray
	 *         coordinates
	 * @see Hit
	 * @throws NullPointerException if the given vector is <code>null</code>
	 * @throws IllegalArgumentException if the given point is equal to the
	 *             camera position
	 */
	public Hit getHit(IVector3f i_rayPoint, TreeSearch i_search);

	/**
	 * Sets a tree search instance that is used when updating the current
	 * surface. Only figures accepted by the given search are considered when
	 * picking a surface.
	 * 
	 * @param i_search the search instance
	 */
	public void setSurfaceSearch(TreeSearch i_search);

	/**
	 * Updates the current surface.
	 * 
	 * @param i_mx the mouse X coordinate
	 * @param i_my the mouse Y coordinate
	 */
	public void updateCurrentSurface(int i_mx, int i_my);
}
