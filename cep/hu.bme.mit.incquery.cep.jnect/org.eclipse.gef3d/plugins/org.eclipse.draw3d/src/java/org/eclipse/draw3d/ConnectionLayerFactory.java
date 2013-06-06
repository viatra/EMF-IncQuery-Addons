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

import org.eclipse.draw2d.ConnectionLayer;

/**
 * ConnectionLayerFactory creates a connection layer. This default
 * implementation creates a {@link ConnectionLayer}.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 10.01.2008
 */
public class ConnectionLayerFactory {

	public final static ConnectionLayerFactory singleton = new ConnectionLayerFactory();

	/**
	 * There is no need to create an instance of this class since the singleton
	 * instance can be used.
	 */
	protected ConnectionLayerFactory() {
	}

	/**
	 * Creates a {@link ConnectionLayer}. This method can be overridden for
	 * creating other layers, using the figure as a hint for creating
	 * appropriate layers. The layer is not added to the passed figure, but only
	 * created.
	 * 
	 * @param hint
	 * @return
	 */
	public ConnectionLayer createConnectionLayer(IFigure2DHost3D hint) {
		return new ConnectionLayer();
	}
}
