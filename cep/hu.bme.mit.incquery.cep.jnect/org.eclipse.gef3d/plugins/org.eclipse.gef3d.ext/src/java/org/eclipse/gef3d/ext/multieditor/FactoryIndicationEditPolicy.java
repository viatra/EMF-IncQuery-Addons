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
package org.eclipse.gef3d.ext.multieditor;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.ui.part.EditorPart;

/**
 * Policy storing the factory which created the associated {@link EditorPart}.
 * This policy is installed by the {@link MultiEditorPartFactory} in order to be
 * able to retrieve the factory which created a context (usually the parent of a
 * node or source of a connection). This policy is usually only installed on
 * {@link ConnectionEditPart}, as their parent does not equal their creation
 * context.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Aug 26, 2009
 */
public class FactoryIndicationEditPolicy extends AbstractEditPolicy {

	public static String ROLE = "Factory Indication";

	protected EditPartFactory factory;

	/**
	 * @param factory the factory to set, must not be null
	 */
	public FactoryIndicationEditPolicy(EditPartFactory factory) {
		if (factory == null) // parameter precondition
			throw new NullPointerException("factory must not be null");

		this.factory = factory;
	}

	/**
	 * @return the factory
	 */
	public EditPartFactory getFactory() {
		return factory;
	}

}
