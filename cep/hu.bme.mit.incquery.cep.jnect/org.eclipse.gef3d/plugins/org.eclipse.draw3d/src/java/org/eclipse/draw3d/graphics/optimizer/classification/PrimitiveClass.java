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
package org.eclipse.draw3d.graphics.optimizer.classification;

import org.eclipse.draw3d.graphics.optimizer.primitive.Primitive;
import org.eclipse.draw3d.graphics.optimizer.primitive.RenderRule;

/**
 * Primitives are divided into classes, and each primitive class is represented
 * by an instance of this type.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 27.12.2009
 */
public interface PrimitiveClass {

	/**
	 * Indicates whether the given primitive belongs to this class.
	 * 
	 * @param i_primitive the primitive to check
	 * @return <code>true</code> if the given primitive belongs to this class
	 *         and <code>false</code> otherwise
	 */
	public boolean contains(Primitive i_primitive);

	/**
	 * Returns the render rule of the primitives contained in this class.
	 * 
	 * @return the render rule
	 */
	public RenderRule getRenderRule();

	/**
	 * Indicates whether this class contains gradient primitives.
	 * 
	 * @return <code>true</code> if this class contains gradient primitives and
	 *         <code>false</code> otherwise
	 */
	public boolean isGradient();

	/**
	 * Indicates whether this class contains images.
	 * 
	 * @return <code>true</code> if this class contains images and
	 *         <code>false</code> otherwise
	 */
	public boolean isImage();

	/**
	 * Indicates whether this class contains lines.
	 * 
	 * @return <code>true</code> if this class contains lines and
	 *         <code>false</code> otherwise
	 */
	public boolean isLine();

	/**
	 * Indicates whether this class outline primitives.
	 * 
	 * @return <code>true</code> if this class contains outline primitives and
	 *         <code>false</code> otherwise
	 */
	public boolean isOutline();

	/**
	 * Indicates whether this class contains polygons.
	 * 
	 * @return <code>true</code> if this class contains polygons and
	 *         <code>false</code> otherwise
	 */
	public boolean isPolygon();

	/**
	 * Indicates whether this class contains polylines.
	 * 
	 * @return <code>true</code> if this class contains polylines and
	 *         <code>false</code> otherwise
	 */
	public boolean isPolyline();

	/**
	 * Indicates whether this class contains quads.
	 * 
	 * @return <code>true</code> if this class contains quads and
	 *         <code>false</code> otherwise
	 */
	public boolean isQuad();

	/**
	 * Indicates whether this class contains solid primitives.
	 * 
	 * @return <code>true</code> if this class contains solid primitives and
	 *         <code>false</code> otherwise
	 */
	public boolean isSolid();

	/**
	 * Indicates whether this class contains text.
	 * 
	 * @return <code>true</code> if this class contains text and
	 *         <code>false</code> otherwise
	 */
	public boolean isText();
}
