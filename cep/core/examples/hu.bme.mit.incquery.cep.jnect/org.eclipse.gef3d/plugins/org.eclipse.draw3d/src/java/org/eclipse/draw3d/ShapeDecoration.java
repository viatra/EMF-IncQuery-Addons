/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;
import org.eclipse.draw3d.util.Draw3DCache;

/**
 * A connection decoration that renders a shape.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 18.05.2008
 */
public abstract class ShapeDecoration extends ShapeFigure3D implements
		RotatableDecoration3D {

	private Vector3fImpl m_lastReference = new Vector3fImpl(0, 0, 0);

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.RotatableDecoration#setReferencePoint(org.eclipse.draw2d.geometry.Point)
	 */
	public void setReferencePoint(Point i_p) {

		throw new UnsupportedOperationException("reference point must be 3D");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.RotatableDecoration3D#setReferencePoint3D(org.eclipse.draw3d.geometry.Vector3f)
	 */
	public void setReferencePoint3D(IVector3f i_reference) {

		if (i_reference == null) {
			if (m_lastReference.x == 0 && m_lastReference.y == 0
				&& m_lastReference.z == 0)
				return;

			getPosition3D().setRotation3D(m_lastReference);
		} else {
			if (i_reference.equals(m_lastReference))
				return;

			Vector3f tmp = Draw3DCache.getVector3f();
			try {
				tmp.set(getPosition3D().getLocation3D());

				Math3D.sub(i_reference, tmp, tmp);
				Math3D.normalise(tmp, tmp);

				Math3D.eulerAngles(IVector3f.Z_AXIS_NEG, tmp, tmp);

				getPosition3D().setRotation3D(tmp);
				m_lastReference.set(tmp);
			} finally {
				Draw3DCache.returnVector3f(tmp);
			}
		}
	}
}
