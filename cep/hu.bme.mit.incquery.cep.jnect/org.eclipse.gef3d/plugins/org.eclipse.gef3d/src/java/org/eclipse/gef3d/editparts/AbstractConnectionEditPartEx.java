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
package org.eclipse.gef3d.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef3d.factories.IFigureFactory;
import org.eclipse.gef3d.factories.IFigureFactoryProvider;


/**
 * Extensible graphical edit part, i.e. this edit part uses a
 * {@link IFigureFactory}.
 *
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	Apr 22, 2008
 */
public abstract class AbstractConnectionEditPartEx extends AbstractConnectionEditPart3D {

	/**
	 * Creates a figure for this edit part using a figure factory. The figure
	 * factory is retrieved from the graphical viewer, which must implement
	 * {@link IFigureFactoryProvider}.
	 * 
	 * @throws IllegalStateException if viewer is not an instance of
	 *             {@link IFigureFactoryProvider}
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {
		if (getViewer() instanceof IFigureFactoryProvider) {
			return ((IFigureFactoryProvider) getViewer()).getFigureFactory()
					.createFigure(this, null);
		}

		throw new IllegalStateException(
				"No figure factory available (viewer is no IFigureFactoryProvider)");
	}

}
