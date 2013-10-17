/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d;

import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw3d.geometry.IVector3f;

/**
 * An IFigure3D that can be rotated by setting a reference point.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 17.05.2008
 */
public interface RotatableDecoration3D extends IFigure3D, RotatableDecoration {

	/**
	 * Sets the reference point to determine the rotation angles.
	 * 
	 * @param i_reference the reference point
	 */
	public void setReferencePoint3D(IVector3f i_reference);
}
