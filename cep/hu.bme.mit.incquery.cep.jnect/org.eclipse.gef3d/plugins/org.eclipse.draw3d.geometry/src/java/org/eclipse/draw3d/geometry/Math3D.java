/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.geometry;

/**
 * Math3D provides common 3D math operations. Instead of spreading all these
 * operations all over the 3D geometry classes holding the data, they are
 * bundled here. This makes it easier to create subclasses of the existing
 * geometry classes or provide adapter interfaces, since only the data has to be
 * provided but not the logic.
 * 
 * @todo investigate faster intersection detection for triangles
 *       ("http://www.devmaster.net/wiki/Ray-triangle_intersection")
 * @author Jens von Pilgrim, Kristian Duske
 * @version $Revision$
 * @since 19.10.2008
 */
public class Math3D extends Math3DMatrixOps {

	// empty class
}
