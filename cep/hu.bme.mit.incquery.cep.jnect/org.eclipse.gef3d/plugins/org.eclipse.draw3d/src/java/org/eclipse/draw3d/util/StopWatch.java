/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Simple too class for measuring the time of a code block.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Apr 10, 2008
 */
public class StopWatch {

	protected final static Map<Thread, StopWatch> INSTANCES = Collections
			.synchronizedMap(new HashMap<Thread, StopWatch>());

	Stack<Long> stackTimes;

	Stack<String> stackMessages;

	protected StopWatch() {
		stackTimes = new Stack<Long>();
		stackMessages = new Stack<String>();
	}

	public static String start(String message) {
		StringBuffer strb = new StringBuffer(message);
		strb.append(" started");
		long t = System.currentTimeMillis();
		getInstance().pushEntry(message, t);
		return strb.toString();
	}

	public static String stop() {
		if (!getInstance().isEmpty()) {
			StringBuffer strb = new StringBuffer();
			long t = getInstance().popEntry(strb);
			strb.append(": ").append(System.currentTimeMillis() - t).append(
					" ms");
			return strb.toString();
		} else {
			return "no stop watch running in this thread";
		}
	}

	/**
	 * @param i_message
	 * @param i_t
	 */
	void pushEntry(String i_message, long i_t) {
		stackTimes.push(i_t);
		stackMessages.push(i_message);
	}

	long popEntry(StringBuffer o_message) {
		o_message.append(stackMessages.pop());
		return stackTimes.pop();
	}

	boolean isEmpty() {
		return stackTimes.isEmpty();
	}

	static StopWatch getInstance() {
		Thread thread = Thread.currentThread();
		StopWatch watch = INSTANCES.get(thread);
		if (watch == null) {
			watch = new StopWatch();
			INSTANCES.put(thread, watch);
		}
		return watch;
	}
}
