/*******************************************************************************
 * Copyright (c) 2010 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.gmf.runtime.diagram.ui.editpolicies;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef3d.editpolicies.Handles3DEditPolicy;
import org.eclipse.gef3d.editpolicies.ResizableEditPolicy3D;

/**
 * Handles3DEditPolicyEx installs {@link ResizableEditPolicyEx3D} instead of
 * {@link ResizableEditPolicy3D}.
 *
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	Jun 21, 2010
 */
public class Handles3DEditPolicyEx extends Handles3DEditPolicy {
	/**
	 * @param i_bDeep
	 */
	public Handles3DEditPolicyEx(boolean i_bDeep) {
		super(i_bDeep);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.editpolicies.AbstractDecoratorEditPolicy#createChildEditPolicies(org.eclipse.gef.EditPart)
	 */
	@Override
	protected EditPolicy[] createChildEditPolicies(EditPart i_child) {
		if (!bDeep) {
			return new EditPolicy[] { new ResizableEditPolicyEx3D() };
		} else {
			return new EditPolicy[] { new ResizableEditPolicyEx3D(),
				new Handles3DEditPolicyEx(bDeep) };
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param i_editPolicy must not be null
	 * @see org.eclipse.gef3d.editpolicies.AbstractDecoratorEditPolicy#getRole(org.eclipse.gef.EditPolicy)
	 */
	@Override
	protected Object getRole(EditPolicy i_editPolicy) {
		if (i_editPolicy instanceof ResizableEditPolicy) {
			return EditPolicy.PRIMARY_DRAG_ROLE;
		}
		if (i_editPolicy instanceof Handles3DEditPolicyEx) {
			return Handles3DEditPolicy.CHILD_DECORATOR;
		}

		if (i_editPolicy == null) // parameter precondition
			throw new NullPointerException("i_editPolicy must not be null");

		throw new IllegalArgumentException("Cannot handle policies of type "
			+ i_editPolicy.getClass());
	}
}
