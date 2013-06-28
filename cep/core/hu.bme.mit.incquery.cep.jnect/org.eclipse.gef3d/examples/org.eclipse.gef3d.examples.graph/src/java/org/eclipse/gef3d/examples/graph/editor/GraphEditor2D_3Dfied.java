/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.examples.graph.editor;

import java.util.logging.Logger;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw3d.IScene;
import org.eclipse.draw3d.LightweightSystem3D;
import org.eclipse.draw3d.ui.preferences.ScenePreferenceDistributor;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef3d.editparts.ScalableFreeformRootEditPart3D;
import org.eclipse.gef3d.editpolicies.Handles3DEditPolicy;
import org.eclipse.gef3d.editpolicies.ShowLayoutFeedbackEditPolicy3D;
import org.eclipse.gef3d.editpolicies.ShowSourceFeedback3DEditPolicy;
import org.eclipse.gef3d.examples.graph.editor.editparts.GraphPart2D;
import org.eclipse.gef3d.examples.graph.editor.editparts.GraphPartGeneric;
import org.eclipse.gef3d.examples.graph.editor.figures.GraphFigure3D;
import org.eclipse.gef3d.examples.graph.model.Graph;
import org.eclipse.gef3d.ext.assimilator.AbstractPolicyModifier;
import org.eclipse.gef3d.ext.assimilator.BorgEditPartFactory;
import org.eclipse.gef3d.ext.assimilator.EditPartReplacer;
import org.eclipse.gef3d.ext.assimilator.IAssimilator;
import org.eclipse.gef3d.ext.assimilator.IAssimilator.InstanceOf;
import org.eclipse.gef3d.ext.multieditor.MultiEditorModelContainer;
import org.eclipse.gef3d.ext.multieditor.MultiEditorPartFactory;
import org.eclipse.gef3d.tools.CameraTool;
import org.eclipse.gef3d.ui.parts.FpsStatusLineItem;
import org.eclipse.gef3d.ui.parts.GraphicalViewer3D;
import org.eclipse.gef3d.ui.parts.GraphicalViewer3DImpl;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorSite;

/**
 * 3D-fication of the 2D graph editor. Its functionality equals
 * {@link GraphEditor2_5D}, but instead of writing a 3D editor from scratch,
 * this editor modifies an existing 2D version.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 20.09.2009
 */
public class GraphEditor2D_3Dfied extends GraphEditor2D {

	/**
	 * Logger for this class
	 */
	private static final Logger log =
		Logger.getLogger(GraphEditor2D_3Dfied.class.getName());

	private ScenePreferenceDistributor scenePrefDistr;

