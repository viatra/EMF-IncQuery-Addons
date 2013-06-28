/*******************************************************************************
 * Copyright (c) 2012 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.graphics3d;

/**
 * Defines OpenGL constant values used in gl* methods of {@link Graphics3DDraw}.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @version $Revision$
 * @since Jan 9, 2012
 */
public interface Graphics3DConst {
	public static final float PI = (float) Math.PI;
	
	public static final int PLATFORM_LINUX = 1;

	public static final int PLATFORM_MACOSX = 2;

	public static final int PLATFORM_WINDOWS = 3;

	
	/*
	 * Some GL drawing constants, mainly used for controlling the drawing
	 * methods. As the default renderer is an OpenGL implementation, these
	 * constant have the corresponding values. Other renderer implementations
	 * have to interpret their meaning towards their specifics.
	 */
	
	
	public static final int GL_ONE = 0x1;

	public static final int GL_ZERO = 0x0;

	public static final int GL_FILL = 0x1b02; // org.lwjgl.opengl.GL11.GL_FILL;

	public static final int GL_LINE = 0x1b01;

	public static final int GL_FRONT_AND_BACK = 0x408; // org.lwjgl.opengl.GL11.

	// GL_FRONT_AND_BACK;

	public static final int GL_LINES = 0x1; // org.lwjgl.opengl.GL11.GL_LINES;

	public static final int GL_LINE_STIPPLE = 0xb24; // org.lwjgl.opengl.GL11.

	// GL_LINE_STIPPLE;

	public static final int GL_LINE_STRIP = 0x3; // org.lwjgl.opengl.GL11.

	// GL_LINE_STRIP;

	public static final int GL_MODELVIEW = 0x1700; // org.lwjgl.opengl.GL11.

	// GL_MODELVIEW;

	public static final int GL_QUADS = 0x7; // org.lwjgl.opengl.GL11.GL_QUADS;

	public static final int GL_POLYGON = 0x9;

	// /TODO implement in X3D
	public static final int GL_TRIANGLES = 0x4;

	// TODO: implement in X3D
	public static final int GL_TRIANGLE_STRIP = 0x5;

	// TODO: implement in X3D
	public static final int GL_TRIANGLE_FAN = 0x6;

	public static final int GL_REPLACE = 0x1e01; // org.lwjgl.opengl.GL11.

	// GL_REPLACE;

	public static final int GL_RGBA = 0x1908; // org.lwjgl.opengl.GL11.GL_RGBA;

	public static final int GL_TEXTURE_2D = 0xde1; // org.lwjgl.opengl.GL11.

	// GL_TEXTURE_2D;

	public static final int GL_TEXTURE_ENV = 0x2300; // org.lwjgl.opengl.GL11.

	// GL_TEXTURE_ENV;

	public static final int GL_TEXTURE_ENV_MODE = 0x2200; // org.lwjgl.opengl.GL11

	// .
	// GL_TEXTURE_ENV_MODE
	// ;

	public static final int GL_UNSIGNED_BYTE = 0x1401; // org.lwjgl.opengl.GL11.

	// GL_UNSIGNED_BYTE;

	public static final int GL_UNPACK_ALIGNMENT = 0xcf5; // org.lwjgl.opengl.GL11

	// .
	// GL_UNPACK_ALIGNMENT
	// ;

	public static final int GL_VERSION = 0x1f02; // org.lwjgl.opengl.GL11.

	// GL_VERSION;

	public static final int GL_DEPTH_TEST = 0xb71; // org.lwjgl.opengl.GL11.

	// GL_DEPTH_TEST;

	public static final int GL_PROJECTION = 0x1701; // org.lwjgl.opengl.GL11.

	// GL_PROJECTION;

	public static final int GL_LUMINANCE_ALPHA = 0x190a; // org.lwjgl.opengl.GL11

	// .
	// GL_LUMINANCE_ALPHA
	// ;

