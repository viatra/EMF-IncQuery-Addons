/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/

package org.eclipse.draw3d.camera;

import java.util.Timer;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw3d.RenderContext;
import org.eclipse.draw3d.camera.tracking.TrackingShot;
import org.eclipse.draw3d.geometry.IMatrix4f;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;
import org.eclipse.draw3d.geometryext.Ray;

/**
 * General camera interface used by LightweightSystem. A camera can be used in
 * two modes, which are working very differently. In absolute mode, moving,
 * rotating, or orbiting the camera results in directly modifying the given
 * parameters. In timed mode, the given values are interpreted as velocities. In
 * timed mode, render must be periodically called in order to update the values.
 * <p>
 * This interface is not supposed to be implemented directly, instead subclass
 * {@link AbstractCamera}.
 * </p>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 19.11.2007
 */
public interface ICamera {

	/**
	 * Right reference vector.
	 */
	public static final IVector3f RIGHT_REF = new Vector3fImpl(1, 0, 0);

	/**
	 * Up reference vector.
	 */
	public static final IVector3f UP_REF = new Vector3fImpl(0, -1, 0);

	/**
	 * View direction reference vector.
	 */
	public static final IVector3f VIEW_REF = new Vector3fImpl(0, 0, 1);

	/**
	 * Registers the given listener with this camera. If the listener is already
	 * registered, it will be registered again.
	 * 
	 * @param i_listener the listener to register
	 */
	public void addCameraListener(ICameraListener i_listener);

	/**
	 * Calculates the distance from this camera to a given point.
	 * 
	 * @param i_point the point
	 * @return the distance from this camera to the given point
	 * @throws NullPointerException if the given point is <code>null</code>
	 */
	public float getDistance(IVector3f i_point);

	/**
	 * Distance of the viewing plane from the camera.
	 * 
	 * @return the distance of the viewing plane
	 */
	public float getNear();

	/**
	 * Returns the current camera position.
	 * 
	 * @param result if not null, this result object is used and returned.
	 * @return
	 */
	public ICameraPosition getCameraPosition(CameraPosition result);

	/**
	 * Sets the camera's position, view direction, and up/right vector according
	 * to the given camera position. Since different camera implementations may
	 * restrict the possible values of these properties, the values provided by
	 * the camera positions are only used as hints.
	 * 
	 * @param cameraPosition, must not be null
	 */
	public void setCameraPosition(ICameraPosition cameraPosition);

	/**
	 * Returns the camera's current position.
	 * 
	 * @param io_result the result vector, if <code>null</code>, a new vector
	 *            will be returned
	 * @return the current position
	 */
	public IVector3f getPosition(Vector3f io_result);

	/**
	 * Returns a ray that starts at the camera position and extends through the
	 * point specified by the given mouse coordinates.
	 * 
	 * @param i_xm the mouse X coordinate
	 * @param i_ym the mouse Y coordinate
	 * @param io_result the result ray, if <code>null</code>, a new one will be
	 *            created
	 * @return the ray
	 */
	public Ray getRay(int i_xm, int i_ym, Ray io_result);

	/**
	 * Returns the current right vector of the camera. The returned vector is
	 * normalized.
	 * 
	 * @param io_result the result vector, if <code>null</code>, a new vector
	 *            will be returned
	 * @return the current right direction
	 */
	public Vector3f getRightVector(Vector3f io_result);

	/**
	 * Returns the current up vector of the camera. This is (if no camera
	 * movement has been occurred inbetween) usually the normalized vector
	 * possibly passed to {@link #lookAt(IVector3f, IVector3f)}.
	 * 
	 * @param io_result the result vector, if <code>null</code>, a new vector
	 *            will be returned
	 * @return the current up direction
	 */
	public Vector3f getUpVector(Vector3f io_result);

	/**
	 * Returns the current view direction. Adding this vector to the current
	 * position returns the point to which the camera is looking (look at). Note
	 * that the result calculated this way is not necessarily equal to the
	 * vector possibly passed to {@link #lookAt(IVector3f, IVector3f)}.
	 * 
	 * @param io_result the result vector, if <code>null</code>, a new vector
	 *            will be returned
	 * @return the normalized current view direction vector
	 */
	public Vector3f getViewDirection(Vector3f io_result);

	/**
	 * Look at the given position. If the up vector is not <code>null</code>,
	 * the camera is adjusted accordingly.
	 * 
	 * @param i_position the position to look at
	 * @param i_upvector the new up vector, which may be <code>null</code>
	 */
	public void lookAt(IVector3f i_position, IVector3f i_upvector);

