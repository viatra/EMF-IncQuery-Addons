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
package org.eclipse.gef3d.ext.multieditor;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.EditPart;
import org.eclipse.ui.IEditorInput;

/**
 * Editor implementing this interface can be used in combination with the
 * Drag-and-Drop mechanisms provided in the dnd-package in order to open
 * diagrams in the multi-editor.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Apr 15, 2009
 */
public interface IMultiEditor extends IAdaptable {

	/**
	 * Indicates whether this multi editor accepts the given editor input.
	 * 
	 * @param i_editorInput the editor input to accept
	 * @return <code>true</code> if this multi editor accepts the given input
	 *         and <code>false</code> otherwise
	 */
	public boolean acceptsInput(IEditorInput i_editorInput);

	/**
	 * Adds the given editor input to this multi editor. If a new nestable
	 * editor is actually created, this method should call the following methods
	 * in that order:
	 * <ol>
	 * <li>{@link INestableEditor#setMultiEditor(IMultiEditor)}</li>
	 * <li>
	 * {@link INestableEditor#init(org.eclipse.ui.IEditorSite, IEditorInput)}</li>
	 * <li>
	 * {@link INestableEditor#initializeAsNested(org.eclipse.gef.GraphicalViewer, MultiEditorPartFactory, MultiEditorModelContainer)}
	 * </li>
	 * </ol>
	 * <p>
	 * This method is defined here in order to enable other classes to
	 * dynamically load new models into the multi editor.
	 * </p>
	 * 
	 * @param i_editorInput the input to add
	 * @param true if the editor was actually added
	 */
	public boolean addEditor(IEditorInput i_editorInput);

	/**
	 * Retrieves an {@link INestableEditor} by an edit part. This method is used
	 * for example by {@link MultiEditorPropertySheetPage} in order to retrieve
	 * the nested editor based on the current selection.
	 * 
	 * @param part the part
	 * @return the nested editor or null, if no nested editor is found
	 */
	public INestableEditor findEditorByEditPart(EditPart part);

	/**
	 * Returns the content edit part of the given nested editor. This method is
	 * rather expensive (however, usually there are not too much editors
	 * nested).
	 * 
	 * @param nestableEditor
	 * @return
	 */
	public EditPart findNestedEditorContent(INestableEditor nestableEditor);

	/**
	 * Adds a new {@link IMultiEditorListener} which is notified when editors
	 * are newly nested or remove.
	 * 
	 * @param multiEditorListener, must not be null
	 */
	public void addMultiEditorListener(IMultiEditorListener multiEditorListener);

	/**
	 * Removes an {@link IMultiEditorListener}.
	 * 
	 * @param multiEditorListener
	 */
	public void removeMultiEditorListener(
		IMultiEditorListener multiEditorListener);
}
