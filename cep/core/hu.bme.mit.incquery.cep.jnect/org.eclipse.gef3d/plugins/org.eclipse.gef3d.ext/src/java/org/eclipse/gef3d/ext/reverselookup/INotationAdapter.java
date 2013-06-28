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

import org.eclipse.gef.EditPart;

/**
 * Helper for {@link ReverseLookupManager} to query the notation model. The
 * reverse lookup manager requires at least one {@link INotationAdapter}.
 * <p>
 * adapters are registered via
 * {@link ReverseLookupManager#addNotationAdapter(INotationAdapter)}.
 * </p>
 * <p>
 * Since these adapters are usually stateless, singletons can be used.
 * </p>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since May 23, 2009
 */
public interface INotationAdapter<NotationType> extends ILookupHelper {

	/**
	 * Returns a list of all children of a given notation element. In most
	 * cases, the children have the same (super) type as the given element, but
	 * not necessarily.
	 * 
	 * @param notationElement
	 * @return list of children or null, if element is a leaf.
	 */
	List<NotationType> getNotationChildren(NotationType notationElement);

	/**
	 * Returns the domain element connected to this notation element. Note that
	 * it might be indirectly connected, e.g. if a notation model is used (and
	 * we search for the EditPart). 
	 * <p>In other words, the returned element is
	 * dependent on the kind of reverse lookup which is to be performed. 
	 * E.g., if {@link EditPart}s are assumed to be the notation elements, 
	 * then is most cases this method will simply return the edit parts 
	 * model {@link EditPart#getModel()}. However, if an explicit graphical
	 * model is used, such as GMF's notation model, then maybe this method
	 * has to return the element referenced by the graphical model, that is
	 * <code>((View) part.getModel()).getElement()}</code>. The first case
	 * is implemented in {@link EditPartNotationAdapter}, the latter case
	 * in <code>GMFEditPartNotationAdapter</code> which is found in
	 * GEF3D's GMF plugin.
	 * </p>
	 * 
	 * 
	 * @param notationElement
	 * @return referenced domain object or null, of no domain object is
	 *         referenced.
	 */
	Object getDomainObject(NotationType notationElement);

}
