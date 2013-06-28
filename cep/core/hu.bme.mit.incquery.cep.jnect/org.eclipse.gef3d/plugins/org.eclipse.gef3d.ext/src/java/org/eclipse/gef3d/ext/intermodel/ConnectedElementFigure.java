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

package org.eclipse.gef3d.ext.intermodel;

import java.util.logging.Logger;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.Label;
import org.eclipse.draw3d.ShapeFigure3D;
import org.eclipse.draw3d.shapes.CuboidFigureShape;
import org.eclipse.draw3d.shapes.Shape;
import org.eclipse.swt.graphics.Color;

/**
 * ConnectedElementFigure There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 18.01.2008
 */
public class ConnectedElementFigure extends ShapeFigure3D {
	/**
	 * Logger for this class
	 */
	@SuppressWarnings("unused")
	private static final Logger log =
		Logger.getLogger(ConnectedElementFigure.class.getName());

	Label tagLabel;

	public ConnectedElementFigure() {

		// embed 2D components into this figure
		this.setLayoutManager(new FlowLayout());
		Color c = ColorConstants.green;
		setAlpha(200);
		setBackgroundColor(c);

	}

	/**
	 * Returns a transparent cuboid figure shape (i.e. a
	 * {@link CuboidFigureShape} nested into a {@link TransparentShape}.
	 * 
	 * @see org.eclipse.draw3d.ShapeFigure3D#createShape()
	 */
	@Override
	protected Shape createShape() {
		return new CuboidFigureShape(this, false);
	}

	public void setTag(String strTag) {
		tagLabel.setText(strTag);
	}
}
