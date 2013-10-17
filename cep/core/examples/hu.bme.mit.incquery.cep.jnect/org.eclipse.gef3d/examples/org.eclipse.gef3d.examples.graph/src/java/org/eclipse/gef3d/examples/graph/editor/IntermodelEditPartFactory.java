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

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef3d.examples.graph.editor.editparts.IntermodelContainerPart;
import org.eclipse.gef3d.examples.graph.editor.editparts.IntermodelEdgePart;
import org.eclipse.gef3d.examples.graph.model.Edge;
import org.eclipse.gef3d.examples.graph.model.Graph;
import org.eclipse.gef3d.examples.graph.model.IntermodelContainer;


/**
 * IntermodelEditPartFactory There should really be more documentation here.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 04.04.2008
 */
public class IntermodelEditPartFactory implements EditPartFactory {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.EditPartFactory#createEditPart(org.eclipse.gef.EditPart,
	 *      java.lang.Object)
	 */
	public EditPart createEditPart(EditPart i_context, Object i_model) {

		EditPart part = null;
		if (i_model instanceof Edge) {
			// create part here only if it is really an intermodel edge:
			Edge edge = (Edge) i_model;
			Graph graph = findGraph(i_context);
			if (graph == null
					|| (graph.getVertices().contains(edge.getSource()) && graph
							.getVertices().contains(edge.getTarget())))
				return null; // 2D connection or graph not found

			part = new IntermodelEdgePart();
			
		} else if (i_model instanceof IntermodelContainer)
			part = new IntermodelContainerPart();

		if (part != null)
			part.setModel(i_model);

		return part;
	}

	/**
	 * @param i_context
	 * @return
	 */
	private Graph findGraph(EditPart i_context) {
		
		EditPart context = i_context;
		while (context != null) {
			if (context.getModel() instanceof Graph)
				return (Graph) context.getModel();
			context = context.getParent();
		}
		
		return null;
	}

}
