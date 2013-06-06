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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;

/**
 * A layout similar to XYZLayout, except that 3D figures with surfaces are
 * positioned along the Z axis in a configurable distance, if no explicit
 * constraint is set. If no explicit constraint value is given, the X and Y
 * position is set to 0, the size and rotation of the children are not changed.
 * Only children with surfaces are stacked, other children are layouted similar
 * to {@link XYZLayout}.
 * 
 * @author Kristian Duske, Jens von Pilgrim
 * @version $Revision$
 * @since 06.09.2009
 */
public class StackLayout3D extends XYZLayout {

	/**
	 * The distance between two layers
	 */
	protected float m_distance;

	protected Vector3f m_lastStackLocation;

	/**
	 * Creates a stack layout with a layer distance of 1000
	 */
	public StackLayout3D() {
		this(1000f);
	}

	/**
	 * Creates a stack layout with a given layer distance
	 * 
	 * @param i_distance
	 */
	public StackLayout3D(float i_distance) {
		m_distance = i_distance;
		m_lastStackLocation = new Vector3fImpl(0, 0, 0);
	}

	/**
	 * Returns the currently used distance.
	 * 
	 * @return the distance
	 */
	public float getDistance() {
		return m_distance;
	}

	/**
	 * Sets a new distance between layers. This distance is only effective when
	 * the figure is redrawn.
	 * 
	 * @param i_distance the distance to set
	 */
	public void setDistance(float i_distance) {
		m_distance = i_distance;
	}

	/**
	 * Layouts the children of the given figure similar to {@link XYZLayout},
	 * except if no constraint is provided and {@link #isChildStacked(Object)}
	 * returns true, a constraint is created in order to stack the children
	 * along the z axis.
	 * 
	 * @see org.eclipse.draw3d.XYZLayout#layout(org.eclipse.draw2d.IFigure)
	 */
	@Override
	public void layout(IFigure parent) {
		Point offset = getOrigin(parent);
		ISurface surface = null;
		if (parent instanceof IFigure2DHost3D) {
			surface = ((IFigure2DHost3D) parent).getSurface();
		}

		for (Object child : parent.getChildren()) {
			IFigure f = (IFigure) child;
			Object constraint = getConstraint(f);
			if (constraint == null) {
				if (isChildStacked(f)) {
					constraint = new Vector3fImpl(m_lastStackLocation);

					// this is only for testing purposes (didn't want
					// to remove it yet):
					// Position3D p = ((IFigure3D) f).getPosition3D();
					// Position3D a = Position3DUtil.createAbsolutePosition();
					// a.setPosition(p);
					// a.setLocation3D((IVector3f) constraint);
					// a.setRotation3D(new Vector3fImpl(0, Math3D.PI / 4f,
					// Math3D.PI / 4f));
					// constraint = a;

					setConstraint(f, constraint);
					m_lastStackLocation.translate(0, 0, m_distance);
				} else {
					continue;
				}
			}
			layoutChild(f, constraint, offset, surface);

		}

	}

	/**
	 * Returns true if the given child is to be stacked, that is if it is a
	 * layer added to the stacks. The default implementation returns true if and
	 * only if the child is a {@link IFigure3D} and
	 * {@link IFigure3D#getSurface()} is not null. Subclasses may override this
	 * method.
	 * 
	 * @param i_child
	 * @return
	 */
	protected boolean isChildStacked(Object i_child) {
		if (i_child instanceof IFigure3D) {
			return ((IFigure3D) i_child).getSurface() != null;
		}
		return false;
	}
}
