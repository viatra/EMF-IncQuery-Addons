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

import static org.eclipse.draw3d.ui.preferences.PrefNames.*;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.core.runtime.Platform;
import org.eclipse.draw3d.ui.Draw3DUIPlugin;
import org.eclipse.draw3d.ui.preferences.PrefNames;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.preference.ScaleFieldEditor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * Preference page implementation for camera control settings.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 03.11.2009
 */
public class CameraPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage, IPropertyChangeListener {

	private Collection<FieldEditor> m_editors = new LinkedList<FieldEditor>();

	private FieldEditor m_invalidEditor;

	/**
	 * Creates a new preference page.
	 */
	public CameraPreferencePage() {

		setPreferenceStore(Draw3DUIPlugin.getDefault().getPreferenceStore());
		setDescription("Draw3D camera preferences");
	}

	private void addEditor(FieldEditor i_editor) {

		m_editors.add(i_editor);

		i_editor.setPage(this);
		i_editor.setPropertyChangeListener(this);
		i_editor.setPreferenceStore(getPreferenceStore());
		i_editor.load();
	}

	private void addKeyEditor(String i_prefName, String i_label,
		int i_keyStrokeLimit, Composite i_parent) {

		KeyBindingFieldEditor keyEditor =
			new KeyBindingFieldEditor(i_prefName, i_label, i_parent);

		keyEditor.setKeyStrokeLimit(i_keyStrokeLimit);
		addEditor(keyEditor);
	}

	private void checkState() {

		for (FieldEditor editor : m_editors)
			if (!editor.isValid()) {
				m_invalidEditor = editor;
				setValid(false);
				break;
			}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createContents(Composite i_parent) {

		Composite control = new Composite(i_parent, SWT.NULL);
		control.setLayout(new GridLayout(1, true));

		createMouseControls(control);
		createKeyboardControls(control);

		checkState();
		return control;
	}

	private void createKeyboardControls(Composite i_parent) {

		Group keyboardGroup = new Group(i_parent, SWT.NULL);
		keyboardGroup.setText("Keyboard");
		keyboardGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		FillLayout fillLayout = new FillLayout();
		fillLayout.marginWidth = 10;
		fillLayout.marginHeight = 10;
		keyboardGroup.setLayout(fillLayout);

		Composite editorParent = new Composite(keyboardGroup, SWT.NULL);

		addKeyEditor(KEY_FORWARD, "Move forward:", 1, editorParent);
		addKeyEditor(KEY_BACKWARD, "Move backward:", 1, editorParent);

		addKeyEditor(KEY_LEFT, "Move left:", 1, editorParent);
		addKeyEditor(KEY_RIGHT, "Move right:", 1, editorParent);

		addKeyEditor(KEY_UP, "Move up:", 1, editorParent);
		addKeyEditor(KEY_DOWN, "Move down:", 1, editorParent);

		addKeyEditor(KEY_ROLL_CCW, "Roll left:", 1, editorParent);
		addKeyEditor(KEY_ROLL_CW, "Roll right:", 1, editorParent);

		addKeyEditor(KEY_CENTER, "Center view", 1, editorParent);
	}

	private void createMouseControls(Composite i_parent) {

		Group mouseGroup = new Group(i_parent, SWT.NULL);
		mouseGroup.setText("Mouse");
		mouseGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		FillLayout fillLayout = new FillLayout();
		fillLayout.marginWidth = 10;
		fillLayout.marginHeight = 10;
		mouseGroup.setLayout(fillLayout);

		Composite editorParent = new Composite(mouseGroup, SWT.NULL);

		addEditor(new ScaleFieldEditor(PrefNames.MOUSE_SENSITIVITY,
			"Mouse sensitivity:", editorParent, 1, 100, 1, 20));

		String[] modOrbitLabels;
		int[] modOrbitValues;
		if (Platform.OS_MACOSX.equals(Platform.getOS())) {
			modOrbitLabels = new String[] { "Shift", "Ctrl", "Alt", "Cmd" };
			modOrbitValues =
				new int[] { SWT.SHIFT, SWT.CONTROL, SWT.ALT, SWT.MOD1 };
		} else {
			modOrbitLabels = new String[] { "Shift", "Ctrl", "Alt" };
			modOrbitValues = new int[] { SWT.SHIFT, SWT.CONTROL, SWT.ALT };
		}

		addEditor(new BitFieldEditor(PrefNames.MOD_ORBIT, "Orbit key:",
			modOrbitLabels.length, modOrbitLabels, modOrbitValues, editorParent));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench i_workbench) {
		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#performApply()
	 */
	@Override
	protected void performApply() {

		for (FieldEditor editor : m_editors)
			editor.store();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#performCancel()
	 */
	@Override
	public boolean performCancel() {

		for (FieldEditor editor : m_editors)
			editor.load();

		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#performDefaults()
	 */
	@Override
	protected void performDefaults() {

		for (FieldEditor editor : m_editors)
			editor.loadDefault();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#performOk()
	 */
	@Override
	public boolean performOk() {

		performApply();
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.util.IPropertyChangeListener#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent i_event) {

		String property = i_event.getProperty();
		if (FieldEditor.IS_VALID.equals(property)) {
			Object newValue = i_event.getNewValue();
			if (newValue instanceof Boolean) {
				boolean valid = ((Boolean) newValue).booleanValue();
				if (valid) {
					checkState();
				} else {
					m_invalidEditor = (FieldEditor) i_event.getSource();
					setValid(valid);
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.DialogPage#setVisible(boolean)
	 */
	@Override
	public void setVisible(boolean i_visible) {
		super.setVisible(i_visible);

		if (i_visible && m_invalidEditor != null)
			m_invalidEditor.setFocus();
	}
}
