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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw3d.Figure3DHelper;
import org.eclipse.draw3d.IFigure3D;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Handle;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef3d.handles.FeedbackFigure3D;
import org.eclipse.gef3d.handles.IHandleFactory;
import org.eclipse.gef3d.handles.NonResizableHandle3DFactory;

/**
 * NonResizableEditPolicy3D creates 3D handles if used within a 3D editor,
 * otherwise it behaves such like its super class. I.e. this class can be used
 * instead of its superclass to enable controllers which can be used in both, 2D
 * and 3D modes.
 * 
 * @author Randy Hudson (hudsonr) (original 2D version)
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Apr 14, 2008
 */
public class NonResizableEditPolicy3D extends NonResizableEditPolicy {
	private FeedbackHelper3D m_helper;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editpolicies.NonResizableEditPolicy#createDragSourceFeedbackFigure()
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
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editpolicies.NonResizableEditPolicy#createSelectionHandles()
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected List createSelectionHandles() {
		// use 2D implementation if only 2D figures are displayed
		if (Figure3DHelper.getAncestor3D(getHostFigure()) == null) {
			return super.createSelectionHandles();
		} else { // use 3D implementation otherwise
			IHandleFactory nonResizableHF =
				NonResizableHandle3DFactory.INSTANCE;

			List<Handle> list = new ArrayList<Handle>();

			// TODO implement tracker method
			// if (isDragAllowed())
			nonResizableHF.addHandles((GraphicalEditPart) getHost(), list);
			// else
			// NonResizableHandleKit.addHandles((GraphicalEditPart)getHost(),
			// list,
			// new SelectEditPartTracker(getHost()), SharedCursors.ARROW);
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
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editpolicies.NonResizableEditPolicy#showChangeBoundsFeedback(org.eclipse.gef.requests.ChangeBoundsRequest)
	 */
	@Override
	protected void showChangeBoundsFeedback(ChangeBoundsRequest i_request) {

		IFigure feedback = getDragSourceFeedbackFigure();
		if (!(feedback instanceof IFigure3D))
			super.showChangeBoundsFeedback(i_request);
		else {
			IFigure3D feedback3D = (IFigure3D) feedback;
			getFeedbackHelper().setInitialFeedbackPosition(feedback3D);
			getFeedbackHelper().updateFeedbackPosition(feedback3D,
				i_request.getMoveDelta(), i_request.getSizeDelta());
		}
	}
}
