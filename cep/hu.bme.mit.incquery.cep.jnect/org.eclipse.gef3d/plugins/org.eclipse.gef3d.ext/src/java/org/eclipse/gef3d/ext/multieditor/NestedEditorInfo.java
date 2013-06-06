/*******************************************************************************
 * Copyright (c) 2010 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.ext.multieditor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;

/**
 * NestedEditorInfo There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Jun 25, 2010
 */
public class NestedEditorInfo implements INestedEditorInfo {

	public static class NestedEditorInfoList implements
			Iterable<NestedEditorInfo> {

		protected Vector<NestedEditorInfo> infos =
			new Vector<NestedEditorInfo>();

		private static final long serialVersionUID = 1475599197292250765L;

		public boolean contains(IEditorInput key) {
			if (key==null) return false;
			for (NestedEditorInfo info : infos) {
				if (info.getEditorInput().equals(key)
					|| info.getEditorInput().getName().equals(key.getName()))
					return true;
			}
			return false;
		}
		
		public boolean contains(INestedEditorInfo info) {
			if (info==null)
				return false;
			return contains(info.getEditorInput());
		}
		
		public boolean add(NestedEditorInfo info) {
			if (info == null) // parameter precondition
				throw new NullPointerException("info must not be null");
			if (contains(info)) return false;
			return infos.add(info);
		}

		public boolean remove(INestedEditorInfo info) {
			return infos.remove(info);
		}

		public NestedEditorInfo getByEditorInput(IEditorInput i_editorInput) {
			for (NestedEditorInfo info : infos) {
				if (info.getEditorInput().equals(i_editorInput))
					return info;
			}
			return null;
		}

		public NestedEditorInfo getByContents(Object i_contents) {
			for (NestedEditorInfo info : infos) {
				if (info.getContents().equals(i_contents))
					return info;
			}
			return null;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see java.lang.Iterable#iterator()
		 */
		public Iterator<NestedEditorInfo> iterator() {
			return infos.iterator();
		}

		/**
		 * @return
		 */
		public int size() {
			return infos.size();
		}

	}

	String m_editorID;

	IEditorInput m_editorInput;

	IEditorSite m_editorSite;

	IMultiEditor m_multiEditor;

	INestableEditor m_nestableEditor;

	State m_state;

	HashMap<String, Object> m_properties;

	Object m_contents;

	/**
	 * Creates a new info with the given key.
	 * 
	 * @param i_editorInput must not be null
	 * @param i_multiEditor must not be null
	 */
	public NestedEditorInfo(IEditorInput i_editorInput,
			IMultiEditor i_multiEditor) {
		if (i_editorInput == null) // parameter precondition
			throw new NullPointerException("i_editorInput must not be null");
		if (i_multiEditor == null) // parameter precondition
			throw new NullPointerException("i_multiEditor must not be null");

		m_editorInput = i_editorInput;
		m_multiEditor = i_multiEditor;
		m_state = State.starting;
		m_properties = new HashMap<String, Object>();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.multieditor.INestedEditorInfo#getMultiEditor()
	 */
	public IMultiEditor getMultiEditor() {
		return m_multiEditor;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.multieditor.INestedEditorInfo#getEditorID()
	 */
	public String getEditorID() {
		return m_editorID;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.multieditor.INestedEditorInfo#getEditorInput()
	 */
	public IEditorInput getEditorInput() {
		return m_editorInput;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.multieditor.INestedEditorInfo#getEditorSite()
	 */
	public IEditorSite getEditorSite() {
		return m_editorSite;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.multieditor.INestedEditorInfo#getNestableEditor()
	 */
	public INestableEditor getNestableEditor() {
		return m_nestableEditor;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.multieditor.INestedEditorInfo#getProperty(java.lang.String)
	 */
	public Object getProperty(String i_key) {
		return m_properties.get(i_key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.multieditor.INestedEditorInfo#getState()
	 */
	public State getState() {
		return m_state;
	}

	/**
	 * Sets the state of the nested editor. The state is initially set to
	 * {@link State#starting}. When the editor has been initialized, the state
	 * is changed to {@value State#active}. This method should only be called by
	 * the multi editor nesting the editor.
	 * 
	 * @param i_state
	 */
	public void setState(State i_state) {
		m_state = i_state;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.multieditor.INestedEditorInfo#setProperty(java.lang.String,
	 *      java.lang.Object)
	 */
	public void setProperty(String i_key, Object i_value) {
		if (i_value == null) {
			m_properties.remove(i_key);
		} else {
			m_properties.put(i_key, i_value);
		}
	}

	/**
	 * Sets the editor ID, this method should only be called be the multi editor
	 * nesting the nestable editor.
	 * 
	 * @param i_editorID the m_editorID to set
	 */
	public void setEditorID(String i_editorID) {
		m_editorID = i_editorID;
	}

	/**
	 * Sets the editor site, this method should only be called be the multi
	 * editor nesting the nestable editor.
	 * 
	 * @param i_editorSite the m_editorSite to set
	 */
	public void setEditorSite(IEditorSite i_editorSite) {
		m_editorSite = i_editorSite;
	}

	/**
	 * Sets the nestable editor, this method should only be called be the multi
	 * editor nesting the nestable editor. It should not be changed after it has
	 * been set. When the nestable editor is set, the state (see
	 * {@link #getState()} is automatically changed to {@link State#active}
	 * 
	 * @param i_nestableEditor the m_nestableEditor to set
	 */
	public void setNestableEditor(INestableEditor i_nestableEditor) {
		m_nestableEditor = i_nestableEditor;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.multieditor.INestedEditorInfo#getContents()
	 */
	public Object getContents() {
		return m_contents;
	}

	/**
	 * Sets the contents model of the nested editor, this method should only be
	 * called be the multi editor nesting the nestable editor.
	 */
	public void setContents(Object contents) {
		m_contents = contents;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NestedEditorInfo (").append(getState()).append("): ")
			.append(getEditorInput().getName()).append(" [");
		if (getNestableEditor() != null)
			builder.append("editor=").append(
				getNestableEditor().getClass().getSimpleName());
		if (getEditorID() != null)
			builder.append(", id=").append(getEditorID());
		builder.append("]");
		return builder.toString();
	}

}
