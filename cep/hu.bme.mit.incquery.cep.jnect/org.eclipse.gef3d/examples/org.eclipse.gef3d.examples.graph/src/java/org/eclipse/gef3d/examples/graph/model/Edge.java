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
package org.eclipse.gef3d.examples.graph.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 * Edge connecting two vertices. Observer pattern is implemented using
 * {@link PropertyChangeSupport}. 
 * 
 * @author jpilgrim
 * @version $Revision$
 * @since 27.09.2004
 */
public class Edge implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4697499045248470082L;

	PropertyChangeSupport m_Listeners;

	public final static String PROPERTY_SOURCE = "source";

	public final static String PROPERTY_DESTINATION = "target";

	Vertex m_vertexSource;

	Vertex m_vertexTarget;

	public Edge() {
		m_Listeners = new PropertyChangeSupport(this);
	}
	
	

	/**
	 * Simple getter, returns property <code>target</code>.
	 * 
	 * @return Returns the <code>targets</code>.
	 */
	public Vertex getTarget() {
		return m_vertexTarget;
	}

	/**
	 * Simple getter, returns property <code>source</code>.
	 * 
	 * @return Returns the <code>sources</code>.
	 */
	public Vertex getSource() {
		return m_vertexSource;
	}

	/**
	 * @param i_Listener
	 */
	public void addPropertyChangeListener(PropertyChangeListener i_Listener) {
		m_Listeners.addPropertyChangeListener(i_Listener);
	}

	/**
	 * @param i_Listener
	 */
	public void removePropertyChangeListener(PropertyChangeListener i_Listener) {
		m_Listeners.removePropertyChangeListener(i_Listener);
	}



	/**
	 * @param vertexSource the vertexSource to set
	 */
	public void setSource(Vertex vertexSource) {
		if (m_vertexSource!=null) {
			m_vertexSource.removeSource(this);
		}
		m_vertexSource = vertexSource;
		if (m_vertexSource!=null) {
			m_vertexSource.addSource(this);
		}
	}



	/**
	 * @param vertexTarget the vertexTarget to set
	 */
	public void setTarget(Vertex vertexTarget) {
		if (m_vertexTarget!=null) {
			m_vertexTarget.removeTarget(this);
		}
		m_vertexTarget = vertexTarget;
		if (m_vertexTarget!=null) {
			m_vertexTarget.addTarget(this);
		}
	}



	/** 
	 * {@inheritDoc}
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj==this) return true;
		if (obj instanceof Edge) {
			return (((Edge) obj).getSource()==getSource() &&
					((Edge) obj).getTarget()==getTarget());
		}
		return false;
	}
	
	/** 
	 * {@inheritDoc}
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int h = 0;
		if(getSource()!=null) h+=getSource().hashCode();
		if (getTarget()!=null) h+=(h*31)+getTarget().hashCode();
		return h;
	}



	/** 
	 * {@inheritDoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Edge from ");
		result.append(String.valueOf(getSource()));
		result.append(" to ");
		result.append(String.valueOf(getTarget()));
		return result.toString();
	}


	

}
