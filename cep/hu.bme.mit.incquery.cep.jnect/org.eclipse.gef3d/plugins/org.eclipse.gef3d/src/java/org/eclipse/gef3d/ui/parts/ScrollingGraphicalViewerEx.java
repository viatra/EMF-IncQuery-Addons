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
package org.eclipse.gef3d.ui.parts;

import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.gef3d.factories.IFigureFactory;
import org.eclipse.gef3d.factories.IFigureFactoryProvider;


/**
 * Two-dimensional viewer implementing {@link IFigureFactoryProvider}. See
 * {@link IFigureFactory}.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Apr 22, 2008
 */
public class ScrollingGraphicalViewerEx extends ScrollingGraphicalViewer
		implements IFigureFactoryProvider.Mutable {
	
	protected IFigureFactory m_FigureFactory = null;
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.gef3d.factories.IFigureFactoryProvider#getFigureFactory()
	 */
	public IFigureFactory getFigureFactory() {
		return m_FigureFactory;
	}
	
	/**
	 * Sets the figure factory of this viewer.
	 * @param i_factory
	 */
	public void setFigureFactory(IFigureFactory i_factory) {
		m_FigureFactory = i_factory;
	}


}
