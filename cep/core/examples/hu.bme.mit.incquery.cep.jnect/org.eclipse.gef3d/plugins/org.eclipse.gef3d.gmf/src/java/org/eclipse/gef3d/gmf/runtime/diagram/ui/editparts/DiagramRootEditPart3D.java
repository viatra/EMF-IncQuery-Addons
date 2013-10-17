/*******************************************************************************
 * Copyright (c) 2009 Kristian Duske and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.gmf.runtime.diagram.ui.editparts;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayeredPane;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.draw3d.DispatchingConnectionLayer;
import org.eclipse.draw3d.FeedbackLayer3D;
import org.eclipse.gef3d.gmf.runtime.draw2d.ui.internal.figures.ConnectionLayerEx.DispatchingConnectionLayerEx;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.notation.MeasurementUnit;

/**
 * 3D diagram root edit part with feedback, primary, connection, and
 * decoration-printable layer.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since Apr 7, 2009
 */
public class DiagramRootEditPart3D extends DiagramRootEditPart {

	/**
	 * Creates a new instance that uses an identity map mode.
	 */
	public DiagramRootEditPart3D() {

		super(MeasurementUnit.PIXEL_LITERAL);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.ScalableFreeformRootEditPart#createLayers(org.eclipse.draw2d.LayeredPane)
	 */
	@Override
	protected void createLayers(LayeredPane i_layeredPane) {

		super.createLayers(i_layeredPane);

		// replace 2D version with 3D one:
		IFigure oldLayer = i_layeredPane.getLayer(FEEDBACK_LAYER);
		i_layeredPane.remove(oldLayer);
		i_layeredPane.add(new FeedbackLayer3D(), FEEDBACK_LAYER);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.FreeformGraphicalRootEditPart#createPrintableLayers()
	 */
	@Override
	protected LayeredPane createPrintableLayers() {

		FreeformLayeredPane layeredPane = new FreeformLayeredPane() {
			@Override
			public void paint(Graphics graphics) {
				for (Object child : getChildren()) {
					if (child instanceof DispatchingConnectionLayer) {
						((DispatchingConnectionLayer) child).dispatchPendingConnections();
					}
				}
				super.paint(graphics);
			}
		};

		layeredPane.add(new FreeformLayer(), PRIMARY_LAYER);
		layeredPane.add(new DispatchingConnectionLayerEx(), CONNECTION_LAYER);
		layeredPane.add(new FreeformLayer(),
			DiagramRootEditPart.DECORATION_PRINTABLE_LAYER);

		return layeredPane;
	}
}