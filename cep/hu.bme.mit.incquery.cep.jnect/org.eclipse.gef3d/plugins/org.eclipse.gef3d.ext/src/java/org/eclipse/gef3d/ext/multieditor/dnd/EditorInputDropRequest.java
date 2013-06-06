/*******************************************************************************
 * Copyright (c) 2009 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.ext.multieditor.dnd;

import java.util.List;

import org.eclipse.gef3d.ext.multieditor.IMultiEditor;
import org.eclipse.ui.IEditorInput;

/**
 * Request indicating an {@link IEditorInput} has been dropped onto a figure. In
 * order to work, the editor using this policy must implement the
 * {@link IMultiEditor} interface. It is used in conjunction with the
 * {@link EditorInputTransferDropTargetListener} which creates this request and
 * also calls all setters.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Apr 15, 2009
 */
public class EditorInputDropRequest extends AbstractDropOnMultiEditorRequest {

	/**
	 * The editor inputs, get/set via getter/setter.
	 */
	protected List<IEditorInput> editorInputs;

	public static String UNDEF_TYPE = "UNDEF_TYPE";

	/**
	 * Constructs this request and set type to {@link #UNDEF_TYPE}.
	 */
	public EditorInputDropRequest(IMultiEditor i_multiEditor) {
		this(i_multiEditor, UNDEF_TYPE);
	}

	/**
	 * Constructs this request and set s type. The type should not be null since
	 * some policies may throw a {@link NullPointerException} in that case.
	 * 
	 * @param type type of this request, should not be null.
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=285741
	 */
	public EditorInputDropRequest(IMultiEditor i_multiEditor, Object type) {
		super(i_multiEditor, type);
	}

	/**
	 * Returns the {@link IEditorInput}s which were dropped onto the editor,
	 * i.e. the figure. This value is set after the mouse has been released and
	 * the drop actually occurred.
	 * 
	 * @return the editorInputs
	 */
	public List<IEditorInput> getEditorInputs() {
		return editorInputs;
	}

	/**
	 * Called by {@link EditorInputTransferDropTargetListener} when the drop
	 * actually occurred (that is after the mouse button has been released).
	 * 
	 * @param i_editorInputs the editorInputs to set
	 */
	protected void setEditorInputs(List<IEditorInput> i_editorInputs) {
		editorInputs = i_editorInputs;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("EditorInputRequest");
		if (getLocation() != null) {
			result.append(" at ").append(getLocation().toString());
		}
		if (editorInputs != null) {
			result.append(" with input ").append(editorInputs.toString());
		} else {
			result.append(" w/o input information");
		}
		return result.toString();
	}

}
