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
package org.eclipse.draw3d.picking;

import java.util.Map;

import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.ParaxialBoundingBox;

/**
 * Objects that implement this interface can be picked accurately.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 31.07.2009
 */
public interface Pickable {

	/**
	 * Returns the distance between the given ray start point and the point of
	 * intersection of the given ray and this object, if any. The returned
	 * distance is actually the scalar value x by which the given ray direction
	 * vector must be multiplied so that the following equation is true:
	 * 
	 * <pre>
	 * p = rayOrigin + x * rayDirection
	 * </pre>
	 * 
	 * in which p is the point of intersection, if any. If the given ray does
	 * not intersect with this object, {@link Float#NaN} is returned.
	 * 
	 * @param i_rayOrigin the origin of the picking ray
	 * @param i_rayDirection the direction of the picking ray
	 * @param i_context a map that can be used to store context information if
	 *            not <code>null</code>
	 * @return the scalar value as described above or {@link Float#NaN} if the
	 *         given ray does not intersect with this object
	 */
	public float getDistance(IVector3f i_rayOrigin, IVector3f i_rayDirection,
		Map<Object, Object> i_context);

	/**
	 * Returns a paraxial (to the world coordinate system) bounding box that
	 * contains this object.
	 * 
	 * @param o_result the result bounding box, if <code>null</code>, a new
	 *            bounding box will be returned
	 * @return the paraxial bounding box or <code>null</code> if the concept of
	 *         a bounding box does not apply to this object (e.g. the object is
	 *         empty)
	 */
	public ParaxialBoundingBox getParaxialBoundingBox(
		ParaxialBoundingBox o_result);
}
