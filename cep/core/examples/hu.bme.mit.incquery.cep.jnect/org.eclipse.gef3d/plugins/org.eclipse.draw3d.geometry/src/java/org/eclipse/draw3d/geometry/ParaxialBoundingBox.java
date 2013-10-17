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
 * A modifiable paraxial bounding box.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 08.08.2009
 */
public interface ParaxialBoundingBox extends IParaxialBoundingBox, BoundingBox {

	/**
	 * Updates this paraxial bounding box so that it is the smallest paraxial
	 * bounding box that contains the given bounding box after the given
	 * bounding box was transformed by the given matrix.
	 * 
	 * @param i_bounds3D the bounding box to contain
	 * @param i_matrix the transformation matrix, usually the model matrix of a
	 *            figure
	 * @throws NullPointerException if any of the given arguments is
	 *             <code>null</code>
	 * @todo optimize this by ditching size and using end to store dimensions
	 */
	public abstract void update(IBoundingBox i_bounds3D, IMatrix4f i_matrix);

	/**
	 * Modifies this paraxial bounding box so that it is the smallest paraxial
	 * bounding box that contains the union of this and the given paraxial
	 * bounding box.
	 * 
	 * @param i_paraxialBoundingBox the paraxial bounding box to unite with
	 * @return <code>true</code> if this bounding box was modified by the union
	 *         operation and <code>false</code> otherwise
	 * @throws NullPointerException if the given paraxial bounding box is
	 *             <code>null</code>
	 */
	public abstract boolean union(IParaxialBoundingBox i_paraxialBoundingBox);
}