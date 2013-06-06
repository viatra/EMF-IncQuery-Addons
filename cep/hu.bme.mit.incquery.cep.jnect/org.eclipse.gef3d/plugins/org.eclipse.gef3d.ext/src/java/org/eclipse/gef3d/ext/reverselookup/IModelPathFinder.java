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

import java.util.List;

/**
 * Helper interface for the {@link ReverseLookupManager}, returns a path from a
 * given model element to its root -- assuming that the data structure is a
 * tree. Note that the underlying data structure has not to be a tree
 * necessarily. Instead, the path returned should reflect how the elements are
 * represented, that is how they are mapped to notation models. This path is
 * used for optimizing the reverse lookup.
 * <p>
 * Adapters are registered via
 * {@link ReverseLookupManager#addModelPathFinder(IModelPathFinder)}.
 * </P>
 * <p>
 * Since these adapters are usually stateless, singletons can be used.
 * </p>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since May 23, 2009
 */
public interface IModelPathFinder extends ILookupHelper {

	/**
	 * Returns a path from the given element to the root. The path starts with
	 * the given model element and ends with the root element.
	 * 
	 * @param modelElement
	 * @return path, <code>path.get(0)</code> must return the modelElement
	 */
	List findPath(Object modelElement);

}