	/**
	 * Constructs this editor and sets default editor domain.
	 */
	public GraphEditor2D_3Dfied() {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.eclipsemag.gef3d.sample.editor2D.GraphEditor2D#getPaletteRoot()
	 */
	@Override
	protected PaletteRoot getPaletteRoot() {
		PaletteRoot root = super.getPaletteRoot();
		if (!fNested) {
			PaletteDrawer drawer = new PaletteDrawer("GEF3D");
			drawer.setDescription("GEF3D tools");
			drawer.add(new ToolEntry("Camera", "Camera Tool", null, null,
				CameraTool.class) {
			});
			root.add(0, drawer);
		}
		return root;
	}

	// private ScenePreferenceListener sceneListener;

	@Override
	protected void createGraphicalViewer(Composite i_parent) {
		GraphicalViewer3DImpl viewer = new GraphicalViewer3DImpl();

		// 1:1 from GraphicalEditor.createGraphicalViewer(Composite),
		// instead of createControl, createControl3D is called!
		Control control = viewer.createControl3D(i_parent);
		setGraphicalViewer(viewer);
		configureGraphicalViewer();
		hookGraphicalViewer();
		initializeGraphicalViewer();

		doAttachFPSCounter(viewer);
		control.addDisposeListener(viewer.getLightweightSystem3D());

		doRegisterToScene(viewer.getLightweightSystem3D());
	}

	/**
	 * Called by {@link #createGraphicalViewer(Composite)} if created viewer is
	 * an instance of {@link IScene}.
	 * 
	 * @param scene
	 */
	protected void doRegisterToScene(IScene scene) {
		scenePrefDistr = new ScenePreferenceDistributor(scene);
		scenePrefDistr.start();
	}

	/**
	 * Called by {@link #createGraphicalViewer(Composite)} if created viewer is
	 * an instanceof {@link GraphicalViewer3D}.
	 * 
	 * @param viewer3D
	 */
	protected void doAttachFPSCounter(GraphicalViewer3D viewer3D) {
		IEditorSite editorSite = getEditorSite();
		IActionBars actionBars = editorSite.getActionBars();
		IStatusLineManager statusLine = actionBars.getStatusLineManager();

		FpsStatusLineItem fpsCounter = new FpsStatusLineItem();
		LightweightSystem3D lightweightSystem3D =
			viewer3D.getLightweightSystem3D();
		lightweightSystem3D.addSceneListener(fpsCounter);
		statusLine.add(fpsCounter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditorWithPalette#dispose()
	 */
	@Override
	public void dispose() {

		if (scenePrefDistr != null)
			scenePrefDistr.stop();

		super.dispose();
	}

	@Override
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();

		EditPartFactory originalFactory =
			getGraphicalViewer().getEditPartFactory();
		BorgEditPartFactory borgFactory = createBorgFactory(originalFactory);

		getGraphicalViewer().setEditPartFactory(borgFactory);

		ScalableFreeformRootEditPart root =
			new ScalableFreeformRootEditPart3D();
		getGraphicalViewer().setRootEditPart(root);
	}

	/**
	 * Replaces original graph part, see comment in
	 * {@link GraphPart3Dfied#createBorgFactory(EditPartFactory)}.
	 * 
	 * @author Jens von Pilgrim
	 * @version $Revision$
	 * @since Aug 20, 2009
	 */
	public static class GraphPart3Dfied extends GraphPart2D {
		@Override
		protected IFigure createFigure() {
			return new GraphFigure3D();
		}

	}

	/**
	 * Here we create a borg factory and add required assimilators. The
	 * following assimilators are used:
	 * <ul>
	 * <li>{@link EditPartReplacer} for replacing the (2D) GraphPartGeneric with a 3D
	 * version. The 3D version is required in order to create a 3D graph figure
	 * instead of a 2D one. Note that we may have altered the figure factory
	 * used here, but we replace the edit part in order to demonstrate how this
	 * can be done in general.</li>
	 * <li>{@link AbstractPolicyModifier} for modifying the graph part. Two new
	 * policies are added in order to add an
	 * {@link ShowLayoutFeedbackEditPolicy3D} for creating a 3D feedback when
	 * creating a node, and a {@link Handles3DEditPolicy} which adds appropriate
	 * policies to children in order to display 3D handles.</li>
	 * <li>{@link InstanceOf} for adding a
	 * {@link ShowLayoutFeedbackEditPolicy3D} to all nodes in order to show 3D
	 * feedback when a connection is created.</li>
	 * <ul>
	 * 
	 * @param originalFactory
	 * @return the borg factory
	 */
	protected BorgEditPartFactory createBorgFactory(
		EditPartFactory originalFactory) {
		BorgEditPartFactory borgFactory =
			new BorgEditPartFactory(originalFactory);

		// replace diagram edit part
		borgFactory.addAssimilator(new EditPartReplacer(GraphPartGeneric.class,
			GraphPart3Dfied.class));

		// modify diagram edit part's policies
		borgFactory.addAssimilator(new AbstractPolicyModifier() {

			public boolean match(EditPart part) {
				return part instanceof GraphPartGeneric;
			}
			
			public void modifyPolicies(EditPart io_editpart) {
				// feedback when creating a node:
				io_editpart.installEditPolicy(
					ShowLayoutFeedbackEditPolicy3D.ROLE,
					new ShowLayoutFeedbackEditPolicy3D());
				// handles and feedback when moving or resizing a node
				io_editpart.installEditPolicy(
					Handles3DEditPolicy.CHILD_DECORATOR,
					new Handles3DEditPolicy(true));
			}
		});

		// modify node edit part's policies
		borgFactory.addAssimilator(new IAssimilator.InstanceOf<EditPart>(
			NodeEditPart.class) {

			public EditPart assimilate(EditPart io_editpart) {
				// feedback when drawing a connection
				io_editpart.installEditPolicy(
					ShowSourceFeedback3DEditPolicy.ROLE,
					new ShowSourceFeedback3DEditPolicy());
				return io_editpart;
			}

		});

		return borgFactory;
	}

	/*
	 * *************************************************************************
	 * Nested
	 * **********************************************************************
	 */
	boolean fNested;

	public void initializeAsNested(GraphicalViewer viewer,
		MultiEditorPartFactory i_multiEditorPartFactory,
		MultiEditorModelContainer i_multiEditorModelContainer) {
		fNested = true;
		try {
			EditPartFactory factory =
				createBorgFactory(createEditPartFactory());

			Graph graph = loadGraph();

			i_multiEditorPartFactory.prepare(graph, factory);
			i_multiEditorModelContainer.add(graph);

		} catch (Exception ex) {
			log.warning("GraphicalViewer exception: " + ex); //$NON-NLS-1$ 
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.multieditor.INestableEditor#createPaletteDrawer()
	 */
	public PaletteDrawer createPaletteDrawer() {
		PaletteRoot root = getPaletteRoot();
		if (root.getChildren().size() == 1
			&& root.getChildren().get(0) instanceof PaletteDrawer) {
			return (PaletteDrawer) root.getChildren().get(0);
		} else {
			PaletteDrawer drawer = new PaletteDrawer("Graph Editor 3D");
			drawer.setChildren(root.getChildren());
			return drawer;

		}
	}

}
