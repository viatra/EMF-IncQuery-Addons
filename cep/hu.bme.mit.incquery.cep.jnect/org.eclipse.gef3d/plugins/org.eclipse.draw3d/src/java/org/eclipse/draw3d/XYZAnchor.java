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
package org.eclipse.draw3d;

import org.eclipse.draw2d.AnchorListener;
import org.eclipse.draw2d.XYAnchor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;

/**
 * XYZAnchor There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since May 31, 2009
 */
public class XYZAnchor extends XYAnchor implements ConnectionAnchor3D {

	public static class Immutable extends XYZAnchor {

		/**
		 * @param i_location
		 */
		public Immutable(Vector3fImpl i_location) {
			super(i_location);
		}
		
		/** 
		 * As this class is immutable, this method throws an
		 * {@link UnsupportedOperationException}.
		 * 
		 * @see org.eclipse.draw3d.XYZAnchor#setLocation(org.eclipse.draw2d.geometry.Point)
		 */
		@Override
		public void setLocation(Point i_p) {
			throw new UnsupportedOperationException("Anchor is immutable");
		}

		/** 
		 * As this class is immutable, this method throws an
		 * {@link UnsupportedOperationException}.
		 * @see org.eclipse.draw3d.XYZAnchor#setLocation3D(org.eclipse.draw3d.geometry.IVector3f)
		 */
		@Override
		public void setLocation3D(IVector3f i_location) {
			throw new UnsupportedOperationException("Anchor is immutable");
		}

		/** 
		 * As this class is immutable, no events will ever been thrown.
		 * Thus, this method does nothing.
		 * @see org.eclipse.draw2d.ConnectionAnchorBase#addAnchorListener(org.eclipse.draw2d.AnchorListener)
		 */
		@Override
		public void addAnchorListener(AnchorListener i_listener) {
		}
	}
	
		
	
	
    Vector3fImpl m_location3D = new Vector3fImpl();

    /**
     * Creates a new anchor at the given location.
     * 
     * @param i_location
     *            the location of this anchor
     */
    public XYZAnchor(Vector3fImpl i_location) {

        super(new Point((int)i_location.getX(),(int) i_location.getY()));
        // do not use setter here in order to enable immutable versions
        m_location3D.set(i_location);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.draw3d.ConnectionAnchor3D#getLocation3D(org.eclipse.draw3d.geometry.IVector3f,
     *      org.eclipse.draw3d.geometry.Vector3f)
     */
    public IVector3f getLocation3D(IVector3f i_reference, Vector3f io_result) {

		Vector3f result = io_result;
		if (result == null)
			result = new Vector3fImpl();

		result.set(m_location3D);
		return result;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.draw3d.ConnectionAnchor3D#getReferencePoint3D(org.eclipse.draw3d.geometry.Vector3f)
     */
    public IVector3f getReferencePoint3D(Vector3f io_result) {

        return getLocation3D(null, io_result);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.draw2d.XYAnchor#setLocation(org.eclipse.draw2d.geometry.Point)
     */
    @Override
    public void setLocation(Point i_p) {

        m_location3D.set(i_p.x, i_p.y, 10);
        super.setLocation(i_p);
    }

    /**
     * Sets the absolute 3D world location of this anchor to the given value.
     * 
     * @param i_location
     *            the absolute 3D world location to set
     */
    public void setLocation3D(IVector3f i_location) {

        m_location3D.set(i_location);
        fireAnchorMoved();
    }

}
