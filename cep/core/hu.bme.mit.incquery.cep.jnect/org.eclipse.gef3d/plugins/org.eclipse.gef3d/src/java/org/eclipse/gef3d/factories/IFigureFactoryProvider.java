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

import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;

/**
 * Classes implementing this interface contain a {@link IFigureFactory}, which
 * can be used by clients, usually {@link GraphicalEditPart}s, for creating
 * their figures.
 * <p>
 * E.g, this interface can be implemented by an {@link EditPartViewer}, which
 * also provides the {@link EditPartFactory}. This is also the reason why this
 * and related classes are defined in package <code>org.eclipse.gef3d</code>.
 * </p>
 * The 3D viewers all implement this interface. If no factory is used, 
 * {@link #getFigureFactory()} returns null.
 *
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	Apr 22, 2008
 */
public interface IFigureFactoryProvider {
	
	/**
	 * Mutable version of the {@link IFigureFactoryProvider} interface, 
	 * usefull if figure factory has to be set. Usually, editors implement
	 * this interface, but clients only rely on the immutable version.
	 *
	 * @author 	Jens von Pilgrim
	 * @version	$Revision$
	 * @since 	Aug 20, 2009
	 */
	public interface Mutable extends IFigureFactoryProvider {
		void setFigureFactory(IFigureFactory i_FigureFactory);
	}
	
	IFigureFactory getFigureFactory();
	
}
