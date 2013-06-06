/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 *    Jens von Pilgrim - initial API
 ******************************************************************************/
package org.eclipse.draw3d.shapes;

import org.eclipse.draw3d.RenderFragment;
import org.eclipse.draw3d.picking.Pickable;

/**
 * A shape is a geometric object. Shapes can render themselves and determine the
 * point of intersection with a ray.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 27.02.2008
 */
public interface Shape extends Pickable, RenderFragment {

	// empty interface
}
