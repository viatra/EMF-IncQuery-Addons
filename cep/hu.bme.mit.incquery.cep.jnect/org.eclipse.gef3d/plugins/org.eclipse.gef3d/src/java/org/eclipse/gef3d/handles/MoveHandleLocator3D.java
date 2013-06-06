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

import java.util.logging.Logger;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw3d.IFigure3D;
import org.eclipse.draw3d.LocatorHelper;
import org.eclipse.draw3d.geometry.Position3D;
import org.eclipse.draw3d.util.Draw3DCache;
import org.eclipse.gef.handles.MoveHandleLocator;

/**
 * MoveHandleLocator3D, 3D version of {@link MoveHandleLocator}.
 * 
 * @author IBM Corporation (original 2D version)
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Apr 15, 2008
 */
public class MoveHandleLocator3D extends MoveHandleLocator {

	/**
	 * The locator helper.
	 */
	protected LocatorHelper m_helper;

	/**
	 * Logger for this class
	 */
	private static final Logger log =
		Logger.getLogger(MoveHandleLocator3D.class.getName());

	/**
	 * @param i_ref
	 */
	public MoveHandleLocator3D(IFigure i_ref) {
		super(i_ref);
		m_helper = new LocatorHelper(i_ref);
	}

	/**
	 * /** Delegates to 2D method if target and reference figure are 2D. Any
	 * other cases are handled here, and if the target is 2D, a warning is
	 * logged.
	 * 
	 * @see org.eclipse.gef.handles.MoveHandleLocator#relocate(org.eclipse.draw2d.IFigure)
	 */
	@Override
	public void relocate(IFigure i_target) {

		IFigure ref = getReference();
		if (!(ref instanceof IFigure3D) && !(i_target instanceof IFigure3D)) {
			super.relocate(i_target);
		} else {
			if (i_target instanceof IFigure3D) {
				Position3D targetPosition = Draw3DCache.getPosition3D();
				try {
					IFigure3D target3D = (IFigure3D) i_target;
					Position3D refPosition = m_helper.getReferencePosition3D();

					target3D.getPosition3D().setPosition(refPosition);
				} finally {
					Draw3DCache.returnPosition3D(targetPosition);
				}
			} else {
				log.warning("Cannot position 2D Figure based "
					+ "on 3D reference, reference: " + ref + ", target: "
					+ i_target);
			}
		}
	}
}
