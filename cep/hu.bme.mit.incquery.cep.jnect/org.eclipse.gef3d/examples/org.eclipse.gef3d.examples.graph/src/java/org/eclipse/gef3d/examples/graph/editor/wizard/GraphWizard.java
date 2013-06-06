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

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef3d.examples.graph.model.Edge;
import org.eclipse.gef3d.examples.graph.model.Graph;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

/**
 * Wizard for creating models to be opened with the GEF3D example graph editors
 * (2D, 2.5D. and 3D). As this wizard is a typical wizard and not part of the
 * tutorial, it is coded quick and dirty. In most cases, EMF would be used for
 * implementing the model, and there is a wizard generated automatically by EMF.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Jun 2, 2009
 */
public class GraphWizard extends Wizard implements INewWizard {
	/**
	 * Logger for this class
	 */
	private static final Logger log =
		Logger.getLogger(GraphWizard.class.getName());

	public static final String EXT_1 = "G3D_graph";

	public static final String EXT_N = "G3D_multi";

	protected GraphWizardConfigurePage graphWizardConfigurePage;

	protected GraphWizardNewFileCreationPage graphWizardNewFileCreationPage;

	private GraphWizardOpenWithPage graphWizardOpenWithPage;

	private IStructuredSelection selection;

	IWorkbench workbench;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		graphWizardConfigurePage =
			new GraphWizardConfigurePage(this, "configure");
		graphWizardConfigurePage
			.setTitle("GEF3D Graph Example, configure initial graph");
		addPage(graphWizardConfigurePage);

		graphWizardNewFileCreationPage =
			new GraphWizardNewFileCreationPage(this, "fileSelect", selection);
		graphWizardNewFileCreationPage
			.setTitle("GEF3D Graph Example, Graph Creation Wizard");
		addPage(graphWizardNewFileCreationPage);

		graphWizardOpenWithPage = new GraphWizardOpenWithPage(this, "openWith");
		addPage(graphWizardOpenWithPage);

		graphWizardNewFileCreationPage.setFileExtension(getExtension());
		graphWizardNewFileCreationPage.setDefaultFilename();
	}

	public String getExtension() {
		if (graphWizardConfigurePage.numberOfPlanes == 1)
			return EXT_1;
		else
			return EXT_N;
	}

	public void updateEditorType() {
		graphWizardNewFileCreationPage.setFileExtension(getExtension());
		graphWizardNewFileCreationPage.setDefaultFilename();
		graphWizardNewFileCreationPage.validatePage();
		graphWizardOpenWithPage
			.setEditorType(graphWizardConfigurePage.numberOfPlanes);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 *      org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(final IWorkbench workbench,
		final IStructuredSelection selection) {
		setWindowTitle("GEF3D Graph Example Wizard");
		this.workbench = workbench;
		this.selection = selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {

		final IFile modelFile = graphWizardNewFileCreationPage.getModelFile();
		final IWorkbenchWindow workbenchWindow =
			workbench.getActiveWorkbenchWindow();
		try {
			final WorkspaceModifyOperation operation =
				new WorkspaceModifyOperation() {
					@Override
					protected void execute(
						final IProgressMonitor progressMonitor) {
						final File f = modelFile.getLocation().toFile();

						Object model;

						if (graphWizardConfigurePage.numberOfPlanes == 1) {
							model =
								Graph
									.getSample(
										graphWizardConfigurePage.numberOfVerticesPerPlane,
										0, 0, 80, 60, 20);
						} else {
							Graph[] graphs = new Graph[graphWizardConfigurePage.numberOfPlanes];
							for (int p = 0; p < graphs.length; p++) {
								Graph g = Graph
								.getSample(
									graphWizardConfigurePage.numberOfVerticesPerPlane,
									0, 0, 80, 60, 20);
								graphs[p] = g;
							}
							
							for (int p = 1; p < graphs.length; p++) {
								for (int c = 0; c < graphWizardConfigurePage.numberOfVerticesPerPlane; c +=
									graphWizardConfigurePage.interconnect) {
									int source = (int) (c);
									int target = (int) (c);
									Edge e = new Edge();
									e.setSource(graphs[p - 1].getVertices().get(source));
									e.setTarget(graphs[p].getVertices().get(target));
								}
							}
							model = graphs;
							
						}

						FileOutputStream fos = null;
						try {
							fos = new FileOutputStream(f);

							final ObjectOutputStream oos =
								new ObjectOutputStream(fos);
							oos.writeObject(model);
							oos.close();

						} catch (final Exception ex) {
							// TODO Implement catch block for
							// FileNotFoundException
							ex.printStackTrace();
							log.severe("Error writing graph - ex=" + ex); //$NON-NLS-1$ 
						} finally {
							progressMonitor.done();
						}

					}
				};

			getContainer().run(false, false, operation);

			// Select the new file resource in the current view.
			//

			final IWorkbenchPage page = workbenchWindow.getActivePage();
			final IWorkbenchPart activePart = page.getActivePart();
			if (activePart instanceof ISetSelectionTarget) {
				final ISelection targetSelection =
					new StructuredSelection(modelFile);
				getShell().getDisplay().asyncExec(new Runnable() {
					public void run() {
						((ISetSelectionTarget) activePart)
							.selectReveal(targetSelection);
					}
				});
			}

			// Open an editor on the new file.
			//

			IEditorDescriptor editor =
				graphWizardOpenWithPage.getEditorDescriptor();
			if (editor == null) {
				editor =
					workbench.getEditorRegistry().getDefaultEditor(
						modelFile.getFullPath().toString());
			}

			page.openEditor(new FileEditorInput(modelFile), editor.getId());
		} catch (final Exception exception) {
			log.log(Level.SEVERE, "Error opening editor: " + exception, exception);
			MessageDialog.openError(workbenchWindow.getShell(),
				"GEF3D Graph Example", exception.getMessage() + " (See log for details)");
			return false;
		}

		return true;

	}

}
