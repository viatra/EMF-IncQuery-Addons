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

import java.util.List;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Handle;

/**
 * Handle factory for creating a single 3D rotate handle. This factory has no
 * GEF counterpart.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 31.08.2009
 */
public class RotateHandle3DFactory implements IHandleFactory {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.gef3d.handles.IHandleFactory#addHandle(org.eclipse.gef.GraphicalEditPart, java.util.List, int)
	 */
	public void addHandle(GraphicalEditPart i_part, List<Handle> i_handles,
		int i_direction) {
		// TODO implement method RotateHandle3DFactory.addHandle

	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.gef3d.handles.IHandleFactory#addHandles(org.eclipse.gef.GraphicalEditPart, java.util.List)
	 */
	public void addHandles(GraphicalEditPart i_part, List<Handle> i_handles) {
		// TODO implement method RotateHandle3DFactory.addHandles

	}

}
