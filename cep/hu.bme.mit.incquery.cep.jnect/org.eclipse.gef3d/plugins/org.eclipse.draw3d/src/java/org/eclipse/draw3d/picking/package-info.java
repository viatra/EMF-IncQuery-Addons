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

/**
 * Figure picking mechanisms allows multiple pickers as well as easily
 * switching the implementation of a picker. Multiple pickers are necessary for
 * correctly supporting moving of 3D figures.
 * <p>
 * While this package holds picking related classes, the picking is performed
 * by the picking update manager {@link org.eclipse.draw3d.PickingUpdateManager3D}.
 * </p>
 * <p>Picking was refactored with rev. 462 (in repository gorgo.fernuni-hagen.de).</p>
 *  
 * @author 	Kristian Duske
 * @version	$Revision$
 * @since 	Jul 15, 2008
 */
package org.eclipse.draw3d.picking;

