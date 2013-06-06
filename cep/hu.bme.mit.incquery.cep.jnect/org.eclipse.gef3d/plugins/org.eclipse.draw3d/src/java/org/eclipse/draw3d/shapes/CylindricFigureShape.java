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

import org.eclipse.draw3d.IFigure3D;
import org.eclipse.draw3d.RenderContext;

/**
 * CylindricFigureShape There should really be more documentation here.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 31.08.2009
 */
public class CylindricFigureShape extends FigureShape<CylinderShape> {

	/**
	 * Creates a new cylindric shape that represents the given figure.
	 * 
	 * @param i_figure the figure which this shape represents
	 * @param i_segments the number of segments of the cylinder
	 * @param i_radiusProportions the radius proportions of the cylinder
	 * @param i_superimposed whether this shape is superimposed
	 * @see CylinderShape#CylinderShape(org.eclipse.draw3d.geometry.IPosition3D,
	 *      int, float, boolean)
	 * @throws NullPointerException if the given figure is <code>null</code>
	 */
	public CylindricFigureShape(IFigure3D i_figure, int i_segments,
			float i_radiusProportions, boolean i_superimposed) {

		super(i_figure, new CylinderShape(i_figure.getPosition3D(), i_segments,
			i_radiusProportions, i_superimposed));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.RenderFragment#render(org.eclipse.draw3d.RenderContext)
	 */
	public void render(RenderContext i_renderContext) {

		getShape().setAlpha(getFigure().getAlpha());
		getShape().setFillColor(getFigure().getBackgroundColor());
		getShape().setOutlineColor(getFigure().getForegroundColor());

		getShape().render(i_renderContext);
	}

	/**
	 * Specifies whether this cylinder should render its faces.
	 * 
	 * @param i_fill <code>true</code> if the cylinder should render its faces
	 *            and <code>false</code> otherwise
	 */
	public void setFill(boolean i_fill) {

		getShape().setFill(i_fill);
	}

	/**
	 * Specifies whether this cylinder should render its outline.
	 * 
	 * @param i_outline <code>true</code> if the cylinder should render its
	 *            outline and <code>false</code> otherwise
	 */
	public void setOutline(boolean i_outline) {

		getShape().setOutline(i_outline);
	}
}
