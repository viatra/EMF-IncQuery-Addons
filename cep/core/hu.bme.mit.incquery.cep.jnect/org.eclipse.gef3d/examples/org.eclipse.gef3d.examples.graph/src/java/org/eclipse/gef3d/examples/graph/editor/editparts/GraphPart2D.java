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
package org.eclipse.gef3d.examples.graph.editor.editparts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gef3d.editparts.AbstractGraphicalEditPartEx;
import org.eclipse.gef3d.editpolicies.ShowLayoutFeedbackEditPolicy3D;
import org.eclipse.gef3d.examples.graph.editor.GraphEditor2D_3Dfied.GraphPart3Dfied;
import org.eclipse.gef3d.examples.graph.editor.editpolicies.Graph3DLayoutPolicy;
import org.eclipse.gef3d.examples.graph.model.Graph;
import org.eclipse.gef3d.examples.graph.model.Vertex;
import org.eclipse.gef3d.factories.IFigureFactory;

/**
 * Graph edit part only for 2D. This class is used only for demonstration
 * purposes to make clear what has to be 3D-fied later, see
 * {@link GraphPart3Dfied} for details.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 21.11.2007
 */
public class GraphPart2D extends AbstractGraphPart {

	/**
	 * {@inheritDoc}
	 * 
	 * @see AbstractEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		installEditPolicy(ShowLayoutFeedbackEditPolicy3D.ROLE,
			new ShowLayoutFeedbackEditPolicy3D());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new Graph3DLayoutPolicy());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#refreshVisuals()
	 */
	@Override
	protected void refreshVisuals() {

		IFigure fig = getFigure();
		fig.setSize(getMaxPosition());

		super.refreshVisuals();
	}

	protected Dimension getMaxPosition() {

		Graph g = (Graph) getModel();
		Dimension dim = new Dimension(100, 100);
		int f;
		for (Vertex v : g.getVertices()) {
			f = (int) (v.getX() + v.getWidth());
			if (f > dim.width)
				dim.width = f;
			f = (int) (v.getY() + v.getHeight());
			if (f > dim.height)
				dim.height = f;
		}
		dim.width += 5;
		dim.height += 5;
		return dim;
	}

}
