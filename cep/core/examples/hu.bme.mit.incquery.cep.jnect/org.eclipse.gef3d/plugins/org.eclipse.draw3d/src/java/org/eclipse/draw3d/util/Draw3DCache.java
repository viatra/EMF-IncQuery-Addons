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

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Logger;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw3d.geometry.Math3DCache;

/**
 * Extends {@link org.eclipse.draw3d.geometry.Math3DCache} with support for
 * draw2d primitives. This way, only the plugin containing this class needs to
 * depend on draw2d.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 29.07.2009
 */
public class Draw3DCache extends Math3DCache {

	private static final Logger log =
		Logger.getLogger(Draw3DCache.class.getName());

	private static final Comparator<Object> m_bufferComparator =
		new Comparator<Object>() {
			public int compare(Object i_o1, Object i_o2) {

				int i1, i2;

				if (i_o1 instanceof Integer)
					i1 = (Integer) i_o1;
				else
					i1 = ((Buffer) i_o1).capacity();

				if (i_o2 instanceof Integer)
					i2 = (Integer) i_o2;
				else
					i2 = ((Buffer) i_o2).capacity();

				if (i1 < i2)
					return -1;

				return 0;
			}
		};

	private static final List<ByteBuffer> m_byteBuffer =
		new ArrayList<ByteBuffer>();

	private static int m_byteBufferCounter;

	private static final Queue<Dimension> m_dimension =
		new LinkedList<Dimension>();

	private static int m_dimensionCounter;

	private static final List<DoubleBuffer> m_doubleBuffer =
		new ArrayList<DoubleBuffer>();

	private static int m_doubleBufferCounter;

	private static final List<FloatBuffer> m_floatBuffer =
		new ArrayList<FloatBuffer>();

	private static int m_floatBufferCounter;

	private static final List<IntBuffer> m_intBuffer =
		new ArrayList<IntBuffer>();

	private static int m_intBufferCounter;

	private static final Queue<Point> m_point = new LinkedList<Point>();

	private static int m_pointCounter;

	private static Queue<Rectangle> m_rectangle = new LinkedList<Rectangle>();

	private static int m_rectangleCounter;

	private static ByteBuffer createByteBuffer(int i_capacity) {

		if (m_count) {
			m_byteBufferCounter++;
			if (m_byteBufferCounter > m_counterThreshold)
				log.warning("created more than " + m_counterThreshold
					+ " byte buffers, are you properly returning them?");
		}

		return BufferUtils.createByteBuffer(i_capacity);
	}

	private static Dimension createDimension() {

		if (m_count) {
			m_dimensionCounter++;
			if (m_dimensionCounter > m_counterThreshold)
				log.warning("created more than " + m_counterThreshold
					+ " dimensions, are you properly returning them?");
		}

		return new Dimension();
	}

	private static DoubleBuffer createDoubleBuffer(int i_capacity) {

		if (m_count) {
			m_doubleBufferCounter++;
			if (m_doubleBufferCounter > m_counterThreshold)
				log.warning("created more than " + m_counterThreshold
					+ " double buffers, are you properly returning them?");
		}

		return BufferUtils.createDoubleBuffer(i_capacity);
	}

	private static FloatBuffer createFloatBuffer(int i_capacity) {

		if (m_count) {
			m_floatBufferCounter++;
			if (m_floatBufferCounter > m_counterThreshold)
				log.warning("created more than " + m_counterThreshold
					+ " float buffers, are you properly returning them?");
		}

		return BufferUtils.createFloatBuffer(i_capacity);
	}

	private static IntBuffer createIntBuffer(int i_capacity) {

		if (m_count) {
			m_intBufferCounter++;
			if (m_intBufferCounter > m_counterThreshold)
				log.warning("created more than " + m_counterThreshold
					+ " int buffers, are you properly returning them?");
		}

		return BufferUtils.createIntBuffer(i_capacity);
	}

	private static Point createPoint() {

		if (m_count) {
			m_pointCounter++;
			if (m_pointCounter > m_counterThreshold)
				log.warning("created more than " + m_counterThreshold
					+ " points, are you properly returning them?");
		}

		return new Point();
	}

	private static Rectangle createRectangle() {

		if (m_count) {
			m_rectangleCounter++;
			if (m_rectangleCounter > m_counterThreshold)
				log.warning("created more than " + m_counterThreshold
					+ " rectangles, are you properly returning them?");
		}

		return new Rectangle();
	}

	private static <T extends Buffer> T doGetBuffer(List<T> i_buffers,
		int i_capacity) {

		int index =
			Collections.binarySearch(i_buffers, i_capacity, m_bufferComparator);

		if (index >= 0) {
			T buffer = i_buffers.remove(index);
			buffer.limit(i_capacity);
			return buffer;
		}

		return null;
	}

