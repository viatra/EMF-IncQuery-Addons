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
import java.util.ArrayList;
import java.util.List;

/**
 * Labeled vertex model class. Observer pattern is implemented using
 * {@link PropertyChangeSupport}.
 * 
 * @author jpilgrim
 * @version $Revision$
 * @since 26.09.2004
 */
public class Vertex implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6167394567950527021L;

	Graph m_graph;

	// Properties
	float m_fX;

	float m_fY;

	float m_fZ;

	float m_iWidth;

	float m_iHeight;

	String m_strName;

	// Observer-Pattern (Subject)
	PropertyChangeSupport m_Listeners;

	// Property names
	public final static String PROPERTY_X = "x";

	public final static String PROPERTY_Y = "y";

	public final static String PROPERTY_Z = "z";

	public final static String PROPERTY_WIDTH = "width";

	public final static String PROPERTY_HEIGHT = "height";

	List<Edge> m_listSources;

	List<Edge> m_listTargets;

	public final static String PROPERTY_SOURCES = "sources";

	public final static String PROPERTY_DESTS = "dests";

	public final static String PROPERTY_NAME = "name";

	static int COUNT = 0;

	public Vertex() {
		this(0, 0, 0);
	}

	public Vertex(float x, float y, float z) {
		m_Listeners = new PropertyChangeSupport(this);
		m_fX = x;
		m_fY = y;
		m_fZ = z;
		m_iWidth = 0;
		m_iHeight = 0;
		m_listSources = new ArrayList<Edge>();
		m_listTargets = new ArrayList<Edge>();
		m_strName = "Vertex_" + ++COUNT;
	}

	/**
	 * Delegate method
	 * 
	 * @param i_Listener
	 */
	public void addPropertyChangeListener(PropertyChangeListener i_Listener) {
		m_Listeners.addPropertyChangeListener(i_Listener);
	}

	/**
	 * Delegate method
	 * 
	 * @param i_Listener
	 */
	public void removePropertyChangeListener(PropertyChangeListener i_Listener) {
		m_Listeners.removePropertyChangeListener(i_Listener);
	}

	/**
	 * @return the graph
	 */
	public Graph getGraph() {
		return m_graph;
	}

	/**
	 * Sets the graph of the vertex, this is package visible only and called by
	 * {@link Graph#addVertex(Vertex)}.
	 * 
	 * @param graph the graph to set
	 */
	void setGraph(Graph graph) {
		m_graph = graph;
	}

	/**
	 * Simple getter, returns property <code>height</code>.
	 * 
	 * @return Returns the <code>height</code>.
	 */
	public float getHeight() {
		return m_iHeight;
	}

	/**
	 * Simple getter, sets <code>height</code>.
	 * 
	 * @param i_height The height to set.
	 */
	public void setHeight(float i_height) {
		float fOldHeight = m_iHeight;
		m_iHeight = i_height;
		m_Listeners.firePropertyChange(PROPERTY_HEIGHT, fOldHeight, m_iHeight);
	}

	/**
	 * Simple getter, returns property <code>width</code>.
	 * 
	 * @return Returns the <code>width</code>.
	 */
	public float getWidth() {
		return m_iWidth;
	}

	/**
	 * Simple getter, sets <code>width</code>.
	 * 
	 * @param i_width The width to set.
	 */
	public void setWidth(float i_width) {
		float fOldWidth = m_iWidth;
		m_iWidth = i_width;
		m_Listeners.firePropertyChange(PROPERTY_WIDTH, fOldWidth, m_iWidth);
	}

	/**
	 * Simple getter, returns property <code>x</code>.
	 * 
	 * @return Returns the <code>x</code>.
	 */
	public float getX() {
		return m_fX;
	}

	/**
	 * Simple getter, sets <code>x</code>.
	 * 
	 * @param i_x The x to set.
	 */
	public void setX(float i_x) {
		float fOldX = m_fX;
		m_fX = i_x;
		m_Listeners.firePropertyChange(PROPERTY_X, fOldX, m_fX);
	}

	/**
	 * Simple getter, returns property <code>y</code>.
	 * 
	 * @return Returns the <code>y</code>.
	 */
	public float getY() {
		return m_fY;
	}

	/**
	 * Simple getter, sets <code>y</code>.
	 * 
	 * @param i_y The y to set.
	 */
	public void setY(float i_y) {
		float fOldY = m_fY;
		m_fY = i_y;
		m_Listeners.firePropertyChange(PROPERTY_Y, fOldY, m_fY);
	}

	/**
	 * @return the z
	 */
	public float getZ() {
		return m_fZ;
	}

	/**
	 * @param i_z the z to set
	 */
	public void setZ(float i_z) {
		float fOldZ = m_fZ;
		m_fZ = i_z;
		m_Listeners.firePropertyChange(PROPERTY_Z, fOldZ, m_fZ);
	}

	/**
	 * Called by {@link Edge#setTarget(Vertex)}.
	 * @param i_Edge
	 * @return
	 */
	boolean addTarget(Edge i_Edge) {
		if (!m_listTargets.contains(i_Edge)) {
			m_listTargets.add(i_Edge);
			m_Listeners.firePropertyChange(PROPERTY_DESTS, null, i_Edge);
			return true;
		}
		return false;

	}

	/**
	 * Called by {@link Edge#setSource(Vertex)}
	 * @param i_Edge
	 * @return
	 */
	boolean addSource(Edge i_Edge) {
		if (!m_listSources.contains(i_Edge)) {
			m_listSources.add(i_Edge);
			m_Listeners.firePropertyChange(PROPERTY_SOURCES, null, i_Edge);
			return true;
		}
		return false;
	}

	/**
	 * Called by {@link Edge#setSource(Vertex)}
	 * @param i_Edge
	 * @return
	 */
	boolean removeSource(Edge i_Edge) {
		if (m_listSources.remove(i_Edge)) {
			m_Listeners.firePropertyChange(PROPERTY_SOURCES, i_Edge, null);
			return true;
		}
		return false;
	}

	/**
	 * Called by {@link Edge#setTarget(Vertex)}.
	 * @param i_Edge
	 * @return
	 */
	boolean removeTarget(Edge i_Edge) {
		if (m_listTargets.remove(i_Edge)) {
			m_Listeners.firePropertyChange(PROPERTY_DESTS, i_Edge, null);
			return true;
		}
		return false;
	}

	/**
	 * Simple getter, returns property <code>dests</code>.
	 * 
	 * @return Returns the <code>dests</code>.
	 */
	public List<Edge> getTargets() {
		return m_listTargets;
	}

	/**
	 * Simple getter, returns property <code>sources</code>.
	 * 
	 * @return Returns the <code>sources</code>.
	 */
	public List<Edge> getSources() {
		return m_listSources;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ("v(" + m_fX + "," + m_fY + "," + m_fZ + "; w=" + m_iWidth
			+ ", h=" + m_iHeight + ")");
	}

	public String getName() {
		return m_strName;
	}

	public void setName(String i_name) {
		String oldname = m_strName;
		m_strName = i_name;
		m_Listeners.firePropertyChange(PROPERTY_NAME, oldname, m_strName);
	}

}
