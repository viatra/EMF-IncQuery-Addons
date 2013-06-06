/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.geometry;

import java.nio.FloatBuffer;

/**
 * Generic immutable matrix interface for converting a matrix into arrays of
 * buffers. <h3>Converting a Matrix</h4> There are two formats for converting to
 * or from a stream: row major or column major. While row major is used in most
 * mathematical areas, OpenGL uses column major format. The two formats store
 * the entries of a matrix in the following way:
 * <h4>Row Major Format</h4>
 * <table>
 * <tr>
 * <td>[0]</td>
 * <td>[1]</td>
 * <td>[2]</td>
 * </tr>
 * <tr>
 * <td>[3]</td>
 * <td>[4]</td>
 * <td>[5]</td>
 * </tr>
 * <tr>
 * <td>[6]</td>
 * <td>[7]</td>
 * <td>[8]</td>
 * </tr>
 * </table>
 * <h4>Column Major Format (OpenGL)</h4>
 * <table>
 * <tr>
 * <td>[0]</td>
 * <td>[3]</td>
 * <td>[6]</td>
 * </tr>
 * <tr>
 * <td>[1]</td>
 * <td>[4]</td>
 * <td>[7]</td>
 * </tr>
 * <tr>
 * <td>[2]</td>
 * <td>[5]</td>
 * <td>[8]</td>
 * </tr>
 * </table>
 * Depending on the actual size of the matrix, these table may differ.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Dec 17, 2008
 */
public interface IMatrix {
	/**
	 * Returns the value at the given row and column indices.
	 * 
	 * @param i_row the row index, 0-based
	 * @param i_column the column index, 0-based
	 * @return the value at the given indices
	 * @throws IllegalArgumentException if any of the given arguments is out of
	 *             bounds
	 */
	public float get(int i_row, int i_column);

	/**
	 * Returns a hash code. Two instances a0 and a1 will return the same hash
	 * code, if a0.equals(a1)==true.
	 * <p>
	 * <p>
	 * All implementations must use the same strategy for computing the hash
	 * code: The entries of the structure are converted into an array (row
	 * major), and then Arrays#hashCode(float[]) is used for calculating the
	 * code.
	 * </p>
	 * 
	 * @return the hash code
	 */
	public int hashCode();

	/**
	 * Returns the number of float values of this matrix.
	 * 
	 * @return
	 */
	public int size();

	/**
	 * Stores the entries of the matrix into an array, starting at offset 0, in
	 * column major (OpenGL) order.
	 * 
	 * @param o_arrayOfFloat The array to store in
	 */
	public void toArrayColumnMajor(float[] o_arrayOfFloat);

	/**
	 * Stores the entries of the matrix into an array, starting at the given
	 * offset, in column major (OpenGL) order.
	 * 
	 * @param o_arrayOfFloat The array to store in
	 * @param i_iOffset The offset to start storing at
	 */
	public void toArrayColumnMajor(float[] o_arrayOfFloat, int i_iOffset);

	/**
	 * Stores the entries of the matrix into an array, starting at offset 0, in
	 * row major order.
	 * 
	 * @param o_arrayOfFloat The array to store in
	 */
	public void toArrayRowMajor(float[] o_arrayOfFloat);

	/**
	 * Stores the entries of the matrix into an array, starting at the given
	 * offset, in row major order.
	 * 
	 * @param o_arrayOfFloat The array to store in
	 * @param i_iOffset The offset to start storing at
	 */
	public void toArrayRowMajor(float[] o_arrayOfFloat, int i_iOffset);

	/**
	 * Stores the entries of the matrix into an array, starting at offset 0, in
	 * column major (OpenGL) order.
	 * 
	 * @param buf The buffer to store it in, at the current position
	 */
	public void toBufferColumnMajor(FloatBuffer o_floatBuffer);

	/**
	 * Stores the entries of the matrix into an array, starting at offset 0, in
	 * row major order.
	 * 
	 * @param buf The buffer to store it in, at the current position
	 */
	public void toBufferRowMajor(FloatBuffer o_floatBuffer);
}
