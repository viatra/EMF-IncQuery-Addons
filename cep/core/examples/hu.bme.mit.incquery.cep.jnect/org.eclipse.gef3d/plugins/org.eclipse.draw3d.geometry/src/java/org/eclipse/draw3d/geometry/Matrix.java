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
 * General mutable matrix interface providing methods for setting a matrix
 * entries form a flat structure, such as arrays or buffers.
 * <p>
 * For an explanation of row- and column-major format, see interface
 * {@link IMatrix}.
 * </p>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Dec 16, 2008
 */
public interface Matrix extends IMatrix {

    /**
     * Sets the value at the given row and column.
     * 
     * @param i_row
     *            the row index (0 based)
     * @param i_column
     *            the column index (0 based)
     * @param i_value
     *            the value to set
     * 
     * @throws IllegalArgumentException
     *             if the given row or column indices are out of bounds
     */
    public void set(int i_row, int i_column, float i_value);

    /**
     * Sets the entries of the matrix. The entries are set in column major
     * order.
     * 
     * @param the
     *            array, must not be null and contain at least {@link #size()}
     *            elements
     */
    public void setColumnMajor(float[] i_arrayOfFloat);

    /**
     * Sets the entries of the matrix, reading from the buffer. The entries are
     * set in column major (OpenGL) order.
     * 
     * @param the
     *            buffer, must not be null and contain at least {@link #size()}
     *            elements
     */
    public void setColumnMajor(FloatBuffer i_floatBuffer);

    /**
     * Set this matrix to be the identity matrix.
     */
    public void setIdentity();

    /**
     * Sets the entries of the matrix. The entries are set in row major order.
     * 
     * @param the
     *            array, must not be null and contain at least {@link #size()}
     *            elements
     */
    public void setRowMajor(float[] i_arrayOfFloat);

    /**
     * Sets the entries of the matrix, reading from the buffer. The entries are
     * set in row major order.
     * 
     * @param the
     *            buffer, must not be null and contain at least {@link #size()}
     *            elements
     */
    public void setRowMajor(FloatBuffer i_floatBuffer);

    /**
     * Set this matrix to 0.
     */
    public void setZero();

}
