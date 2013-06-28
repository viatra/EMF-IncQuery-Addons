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
package org.eclipse.gef3d.factories;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.gef3d.ui.parts.GraphicalViewer3D;
import org.eclipse.gef3d.ui.parts.GraphicalViewer3DImpl;

/**
 * Interface of figure factories for creating figures. In the original GEF,
 * figures are created by the {@link EditPart}s themselves (in method
 * {@link AbstractGraphicalEditPart#createFigure()}. GEF3D provides different
 * display modes (2D, 2.5D, and 3D), hence sometimes different figures are to be
 * used.
 * <p>
 * Note that the viewer is required to be an {@link IFigureFactoryProvider},
 * which is usually the case if a {@link GraphicalViewer3D} is used, as the edit
 * part must be able to retrieve the factory from the viewer. Of course, the
 * factory needs to be registered at the viewer. Since the viewer is available
 * to the edit part, let your viewer implement {@link IFigureFactoryProvider}.
 * GEF3D's default 3D viewer implementations implement this interface. The
 * figure factory is best registered where the {@link EditPartFactory} is
 * registered, i.e. in {@link GraphicalEditor#configureGraphicalViewer}. The
 * {@link GraphicalViewer3DImpl} provides a special method
 * {@link GraphicalViewer3DImpl#setFigureFactory(IFigureFactory)}. The following
 * code snippet can serve as a template to be used in your
 * {@link GraphicalEditor#configureGraphicalViewer()} implementation:
 * 
 * <pre>
 * ((IFigureFactoryProvider.Mutable) getGraphicalViewer())
 * 	.setFigureFactory(new MY_FIGURE_FACTORY(DisplayMode.Projected));
 * </pre>
 * 
 * (replace MY_FIGURE_FACTORY with your figure factory implementation).
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Apr 22, 2008
 * @see IFigureFactoryProvider
 */
public interface IFigureFactory extends IDisplayModeSensitive {

	/**
	 * Creates a figure for the given controller. Since the controller has to
	 * set the figures properties, the returned figure is usually an
	 * implementation of an interface which the given controller can handle.
	 * 
	 * @param i_controller the edit part calling this method. Note that the
	 *            controller is not modified, i.e. the controller has to store
	 *            the returned figure itself.
	 * @param i_hint hint for the creation, e.g., a string describing the type
	 *            (may be null)
	 * @return
	 */
	IFigure createFigure(GraphicalEditPart i_controller, Object i_hint);

}
