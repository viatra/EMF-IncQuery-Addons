/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Matthias Thiele - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.graphics3d;


/**
 * Graphics3DUtil interface defines high-level 3D draw operations.
 * 
 * @author Matthias Thiele, Jens von Pilgrim
 * @version $Revision$
 * @since 06.12.2008
 */
public interface Graphics3DUtil {

	public static final int UNDEFINED_CONST_VAL = -1;

	/*
	 * Some GL drawing constants, mainly used for controlling the drawing
	 * methods. As the default renderer is an OpenGL implementation, these
	 * constant have the corresponding values. Other renderer implementations
	 * have to interpret their meaning towards their specifics.
	 */

	public static final int GLU_FILL = 100012; // org.lwjgl.util.glu.GLU.GLU_FILL;

	public static final int GLU_FLAT = 100001; // org.lwjgl.util.glu.GLU.GLU_FLAT;

	public static final int GLU_INSIDE = 100021; // org.lwjgl.util.glu.GLU.GLU_INSIDE;

	public static final int GLU_SILHOUETTE = 100013; // org.lwjgl.util.glu.GLU.GLU_SILHOUETTE;

	public static final int GLU_POINT = 100010; // org.lwjgl.util.glu.GLU.GLU_POINT;

	public static final int GLU_LINE = 100011; // org.lwjgl.util.glu.GLU.GLU_LINE;

	public static final int GLU_OUTSIDE = 100020; // org.lwjgl.util.glu.GLU.GLU_OUTSIDE;

	public static final int GLU_SMOOTH = 100000; // org.lwjgl.util.glu.GLU.GLU_SMOOTH;

	public static final int GLU_NONE = 100002; // org.lwjgl.util.glu.GLU.GLU_NONE;

	/*
	 * These are the high-level 3D methods. As the default renderer
	 * implementation is OpenGL, the methods are named accordingly and will fit
	 * well to the OpenGL renderer. Other renderer implementation have to
	 * interpret the methods according to their specifics.
	 */

	/**
	 * Sets the camera/eye position and looking direction, similar to GLU's
	 * methods with same name.
	 * <p>
	 * This method is usually only called by camera implementations. It sets the
	 * position of the camera (eyex, eyey, eyez), the reference point to which
	 * the camera is looking at (centerx, centery, centerz), and the up vector
	 * of the camera (upx, upy, upz). The figure illustrates these settings.
	 * 
	 * <img src="doc-files/gluLookAt.svg" width="50%" />
	 * 
	 * @param eyex the x component of the camera, i.e. eye, position
	 * @param eyey the y component of the camera, i.e. eye, position
	 * @param eyez the z component of the camera, i.e. eye, position
	 * @param centerx the x component of the reference point
	 * @param centery the y component of the reference point
	 * @param centerz the z component of the reference point
	 * @param upx the x component of the up vector
	 * @param upy the y component of the up vector
	 * @param upz the z component of the up vector
	 * @see http://www.opengl.org/sdk/docs/man/xhtml/gluLookAt.xml
	 */
	public abstract void gluLookAt(float eyex, float eyey, float eyez,
		float centerx, float centery, float centerz, float upx, float upy,
		float upz);

	/**
	 * Sets a box viewing volume, with all z coordinates are assumed to be in
	 * [-1, 1]. That is, this volume is used to project 2D content on a 2D
	 * screen.
	 * 
	 * @param left clipping left
	 * @param right clipping right
	 * @param bottom clipping bottom
	 * @param top clipping top
	 * @see http://www.opengl.org/sdk/docs/man/xhtml/gluOrtho2D.xml
	 */
	public abstract void gluOrtho2D(int left, int right, int bottom, int top);

	/**
	 * Set up the projection matrix, similar to the OpenGL GLU method with same
	 * name. The viewing volume resulting from these settings is illustrated
	 * in the figure.
	 * <img src="doc-files/gluPerspective.svg" width="70%" />
	 * 
	 * @param fovy field of view angle
	 * @param aspect aspect ratio
	 * @param zNear near clipping plane
	 * @param zFar far clipping plane
	 * @see http://www.opengl.org/sdk/docs/man/xhtml/gluPerspective.xml
	 */
	public abstract void gluPerspective(int fovy, float aspect, int zNear,
		int zFar);

//	/**
//	 * Maps window coordinates to object coordinates.
//	 * 
//	 * @param winx
//	 * @param winy
//	 * @param winz
//	 * @param modelMatrix
//	 * @param projMatrix
//	 * @param viewport
//	 * @param o_objCoordinates
//	 * @see http://www.opengl.org/sdk/docs/man/xhtml/gluUnProject.xml
//	 */
//	public abstract void gluUnProject(int winx, int winy, float winz,
//		FloatBuffer modelMatrix, FloatBuffer projMatrix, IntBuffer viewport,
//		FloatBuffer o_objCoordinates);
}