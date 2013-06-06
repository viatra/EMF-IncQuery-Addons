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
package org.eclipse.gef3d.editpolicies;

import org.eclipse.draw3d.PolylineConnection3D;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;

/**
 * Policy for creating 3D connection feedback figures, that is create a
 * {@link PolylineConnection3D} indicating source feedback. This policy
 * is intended to be installed <em>before</em> the actual {@link GraphicalNodeEditPolicy}
 * is installed, in order to get called before this policy. It only creates
 * the feedback figure, i.e. the only method returning non-null is
 * {@link GraphicalNodeEditPolicy#showSourceFeedback(Request)}.
 * If used in conjunction with a "borg factory" (BorgEditPartFactory),
 * this policy has to be directly installed after the creation of an object
 * and not when the policies are modified. To avoid this policy top be replaced
 * by the actual node edit policy, is should be installed with role
 * {@link #ROLE}.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since May 31, 2009
 */
public class ShowSourceFeedback3DEditPolicy extends GraphicalNodeEditPolicy3D {

	public final static String ROLE = "SHOW_SOURCE_FEEDBACK_3D";
	
	/**
	 * Returns null, this policy is only intended to create a source feedback
	 * request.
	 * 
	 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCompleteCommand(org.eclipse.gef.requests.CreateConnectionRequest)
	 */
	@Override
	protected Command getConnectionCompleteCommand(
		CreateConnectionRequest i_request) {
		return null;
	}

	/**
	 * Returns null, this policy is only intended to create a source feedback
	 * request.
	 * 
	 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCreateCommand(org.eclipse.gef.requests.CreateConnectionRequest)
	 */
	@Override
	protected Command getConnectionCreateCommand(
		CreateConnectionRequest i_request) {
		return null;
	}

	/**
	 * Returns null, this policy is only intended to create a source feedback
	 * request.
	 * 
	 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectSourceCommand(org.eclipse.gef.requests.ReconnectRequest)
	 */
	@Override
	protected Command getReconnectSourceCommand(ReconnectRequest i_request) {
		return null;
	}

	/**
	 * Returns null, this policy is only intended to create a source feedback
	 * request.
	 * 
	 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectTargetCommand(org.eclipse.gef.requests.ReconnectRequest)
	 */
	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest i_request) {
		return null;
	}

}
