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

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef3d.ext.multieditor.IMultiEditor;

/**
 * Base class for drop commands for dropping something onto a multi editor.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @version $Revision$
 * @since Jun 11, 2011
 */
public class AbstractDropOnMultiEditorCommand extends Command {

	private IMultiEditor multiEditor;

	private Point location;

	/**
	 * @param i_multiEditor must not be null
	 * @param i_location may be null
	 */
	public AbstractDropOnMultiEditorCommand(IMultiEditor i_multiEditor, Point i_location) {
		if (i_multiEditor == null) // parameter precondition
			throw new NullPointerException("i_multiEditor must not be null");

		multiEditor = i_multiEditor;
		location = i_location;
	}

	/**
	 * Getter for multi editor property, property is immutable and set in
	 * constructor.
	 * 
	 * @return the multiEditor
	 */
	protected IMultiEditor getMultiEditor() {
		return multiEditor;
	}

	/**
	 * Getter for location property, property is immutable and set in
	 * constructor.
	 * 
	 * @return the location, may be null
	 */
	protected Point getLocation() {
		return location;
	}

	/**
	 * Always returns false, as drop command usually lead to opening an editor
	 * and this cannot be undone yet.
	 * 
	 * @see org.eclipse.gef.commands.Command#canUndo()
	 */
	@Override
	public boolean canUndo() {
		return false;
	}

}
