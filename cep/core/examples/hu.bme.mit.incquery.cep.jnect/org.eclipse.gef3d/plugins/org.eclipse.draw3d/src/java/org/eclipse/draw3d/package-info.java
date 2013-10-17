/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial implementation
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/

/**
 * 3D version of Draw2D.
 * <p>
 * A brief description can be found in:
 * <p><i>  
 * Jens von Pilgrim and Kristian Duske: GEF3D -- a Framework for Two-, 
 * Two-and-a-half-, and Three-Dimensional Graphical Editors. 
 * To appear in the ACM SIGGRAPH conference proceedings (Softvis 2008),        
 * Sept. 2008</i>
 * </p>  
 * </p>
 * 
 * <h3>Some Important Classes and Hints</h3>
 * ... which may be overlooked at first glance (and which are not necessarily
 * located in this package ;-) ).
 * <dl>
 * <dt>{@link org.eclipse.draw3d.shapes.Shape}</dt>
 * 	<dd>Super interface for shapes, that are 3D objects to be rendered. See
 * 	shapes package description for details. Figure3D usually use shapes to
 * 	render themselves.</dd>
 * <dt>{@link org.eclipse.draw3d.ConnectionAnchor3D}</dt><dd>Most of these helper classes
 * (the connection anchor is just an example) are not only 3D version of the 
 * known GEF 2D versions, but can be used in 2D environments, too. (Most
 * if these classes are derived from the 2D versions). This way, basis figure
 * classes or methods may be used in 2D and 3D envrionments.</dd>
 * <dt>{@link org.eclipse.draw3d.Figure3DHelper}, {@link org.eclipse.draw3d.Figure3DFriend}</dt><dd>These classes
 * implement the delegator pattern. Some core functionality of {@link org.eclipse.draw3d.Figure3D}
 * is implemented by {@link org.eclipse.draw3d.Figure3DHelper}. This may be usefull if, for some
 * reasons, client specific figures cannot be derived from {@link org.eclipse.draw3d.Figure3D} but
 * have to implement {@link org.eclipse.draw3d.IFigure3D}.</dd>
 * <dt>{@link org.eclipse.draw3d.SurfaceLayout}</dt><dd>This is a special layout manager 
 * positioning children of a 3D figure on its surface.</dd>
 * </dl>
 * 
 * 
 * 
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	Jul 15, 2008
 */
package org.eclipse.draw3d;

