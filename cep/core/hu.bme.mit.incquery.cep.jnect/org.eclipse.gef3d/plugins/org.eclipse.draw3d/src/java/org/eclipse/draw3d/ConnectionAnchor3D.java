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

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Vector3f;

/**
 * 3D version of connection anchor.
 * 
 * @author IBM Corporation (original comments of 2D version)
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 22.10.2007
 */
public interface ConnectionAnchor3D extends ConnectionAnchor {

	/**
	 * Returns the location where the connection should be anchored in absolute
	 * world coordinates. The anchor may use the given reference Point to
	 * calculate this location.
	 * 
	 * @param i_reference the reference Point in absolute coordinates
	 * @param o_result the result vector, if <code>null</code> a new vector will
	 *            be created
	 * @return The anchor's location
	 */
	public IVector3f getLocation3D(IVector3f i_reference, Vector3f o_result);

	/**
	 * Returns the reference point for this anchor in absolute world
	 * coordinates. This might be used by another anchor to determine its own
	 * location (i.e. {@link ChopboxAnchor}).
	 * 
	 * @param o_result the result vector, if <code>null</code> a new vector will
	 *            be created
	 * @return The reference Point
	 */
	public IVector3f getReferencePoint3D(Vector3f o_result);

}
