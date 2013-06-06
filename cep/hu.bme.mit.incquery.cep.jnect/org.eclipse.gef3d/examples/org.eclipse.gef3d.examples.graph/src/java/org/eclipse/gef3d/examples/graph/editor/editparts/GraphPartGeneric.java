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
package org.eclipse.gef3d.examples.graph.editor.editparts;

import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gef3d.editpolicies.ShowLayoutFeedbackEditPolicy3D;
import org.eclipse.gef3d.examples.graph.editor.editpolicies.Graph3DLayoutPolicy;
import org.eclipse.gef3d.factories.IFigureFactory;
import org.eclipse.gef3d.tools.DragEditPartsTracker3D;

/**
 * GraphPartGeneric for managing graphs. Graphs are the root elements, i.e. the
 * diagram plane. This part can be using in 2D, 2.5D, and 3D mode, since it uses
 * a {@link IFigureFactory} to create the figure. This is a little bit different
 * from normal GEF based editors, which usually create the figure themselves.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 21.11.2007
 */
public class GraphPartGeneric extends AbstractGraphPart {
	/**
	 * {@inheritDoc}
	 * 
	 * @see AbstractEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new Graph3DLayoutPolicy());

	}

	/**
	 * Returns a 3D enabled drag tracker instead of the original 2D version.
	 * 
	 * @see org.eclipse.gef.EditPart#getDragTracker(Request)
	 * @see DragEditPartsTracker3D
	 */
	@Override
	public DragTracker getDragTracker(Request request) {
		return new DragEditPartsTracker3D(this);
	}

}
