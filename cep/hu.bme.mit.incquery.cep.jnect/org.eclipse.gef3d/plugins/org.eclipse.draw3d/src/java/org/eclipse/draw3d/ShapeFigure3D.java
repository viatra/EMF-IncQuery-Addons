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
package org.eclipse.draw3d;

import java.util.Map;

import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.ParaxialBoundingBox;
import org.eclipse.draw3d.geometry.ParaxialBoundingBoxImpl;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.shapes.Shape;
import org.eclipse.draw3d.util.Draw3DCache;

/**
 * A figure that is represented visually by a {@link Shape}.
 * 
 * @author Kristian Duske, Jens von Pilgrim
 * @version $Revision$
 * @since 05.08.2009
 */
public abstract class ShapeFigure3D extends Figure3D {

	/**
	 * The shape of this figure, created in {@link #createShape()}.
	 */
	protected Shape m_shape;

	/**
	 * Creates the shape(s) that represent this figure. This method must be
	 * overridden by subclasses and must not return null.
	 * 
	 * @see CompositeShape
	 * @return the shape of this figure, must not return null.
	 */
	protected abstract Shape createShape();

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.Figure3D#getDistance(org.eclipse.draw3d.geometry.IVector3f,
	 *      org.eclipse.draw3d.geometry.IVector3f, java.util.Map)
	 */
	@Override
	public float getDistance(IVector3f i_rayOrigin, IVector3f i_rayDirection,
		Map<Object, Object> i_context) {

		return getShape().getDistance(i_rayOrigin, i_rayDirection, i_context);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.Figure3D#getParaxialBoundingBox(org.eclipse.draw3d.geometry.ParaxialBoundingBox)
	 */
	@Override
	public ParaxialBoundingBox getParaxialBoundingBox(
		ParaxialBoundingBox o_result) {

		ParaxialBoundingBox result = o_result;
		if (o_result == null)
			result = new ParaxialBoundingBoxImpl();

		Vector3f location = Draw3DCache.getVector3f();
		Vector3f size = Draw3DCache.getVector3f();
		try {
			if (m_paraxialBounds == null) {
				m_paraxialBounds = getShape().getParaxialBoundingBox(null);

				if (m_paraxialBounds == null)
					return null;

				helper.unionWithChildParaxialBounds(m_paraxialBounds);
			}

			m_paraxialBounds.getLocation(location);
			m_paraxialBounds.getSize(size);

			result.setLocation(location);
			result.setSize(size);

			return result;
		} finally {
			Draw3DCache.returnVector3f(location, size);
		}
	}

	/**
	 * Returns the shape that represents this figure. If the shape doesn't exist
	 * yet, it is lazily created by calling {@link #createShape()}. This method
	 * never returns null.
	 * 
	 * @return the shape
	 */
	protected Shape getShape() {

		if (m_shape == null) {
			m_shape = createShape();
			if (m_shape == null) {
				throw new NullPointerException("created shape must not be null");
			}
		}

		return m_shape;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.Figure3D#collectRenderFragments(org.eclipse.draw3d.RenderContext)
	 */
	@Override
	public void collectRenderFragments(RenderContext i_renderContext) {

		i_renderContext.addRenderFragment(getShape());
	}
}
