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

import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.GraphicalEditPart;

/**
 * Figure factory creating figures based on the type of edit parts.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Apr 22, 2008
 */
public class MappedFigureFactory implements IFigureFactory {

	protected Map<Class<? extends GraphicalEditPart>, Class<? extends IFigure>> editPart2FigureClass;

	protected DisplayMode mode;

	/**
	 * @param mode
	 */
	public MappedFigureFactory(DisplayMode mode) {

		this.mode = mode;

	}

	/**
	 * @param map must not be null
	 */
	public void setMap(Map<Class<? extends GraphicalEditPart>, Class<? extends IFigure>> map) {
		if (map == null) // parameter precondition
			throw new NullPointerException("map must not be null");

		editPart2FigureClass = map;
	}

	/**
	 * Creates a figure based on the given controller. The hint is ignored.
	 * 
	 * @see org.eclipse.gef3d.factories.IFigureFactory#createFigure(org.eclipse.gef.GraphicalEditPart,
	 *      java.lang.Object)
	 */
	public IFigure createFigure(GraphicalEditPart i_controller, Object i_hint) {
		if (editPart2FigureClass == null) {
			throw new IllegalStateException(
					"map, mapping edit part classes to figure classes, was not set.");
		}

		Class<? extends IFigure> _class = editPart2FigureClass
				.get(i_controller.getClass());
		if (_class == null) {
			throw new IllegalStateException("No class set for type "
					+ i_controller.getClass());
		}
		IFigure fig;
		try {
			fig = _class.newInstance();
		} catch (InstantiationException ex) {
			throw new IllegalStateException(ex);
		} catch (IllegalAccessException ex) {
			throw new IllegalStateException(ex);
		}

		return fig;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.factories.IDisplayModeSensitive#getMode()
	 */
	public DisplayMode getMode() {
		return mode;
	}

}
