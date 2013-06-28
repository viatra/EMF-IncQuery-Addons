/*******************************************************************************
 * Copyright (c) 2009-2010 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Madhu Samuel	 - Implementation
 ******************************************************************************/
package org.eclipse.draw3d.jogl.graphics3d.texture;

import javax.media.opengl.GL;

import org.eclipse.draw3d.jogl.graphics3d.util.TextureUtil;

/**
 * Texture Util
 * 
 * @author Madhu Samuel
 * @version $Revision$
 * @since 27.08.2009
 */
public class TextureValidator {
	
	/**
	 * Cached flag indicating whether Fbo is supported (1) or not (0). If the
	 * flag is -1, we have to resolve its value in {@link #isSuppported()}.
	 */
	private static int iFboIsSupported = -1;
	
	/**
	 * The GL Instance
	 */
	private GL m_gl;
	
	public TextureValidator(GL i_gl) {
		this.m_gl = i_gl;
	}
	
	public boolean isSupported(TextureType type) {
		boolean isSupported = false;
		if(type==TextureType.FBO) {
			isSupported = isFrameBufferSupported();
		} else if(type==TextureType.PBuffer) {
			isSupported = isPBufferSupported();
		}
		
		return isSupported;
	}

	private boolean isPBufferSupported() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Indicates whether FBOs are supported on this system.
	 * 
	 * @return <code>true</code> if FBOs are supported or <code>false</code>
	 *         otherwise
	 */
	private boolean isFrameBufferSupported() {

		if (iFboIsSupported == -1) {
			iFboIsSupported = 0;
			//FIXME removed code which is not supported (quick assumption) by jogl - Madhu

			// create an FBO with a texture attachment and check the status
			int glFrameBuffer = 0;
			int glTexture = 0;
			try {
				glFrameBuffer = createFbo();
				glTexture = createTexture(32, 32);
				int status =
					m_gl.glCheckFramebufferStatusEXT(GL.GL_FRAMEBUFFER_EXT);
				if (status != GL.GL_FRAMEBUFFER_COMPLETE_EXT) {
					return false;
				}
			} finally {
				deleteTexture(glTexture);
				deleteFbo(glFrameBuffer);
			}

			iFboIsSupported = 1;
			return true;
		}
		return iFboIsSupported == 1;

	}
	
	//FIXME modified from static to instance method - madhu
	private int createFbo() {
		return TextureUtil.createFbo(m_gl);
	}
	
	//FIXME modified from static to instance method - madhu
	private int createTexture(int i_width, int i_height) {
		return TextureUtil.createTexture(i_width, i_height, m_gl);
	}
	
	private void deleteFbo(int i_glFrameBuffer) {
		TextureUtil.deleteFbo(i_glFrameBuffer, m_gl);
	}
	
	private void deleteTexture(int i_glTexture) {
		TextureUtil.deleteTexture(i_glTexture, m_gl);
	}

}
