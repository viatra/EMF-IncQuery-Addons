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
package org.eclipse.draw3d.jogl.graphics3d.util;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import javax.media.opengl.GL;

import org.eclipse.draw3d.util.Draw3DCache;

/**
 * TextureUtil
 * 
 * @author Madhu Samuel
 * @version $Revision$
 * @since 27.08.2009
 */
public class TextureUtil {
	
	public static int createFbo(GL i_gl) {

		IntBuffer buffer = Draw3DCache.getIntBuffer(1);
		try {
			buffer.rewind();
			//FIXME EXTFramebufferObject.glGenFramebuffersEXT(buffer) modified as below : madhu
			i_gl.glGenFramebuffersEXT(1,buffer);
			return buffer.get(0);
		} finally {
			Draw3DCache.returnIntBuffer(buffer);
		}
	}
	
	public static int createTexture(int i_width, int i_height, GL i_gl) {

		IntBuffer buffer = Draw3DCache.getIntBuffer(1);
		try {
			buffer.rewind();
			//FIXME gl.glGenTextures(buffer) modified as below : Madhu
			i_gl.glGenTextures(1,buffer);
			int glTexture = buffer.get(0);
			
			i_gl.glBindTexture(GL.GL_TEXTURE_2D, glTexture);
			i_gl.glTexParameteri(GL.GL_TEXTURE_2D,
				GL.GL_TEXTURE_MAG_FILTER, GL.GL_LINEAR);
			i_gl.glTexParameteri(GL.GL_TEXTURE_2D,
				GL.GL_TEXTURE_MIN_FILTER, GL.GL_LINEAR);
			i_gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S,
				GL.GL_CLAMP);
			i_gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T,
				GL.GL_CLAMP);

			i_gl.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, i_width,
				i_height, 0, GL.GL_RGBA, GL.GL_UNSIGNED_BYTE,
				(ByteBuffer) null);
			//FIXME EXTFramebufferObject.glFramebufferTexture2DEXT(EXTFramebufferObject.GL_FRAMEBUFFER_EXT,EXTFramebufferObject.GL_COLOR_ATTACHMENT0_EXT,GL.GL_TEXTURE_2D, glTexture, 0);
			//modified as below : madhu
			i_gl.glFramebufferTexture2DEXT(
				GL.GL_FRAMEBUFFER_EXT,
				GL.GL_COLOR_ATTACHMENT0_EXT,
				GL.GL_TEXTURE_2D, glTexture, 0);
			i_gl.glBindTexture(GL.GL_TEXTURE_2D, 0);

			return glTexture;
		} finally {
			Draw3DCache.returnIntBuffer(buffer);
		}
	}
	
	public static void deleteFbo(int i_glFrameBuffer, GL i_gl) {

		if (i_glFrameBuffer > 0) {
			IntBuffer buffer = Draw3DCache.getIntBuffer(1);
			try {
				buffer.rewind();
				buffer.put(i_glFrameBuffer);
				//FIXME EXTFramebufferObject.glDeleteFramebuffersEXT(buffer); modifed as below - madhu
				i_gl.glDeleteFramebuffersEXT(1,buffer);
			} finally {
				Draw3DCache.returnIntBuffer(buffer);
			}
		}
	}
	
	public static void deleteTexture(int i_glTexture, GL i_gl) {

		if (i_glTexture > 0) {
			IntBuffer buffer = Draw3DCache.getIntBuffer(1);
			try {
				buffer.rewind();
				buffer.put(i_glTexture);
				//FIXME GL11.glDeleteTextures(buffer); modifed as blow - madhu
				i_gl.glDeleteTextures(1, buffer);
			} finally {
				Draw3DCache.returnIntBuffer(buffer);
			}
		}
	}

}
