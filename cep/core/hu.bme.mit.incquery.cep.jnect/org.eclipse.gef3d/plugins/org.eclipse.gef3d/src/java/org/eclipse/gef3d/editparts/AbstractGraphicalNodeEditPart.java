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
package org.eclipse.gef3d.editparts;

import static org.eclipse.gef3d.factories.IConnectionAnchorFactory.ConnectionEnd.Source;
import static org.eclipse.gef3d.factories.IConnectionAnchorFactory.ConnectionEnd.Target;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef3d.factories.IConnectionAnchorFactory;
import org.eclipse.gef3d.factories.IFigureFactory;


/**
 * Extensible graphical node edit part, i.e. this edit part uses (besides an 
 * {@link IFigureFactory}) an {@link IConnectionAnchorFactory}.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Apr 22, 2008
 */
public abstract class AbstractGraphicalNodeEditPart extends
		AbstractGraphicalEditPartEx implements NodeEditPart {

	/**
	 * The connection anchor factory of this edit part used by
	 * {@link NodeEditPart}'s methods. This factory is lazily created in
	 * {@link #createConnectionAnchorFactory()}.
	 */
	protected IConnectionAnchorFactory m_ConnectionAnchorFactory;

	/**
	 * Creates {@link IConnectionAnchorFactory} for this edit part.
	 * 
	 * @return the connection anchor factory for this edit part, must not return
	 *         null.
	 */
	protected abstract IConnectionAnchorFactory createConnectionAnchorFactory();
	
	
	/**
	 * Sets connection anchor factory for this edit part.
	 * This method is called internally by {@link #getConnectionAnchorFactory()}
	 * using {@link #createConnectionAnchorFactory()} for creating a factory if 
	 * it wasn't set before. But this method may also be called from outside
	 * this class, e.g. by a <code>BorgEditPartFactory</code> for adapting
	 * the behavior of this edit part.
	 *  
	 *  
	 * @param i_ConnectionAnchorFactory, must not be null
	 */
	public void setConnectionAnchorFactory(IConnectionAnchorFactory i_ConnectionAnchorFactory) {
		if (i_ConnectionAnchorFactory == null) // parameter precondition
			throw new NullPointerException("i_ConnectionAnchorFactory must not be null");
		m_ConnectionAnchorFactory = i_ConnectionAnchorFactory;
	}
	

	/**
	 * Returns connection edit part factory, if factory null it is created on
	 * the fly by calling {@link #createConnectionAnchorFactory()}.
	 * 
	 * @return the connectionAnchorFactory, must not return null
	 */
	public IConnectionAnchorFactory getConnectionAnchorFactory() {
		if (m_ConnectionAnchorFactory == null) {
			setConnectionAnchorFactory(createConnectionAnchorFactory());
		}
		return m_ConnectionAnchorFactory;
	}

	/**
	 * Uses connection anchor factory for creating the connection anchor.
	 * <p>
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
	 */
	public ConnectionAnchor getSourceConnectionAnchor(
			ConnectionEditPart i_connection) {
		return getConnectionAnchorFactory().createConnectionAnchor(this,
				i_connection, Source);
	}

	/**
	 * Uses connection anchor factory for creating the connection anchor.
	 * <p>
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.Request)
	 */
	public ConnectionAnchor getSourceConnectionAnchor(Request i_request) {
		return getConnectionAnchorFactory().createConnectionAnchor(this,
				i_request, Source);
	}

	/**
	 * Uses connection anchor factory for creating the connection anchor.
	 * <p>
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
	 */
	public ConnectionAnchor getTargetConnectionAnchor(
			ConnectionEditPart i_connection) {
		return getConnectionAnchorFactory().createConnectionAnchor(this,
				i_connection, Target);
	}

	/**
	 * Uses connection anchor factory for creating the connection anchor.
	 * <p>
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.Request)
	 */
	public ConnectionAnchor getTargetConnectionAnchor(Request i_request) {
		return getConnectionAnchorFactory().createConnectionAnchor(this,
				i_request, Target);
	}

}
