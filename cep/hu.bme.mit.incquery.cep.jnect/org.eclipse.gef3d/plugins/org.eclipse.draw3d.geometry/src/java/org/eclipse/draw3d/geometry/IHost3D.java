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
 * Host (or context) of a position. The {@link IPosition3D} is a kind of policy,
 * the {@link IHost3D} is its context. Also, the host observes its position and
 * is notified when it changes.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Jan 21, 2009
 */
public interface IHost3D {

	/**
	 * Returns the position of this 3D object. This may return null. If it is
	 * not null,
	 * <code>{@link #getPosition3D()}.{@link IPosition3D#getHost()}==this</code>
	 * must be true.
	 * 
	 * @return
	 * @see IPosition3D#getHost()
	 */
	public Position3D getPosition3D();

	/**
	 * Returns the parent of this object, that is the parent according to a
	 * scene graph. This is usually the parent figure.
	 * 
	 * @return parent host or null, if no such parent is available
	 */
	public IHost3D getParentHost3D();

	/**
	 * Called by host's position when updated.
	 * 
	 * @param hint flags indicating what components (location, rotation, size)
	 *            had been changed
	 * @param delta the delta of the changed property (new-old)
	 */
	public void positionChanged(EnumSet<PositionHint> hint, IVector3f delta);

}
