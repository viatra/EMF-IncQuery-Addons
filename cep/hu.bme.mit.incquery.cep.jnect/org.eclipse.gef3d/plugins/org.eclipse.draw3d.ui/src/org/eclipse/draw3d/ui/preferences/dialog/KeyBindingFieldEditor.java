/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.ui.preferences.dialog;

import org.eclipse.jface.bindings.keys.KeySequence;
import org.eclipse.jface.bindings.keys.KeySequenceText;
import org.eclipse.jface.bindings.keys.ParseException;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.widgets.Composite;

/**
 * A field editor for key bindings. Uses JFace key bindings internally.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 06.03.2008
 */
public class KeyBindingFieldEditor extends StringFieldEditor {

	private KeySequenceText m_keySequenceText;

	/**
	 * Creates a new key binding field editor with the given parameters.
	 * 
	 * @param i_name the name of the preference property to edit
	 * @param i_label the label text
	 * @param i_parent the parent control
	 */
	public KeyBindingFieldEditor(String i_name, String i_label,
			Composite i_parent) {
		super(i_name, i_label, i_parent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.FieldEditor#doFillIntoGrid(org.eclipse.swt.widgets.Composite,
	 *      int)
	 */
	@Override
	protected void doFillIntoGrid(Composite i_parent, int i_numColumns) {

		super.doFillIntoGrid(i_parent, i_numColumns);
		m_keySequenceText = new KeySequenceText(getTextControl(i_parent));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.FieldEditor#doLoad()
	 */
	@Override
	protected void doLoad() {

		String name = getPreferenceName();
		String string = getPreferenceStore().getString(name);

		loadKeySequence(string);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.FieldEditor#doLoadDefault()
	 */
	@Override
	protected void doLoadDefault() {

		String name = getPreferenceName();
		String string = getPreferenceStore().getDefaultString(name);

		loadKeySequence(string);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.FieldEditor#doStore()
	 */
	@Override
	protected void doStore() {

		KeySequence keySequence = m_keySequenceText.getKeySequence();

		String name = getPreferenceName();
		getPreferenceStore().setValue(name, keySequence.toString());
	}

	/**
	 * @param string
	 */
	private void loadKeySequence(String string) {
		try {
			KeySequence keySequence = KeySequence.getInstance(string);
			m_keySequenceText.setKeySequence(keySequence);
		} catch (ParseException ex) {
			throw new RuntimeException(
					"Unable to parse key sequence for preference "
							+ getPreferenceName() + ": " + string, ex);
		}
	}

	/**
	 * Sets the maximum number of key strokes allowed for key sequences created
	 * by this field editor.
	 * 
	 * @param i_keyStrokeLimit the maximum number of allowed key strokes
	 */
	public void setKeyStrokeLimit(int i_keyStrokeLimit) {

		m_keySequenceText.setKeyStrokeLimit(i_keyStrokeLimit);
	}
}
