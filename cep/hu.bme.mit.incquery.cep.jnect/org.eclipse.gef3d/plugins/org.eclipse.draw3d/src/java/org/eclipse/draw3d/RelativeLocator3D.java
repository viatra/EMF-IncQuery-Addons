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
package org.eclipse.draw3d;

import java.util.logging.Logger;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RelativeLocator;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Position3D;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;
import org.eclipse.draw3d.util.Draw3DCache;

/**
 * RelativeLocator3D, 3D version of the 2D relative locator
 * {@link RelativeLocator}. This 3D version extends its 2D version, so it can be
 * used instead of the 2D version.
 * <p>
 * This locator (as its 2D version) is used for positioning handles on figures,
 * see GEF's <code>ResizableEditPolicy</code> (and other selection policies) of
 * how this locator and handles are used.
 * 
 * @author IBM Corporation (original 2D version)
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Mar 24, 2008
 */
public class RelativeLocator3D extends RelativeLocator {

	/**
	 * The locator helper.
	 */
	protected LocatorHelper m_helper;

	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger.getLogger(RelativeLocator3D.class
		.getName());

	/**
	 * Contains the relative offset factors.
	 */
	protected Vector3fImpl m_factors = new Vector3fImpl(0, 0, 0);

	/**
	 * Creates a new instance with no relative offset.
	 */
	public RelativeLocator3D() {

		// nothing to initialize
	}

	/**
	 * Just as {@link RelativeLocator#RelativeLocator(IFigure, double, double)},
	 * relative z is set to front face (1.0)
	 * 
	 * @param i_reference the reference figure
	 * @param i_relativeX the relative X offset
	 * @param i_relativeY the relative Y offset
	 */
	public RelativeLocator3D(IFigure i_reference, double i_relativeX,
			double i_relativeY) {

		this(i_reference, i_relativeX, i_relativeY, 1);
	}

	/**
	 * Creates a new relative locator with the given reference figure and
	 * relative X, Y and Z offsets
	 * 
	 * @param i_reference the reference figure
	 * @param i_relativeX the relative X offset
	 * @param i_relativeY the relative Y offset
	 * @param i_relativeZ the relative Z offset
	 */
	public RelativeLocator3D(IFigure i_reference, double i_relativeX,
			double i_relativeY, double i_relativeZ) {

		super(i_reference, i_relativeX, i_relativeY);
		m_factors.set((float) i_relativeX, (float) i_relativeY,
			(float) i_relativeZ);
		m_helper = new LocatorHelper(i_reference);
	}

	/**
	 * Creates a new relative locator with the given reference figure and
	 * relative location. The given location is one of {@link PositionConstants}
	 * and the relative Z location is set to {@link PositionConstants3D#ZMIDDLE}
	 * .
	 * 
	 * @param i_reference the reference figure
	 * @param i_location the relative 2D location
	 */
	public RelativeLocator3D(IFigure i_reference, int i_location) {

		this(i_reference, i_location, PositionConstants3D.ZMIDDLE);
	}

	/**
	 * Creates a new relative locator with the given reference figure and
	 * relative location. The given location is one of {@link PositionConstans}
	 * and the given Z location is one of {@link PositionConstants3D}.
	 * 
	 * @param i_reference the reference figure
	 * @param i_location the relative 2D location
	 * @param i_zlocation the relative Z location
	 */
	public RelativeLocator3D(IFigure i_reference, int i_location,
			PositionConstants3D i_zlocation) {

		super(i_reference, i_location);
		switch (i_location & PositionConstants.NORTH_SOUTH) {
		case PositionConstants.NORTH:
			m_factors.y = 0;
			break;
		case PositionConstants.SOUTH:
			m_factors.y = 1.0f;
			break;
		default:
			m_factors.y = 0.5f;
		}

		switch (i_location & PositionConstants.EAST_WEST) {
		case PositionConstants.WEST:
			m_factors.x = 0;
			break;
		case PositionConstants.EAST:
			m_factors.x = 1.0f;
			break;
		default:
			m_factors.x = 0.5f;
		}

		switch (i_zlocation) {
		case FRONT:
			m_factors.z = 1.0f;
			break;
		case BACK:
			m_factors.z = 0;
			break;
		default: // ZMIDDLE
			m_factors.z = 0.5f;
		}

		m_helper = new LocatorHelper(i_reference);
	}

	/**
	 * Delegates to 2D method if target and reference figure are 2D. Any other
	 * cases are handled here, and if the target is 2D, a warning is logged.
	 * 
	 * @see org.eclipse.draw2d.RelativeLocator#relocate(org.eclipse.draw2d.IFigure)
	 */
	@Override
	public void relocate(IFigure i_target) {

		IFigure ref = getReferenceFigure();
		if (!(ref instanceof IFigure3D) && !(i_target instanceof IFigure3D)) {
			super.relocate(i_target);
		} else {
			if (i_target instanceof IFigure3D) {
				Position3D targetPosition = Draw3DCache.getPosition3D();
				Vector3f location = Draw3DCache.getVector3f();
				Vector3f size = Draw3DCache.getVector3f();
				try {
					IFigure3D target3D = (IFigure3D) i_target;

					Position3D refPosition = m_helper.getReferencePosition3D();
					// refPosition is relative to ref's parent

					// calculate location offset to appropriate vertex/edge:
					Math3D.scale(m_factors, refPosition.getSize3D(), location);
					// slightly correct position with targets half size
					// we want to locate the center of the target on the
					// intended vertex/edge:
					Math3D.scale(1 / 2f, target3D.getPreferredSize3D(), size);
					Math3D.sub(location, size, location);

					// "move" target to calculated location and
					// handle rotation
					Math3D.rotate(refPosition.getRotation3D(), location, location);
					Math3D.add(location, refPosition.getLocation3D(), location);
					
					refPosition.setLocation3D(location);
					refPosition.setSize3D(target3D.getPreferredSize3D());

					target3D.getPosition3D().setPosition(refPosition);
				} finally {
					Draw3DCache.returnPosition3D(targetPosition);
					Draw3DCache.returnVector3f(location, size);
				}
			} else {
				log.warning("Cannot position 2D Figure based "
					+ "on 3D reference, reference: " + ref + ", target: "
					+ i_target);
			}
		}
	}
}
