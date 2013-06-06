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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Cursors;

/**
 * ConnectionHandle3D There should really be more documentation here.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 17.10.2009
 */
public abstract class ConnectionHandle3D extends CubeHandle implements
		PropertyChangeListener {

	private boolean m_fixed;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.handles.AbstractHandle3D#addNotify()
	 */
	@Override
	public void addNotify() {

		super.addNotify();

		getConnection().addPropertyChangeListener(Connection.PROPERTY_POINTS,
			this);
	}

	/**
	 * Retursn the 3D connection to which this handle belongs.
	 * 
	 * @return the 3D connection
	 */
	public Connection getConnection() {

		return (Connection) getOwnerFigure();
	}

	/**
	 * Indicates whether this handle is fixed.
	 * 
	 * @return <code>true</code> if this handle is fixed and <code>false</code>
	 *         otherwise
	 */
	public boolean isFixed() {
		return m_fixed;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent i_evt) {

		if (i_evt.getPropertyName().equals(Connection.PROPERTY_POINTS))
			revalidate();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.handles.AbstractHandle3D#removeNotify()
	 */
	@Override
	public void removeNotify() {

		getConnection().removePropertyChangeListener(
			Connection.PROPERTY_POINTS, this);

		super.removeNotify();
	}

	/**
	 * Specifies whether this handle is fixed, e.g. whether it can be moved.
	 * 
	 * @param i_fixed <code>true</code> if this handle is fixed or
	 *            <code>false</code> otherwise
	 */
	public void setFixed(boolean i_fixed) {

		if (i_fixed)
			setCursor(Cursors.NO);
		else
			setCursor(Cursors.CROSS);

		m_fixed = i_fixed;
	}
}
