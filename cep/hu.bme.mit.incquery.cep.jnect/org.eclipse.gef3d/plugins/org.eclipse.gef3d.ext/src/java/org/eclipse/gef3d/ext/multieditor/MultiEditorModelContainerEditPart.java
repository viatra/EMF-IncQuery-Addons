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

package org.eclipse.gef3d.ext.multieditor;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw3d.StackLayout3D;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef3d.editpolicies.XY3DLayoutPolicy;
import org.eclipse.gef3d.editpolicies.XYZConstraintLayoutPolicy;
import org.eclipse.gef3d.ext.intermodel.UndirectConnectionEditPart3D;

/**
 * Edit Part for multi container, that is the content of a multi editor. The
 * root elements of all nested editors are children of this element, i.e., the
 * children edit parts of this part are the content edit parts of the nested
 * editors. This edit part uses a simple {@link StackLayout3D} for layouting the
 * children planes.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 14.01.2008
 */
public class MultiEditorModelContainerEditPart extends
		AbstractGraphicalEditPart implements PropertyChangeListener {

	/**
	 * Logger for this class
	 */
	@SuppressWarnings("unused")
	private static final Logger log =
		Logger.getLogger(MultiEditorModelContainerEditPart.class.getName());

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {
		Figure fig = new MultiEditorModelContainerFigure();
		fig.setLayoutManager(new StackLayout3D(500));

		return fig;
	}

	/**
	 * A {@link XYZConstraintLayoutPolicy} is installed in order to make
	 * 3D figures, that is the planes with the diagrams, moveable. Of course,
	 * the new locations are not stored.
	 * 
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new XYZConstraintLayoutPolicy());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
	 */
	@Override
	protected List getModelChildren() {
		MultiEditorModelContainer base = (MultiEditorModelContainer) getModel();
		return base.getModelContainers();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.fernuni.gef3d.EditPart#activate()
	 */
	@Override
	public void activate() {
		if (!isActive()) {
			((MultiEditorModelContainer) getModel())
				.addPropertyChangeListener(this);
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
		((MultiEditorModelContainer) getModel())
			.removePropertyChangeListener(this);
		super.deactivate();
	}

	/**
	 * Received an event from its model, that is the
	 * {@link MultiEditorModelContainer}, indicating a new child to be added, a
	 * child to be removed or a child to be replaced.
	 * <p>
	 * Note: The method must not call {@link #refreshChildren()} as it may occur
	 * that children are added <i>while</i> another child is refreshed. E.g., if
	 * a model loaded contains cross model references, it may happen that the
	 * cross referenced model gets automatically loaded when the cross model
	 * reference, also known as inter-model connection) (e.g., visualized using
	 * an {@link UndirectConnectionEditPart3D} ) is created and searches for it
	 * target edit part. In that case, the target edit part of the inter-model
	 * connection is a child of a diagram, which is loaded only when the target
	 * edit part is to be retrieved. This will cause a new diagram/editor to be
	 * added to the children of the multi editor <i>while</i> its
	 * {@link #refreshChildren()} method is active and running. Calling
	 * {@link #refreshChildren()} again would cause duplicate edit parts created
	 * for the same model elments, as {@link #refreshChildren()} is not prepared
	 * for that situation. In order to solve that problem, this update method
	 * here evaluates the change and adds or removes edit parts as needed
	 * without re-evaluating all children. This does not only prevent recursive
	 * calls to {@link #refreshChildren()}, but is also more performant.
	 * </p>
	 * 
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent i_Event) {
		if (i_Event.getSource() == getModel()
			&& MultiEditorModelContainer.PROPERTY_CONTAINER.equals(i_Event
				.getPropertyName())) {

			Object oldValue = i_Event.getOldValue();
			Object newValue = i_Event.getNewValue();

			if (oldValue == null && newValue != null) { // add new child
				EditPart editPart = createChild(newValue);
				addChild(editPart, -1); // append new edit part
			} else if (oldValue != null && newValue == null) { // remove child
				int i = findIndexOfEditPartByModel(oldValue);
				if (i >= 0) {
					removeChild((EditPart) children.get(i));
				}
			} else if (oldValue != null && newValue != null
				&& oldValue != newValue) { // changed
				int i = findIndexOfEditPartByModel(oldValue);
				if (i >= 0) {
					removeChild((EditPart) children.get(i));
				}
				EditPart editPart = createChild(newValue);
				addChild(editPart, i);
			}

		}
	}

	/**
	 * Finds index of child edit part <i>e</i> with
	 * <i>e.getModel()==modelOfChild/<i> is true. It is assumed that only one
	 * edit part is associated to the given model element. This method is used
	 * when receiving an event from the model indicating a child to be removed
	 * or replaced, see {@link #propertyChange(PropertyChangeEvent)}.
	 * 
	 * @param modelOfChild may not be null
	 * @return the index of the children edit part with given model or -1, if no
	 *         child edit part has given model
	 */
	protected int findIndexOfEditPartByModel(Object modelOfChild) {
		if (modelOfChild == null) // parameter precondition
			throw new NullPointerException("modelOfChild must not be null");

		int i = children.size();
		while (i > 0) {
			i--;
			if (((EditPart) children.get(i)).getModel() == modelOfChild) {
				break;
			}
		}
		return i;
	}

}
