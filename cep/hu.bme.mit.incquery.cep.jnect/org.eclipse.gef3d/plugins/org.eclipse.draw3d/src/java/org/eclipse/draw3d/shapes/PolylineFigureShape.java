/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.shapes;

import java.util.Map;

import org.eclipse.draw3d.Polyline3D;
import org.eclipse.draw3d.RenderContext;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Math3DCache;
import org.eclipse.draw3d.geometry.ParaxialBoundingBox;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Math3DBase.Side;
import org.eclipse.draw3d.geometryext.Plane;
import org.eclipse.draw3d.geometryext.PointList3D;
import org.eclipse.draw3d.graphics3d.Graphics3D;
import org.eclipse.draw3d.graphics3d.Graphics3DDraw;

/**
 * A polyline shape can be used to render polylines.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 03.04.2008
 */
public class PolylineFigureShape implements Shape {

	private static final float ACCURACY = 10f;

	private static final String KEY_HORIZONTAL_BORDER = "horizontal border";

	private static final String KEY_VERTICAL_BORDER = "vertical border";

	private static final String KEY_VISIBLE_BORDER = "visible border";

	private Polyline3D m_figure;

	/**
	 * Creates a new shape for the given polyline figure.
	 * 
	 * @param i_figure the figure to which this shape belongs
	 */
	public PolylineFigureShape(Polyline3D i_figure) {

		if (i_figure == null)
			throw new NullPointerException("i_figure must not be null");

		m_figure = i_figure;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.picking.Pickable#getDistance(org.eclipse.draw3d.geometry.IVector3f,
	 *      org.eclipse.draw3d.geometry.IVector3f, java.util.Map)
	 */
	public float getDistance(IVector3f i_rayOrigin, IVector3f i_rayDirection,
		Map<Object, Object> i_context) {

		// TODO handle line width!

		PointList3D points = m_figure.getPoints3D();

		if (points.size() < 2)
			return Float.NaN;

		/*
		 * To determine whether a polyline is hit by a ray, we implement the
		 * following method. First, we reduce the problem to line segments by
		 * checking individually the segments of the polyline for intersections
		 * with the ray. To reduce the number of checks, we divide the world
		 * space into five subspaces using three planes. One plane contains the
		 * origin of the picking ray and has the ray direction as its normal.
		 * This plane divides the world space into two subspaces we call "front"
		 * and "behind" for obvious reasons. Furthermore, we subdive the front
		 * and back spaces space "horizontally" and "vertically" using two
		 * planes that are orthogonal to each other and whose line of
		 * intersection is parallel to the ray direction and contains the ray
		 * origin. This is easy to image, just place yourself at the origin of
		 * the ray and look into its direction. The "horizontal" and "vertical"
		 * division planes would be visible as two orthogonal lines which
		 * intersect exactly at the point you are looking at. Be aware that from
		 * your point of view, neither of these planes is usually horizontal or
		 * vertical - we only use these words to differentiate the two planes.
		 * Now that we have subdivided space, we can formulate conditions for
		 * intersecting line segments. Firstly, a segment can only intersect
		 * with the ray if at least one of its vertices is the front space and
		 * if its vertices are contained in opposite sub spaces (for example,
		 * vertex 1 is in the upper left and vertex2 in the lower right
		 * subspace). After we have found such a candidate, we can easily
		 * calculate the point of intersection between the segment and the ray.
		 */

		Plane visBorder =
			getVisibleBorder(i_rayOrigin, i_rayDirection, i_context);
		Plane hBorder =
			getHorizontalBorder(i_rayOrigin, i_rayDirection, i_context);
		Plane vBorder =
			getVerticalBorder(i_rayOrigin, i_rayDirection, i_context);

		IVector3f p1 = points.get(0);
		IVector3f p2;

		Side visSide1 = visBorder.getSide(p1);
		Side hSide1 = null, vSide1 = null, visSide2, hSide2, vSide2;

		for (int i = 1; i < points.size(); i++) {
			p2 = points.get(i);
			visSide2 = visBorder.getSide(p2);

			// is at least one point in the front subspace?
			if (visSide1 != visSide2 || visSide1 == Side.FRONT) {

				if (hSide1 == null)
					hSide1 = hBorder.getSide(p1);
				hSide2 = hBorder.getSide(p2);

				// are the points on different sides or on the horizontal plane?
				if (hSide1 != hSide2 || (hSide1 == null && hSide2 == null)) {

					if (vSide1 == null)
						vSide1 = vBorder.getSide(p1);
					vSide2 = vBorder.getSide(p2);

					// are the points on different sides or on the vertical
					// plane?
					if (vSide1 != vSide2 || (vSide1 == null && vSide2 == null)) {
						Vector3f intersection = Math3DCache.getVector3f();
						Vector3f tmp = Math3DCache.getVector3f();
						try {
							// the two points are in different quadrants or on a
							// plane, so we try and hit the segment
							Plane intersectingBorder = null;
							if ((hSide1 == null && hSide2 == null))
								intersectingBorder = vBorder;
							else
								intersectingBorder = hBorder;

							intersectingBorder.intersectionWithSegment(p1, p2,
								intersection);

							// intersection only if tmp is on the
							// picking ray
							Math3D.sub(intersection, i_rayOrigin, tmp);
							float fx = tmp.getX() / i_rayDirection.getX();
							float fy = tmp.getY() / i_rayDirection.getY();
							float fz = tmp.getZ() / i_rayDirection.getZ();

							if (!Math3D.equals(fx, fy, ACCURACY))
								return Float.NaN;

							if (!Math3D.equals(fx, fz, ACCURACY))
								return Float.NaN;

							if (!Math3D.equals(fy, fz, ACCURACY))
								return Float.NaN;

							return (fx + fy + fz) / 3f;
						} finally {
							Math3DCache.returnVector3f(intersection, tmp);
						}
					}

					// carry the "vertical" side of point 2 to point 1
					vSide1 = vSide2;
				} else {
					vSide1 = null;
				}

				// carry the "horizontal" side of point 2 to point 1
				hSide1 = hSide2;
			} else {
				hSide1 = null;
				vSide1 = null;
			}

			// carry the "visible" side of point 2 to point 1
			visSide1 = visSide2;
			p1 = p2;
		}

		return Float.NaN;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.RenderFragment#getDistanceMeasure(org.eclipse.draw3d.RenderContext)
	 */
	public float getDistanceMeasure(RenderContext i_renderContext) {

		// if transparent, polylines are always drawn last
		return 0;
	}

	private Plane getHorizontalBorder(IVector3f i_rayOrigin,
		IVector3f i_rayDirection, Map<Object, Object> i_context) {

		Plane horizontalBorder = null;
		if (i_context != null)
			horizontalBorder = (Plane) i_context.get(KEY_HORIZONTAL_BORDER);

		if (horizontalBorder == null) {
			Vector3f normal = Math3DCache.getVector3f();
			try {
				Math3D.cross(i_rayOrigin, i_rayDirection, normal);
				Math3D.normalise(normal, normal);

				horizontalBorder = new Plane();
				horizontalBorder.set(i_rayOrigin, normal);

				if (i_context != null)
					i_context.put(KEY_HORIZONTAL_BORDER, horizontalBorder);
			} finally {
				Math3DCache.returnVector3f(normal);
			}
		}

		return horizontalBorder;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.picking.Pickable#getParaxialBoundingBox(org.eclipse.draw3d.geometry.ParaxialBoundingBox)
	 */
	public ParaxialBoundingBox getParaxialBoundingBox(
		ParaxialBoundingBox o_result) {

		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.RenderFragment#getRenderType()
	 */
	public RenderType getRenderType() {

		return RenderType.getRenderType(m_figure.getAlpha(), false);
	}

	private Plane getVerticalBorder(IVector3f i_rayOrigin,
		IVector3f i_rayDirection, Map<Object, Object> i_context) {

		Plane verticalBorder = null;
		if (i_context != null)
			verticalBorder = (Plane) i_context.get(KEY_VERTICAL_BORDER);

		if (verticalBorder == null) {
			Vector3f hNormal = Math3DCache.getVector3f();
			Vector3f vNormal = Math3DCache.getVector3f();
			try {
				Plane horizontalBorder =
					getHorizontalBorder(i_rayOrigin, i_rayDirection, i_context);
				horizontalBorder.getNormal(hNormal);

				Math3D.cross(i_rayDirection, hNormal, vNormal);

				verticalBorder = new Plane();
				verticalBorder.set(i_rayOrigin, vNormal);

				if (i_context != null)
					i_context.put(KEY_VERTICAL_BORDER, verticalBorder);
			} finally {
				Math3DCache.returnVector3f(hNormal, vNormal);
			}
		}

		return verticalBorder;
	}

	private Plane getVisibleBorder(IVector3f i_rayOrigin,
		IVector3f i_rayDirection, Map<Object, Object> i_context) {

		Plane visibleBorder = null;
		if (i_context != null)
			visibleBorder = (Plane) i_context.get(KEY_VISIBLE_BORDER);

		if (visibleBorder == null) {
			visibleBorder = new Plane();
			visibleBorder.set(i_rayOrigin, i_rayDirection);

			if (i_context != null)
				i_context.put(KEY_VISIBLE_BORDER, visibleBorder);
		}

		return visibleBorder;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.RenderFragment#render(org.eclipse.draw3d.RenderContext)
	 */
	public void render(RenderContext i_renderContext) {

		PointList3D points = m_figure.getPoints3D();

		if (points.size() < 2)
			return;

		Graphics3D g3d = i_renderContext.getGraphics3D();
		g3d.glColor(m_figure.getForegroundColor(), m_figure.getAlpha());

		g3d.glLineWidth(m_figure.getLineWidth());

		g3d.glBegin(Graphics3DDraw.GL_LINE_STRIP);
		for (IVector3f point : points)
			g3d.glVertex3f(point);
		g3d.glEnd();
	}
}
