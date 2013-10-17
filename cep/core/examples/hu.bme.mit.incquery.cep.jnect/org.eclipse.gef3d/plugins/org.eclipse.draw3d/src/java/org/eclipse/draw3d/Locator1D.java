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
package org.eclipse.draw3d;

/**
 * A locator that calculates the location of a point along a singular axis.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 20.09.2009
 */
public interface Locator1D {

	/**
	 * Absolute locator that locates a point at a given fixed distance from 0 or
	 * the length given to {@link #getLocation(float)}.
	 * 
	 * @author Kristian Duske
	 * @version $Revision$
	 * @since 20.09.2009
	 */
	public class Absolute implements Locator1D {

		/**
		 * Position at the beginning or end of the axis.
		 * 
		 * @author Kristian Duske
		 * @version $Revision$
		 * @since 20.09.2009
		 */
		public enum Position {
			/**
			 * Position at the beginning.
			 */
			BEGINNING,
			/**
			 * Position at the end.
			 */
			END
		}

		private float m_offset;

		private Absolute.Position m_position;

		/**
		 * Creates a new absolute locator at the given position and offset.
		 * 
		 * @param i_position the position
		 * @param i_offset the offset
		 */
		public Absolute(Position i_position, float i_offset) {

			if (i_position == null)
				throw new NullPointerException("i_position must not be null");

			m_position = i_position;
			m_offset = Math.max(0, i_offset);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.BorderAnchor3D.RelativeLocator1D#getLocation(float)
		 */
		public float getLocation(float i_length) {

			if (m_position == Position.BEGINNING)
				return Math.min(m_offset, i_length);

			return Math.max(0, i_length - m_offset);
		}

	}

	/**
	 * A locator that positions a point at a relative distance.
	 * 
	 * @author Kristian Duske
	 * @version $Revision$
	 * @since 20.09.2009
	 */
	public class Relative implements Locator1D {

		private float m_weight;

		/**
		 * Creates a new relative locator with the given weights. The weights
		 * specifies the relative offset between 0 and 1.
		 * 
		 * @param i_weight the weights, must be greater or equal to 0 and less or
		 *            equal to 1
		 */
		public Relative(float i_weight) {

			if (i_weight < 0 || i_weight > 1)
				throw new IllegalArgumentException(
					"weights must be 0 <= weights <= 1, was " + i_weight);

			m_weight = i_weight;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.Locator1D#getLocation(float)
		 */
		public float getLocation(float i_length) {

			return m_weight * i_length;
		}

	}

	/**
	 * Returns the new location a point in relation to the given length of the
	 * axis.
	 * 
	 * @param i_length the length of the axis
	 * @return the locationO
	 */
	public float getLocation(float i_length);
}