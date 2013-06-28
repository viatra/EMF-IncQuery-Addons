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
package org.eclipse.draw3d.graphics.optimizer.primitive;

/**
 * A vertex primitive is a primitive that generates vertex data directly.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 23.12.2009
 */
public interface VertexPrimitive extends Primitive {

	/**
	 * Returns the number of vertices of this primitive
	 * 
	 * @return the number of vertices
	 */
	public int getVertexCount();

	/**
	 * Returns the vertices of this primitive (after the transformation has been
	 * applied).
	 * 
	 * @return the vertices
	 */
	public float[] getVertices();
}
