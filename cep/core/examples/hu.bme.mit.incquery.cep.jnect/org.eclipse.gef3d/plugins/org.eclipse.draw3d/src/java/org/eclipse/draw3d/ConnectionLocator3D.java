/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/

package org.eclipse.draw3d;

import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;
import org.eclipse.draw3d.geometryext.PointList3D;
import org.eclipse.draw3d.util.Draw3DCache;

/**
 * Locator used to place an {@link IFigure3D} on a {@link Connection}. The
 * figure can be placed at the source or target end of the connection figure.
 * The default connection implementation uses a {@link DelegatingLayout} which
 * requires locators.
 * 
 * @author Kristian Duske
 * @version $Revision: 248 $
 * @since 17.05.2008
 */
public class ConnectionLocator3D extends ConnectionLocator {

	/**
	 * Creates a new 3D connection locator for the given connection and with the
	 * given alignment.
	 * 
	 * @param i_connection the connection
	 * @param i_align the alignment
	 */
	public ConnectionLocator3D(Connection i_connection, int i_align) {
		super(i_connection, i_align);
	}

	/**
	 * Returns the location of a decoration depending on the locator's
	 * alignment.
	 * 
	 * @param i_points the point list
	 * @param io_result the result vector, can be <code>null</code>
	 * @return the location
	 * @throws NullPointerException if the given point list is <code>null</code>
	 */
	protected IVector3f getLocation(List<IVector3f> i_points, Vector3f io_result) {

		if (i_points == null)
			throw new NullPointerException("i_points must not be null");

		Vector3f result = io_result;
		if (result == null)
			result = new Vector3fImpl();

		int size = i_points.size();
		switch (getAlignment()) {
		case SOURCE:
			result.set(i_points.get(0));
			break;
		case TARGET:
			result.set(i_points.get(size - 1));
			break;
		case MIDDLE:
			if ((size % 2) == 0) {
				int i = size / 2;
				IVector3f p1 = i_points.get(i - 1);
				IVector3f p2 = i_points.get(i);
				Math3D.sub(p2, p1, result);
				result.scale(0.5f);
				Math3D.add(p1, result, result);
			} else {
				result.set(i_points.get((size - 1) / 2));
			}
			break;
		default:
			throw new IllegalStateException("unknown location: "
				+ getAlignment());
		}

		return result;
	}

	/**
	 * Returns the surface to onto which the connection figure is projected if
	 * it is a 2D connection.
	 * 
	 * @return the surface or <code>null</code> if the connection is a 3D
	 *         connection
	 */
	protected ISurface getSurface() {

		if (getConnection() instanceof Connection3D)
			return null;

		IFigure figure = null;
		ConnectionAnchor sourceAnchor = getConnection().getSourceAnchor();
		if (sourceAnchor != null)
			figure = sourceAnchor.getOwner();

		if (figure == null) {
			ConnectionAnchor targetAnchor = getConnection().getTargetAnchor();
			if (targetAnchor != null)
				figure = targetAnchor.getOwner();
		}

		if (figure != null) {
			IFigure3D figure3D = Figure3DHelper.getAncestor3D(figure);
			if (figure3D != null)
				return figure3D.getSurface();
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Locator#relocate(org.eclipse.draw2d.IFigure)
	 */
	@Override
	public void relocate(IFigure i_target) {

		IFigure3D target3D = (IFigure3D) i_target;

		Vector3f wLocation = Draw3DCache.getVector3f();
		Vector3f size = Draw3DCache.getVector3f();
		try {
			if (getConnection() instanceof Connection3D) {
				Connection3D connection3D = (Connection3D) getConnection();
				PointList3D points = connection3D.getPoints3D();
				getLocation(points, wLocation);
			} else {
				PointList points = getConnection().getPoints();
				Point sLocation = getLocation(points);

				ISurface surface = getSurface();
				if (surface != null)
					surface.getWorldLocation(sLocation, wLocation);
			}

			size.set(target3D.getPreferredSize3D());
			target3D.getPosition3D().setSize3D(size);

			size.scale(0.5f);
			Math3D.sub(wLocation, size, wLocation);

			target3D.getPosition3D().setLocation3D(wLocation);
		} finally {
			Draw3DCache.returnVector3f(wLocation, size);
		}
	}
}
