/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others,
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation of 2D version
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.editpolicies;

import static org.eclipse.draw2d.PositionConstants.EAST;
import static org.eclipse.draw2d.PositionConstants.NORTH;
import static org.eclipse.draw2d.PositionConstants.NORTH_EAST;
import static org.eclipse.draw2d.PositionConstants.NORTH_WEST;
import static org.eclipse.draw2d.PositionConstants.SOUTH;
import static org.eclipse.draw2d.PositionConstants.SOUTH_EAST;
import static org.eclipse.draw2d.PositionConstants.SOUTH_WEST;
import static org.eclipse.draw2d.PositionConstants.WEST;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw3d.Figure3D;
import org.eclipse.draw3d.Figure3DHelper;
import org.eclipse.draw3d.IFigure3D;
import org.eclipse.draw3d.ISurface;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Handle;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef3d.handles.FeedbackFigure3D;
import org.eclipse.gef3d.handles.IHandleFactory;
import org.eclipse.gef3d.handles.MoveHandle3DFactory;
import org.eclipse.gef3d.handles.NonResizableHandle3DFactory;
import org.eclipse.gef3d.handles.ResizableHandle3DFactory;
import org.eclipse.gef3d.requests.ChangeBounds3DRequest;
import org.eclipse.gef3d.requests.ChangeBounds3DRequest.Modifier3D;

/**
 * 3D version of {@link ResizableEditPolicy}, creates 3D handles if used within
 * a 3D editor, otherwise it behaves such like its super class. I.e. this class
 * can be used instead of its superclass to enable controllers which can be used
 * in both, 2D and 3D modes.
 * <p>
 * This policy is usually not created and installed by the host edit part
 * directly. Instead it is created as a child policy. That means a parent edit
 * part's policy decorates the children of their host edit part with new
 * policies. An example can be found in <code>Handles3DEditPolicy</code> of the
 * GMF UML Tools 3D example. The according 2D version is for example created by
 * {@link ConstrainedLayoutEditPolicy#createChildEditPolicy(EditPart)}.
 * </p>
 * <p>
 * Since the task of this policy remains, the policy can still understand the
 * same requests as the original 2D version, that is for example the following
 * types: {@link RequestConstants#REQ_RESIZE}, {@link RequestConstants#REQ_MOVE}
 * (if drag is allowed), {@link RequestConstants#REQ_CLONE},
 * {@link RequestConstants#REQ_ADD}, {@link RequestConstants#REQ_ORPHAN} and
 * {@link RequestConstants#REQ_ALIGN}.
 * </p>
 * <p>
 * Parts of this class (methods and/or comments) were copied and modified from
 * {@link ResizableEditPolicy}, copyright (c) 2000, 2005 IBM Corporation and
 * others and distributed under the EPL license.
 * </p>
 * <p>
 * Note: This edit policy does not understand drag and drop! If you need that,
 * use
 * {@link org.eclipse.gef3d.gmf.runtime.diagram.ui.editpolicies.ResizableEditPolicy3DEx}
 * </p>
 * 
 * @author Randy Hudson (hudsonr) (original 2D version)
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Mar 24, 2008
 */
public class ResizableEditPolicy3D extends ResizableEditPolicy {

	/**
	 * Logger for this class
	 */
	@SuppressWarnings("unused")
	private static final Logger log = Logger
		.getLogger(ResizableEditPolicy3D.class.getName());

	private FeedbackHelper3D m_helper;

	/**
	 * Creates the figure used for feedback.
	 * <p>
	 * Copied and modified for 3D from
	 * {@link NonResizableEditPolicy#createDragSourceFeedbackFigure()}.
	 * </p>
	 * 
	 * @return the new feedback figure
	 */
	@Override
	protected IFigure createDragSourceFeedbackFigure() {

		// use 2D implementation if only 2D figures are displayed
		if (Figure3DHelper.getAncestor3D(getHostFigure()) == null) {
			return super.createDragSourceFeedbackFigure();
		} else { // use 3D implementation otherwise

			// Use a ghost rectangle for feedback
			// GEF:
			// RectangleFigure r = new RectangleFigure();
			// FigureUtilities.makeGhostShape(r);
			// r.setLineStyle(Graphics.LINE_DOT);
			// r.setForegroundColor(ColorConstants.white);

			IFigure3D feedback = new FeedbackFigure3D();
			getFeedbackHelper().setInitialFeedbackPosition(feedback);

			addFeedback(feedback);
			return feedback;
		}
	}

	/**
	 * Creates a new feedback helper for the current host figure.
	 * 
	 * @return the feedback helper
	 */
	protected FeedbackHelper3D createFeedbackHelper() {

		return new FeedbackHelper3D();
	}

