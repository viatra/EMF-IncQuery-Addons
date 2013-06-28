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
package org.eclipse.gef3d.handles;

import java.util.logging.Logger;

import org.eclipse.draw2d.AncestorListener;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw3d.Figure3D;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Handle;
import org.eclipse.gef.handles.AbstractHandle;
import org.eclipse.swt.graphics.Cursor;


/**
 * 3D version of {@link AbstractHandle}, most methods are 1:1 copies of
 * original version and are not modified. This class was created since
 * AbstractHandle extends Figure, and this one must extend Figure3D.
 * 
 * @todo Create Handle3D interface returning a 3D point
 * 
 * @author IBM Corporation (original 2D version)
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Mar 25, 2008
 * @see AbstracHandle
 */
public abstract class AbstractHandle3D extends Figure3D implements Handle,
		AncestorListener {
	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger.getLogger(AbstractHandle3D.class
			.getName());

	/** copied (and not modified yet) from {@link AbstractHandle} */
	private GraphicalEditPart editpart;

	/**
	 * copied (and not modified yet) from {@link AbstractHandle}
	 */
	private DragTracker dragTracker;

	/**
	 * copied (and not modified yet) from {@link AbstractHandle}
	 */
	private Locator locator;

	/**
	 * Null constructor
	 */
	public AbstractHandle3D() {
	}

	/**
	 * Creates a handle for the given <code>GraphicalEditPart</code> using the
	 * given <code>Locator</code>.
	 * <p>
	 * Copied (and not modified yet) from {@link AbstractHandle}.
	 * </p>
	 * 
	 * @param owner The editpart which provided this handle
	 * @param loc The locator to position the handle
	 */
	public AbstractHandle3D(GraphicalEditPart owner, Locator loc) {
		setOwner(owner);
		setLocator(loc);
	}

	/**
	 * Creates a handle for the given <code>GraphicalEditPart</code> using the
	 * given <code>Locator</code> and <code>Cursor</code>.
	 * <p>
	 * Copied (and not modified yet) from {@link AbstractHandle}.
	 * </p>
	 * 
	 * @param owner The editpart which provided this handle
	 * @param loc The locator to position the handle
	 * @param c The cursor to display when the mouse is over the handle
	 */
	public AbstractHandle3D(GraphicalEditPart owner, Locator loc, Cursor c) {
		this(owner, loc);
		setCursor(c);
	}

	/**
	 * Adds this as an {@link AncestorListener} to the owner's {@link Figure}.
	 * <p>
	 * Copied (and not modified yet) from {@link AbstractHandle}.
	 * </p>
	 */
	public void addNotify() {
		super.addNotify();
		// Listen to the owner figure so the handle moves when the
		// figure moves.
		getOwnerFigure().addAncestorListener(this);
	}

	/**
	 * <p>
	 * Copied (and not modified yet) from
	 * {@link AbstractHandle#ancestorMoved(IFigure)}.
	 * </p>
	 * 
	 * @see org.eclipse.draw2d.AncestorListener#ancestorMoved(org.eclipse.draw2d.IFigure)
	 */
	public void ancestorMoved(IFigure ancestor) {
//		
//
//		if (log.isLoggable(Level.INFO)) {
//			log.info("moved ancestor=" + ancestor); //$NON-NLS-1$
//		}
		
		revalidate();
	}

	/**
	 * <p>
	 * Copied (and not modified yet) from {@link AbstractHandle}.
	 * </p>
	 * 
	 * @see org.eclipse.draw2d.AncestorListener#ancestorAdded(org.eclipse.draw2d.IFigure)
	 */
	public void ancestorAdded(IFigure ancestor) {
	}

	/**
	 * <p>
	 * Copied (and not modified yet) from {@link AbstractHandle}.
	 * </p>
	 * 
	 * @see org.eclipse.draw2d.AncestorListener#ancestorRemoved(org.eclipse.draw2d.IFigure)
	 */
	public void ancestorRemoved(IFigure ancestor) {
	}

	/**
	 * Creates a new drag tracker to be returned by getDragTracker().
	 * <p>
	 * Copied (and not modified yet) from {@link AbstractHandle}.
	 * </p>
	 * 
	 * @return a new drag tracker
	 */
	protected abstract DragTracker createDragTracker();

	/**
	 * By default, the center of the handle is returned.
	 * <p>
	 * Copied (and not modified yet) from {@link AbstractHandle}.
	 * </p>
	 * 
	 * @see org.eclipse.gef.Handle#getAccessibleLocation()
	 */
	public Point getAccessibleLocation() {
		Point p = getBounds().getCenter();
		translateToAbsolute(p);
		return p;
	}

	/**
	 * Returns the cursor. The cursor is displayed whenever the mouse is over
	 * the handle.
	 * <p>
	 * Copied (and not modified yet) from {@link AbstractHandle}.
	 * </p>
	 * 
	 * @deprecated use getCursor()
	 * @return the cursor
	 */
	public Cursor getDragCursor() {
		return getCursor();
	}

	/**
	 * Returns the drag tracker to use when the user clicks on this handle. If
	 * the drag tracker has not been set, it will be lazily created by calling
	 * {@link #createDragTracker()}.
	 * <p>
	 * Copied (and not modified yet) from {@link AbstractHandle}.
	 * </p>
	 * 
	 * @return the drag tracker
	 */
	public DragTracker getDragTracker() {
		if (dragTracker == null)
			dragTracker = createDragTracker();
		return dragTracker;
	}

	/**
	 * Returns the <code>Locator</code> used to position this handle.
	 * <p>
	 * Copied (and not modified yet) from {@link AbstractHandle}.
	 * </p>
	 * 
	 * @return the locator
	 */
	public Locator getLocator() {
		return locator;
	}

	/**
	 * Returns the <code>GraphicalEditPart</code> associated with this handle.
	 * <p>
	 * Copied (and not modified yet) from {@link AbstractHandle}.
	 * </p>
	 * 
	 * @return the owner editpart
	 */
	protected GraphicalEditPart getOwner() {
		return editpart;
	}

	/**
	 * Convenience method to return the owner's figure.
	 * <p>
	 * Copied (and not modified yet) from {@link AbstractHandle}.
	 * </p>
	 * 
	 * @return the owner editpart's figure
	 */
	protected IFigure getOwnerFigure() {
		return getOwner().getFigure();
	}

	/**
	 * <p>
	 * Copied (and not modified yet) from {@link AbstractHandle}.
	 * </p>
	 * 
	 * @see org.eclipse.draw2d.IFigure#removeNotify()
	 */
	public void removeNotify() {
		getOwnerFigure().removeAncestorListener(this);
		super.removeNotify();
	}

	/**
	 * Sets the Cursor for the handle.
	 * <p>
	 * Copied (and not modified yet) from {@link AbstractHandle}.
	 * </p>
	 * 
	 * @param c the cursor
	 * @throws Exception a bogus excpetion declaration
	 * @deprecated use setCursor()
	 */
	public void setDragCursor(Cursor c) throws Exception {
		setCursor(c);
	}

	/**
	 * Sets the drag tracker for this handle.
	 * <p>
	 * Copied (and not modified yet) from {@link AbstractHandle}.
	 * </p>
	 * 
	 * @param t the drag tracker
	 */
	public void setDragTracker(DragTracker t) {
		dragTracker = t;
	}

	/**
	 * Sets the locator which position this handle.
	 * <p>
	 * Copied (and not modified yet) from {@link AbstractHandle}.
	 * </p>
	 * 
	 * @param locator the new locator
	 */
	protected void setLocator(Locator locator) {
		this.locator = locator;
	}

	/**
	 * Sets the owner editpart associated with this handle.
	 * <p>
	 * Copied (and not modified yet) from {@link AbstractHandle}.
	 * </p>
	 * 
	 * @param editpart the owner
	 */
	protected void setOwner(GraphicalEditPart editpart) {
		this.editpart = editpart;
	}

	/**
	 * Extends validate() to place the handle using its locator.
	 * <p>
	 * Copied (and not modified yet) from {@link AbstractHandle#validate()}.
	 * </p>
	 * 
	 * @see org.eclipse.draw2d.IFigure#validate()
	 */
	public void validate() {
		if (isValid())
			return;
		getLocator().relocate(this);
		super.validate();
	}

	

}
