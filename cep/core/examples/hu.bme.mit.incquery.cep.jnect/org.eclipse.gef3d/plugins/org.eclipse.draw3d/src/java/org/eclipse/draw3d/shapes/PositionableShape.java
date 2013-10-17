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
import java.util.logging.Logger;

import org.eclipse.draw3d.Figure3D;
import org.eclipse.draw3d.IFigure3D;
import org.eclipse.draw3d.RenderContext;
import org.eclipse.draw3d.RenderFragment;
import org.eclipse.draw3d.ShapeFigure3D;
import org.eclipse.draw3d.geometry.IMatrix4f;
import org.eclipse.draw3d.geometry.IPosition3D;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Math3DCache;
import org.eclipse.draw3d.geometry.ParaxialBoundingBox;
import org.eclipse.draw3d.geometry.ParaxialBoundingBoxImpl;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.graphics3d.Graphics3D;
import org.eclipse.draw3d.graphics3d.Graphics3DDraw;
import org.eclipse.draw3d.util.Draw3DCache;

/**
 * PositionableShape There should really be more documentation here.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 05.08.2009
 */
public abstract class PositionableShape implements Shape {

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(PositionableShape.class
		.getName());

	/**
	 * Position of the shape, usually a shared instance contained by the
	 * {@link IFigure3D} (i.e. a {@link ShapeFigure3D}).
	 */
	private IPosition3D m_position3D;

	/**
	 * Creates a new positionable shape with the given position.
	 * <p>
	 * The position of the shape may be a shared instance contained in the
	 * {@link Figure3D}, usually a {@link ShapeFigure3D}. Thus, changing the
	 * figure's shape also changes the position of the shape without further
	 * method calls (as they both use the same position instance).
	 * </p>
	 * 
	 * @param i_position3D the position of this shape, must not be null
	 * @throws NullPointerException if the given position is <code>null</code>
	 */
	public PositionableShape(IPosition3D i_position3D) {
		if (i_position3D == null) // parameter precondition
			throw new NullPointerException("i_position3D must not be null");

		m_position3D = i_position3D;
	}

	/**
	 * Performs the intersection calculation using the given picking ray. The
	 * picking ray may have been transformed due to the position of this shape.
	 * 
	 * @param i_rayOrigin the origin of the modified picking ray
	 * @param i_rayDirection the direction of the modified picking ray
	 * @param i_context a map for storing context information
	 * @return the distance between the point of intersection of the picking ray
	 *         and this shape or {@link Float#NaN} if the ray does not intersect
	 *         with this shape
	 */
	protected abstract float doGetDistance(IVector3f i_rayOrigin,
		IVector3f i_rayDirection, Map<Object, Object> i_context);

	/**
	 * Performs the actual rendering.
	 * 
	 * @param i_renderContext the current render context
	 */
	protected abstract void doRender(RenderContext i_renderContext);

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.picking.Pickable#getDistance(org.eclipse.draw3d.geometry.IVector3f,
	 *      org.eclipse.draw3d.geometry.IVector3f, java.util.Map)
	 */
	public float getDistance(IVector3f i_rayOrigin, IVector3f i_rayDirection,
		Map<Object, Object> i_context) {

		if (m_position3D == null
			|| m_position3D.getTransformationMatrix()
				.equals(IMatrix4f.IDENTITY))
			return doGetDistance(i_rayOrigin, i_rayDirection, i_context);

		Vector3f newOrigin = Draw3DCache.getVector3f();
		Vector3f newDirection = Draw3DCache.getVector3f();
		try {
			newOrigin.set(i_rayOrigin);
			newDirection.set(i_rayDirection);

			// transform picking ray
			if (!m_position3D.transformRay(newOrigin, newDirection))
				return Float.NaN;

			float newLength = newDirection.length();
			if (newLength != 1)
				newDirection.scale(1 / newLength); // normalise

			float distance = doGetDistance(newOrigin, newDirection, i_context);
			if (Float.isNaN(distance))
				return Float.NaN;

			return distance / newLength;
		} finally {
			Draw3DCache.returnVector3f(newOrigin, newDirection);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.TransparentRenderFragment#getDistanceMeasure(org.eclipse.draw3d.RenderContext)
	 */
	public float getDistanceMeasure(RenderContext i_renderContext) {

		Vector3f viewPoint = Draw3DCache.getVector3f();
		Vector3f diff = Draw3DCache.getVector3f();
		try {
			i_renderContext.getScene().getCamera().getPosition(viewPoint);
			Math3D.sub(m_position3D.getCenter3D(), viewPoint, diff);

			return diff.lengthSquared();
		} finally {
			Draw3DCache.returnVector3f(viewPoint, diff);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.picking.Pickable#getParaxialBoundingBox(ParaxialBoundingBox)
	 */
	public ParaxialBoundingBox getParaxialBoundingBox(
		ParaxialBoundingBox o_result) {

		ParaxialBoundingBox result = o_result;
		if (result == null)
			result = new ParaxialBoundingBoxImpl();

		Vector3f location = Math3DCache.getVector3f();
		Vector3f size = Math3DCache.getVector3f();
		try {
			Math3D.getCuboidParaxialBoundingBox(m_position3D, location, size);

			result.setLocation(location);
			result.setSize(size);

			return result;
		} finally {
			Math3DCache.returnVector3f(location, size);
		}
	}

	/**
	 * Returns the position of this shape.
	 * 
	 * @return the position of this shape
	 */
	public IPosition3D getPosition3D() {

		return m_position3D;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see RenderFragment#render(RenderContext)
	 */
	public void render(RenderContext i_renderContext) {

		if (i_renderContext.getScene().isDebug())
			doRender(i_renderContext);

		if (m_position3D == null)
			doRender(i_renderContext);
		else {
			Graphics3D g3d = i_renderContext.getGraphics3D();
			boolean useModelMatrix =
				m_position3D != null
					&& !IMatrix4f.IDENTITY.equals(m_position3D
						.getTransformationMatrix());

			g3d.glMatrixMode(Graphics3DDraw.GL_MODELVIEW);

			if (useModelMatrix)
				g3d.glPushMatrix();

			try {
				if (useModelMatrix)
					g3d.setPosition(m_position3D);

				doRender(i_renderContext);
			} finally {
				if (useModelMatrix)
					g3d.glPopMatrix();
			}
		}
	}
}
