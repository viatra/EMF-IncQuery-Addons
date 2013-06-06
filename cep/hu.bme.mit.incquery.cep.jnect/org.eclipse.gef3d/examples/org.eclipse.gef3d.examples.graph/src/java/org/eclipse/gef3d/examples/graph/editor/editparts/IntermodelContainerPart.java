/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 *    Kristian Duske - multi editor sample
 ******************************************************************************/
package org.eclipse.gef3d.examples.graph.editor.editparts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef3d.examples.graph.editor.figures.IntermodelContainerFigure;
import org.eclipse.gef3d.examples.graph.model.IntermodelContainer;


/**
 * IntermodelContainerPart There should really be more documentation here.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 04.04.2008
 */
public class IntermodelContainerPart extends AbstractGraphicalEditPart
		implements PropertyChangeListener {

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.fernuni.gef3d.EditPart#activate()
	 */
	@Override
	public void activate() {

		if (!isActive())
			((IntermodelContainer) getModel()).addPropertyChangeListener(this);
		super.activate();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		// TODO implement method IntermodelContainerPart.createEditPolicies

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractConnectionEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {
		IntermodelContainerFigure figure = new IntermodelContainerFigure();
		figure.getPosition3D().setLocation3D(IVector3f.NULLVEC3f);
		return figure;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#deactivate()
	 */
	@Override
	public void deactivate() {
		((IntermodelContainer) getModel()).removePropertyChangeListener(this);
		super.deactivate();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
	 */
	@Override
	protected List getModelChildren() {

		return ((IntermodelContainer) getModel()).getConnections();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent i_event) {

		String strPropertyName = i_event.getPropertyName();
		if (IntermodelContainer.PROPERTY_CONNECTIONS.equals(strPropertyName)) {
			refreshChildren();
		}
	}

}
