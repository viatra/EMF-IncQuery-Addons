/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.handles;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw3d.ShapeFigure3D;
import org.eclipse.draw3d.shapes.CuboidFigureShape;
import org.eclipse.draw3d.shapes.Shape;

/**
 * Cube like transparent figure used for visualizing feedback during edit
 * operations like resizing. While GEF uses a RectangleFigure, here an explicit
 * figure is used.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Mar 31, 2008
 */
public class FeedbackFigure3D extends ShapeFigure3D {

	/**
	 * Creates a new feedback figure.
	 */
	public FeedbackFigure3D() {

		setBackgroundColor(ColorConstants.blue);
		setForegroundColor(ColorConstants.black);
		setAlpha(100);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.ShapeFigure3D#createShape()
	 */
	@Override
	protected Shape createShape() {

		return new CuboidFigureShape(this, true);
	}

}
