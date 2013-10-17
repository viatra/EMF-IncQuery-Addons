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
package org.eclipse.draw3d.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

import org.eclipse.draw3d.RenderContext;
import org.eclipse.draw3d.Renderable;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Math3DCache;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;
import org.eclipse.draw3d.graphics3d.Graphics3D;
import org.eclipse.draw3d.graphics3d.Graphics3DDraw;

/**
 * This is a helper class that stores simple geometric primitives so that they
 * can be rendered for debug purposes.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 01.08.2009
 */
public class DebugPrimitives implements Renderable {

	private static DebugPrimitives INSTANCE;

	public static DebugPrimitives getInstance() {

		if (INSTANCE == null)
			INSTANCE = new DebugPrimitives();

		return INSTANCE;
	}

	public static boolean hasInstance() {

		return INSTANCE != null;
	}

	private Map<Object, Vector3f[]> m_lines = new HashMap<Object, Vector3f[]>();

	private Map<Object, Vector3f> m_points = new HashMap<Object, Vector3f>();

	private Map<Object, Vector3f[]> m_rays = new HashMap<Object, Vector3f[]>();

	private Map<Object, Vector3f[]> m_segments =
		new HashMap<Object, Vector3f[]>();

	private DebugPrimitives() {

		// empty;
	}

	public void addLine(Object i_key, IVector3f i_p1, IVector3f i_p2) {

		if (i_key == null)
			throw new NullPointerException("i_key must not be null");

		if (i_p1 == null)
			throw new NullPointerException("i_p1 must not be null");

		if (i_p2 == null)
			throw new NullPointerException("i_p2 must not be null");

		Vector3f[] line = m_lines.get(i_key);
		if (line == null) {
			line = new Vector3f[] { new Vector3fImpl(), new Vector3fImpl() };
			m_lines.put(i_key, line);
		}

		line[0].set(i_p1);
		line[1].set(i_p2);
	}

	public void addPoint(Object i_key, IVector3f i_p) {

		if (i_key == null)
			throw new NullPointerException("i_key must not be null");

		if (i_p == null)
			throw new NullPointerException("i_p must not be null");

		Vector3f point = m_points.get(i_key);
		if (point == null) {
			point = new Vector3fImpl();
			m_points.put(i_key, point);
		}

		point.set(i_p);
	}

	public void addRay(Object i_key, IVector3f i_rayOrigin,
		IVector3f i_rayDirection) {

		if (i_key == null)
			throw new NullPointerException("i_key must not be null");

		if (i_rayOrigin == null)
			throw new NullPointerException("i_rayOrigin must not be null");

		if (i_rayDirection == null)
			throw new NullPointerException("i_rayDirection must not be null");

		Vector3f[] ray = m_rays.get(i_key);
		if (ray == null) {
			ray = new Vector3f[] { new Vector3fImpl(), new Vector3fImpl() };
			m_rays.put(i_key, ray);
		}

		ray[0].set(i_rayOrigin);
		ray[1].set(i_rayDirection);
	}

	public void addSegment(Object i_key, IVector3f i_p1, IVector3f i_p2) {

		if (i_key == null)
			throw new NullPointerException("i_key must not be null");

		if (i_p1 == null)
			throw new NullPointerException("i_p1 must not be null");

		if (i_p2 == null)
			throw new NullPointerException("i_p2 must not be null");

		Vector3f[] segment = m_segments.get(i_key);
		if (segment == null) {
			segment = new Vector3f[] { new Vector3fImpl(), new Vector3fImpl() };
			m_segments.put(i_key, segment);
		}

		segment[0].set(i_p1);
		segment[1].set(i_p2);
	}

	public void clear() {

		m_lines.clear();
		m_rays.clear();
		m_segments.clear();
		m_points.clear();
	}

