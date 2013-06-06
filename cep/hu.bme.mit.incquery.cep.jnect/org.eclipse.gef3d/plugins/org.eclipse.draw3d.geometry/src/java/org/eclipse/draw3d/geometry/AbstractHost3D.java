/*******************************************************************************
 * Copyright (c) 2009 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.geometry;

import java.util.EnumSet;

import org.eclipse.draw3d.geometry.IPosition3D.PositionHint;

/**
 * Basic host implementation, can be used by other classes as base class.
 *
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	Jan 21, 2009
 */
public abstract class AbstractHost3D implements IHost3D {
	
	protected IHost3D parent;
	
	

	/**
	 * @param i_parent
	 */
	public AbstractHost3D(IHost3D i_parent) {
		super();
		parent = i_parent;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.draw3d.geometry.IHost3D#getParentHost3D()
	 */
	public IHost3D getParentHost3D() {
		return parent;
	}

	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.draw3d.geometry.IHost3D#positionChanged(java.util.EnumSet, org.eclipse.draw3d.geometry.IVector3f)
	 */
	public void positionChanged(EnumSet<PositionHint> i_hint, IVector3f i_delta) {
		
	}

}
