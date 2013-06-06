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
package org.eclipse.gef3d.ext.assimilator;

import org.eclipse.gef.EditPart;
import org.eclipse.gef3d.ext.assimilator.IAssimilator.ExactType;

/**
 * Assimilator replacing EditParts of a given type with EditParts of a different
 * type. The model of the original edit part is set as model of the new edit
 * part.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since May 25, 2009
 */
public class EditPartReplacer extends ExactType<EditPart> {

	Class replaceType;

	/**
	 * @param fromType
	 * @param replaceType
	 */
	public EditPartReplacer(Class fromType, Class replaceType) {
		super(fromType);
		if (!EditPart.class.isAssignableFrom(replaceType))
			throw new IllegalArgumentException(
				"replaceType must be a subtype of EditPart, "
					+ replaceType.getName() + "is not a subtype");
		this.replaceType = replaceType;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.assimilator.IAssimilator#assimilate(java.lang.Object)
	 */
	public EditPart assimilate(EditPart editPart) {
		EditPart newPart;
		try {
			newPart = (EditPart) replaceType.newInstance();
		} catch (Exception ex) {
			throw new IllegalStateException("Cannot instatiate new type", ex);
		}
		newPart.setModel(editPart.getModel());
		return newPart;
	}
}
