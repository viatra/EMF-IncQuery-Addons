/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - refactoring and cleanup, orbit
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.camera;

import java.nio.FloatBuffer;
import java.util.Timer;
import java.util.logging.Logger;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw3d.RenderContext;
import org.eclipse.draw3d.camera.tracking.TrackingShot;
import org.eclipse.draw3d.geometry.IMatrix4f;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Math3DCache;
import org.eclipse.draw3d.geometry.Matrix4f;
import org.eclipse.draw3d.geometry.Matrix4fImpl;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;
import org.eclipse.draw3d.geometryext.Ray;
import org.eclipse.draw3d.graphics3d.Graphics3D;
import org.eclipse.draw3d.graphics3d.Graphics3DDraw;
import org.eclipse.draw3d.util.Draw3DCache;

/**
 * Implements ICamera interface using a "first person" view strategy. lookAt and
 * orbit are expensive!
 * <p>
 * This camera behaves like a camera in first-person shooters, except an orbit
 * feature is implemented .
 * </p>
 * 
 * @author Jens von Pilgrim
 * @author Kristian Duske
 * @version $Revision$
 * @since 19.11.2007
 */
public class FirstPersonCamera extends AbstractCamera {

	/**
	 * Serves as a cache for the last projection operation.
	 * 
	 * @author Kristian Duske
	 * @version $Revision$
	 * @since 28.07.2009
	 */
	private static class Projection {

		private float m_depth;

		private Point m_mLocation = new Point();

		private Matrix4f m_modelMatrix = new Matrix4fImpl();

		private boolean m_valid = false;

		private Vector3f m_wLocation = new Vector3fImpl();

		/**
		 * 
		 */
		Projection() {
		}

		/**
		 * Returns the cached mouse location.
		 * 
		 * @param io_result the result point, if <code>null</code>, a new point
		 *            will be returned
		 * @return the cached mouse location
		 */
		public Point getMouseLocation(Point io_result) {

			Point result = io_result;
			if (result == null)
				result = new Point();

			result.setLocation(m_mLocation);
			return result;
		}

		/**
		 * Returns the cached world location.
		 * 
		 * @param io_result the result vector, if <code>null</code>, a new
		 *            vector will be returned
		 * @return the cached world location
		 */
		public Vector3f getWorldLocation(Vector3f io_result) {

			Vector3f result = io_result;
			if (result == null)
				result = new Vector3fImpl();

			result.set(m_wLocation);
			return result;
		}

		/**
		 * Indicates whether the cached mouse location is up to date for the
		 * given world location and model matrix.
		 * 
		 * @param i_wx the world X coordinate
		 * @param i_wy the world Y coordinate
		 * @param i_wz the world Z coordinate
		 * @param i_modelMatrix the model matrix
		 * @return <code>true</code> if the cached mouse location is up to date
		 *         for the given world location and model matrix
		 */
		public boolean hasMouseLocation(float i_wx, float i_wy, float i_wz,
			IMatrix4f i_modelMatrix) {

			if (!m_valid)
				return false;

			if (i_wx != m_wLocation.getX() || i_wy != m_wLocation.getY()
				|| i_wz != m_wLocation.getY())
				return false;

			if (i_modelMatrix == null) {
				if (!m_modelMatrix.equals(IMatrix4f.IDENTITY))
					return false;
			} else {
				if (!i_modelMatrix.equals(m_modelMatrix))
					return false;
			}

			return true;
		}

		/**
		 * Indicates whether the cached world location is up to date for the
		 * given mouse location and model matrix.
		 * 
		 * @param i_mx the mouse X coordinate
		 * @param i_my the mouse Y coordinate
		 * @param i_depth the depth value
		 * @param i_modelMatrix the model matrix
		 * @return <code>true</code> if the cached world location location is up
		 *         to date for the given mouse location and model matrix
		 */
		public boolean hasWorldLocation(int i_mx, int i_my, float i_depth,
			IMatrix4f i_modelMatrix) {

			if (!m_valid)
				return false;

			if (i_mx != m_mLocation.x || i_my != m_mLocation.y
				|| i_depth != m_depth)
				return false;

			if (i_modelMatrix == null) {
				if (!m_modelMatrix.equals(IMatrix4f.IDENTITY))
					return false;
			} else {
				if (!i_modelMatrix.equals(m_modelMatrix))
					return false;
			}

			return true;
		}

