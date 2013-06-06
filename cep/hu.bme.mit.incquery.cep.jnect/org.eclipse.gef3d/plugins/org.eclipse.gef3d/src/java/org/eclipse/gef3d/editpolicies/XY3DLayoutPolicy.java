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
package org.eclipse.gef3d.editpolicies;

import java.util.logging.Logger;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw3d.geometry.IBoundingBox;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Position3D;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;

/**
 * 3D version of GEF's {@link XYLayoutEditPolicy} managing 3D handles (via its
 * children).
 * <p>
 * Most of the methods implemented here are copies of the super class, except 2D
 * related things are replaced with 3D version.
 * </p>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Mar 24, 2008
 */
public abstract class XY3DLayoutPolicy extends XYLayoutEditPolicy {

	/**
	 * Logger for this class
	 */
	@SuppressWarnings("unused")
	private static final Logger log =
		Logger.getLogger(XY3DLayoutPolicy.class.getName());

	/**
	 * {@inheritDoc}
	 * <p>
	 * Calls super method and replaces possibly created
	 * {@link ResizableEditPolicy} with 3D version {@link ResizableEditPolicy3D}.
	 * 
	 * @see org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#createChildEditPolicy(org.eclipse.gef.EditPart)
	 */
	@Override
	protected EditPolicy createChildEditPolicy(EditPart i_child) {

		EditPolicy ret = super.createChildEditPolicy(i_child);

		// replace 2D version with 3D version
		if (ret instanceof ResizableEditPolicy)
			ret = new ResizableEditPolicy3D();

		return ret;
	}
	
	/**
	 * {@inheritDoc}
	 * <p>
	 * Overridden as the 3D version may not only handle constraints of type
	 * {@link Rectangle}, but {@link Position3D}, {@link IBoundingBox} and
	 * {@link IVector3f} as well, and this might cause class cast exceptions in
	 * the 2D methods.
	 * </p>
	 * 
	 * @param child the child
	 * @return the current constraint if it is defined and of type
	 *         {@link Rectangle}, null otherwise.
	 * @see org.eclipse.gef.editpolicies.XYLayoutEditPolicy#getCurrentConstraintFor(org.eclipse.gef.GraphicalEditPart)
	 */
	@Override
	protected Rectangle getCurrentConstraintFor(GraphicalEditPart child) {
		IFigure fig = child.getFigure();
		Object constraint =
			fig.getParent().getLayoutManager().getConstraint(fig);
		if (constraint instanceof Rectangle) {
			return (Rectangle) fig.getParent().getLayoutManager()
				.getConstraint(fig);
		}

		return null;
	}

}