	public static final int GL_BLEND = 0xbe2; // org.lwjgl.opengl.GL11.GL_BLEND;

	public static final int GL_COMPILE = 0x1300; // org.lwjgl.opengl.GL11.

	// GL_COMPILE;

	public static final int GL_COLOR_BUFFER_BIT = 0x4000; // org.lwjgl.opengl.GL11

	// .
	// GL_COLOR_BUFFER_BIT
	// ;

	public static final int GL_DEPTH_BUFFER_BIT = 0x100; // org.lwjgl.opengl.GL11

	// .
	// GL_DEPTH_BUFFER_BIT
	// ;

	public static final int GL_DEPTH_COMPONENT = 0x1902; // org.lwjgl.opengl.GL11

	// .
	// GL_DEPTH_COMPONENT
	// ;

	public static final int GL_RGB = 0x1907; // org.lwjgl.opengl.GL11.GL_RGB;

	public static final int GL_FLOAT = 0x1406; // org.lwjgl.opengl.GL11.GL_FLOAT;

	public static final int GL_DITHER = 0xbd0; // org.lwjgl.opengl.GL11.GL_DITHER

	// ;

	public static final int GL_MULTISAMPLE = 0x809d; // org.lwjgl.opengl.GL13.

	// GL_MULTISAMPLE;

	public static final int GL_LINE_LOOP = 0x2; // org.lwjgl.opengl.GL11.

	// GL_LINE_LOOP;

	public static final int GL_FLAT = 0x1d00; // org.lwjgl.opengl.GL11.GL_FLAT;

	public static final int GL_CULL_FACE = 0xb44; // org.lwjgl.opengl.GL11.

	// GL_CULL_FACE;

	public static final int GL_LINE_SMOOTH_HINT = 0xc52; // org.lwjgl.opengl.GL11

	// .
	// GL_LINE_SMOOTH_HINT
	// ;

	public static final int GL_NICEST = 0x1102; // org.lwjgl.opengl.GL11.GL_NICEST

	// ;

	public static final int GL_LINE_SMOOTH = 0xb20; // org.lwjgl.opengl.GL11.

	// GL_LINE_SMOOTH;

	public static final int GL_VIEWPORT = 0xba2; // org.lwjgl.opengl.GL11.

	// GL_VIEWPORT;

	public static final int GL_PROJECTION_MATRIX = 0xba7; // org.lwjgl.opengl.GL11

	// .
	// GL_PROJECTION_MATRIX
	// ;

	public static final int GL_MODELVIEW_MATRIX = 0xba6; // org.lwjgl.opengl.GL11

	// .
	// GL_MODELVIEW_MATRIX
	// ;

	

	// PLATFORM_WINDOWS;

	public static final int GL_SRC_ALPHA = 0x302; // org.lwjgl.opengl.GL11.

	// GL_SRC_ALPHA;

	public static final int GL_ONE_MINUS_SRC_ALPHA = 0x303; // org.lwjgl.opengl.

	// GL11.
	// GL_ONE_MINUS_SRC_ALPHA
	// ;

	public static final int GL_PACK_ALIGNMENT = 0xd05; // org.lwjgl.opengl.GL11.

	// GL_PACK_ALIGNMENT;

	public static final int GL_BGR = 0x80e0; // org.lwjgl.opengl.GL12.GL_BGR;

	public static final int GL_COLOR_INDEX = 0x1900; // org.lwjgl.opengl.GL11.

	// GL_COLOR_INDEX;

	public static final int GL_RED = 0x1903; // org.lwjgl.opengl.GL11.GL_RED;

	public static final int GL_GREEN = 0x1904; // org.lwjgl.opengl.GL11.GL_GREEN;

	public static final int GL_BLUE = 0x1905; // org.lwjgl.opengl.GL11.GL_BLUE;

	public static final int GL_ALPHA = 0x1906; // org.lwjgl.opengl.GL11.GL_ALPHA;

	public static final int GL_LUMINANCE = 0x1909; // org.lwjgl.opengl.GL11.

