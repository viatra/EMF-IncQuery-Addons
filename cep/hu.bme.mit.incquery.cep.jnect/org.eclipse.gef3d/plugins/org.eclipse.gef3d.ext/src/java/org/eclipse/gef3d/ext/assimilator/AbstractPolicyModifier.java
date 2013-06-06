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

/**
 * Abstract base class for assimilators only modifying an edit part's
 * policies without modifying the edit part itself.
 *
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	May 25, 2009
 */
public abstract class AbstractPolicyModifier implements IEditPartAssimilator {

	/** 
	 * Default implementation, the edit part itself is not modified and returned
	 * as it is. The policies are modified separately.
	 * 
	 * @see org.eclipse.gef3d.ext.assimilator.IAssimilator#assimilate(java.lang.Object)
	 */
	public EditPart assimilate(EditPart editPart) {
		return editPart;
	}

	

}
