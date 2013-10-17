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
 * Model classes for simple graph sample.  Observer pattern is implemented using
 * {@link PropertyChangeSupport}, i.e. observers must implement the
 * {@link java.beans.PropertyChangeListener} interface.
 * <p>
 * In "real" world applications, EMF is often used for implementing the model.   
 *  
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	Jul 15, 2008
 */
package org.eclipse.gef3d.examples.graph.model;

import java.beans.PropertyChangeSupport;