	/**
	 * Moves camera by given distances.
	 * 
	 * @param i_dForward the distance in the view direction
	 * @param i_dStrafe the sideways distance in the right direction
	 * @param i_dUp the distance on the Z axis
	 */
	public void moveBy(float i_dForward, float i_dStrafe, float i_dUp);

	/**
	 * Moves the camera to the given position.
	 * 
	 * @param i_Position the new view point
	 * @throws NullPointerException if the given vector is <code>null</code>
	 */
	public void moveTo(IVector3f i_position);

	/**
	 * Moves the camera around a location (called orbit center) by a given
	 * angle.
	 * 
	 * @param i_center the orbit center
	 * @param i_hAngle the horizontal orbit angle, in radians
	 * @param i_vAngle the vertical orbit angle, in radians
	 */
	public void orbit(IVector3f i_center, float i_hAngle, float i_vAngle);

	/**
	 * Performs a projection of the given world coordinates to mouse
	 * coordinates. In other words, it calculates the pixel which a ray from the
	 * eye to the given 3D point would intersect with.
	 * 
	 * @param i_wx the X world coordinate
	 * @param i_wy the Y world coordinate
	 * @param i_wz the Z world coordinate
	 * @param io_result the result point, if <code>null</code>, a new point will
	 *            be created
	 * @return the result point
	 */
	public Point project(float i_wx, float i_wy, float i_wz, Point io_result);

	/**
	 * Performs a projection of the given world coordinates to mouse
	 * coordinates. In other words, it calculates the pixel which a ray from the
	 * eye to the given 3D point would intersect with.
	 * 
	 * @param i_wLocation the world coordinates
	 * @param io_result the result point, if <code>null</code>, a new point will
	 *            be created
	 * @return the result point
	 */
	public Point project(IVector3f i_wLocation, Point io_result);

	/**
	 * Removes the given camera listener from this camera. If the given listener
	 * is not registered, nothing happens. If the given listener has been
	 * registered more than once, the oldest registration will be removed.
	 * 
	 * @param i_listener the listener to remove
	 */
	public void removeCameraListener(ICameraListener i_listener);

	/**
	 * Renders the camera.
	 * 
	 * @param renderContext the current render context
	 */
	public void render(RenderContext renderContext);

	/**
	 * Resets the camera to its default position, view direction and up vector.
	 */
	public void reset();

	/**
	 * Rotates camera by the given angles.
	 * 
	 * @param i_roll the roll angle (rotates about the view direction)
	 * @param i_pitch the pitch angle (nods the camera)
	 * @param i_yaw the yaw angle (looks sideways)
	 */
	public void rotate(float i_roll, float i_pitch, float i_yaw);

	/**
	 * Sets the current viewport.
	 * 
	 * @param i_x the x offset of the viewport
	 * @param i_y the y offset of the viewport
	 * @param i_width the width of the viewport
	 * @param i_height the height of the viewport
	 */
	public void setViewport(int i_x, int i_y, int i_width, int i_height);

	/**
	 * Returns the dimension of the view port.
	 * 
	 * @return
	 */
	public Dimension getViewPortSize();

	/**
	 * Transfers all registered camera listeners from this camera to the given
	 * camera. Registered listeners are notified of the change by calling
	 * {@link ICameraListener#cameraTypeChanged(ICamera, ICamera)}.
	 * 
	 * @param i_newCamera the new camera
	 */
	public void transferListeners(ICamera i_newCamera);

	/**
	 * Performs a reverse projection of the given mouse coordinates and depth
	 * value using the given model matrix. The origin of the mouse coordinates
	 * is expected to be in the upper left corner. If the given model matrix is
	 * <code>null</code>, it is ignored (in other words, it is replaced with the
	 * identity matrix). The result vector contains the world coordinates of the
	 * point at the given screen coordinates and depth.
	 * 
	 * @param i_mx the mouse X coordinate
	 * @param i_my the mouse Y coordinate
	 * @param i_d the depth value
	 * @param i_modelMatrix the model matrix
	 * @param io_result the result vector, if <code>null</code>, a new vector
	 *            will be created
	 * @return the result vector
	 */
	public Vector3f unProject(int i_mx, int i_my, float i_d,
		IMatrix4f i_modelMatrix, Vector3f io_result);

	/**
	 * Schedules a new tracking shot, possibly running tracking shots are
	 * canceled. While camera tracks could be run using a separated
	 * {@link Timer}, it is recommended to use the camera's timer in order to
	 * enable canceling of tracking shots via {@link #cancelTrackingShot()}.
	 */
	public void scheduleTrackingShot(TrackingShot shot);

	/**
	 * Cancels a possibly running tracking shot.
	 */
	public void cancelTrackingShot();
}
