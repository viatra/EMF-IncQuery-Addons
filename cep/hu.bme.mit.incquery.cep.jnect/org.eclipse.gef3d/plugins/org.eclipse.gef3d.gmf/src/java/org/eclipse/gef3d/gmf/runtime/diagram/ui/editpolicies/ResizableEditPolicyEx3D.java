/*******************************************************************************
 * Copyright (c) 2010 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 		IBM Corporation - initial API and implementation of 2D version
 *    	Jens von Pilgrim - initial 3D API and 3D implementation
 ******************************************************************************/
package org.eclipse.gef3d.gmf.runtime.diagram.ui.editpolicies;

import java.util.Iterator;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Handle;
import org.eclipse.gef.Request;
import org.eclipse.gef.handles.AbstractHandle;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.tools.DragEditPartsTracker;
import org.eclipse.gef3d.editpolicies.ResizableEditPolicy3D;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableEditPolicyEx;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx;

/**
 * 3D version of {@link ResizableEditPolicyEx}, a resizable edit policy that
 * understands REQ_DRAG and REQ_DROP requests.
 * 
 * @author melaasar (2D implementation)
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Jun 21, 2010
 */
public class ResizableEditPolicyEx3D extends ResizableEditPolicy3D {

	/**
	 * <p>
	 * Copy of {@link ResizableEditPolicyEx#eraseSourceFeedback(Request)}
	 * written by melaasar
	 * </p>
	 * 
	 * @see org.eclipse.gef.EditPolicy#eraseSourceFeedback(org.eclipse.gef.Request)
	 */
	@Override
	public void eraseSourceFeedback(Request request) {
		if (RequestConstants.REQ_DROP.equals(request.getType()))
			eraseChangeBoundsFeedback((ChangeBoundsRequest) request);
		else
			super.eraseSourceFeedback(request);
	}

	/**
	 * <p>
	 * Copy of {@link ResizableEditPolicyEx#showSourceFeedback(Request)} written by melaasar
	 * </p>
	 * 
	 * @see org.eclipse.gef.EditPolicy#showSourceFeedback(org.eclipse.gef.Request)
	 */
	@Override
	public void showSourceFeedback(Request request) {
		if (RequestConstants.REQ_DROP.equals(request.getType()))
			showChangeBoundsFeedback((ChangeBoundsRequest) request);
		else
			super.showSourceFeedback(request);
	}

//	/**
//	 * <p>
//	 * Copy of {@link ResizableEditPolicyEx#addSelectionHandles()} written by melaasar
//	 * </p>
//	 * 
//	 * @see org.eclipse.gef.editpolicies.SelectionHandlesEditPolicy#addSelectionHandles()
//	 */
//	@Override
//	protected void addSelectionHandles() {
//		super.addSelectionHandles();
//		Iterator iter = handles.iterator();
//		while (iter.hasNext()) {
//			Handle handle = (Handle) iter.next();
//			if (handle.getDragTracker().getClass() == DragEditPartsTracker.class)
//				replaceHandleDragEditPartsTracker(handle);
//		}
//	}

//	/**
//	 * Replaces the handle's default DragEditPartsTracker with the extended
//	 * DragEditPartsTrackerEx
//	 * <p>
//	 * Copy of {@link ResizableEditPolicyEx#replaceHandleDragEditPartsTracker(Handle)} written by melaasar
//	 * </p>
//	 * 
//	 * @param handle
//	 */
//	protected void replaceHandleDragEditPartsTracker(Handle handle) {
//		if (handle instanceof AbstractHandle) {
//			AbstractHandle h = (AbstractHandle) handle;
//			h.setDragTracker(new DragEditPartsTrackerEx(getHost()));
//		}
//	}

//	/**
//	 * <p>
//	 * Copy of {@link ResizableEditPolicyEx#getTargetEditPart(Request)} written by melaasar
//	 * </p>
//	 * 
//	 * @see org.eclipse.gef.EditPolicy#getTargetEditPart(org.eclipse.gef.Request)
//	 */
//	@Override
//	public EditPart getTargetEditPart(Request request) {
//		if (understandsRequest(request))
//			return getHost();
//		return super.getTargetEditPart(request);
//	}

//	/**
//	 * <p>
//	 * Copy of {@link ResizableEditPolicyEx#showChangeBoundsFeedback(ChangeBoundsRequest)} written by melaasar
//	 * </p> {@inheritDoc}
//	 * 
//	 * @see org.eclipse.gef3d.editpolicies.ResizableEditPolicy3D#showChangeBoundsFeedback(org.eclipse.gef.requests.ChangeBoundsRequest)
//	 */
//	@Override
//	protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
//		IFigure feedback = getDragSourceFeedbackFigure();
//
//		PrecisionRectangle rect =
//			new PrecisionRectangle(getInitialFeedbackBounds().getCopy());
//		getHostFigure().translateToAbsolute(rect);
//		rect.translate(request.getMoveDelta());
//		rect.resize(request.getSizeDelta());
//
//		IFigure f = getHostFigure();
//		Dimension min = f.getMinimumSize().getCopy();
//		Dimension max = f.getMaximumSize().getCopy();
//		IMapMode mmode = MapModeUtil.getMapMode(f);
//		min.height = mmode.LPtoDP(min.height);
//		min.width = mmode.LPtoDP(min.width);
//		max.height = mmode.LPtoDP(max.height);
//		max.width = mmode.LPtoDP(max.width);
//
//		if (min.width > rect.width)
//			rect.width = min.width;
//		else if (max.width < rect.width)
//			rect.width = max.width;
//
//		if (min.height > rect.height)
//			rect.height = min.height;
//		else if (max.height < rect.height)
//			rect.height = max.height;
//
//		feedback.translateToRelative(rect);
//		feedback.setBounds(rect);
//	}

}
