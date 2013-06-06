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

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef3d.examples.graph.editor.GraphEditor2D_3Dfied.GraphPart3Dfied;
import org.eclipse.gef3d.examples.graph.editor.commands.VertexCreateCommand;
import org.eclipse.gef3d.examples.graph.editor.commands.VertexResizeCommand;
import org.eclipse.gef3d.examples.graph.model.Graph;
import org.eclipse.gef3d.examples.graph.model.Vertex;

/**
 * 2D edit policy, used for demonstration purposes only, see
 * {@link GraphPart3Dfied} for details.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Mar 28, 2008
 */
public class GraphLayoutPolicy extends XYLayoutEditPolicy {

	/**
	 * Logger for this class
	 */
	private static final Logger log =
		Logger.getLogger(GraphLayoutPolicy.class.getName());

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
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getCreateCommand(org.eclipse.gef.requests.CreateRequest)
	 */
	@Override
	protected Command getCreateCommand(CreateRequest i_request) {
		Object obj = i_request.getNewObject();
		// Host == Context in strategy pattern
		Graph graph = (Graph) getHost().getModel();
		

		if (obj instanceof Vertex) {
			Rectangle rect = (Rectangle) getConstraintFor(i_request);
			return new VertexCreateCommand((Vertex) obj, graph, rect.x, rect.y,
				rect.width, rect.height);
		}
		// type not supported:
		return null;
	}

}
