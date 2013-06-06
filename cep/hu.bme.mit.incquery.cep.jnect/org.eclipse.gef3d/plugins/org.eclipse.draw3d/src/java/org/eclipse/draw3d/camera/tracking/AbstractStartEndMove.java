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
package org.eclipse.draw3d.camera.tracking;

import org.eclipse.draw3d.camera.ICameraPosition;

/**
 * Abstract camera move with a target.
 *
 * @author 	Jens von Pilgrim (developer@jevopi.de)
 * @version	$Revision$
 * @since 	May 22, 2011
 */
public abstract class AbstractStartEndMove implements ICameraMove {

	ICameraPosition startPosition;
	ICameraPosition endPosition;
	
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.draw3d.camera.tracking.ICameraMove#init(org.eclipse.draw3d.camera.ICameraPosition, org.eclipse.draw3d.camera.ICameraPosition)
	 */
	public ICameraPosition init(ICameraPosition i_startPosition,
		ICameraPosition i_endPosition) {
		startPosition = i_startPosition;
		endPosition = i_endPosition;
		return endPosition;
	}
	
	/**
	 * @return the startPosition
	 */
	public ICameraPosition getStartPosition() {
		return startPosition;
	}
	
	/**
	 * @return the endPosition
	 */
	public ICameraPosition getEndPosition() {
		return endPosition;
	}
	

}
