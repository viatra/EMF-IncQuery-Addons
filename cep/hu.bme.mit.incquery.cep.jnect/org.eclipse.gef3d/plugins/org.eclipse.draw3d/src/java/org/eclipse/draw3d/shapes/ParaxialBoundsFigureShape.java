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
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.ParaxialBoundingBox;
import org.eclipse.draw3d.geometry.Position3D;
import org.eclipse.draw3d.geometry.Position3DUtil;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.util.Draw3DCache;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

/**
 * Renders the paraxial bounding box of a figure.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 08.08.2009
 */
public class ParaxialBoundsFigureShape implements Shape {

	private IFigure3D m_figure;

	private Position3D m_position;

	private CuboidShape m_shape;

	/**
	 * Creates a new shape for the given figure.
	 * 
	 * @param i_figure the figure
	 */
	public ParaxialBoundsFigureShape(IFigure3D i_figure) {

		m_figure = i_figure;
		m_position = Position3DUtil.createAbsolutePosition();
		m_shape = new CuboidShape(m_position, false);

		m_shape.setFill(false);
		m_shape.setOutlineColor(Display.getCurrent().getSystemColor(
			SWT.COLOR_RED));
		m_shape.setAlpha(100);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.picking.Pickable#getDistance(org.eclipse.draw3d.geometry.IVector3f,
	 *      org.eclipse.draw3d.geometry.IVector3f, java.util.Map)
	 */
	public float getDistance(IVector3f i_rayOrigin, IVector3f i_rayDirection,
		Map<Object, Object> i_context) {

		return Float.NaN;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.TransparentRenderFragment#getDistanceMeasure(org.eclipse.draw3d.RenderContext)
	 */
	public float getDistanceMeasure(RenderContext i_renderContext) {

		Vector3f viewPoint = Draw3DCache.getVector3f();
		Vector3f center = Draw3DCache.getVector3f();
		Vector3f diff = Draw3DCache.getVector3f();
		ParaxialBoundingBox pBounds = Draw3DCache.getParaxialBoundingBox();
		try {
			ParaxialBoundingBox figureBounds =
				m_figure.getParaxialBoundingBox(pBounds);

			if (figureBounds != null) {
				i_renderContext.getScene().getCamera().getPosition(viewPoint);
				figureBounds.getCenter(center);

				Math3D.sub(center, viewPoint, diff);
				return diff.lengthSquared();
			}

			// this figure is not rendered anyway
			return 0;
		} finally {
			Draw3DCache.returnVector3f(viewPoint, center, diff);
			Draw3DCache.returnParaxialBoundingBox(pBounds);
		}
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
	 * @see org.eclipse.draw3d.RenderFragment#getRenderType()
	 */
	public RenderType getRenderType() {

		return RenderType.TRANSPARENT;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.RenderFragment#render(org.eclipse.draw3d.RenderContext)
	 */
	public void render(RenderContext i_renderContext) {

		Vector3f position = Draw3DCache.getVector3f();
		Vector3f size = Draw3DCache.getVector3f();
		ParaxialBoundingBox pBounds = Draw3DCache.getParaxialBoundingBox();
		try {
			ParaxialBoundingBox figureBounds =
				m_figure.getParaxialBoundingBox(pBounds);

			if (figureBounds != null) {
				figureBounds.getLocation(position);
				figureBounds.getSize(size);

				m_position.setLocation3D(position);
				m_position.setSize3D(size);

				m_shape.render(i_renderContext);
			}
		} finally {
			Draw3DCache.returnVector3f(position, size);
			Draw3DCache.returnParaxialBoundingBox(pBounds);
		}
	}
}
