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
package org.eclipse.gef3d.factories;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;

/**
 * Factory for creating connection anchors of {@link NodeEditPart}s. 
 * Implementations of this interface are supposed to be stateless, i.e. a single
 * instance can be shared by several edit parts. 
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Apr 22, 2008
 */
public interface IConnectionAnchorFactory extends IDisplayModeSensitive {

	enum ConnectionEnd {
		Source, Target;
	}

	/**
	 * Creates a {@link ConnectionAnchor} for a given edit part, i.e. its
	 * figure, and (optional) a given end. If the anchor is independent from the
	 * given end, this parameter can be null.
	 * 
	 * @param i_EditPart, must not be null
	 * @param i_connectionEditPart
	 * @param i_connectionEnd, can be null if side doesn't matter
	 * @return
	 */
	ConnectionAnchor createConnectionAnchor(GraphicalEditPart i_EditPart,
			ConnectionEditPart i_connectionEditPart,
			ConnectionEnd i_connectionEnd);

	
	/**
	 * Creates a {@link ConnectionAnchor} for a given edit part, i.e. its
	 * figure, and (optional) a given end. If the anchor is independent from the
	 * given end, this parameter can be null.
	 * 
	 * @param i_EditPart, must not be null
	 * @param i_request
	 * @param i_connectionEnd, can be null
	 * @return
	 */
	ConnectionAnchor createConnectionAnchor(GraphicalEditPart i_EditPart,
			Request i_request,
			ConnectionEnd i_connectionEnd);
	
}
