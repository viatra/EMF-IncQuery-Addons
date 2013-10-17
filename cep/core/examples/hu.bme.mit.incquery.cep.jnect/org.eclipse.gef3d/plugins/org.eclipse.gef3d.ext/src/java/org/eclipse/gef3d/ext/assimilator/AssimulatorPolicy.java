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

package org.eclipse.gef3d.ext.assimilator;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;

/**
 * Calls the assimilators to modify the edit parts (hosts) policies when the
 * edit part is activated. This policy is installed by a
 * {@link BorgEditPartFactory}.
 * <p>
 * The whole process is a little bit tricky due to GEF's design and how edit
 * policies are handles (and accessible from clients). The following list
 * summarizes important "stations" of an edit part regarding its policies:
 * <ol>
 * <li>EditPart is created, no policies are installed</li>
 * <li>Policies are installed, this may be caused by
 * {@link AbstractEditPart#createEditPolicies()} or by any other class calling
 * {@link AbstractEditPart#installEditPolicy(Object, EditPolicy)}.</li>
 * <li>EditPart is activated, this causes the edit part to activate all its
 * installed policies.</li>
 * <li>After all edit polcies have been activated, the EdiPart fires an event
 * indicating that it has been activated.
 * </ol>
 * This {@link AssimulatorPolicy} calls assimilators to modify the policies
 * installed at an {@link EditPart}. Modification means, policies are removed,
 * exchanged or added to or from the EditPart's policy list. The problem is that
 * the internally used iterator ( {@link AbstractEditPart#EditPolicyIterator} is
 * not aware of changes in the list while iterating over it. Especially, it
 * doesn't recognized if the policies are added to the list. That means, that if
 * an assimilator adds a policy in
 * {@link IEditPartAssimilator#modifyPolicies(EditPart)}, this policy does not
 * get activated during in {@link AbstractEditPart#activate()}, but immediately
 * on installation. This may cause no problems in many cases, but in some cases
 * this is a problem, because other edit polices activated after the added one
 * may overwrite changes applied be the added one. For that reason, this policy
 * does register itself as a listener to the edit part and calls
 * {@link IEditPartAssimilator#modifyPolicies(EditPart)} <em>after</em> all
 * other polcies have been modified. It especially doesn't modify the edit
 * part's policy list during activation of the edit part, as the internal
 * iterator is unaware of such changes.
 * </p>
 * <p>In other words: How does it work now? On activation ({@link #activate()},
 * this policy does not directly modify the edit part, instead it registers itsself
 * as an {@link EditPartListener}. Thus it is called after the edit part has
 * been activated (and all other installed policies were activated). Only now
 * the edit part is modified and new policies are added (or other ones are 
 * removed).
 * </p>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Apr 8, 2008
 */
public class AssimulatorPolicy extends AbstractEditPolicy implements
		EditPartListener {

	public final static String ASSIMILATOR_POLICY_ROLE = "Assimilator Role";

	IEditPartAssimilator assimilator;

	/**
	 * @param i_io_editPart
	 * @param i_assimilator
	 */
	public AssimulatorPolicy(EditPart io_editPart,
			IEditPartAssimilator i_assimilator) {
		if (io_editPart == null) // parameter precondition
			throw new NullPointerException("io_editPart must not be null");
		if (i_assimilator == null) // parameter precondition
			throw new NullPointerException("i_assimilator must not be null");

		assimilator = i_assimilator;
		setHost(io_editPart);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#activate()
	 */
	@Override
	public void activate() {
		getHost().addEditPartListener(this);
	}

	/**
	 * 
	 */
	private void modifyPolicies() {
		assimilator.modifyPolicies(getHost());
		// we only modify the edit part ones:
		getHost().removeEditPolicy(ASSIMILATOR_POLICY_ROLE);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.EditPartListener#partActivated(org.eclipse.gef.EditPart)
	 */
	public void partActivated(EditPart i_editpart) {
		modifyPolicies();
		getHost().removeEditPartListener(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.EditPartListener#partDeactivated(org.eclipse.gef.EditPart)
	 */
	public void partDeactivated(EditPart i_editpart) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.EditPartListener#removingChild(org.eclipse.gef.EditPart,
	 *      int)
	 */
	public void removingChild(EditPart i_child, int i_index) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.EditPartListener#childAdded(org.eclipse.gef.EditPart,
	 *      int)
	 */
	public void childAdded(EditPart i_child, int i_index) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.EditPartListener#selectedStateChanged(org.eclipse.gef.EditPart)
	 */
	public void selectedStateChanged(EditPart i_editpart) {
		// TODO implement method EditPartListener.selectedStateChanged

	}

}
