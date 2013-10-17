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

import java.util.EventObject;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw3d.camera.ICamera;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;
import org.eclipse.draw3d.util.Draw3DCache;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Widget;

/**
 * MouseEvent3D There should really be more documentation here.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 21.06.2009
 */
public class MouseEvent3D extends MouseEvent {

	private static final Event DUMMY = new Event();

	private static final long serialVersionUID = -7581719169381368361L;

	private static Event getEvent(Object i_object) {

		if (i_object instanceof Event)
			return (Event) i_object;

		EventObject eventObject = (EventObject) i_object;
		DUMMY.widget = (Widget) eventObject.getSource();

		return DUMMY;
	}

	/**
	 * The original mouse location on the screen, as produced by SWT.
	 * {@link MouseEvent#x} and {@link MouseEvent#y} are converted into surface
	 * locations in {@link #MouseEvent3D(MouseEvent, ISurface, ICamera)}.
	 */
	protected Point screenLocation;

	/**
	 * The 3D location in world space that has been derived from the mouse
	 * coordinates.
	 */
	protected Vector3f worldLocation;

	/**
	 * Camera, used to calculate world locations from mouse event
	 */
	protected ICamera camera;

	/**
	 * Surface, set in constructor, usually the surface under the mouse cursor.
	 */
	protected ISurface surface;

	/**
	 * @param i_me the original 2D mouse event
	 * @param surface the surface under the mouse
	 * @param camera the current camera
	 */
	public MouseEvent3D(MouseEvent i_me, ISurface surface, ICamera camera) {
		super(getEvent(i_me));
		this.surface = surface;
		this.camera = camera;

		// save original mouse location
		screenLocation = new Point(i_me.x, i_me.y);

		worldLocation = new Vector3fImpl();
		Point surfaceLocation = Draw3DCache.getPoint();
		try {
			screenToWorld(camera, surface, getScreenLocation(),
				surfaceLocation, worldLocation);
			// x and y now represents surface locations!
			this.x = surfaceLocation.x;
			this.y = surfaceLocation.y;
		} finally {
			Draw3DCache.returnPoint(surfaceLocation);
		}

		// from MouseEvent
		this.button = i_me.button;
		this.stateMask = i_me.stateMask;
		this.count = i_me.count;
		// from TypedEvent
		this.display = i_me.display;
		this.widget = i_me.widget;
		this.time = i_me.time;
		this.data = i_me.data;
		// from EventObject
		this.source = i_me.widget;
	}

	/**
	 * Returns the camera, can be used to convert screen coordinates to world
	 * coordinates in
	 * {@link #screenToWorld(ICamera, ISurface, Point, Point, Vector3f)}. Note
	 * that the position and direction of a camera may change, so you cannot use
	 * a "newer" camera to calculate "older" values---camera and event have to
	 * match.
	 * 
	 * @return the camera
	 */
	public ICamera getCamera() {
		return camera;
	}

	/**
	 * Returns the surface used to calculate the location of the mouse cursor
	 * "in" the 3D scene. Actually the mouse events mouse locations
	 * {@link MouseEvent#x}/{@link MouseEvent#y} are in surface location on this
	 * very surface.
	 * 
	 * @return the surface
	 */
	public ISurface getSurface() {
		return surface;
	}

	/**
	 * Returns the screen location. This is the original location as produced by
	 * SWT, and in 2D this would equal {@link MouseEvent#x}/{@link MouseEvent#y}
	 * , however these last two values are automatically replaced in the
	 * constructor.
	 * 
	 * @return the screenLocation
	 */
	public Point getScreenLocation() {
		return screenLocation;
	}

	/**
	 * @return the worldLocation
	 */
	public IVector3f getWorldLocation() {
		return worldLocation;
	}

	/**
	 * Converts the given screen location into a world location, using the mouse
	 * event's camera and the given surface. If the surface is null, the mouse
	 * event's surface is used.
	 * 
	 * @param screenLocation screen location to be converted
	 * @param i_surface may be null
	 * @return
	 */
	public Vector3f computeWorldLocation(Point i_screenLocation, ISurface i_surface) {
		return screenToWorld(camera, i_surface == null ? getSurface() : i_surface,
			i_screenLocation, null, null);
	}

	/**
	 * Utility method used for converting (2D) mouse coordinates to 3D world
	 * coordinates.
	 * 
	 * @param camera the camera used to unproject the mouse coordinate
	 * @param surface the surface which is used to calculate the world location
	 * @param i_screenLocation the screen location
	 * @param o_surfaceLocation the location of the mouse on the surface, may be
	 *            null
	 * @param o_result the result, may be null.
	 * @return the o_result or a new vector 3f
	 * @see EventHandler3D#convert(MouseEvent i_me)
	 */
	public static Vector3f screenToWorld(ICamera camera, ISurface surface,
		Point i_screenLocation, Point o_surfaceLocation, Vector3f o_result) {
		// camera's eye
		Vector3f eye = Draw3DCache.getVector3f();
		// camera's look direction
		Vector3f direction = Draw3DCache.getVector3f();
		// vector from eye through 2D mouse location
		Vector3f pointVector = Draw3DCache.getVector3f();

		// 2D location on surface
		Point sLocation =
			o_surfaceLocation == null ? Draw3DCache.getPoint()
				: o_surfaceLocation;
		try {
			camera.getPosition(eye);
			camera.unProject(i_screenLocation.x, i_screenLocation.y, 0, null,
				pointVector);
			Math3D.getRayDirection(eye, pointVector, direction);
			surface.getSurfaceLocation2D(eye, direction, sLocation);

			return surface.getWorldLocation(sLocation, o_result);
		} finally {
			Draw3DCache.returnVector3f(eye, pointVector, direction);
			if (o_surfaceLocation == null)
				Draw3DCache.returnPoint(sLocation);
		}
	}
	/*
	 * Vector3f eye = Draw3DCache.getVector3f(); Vector3f point =
	 * Draw3DCache.getVector3f(); Vector3f direction =
	 * Draw3DCache.getVector3f(); Point sLocation = Draw3DCache.getPoint(); try
	 * { camera.getPosition(eye); camera.unProject(i_me.x, i_me.y, 0, null,
	 * point); Math3D.getRayDirection(eye, point, direction);
	 * surface.getSurfaceLocation2D(eye, direction, sLocation); Vector3f
	 * wLocation = surface.getWorldLocation(sLocation, null); return new
	 * MouseEvent3D(i_me, sLocation, wLocation); } finally {
	 * Draw3DCache.returnVector3f(eye, point, direction);
	 * Draw3DCache.returnPoint(sLocation); }
	 */

}