	private static <T extends Buffer> void doReturnBuffer(List<T> i_buffers,
		T i_buffer) {

		int index =
			Collections.binarySearch(i_buffers, i_buffer, m_bufferComparator);

		if (index < 0)
			index = -index - 1;

		i_buffers.add(index, i_buffer);
	}

	/**
	 * Returns a buffer with at least the given capacity. The returned buffer
	 * will be limited to the given capacity, but it will not be rewound.
	 * 
	 * @param i_capacity the desired minimum capacity
	 * @return a buffer with the desired minimum capacity
	 */
	public static ByteBuffer getByteBuffer(int i_capacity) {

		ByteBuffer buffer;
		if (m_synchronized)
			synchronized (m_byteBuffer) {
				buffer = doGetBuffer(m_byteBuffer, i_capacity);
			}
		else
			buffer = doGetBuffer(m_byteBuffer, i_capacity);

		if (buffer == null)
			buffer = createByteBuffer(i_capacity);
		else
			buffer.limit(i_capacity);

		return buffer;
	}

	/**
	 * Returns a cached {@link Dimension}.
	 * 
	 * @return a cached dimension
	 */
	public static Dimension getDimension() {

		if (m_synchronized) {
			synchronized (m_dimension) {
				if (m_dimension.isEmpty())
					return createDimension();
				else
					return m_dimension.remove();
			}
		} else {
			if (m_dimension.isEmpty())
				return createDimension();
			else
				return m_dimension.remove();
		}
	}

	/**
	 * Returns a buffer with at least the given capacity. The returned buffer
	 * will be limited to the given capacity, but it will not be rewound.
	 * 
	 * @param i_capacity the desired minimum capacity
	 * @return a buffer with the desired minimum capacity
	 */
	public static DoubleBuffer getDoubleBuffer(int i_capacity) {

		DoubleBuffer buffer;
		if (m_synchronized)
			synchronized (m_doubleBuffer) {
				buffer = doGetBuffer(m_doubleBuffer, i_capacity);
			}
		else
			buffer = doGetBuffer(m_doubleBuffer, i_capacity);

		if (buffer == null)
			buffer = createDoubleBuffer(i_capacity);
		else
			buffer.limit(i_capacity);

		return buffer;
	}

	/**
	 * Returns a buffer with at least the given capacity. The returned buffer
	 * will be limited to the given capacity, but it will not be rewound.
	 * 
	 * @param i_capacity the desired minimum capacity
	 * @return a buffer with the desired minimum capacity
	 */
	public static FloatBuffer getFloatBuffer(int i_capacity) {

		FloatBuffer buffer;
		if (m_synchronized)
			synchronized (m_floatBuffer) {
				buffer = doGetBuffer(m_floatBuffer, i_capacity);
			}
		else
			buffer = doGetBuffer(m_floatBuffer, i_capacity);

		if (buffer == null)
			buffer = createFloatBuffer(i_capacity);
		else
			buffer.limit(i_capacity);

		return buffer;
	}

	/**
	 * Returns a buffer with at least the given capacity. The returned buffer
	 * will be limited to the given capacity, but it will not be rewound.
	 * 
	 * @param i_capacity the desired minimum capacity
	 * @return a buffer with the desired minimum capacity
	 */
	public static IntBuffer getIntBuffer(int i_capacity) {

		IntBuffer buffer;
		if (m_synchronized)
			synchronized (m_intBuffer) {
				buffer = doGetBuffer(m_intBuffer, i_capacity);
			}
		else
			buffer = doGetBuffer(m_intBuffer, i_capacity);

		if (buffer == null)
			buffer = createIntBuffer(i_capacity);
		else
			buffer.limit(i_capacity);

		return buffer;
	}

	/**
	 * Returns a cached {@link Point}.
	 * 
	 * @return a cached point
	 */
	public static Point getPoint() {

		if (m_synchronized) {
			synchronized (m_point) {
				if (m_point.isEmpty())
					return createPoint();
				else
					return m_point.remove();
			}
		} else {
			if (m_point.isEmpty())
				return createPoint();
			else
				return m_point.remove();
		}
	}

	/**
	 * Returns a cached {@link Rectangle}.
	 * 
	 * @return a cached rectangle
	 */
	public static Rectangle getRectangle() {

		if (m_synchronized) {
			synchronized (m_rectangle) {
				if (m_rectangle.isEmpty())
					return createRectangle();
				else
					return m_rectangle.remove();
			}
		} else {
			if (m_rectangle.isEmpty())
				return createRectangle();
			else
				return m_rectangle.remove();
		}
	}

