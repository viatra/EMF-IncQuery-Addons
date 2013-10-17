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
package org.eclipse.gef3d.examples.graph.editor.figures;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ScrollPane;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef3d.editparts.AbstractGraphicalEditPartEx;
import org.eclipse.gef3d.examples.graph.editor.editparts.EdgePart;
import org.eclipse.gef3d.examples.graph.editor.editparts.GraphPartGeneric;
import org.eclipse.gef3d.examples.graph.editor.editparts.VertexPart;
import org.eclipse.gef3d.factories.DisplayMode;
import org.eclipse.gef3d.factories.IFigureFactoryProvider;
import org.eclipse.gef3d.factories.MappedFigureFactory;
import org.eclipse.gef3d.ui.parts.GraphicalViewer3D;

/**
 * Used by graph related {@link AbstractGraphicalEditPartEx} implementations for
 * creating the figures. This factory decouples the edit parts from the figures.
 * Depending on the display mode, 2D or 3D figures are created. Note that the
 * viewer is required to be an {@link IFigureFactoryProvider}, which is usually the
 * case if a {@link GraphicalViewer3D} is used, and this factory needs to be
 * registered at the viewer. 
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Apr 22, 2008
 */
public class GraphFigureFactory extends MappedFigureFactory {

	/**
	 * @param i_mode must not be null
	 */
	public GraphFigureFactory(DisplayMode i_mode) {
		super(i_mode);

		if (i_mode == null) // parameter precondition
			throw new NullPointerException("i_mode must not be null");

		Map<Class<? extends GraphicalEditPart>, Class<? extends IFigure>> map =
			new HashMap<Class<? extends GraphicalEditPart>, Class<? extends IFigure>>();

		// Diagram figure
		switch (getMode()) {
		case TwoDimensional:
			map.put(GraphPartGeneric.class, GraphFigure2D.class);
			break;
		case Projected:
		case ThreeDimensional:
			map.put(GraphPartGeneric.class, GraphFigure3D.class);
		}

		// Content figures
		switch (getMode()) {
		case TwoDimensional:
		case Projected:
			map.put(VertexPart.class, VertexFigure2D.class);
			map.put(EdgePart.class, EdgeFigure2D.class);
			break;
		case ThreeDimensional:
			map.put(VertexPart.class, VertexFigure3D.class);
			map.put(EdgePart.class, EdgeFigure3D.class);
			break;
		}

		setMap(map);

	}

}
