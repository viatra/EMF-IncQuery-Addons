/*******************************************************************************
 * Copyright (c) 2010 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.graphics3d.lwjgl.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw3d.graphics3d.Graphics3DDraw;
import org.eclipse.draw3d.lwjgl.Activator;
import org.lwjgl.opengl.GL11;

/**
 * Checker used in {@link Activator} for ensuring {@link Graphics3DDraw} constants
 * have same values as {@link GL11} constants.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Nov 15, 2010
 */
public class ConstantChecker {
	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger.getLogger(ConstantChecker.class.getName());
	
	List<String> errors = new ArrayList<String>();
	

	public static List<String> checkConstants() {
		ConstantChecker checker = new ConstantChecker();
		
		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_ONE,
			org.lwjgl.opengl.GL11.GL_ONE, "GL_ONE", 0x1);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_ZERO,
			org.lwjgl.opengl.GL11.GL_ZERO, "GL_ZERO", 0x0);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_FILL,
			org.lwjgl.opengl.GL11.GL_FILL, "GL_FILL", 0x1b02);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_LINE,
			org.lwjgl.opengl.GL11.GL_LINE, "GL_LINE", 0x1b01);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_FRONT_AND_BACK,
			org.lwjgl.opengl.GL11.GL_FRONT_AND_BACK, "GL_FRONT_AND_BACK", 0x408);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_LINES,
			org.lwjgl.opengl.GL11.GL_LINES, "GL_LINES", 0x1);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_LINE_STIPPLE,
			org.lwjgl.opengl.GL11.GL_LINE_STIPPLE, "GL_LINE_STIPPLE", 0xb24);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_LINE_STRIP,
			org.lwjgl.opengl.GL11.GL_LINE_STRIP, "GL_LINE_STRIP", 0x3);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_MODELVIEW,
			org.lwjgl.opengl.GL11.GL_MODELVIEW, "GL_MODELVIEW", 0x1700);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_QUADS,
			org.lwjgl.opengl.GL11.GL_QUADS, "GL_QUADS", 0x7);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_POLYGON,
			org.lwjgl.opengl.GL11.GL_POLYGON, "GL_POLYGON", 0x9);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_TRIANGLES,
			org.lwjgl.opengl.GL11.GL_TRIANGLES, "GL_TRIANGLES", 0x4);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_TRIANGLE_STRIP,
			org.lwjgl.opengl.GL11.GL_TRIANGLE_STRIP, "GL_TRIANGLE_STRIP", 0x5);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_TRIANGLE_FAN,
			org.lwjgl.opengl.GL11.GL_TRIANGLE_FAN, "GL_TRIANGLE_FAN", 0x6);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_REPLACE,
			org.lwjgl.opengl.GL11.GL_REPLACE, "GL_REPLACE", 0x1e01);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_RGBA,
			org.lwjgl.opengl.GL11.GL_RGBA, "GL_RGBA", 0x1908);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_TEXTURE_2D,
			org.lwjgl.opengl.GL11.GL_TEXTURE_2D, "GL_TEXTURE_2D", 0xde1);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_TEXTURE_ENV,
			org.lwjgl.opengl.GL11.GL_TEXTURE_ENV, "GL_TEXTURE_ENV", 0x2300);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_TEXTURE_ENV_MODE,
			org.lwjgl.opengl.GL11.GL_TEXTURE_ENV_MODE, "GL_TEXTURE_ENV_MODE",
			0x2200);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_UNSIGNED_BYTE,
			org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE, "GL_UNSIGNED_BYTE", 0x1401);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_UNPACK_ALIGNMENT,
			org.lwjgl.opengl.GL11.GL_UNPACK_ALIGNMENT, "GL_UNPACK_ALIGNMENT",
			0xcf5);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_VERSION,
			org.lwjgl.opengl.GL11.GL_VERSION, "GL_VERSION", 0x1f02);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_DEPTH_TEST,
			org.lwjgl.opengl.GL11.GL_DEPTH_TEST, "GL_DEPTH_TEST", 0xb71);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_PROJECTION,
			org.lwjgl.opengl.GL11.GL_PROJECTION, "GL_PROJECTION", 0x1701);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_LUMINANCE_ALPHA,
			org.lwjgl.opengl.GL11.GL_LUMINANCE_ALPHA, "GL_LUMINANCE_ALPHA",
			0x190a);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_BLEND,
			org.lwjgl.opengl.GL11.GL_BLEND, "GL_BLEND", 0xbe2);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_COMPILE,
			org.lwjgl.opengl.GL11.GL_COMPILE, "GL_COMPILE", 0x1300);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_COLOR_BUFFER_BIT,
			org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT, "GL_COLOR_BUFFER_BIT",
			0x4000);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_DEPTH_BUFFER_BIT,
			org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT, "GL_DEPTH_BUFFER_BIT",
			0x100);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_DEPTH_COMPONENT,
			org.lwjgl.opengl.GL11.GL_DEPTH_COMPONENT, "GL_DEPTH_COMPONENT",
			0x1902);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_RGB,
			org.lwjgl.opengl.GL11.GL_RGB, "GL_RGB", 0x1907);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_FLOAT,
			org.lwjgl.opengl.GL11.GL_FLOAT, "GL_FLOAT", 0x1406);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_DITHER,
			org.lwjgl.opengl.GL11.GL_DITHER, "GL_DITHER", 0xbd0);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_MULTISAMPLE,
			org.lwjgl.opengl.GL13.GL_MULTISAMPLE, "GL_MULTISAMPLE", 0x809d);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_LINE_LOOP,
			org.lwjgl.opengl.GL11.GL_LINE_LOOP, "GL_LINE_LOOP", 0x2);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_FLAT,
			org.lwjgl.opengl.GL11.GL_FLAT, "GL_FLAT", 0x1d00);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_CULL_FACE,
			org.lwjgl.opengl.GL11.GL_CULL_FACE, "GL_CULL_FACE", 0xb44);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_LINE_SMOOTH_HINT,
			org.lwjgl.opengl.GL11.GL_LINE_SMOOTH_HINT, "GL_LINE_SMOOTH_HINT",
			0xc52);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_NICEST,
			org.lwjgl.opengl.GL11.GL_NICEST, "GL_NICEST", 0x1102);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_LINE_SMOOTH,
			org.lwjgl.opengl.GL11.GL_LINE_SMOOTH, "GL_LINE_SMOOTH", 0xb20);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_VIEWPORT,
			org.lwjgl.opengl.GL11.GL_VIEWPORT, "GL_VIEWPORT", 0xba2);

		checker.check(
			org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_PROJECTION_MATRIX,
			org.lwjgl.opengl.GL11.GL_PROJECTION_MATRIX, "GL_PROJECTION_MATRIX",
			0xba7);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_MODELVIEW_MATRIX,
			org.lwjgl.opengl.GL11.GL_MODELVIEW_MATRIX, "GL_MODELVIEW_MATRIX",
			0xba6);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_SRC_ALPHA,
			org.lwjgl.opengl.GL11.GL_SRC_ALPHA, "GL_SRC_ALPHA", 0x302);

		checker.check(
			org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_ONE_MINUS_SRC_ALPHA,
			org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA,
			"GL_ONE_MINUS_SRC_ALPHA", 0x303);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_PACK_ALIGNMENT,
			org.lwjgl.opengl.GL11.GL_PACK_ALIGNMENT, "GL_PACK_ALIGNMENT", 0xd05);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_BGR,
			org.lwjgl.opengl.GL12.GL_BGR, "GL_BGR", 0x80e0);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_COLOR_INDEX,
			org.lwjgl.opengl.GL11.GL_COLOR_INDEX, "GL_COLOR_INDEX", 0x1900);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_RED,
			org.lwjgl.opengl.GL11.GL_RED, "GL_RED", 0x1903);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_GREEN,
			org.lwjgl.opengl.GL11.GL_GREEN, "GL_GREEN", 0x1904);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_BLUE,
			org.lwjgl.opengl.GL11.GL_BLUE, "GL_BLUE", 0x1905);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_ALPHA,
			org.lwjgl.opengl.GL11.GL_ALPHA, "GL_ALPHA", 0x1906);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_LUMINANCE,
			org.lwjgl.opengl.GL11.GL_LUMINANCE, "GL_LUMINANCE", 0x1909);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_STENCIL_INDEX,
			org.lwjgl.opengl.GL11.GL_STENCIL_INDEX, "GL_STENCIL_INDEX", 0x1901);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_BYTE,
			org.lwjgl.opengl.GL11.GL_BYTE, "GL_BYTE", 0x1400);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_UNSIGNED_SHORT,
			org.lwjgl.opengl.GL11.GL_UNSIGNED_SHORT, "GL_UNSIGNED_SHORT",
			0x1403);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_SHORT,
			org.lwjgl.opengl.GL11.GL_SHORT, "GL_SHORT", 0x1402);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_UNSIGNED_INT,
			org.lwjgl.opengl.GL11.GL_UNSIGNED_INT, "GL_UNSIGNED_INT", 0x1405);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_INT,
			org.lwjgl.opengl.GL11.GL_INT, "GL_INT", 0x1404);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_BGRA,
			org.lwjgl.opengl.GL12.GL_BGRA, "GL_BGRA", 0x80e1);

		checker.check(
			org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_UNSIGNED_BYTE_3_3_2,
			org.lwjgl.opengl.GL12.GL_UNSIGNED_BYTE_3_3_2,
			"GL_UNSIGNED_BYTE_3_3_2", 0x8032);

		checker.check(
			org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_UNSIGNED_BYTE_2_3_3_REV,
			org.lwjgl.opengl.GL12.GL_UNSIGNED_BYTE_2_3_3_REV,
			"GL_UNSIGNED_BYTE_2_3_3_REV", 0x8362);

		checker.check(
			org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_UNSIGNED_SHORT_5_6_5,
			org.lwjgl.opengl.GL12.GL_UNSIGNED_SHORT_5_6_5,
			"GL_UNSIGNED_SHORT_5_6_5", 0x8363);

		checker.check(
			org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_UNSIGNED_SHORT_5_6_5_REV,
			org.lwjgl.opengl.GL12.GL_UNSIGNED_SHORT_5_6_5_REV,
			"GL_UNSIGNED_SHORT_5_6_5_REV", 0x8364);

		checker.check(
			org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_UNSIGNED_SHORT_4_4_4_4,
			org.lwjgl.opengl.GL12.GL_UNSIGNED_SHORT_4_4_4_4,
			"GL_UNSIGNED_SHORT_4_4_4_4", 0x8033);

		checker.check(
			org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_UNSIGNED_SHORT_4_4_4_4_REV,
			org.lwjgl.opengl.GL12.GL_UNSIGNED_SHORT_4_4_4_4_REV,
			"GL_UNSIGNED_SHORT_4_4_4_4_REV", 0x8365);

		checker.check(
			org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_UNSIGNED_SHORT_5_5_5_1,
			org.lwjgl.opengl.GL12.GL_UNSIGNED_SHORT_5_5_5_1,
			"GL_UNSIGNED_SHORT_5_5_5_1", 0x8034);

		checker.check(
			org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_UNSIGNED_SHORT_1_5_5_5_REV,
			org.lwjgl.opengl.GL12.GL_UNSIGNED_SHORT_1_5_5_5_REV,
			"GL_UNSIGNED_SHORT_1_5_5_5_REV", 0x8366);

		checker.check(
			org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_UNSIGNED_INT_8_8_8_8,
			org.lwjgl.opengl.GL12.GL_UNSIGNED_INT_8_8_8_8,
			"GL_UNSIGNED_INT_8_8_8_8", 0x8035);

		checker.check(
			org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_UNSIGNED_INT_8_8_8_8_REV,
			org.lwjgl.opengl.GL12.GL_UNSIGNED_INT_8_8_8_8_REV,
			"GL_UNSIGNED_INT_8_8_8_8_REV", 0x8367);

		checker.check(
			org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_UNSIGNED_INT_10_10_10_2,
			org.lwjgl.opengl.GL12.GL_UNSIGNED_INT_10_10_10_2,
			"GL_UNSIGNED_INT_10_10_10_2", 0x8036);

		checker.check(
			org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_UNSIGNED_INT_2_10_10_10_REV,
			org.lwjgl.opengl.GL12.GL_UNSIGNED_INT_2_10_10_10_REV,
			"GL_UNSIGNED_INT_2_10_10_10_REV", 0x8368);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_POINTS,
			org.lwjgl.opengl.GL11.GL_POINTS, "GL_POINTS", 0x0);

		checker.check(org.eclipse.draw3d.graphics3d.Graphics3DDraw.GL_QUAD_STRIP,
			org.lwjgl.opengl.GL11.GL_QUAD_STRIP, "GL_QUAD_STRIP", 0x8);
		
		return checker.errors;
	}

	/**
	 * @param constGraphics3DDraw
	 * @param constLWJGL
	 * @param i_name
	 * @param checkedValue
	 */
	protected  void check(int constGraphics3DDraw,
		int constLWJGL, String i_name, int checkedValue) {
		
		if (constGraphics3DDraw!=constLWJGL) {
			errors.add("Graphics3DDraw."+i_name+" ("+constGraphics3DDraw+") != GL11."+i_name+" ("+constLWJGL+"), reference="+checkedValue);
		}
		if (constGraphics3DDraw!=checkedValue) {
			if (log.isLoggable(Level.INFO)) {
				log.info("LWJGL constant, reference changed: Graphics3DDraw."+i_name+" ("+constGraphics3DDraw+") == GL11."+i_name+" ("+constLWJGL+"), reference="+checkedValue); //$NON-NLS-1$
			}
		}

	}

}
