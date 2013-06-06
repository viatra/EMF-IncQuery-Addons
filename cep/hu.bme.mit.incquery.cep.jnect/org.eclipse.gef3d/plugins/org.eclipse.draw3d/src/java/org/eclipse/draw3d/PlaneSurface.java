/*******************************************************************************
 * Copyright (c) 2011 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d;

import java.util.EnumSet;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw3d.geometry.IHost3D;
import org.eclipse.draw3d.geometry.IPosition3D.PositionHint;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Position3D;
import org.eclipse.draw3d.geometry.Position3DImpl;

/**
 * PlaneSurface
 * There should really be more documentation here.
 *
 * @author 	Jens von Pilgrim (developer@jevopi.de)
 * @version	$Revision$
 * @since 	Apr 19, 2011
 */
public class PlaneSurface extends PositionBasedSurface implements IHost3D {
	
	Position3D planePosition;
	
	/**
	 * 
	 */
	public PlaneSurface() {
		planePosition = new Position3DImpl(this);
		coordinateSystemChanged();
	}
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.draw3d.ISurface#findFigureAt(int, int, org.eclipse.draw2d.TreeSearch)
	 */
	public IFigure findFigureAt(int i_sx, int i_sy, TreeSearch i_search) {
		return null;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.draw3d.ISurface#getHost()
	 */
	public IFigure3D getHost() {
		return null;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.draw3d.ISurface#is2DHost()
	 */
	public boolean is2DHost() {
		return false;
	}

	
	
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.draw3d.PositionBasedSurface#getPosition3D()
	 * @see IHost3D#getPosition3D()
	 */
	@Override
	public Position3D getPosition3D() {
		return planePosition;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.draw3d.geometry.IHost3D#getParentHost3D()
	 */
	public IHost3D getParentHost3D() {
		return null;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.draw3d.geometry.IHost3D#positionChanged(java.util.EnumSet, org.eclipse.draw3d.geometry.IVector3f)
	 */
	public void positionChanged(EnumSet<PositionHint> i_hint, IVector3f i_delta) {
		coordinateSystemChanged();
	}
	
	/** 
	 * {@inheritDoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("l=").append(getPosition3D().getLocation3D());
		result.append(", s=").append(getPosition3D().getSize3D());
		result.append(", r=");
		
		result.append((int) (getPosition3D().getRotation3D().getX()*180/Math.PI));
		result.append("°/");
		result.append((int) (getPosition3D().getRotation3D().getY()*180/Math.PI));
		result.append("°/");
		result.append((int) (getPosition3D().getRotation3D().getZ()*180/Math.PI));
		result.append("°");
		return result.toString();
	}

}
