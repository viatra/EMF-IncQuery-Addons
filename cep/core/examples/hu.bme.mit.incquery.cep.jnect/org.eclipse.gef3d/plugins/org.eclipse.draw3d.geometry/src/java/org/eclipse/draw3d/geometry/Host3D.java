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


/**
 * Simple host for {@link Position3D}, enables a position to be "linked" into an
 * object tree, i.e. to make the position relative, without the need to
 * implement the {@link IHost3D} by the "real" object.
 * <p>
 * This class is rarely used, an example can be found in the shape
 * {@link ConeFigureShape}.
 * </p>
 * <p>
 * If you do not have a parent, i.e. an absolute position, you may use
 * {@link Position3DImpl#Position3DImpl()} which creates a position with a dummy
 * host.
 * </p>
 * <p>
 * <strong>It is recommend to use
 * {@link Position3DUtil#createRelativePosition(IHost3D)} which creates an
 * instance of this class, since this makes the purpose clear.</strong>
 * </p>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Jan 22, 2009
 */
public class Host3D extends AbstractHost3D {

	Position3D position3D;

	/**
	 * Creates this dummy host with a position3D. The parent must not be null,
	 * since this is the whole idea about this host: to make the position
	 * relative. If you do not have a parent, i.e. an absolute position, you may
	 * use {@link Position3DImpl#Position3DImpl()} which creates a position with
	 * a dummy host.
	 * 
	 * @param i_parent must not be null
	 */
	public Host3D(IHost3D i_parent) {
		super(i_parent);
		position3D = new Position3DImpl(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IHost3D#getPosition3D()
	 */
	public Position3D getPosition3D() {
		return position3D;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "host, relative position";
	}

}
