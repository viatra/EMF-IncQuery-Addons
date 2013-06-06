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
package org.eclipse.gef3d.ext.intermodel;

import org.eclipse.draw3d.DispatchingConnectionLayer;
import org.eclipse.draw3d.Figure3D;
import org.eclipse.draw3d.geometry.NullPosition3D;
import org.eclipse.draw3d.geometry.Position3D;

/**
 * Default implementation of the {@link IInterModelDiagram} interface. This
 * figure has no position and its connection layer is a delegating connection
 * layer.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 08.09.2009
 */
public class InterModelDiagramFigure extends Figure3D implements IInterModelDiagram {

	/**
	 * Creates a new instance.
	 */
	public InterModelDiagramFigure() {

		connectionLayer = new DispatchingConnectionLayer();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.Figure3D#createPosition3D()
	 */
	@Override
	protected Position3D createPosition3D() {

		return new NullPosition3D(this);
	}
}
