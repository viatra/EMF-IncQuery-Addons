/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 *    Kristian Duske - multi editor sample
 ******************************************************************************/
package org.eclipse.gef3d.examples.graph.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * IntermodelContainer contains connections between vertices of different
 * graphs.  Observer pattern is implemented using
 * {@link PropertyChangeSupport}.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 04.04.2008
 */
public class IntermodelContainer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2028784355201487881L;

	public final static String PROPERTY_CONNECTIONS = "connections";

	private List<Edge> m_connections = new ArrayList<Edge>();

	private PropertyChangeSupport m_listeners = new PropertyChangeSupport(this);

	/**
	 * Adds the given edge.
	 * 
	 * @param i_edge the edge to add
	 * @return <code>true</code> if the edge has been added or
	 *         <code>false</code> otherwise
	 */
	public boolean add(Edge i_edge) {

		boolean added = m_connections.add(i_edge);

		if (added)
			m_listeners.firePropertyChange(PROPERTY_CONNECTIONS, null, i_edge);

		return added;
	}

	/**
	 * Adds the given property change listener
	 * 
	 * @param i_Listener the property change listener to add
	 */
	public void addPropertyChangeListener(PropertyChangeListener i_Listener) {

		m_listeners.addPropertyChangeListener(i_Listener);
	}

	/**
	 * @return
	 */
	public List<Edge> getConnections() {

		return Collections.unmodifiableList(m_connections);
	}

	/**
	 * Removes the given edge.
	 * 
	 * @param i_edge the edge to remove
	 * @return <code>true</code> if the given edge was removed or
	 *         <code>false</code> otherwise
	 */
	public boolean remove(Edge i_edge) {

		boolean removed = m_connections.remove(i_edge);

		if (removed)
			m_listeners.firePropertyChange(PROPERTY_CONNECTIONS, i_edge, null);

		return removed;
	}

	/**
	 * Removes the given property change listener.
	 * 
	 * @param i_Listener the property change listener to remove
	 */
	public void removePropertyChangeListener(PropertyChangeListener i_Listener) {

		m_listeners.removePropertyChangeListener(i_Listener);
	}
}
