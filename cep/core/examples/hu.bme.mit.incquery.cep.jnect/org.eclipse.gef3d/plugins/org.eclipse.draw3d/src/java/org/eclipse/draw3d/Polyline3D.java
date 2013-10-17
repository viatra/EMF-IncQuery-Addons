/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others,
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation of 2D version
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d;

import java.util.List;
import java.util.logging.Logger;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.ParaxialBoundingBox;
import org.eclipse.draw3d.geometryext.PointList3D;
import org.eclipse.draw3d.shapes.PolylineFigureShape;
import org.eclipse.draw3d.shapes.Shape;

/**
 * 3D version of {@link org.eclipse.draw2d.Polyline}.
 * 
 * @todo Derive this figure from Shape3D (when Shape3D is needed)
 * @author IBM Corporation (original 2D version)
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 26.11.2007
 */
public class Polyline3D extends ShapeFigure3D {
	
	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger.getLogger(Polyline3D.class
		.getName());

	/**
	 * The width of this poly line.
	 */
	float lineWidth = 1.0f;

	/**
	 * The point list. This list is derived from {@link PointList} and can thus
	 * be used instead of this 2D version.
	 */
	PointList3D points = new PointList3D();

	/**
	 * Adds a copy of the given point to the Polyline. Changes to the given
	 * point are not reflected by this polyline.
	 * 
	 * @param i_point the point to be added to the Polyline
	 */
	public void addPoint(IVector3f i_point) {

		points.add(i_point);
		// bounds = null;
		repaint();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.ShapeFigure3D#createShape()
	 */
	@Override
	protected Shape createShape() {
		return new PolylineFigureShape(this);
	}

	/**
	 * Returns the last point in the Polyline.
	 * 
	 * @throws IndexOutOfBoundsException if the list is empty or contains only
	 *             one point
	 * @return the last point
	 */
	public IVector3f getEnd() {

		if (points.size() < 2) {
			throw new IndexOutOfBoundsException(
				"pointlist is empty or contains only one point");
		}

		IVector3f pt = points.get(points.size() - 1);
		log.info("getEnd(): " + pt);

		return pt;
	}

	/**
	 * Returns the line width.
	 * 
	 * @return the line width
	 */
	public float getLineWidth() {

		return lineWidth;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.Figure3D#getParaxialBoundingBox(org.eclipse.draw3d.geometry.ParaxialBoundingBox)
	 */
	@Override
	public ParaxialBoundingBox getParaxialBoundingBox(
		ParaxialBoundingBox o_result) {

		// polylines don't have paraxial bounds
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Connection#getPoints()
	 */
	public PointList getPoints() {
		return points;
	}

	/**
	 * Returns the PointList containing the Points that make up this Connection
	 * by reference. Note that simply changing the points does not update the
	 * connection, as no notification is generated. In order to update the
	 * connection, {@link #setPoints3D(List)} must be called, even if the same
	 * list is returned.
	 * 
	 * @return this Polyline's points
	 * @since 2.0
	 */
	public PointList3D getPoints3D() {
		return points;
	}

	/**
	 * @return the first point in the Polyline or null, if line contains no
	 *         points
	 * @throws IndexOutOfBoundsException if the list is empty
	 * @since 2.0
	 */
	public IVector3f getStart() {
		return points.get(0);
	}

	/**
	 * Inserts a copy of the given point at a specified index in the polyline.
	 * Changes to the given point are not reflected by this polyline.
	 * 
	 * @param i_point the point to be added
	 * @param i_index the position in the Polyline where the point is to be
	 *            added
	 * @throws IndexOutOfBoundsException - if the index is out of range (index <
	 *             0 || index >= size()).
	 */
	public void insertPoint(IVector3f i_point, int i_index) {

		// bounds = null;
		log.info("insertPoint(IVector3f, int): " + i_point + ", " + i_index);
		points.set(i_index, i_point);
		repaint();
	}

	/**
	 * @return <code>false</code> because Polyline's aren't filled
	 */
	@Override
	public boolean isOpaque() {
		return false;
	}

	/**
	 * @see Figure#primTranslate(int, int)
	 */
	@Override
	public void primTranslate(int x, int y) {
	}

	/**
	 * Erases the Polyline and removes all of its {@link IVector3f Points}.
	 * 
	 * @since 2.0
	 */
	public void removeAllPoints() {
		erase();
		// bounds = null;
		points.clear();
	}

	/**
	 * Removes a point from the Polyline.
	 * 
	 * @param index the position of the point to be removed
	 * @throws IndexOutOfBoundsException - if the index is out of range (index <
	 *             0 || index >= size()).
	 */
	public void removePoint(int index) {
		erase();
		// bounds = null;
		points.remove(index);
	}

	/**
	 * Sets the end point of the Polyline. If line contains only one point, the
	 * new point is added as second point, otherwise the last point is replaced
	 * by the new point.
	 * 
	 * @param end the point that will become the last point in the Polyline
	 * @throws IndexOutOfBoundsException - if line contains no point
	 */
	public void setEnd(IVector3f end) {
		if (points.size() == 0) {
			throw new IndexOutOfBoundsException(
				"line contains no points, set start point before");
		}
		if (points.size() < 2) {
			addPoint(end);
		} else {
			setPoint(end, points.size() - 1);
		}
	}

	/**
	 * Sets the points at both extremes of the Polyline
	 * 
	 * @param start the point to become the first point in the Polyline
	 * @param end the point to become the last point in the Polyline
	 */
	public void setEndpoints(IVector3f start, IVector3f end) {
		setStart(start);
		setEnd(end);
	}

	/**
	 * @see org.eclipse.draw2d.Shape#setLineWidth(int)
	 */
	public void setLineWidth(float w) {
		if (lineWidth == w) {
			return;
		}
		if (w < lineWidth) {
			erase();
		}
		// bounds = null;
		// super.setLineWidth(w);
		lineWidth = w;
	}

	/**
	 * Sets the point at <code>index</code> to the IVector3f <code>pt</code>.
	 * Calling this method results in a recalculation of the polyline's bounding
	 * box. If you're going to set multiple Points, use
	 * {@link #setPoints(PointList)}.
	 * 
	 * @param pt the point
	 * @param index the index
	 */
	public void setPoint(IVector3f pt, int index) {
		erase();
		points.set(index, pt);
		// points.set(index, new Vector3f(pt));
		// bounds = null;
		repaint();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Connection#setPoints(org.eclipse.draw2d.geometry.PointList)
	 */
	public void setPoints(PointList i_list) {
		erase();

		if (i_list != points) {
			points.clear();
			points.addAll(i_list);
		}

		firePropertyChange(Connection.PROPERTY_POINTS, null, points);
		repaint();
		invalidate();
	}

	/**
	 * Sets the list of points to be used by this polyline connection. Removes
	 * any previously existing points. The polyline will hold onto the given
	 * list by reference.
	 * 
	 * @param points new set of points
	 * @since 2.0
	 */
	public void setPoints3D(List<IVector3f> i_list) {
		erase();

		if (i_list != points) {
			points.clear();
			points.addAll(i_list);
		}

		// TODO what's that?
		// bounds = null;
		firePropertyChange(Connection.PROPERTY_POINTS, null, points);
		repaint();
		invalidate();
	}

	/**
	 * Sets the start point of the Polyline. If list contains no points, the new
	 * point is added to the point list, otherwise the first point is replaced.
	 * 
	 * @param start the point that will become the first point in the Polyline
	 * @since 2.0
	 */
	public void setStart(IVector3f start) {
		if (points.size() == 0) {
			addPoint(start);
		} else {
			setPoint(start, 0);
		}
	}
}
