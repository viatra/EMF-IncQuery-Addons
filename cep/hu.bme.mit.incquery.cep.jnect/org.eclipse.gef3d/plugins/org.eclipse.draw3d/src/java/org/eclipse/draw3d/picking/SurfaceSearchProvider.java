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
package org.eclipse.draw3d.picking;

import org.eclipse.draw2d.TreeSearch;

/**
 * A picker uses uses this interface to get a tree search to use when searching
 * for the current surface.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 02.08.2009
 */
public interface SurfaceSearchProvider {

	/**
	 * Returns a search for the current surface.
	 * 
	 * @return the search
	 */
	public TreeSearch getSurfaceSearch();
}
