/*******************************************************************************
 * Copyright (c) 2009-2010 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 *    Madhu Samuel	   - JOGL Implementation 
 ******************************************************************************/
package org.eclipse.draw3d.jogl.graphics3d.texture;

import javax.media.opengl.GL;


/**
 * AbstractLwjglTexture
 * There should really be more documentation here.
 *
 * @author 	Madhu Samuel
 * @version	$Revision$
 * @since 	27.08.2009
 */
public abstract class AbstractJoglTexture implements JoglTexture {


	protected boolean m_disposed = false;
	protected boolean m_valid = false;
	protected GL m_gl;

}
