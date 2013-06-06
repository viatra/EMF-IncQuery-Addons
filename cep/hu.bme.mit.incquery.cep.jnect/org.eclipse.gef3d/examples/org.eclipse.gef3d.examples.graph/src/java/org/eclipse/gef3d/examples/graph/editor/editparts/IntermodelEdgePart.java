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

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef3d.editparts.AbstractConnectionEditPart3D;
import org.eclipse.gef3d.examples.graph.editor.figures.EdgeFigure3D;
import org.eclipse.gef3d.examples.graph.model.Edge;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

/**
 * IntermodelEdgePart There should really be more documentation here.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 04.04.2008
 */
public class IntermodelEdgePart extends AbstractConnectionEditPart3D implements
		PropertyChangeListener {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#activate()
	 */
	@Override
	public void activate() {
		if (!isActive()) {
			((Edge) getModel()).addPropertyChangeListener(this);
		}
		super.activate();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.examples.graph.editor.editparts.EdgePart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {

		EdgeFigure3D edge = new EdgeFigure3D();

		Color color = Display.getCurrent().getSystemColor(SWT.COLOR_BLUE);
		edge.setForegroundColor(color);

		// edge.setTargetDecoration(new ArrowDecoration3D());
		// edge.setSourceDecoration(new ArrowDecoration3D());

		return edge;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#deactivate()
	 */
	@Override
	public void deactivate() {
		((Edge) getModel()).removePropertyChangeListener(this);
		super.deactivate();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent i_arg0) {
		// nothing to do
	}
}
