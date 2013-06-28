/*******************************************************************************
 * Copyright (c) 2009 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.ui.preferences.dialog;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.widgets.Composite;

/**
 * Abstract base implementation for preference pages that contain editors for
 * key bindings.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 03.11.2009
 */
public abstract class KeyFieldEditorPreferencePage extends
		FieldEditorPreferencePage {

	/**
	 * Creates a new preference pages with the given style.
	 * 
	 * @param i_style the style
	 */
	public KeyFieldEditorPreferencePage(int i_style) {

		super(i_style);
	}

	/**
	 * Adds a key binding field editor with the given preference name, label and
	 * key stroke limit.
	 * 
	 * @param i_prefName the name of the preference in the preference store
	 * @param i_label the label
	 * @param i_keyStrokeLimit the maximum number of keystrokes
	 * @param i_parent the parent composite
	 */
	protected void addKeyEditor(String i_prefName, String i_label,
		int i_keyStrokeLimit, Composite i_parent) {

		KeyBindingFieldEditor keyEditor =
			new KeyBindingFieldEditor(i_prefName, i_label, i_parent);

		keyEditor.setKeyStrokeLimit(i_keyStrokeLimit);
		addField(keyEditor);
	}
}
