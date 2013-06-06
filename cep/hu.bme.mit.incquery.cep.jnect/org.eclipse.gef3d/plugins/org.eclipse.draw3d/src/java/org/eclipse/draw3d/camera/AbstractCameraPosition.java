/*******************************************************************************
 * Copyright (c) 2011 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.camera;

import org.eclipse.draw3d.geometry.IVector3f;

/**
 * AbstractCameraPosition There should really be more documentation here.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @version $Revision$
 * @since May 22, 2011
 */
public abstract class AbstractCameraPosition implements ICameraPosition {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.ICameraPosition#getPosition()
	 */
	public IVector3f getPosition() {
		return getPosition(null);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.ICameraPosition#getViewDirection()
	 */
	public IVector3f getViewDirection() {
		return getViewDirection(null);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.ICameraPosition#getUpVector()
	 */
	public IVector3f getUpVector() {
		return getUpVector(null);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.camera.ICameraPosition#getRightVector()
	 */
	public IVector3f getRightVector() {
		return getRightVector(null);
	}

}
