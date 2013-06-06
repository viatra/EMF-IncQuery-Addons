/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.gmf.runtime.diagram.ui.services.editpolicy;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef3d.editpolicies.Handles3DEditPolicy;
import org.eclipse.gef3d.editpolicies.ShowLayoutFeedbackEditPolicy3D;
import org.eclipse.gef3d.gmf.runtime.core.service.ProviderAcceptor;
import org.eclipse.gef3d.gmf.runtime.diagram.ui.editpolicies.Handles3DEditPolicyEx;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;

/**
 * Adds policies for 3D handles. This policy provider is registered to
 * extension point "org.eclipse.gmf.runtime.diagram.ui.editpolicyProviders"
 * in the <i>plugin.xml</i> of <code>plugin org.eclipse.gef3d.gmf</code>
 * 
 * @author Kristian Duske, Jens von Pilgrim
 * @version $Revision$
 * @since 06.01.2009
 */
public class Handles3DEditPolicyProvider3D extends AbstractProvider implements
		IEditPolicyProvider {

	private static final Logger log =
		Logger.getLogger(Handles3DEditPolicyProvider3D.class.getName());

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider#createEditPolicies(org.eclipse.gef.EditPart)
	 */
	public void createEditPolicies(EditPart i_editPart) {

		if (log.isLoggable(Level.INFO))
			log.fine("modifying edit policies of "
				+ i_editPart.getClass().getName());

		// show feedback when creating new nodes
		i_editPart.installEditPolicy(ShowLayoutFeedbackEditPolicy3D.ROLE,
			new ShowLayoutFeedbackEditPolicy3D());
		
		// show handles
		i_editPart.installEditPolicy(Handles3DEditPolicy.CHILD_DECORATOR, //EditPolicy.PRIMARY_DRAG_ROLE,
			new Handles3DEditPolicyEx(true));
		
		
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

			if (editPart instanceof GraphicalEditPart) { // DiagramEditPart) {
				if (ProviderAcceptor.evaluate3DAcceptance(this, i_operation))
					return true;
			} else {
				if (log.isLoggable(Level.INFO)) {
					log.info("Do not support this kind of edit part - editPart=" + editPart); //$NON-NLS-1$
				}
			}
		}

		return false;

	}

}
