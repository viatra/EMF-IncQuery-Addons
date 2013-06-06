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

package org.eclipse.gef3d.ext.multieditor;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * The content model of a multi editor, storing all nested content objects.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 16.01.2008
 */
public class MultiEditorModelContainer {

	protected List<Object> modelContainer;

	// Observer-Pattern (Subject)
	PropertyChangeSupport m_Listeners;

	public final static String PROPERTY_CONTAINER = "container";

	/**
	 * 
	 */
	public MultiEditorModelContainer() {
		modelContainer = new ArrayList<Object>();
		m_Listeners = new PropertyChangeSupport(this);
	}

	/**
	 * Returns list of all contained nested root elements, i.e. the
	 * root models of the nested editors.
	 * @return
	 */
	public List getModelContainers() {
		return modelContainer;
	}
	
	/**
	 * Retrieves all model roots which are instances of a given type.
	 * The list is passed by reference in order to enable typed lists.
	 * @param o_listModels, must not be null (list is <b>not</b> cleared)
	 * @param i_type
	 */
	@SuppressWarnings("unchecked")
	public void retrieveModelsByType(List o_listModels, Class i_type) {
		if (o_listModels == null) // parameter precondition
			throw new NullPointerException("o_listModels must not be null");
		if (i_type == null) // parameter precondition
			throw new NullPointerException("i_type must not be null");
				
		
		for(Object obj: modelContainer) {
			if (i_type.isInstance(obj))
				o_listModels.add(obj);
		}
	}
	
//	public List

	/**
	 * Delegate method
	 * 
	 * @param i_modelRootElement
	 * @return
	 * @see java.util.Set#add(java.lang.Object)
	 */
	public boolean add(Object i_modelRootElement) {
		boolean bVal = modelContainer.add(i_modelRootElement);
		if (bVal) {
			m_Listeners.firePropertyChange(PROPERTY_CONTAINER, null,
					i_modelRootElement);
		}
		return bVal;
	}

	/**
	 * Delegate method
	 * 
	 * @see java.util.Set#clear()
	 */
	public void clear() {
		modelContainer.clear();
		m_Listeners.firePropertyChange(PROPERTY_CONTAINER, null, null);
	}

	/**
	 * Delegate method
	 * 
	 * @param i_modelRootElement
	 * @return
	 * @see java.util.Set#contains(java.lang.Object)
	 */
	public boolean contains(Object i_modelRootElement) {
		return modelContainer.contains(i_modelRootElement);
	}

	/**
	 * Delegate method
	 * 
	 * @return
	 * @see java.util.Set#isEmpty()
	 */
	public boolean isEmpty() {
		return modelContainer.isEmpty();
	}

	/**
	 * Delegate method
	 * 
	 * @return
	 * @see java.util.Set#iterator()
	 */
	public Iterator<Object> iterator() {
		return modelContainer.iterator();
	}

	/**
	 * Delegate method
	 * 
	 * @param i_modelRootElement
	 * @return
	 * @see java.util.Set#remove(java.lang.Object)
	 */
	public boolean remove(Object i_modelRootElement) {
		boolean bVal = modelContainer.remove(i_modelRootElement);
		if (bVal) {
			m_Listeners.firePropertyChange(PROPERTY_CONTAINER, null,
					i_modelRootElement);
		}
		return bVal;
	}

	/**
	 * Delegate method
	 * 
	 * @return
	 * @see java.util.Set#size()
	 */
	public int size() {
		return modelContainer.size();
	}

	/**
	 * Delegate method
	 * 
	 * @param i_listener
	 * @see java.beans.PropertyChangeSupport#addPropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void addPropertyChangeListener(PropertyChangeListener i_listener) {
		m_Listeners.addPropertyChangeListener(i_listener);
	}

	/**
	 * Delegate method
	 * 
	 * @param i_listener
	 * @see java.beans.PropertyChangeSupport#removePropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void removePropertyChangeListener(PropertyChangeListener i_listener) {
		m_Listeners.removePropertyChangeListener(i_listener);
	}

	/** 
	 * {@inheritDoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer strb = new StringBuffer("MultiEditorModelContainer (");
		boolean bFirst = true;
		for (Object obj: modelContainer) {
			if (bFirst) {
				bFirst = false;
			} else {
				strb.append(", ");
			}
			strb.append(obj.getClass());
		}
		strb.append(")");
		return strb.toString();
	}
	
	

}
