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

/**
 * SingletonConnectionAnchorFactory holds a single anchor instance passed in the
 * constructor which is returned by all create methods. This anchor instance is
 * the singleton.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 22.01.2008
 */
public class SingletonConnectionAnchorFactory extends
		AbstractConnectionAnchorFactory {

	ConnectionAnchor m_SingletonAnchor;

	/**
	 * @param i_owner
	 */
	public SingletonConnectionAnchorFactory(ConnectionAnchor i_anchor) {
		m_SingletonAnchor = i_anchor;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.AbstractConnectionAnchorFactory#getConnectionAnchor()
	 */
	@Override
	protected ConnectionAnchor getConnectionAnchor() {
		return m_SingletonAnchor;
	}

}
