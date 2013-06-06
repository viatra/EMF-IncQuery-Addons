/*******************************************************************************
 * Copyright (c) 2009-2010 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Madhu Samuel - Implementation
 ******************************************************************************/

/**
 * Font classes for rendering 2D (SWT) fonts in GL scenes. GEF3D uses OpenGL
 * to render the 2D content, too. This idea was inspired by the discussion
 * at <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=68724">GEF 
 * Bugzilla, [Bug 68724] Investigate OpenGL support for Draw2D</a>. The font
 * rendering is implemented from scratch here.
 *  
 * @author 	Madhu Samuel
 * @version $Revision$
 * @since 	24.08.2009
 */
package org.eclipse.draw3d.jogl.graphics3d.font;

