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
package org.eclipse.gef3d.examples.graph.editor.performance;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef3d.examples.graph.editor.GraphEditor2_5D;
import org.eclipse.gef3d.examples.graph.editor.GraphEditor3D;
import org.eclipse.gef3d.examples.graph.editor.IntermodelEditPartFactory;
import org.eclipse.gef3d.examples.graph.editor.editparts.GraphEditPartFactory;
import org.eclipse.gef3d.examples.graph.model.Edge;
import org.eclipse.gef3d.examples.graph.model.Graph;
import org.eclipse.gef3d.examples.graph.model.IntermodelContainer;
import org.eclipse.gef3d.examples.graph.model.Vertex;
import org.eclipse.gef3d.ext.multieditor.MultiEditorModelContainer;
import org.eclipse.gef3d.ext.multieditor.MultiEditorPartFactory;


/**
 * GraphEditorMulti2_5D displays two graphs in Dia3D mode with intermodel
 * connections
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 20.12.2007
 */
public class PerformanceTest extends GraphEditor2_5D {

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

		int planes = 20; // max 50
		int nodesPerPlane = 40; // max: 200;
		Graph[] graphs = new Graph[planes];

		MultiEditorModelContainer container = new MultiEditorModelContainer();
		GraphicalViewer viewer = getGraphicalViewer();
		MultiEditorPartFactory multiFactory = (MultiEditorPartFactory) viewer
				.getEditPartFactory();
		GraphEditPartFactory graphFactory = new GraphEditPartFactory();

		IntermodelContainer intermodel = new IntermodelContainer();
		IntermodelEditPartFactory intermodelFactory = new IntermodelEditPartFactory();
		multiFactory.prepare(intermodel, intermodelFactory);

		for (int p = 0; p < planes; p++) {
			Graph g = Graph.getSample(nodesPerPlane, 0, 0, 65, 30, 5);
			container.add(g);
			multiFactory.prepare(g, graphFactory);
			multiFactory.prepare(g, intermodelFactory,
					MultiEditorPartFactory.HIGHEST_PRIORITY);

			graphs[p] = g;
		}

//		for (int p = 1; p < planes; p++) {
//			for (int c = 0; c < nodesPerPlane / 2; c++) {
//				int source = (int) (Math.random() * nodesPerPlane);
//				int target = (int) (Math.random() * nodesPerPlane);
//
//				intermodel.add(new Edge(graphs[p - 1].getVerteces().get(source),
//						graphs[p].getVerteces().get(target)));
//			}
//		}
		
		for (int p = 1; p < planes; p++) {
			for (int c = 0; c < nodesPerPlane; c+=5) {
				int source = (int) (c);
				int target = (int) (c);

				Edge e = new Edge();
				e.setSource(graphs[p - 1].getVertices().get(source));
				e.setTarget(graphs[p].getVertices().get(target));
				
			}
		}
		

		viewer.setContents(container);
	}

	
}
