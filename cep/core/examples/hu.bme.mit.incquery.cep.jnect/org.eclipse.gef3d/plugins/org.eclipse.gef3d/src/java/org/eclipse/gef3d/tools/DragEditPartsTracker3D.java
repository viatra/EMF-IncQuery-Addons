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
package org.eclipse.gef3d.tools;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.Platform;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw3d.Figure3DHelper;
import org.eclipse.draw3d.IFigure3D;
import org.eclipse.draw3d.ISurface;
import org.eclipse.draw3d.MouseEvent3D;
import org.eclipse.draw3d.PlaneSurface;
import org.eclipse.draw3d.RenderContext;
import org.eclipse.draw3d.ShapeFigure3D;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;
import org.eclipse.draw3d.shapes.CuboidFigureShape;
import org.eclipse.draw3d.shapes.Shape;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.tools.DragEditPartsTracker;
import org.eclipse.gef3d.requests.ChangeBounds3DRequest;
import org.eclipse.gef3d.requests.ChangeBounds3DRequest.Modifier3D;
import org.eclipse.gef3d.ui.parts.GraphicalViewer3DImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

/**
 * DragEditPartsTracker3D There should really be more documentation here. The
 * (2D) tracker knows
 * <ol>
 * <li>the mouse start location: {@link #getStartLocation()}</li>
 * <li>the current mouse location: {@link #getLocation()}, via
 * {@link #getCurrentInput()}</li>
 * </ol>
 * We need some more information:
 * <ol>
 * <li>the start surface -- stored in {@link #setStartLocation(Point)} using the
 * current mouse event 3D</li>
 * <li>the screen start location -- stored in {@link #setStartLocation(Point)}
 * using the current mouse event 3D. Note: The start location of the mouse is
 * already converted to a surface location!</li>
 * <li>the start world location -- stored in {@link #setStartLocation(Point)}
 * using the current mouse event 3D. Note: We cannot calculate this location in
 * a preceding call, as the camera position and direction may have changed!</li>
 * </ol>
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @version $Revision$
 * @since Apr 15, 2011
 */
public class DragEditPartsTracker3D extends DragEditPartsTracker {
	/**
	 * Logger for this class
	 */
	// @SuppressWarnings("unused") //$NON-NLS-1$
	private static final Logger log = Logger
		.getLogger(DragEditPartsTracker3D.class.getName());

	/**
	 * Key modifier for cloning. It's ALT on Mac, and CTRL on all other
	 * platforms.
	 */
	static final int MODIFIER_3DDRAG;

	static {
		if (Platform.OS_MACOSX.equals(Platform.getOS()))
			MODIFIER_3DDRAG = SWT.COMMAND;
		else
			MODIFIER_3DDRAG = SWT.ALT;
	}

	/**
	 * The mouse sensitivity used when computing the rotation based on mouse
	 * movement
	 * 
	 * @todo make this configurable
	 */
	public static float ROTATION_SENSITIVITY = 0.01f;

	public static float ROTATION_THRESHOLD = 20;

	/**
	 * The mouse event 3D, cached in order to retrieve camera and surface
	 * information.
	 */
	protected MouseEvent3D currentMouseEvent3D = null;

	/**
	 * The start world location.
	 */
	protected IVector3f startWorldLocation = null;

	/**
	 * The start surface.
	 */
	protected ISurface startSurface = null;

	/**
	 * The real start screen location
	 */
	protected Point startScreenLocation = null;

	/**
	 * The surface used for changing the depth of a figure
	 */
	protected PlaneSurface depthSurface;

	/**
	 * Debug figure
	 */
	protected ShapeFigure3D debugDepthSurfaceFigure = new ShapeFigure3D() {
		@Override
		protected Shape createShape() {
			return new CuboidFigureShape(this, false);
		}
	};

	/**
	 * @param i_sourceEditPart
	 */
	public DragEditPartsTracker3D(EditPart i_sourceEditPart) {
		super(i_sourceEditPart);

		// configure the debug figure
		Color c = Display.getCurrent().getSystemColor(SWT.COLOR_BLUE);
		debugDepthSurfaceFigure.setForegroundColor(c);
		c = Display.getCurrent().getSystemColor(SWT.COLOR_MAGENTA);
		debugDepthSurfaceFigure.setBackgroundColor(c);
		debugDepthSurfaceFigure.setAlpha(0x77);
	}

	/**
	 * Called in entry methods to clear the current mouse event 3D.
	 */
	protected void popMouseEvent3D() {
		currentMouseEvent3D = null;
	}

