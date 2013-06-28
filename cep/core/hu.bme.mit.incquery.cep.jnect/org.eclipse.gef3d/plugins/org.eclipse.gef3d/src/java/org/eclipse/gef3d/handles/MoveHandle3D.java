/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others,
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation of 2D version
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.handles;

import java.util.Map;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Cursors;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw3d.RenderContext;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Math3DCache;
import org.eclipse.draw3d.geometry.ParaxialBoundingBox;
import org.eclipse.draw3d.geometry.Position3D;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.shapes.CuboidFigureShape;
import org.eclipse.draw3d.shapes.CuboidShape;
import org.eclipse.draw3d.util.Draw3DCache;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.tools.DragEditPartsTracker;
import org.eclipse.gef3d.editpolicies.ResizableEditPolicy3D;

/**
 * 3D version of {@link MoveHandle}. The move handle is created via a
 * {@link MoveHandle3DFactory}, which is used by appropriate policies such as
 * the {@link ResizableEditPolicy3D}.
 * <p>
 * Parts of this class (methods and/or comments) were copied and modified from
 * {@link MoveHandle}, copyright (c) 2000, 2005 IBM Corporation and others and
 * distributed under the EPL license.
 * </p>
 * 
 * @author IBM Corporation (original 2D version)
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Apr 15, 2008
 */
public class MoveHandle3D extends AbstractHandle3D {

	private static final float INNER_PAD = 4;
	private CuboidFigureShape m_shape = new CuboidFigureShape(this, true);

	/**
	 * Creates a MoveHandle for the given <code>GraphicalEditPart</code> using a
	 * default {@link Locator}.
	 * <p>
	 * Copied from {@link MoveHandle#MoveHandle(GraphicalEditPart)}, using a 3D
	 * locator instead of a 2D one
	 * </p>
	 * 
	 * @param owner The GraphicalEditPart to be moved by this handle.
	 */
	public MoveHandle3D(GraphicalEditPart owner) {

		this(owner, new MoveHandleLocator3D(owner.getFigure()));
	}

	/**
	 * Creates a MoveHandle for the given <code>GraphicalEditPart</code> using
	 * the given <code>Locator</code>.
	 * <p>
	 * Copied from {@link MoveHandle#MoveHandle(GraphicalEditPart, Locator)} and
	 * not yet modified.
	 * </p>
	 * 
	 * @param owner The GraphicalEditPart to be moved by this handle.
	 * @param loc The Locator used to place the handle.
	 */
	public MoveHandle3D(GraphicalEditPart owner, Locator loc) {

		super(owner, loc);
		initialize();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.Figure3D#collectRenderFragments(org.eclipse.draw3d.RenderContext)
	 */
	@Override
	public void collectRenderFragments(RenderContext i_renderContext) {
		i_renderContext.addRenderFragment(m_shape);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Copied from {@link MoveHandle#MoveHandle(GraphicalEditPart, Locator)}.
	 * </p>
	 * 
	 * @see org.eclipse.gef3d.handles.AbstractHandle3D#createDragTracker()
	 */
	@Override
	protected DragTracker createDragTracker() {

		DragEditPartsTracker tracker = new DragEditPartsTracker(getOwner());
		tracker.setDefaultCursor(getCursor());

		return tracker;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.Figure3D#getDistance(org.eclipse.draw3d.geometry.IVector3f,
	 *      org.eclipse.draw3d.geometry.IVector3f, java.util.Map)
	 */
	@Override
	public float getDistance(IVector3f i_rayOrigin, IVector3f i_rayDirection,
		Map<Object, Object> i_context) {

		float outer =
			m_shape.getDistance(i_rayOrigin, i_rayDirection, i_context);

		if (!Float.isNaN(outer)) {
			Position3D pos = Draw3DCache.getPosition3D();
			Vector3f v=Draw3DCache.getVector3f();
			try {
				pos.setPosition(getPosition3D());
				v.set(pos.getSize3D());
				v.setX(v.getX() - INNER_PAD);
				v.setY(v.getY() - INNER_PAD);
				v.setZ(v.getZ() + 0.05f);
				pos.setSize3D(v);
				CuboidShape neg = new CuboidShape(pos, false);
				float inner = neg.getDistance(i_rayOrigin, i_rayDirection, i_context);
				return Float.isNaN(inner) ? outer : Float.NaN;

			} finally {
				Draw3DCache.returnVector3f(v);
				Draw3DCache.returnPosition3D(pos);
			}
		}
		
		return outer;

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.Figure3D#getParaxialBoundingBox(org.eclipse.draw3d.geometry.ParaxialBoundingBox)
	 */
	@Override
	public ParaxialBoundingBox getParaxialBoundingBox(
		ParaxialBoundingBox o_result) {

		return m_shape.getParaxialBoundingBox(o_result);
	}

	/**
	 * Initializes the handle, i.e. sets figure's properties.
	 * <p>
	 * Copied from {@link MoveHandle#initialize()}, additionally 3D properties
	 * are set.
	 * <p>
	 */
	protected void initialize() {
		// from MoveHandle:
		setOpaque(false);
		setBorder(new LineBorder(1));
		setCursor(Cursors.SIZEALL);

		// 3D:
		setAlpha(100);
		setBackgroundColor(ColorConstants.green);
		setForegroundColor(ColorConstants.green);

		m_shape.setFill(false);
	}
}
