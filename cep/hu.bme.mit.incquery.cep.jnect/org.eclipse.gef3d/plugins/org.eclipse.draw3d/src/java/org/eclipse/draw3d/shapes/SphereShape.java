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
package org.eclipse.draw3d.shapes;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw3d.RenderContext;
import org.eclipse.draw3d.geometry.IPosition3D;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Position3DImpl;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;
import org.eclipse.draw3d.graphics3d.DisplayListManager;
import org.eclipse.draw3d.graphics3d.Graphics3D;
import org.eclipse.draw3d.graphics3d.Graphics3DDraw;
import org.eclipse.draw3d.picking.Query;
import org.eclipse.draw3d.util.Draw3DCache;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

/**
 * A shape that renders a sphere.
 * 
 * @todo Reuse more vertices for the stripes - currently we create a lot of
 *       duplicates.
 * @todo Dreate entire stripes, not just a single wedge.
 * @todo Due to the approximate nature of the triangulation,
 *       {@link #getDistance(Query)} will only return exact results when the ray
 *       hits a vertex. It would be more precise to intersect with the
 *       individual triangles of the sphere for low precision values.
 * @author Kristian Duske
 * @version $Revision$
 * @since 05.08.2009
 */
public class SphereShape extends PositionableShape {

	/**
	 * A key to store a display list for a sphere in the display list manager.
	 * 
	 * @author Kristian Duske
	 * @version $Revision$
	 * @since 05.06.2009
	 */
	private static class SphereKey {

		private int m_hashCode;

		/**
		 * Creates a new key with the given values.
		 * 
		 * @param i_precision the precision of the sphere
		 * @param i_outline <code>true</code> if this key is for the display
		 *            list that draws the outline and <code>false</code> if it
		 *            is for the display list that fills the cylinder
		 */
		public SphereKey(int i_precision, boolean i_outline) {
			m_hashCode = 17;
			m_hashCode = 37 * m_hashCode + i_precision;
			m_hashCode = 37 * m_hashCode + (i_outline ? 1231 : 1237);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object i_obj) {

			if (i_obj == null)
				return false;

			if (this == i_obj)
				return true;

			if (!(i_obj instanceof SphereKey))
				return false;

			return m_hashCode == i_obj.hashCode();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {

			return m_hashCode;
		}
	}

	private static final IVector3f CENTER = new Vector3fImpl(0.5f, 0.5f, 0.5f);

	private static final float RADIUS = 0.5f;

	private static final float RADIUS_SQUARED = RADIUS * RADIUS;

	/**
	 * Contains a matrix that rotates 90 degress about the Z axis.
	 */
	static final IPosition3D ROTATE_Z90;

	/**
	 * Caches the stripes across multiple instances since they never change.
	 */
	private static final Map<Integer, SphereTriangle[][]> STRIPE_CACHE =
		new HashMap<Integer, SphereTriangle[][]>();

	private static final float[] TMP_F2 = new float[2];

	static {
		Position3DImpl pos = new Position3DImpl();
		pos.setSize3D(new Vector3fImpl(1, 1, 1));
		pos.setRotation3D(new Vector3fImpl(0, 0, (float) Math.PI / 2));

		ROTATE_Z90 = pos;
	}

	private int m_alpha = 0xFF;

	private boolean m_fill = true;

	private Color m_fillColor = Display.getCurrent().getSystemColor(
		SWT.COLOR_WHITE);

	private SphereKey m_fillKey;

	private boolean m_outline = true;

	private Color m_outlineColor = Display.getCurrent().getSystemColor(
		SWT.COLOR_BLACK);

	private SphereKey m_outlineKey;

	private SphereTriangle[][] m_stripes;

	private boolean m_superimposed;

	/**
	 * Creates a new sphere with the given precision. This is a convenient
	 * method creating a non-superimposed shape.
	 * 
	 * @param i_position3D the position of the sphere
	 * @param i_precision the precision of the sphere
	 */
	public SphereShape(IPosition3D i_position3D, int i_precision) {
		this(i_position3D, i_precision, false);
	}

