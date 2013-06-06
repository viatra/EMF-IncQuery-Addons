/*******************************************************************************
 * Copyright (c) 2005, 2006 IBM Corporation and others,
 * Copyright (c) 2009 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation of 2D version 
 *    Jens von Pilgrim, Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.examples.uml2.activity.part;

import java.util.logging.Logger;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw3d.LightweightSystem3D;
import org.eclipse.draw3d.ui.preferences.ScenePreferenceDistributor;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef3d.ext.multieditor.IMultiEditor;
import org.eclipse.gef3d.ext.multieditor.MultiEditorModelContainer;
import org.eclipse.gef3d.ext.multieditor.MultiEditorPartFactory;
import org.eclipse.gef3d.ext.multieditor.emf.INestableEditorWithEditingDomain;
import org.eclipse.gef3d.gmf.runtime.core.service.ProviderAcceptor;
import org.eclipse.gef3d.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer3D;
import org.eclipse.gef3d.tools.CameraTool;
import org.eclipse.gef3d.ui.parts.FpsStatusLineItem;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IDiagramPreferenceSupport;
import org.eclipse.gmf.runtime.diagram.ui.internal.parts.DiagramGraphicalViewerKeyHandler;
import org.eclipse.gmf.runtime.diagram.ui.internal.parts.DirectEditKeyHandler;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContextMenuProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.DiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.EditPartService;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeTypes;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.uml2.diagram.activity.part.DiagramEditorContextMenuProvider;
import org.eclipse.uml2.diagram.activity.part.UMLDiagramEditor;
import org.eclipse.uml2.diagram.common.pathmap.XMI2UMLSupport;
import org.eclipse.uml2.diagram.usecase.part.UMLDocumentProvider;

/**
 * UMLDiagramEditor3D There should really be more documentation here.
 * 
 * @author mgoyal (original {@link DiagramDocumentEditor})
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Apr 7, 2009
 */
