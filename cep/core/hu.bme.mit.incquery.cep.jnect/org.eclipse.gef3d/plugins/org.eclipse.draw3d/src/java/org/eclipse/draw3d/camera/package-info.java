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
 * Camera related interfaces and classes. A camera is used in 3D scenes to 
 * project the 3D content on a 2D plane -- the screen. Several types of cameras
 * are used in 3D. Here, a first person shooter like camera is provided. From a 
 * GEF perspective, the camera "replaces" zoom and scroll capabilites.
 * <p/>
 * When moving the camera around, the whole scene has to be rendered again. 
 * Yet 2D content is usually not be redrawn, since it is stored as textures
 * which can be reused. However, if necessary, also 2D content can be redrawn.
 * When moving the camera, the render methods of each figure are called.
 * </p>
 * Some features of the implemented cameras are described in 
 * <p><i>  
 * Jens von Pilgrim and Kristian Duske: GEF3D -- a Framework for Two-, 
 * Two-and-a-half-, and Three-Dimensional Graphical Editors. 
 * To appear in the ACM SIGGRAPH conference proceedings (Softvis 2008),        
 * Sept. 2008</i>
 * </p>   
 *  
 *  
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	Jul 15, 2008
 */
package org.eclipse.draw3d.camera;

