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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

/**
 * Sounds Swedish, but it's an assimilating factory calling method based on the
 * created edit part in order to modify the properties of the newly created
 * object. The original edit part factory is nested inside this factory and the
 * original creation task is delegated to this factory. After an edit part has
 * been created, the newly created object is passed to {@link IAssimilator} in
 * order to change the object's state. If you know StarTrek, you'll know that
 * resistance is futile.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 17.01.2008
 * @see IPolicyAssimilator
 */
public class BorgEditPartFactory implements EditPartFactory {

	protected EditPartFactory nestedFactory;

	protected List<IAssimilator<EditPart>> assimilators;

	/**
	 * @param i_nestedFactory
	 */
	public BorgEditPartFactory(EditPartFactory i_nestedFactory) {
		nestedFactory = i_nestedFactory;
		assimilators = new ArrayList<IAssimilator<EditPart>>();
	}

	/**
	 * Adds an assimilator to the end of the assimilator list.
	 * 
	 * @param i_assimilator
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean addAssimilator(IAssimilator<EditPart> i_assimilator) {
		return assimilators.add(i_assimilator);
	}

	/**
	 * Adds an assimilator at given index.
	 * 
	 * @param i_index
	 * @param i_assimilator
	 * @see java.util.List#add(int, java.lang.Object)
	 */
	public void addAssimilator(int i_index, IAssimilator<EditPart> i_assimilator) {
		assimilators.add(i_index, i_assimilator);
	}

	/**
	 * Removes an assimilator
	 * 
	 * @param i_assimilator
	 * @return true if assimilator was found and removed
	 * @see java.util.List#remove(java.lang.Object)
	 */
	public boolean removeAssimilator(IAssimilator<EditPart> i_assimilator) {
		return assimilators.remove(i_assimilator);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.EditPartFactory#createEditPart(org.eclipse.gef.EditPart,
	 *      java.lang.Object)
	 */
	public EditPart createEditPart(EditPart i_context, Object i_model) {
		EditPart editPart = nestedFactory.createEditPart(i_context, i_model);
		if (editPart != null) {
			editPart = callAssimilators(editPart);
		}
		return editPart;
	}

	/**
	 * @param io_editPart
	 */
	protected EditPart callAssimilators(EditPart io_editPart) {
		for (IAssimilator<EditPart> assimilator : assimilators) {
			if (assimilator.match(io_editPart)) {
				io_editPart = assimilator.assimilate(io_editPart);
				if (assimilator instanceof IEditPartAssimilator) {
					AssimulatorPolicy ap = new AssimulatorPolicy(io_editPart,
							(IEditPartAssimilator) assimilator);
					io_editPart.installEditPolicy(
							AssimulatorPolicy.ASSIMILATOR_POLICY_ROLE, ap);
				}
			}
		}
		return io_editPart;
	}

}
