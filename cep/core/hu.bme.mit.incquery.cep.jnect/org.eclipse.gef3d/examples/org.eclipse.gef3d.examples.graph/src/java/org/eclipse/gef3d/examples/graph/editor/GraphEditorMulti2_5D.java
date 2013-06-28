/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 *    Kristian Duske - multi editor editor
 ******************************************************************************/
package org.eclipse.gef3d.examples.graph.editor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef3d.examples.graph.editor.actions.ActionBuilder;
import org.eclipse.gef3d.examples.graph.editor.editparts.GraphEditPartFactory;
import org.eclipse.gef3d.examples.graph.model.Edge;
import org.eclipse.gef3d.examples.graph.model.Graph;
import org.eclipse.gef3d.examples.graph.model.IntermodelContainer;
import org.eclipse.gef3d.ext.multieditor.MultiEditorModelContainer;
import org.eclipse.gef3d.ext.multieditor.MultiEditorPartFactory;
import org.eclipse.ui.IFileEditorInput;

/**
 * GraphEditorMulti2_5D displays two graphs in Dia3D mode with intermodel
 * connections
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 20.12.2007
 */
public class GraphEditorMulti2_5D extends GraphEditor2_5D {

    /**
     * Logger for this class
     */
    private static final Logger log = Logger.getLogger(GraphEditorMulti2_5D.class.getName());

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.gef3d.examples.graph.editor.GraphEditor3D#configureGraphicalViewer()
     */
    @Override
    protected void configureGraphicalViewer() {

        super.configureGraphicalViewer();

        MultiEditorPartFactory multiFactory = new MultiEditorPartFactory();
        getGraphicalViewer().setEditPartFactory(multiFactory);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.gef.ui.parts.GraphicalEditor#initializeGraphicalViewer()
     */
    @Override
    protected void initializeGraphicalViewer() {

        Graph graphs[] = load();
        if (graphs == null) {
            graphs = createGraphs();
        }

        MultiEditorModelContainer container = new MultiEditorModelContainer();
        GraphicalViewer viewer = getGraphicalViewer();
        MultiEditorPartFactory multiFactory = (MultiEditorPartFactory) viewer.getEditPartFactory();
        GraphEditPartFactory graphFactory = new GraphEditPartFactory();

        IntermodelContainer intermodel = new IntermodelContainer();
        IntermodelEditPartFactory intermodelFactory = new IntermodelEditPartFactory();
        multiFactory.prepare(intermodel, intermodelFactory);

        for (int p = 0; p < graphs.length; p++) {
            container.add(graphs[p]);
            multiFactory.prepare(graphs[p], graphFactory);
            multiFactory.prepare(graphs[p], intermodelFactory,
                MultiEditorPartFactory.HIGHEST_PRIORITY);
        }

        viewer.setContents(container);
    }

    protected Graph[] createGraphs() {

        int planes = 10; // max 50
        int nodesPerPlane = 20; // max: 200;
        Graph[] graphs = new Graph[planes];

        for (int p = 0; p < planes; p++) {
            graphs[p] = Graph.getSample(nodesPerPlane, 0, 0, 65, 30, 5);
        }

        for (int p = 1; p < planes; p++) {
            for (int c = 0; c < nodesPerPlane; c += 20) {
                int source = (int) (c);
                int target = (int) (c);

                Edge e = new Edge();
                e.setSource(graphs[p - 1].getVertices().get(source));
                e.setTarget(graphs[p].getVertices().get(target));
            }
        }

        return graphs;
    }

    /**
     * Loads a graph or a multi graph from a file, this is simply done via
     * object serialization. In a real example, you probably would like to use
     * EMF and a resource set.
     * <p>
     * Note: This method is protected. If declared private, it would become
     * difficult for subclasses to reuse its functionality. From implementing
     * GEF3D, which includes hacking GEF in many ways, we have learned to prefer
     * protected over private.
     * </p>
     * 
     * @return the loaded graph
     */
    protected Graph[] load() {

        Object model = null;
        File f = ((IFileEditorInput) getEditorInput()).getFile().getLocation().toFile();

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            model = ois.readObject();
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
        if (model instanceof Graph) {
            return new Graph[] { (Graph) model };
        } else if (model instanceof Graph[]) {
            return (Graph[]) model;
        }
        return null;
    }

}