public class UMLActivityDiagramEditor3D extends UMLDiagramEditor implements
		INestableEditorWithEditingDomain {

	/**
	 * Logger for this class
	 */
	private static final Logger log =
		Logger.getLogger(UMLActivityDiagramEditor3D.class.getName());

	/**
	 * Reference to viewer of nesting multi editor, set in
	 * {@link #initializeAsNested(GraphicalViewer, MultiEditorPartFactory, MultiEditorModelContainer)}
	 * . This reference is used in {@link #getDiagramEditPart()}.
	 */
	protected GraphicalViewer multiEditorViewer;

	private ScenePreferenceDistributor scenePreferenceDistributor;

	/**
	 * A reference to the 3D diagram graphical viewer.
	 */
	protected DiagramGraphicalViewer3D viewer3D;

	/**
	 * 
	 */
	public UMLActivityDiagramEditor3D() {

		// this is a hack:
		MapModeTypes.DEFAULT_MM = MapModeTypes.IDENTITY_MM;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.uml2.diagram.clazz.part.UMLDiagramEditor#configureGraphicalViewer()
	 */
	@Override
	protected void configureGraphicalViewer() {

		configureProviderAcceptor();

		{ // GraphicalEditor
			getGraphicalViewer().getControl().setBackground(
				ColorConstants.listBackground);
		}
		{ // DiagramEditor
			IDiagramGraphicalViewer viewer = getDiagramGraphicalViewer();

			RootEditPart rootEP =
				EditPartService.getInstance().createRootEditPart(getDiagram());
			if (rootEP instanceof IDiagramPreferenceSupport) {
				((IDiagramPreferenceSupport) rootEP)
					.setPreferencesHint(getPreferencesHint());
			}

			if (getDiagramGraphicalViewer() instanceof DiagramGraphicalViewer) {
				((DiagramGraphicalViewer) getDiagramGraphicalViewer())
					.hookWorkspacePreferenceStore(getWorkspaceViewerPreferenceStore());
			}

			viewer.setRootEditPart(rootEP);

			viewer.setEditPartFactory(EditPartService.getInstance());
			ContextMenuProvider provider =
				new DiagramContextMenuProvider(this, viewer);
			viewer.setContextMenu(provider);
			getSite().registerContextMenu(
				ActionIds.DIAGRAM_EDITOR_CONTEXT_MENU, provider, viewer);
			KeyHandler viewerKeyHandler =
				new DiagramGraphicalViewerKeyHandler(viewer)
					.setParent(getKeyHandler());
			viewer.setKeyHandler(new DirectEditKeyHandler(viewer)
				.setParent(viewerKeyHandler));
			// ((FigureCanvas) viewer.getControl())
			// .setScrollBarVisibility(FigureCanvas.ALWAYS);
		}

		{ // org.eclipse.uml2.diagram.clazz.part.UMLDiagramEditor#configureGraphicalViewer()
			DiagramEditorContextMenuProvider provider =
				new DiagramEditorContextMenuProvider(this,
					getDiagramGraphicalViewer());
			getDiagramGraphicalViewer().setContextMenu(provider);
			getSite().registerContextMenu(
				ActionIds.DIAGRAM_EDITOR_CONTEXT_MENU, provider,
				getDiagramGraphicalViewer());
		}
	}

	/* 
	 * 
	 */
	protected void configureProviderAcceptor() {

		// set special provider acceptor
		ProviderAcceptor providerAcceptor = new ProviderAcceptor(true);
		providerAcceptor.setProperty(ProviderAcceptor.GRAPHICAL_EDITOR, this);
		getGraphicalViewer().setProperty(
			ProviderAcceptor.PROVIDER_ACCEPTOR_PROPERTY_KEY, providerAcceptor);
		getDiagram().eAdapters().add(providerAcceptor);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ui.parts.GraphicalEditor3DWithPalette#createGraphicalViewer(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createGraphicalViewer(Composite i_parent) {

		viewer3D = new DiagramGraphicalViewer3D();

		// 1:1 from GraphicalEditor.createGraphicalViewer(Composite)
		Control control = viewer3D.createControl3D(i_parent);
		setGraphicalViewer(viewer3D);
		configureGraphicalViewer();
		hookGraphicalViewer();
		initializeGraphicalViewer();

		IEditorSite editorSite = getEditorSite();
		IActionBars actionBars = editorSite.getActionBars();
		IStatusLineManager statusLine = actionBars.getStatusLineManager();

		FpsStatusLineItem fpsCounter = new FpsStatusLineItem();
		LightweightSystem3D lightweightSystem3D =
			viewer3D.getLightweightSystem3D();
		lightweightSystem3D.addSceneListener(fpsCounter);

		statusLine.add(fpsCounter);

		scenePreferenceDistributor =
			new ScenePreferenceDistributor(lightweightSystem3D);
		scenePreferenceDistributor.start();

		control.addDisposeListener(lightweightSystem3D);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.multieditor.INestableEditor#createPaletteDrawer()
	 */
	public PaletteDrawer createPaletteDrawer() {

		PaletteRoot root = createPaletteRoot(null);
		if (root.getChildren().size() == 1
			&& root.getChildren().get(0) instanceof PaletteDrawer) {
			return (PaletteDrawer) root.getChildren().get(0);
		} else {
			PaletteDrawer drawer = new PaletteDrawer("Activity Diagram");
			drawer.setChildren(root.getChildren());
			return drawer;

		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.feu.gef3d.ecoretools.diagram.part.EcoreDiagramEditor#createPaletteRoot(org.eclipse.gef.palette.PaletteRoot)
	 */
	@Override
	protected PaletteRoot createPaletteRoot(PaletteRoot i_existingPaletteRoot) {

		PaletteRoot root = super.createPaletteRoot(i_existingPaletteRoot);

		PaletteDrawer drawer = new PaletteDrawer("GEF3D");
		drawer.setDescription("GEF3D tools");
		drawer.add(new ToolEntry("Camera", "Camera Tool", null, null,
			CameraTool.class) {
			// nothing to implement
		});
		root.add(0, drawer);

		return root;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditorWithPalette#dispose()
	 */
	@Override
	public void dispose() {

		if (scenePreferenceDistributor != null)
			scenePreferenceDistributor.stop();

		super.dispose();
	}

	/**
	 * Overridden in order to retrieve {@link DiagramEditPart} if this editor is
	 * nested. In that case, the owned viewer is null, as the viewer of the
	 * nesting multi editor is used. {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor#getDiagramEditPart()
	 */
	@Override
	public DiagramEditPart getDiagramEditPart() {
		if (getDiagramGraphicalViewer() != null) {
			return (DiagramEditPart) getDiagramGraphicalViewer().getContents();
		}
		if (isNested()) {
			EditPart part = multiEditor.findNestedEditorContent(this);
			return (DiagramEditPart) part;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor#getGraphicalControl()
	 */
	@Override
	protected Control getGraphicalControl() {

		return getGraphicalViewer().getControl();
	}

	/*
	 * *************************************************************************
	 * Nested
	 * **********************************************************************
	 */

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.multieditor.INestableEditor#initializeAsNested(org.eclipse.gef.GraphicalViewer,
	 *      org.eclipse.gef3d.ext.multieditor.MultiEditorPartFactory,
	 *      org.eclipse.gef3d.ext.multieditor.MultiEditorModelContainer)
	 */
	public Object initializeAsNested(GraphicalViewer viewer,
		MultiEditorPartFactory i_multiEditorPartFactory,
		MultiEditorModelContainer i_multiEditorModelContainer) {

		multiEditorViewer = viewer;
		try {
			// setGraphicalViewer(viewer);

			// initializeGraphicalViewerContents():
			Diagram diagram = getDiagram();

			// set provider acceptor in nested content diagram
			diagram.eAdapters().add(
				ProviderAcceptor.retrieveProviderSelector(viewer));

			EditPartFactory factory = EditPartService.getInstance();

			// EditPart editPart = getDiagramEditPart();

			i_multiEditorPartFactory.prepare(diagram, factory);
			i_multiEditorModelContainer.add(diagram);

			// we need this only during initialization, views
			// are shared between multiple editor instances, even
			// between 3D and 2D instances!
			diagram.eAdapters().remove(
				ProviderAcceptor.retrieveProviderSelector(viewer));

			return diagram;

		} catch (Exception ex) {
			log.warning("GraphicalViewer exception: " + ex); //$NON-NLS-1$
			return null;
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramEditor#initializeGraphicalViewerContents()
	 */
	@Override
	protected void initializeGraphicalViewerContents() {
		if (!isNested()) {
			// zoom needs to be 1
			super.initializeGraphicalViewerContents();
			getZoomManager().setZoom(1.0);
		}
	}

	/**
	 * The editing domain id, used in {@link #createEditingDomain()} to retrieve
	 * shared {@link EditingDomain}. The default value is null, if this editor
	 * is nested, the multi editor set this id via
	 * {@link #setEditingDomainID(String)} defined in
	 * {@link INestableEditorWithEditingDomain} .
	 */
	protected String editingDomainID = null;

	/**
	 * The multi editor into which this editor is nested, set in
	 * {@link #setMultiEditor(IMultiEditor)}.
	 */
	protected IMultiEditor multiEditor;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.multieditor.INestableEditorWithEditingDomain#setEditingDomainID(java.lang.String)
	 */
	public void setEditingDomainID(String i_editingDomainID) {
		editingDomainID = i_editingDomainID;
	}
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor#getEditingDomainID()
	 */
	@Override
	protected String getEditingDomainID() {
		return editingDomainID;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.multieditor.INestableEditor#setMultiEditor(org.eclipse.gef3d.ext.multieditor.IMultiEditor)
	 */
	public void setMultiEditor(IMultiEditor i_multiEditor) {
		multiEditor = i_multiEditor;
	}

	/**
	 * Returns true, if multi editor is set.
	 * 
	 * @return
	 */
	public boolean isNested() {
		return multiEditor != null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor#clearGraphicalViewerContents()
	 */
	@Override
	protected void clearGraphicalViewerContents() {
		if (getGraphicalViewer() != null
			&& getGraphicalViewer() instanceof IDiagramGraphicalViewer) {
			super.clearGraphicalViewerContents();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramEditor#setDocumentProvider(org.eclipse.ui.IEditorInput)
	 * @see http://bugs.eclipse.org/189974
	 */
	@Override
	protected void setDocumentProvider(IEditorInput i_input) {
		if (!isNested()) {
			super.setDocumentProvider(i_input);
		} else {
			setDocumentProvider(new UMLDocumentProvider() {
				/**
				 * @generated
				 */
				@Override
				protected IDocument createEmptyDocument() {
					DiagramDocument document = new DiagramDocument();
					TransactionalEditingDomain domain =
						TransactionalEditingDomain.Registry.INSTANCE
							.getEditingDomain(getEditingDomainID());
					;
					XMI2UMLSupport
						.enableXMI2UMLSupport(domain.getResourceSet());
					document.setEditingDomain(domain);
					return document;
				}

			});
		}
	}
}
