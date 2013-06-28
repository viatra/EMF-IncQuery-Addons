/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Matthias Thiele - initial API and implementation
 *    Kristian Duske - initial API
 *    Jens von Pilgrim - initial API
 ******************************************************************************/
package org.eclipse.draw3d.graphics3d;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.eclipse.draw3d.geometry.IPosition3D;
import org.eclipse.draw3d.geometry.IVector2f;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.opengl.GLCanvas;

/**
 * The Graphics3DDraw interface defines common 3D draw operations in OpenGL
 * style.
 * 
 * @author Matthias Thiele
 * @version $Revision$
 * @since 06.12.2008
 */
public interface Graphics3DDraw extends Graphics3DConst {

	/*
	 * These are render methods which were already abstracted from the original
	 * OpenGL methods. Some of these method replace gl... methods, concrete
	 * implementations have to map these methods to appropriate gl... methods.
	 */

	/**
	 * Sets the position of an element.
	 * <p>
	 * OpenGL note: This method replaces
	 * <code>glMultMatrix(FloatBuffer m)</code>.
	 * </p>
	 * 
	 * @param position
	 */
	/**
	 * @param position
	 */
	void setPosition(IPosition3D position);

	
	/**
	 * 
	 * @return the platform constant
	 * @see Graphics3DConst#PLATFORM_WINDOWS
	 * @see Graphics3DConst#PLATFORM_MACOSX
	 * @see Graphics3DConst#PLATFORM_LINUX
	 */
	public abstract int getPlatform();
	
	/**
	 * @param context, usually a {@link GLCanvas}
	 * @throws Graphics3DException
	 */
	public void useContext(Object context) throws Graphics3DException;
	
	

	/*
	 * These are the 3D drawing methods. As the default renderer implementation
	 * is OpenGL, the methods are named accordingly and will fit well to the
	 * OpenGL renderer. Other renderer implementation have to interpret the
	 * methods according to their specifics.
	 */

	/**
	 * @param mode
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glBegin.xml">http://www.opengl.org/sdk/docs/man/xhtml/glBegin.xml</a>
	 */
	public abstract void glBegin(int mode);

	/**
	 * @param target
	 * @param texture
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glBindTexture.xml">http://www.opengl.org/sdk/docs/man/xhtml/glBindTexture.xml</a>
	 */
	public abstract void glBindTexture(int target, int texture);

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @param alpha
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glColor.xml">http://www.opengl.org/sdk/docs/man/xhtml/glColor.xml</a>
	 */
	public abstract void glColor4f(float red, float green, float blue,
		float alpha);

	/**
	 * @param i_color
	 * @param i_alpha
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glColor.xml">http://www.opengl.org/sdk/docs/man/xhtml/glColor.xml</a>
	 */
	public abstract void glColor(Color i_color, int i_alpha);

	/**
	 * @param i_color
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glColor.xml">http://www.opengl.org/sdk/docs/man/xhtml/glColor.xml</a>
	 */
	public abstract void glColor(Color i_color);

	/**
	 * @param rgba
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glColor.xml">http://www.opengl.org/sdk/docs/man/xhtml/glColor.xml</a>
	 */
	public abstract void glColor4f(float[] rgba);

	/**
	 * @param cap
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glDisable.xml">http://www.opengl.org/sdk/docs/man/xhtml/glDisable.xml</a>
	 */
	public abstract void glDisable(int cap);

	/**
	 * @param cap
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glEnable.xml">http://www.opengl.org/sdk/docs/man/xhtml/glEnable.xml</a>
	 */
	public abstract void glEnable(int cap);

	/**
	 * 
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glEnd.xml">http://www.opengl.org/sdk/docs/man/xhtml/glEnd.xml</a>
	 */
	public abstract void glEnd();

	/**
	 * @param target
	 * @param pname
	 * @param param
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glTexEnvi.xml">http://www.opengl.org/sdk/docs/man/xhtml/glTexEnvi.xml</a>
	 */
	public abstract void glTexEnvi(int target, int pname, int param);

