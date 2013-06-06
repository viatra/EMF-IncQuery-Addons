/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.handles;

import java.util.List;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Handle;
import org.eclipse.gef.handles.ResizableHandleKit;

/**
 * IHandleFactory is the base interface for factories creating Handles.
 * These factories replace GEF's HandleKits (such as {@link ResizableHandleKit})
 * using the factory pattern.
 * <p>
 * For specifying the corner, {@link PositionConstants} are used. These are
 * extended by {@link PositionConstants3D} for enabling front and back handles.
 *
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	Mar 26, 2008
 */
public interface IHandleFactory {

	/**
	 * Adds a single handle in the given direction to the given List.
	 * 
	 * <p>This method was extracted from GEF's Handle Kit classes, e.g.
	 * {@link ResizableHandleKit}. We are not using static methods and
	 * classes here but the factory pattern instead.</p>
	 * 
	 * @param part the owner GraphicalEditPart of the handle
	 * @param handles the List to add the handle to
	 * @param direction the integer constant from {@link PositionConstants} 
	 * 	that refers to the handle direction
	 */
	public void addHandle(GraphicalEditPart part, List<Handle> handles, int direction);
	
	/**
	 * Fills the given List with handles at each corner
	 * and the north, south, east, and west of the GraphicalEditPart.
	 * Depending of the factory, other handles at other corners may be
	 * created.
	 * 
	 * @param part the owner GraphicalEditPart of the handles
	 * @param handles the List to add the handles to
	 */
	public void addHandles(GraphicalEditPart part, List<Handle> handles);
	
}
