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
package org.eclipse.gef3d.gmf.ext.reverselookup;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef3d.ext.reverselookup.ModelPathFinderStrategy;
import org.eclipse.gef3d.ext.reverselookup.ILookupStrategy;
import org.eclipse.gef3d.ext.reverselookup.ReverseLookupManager;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;

/**
 * Lookup strategy for {@link ReverseLookupManager}, uses GMF lookup map
 * (mapping the semantic model element's id
 * {@link EMFCoreUtil#getProxyID(EObject)} as key, i.e.
 * {@link IDiagramGraphicalViewer#findEditPartsForElement(String, Class)}.
 * <p>
 * As only the first edit part is returned, it may be even more efficient to use
 * GEF3D's {@link ModelPathFinderStrategy} in combination with
 * {@link GMFEditPartNotationAdapter}, since this method stops when the first
 * edit part is found. Apart from that, you'll need to use this strategy if no
 * {@link IDiagramGraphicalViewer} is used, as it may be the case in 3D
 * multi-editors!
 * </p>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Sep 28, 2009
 * @see ReverseLookupManager
 */
public class GMFEditPartMapLookupStrategy implements ILookupStrategy<EditPart> {
	/**
	 * Logger for this class
	 */
	private static final Logger log =
		Logger.getLogger(GMFEditPartMapLookupStrategy.class.getName());

	IDiagramGraphicalViewer viewer;

	/**
	 * Creates this strategy, if you do not have an
	 * {@link IDiagramGraphicalViewer}, you can use GEF3D's lookup mechanism,
	 * see {@link ModelPathFinderStrategy}.
	 * 
	 * @param i_viewer
	 */
	public GMFEditPartMapLookupStrategy(IDiagramGraphicalViewer i_viewer) {
		viewer = i_viewer;
	}

	/**
	 * Returns the (almost) the first {@link EditPart} using the
	 * {@link IDiagramGraphicalViewer#findEditPartsForElement(String, Class)}
	 * method. If more then one edit part is found, the first
	 * {@link GraphicalEditPart} is returned (if possible), otherwise the first
	 * found {@link EditPart}.
	 * 
	 * @see org.eclipse.gef3d.ext.reverselookup.emf.ILookupStrategy#findNotationByDomain(java.lang.Object)
	 */
	public EditPart findNotationByDomain(Object i_domainElement) {
		if (i_domainElement instanceof EObject) {
			String id = EMFCoreUtil.getProxyID((EObject) i_domainElement);
			if (id != null) {
				List results =
					viewer.findEditPartsForElement(id, EditPart.class);
				if (results != null && !results.isEmpty()) {
					if (results.size() > 1) {
						int size = results.size();
						Object editPart;
						for (int i=0; i<size; i++) {
							editPart = results.get(i);
							if (editPart instanceof GraphicalEditPart)
								return (EditPart) editPart;
						}
						
//						if (log.isLoggable(Level.INFO)) {
//							log.info("Found " + results.size() //$NON-NLS-1$
//								+ " editparts for domain element " //$NON-NLS-1$
//								+ i_domainElement + ", return first one"); //$NON-NLS-1$
//						}
					}
					return (EditPart) results.get(0);
				}
			}
		}
		return null;
	}

	/**
	 * Returns 1 if model element is an instance of {@link EObject}, else -1.
	 * 
	 * @see org.eclipse.gef3d.ext.reverselookup.emf.ILookupHelper#handlesElement(java.lang.Object)
	 */
	public int handlesElement(Object i_modelElement) {
		if (i_modelElement instanceof EObject)
			return 1;
		return -1;
	}

}
