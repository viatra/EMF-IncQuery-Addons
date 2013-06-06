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

import java.util.logging.Logger;

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;

/**
 * DispatchingConnectionLayer is used for the root edit part. This class is
 * usually not used in 3D figures.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 20.12.2007
 */
public class DispatchingConnectionLayer extends ConnectionLayer {
	/**
	 * Logger for this class
	 */
	@SuppressWarnings("unused")
	private static final Logger log =
		Logger.getLogger(DispatchingConnectionLayer.class.getName());

	private final DispatchingConnectionLayerHelper dclhelper;

	/**
	 * 
	 */
	public DispatchingConnectionLayer() {
		dclhelper =
			new DispatchingConnectionLayerHelper(this,
				ConnectionLayerFactory.singleton);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.ConnectionLayer#add(org.eclipse.draw2d.IFigure,
	 *      java.lang.Object, int)
	 */
	@Override
	public void add(IFigure i_figure, Object i_constraint, int i_index) {
		if (!dclhelper.add(i_figure, i_constraint, i_index))
			super.add(i_figure, i_constraint, i_index);
	}

	/**
	 * Dispatches connections, that is connections not added to a connection
	 * layer associated with a figure3D are now assigned to one of these
	 * layers.
	 * @see DispatchingConnectionLayerHelper#dispatchPendingConnections()
	 */
	public void dispatchPendingConnections() {
		dclhelper.dispatchPendingConnections();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Figure#paintChildren(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void paintChildren(Graphics i_graphics) {
		dclhelper.paintChildren(i_graphics);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.ConnectionLayer#remove(org.eclipse.draw2d.IFigure)
	 */
	@Override
	public void remove(IFigure i_figure) {
		if (!dclhelper.remove(i_figure))
			super.remove(i_figure);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.ConnectionLayer#setConnectionRouter(org.eclipse.draw2d.ConnectionRouter)
	 */
	@Override
	public void setConnectionRouter(ConnectionRouter i_router) {
		super.setConnectionRouter(i_router);
		dclhelper.setConnectionRouter(i_router);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Figure#validate()
	 */
	@Override
	public void validate() {
		dclhelper.validate();
		super.validate();
	}

}
