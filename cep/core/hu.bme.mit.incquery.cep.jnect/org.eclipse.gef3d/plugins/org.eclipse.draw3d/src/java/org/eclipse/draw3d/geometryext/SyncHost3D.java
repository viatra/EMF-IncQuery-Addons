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
package org.eclipse.draw3d.geometryext;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw3d.geometry.IHost3D;
import org.eclipse.draw3d.geometry.Position3D;

/**
 * Host of a {@link SynchronizedPosition3DImpl} providing the 2D bounds
 * information.
 * <p>
 * Note that
 * {@link #positionChanged(java.util.EnumSet, org.eclipse.draw3d.geometry.IVector3f)}
 * is only called if the {@link SynchronizedPosition3DImpl} had been changed by
 * calling a setter defined in {@link Position3D}, and not by changing the
 * backing 2D {@link Rectangle} object.
 * </p>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Jan 21, 2009
 */
public interface SyncHost3D extends IHost3D {

	/**
	 * Returns rectangle representing the bounds of a 2D figure.
	 * 
	 * @return
	 */
	public Rectangle getBounds();

	/**
	 * Sets the bounds of this host.
	 */
	public void setBounds(Rectangle rect);

}
