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
package org.eclipse.gef3d.gmf.runtime.diagram.ui.figures;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw3d.FigureSurface;
import org.eclipse.draw3d.ISurface;
import org.eclipse.draw3d.ShapeFigure3D;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;
import org.eclipse.draw3d.shapes.CuboidFigureShape;
import org.eclipse.draw3d.shapes.Shape;

/**
 * A 3D figure that renders itself as a cuboid. This figure calculates its
 * preferred size so that it can contain all its 2D children and it has a
 * surface. Its initial size is set to the {link #DEFAULT_SIZE}. To use the
 * preferred size, an appropriate layout manager has to be set to the containing
 * figure.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 23.09.2009
 */
public class DiagramFigure3D extends ShapeFigure3D {

	private static final IVector3f DEFAULT_SIZE =
		new Vector3fImpl(500, 500, 20);

	private ISurface m_surface = new FigureSurface(this);

	/**
	 * Creates a new instance.
	 */
	public DiagramFigure3D() {

		getPosition3D().setSize3D(DEFAULT_SIZE);
		setLayoutManager(new FreeformLayout());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.ShapeFigure3D#createShape()
	 */
	@Override
	protected Shape createShape() {

		return new CuboidFigureShape(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Figure#getPreferredSize(int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Dimension getPreferredSize(int i_wHint, int i_hHint) {

		Dimension preferredSize = super.getPreferredSize(i_wHint, i_hHint);
		union(preferredSize, getChildren());

		if (connectionLayer != null)
			union(preferredSize, connectionLayer.getChildren());

		return preferredSize;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.Figure3D#getSurface()
	 */
	@Override
	public ISurface getSurface() {

		return m_surface;
	}

	@SuppressWarnings("unchecked")
	private void union(Dimension i_d, Collection i_figures) {

		for (Iterator i = i_figures.iterator(); i.hasNext();) {
			IFigure child = (IFigure) i.next();
			Rectangle childBounds = child.getBounds();

			int r = childBounds.x + childBounds.width;
			int b = childBounds.y + childBounds.height;
			i_d.width = Math.max(i_d.width, r);
			i_d.height = Math.max(i_d.height, b);
		}
	}
}
