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
 * @version $Revision$
 * @since 31.10.2007
 * @see org.eclipse.draw2d.ChopboxAnchor
 */
public class ChopboxAnchor3D extends AbstractConnectionAnchor3D {

	@SuppressWarnings("unused")
	private static final Logger log =
		Logger.getLogger(ChopboxAnchor3D.class.getName());

	/**
	 * Constructs a new ChopboxAnchor.
	 */
	protected ChopboxAnchor3D() {
		// nothing to initialize
	}

	/**
	 * Constructs a ChopboxAnchor with the given <i>owner</i> figure.
	 * 
	 * @param owner the owner figure
	 * @since 2.0
	 */
	public ChopboxAnchor3D(IFigure owner) {
		super(owner);
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

		Point surfaceRef = Draw3DCache.getPoint();
		Vector3f center = Draw3DCache.getVector3f();
		Vector3f tmp = Draw3DCache.getVector3f();
		try {
			// maybe the owner is a 2D figure!
			if (getOwner() instanceof IFigure3D) {
				IFigure3D owner3D = (IFigure3D) getOwner();

				// bounding box in relative coordinates
				IBoundingBox boundingBox = getBounds3D();
				Vector3f size = boundingBox.getSize(null);
				boundingBox.getCenter(center);

				// bounding box is a dot
				if (size.lengthSquared() == 0 || i_reference == null) {
					result.set(center);
					return result;
				}

				// We can avoid doing intersections by simply scaling the vector
				// relativeRef - center3D appropriately. The correct scaling
				// factor
				// depends on which face of the bounding box the vector
				// intersects
				// with
				// and can be determined by comparing the sizes of the factors
				// lambdai =
				// 2*delta.i / size.i where i in {x, y, z}. The smallest of
				// those
				// factors is the correct scaling factor. There are no special
				// cases
				// like intersecting with edges or corners with this method.
				tmp.set(i_reference);
				owner3D.transformToRelative(tmp);
				Math3D.sub(tmp, center, tmp);
				float lambdaX = Math.abs(size.getX() / (2 * tmp.getX()));
				float lambdaY = Math.abs(size.getY() / (2 * tmp.getY()));
				float lambdaZ = Math.abs(size.getZ() / (2 * tmp.getZ()));

				float lambda = Math.min(lambdaX, lambdaY);
				lambda = Math.min(lambda, lambdaZ);

				tmp.scale(lambda);
				Math3D.add(center, tmp, tmp);

				// delta is relative to the owner of this anchor, so make it
				// absolute
				owner3D.transformToAbsolute(tmp);

				result.set(tmp);
				return result;
			} else { // 2D owner
				IFigure3D host = Figure3DHelper.getAncestor3D(getOwner());
				if (host == null)
					throw new IllegalStateException("no 3D host found");

				ISurface surface = host.getSurface();

				Rectangle bounds = getOwner().getBounds();
				Point sCenter = bounds.getCenter();

				surface.getWorldLocation(sCenter, center);

				result.set(center);
				return result;
			}
		} finally {
			Draw3DCache.returnPoint(surfaceRef);
			Draw3DCache.returnVector3f(center, tmp);
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
		Point ref = getBox().getCenter();
		getOwner().translateToAbsolute(ref);
		return ref;
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

		Vector3f ref3D = Draw3DCache.getVector3f();
		try {
			if (owner instanceof IFigure3D) {
				getBounds3D().getCenter(ref3D);

				IFigure3D owner3D = (IFigure3D) owner;
				owner3D.transformToAbsolute(ref3D);

				result.set(ref3D);
				return result;
			} else {
				Point ref2D = getReferencePoint();
				IFigure3D host = Figure3DHelper.getAncestor3D(owner);

				ISurface surface = host.getSurface();
				return surface.getWorldLocation(ref2D, result);
			}
		} finally {
			Draw3DCache.returnVector3f(ref3D);
		}
	}

}
