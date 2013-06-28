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
package org.eclipse.gef3d.gmf.runtime.diagram.ui.services.editpolicy;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef3d.editpolicies.Handles3DEditPolicy;
import org.eclipse.gef3d.editpolicies.ShowLayoutFeedbackEditPolicy3D;
import org.eclipse.gef3d.editpolicies.ShowSourceFeedback3DEditPolicy;
import org.eclipse.gef3d.gmf.runtime.core.service.ProviderAcceptor;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;

/**
 * Adds policy for enabling 3D feedbck when creating or reconnecting
 * connections.
 * <p>
 * This provider uses the {@link ProviderAcceptor} in order to check whether is
 * has to provide the functionality in the given context. Here, the acceptor
 * must accept 3D policies, i.e. {@link ProviderAcceptor#isGEF3D()} must return
 * true.
 * </p>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 06.01.2009
 */
public class FeedbackHelper3DEditPolicyProvider3D extends AbstractProvider
		implements IEditPolicyProvider {

	private static final Logger log =
		Logger.getLogger(FeedbackHelper3DEditPolicyProvider3D.class.getName());

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider#createEditPolicies(org.eclipse.gef.EditPart)
	 */
	public void createEditPolicies(EditPart i_editPart) {

		if (log.isLoggable(Level.INFO))
			log.fine("modifying edit policies of "
				+ i_editPart.getClass().getName());

		

		// show feedback when creating connections
		i_editPart.installEditPolicy(ShowSourceFeedback3DEditPolicy.ROLE,
			new ShowSourceFeedback3DEditPolicy());

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
	 */
	public boolean provides(IOperation i_operation) {
		if (i_operation instanceof CreateEditPoliciesOperation) {
			EditPart editPart =
				((CreateEditPoliciesOperation) i_operation).getEditPart();

			if (editPart instanceof NodeEditPart) {
				return ProviderAcceptor.evaluate3DAcceptance(this, i_operation);
			}
		}

		return false;

	}

}
