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
package org.eclipse.gef3d.ui.parts;

import org.eclipse.draw3d.LightweightSystem3D;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * During initialization, the methods of this interface are used to
 * prepare a 3D editor, especially for creating a special connection layer.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Apr 15, 2009
 */
public interface GraphicalViewer3D extends GraphicalViewer {
	/**
	 * Returns the 3D light weight system
	 * 
	 * @return
	 */
	public LightweightSystem3D getLightweightSystem3D();

	/**
	 * Replaces {@link GraphicalViewer#createControl(Composite)}. The 2D
	 * implementation is sometimes declared final (e.g. in
	 * {@link ScrollingGraphicalViewer}), thus we have to use a parallel
	 * mechanism. Note that this method must be called by editor instead of 
	 * the original 2D version!
	 * 
	 * @param i_parent
	 * @return
	 */
	public Control createControl3D(Composite i_parent);
}
