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

import java.util.List;

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.IFigure;

/**
 * Interface to be implemented by 3D figures having 2D children such as 2D
 * connections or more general 2D figures.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 10.01.2008
 */
public interface IFigure2DHost3D {

	/**
	 * Returns all 2D children of the host. Only the hosts immediate children
	 * are returned and not their descendants. If this host does not have any 2D
	 * children, an empty list is returned.
	 * 
	 * @return an unmodifiable list containing the 2D children
	 */
	public List<IFigure> getChildren2D();

	/**
	 * Returns this figure's connection layer. If no layer is set yet but
	 * connection layers are supported, the factory is used for creating the
	 * layer lazily. This method is used by {@link DispatchingConnectionLayer}.
	 * If this figure doesn't support connections, null is returned. The
	 * {@link DispatchingConnectionLayer} uses the first available connection
	 * layer.
	 * 
	 * @param i_clfactory
	 *            the factory used or <code>null</code>, if no layer should be
	 *            created lazily
	 * @return the connection layer or <code>null</code> if this figure does not
	 *         support connections
	 * @see ConnectionLayerFactory#singleton
	 */
	public ConnectionLayer getConnectionLayer(ConnectionLayerFactory i_clfactory);

	/**
	 * Returns the surface of this host figure.
	 * 
	 * @return the surface
	 * @todo add parameters that allow selection of a particular surface if a
	 *       figure needs more than one surface
	 */
	public ISurface getSurface();
}