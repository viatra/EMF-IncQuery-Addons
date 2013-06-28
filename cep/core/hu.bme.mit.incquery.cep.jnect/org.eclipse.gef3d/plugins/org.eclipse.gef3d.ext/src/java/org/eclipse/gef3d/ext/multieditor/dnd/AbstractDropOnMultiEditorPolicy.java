/*******************************************************************************
 * Copyright (c) 2011 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.ext.multieditor.dnd;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;

/**
 * AbstractDropOnMultiEditorPolicy There should really be more documentation here.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @version $Revision$
 * @since Jun 11, 2011
 */
public class AbstractDropOnMultiEditorPolicy extends AbstractEditPolicy {

	/**
	 * {@inheritDoc}.
	 * <p>
	 * If the given request is an instance of
	 * {@link AbstractDropOnMultiEditorRequest}, the host of this policy is
	 * returned as target edit part.
	 * 
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#getTargetEditPart(org.eclipse.gef.Request)
	 */
	@Override
	public EditPart getTargetEditPart(Request i_request) {
		if (i_request instanceof AbstractDropOnMultiEditorRequest) {
			return this.getHost();
		}
		return super.getTargetEditPart(i_request);
	}

}
