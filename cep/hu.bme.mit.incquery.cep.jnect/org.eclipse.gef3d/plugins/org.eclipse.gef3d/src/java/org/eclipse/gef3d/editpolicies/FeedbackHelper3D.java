/*******************************************************************************
 * Copyright (c) 2009 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.editpolicies;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.UpdateManager;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw3d.Figure3DHelper;
import org.eclipse.draw3d.IFigure3D;
import org.eclipse.draw3d.ISurface;
import org.eclipse.draw3d.LocatorHelper;
import org.eclipse.draw3d.PickingUpdateManager3D;
import org.eclipse.draw3d.XYZAnchor;
import org.eclipse.draw3d.geometry.IMatrix4f;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Matrix4f;
import org.eclipse.draw3d.geometry.Matrix4fImpl;
import org.eclipse.draw3d.geometry.Position3D;
import org.eclipse.draw3d.geometry.Position3DUtil;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;
import org.eclipse.draw3d.picking.Picker;
import org.eclipse.draw3d.util.Draw3DCache;
import org.eclipse.gef.editpolicies.FeedbackHelper;
import org.eclipse.gef3d.requests.ChangeBounds3DRequest;

/**
 * FeedbackHelper3D There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since May 31, 2009
 */
public class FeedbackHelper3D extends FeedbackHelper {

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(FeedbackHelper3D.class
		.getName());

	/**
	 * A dummy anchor.
	 */
	protected XYZAnchor m_dummyAnchor;

	// /**
	// * The 3D host figure.
	// */
	// protected IFigure m_hostFigure;

	/**
	 * The locator helper.
	 */
	protected LocatorHelper m_helper;

	/**
	 * The picker, which can be <code>null</code>.
	 */
	protected Picker m_picker;

	/**
	 * Creates a new feedback helper.
	 */
	public FeedbackHelper3D() {

		m_dummyAnchor = createDummyAnchor();
	}

	/**
	 * Creates a dummy anchor.
	 * 
	 * @return a dummy anchor
	 */
	protected XYZAnchor createDummyAnchor() {

		return new XYZAnchor(new Vector3fImpl(10, 10, 10));
	}

	/**
	 * Sets the bounds of the given feedback figure to the given values,
	 * expanded by <code>0.01f</code>. The given values are in relation to the
	 * current surface.
	 * 
	 * @param i_feedback the feedback figure to modify
	 * @param i_sLocation the absolute location in surface coordinates
	 * @param i_sSize the absolute size in surface coordinates
	 */
	public void setAbsoluteFeedbackBounds(IFigure3D i_feedback,
		Point i_sLocation, Dimension i_sSize) {

		if (i_feedback == null)
			throw new NullPointerException("i_feedback must not be null");

		Vector3f surfaceRelativeLocation = Draw3DCache.getVector3f();
		Vector3f wSize = Draw3DCache.getVector3f();
		Vector3f rotation = Draw3DCache.getVector3f();
		// Point sCenter = Draw3DCache.getPoint();
		try {
			Position3D feedbackPosition = i_feedback.getPosition3D();
			ISurface surface = m_picker.getCurrentSurface();

			surface.getSurfaceRotation(rotation);
			feedbackPosition.setRotation3D(rotation);

			if (i_sSize != null)
				wSize.set(i_sSize.width, i_sSize.height, 1);
			else
				wSize.set(0, 0, 1);

			feedbackPosition.setSize3D(wSize);

			if (i_sLocation != null) {
				// if (i_sSize != null) {
				// sCenter.setLocation(i_sSize.width, i_sSize.height);
				// sCenter.scale(0.5);
				// } else
				// sCenter.setLocation(0, 0);
				//
				// sCenter.translate(i_sLocation);
				surface.getWorldLocation(i_sLocation, surfaceRelativeLocation);

				// feedbackPosition.setCenter3D(surfaceRelativeLocation);
				feedbackPosition.setLocation3D(surfaceRelativeLocation);
			}
		} finally {
			Draw3DCache
				.returnVector3f(surfaceRelativeLocation, wSize, rotation);
			// Draw3DCache.returnPoint(sCenter);
		}
	}

