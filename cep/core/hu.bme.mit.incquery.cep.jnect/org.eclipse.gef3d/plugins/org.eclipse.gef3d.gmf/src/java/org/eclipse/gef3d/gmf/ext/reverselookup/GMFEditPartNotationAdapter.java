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
package org.eclipse.gef3d.gmf.ext.reverselookup;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef3d.ext.reverselookup.EditPartNotationAdapter;
import org.eclipse.gef3d.ext.reverselookup.INotationAdapter;
import org.eclipse.gmf.runtime.notation.View;

/**
 * Implementation of {@link INotationAdapter} (indirectly by subclassing
 * {@link EditPartNotationAdapter} for returning the semantic (or domain) model
 * element handled by an {@link EditPart}. This class basically "skips" the
 * notation model element.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since May 23, 2009
 */
public class GMFEditPartNotationAdapter extends EditPartNotationAdapter {

	/**
	 * The singleton instance, object has no state
	 */
	public final static GMFEditPartNotationAdapter INSTANCE =
		new GMFEditPartNotationAdapter();

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.reverselookup.emf.INotationAdapter#getDomainObject(java.lang.Object)
	 */
	public Object getDomainObject(EditPart notationElement) {
		return ((View) notationElement.getModel()).getElement();
	}

	/**
	 * Returns 2 if the element is an {@link EObject} and its model element is
	 * a {@link View}, since the length of the navigation path is 2
	 * (getModel().getElement()). Otherwise, -1 is returned.
	 * 
	 * @see org.eclipse.gef3d.ext.reverselookup.emf.ILookupHelper#handlesElement(java.lang.Object)
	 */
	public int handlesElement(Object i_modelElement) {
		if (i_modelElement instanceof EditPart) {
			if (((EditPart) i_modelElement).getModel() instanceof View) {
				return 2;
			}
		}
		return -1;
	}

}
