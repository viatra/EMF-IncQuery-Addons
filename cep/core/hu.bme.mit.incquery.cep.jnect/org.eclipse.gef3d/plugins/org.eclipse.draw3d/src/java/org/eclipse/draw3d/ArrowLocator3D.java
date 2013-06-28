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

import java.util.List;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw3d.geometry.IVector3f;

/**
 * Locator used to place a {@link RotatableDecoration3D} on a
 * {@link Connection3D}. The decoration can be placed at the source or target
 * end of the connection figure. The default connection implementation uses a
 * {@link DelegatingLayout} which requires locators.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 17.05.2008
 */
public class ArrowLocator3D extends ConnectionLocator3D {

	/**
	 * Creates a new locator for the given connection and alignment.
	 * 
	 * @param i_connection the connection
	 * @param i_alignment the alignment
	 */
	public ArrowLocator3D(Connection3D i_connection, int i_alignment) {
		super(i_connection, i_alignment);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Locator#relocate(org.eclipse.draw2d.IFigure)
	 */
	@Override
	public void relocate(IFigure i_target) {

		super.relocate(i_target);

		if (getConnection() instanceof Connection3D) {
			Connection3D connection3D = (Connection3D) getConnection();

			List<IVector3f> points = connection3D.getPoints3D();
			RotatableDecoration3D arrow = (RotatableDecoration3D) i_target;

			if (getAlignment() == SOURCE)
				arrow.setReferencePoint3D(points.get(1));
			else if (getAlignment() == TARGET)
				arrow.setReferencePoint3D(points.get(points.size() - 2));
		}

		// TODO implement for 2D connections also
	}
}
