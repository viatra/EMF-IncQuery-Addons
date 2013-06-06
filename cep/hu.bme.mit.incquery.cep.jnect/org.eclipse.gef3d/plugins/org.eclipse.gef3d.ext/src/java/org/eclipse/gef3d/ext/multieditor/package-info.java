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

/**
 * This package contains the {@link MultiEditorPartFactory}, an extension of the
 * factory pattern, and its helper classes.
 * <p>
 * With GEF3D, the content of several combined editors can be combined and 
 * displayed in a single 3D scene. This is achieved by organizing the roots of 
 * all these editors as children of a {@link MultiEditorModelContainer}, which
 * becomes the root (and with it its edit part and figure). In order
 * to create objects, the {@link MultiEditorPartFactory} calls the original
 * factory, which is nested inside the multi editor part factory.
 * </p>
 * <p>Nested editors have to implement the interface {@link INestableEditor},
 * for editors using EMF features such as ResourceSets or EditingDomain, 
 * sub-interfaces of {@link INestableEditor} are provided in plugin
 * <code>org.eclipse.gef3d.ext.emf</code>.
 * </p>
 *  
 *  
 * @todo Instead of hard coding multi editor, extension points may be used.
 *  
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	Jul 15, 2008
 */
package org.eclipse.gef3d.ext.multieditor;

