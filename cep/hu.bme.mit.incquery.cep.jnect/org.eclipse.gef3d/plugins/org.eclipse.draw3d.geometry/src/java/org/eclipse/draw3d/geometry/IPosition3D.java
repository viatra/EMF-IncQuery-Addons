/*******************************************************************************
 * Copyright (c) 2009 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.geometry;

/**
 * Stores location, size, and rotation of an 3D object. Immutable triple of
 * position properties for 3D objects, that is location, size (scale), and
 * rotation. These three properties can be combined in a so called
 * transformation matrix, which can then be passed to OpenGL or renderer able to
 * handle these kind of information.
 * <p>
 * This interface and its subinterfaces and implementations were created in
 * order to resolve the problem stated in bug 261775.
 * </p>
 * <p>
 * Every Position is expected to have a host, i.e. @link{#getHost()} must not
 * return null. If you do not have a host (e.g. you only need a temporary
 * position of the position is absolute), you can use
 * {@link Position3DImpl#Position3DImpl()} in order to create a position with a
 * dummy host.
 * </p>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Jan 21, 2009
 * @href https://bugs.eclipse.org/bugs/show_bug.cgi?id=261775
 */
public interface IPosition3D {

	/**
	 * Hint passed in events indicating which component (location, rotatoin,
	 * size) of the position had been changed.
	 * 
	 * @author Jens von Pilgrim
	 * @version $Revision$
	 * @since Jan 21, 2009
	 * @see Host3D#positionChanged
	 */
	public static enum PositionHint {
		/**
		 * Location has changed.
		 */
		LOCATION,
		/**
		 * Rotation has changed.
		 */
		ROTATION,
		/**
		 * Size has changed.
		 */
		SIZE;
	}

	/**
	 * Returns an absolute position that has the same absolute location, size
	 * and rotation as this position. If this position is already absolute, this
	 * function will return this.
	 * <p>
	 * <b>If the given result position has a parent position, the result of this
	 * is undefined.</b>
	 * </p>
	 * 
	 * @param o_result the result position, if <code>null</code>, a new absolute
	 *            position will be returned
	 * @return an absolute position
	 */
	public Position3D getAbsolute(Position3D o_result);

	/**
	 * Returns the absolute rotation matrix of this position.
	 * <p>
	 * M<sub>rot</sub> = M<sub>0</sub> * M<sub>1</sub> * ... * M<sub>n</sub>
	 * </p>
	 * in which M<sub>0</sub> is the rotation matrix of the root position and
	 * M<sub>n</sub> is the rotation matrix of this position.
	 * 
	 * @return the absolute rotation matrix of this position
	 */
	public IMatrix4f getAbsoluteRotationMatrix();

	/**
	 * Returns the smallest box completely enclosing the IFigure. This method is
	 * the 3D equivalent of {@link IFigure#getBounds()}. While GEF's version
	 * returns a mutable class (Rectangle) and forbids to change the returned
	 * object, here an immutable class (interface) is returned avoiding these
	 * problems.
	 * <p>
	 * Returns bounds, i.e. lower left back corner and size. The coordinates are
	 * relative coordinates, that is rotation is not recognized here.
	 * </p>
	 * <p>
	 * Note that the returned object is immutable, use setters for location,
	 * size, and rotation in {@link Position3D}.
	 * </p>
	 * 
	 * @return the bounding box
	 * @see org.eclipse.draw3d.IFigure3D#getBounds3D()
	 */
	public IBoundingBox getBounds3D();

	/**
	 * Returns the center of this position.
	 * 
	 * @return the center of this position
	 */
	public IVector3f getCenter3D();

	/**
	 * Returns the host (or context) of this position.
	 * <code>{@link #getHost()}.{@link IHost3D#getPosition3D()}==this</code>
	 * must always be true.
	 * 
	 * @return returns the host, must not be null
	 * @see IHost3D#getPosition3D()
	 */
	public IHost3D getHost();

	/**
	 * Returns the lower left corner of the bounding box.
	 * 
	 * @return the location
	 */
	public IVector3f getLocation3D();

	/**
	 * Returns a position that is relative to this position and that has the
	 * same absolute location, size and rotation as the given position.
	 * <p>
	 * <b>If the given position does not have this as its parent position, the
	 * result is undefined.</b>
	 * </p>
	 * 
	 * @param i_position3D the position to make relative to this
	 * @param o_result the result position, if <code>null</code>, a new position
	 *            will be returned
	 * @return a relative position
	 */
	public Position3D getRelative(IPosition3D i_position3D, Position3D o_result);

	/**
	 * Returns the rotation angles of the figure.
	 * 
	 * @return the rotation angles
	 */
	public IVector3f getRotation3D();

	/**
	 * Returns the matrix that performs the transformation of this figure's
	 * rotation and location, but does not include the scaling transformation.
	 * 
	 * @return the rotation / location matrix
	 */
	public IMatrix4f getRotationLocationMatrix();

	/**
	 * Returns the 3D dimensions.
	 * 
	 * @return the dimensions
	 */
	public IVector3f getSize3D();

	/**
	 * Returns the matrix that performs the transformation of this figure's
	 * basic shape to it's intended shape.
	 * 
	 * @return the model matrix
	 */
	public IMatrix4f getTransformationMatrix();

	/**
	 * Indicates whether the internal cached information of this position and of
	 * all its ancestors is valid.
	 * 
	 * @return <code>true</code> if the internal cached information of this
	 *         position and of all its ancestors is valid and <code>false</code>
	 *         otherwise
	 */
	public boolean isValid();

	/**
	 * Transforms the given picking ray by applying the inverse of the
	 * transformation matrix to the given origin and the inverse of only the
	 * rotation and scaling matrices to the given direction vector. After the
	 * transformation, the direction vector may not be normalised and must be
	 * corrected.
	 * <p>
	 * This method is used to transform a picking ray to model coordinates.
	 * </p>
	 * Be aware that it is not always possible to transform a ray. If the
	 * transformation matrix of this position is not invertible, the ray cannot
	 * be transformed in a meaningful way. This can happen if any component of
	 * the size of this position is <code>0</code>. In that case, this method
	 * returns <code>false</code>.
	 * 
	 * @param i_origin the origin of the ray to transform
	 * @param i_direction the direction of the ray to transform
	 * @return <code>true</code> if the ray could be transformed and
	 *         <code>false</code> otherwise
	 */
	public boolean transformRay(Vector3f i_origin, Vector3f i_direction);
}
