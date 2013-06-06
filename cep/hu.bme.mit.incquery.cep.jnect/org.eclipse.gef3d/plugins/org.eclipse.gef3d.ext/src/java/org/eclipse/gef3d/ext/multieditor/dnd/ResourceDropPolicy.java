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

import org.eclipse.core.resources.IResource;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;

/**
 * Enables native drop of {@link IResource}s ointo the 3D scene.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @version $Revision$
 * @since Jun 11, 2011
 */
public class ResourceDropPolicy extends AbstractDropOnMultiEditorPolicy {

	/**
	 * Role name used to install this policy.
	 */
	public static final Object RESOURCE_DROP_ROLE = "RESOURCE_DROP_ROLE";

	/**
	 * Returns true if the request is an {@link ResourceDropRequest}.
	 * 
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#understandsRequest(org.eclipse.gef.Request)
	 */
	@Override
	public boolean understandsRequest(Request i_req) {
		return i_req instanceof ResourceDropRequest;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#getCommand(org.eclipse.gef.Request)
	 */
	@Override
	public Command getCommand(Request i_request) {

		if (i_request instanceof ResourceDropRequest) {
			ResourceDropRequest rdr = (ResourceDropRequest) i_request;

			ResourcesDropCommand cmd =
				new ResourcesDropCommand(rdr.getMultiEditor(),
					rdr.getLocation(), rdr.getResources());
			
			if (cmd.canExecute())
				return cmd;

		}

		return super.getCommand(i_request);
	}
}
