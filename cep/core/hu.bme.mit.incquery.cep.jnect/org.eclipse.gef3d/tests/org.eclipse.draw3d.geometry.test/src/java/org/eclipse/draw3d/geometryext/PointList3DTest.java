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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.ListIterator;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;
import org.junit.Test;

/**
 * Test case for {@link PointList3D}.
 *
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	Jun 1, 2009
 */
public class PointList3DTest {

	private static final PointList3D TEN;
	private static final PointList TEN2D;
	static {
		TEN = new PointList3D(10);
		TEN.add(new Vector3fImpl(1,11,21));
		TEN.add(new Vector3fImpl(2,12,22));
		TEN.add(new Vector3fImpl(3,13,23));
		TEN.add(new Vector3fImpl(4,14,24));
		TEN.add(new Vector3fImpl(5,15,25));
		TEN.add(new Vector3fImpl(6,16,26));
		TEN.add(new Vector3fImpl(7,17,27));
		TEN.add(new Vector3fImpl(8,18,28));
		TEN.add(new Vector3fImpl(9,19,29));
		TEN.add(new Vector3fImpl(10,20,30));
		TEN2D = new PointList(10);
		for (int i=0; i<10; i++) {
			TEN2D.addPoint(i+1, i+11);
		}
	}
	

	/**
	 * Test method for {@link org.eclipse.draw3d.geometryext.PointList3D#addAll(org.eclipse.draw2d.geometry.PointList)}.
	 */
	@Test
	public void testAddAllPointList() {
		PointList3D pl = new PointList3D();
		pl.addAll(TEN2D);
		assertEquals(10, pl.size());
		for (int i=0; i<10; i++) {
			assertEquals(TEN2D.getPoint(i), pl.getPoint(i));
		}
	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometryext.PointList3D#addPoint(org.eclipse.draw2d.geometry.Point)}.
	 */
	@Test
	public void testAddPointPoint() {
		PointList3D pl = new PointList3D();
		pl.addPoint(new Point(1,1));
		assertEquals(new Vector3fImpl(1,1, pl.getDefaultZ()), pl.getPoint3D(0));
		assertEquals(new Point(1,1), pl.getPoint(0));
	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometryext.PointList3D#addPoint(int, int)}.
	 */
	@Test
	public void testAddPointIntInt() {
		PointList3D pl = new PointList3D();
		pl.addPoint(1,1);
		assertEquals(new Vector3fImpl(1,1, pl.getDefaultZ()), pl.getPoint3D(0));
		assertEquals(new Point(1,1), pl.getPoint(0));
	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometryext.PointList3D#getBounds()}.
	 */
	@Test
	public void testGetBounds() {
		assertEquals(new Rectangle(1,11, 9, 9), TEN.getBounds());
	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometryext.PointList3D#getCopy()}.
	 */
	@Test
	public void testGetCopy() {
		PointList pl = TEN.getCopy();
		assertEquals(10, pl.size());
		for (int i=0; i<10; i++) {
			assertEquals(new Point(i+1, i+11), pl.getPoint(i));
		}
	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometryext.PointList3D#getFirstPoint()}.
	 */
	@Test
	public void testGetFirstPoint() {
		assertEquals(new Vector3fImpl(1,11,21), TEN.getFirstPoint3D());
		assertEquals(new Point(1,11), TEN.getFirstPoint());
	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometryext.PointList3D#getLastPoint()}.
	 */
	@Test
	public void testGetLastPoint() {
		assertEquals(new Vector3fImpl(10,20,30), TEN.getLastPoint3D());
		assertEquals(new Point(10, 20), TEN.getLastPoint());
	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometryext.PointList3D#getMidpoint()}.
	 */
	@Test
	public void testGetMidpoint() {
		PointList3D pl = new PointList3D();
		assertEquals(IVector3f.NULLVEC3f, pl.getMidpoint3D());
		pl.add(new Vector3fImpl(1,10,100));
		assertEquals(new Vector3fImpl(1,10,100), pl.getMidpoint3D());
		pl.add(new Vector3fImpl(2,20,200));
		assertEquals(new Vector3fImpl(1.5f,15f, 150f), pl.getMidpoint3D());
		assertEquals(new Point(1,15), pl.getMidpoint());
		pl.add(new Vector3fImpl(3,30,300));
		assertEquals(new Vector3fImpl(2,20,200), pl.getMidpoint3D());
	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometryext.PointList3D#getPoint(int)}.
	 */
	@Test
	public void testGetPointInt() {
		assertEquals(new Point(3,13), TEN.getPoint(2));
	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometryext.PointList3D#getPoint(org.eclipse.draw2d.geometry.Point, int)}.
	 */
	@Test
	public void testGetPointPointInt() {
		Point p = new Point();
		TEN.getPoint(p,2);
		assertEquals(new Point(3,13), p);
	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometryext.PointList3D#insertPoint(org.eclipse.draw2d.geometry.Point, int)}.
	 */
	@Test
	public void testInsertPoint() {
		PointList3D pl = new PointList3D(TEN);
		pl.insertPoint(new Point(99,99), 4); // 5 -> index 5; 4 -> index 3
		assertEquals(11, pl.size());
		assertEquals(new Point(99,99), pl.getPoint(4));
		assertEquals(new Vector3fImpl(5, 15, 25), pl.getPoint3D(5));
		assertEquals(new Vector3fImpl(4, 14, 24), pl.getPoint3D(3));
		
	}

	
	/**
	 * Test method for {@link org.eclipse.draw3d.geometryext.PointList3D#removePoint(int)}.
	 */
	@Test
	public void testRemovePoint() {
		PointList3D pl = new PointList3D(TEN);
		pl.removePoint(4);
		assertEquals(9, pl.size());
		assertFalse(pl.contains(TEN.get(4)));
	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometryext.PointList3D#reverse()}.
	 */
	@Test
	public void testReverse() {
		PointList3D pl = new PointList3D(TEN);
		pl.reverse();
		assertEquals(10, pl.size());
		for (int i=0; i<10; i++) {
			assertEquals(TEN.get(9-i), pl.get(i));
		}
	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometryext.PointList3D#setPoint(org.eclipse.draw2d.geometry.Point, int)}.
	 */
	@Test
	public void testSetPoint() {
		PointList3D pl = new PointList3D(TEN);
		pl.setPoint(new Point(99,99), 4); // 5 -> index 5; 4 -> index 3
		assertEquals(10, pl.size());
		assertEquals(new Point(99,99), pl.getPoint(4));
		assertFalse(pl.contains(TEN.get(4)));
		assertEquals(new Vector3fImpl(4, 14, 24), pl.getPoint3D(3));
	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometryext.PointList3D#setSize(int)}.
	 */
	@Test
	public void testSetSize() {
		PointList3D pl = new PointList3D(TEN); 
		pl.setSize(10);
		assertEquals(10, pl.size());
		pl.setSize(15);
		assertEquals(15, pl.size());
		pl.setSize(5);
		assertEquals(5, pl.size());
	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometryext.PointList3D#size()}.
	 */
	@Test
	public void testSize() {
		PointList3D pl = new PointList3D(TEN); 
		assertEquals(10, pl.size());
		pl = new PointList3D();
		assertEquals(0, pl.size());
		pl = new PointList3D(10);
		assertEquals(0, pl.size());
		pl = new PointList3D(TEN);
		assertEquals(10, pl.size());
	}



	/**
	 * Test method for {@link org.eclipse.draw3d.geometryext.PointList3D#add(org.eclipse.draw3d.geometry.IVector3f)}.
	 */
	@Test
	public void testAddIVector3f() {
		PointList3D pl = new PointList3D();
		for (int i=1; i<=10; i++) {
			pl.add(new Vector3fImpl(i, i+10, i+20));
			assertEquals(i, pl.size());
			assertEquals(pl.get(i-1), TEN.get(i-1));
		}
	}


	/**
	 * Test method for {@link org.eclipse.draw3d.geometryext.PointList3D#clear()}.
	 */
	@Test
	public void testClear() {
		PointList3D pl = new PointList3D(TEN);
		assertEquals(10, pl.size());
		pl.clear();
		assertEquals(0, pl.size());
	}



	/**
	 * Test method for {@link org.eclipse.draw3d.geometryext.PointList3D#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains() {
		assertTrue(TEN.contains(new Vector3fImpl(4,14,24)));
		assertTrue(TEN.contains(new Point(4,14)));
	}




	/**
	 * Test method for {@link org.eclipse.draw3d.geometryext.PointList3D#iterator()}.
	 */
	@Test
	public void testIterator() {
		int i=0; 
		for (IVector3f v: TEN) {
			assertEquals(TEN.get(i), v);
			i++;
		}
		assertEquals(TEN.size(), i);
		i=0;
		for (Iterator iter = TEN.iterator(); iter.hasNext();) {
			assertEquals(TEN.get(i), iter.next());
			i++;
		}
		assertEquals(TEN.size(), i);
	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometryext.PointList3D#listIterator(int)}.
	 */
	@Test
	public void testListIteratorInt() {
		int i=0; 
		ListIterator<IVector3f> iter = TEN.listIterator();
		for (; iter.hasNext();) {
			assertEquals(TEN.get(i), iter.next());
			i++;
		}
		assertEquals(TEN.size(), i);
		for (; iter.hasPrevious();) {
			i--;
			assertEquals(TEN.get(i), iter.previous());
		}
		assertEquals(0, i);
	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometryext.PointList3D#subList(int, int)}.
	 */
	@Test
	public void testSubList() {
		PointList3D pl = new PointList3D(TEN);
		assertEquals(10, pl.size());
		pl = new PointList3D(pl.subList(2, 7));
		assertEquals(5, pl.size());
		assertEquals(new Vector3fImpl(3,13,23), pl.getFirstPoint3D());
		assertEquals(new Vector3fImpl(7,17,27), pl.getLastPoint3D());
	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometryext.PointList3D#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveObject() {
		PointList3D pl = new PointList3D(TEN);
		assertTrue(pl.remove(TEN.get(5)));
		assertEquals(9, pl.size());
		assertFalse(pl.contains(TEN.get(5)));
	}

	/**
	 * Test method for {@link org.eclipse.draw3d.geometryext.PointList3D#removeAll(java.util.Collection)}.
	 */
	@Test
	public void testRemoveAll() {
		PointList3D pl = new PointList3D(TEN);
		assertEquals(10, pl.size());
		pl.removeAll(TEN);
		assertEquals(0, pl.size());
	}


}
