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
package org.eclipse.draw3d.geometry;


/**
 * Math2D There should really be more documentation here.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 18.11.2009
 */
public class Math2D {

	

	private static void checkPoints(int[] i_p, String i_name) {

		if (i_p == null)
			throw new NullPointerException(i_name + " must not be null");

		if (i_p.length % 2 != 0)
			throw new IllegalArgumentException(i_name
				+ " must contain an even number of coordinates");

		if (i_p.length < 2)
			throw new IllegalArgumentException(i_name
				+ " must contain at least one point");
	}

	private static void checkPolygon(int[] i_p, String i_name) {

		if (i_p == null)
			throw new NullPointerException(i_name + " must not be null");

		if (i_p.length % 2 != 0)
			throw new IllegalArgumentException(i_name
				+ " must contain an even number of coordinates");

		if (i_p.length < 6)
			throw new IllegalArgumentException(i_name
				+ " must contain at least three vertices");
	}

	public static int[] getSortedIndices(int[] points) {

		checkPoints(points, "points");

		int n = points.length / 2;
		
		int[] sorted = new int[n];

		for (int i = 0; i < n; i++)
			sorted[i] = i;

		quicksort(sorted, points, 0, n - 1);
		return sorted;
	}

	/**
	 * Tests whether the first given polygon contains an edge that separates it
	 * completely from the second given polygon.
	 * 
	 * @param i_p0 the first polygon
	 * @param i_p1 the second polygon
	 * @return <code>true</code> if the first polygon contains such an edge and
	 *         <code>false</code> otherwise
	 */
	private static boolean hasSeparator(int[] i_p0, int[] i_p1) {

		int n0 = i_p0.length / 2;
		for (int i0 = 0, i1 = n0 - 1; i0 < n0; i1 = i0, i0++) {
			int locx = i_p0[2 * i0];
			int locy = i_p0[2 * i0 + 1];

			int dirx = -(locy - i_p0[2 * i1 + 1]);
			int diry = locx - i_p0[2 * i1];

			if (whichSide(i_p1, locx, locy, dirx, diry) > 0)
				return true;
		}

		return false;
	}

	public static int pointsInPolygon(int[] polygon, int[] points, int max) {

		return sortedPointsInPolygon(polygon, points, getSortedIndices(points),
			max);
	}

	public static int sortedPointsInPolygon(int[] polygon, int[] points,
		int[] sorted, int max) {

		checkPolygon(polygon, "polygon");
		checkPoints(points, "points");

		int numVertices = polygon.length / 2;
		int numPoints = points.length / 2;

		// find index of the leftmost and rightmost polygon vertices
		int l = 0;
		int r = 0;
		for (int i = 1; i < numVertices; i++) {
			if (polygon[2 * i] < polygon[2 * l])
				l = i;
			if (polygon[2 * i] > polygon[2 * r])
				r = i;
		}

		// skip points left of first vertex
		int pIdx = 0;
		int px = points[2 * sorted[pIdx]];
		while (pIdx < numPoints && px < polygon[2 * l])
			px = points[2 * sorted[pIdx++]];

		// all points are left of first vertex
		if (pIdx >= numPoints)
			return 0;

		// initialize polygon segments
		int us = l;
		int ue = wrapIndex(us, numVertices, true);
		int ls = l;
		int le = wrapIndex(ls, numVertices, false);

		int num = 0;
		int py = points[2 * sorted[pIdx] + 1];

		while (pIdx < numPoints && px < polygon[2 * r]) {

			// find upper segment that contains the point horizontally
			// also skips vertical segments
			while (px >= polygon[2 * ue]) {
				us = ue;
				ue = wrapIndex(us, numVertices, true);
			}

			// find lower segment that contains the point horizontally
			// also skips vertical segments
			while (px >= polygon[le]) {
				ls = le;
				le = wrapIndex(ls, numVertices, false);
			}

			int usx = polygon[2 * us];
			int usy = polygon[2 * us + 1];
			int uex = polygon[2 * ue];
			int uey = polygon[2 * ue + 1];

			int lsx = polygon[2 * ls];
			int lsy = polygon[2 * ls + 1];
			int lex = polygon[2 * le];
			int ley = polygon[2 * le + 1];

			// is the point between the upper and lower segment extrema?
			if (py <= Math.max(usy, uey) && py >= Math.min(lsy, ley)) {

				// construct a vertical segment between the two polygon
				// segments that has the same X coordinate as the point

				int udy = uey - usy;
				int udx = uex - usx;
				float ug = udy / (float) udx;

				int ldy = ley - lsy;
				int ldx = lex - lsx;
				float lg = ldy / (float) ldx;

				float uy = ug * (px - usx);
				float ly = lg * (px - lsx);

				if (Math3D.in(ly, uy, px))
					num++;

				if (num >= max)
					return num;
			}

			pIdx++;
			px = points[2 * sorted[pIdx]];
			py = points[2 * sorted[pIdx] + 1];
		}

		return num;
	}

	/**
	 * Determines whether the given polygons intersect. The polygon arrays
	 * contain the vertices of the polygons in CCW order, with alternating X and
	 * Y coordinates.
	 * <p>
	 * The algorithm implements the separating axis theorem, see
	 * http://www.geometrictools.com/Documentation/MethodOfSeparatingAxes.pdf
	 * </p>
	 * 
	 * @param i_p0 the first polygon
	 * @param i_p1 the second polygon
	 * @return <code>true</code> if the given polygons intersect and
	 *         <code>false</code> otherwise
	 * @throws NullPointerException if either of the given arrays is
	 *             <code>null</code>
	 * @throws IllegalArgumentException if either of the given arrays contains
	 *             an odd number of coordinates or if either of the given arrays
	 *             contains less than three vertices
	 */
	public static boolean polygonIntersectsPolygon(int[] i_p0, int[] i_p1) {

		checkPolygon(i_p0, "i_p0");
		checkPolygon(i_p1, "i_p1");

		if (hasSeparator(i_p0, i_p1))
			return false;

		return !hasSeparator(i_p1, i_p0);
	}

	private static void quicksort(int[] indices, int[] points, int low,
		int high) {

		int i = low;
		int j = high;

		// http://googleresearch.blogspot.com/2006/06/extra-extra-read-all-about-it-nearly.html
		int x = points[2 * indices[(low+high) >>> 1]];

		while (i <= j) {
			while (points[2 * indices[i]] < x)
				i++;
			while (points[2 * indices[j]] > x)
				j--;

			if (i <= j) {
				int t = indices[i];
				indices[i] = indices[j];
				indices[j] = t;

				i++;
				j--;
			}
		}

		if (low < j)
			quicksort(indices, points, low, j);

		if (i < high)
			quicksort(indices, points, i, high);
	}

	private static int whichSide(int[] polygon, int locx, int locy, int dirx,
		int diry) {

		int n = polygon.length / 2;

		int pos = 0;
		int neg = 0;

		for (int i = 0; i < n; i++) {

			// dot product
			int t = locx * dirx + locy * diry;

			if (t > 0)
				pos++;
			else if (t < 0)
				neg++;

			if (pos > 0 && neg > 0)
				return 0;
		}

		if (pos > 0)
			return 1;

		return -1;
	}

	private static int wrapIndex(int index, int length, boolean direction) {

		if (direction) {
			if (index == length - 1)
				return 0;
			return index + 1;
		}

		if (index == 0)
			return length - 1;

		return index - 1;

	}

}
