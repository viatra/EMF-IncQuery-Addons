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
package org.eclipse.gef3d.ext.intermodel;

import org.eclipse.draw3d.IFigure3D;

/**
 * Inter model aware stack layout.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Sep 29, 2009
 */
public class StackLayout3D extends org.eclipse.draw3d.StackLayout3D {

	/**
	 * Returns true only if the child is an instance of {@link IFigure3D} but
	 * is not an instance of {@link InterModelDiagramFigure}. This way, 
	 * inter models do not cause "gaps" in the stack.
	 * 
	 * @see org.eclipse.draw3d.StackLayout3D#isChildStacked(java.lang.Object)
	 */
	@Override
	protected boolean isChildStacked(Object i_child) {
		return (i_child instanceof IFigure3D)
			&& !(i_child instanceof InterModelDiagramFigure);
	}

}
