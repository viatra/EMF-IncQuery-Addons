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

package org.eclipse.gef3d.ext;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;

/**
 * IConnectionAnchorFactory is a factory for
 * 
 * @link{ConnectionAnchor}, used in {@link NodeEditPart}s. It implements the
 *                          methods declared in {@link NodeEditPart} (but not in
 *                          NodeEditPart's super interfaces) and it should be
 *                          used in EditParts as a delegator. Usually, the
 *                          abstract super class
 *                          {@link AbstractConnectionAnchorFactory} is used.
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 20.01.2008
 * @see AbstractConnectionAnchorFactory
 */
public interface IConnectionAnchorFactory {

	/**
	 * Returns the <code>ConnectionAnchor</code> for the specified <i>source</i>
	 * connection.
	 * 
	 * @param connection the ConnectionEditPart
	 * @return the ConnectionAnchor for the given ConnectionEditPart
	 * @see NodeEditPart#getSourceConnectionAnchor(ConnectionEditPart)
	 */
	ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection);

	/**
	 * Returns the <code>ConnectionAnchor</code> for the specified <i>target</i>
	 * connection.
	 * 
	 * @param connection the ConnectionEditPart
	 * @return the ConnectionAnchor for the given ConnectionEditPart
	 * @see NodeEditPart#getTargetConnectionAnchor(ConnectionEditPart)
	 */
	ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection);

	/**
	 * Returns the <i>source</i> <code>ConnectionAnchor</code> for the
	 * specified Request.
	 * 
	 * @param request a Request describing the current interaction
	 * @return the ConnectionAnchor to use during feedback
	 * @see NodeEditPart#getSourceConnectionAnchor(Request)
	 */
	ConnectionAnchor getSourceConnectionAnchor(Request request);

	/**
	 * Returns the <i>target</i> <code>ConnectionAnchor</code> for the
	 * specified Request.
	 * 
	 * @param request a Request describing the current interaction
	 * @return the ConnectionAnchor to use during feedback
	 * @see NodeEditPart#getTargetConnectionAnchor(Request)
	 */
	ConnectionAnchor getTargetConnectionAnchor(Request request);

}
