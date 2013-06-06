/*******************************************************************************
 * Copyright (c) 2008 Kristian Duske and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d;

import org.eclipse.draw2d.FreeformLayer;

/**
 * FeedbackLayer3D
 * There should really be more documentation here.
 *
 * @author 	Kristian Duske
 * @version	$Revision$
 * @since 	Apr 7, 2009
 */	
public class FeedbackLayer3D extends FreeformLayer {

	public FeedbackLayer3D() {
		setEnabled(false);
	}

//	/**
//	 * {@inheritDoc}
//	 * 
//	 * @see org.eclipse.draw2d.FreeformLayer#add(org.eclipse.draw2d.IFigure,
//	 *      java.lang.Object, int)
//	 */
//	@Override
//	public void add(IFigure i_child, Object i_constraint, int i_index) {
//
//		if (i_child instanceof Connection) {
//			Connection conn = (Connection) i_child;
//			super.add(conn); -- this line leads to a stack overflow (call loop) 
//			
//		} else {
//			super.add(i_child, i_constraint, i_index);
//		}
//	}

}