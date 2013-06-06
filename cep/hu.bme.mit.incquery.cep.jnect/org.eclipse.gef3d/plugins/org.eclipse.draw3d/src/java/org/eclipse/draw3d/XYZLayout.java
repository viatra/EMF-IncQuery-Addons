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
package org.eclipse.draw3d;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw3d.geometry.IBoundingBox;
import org.eclipse.draw3d.geometry.IPosition3D;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.util.Draw3DCache;

/**
 * 3D version of the {@link XYLayout}. This lays out the components using the
 * layout constraints as defined by each component. The constraints are expected
 * to be either {@link IVector3f} (location only), {@link IPosition3D} (full 3D
 * position information), {@link Rectangle} (2D with location and size), or only
 * {@link Point}. If constraints are null or another type, the position of the
 * child is not changed by this manager. Also, the surface of the parent is
 * ignored here, if you want to ensure that children are painted on top of their
 * parent's surface, use the XYZSurfaceLayout layout manager.
 * <p>
 * If child is not a 3D figure, only its 2D location components are set, other
 * values maybe present in the constraint are ignored. Particularly no
 * projection is performed.
 * </p>
 * 
 * @todo (3D) preferred size not supported yet
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 14.01.2008
 */
public class XYZLayout extends XYLayout {
	/**
	 * Logger for this class
	 */
	// @SuppressWarnings("unused") //$NON-NLS-1$
	private static final Logger log = Logger.getLogger(XYZLayout.class
		.getName());

	/**
	 * Implements the algorithm to layout the components of the given container
	 * figure. Each component is laid out using its own layout constraint
	 * specifying its size and position. The layout can handle different types
	 * of constraints:
	 * <ol>
	 * <li>{@link IPosition3D} or {@link IBoundingBox}: if child is an instance
	 * of {@link IFigure3D}, the position of the figure is simply set to the
	 * constraint's value, otherwise bounding box is converted into a rectangle.
	 * </li>
	 * <li>{@link IVector3f}: if child is an instance of {@link IFigure3D}, the
	 * constraint is interpreted as location. If you want to set the size or
	 * rotation, use {@link IPosition3D}. If the child is a 2D figure, the
	 * location is converted into a rectangle.</li>
	 * <li>{@link Rectangle}: child is located similar to {@link XYLayout}, note
	 * that 2D and 3D figures can be positioned that way</li>
	 * </ol>
	 * 
	 * @see org.eclipse.draw2d.XYLayout#layout(org.eclipse.draw2d.IFigure)
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
			if (constraint == null)
				continue;

			layoutChild(f, constraint, offset, surface);

		}

	}

	/**
	 * @param f must not be null
	 * @param constraint must not be null
	 * @param offset
	 * @param surface
	 */
	protected void layoutChild(IFigure f, Object i_constraint, Point offset,
		ISurface surface) {
		Object processedConstraint = i_constraint;
		if (processedConstraint instanceof IPosition3D) {
			if (f instanceof IFigure3D) {
				((IFigure3D) f).getPosition3D().setPosition(
					(IPosition3D) processedConstraint);
				return;
			} else {
				processedConstraint =
					toRectangle(((IPosition3D) processedConstraint).getBounds3D(),
						surface);
			}
		} else if (processedConstraint instanceof IBoundingBox) {
			if (f instanceof IFigure3D) {
				Vector3f location = Draw3DCache.getVector3f();
				Vector3f size = Draw3DCache.getVector3f();
				try {
					IBoundingBox boundingBox = ((IBoundingBox) processedConstraint);
					boundingBox.getLocation(location);
					boundingBox.getSize(size);
					((IFigure3D) f).getPosition3D().setLocation3D(location);
					((IFigure3D) f).getPosition3D().setSize3D(size);
				} finally {
					Draw3DCache.returnVector3f(location, size);
				}
				return;
			} else {
				processedConstraint = toRectangle((IBoundingBox) processedConstraint, surface);
			}
		} else if (processedConstraint instanceof IVector3f) {
			if (f instanceof IFigure3D) {
				((IFigure3D) f).getPosition3D().setLocation3D(
					(IVector3f) processedConstraint);
				return;
			} else {
				processedConstraint = toRectangle((IVector3f) processedConstraint, surface);
			}
		}

		if (processedConstraint instanceof Rectangle) {
			// 2D figure, use layout algorithm of XYLayout
			Rectangle bounds = (Rectangle) processedConstraint;

			// layout "algorithm", 1:1 copy from XYLayout:
			if (bounds.width == -1 || bounds.height == -1) {
				Dimension figuresPreferredSize =
					f.getPreferredSize(bounds.width, bounds.height);
				bounds = bounds.getCopy();
				if (bounds.width == -1)
					bounds.width = figuresPreferredSize.width;
				if (bounds.height == -1)
					bounds.height = figuresPreferredSize.height;
			}
			bounds = bounds.getTranslated(offset);
			f.setBounds(bounds);
			return;
		}

		if (log.isLoggable(Level.INFO)) {
			log.info("Cannot handle constraint type " //$NON-NLS-1$
				+ processedConstraint.getClass() + " for " //$NON-NLS-1$
				+ f.getClass());
		}
	}

	/**
	 * Converts a position 3D to a rectangle by projecting it onto the surface.
	 * The depth of the position is ignored.
	 * 
	 * @param boundingBox the new location and size
	 * @param surface if null, rotation and z values are simply ignored
	 * @return
	 */
	protected Rectangle toRectangle(IBoundingBox boundingBox, ISurface surface) {

		if (surface == null) {
			Vector3f location = Draw3DCache.getVector3f();
			boundingBox.getLocation(location);
			Vector3f size = Draw3DCache.getVector3f();
			boundingBox.getSize(size);
			try {
				return new Rectangle((int) location.getX(),
					(int) location.getY(), (int) size.getX(), (int) size.getY());
			} finally {
				Draw3DCache.returnVector3f(location, size);
			}
		}

		Point l2D = Draw3DCache.getPoint();
		Point e2D = Draw3DCache.getPoint();
		Vector3f location = Draw3DCache.getVector3f();
		boundingBox.getLocation(location);
		Vector3f end = Draw3DCache.getVector3f();
		boundingBox.getEnd(end);
		try {
			surface.getSurfaceLocation2D(location, l2D);
			surface.getSurfaceLocation2D(end, e2D);
			return new Rectangle(l2D, e2D);
		} finally {
			Draw3DCache.returnPoint(l2D, e2D);
			Draw3DCache.returnVector3f(location, end);
		}

	}

	/**
	 * Converts a location into a rectangle. The position of the rectangle is
	 * the projection of the location onto the surface, width and height are set
	 * to -1.
	 * 
	 * @param location3D the 3D location
	 * @param surface the surface used for transforming the 3D location into a
	 *            rectangle, if the surface is null, the location is simply
	 *            transformed into the rectangle by ignoring the z value.
	 * @return
	 */
	protected Rectangle toRectangle(IVector3f location3D, ISurface surface) {
		if (surface == null) {
			return new Rectangle((int) location3D.getX(),
				(int) location3D.getY(), -1, -1);
		}

		Point p = surface.getSurfaceLocation2D(location3D, null);
		return new Rectangle(p.x, p.y, -1, -1);
	}
}
