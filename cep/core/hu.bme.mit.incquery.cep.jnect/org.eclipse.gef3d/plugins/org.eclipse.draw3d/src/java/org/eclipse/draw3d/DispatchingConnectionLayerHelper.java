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
package org.eclipse.draw3d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * Helper class for {@link DispatchingConnectionLayer} (and other connection
 * layers used in GEF3D) dispatching the layers. The functionality was moved to
 * this helper class which acts as an delegator since several connection layer
 * classes use it and different class hierarchies must be used.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Apr 2, 2008
 */
public class DispatchingConnectionLayerHelper {

	public static class ConnectionConstraints {
		public Object constaint;

		public int index;

		/**
		 * @param i_constaint
		 * @param i_index
		 */
		public ConnectionConstraints(Object i_constaint, int i_index) {
			constaint = i_constaint;
			index = i_index;
		}

	}

	public final static String CONSTRAINT_LAYER = "CONSTRAINT_LAYER";

	/**
	 * Logger for this class
	 */
	private static final Logger log =
		Logger.getLogger(DispatchingConnectionLayerHelper.class.getName());

	/**
	 * layer cache, maps 3D figure to layer
	 */
	private final Map<IFigure3D, ConnectionLayer> distributedLayersMap =
		new HashMap<IFigure3D, ConnectionLayer>();

	// private final List<ConnectionLayer> distributedLayers = new
	// ArrayList<ConnectionLayer>(10000);

	private final ConnectionLayerFactory factory;

	private final ConnectionLayer host;

	private final Map<Connection, ConnectionConstraints> pendingConnections =
		new HashMap<Connection, ConnectionConstraints>();

	/**
	 * While connections are pending, they are added to this parent (if not
	 * null). The parent may be configured in order to provide settings during
	 * set up of child, e.g. map mode information for GMF figures.
	 */
	private IFigure pendingParent;

	/**
	 * @param i_host
	 */
	public DispatchingConnectionLayerHelper(ConnectionLayer i_host,
			ConnectionLayerFactory i_factory) {
		host = i_host;
		factory = i_factory;
		pendingParent = null;
	}
	
	public void setPendingParent(IFigure fig) {
		pendingParent = fig;
	}

