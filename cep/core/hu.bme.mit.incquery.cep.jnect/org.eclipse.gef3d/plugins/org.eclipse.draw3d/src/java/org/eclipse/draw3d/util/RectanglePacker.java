/*******************************************************************************
 * Copyright (c) 2010 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * An algorithm that attempts to pack rectangles as tightly as possible into a
 * square. This algorithm was based on ideas presented in &quot;Two-Dimensional
 * Finite Bin-Packing Algorithms&quot; by J. 0. Berkey and P. Y. Wang (DUI
 * 0160-5682/87).
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 05.01.2010
 */
public class RectanglePacker<T> {

	private class Strip {

		private int m_height = 0;

		private int m_x = 0;

		private int m_y;

		public Strip(int i_y, Rectangle i_firstRectangle) {

			m_y = i_y;
			m_height = i_firstRectangle.height;

			add(i_firstRectangle);
		}

		public boolean add(Rectangle i_rectangle) {

			if (i_rectangle.width > getLength() - m_x
				|| i_rectangle.height > m_height)
				return false;

			i_rectangle.x = m_x;
			i_rectangle.y = m_y;
			m_x += i_rectangle.width;

			return true;
		}
	}

	private Comparator<Rectangle> m_comparator = new Comparator<Rectangle>() {

		public int compare(Rectangle i_r1, Rectangle i_r2) {

			if (i_r1.height < i_r2.height)
				return -1;

			if (i_r1.height > i_r2.height)
				return 1;

			return 0;
		}
	};

	private int m_length = 16;

	private boolean m_packed = false;

	private Map<T, Rectangle> m_rectangles = new HashMap<T, Rectangle>();

	private List<Strip> m_strips = new LinkedList<Strip>();

	private int m_totalHeight = 0;

	public void add(int i_w, int i_h, T i_data) {

		if (m_packed)
			throw new IllegalStateException(this + " is already packed");

		m_rectangles.put(i_data, new Rectangle(0, 0, i_w, i_h));
	}

	public int getLength() {

		return m_length;
	}

	public Point getPosition(T i_data, Point io_result) {

		Point result = io_result;
		if (result == null)
			result = new Point();

		Rectangle rectangle = m_rectangles.get(i_data);
		result.x = rectangle.x;
		result.y = rectangle.y;

		return result;
	}

	public void pack() {

		if (m_packed)
			throw new IllegalStateException(this + " is already packed");

		List<Rectangle> sorted =
			new ArrayList<Rectangle>(m_rectangles.values());

		Collections.sort(sorted, m_comparator);
		for (Rectangle rectangle : sorted)
			pack(rectangle);

		m_packed = true;
	}

	private void pack(Rectangle i_rectangle) {

		// find strip that can contain the rectangle
		for (Strip strip : m_strips)
			if (strip.add(i_rectangle))
				return;

		// create new strip
		while (i_rectangle.height > m_length - m_totalHeight
			|| i_rectangle.width > m_length)
			m_length *= 2;

		m_strips.add(new Strip(m_totalHeight, i_rectangle));
		m_totalHeight += i_rectangle.height;
	}
}
