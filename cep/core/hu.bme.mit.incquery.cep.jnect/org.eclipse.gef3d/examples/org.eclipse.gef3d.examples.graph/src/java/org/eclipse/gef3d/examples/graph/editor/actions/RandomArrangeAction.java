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
package org.eclipse.gef3d.examples.graph.editor.actions;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.gef3d.examples.graph.editor.editparts.VertexPart;
import org.eclipse.gef3d.examples.graph.model.Vertex;
import org.eclipse.ui.IWorkbenchPart;


/**
 * This action arranges all nodes of a diagram randomly. It has no real use but
 * can be used to debug and validate update mechanisms.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Feb 7, 2008
 */
public class RandomArrangeAction extends WorkbenchPartAction {
	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger.getLogger(RandomArrangeAction.class.getName());

	public final static String ID = RandomArrangeAction.class.getName();

	/**
	 * @param i_part
	 */
	public RandomArrangeAction(IWorkbenchPart i_part) {
		super(i_part);
		setId(ID);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#calculateEnabled()
	 */
	@Override
	protected boolean calculateEnabled() {
		// TODO implement method RandomArrangeAction.calculateEnabled
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		List<Vertex> vertices = getVertices(getVertexParts());
		float[] minmax = getMinMax(vertices);
		if (vertices.size()<4) {
			minmax[0] = 100;
			minmax[1] = 100;
		}
		randomArrange(vertices, minmax[0]*1.1f, minmax[1]*1.1f);
		

		if (log.isLoggable(Level.INFO)) {
			log.info("Arranged nodes randomly"); //$NON-NLS-1$
		}

	}

	protected GraphicalViewer getEditPartViewer() {
		return (GraphicalViewer) getWorkbenchPart().getAdapter(
				GraphicalViewer.class);
	}

	@SuppressWarnings("unchecked")
	protected List<VertexPart> getVertexParts() {
		GraphicalViewer viewer = getEditPartViewer();
		List listEditParts = viewer.getContents().getChildren();
		List<VertexPart> list = new ArrayList<VertexPart>();
		for (Iterator iter = listEditParts.iterator(); iter.hasNext();) {
			Object obj = iter.next();
			if (obj instanceof VertexPart) {
				list.add((VertexPart) obj);
			}
		}
		return list;
	}

	protected List<Vertex> getVertices(List<VertexPart> editParts) {
		if (editParts == null) // parameter precondition
			throw new NullPointerException("editParts must not be null");

		List<Vertex> list = new ArrayList<Vertex>(editParts.size());
		for (VertexPart part : editParts) {
			if (part.getModel() != null)
				list.add((Vertex) part.getModel());
		}
		return list;
	}

	protected float[] getMinMax(List<Vertex> vertices) {
		float fMaxX = Float.MIN_VALUE, fMaxY = Float.MIN_VALUE;
		for (Vertex v : vertices) {
			fMaxX = Math.max(fMaxX, v.getX());
			fMaxY = Math.max(fMaxY, v.getY());
		}
		float[] ret = { fMaxX, fMaxY };
		return ret;
	}

	/**
	 * @param io_vertices
	 * @param maxX
	 * @param maxY
	 */
	protected void randomArrange(List<Vertex> io_vertices, float maxX, float maxY) {
		for (Vertex v: io_vertices) {
			v.setX((float) (Math.random()*maxX));
			v.setY((float) (Math.random()*maxY));
		}
	}
}
