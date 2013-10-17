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
package org.eclipse.gef3d.examples.uml2.activity.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw3d.Figure3D;
import org.eclipse.draw3d.geometry.Vector3fImpl;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.gef.tools.DeselectAllTracker;
import org.eclipse.gef3d.examples.uml2.figures.DiagramFigure3D;
import org.eclipse.gmf.runtime.diagram.ui.internal.tools.RubberbandDragTracker;
import org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.diagram.activity.edit.parts.PackageEditPart;

/**
 * PackageEditPart3D There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Apr 7, 2009
 */
public class PackageEditPart3D extends PackageEditPart {

	/**
	 * @param i_view
	 */
	public PackageEditPart3D(View i_view) {
		super(i_view);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {
		Figure3D f = new DiagramFigure3D();
		// Figure3D f = new ClassDiagramFigure3DEmbedded();

		f.getPosition3D().setLocation3D(new Vector3fImpl(0, 0, 0));
		f.getPosition3D().setSize3D(new Vector3fImpl(1400, 1400, 60));

		f.setBackgroundColor(new Color(Display.getCurrent(), 255, 255, 255));
		f.setAlpha((byte) (255 / 2));

		return f;
	}
	
	/**
	 * Replaces the {@link RubberbandDragTracker} with an old school
	 * {@link DragEditPartsTrackerEx}, since the former performs a cast which
	 * fails.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart#getDragTracker(org.eclipse.gef.Request)
	 */
	@Override
	public DragTracker getDragTracker(Request req) {
		if (req instanceof SelectionRequest
			&& ((SelectionRequest) req).getLastButtonPressed() == 3)
			return new DeselectAllTracker(this);
		return new DragEditPartsTrackerEx(this);
	}

}
