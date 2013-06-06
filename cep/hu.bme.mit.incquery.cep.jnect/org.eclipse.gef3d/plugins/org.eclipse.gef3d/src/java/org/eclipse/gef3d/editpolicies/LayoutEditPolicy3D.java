/*******************************************************************************
 * Copyright (c) 2009 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.editpolicies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw3d.Figure3DHelper;
import org.eclipse.draw3d.IFigure3D;
import org.eclipse.gef.Request;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef3d.handles.FeedbackFigure3D;

/**
 * 3D version of {@link LayoutEditPolicy}.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 30.07.2009
 */
public abstract class LayoutEditPolicy3D extends LayoutEditPolicy {

	private FeedbackHelper3D m_helper;

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
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#createSizeOnDropFeedback(org.eclipse.gef.requests.CreateRequest)
	 */
	@Override
	protected IFigure createSizeOnDropFeedback(CreateRequest i_createRequest) {

		IFigure3D host3D = Figure3DHelper.getAncestor3D(getHostFigure());
		if (host3D == null) {
			return super.createSizeOnDropFeedback(i_createRequest);
		} else { // use 3D implementation otherwise
			FeedbackFigure3D feedback = new FeedbackFigure3D();

			addFeedback(feedback);
			return feedback;
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
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#showLayoutTargetFeedback(org.eclipse.gef.Request)
	 */
	@Override
	protected void showLayoutTargetFeedback(Request i_request) {

		if (i_request instanceof CreateRequest
			&& REQ_CREATE.equals(i_request.getType())) {

			CreateRequest createRequest = (CreateRequest) i_request;
			IFigure3D feedback =
				(IFigure3D) getSizeOnDropFeedback(createRequest);

			getFeedbackHelper().setAbsoluteFeedbackBounds(feedback,
				createRequest.getLocation(), createRequest.getSize());
		}
	}
}