	/**
	 * {@inheritDoc} This method is responsible for creating selection handles.
	 * <p>
	 * Copied from {@link ResizableEditPolicy}. Instead of handler kits,
	 * factories are used. If no 3D ancestor is found, the original method is
	 * used.
	 * </p>
	 * 
	 * @see org.eclipse.gef.editpolicies.ResizableEditPolicy#createSelectionHandles()
	 */
	@Override
	protected List createSelectionHandles() {

		// use 2D implementation if only 2D figures are displayed
		if (Figure3DHelper.getAncestor3D(getHostFigure()) == null) {
			return super.createSelectionHandles();
		} else { // use 3D implementation otherwise

			IHandleFactory nonResizableHF =
				NonResizableHandle3DFactory.INSTANCE;
			IHandleFactory resizableHF = ResizableHandle3DFactory.INSTANCE;
			IHandleFactory moveHF = MoveHandle3DFactory.INSTANCE;

			int directions = getResizeDirections();

			List<Handle> list = new ArrayList<Handle>();
			GraphicalEditPart host = (GraphicalEditPart) getHost();

			if (directions == 0)
				nonResizableHF.addHandles(host, list);
			else if (directions != -1) {
				moveHF.addHandles(host, list);
				if ((directions & EAST) != 0)
					resizableHF.addHandle(host, list, EAST);
				else
					nonResizableHF.addHandle(host, list, EAST);
				if ((directions & SOUTH_EAST) == SOUTH_EAST)
					resizableHF.addHandle(host, list, SOUTH_EAST);
				else
					nonResizableHF.addHandle(host, list, SOUTH_EAST);
				if ((directions & SOUTH) != 0)
					resizableHF.addHandle(host, list, SOUTH);
				else
					nonResizableHF.addHandle(host, list, SOUTH);
				if ((directions & SOUTH_WEST) == SOUTH_WEST)
					resizableHF.addHandle(host, list, SOUTH_WEST);
				else
					nonResizableHF.addHandle(host, list, SOUTH_WEST);
				if ((directions & WEST) != 0)
					resizableHF.addHandle(host, list, WEST);
				else
					nonResizableHF.addHandle(host, list, WEST);
				if ((directions & NORTH_WEST) == NORTH_WEST)
					resizableHF.addHandle(host, list, NORTH_WEST);
				else
					nonResizableHF.addHandle(host, list, NORTH_WEST);
				if ((directions & NORTH) != 0)
					resizableHF.addHandle(host, list, NORTH);
				else
					nonResizableHF.addHandle(host, list, NORTH);
				if ((directions & NORTH_EAST) == NORTH_EAST)
					resizableHF.addHandle(host, list, NORTH_EAST);
				else
					nonResizableHF.addHandle(host, list, NORTH_EAST);
			} else
				resizableHF.addHandles(host, list);

			return list;
		}
	}

	/**
	 * Returns the current feedback helper. If no feedback helper is set, a new
	 * one will be created. Also,
	 * {@link FeedbackHelper3D#setHostFigure(IFigure)} will be called with the
	 * current host figure as the parameter.
	 * 
	 * @return the feedback helper
	 */
	protected FeedbackHelper3D getFeedbackHelper() {

		if (m_helper == null)
			m_helper = createFeedbackHelper();

		m_helper.setHostFigure(getHostFigure());
		return m_helper;
	}

	/**
	 * Shows or updates feedback for a change bounds request.
	 * <p>
	 * Copied and modified for 3D from
	 * {@link NonResizableEditPolicy#showChangeBoundsFeedback(ChangeBoundsRequest)}
	 * .
	 * </p>
	 * 
	 * @param request the request
	 */
	@Override
	protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {

		IFigure feedback = getDragSourceFeedbackFigure();
		if (!(feedback instanceof IFigure3D))
			super.showChangeBoundsFeedback(request);
		else {
			IFigure3D feedback3D = (IFigure3D) feedback;

			if (request instanceof ChangeBounds3DRequest) {
				ChangeBounds3DRequest cbr = (ChangeBounds3DRequest) request;
				if (((ChangeBounds3DRequest) request).getModifier3D() != Modifier3D.NONE) {

					ISurface figureSurface = getFigureSurface();
					if (figureSurface != null) {
						getFeedbackHelper().setInitialFeedbackPosition(
							feedback3D, figureSurface);

						Vector3f newPos = null;
						if (cbr.getModifier3D() == Modifier3D.DEPTH
							&& getHostFigure() instanceof IFigure3D) {

							newPos =
								cbr.getStartSurface().getWorldLocation(
									cbr.getMoveDepthDelta3D(), newPos);
							Math3D.sub(newPos, cbr.getStartSurface().getHost()
								.getPosition3D().getLocation3D(), newPos);
							Math3D.add(((Figure3D) getHostFigure())
								.getPosition3D().getLocation3D(), newPos,
								newPos);

						}

						getFeedbackHelper().updateFeedbackPosition(feedback3D,
							newPos, cbr.getRotationDelta3D());
						return;
					}

				} 
			}

			// default and fall back solution: standard 2D mechanism:
			getFeedbackHelper().setInitialFeedbackPosition(feedback3D);
			getFeedbackHelper().updateFeedbackPosition(feedback3D,
				request.getMoveDelta(), request.getSizeDelta());

		}
	}

	/**
	 * Returns the surface of the host's figure. This surface is used in 3D
	 * interaction to show feedback figure, as in these cases we do not want to
	 * let the feedback figure "jump" on arbitrary surfaces.
	 * 
	 * @return
	 */
	protected ISurface getFigureSurface() {
		return Figure3DHelper.getAncestor3D(getHostFigure()).getSurface();
	}

	/**
	 * If given request is an instance of {@link ChangeBounds3DRequest}, the
	 * temporarily created request forwarded to the host's parent is a
	 * {@link ChangeBounds3DRequest} as well, including all the 3D information.
	 * 
	 * @see org.eclipse.gef.editpolicies.NonResizableEditPolicy#getMoveCommand(org.eclipse.gef.requests.ChangeBoundsRequest)
	 */
	@Override
	protected Command getMoveCommand(ChangeBoundsRequest request) {
		if (request instanceof ChangeBounds3DRequest) {
			ChangeBounds3DRequest request3D = (ChangeBounds3DRequest) request;

			ChangeBounds3DRequest req =
				new ChangeBounds3DRequest(REQ_MOVE_CHILDREN);
			req.setEditParts(getHost());

			req.set(request3D);

			// from super:
			return getHost().getParent().getCommand(req);
		} else {
			return super.getMoveCommand(request);
		}
	}

}
