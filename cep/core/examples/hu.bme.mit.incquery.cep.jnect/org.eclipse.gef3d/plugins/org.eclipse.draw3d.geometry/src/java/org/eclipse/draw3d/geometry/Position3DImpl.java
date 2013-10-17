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
 * Implementation of {@link Position3D} with a backing {@link BoundingBox}
 * object.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Jan 21, 2009
 * @see BoundingBox
 */
public class Position3DImpl extends AbstractPosition3D {

	private IHost3D host;

	private BoundingBoxImpl bounds3D;

	/**
	 * @param i_host, must not be null
	 */
	public Position3DImpl(IHost3D i_host) {
		if (i_host == null) // parameter precondition
			throw new NullPointerException(
				"i_host must not be null, use empty constructor instead");

		host = i_host;
		bounds3D = new BoundingBoxImpl();
	}

	/**
	 * Host class used for absolute positions.
	 * 
	 * @author Jens von Pilgrim (developer@jevopi.de)
	 * @version $Revision$
	 * @since Apr 26, 2011
	 */
	protected class NoHost extends AbstractHost3D {

		public NoHost() {
			super(null);
		}

		public Position3D getPosition3D() {
			return Position3DImpl.this;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "no host";
		}

	}

	/**
	 * Creates a position with a dummy host, i.e. {@link #getHost()} will no
	 * return null. <strong>It is recommend to use
	 * {@link Position3DUtil#createAbsolutePosition()} which creates an instance
	 * of this class, since this makes the purpose clear.</strong>
	 */
	public Position3DImpl() {
		bounds3D = new BoundingBoxImpl();
		host = new NoHost();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IPosition3D#getHost()
	 */
	public IHost3D getHost() {
		return host;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IPosition3D#getBounds3D()
	 */
	public IBoundingBox getBounds3D() {
		return bounds3D;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IPosition3D#getLocation3D()
	 */
	public IVector3f getLocation3D() {
		return bounds3D.m_position;
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

		bounds3D.setLocation(i_point.getX(), i_point.getY(), i_point.getZ());

		invalidate();

		firePositionChanged(PositionHint.LOCATION, delta);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.geometry.IPosition3D#getSize3D()
	 */
	public IVector3f getSize3D() {
		return bounds3D.m_size;
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

		bounds3D.setSize(i_size);

		invalidate();

		firePositionChanged(PositionHint.SIZE, delta);
	}

}
