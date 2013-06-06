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

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometryext.PointList3D;
import org.eclipse.draw3d.util.Draw3DCache;

/**
 * ConnectionRouter3D is the 3D version of {@link ConnectionRouter}.
 * 
 * @todo Make it more efficient!
 * 
 * @author IBM Corporation (original 2D version)
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 26.11.2007
 * @see org.eclipse.draw3d.ConnectionRouter
 */
public interface ConnectionRouter3D extends ConnectionRouter {

	/**
	 * Routes Connections directly from the source anchor to the target anchor
	 * with no bendpoints in between.
	 */
	class NullConnectionRouter3D extends  AbstractRouter3D {

		/**
		 * Constructs a new NullConnectionRouter.
		 */
		NullConnectionRouter3D() {

			// nothing to initialize
		}

		/**
		 * Routes the given Connection directly between the source and target
		 * anchors.
		 * 
		 * @param conn the connection to be routed
		 */
		public void route(Connection connection) {

			if (connection instanceof Connection3D ) {

				Vector3f tmp = Draw3DCache.getVector3f();
				try {
					Connection3D c3D = (Connection3D) connection;
					PointList3D points = c3D.getPoints3D();
					points.removeAllPoints();

					getStartPoint3D(c3D, tmp);
					c3D.transformToAbsolute(tmp);
					points.add(tmp);

					getEndPoint3D(c3D, tmp);
					c3D.transformToAbsolute(tmp);
					points.add(tmp);

					c3D.setPoints3D(points);
				} finally {
					Draw3DCache.returnVector3f(tmp);
				}
			} else {
				PointList points = connection.getPoints();
				points.removeAllPoints();
				Point p;
				connection.translateToRelative(p = getStartPoint(connection));
				points.addPoint(p);
				connection.translateToRelative(p = getEndPoint(connection));
				points.addPoint(p);
				connection.setPoints(points);
			}
		}
	}

	/**
	 * The default router for Connections.
	 */
	ConnectionRouter3D NULL = new NullConnectionRouter3D();
}
