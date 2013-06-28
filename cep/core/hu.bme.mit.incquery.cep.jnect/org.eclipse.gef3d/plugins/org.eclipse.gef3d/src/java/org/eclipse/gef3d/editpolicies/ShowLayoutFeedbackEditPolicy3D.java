/*******************************************************************************
 * Copyright (c) 2009 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.editpolicies;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;

/**
 * Displays a 3D feedback figure when creating new nodes. The actual
 * implementation is inherited from {@link LayoutEditPolicy3D}.
 * 
 * @author Jens von Pilgrim
 * @author Kristian Duske
 * @version $Revision$
 * @since 30.07.2009
 */
public class ShowLayoutFeedbackEditPolicy3D extends LayoutEditPolicy3D {

	/**
	 * The name of the role of this edit policy.
	 */
	public static final String ROLE = "SHOW_LAYOUT_FEEDBACK_3D";

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#createChildEditPolicy(org.eclipse.gef.EditPart)
	 */
	@Override
	protected EditPolicy createChildEditPolicy(EditPart i_child) {

		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getCreateCommand(org.eclipse.gef.requests.CreateRequest)
	 */
	@Override
	protected Command getCreateCommand(CreateRequest i_request) {

		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getMoveChildrenCommand(org.eclipse.gef.Request)
	 */
	@Override
	protected Command getMoveChildrenCommand(Request i_request) {

		return null;
	}
}