	/**
	 * Returns the given byte buffers to the cache. If any of the given buffers
	 * is <code>null</code>, it is ignored.
	 * 
	 * @param i_bs the buffers to return
	 */
	public static void returnByteBuffer(ByteBuffer... i_bs) {

		if (m_synchronized) {
			synchronized (m_floatBuffer) {
				for (ByteBuffer b : i_bs)
					if (b != null)
						doReturnBuffer(m_byteBuffer, b);
			}
		} else {
			for (ByteBuffer b : i_bs)
				if (b != null)
					doReturnBuffer(m_byteBuffer, b);
		}

		if (m_count && m_byteBuffer.size() > m_instanceThreshold)
			log.warning("cache contains more than " + m_instanceThreshold
				+ " byte buffers");
	}

	/**
	 * Returns the given dimensions to the cache. If any of the given dimensions
	 * is <code>null</code>, it is ignored.
	 * 
	 * @param i_ds the dimensions to return
	 */
	public static void returnDimension(Dimension... i_ds) {

		if (m_synchronized)
			synchronized (m_dimension) {
				for (Dimension d : i_ds)
					if (d != null)
						m_dimension.offer(d);
			}
		else
			for (Dimension d : i_ds)
				if (d != null)
					m_dimension.offer(d);

		if (m_count && m_dimension.size() > m_instanceThreshold)
			log.warning("cache contains more than " + m_instanceThreshold
				+ " dimensions");
	}

	/**
	 * Returns the given double buffers to the cache. If any of the given
	 * buffers is <code>null</code>, it is ignored.
	 * 
	 * @param i_bs the buffers to return
	 */
	public static void returnDoubleBuffer(DoubleBuffer... i_bs) {

		if (m_synchronized) {
			synchronized (m_doubleBuffer) {
				for (DoubleBuffer b : i_bs)
					if (b != null)
						doReturnBuffer(m_doubleBuffer, b);
			}
		} else {
			for (DoubleBuffer b : i_bs)
				if (b != null)
					doReturnBuffer(m_doubleBuffer, b);
		}

		if (m_count && m_doubleBuffer.size() > m_instanceThreshold)
			log.warning("cache contains more than " + m_instanceThreshold
				+ " double buffers");

	}

	/**
	 * Returns the given float buffers to the cache. If any of the given buffers
	 * is <code>null</code>, it is ignored.
	 * 
	 * @param i_bs the buffers to return
	 */
	public static void returnFloatBuffer(FloatBuffer... i_bs) {

		if (m_synchronized) {
			synchronized (m_floatBuffer) {
				for (FloatBuffer b : i_bs)
					if (b != null)
						doReturnBuffer(m_floatBuffer, b);
			}
		} else {
			for (FloatBuffer b : i_bs)
				if (b != null)
					doReturnBuffer(m_floatBuffer, b);
		}

		if (m_count && m_floatBuffer.size() > m_instanceThreshold)
			log.warning("cache contains more than " + m_instanceThreshold
				+ " float buffers");
	}

	/**
	 * Returns the given int buffers to the cache. If any of the given buffers
	 * is <code>null</code>, it is ignored.
	 * 
	 * @param i_bs the buffers to return
	 */
	public static void returnIntBuffer(IntBuffer... i_bs) {

		if (m_synchronized) {
			synchronized (m_intBuffer) {
				for (IntBuffer b : i_bs)
					if (b != null)
						doReturnBuffer(m_intBuffer, b);
			}
		} else {
			for (IntBuffer b : i_bs)
				if (b != null)
					doReturnBuffer(m_intBuffer, b);
		}

		if (m_count && m_intBuffer.size() > m_instanceThreshold)
			log.warning("cache contains more than " + m_instanceThreshold
				+ " int buffers");
	}

	/**
	 * Returns the given points to the cache. If any of the given points is
	 * <code>null</code>, it is ignored.
	 * 
	 * @param i_ps the points to return
	 */
	public static void returnPoint(Point... i_ps) {

		if (m_synchronized)
			synchronized (m_point) {
				for (Point p : i_ps)
					if (p != null)
						m_point.offer(p);
			}
		else
			for (Point p : i_ps)
				if (p != null)
					m_point.offer(p);

		if (m_count && m_point.size() > m_instanceThreshold)
			log.warning("cache contains more than " + m_instanceThreshold
				+ " points");
	}

	/**
	 * Returns the given rectangles to the cache. If any of the given rectangles
	 * is <code>null</code>, it is ignored.
	 * 
	 * @param i_rs the rectangles to return
	 */
	public static void returnRectangle(Rectangle... i_rs) {

		if (m_synchronized)
			synchronized (m_rectangle) {
				for (Rectangle r : i_rs)
					if (r != null)
						m_rectangle.offer(r);
			}
		else
			for (Rectangle r : i_rs)
				if (r != null)
					m_rectangle.offer(r);

		if (m_count && m_rectangle.size() > m_instanceThreshold)
			log.warning("cache contains more than " + m_instanceThreshold
				+ " rectangles");
	}
}
