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
package org.eclipse.gef3d.examples.graph.editor.editpolicies;

import java.util.logging.Logger;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef3d.editpolicies.XY3DLayoutPolicy;
import org.eclipse.gef3d.examples.graph.editor.commands.VertexCreateCommand;
import org.eclipse.gef3d.examples.graph.editor.commands.VertexResizeCommand;
import org.eclipse.gef3d.examples.graph.model.Graph;
import org.eclipse.gef3d.examples.graph.model.Vertex;

/**
 * Graph3DLayoutPolicy There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Mar 28, 2008
 */
public class Graph3DLayoutPolicy extends XY3DLayoutPolicy {

	/**
	 * Logger for this class
	 */
	@SuppressWarnings("unused")
	private static final Logger log =
		Logger.getLogger(Graph3DLayoutPolicy.class.getName());

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#createChangeConstraintCommand(org.eclipse.gef.EditPart,
	 *      java.lang.Object)
	 */
	@Override
	protected Command createChangeConstraintCommand(EditPart i_child,
		Object i_constraint) {

		Object obj = i_child.getModel();
		Rectangle rect = (Rectangle) i_constraint;
		if (obj instanceof Vertex) {
			return new VertexResizeCommand((Vertex) obj, rect);
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#createSizeOnDropFeedback(org.eclipse.gef.requests.CreateRequest)
	 */
	@Override
	protected IFigure createSizeOnDropFeedback(CreateRequest i_createRequest) {

		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getCreateCommand(org.eclipse.gef.requests.CreateRequest)
	 */
	@Override
	protected Command getCreateCommand(CreateRequest i_request) {

		Object obj = i_request.getNewObject();

		if (obj instanceof Vertex) {
			Graph g = (Graph) this.getHost().getModel();
			Rectangle rect = (Rectangle) getConstraintFor(i_request);

			return new VertexCreateCommand((Vertex) obj, g, rect.x, rect.y,
				rect.width, rect.height);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#showLayoutTargetFeedback(org.eclipse.gef.Request)
	 */
	@Override
	protected void showLayoutTargetFeedback(Request i_request) {

		// nothing to do
	}
}
