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


/**
 * Mutable matrix4f.
 * 
 * <p>
 * For an explanation of row- and column-major format, see  interface
 * {@link IMatrix4f}.
 * </p>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Dec 16, 2008
 */
public interface Matrix4f extends IMatrix4f, Matrix {
	
	/**
	 * Sets the component's values of this matrix to the values of the given
	 * matrix.
	 * 
	 * @param i_sourceMatrix4f must not be null
	 */
	public void set(IMatrix4f i_sourceMatrix4f);

		
		
}
