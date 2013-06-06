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

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Position3D;
import org.eclipse.draw3d.geometry.Position3DUtil;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.util.Draw3DCache;

/**
 * Contains useful functions for locators.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 10.08.2009
 */
public class LocatorHelper {

	private IFigure m_reference;

	/**
	 * @return the reference
	 */
	public IFigure getReference() {
		return m_reference;
	}

	/**
	 * Creates a new locator helper with the given reference figure.
	 * 
	 * @param i_reference the reference figure
	 */
	public LocatorHelper(IFigure i_reference) {

		if (i_reference == null)
			throw new NullPointerException("i_reference must not be null");

		m_reference = i_reference;
	}

	/**
	 * Returns the reference position relative to the host of the reference
	 * figure.
	 * 
	 * @return the reference position
	 */
	public Position3D getReferencePosition3D() {

		if (m_reference instanceof IFigure3D)
			return getReferencePosition3D(m_reference.getParent());

		return getReferencePosition3D(m_reference);
	}

	public Position3D getReferencePosition3D(IFigure host) {
		IFigure3D host3D = Figure3DHelper.getAncestor3D(host);
		Position3D result = Position3DUtil.createRelativePosition(host3D);

		if (m_reference instanceof IFigure3D) {
			IFigure3D ref3D = (IFigure3D) m_reference;
			result.setPosition(ref3D.getPosition3D());

			return result;
		} else {
			Vector3f location = Draw3DCache.getVector3f();
			Vector3f size = Draw3DCache.getVector3f();
			try {

				Rectangle refBounds;
				if (m_reference instanceof Connection)
					refBounds =
						((Connection) m_reference).getPoints().getBounds();
				else
					refBounds = m_reference.getBounds();
				// m_reference.getParent().translateToAbsolute(refBounds);

				location.set(refBounds.x, refBounds.y, 0);
				size.set(refBounds.width, refBounds.height, 1);

				result.setLocation3D(location);
				result.setSize3D(size);
				result.setRotation3D(IVector3f.NULLVEC3f);

				return result;
			} finally {
				Draw3DCache.returnVector3f(location, size);
			}
		}
	}
}