	/**
	 * Moves the given feedback figure by the given move delta and resizes it by
	 * the given size delta. The given deltas are in relation to the current
	 * surface.
	 * 
	 * @param i_feedback the feedback figure
	 * @param i_surfaceMoveDelta the move delta
	 * @param i_surfaceSizeDelta the size delta
	 * @see XYZConstraintLayoutPolicy#getConstraintFor(org.eclipse.gef.requests.ChangeBoundsRequest,
	 *      org.eclipse.gef.GraphicalEditPart)
	 */
	public void updateFeedbackPosition(IFigure3D i_feedback,
		Point i_surfaceMoveDelta, Dimension i_surfaceSizeDelta) {

		// if (log.isLoggable(Level.INFO)) {
		//			log.info("move " + i_surfaceMoveDelta); //$NON-NLS-1$
		// }

		if (i_feedback == null)
			throw new NullPointerException("i_feedback must not be null");

		Vector3f surfaceRelativeLocation = Draw3DCache.getVector3f();
		Vector3f size = Draw3DCache.getVector3f();
		try {

			ISurface surface = m_picker.getCurrentSurface();
			ISurface initialSurface =
				Figure3DHelper.getAncestor3D(m_helper.getReference())
					.getSurface();

			Position3D newPos; // = m_helper.getReferencePosition3D();

			// TODO use surface or initialSurface to enable or prevent jumping
			
			// if (surface != initialSurface
			// && !(m_helper.getReference() instanceof IFigure3D)) {
			newPos = m_helper.getReferencePosition3D(surface.getHost());
			// } else {
			// dummy = m_helper.getReferencePosition3D();
			// }
			// else
			{

				// IFigure3D host =
				// Figure3DHelper.getAncestor3D(m_hostFigure.getParent());
				// Position3D dummy =
				// Position3DUtil.createRelativePosition(host);
				// Position3D feedbackPosition = i_feedback.getPosition3D();
				//
				// dummy.setPosition(feedbackPosition);
				//
				if (i_surfaceMoveDelta != null) {
					surfaceRelativeLocation.set(newPos.getLocation3D());
					surfaceRelativeLocation.translate(i_surfaceMoveDelta.x,
						i_surfaceMoveDelta.y, 0);
					newPos.setLocation3D(surfaceRelativeLocation);
				}

				if (i_surfaceSizeDelta != null) {
					size.set(newPos.getSize3D());
					size.translate(i_surfaceSizeDelta.width,
						i_surfaceSizeDelta.height, 0);

					newPos.setSize3D(size);
				}

				// log.info(feedbackPosition.toString());
			}

			i_feedback.getPosition3D().setPosition(newPos);
		} finally {
			Draw3DCache.returnVector3f(surfaceRelativeLocation, size);
		}
	}

	/**
	 * Update feedback position in case of rotation or 3D move.
	 * 
	 * @param i_feedback3d
	 * @param i_newPosition in world coordinates
	 * @param i_sizeDelta3D
	 * @param i_rotationDelta3D
	 * @param i_surface the surface to which the depth move delta is relative
	 * @see ChangeBounds3DRequest#getTransformedPosition(Position3D)
	 */
	public void updateFeedbackPosition(IFigure3D i_feedback,
		IVector3f i_newPosition, IVector3f i_rotationDelta3D) {

		if (log.isLoggable(Level.INFO)) {
			log.info("Move to " + i_newPosition + ", Rot " + i_rotationDelta3D); //$NON-NLS-1$ //$NON-NLS-2$
		}

		if (i_feedback == null)
			throw new NullPointerException("i_feedback must not be null");

		try {

			Position3D rotatedNewPosition = i_feedback.getPosition3D();

			if (i_newPosition != null) { // && i_moveDelta3D !=
											// IVector3f.NULLVEC3f) {
				rotatedNewPosition.setLocation3D(i_newPosition);
			}
			if (i_rotationDelta3D != null
				&& i_rotationDelta3D != IVector3f.NULLVEC3f) {
				
				// i_rotationDelta3D is a rotation around the world x/y/z-axis
				// we want to rotate around the figure relative x/y/z axis
				
				Matrix4f deltaMatrix = Math3D.rotate(i_rotationDelta3D, IMatrix4f.IDENTITY, null);
				Math3D.mul( i_feedback.getPosition3D().getAbsoluteRotationMatrix(), deltaMatrix, deltaMatrix);
				Vector3f relV = Math3D.rotationMatrixToEulerAngles(deltaMatrix, null);
				
				rotatedNewPosition.setRotation3D( relV);
				
				
//				Vector3f v3f =
//					new Vector3fImpl(rotatedNewPosition.getRotation3D());
//				Math3D.add(v3f, i_rotationDelta3D, v3f);
//				rotatedNewPosition.setRotation3D(v3f);
			}
			i_feedback.getPosition3D().setPosition(rotatedNewPosition);
		} finally {
		}

	}

