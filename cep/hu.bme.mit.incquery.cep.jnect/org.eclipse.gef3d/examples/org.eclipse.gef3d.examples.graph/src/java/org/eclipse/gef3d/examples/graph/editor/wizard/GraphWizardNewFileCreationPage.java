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

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

class GraphWizardNewFileCreationPage extends WizardNewFileCreationPage {
	
	
	IStructuredSelection selection;
	
	/**
	 * 
	 */
	private final GraphWizard graphWizard;

	public GraphWizardNewFileCreationPage(GraphWizard graphWizard, final String pageId,
			final IStructuredSelection selection) {
		super(pageId, selection);
		this.selection = selection;
		this.graphWizard = graphWizard;
	}

	public IFile getModelFile() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(
			getContainerFullPath().append(getFileName()));
	}
	
	

	@Override
	protected boolean validatePage() {
		if (super.validatePage()) {
			final String extension =
				new Path(getFileName()).getFileExtension();
			if (extension == null
				|| !extension.endsWith(graphWizard.getExtension())) {
				setErrorMessage("File name must end with " + graphWizard.getExtension());
				return false;
			}
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 */
	public void setDefaultFilename() {
		if (selection != null && !selection.isEmpty()) {
			final Object selectedElement = selection.iterator().next();
			if (selectedElement instanceof IResource) {
				IResource selectedResource = (IResource) selectedElement;
				if (selectedResource.getType() == IResource.FILE) {
					selectedResource = selectedResource.getParent();
				}
				if (selectedResource instanceof IFolder
					|| selectedResource instanceof IProject) {
					setContainerFullPath(selectedResource.getFullPath());

					final String defaultModelFilenameExtension =
						graphWizard.getExtension();
					String modelFilename =
						"test." + defaultModelFilenameExtension;
					for (int i = 1; ((IContainer) selectedResource)
						.findMember(modelFilename) != null; ++i) {
						modelFilename =
							"test" + i + "." + defaultModelFilenameExtension;
					}
					setFileName(modelFilename);
				}
			}
		} else {
			setFileExtension("test."+graphWizard.getExtension());
		}
	}
	
	
}