		/**
		 * Invalidates the cached values.
		 */
		public void invalidate() {

			m_valid = false;
		}

		/**
		 * Updates the cached projection input and output values and the model
		 * matrix to the given values.
		 * 
		 * @param i_wx the world X coordinate
		 * @param i_wy the world Y coordinate
		 * @param i_wz the world Z coordinate
		 * @param i_mx the mouse X coordinate
		 * @param i_my the mouse Z coordinate
		 * @param i_depth the depth value
		 * @param i_modelMatrix the model matrix
		 */
		public void update(float i_wx, float i_wy, float i_wz, int i_mx,
			int i_my, float i_depth, IMatrix4f i_modelMatrix) {

			m_wLocation.set(i_wx, i_wy, i_wz);
			m_mLocation.x = i_mx;
			m_mLocation.y = i_my;
			m_depth = i_depth;

			if (i_modelMatrix == null)
				m_modelMatrix.setIdentity();
			else
				m_modelMatrix.set(i_modelMatrix);

			m_valid = true;
		}
	}

	@SuppressWarnings("unused")
	private static Logger log =
		Logger.getLogger(FirstPersonCamera.class.getName());

	private Projection m_cachedProjection = new Projection();

	/**
	 * Distance of the far clipping plane.
	 */
	protected int m_far = 10000;

	/**
	 * The field of vision angle in degrees.
	 */
	protected int m_fov = 45;

	private boolean m_matricesValid = false;

	/**
	 * Distance of the near clipping plane.
	 */
	protected int m_near = 100;

	/**
	 * The current camera position.
	 */
	protected final Vector3fImpl m_position = new Vector3fImpl();

	private final Matrix4fImpl m_projectionMatrix = new Matrix4fImpl();

	/**
	 * The current camera right vector.
	 */
	protected final Vector3fImpl m_right = new Vector3fImpl();

	/**
	 * The current camera up vector.
	 */
	protected final Vector3fImpl m_up = new Vector3fImpl();

	/**
	 * The current viewing direction.
	 */
	protected final Vector3fImpl m_viewDir = new Vector3fImpl();

	private final Matrix4fImpl m_viewMatrix = new Matrix4fImpl();

	/**
	 * The current viewport.
	 */
	protected final Rectangle m_viewport = new Rectangle();
	
	protected Timer timer;

	/**
	 * Creates and initializes a first person camera.
	 */
	public FirstPersonCamera() {
		reset();
	}
	
	private IMatrix4f calculateInversionMatrix(IMatrix4f i_modelMatrix,
		Matrix4f io_result) {

		calculateMatrix(i_modelMatrix, io_result);

		Math3D.invert(io_result, io_result);
		return io_result;
	}

