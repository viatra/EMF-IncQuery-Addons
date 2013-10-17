/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.draw2d.LayoutManager;

/**
 * A delegating layout is a layout manager that uses a delegate. To
 * differentiate from {@link DelegatingLayout}, this class is called
 * <code>DelegatingLayoutManager</code>.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 01.04.2008
 */
public interface DelegatingLayoutManager {

	/**
	 * Returns the delegate of this layout or <code>null</code> if no delegate
	 * is set.
	 * 
	 * @return the delegate
	 */
	public LayoutManager getDelegate();

	/**
	 * Sets the delegate or <code>null</code> if the delegate should be
	 * removed.
	 * 
	 * @param i_delegate the new delegate or <code>null</code>
	 */
	public void setDelegate(LayoutManager i_delegate);
}
