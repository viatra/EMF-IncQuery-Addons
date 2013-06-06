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
package org.eclipse.draw3d.shapes;

import java.util.Map;

import org.eclipse.draw3d.IFigure3D;
import org.eclipse.draw3d.RenderContext;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.ParaxialBoundingBox;

/**
 * An abstract base class for shapes that use a figure to retrieve graphical
 * properties during rendering. The actual rendering is delegated to a shape.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @param <T> the type of the delegate shape
 * @since 14.10.2009
 */
public abstract class FigureShape<T extends Shape> implements Shape {

	private IFigure3D m_figure;

	private T m_shape;

	/**
	 * Returns the figure.
	 * 
	 * @return the figure
	 */
	protected IFigure3D getFigure() {

		return m_figure;
	}

	/**
	 * Returns the delegate shape.
	 * 
	 * @return the delegate shape
	 */
	protected T getShape() {

		return m_shape;
	}

	/**
	 * Creates a new figure shape.
	 * 
	 * @param i_figure the figure
	 * @param i_shape the delegate shape
	 */
	public FigureShape(IFigure3D i_figure, T i_shape) {

		if (i_figure == null)
			throw new NullPointerException("i_figure must not be null");

		if (i_shape == null)
			throw new NullPointerException("i_shape must not be null");

		m_figure = i_figure;
		m_shape = i_shape;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.picking.Pickable#getDistance(org.eclipse.draw3d.geometry.IVector3f,
	 *      org.eclipse.draw3d.geometry.IVector3f, java.util.Map)
	 */
	public float getDistance(IVector3f i_rayOrigin, IVector3f i_rayDirection,
		Map<Object, Object> i_context) {

		return m_shape.getDistance(i_rayOrigin, i_rayDirection, i_context);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.picking.Pickable#getParaxialBoundingBox(org.eclipse.draw3d.geometry.ParaxialBoundingBox)
	 */
	public ParaxialBoundingBox getParaxialBoundingBox(
		ParaxialBoundingBox o_result) {

		return m_shape.getParaxialBoundingBox(o_result);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.RenderFragment#getDistanceMeasure(org.eclipse.draw3d.RenderContext)
	 */
	public float getDistanceMeasure(RenderContext i_renderContext) {

		return m_shape.getDistanceMeasure(i_renderContext);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.RenderFragment#getRenderType()
	 */
	public RenderType getRenderType() {

		return m_shape.getRenderType();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FigureShape [m_figure=" + m_figure + ", m_shape=" + m_shape
			+ "]";
	}

}
