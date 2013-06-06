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
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw3d.geometry.BoundingBoxImpl;
import org.eclipse.draw3d.geometry.IBoundingBox;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;
import org.eclipse.draw3d.util.Draw3DCache;

/**
 * 3D version of {@link org.eclipse.draw2d.ChopboxAnchor}.
 * 
 * @author IBM Corporation (original 2D version)
 * @author Jens von Pilgrim
 * @version $Revision: 284 $
 * @since 31.10.2007
 * @see org.eclipse.draw2d.ChopboxAnchor
 */
public class BorderAnchor3D extends AbstractConnectionAnchor3D {

	@SuppressWarnings("unused")
	private static final Logger log =
		Logger.getLogger(BorderAnchor3D.class.getName());

	private ISurface m_surface;

	private Locator1D m_xLocator;

	private Locator1D m_yLocator;

	private Locator1D m_zLocator;

	/**
	 * Constructs a new ChopboxAnchor.
	 */
	protected BorderAnchor3D() {
		// nothing to initialize
	}

	/**
	 * Constructs a border anchor with the given <i>owner</i> figure that
	 * positions the connection endpoint in the center of the owner.
	 * 
	 * @param owner the owner figure
	 * @since 2.0
	 */
	public BorderAnchor3D(IFigure owner) {
		this(owner, new Locator1D.Relative(0.5f), new Locator1D.Relative(0.5f),
			new Locator1D.Relative(0.5f));
	}

	/**
	 * Creates a new anchor with the given 1D locators for the X, Y and Z axes.
	 * 
	 * @param i_owner the owner of this anchor
	 * @param i_xLocator the X axis locator
	 * @param i_yLocator the Y axis locator
	 * @param i_zLocator the Z axis locator
	 */
	public BorderAnchor3D(IFigure i_owner, Locator1D i_xLocator,
			Locator1D i_yLocator, Locator1D i_zLocator) {

		super(i_owner);

		if (i_xLocator == null)
			throw new NullPointerException("i_xLocator must not be null");

		if (i_yLocator == null)
			throw new NullPointerException("i_yLocator must not be null");

		if (i_zLocator == null)
			throw new NullPointerException("i_zLocator must not be null");

		m_xLocator = i_xLocator;
		m_yLocator = i_yLocator;
		m_zLocator = i_zLocator;
	}

	/**
	 * @param reference
	 * @param absoluteMode used in 2D mode to translate owner to absolute. In 3D
	 *            mode this is done when converting the location to 3D. (have I
	 *            heard someone whisper "this is a hack"?)
	 * @return
	 */
	private Point doGetLocation(Point reference, boolean absoluteMode) {

		// TODO: this is buggy
		Rectangle r = Rectangle.SINGLETON;
		r.setBounds(getBox());
		r.translate(-1, -1);
		r.resize(1, 1);

		if (absoluteMode)
			getOwner().translateToAbsolute(r);
		float centerX = r.x + 0.5f * r.width;
		float centerY = r.y + 0.5f * r.height;

		if (r.isEmpty() || reference == null
			|| (reference.x == (int) centerX && reference.y == (int) centerY)) {
			return new Point((int) centerX, (int) centerY); // This avoids
			// divide-by-zero
		}

		float dx = reference.x - centerX;
		float dy = reference.y - centerY;

		// r.width, r.height, dx, and dy are guaranteed to be non-zero.
		float scale =
			0.5f / Math.max(Math.abs(dx) / r.width, Math.abs(dy) / r.height);

		dx *= scale;
		dy *= scale;
		centerX += dx;
		centerY += dy;

		return new Point(Math.round(centerX), Math.round(centerY));
	}

	private Vector3f doGetReferencePoint3D(Vector3f io_result) {

		Vector3f result = io_result;
		if (result == null)
			result = new Vector3fImpl();

		Vector3f size = Draw3DCache.getVector3f();
		try {
			IBoundingBox boundingBox = getBounds3D();
			boundingBox.getSize(size);

			// bounding box is a dot
			if (size.lengthSquared() == 0) {
				boundingBox.getCenter(result);
				return result;
			}

			result.setX(m_xLocator.getLocation(size.getX()));
			result.setY(m_yLocator.getLocation(size.getY()));
			result.setZ(m_zLocator.getLocation(size.getZ()));

			ISurface surface = getSurface();
			surface.getWorldLocation(result, result);

			return result;
		} finally {
			Draw3DCache.returnVector3f(size);
		}

	}

