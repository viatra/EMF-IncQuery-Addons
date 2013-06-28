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
package org.eclipse.gef3d.examples.graph.editor;

import org.eclipse.gef3d.factories.DisplayMode;

/**
 * GraphEditor2_5D There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 20.12.2007
 */
public class GraphEditor2_5D extends GraphEditor3D {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.examples.graph.editor.GraphEditor3D#initMode()
	 */
	@Override
	protected void initMode() {
		mode = DisplayMode.Projected;
	}

}
