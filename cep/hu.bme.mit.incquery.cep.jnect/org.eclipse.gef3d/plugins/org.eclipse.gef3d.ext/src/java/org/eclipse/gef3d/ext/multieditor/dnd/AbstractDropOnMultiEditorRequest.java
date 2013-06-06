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

import org.eclipse.gef.requests.DropRequest;
import org.eclipse.gef.requests.LocationRequest;
import org.eclipse.gef3d.ext.multieditor.IMultiEditor;
import org.eclipse.ui.IEditorInput;

/**
 * Base class for requests indicating a drop onto a multi editor, e.g., for
 * opening new files in the 3D scene.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @version $Revision$
 * @since Jun 11, 2011
 */
public abstract class AbstractDropOnMultiEditorRequest extends LocationRequest
		implements DropRequest {

	/**
	 * The multi editor, set in constructor, get via getter.
	 */
	private IMultiEditor multiEditor;

	/**
	 * @param i_multiEditor must not be null
	 */
	public AbstractDropOnMultiEditorRequest(IMultiEditor i_multiEditor) {
		if (i_multiEditor == null) // parameter precondition
			throw new NullPointerException("i_multiEditor must not be null");

		multiEditor = i_multiEditor;
	}

	/**
	 * @param i_type
	 * @param i_multiEditor must not be null
	 */
	public AbstractDropOnMultiEditorRequest(IMultiEditor i_multiEditor,
			Object i_type) {
		super(i_type);
		if (i_multiEditor == null) // parameter precondition
			throw new NullPointerException("i_multiEditor must not be null");

		multiEditor = i_multiEditor;
	}

	/**
	 * Returns the multi editor in which context this request has been created,
	 * that is on which the {@link IEditorInput} was been dropped. This property
	 * is immutable and set in constructor.
	 * 
	 * @return the dropableMultiEditor
	 */
	public IMultiEditor getMultiEditor() {
		return multiEditor;
	}

}
