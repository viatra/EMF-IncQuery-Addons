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

import org.eclipse.draw3d.graphics.GraphicsState;

/**
 * A primitive that represents a single line.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 25.12.2009
 */
public class LinePrimitive extends AbstractVertexPrimitive {

	/**
	 * Creates a new line primitive that extends from the first given point to
	 * the second given point.
	 * 
	 * @param i_state the current graphics state
	 * @param i_x1 the X coordinate of the line's first point
	 * @param i_y1 the Y coordinate of the line's first point
	 * @param i_x2 the X coordinate of the line's second point
	 * @param i_y2 the Y coordinate of the line's second point
	 */
	public LinePrimitive(GraphicsState i_state, int i_x1, int i_y1, int i_x2,
			int i_y2) {

		super(i_state.getTransformation(), new OutlineRenderRule(i_state),
			new float[] { i_x1, i_y1, i_x2, i_y2 });
	}
}