	private IMatrix4f calculateMatrix(IMatrix4f i_modelMatrix,
		Matrix4f io_result) {

		Matrix4f tmp = Math3DCache.getMatrix4f();
		try {
			if (i_modelMatrix != null)
				Math3D.mul(m_projectionMatrix, i_modelMatrix, tmp);
			else
				tmp.set(m_projectionMatrix);

			Math3D.mul(tmp, m_viewMatrix, io_result);
			return io_result;
		} finally {
			Math3DCache.returnMatrix4f(tmp);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.AbstractCamera#fireCameraChanged()
	 */
	@Override
	protected void fireCameraChanged() {

		m_matricesValid = false;
		m_cachedProjection.invalidate();
		super.fireCameraChanged();
	}

	private float getAspect() {

		if (m_viewport.height == 0)
			return 0;

		return m_viewport.width / (float) m_viewport.height;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.ICamera#getDistance(org.eclipse.draw3d.geometry.Vector3f)
	 */
	public float getDistance(IVector3f i_point) {

		if (i_point == null)
			throw new NullPointerException("i_point must not be null");

		Vector3f tmp = Math3DCache.getVector3f();
		try {
			Math3D.sub(i_point, m_position, tmp);
			return tmp.length();
		} finally {
			Math3DCache.returnVector3f(tmp);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.ICamera#getNear()
	 */
	public float getNear() {

		return m_near;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.ICamera#getPosition(Vector3f)
	 */
	public Vector3f getPosition(Vector3f io_result) {

		Vector3f result = io_result;
		if (result == null)
			result = new Vector3fImpl();

		result.set(m_position);
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.ICamera#getRay(int, int,
	 *      org.eclipse.draw3d.geometryext.Ray)
	 */
	public Ray getRay(int i_xm, int i_ym, Ray io_result) {

		Ray result = io_result;
		if (result == null)
			result = new Ray();

		Vector3f direction = Math3DCache.getVector3f();
		try {
			unProject(i_xm, i_ym, 0, null, direction);
			Math3D.sub(direction, m_position, direction);

			result.set(m_position, direction);
			return result;
		} finally {
			Math3DCache.returnVector3f(direction);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.ICamera#getRightVector(org.eclipse.draw3d.geometry.Vector3f)
	 */
	public Vector3f getRightVector(Vector3f io_result) {

		Vector3f result = io_result;
		if (result == null)
			result = new Vector3fImpl();

		result.set(m_right);
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.ICamera#getUpVector(org.eclipse.draw3d.geometry.Vector3f)
	 */
	public Vector3f getUpVector(Vector3f io_result) {

		Vector3f result = io_result;
		if (result == null)
			result = new Vector3fImpl();

		result.set(m_up);
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.ICamera#getViewDirection(org.eclipse.draw3d.geometry.Vector3f)
	 */
	public Vector3f getViewDirection(Vector3f io_result) {

		Vector3f result = io_result;
		if (result == null)
			result = new Vector3fImpl();

		result.set(m_viewDir);
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.ICamera#lookAt(org.eclipse.draw3d.geometry.IVector3f,
	 *      org.eclipse.draw3d.geometry.IVector3f)
	 */
	public void lookAt(IVector3f i_to, IVector3f i_upvector) {

		Math3D.sub(i_to, m_position, m_viewDir);
		Math3D.normalise(m_viewDir, m_viewDir);
		if (i_upvector != null)
			Math3D.normalise(i_upvector, m_up);

		// p+v=t => v = t-p
		Math3D.cross(m_up, m_viewDir, m_right);

		fireCameraChanged();
	}

	/**
	 * Moves the camera by the given distances.
	 * 
	 * @param i_dX the distance on the X axis
	 * @param i_dY the distance on the Y axis
	 * @param i_dZ the distance on the Z axis
	 */
	public void moveBy(float i_dForward, float i_dStrafe, float i_dUp) {

		Vector3f tmp = Math3DCache.getVector3f();
		try {
			tmp.set(m_viewDir);
			tmp.scale(i_dForward);
			Math3D.add(m_position, tmp, m_position);

			tmp.set(m_right);
			tmp.scale(i_dStrafe);
			Math3D.add(m_position, tmp, m_position);

			tmp.set(m_up);
			tmp.scale(i_dUp);
			Math3D.add(m_position, tmp, m_position);

			fireCameraChanged();
		} finally {
			Math3DCache.returnVector3f(tmp);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.ICamera#moveTo(org.eclipse.draw3d.geometry.IVector3f)
	 */
	public void moveTo(IVector3f i_Position) {

		if (i_Position == null)
			throw new NullPointerException("i_viewPoint must not be null");

		m_position.set(i_Position);
		
		fireCameraChanged();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.ICamera#orbit(IVector3f, float, float)
	 */
	public void orbit(IVector3f i_center, float i_hAngle, float i_vAngle) {

		Matrix4f rot = Math3DCache.getMatrix4f();
		Vector3f tmp = Math3DCache.getVector3f();

		try {
			rot.setIdentity();
			if (i_hAngle != 0)
				Math3D.rotate(i_hAngle, m_up, rot, rot);

			if (i_vAngle != 0)
				Math3D.rotate(i_vAngle, m_right, rot, rot);

			// camera position
			Math3D.sub(m_position, i_center, tmp);
			tmp.transform(rot);
			Math3D.add(tmp, i_center, m_position);

			// view direction and reference vectors
			m_viewDir.transform(rot);
			m_right.transform(rot);
			m_up.transform(rot);

			fireCameraChanged();
		} finally {
			Math3DCache.returnMatrix4f(rot);
			Math3DCache.returnVector3f(tmp);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.ICamera#project(float, float, float,
	 *      org.eclipse.draw2d.geometry.Point)
	 */
	public Point project(float i_wx, float i_wy, float i_wz, Point io_result) {

		if (m_cachedProjection.hasMouseLocation(i_wx, i_wy, i_wz, null))
			return m_cachedProjection.getMouseLocation(io_result);

		Point result = io_result;
		if (result == null)
			result = new Point();

		Matrix4f transformation = Math3DCache.getMatrix4f();
		Vector3f tmp = Math3DCache.getVector3f();

		try {
			calculateMatrix(null, transformation);
			tmp.set(i_wx, i_wy, i_wz);

			tmp.transform(transformation);

			result.x = Math.round((tmp.getX() + 1) * m_viewport.width / 2f);
			result.y =
				Math.round((-1 * tmp.getY() + 1) * m_viewport.height / 2f);

			float depth = (tmp.getZ() + 1) / 2;
			m_cachedProjection.update(i_wx, i_wy, i_wz, result.x, result.y,
				depth, null);

			return result;
		} finally {
			Math3DCache.returnMatrix4f(transformation);
			Math3DCache.returnVector3f(tmp);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.ICamera#project(org.eclipse.draw3d.geometry.IVector3f,
	 *      org.eclipse.draw2d.geometry.Point)
	 */
	public Point project(IVector3f i_wLocation, Point io_result) {

		return project(i_wLocation.getX(), i_wLocation.getY(),
			i_wLocation.getZ(), io_result);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.ICamera#render(org.eclipse.draw3d.RenderContext)
	 */
	public void render(RenderContext renderContext) {

		Graphics3D g3d = renderContext.getGraphics3D();
		g3d.glViewport(0, 0, m_viewport.width, m_viewport.height);

		g3d.glMatrixMode(Graphics3DDraw.GL_PROJECTION);
		g3d.glLoadIdentity();

		g3d.gluPerspective(m_fov, getAspect(), m_near, m_far);

		g3d.glMatrixMode(Graphics3DDraw.GL_MODELVIEW);
		g3d.glLoadIdentity();

		float viewX = m_position.x + m_viewDir.x;
		float viewY = m_position.y + m_viewDir.y;
		float viewZ = m_position.z + m_viewDir.z;

		g3d.gluLookAt(m_position.x, m_position.y, m_position.z, viewX, viewY,
			viewZ, m_up.x, m_up.y, m_up.z);

		if (!m_matricesValid) {
			FloatBuffer buffer = Draw3DCache.getFloatBuffer(16);
			try {
				buffer.rewind();
				g3d.glGetFloat(Graphics3DDraw.GL_PROJECTION_MATRIX, buffer);
				m_projectionMatrix.setColumnMajor(buffer);
				Math3D.transpose(m_projectionMatrix, m_projectionMatrix);

				buffer.rewind();
				g3d.glGetFloat(Graphics3DDraw.GL_MODELVIEW_MATRIX, buffer);
				m_viewMatrix.setColumnMajor(buffer);
				Math3D.transpose(m_viewMatrix, m_viewMatrix);

				m_matricesValid = true;
			} finally {
				Draw3DCache.returnFloatBuffer(buffer);
			}
		}
	}

	public void reset() {

		m_position.set(0, 0, -1000);

		m_viewDir.set(VIEW_REF);
		m_right.set(RIGHT_REF);
		m_up.set(UP_REF);

		fireCameraChanged();
	}
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.draw3d.camera.ICamera#setCameraPosition(org.eclipse.draw3d.camera.ICameraPosition)
	 */
	public void setCameraPosition(ICameraPosition i_cameraPosition) {
		if (i_cameraPosition == null) // parameter precondition
			throw new NullPointerException("i_cameraPosition must not be null");
		
		i_cameraPosition.getPosition(m_position);
		i_cameraPosition.getUpVector(m_up);
		i_cameraPosition.getViewDirection(m_viewDir);
		i_cameraPosition.getRightVector(m_right);
		
		fireCameraChanged();
	}

	public void rotate(float i_roll, float i_pitch, float i_yaw) {

		Matrix4f rot = Math3DCache.getMatrix4f();
		try {
			rot.setIdentity();

			if (i_roll != 0)
				Math3D.rotate(i_roll, m_viewDir, rot, rot);

			if (i_pitch != 0)
				Math3D.rotate(i_pitch, m_right, rot, rot);

			if (i_yaw != 0)
				Math3D.rotate(i_yaw, m_up, rot, rot);

			m_viewDir.transform(rot);
			m_right.transform(rot);
			m_up.transform(rot);

			fireCameraChanged();
		} finally {
			Math3DCache.returnMatrix4f(rot);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.ICamera#setViewport(int, int, int, int)
	 */
	public void setViewport(int i_x, int i_y, int i_width, int i_height) {

		m_viewport.setLocation(i_x, i_y);
		m_viewport.setSize(i_width, i_height);

		fireCameraChanged();
	}
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.draw3d.camera.ICamera#getViewPortSize()
	 */
	public Dimension getViewPortSize() {
		return new Dimension(m_viewport.width, m_viewport.height);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.ICamera#unProject(int, int, float,
	 *      org.eclipse.draw3d.geometry.IMatrix4f,
	 *      org.eclipse.draw3d.geometry.Vector3f)
	 */
	public Vector3f unProject(int i_mx, int i_my, float i_depth,
		IMatrix4f i_modelMatrix, Vector3f io_result) {

		if (m_cachedProjection.hasWorldLocation(i_mx, i_my, i_depth,
			i_modelMatrix))
			return m_cachedProjection.getWorldLocation(io_result);

		Vector3f result = io_result;
		if (result == null)
			result = new Vector3fImpl();

		Matrix4f inversion = Math3DCache.getMatrix4f();
		try {

			// invert viewport transformation
			result.setX(2 * i_mx / (float) m_viewport.width - 1);
			result.setY(2 * (m_viewport.height - i_my)
				/ (float) m_viewport.height - 1);
			result.setZ(2 * i_depth - 1);

			calculateInversionMatrix(i_modelMatrix, inversion);
			result.transform(inversion);

			m_cachedProjection.update(result.getX(), result.getY(),
				result.getZ(), i_mx, i_my, i_depth, i_modelMatrix);

			return result;
		} finally {
			Math3DCache.returnMatrix4f(inversion);
		}
	}
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.draw3d.camera.ICamera#getCameraPosition(org.eclipse.draw3d.camera.CameraPosition)
	 */
	public ICameraPosition getCameraPosition(CameraPosition o_result) {
		CameraPosition cameraPosition = o_result;
		if (cameraPosition==null) {
			cameraPosition = new CameraPosition();
		}
		cameraPosition.setPosition(m_position);
		cameraPosition.setUpVector(m_up);
		cameraPosition.setViewDirection(m_viewDir);
		return cameraPosition;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.draw3d.camera.ICamera#scheduleTrackingShot(org.eclipse.draw3d.camera.tracking.TrackingShot, long, long)
	 */
	public void scheduleTrackingShot(TrackingShot i_shot) {
		
		if (timer!=null) {
			cancelTrackingShot();
		}
		
		timer = new Timer();
		timer.scheduleAtFixedRate(i_shot, 0, 50);
		
	}
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.draw3d.camera.ICamera#cancelTrackingShot()
	 */
	public void cancelTrackingShot() {
		if (timer!=null) {
			try {
				timer.cancel();
			} catch (Exception ex) {
				// TODO: handle exception
			}
			timer = null;
		}
		
	}
	
	
}
