/*******************************************************************************
 * Copyright (c) 2009 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.picking;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw3d.IFigure3D;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;

/**
 * A mutable implementation of the {@link Hit} interface.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 31.07.2009
 */
public class HitImpl implements Hit {

	private float m_distance;

	private IFigure3D m_figure;

	private IVector3f m_rayDirection;

	private IVector3f m_rayOrigin;

	private IFigure m_searchResult;

	private Vector3f m_wLocation;

	/**
	 * Creates a new hit with the given figure and distance.
	 * 
	 * @param i_figure the 3D figure that was hit
	 * @param i_searchResult the search result
	 * @param i_distance the distance of the hit point to the origin of the
	 *            picking ray
	 * @param i_rayOrigin the origin of the picking ray
	 * @param i_rayDirection the direction of the picking ray
	 * @throws NullPointerException if the given figure or any of the given
	 *             vectors is <code>null</code>
	 */
	public HitImpl(IFigure3D i_figure, IFigure i_searchResult,
			float i_distance, IVector3f i_rayOrigin, IVector3f i_rayDirection) {

		if (i_figure == null)
			throw new NullPointerException("i_figure must not be null");

		if (i_searchResult == null)
			throw new NullPointerException("i_searchResult must not be null");

		if (i_rayOrigin == null)
			throw new NullPointerException("i_rayOrigin must not be null");

		if (i_rayDirection == null)
			throw new NullPointerException("i_rayDirection must not be null");

		m_figure = i_figure;
		m_searchResult = i_searchResult;
		m_distance = i_distance;
		m_rayOrigin = i_rayOrigin;
		m_rayDirection = i_rayDirection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.picking.Hit#getDistance()
	 */
	public float getDistance() {

		return m_distance;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.picking.Hit#getFigure3D()
	 */
	public IFigure3D getFigure3D() {

		return m_figure;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.picking.Hit#getSearchResult()
	 */
	public IFigure getSearchResult() {

		return m_searchResult;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.picking.Hit#getWorldLocation(org.eclipse.draw3d.geometry.Vector3f)
	 */
	public Vector3f getWorldLocation(Vector3f o_result) {

		Vector3f result = o_result;
		if (result == null)
			result = new Vector3fImpl();

		if (m_wLocation == null) {
			m_wLocation = new Vector3fImpl(m_rayDirection);
			m_wLocation.scale(m_distance);
			Math3D.add(m_rayOrigin, m_wLocation, m_wLocation);
		}

		result.set(m_wLocation);
		return result;
	}

	/**
	 * Indicates whether this hit is closer than the given hit (to the origin of
	 * the picking ray).
	 * 
	 * @param i_hit the hit to compare with
	 * @return <code>true</code> if this hit is closer than the given hit and
	 *         <code>false</code> otherwise
	 * @throws NullPointerException if the given hit is <code>null</code>
	 */
	public boolean isCloserThan(Hit i_hit) {

		if (i_hit == null)
			throw new NullPointerException("i_hit must not be null");

		return m_distance < i_hit.getDistance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		StringBuilder b = new StringBuilder();

		b.append("Hit[figure=");
		b.append(m_figure);
		b.append(", distance: ");
		b.append(m_distance);
		b.append(", world: ");
		b.append(m_wLocation);
		b.append("]");

		return b.toString();
	}

}
