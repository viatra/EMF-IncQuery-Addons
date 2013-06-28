/*******************************************************************************
 * Copyright (c) 2000, 2006 IBM Corporation and others.
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation (RadioGroupFieldEditor)
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.ui.preferences.dialog;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

/**
 * Allows editing of bit fields. This class was copied from
 * {@link RadioGroupFieldEditor} and subsequently modified to display check
 * boxes.
 * 
 * @author IBM Corporation (individual author unknown)
 * @author Kristian Duske
 * @version $Revision$
 * @since 19.02.2009
 */
public class BitFieldEditor extends FieldEditor {

	Button[] checkboxes;

	Composite groupBox;

	private int indent = HORIZONTAL_GAP;

	private String[] labels;

	private int numColumns;

	private boolean useGroup;

	int value;

	private int[] values;

	/**
	 * Creates a bit field editor. This constructor does not use a
	 * <code>Group</code> to contain the checkboxes. It is equivalent to using
	 * the following constructor with <code>false</code> for the
	 * <code>useGroup</code> argument.
	 * <p>
	 * Example usage:
	 * 
	 * <pre>
	 * 	BitFieldEditor editor= new BitFieldEditor(
	 * 		&quot;GeneralPage.Modifiers&quot;, resName, 1,
	 * 		new String[] {
	 * 			{&quot;Control key&quot;},
	 * 			{&quot;Shift key&quot;},
	 * 			{&quot;Alt key&quot;}
	 * 		},
	 *      new int[] {1, 2, 4}
	 *      parent);
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param i_name
	 *            the name of the preference this field editor works on
	 * @param i_labelText
	 *            the label text of the field editor
	 * @param i_numColumns
	 *            the number of columns for the checkbox presentation
	 * @param i_labels
	 *            list of checkbox labels
	 * @param i_values
	 *            list of integer values; the returned value is the bitwise
	 *            combination of these
	 * @param i_parent
	 *            the parent of the field editor's control
	 */
	public BitFieldEditor(String i_name, String i_labelText, int i_numColumns,
			String[] i_labels, int[] i_values, Composite i_parent) {
		this(i_name, i_labelText, i_numColumns, i_labels, i_values, i_parent,
				false);
	}