	/**
	 * Sets the host figure of this feedback helper.
	 * 
	 * @param i_hostFigure the host figure
	 */
	public void setHostFigure(IFigure i_hostFigure) {
		if (i_hostFigure == null) // parameter precondition
			throw new NullPointerException("i_hostFigure must not be null");

		m_helper = new LocatorHelper(i_hostFigure);

		// m_hostFigure = i_hostFigure;

		UpdateManager updateManager = i_hostFigure.getUpdateManager();
		if (updateManager instanceof PickingUpdateManager3D)
			m_picker = ((PickingUpdateManager3D) updateManager).getPicker();
		else {
			throw new IllegalArgumentException(
				"figure's update manager must be instanceof PickingUpdateManager3D, was "
					+ updateManager);
		}
	}

	/**
	 * Calls {@link #setInitialFeedbackPosition(IFigure3D, ISurface)} with the
	 * current surface under the mouse cursor (i.e. the picker's current
	 * surface). As the surface is always updated to the current surface under
	 * the mouse cursor, the feedback figure automatically "jumps" to match the
	 * position of the new surface. This is the default mechanism for most
	 * operations, it can be avoided by calling
	 * {@link #setInitialFeedbackPosition(IFigure3D, ISurface)} with a
	 * non-changing surface, e.g., the surface of the figure or the start
	 * surface.
	 * 
	 * @param i_feedback the feedback figure to modify
	 */
	public void setInitialFeedbackPosition(IFigure3D i_feedback) {
		setInitialFeedbackPosition(i_feedback, m_picker.getCurrentSurface());
	}

	/**
	 * Sets the bounds of the given feedback figure to the bounds of the host
	 * figure, expanded by <code>0.01f</code>, relative to the given surface.
	 * 
	 * @param i_feedback
	 * @param surface
	 */
	public void setInitialFeedbackPosition(IFigure3D i_feedback,
		ISurface surface) {

		// if (log.isLoggable(Level.INFO)) {
		//			log.info("set initial feedback position"); //$NON-NLS-1$
		// }

		ISurface initialSurface =
			Figure3DHelper.getAncestor3D(m_helper.getReference()).getSurface();

		Position3D refPosition = m_helper.getReferencePosition3D();

		if (surface != initialSurface) {
			Position3D result =
				Position3DUtil.createRelativePosition(surface.getHost());
			result.setSize3D(refPosition.getSize3D());
			refPosition = result;

		}

		i_feedback.getPosition3D().setPosition(refPosition);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * This method is a duplicate of the original one, using the newly defined
	 * anchor here.
	 * 
	 * @see org.eclipse.gef.editpolicies.FeedbackHelper#update(org.eclipse.draw2d.ConnectionAnchor,
	 *      org.eclipse.draw2d.geometry.Point)
	 */
	@Override
	public void update(ConnectionAnchor anchor, Point p) {

		if (anchor != null)
			setAnchor(anchor);
		else {
			ISurface surface = m_picker.getCurrentSurface();

			Vector3f w = Draw3DCache.getVector3f();
			try {
				surface.getWorldLocation(p, w);
				// log.info(w.toString());
				m_dummyAnchor.setLocation3D(w);
				setAnchor(m_dummyAnchor);
			} finally {
				Draw3DCache.returnVector3f(w);
			}
		}
	}

}
