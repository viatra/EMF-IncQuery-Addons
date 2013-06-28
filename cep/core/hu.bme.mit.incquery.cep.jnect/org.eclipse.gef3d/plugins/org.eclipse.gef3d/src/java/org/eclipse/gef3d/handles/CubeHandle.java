/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.handles;

import java.util.Map;
import java.util.logging.Logger;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw3d.RenderContext;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.ParaxialBoundingBox;
import org.eclipse.draw3d.geometry.ParaxialBoundingBoxImpl;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;
import org.eclipse.draw3d.shapes.CuboidFigureShape;
import org.eclipse.draw3d.util.Draw3DCache;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.handles.SquareHandle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;

/**
 * CubeHandle is the 3D version of {@link SquareHandle}.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Mar 25, 2008
 */
public abstract class CubeHandle extends AbstractHandle3D {

	/**
	 * The default size for square handles. (copied from {@link SquareHandle}
	 * and made public)
	 */
	protected static final float DEFAULT_HANDLE_SIZE = 7;

	/**
	 * Logger for this class
	 */
	@SuppressWarnings("unused")
	private static final Logger log =
		Logger.getLogger(CubeHandle.class.getName());

	private CuboidFigureShape m_alphaCube = new CuboidFigureShape(this, false);

	private CuboidFigureShape m_superCube = new CuboidFigureShape(this, true);

	/**
	 * Null constructor
	 */
	public CubeHandle() {

		init();
	}

	/**
	 * Creates a SquareHandle for the given <code>GraphicalEditPart</code> with
	 * the given <code>Locator</code>.
	 * 
	 * @param owner the owner
	 * @param loc the locator
	 */
	public CubeHandle(GraphicalEditPart owner, Locator loc) {
		super(owner, loc);
		init();
	}

	/**
	 * Creates a SquareHandle for the given <code>GraphicalEditPart</code> with
	 * the given <code>Cursor</code> using the given <code>Locator</code>.
	 * 
	 * @param owner The editpart which provided this handle
	 * @param loc The locator to position the handle
	 * @param c The cursor to display when the mouse is over the handle
	 */
	public CubeHandle(GraphicalEditPart owner, Locator loc, Cursor c) {
		super(owner, loc, c);
		init();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.Figure3D#collectRenderFragments(org.eclipse.draw3d.RenderContext)
	 */
	@Override
	public void collectRenderFragments(RenderContext i_renderContext) {

		i_renderContext.addRenderFragment(m_alphaCube);
		i_renderContext.addRenderFragment(m_superCube);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.handles.AbstractHandle3D#createDragTracker()
	 */
	@Override
	protected DragTracker createDragTracker() {
		// TODO implement method CubeHandle.createDragTracker
		return null;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Returns the color for the inside of the handle. Like
	 * {@link SquareHandle#getFillColor()}.
	 * 
	 * @see org.eclipse.draw2d.Figure#getBackgroundColor()
	 */
	@Override
	public Color getBackgroundColor() {

		return (isPrimary()) ? ColorConstants.darkGray : ColorConstants.white;
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

		return m_alphaCube.getDistance(i_rayOrigin, i_rayDirection, i_context);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Returns the color for the outside of the handle, GEF uses
	 * {@link SquareHandle#getBorderColor()} instead.
	 * 
	 * @see org.eclipse.draw2d.Figure#getForegroundColor()
	 */
	@Override
	public Color getForegroundColor() {
		return (isPrimary()) ? ColorConstants.red : ColorConstants.black;
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
				m_paraxialBounds = m_alphaCube.getParaxialBoundingBox(null);

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
	 * Initializes the handle.
	 */
	protected void init() {

		setPreferredSize3D(new Vector3fImpl(DEFAULT_HANDLE_SIZE,
			DEFAULT_HANDLE_SIZE, DEFAULT_HANDLE_SIZE));
		setAlpha(40);
	}

	/**
	 * Returns <code>true</code> if the handle's owner is the primary selection.
	 * 
	 * @return <code>true</code> if the handles owner has primary selection.
	 *         <p>
	 *         Copied (and not modified yet) from {@link SquareHandle}.
	 *         </p>
	 */
	protected boolean isPrimary() {
		return getOwner().getSelected() == EditPart.SELECTED_PRIMARY;
	}

}
