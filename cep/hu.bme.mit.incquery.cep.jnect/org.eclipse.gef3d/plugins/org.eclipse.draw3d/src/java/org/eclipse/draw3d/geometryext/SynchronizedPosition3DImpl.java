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
import org.eclipse.draw3d.geometry.AbstractPosition3D;
import org.eclipse.draw3d.geometry.IBoundingBox;
import org.eclipse.draw3d.geometry.IHost3D;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Position3D;
import org.eclipse.draw3d.geometry.Vector3fImpl;

/**
 * Mutable implementation of {@link Position3D}, based on a synchronized bounds
 * object. That is the properties of this 3D position object is synchronized via
 * {@link SyncedBounds3D} with a 2D object.
 * <p>
 * Note hat
 * {@link IHost3D#positionChanged(java.util.EnumSet, org.eclipse.draw3d.geometry.IVector3f)}
 * is only called this object had been changed by calling a setter defined in
 * {@link Position3D}, and not by changing the backing 2D {@link Rectangle}
 * object.
 * </p>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Jan 21, 2009
 */
public class SynchronizedPosition3DImpl extends AbstractPosition3D {

	private SyncedBounds3D bounds3D;

	private SyncHost3D host;

	/**
	 * @param i_syncHost, must not be null here!
	 */
	public SynchronizedPosition3DImpl(SyncHost3D i_syncHost) {
		if (i_syncHost == null) // parameter precondition
			throw new NullPointerException("i_syncHost must not be null");

		host = i_syncHost;
		bounds3D = new SyncedBounds3D();
		bounds3D.setDepth(1);
		m_rotationAngles = new Vector3fImpl(0, 0, 0);
		m_updatingBounds = false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IPosition3D#getBounds3D()
	 */
	public IBoundingBox getBounds3D() {
		return bounds3D.getBoundingBox(host.getBounds());
	}

	/**
	 * {@inheritDoc}
	 * This will always return an {@link SyncHost3D}.
	 * 
	 * @see org.eclipse.draw3d.geometry.IPosition3D#getHost()
	 */
	public IHost3D getHost() {
		return host;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IPosition3D#getLocation3D()
	 */
	public IVector3f getLocation3D() {
		return bounds3D.getLocation3D(host.getBounds());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IPosition3D#getSize3D()
	 */
	public IVector3f getSize3D() {
		return bounds3D.getSize3D(host.getBounds());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Position3D#setLocation3D(org.eclipse.draw3d.geometry.IVector3f)
	 */
	public void setLocation3D(IVector3f i_point) {
		if (i_point == null) // parameter precondition
			throw new NullPointerException("i_point must not be null");

		if (getLocation3D().equals(i_point))
			return;

		Vector3fImpl delta = new Vector3fImpl();
		Math3D.sub(i_point, getLocation3D(), delta);

		Rectangle newBounds = bounds3D.setBounds3D(i_point, getSize3D());

		if (delta.x != 0 || delta.y != 0)
			host.setBounds(newBounds);

		// This forces the synced bounds update the location vector.
		// While this has no direct effect here, a client may has cached
		// the location vector.
		getLocation3D();

		invalidate();

		firePositionChanged(PositionHint.LOCATION, delta);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.Position3D#setSize3D(org.eclipse.draw3d.geometry.IVector3f)
	 */
	public void setSize3D(IVector3f i_size) {
		if (i_size == null) // parameter precondition
			throw new NullPointerException("i_size must not be null");
		// if (i_size.getX() < 0 || i_size.getY() < 0 || i_size.getZ() < 0) //
		// parameter
		// // precondition
		// throw new IllegalArgumentException(
		// "no value of given vector must be less 0, , was " + i_size);

		IVector3f size3D = getSize3D();

		if (size3D.equals(i_size))
			return;

		Vector3fImpl delta = new Vector3fImpl();
		Math3D.sub(i_size, size3D, delta);

		Rectangle newBounds = bounds3D.setBounds3D(getLocation3D(), i_size);
		if (delta.x != 0 || delta.y != 0)
			host.setBounds(newBounds);

		// This forces the synced bounds update the location vector.
		// While this has no direct effect here, a client may has cached
		// the size vector.
		getLocation3D();

		invalidate();

		firePositionChanged(PositionHint.SIZE, delta);
	}

}
