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

import static org.eclipse.draw3d.geometry.IVector3f.*;

/**
 * Immutable matrix4f. <h3>Converting a Matrix</h4> There are two formats for
 * converting to or from a stream: row major or column major. While row major is
 * used in most mathematical areas, OpenGL uses column major format. The two
 * formats store the entries of a matrix in the following way:
 * <h4>Row Major Format</h4>
 * <table>
 * <tr>
 * <td>[0]</td>
 * <td>[1]</td>
 * <td>[2]</td>
 * <td>[3]</td>
 * </tr>
 * <tr>
 * <td>[4]</td>
 * <td>[5]</td>
 * <td>[6]</td>
 * <td>[7]</td>
 * </tr>
 * <tr>
 * <td>[8]</td>
 * <td>[9]</td>
 * <td>[10]</td>
 * <td>[11]</td>
 * </tr>
 * <tr>
 * <td>[12]</td>
 * <td>[13]</td>
 * <td>[14]</td>
 * <td>[15]</td>
 * </tr>
 * </table>
 * <h4>Column Major Format (OpenGL)</h4>
 * <table>
 * <tr>
 * <td>[0]</td>
 * <td>[4]</td>
 * <td>[8]</td>
 * <td>[12]</td>
 * </tr>
 * <tr>
 * <td>[1]</td>
 * <td>[5]</td>
 * <td>[9]</td>
 * <td>[13]</td>
 * </tr>
 * <tr>
 * <td>[2]</td>
 * <td>[6]</td>
 * <td>[10]</td>
 * <td>[14]</td>
 * </tr>
 * <tr>
 * <td>[3]</td>
 * <td>[7]</td>
 * <td>[11]</td>
 * <td>[15]</td>
 * </tr>
 * </table>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Dec 16, 2008
 * @see http://en.wikipedia.org/wiki/Matrix_(mathematics)
 */
public interface IMatrix4f extends IMatrix {

	/**
	 * Identity matrix ( 1,0,0,0, 0,0,1,0, 0,0,1,0, 0,0,0,1 ). All matrices are
	 * created with the identity matrix, by default. We write it here explicitly
	 * to make it clear (and enable tests).
	 */
	public final static IMatrix4f IDENTITY =
		new Matrix4fImpl(new float[] { 1, 0, 0, 0, //
			0, 1, 0, 0, //
			0, 0, 1, 0, //
			0, 0, 0, 1 }, false);

	/**
	 * Zero matrix ( (0,0,0,0), (0,0,0,0), (0,0,0,0), (0,0,0,0) ).
	 */
	public final static IMatrix4f ZERO =
		new Matrix4fImpl(new float[] { 0, 0, 0, 0, //
			0, 0, 0, 0, //
			0, 0, 0, 0, //
			0, 0, 0, 0 }, false);

	/**
	 * Format used in toString() methods
	 */
	public final static String TO_STRING_FORMAT =
		"%n(" + NF + ", " + NF + ", " + NF + ", " + NF + "%n " + NF + ", " + NF
			+ ", " + NF + ", " + NF + "%n " + NF + ", " + NF + ", " + NF + ", "
			+ NF + "%n " + NF + ", " + NF + ", " + NF + ", " + NF + ")%n";

	/**
	 * Compares two matrices. A matrix m0 is equals another matrix m1 if m0 and
	 * m1 are the same instance (m0==m1) or if all their components are equal.
	 * 
	 * @param i_anotherMatrix4f The matrix4f to compare with.
	 * @return True on equality, false otherwise.
	 */
	public boolean equals(IMatrix4f i_anotherMatrix4f);

}
