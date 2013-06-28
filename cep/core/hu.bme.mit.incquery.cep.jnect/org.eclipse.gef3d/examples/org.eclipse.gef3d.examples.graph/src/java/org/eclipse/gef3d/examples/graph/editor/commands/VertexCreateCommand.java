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
package org.eclipse.gef3d.examples.graph.editor.commands;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef3d.examples.graph.model.Graph;
import org.eclipse.gef3d.examples.graph.model.Vertex;

/**
 * CreateVertexCommand creates a new vertex.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Jul 9, 2008
 */
public class VertexCreateCommand extends Command {

	Graph m_graph;

	Vertex m_newVertex;

	float m_x, m_y, m_width, m_height;

	/**
	 * @param newVertex
	 * @param rect
	 * @param graph
	 */
	public VertexCreateCommand(Vertex newVertex, Graph graph, float x, float y,
			float width, float height) {
		m_newVertex = newVertex;
		m_x = x;
		m_y = y;
		m_width = (width < 10) ? 10 : width;
		m_height = (height < 10) ? 10 : height;
		m_graph = graph;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		m_newVertex.setX(m_x);
		m_newVertex.setY(m_y);
		m_newVertex.setWidth(m_width);
		m_newVertex.setHeight(m_height);
		m_graph.addVertex(m_newVertex);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		if (m_newVertex != null) {
			m_graph.removeVertex(m_newVertex);
		}
	}
}