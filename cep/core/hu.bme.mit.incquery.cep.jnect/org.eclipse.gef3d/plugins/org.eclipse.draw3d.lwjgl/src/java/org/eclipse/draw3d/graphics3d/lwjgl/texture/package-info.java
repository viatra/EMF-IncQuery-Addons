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
 *    Matthias Thiele - initial API and implementation
 ******************************************************************************/

/**
 * <p>
 * We use arbitrary texture sizes for performance reasons, 
 * this only works on machines with OpenGL version 2 or later.
 * Some video cards can do it with D3D and some OpenGL 2.0 cards can´t.
 * In the first group are nVidia serie 6 and up and in second are 
 * ATI Radeon series 200 and 300.
 * (since rev. 361, 
 * also see mailing list: Alessandro Borges: NPOT - textures, April 7. 2008)
 * </p>  
 *  
 * @author 	Kristian Duske
 * @version $Revision$
 * @since 	April 7, 2008
 */
package org.eclipse.draw3d.graphics3d.lwjgl.texture;

