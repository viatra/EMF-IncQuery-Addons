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
package org.eclipse.draw3d;

import org.eclipse.draw3d.shapes.CylindricFigureShape;
import org.eclipse.draw3d.shapes.Shape;

/**
 * A decoration figure that renders an arrow head.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 20.09.2009
 */
public class ArrowDecoration3D extends ShapeDecoration {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.ShapeFigure3D#createShape()
	 */
	@Override
	protected Shape createShape() {

		CylindricFigureShape s = new CylindricFigureShape(this, 12, 0, false);
		s.setFill(true);
		s.setOutline(true);

		return s;
	}

	/**
	 * Specifies whether the arrow head should be filled with the background
	 * color.
	 * 
	 * @param i_fill <code>true</code> if the arrow head should be filled and
	 *            <code>false</code> otherwise
	 */
	public void setFill(boolean i_fill) {

		((CylindricFigureShape) getShape()).setFill(i_fill);
	}

	/**
	 * Specifies whether the arrow head should be outlined with the foreground
	 * color.
	 * 
	 * @param i_outline <code>true</code> if the arrow should be outlined and
	 *            <code>false</code> otherwise
	 */
	public void setOutline(boolean i_outline) {

		((CylindricFigureShape) getShape()).setOutline(i_outline);
	}
}
