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
package org.eclipse.draw3d;

import java.util.logging.Logger;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Matrix4f;
import org.eclipse.draw3d.geometry.Matrix4fImpl;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;
import org.eclipse.draw3d.util.Draw3DCache;

/**
 * An abstract base implementation of a surface.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 13.07.2009
 */
public abstract class AbstractSurface implements ISurface {

	@SuppressWarnings("unused")
	private final Logger log = Logger.getLogger(getClass().getName());

	/**
	 * Caches the last projection. The first array element is the world
	 * location, the second is the 3D surface location.
	 */
	private Vector3f[] m_cachedProjection;

	/**
	 * The surface normal in world coordinates.
	 */
	private Vector3f m_normal = new Vector3fImpl();

	/**
	 * Indicates whether the surface normal is still valid.
	 */
	private boolean m_normalValid = false;

	/**
	 * The up vector in world coordinates.
	 */
	private Vector3f m_upVector = new Vector3fImpl();

	/**
	 * Indicates whether the up vector is still valid.
	 */
	private boolean m_upVectorValid = false;

	/**
	 * The matrix that transforms a vector given in surface coordinates to world
	 * coordinates.
	 */
	private Matrix4f m_surfaceToWorld = new Matrix4fImpl();

	private boolean m_surfaceToWorldValid = false;

	/**
	 * The matrix that transforms a vector given in world coordinates to surface
	 * coordinates.
	 */
	private Matrix4f m_worldToSurface = new Matrix4fImpl();

	private boolean m_worldToSurfaceValid = false;

	/**
	 * Calculates the normal of this surface.
	 * 
	 * @param io_normal the result vector, this argument is never
	 *            <code>null</code>
	 */
	protected abstract void calculateNormal(Vector3f io_normal);

	/**
	 * Calculates the up vector of this surface. As the up vector is usually the
	 * y-axis, this method calls {@link #getYAxis(Vector3f)} by default and
	 * negates the result.
	 * 
	 * @param i_upVector
	 */
	protected void calculateUpVector(Vector3f o_upVector) {
		getYAxis(o_upVector);
		Math3D.negate(o_upVector, o_upVector);
	}

