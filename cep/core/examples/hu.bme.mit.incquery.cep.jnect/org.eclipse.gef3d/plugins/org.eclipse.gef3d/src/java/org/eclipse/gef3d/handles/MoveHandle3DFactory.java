/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others,
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation of 2D version
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.handles;

import java.util.List;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Handle;
import org.eclipse.gef.handles.NonResizableHandleKit;
import org.eclipse.gef.handles.ResizableHandleKit;

/**
 * Handle factory for creating a single 3D move handle. This factory has
 * no GEF counterpart, instead move handles were created by
 * {@link ResizableHandleKit} and {@link NonResizableHandleKit}.
 * Here, {@link ResizableHandle3DFactory} (and 
 * {@link NonResizableHandle3DFactory}) are also calling this factory here
 * automatically.
 * 
 * @author IBM Corporation (original 2D version: ResizableHandleKit)
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Mar 26, 2008
 */
public class MoveHandle3DFactory implements IHandleFactory {

	public final static MoveHandle3DFactory INSTANCE = new MoveHandle3DFactory();

	/**
	 * Direction is ignored here, a single handle is created. {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.handles.IHandleFactory#addHandle(org.eclipse.gef.GraphicalEditPart,
	 *      java.util.List, int)
	 */
	public void addHandle(GraphicalEditPart i_part, List<Handle> o_handles,
			int i_direction) {
		o_handles.add(createHandle(i_part));
	}

	/**
	 * A single handle is created here. {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.handles.IHandleFactory#addHandles(org.eclipse.gef.GraphicalEditPart,
	 *      java.util.List)
	 */
	public void addHandles(GraphicalEditPart i_part, List<Handle> o_handles) {
		 o_handles.add(createHandle(i_part));
	}

	/**
	 * @param i_part
	 * @return
	 */
	protected Handle createHandle(GraphicalEditPart i_part) {
		return new MoveHandle3D(i_part);
	}

}