	private float getFactor(IVector3f i_v) {

		float fx = 10000f / i_v.getX();
		float fy = 10000f / i_v.getY();
		float fz = 10000f / i_v.getZ();

		return Math.min(fx, Math.min(fy, fz));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.Renderable#prerender(org.eclipse.draw3d.RenderContext)
	 */
	public void prerender(@SuppressWarnings("unused") RenderContext i_renderContext) {

		// nothing to do
	}

	// @SuppressWarnings("unused")
	private static Logger log =
		Logger.getLogger(DebugPrimitives.class.getName());

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.Renderable#render(org.eclipse.draw3d.RenderContext)
	 */
	public void render(RenderContext i_renderContext) {

		if (m_warning) {
			log
				.warning("You are using debug primitives. Don't forget to remove them.");
			m_warning = false;
		}

		renderLines(i_renderContext);
		renderRays(i_renderContext);
		renderSegments(i_renderContext);
		renderPoints(i_renderContext);
	}

	private void renderLines(RenderContext i_renderContext) {

		if (m_lines.isEmpty())
			return;

		Vector3f dir = Math3DCache.getVector3f();
		Vector3f start = Math3DCache.getVector3f();
		Vector3f end = Math3DCache.getVector3f();
		try {
			Graphics3D g3D = i_renderContext.getGraphics3D();

			g3D.glLineWidth(1f);
			g3D.glColor4f(1, 0, 0, 0.5f);
			g3D.glBegin(Graphics3DDraw.GL_LINES);
			for (Iterator<Vector3f[]> iter = m_lines.values().iterator(); iter
				.hasNext();) {

				IVector3f[] points = iter.next();
				IVector3f p1 = points[0];
				IVector3f p2 = points[1];

				Math3D.sub(p2, p1, dir);

				float f = getFactor(dir);
				Math3D.scale(f, dir, start);
				Math3D.add(p1, start, start);

				Math3D.scale(-f, dir, end);
				Math3D.add(p1, end, end);

				g3D.glVertex3f(start.getX(), start.getY(), start.getZ());
				g3D.glVertex3f(end.getX(), end.getY(), end.getZ());
			}
			g3D.glEnd();
		} finally {
			Math3DCache.returnVector3f(dir, start, end);
		}
	}

	private void renderPoints(RenderContext i_renderContext) {

		if (m_points.isEmpty())
			return;

		Graphics3D g3D = i_renderContext.getGraphics3D();

		g3D.glPointSize(5);
		g3D.glColor4f(0, 1, 1, 0.5f);
		g3D.glBegin(Graphics3DDraw.GL_POINTS);
		for (Iterator<Vector3f> iter = m_points.values().iterator(); iter
			.hasNext();) {

			IVector3f p = iter.next();
			g3D.glVertex3f(p.getX(), p.getY(), p.getZ());
		}
		g3D.glEnd();

	}

	private void renderRays(RenderContext i_renderContext) {

		if (m_rays.isEmpty())
			return;

		Vector3f end = Math3DCache.getVector3f();
		try {
			Graphics3D g3D = i_renderContext.getGraphics3D();

			g3D.glLineWidth(1f);
			g3D.glColor4f(0, 1, 0, 0.5f);
			g3D.glBegin(Graphics3DDraw.GL_LINES);
			for (Iterator<Vector3f[]> iter = m_rays.values().iterator(); iter
				.hasNext();) {

				Vector3f[] ray = iter.next();
				IVector3f start = ray[0];
				IVector3f direction = ray[1];

				float f = getFactor(direction);
				Math3D.scale(f, direction, end);
				Math3D.add(start, end, end);

				g3D.glVertex3f(start.getX(), start.getY(), start.getZ());
				g3D.glVertex3f(end.getX(), end.getY(), end.getZ());
			}
			g3D.glEnd();
		} finally {
			Math3DCache.returnVector3f(end);
		}
	}

	private boolean m_warning = true;

	private void renderSegments(RenderContext i_renderContext) {

		if (m_segments.isEmpty())
			return;

		Vector3f end = Math3DCache.getVector3f();
		try {
			Graphics3D g3D = i_renderContext.getGraphics3D();

			g3D.glLineWidth(1f);
			g3D.glColor4f(0, 0, 1, 0.5f);
			g3D.glBegin(Graphics3DDraw.GL_LINES);
			for (Iterator<Vector3f[]> iter = m_segments.values().iterator(); iter
				.hasNext();) {

				IVector3f[] segment = iter.next();
				IVector3f p1 = segment[0];
				IVector3f p2 = segment[1];

				g3D.glVertex3f(p1.getX(), p1.getY(), p1.getZ());
				g3D.glVertex3f(p2.getX(), p2.getY(), p2.getZ());
			}
			g3D.glEnd();
		} finally {
			Math3DCache.returnVector3f(end);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.Renderable#collectRenderFragments(org.eclipse.draw3d.RenderContext)
	 */
	public void collectRenderFragments(RenderContext i_renderContext) {
		// TODO implement method Renderable.collectRenderFragments

	}

}
