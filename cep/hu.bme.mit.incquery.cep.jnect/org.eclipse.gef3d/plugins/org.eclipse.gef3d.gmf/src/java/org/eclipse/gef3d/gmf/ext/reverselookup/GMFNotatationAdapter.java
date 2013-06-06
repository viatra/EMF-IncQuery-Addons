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
package org.eclipse.gef3d.gmf.ext.reverselookup;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef3d.ext.reverselookup.INotationAdapter;
import org.eclipse.gmf.runtime.notation.View;

/**
 * GMFNotatationAdapter
 * There should really be more documentation here.
 *
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	Apr 21, 2010
 */
public class GMFNotatationAdapter implements INotationAdapter<View> {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.gef3d.ext.reverselookup.emf.INotationAdapter#getDomainObject(java.lang.Object)
	 */
	public Object getDomainObject(View i_notationElement) {
		return i_notationElement.getElement();
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.gef3d.ext.reverselookup.emf.INotationAdapter#getNotationChildren(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public List<View> getNotationChildren(View i_notationElement) {
		return i_notationElement.getChildren();
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.gef3d.ext.reverselookup.emf.ILookupHelper#handlesElement(java.lang.Object)
	 */
	public int handlesElement(Object i_modelElement) {
		return (i_modelElement instanceof EObject)? 1 : 0;
	}

}