	/**
	 * Returns the 3D bounding box of this ChopboxAnchor's owner. Subclasses can
	 * override this method to adjust the box the anchor can be placed on.
	 * 
	 * @return the bounds of this ChopboxAnchor's owner
	 * @throws IllegalStateException if no 3D bounding box can be determined
	 */
	protected IBoundingBox getBounds3D() {

		IFigure owner = getOwner();
		if (owner instanceof IFigure3D) {
			IFigure3D owner3D = (IFigure3D) owner;
			return owner3D.getBounds3D();
		} else {
			Vector3f origin3D = Draw3DCache.getVector3f();
			Vector3f tmp = Draw3DCache.getVector3f();
			Vector3f size3D = Draw3DCache.getVector3f();

			try {
				IFigure3D host = Figure3DHelper.getAncestor3D(owner);
				if (host == null)
					throw new IllegalStateException("no 3D host found");

				ISurface surface = host.getSurface();

				Rectangle bounds = owner.getBounds();
				Point bl = bounds.getBottomLeft();
				Point tr = bounds.getTopRight();

				surface.getWorldLocation(bl, origin3D);
				surface.getWorldLocation(tr, tmp);

				Math3D.sub(tmp, origin3D, size3D);
				return new BoundingBoxImpl(origin3D, size3D);
			} finally {
				Draw3DCache.returnVector3f(origin3D, tmp, size3D);
			}
		}
	}

	/**
	 * Returns the 2D bounds of this ChopboxAnchor's owner. Subclasses can
	 * override this method to adjust the box the anchor can be placed on. For
	 * instance, the owner figure may have a drop shadow that should not be
	 * included in the box.
	 * <p>
	 * Copied from original {@link org.eclipse.draw2d.ChopboxAnchor}.
	 * </p>
	 * 
	 * @return the 2D bounds of this ChopboxAnchor's owner
	 */
	protected Rectangle getBox() {
		return getOwner().getBounds();
	}

	/**
	 * Gets a Rectangle from {@link #getBox()} and returns the Point where a
	 * line from the center of the Rectangle to the Point <i>reference</i>
	 * intersects the Rectangle.
	 * <p>
	 * Copied from original
	 * {@link org.eclipse.draw2d.ChopboxAnchor#getLocation(Point)}.
	 * </p>
	 * 
	 * @param reference The reference point
	 * @return The anchor location
	 */
	@Override
	public Point getLocation(Point reference) {
		return doGetLocation(reference, true);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.AbstractConnectionAnchor3D#getLocation3D(IVector3f,
	 *      Vector3f)
	 */
	@Override
	public IVector3f getLocation3D(IVector3f i_reference, Vector3f io_result) {

		Vector3f result = io_result;
		if (result == null)
			result = new Vector3fImpl();

		Vector3f localReference = Draw3DCache.getVector3f();
		Vector3f rayDirection = Draw3DCache.getVector3f();
		try {
			if (getOwner() instanceof IFigure3D) {
				IFigure3D owner3D = (IFigure3D) getOwner();
				doGetReferencePoint3D(localReference);

				Math3D.sub(localReference, i_reference, rayDirection);
				Math3D.normalise(rayDirection, rayDirection);

				float distance =
					owner3D.getDistance(i_reference, rayDirection, null);

				Math3D.getLocation(i_reference, rayDirection, distance, result);
			} else { // 2D owner
				Point reference = getReferencePoint();

				ISurface surface = getSurface();
				surface.getWorldLocation(reference, result);
			}

			return result;
		} finally {
			Draw3DCache.returnVector3f(localReference, rayDirection);
		}
	}

	/**
	 * Returns the anchor's reference point. In the case of the ChopboxAnchor,
	 * this is the center of the anchor's owner. Copied from original
	 * {@link org.eclipse.draw2d.ChopboxAnchor}.
	 * 
	 * @return The reference point
	 */
	@Override
	public Point getReferencePoint() {

		Point reference = new Point(getBox().getTopLeft());
		reference.x += (int) m_xLocator.getLocation(getBox().width);
		reference.y += (int) m_yLocator.getLocation(getBox().height);

		getOwner().translateToAbsolute(reference);
		return reference;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.ConnectionAnchor3D#getReferencePoint3D(Vector3f)
	 */
	@Override
	public Vector3f getReferencePoint3D(Vector3f io_result) {

		IFigure owner = getOwner();
		if (owner == null)
			return null;

		Vector3f result = io_result;
		if (result == null)
			result = new Vector3fImpl();

		if (owner instanceof IFigure3D) {
			doGetReferencePoint3D(result);
		} else {
			Point ref2D = getReferencePoint();

			ISurface surface = getSurface();
			surface.getWorldLocation(ref2D, result);
		}

		return result;
	}

	/**
	 * Returns a surface for the owner of this anchor. If is not a 3D figure,
	 * its closest 3D ancestor will be used to get a surface. If that figure
	 * does not have a surface, one will be created and cached for it. If the
	 * owner does not have a 3D ancestor, <code>null</code> is returned.
	 * 
	 * @return a surface for the owner of this anchor or <code>null</code> if
	 *         the owner does not have a 3D ancestor
	 */
	protected ISurface getSurface() {

		IFigure figure = getOwner();
		IFigure3D figure3D = Figure3DHelper.getAncestor3D(figure);
		if (figure3D == null)
			return null;

		ISurface surface = figure3D.getSurface();
		if (surface != null)
			return surface;

		if (m_surface == null)
			m_surface = new FigureSurface(figure3D);

		return m_surface;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.AbstractConnectionAnchor#setOwner(org.eclipse.draw2d.IFigure)
	 */
	@Override
	public void setOwner(IFigure i_owner) {

		if (i_owner != getOwner())
			m_surface = null;

		super.setOwner(i_owner);
	}

}
