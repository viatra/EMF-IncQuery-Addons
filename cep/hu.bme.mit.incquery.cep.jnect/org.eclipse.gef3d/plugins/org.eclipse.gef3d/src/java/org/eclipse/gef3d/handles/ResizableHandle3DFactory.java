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

import static org.eclipse.draw3d.PositionConstants3D.*;

import java.util.List;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw3d.PositionConstants3D;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Handle;
import org.eclipse.gef.handles.ResizableHandleKit;


/**
 * 3D version of {@link ResizableHandleKit}. While {@link ResizableHandleKit}
 * has static methods, we use the factory and singleton patterns here.
 * 
 * @author IBM Corporation (original 2D version: ResizableHandleKit)
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Mar 26, 2008
 */
public class ResizableHandle3DFactory implements IHandleFactory {

	public final static ResizableHandle3DFactory INSTANCE = new ResizableHandle3DFactory();

	/**
	 * {@inheritDoc}
	 * <p>
	 * Copied (and not modified yet) from {@link ResizableHandleKit}.
	 * </p>
	 * 
	 * @see org.eclipse.gef3d.handles.IHandleFactory#addHandle(org.eclipse.gef.GraphicalEditPart,
	 *      java.util.List, int)
	 */
	public void addHandle(GraphicalEditPart part, List<Handle> handles,
			int direction) {
		handles.add(createHandle(part, direction, FRONT));

	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Copied from {@link ResizableHandleKit}. Instead of creating the move
	 * handle here directly, the {@link MoveHandle3DFactory} is used. All
	 * handles are set to front of reference figure (z component).
	 * </p>
	 * 
	 * @see org.eclipse.gef3d.handles.IHandleFactory#addHandles(org.eclipse.gef.GraphicalEditPart,
	 *      java.util.List)
	 */
	public void addHandles(GraphicalEditPart part, List<Handle> handles) {
		// addMoveHandle(part, handles); original GEF
		MoveHandle3DFactory.INSTANCE.addHandles(part, handles);

		// TODO: cursor is not updated when position is set to front, i.e.
		/*
		 * handles.add(createHandle(part, PositionConstants.EAST)); updates the
		 * cursor, while
		 * handles.add(createHandle(part, PositionConstants3D.FRONT
		 *		| PositionConstants.EAST));
		 * doesn't		
		 */

		handles.add(createHandle(part, PositionConstants.EAST, FRONT));
		handles.add(createHandle(part, PositionConstants.SOUTH_EAST, FRONT));
		handles.add(createHandle(part, PositionConstants.SOUTH, FRONT));
		handles.add(createHandle(part, PositionConstants.SOUTH_WEST, FRONT));
		handles.add(createHandle(part, PositionConstants.WEST, FRONT));
		handles.add(createHandle(part, PositionConstants.NORTH_WEST, FRONT));
		handles.add(createHandle(part, PositionConstants.NORTH, FRONT));
		handles.add(createHandle(part, PositionConstants.NORTH_EAST, FRONT));

	}

	/**
	 * <p>
	 * Copied (and not modified yet) from {@link ResizableHandleKit}.
	 * </p>
	 * 
	 * @param part
	 * @param direction
	 * @return
	 */
	protected Handle createHandle(GraphicalEditPart part, int direction, PositionConstants3D i_zdir) {

		return new ResizeHandle3D(part, direction, i_zdir);
	}

}
