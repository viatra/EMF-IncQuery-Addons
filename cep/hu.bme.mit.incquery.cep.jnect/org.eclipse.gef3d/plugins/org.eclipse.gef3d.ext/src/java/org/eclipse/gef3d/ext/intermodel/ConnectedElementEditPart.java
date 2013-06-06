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

package org.eclipse.gef3d.ext.intermodel;

import java.util.List;
import java.util.logging.Logger;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw3d.ChopboxAnchor3D;
import org.eclipse.draw3d.Figure3DHelper;
import org.eclipse.draw3d.IFigure3D;
import org.eclipse.draw3d.ISurface;
import org.eclipse.draw3d.geometry.IBoundingBox;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;
import org.eclipse.draw3d.util.Draw3DCache;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef3d.ext.IConnectionAnchorFactory;
import org.eclipse.gef3d.ext.SingletonConnectionAnchorFactory;
import org.eclipse.swt.graphics.Color;

/**
 * ConnectedElementEditPart.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 22.01.2008
 */
public class ConnectedElementEditPart extends AbstractGraphicalEditPart
		implements NodeEditPart {
	private static final Color COLOR = ColorConstants.green;

	/**
	 * Logger for this class
	 */
	private static final Logger log =
		Logger.getLogger(ConnectedElementEditPart.class.getName());

	/**
	 * Returns the center point of a figure (2D or 3D).
	 * 
	 * @param i_fig the figure
	 * @param io_result the result vector, if <code>null</code>, a new vector
	 *            will be returned
	 * @return the center point
	 */
	public static IVector3f getTopCenter3D(IFigure i_fig, Vector3f io_result) {

		if (i_fig instanceof IFigure3D) {

			Vector3f result = io_result;
			if (result == null)
				result = new Vector3fImpl();

			Vector3f location = Draw3DCache.getVector3f();
			Vector3f size = Draw3DCache.getVector3f();
			try {
				IFigure3D fig = (IFigure3D) i_fig;
				IBoundingBox bb = fig.getBounds3D();
				bb.getLocation(location);
				bb.getSize(size);

				result.setX(location.getX() + size.getX() / 2f);
				result.setY(location.getY() + size.getY());
				result.setZ(location.getZ() + size.getZ() / 2f);

				return result;
			} finally {
				Draw3DCache.returnVector3f(location, size);
			}
		} else {
			if (i_fig instanceof Connection) {
				if (!(i_fig instanceof IFigure3D)) {
					Connection conn = (Connection) i_fig;
					Point midpoint = conn.getPoints().getMidpoint();

					IFigure3D host = Figure3DHelper.getAncestor3D(i_fig);
					ISurface surface = host.getSurface();

					return surface.getWorldLocation(midpoint, io_result);
				} else {
					throw new UnsupportedOperationException(
						"getCenter3D not implemented for 3D connections yet");
				}
			} else {
				Rectangle rect = i_fig.getBounds();
				Point point = new Point(rect.x + rect.width / 2, rect.y);

				IFigure3D host = Figure3DHelper.getAncestor3D(i_fig);
				ISurface surface = host.getSurface();

				return surface.getWorldLocation(point, io_result);
			}
		}
	}

	/**
	 * Listener to connected element (and its representing figure) in order to
	 * update position of connected element figure (the figure controlled by
	 * this edit part. Note: We also could have implemented this interface by
	 * this editpart, but we follow the principle of preferring composition over
	 * inheritance.
	 */
	IElementAdapterListener adapterListener;

	IConnectionAnchorFactory m_anchorFactory;

	/**
	 * 
	 */
	public ConnectedElementEditPart(ConnectedElementAdapter i_model) {
		if (i_model == null) // parameter precondition
			throw new NullPointerException("i_model must not be null");

		setModel(i_model);

		adapterListener = new IElementAdapterListener() {

			public void figureMoved(IFigure i_fig) {
				refreshVisuals();
			}

		};

		// if (log.isLoggable(Level.INFO)) {
		// log
		// .info("ConnectedElementAdapter - Created connection adapter for" +
		// i_model); //$NON-NLS-1$
		// }
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#activate()
	 */
	@Override
	public void activate() {
		super.activate();
		getConnectedElementAdapter().addElementAdapterListener(adapterListener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		// TODO implement method TraceableElementEditPart.createEditPolicies

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {

		IFigure3D fig = new ConnectedElementFigure();
		m_anchorFactory =
			new SingletonConnectionAnchorFactory(new ChopboxAnchor3D(fig));

		relocateFigure(fig);

		return fig;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#deactivate()
	 */
	@Override
	public void deactivate() {
		getConnectedElementAdapter().removeElementAdapterListener(
			adapterListener);
		super.deactivate();
	}

	/**
	 * Convenience method, returns casted model.
	 * 
	 * @return
	 */
	public ConnectedElementAdapter getConnectedElementAdapter() {
		return (ConnectedElementAdapter) getModel();
	}

	/**
	 * Convenience method.
	 * 
	 * @return
	 */
	protected GraphicalEditPart getModelEditPart() {
		return getConnectedElementAdapter().getElementEditPart();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelSourceConnections()
	 */
	@Override
	protected List getModelSourceConnections() {
		return getConnectedElementAdapter().getSourceConnections();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelTargetConnections()
	 */
	@Override
	protected List getModelTargetConnections() {
		return getConnectedElementAdapter().getTargetConnections();
	}

	/**
	 * Delegate method
	 * 
	 * @param i_connection
	 * @return
	 * @see org.eclipse.gef3d.ext.IConnectionAnchorFactory#getSourceConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
	 */
	public ConnectionAnchor getSourceConnectionAnchor(
		ConnectionEditPart i_connection) {
		return m_anchorFactory.getSourceConnectionAnchor(i_connection);
	}

	/**
	 * Delegate method
	 * 
	 * @param i_request
	 * @return
	 * @see org.eclipse.gef3d.ext.IConnectionAnchorFactory#getSourceConnectionAnchor(org.eclipse.gef.Request)
	 */
	public ConnectionAnchor getSourceConnectionAnchor(Request i_request) {
		return m_anchorFactory.getSourceConnectionAnchor(i_request);
	}

	/**
	 * Delegate method
	 * 
	 * @param i_connection
	 * @return
	 * @see org.eclipse.gef3d.ext.IConnectionAnchorFactory#getTargetConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
	 */
	public ConnectionAnchor getTargetConnectionAnchor(
		ConnectionEditPart i_connection) {
		return m_anchorFactory.getTargetConnectionAnchor(i_connection);
	}

	/**
	 * Delegate method
	 * 
	 * @param i_request
	 * @return
	 * @see org.eclipse.gef3d.ext.IConnectionAnchorFactory#getTargetConnectionAnchor(org.eclipse.gef.Request)
	 */
	public ConnectionAnchor getTargetConnectionAnchor(Request i_request) {
		return m_anchorFactory.getTargetConnectionAnchor(i_request);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#refreshVisuals()
	 */
	@Override
	protected void refreshVisuals() {
		relocateFigure((IFigure3D) getFigure());
	}

	/**
	 * @param fig
	 */
	private void relocateFigure(IFigure3D fig) {

		Vector3f size = Draw3DCache.getVector3f();
		Vector3f topCenter = Draw3DCache.getVector3f();
		try {
			size.set(5, 5, 5);
			fig.getPosition3D().setSize3D(size);

			IFigure connectedFig = getModelEditPart().getFigure();
			getTopCenter3D(connectedFig, topCenter);

			size.scale(1 / 2f);
			Math3D.sub(topCenter, size, topCenter);

			fig.getPosition3D().setLocation3D(topCenter);
		} finally {
			Draw3DCache.returnVector3f(size, topCenter);
		}
	}

}
