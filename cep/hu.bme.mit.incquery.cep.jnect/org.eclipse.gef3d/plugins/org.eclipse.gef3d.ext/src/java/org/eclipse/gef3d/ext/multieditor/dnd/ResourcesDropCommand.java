/*******************************************************************************
 * Copyright (c) 2011 Jens von Pilgrim and others.
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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef3d.ext.multieditor.IMultiEditor;
import org.eclipse.gef3d.ext.multieditor.ResourceEditorInput;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;

/**
 * This command causes a multi editor to open a new editor input based on a
 * {@link ResourceEditorInput}. This command cannot be undone.
 * <p>
 * The dropped resources are encapsulated into either {@link FileEditorInput}
 * or {@link ResourceEditorInput} objects.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @version $Revision$
 * @since Jun 11, 2011
 * @see ResourceEditorInput
 */
public class ResourcesDropCommand extends AbstractDropOnMultiEditorCommand {

	private List<IResource> resources;

	/**
	 * @param i_multiEditor must not be null
	 * @param i_location may be null
	 * @param i_resources must not be null
	 */
	public ResourcesDropCommand(IMultiEditor i_multiEditor, Point i_location,
			List<IResource> i_resources) {
		super(i_multiEditor, i_location);
		if (i_resources == null) // parameter precondition
			throw new NullPointerException("i_resources must not be null");

		resources = i_resources;
	}

	/**
	 * Getter for resources property, property is immutable and set in
	 * constructor.
	 * 
	 * @return the resources
	 */
	protected List<IResource> getResources() {
		return resources;
	}

	/**
	 * Returns true if at least one editor input is accepted by the editor.
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		for (IResource resource : resources) {
			IEditorInput editorInput =
				(resource instanceof IFile) ? new FileEditorInput((IFile) resource)
					: new ResourceEditorInput(resource);
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
		for (IResource resource : resources) {
			IEditorInput editorInput =
				(resource instanceof IFile) ? new FileEditorInput((IFile) resource)
					: new ResourceEditorInput(resource);
			if (getMultiEditor().acceptsInput(editorInput))
				getMultiEditor().addEditor(editorInput);
		}
	}

}
