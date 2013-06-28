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
package org.eclipse.draw3d.graphics.optimizer.primitive;

import java.util.Arrays;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw3d.geometry.IMatrix3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Vector2f;
import org.eclipse.draw3d.graphics.optimizer.PrimitiveBounds;
import org.eclipse.draw3d.util.Draw3DCache;

/**
 * Abstract base implementation for {@link VertexPrimitive vertex primitives}.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 25.12.2009
 */
public abstract class AbstractVertexPrimitive extends AbstractPrimitive
		implements VertexPrimitive {

	private static float[] getVertices(PointList i_points) {

		if (i_points == null)
			throw new NullPointerException("i_points must not be null");

		Point p = Draw3DCache.getPoint();
		try {
			int s = i_points.size();
			float[] vertices = new float[2 * s];

			for (int i = 0; i < s; i++) {
				i_points.getPoint(p, i);
				vertices[2 * i] = p.x;
				vertices[2 * i + 1] = p.y;
			}

			return vertices;
		} finally {
			Draw3DCache.returnPoint(p);
		}
	}

	private float[] m_vertices;

	/**
	 * Creates a new primitve with the given transformation, render rule and
	 * vertices.
	 * 
	 * @param i_transformation the transformation, may be <code>null</code>
	 * @param i_renderRule the render rule
	 * @param i_vertices the vertex data
	 * @throws IllegalArgumentException if the given vertex array contains an
	 *             uneven number of elements or less than two vertices
	 * @throws NullPointerException if the given render rule or the given vertex
	 *             data array is <code>null</code>
	 */
	protected AbstractVertexPrimitive(IMatrix3f i_transformation,
			RenderRule i_renderRule, float[] i_vertices) {

		super(i_transformation, i_renderRule);

		if (i_vertices == null)
			throw new NullPointerException("i_vertices must not be null");

		if (i_vertices.length % 2 != 0)
			throw new IllegalArgumentException(
				"i_vertices must contain an even number of elements");

		if (i_vertices.length < 4)
			throw new IllegalArgumentException(
				"i_vertices must contain at least two vertices");

		if (i_transformation != null
			&& !IMatrix3f.IDENTITY.equals(i_transformation)) {

			Vector2f v = Draw3DCache.getVector2f();
			try {
				int s = i_vertices.length / 2;
				m_vertices = new float[2 * s];

				for (int i = 0; i < s; i++) {
					v.set(i_vertices[2 * i], i_vertices[2 * i + 1]);
					Math3D.transform(v, i_transformation, v);
					m_vertices[2 * i] = v.getX();
					m_vertices[2 * i + 1] = v.getY();
				}
			} finally {
				Draw3DCache.returnVector2f(v);
			}
		} else
			m_vertices = i_vertices;
	}

	/**
	 * Creates a new primitve with the given transformation, render rule and
	 * vertices.
	 * 
	 * @param i_transformation the transformation, may be <code>null</code>
	 * @param i_renderRule the render rule
	 * @param i_vertices the vertex data
	 * @throws NullPointerException if the given render rule or the given point
	 *             list is <code>null</code>
	 */
	protected AbstractVertexPrimitive(IMatrix3f i_transformation,
			RenderRule i_renderRule, PointList i_vertices) {

		this(i_transformation, i_renderRule, getVertices(i_vertices));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.AbstractPrimitive#calculateBounds()
	 */
	@Override
	protected PrimitiveBounds calculateBounds() {

		return new PrimitiveBounds(m_vertices);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.VertexPrimitive#getVertexCount()
	 */
	public int getVertexCount() {

		return m_vertices.length / 2;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.VertexPrimitive#getVertices()
	 */
	public float[] getVertices() {

		return m_vertices;
	}

	@Override
	public String toString() {
		return "AbstractVertexPrimitive [m_vertices="
			+ Arrays.toString(m_vertices) + "]";
	}
}
