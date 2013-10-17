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

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;

class GraphWizardConfigurePage extends WizardPage {

	private final GraphWizard graphWizard;

	int numberOfVerticesPerPlane = 5;

	int numberOfPlanes = 1;
	
	int interconnect = 10;

	Label openingHint;

	public final static String MSG_1_PLANE =
		"Graph can be opened with 2D, 2.5D and 3D editor.";

	public final static String MSG_N_PLANES =
		"Graph can be opened with multi graph editor only.";

	public GraphWizardConfigurePage(GraphWizard graphWizard,
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
		layout.numColumns = 2;
		layout.verticalSpacing = 12;
		composite.setLayout(layout);
		GridData data = new GridData();
		data.verticalAlignment = GridData.FILL;
		data.grabExcessVerticalSpace = true;
		data.horizontalAlignment = GridData.FILL;
		composite.setLayoutData(data);

		Label label = new Label(composite, SWT.LEFT);
		label.setText("Number of vertices per plane:");
		Spinner spinner = new Spinner(composite, SWT.None);
		spinner.setMinimum(0);
		spinner.setMaximum(8000);
		spinner.setIncrement(5);
		spinner.setSelection(numberOfVerticesPerPlane);
		spinner.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				numberOfVerticesPerPlane =
					((Spinner) e.getSource()).getSelection();
				
			}
		});

		label = new Label(composite, SWT.LEFT);
		label.setText("Number of planes:");
		spinner = new Spinner(composite, SWT.None);
		spinner.setMinimum(1);
		spinner.setMaximum(30);
		spinner.setIncrement(1);
		spinner.setSelection(numberOfPlanes);
		spinner.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				int old = numberOfPlanes;
				numberOfPlanes = ((Spinner) e.getSource()).getSelection();
				if (old!=numberOfPlanes && (old==1 || numberOfPlanes==1)) {
					updateHint();
					graphWizard.updateEditorType();
				}
				
			}
		});
		
		label = new Label(composite, SWT.LEFT);
		label.setText("Interconnec every x-th element:");
		spinner = new Spinner(composite, SWT.None);
		spinner.setMinimum(1);
		spinner.setMaximum(30);
		spinner.setIncrement(1);
		spinner.setSelection(interconnect);
		spinner.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				interconnect = ((Spinner) e.getSource()).getSelection();
			}
		});

		openingHint = new Label(composite, SWT.LEFT);
		data = new GridData();
		data.horizontalSpan = 2;
		label.setLayoutData(data);
		updateHint();

		setPageComplete(true);
		setControl(composite);
	}

	/**
	 * 
	 */
	private void updateHint() {
		if (numberOfPlanes == 1) {
			openingHint.setText(MSG_1_PLANE);
		} else {
			openingHint.setText(MSG_N_PLANES);
		}

	}
}