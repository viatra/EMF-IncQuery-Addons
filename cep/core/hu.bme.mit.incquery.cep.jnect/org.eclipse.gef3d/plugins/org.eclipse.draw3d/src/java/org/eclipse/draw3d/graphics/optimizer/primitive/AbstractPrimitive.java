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

import org.eclipse.draw3d.geometry.IMatrix3f;
import org.eclipse.draw3d.geometry.Matrix3fImpl;
import org.eclipse.draw3d.graphics.optimizer.PrimitiveBounds;

/**
 * Abstract base implementation for {@link Primitive primitives}. This class
 * implements the {@link #intersects(Primitive)} method by checking the bounding
 * boxes against each other.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 24.12.2009
 */
public abstract class AbstractPrimitive implements Primitive {

	private PrimitiveBounds m_bounds;

	private RenderRule m_renderRule;

	private IMatrix3f m_transformation;

	/**
	 * Creates a new primitive with the given transformation and render rule.
	 * 
	 * @param i_transformation the transformation, may be <code>null</code>
	 * @param i_renderRule the render rule
	 * @throws NullPointerException if the given render rule is
	 *             <code>null</code>
	 */
	protected AbstractPrimitive(IMatrix3f i_transformation,
			RenderRule i_renderRule) {

		if (i_renderRule == null)
			throw new NullPointerException("i_renderRule must not be null");

		if (i_transformation != null)
			m_transformation = new Matrix3fImpl(i_transformation);

		m_renderRule = i_renderRule;
	}

	/**
	 * Calculates the bounding box of this primitive (after the transformation
	 * has been applied).
	 * 
	 * @return the bounding box
	 */
	protected abstract PrimitiveBounds calculateBounds();

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.Primitive#getBounds()
	 */
	public PrimitiveBounds getBounds() {

		if (m_bounds == null)
			m_bounds = calculateBounds();

		return m_bounds;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.Primitive#getRenderRule()
	 */
	public RenderRule getRenderRule() {

		return m_renderRule;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.Primitive#getTransformation()
	 */
	public IMatrix3f getTransformation() {

		return m_transformation;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.Primitive#intersects(org.eclipse.draw3d.graphics.optimizer.primitive.Primitive)
	 */
	public boolean intersects(Primitive i_primitive) {

		PrimitiveBounds bounds = i_primitive.getBounds();
		if (getBounds().intersects(bounds))
			return true;

		if (getBounds().contains(bounds))
			return true;

		if (bounds.contains(getBounds()))
			return true;

		return false;
	}
}
