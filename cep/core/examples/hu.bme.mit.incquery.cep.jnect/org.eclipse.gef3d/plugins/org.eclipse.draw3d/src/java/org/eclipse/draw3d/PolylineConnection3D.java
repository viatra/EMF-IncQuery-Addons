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
package org.eclipse.draw3d;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.draw2d.AnchorListener;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.RoutingListener;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw3d.geometry.Vector3fImpl;

/**
 * PolylineConnection3D is the 3D version of {@link PolylineConnection} with
 * exactly the same features. Instead of a 2D connection router, a 3D router is
 * used, and, of course, it extends Polyline3D instead of Polyline.
 * <p>
 * Internal note: This class is a copy of PolylineConnection, modifications are
 * deocumented.
 * 
 * @author IBM Corporation (original 2D version)
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 26.11.2007
 * @see org.eclipse.draw2d.PolylineConnection
 */
public class PolylineConnection3D extends Polyline3D implements Connection3D,
		AnchorListener {

	/**
	 * Logger for this class
	 */
	@SuppressWarnings("unused")
	private static final Logger log =
		Logger.getLogger(PolylineConnection3D.class.getName());

	/** Start anchor, just as in PolylineConnection */
	private ConnectionAnchor startAnchor;

	/** End anchor, just as in PolylineConnection */
	private ConnectionAnchor endAnchor;

	/**
	 * Connection router, just as in PolylineConnection, except it is a 3D
	 * router here.
	 */
	private ConnectionRouter connectionRouter = ConnectionRouter3D.NULL;

	/** Start decoration, just as in PolylineConnection */
	private RotatableDecoration startArrow;

	/** End decoration, just as in PolylineConnection */
	private RotatableDecoration endArrow;

	/* no more attributes, just as in PolylineConnection */

	/* Init method, just as in PolylineConnection */
	{
		setLayoutManager(new DelegatingLayout());
		addPoint(new Vector3fImpl(0, 0, 0));
		addPoint(new Vector3fImpl(1, 1, 1));
	}

	/**
	 * Hooks the source and target anchors.
	 * 
	 * @see Figure#addNotify()
	 * @see PolylineConnection#addNotify()
	 */
	@Override
	public void addNotify() {
		super.addNotify();
		hookSourceAnchor();
		hookTargetAnchor();
	}

	/**
	 * Appends the given routing listener to the list of listeners.
	 * 
	 * @param listener the routing listener
	 * @see PolylineConnection#addRoutingListener(RoutingListener)
	 */
	public void addRoutingListener(RoutingListener listener) {
		if (connectionRouter instanceof RoutingNotifier) {
			RoutingNotifier notifier = (RoutingNotifier) connectionRouter;
			notifier.listeners.add(listener);
		} else {
			connectionRouter = new RoutingNotifier(connectionRouter, listener);
		}
	}

	/**
	 * Called by the anchors of this connection when they have moved,
	 * revalidating this polyline connection.
	 * 
	 * @param anchor the anchor that moved
	 * @see PolylineConnection#anchorMoved(ConnectionAnchor)
	 */
	public void anchorMoved(ConnectionAnchor anchor) {
		revalidate();
	}

	/**
	 * Returns the bounds which holds all the points in this polyline
	 * connection. Returns any previously existing bounds, else calculates by
	 * unioning all the children's dimensions.
	 * 
	 * @return the bounds
	 * @see PolylineConnection#getBounds()
	 */
	@Override
	public Rectangle getBounds() {
		if (bounds == null) {
			// usually, bounds are already set in super, but one never knows:
			bounds = super.getBounds(); 
			for (int i = 0; i < getChildren().size(); i++) {
				IFigure child = (IFigure) getChildren().get(i);
				bounds.union(child.getBounds());
			}
		}
		return bounds;
	}

	// TODO getBounds3D() ?

	/**
	 * Returns the <code>ConnectionRouter</code> used to layout this connection.
	 * Will not return <code>null</code>.
	 * 
	 * @return this connection's router
	 * @see PolylineConnection#getConnectionRouter()
	 */
	public ConnectionRouter getConnectionRouter() {
		if (connectionRouter instanceof RoutingNotifier) {
			return ((RoutingNotifier) connectionRouter).realRouter;
		}
		return connectionRouter;
	}

	/**
	 * Returns this connection's routing constraint from its connection router.
	 * May return <code>null</code>.
	 * 
	 * @return the connection's routing constraint
	 * @see PolylineConnection#getRoutingConstraint()
	 */
	public Object getRoutingConstraint() {
		if (getConnectionRouter() != null) {
			return getConnectionRouter().getConstraint(this);
		} else {
			return null;
		}
	}

	/**
	 * Returns start anchor.
	 * 
	 * @return the anchor at the start of this polyline connection (may be null)
	 * @see PolylineConnection#getSourceAnchor()
	 */
	public ConnectionAnchor getSourceAnchor() {
		return startAnchor;
	}

	/**
	 * Returns the start decoration
	 * 
	 * @return the source decoration (may be null)
	 * @see PolylineConnection#getSourceDecoration()
	 */
	protected RotatableDecoration getSourceDecoration() {
		return startArrow;
	}

	/**
	 * Returns the end anchor.
	 * 
	 * @return the anchor at the end of this polyline connection (may be null)
	 * @see PolylineConnection#getTargetAnchor()
	 */
	public ConnectionAnchor getTargetAnchor() {
		return endAnchor;
	}

	/**
	 * Returns the end decoration.
	 * 
	 * @return the target decoration (may be null)
	 * @see PolylineConnection#getTargetDecoration()
	 */
	protected RotatableDecoration getTargetDecoration() {
		return endArrow;
	}

	/**
	 * Registers this figure as listener at its source anchor.
	 * 
	 * @see PolylineConnection#hookSourceAnchor()
	 */
	private void hookSourceAnchor() {
		if (getSourceAnchor() != null) {
			getSourceAnchor().addAnchorListener(this);
		}
	}

	/**
	 * Registers this figure as listener at its target anchor.
	 * 
	 * @see PolylineConnection#hookTargetAnchor()
	 */
	private void hookTargetAnchor() {
		if (getTargetAnchor() != null) {
			getTargetAnchor().addAnchorListener(this);
		}
	}

	/**
	 * Layouts this polyline. If the start and end anchors are present, the
	 * connection router is used to route this, after which it is laid out. It
	 * also fires a moved method. This method is currently disabled, since a 3D
	 * line has to be layouted differently. Internal note: Copied and slightly
	 * modified
	 * 
	 * @todo implement this method
	 * @see PolylineConnection#layout()
	 */
	@Override
	public void layout() {
		if ( // from PolylineConnection:
		(getSourceAnchor() != null && getTargetAnchor() != null)
		// added -- and removed: XYZAnchor has no owner!:
		// && (getSourceAnchor().getOwner() != null && getTargetAnchor()
		// .getOwner() != null)
		) {
			connectionRouter.route(this); // from PolylineConnection
		}

		Rectangle oldBounds = bounds; // from PolylineConnection
		super.layout(); // from PolylineConnection

		// TODO uups? This was copied from original, why is it set to null?
		// is there a local field in original version?
		// bounds = null;

		// from PolylineConnection
		if (!getBounds().contains(oldBounds)) {
			getParent().translateToParent(oldBounds);
			getUpdateManager().addDirtyRegion(getParent(), oldBounds);
		}

		repaint(); // from PolylineConnection
		// invalidate(); not in original
		fireFigureMoved(); // from PolylineConnection
	}

	/**
	 * Called just before the receiver is being removed from its parent. Results
	 * in removing itself from the connection router.
	 * 
	 * @see PolylineConnection#removeNotify()
	 */
	@Override
	public void removeNotify() {
		unhookSourceAnchor();
		unhookTargetAnchor();
		connectionRouter.remove(this);
		super.removeNotify();
	}

	/**
	 * Removes the first occurence of the given listener.
	 * 
	 * @param listener the listener being removed
	 * @see PolylineConnection#removeRoutingListener(RoutingListener)
	 */
	public void removeRoutingListener(RoutingListener listener) {
		if (connectionRouter instanceof RoutingNotifier) {
			RoutingNotifier notifier = (RoutingNotifier) connectionRouter;
			notifier.listeners.remove(listener);
			if (notifier.listeners.isEmpty()) {
				connectionRouter = notifier.realRouter;
			}
		}
	}

	/**
	 * @see PolylineConnection#revalidate()
	 * @see PolylineConnection#revalidate()
	 */
	@Override
	public void revalidate() {
		// if (log.isLoggable(Level.INFO)) {
		//			log.info("revalidate "); //$NON-NLS-1$
		// }

		super.revalidate();

		// invalidate(); // added
		// if (getParent() != null) getParent().revalidate(); // added

		// added null check (kristian)
		if (connectionRouter != null)
			connectionRouter.invalidate(this);
	}

	/**
	 * Sets the connection router which handles the layout of this polyline.
	 * Generally set by the parent handling the polyline connection.
	 * 
	 * @param cr the connection router, may be null
	 * @see PolylineConnection#setConnectionRouter(ConnectionRouter)
	 */
	public void setConnectionRouter(ConnectionRouter i_cr) {
		ConnectionRouter cr = i_cr;
		if (cr == null) {
			cr = ConnectionRouter3D.NULL;
		}
		ConnectionRouter oldRouter = getConnectionRouter();
		if (oldRouter != cr) {
			connectionRouter.remove(this);
			if (connectionRouter instanceof RoutingNotifier) {
				((RoutingNotifier) connectionRouter).realRouter = cr;
			} else {
				connectionRouter = cr;
			}
			firePropertyChange(Connection.PROPERTY_CONNECTION_ROUTER,
				oldRouter, cr);
			revalidate();
		}
	}

	/**
	 * Sets the routing constraint for this connection.
	 * 
	 * @param cons the constraint
	 * @see PolylineConnection#setRoutingConstraint(Object)
	 */
	public void setRoutingConstraint(Object cons) {
		if (connectionRouter != null) {
			connectionRouter.setConstraint(this, cons);
		}
		revalidate();
	}

	/**
	 * Sets the anchor to be used at the start of this polyline connection.
	 * 
	 * @param anchor the new source anchor, must be a 3D anchor or an anchor
	 *            attached to a figure for which a 3D host figure is retrievable
	 * @see PolylineConnection#setSourceAnchor(ConnectionAnchor)
	 */
	public void setSourceAnchor(ConnectionAnchor anchor) {
		if (anchor == startAnchor) {
			return;
		}
		// Anchor needs an 3D owner, in case that anchor is not null. The
		// later only occurs if a connection is removed, see bug 342830
		if (!(anchor instanceof ConnectionAnchor3D) && anchor!=null) {
			if (Figure3DHelper.getAncestor3D(anchor.getOwner()) == null) {
				throw new IllegalArgumentException(
					"Cannot set 2D anchor w/o available 3D owner, you probably"
						+ "would subclass your connection edit part from a 3D base class");
			}
		}
		unhookSourceAnchor();
		// No longer needed, revalidate does this. (original comment)
		// getConnectionRouter().invalidate(this); (originally uncommented)
		startAnchor = anchor;
		if (getParent() != null) {
			hookSourceAnchor();
		}
		revalidate();
	}

	/**
	 * Sets the decoration to be used at the start of the {@link Connection}.
	 * 
	 * @param dec the new source decoration
	 * @see PolylineConnection#setSourceDecoration(RotatableDecoration)
	 */
	public void setSourceDecoration(RotatableDecoration dec) {
		if (startArrow == dec) {
			return;
		}
		if (startArrow != null) {
			remove(startArrow);
		}
		startArrow = dec;
		if (startArrow != null) {
			add(startArrow, new ArrowLocator3D(this, ConnectionLocator.SOURCE));
		}
	}

	/**
	 * Sets the anchor to be used at the end of the polyline connection. Removes
	 * this listener from the old anchor and adds it to the new anchor.
	 * 
	 * @param anchor the new target anchor, must be a 3D anchor or an anchor
	 *            attached to a figure for which a 3D host figure is retrievable
	 * @see PolylineConnection#setTargetAnchor(ConnectionAnchor)
	 */
	public void setTargetAnchor(ConnectionAnchor anchor) {
		if (anchor == endAnchor) {
			return;
		}
		// Anchor needs an 3D owner, in case that anchor is not null. The
		// later only occurs if a connection is removed, see bug 342830
		if (!(anchor instanceof ConnectionAnchor3D) && anchor!=null) {
			if (Figure3DHelper.getAncestor3D(anchor.getOwner()) == null) {
				throw new IllegalArgumentException(
					"Cannot set 2D anchor w/o available 3D owner, you probably"
						+ "would subclass your connection edit part from a 3D base class");
			}
		}
		unhookTargetAnchor();
		endAnchor = anchor;
		if (getParent() != null) {
			hookTargetAnchor();
		}
		revalidate();
	}

	/**
	 * Sets the decoration to be used at the end of the {@link Connection}.
	 * 
	 * @param dec the new target decoration
	 * @see PolylineConnection#setTargetDecoration(RotatableDecoration)
	 */
	public void setTargetDecoration(RotatableDecoration dec) {
		if (endArrow == dec) {
			return;
		}
		if (endArrow != null) {
			remove(endArrow);
		}
		endArrow = dec;
		if (endArrow != null) {
			add(endArrow, new ArrowLocator3D(this, ConnectionLocator.TARGET));
		}
	}

	/**
	 * Removes this figure from start anchors listeners.
	 * 
	 * @see PolylineConnection#unhookSourceAnchor()
	 */
	private void unhookSourceAnchor() {
		if (getSourceAnchor() != null) {
			getSourceAnchor().removeAnchorListener(this);
		}
	}

	/**
	 * Removes this figure from end anchors listeners.
	 * 
	 * @see PolylineConnection#unhookTargetAnchor()
	 */
	private void unhookTargetAnchor() {
		if (getTargetAnchor() != null) {
			getTargetAnchor().removeAnchorListener(this);
		}
	}

	/**
	 * RoutingNotifier There should really be more documentation here.
	 * 
	 * @see PolylineConnection.RoutingNotifier
	 */
	final static class RoutingNotifier implements ConnectionRouter {

		ConnectionRouter realRouter;

		List<RoutingListener> listeners = new ArrayList<RoutingListener>(1);

		RoutingNotifier(ConnectionRouter router, RoutingListener listener) {
			realRouter = router;
			listeners.add(listener);
		}

		public Object getConstraint(Connection connection) {
			return realRouter.getConstraint(connection);
		}

		public void invalidate(Connection connection) {
			for (int i = 0; i < listeners.size(); i++) {
				listeners.get(i).invalidate(connection);
			}

			realRouter.invalidate(connection);
		}

		public void route(Connection connection) {
			boolean consumed = false;
			for (int i = 0; i < listeners.size(); i++) {
				consumed |= listeners.get(i).route(connection);
			}

			if (!consumed) {
				realRouter.route(connection);
			}

			for (int i = 0; i < listeners.size(); i++) {
				listeners.get(i).postRoute(connection);
			}
		}

		public void remove(Connection connection) {
			for (int i = 0; i < listeners.size(); i++) {
				listeners.get(i).remove(connection);
			}
			realRouter.remove(connection);
		}

		public void setConstraint(Connection connection, Object constraint) {
			for (int i = 0; i < listeners.size(); i++) {
				listeners.get(i).setConstraint(connection, constraint);
			}
			realRouter.setConstraint(connection, constraint);
		}

	}

	/**
	 * {@inheritDoc} Added for debugging purposes only, may be removed.
	 * 
	 * @see org.eclipse.draw2d.Figure#setValid(boolean)
	 */
	@Override
	public void setValid(boolean i_value) {
		// if (! i_value) {
		// if (log.isLoggable(Level.INFO)) {
		//				log.info("boolean - figure is set invalid"); //$NON-NLS-1$
		// }
		// }
		super.setValid(i_value);
	}
}
