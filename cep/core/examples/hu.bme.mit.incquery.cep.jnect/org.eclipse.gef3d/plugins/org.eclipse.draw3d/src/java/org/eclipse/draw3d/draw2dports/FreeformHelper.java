/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others,
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation
 *    Jens von Pilgrim - moved to draw3d and made class public
 ******************************************************************************/
package org.eclipse.draw3d.draw2dports;

import java.util.List;

import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.FreeformFigure;
import org.eclipse.draw2d.FreeformListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * FreeformHelper is GEF3D's version of GEF's
 * {@link org.eclipse.gef.FreeformHelper} and it is used by FreeformLayer3D.
 * 
 * <p>Copied (and not modified yet) from 
 * {@link org.eclipse.gef.FreeformHelper}.
 * <b>It was duplicated since the original class is package visible only.</b>
 * </p>
 * 
 * @author IBM Corporation
 * @version $Revision$
 * @since Feb 11, 2008
 */
public class FreeformHelper implements FreeformListener {

	/**
	 * 
	 * ChildTracker
	 * 
	 * <p>Copied (and not modified yet) from 
	 * {@link org.eclipse.gef.FreeformHelper}.</p>
	 */
	class ChildTracker implements FigureListener {
		public void figureMoved(IFigure source) {
			invalidate();
		}
	}

	/**
	 * <p>Copied (and not modified yet) from 
	 * {@link org.eclipse.gef.FreeformHelper}.</p>
	 */
	private FreeformFigure host;

	
	/**
	 * <p>Copied (and not modified yet) from 
	 * {@link org.eclipse.gef.FreeformHelper}.</p>
	 */
	private Rectangle freeformExtent;

	/**
	 * <p>Copied (and not modified yet) from 
	 * {@link org.eclipse.gef.FreeformHelper}.</p>
	 */
	private FigureListener figureListener = new ChildTracker();

	/**
	 * <p>Copied (and not modified yet) from 
	 * {@link org.eclipse.gef.FreeformHelper}.</p>
	 * 
	 * @param host the host of this helper, i.e. the figure using the helper
	 */
	public FreeformHelper(FreeformFigure host) {
		this.host = host;
	}

	/**
	 * <p>Copied (and not modified yet) from 
	 * {@link org.eclipse.gef.FreeformHelper}.</p>
	 * @return
	 */
	public Rectangle getFreeformExtent() {
		if (freeformExtent != null)
			return freeformExtent;
		Rectangle r;
		@SuppressWarnings("unchecked")
		List<IFigure> children = host.getChildren();
		for (IFigure child: children) {
			if (child instanceof FreeformFigure)
				r = ((FreeformFigure) child).getFreeformExtent();
			else
				r = child.getBounds();
			if (freeformExtent == null)
				freeformExtent = r.getCopy();
			else
				freeformExtent.union(r);
		}
		Insets insets = host.getInsets();
		if (freeformExtent == null)
			freeformExtent = new Rectangle(0, 0, insets.getWidth(), insets
					.getHeight());
		else {
			host.translateToParent(freeformExtent);
			freeformExtent.expand(insets);
		}
		// System.out.println("New extent calculated for " + host + " = " +
		// freeformExtent);
		return freeformExtent;
	}

	
	/**
	 * <p>Copied (and not modified yet) from 
	 * {@link org.eclipse.gef.FreeformHelper}.</p>
	 * @param child
	 */
	public void hookChild(IFigure child) {
		invalidate();
		if (child instanceof FreeformFigure)
			((FreeformFigure) child).addFreeformListener(this);
		else
			child.addFigureListener(figureListener);
	}

	/**
	 * <p>Copied (and not modified yet) from 
	 * {@link org.eclipse.gef.FreeformHelper}.</p>
	 */
	void invalidate() {
		freeformExtent = null;
		host.fireExtentChanged();
		if (host.getParent() != null)
			host.getParent().revalidate();
		else
			host.revalidate();
	}

	/** 
	 * {@inheritDoc}
	 * 
	 * <p>Copied (and not modified yet) from 
	 * {@link org.eclipse.gef.FreeformHelper}.</p>
	 * @see org.eclipse.draw2d.FreeformListener#notifyFreeformExtentChanged()
	 */
	public void notifyFreeformExtentChanged() {
		// A childs freeform extent has changed, therefore this extent must be
		// recalculated
		invalidate();
	}

	/**
	 * <p>Copied (and not modified yet) from 
	 * {@link org.eclipse.gef.FreeformHelper}.</p>
	 * @param bounds
	 */
	public void setFreeformBounds(Rectangle i_bounds) {
		Rectangle bounds = i_bounds.getCopy();
		host.translateFromParent(bounds);
		@SuppressWarnings("unchecked")
		List<IFigure> children = host.getChildren();
		for (IFigure child: children) {
			if (child instanceof FreeformFigure)
				((FreeformFigure) child).setFreeformBounds(bounds);
		}
	}

	/**
	 * <p>Copied (and not modified yet) from 
	 * {@link org.eclipse.gef.FreeformHelper}.</p>
	 * @param child
	 */
	public void unhookChild(IFigure child) {
		invalidate();
		if (child instanceof FreeformFigure)
			((FreeformFigure) child).removeFreeformListener(this);
		else
			child.removeFigureListener(figureListener);
	}

}
