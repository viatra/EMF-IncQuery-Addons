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
package org.eclipse.draw3d.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.eclipse.draw3d.geometry.IVector2f;
import org.eclipse.draw3d.geometry.Vector2f;
import org.eclipse.draw3d.geometry.Vector2fImpl;

/**
 * A fast algorithm for drawing smooth arcs using line segments. This
 * implementation is based on http://slabode.exofire.net/circle_draw.shtml.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 13.11.2009
 */
public class ArcHelper implements Iterable<IVector2f> {

	private class ArcIterator implements Iterator<IVector2f> {

		private Vector2f m_next = new Vector2fImpl();

		private Vector2f m_result = new Vector2fImpl();

		private int m_segment = 0;

		ArcIterator() {

			m_next.set(m_start);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see java.util.Iterator#hasNext()
		 */
		public boolean hasNext() {

			return m_segment <= m_numSegments;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see java.util.Iterator#next()
		 */
		public IVector2f next() {

			if (!hasNext())
				throw new NoSuchElementException();

			float x = m_next.getX();
			float y = m_next.getY();

			m_result.setX(x * m_axes.getX() + m_center.getX());
			m_result.setY(y * -m_axes.getY() + m_center.getY());
			m_segment++;

			if (hasNext()) {
				float t = x;
				x = m_cos * x - m_sin * y;
				y = m_sin * t + m_cos * y;

				m_next.set(x, y);
			}

			return m_result;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see java.util.Iterator#remove()
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	private static final float PI2 = (float) Math.PI * 2;

	IVector2f m_axes;

	IVector2f m_center;

	float m_cos;

	int m_numSegments;

	float m_sin;

	IVector2f m_start;

	private boolean m_skipFinal;

	/**
	 * Creates a new helper for drawing an ellipse arc with the given
	 * parameters.
	 * 
	 * @param i_precision a precision factor, must be greater than 0 and less
	 *            than or equal to 1
	 * @param i_x the X coordinate of the ellipse's bounding box
	 * @param i_y the Y coordinate of the ellipse's bounding box
	 * @param i_width the width of the bounding box
	 * @param i_height the height of the bounding box
	 * @param i_start the start angle, in radians
	 * @param i_length the angle length, in radians
	 * @param i_skipFinal skip the final vertex
	 */
	public ArcHelper(float i_precision, float i_x, float i_y, float i_width,
			float i_height, float i_start, float i_length, boolean i_skipFinal) {

		if (i_precision <= 0 || i_precision > 1)
			throw new IllegalArgumentException(
				"precision must be greater than 0 and less than or equal to 1");

		float start = i_start % PI2;
		float length = i_length;

		m_axes = new Vector2fImpl(i_width / 2, i_height / 2);
		m_center = new Vector2fImpl(i_x + m_axes.getX(), i_y + m_axes.getY());

		float avgRadius = (m_axes.getX() + m_axes.getY()) / 2;
		m_numSegments =
			(int) Math.ceil(i_precision * 10 * Math.sqrt(avgRadius)
				* Math.abs(length) / PI2);

		float theta = length / m_numSegments;

		m_skipFinal = i_skipFinal;
		if (m_skipFinal)
			m_numSegments--;

		m_cos = (float) Math.cos(theta);
		m_sin = (float) Math.sin(theta);

		m_start =
			new Vector2fImpl((float) Math.cos(start), (float) Math.sin(start));
	}

	/**
	 * Returns a new array containing all vertices of this arc.
	 * 
	 * @return the new array
	 */
	public float[] getArray() {

		return getArray(new float[2 * getNumVertices()], 0);
	}

	/**
	 * Adds all vertices of this arc to the given array, starting at position 0.
	 * 
	 * @param i_array the array to fill
	 * @return the given array
	 * @throws NullPointerException if the given array is <code>null</code>
	 * @throws IllegalArgumentException if the given array is too small to
	 *             contain all vertices
	 */
	public float[] getArray(float[] i_array) {

		return getArray(i_array, 0);
	}

	/**
	 * Adds all vertices of this arc to the given array, starting at the given
	 * offset.
	 * 
	 * @param i_array the array to fill
	 * @param i_offset the offset position in the array
	 * @return the given array
	 * @throws NullPointerException if the given array is <code>null</code>
	 * @throws IllegalArgumentException if the given array is too small to
	 *             contain all vertices
	 */
	public float[] getArray(float[] i_array, int i_offset) {

		if (i_array.length - i_offset < 2 * getNumVertices())
			throw new IllegalArgumentException("i_array is too small");

		int i = 0;
		for (IVector2f v : this) {
			i_array[i_offset + 2 * i] = v.getX();
			i_array[i_offset + 2 * i + 1] = v.getY();
			i++;
		}

		return i_array;
	}

	/**
	 * Returns the number of vertices in this arc.
	 * 
	 * @return the number of vertices
	 */
	public int getNumVertices() {

		return m_numSegments + 1;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<IVector2f> iterator() {

		return new ArcIterator();
	}
}
