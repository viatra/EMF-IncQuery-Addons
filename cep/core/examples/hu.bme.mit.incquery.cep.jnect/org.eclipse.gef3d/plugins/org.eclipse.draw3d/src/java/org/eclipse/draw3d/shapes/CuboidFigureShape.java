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
import org.eclipse.draw3d.graphics3d.Graphics3D;

/**
 * A figure shape that renders itself as a cuboid.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 05.08.2009
 */
public class CuboidFigureShape extends FigureShape<CuboidShape> {

	/**
	 * Creates a new cuboid figure shape. The figure is not superimposed, this
	 * is a convenient method, it's equal to
	 * {@link #CuboidFigureShape(IFigure3D, boolean)}.
	 * 
	 * @param i_figure the figure which this shape represents
	 */
	public CuboidFigureShape(IFigure3D i_figure) {

		this(i_figure, false);
	}

	/**
	 * Creates a new cuboid figure shape.
	 * 
	 * @param i_figure the figure which this shape represents
	 * @param i_superimposed whether this shape is superimposed
	 */
	public CuboidFigureShape(IFigure3D i_figure, boolean i_superimposed) {

		super(i_figure, new CuboidShape(i_figure.getPosition3D(),
			i_superimposed));
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

		Graphics3D g3d = i_renderContext.getGraphics3D();
		if (g3d.hasGraphics2D(getFigure()))
			getShape().setTextureId(g3d.getGraphics2DId(getFigure()));
		else
			getShape().setTextureId(null);

		getShape().render(i_renderContext);
	}

	/**
	 * Specifies whether this cuboid should render its faces.
	 * 
	 * @param i_fill <code>true</code> if the cuboid should render its faces and
	 *            <code>false</code> otherwise
	 */
	public void setFill(boolean i_fill) {

		getShape().setFill(i_fill);
	}

	/**
	 * Specifies whether this cuboid should render its outline.
	 * 
	 * @param i_outline <code>true</code> if the cuboid should render its
	 *            outline and <code>false</code> otherwise
	 */
	public void setOutline(boolean i_outline) {

		getShape().setOutline(i_outline);
	}
}
