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
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.SelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.SimpleFactory;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef3d.editparts.ScalableFreeformRootEditPart3D;
import org.eclipse.gef3d.editpolicies.Handles3DEditPolicy;
import org.eclipse.gef3d.examples.graph.editor.actions.ActionBuilder;
import org.eclipse.gef3d.examples.graph.editor.editparts.GraphEditPartFactory;
import org.eclipse.gef3d.examples.graph.editor.figures.GraphFigureFactory;
import org.eclipse.gef3d.examples.graph.model.Edge;
import org.eclipse.gef3d.examples.graph.model.Graph;
import org.eclipse.gef3d.examples.graph.model.Vertex;
import org.eclipse.gef3d.factories.DisplayMode;
import org.eclipse.gef3d.tools.CameraTool;
import org.eclipse.gef3d.ui.parts.GraphicalEditor3DWithPalette;
import org.eclipse.gef3d.ui.parts.GraphicalViewer3DImpl;
import org.eclipse.ui.IFileEditorInput;

/**
 * GraphEditor3D There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 16.11.2007
 */
public class GraphEditor3D extends GraphicalEditor3DWithPalette {

	protected DisplayMode mode;

	/**
	 * Logger for this class
	 */
	private static final Logger log =
		Logger.getLogger(GraphEditor3D.class.getName());

	/**
	 * 
	 */
	public GraphEditor3D() {
		initMode();
		setEditDomain(new DefaultEditDomain(this));
	}

	protected void initMode() {
		mode = DisplayMode.ThreeDimensional;
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
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditorWithPalette#getPaletteRoot()
	 */
	@Override
	protected PaletteRoot getPaletteRoot() {
		PaletteRoot root = new PaletteRoot();
		PaletteGroup controls = new PaletteGroup("Controls");
		root.add(controls);
		controls.add(new SelectionToolEntry());
		controls.add(new ToolEntry("Camera", "Camera Tool", null, null,
			CameraTool.class) {
		});
		controls.add(new CreationToolEntry("Vertex", "Create Vertex",
			new SimpleFactory(Vertex.class), null, null));
		controls.add(new ConnectionCreationToolEntry("Edge", "Create Edge",
			new SimpleFactory(Edge.class), null, null));
		return root;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#configureGraphicalViewer()
	 */
	@Override
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();

		getGraphicalViewer().setEditPartFactory(new GraphEditPartFactory());
		((GraphicalViewer3DImpl) getGraphicalViewer())
			.setFigureFactory(new GraphFigureFactory(mode));

		ScalableFreeformRootEditPart root =
			new ScalableFreeformRootEditPart3D();
		
	    // handles and feedback when moving or resizing a node
        root.installEditPolicy(
			Handles3DEditPolicy.CHILD_DECORATOR,
			new Handles3DEditPolicy(true));
		
		getGraphicalViewer().setRootEditPart(root);
	}

	/**
	 * Creates actions using the {@link ActionBuilder}.
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
