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
package org.eclipse.gef3d.examples.graph.editor.commands;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef3d.examples.graph.model.Edge;
import org.eclipse.gef3d.examples.graph.model.Graph;
import org.eclipse.gef3d.examples.graph.model.Vertex;

/**
 * EdgeCreateCommand There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since May 22, 2009
 */
public class EdgeCreateCommand extends Command {

	Vertex source;

	Vertex target;

	Edge edge;

	/**
	 * @param i_source
	 */
	public EdgeCreateCommand(Edge edge, Vertex source) {
		this.edge = edge;
		this.source = source;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		edge.setSource(source);
		edge.setTarget(target);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		edge.setSource(null);
		edge.setTarget(null);
	}

	/**
	 * @param i_target the target to set
	 */
	public void setTarget(Vertex i_target) {
		target = i_target;
	}

}
