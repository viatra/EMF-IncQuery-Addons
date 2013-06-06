/*******************************************************************************
 * Copyright (c) 2009 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.ext.reverselookup;

/**
 * Super interface for adapters used in {@link ReverseLookupManager}, providing
 * a method indicating if this helper can handle a given element. The returned
 * value indicates "how well" is can be handled, if the element cannot be
 * handled, 0 is to be returned. This interface is used by ILookupStrategy and
 * ModelPathFi
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since May 23, 2009
 */
public interface ILookupHelper {

	/**
	 * Returns a number > 0 if this adapter handles the given element. Basic
	 * adapters are assumed to return low numbers, while highly specialized ones
	 * return higher numbers. Rule of thumb: Return the length of the navigation
	 * path to find the matching elements.
	 * 
	 * @param notationElement
	 * @return
	 */
	public int handlesElement(Object modelElement);

}