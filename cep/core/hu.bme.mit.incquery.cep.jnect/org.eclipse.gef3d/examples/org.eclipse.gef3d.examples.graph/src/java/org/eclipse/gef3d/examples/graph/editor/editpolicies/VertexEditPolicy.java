/*******************************************************************************
 * Copyright (c) 2009 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.examples.graph.editor.editpolicies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gef3d.examples.graph.editor.commands.EdgeCreateCommand;
import org.eclipse.gef3d.examples.graph.model.Edge;
import org.eclipse.gef3d.examples.graph.model.Vertex;

/**
 * GraphNodeEditPolicy There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since May 22, 2009
 */
public class VertexEditPolicy extends GraphicalNodeEditPolicy {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCreateCommand(org.eclipse.gef.requests.CreateConnectionRequest)
	 */
	@Override
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		Object obj = request.getNewObject();
		if (obj instanceof Edge) {
			EdgeCreateCommand cmd =
				new EdgeCreateCommand((Edge)obj, (Vertex) getHost().getModel());

			request.setStartCommand(cmd);
			return cmd;
		}
		return null;
	}
	
	

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCompleteCommand(org.eclipse.gef.requests.CreateConnectionRequest)
	 */
	@Override
	protected Command getConnectionCompleteCommand(
		CreateConnectionRequest request) {
		EdgeCreateCommand cmd = (EdgeCreateCommand) request.getStartCommand();
		cmd.setTarget((Vertex) getHost().getModel());
		return cmd;

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectSourceCommand(org.eclipse.gef.requests.ReconnectRequest)
	 */
	@Override
	protected Command getReconnectSourceCommand(ReconnectRequest i_request) {
		// TODO implement method GraphNodeEditPolicy.getReconnectSourceCommand
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectTargetCommand(org.eclipse.gef.requests.ReconnectRequest)
	 */
	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest i_request) {
		// TODO implement method GraphNodeEditPolicy.getReconnectTargetCommand
		return null;
	}

}
