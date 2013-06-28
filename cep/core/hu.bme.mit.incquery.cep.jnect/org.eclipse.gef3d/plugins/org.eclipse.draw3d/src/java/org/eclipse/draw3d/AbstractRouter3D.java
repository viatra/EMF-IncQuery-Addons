/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others,
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	  IBM Corporation - initial API and implementation of 2D version
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d;

import org.eclipse.draw2d.AbstractRouter;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.util.Draw3DCache;

/**
 * 3D version of AbstractRouter.
 * 
 * @author IBM Corporation (original comments of 2D version)
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 26.11.2007
 * @see org.eclipse.draw3d.AbstractRouter
 */
public abstract class AbstractRouter3D extends AbstractRouter implements
        ConnectionRouter3D {

    /**
     * A convenience method for obtaining a connection's endpoint. The
     * connection's endpoint is a point in absolute coordinates obtained by
     * using its source and target {@link ConnectionAnchor}. The returned Point
     * is a static singleton that is reused to reduce garbage collection. The
     * caller may modify this point in any way. However, the point will be
     * reused and its values overwritten during the next call to this method.
     * 
     * @param connection
     *            The connection
     * @param io_result
     *            the result vector, if <code>null</code> a new vector will be
     *            created
     * @return The endpoint
     */
    protected IVector3f getEndPoint3D(Connection3D connection,
            Vector3f io_result) {

        ConnectionAnchor sourceAnchor = connection.getSourceAnchor();
        ConnectionAnchor targetAnchor = connection.getTargetAnchor();

        Vector3f ref = Draw3DCache.getVector3f();
        try {
            getReferencePoint3D(sourceAnchor, ref);
            return getLocation3D(targetAnchor, ref, io_result);
        } finally {
            Draw3DCache.returnVector3f(ref);
        }

    }

    /**
     * Returns the location of the given connection anchor in world coordinates.
     * The given anchor may be a 3D or 2D anchor.
     * 
     * @param i_anchor
     *            the connection anchor
     * @param i_reference
     *            the reference point in world coordinates
     * @param io_result
     *            the result vector, if <code>null</code> a new vector will be
     *            created
     * @return the anchor's location
     */
    protected IVector3f getLocation3D(ConnectionAnchor i_anchor,
            IVector3f i_reference, Vector3f io_result) {

        if (i_anchor instanceof ConnectionAnchor3D) {
            ConnectionAnchor3D anchor3D = (ConnectionAnchor3D) i_anchor;
            return anchor3D.getLocation3D(i_reference, io_result);
        } else {

            Point sLocation = Draw3DCache.getPoint();
            try {

                IFigure3D owner = Figure3DHelper.getAncestor3D(i_anchor.getOwner());
                if (owner != null) {
                    // get surface location of the reference point
                    ISurface surface = owner.getSurface();
                    surface.getSurfaceLocation2D(i_reference, sLocation);

                    // get surface location of the anchor in reference to p
                    Point p = i_anchor.getLocation(sLocation);

                    // convert back to world coordinate system
                    return surface.getWorldLocation(p, io_result);
                } else {
                    throw new IllegalStateException(
                        "Cannot calculate the location of a 2D router with no owner");
                }
            } finally {
                Draw3DCache.returnPoint(sLocation);
            }
        }
    }

    /**
     * Returns the reference point of the given anchor in world coordinates.
     * 
     * @param anchor
     *            the anchor
     * @param io_result
     *            the result vector, if <code>null</code> a new vector will be
     *            created
     * @return the reference point
     */
    protected IVector3f getReferencePoint3D(ConnectionAnchor anchor,
            Vector3f io_result) {

        if (anchor instanceof ConnectionAnchor3D) {
            ConnectionAnchor3D anchor3D = (ConnectionAnchor3D) anchor;
            return anchor3D.getReferencePoint3D(io_result);
        } else {
            IFigure3D owner = Figure3DHelper.getAncestor3D(anchor.getOwner());
            ISurface surface = owner.getSurface();

            Point p = anchor.getReferencePoint();
            return surface.getWorldLocation(p, io_result);
        }
    }

    /**
     * A convenience method for obtaining a connection's start point. The
     * connection's startpoint is a point in absolute coordinates obtained by
     * using its source and target {@link ConnectionAnchor}. The returned Point
     * is a static singleton that is reused to reduce garbage collection. The
     * caller may modify this point in any way. However, the point will be
     * reused and its values overwritten during the next call to this method.
     * 
     * @param connection
     *            The connection
     * @param io_result
     *            the result vector, if <code>null</code> a new vector will be
     *            created
     * @return The start point
     */
    protected IVector3f getStartPoint3D(Connection3D connection,
            Vector3f io_result) {

        ConnectionAnchor sourceAnchor = connection.getSourceAnchor();
        ConnectionAnchor targetAnchor = connection.getTargetAnchor();

        Vector3f ref = Draw3DCache.getVector3f();
        try {
            getReferencePoint3D(targetAnchor, ref);
            return getLocation3D(sourceAnchor, ref, io_result);
        } finally {
            Draw3DCache.returnVector3f(ref);
        }
    }

}
