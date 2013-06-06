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

import org.eclipse.draw3d.geometry.IMatrix3f;
import org.eclipse.draw3d.graphics.GraphicsState;

/**
 * A primitive that represents a quadrilateral.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 25.12.2009
 */
public class QuadPrimitive extends AbstractVertexPrimitive {

	/**
	 * Creates a new quadrilateral from a rectangle with the given geometric
	 * properties. The quadrilateral will be solid and filled with a gradient
	 * from the current foreground to the background color.
	 * 
	 * @param i_state the current graphics state
	 * @param i_x the X coordinate of the rectangle
	 * @param i_y the Y coordinate of the rectangle
	 * @param i_width the width of the rectangle
	 * @param i_height the height of the rectangle
	 * @param i_vertical <code>true</code> if the gradient is vertical and
	 *            <code>false</code> if it is horizontal
	 * @return the quadrilateral primitive
	 */
	public static QuadPrimitive createGradientQuad(GraphicsState i_state,
		int i_x, int i_y, int i_width, int i_height, boolean i_vertical) {

		return new QuadPrimitive(i_state.getTransformation(),
			new GradientRenderRule(i_state), getVertices(i_x, i_y, i_width,
				i_height, i_vertical));
	}

	/**
	 * Creates a new quadrilateral from a rectangle with the given geometric
	 * properties. The quadrilateral will be outlined.
	 * 
	 * @param i_state the current graphics state
	 * @param i_x the X coordinate of the rectangle
	 * @param i_y the Y coordinate of the rectangle
	 * @param i_width the width of the rectangle
	 * @param i_height the height of the rectangle
	 * @return the quadrilateral primitive
	 */
	public static QuadPrimitive createOutlineQuad(GraphicsState i_state,
		int i_x, int i_y, int i_width, int i_height) {

		return new QuadPrimitive(i_state.getTransformation(),
			new OutlineRenderRule(i_state), getVertices(i_x, i_y, i_width,
				i_height, false));
	}

	/**
	 * Creates a new quadrilateral from a rectangle with the given geometric
	 * properties. The quadrilateral will be solid.
	 * 
	 * @param i_state the current graphics state
	 * @param i_x the X coordinate of the rectangle
	 * @param i_y the Y coordinate of the rectangle
	 * @param i_width the width of the rectangle
	 * @param i_height the height of the rectangle
	 * @return the quadrilateral primitive
	 */
	public static QuadPrimitive createSolidQuad(GraphicsState i_state, int i_x,
		int i_y, int i_width, int i_height) {

		return new QuadPrimitive(i_state.getTransformation(),
			new SolidRenderRule(i_state), getVertices(i_x, i_y, i_width,
				i_height, false));
	}

	/**
	 * Returns the vertices of a rectangle with the given position and
	 * dimensions. If the last parameter is <code>false</code>, the first vertex
	 * in the array is the vertex at the given position, if it is
	 * <code>true</code>, the first vertex will be the one below this vertex.
	 * 
	 * @param i_x the X coordinate of the rectangle's position
	 * @param i_y the Y coordinate of the rectangle's position
	 * @param i_w the rectangle's width
	 * @param i_h the rectangle's height
	 * @param i_shift <code>true</code> if the vertex array should be left
	 *            shifted by one vertex.
	 * @return the vertex array
	 */
	protected static float[] getVertices(int i_x, int i_y, int i_w, int i_h,
		boolean i_shift) {

		if (i_shift)
			return new float[] { i_x + i_w, i_y, i_x, i_y, i_x, i_y + i_h,
				i_x + i_w, i_y + i_h };

		return new float[] { i_x, i_y, i_x, i_y + i_h, i_x + i_w, i_y + i_h,
			i_x + i_w, i_y };
	}

	/**
	 * Creates a new quadrilateral primitive with the given transformation,
	 * render rule and vertex data.
	 * 
	 * @param i_transformation the transformation, may be <code>null</code>
	 * @param i_renderRule the render rule
	 * @param i_vertices the vertex data
	 * @throws IllegalArgumentException if the given array does not contain
	 *             exactly 8 elements
	 */
	protected QuadPrimitive(IMatrix3f i_transformation,
			RenderRule i_renderRule, float[] i_vertices) {

		super(i_transformation, i_renderRule, i_vertices);

		if (i_vertices.length != 8)
			throw new IllegalArgumentException(
				"a quad must contain exactly four vertices");
	}
}
