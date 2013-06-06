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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef3d.editparts.AbstractGraphicalNodeEditPart;
import org.eclipse.gef3d.editpolicies.ShowSourceFeedback3DEditPolicy;
import org.eclipse.gef3d.examples.graph.editor.editpolicies.VertexEditPolicy;
import org.eclipse.gef3d.examples.graph.model.Vertex;
import org.eclipse.gef3d.factories.IConnectionAnchorFactory;
import org.eclipse.gef3d.factories.SingleAnchorConnectionAnchorFactory;

/**
 * VertexPart manges vertices. This part can be using in 2D, 2.5D, and 3D mode.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 22.11.2007
 */
public class VertexPart extends AbstractGraphicalNodeEditPart implements
		PropertyChangeListener, NodeEditPart {

	/**
	 * Logger for this class
	 */
	private static final Logger log =
		Logger.getLogger(VertexPart.class.getName());

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#activate()
	 */
	@Override
	public void activate() {
		if (!isActive()) {
			((Vertex) getModel()).addPropertyChangeListener(this);
		}
		super.activate();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.editparts.AbstractGraphicalNodeEditPart#createConnectionAnchorFactory()
	 */
	@Override
	protected IConnectionAnchorFactory createConnectionAnchorFactory() {
		return new SingleAnchorConnectionAnchorFactory.ChopboxAnchor3DFactory(
			this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		installEditPolicy(ShowSourceFeedback3DEditPolicy.ROLE,
			new ShowSourceFeedback3DEditPolicy());
		installEditPolicy(EditPolicy.NODE_ROLE, new VertexEditPolicy());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#deactivate()
	 */
	@Override
	public void deactivate() {
		((Vertex) getModel()).removePropertyChangeListener(this);
		super.deactivate();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getDragTracker(org.eclipse.gef.Request)
	 */
	@Override
	public DragTracker getDragTracker(Request i_request) {

		return super.getDragTracker(i_request);
		// return new DragEditPartsTracker3D(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelSourceConnections()
	 */
	@Override
	protected List getModelSourceConnections() {
		return ((Vertex) getModel()).getSources();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelTargetConnections()
	 */
	@Override
	protected List getModelTargetConnections() {
		return ((Vertex) getModel()).getTargets();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent i_Event) {
		String strPropertyName = i_Event.getPropertyName();
		if (Vertex.PROPERTY_X.equals(strPropertyName)
			|| Vertex.PROPERTY_Y.equals(strPropertyName)
			|| Vertex.PROPERTY_HEIGHT.equals(strPropertyName)
			|| Vertex.PROPERTY_WIDTH.equals(strPropertyName)) {
			refreshVisuals();
		} else if (Vertex.PROPERTY_SOURCES.equals(strPropertyName)) {
			refreshSourceConnections();
		} else if (Vertex.PROPERTY_DESTS.equals(strPropertyName)) {
			refreshTargetConnections();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#refreshVisuals()
	 */
	@Override
	protected void refreshVisuals() {
		Vertex v = (Vertex) getModel();
		Point p = new Point(v.getX(), v.getY());
		IFigure fig = getFigure();
		fig.setLocation(p);
		fig.setSize(Math.round(v.getWidth()), Math.round(v.getHeight()));

		// if (log.isLoggable(Level.INFO)) {
		//			log.info("Updating figure for model " + v); //$NON-NLS-1$
		// }

		super.refreshVisuals();

		/*
		 * if (mode == Mode.GEFOGL) { IFigure3D fig = ( IFigure3D) getFigure();
		 * // HACK: don't change the figure's Z coordinate here float z =
		 * fig.getLocation3D().getZ(); Vector3f vec = new Vector3f(v.getX(),
		 * v.getY(), z); fig.setLocation3D(vec); vec.set(v.getWidth(),
		 * v.getHeight(), 5); fig.setSize3D(vec); } else { IFigure fig =
		 * getFigure(); Point p = new Point(v.getX(), v.getY());
		 * fig.setLocation(p); fig.setSize(Math.round(v.getWidth()),
		 * Math.round(v.getHeight())); }
		 */

	}

}
