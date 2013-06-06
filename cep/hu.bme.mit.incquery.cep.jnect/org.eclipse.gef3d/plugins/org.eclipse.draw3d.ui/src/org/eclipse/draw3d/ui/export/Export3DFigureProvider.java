/*******************************************************************************
 * Copyright (c) 2009 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.ui.export;

import org.eclipse.draw3d.IFigure3D;

/**
 * Provides the root 3D figure for an export action.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 09.06.2009
 */
public interface Export3DFigureProvider {

	/**
	 * Returns the export root figure. The figure tree below this figure
	 * (including the root) will be exported.
	 * 
	 * @return the root figure
	 */
	public IFigure3D getFigure();
}
