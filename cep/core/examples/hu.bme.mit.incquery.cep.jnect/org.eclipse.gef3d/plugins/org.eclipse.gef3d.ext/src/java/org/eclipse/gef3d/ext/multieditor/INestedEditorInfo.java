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

import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;

/**
 * Collects all information regarding an {@link INestableEditor} actually nested
 * into an {@link IMultiEditor}. This information is created and updated by the
 * multi editor and can be used by clients and the multi editor itself to
 * retrieve metadata about the nested editor.
 * <p>
 * This interface provides only limited write access to the information, the
 * implementation is fully mutable.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Jun 25, 2010
 */
public interface INestedEditorInfo {

	public static enum State {
		starting, active
	}
	
	/**
	 * The multi editor nesting the nestable editor.
	 * 
	 * @return
	 */
	IMultiEditor getMultiEditor();

	/**
	 * The nestable editor itself.
	 * 
	 * @return
	 */
	INestableEditor getNestableEditor();

	/**
	 * The editor input of the nestable editor. This information is always
	 * available and used as key.
	 * 
	 * @return the input, this information is always available
	 */
	IEditorInput getEditorInput();

	/**
	 * The editor site of the nested editor. This usually is only a proxy of the
	 * editor site of the multi editor. The site may be used by clients to
	 * identify the type of editor, also see {@link #getEditorID()}.
	 * 
	 * @return the site or null, if this inforamtion is not available
	 */
	IEditorSite getEditorSite();

	/**
	 * The ID of the nested editor or null, if this information is not
	 * available. The ID may be used by clients such as (GMF) providers to
	 * identify the type of editor, also see {@link #getEditorSite()}.
	 * 
	 * @return
	 */
	String getEditorID();

	/**
	 * The current state of the nestable editor. While the editor is
	 * initialized, its state is {@link State#starting}. This is usually only
	 * true while {@link AbstractMultiEditor3D#addEditor(IEditorInput)} is
	 * active. When the editor has been added, its state is changed to
	 * {@link State#active}. The state is managed by the multi editor.
	 * 
	 * @return
	 */
	State getState();

	/**
	 * Returns the contents model of the nested editor, usually the
	 * "diagram" itself.
	 * 
	 * @return
	 */
	Object getContents();

	/**
	 * Returns an application specific property stored in this info or null, if
	 * no such information is found.
	 * 
	 * @param key
	 * @return
	 */
	Object getProperty(String key);

	/**
	 * Sets a property to the new value.
	 * 
	 * @param key
	 * @param value new value or null, to remove the current value
	 */
	void setProperty(String key, Object value);
}