	/**
	 * Creates a new sphere with the given precision.
	 * 
	 * @param i_position3D the position of the sphere
	 * @param i_precision the precision of the sphere
	 * @param i_superimposed whether this shape is superimposed
	 */
	public SphereShape(IPosition3D i_position3D, int i_precision,
			boolean i_superimposed) {

		super(i_position3D);

		m_superimposed = i_superimposed;
		
		m_stripes = STRIPE_CACHE.get(i_precision);

		if (m_stripes == null) {
			Vector3f a = new Vector3fImpl(CENTER);
			a.setX(a.getX() + RADIUS);

			Vector3f b = new Vector3fImpl(CENTER);
			b.setY(b.getY() + RADIUS);

			Vector3f c = new Vector3fImpl(CENTER);
			c.setZ(c.getZ() + RADIUS);

			Vector3f d = new Vector3fImpl(CENTER);
			d.setZ(d.getZ() - RADIUS);

			m_stripes = new SphereTriangle[2][];
			m_stripes[0] = new SphereTriangle[] { new SphereTriangle(a, b, c) };
			m_stripes[1] = new SphereTriangle[] { new SphereTriangle(a, b, d) };

			for (int i = 1; i <= i_precision; i++) {

				// initialize stripes arrays
				int numStripes = (2 << i); // 2^(p+1)
				SphereTriangle[][] newStripes =
					new SphereTriangle[numStripes][];
				for (int j = 0; j < numStripes / 2; j++) {
					int numTriangles = j * 2 + 1;
					newStripes[j] = new SphereTriangle[numTriangles];
					newStripes[numStripes - j - 1] =
						new SphereTriangle[numTriangles];
				}

				// divide stripes
				for (int j = 0; j < m_stripes.length; j++) {
					SphereTriangle[] stripe = m_stripes[j];
					SphereTriangle[] newUpper = newStripes[j * 2];
					SphereTriangle[] newLower = newStripes[j * 2 + 1];

					int upperIndex = 0;
					int lowerIndex = 0;

					for (int k = 0; k < stripe.length; k++) {
						SphereTriangle triangle = stripe[k];
						SphereTriangle[] subTriangles =
							triangle.divide(CENTER, RADIUS);

						// is the triangle standing on the segment a-b or on
						// the edge c?
						if (triangle.getC().getZ() > triangle.getA().getZ()) {
							newUpper[upperIndex++] = subTriangles[0];
							newLower[lowerIndex++] = subTriangles[1];
							newLower[lowerIndex++] = subTriangles[2];
							newLower[lowerIndex++] = subTriangles[3];
						} else {
							newLower[lowerIndex++] = subTriangles[0];
							newUpper[upperIndex++] = subTriangles[1];
							newUpper[upperIndex++] = subTriangles[2];
							newUpper[upperIndex++] = subTriangles[3];
						}
					}
				}

				m_stripes = newStripes;
			}

			STRIPE_CACHE.put(i_precision, m_stripes);
		}
		m_outlineKey = new SphereKey(i_precision, true);
		m_fillKey = new SphereKey(i_precision, false);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.shapes.PositionableShape#doGetDistance(org.eclipse.draw3d.geometry.IVector3f,
	 *      org.eclipse.draw3d.geometry.IVector3f, java.util.Map)
	 */
	@Override
	protected float doGetDistance(IVector3f i_rayOrigin,
		IVector3f i_rayDirection, Map<Object, Object> i_context) {

		// TODO: intersect with individual triangles for low precision

		// vector from ray origin to sphere center
		Vector3f roToC = Draw3DCache.getVector3f();
		// projection of roToC onto the ray
		Vector3f proj = Draw3DCache.getVector3f();
		// vector from origin + proj to sphere center
		Vector3f orth = Draw3DCache.getVector3f();
		try {
			// vector from ray origin to center
			Math3D.sub(CENTER, i_rayOrigin, roToC);

			// project that vector onto the ray direction
			float dot = Math3D.dot(roToC, i_rayDirection);
			Math3D.scale(dot, i_rayDirection, proj);

			Math3D.sub(roToC, proj, orth);

			// vector orth is now orthogonal to ray direction and points to
			// center, its length measures the minimum distance between ray and
			// center
			if (orth.lengthSquared() > RADIUS_SQUARED)
				return Float.NaN;

			// compute solutions of ray equation inserted into sphere equation
			float B = -2 * dot;
			float C = roToC.length() - RADIUS_SQUARED;

			Math3D.solveQuadraticEquation(B, C, TMP_F2);
			return Math3D.minDistance(TMP_F2);
		} finally {
			Draw3DCache.returnVector3f(roToC, proj, orth);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.shapes.PositionableShape#doRender(org.eclipse.draw3d.RenderContext)
	 */
	@Override
	protected void doRender(RenderContext i_renderContext) {

		Graphics3D g3d = i_renderContext.getGraphics3D();
		DisplayListManager displayListManager =
			i_renderContext.getGraphics3D().getDisplayListManager();

		initDisplayLists(displayListManager, g3d);

		if (m_fill) {
			g3d.glColor(m_fillColor, m_alpha);
			displayListManager.executeDisplayList(m_fillKey);
		}

		if (m_outline) {
			g3d.glColor(m_outlineColor, m_alpha);
			displayListManager.executeDisplayList(m_outlineKey);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.RenderFragment#getRenderType()
	 */
	public RenderType getRenderType() {

		return RenderType.getRenderType(m_alpha, m_superimposed);
	}

	private void initDisplayLists(DisplayListManager i_manager,
		final Graphics3D i_graphics3D) {

		boolean initFill = m_fill && !i_manager.isDisplayList(m_fillKey);
		boolean initOutline =
			m_outline && !i_manager.isDisplayList(m_outlineKey);

		if (!initFill && !initOutline)
			return;

		i_manager.interruptDisplayList();
		try {
			if (initFill) {
				i_manager.createDisplayList(m_fillKey, new Runnable() {
					public void run() {
						i_graphics3D.glPushMatrix();
						try {
							renderFill(i_graphics3D);
							for (int i = 0; i < 3; i++) {
								i_graphics3D.setPosition(ROTATE_Z90);
								renderFill(i_graphics3D);
							}
						} finally {
							i_graphics3D.glPopMatrix();
						}
					}
				});
			}

			if (initOutline) {
				i_manager.createDisplayList(m_outlineKey, new Runnable() {
					public void run() {
						i_graphics3D.glPushMatrix();
						try {
							renderOutline(i_graphics3D);
							for (int i = 0; i < 3; i++) {
								i_graphics3D.setPosition(ROTATE_Z90);
								renderOutline(i_graphics3D);
							}
						} finally {
							i_graphics3D.glPopMatrix();
						}
					}
				});
			}
		} finally {
			i_manager.resumeDisplayList();
		}
	}

	void renderFill(Graphics3D i_g3d) {

		i_g3d.glColor4f(0, 0, 1, 0.5f);
		i_g3d.glPolygonMode(Graphics3DDraw.GL_FRONT_AND_BACK,
			Graphics3DDraw.GL_FILL);

		for (int i = 0; i < m_stripes.length; i++) {
			SphereTriangle[] stripe = m_stripes[i];

			if (i < m_stripes.length / 2) {
				i_g3d.glBegin(Graphics3DDraw.GL_TRIANGLE_STRIP);
				for (int j = stripe.length - 1; j >= 0; j -= 2) {
					i_g3d.glVertex3f(stripe[j].getB());
					i_g3d.glVertex3f(stripe[j].getC());
				}
				i_g3d.glVertex3f(stripe[0].getA());
				i_g3d.glEnd();
			} else {
				i_g3d.glBegin(Graphics3DDraw.GL_TRIANGLE_STRIP);
				for (int j = 0; j < stripe.length; j += 2) {
					i_g3d.glVertex3f(stripe[j].getA());
					i_g3d.glVertex3f(stripe[j].getC());
				}
				i_g3d.glVertex3f(stripe[stripe.length - 1].getB());
				i_g3d.glEnd();
			}
		}
	}

	void renderOutline(Graphics3D i_g3d) {

		i_g3d.glColor4f(1, 0, 0, 0.5f);

		for (int i = 0; i < m_stripes.length; i++) {
			SphereTriangle[] stripe = m_stripes[i];

			// equator and parallels
			if (i < m_stripes.length / 2) {
				i_g3d.glBegin(Graphics3DDraw.GL_LINE_STRIP);
				for (int j = 0; j < stripe.length; j += 2)
					i_g3d.glVertex3f(stripe[j].getA());
				i_g3d.glVertex3f(stripe[stripe.length - 1].getB());
				i_g3d.glEnd();
			} else {
				if (i < m_stripes.length - 1) {
					i_g3d.glBegin(Graphics3DDraw.GL_LINE_STRIP);
					for (int j = 1; j < stripe.length; j += 2)
						i_g3d.glVertex3f(stripe[j].getA());
					i_g3d.glVertex3f(stripe[stripe.length - 2].getB());
					i_g3d.glEnd();
				}
			}

			// zig-zag
			i_g3d.glBegin(Graphics3DDraw.GL_LINE_STRIP);
			i_g3d.glVertex3f(stripe[0].getA());
			for (int j = 0; j < stripe.length; j++)
				i_g3d.glVertex3f(stripe[j].getC());
			i_g3d.glEnd();
		}
	}

	/**
	 * Sets the alpha value of this shape.
	 * 
	 * @param i_alpha the alpha value, should be between 0 and 255, inclusive
	 */
	public void setAlpha(int i_alpha) {

		m_alpha = i_alpha;
	}

	/**
	 * Specifies whether the polygons should be filled.
	 * 
	 * @param i_fill <code>true</code> if the polygons should be filled and
	 *            <code>false</code> otherwise
	 */
	public void setFill(boolean i_fill) {

		m_fill = i_fill;
	}

	/**
	 * Sets the fill color of this sphere.
	 * 
	 * @param i_color the fill color
	 * @param i_alpha the alpha value
	 */
	public void setFillColor(Color i_color) {

		m_fillColor = i_color;
	}

	/**
	 * Specifies whether an outline should be drawn.
	 * 
	 * @param i_outline <code>true</code> if an outline should be drawn and
	 *            <code>false</code> otherwise
	 */
	public void setOutline(boolean i_outline) {

		m_outline = i_outline;
	}

	/**
	 * Sets the outline color of this sphere.
	 * 
	 * @param i_color the outline color
	 * @param i_alpha the alpha value
	 */
	public void setOutlineColor(Color i_color) {

		m_outlineColor = i_color;
	}
}
