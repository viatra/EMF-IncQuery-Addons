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
package org.eclipse.gef3d.examples.graph.editor.editparts;

import java.util.logging.Level;

import java.util.logging.Logger;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef3d.examples.graph.model.Edge;
import org.eclipse.gef3d.examples.graph.model.Graph;
import org.eclipse.gef3d.examples.graph.model.Vertex;


/**
 * Edit part factory, create edit parts by given (Graph) model elements.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 21.11.2007
 */
public class GraphEditPartFactory implements EditPartFactory {
	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger
			.getLogger(GraphEditPartFactory.class.getName());

	/**
	 * Creates parts matching given model element and set the model
	 * of the edit part. The context is ignored here.
	 * 
	 * 
	 * @see org.eclipse.gef.EditPartFactory#createEditPart(org.eclipse.gef.EditPart,
	 *      java.lang.Object)
	 */
	public EditPart createEditPart(EditPart i_context, Object i_model) {
		EditPart part = null;
		if (i_model instanceof Graph) {
			part = new GraphPartGeneric();
		} else if (i_model instanceof Vertex) {
			part = new VertexPart();
		} else if (i_model instanceof Edge) {
			part = new EdgePart();
		}
		if (part != null) {
			part.setModel(i_model);
		} else {
			log.warning("EditPart, No part created for model=" + i_model); 
		}
		return part;
	}

}
