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

/**
 * Special edit parts used in 3D, 2D or 2.5D editors. Since most edit part
 * functions are independent from the view, a single edit part implementation
 * can usually be used for all three  editors, except different figures have to
 * be created. For that reason, GEF3D introduces an 
 * {@link org.eclipse.gef3d.factories.IFigureFactory}. The edit parts defined
 * in this package use this factory for creating their figures instead of 
 * creating the figure themselves.     
 *  
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	Jul 15, 2008
 */
package org.eclipse.gef3d.editparts;

