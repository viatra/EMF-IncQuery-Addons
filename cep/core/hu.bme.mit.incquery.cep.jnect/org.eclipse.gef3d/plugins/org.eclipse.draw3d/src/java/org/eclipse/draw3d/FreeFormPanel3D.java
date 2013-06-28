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
package org.eclipse.draw3d;

import java.util.Iterator;
import java.util.logging.Logger;

import org.eclipse.draw2d.FreeformFigure;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw3d.draw2dports.FreeformHelper;
import org.eclipse.draw3d.shapes.CuboidFigureShape;
import org.eclipse.draw3d.shapes.Shape;

/**
 * A free form figure that automatically expands to accomodate its children and
 * uses a cuboid shape to display itself.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 27.08.2009
 */
public class FreeFormPanel3D extends ShapeFigure3D implements FreeformFigure {

	/**
	 * Logger for this class
	 */
	static final Logger log = Logger.getLogger(FreeFormPanel3D.class
		.getName());

	
	/**
	 * <p>
	 * Copied and modified from {@link FreeformLayer}. This is not the original
	 * FreeformHelper, since GEF's FreeformHelper is package visible only. It's
	 * a 1:1 copy (maybe changed in future versions, so look at
	 * {@link FreeformHelper}'s javadoc. It was also renamed (from helper to
	 * freeformHelper).
	 * </p>
	 */
	private final FreeformHelper freeformHelper = new FreeformHelper(this);

	private FreeformListener m_autosizeListener = new FreeformListener() {

		public void notifyFreeformExtentChanged() {
			Rectangle extent = getFreeformExtent();
			log.info(extent.toString());
			setBounds(extent);
		}
	};

	/**
	 * Creates a new instance.
	 */
	public FreeFormPanel3D() {

		addFreeformListener(m_autosizeListener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.Figure3D#add(org.eclipse.draw2d.IFigure,
	 *      java.lang.Object, int)
	 */
	@Override
	public void add(IFigure i_figure, Object i_constraint, int i_index) {

		super.add(i_figure, i_constraint, i_index);
		freeformHelper.hookChild(i_figure);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.FreeformFigure#addFreeformListener(org.eclipse.draw2d.FreeformListener)
	 */
	public void addFreeformListener(FreeformListener i_listener) {

		addListener(FreeformListener.class, i_listener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.ShapeFigure3D#createShape()
	 */
	@Override
	protected Shape createShape() {

		return new CuboidFigureShape(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.FreeformFigure#fireExtentChanged()
	 */
	public void fireExtentChanged() {

		Iterator<?> iter = getListeners(FreeformListener.class);
		while (iter.hasNext())
			((FreeformListener) iter.next()).notifyFreeformExtentChanged();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.FreeformFigure#getFreeformExtent()
	 */
	public Rectangle getFreeformExtent() {

		return freeformHelper.getFreeformExtent();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Figure#primTranslate(int, int)
	 */
	@Override
	protected void primTranslate(int i_dx, int i_dy) {

		bounds.translate(i_dx, i_dy);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.Figure3D#remove(org.eclipse.draw2d.IFigure)
	 */
	@Override
	public void remove(IFigure i_figure) {

		freeformHelper.unhookChild(i_figure);
		super.remove(i_figure);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.FreeformFigure#removeFreeformListener(org.eclipse.draw2d.FreeformListener)
	 */
	public void removeFreeformListener(FreeformListener i_listener) {

		removeListener(FreeformListener.class, i_listener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.FreeformFigure#setFreeformBounds(org.eclipse.draw2d.geometry.Rectangle)
	 */
	public void setFreeformBounds(Rectangle i_bounds) {

		freeformHelper.setFreeformBounds(bounds);
	}
}
