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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.SelectionToolEntry;
import org.eclipse.gef.requests.SimpleFactory;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.parts.GraphicalEditorWithPalette;
import org.eclipse.gef3d.examples.graph.editor.actions.ActionBuilder;
import org.eclipse.gef3d.examples.graph.editor.editparts.GraphEditPartFactory;
import org.eclipse.gef3d.examples.graph.editor.figures.GraphFigureFactory;
import org.eclipse.gef3d.examples.graph.model.Edge;
import org.eclipse.gef3d.examples.graph.model.Graph;
import org.eclipse.gef3d.examples.graph.model.Vertex;
import org.eclipse.gef3d.factories.DisplayMode;
import org.eclipse.gef3d.factories.IFigureFactory;
import org.eclipse.gef3d.factories.IFigureFactoryProvider;
import org.eclipse.gef3d.ui.parts.ScrollingGraphicalViewerEx;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IFileEditorInput;

/**
 * Simple GEF based 2D editor for editing graphs. This editor serves as a
 * starting point for the 3D editors.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 16.11.2007
 */
public class GraphEditor2D extends GraphicalEditorWithPalette {

	/**
	 * Logger for this class
	 */
	private static final Logger log =
		Logger.getLogger(GraphEditor2D.class.getName());

	/**
	 * Constructs this editor and sets default editor domain.
	 */
	public GraphEditor2D() {
		setEditDomain(new DefaultEditDomain(this));
	}

	/*--------------------------------------------------------------------------
	 * Loading and saving graph
	 * -----------------------------------------------------------------------*/

	/**
	 * Loads a graph and set it as viewer's content.
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#initializeGraphicalViewer()
	 */
	@Override
	protected void initializeGraphicalViewer() {
		Graph g = loadGraph();
		if (g == null) { // this should not happen
			g = Graph.getSample(10, 0, 0, 80, 60, 20);
			if (log.isLoggable(Level.INFO)) {
				log.info("Loadig graph failed, created graph with " //$NON-NLS-1$
					+ g.getVertices().size() + " nodes."); //$NON-NLS-1$
			}
		}
		getGraphicalViewer().setContents(g);
	}

	/**
	 * Loads a graph from a file, this is simply done via object serialization.
	 * In a real example, you probably would like to use EMF and a resource set.
	 * <p>
	 * Note: This method is protected. If declared private, it would become
	 * difficult for subclasses to reuse its functionality. From implementing
	 * GEF3D, which includes hacking GEF in many ways, we have learned to prefer
	 * protected over private.
	 * </p>
	 * 
	 * @return the loaded graph
	 */
	protected Graph loadGraph() {
		Graph g = null;
		File f =
			((IFileEditorInput) getEditorInput()).getFile().getLocation()
				.toFile();

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			g = (Graph) ois.readObject();
		} catch (Exception ex) {
			if (log.isLoggable(Level.INFO)) {
				log.info("Error loading graph - ex=" + ex); //$NON-NLS-1$
			}
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException ex) {
					// TODO Implement catch block for IOException
					ex.printStackTrace();
				}
			}
		}
		return g;
	}

	/**
	 * Saves the graph by simply using object serialization.
	 * 
	 * @see org.eclipse.ui.part.EditorPart#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void doSave(IProgressMonitor i_monitor) {
		Graph g = (Graph) getGraphicalViewer().getContents().getModel();
		File f =
			((IFileEditorInput) getEditorInput()).getFile().getLocation()
				.toFile();

		FileOutputStream fos;
		try {
			fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(g);
			oos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			log.severe("Error saving graph - ex=" + ex); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/*--------------------------------------------------------------------------
	 * set up editor
	 * -----------------------------------------------------------------------*/

	/**
	 * Creates tools for creating vertices and edges.
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditorWithPalette#getPaletteRoot()
	 */
	@Override
	protected PaletteRoot getPaletteRoot() {
		PaletteRoot root = new PaletteRoot();
		PaletteGroup controls = new PaletteGroup("Controls");
		root.add(controls);
		controls.add(new SelectionToolEntry());
		controls.add(new CreationToolEntry("Vertex", "Create Vertex",
			new SimpleFactory(Vertex.class), null, null));
		controls.add(new ConnectionCreationToolEntry("Edge", "Create Edge",
			new SimpleFactory(Edge.class), null, null));
		return root;
	}

	/**
	 * This is a re-implementation of the original method. This is a typical
	 * problem when working with GEF: certain things are private or, as it is
	 * the case here, created within a larger method and no explicit create
	 * method exists. Here, we want to exchange the default viewer with a viewer
	 * supporting a {@link IFigureFactory}.
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#createGraphicalViewer(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createGraphicalViewer(Composite parent) {
		// we create a ScrollingGraphicalViewerEx instead of a
		// normal ScrollingGraphicalViewer:
		GraphicalViewer viewer = new ScrollingGraphicalViewerEx();
		viewer.createControl(parent);
		setGraphicalViewer(viewer);
		configureGraphicalViewer();
		hookGraphicalViewer();
		initializeGraphicalViewer();
	}

	/**
	 * The graphical viewer is configured, that is the edit part factory and the
	 * root edit part are set. Since we use an extended viewer version which
	 * supports a figure factory as well, we also set this factory here.
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#configureGraphicalViewer()
	 */
	@Override
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();

		getGraphicalViewer().setEditPartFactory(createEditPartFactory());
		((IFigureFactoryProvider.Mutable) getGraphicalViewer())
			.setFigureFactory(new GraphFigureFactory(DisplayMode.TwoDimensional));
		
		ScalableFreeformRootEditPart root = new ScalableFreeformRootEditPart();
		getGraphicalViewer().setRootEditPart(root);
	}

	/**
	 * @return
	 */
	protected GraphEditPartFactory createEditPartFactory() {
		return new GraphEditPartFactory();
	}

	/**
	 * Creates actions using the {@link ActionBuilder}. This method is called
	 * very early in the set up process, the graphical viewer is not initialized
	 * yet.
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#createActions()
	 */
	@Override
	protected void createActions() {
		super.createActions();
		ActionRegistry registry = getActionRegistry();
		ActionBuilder.buildActions(registry, this);
	}

}
