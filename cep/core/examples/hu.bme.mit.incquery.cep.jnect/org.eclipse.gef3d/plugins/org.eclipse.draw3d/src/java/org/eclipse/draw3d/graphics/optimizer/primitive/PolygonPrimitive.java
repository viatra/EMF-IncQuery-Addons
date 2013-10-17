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

import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw3d.graphics.GraphicsState;

/**
 * A primitive that represents a polygon. Polygons can be solid or outlined.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 25.12.2009
 */
public class PolygonPrimitive extends AbstractVertexPrimitive {

	/**
	 * Creates a new polygon with the given vertex data.
	 * 
	 * @param i_state the current graphics state
	 * @param i_vertices the vertex data as a point list
	 * @param i_solid <code>true</code> if the polygon is solid and
	 *            <code>false</code> if it is outlined
	 * @throws IllegalArgumentException if the given point list contains less
	 *             than three vertices
	 */
	public PolygonPrimitive(GraphicsState i_state, PointList i_vertices,
			boolean i_solid) {

		super(i_state.getTransformation(), i_solid ? new SolidRenderRule(
			i_state) : new OutlineRenderRule(i_state), i_vertices);

		if (i_vertices.size() < 3)
			throw new IllegalArgumentException(
				"a polygon must contain at least three vertices");
	}

	/**
	 * Creates a new polygon with the given vertex data.
	 * 
	 * @param i_state the current graphics state
	 * @param i_vertices the vertex data as a float array
	 * @param i_solid <code>true</code> if the polygon is solid and
	 *            <code>false</code> if it is outlined
	 * @throws IllegalArgumentException if the given array contains an uneven
	 *             number of elements or less than three vertices
	 */
	public PolygonPrimitive(GraphicsState i_state, float[] i_vertices,
			boolean i_solid) {

		super(i_state.getTransformation(), i_solid ? new SolidRenderRule(
			i_state) : new OutlineRenderRule(i_state), i_vertices);

		if (i_vertices.length < 6)
			throw new IllegalArgumentException(
				"a polygon must contain at least three vertices");
	}
}
