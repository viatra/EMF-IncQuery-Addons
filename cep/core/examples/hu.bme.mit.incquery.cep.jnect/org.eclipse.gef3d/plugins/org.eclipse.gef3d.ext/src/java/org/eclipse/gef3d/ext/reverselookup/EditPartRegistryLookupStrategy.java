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
package org.eclipse.gef3d.ext.reverselookup;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;

/**
 * Uses the viewer's edit part registry (
 * {@link EditPartViewer#getEditPartRegistry()}) for looking up an edit part by
 * its model element. Note that this method will fail if a notation model is
 * used, i.e. if the domain element (or semantic elements) are not directly
 * attached to the edit part.
 * <p>
 * For GMF, a special implementation of the lookup strategy is provided in
 * plugin <code>org.eclipse.gef3d.gmf</code>
 * </p>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Sep 28, 2009
 */
public class EditPartRegistryLookupStrategy implements
		ILookupStrategy<EditPart> {

	EditPartViewer viewer;

	/**
	 * @param i_viewer
	 */
	public EditPartRegistryLookupStrategy(EditPartViewer i_viewer) {
		if (i_viewer == null) // parameter precondition
			throw new NullPointerException("i_viewer must not be null");

		viewer = i_viewer;
	}

	/**
	 * Returns 1.
	 * 
	 * @see org.eclipse.gef3d.ext.reverselookup.ILookupHelper#handlesElement(java.lang.Object)
	 */
	public int handlesElement(Object i_modelElement) {
		return 1;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.reverselookup.ILookupStrategy#findNotationByDomain(java.lang.Object)
	 */
	public EditPart findNotationByDomain(Object i_domainElement) {
		return (EditPart) viewer.getEditPartRegistry().get(i_domainElement);
	}

	/** 
	 * {@inheritDoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EditPartRegistryLookupStrategy [viewer=" + viewer + "]";
	}
	
	

}
