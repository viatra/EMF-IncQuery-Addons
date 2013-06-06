/*******************************************************************************
 * Copyright (c) 2009 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.handles;

import org.eclipse.draw3d.ConnectionLocator3D;
import org.eclipse.gef.ConnectionEditPart;

/**
 * ConnectionEndPointHandle3D There should really be more documentation here.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 17.10.2009
 */
public class ConnectionEndPointHandle3D extends ConnectionHandle3D {

	/**
	 * Creates a new connection end point handle with the given owner and
	 * alignment.
	 * 
	 * @param i_owner the owner of the handle
	 * @param i_alignment the alignment
	 */
	public ConnectionEndPointHandle3D(ConnectionEditPart i_owner,
			int i_alignment) {

		setOwner(i_owner);
		setLocator(new ConnectionLocator3D(getConnection(), i_alignment));

		init();
	}

	/**
	 * Creates a new connection end point handle with the given owner and
	 * alignment.
	 * 
	 * @param i_owner the owner of the handle
	 * @param i_alignment the alignment
	 * @param i_fixed whether this handle is fixed
	 * @see ConnectionHandle3D#setFixed(boolean)
	 */
	public ConnectionEndPointHandle3D(ConnectionEditPart i_owner,
			int i_alignment, boolean i_fixed) {

		setOwner(i_owner);
		setLocator(new ConnectionLocator3D(getConnection(), i_alignment));
		setFixed(i_fixed);

		init();
	}
}
