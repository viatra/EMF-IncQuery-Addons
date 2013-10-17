/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d;

/**
 * General interface for objects to be rendered. A renderable object creates one
 * or more instances of {@link RenderFragment}.
 * <p>
 * <b>Important note:</b> An instance of {@link Renderable} must not add itself
 * to the given render context! This would lead to infinite recursion.
 * </p>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 23.01.2008
 */
public interface Renderable {

	/**
	 * Collects the render fragments from this renderable and adds them to the
	 * given render collection.
	 * 
	 * @param i_renderContext the render context in which to add the fragments
	 */
	public void collectRenderFragments(RenderContext i_renderContext);
}
