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
package org.eclipse.gef3d.examples.graph.editor.figures;

import java.util.logging.Logger;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * EdgeFigure2D There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 19.12.2007
 */
public class EdgeFigure2D extends PolylineConnection {
	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger.getLogger(EdgeFigure2D.class
			.getName());

	/**
	 * ONLY FOR DEBUGGING, CAN BE REMOVED
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Figure#paint(org.eclipse.draw2d.Graphics)
	 */
	@Override
	public void paint(Graphics i_graphics) {
		// log();
		super.paint(i_graphics);
	}

	/**
	 * ONLY FOR DEBUGGING, CAN BE REMOVED
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Polyline#addPoint(org.eclipse.draw2d.geometry.Point)
	 */
	@Override
	public void addPoint(Point i_pt) {
		log();

		super.addPoint(i_pt);
	}

	/**
	 * ONLY FOR DEBUGGING, CAN BE REMOVED
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Polyline#getEnd()
	 */
	@Override
	public Point getEnd() {
		log();

		return super.getEnd();
	}

	/**
	 * ONLY FOR DEBUGGING, CAN BE REMOVED
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Polyline#getPoints()
	 */
	@Override
	public PointList getPoints() {
		// log();
		return super.getPoints();
	}

	/**
	 * ONLY FOR DEBUGGING, CAN BE REMOVED
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Polyline#getStart()
	 */
	@Override
	public Point getStart() {
		log();
		return super.getStart();
	}

	/**
	 * ONLY FOR DEBUGGING, CAN BE REMOVED
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Polyline#insertPoint(org.eclipse.draw2d.geometry.Point,
	 *      int)
	 */
	@Override
	public void insertPoint(Point i_pt, int i_index) {
		log();
		super.insertPoint(i_pt, i_index);
	}

	/**
	 * ONLY FOR DEBUGGING, CAN BE REMOVED
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Polyline#setEnd(org.eclipse.draw2d.geometry.Point)
	 */
	@Override
	public void setEnd(Point i_end) {
		log();
		super.setEnd(i_end);
	}

	/**
	 * ONLY FOR DEBUGGING, CAN BE REMOVED
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Polyline#setEndpoints(org.eclipse.draw2d.geometry.Point,
	 *      org.eclipse.draw2d.geometry.Point)
	 */
	@Override
	public void setEndpoints(Point i_start, Point i_end) {
		log();
		super.setEndpoints(i_start, i_end);
	}

	/**
	 * ONLY FOR DEBUGGING, CAN BE REMOVED
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Polyline#setPoint(org.eclipse.draw2d.geometry.Point,
	 *      int)
	 */
	@Override
	public void setPoint(Point i_pt, int i_index) {
		log();
		super.setPoint(i_pt, i_index);
	}

	/**
	 * ONLY FOR DEBUGGING, CAN BE REMOVED
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Polyline#setPoints(org.eclipse.draw2d.geometry.PointList)
	 */
	@Override
	public void setPoints(PointList i_points) {
		log();
		super.setPoints(i_points);
	}

	/**
	 * ONLY FOR DEBUGGING, CAN BE REMOVED
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Polyline#setStart(org.eclipse.draw2d.geometry.Point)
	 */
	@Override
	public void setStart(Point i_start) {
		log();
		super.setStart(i_start);
	}

	/**
	 * ONLY FOR DEBUGGING, CAN BE REMOVED
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Figure#setBounds(org.eclipse.draw2d.geometry.Rectangle)
	 */
	@Override
	public void setBounds(Rectangle i_rect) {
		log();
		super.setBounds(i_rect);
	}

	void log() {
		// if (log.isLoggable(Level.INFO)) {
		// log.info(CallStackTracer.getStackTrace(1,4));
		// }
	}

}
