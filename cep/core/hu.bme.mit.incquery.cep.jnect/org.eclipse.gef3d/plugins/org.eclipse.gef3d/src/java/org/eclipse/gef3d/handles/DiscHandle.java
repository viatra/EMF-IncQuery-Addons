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
package org.eclipse.gef3d.handles;

import java.util.Map;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw3d.RenderContext;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.ParaxialBoundingBox;
import org.eclipse.draw3d.geometry.ParaxialBoundingBoxImpl;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;
import org.eclipse.draw3d.shapes.CylindricFigureShape;
import org.eclipse.draw3d.util.Draw3DCache;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.handles.SquareHandle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;

/**
 * A handle that renders itself in the form of a disc.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 18.06.2009
 */
public abstract class DiscHandle extends AbstractHandle3D {

	/**
	 * The default size (height and diameter) of the handle.
	 */
	protected static final float DEFAULT_HANDLE_SIZE = 7;

	private CylindricFigureShape m_alphaDisc =
		new CylindricFigureShape(this, 12, 1, false);

	private CylindricFigureShape m_superDisc =
		new CylindricFigureShape(this, 12, 1, true);

	/**
	 * Creates a disc handle for the given <code>GraphicalEditPart</code> with
	 * the given <code>Locator</code>.
	 * 
	 * @param owner the edit part which created this handle
	 * @param loc the locator to position this handle
	 */
	public DiscHandle(GraphicalEditPart owner, Locator loc) {
		super(owner, loc);
		init();
	}

	/**
	 * Creates a disc handle for the given <code>GraphicalEditPart</code> with
	 * the given <code>Cursor</code> using the given <code>Locator</code>.
	 * 
	 * @param owner the edit part which created this handle
	 * @param loc the locator to position this handle
	 * @param c the cursor to display when the mouse hovers over this handle
	 */
	public DiscHandle(GraphicalEditPart owner, Locator loc, Cursor c) {
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

		i_renderContext.addRenderFragment(m_alphaDisc);
		i_renderContext.addRenderFragment(m_superDisc);
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

		return isPrimary() ? ColorConstants.darkGray : ColorConstants.white;

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

		return m_alphaDisc.getDistance(i_rayOrigin, i_rayDirection, i_context);
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

		return ColorConstants.black;
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
				m_paraxialBounds = m_alphaDisc.getParaxialBoundingBox(null);

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
	 * Initializes this handle.
	 */
	protected void init() {

		setPreferredSize3D(new Vector3fImpl(DEFAULT_HANDLE_SIZE,
			DEFAULT_HANDLE_SIZE, DEFAULT_HANDLE_SIZE));
		setAlpha(40);
	}

	/**
	 * Indicates whether the handle's owner is the primary selection.
	 * 
	 * @return <code>true</code> if the handles owner is the primary selection.
	 *         <p>
	 *         Copied (and not modified yet) from {@link SquareHandle}.
	 *         </p>
	 */
	protected boolean isPrimary() {

		return getOwner().getSelected() == EditPart.SELECTED_PRIMARY;
	}

}
