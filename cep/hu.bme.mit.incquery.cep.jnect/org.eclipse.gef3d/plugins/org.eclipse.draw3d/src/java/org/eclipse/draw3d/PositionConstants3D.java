/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d;

import static org.eclipse.draw2d.PositionConstants.ALWAYS_LEFT;
import static org.eclipse.draw2d.PositionConstants.ALWAYS_RIGHT;
import static org.eclipse.draw2d.PositionConstants.BOTTOM;
import static org.eclipse.draw2d.PositionConstants.CENTER;
import static org.eclipse.draw2d.PositionConstants.HORIZONTAL;
import static org.eclipse.draw2d.PositionConstants.LEFT;
import static org.eclipse.draw2d.PositionConstants.MIDDLE;
import static org.eclipse.draw2d.PositionConstants.RIGHT;
import static org.eclipse.draw2d.PositionConstants.TOP;
import static org.eclipse.draw2d.PositionConstants.VERTICAL;

import org.eclipse.draw2d.PositionConstants;

/**
 * PositionConstants3D extend the 2D position constants for 3D.
 * 
 * We use an enumeration here instead of integers (as used by GEF) since
 * we are using JDK 1.5 or greater. 
 * 
 * <p>Iternal note: In a first approach, integers were used and Draw2D's
 * {@link PositionConstants} was extended. Unfortunately, GEF runs into some
 * problems if a position value has more "bits" set then expected, e.g.
 * the cursor was not updated accordingly on handles due to the extra
 * bit set for 3D position. Thus we use a separate approach here.
 * </p>
 * 
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	Mar 26, 2008
 */
public enum PositionConstants3D { // implements PositionConstants {
	
	FRONT,
	BACK,
	ZMIDDLE,
	STRAIGHT
	;
	
	/*
	public final static int BASE3D = 1024; 
	public final static int FRONT = BASE3D;
	public final static int BACK = BASE3D << 1; // 2048
	public final static int ZMIDDLE = BASE3D << 2; // 4096
	public final static int STRAIGHT = BASE3D << 3; 
	*/
	
	/**
	 * toString method for 2D postion constants, i.e. {@link PositionConstants}.
	 */
	public static String toString(int pos2D) {
		StringBuffer strb = new StringBuffer();

		if (pos2D==0) strb.append("NONE");
		append(strb, pos2D, LEFT, "LEFT=NORTH"); // int NORTH =  1;
		append(strb, pos2D, CENTER, "CENTER");
		append(strb, pos2D, RIGHT, "RIGHT=SOUTH");
		append(strb, pos2D, ALWAYS_LEFT, "ALWAYS_LEFT");
		append(strb, pos2D, ALWAYS_RIGHT, "ALWAYS_RIGHT");

		append(strb, pos2D, TOP, "TOP=WEST"); // int WEST  =  8;
		append(strb, pos2D, MIDDLE, "MIDDLE=EAST"); // int EAST  = 16;
		append(strb, pos2D, BOTTOM, "BOTTOM");
		
		append(strb, pos2D, HORIZONTAL, "HORIZONTAL");
		append(strb, pos2D, VERTICAL, "VERTICAL");
		/*
		append(strb, pos, FRONT, "FRONT");
		append(strb, pos, BACK, "BACK");
		append(strb, pos, ZMIDDLE, "ZMIDDLE");
		append(strb, pos, STRAIGHT, "STRAIGHT"); 
		 */	
		return strb.toString();
	}
	
	private static void append(StringBuffer strb, int pos, int value, String str) {
		if ((pos & value) > 0) {
			if (strb.length()>0) strb.append("|");
			strb.append(str);
		}
	}
	
	
}
