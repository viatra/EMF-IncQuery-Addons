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
import org.eclipse.gef.Request;

/**
 * Default implementation of {@link IConnectionAnchorFactory}, delegating the 
 * creation request to more and more generic methods. The creation request 
 * is delegated in this order:
 * <ol>
 * 	<li>{@link #createConnectionAnchor(GraphicalEditPart, org.eclipse.gef3d.factories.IConnectionAnchorFactory.ConnectionEnd)},
 * 		that is request or connection edit part are ignored</li>
 * <li>{@link #createConnectionAnchor(GraphicalEditPart)}, that is
 * 		connection end (target or source) is ignored
 * </ol>
 * The last method {@link #createConnectionAnchor(GraphicalEditPart)} must be 
 * overridden by subclasses, other methods may be overridden if needed.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Apr 22, 2008
 */
public abstract class AbstractConnectionAnchorFactory implements
		IConnectionAnchorFactory {

	private DisplayMode m_mode;

	/**
	 * Creates this factory with no specific display mode set, i.e.
	 * {@link #getMode()} will return <code>null</code>.
	 */
	public AbstractConnectionAnchorFactory() {
		this(null);
	}

	/**
	 * Creates this factory with given mode.
	 * 
	 * @param i_mode
	 */
	public AbstractConnectionAnchorFactory(DisplayMode i_mode) {
		m_mode = i_mode;
	}

	public abstract ConnectionAnchor createConnectionAnchor(
			GraphicalEditPart i_EditPart);

	/**
	 * May be overridden by subclasses if connection end matters, the default
	 * implementation calls {@link #createConnectionAnchor(GraphicalEditPart)}.
	 * 
	 * @param i_EditPart
	 * @param i_connectionEnd
	 * @return
	 */
	public ConnectionAnchor createConnectionAnchor(
			GraphicalEditPart i_EditPart, ConnectionEnd i_connectionEnd) {
		return createConnectionAnchor(i_EditPart);
	}

	/**
	 * May be overridden by subclasses if ConnectionEditPart matters, the
	 * default implementation calls
	 * {@link #createConnectionAnchor(GraphicalEditPart, org.eclipse.gef3d.factories.IConnectionAnchorFactory.ConnectionEnd)}
	 * <p>
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.factories.IConnectionAnchorFactory#createConnectionAnchor(org.eclipse.gef.GraphicalEditPart,
	 *      org.eclipse.gef.ConnectionEditPart,
	 *      org.eclipse.gef3d.factories.IConnectionAnchorFactory.ConnectionEnd)
	 */
	public ConnectionAnchor createConnectionAnchor(
			GraphicalEditPart i_EditPart,
			ConnectionEditPart i_connectionEditPart,
			ConnectionEnd i_connectionEnd) {
		return createConnectionAnchor(i_EditPart, i_connectionEnd);
	}

	/**
	 * May be overridden by subclasses if the request matters, the
	 * default implementation calls
	 * {@link #createConnectionAnchor(GraphicalEditPart, org.eclipse.gef3d.factories.IConnectionAnchorFactory.ConnectionEnd)}
	 * <p>
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.factories.IConnectionAnchorFactory#createConnectionAnchor(org.eclipse.gef.GraphicalEditPart,
	 *      org.eclipse.gef.Request,
	 *      org.eclipse.gef3d.factories.IConnectionAnchorFactory.ConnectionEnd)
	 */
	public ConnectionAnchor createConnectionAnchor(
			GraphicalEditPart i_EditPart, Request i_request,
			ConnectionEnd i_connectionEnd) {
		return createConnectionAnchor(i_EditPart, i_connectionEnd);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.factories.IDisplayModeSensitive#getMode()
	 */
	public DisplayMode getMode() {
		return m_mode;
	}

}
