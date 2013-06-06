/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Vector3f;

/**
 * 3D version of AbstractConnectionAnchor. Since this class extends
 * {@link AbstractConnectionAnchor}, it could be used instead of this class,
 * too.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 22.10.2007
 * 
 */
public abstract class AbstractConnectionAnchor3D extends AbstractConnectionAnchor
		implements ConnectionAnchor3D {

	/**
	 * Creates a new anchor.
	 */
	public AbstractConnectionAnchor3D() {
		// nothing to initialize
	}

	/**
	 * Creates a new anchor that belongs to the given owner.
	 * 
	 * @param i_owner the owner of this connection anchor
	 */
	public AbstractConnectionAnchor3D(IFigure i_owner) {

		super(i_owner);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.ConnectionAnchor#getLocation(org.eclipse.draw2d.geometry.Point)
	 */
	public Point getLocation(Point i_reference) {
		// TODO implement method AbstractConnectionAnchor3D.getLocation
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.ConnectionAnchor3D#getLocation3D(IVector3f,
	 *      org.eclipse.draw3d.geometry.Vector3f)
	 */
	public IVector3f getLocation3D(IVector3f i_reference,
			Vector3f io_result) {
		// TODO implement method AbstractConnectionAnchor3D.getLocation3D
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.ConnectionAnchor3D#getReferencePoint3D()
	 */
	public IVector3f getReferencePoint3D(Vector3f io_result) {
		// TODO implement method AbstractConnectionAnchor3D.getReferencePoint3D
		return null;
	}
}