	// GL_LUMINANCE;

	public static final int GL_STENCIL_INDEX = 0x1901; // org.lwjgl.opengl.GL11.

	// GL_STENCIL_INDEX;

	public static final int GL_BYTE = 0x1400; // org.lwjgl.opengl.GL11.GL_BYTE;

	public static final int GL_UNSIGNED_SHORT = 0x1403; // org.lwjgl.opengl.GL11.

	// GL_UNSIGNED_SHORT;

	public static final int GL_SHORT = 0x1402; // org.lwjgl.opengl.GL11.GL_SHORT;

	public static final int GL_UNSIGNED_INT = 0x1405; // org.lwjgl.opengl.GL11.

	// GL_UNSIGNED_INT;

	public static final int GL_INT = 0x1404; // org.lwjgl.opengl.GL11.GL_INT;

	public static final int GL_BGRA = 0x80e1; // org.lwjgl.opengl.GL12.GL_BGRA;

	public static final int GL_UNSIGNED_BYTE_3_3_2 = 0x8032; // org.lwjgl.opengl.

	// GL12.
	// GL_UNSIGNED_BYTE_3_3_2
	// ;

	public static final int GL_UNSIGNED_BYTE_2_3_3_REV = 0x8362; // org.lwjgl.

	// opengl
	// .GL12.
	// GL_UNSIGNED_BYTE_2_3_3_REV
	// ;

	public static final int GL_UNSIGNED_SHORT_5_6_5 = 0x8363; // org.lwjgl.opengl

	// .GL12.
	// GL_UNSIGNED_SHORT_5_6_5
	// ;

	public static final int GL_UNSIGNED_SHORT_5_6_5_REV = 0x8364; // org.lwjgl.

	// opengl
	// .GL12.
	// GL_UNSIGNED_SHORT_5_6_5_REV
	// ;

	public static final int GL_UNSIGNED_SHORT_4_4_4_4 = 0x8033; // org.lwjgl.

	// opengl.GL12.
	// GL_UNSIGNED_SHORT_4_4_4_4
	// ;

	public static final int GL_UNSIGNED_SHORT_4_4_4_4_REV = 0x8365; // org.lwjgl.

	// opengl
	// .GL12.
	// GL_UNSIGNED_SHORT_4_4_4_4_REV
	// ;

	public static final int GL_UNSIGNED_SHORT_5_5_5_1 = 0x8034; // org.lwjgl.

	// opengl.GL12.
	// GL_UNSIGNED_SHORT_5_5_5_1
	// ;

	public static final int GL_UNSIGNED_SHORT_1_5_5_5_REV = 0x8366; // org.lwjgl.

	// opengl
	// .GL12.
	// GL_UNSIGNED_SHORT_1_5_5_5_REV
	// ;

	public static final int GL_UNSIGNED_INT_8_8_8_8 = 0x8035; // org.lwjgl.opengl

	// .GL12.
	// GL_UNSIGNED_INT_8_8_8_8
	// ;

	public static final int GL_UNSIGNED_INT_8_8_8_8_REV = 0x8367; // org.lwjgl.

	// opengl
	// .GL12.
	// GL_UNSIGNED_INT_8_8_8_8_REV
	// ;

	public static final int GL_UNSIGNED_INT_10_10_10_2 = 0x8036; // org.lwjgl.

	// opengl
	// .GL12.
	// GL_UNSIGNED_INT_10_10_10_2
	// ;

	public static final int GL_UNSIGNED_INT_2_10_10_10_REV = 0x8368; // org.lwjgl

	// .
	// opengl
	// .
	// GL12.
	// GL_UNSIGNED_INT_2_10_10_10_REV
	// ;

	public static final int GL_POINTS = 0x0; // org.lwjgl.opengl.GL11.GL_POINTS;

	public static final int GL_QUAD_STRIP = 0x8; // org.lwjgl.opengl.GL11.

	// GL_QUAD_STRIP;
}
