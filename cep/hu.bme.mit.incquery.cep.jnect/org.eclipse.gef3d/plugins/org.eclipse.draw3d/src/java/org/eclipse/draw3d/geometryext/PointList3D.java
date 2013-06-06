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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Vector3fImpl;

/**
 * {@link PointList} compatible list holding 3D points, i.e. {@link IVector3f}.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since May 31, 2009
 */
public class PointList3D extends PointList implements List<IVector3f> {

	private class PointList3DIterator implements ListIterator<IVector3f> {

		int pos = 0;

		/**
		 * @param i_index
		 */
		public PointList3DIterator(int start) {
			pos = start;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see java.util.ListIterator#add(java.lang.Object)
		 */
		public void add(IVector3f v) {
			PointList3D.this.add(pos, v);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see java.util.ListIterator#hasNext()
		 */
		public boolean hasNext() {
			return pos < size();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see java.util.ListIterator#hasPrevious()
		 */
		public boolean hasPrevious() {
			return pos > 0;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see java.util.ListIterator#next()
		 */
		public IVector3f next() {
			if (pos >= size())
				throw new NoSuchElementException();
			return get(pos++);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see java.util.ListIterator#nextIndex()
		 */
		public int nextIndex() {
			return pos;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see java.util.ListIterator#previous()
		 */
		public IVector3f previous() {
			if (pos == 0 || isEmpty())
				throw new NoSuchElementException();
			return get(--pos);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see java.util.ListIterator#previousIndex()
		 */
		public int previousIndex() {
			return pos - 1;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see java.util.ListIterator#remove()
		 */
		public void remove() {
			PointList3D.this.remove(pos);

		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see java.util.ListIterator#set(java.lang.Object)
		 */
		public void set(IVector3f v) {
			PointList3D.this.set(pos, v);
		}

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8955686832232579183L;

	List<Vector3fImpl> points3D;

	private float defaultZ = 0.0f;

	/**
	 * @see PointList#PointList()
	 */
	public PointList3D() {
		this(2);
	}

	/**
	 * Initializes this point list with given 2D points. The array is expected
	 * to hold x and y values.
	 * 
	 * @see PointList#PointList(int[])
	 */
	public PointList3D(int points[]) {
		this(points.length);
		for (int i = 0; i < points.length; i += 2) {
			addPoint(points[i], points[i + 1]);
		}
	}

	/**
	 * Initializes this point list and sets the initial capacity to the given
	 * size. The given size is not the length of the point list!
	 * 
	 * @see PointList#PointList(int)
	 */
	public PointList3D(int initalCapacity) {
		points3D = new ArrayList<Vector3fImpl>(initalCapacity);
	}
	
	/**
	 * Constructor for {@link UnmodifiablePointList3D} super class.
	 * @param do_not_create_list
	 */
	protected PointList3D(boolean do_not_create_list) {
		if (! do_not_create_list) {
			points3D = new ArrayList<Vector3fImpl>(2);
		} else {
			points3D = null;
		}
	}

	/*
	 * *************************************************************************
	 * special 3D methods
	 * **********************************************************************
	 */

	/**
	 * @param i_pointList3D
	 */
	public PointList3D(PointList3D i_pointList3D) {
		this(i_pointList3D.size());
		for (Vector3fImpl v : i_pointList3D.points3D) {
			points3D.add(new Vector3fImpl(v));
		}
	}

	/**
	 * @param subList
	 */
	public PointList3D(List<IVector3f> list) {
		this(list.size());
		for (IVector3f v : list) {
			points3D.add(new Vector3fImpl(v));
		}
	}

	/**
	 * @return
	 */
	public float getDefaultZ() {
		return defaultZ;
	}

	/**
	 * @param i_vector3fImpl
	 */
	public void addPointByRef(Vector3fImpl v) {
		points3D.add(v);
	}

	public IVector3f getPoint3D(int index) {
		return points3D.get(index);
	}

	public IVector3f getMidpoint3D() {
		if (size() % 2 == 0) { // even number
			if (size() == 0)
				return IVector3f.NULLVEC3f;
			IVector3f v0 = getPoint3D(size() / 2 - 1);
			IVector3f v1 = getPoint3D(size() / 2);
			Vector3fImpl v = new Vector3fImpl();
			Math3D.add(v0, v1, v);
			Math3D.scale(0.5f, v, v);
			return v;
		} else { // odd
			return getPoint3D(size() / 2);
		}
	}

	/**
	 * @param i_p
	 * @return
	 */
	protected Vector3fImpl toVector3f(Point i_p) {
		return new Vector3fImpl(i_p.x, i_p.y, getDefaultZ());
	}

	protected Vector3fImpl toVector3f(int x, int y) {
		return new Vector3fImpl(x, y, getDefaultZ());
	}

	protected Point toPoint(IVector3f v) {
		return new Point((int) v.getX(), (int) v.getY());
	}

	protected void toPoint(IVector3f v, Point intoPoint) {
		intoPoint.x = (int) v.getX();
		intoPoint.y = (int) v.getY();
	}

	/**
	 * @param i_points
	 */
	public void set(List<? extends IVector3f> i_points) {
		points3D = new ArrayList<Vector3fImpl>(i_points.size());
		for (IVector3f v : i_points) {
			points3D.add(new Vector3fImpl(v));
		}

	}

	/*
	 * *************************************************************************
	 * overridden point list methods
	 * **********************************************************************
	 */

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.geometry.PointList#addAll(org.eclipse.draw2d.geometry.PointList)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void addAll(PointList source) {
		if (source instanceof PointList3D) {
			addAll((Collection<IVector3f>) source);
		}
		for (int i = 0; i < source.size(); i++) {
			addPoint(source.getPoint(i));
		}
	}

	/**
	 * Adds given (2D) point to this list, z s set to default z (
	 * {@link #getDefaultZ()}).
	 * 
	 * @see org.eclipse.draw2d.geometry.PointList#addPoint(org.eclipse.draw2d.geometry.Point)
	 */
	@Override
	public void addPoint(Point p) {
		addPointByRef(toVector3f(p));
	}

	/**
	 * {@inheritDoc}Adds given (2D) point to this list, z s set to default z (
	 * {@link #getDefaultZ()}).
	 * 
	 * @see org.eclipse.draw2d.geometry.PointList#addPoint(int, int)
	 */
	@Override
	public void addPoint(int x, int y) {
		addPointByRef(toVector3f(x, y));
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Note: This method is relative expensive as the bound are calculated.
	 * </p>
	 * 
	 * @see org.eclipse.draw2d.geometry.PointList#getBounds()
	 */
	@Override
	public Rectangle getBounds() {
		if (size() == 0) {
			return new Rectangle(0, 0, 0, 0);
		}

		float minX = Float.MAX_VALUE;
		float minY = Float.MAX_VALUE;
		float maxX = Float.MIN_VALUE;
		float maxY = Float.MIN_VALUE;

		for (Vector3fImpl v : points3D) {
			if (v.x < minX)
				minX = v.getX();
			if (v.x > maxX)
				maxX = v.getX();
			if (v.y < minY)
				minY = v.getY();
			if (v.y > maxY)
				maxY = v.getY();
		}

		return new Rectangle((int) minX, (int) minY, (int) (maxX - minX),
			(int) (maxY - minY));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.geometry.PointList#getCopy()
	 */
	@Override
	public PointList getCopy() {
		return new PointList3D(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.geometry.PointList#getFirstPoint()
	 */
	@Override
	public Point getFirstPoint() {
		return getPoint(0);
	}

	public IVector3f getFirstPoint3D() {
		return getPoint3D(0);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.geometry.PointList#getLastPoint()
	 */
	@Override
	public Point getLastPoint() {
		return getPoint(size() - 1);
	}

	public IVector3f getLastPoint3D() {
		return getPoint3D(size() - 1);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.geometry.PointList#getMidpoint()
	 */
	@Override
	public Point getMidpoint() {
		return toPoint(getMidpoint3D());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.geometry.PointList#getPoint(int)
	 */
	@Override
	public Point getPoint(int index) {
		return toPoint(getPoint3D(index));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.geometry.PointList#getPoint(org.eclipse.draw2d.geometry.Point,
	 *      int)
	 */
	@Override
	public Point getPoint(Point p, int index) {
		toPoint(getPoint3D(index), p);
		return p;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.geometry.PointList#insertPoint(org.eclipse.draw2d.geometry.Point,
	 *      int)
	 */
	@Override
	public void insertPoint(Point p, int index) {
		points3D.add(index, toVector3f(p));
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Note: This method is relative expensive as the bound are calculated. This
	 * method is not implemented as the 3D version. Instead, the bounds of this
	 * point list is calculated, and the method returns true if the two
	 * rectangles (bounds and given rectangle) intersect.
	 * </p>
	 * 
	 * @see org.eclipse.draw2d.geometry.PointList#intersects(org.eclipse.draw2d.geometry.Rectangle)
	 */
	@Override
	public boolean intersects(Rectangle r) {
		Rectangle rect = getBounds();
		return rect.intersects(r);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.geometry.PointList#performScale(double)
	 */
	@Override
	public void performScale(double factor) {
		for (Vector3fImpl v : points3D) {
			Math3D.scale((float) factor, v, v);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.geometry.PointList#performTranslate(int, int)
	 */
	@Override
	public void performTranslate(int dx, int dy) {
		for (Vector3fImpl v : points3D) {
			Math3D.translate(v, dx, dy, 0, v);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.geometry.PointList#removeAllPoints()
	 */
	@Override
	public void removeAllPoints() {
		points3D.clear();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.geometry.PointList#removePoint(int)
	 */
	@Override
	public Point removePoint(int index) {
		return toPoint(points3D.remove(index));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.geometry.PointList#reverse()
	 */
	@Override
	public void reverse() {
		Collections.reverse(points3D);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.geometry.PointList#setPoint(org.eclipse.draw2d.geometry.Point,
	 *      int)
	 */
	@Override
	public void setPoint(Point pt, int index) {
		points3D.set(index, toVector3f(pt));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.geometry.PointList#setSize(int)
	 */
	@Override
	public void setSize(int newSize) {
		if (size() >= newSize) {
			for (int i = size() - 1; i >= newSize; i--) {
				points3D.remove(i);
			}
		} else {
			for (int i = size(); i < newSize; i++) {
				points3D.add(new Vector3fImpl());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.geometry.PointList#size()
	 */
	@Override
	public int size() {
		return points3D.size();
	}

	/**
	 * Returns this point list as an array of integers with x and y values. Note
	 * that the returned array is <em>not</em> returned by reference!
	 * 
	 * @see org.eclipse.draw2d.geometry.PointList#toIntArray()
	 */
	@Override
	public int[] toIntArray() {
		int[] aint = new int[size() * 2];
		int i = 0;
		for (Vector3fImpl v : points3D) {
			aint[i++] = (int) v.x;
			aint[i++] = (int) v.y;
		}
		return aint;
	}

	/**
	 * {@inheritDoc} Called by, as final declared method,
	 * org.eclipse.draw2d.geometry
	 * .PointList#translate(org.eclipse.draw2d.geometry.Point). Calls
	 * {@link #performTranslate(int, int)} -- wondering why original point list
	 * implements this method twice.
	 * 
	 * @see org.eclipse.draw2d.geometry.PointList#translate(int, int)
	 */
	@Override
	public void translate(int x, int y) {
		performTranslate(x, y);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.geometry.PointList#transpose()
	 */
	@Override
	public void transpose() {
		float t;
		for (Vector3fImpl v : points3D) {
			t = v.x;
			v.x = v.y;
			v.y = t;
		}
	}

	/*
	 * *************************************************************************
	 * List methods
	 * **********************************************************************
	 */

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(IVector3f v) {
		return points3D.add(new Vector3fImpl(v));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#remove(int)
	 */
	public IVector3f remove(int index) {
		return points3D.remove(index);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#set(int, java.lang.Object)
	 */
	public IVector3f set(int index, IVector3f v) {
		return points3D.set(index, new Vector3fImpl(v));
	}

	/**
	 * @param index
	 * @return
	 * @see List#get(int)
	 */
	public IVector3f get(int index) {
		return points3D.get(index);
	}

	/**
	 * List interface version of {@link #removeAllPoints()}, calls
	 * {@link #removeAllPoints()} internally.
	 * 
	 * @see List#clear()
	 */
	public void clear() {
		removeAllPoints();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#add(int, java.lang.Object)
	 */
	public void add(int index, IVector3f v) {
		points3D.add(index, new Vector3fImpl(v));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#addAll(java.util.Collection)
	 */
	public boolean addAll(Collection<? extends IVector3f> vectors) {
		Collection<Vector3fImpl> vimpls =
			new ArrayList<Vector3fImpl>(vectors.size());
		for (IVector3f v : vectors) {
			vimpls.add(new Vector3fImpl(v));
		}
		return points3D.addAll(vimpls);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#addAll(int, java.util.Collection)
	 */
	public boolean addAll(int index, Collection<? extends IVector3f> vectors) {
		Collection<Vector3fImpl> vimpls =
			new ArrayList<Vector3fImpl>(vectors.size());
		for (IVector3f v : vectors) {
			vimpls.add(new Vector3fImpl(v));
		}
		return points3D.addAll(index, vimpls);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#contains(java.lang.Object)
	 */
	public boolean contains(Object i_o) {
		if (i_o instanceof Point) {
			return indexOf(i_o)>=0;
		}
		return points3D.contains(i_o);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#containsAll(java.util.Collection)
	 */
	public boolean containsAll(Collection<?> i_c) {
		return points3D.containsAll(i_c);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#indexOf(java.lang.Object)
	 */
	public int indexOf(Object i_o) {
		if (i_o instanceof Point) {
			Point p = (Point) i_o;
			int i = 0;
			for (Vector3fImpl v : points3D) {
				if ((int) v.x == p.x && (int) v.y == p.y) {
					return i;
				}
				i++;
			}
			return -1;
		}
		return points3D.indexOf(i_o);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#isEmpty()
	 */
	public boolean isEmpty() {
		return points3D.isEmpty();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#lastIndexOf(java.lang.Object)
	 */
	public int lastIndexOf(Object i_o) {
		return points3D.lastIndexOf(i_o);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#listIterator()
	 */
	public ListIterator<IVector3f> listIterator() {
		return listIterator(0);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#iterator()
	 */
	public Iterator<IVector3f> iterator() {
		return listIterator(0);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#listIterator(int)
	 */
	public ListIterator<IVector3f> listIterator(int index) {
		return new PointList3DIterator(index);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#subList(int, int)
	 */
	public List<IVector3f> subList(int fromIndex, int toIndex) {
		List<IVector3f> sub = new ArrayList<IVector3f>(toIndex - fromIndex);
		for (int i = fromIndex; i < toIndex; i++) {
			sub.add(points3D.get(i));
		}
		return sub;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#remove(java.lang.Object)
	 */
	public boolean remove(Object o) {
		return points3D.remove(o);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#removeAll(java.util.Collection)
	 */
	public boolean removeAll(Collection<?> i_c) {
		return points3D.removeAll(i_c);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#retainAll(java.util.Collection)
	 */
	public boolean retainAll(Collection<?> c) {
		return points3D.retainAll(c);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#toArray()
	 */
	public Object[] toArray() {
		return points3D.toArray();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#toArray(T[])
	 */
	public <T> T[] toArray(T[] a) {
		return points3D.toArray(a);
	}

	/*
	 * *************************************************************************
	 * Debugging
	 * **********************************************************************
	 */

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder strb = new StringBuilder(getClass().getSimpleName());
		strb.append(": {");
		boolean bFirst = true;
		for (Vector3fImpl v : points3D) {
			if (!bFirst) {
				strb.append(", ");
			} else
				bFirst = false;
			strb.append(v.toString());
		}
		strb.append("}");
		return strb.toString();
	}

}
