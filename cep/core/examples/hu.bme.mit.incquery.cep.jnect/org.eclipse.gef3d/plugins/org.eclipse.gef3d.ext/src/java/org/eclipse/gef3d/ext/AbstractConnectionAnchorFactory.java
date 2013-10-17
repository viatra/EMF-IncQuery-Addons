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
import org.eclipse.gef.Request;

/**
 * Abstract base class for connection anchor facgtories. This base class
 * delegates the four original interface methods to two and finally to one
 * method:
 * 
 * <pre>
 * <code>
 * createSource / TargetConnectionAnchor(ConnectionEditPart / Request)
 * </code>
 * to
 * <code>
 * createConnectionAnchor(ConnectionEditPart / Request)
 * </code>
 * to @link{#createConnectionAnchor()}
 * </pre>
 * 
 * Subclasses can override appropriate methods and minimize the implementation
 * effort.
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 20.01.2008
 */
public abstract class AbstractConnectionAnchorFactory implements
		IConnectionAnchorFactory {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.IConnectionAnchorFactory#getSourceConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
	 */
	public ConnectionAnchor getSourceConnectionAnchor(
			ConnectionEditPart i_connection) {
		return getConnectionAnchor(i_connection);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.IConnectionAnchorFactory#getSourceConnectionAnchor(org.eclipse.gef.Request)
	 */
	public ConnectionAnchor getSourceConnectionAnchor(Request i_request) {
		return getConnectionAnchor(i_request);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.IConnectionAnchorFactory#getTargetConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
	 */
	public ConnectionAnchor getTargetConnectionAnchor(
			ConnectionEditPart i_connection) {
		return getConnectionAnchor(i_connection);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.IConnectionAnchorFactory#getTargetConnectionAnchor(org.eclipse.gef.Request)
	 */
	public ConnectionAnchor getTargetConnectionAnchor(Request i_request) {
		return getConnectionAnchor(i_request);
	}

	/**
	 * This method calls {@link #getConnectionAnchor()} by default.
	 * 
	 * @param i_connection
	 * @return
	 */
	protected ConnectionAnchor getConnectionAnchor(
			ConnectionEditPart i_connection) {
		return getConnectionAnchor();
	}

	/**
	 * This method calls {@link #getConnectionAnchor()} by default
	 * 
	 * @param i_request
	 * @return
	 */
	protected ConnectionAnchor getConnectionAnchor(Request i_request) {
		return getConnectionAnchor();
	}

	/**
	 * Override this method if you do not override
	 * {@link #getSourceConnectionAnchor(ConnectionEditPart)} and
	 * {@link #getSourceConnectionAnchor(Request)}.
	 * 
	 * @return
	 */
	protected ConnectionAnchor getConnectionAnchor() {
		return null;
	}

}
