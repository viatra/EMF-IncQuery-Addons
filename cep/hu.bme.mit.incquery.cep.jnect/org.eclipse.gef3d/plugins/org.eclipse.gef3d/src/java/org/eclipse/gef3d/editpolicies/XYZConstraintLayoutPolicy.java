/*******************************************************************************
 * Copyright (c) 2011 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.editpolicies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw3d.IFigure3D;
import org.eclipse.draw3d.ISurface;
import org.eclipse.draw3d.LocatorHelper;
import org.eclipse.draw3d.geometry.IBoundingBox;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Position3D;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.util.Draw3DCache;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef3d.commands.UpdateConstraintCommand;
import org.eclipse.gef3d.requests.ChangeBounds3DRequest;
import org.eclipse.gef3d.requests.ChangeBounds3DRequest.Modifier3D;

/**
 * Layout policy creating commands for updating constraints of figures,
 * regardless of edit part and model. Children of a (3D) figure using this
 * layout can be moved and rotated in 3D space, however the change of position
 * is not propagated to the edit part and thus cannot be persisted.
 * <p>
 * This policy is usually only used for multi editors to enable the user to
 * temporarily move planes around.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @version $Revision$
 * @since Apr 24, 2011
 */
public class XYZConstraintLayoutPolicy extends XY3DLayoutPolicy {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#createChangeConstraintCommand(org.eclipse.gef.EditPart,
	 *      java.lang.Object)
	 */
	@Override
	protected Command createChangeConstraintCommand(EditPart i_child,
		Object i_constraint) {
		if (i_child instanceof GraphicalEditPart) {
			return new UpdateConstraintCommand(
				((GraphicalEditPart) i_child).getFigure(), i_constraint,
				getHostFigure().getLayoutManager());
		}
		return null;
	}

	/**
	 * Returns null, no new elements can be created with this policy.
	 * 
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getCreateCommand(org.eclipse.gef.requests.CreateRequest)
	 */
	@Override
	protected Command getCreateCommand(CreateRequest request) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Internal note: The algorithm used to calculate new position is quire
	 * similar to the one used in
	 * {@link FeedbackHelper3D#updateFeedbackPosition(IFigure3D, IVector3f, IVector3f)}
	 * . In case of 3D-movement, the conversion is done in
	 * {@link ChangeBounds3DRequest#getTransformedPosition(Position3D)}, which
	 * is similar to
	 * {@link FeedbackHelper3D#updateFeedbackPosition(IFigure3D, org.eclipse.draw2d.geometry.Point, org.eclipse.draw2d.geometry.Dimension)}
	 * </p>
	 * 
	 * @see org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#getConstraintFor(org.eclipse.gef.requests.ChangeBoundsRequest,
	 *      org.eclipse.gef.GraphicalEditPart)
	 */
	@Override
	protected Object getConstraintFor(ChangeBoundsRequest request,
		GraphicalEditPart child) {

		if (request instanceof ChangeBounds3DRequest
			&& child.getFigure() instanceof IFigure3D) {

			ChangeBounds3DRequest cbr3D = (ChangeBounds3DRequest) request;
			IFigure3D child3D = (IFigure3D) child.getFigure();

			if (cbr3D.getModifier3D() != Modifier3D.NONE) {
				Position3D childPos = child3D.getPosition3D();
				Position3D newPos = childPos.getAbsolute(null);
				cbr3D.getTransformedPosition(newPos);
				return getConstraintFor(newPos);
			} else {

				ISurface surface = cbr3D.getStartSurface();
				LocatorHelper locator = new LocatorHelper(child3D);
				Position3D newPos =
					locator.getReferencePosition3D(surface.getHost());
				Vector3f surfaceRelativeLocation = Draw3DCache.getVector3f();
				Vector3f size = Draw3DCache.getVector3f();
				try {
					if (request.getMoveDelta() != null) {
						surfaceRelativeLocation.set(newPos.getLocation3D());
						surfaceRelativeLocation.translate(
							request.getMoveDelta().x, request.getMoveDelta().y,
							0);
						newPos.setLocation3D(surfaceRelativeLocation);
					}

					if (request.getSizeDelta() != null) {
						size.set(newPos.getSize3D());
						size.translate(request.getSizeDelta().width,
							request.getSizeDelta().height, 0);
						newPos.setSize3D(size);
					}
					
				} finally {
					Draw3DCache.returnVector3f(surfaceRelativeLocation, size);
				}
				return getConstraintFor(newPos);
			}
		}

		// fall back to 2D:
		return super.getConstraintFor(request, child);

	}

	/**
	 * @param i_newPos
	 * @return
	 */
	protected Object getConstraintFor(Position3D i_newPos) {
		return i_newPos;
	}

}