	/**
	 * @param s
	 * @param t
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glTexCoord.xml">http://www.opengl.org/sdk/docs/man/xhtml/glTexCoord.xml</a>
	 */
	public abstract void glTexCoord2f(float s, float t);

	/**
	 * @param coords
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glTexCoord.xml">http://www.opengl.org/sdk/docs/man/xhtml/glTexCoord.xml</a>
	 */
	public abstract void glTexCoord2f(IVector2f coords);

	/**
	 * @param face
	 * @param mode
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glPolygonMode.xml">http://www.opengl.org/sdk/docs/man/xhtml/glPolygonMode.xml</a>
	 */
	public abstract void glPolygonMode(int face, int mode);

	/**
	 * @param x
	 * @param y
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glVertex.xml">http://www.opengl.org/sdk/docs/man/xhtml/glVertex.xml</a>
	 */
	public abstract void glVertex2f(float x, float y);

	/**
	 * @param vertex
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glVertex.xml">http://www.opengl.org/sdk/docs/man/xhtml/glVertex.xml</a>
	 */
	public abstract void glVertex2f(IVector2f vertex);

	/**
	 * @param mode
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glMatrixMode.xml">http://www.opengl.org/sdk/docs/man/xhtml/glMatrixMode.xml</a>
	 */
	public abstract void glMatrixMode(int mode);

	/**
	 * 
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glPushMatrix.xml">http://www.opengl.org/sdk/docs/man/xhtml/glPushMatrix.xml</a>
	 */
	public abstract void glPushMatrix();

	/**
	 * 
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glPopMatrix.xml">http://www.opengl.org/sdk/docs/man/xhtml/glPopMatrix.xml</a>
	 */
	public abstract void glPopMatrix();

	/**
	 * @param factor
	 * @param pattern
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glLineStipple.xml">http://www.opengl.org/sdk/docs/man/xhtml/glLineStipple.xml</a>
	 */
	public abstract void glLineStipple(int factor, short pattern);

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glTranslatef.xml">http://www.opengl.org/sdk/docs/man/xhtml/glTranslatef.xml</a>
	 */
	public abstract void glTranslatef(float x, float y, float z);

	/**
	 * @param name
	 * @return
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glGet.xml">http://www.opengl.org/sdk/docs/man/xhtml/glGet.xml</a>
	 */
	public abstract String glGetString(int name);

	/**
	 * @param pname
	 * @param params
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glGet.xml">http://www.opengl.org/sdk/docs/man/xhtml/glGet.xml</a>
	 */
	public abstract void glGetFloat(int pname, FloatBuffer params);

	/**
	 * @param pname
	 * @param params
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glGet.xml">http://www.opengl.org/sdk/docs/man/xhtml/glGet.xml</a>
	 */
	public abstract void glGetInteger(int pname, IntBuffer params);

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glViewport.xml">http://www.opengl.org/sdk/docs/man/xhtml/glViewport.xml</a>
	 */
	public abstract void glViewport(int x, int y, int width, int height);

	/**
	 * 
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glLoadIdentity.xml">http://www.opengl.org/sdk/docs/man/xhtml/glLoadIdentity.xml</a>
	 */
	public abstract void glLoadIdentity();

	/**
	 * @param range
	 * @return
	 */
	public abstract int glGenLists(int range);

	/**
	 * @param list
	 * @param range
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glDeleteLists.xml">http://www.opengl.org/sdk/docs/man/xhtml/glDeleteLists.xml</a>
	 */
	public abstract void glDeleteLists(int list, int range);

	/**
	 * @param list
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glCallList.xml">http://www.opengl.org/sdk/docs/man/xhtml/glCallList.xml</a>
	 */
	public abstract void glCallList(int list);

	/**
	 * @param list
	 * @param mode
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glNewList.xml">http://www.opengl.org/sdk/docs/man/xhtml/glNewList.xml</a>
	 */
	public abstract void glNewList(int list, int mode);

