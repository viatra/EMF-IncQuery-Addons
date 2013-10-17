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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gef3d.editparts.AbstractGraphicalEditPartEx;
import org.eclipse.gef3d.editpolicies.ShowLayoutFeedbackEditPolicy3D;
import org.eclipse.gef3d.examples.graph.editor.editpolicies.Graph3DLayoutPolicy;
import org.eclipse.gef3d.examples.graph.model.Graph;
import org.eclipse.gef3d.examples.graph.model.Vertex;
import org.eclipse.gef3d.factories.IFigureFactory;

/**
 * Abstract base class for 2D and generic edit parts. All these different 
 * graph edit parts only exists for demonstration purposes, read
 * package documenation for details.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 21.11.2007
 */
public abstract class AbstractGraphPart extends AbstractGraphicalEditPartEx implements
        PropertyChangeListener {

    /**
     * {@inheritDoc}
     * 
     * @see de.fernuni.gef3d.EditPart#activate()
     */
    @Override
    public void activate() {

        if (!isActive()) {
            ((Graph) getModel()).addPropertyChangeListener(this);
        }
        super.activate();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#deactivate()
     */
    @Override
    public void deactivate() {

        ((Graph) getModel()).removePropertyChangeListener(this);
        super.deactivate();
    }

    /**
     * This method get notified by the model (the graph) if new elements were
     * added or elements have been removed. In order to reflect the changes, the
     * children have to be refreshed. Since we also want to optimize the plane,
     * we call {@link #refresh()} in order to update the size.
     * 
     * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
     */
    public void propertyChange(PropertyChangeEvent i_Event) {

        String strPropertyName = i_Event.getPropertyName();
        if (Graph.PROPERTY_VERTECES.equals(strPropertyName)) {
            refresh();
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
     */
    @SuppressWarnings("unchecked")
    @Override
    protected List getModelChildren() {

        return ((Graph) getModel()).getVertices();
    }


    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.gef.editparts.AbstractEditPart#refreshVisuals()
     */
    @Override
    protected void refreshVisuals() {

        IFigure fig = getFigure();
        fig.setSize(getMaxPosition());

        super.refreshVisuals();
    }

    protected Dimension getMaxPosition() {

        Graph g = (Graph) getModel();
        Dimension dim = new Dimension(100, 100);
        int f;
        for (Vertex v : g.getVertices()) {
            f = (int) (v.getX() + v.getWidth());
            if (f > dim.width)
                dim.width = f;
            f = (int) (v.getY() + v.getHeight());
            if (f > dim.height)
                dim.height = f;
        }
        dim.width += 5;
        dim.height += 5;
        return dim;
    }

}
