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
 * This package contains classes and interfaces for implementing the
 * <em>Borg Pattern</em>, an extension of the factory pattern to modify an
 * object's state after it has been created.
 * 
 * A given
 * factory for some kind of objects, here {@link EditPart}s, is nested into a
 * {@link BorgEditPartFactory}. After the new {@link EditPart} has been
 * created by the nested factory, registered {@link IPolicyAssimilator}s can
 * modify the newly created edit part.
 * <p>
 * Due to some design issues of GEF, it is not possible to directly install
 * new {@link EditPolicy}-s  right after an {@link EditPart} has been created,
 * since {@link EditPart#createEditPolicies()} is called after the edit part
 * has been created by the factory and possibly installed policies are
 * replaced then.
 * To solve this problem, an AssimulatorPolicy is installed if the assimilator
 * modifies policies, i.e. if it is an instance of {@link IEditPartAssimilator}.
 * This policy calls {@link IEditPartAssimilator#modifyPolicies()} when
 * it is activated by its edit part.
 * <p>The name is inspired by StarTrek, and if you know StarTrek, you probably
 * know that resistance is futile.</p>
 * 
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	Apr 08, 2008
 */
package org.eclipse.gef3d.ext.assimilator;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.EditPart;