	/**
	 * Adds a connection to the appropriate layer. If no layer is found yet, the
	 * connection is marked as pending at added later in
	 * {@link #dispatchPendingConnections()}.
	 * 
	 * @return true, if helper could handle this kind of figure
	 * @see org.eclipse.draw2d.ConnectionLayer#add(org.eclipse.draw2d.IFigure,
	 *      java.lang.Object, int)
	 */
	public boolean add(IFigure i_figure, Object i_constraint, int i_index) {
		if (i_constraint != CONSTRAINT_LAYER && i_figure instanceof Connection
			&& !(i_figure instanceof IFigure3D)) {

			IFigure3D fig3DHost = findConectionLayerHost((Connection) i_figure);
			ConnectionLayer distributedLayer =
				getConnectionLayerOf3DHost(fig3DHost);

			if (distributedLayer != null) {
				// if (distributedLayer.getConnectionRouter()==null) {
				distributedLayer
					.setConnectionRouter(host.getConnectionRouter());
				// }
				distributedLayer.add(i_figure, i_constraint, i_index);
				// if it was added before:
				pendingConnections.remove(i_figure);
				fig3DHost.invalidateTree(); // repaint 2D content
			} else {
				pendingConnections.put((Connection) i_figure,
					new ConnectionConstraints(i_constraint, i_index));
				if (pendingParent!=null) {
					pendingParent.add(i_figure);
				}

			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Dispatches connections, that is connections not added to a connection
	 * layer associated with a figure3D are now assigned to one of these layers.
	 */
	public void dispatchPendingConnections() {
		if (!pendingConnections.isEmpty()) {
			ArrayList<IFigure> dispatchedConnections = new ArrayList<IFigure>();

			IFigure3D fig3DHost;
			ConnectionLayer distributedLayer;

			for (Entry<Connection, ConnectionConstraints> entry : pendingConnections
				.entrySet()) {
				Connection connection = entry.getKey();
				ConnectionConstraints cc = entry.getValue();

				fig3DHost = findConectionLayerHost(connection);
				distributedLayer = getConnectionLayerOf3DHost(fig3DHost);

				if (distributedLayer != null) {
					distributedLayer.setConnectionRouter(host
						.getConnectionRouter());
					dispatchedConnections.add(connection);
					distributedLayer.add(connection, cc.constaint, cc.index);
					rewire(connection);
					distributedLayer.validate();
					fig3DHost.invalidateTree(); // repaint 2D content
				}
			}
			for (IFigure conn : dispatchedConnections) {
				pendingConnections.remove(conn);
			}
		}
	}

	/**
	 * Finds an appropriate layer for a given connection. If no layer is found,
	 * it is created lazily. Note that only layers for connections with source
	 * and target placed on the same surface, i.e. 3D figure, can be added to a
	 * layer.
	 * 
	 * @param i_connection
	 * @return 3D figure hosting connection layer or null, if connection has no
	 *         3D ancestor
	 * @throws IllegalArgumentException if connection has different 3D hosts
	 */
	protected IFigure3D findConectionLayerHost(Connection i_connection) {

		ConnectionAnchor anchor;
		anchor = i_connection.getSourceAnchor();
		IFigure source = (anchor != null) ? anchor.getOwner() : null;
		anchor = i_connection.getTargetAnchor();
		IFigure target = (anchor != null) ? anchor.getOwner() : null;

		IFigure3D sourceAncestor3D = Figure3DHelper.getAncestor3D(source);
		IFigure3D targetAncestor3D = Figure3DHelper.getAncestor3D(target);

		// a 2D connection can only be handled by a layer, if its source
		// and target are on the same surface
		if (sourceAncestor3D != targetAncestor3D) {
			log.severe("2D connections with different 3D ancestors");

			throw new IllegalArgumentException(
				"Connection's anchors have different 3D ancestors");
		}

		return sourceAncestor3D;
	}

	/**
	 * Returns (2D) connection layer associated with given 3D figure.
	 * 
	 * @param fig3DHost
	 */
	private ConnectionLayer getConnectionLayerOf3DHost(IFigure3D fig3DHost) {
		if (fig3DHost == null)
			return null;
		ConnectionLayer layer;
		layer = distributedLayersMap.get(fig3DHost);
		if (layer == null) { // create layer lazily
			layer = fig3DHost.getConnectionLayer(factory);
			if (layer != null) {
				host.add(layer, CONSTRAINT_LAYER);
				distributedLayersMap.put(fig3DHost, layer);
			} else {
				log.warning("Cannot create connection layer for figure "
					+ fig3DHost);
			}
		}
		return layer;
	}

	/**
	 * Paints the children of the host connection layer. Since the distributed
	 * connection layers are already painted by their host 3D figures (see
	 * {@link Figure3DHelper#paintChildren(Graphics)}), they are <em>not</em>
	 * painted here for performance reasons.
	 * 
	 * @param i_graphics the graphics object to paint on
	 */
	public void paintChildren(Graphics i_graphics) {

		@SuppressWarnings("unchecked")
		List<IFigure> children = host.getChildren();
		Rectangle clip = Rectangle.SINGLETON;
		for (IFigure child: children) {
			if (!(child instanceof ConnectionLayer) // if child is a connection,
				// is it painted by its 3D host figure
				&& child.isVisible() // only paint if visible
				&& child.intersects(i_graphics.getClip(clip)) // only paint
			// if it intersects
			) {
				i_graphics.clipRect(child.getBounds());
				child.paint(i_graphics);
				i_graphics.restoreState();
			}
		}
	}

	/**
	 * @return true, if helper could handle this kind of figure
	 * @see org.eclipse.draw2d.ConnectionLayer#remove(org.eclipse.draw2d.IFigure)
	 */
	public boolean remove(IFigure i_figure) {
		if (i_figure instanceof Connection && !(i_figure instanceof IFigure3D)) {

			if (pendingConnections.remove(i_figure) == null) {
				IFigure3D fig3DHost =
					findConectionLayerHost((Connection) i_figure);
				ConnectionLayer distributedLayer =
					getConnectionLayerOf3DHost(fig3DHost);

				if (distributedLayer != null) {
					distributedLayer.remove(i_figure);
					fig3DHost.invalidateTree(); // repaint 2D content
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Rewire the connection so that it is correctly set up. Because no parent
	 * was set in add(), the setup of the connection has possibly failed before
	 * (parent was null). Look at PolylineConnection#setSourceAnchor() and
	 * PolylineConnection#setTargetAnchor() to understand this.
	 * 
	 * @param figure
	 */
	private void rewire(IFigure figure) {

		if (figure instanceof Connection) {
			Connection conn = (Connection) figure;

			ConnectionAnchor sourceAnchor = conn.getSourceAnchor();
			ConnectionAnchor targetAnchor = conn.getTargetAnchor();

			conn.setSourceAnchor(null);
			conn.setTargetAnchor(null);

			conn.setSourceAnchor(sourceAnchor);
			conn.setTargetAnchor(targetAnchor);
		}
	}

	/**
	 * @see org.eclipse.draw2d.ConnectionLayer#setConnectionRouter(org.eclipse.draw2d.ConnectionRouter)
	 */
	public void setConnectionRouter(ConnectionRouter i_router) {
		for (ConnectionLayer distributedLayer : distributedLayersMap.values()) {
			// for (ConnectionLayer distributedLayer : distributedLayers) {
			if (distributedLayer.getConnectionRouter() == null) {
				distributedLayer.setConnectionRouter(i_router);
			}
		}

	}

	/**
	 * @see org.eclipse.draw2d.Figure#validate()
	 */
	public void validate() {
		dispatchPendingConnections();

		for (ConnectionLayer layer : distributedLayersMap.values()) {
			// for (ConnectionLayer layer : distributedLayers) {
			layer.validate();
		}
	}

}