	/**
	 * This method must be called whenever the surface coordinate system has
	 * changed.
	 */
	protected void coordinateSystemChanged() {

		m_surfaceToWorldValid = false;
		m_worldToSurfaceValid = false;
		m_normalValid = false;
		m_upVectorValid = false;
		m_cachedProjection = null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.ISurface#getNormal()
	 */
	public IVector3f getNormal() {

		if (!m_normalValid) {
			calculateNormal(m_normal);
			m_normalValid = true;
		}

		return m_normal;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.ISurface#getUpVector()
	 */
	public IVector3f getUpVector() {
		if (!m_upVectorValid) {
			calculateUpVector(m_upVector);
			m_upVectorValid = true;
		}

		return m_upVector;
	}

	/**
	 * Returns the origin of this surface.
	 * 
	 * @param io_result the result vector, if <code>null</code>, a new vector
	 *            will be returned
	 * @return a vector pointing to the origin of this surface
	 */
	protected abstract Vector3f getOrigin(Vector3f io_result);

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.ISurface#getSurfaceLocation2D(float, float,
	 *      float, org.eclipse.draw2d.geometry.Point)
	 */
	public Point getSurfaceLocation2D(float i_wx, float i_wy, float i_wz,
		Point io_result) {

		Vector3f w = Draw3DCache.getVector3f();
		try {
			w.set(i_wx, i_wy, i_wz);
			return getSurfaceLocation2D(w, io_result);
		} finally {
			Draw3DCache.returnVector3f(w);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.ISurface#getSurfaceLocation2D(org.eclipse.draw3d.geometry.IVector3f,
	 *      org.eclipse.draw3d.geometry.IVector3f,
	 *      org.eclipse.draw2d.geometry.Point)
	 */
	public Point getSurfaceLocation2D(IVector3f i_rayOrigin,
		IVector3f i_rayDirection, Point io_result) {

		Point result = io_result;
		if (result == null)
			result = new Point();

		Vector3f sLocation = Draw3DCache.getVector3f();
		try {
			getSurfaceLocation3D(i_rayOrigin, i_rayDirection, sLocation);

			result.x = (int) sLocation.getX();
			result.y = (int) sLocation.getY();

			return result;
		} finally {
			Draw3DCache.returnVector3f(sLocation);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.ISurface#getSurfaceLocation2D(org.eclipse.draw3d.geometry.IVector3f,
	 *      org.eclipse.draw2d.geometry.Point)
	 */
	public Point getSurfaceLocation2D(IVector3f i_world, Point io_result) {

		Point result = io_result;
		if (result == null)
			result = new Point();

		Vector3f vector = Draw3DCache.getVector3f();
		try {
			validateWorldToSurface();
			vector.set(i_world);
			vector.transform(m_worldToSurface);

			result.x = (int) vector.getX();
			result.y = (int) vector.getY();

			return result;
		} finally {
			Draw3DCache.returnVector3f(vector);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.ISurface#getSurfaceLocation3D(float, float,
	 *      float, org.eclipse.draw3d.geometry.Vector3f)
	 */
	public Vector3f getSurfaceLocation3D(float i_wx, float i_wy, float i_wz,
		Vector3f io_result) {

		Vector3f w = Draw3DCache.getVector3f();
		try {
			w.set(i_wx, i_wy, i_wz);
			return getSurfaceLocation3D(w, io_result);
		} finally {
			Draw3DCache.returnVector3f(w);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.ISurface#getSurfaceLocation3D(org.eclipse.draw3d.ISurface,
	 *      org.eclipse.draw3d.geometry.Vector3f,
	 *      org.eclipse.draw3d.geometry.Vector3f)
	 */
	public Vector3f getSurfaceLocation3D(ISurface i_reference,
		Vector3f i_surface, Vector3f io_result) {

		Vector3f w = Draw3DCache.getVector3f();
		try {
			i_reference.getWorldLocation(i_surface, w);
			return getSurfaceLocation3D(w, io_result);
		} finally {
			Draw3DCache.returnVector3f(w);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.ISurface#getSurfaceLocation3D(org.eclipse.draw3d.geometry.IVector3f,
	 *      org.eclipse.draw3d.geometry.IVector3f,
	 *      org.eclipse.draw3d.geometry.Vector3f)
	 */
	public Vector3f getSurfaceLocation3D(IVector3f i_rayOrigin,
		IVector3f i_rayDirection, Vector3f io_result) {

		Vector3f p = Draw3DCache.getVector3f();
		Vector3f n = Draw3DCache.getVector3f();
		Vector3f w = Draw3DCache.getVector3f();

		try {
			getOrigin(p);
			getZAxis(n);

			Math3D.rayIntersectsPlane(i_rayOrigin, i_rayDirection, p, n, w);
			if (w == null)
				return null;

			return getSurfaceLocation3D(w, io_result);
		} finally {
			Draw3DCache.returnVector3f(p, n, w);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.ISurface#getSurfaceLocation3D(org.eclipse.draw3d.geometry.IVector3f,
	 *      org.eclipse.draw3d.geometry.Vector3f)
	 */
	public Vector3f getSurfaceLocation3D(IVector3f i_world, Vector3f io_result) {

		Vector3f result = io_result;
		if (result == null)
			result = new Vector3fImpl();

		if (m_cachedProjection != null && i_world.equals(m_cachedProjection[0])) {
			result.set(m_cachedProjection[1]);
			return result;
		}

		validateWorldToSurface();
		result.set(i_world);
		result.transform(m_worldToSurface);

		setCachedProjection(i_world, result);
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.ISurface#getWorldDimension(org.eclipse.draw2d.geometry.Dimension,
	 *      org.eclipse.draw3d.geometry.Vector3f)
	 */
	public Vector3f getWorldDimension(Dimension i_surface, Vector3f o_result) {

		Vector3f start = Draw3DCache.getVector3f();
		Vector3f end = Draw3DCache.getVector3f();
		try {
			getWorldLocation(0, 0, 0, start);
			getWorldLocation(i_surface.width, i_surface.height, 0, end);
			return Math3D.sub(end, start, o_result);
		} finally {
			Draw3DCache.returnVector3f(start);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.ISurface#getWorldLocation(float, float, float,
	 *      org.eclipse.draw3d.geometry.Vector3f)
	 */
	public Vector3f getWorldLocation(float i_sx, float i_sy, float i_sz,
		Vector3f io_result) {

		Vector3f s = Draw3DCache.getVector3f();
		try {
			s.set(i_sx, i_sy, i_sz);
			return getWorldLocation(s, io_result);
		} finally {
			Draw3DCache.returnVector3f(s);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.ISurface#getWorldLocation(org.eclipse.draw3d.geometry.IVector3f,
	 *      org.eclipse.draw3d.geometry.Vector3f)
	 */
	public Vector3f getWorldLocation(IVector3f i_surface, Vector3f io_result) {

		Vector3f result = io_result;
		if (result == null)
			result = new Vector3fImpl();

		if (m_cachedProjection != null
			&& i_surface.equals(m_cachedProjection[1])) {
			result.set(m_cachedProjection[0]);
			return result;
		}

		result.set(i_surface);
		validateSurfaceToWorld();
		result.transform(m_surfaceToWorld);

		setCachedProjection(result, i_surface);
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.ISurface#getWorldLocation(org.eclipse.draw2d.geometry.Point,
	 *      org.eclipse.draw3d.geometry.Vector3f)
	 */
	public Vector3f getWorldLocation(Point i_surface, Vector3f io_result) {

		return getWorldLocation(i_surface.x, i_surface.y, 0, io_result);
	}

	/**
	 * Returns the X axis vector of this surface. The returned vector is
	 * normalized.
	 * 
	 * @param io_result the result vector, if <code>null</code>, a new vector
	 *            will be returned
	 * @return the X axis vector
	 */
	protected abstract Vector3f getXAxis(Vector3f io_result);

	/**
	 * Returns the Y axis vector of this surface. The returned vector is
	 * normalized.
	 * 
	 * @param io_result the result vector, if <code>null</code>, a new vector
	 *            will be returned
	 * @return the Y axis vector
	 */
	protected abstract Vector3f getYAxis(Vector3f io_result);

	/**
	 * Returns the Z axis vector of this surface. The returned vector is
	 * normalized.
	 * 
	 * @param io_result the result vector, if <code>null</code>, a new vector
	 *            will be returned
	 * @return the Z axis vector
	 */
	protected abstract Vector3f getZAxis(Vector3f io_result);

	private void setCachedProjection(IVector3f i_world, IVector3f i_surface) {

		if (m_cachedProjection == null) {
			m_cachedProjection =
				new Vector3f[] { new Vector3fImpl(i_world),
					new Vector3fImpl(i_surface) };
		} else {
			m_cachedProjection[0].set(i_world);
			m_cachedProjection[1].set(i_surface);
		}
	}

	private void validateSurfaceToWorld() {

		if (m_surfaceToWorldValid)
			return;

		Vector3f origin = Draw3DCache.getVector3f();
		Vector3f xAxis = Draw3DCache.getVector3f();
		Vector3f yAxis = Draw3DCache.getVector3f();
		Vector3f zAxis = Draw3DCache.getVector3f();
		try {
			getXAxis(xAxis);
			getYAxis(yAxis);
			getZAxis(zAxis);
			getOrigin(origin);

			m_surfaceToWorld.set(0, 0, xAxis.getX());
			m_surfaceToWorld.set(0, 1, xAxis.getY());
			m_surfaceToWorld.set(0, 2, xAxis.getZ());
			m_surfaceToWorld.set(0, 3, 0);

			m_surfaceToWorld.set(1, 0, yAxis.getX());
			m_surfaceToWorld.set(1, 1, yAxis.getY());
			m_surfaceToWorld.set(1, 2, yAxis.getZ());
			m_surfaceToWorld.set(1, 3, 0);

			m_surfaceToWorld.set(2, 0, zAxis.getX());
			m_surfaceToWorld.set(2, 1, zAxis.getY());
			m_surfaceToWorld.set(2, 2, zAxis.getZ());
			m_surfaceToWorld.set(2, 3, 0);

			m_surfaceToWorld.set(3, 0, origin.getX());
			m_surfaceToWorld.set(3, 1, origin.getY());
			m_surfaceToWorld.set(3, 2, origin.getZ());
			m_surfaceToWorld.set(3, 3, 1);

			m_surfaceToWorldValid = true;
		} finally {
			Draw3DCache.returnVector3f(origin, xAxis, yAxis, zAxis);
		}
	}

	private void validateWorldToSurface() {

		if (m_worldToSurfaceValid)
			return;

		validateSurfaceToWorld();
		Math3D.invert(m_surfaceToWorld, m_worldToSurface);

		m_worldToSurfaceValid = true;
	}

}
