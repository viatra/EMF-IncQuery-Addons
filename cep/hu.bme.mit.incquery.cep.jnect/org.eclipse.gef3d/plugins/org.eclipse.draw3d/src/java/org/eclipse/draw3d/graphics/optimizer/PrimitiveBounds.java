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
package org.eclipse.draw3d.graphics.optimizer;

/**
 * Simple representation of a 2D paraxial bounding box.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 02.12.2009
 */
public class PrimitiveBounds {

	private float m_x, m_y, m_width, m_height, m_xPlusWidth, m_yPlusHeight;

	/**
	 * Creates the smallest paraxial bounding box that contains all vertices in
	 * the given vertex array.
	 * 
	 * @param i_vertices the vertex data
	 * @throws NullPointerException if the given array is <code>null</code>
	 * @throws IllegalArgumentException if the given array contains less than 1
	 *             vertex or an odd number of elements
	 */
	public PrimitiveBounds(float[] i_vertices) {

		if (i_vertices == null)
			throw new NullPointerException("i_vertices must not be null");

		if (i_vertices.length < 2)
			throw new IllegalArgumentException(
				"i_vertices must contain at least one vertex");

		if (i_vertices.length % 2 != 0)
			throw new IllegalArgumentException(
				"i_vertices must contain an equal number of elements");

		m_x = i_vertices[0];
		m_y = i_vertices[1];
		m_width = 0;
		m_height = 0;
		m_xPlusWidth = m_x;
		m_yPlusHeight = m_y;

		float x, y;
		for (int i = 1; i < i_vertices.length / 2; i++) {
			x = i_vertices[2 * i];
			y = i_vertices[2 * i + 1];

			if (x < m_x) {
				m_x = x;
				m_xPlusWidth = m_x + m_width;
			} else if (x > m_xPlusWidth) {
				m_width = x - m_x;
				m_xPlusWidth = m_x + m_width;
			}

			if (y < m_y) {
				m_y = y;
				m_yPlusHeight = y + m_height;
			} else if (y > m_yPlusHeight) {
				m_height = y - m_y;
				m_yPlusHeight = m_y + m_height;
			}
		}
	}

	/**
	 * Indicates whether the given paraxial bounding box is contained entirely
	 * within this bounding box.
	 * 
	 * @param i_bounds the bounding box to check
	 * @return <code>true</code> if the given paraxial bounding box is contained
	 *         within this bounding box and <code>false</code> otherwise
	 */
	public boolean contains(PrimitiveBounds i_bounds) {

		if (i_bounds == null)
			throw new NullPointerException("i_bounds must not be null");

		if (i_bounds.getX() <= m_x)
			return false;

		if (i_bounds.getXPlusWidth() >= getXPlusWidth())
			return false;

		if (i_bounds.getY() <= m_y)
			return false;

		if (i_bounds.getYPlusHeight() >= getYPlusHeight())
			return false;

		return true;
	}

	/**
	 * The height of this bounding box.
	 * 
	 * @return the height of this bounding box
	 */
	public float getHeight() {

		return m_height;
	}

	/**
	 * The width of this bounding box.
	 * 
	 * @return the width of this bounding box
	 */
	public float getWidth() {

		return m_width;
	}

	/**
	 * The X position of this bounding box.
	 * 
	 * @return the X position of this bounding box
	 */
	public float getX() {

		return m_x;
	}

	/**
	 * The sum of the X position and the width of this bounding box.
	 * 
	 * @return the sum of the X position and the width of this bounding box
	 */
	public float getXPlusWidth() {

		return m_xPlusWidth;
	}

	/**
	 * The Y position of this bounding box.
	 * 
	 * @return the Y position of this bounding box
	 */
	public float getY() {

		return m_y;
	}

	/**
	 * The sum of the Y position and the height of this bounding box.
	 * 
	 * @return the sum of the Y position and the height of this bounding box
	 */
	public float getYPlusHeight() {

		return m_yPlusHeight;
	}

	/**
	 * Indicates whether the given paraxial bounding box intersects with this
	 * bounding box. Does not check for containment.
	 * 
	 * @param i_bounds the paraxial bounding box to check
	 * @return <code>true</code> if this paraxial bounding box intersects with
	 *         the given paraxial bounding box and <code>false</code> otherwise
	 * @throws NullPointerException if the given bounding box is
	 *             <code>null</code>
	 */
	public boolean intersects(PrimitiveBounds i_bounds) {

		if (i_bounds == null)
			throw new NullPointerException("i_bounds must not be null");

		if (i_bounds.getX() > getXPlusWidth())
			return false;

		if (i_bounds.getXPlusWidth() < m_x)
			return false;

		if (i_bounds.getY() > getYPlusHeight())
			return false;

		if (i_bounds.getYPlusHeight() < m_y)
			return false;

		return true;
	}

	@Override
	public String toString() {

		return "PrimitiveBounds [m_x=" + m_x + ", m_y=" + m_y + ", m_width="
			+ m_width + ", m_height=" + m_height + "]";
	}
}