	/**
	 * Creates a bit field editor.
	 * <p>
	 * Example usage:
	 * 
	 * <pre>
	 * BitFieldEditor editor = new BitFieldEditor(
	 * 		&quot;GeneralPage.Modifiers&quot;, resName, 1,
	 * 		new String[] {
	 * 			{&quot;Control key&quot;},
	 * 			{&quot;Shift key&quot;},
	 * 			{&quot;Alt key&quot;}
	 * 		},
	 *      new int[] {1, 2, 4}
	 *      parent, true);
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param i_name
	 *            the name of the preference this field editor works on
	 * @param i_labelText
	 *            the label text of the field editor
	 * @param i_numColumns
	 *            the number of columns for the radio button presentation
	 * @param i_labels
	 *            list of checkbox labels
	 * @param i_values
	 *            list of integer values; the returned value is the bitwise
	 *            combination of these
	 * @param i_parent
	 *            the parent of the field editor's control
	 * @param i_useGroup
	 *            whether to use a Group control to contain the radio buttons
	 */
	public BitFieldEditor(String i_name, String i_labelText, int i_numColumns,
			String[] i_labels, int[] i_values, Composite i_parent,
			boolean i_useGroup) {

		init(i_name, i_labelText);
		Assert.isTrue(i_labels.length == i_values.length);
		this.labels = i_labels;
		this.values = i_values;
		this.numColumns = i_numColumns;
		this.useGroup = i_useGroup;
		createControl(i_parent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.FieldEditor#adjustForNumColumns(int)
	 */
	@Override
	protected void adjustForNumColumns(int i_numColumns) {

		Control control = getLabelControl();
		if (control != null) {
			((GridData) control.getLayoutData()).horizontalSpan = numColumns;
		}
		((GridData) groupBox.getLayoutData()).horizontalSpan = numColumns;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.FieldEditor#doFillIntoGrid(org.eclipse.swt.widgets.Composite,
	 *      int)
	 */
	@Override
	protected void doFillIntoGrid(Composite i_parent, int i_numColumns) {

		if (useGroup) {
			Control control = getGroupControl(i_parent);
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			control.setLayoutData(gd);
		} else {
			Control control = getLabelControl(i_parent);
			GridData gd = new GridData();
			gd.horizontalSpan = i_numColumns;
			control.setLayoutData(gd);
			control = getGroupControl(i_parent);
			gd = new GridData();
			gd.horizontalSpan = i_numColumns;
			gd.horizontalIndent = indent;
			control.setLayoutData(gd);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.FieldEditor#doLoad()
	 */
	@Override
	protected void doLoad() {

		updateValue(getPreferenceStore().getInt(getPreferenceName()));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.FieldEditor#doLoadDefault()
	 */
	@Override
	protected void doLoadDefault() {

		updateValue(getPreferenceStore().getDefaultInt(getPreferenceName()));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.FieldEditor#doStore()
	 */
	@Override
	protected void doStore() {

		getPreferenceStore().setValue(getPreferenceName(), value);
	}

	private Control getGroupControl(Composite parent) {

		if (groupBox == null) {
			Font font = parent.getFont();
			if (useGroup) {
				Group group = new Group(parent, SWT.NONE);
				group.setFont(font);
				String text = getLabelText();
				if (text != null)
					group.setText(text);
				groupBox = group;
				GridLayout layout = new GridLayout();
				layout.horizontalSpacing = HORIZONTAL_GAP;
				layout.numColumns = numColumns;
				groupBox.setLayout(layout);
			} else {
				groupBox = new Composite(parent, SWT.NONE);
				GridLayout layout = new GridLayout();
				layout.marginWidth = 0;
				layout.marginHeight = 0;
				layout.horizontalSpacing = HORIZONTAL_GAP;
				layout.numColumns = numColumns;
				groupBox.setLayout(layout);
				groupBox.setFont(font);
			}

			checkboxes = new Button[labels.length];
			for (int i = 0; i < labels.length; i++) {
				Button checkbox = new Button(groupBox, SWT.CHECK | SWT.LEFT);
				checkboxes[i] = checkbox;
				checkbox.setText(labels[i]);
				checkbox.setData(values[i]);
				checkbox.setFont(font);
				checkbox.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent event) {
						int oldValue = value;
						Button button = (Button) event.widget;
						int bit = (Integer) button.getData();
						if (button.getSelection())
							value |= bit;
						else
							value &= ~bit;

						setPresentsDefaultValue(false);
						fireValueChanged(VALUE, oldValue, value);
					}
				});
			}
			groupBox.addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent event) {
					groupBox = null;
					checkboxes = null;
				}
			});
		} else {
			checkParent(groupBox, parent);
		}
		return groupBox;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.FieldEditor#getNumberOfControls()
	 */
	@Override
	public int getNumberOfControls() {

		return 1;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.FieldEditor#setEnabled(boolean,
	 *      org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void setEnabled(boolean i_enabled, Composite i_parent) {

		if (!useGroup)
			super.setEnabled(i_enabled, i_parent);

		for (int i = 0; i < checkboxes.length; i++) {
			checkboxes[i].setEnabled(i_enabled);
		}

	}

	/**
	 * Sets the indent used for the first column of the checkbox matrix.
	 * 
	 * @param i_indent
	 *            the indent (in pixels)
	 */
	public void setIndent(int i_indent) {
		if (i_indent < 0) {
			this.indent = 0;
		} else {
			this.indent = i_indent;
		}
	}

	/**
	 * Updates the checkboxes according to the given value.
	 * 
	 * @param i_newValue
	 *            the value
	 */
	public void updateValue(int i_newValue) {

		this.value = i_newValue;
		if (checkboxes == null)
			return;

		for (int i = 0; i < checkboxes.length; i++) {
			Button checkbox = checkboxes[i];
			int data = (Integer) checkbox.getData();
			checkbox.setSelection((i_newValue & data) != 0);
		}
	}

}
