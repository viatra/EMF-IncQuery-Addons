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

package org.eclipse.gef3d.ext.assimilator;

import org.eclipse.gef.EditPart;

/**
 * IEditPartAssimilator
 * There should really be more documentation here.
 *
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	Apr 8, 2008
 */
public interface IEditPartAssimilator extends IAssimilator<EditPart>{
	/**
	 * Called after the edit part has been activated.
	 * <p>
	 * This mechanism is a little bit tricky, see {@link AssimulatorPolicy} for
	 * details.
	 * </p>
	 */
	void modifyPolicies(EditPart io_editpart);
}
