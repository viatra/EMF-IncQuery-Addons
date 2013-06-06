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

/**
 * This package contains a {@link ReverseLookupManager} for finding notation 
 * (or graphical) elements by their referenced domain (or semantic) element. 
 * The reverse lookup implemented here is usually not as fast as application
 * specific lookups, so it is recommend to use an application specific lookup or the
 * edit part registry
 * ({@link org.eclipse.gef.EditPartViewer#getEditPartRegistry()}), 
 * <p>
 * The reverse lookup makes almost no assumptions about how domain and
 * notation elements are mapped. The notation model is interpreted as tree.
 * That is, a notation element has children, and no cycles occur and all elements
 * of the notation model can be reached starting from a root element. For that, 
 * connections are handled similar to nodes. The algorithm queries a path for 
 * the domain element to be searched to it domain root -- if this path could not
 * be defined (e.g. because the domain model is not organized as tree), the 
 * algorithm still works but slows down. If a (domain) path can be calculated,
 * a second assumption is made: If an element of the domain path is mapped to
 * a notation element, then successors of the domain element are referenced
 * from notation elements which are found in the subtree with the previously
 * found notation element as root.  
 * </p>
 * <p>The algorithm is independent from any notation or domain model, in order
 * to calculate the domain path, an {@link IModelPathFinder} has to be registered. 
 * For getting the model element referenced by a notation element and for calculating
 * the children of a notation element, {@link INotationAdapter}s are used. As
 * {@link org.eclipse.gef.EditPart} are interpreted as notation elements as well,
 * {@link EditPartNotationAdapter} is provided here in order to return
 * the model element and the children of an edit part. Since multiple adapters can 
 * be used (for different types of models visualized in a multi editor), 
 * adapters indicate if they can handle a request (see 
 * {@link ILookupHelper#handlesElement(Object)}). Default implementations, such
 * as {@link EditPartNotationAdapter}, return 1 if they can handle a request,
 * more specialized adapters should return higher values. An adapter for GMF 
 * edit parts with referenced <code>View</code> objects (which then reference the
 * domain model) is provided in plugin <code>org.eclipse.gef3d.gmf</code>
 * (see <code>o.e.gef3d.gmf.ext.GMFEditPartNotationAdapter</code>).
 * </p>
 * <p>
 * Since the reverse lookup manager is assumed to be used for finding 
 * {@link org.eclipse.gef.EditPart} by the (domain) model element, 
 * a static method 
 * {@link ReverseLookupManager#getEditPartLookupManager(org.eclipse.gef.EditPartViewer)}
 * is provided, which returns a lookup manager associated to a given
 * {@link org.eclipse.gef.EditPartViewer}. The manager is created lazily if requried. 
 * </p> 
 * <p>For EMF models, an implemention of the {@link IModelPathFinder} interface
 * can be found in plugin <code>org.eclipse.gef3d.ext.emf</code>.</p> 
 * 
 *  
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	May 24, 2009
 */
package org.eclipse.gef3d.ext.reverselookup;

