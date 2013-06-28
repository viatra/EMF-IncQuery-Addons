/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/

/**
 * This package provide basic (3D) shapes. The can be used by figures to render
 * themselves. In order to be rendered, a shape needs a location. There are two
 * strategies for providing a location to a shape: by attaching a shape to a 
 * figure and then use the figure's location or by directly setting a position.
 * In the first case, the shape should extend the abstract super class 
 * {@link FigureShape}, which does not only provide the figure's position, but
 *  which can use to retrieve other information such as color from the figure.
 * In the second case, the shape should extend the abstract super class
 * {@link PositionableShape}. Note that often a figure shape nests an 
 * positionable shape and copies some attributes from figure to the shape, 
 * e.g., position or color. 
 * <p>
 * GEF3D uses real picking of objects in a 3D scene. For that reason, every 
 * figure or shape has to implement interface {@link org.eclipse.draw3d.picking.Pickable}. See this interface for more information.
 * <small>In an earlier version, GEF3D used color picking, but this technique was
 * replaced due to conceptional problems with GEF.</small>
 * </p>
 * <p><em>Note: The concept of shape may be changed in future version. As it is
 * not possible to not use shapes, you may have to change your code in that case.
 * We apologize for any inconvenience, and we will inform you via the GEF3D 
 * newsgroup in case of an API change.</em></p>
 * @see FigureShape
 * @see PositionableShape 
 *  
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	Jul 15, 2008
 */
package org.eclipse.draw3d.shapes;