	/**
	 * 
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glEndList.xml">http://www.opengl.org/sdk/docs/man/xhtml/glEndList.xml</a>
	 */
	public abstract void glEndList();

	/**
	 * @param cap
	 * @return
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glEndList.xml">http://www.opengl.org/sdk/docs/man/xhtml/glIsEnabled</a>
	 */
	public abstract boolean glIsEnabled(int cap);

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glVertex.xml">http://www.opengl.org/sdk/docs/man/xhtml/glVertex.xml</a>
	 */
	public abstract void glVertex3f(float x, float y, float z);

	/**
	 * @param vertex
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glVertex.xml">http://www.opengl.org/sdk/docs/man/xhtml/glVertex.xml</a>
	 */
	public abstract void glVertex3f(IVector3f vertex);

	/**
	 * 
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glFlush.xml">http://www.opengl.org/sdk/docs/man/xhtml/glFlush.xml</a>
	 */
	public abstract void glFlush();

	/**
	 * @param mode
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glShadeModel.xml">http://www.opengl.org/sdk/docs/man/xhtml/glShadeModel.xml</a>
	 */
	public abstract void glShadeModel(int mode);

	/**
	 * @param target
	 * @param mode
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glHint.xml">http://www.opengl.org/sdk/docs/man/xhtml/glHint.xml</a>
	 */
	public abstract void glHint(int target, int mode);

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @param alpha
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glClearColor.xml">http://www.opengl.org/sdk/docs/man/xhtml/glClearColor.xml</a>
	 */
	public abstract void glClearColor(float red, float green, float blue,
		float alpha);

	/**
	 * @param mask
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glClear.xml">http://www.opengl.org/sdk/docs/man/xhtml/glClear.xml</a>
	 */
	public abstract void glClear(int mask);

	

	/**
	 * @param sfactor
	 * @param dfactor
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glBlendFunc.xml">http://www.opengl.org/sdk/docs/man/xhtml/glBlendFunc.xml</a>
	 */
	public abstract void glBlendFunc(int sfactor, int dfactor);

	/**
	 * @param depth
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glClearDepth.xml">http://www.opengl.org/sdk/docs/man/xhtml/glClearDepth.xml</a>
	 */
	public abstract void glClearDepth(double depth);

	/**
	 * @param pname
	 * @param param
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glPixelStorei.xml">http://www.opengl.org/sdk/docs/man/xhtml/glPixelStorei.xml</a>
	 */
	public abstract void glPixelStorei(int pname, int param);

	/**
	 * @param width
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glLineWidth.xml">http://www.opengl.org/sdk/docs/man/xhtml/glLineWidth.xml</a>
	 */
	public abstract void glLineWidth(float width);

	/**
	 * @param size
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glPointSize.xml">http://www.opengl.org/sdk/docs/man/xhtml/glPointSize.xml</a>
	 */
	public abstract void glPointSize(float size);

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glColor.xml">http://www.opengl.org/sdk/docs/man/xhtml/glColor.xml</a>
	 */
	public abstract void glColor3f(float red, float green, float blue);

	/**
	 * @param rgb
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glColor.xml">http://www.opengl.org/sdk/docs/man/xhtml/glColor.xml</a>
	 */
	public abstract void glColor3f(float[] rgb);

	/**
	 * 
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glFinish.xml">http://www.opengl.org/sdk/docs/man/xhtml/glFinish.xml</a>
	 */
	public abstract void glFinish();

	/**
	 * @param nx
	 * @param ny
	 * @param nz
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glNormal.xml">http://www.opengl.org/sdk/docs/man/xhtml/glNormal.xml</a>
	 */
	public abstract void glNormal3f(float nx, float ny, float nz);

	/**
	 * @param normal
	 * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glNormal.xml">http://www.opengl.org/sdk/docs/man/xhtml/glNormal.xml</a>
	 */
	public abstract void glNormal3f(IVector3f normal);

	

}