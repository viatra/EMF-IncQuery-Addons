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
package org.eclipse.draw3d.util;

/**
 * Helper class for debugging, prints out parts of the stack trace into a
 * String, which can be logged.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 17.12.2007
 */
public class CallStackTracer {

	/**
	 * The new line character for the current platform.
	 */
	public final static String NEWLINE = System.getProperty("line.separator");
	
	/**
	 * Returns the caller of a method. I.e. if a method foo() calls a method
	 * bar(), and bar() invokes getCaller(), "foo()" is returned.
	 * @return
	 */
	public static String getCaller() {
		return getStackTrace(3,3);
	}

	/**
	 * Prints stack trace w/o showing traces inside this class.
	 * 
	 * @param depth last stack trace entry printed (relative from caller)
	 * @return
	 */
	public static String getStackTrace(int depth) {
		return getStackTrace(2, 2 + depth);
	}

	/**
	 * Prints stack trace in interval [from, depth]
	 * <ol>
	 * 0 - getStackTrace 1 - method calling this getStackTrace
	 * </ol>
	 * 
	 * @param from first stack trace entry printed
	 * @param depth last stack trace entry printed
	 * @return
	 */
	public static String getStackTrace(int from, int depth) {
		StringBuffer strb = new StringBuffer();
		Exception ex = new Exception();
		StackTraceElement elements[] = ex.getStackTrace();
		for (int i = from; i <= depth && i < elements.length; i++) {
			if (strb.length() > 0) {
				strb.append(NEWLINE);
			}
			strb.append(elements[i].toString());
		}
		return strb.toString();
	}

}
