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

package org.eclipse.gef3d.gmf.runtime.draw2d.ui.internal.figures.ConnectionLayerEx;

import java.util.logging.Logger;

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw3d.ConnectionLayerFactory;
import org.eclipse.draw3d.DispatchingConnectionLayerHelper;
import org.eclipse.draw3d.IFigure2DHost3D;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ConnectionLayerEx;


/**
 * DispatchingConnectionLayerEx There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision:47 $
 * @since 04.01.2008
 */
public class DispatchingConnectionLayerEx extends ConnectionLayerEx {

	public final static ConnectionLayerFactory CONNECTIONLAYEREXFACTORY = new ConnectionLayerFactory() {

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.ConnectionLayerFactory#createConnectionLayer(org.eclipse.draw3d.IFigure2DHost3D)
		 */
		@Override
		public ConnectionLayer createConnectionLayer(IFigure2DHost3D i_hint) {
			return new ConnectionLayerEx();
		}

	};

	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger
			.getLogger(DispatchingConnectionLayerEx.class.getName());

	private DispatchingConnectionLayerHelper dclhelper;

	/**
	 * 
	 */
	public DispatchingConnectionLayerEx() {
		dclhelper = new DispatchingConnectionLayerHelper(this,
				CONNECTIONLAYEREXFACTORY);
		dclhelper.setPendingParent(new MapModeFigure());
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
	 * 
	 */
	public void dispatchPendingConnections() {
		dclhelper.dispatchPendingConnections();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ConnectionLayerEx#getConnectionRouter()
	 */
	@Override
	public ConnectionRouter getConnectionRouter() {
		return connectionRouter;
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
