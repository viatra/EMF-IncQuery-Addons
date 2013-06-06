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

package org.eclipse.gef3d.ext.multieditor;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gef.EditPart;

/**
 * Delegator There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 15.01.2008
 */
public class Delegator<T> {

	protected Map<EditPart, T> receivers;

	protected EditPart activeRootContext;

	protected EditPart primaryRootContext;

	/**
	 * 
	 */
	public Delegator() {
		receivers = new HashMap<EditPart, T>();
	}

	public void addReceiver(EditPart rootContext, T receiver) {
		receivers.put(rootContext, receiver);
		if (primaryRootContext == null) {
			setPrimaryContext(rootContext);
		}
	}

	/**
	 * @param rootContext
	 */
	public void setPrimaryContext(EditPart rootContext) {
		if (!receivers.containsKey(rootContext)) {
			throw new IllegalStateException(
					"Root context not in receiver's key list");
		}
		primaryRootContext = rootContext;

	}

	public T remove(EditPart root) {
		T value = receivers.remove(root);
		if (root == primaryRootContext) {
			if (receivers.size() > 0) {
				setPrimaryContext(receivers.keySet().iterator().next());
			} else {
				primaryRootContext = null;
			}
		}
		return value;
	}

	/**
	 * Sets active context, if given context is not a root context, the
	 * ancestors of the context are searched.
	 * 
	 * @param context
	 */
	public void setActiveContext(EditPart context) {
		while (context != null && !receivers.containsKey(context)) {
			context = context.getParent();
		}
		activeRootContext = context;
	}

	public EditPart getActiveContext() {
		return activeRootContext;
	}

	public T getActive() {
		if (activeRootContext == null) {
			return receivers.get(primaryRootContext);
		}
		return receivers.get(activeRootContext);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer strb = new StringBuffer("Delegator<");

		strb.append(Delegator.class.getTypeParameters()[0].getName());
		strb.append(">: activeRootContext=");
		strb.append(activeRootContext);
		strb.append(", #rec=").append(receivers.size());

		return strb.toString();

	}

	/**
	 * Delegate method
	 * 
	 * @return
	 * @see java.util.Map#isEmpty()
	 */
	public boolean isEmpty() {
		return receivers.isEmpty();
	}

	/**
	 * Delegate method
	 * 
	 * @return
	 * @see java.util.Map#size()
	 */
	public int size() {
		return receivers.size();
	}

}
