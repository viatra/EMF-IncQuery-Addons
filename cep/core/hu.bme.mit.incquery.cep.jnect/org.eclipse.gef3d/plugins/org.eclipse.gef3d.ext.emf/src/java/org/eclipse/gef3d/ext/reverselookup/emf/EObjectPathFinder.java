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
package org.eclipse.gef3d.ext.reverselookup.emf;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef3d.ext.reverselookup.IModelPathFinder;
import org.eclipse.gef3d.ext.reverselookup.ReverseLookupManager;

/**
 * Implementation of {@link IModelPathFinder} used in the
 * {@link ReverseLookupManager} for {@link EObject}s. Returns a path from a
 * given element of type EObject to its root in a model graph by iteratively
 * calling {@link EObject#eContainer()}.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since May 23, 2009
 */
public class EObjectPathFinder implements IModelPathFinder {

	/**
	 * The singleton instance, object has no state
	 */
	public final static EObjectPathFinder INSTANCE = new EObjectPathFinder();

	/**
	 * {@inheritDoc}
	 * <p>
	 * The given model element is expected to be an {@link EObject}, otherwise a
	 * {@link ClassCastException} will be thrown. This is ensured by calling
	 * {@link #handlesElement(Object)} before.
	 * </p>
	 * 
	 * @param i_modelElement must be an instance of {@link EObject}
	 * @return a path with first item is the givebn model element, the last item
	 *         is the root container
	 * @see org.eclipse.gef3d.ext.reverselookup.emf.IModelPathFinder#findPath(java.lang.Object)
	 */
	public List findPath(Object i_modelElement) {
		EObject eobj = (EObject) i_modelElement;

		List<EObject> path = new ArrayList<EObject>();
		EObject container;

		while (eobj != null) {
			container = eobj.eContainer(); // resolves eobj;
			path.add(eobj); // do not insert proxies
			eobj = container;
		}
		return path;
	}

	/**
	 * Returns 1 if given model element is an instance of {@link EObject}.
	 * 
	 * @see org.eclipse.gef3d.ext.reverselookup.emf.ILookupHelper#handlesElement(java.lang.Object)
	 * @return 1, if model element is instance of {@link EObject}, 0 otherwise
	 */
	public int handlesElement(Object i_modelElement) {
		if (i_modelElement instanceof EObject)
			return 1;
		return 0;
	}

}
