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
package org.eclipse.gef3d.examples.graph.editor.wizard;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IEditorDescriptor;

class GraphWizardOpenWithPage extends WizardPage {

	/**
	 * 
	 */
	private final GraphWizard graphWizard;

	LinkedHashSet<IEditorDescriptor> allEditors;

	LinkedHashSet<IEditorDescriptor> graphEditors;

	LinkedHashSet<IEditorDescriptor> multiEditors;

	Button radioButtons[] = null;

	public GraphWizardOpenWithPage(GraphWizard graphWizard,
			final String pageName) {
		super(pageName);
		this.graphWizard = graphWizard;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(final Composite parent) {
		final Composite composite = new Composite(parent, SWT.None);
		final GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.verticalSpacing = 12;
		composite.setLayout(layout);
		final GridData data = new GridData();
		data.verticalAlignment = GridData.FILL;
		data.grabExcessVerticalSpace = true;
		data.horizontalAlignment = GridData.FILL;
		composite.setLayoutData(data);

		final Label label = new Label(composite, SWT.LEFT);
		label.setText("Open with editor:");

		initEditorDescriptors();
		radioButtons = new Button[allEditors.size()];
		int i = 0;
		for (IEditorDescriptor descr : allEditors) {
			radioButtons[i] = new Button(composite, SWT.RADIO);
			radioButtons[i].setText(descr.getLabel());
			radioButtons[i].setData(descr);
			if (i == 0) {
				radioButtons[i].setSelection(true);
			}
			i++;
		}

		setPageComplete(true);
		setControl(composite);
		setEditorType(1);
	}

	public void setEditorType(int numberOfPlanes) {
		if (radioButtons != null) {
			Set<IEditorDescriptor> active =
				(numberOfPlanes == 1) ? graphEditors : multiEditors;
			boolean bEnable;
			boolean bFirst = true;
			for (Button radio : radioButtons) {
				bEnable = active.contains(radio.getData());
				radio.setEnabled(bEnable);
				if (bEnable) {
					radio.setSelection(bFirst);
					bFirst = false;
				} else {
					radio.setSelection(false);
				}
			}
		}
	}

	IEditorDescriptor getEditorDescriptor() {
		for (int i = 0; i < radioButtons.length; i++) {
			if (radioButtons[i].getSelection())
				return (IEditorDescriptor) radioButtons[i].getData();
		}
		return null;
	}

	protected void initEditorDescriptors() {
		IEditorDescriptor[] ieDescriptors =
			this.graphWizard.workbench.getEditorRegistry().getEditors(
				"x." + GraphWizard.EXT_1);
		graphEditors =
			new LinkedHashSet<IEditorDescriptor>(Arrays.asList(ieDescriptors));

		ieDescriptors =
			this.graphWizard.workbench.getEditorRegistry().getEditors(
				"x." + GraphWizard.EXT_N);
		multiEditors =
			new LinkedHashSet<IEditorDescriptor>(Arrays.asList(ieDescriptors));

		allEditors = new LinkedHashSet<IEditorDescriptor>(graphEditors);
		allEditors.addAll(multiEditors);

	}
}