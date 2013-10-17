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
package org.eclipse.draw3d;

import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometryext.PointList3D;

/**
 * 3D version of connection, extends from Connection and can be used in a 2D
 * editor, too.
 * 
 * @author IBM Corporation (original comments of 2D version)
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 26.11.2007
 * @see org.eclipse.draw2d.Connection
 */
public interface Connection3D extends IFigure3D, Connection {
	/**
	 * Returns the PointList containing the Points that make up this Connection
	 * by reference. Note that simply changing the points does not update the
	 * connection, as no notification is generated. In order to update the
	 * connection, {@link #setPoints3D(List)} must be called, even if the same
	 * list is returned.
	 * 
	 * @return The points for this Connection
	 */
	PointList3D getPoints3D();

	/**
	 * Sets the PointList containing the Points that make up this Connection,
	 * erases this figure and erase();notifies attached listeners.
	 * 
	 * @param list The points for this Connection
	 */
	void setPoints3D(List<IVector3f> list);

}
