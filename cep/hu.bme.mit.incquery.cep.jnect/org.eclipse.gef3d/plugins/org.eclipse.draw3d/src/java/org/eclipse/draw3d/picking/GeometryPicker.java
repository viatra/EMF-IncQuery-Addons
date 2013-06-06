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

import java.util.logging.Logger;

import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw3d.IFigure3D;
import org.eclipse.draw3d.IScene;
import org.eclipse.draw3d.ISurface;
import org.eclipse.draw3d.camera.ICamera;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.util.Draw3DCache;

/**
 * GeometryPicker There should really be more documentation here.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 31.07.2009
 */
public class GeometryPicker implements Picker {

	// @SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(GeometryPicker.class
		.getName());

	private ISurface m_currentSurface;

	private IFigure3D m_rootFigure;

	private IScene m_scene;

	private TreeSearch m_surfaceSearch;

	/**
	 * Creates a new picker for the given scene.
	 * 
	 * @param i_scene the scene in which the pickable figures are displayed
	 * @throws NullPointerException if the given scene is <code>null</code>
	 */
	public GeometryPicker(IScene i_scene) {

		if (i_scene == null)
			throw new NullPointerException("i_scene must not be null");

		m_scene = i_scene;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.picking.Picker#getCurrentSurface()
	 */
	public ISurface getCurrentSurface() {

		if (m_currentSurface == null)
			return m_rootFigure.getSurface();

		return m_currentSurface;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.picking.Picker#getHit(int, int)
	 */
	public Hit getHit(int i_mx, int i_my) {

		return getHit(i_mx, i_my, null);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.picking.Picker#getHit(int, int,
	 *      org.eclipse.draw2d.TreeSearch)
	 */
	public Hit getHit(int i_mx, int i_my, TreeSearch i_search) {

		Vector3f rayPoint = Draw3DCache.getVector3f();
		try {
			ICamera camera = m_scene.getCamera();
			camera.unProject(i_mx, i_my, 0, null, rayPoint);

			return getHit(rayPoint, i_search);
		} finally {
			Draw3DCache.returnVector3f(rayPoint);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.picking.Picker#getHit(org.eclipse.draw3d.geometry.IVector3f)
	 */
	public Hit getHit(IVector3f i_rayPoint) {

		return getHit(i_rayPoint, (TreeSearch) null);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.picking.Picker#getHit(org.eclipse.draw3d.geometry.IVector3f,
	 *      org.eclipse.draw3d.geometry.IVector3f)
	 */
	public Hit getHit(IVector3f i_rayOrigin, IVector3f i_rayDirection) {

		return getHit(i_rayOrigin, i_rayDirection, null);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.picking.Picker#getHit(org.eclipse.draw3d.geometry.IVector3f,
	 *      org.eclipse.draw3d.geometry.IVector3f,
	 *      org.eclipse.draw2d.TreeSearch)
	 */
	public Hit getHit(IVector3f i_rayOrigin, IVector3f i_rayDirection,
		TreeSearch i_search) {

		if (i_rayOrigin == null)
			throw new NullPointerException("i_rayOrigin must not be null");

		if (i_rayDirection == null)
			throw new NullPointerException("i_rayDirection must not be null");

		Query query =
			new Query(i_rayOrigin, i_rayDirection, m_rootFigure, i_search);
		query.setDebug(m_scene.isDebug());

		return query.execute();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.picking.Picker#getHit(org.eclipse.draw3d.geometry.IVector3f,
	 *      org.eclipse.draw2d.TreeSearch)
	 */
	public Hit getHit(IVector3f i_rayPoint, TreeSearch i_search) {

		if (i_rayPoint == null)
			throw new NullPointerException("i_rayPoint must not be null");

		Vector3f rayOrigin = Draw3DCache.getVector3f();
		Vector3f rayDirection = Draw3DCache.getVector3f();
		try {
			ICamera camera = m_scene.getCamera();
			camera.getPosition(rayOrigin);

			if (rayOrigin.equals(i_rayPoint)) {
				// throw new IllegalArgumentException(
				// "rayPoint must not be equal to the camera position");
				log.warning("rayPoint must not be equal to the camera position");
				return null;
			}

			Math3D.getRayDirection(rayOrigin, i_rayPoint, rayDirection);
			return getHit(rayOrigin, rayDirection, i_search);
		} finally {
			Draw3DCache.returnVector3f(rayOrigin, rayDirection);
		}
	}

	/**
	 * Sets the root figure.
	 * 
	 * @param i_rootFigure the root figure
	 */
	public void setRootFigure(IFigure3D i_rootFigure) {

		m_rootFigure = i_rootFigure;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.picking.Picker#setSurfaceSearch(org.eclipse.draw2d.TreeSearch)
	 */
	public void setSurfaceSearch(TreeSearch i_search) {

		m_surfaceSearch = i_search;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.picking.Picker#updateCurrentSurface(int, int)
	 */
	public void updateCurrentSurface(int i_mx, int i_my) {

		Hit hit = getHit(i_mx, i_my, m_surfaceSearch);
		if (hit != null) {
			ISurface surface = hit.getFigure3D().getSurface();
			if (surface != null)
				m_currentSurface = surface;
		}
	}
}
