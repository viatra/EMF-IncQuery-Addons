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

import java.util.logging.Logger;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef3d.examples.graph.model.Vertex;

/**
 * VertexResizeCommand There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Jun 4, 2009
 */
public class VertexResizeCommand extends Command {
	private Vertex vertex;

	private Rectangle bounds;

	private Rectangle boundsOld;

	public VertexResizeCommand(Vertex vertex, Rectangle bounds) {
	    
		this.vertex = vertex;
		this.bounds = new Rectangle(bounds);
		this.boundsOld =
			new Rectangle((int) vertex.getX(), (int) vertex.getY(),
				(int) vertex.getWidth(), (int) vertex.getHeight());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		vertex.setX(bounds.x);
		vertex.setY(bounds.y);
		vertex.setWidth(bounds.width);
		vertex.setHeight(bounds.height);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		vertex.setX(boundsOld.x);
		vertex.setY(boundsOld.y);
		vertex.setWidth(boundsOld.width);
		vertex.setHeight(boundsOld.height);

	}
}
