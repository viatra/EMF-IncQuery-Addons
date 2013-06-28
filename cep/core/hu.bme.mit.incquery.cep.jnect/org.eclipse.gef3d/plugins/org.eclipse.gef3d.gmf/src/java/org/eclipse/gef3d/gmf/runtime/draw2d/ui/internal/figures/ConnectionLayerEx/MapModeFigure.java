/*******************************************************************************
 * Copyright (c) 2010 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.gmf.runtime.draw2d.ui.internal.figures.ConnectionLayerEx;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Translatable;
import org.eclipse.gmf.runtime.draw2d.ui.internal.mapmode.IdentityMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;

/**
 * MapModeFigure is a figure implementing {@link IMapMode}. All {@link IMapMode}
 * functions are delegated to a map mode member, which is an
 * {@link IdentityMapMode} by default. This figure is used by
 * {@link DispatchingConnectionLayerEx} to temporarily set a parent to
 * connections (while pending and waited to be attached to their real layer).
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Jun 6, 2010
 */
public class MapModeFigure extends Figure implements IFigure, IMapMode {

	IMapMode mapMode = new IdentityMapMode();
	
	

	/**
	 * @return the mapMode
	 */
	public IMapMode getMapMode() {
		return mapMode;
	}

	/**
	 * @param i_mapMode the mapMode to set
	 */
	public void setMapMode(IMapMode i_mapMode) {
		mapMode = i_mapMode;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode#DPtoLP(int)
	 */
	public int DPtoLP(int i_deviceUnit) {
		return mapMode.DPtoLP(i_deviceUnit);
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode#DPtoLP(org.eclipse.draw2d.geometry.Translatable)
	 */
	public Translatable DPtoLP(Translatable i_t) {
		return mapMode.DPtoLP(i_t);
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode#LPtoDP(int)
	 */
	public int LPtoDP(int i_logicalUnit) {
		return mapMode.LPtoDP(i_logicalUnit);
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode#LPtoDP(org.eclipse.draw2d.geometry.Translatable)
	 */
	public Translatable LPtoDP(Translatable i_t) {
		return mapMode.LPtoDP(i_t);
	}
	
	
	
	
}
