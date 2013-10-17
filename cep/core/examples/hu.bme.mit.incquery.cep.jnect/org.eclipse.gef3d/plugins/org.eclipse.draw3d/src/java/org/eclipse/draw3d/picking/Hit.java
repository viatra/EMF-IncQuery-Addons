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
package org.eclipse.draw3d.picking;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw3d.IFigure3D;
import org.eclipse.draw3d.geometry.Vector3f;

/**
 * A picking hit.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 31.07.2009
 */
public interface Hit {

	/**
	 * Returns the distance between the starting point of the picking ray and
	 * the world location of this hit.
	 * 
	 * @return the distance
	 */
	public float getDistance();

	/**
	 * The 3D figure that was hit by the pick ray.
	 * 
	 * @return the 3D figure
	 */
	public IFigure3D getFigure3D();

	/**
	 * The figure that was hit by the picking operation. This is either the 3D
	 * figure returned by {@link #getFigure3D()} or a 2D figure on surface of
	 * the 3D figure if such a figure was hit by the picking ray and if it was
	 * accepted by the search.
	 * 
	 * @return the search result
	 */
	public IFigure getSearchResult();

	/**
	 * Returns the world location of this hit, in other words the world location
	 * of the point of intersection between the picking ray and the hit figure.
	 * 
	 * @param o_result the result vector, if <code>null</code> , a new vector
	 *            will be returned
	 * @return the world location
	 */
	public Vector3f getWorldLocation(Vector3f o_result);
}
