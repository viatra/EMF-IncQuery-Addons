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
package org.eclipse.gef3d.handles;

import org.eclipse.draw3d.IFigure3D;
import org.eclipse.draw3d.geometry.IBoundingBox;
import org.eclipse.gef.handles.HandleBounds;


/**
 * HandleBounds3D is the 3D version of {@link HandleBounds}. It is used by 
 * {@link RelativeHandleLocator3D}. If a figure doesn't implement this
 * interface, the regular bounds of the figure are used instead.
 *
 * @author Randy Hudson (hudsonr) (original 2D version)
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	Mar 25, 2008
 */
public interface HandleBounds3D extends HandleBounds, IFigure3D {

	/**
	 * Returns the bounding box around which handles are to be placed. 
	 * The bounding box should be in the same coordinate system as the figure 
	 * itself.
	 * 
	 * 
	 * @return The rectangle used for handles
	 */
	IBoundingBox getHandleBounds3D();

}
