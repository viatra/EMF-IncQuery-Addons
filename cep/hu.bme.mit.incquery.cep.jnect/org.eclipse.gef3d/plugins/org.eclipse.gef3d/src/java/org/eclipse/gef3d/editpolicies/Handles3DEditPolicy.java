/*
 * Type:    de.feu.gef3d.topcased.modeler.uml.classdiagram.Handles3DEditPolicy
 * File:  	Handles3DEditPolicy.java
 * Project:	de.feu.gef3d.topcased
 * Date: 	May 5, 2008
 * Author: 	Jens von Pilgrim
 * Version:	$Revision$
 * Changed: $Date$ by $Author$ 
 * URL:     $HeadURL$
 *
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.gef3d.editpolicies;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy;

/**
 * This policy decorates the child edit parts of its host edit parts by adding
 * appropriate policies for creating handles and feedback figures. Usually, this
 * task is fulfilled by a layout policy (see for example
 * {@link ConstrainedLayoutEditPolicy#createChildEditPolicy(EditPart)}. But we
 * need 3D handles and feedback figures while the layout manager itself can be
 * resued (on the surface, the original 2D code can be reused). So we have to
 * manage the creation of appropriate 3D handles and feedback figures
 * separately.
 * <p>
 * This policy itself is installed by a provider (GMF style), see
 * {@link org.eclipse.gef3d.gmf.runtime.diagram.ui.services.editpolicy.Handles3DEditPolicyProvider3D}
 * . If only GEF is used, this policy must be installed, for example by using
 * the borg factory pattern and an assimilator installing new policies). The
 * role of this policy is usually {@link #CHILD_DECORATOR}.
 * </p>
 * 
 * @author Jens von Pilgrim, Kristian Duske
 * @version $Revision$
 * @since May 5, 2008
 */
public class Handles3DEditPolicy extends AbstractDecoratorEditPolicy {

	/**
	 * The role for this edit policy. This role is also used when the policy is
	 * deeply installed, that is when an instance of this policy class is
	 * additionally installed to the children (which causes an recursive
	 * installation).
	 */
	public static final Object CHILD_DECORATOR =
		"Handles3DEditPolicy Child Decorator";

	/**
	 * If true, an instance of this class is installed to the children as well.
	 */
	protected boolean bDeep = false;

	/**
	 * @param i_bDeep
	 */
	public Handles3DEditPolicy(boolean i_bDeep) {
		bDeep = i_bDeep;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.editpolicies.AbstractDecoratorEditPolicy#createChildEditPolicies(org.eclipse.gef.EditPart)
	 */
	@Override
	protected EditPolicy[] createChildEditPolicies(EditPart i_child) {
		if (!bDeep) {
			return new EditPolicy[] { new ResizableEditPolicy3D() };
		} else {
			return new EditPolicy[] { new ResizableEditPolicy3D(),
				new Handles3DEditPolicy(bDeep) };
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
		if (i_editPolicy instanceof ResizableEditPolicy3D) {
			return EditPolicy.PRIMARY_DRAG_ROLE;
		}
		if (i_editPolicy instanceof Handles3DEditPolicy) {
			return Handles3DEditPolicy.CHILD_DECORATOR;
		}

		if (i_editPolicy == null) // parameter precondition
			throw new NullPointerException("i_editPolicy must not be null");

		throw new IllegalArgumentException("Cannot handle policies of type "
			+ i_editPolicy.getClass());
	}

}