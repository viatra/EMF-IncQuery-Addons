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
package org.eclipse.gef3d.handles;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw3d.PositionConstants3D;
import org.eclipse.draw3d.RelativeLocator3D;


/**
 * RelativeHandleLocator3D, There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Mar 24, 2008
 */
public class RelativeHandleLocator3D extends RelativeLocator3D {

	/**
	 * @param i_reference
	 * @param i_location
	 * @param i_zlocation
	 */
	public RelativeHandleLocator3D(IFigure i_reference, int i_location,
			PositionConstants3D i_zlocation) {
		super(i_reference, i_location);
	}
}
