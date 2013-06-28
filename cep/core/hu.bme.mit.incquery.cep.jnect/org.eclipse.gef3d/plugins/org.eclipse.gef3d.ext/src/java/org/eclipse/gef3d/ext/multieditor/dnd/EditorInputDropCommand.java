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
import java.util.logging.Logger;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef3d.ext.multieditor.IMultiEditor;
import org.eclipse.ui.IEditorInput;

/**
 * This command causes a multi editor to open a new editor input. This command
 * cannot be undone.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Apr 15, 2009
 */
public class EditorInputDropCommand extends AbstractDropOnMultiEditorCommand {
	/**
	 * Logger for this class
	 */
	@SuppressWarnings("unused")
	private static final Logger log = Logger
		.getLogger(EditorInputDropCommand.class.getName());

	List<IEditorInput> editorInputs;

	/**
	 * @param i_multiEditor must not be null
	 * @param i_location may be null
	 * @param i_editorInputs must not be null
	 */
	public EditorInputDropCommand(IMultiEditor i_multiEditor, Point i_location,
			List<IEditorInput> i_editorInputs) {
		super(i_multiEditor, i_location);
		if (i_editorInputs == null) // parameter precondition
			throw new NullPointerException("i_editorInputs must not be null");

		editorInputs = i_editorInputs;
	}

	/**
	 * Getter for editor inputs property, property is immutable and set in
	 * constructor.
	 * 
	 * @return the editorInputs
	 */
	protected List<IEditorInput> getEditorInputs() {
		return editorInputs;
	}

	/**
	 * Returns true if at least one editor input is accepted by the editor.
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		for (IEditorInput editorInput : editorInputs) {
			if (getMultiEditor().acceptsInput(editorInput))
				return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		for (IEditorInput editorInput : editorInputs) {
			if (getMultiEditor().acceptsInput(editorInput))
				getMultiEditor().addEditor(editorInput);
		}
	}

}