	/**
	 * Called in entry methods to set the current mouse event 3D.
	 * 
	 * @param i_me
	 */
	protected void pushMouseEvent3D(MouseEvent i_me) {
		if (i_me instanceof MouseEvent3D) {
			currentMouseEvent3D = (MouseEvent3D) i_me;
		} else {
			currentMouseEvent3D = null;
		}
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Implementation note: This is, again,a dirty hack: when the start location
	 * is updated to the current mouse location, e.g. in handleMove(), we want
	 * to keep track of the start world location and surface as well
	 * </p>
	 * 
	 * @see org.eclipse.gef.tools.AbstractTool#setStartLocation(org.eclipse.draw2d.geometry.Point)
	 */
	@Override
	protected void setStartLocation(Point i_p) {

		if (log.isLoggable(Level.INFO)) {
			log.info("update drag start location"); //$NON-NLS-1$
		}

		if (currentMouseEvent3D != null) {
			startSurface = currentMouseEvent3D.getSurface();
			startWorldLocation = currentMouseEvent3D.getWorldLocation();
			startScreenLocation = currentMouseEvent3D.getScreenLocation();

			
			
			
			
			Vector3f depthRotation = startSurface.getSurfaceRotation(null);
			
			Vector3f b = new Vector3fImpl(0,0,-1);
			IVector3f no = startSurface.getNormal();
			
			Math3D.eulerAngles(no, b, depthRotation);
			depthRotation.setX((float) (depthRotation.getX() - Math.PI / 2f));
//			depthRotation.setY((float) (depthRotation.getY() + Math.PI / 2f));
////			depthRotation.setZ((float) (depthRotation.getZ() + Math.PI / 2f));

			if (Math3D.equals(depthRotation, IVector3f.NULLVEC3f, 0.001f)) {
				depthRotation.setX(Math3D.PI/2f);
			}
			
			depthSurface = new PlaneSurface();
			depthSurface.getPosition3D().setLocation3D(startWorldLocation);
			depthSurface.getPosition3D().setRotation3D(depthRotation);
			depthSurface.getPosition3D().setSize3D(
				new Vector3fImpl(20, 40, 5));

			if (getCurrentViewer() instanceof GraphicalViewer3DImpl) {
				GraphicalViewer3DImpl v =
					(GraphicalViewer3DImpl) getCurrentViewer();
				if (v.getLightweightSystem3D().isDebug()) {
					debugDepthSurfaceFigure.getPosition3D().setPosition(
						depthSurface.getPosition3D());
					debugDepthSurfaceFigure.setVisible(true);

					v.getLightweightSystem3D().addDebugFigure(
						debugDepthSurfaceFigure);
				}

			}

			if (log.isLoggable(Level.INFO)) {
				log.info("depthSurface=" + depthSurface + ", startSurface=" + startSurface); //$NON-NLS-1$
			}
		} else {
			// better no info, than wrong info
			startWorldLocation = null;
			startSurface = null;
			startScreenLocation = null;
			depthSurface = null;
		}
		super.setStartLocation(i_p);
	}

	public void deactivate() {
		if (getCurrentViewer() instanceof GraphicalViewer3DImpl) {
			GraphicalViewer3DImpl v =
				(GraphicalViewer3DImpl) getCurrentViewer();
			v.getLightweightSystem3D().removeDebugFigure(
				debugDepthSurfaceFigure);
		}
	};

	/**
	 * {@inheritDoc}
	 * <p>
	 * This 3D method creates an {@link ChangeBounds3DRequest} instead of the 2D
	 * {@link ChangeBoundsRequest}.
	 * </p>
	 * 
	 * @see org.eclipse.gef.tools.DragEditPartsTracker#createTargetRequest()
	 */
	@Override
	protected Request createTargetRequest() {
		Object type = isCloneActive() ? REQ_CLONE : REQ_MOVE;
		ChangeBounds3DRequest cbr = new ChangeBounds3DRequest(type);
		cbr.setStartSurface(startSurface);
		return cbr;
	}

	/**
	 * Replaces super method and calls {@link #setStartLocation(Point)} instead
	 * of directly manipulating the fields (seems to be a design bug in the
	 * super method).
	 * 
	 * @see org.eclipse.gef.tools.AbstractTool#mouseDown(org.eclipse.swt.events.MouseEvent,
	 *      org.eclipse.gef.EditPartViewer)
	 */
	@Override
	public void mouseDown(MouseEvent me, EditPartViewer viewer) {
		if (!isViewerImportant(viewer))
			return;
		setViewer(viewer);

		pushMouseEvent3D(me);
		try {
			getCurrentInput().setInput(me);
			getCurrentInput().setMouseButton(me.button, true);

			setStartLocation(new Point(me.x, me.y));

			handleButtonDown(me.button);

		} finally {
			popMouseEvent3D();
		}
	}

	/**
	 * Calls super method, but stores 3D mouse event first.
	 * 
	 * @see org.eclipse.gef.tools.AbstractTool#mouseDrag(org.eclipse.swt.events.MouseEvent,
	 *      org.eclipse.gef.EditPartViewer)
	 */
	@Override
	public void mouseDrag(MouseEvent me, EditPartViewer viewer) {
		pushMouseEvent3D(me);
		try {
			super.mouseDrag(me, viewer);
		} finally {
			popMouseEvent3D();
		}
	}

	/**
	 * Convenience method, returns ancestor 3D of source edit part#s figure.
	 * 
	 * @return may return null
	 */
	IFigure3D getAncestor3D() {
		if (getSourceEditPart() instanceof GraphicalEditPart) {
			return Figure3DHelper
				.getAncestor3D(((GraphicalEditPart) getSourceEditPart())
					.getFigure());
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.tools.DragEditPartsTracker#updateTargetRequest()
	 */
	@Override
	protected void updateTargetRequest() {
		super.updateTargetRequest();

		ChangeBounds3DRequest cbr = (ChangeBounds3DRequest) getTargetRequest();
		cbr.setMoveDepthDelta3D(IVector3f.NULLVEC3f);
		cbr.setRotationDelta3D(IVector3f.NULLVEC3f);
		cbr.setModifier3D(Modifier3D.NONE);

		// update 3D values
		if (currentMouseEvent3D != null) {
			cbr.setLocation3D(currentMouseEvent3D.getWorldLocation());
			if (getCurrentInput().isModKeyDown(MODIFIER_3DDRAG)) {
				cbr.setModifier3D(getCurrentInput().isShiftKeyDown()
					? Modifier3D.ROTATION : Modifier3D.DEPTH);

				// clear 2D deltas
				cbr.setMoveDelta(NO_DELTA);
				cbr.setSizeDelta(NO_DELTA_SIZE);

				switch (cbr.getModifier3D()) {
				case DEPTH:
					cbr.setMoveDepthDelta3D(computeDepthDelta3D());
					break;
				case ROTATION:
					cbr.setRotationDelta3D(computeRotationDelta3D());
					break;
				}
			}
		}
	}

	final static Point NO_DELTA = new Point(0, 0);

	final static Dimension NO_DELTA_SIZE = new Dimension(0, 0);

	/**
	 * The move delta 3D, using the start surface to calculate the delta.
	 * 
	 * @return
	 */
	protected IVector3f computeMoveDelta3D() {
		Vector3f end =
			currentMouseEvent3D.computeWorldLocation(
				currentMouseEvent3D.getScreenLocation(), startSurface);
		Math3D.sub(end, startWorldLocation, end);
		return end;
	}

	/**
	 * The depth delta, using the depth surface to calculate the delta.
	 * 
	 * @return
	 */
	protected IVector3f computeDepthDelta3D() {
		if (log.isLoggable(Level.INFO)) {
			log.info("compute depth with depthSurface=" + depthSurface); //$NON-NLS-1$
		}

		Vector3f end =
			currentMouseEvent3D.computeWorldLocation(
				currentMouseEvent3D.getScreenLocation(), depthSurface);

		startSurface.getSurfaceLocation3D(end, end);

		if (log.isLoggable(Level.INFO)) {
			log.info("new depth: " + end.getZ()); //$NON-NLS-1$
		}
		// end.setZ(end.getZ()-depthSurface.getPosition3D().getLocation3D().getZ());
		end.setY(0);
		end.setX(0);

//		startSurface.getWorldLocation(end, end);

		return end;
	}

	/**
	 * The rotation delta, using the screen x and y deltas to calculate a
	 * rotation delta around y axis (x-delta) and x axis (y-delta)
	 * 
	 * @return
	 */
	protected IVector3f computeRotationDelta3D() {
		Dimension delta =
			currentMouseEvent3D.getScreenLocation().getDifference(
				startScreenLocation);
		Vector3f rotationDelta = new Vector3fImpl();
		// if (RESTRICT_MOUSE_ROTATION) {
		// if (delta.width > delta.height) {
		// rotationDelta.setY(ROTATION_SENSITIVITY * (float) delta.width);
		// } else {
		// rotationDelta.setX(ROTATION_SENSITIVITY * (float) delta.height);
		// }
		// } else {
		// rotationDelta.setX(ROTATION_SENSITIVITY * (float) delta.height);
		// rotationDelta.setY(ROTATION_SENSITIVITY * (float) delta.width);
		//
		// }

		if (Math.abs(delta.width) > ROTATION_THRESHOLD) {
			rotationDelta.setY(ROTATION_SENSITIVITY
				* (float) (delta.width - ROTATION_THRESHOLD));
		}
		if (Math.abs(delta.height) > ROTATION_THRESHOLD) {
			rotationDelta.setX(ROTATION_SENSITIVITY
				* (float) (delta.height - ROTATION_THRESHOLD));
		}

		return rotationDelta;
	}
}
