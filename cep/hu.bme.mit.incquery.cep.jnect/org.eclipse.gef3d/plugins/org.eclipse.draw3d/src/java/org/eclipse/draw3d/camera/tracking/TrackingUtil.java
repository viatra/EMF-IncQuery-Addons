/*******************************************************************************
 * Copyright (c) 2011 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.camera.tracking;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw3d.Figure3DHelper;
import org.eclipse.draw3d.IFigure3D;
import org.eclipse.draw3d.ISurface;
import org.eclipse.draw3d.camera.CameraPosition;
import org.eclipse.draw3d.camera.ICamera;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Math3DCache;
import org.eclipse.draw3d.geometry.Matrix4f;
import org.eclipse.draw3d.geometry.Vector3f;

/**
 * Utility methods for calculating the camera position.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @version $Revision$
 * @since May 22, 2011
 */
public class TrackingUtil {

	public static CameraPosition figureToScreen(IFigure figure, ICamera camera) {
		IFigure3D fig3D = Figure3DHelper.getAncestor3D(figure);
		if (fig3D == null) {
			throw new IllegalArgumentException("Cannot retrieve 3D ancestor");
		}
		ISurface surface = fig3D.getSurface();
		if (surface == null) {
			throw new IllegalArgumentException("No surface found.");
		}

		CameraPosition pos = new CameraPosition();

		Vector3f v = Math3DCache.getVector3f(), v1 = Math3DCache.getVector3f(), v2 =
			Math3DCache.getVector3f(), v3 = Math3DCache.getVector3f();
		try {

			// up vector
			pos.setUpVector(surface.getUpVector());

			// view direction
			Math3D.scale(-1f, surface.getNormal(), v);
			pos.setViewDirection(v);

			// position
			if (figure instanceof IFigure3D) {
				IFigure3D f3D = (IFigure3D) figure;
				v1.set(f3D.getPosition3D().getCenter3D());
			} else {
				Point p2D = figure.getBounds().getCenter();
				surface.getWorldLocation(p2D, v1);
			}

			float near = camera.getNear();
			camera.unProject(0, 0, 0, Matrix4f.IDENTITY, v2);
			camera.unProject(100, 100, 0, Matrix4f.IDENTITY, v3);

			float projLength = Math3D.distance(v2, v3);
			float orgLengh = (float) Math.sqrt(2 * 100 * 100);

			float scale = (near) * (orgLengh / projLength);

			Math3D.scale(scale, v, v);
			Math3D.sub(v1, v, v1);

			pos.setPosition(v1);
		} finally {
			Math3DCache.returnVector3f(v, v1, v2, v3);
		}
		return pos;
	}

}
