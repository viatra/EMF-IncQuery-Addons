/*******************************************************************************
 * Copyright (c) 2008 Kristian Duske and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.examples.ecore.diagram.parts;

import org.eclipse.emf.ecoretools.diagram.edit.parts.EcoreEditPartFactory;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.Diagram;

/**
 * EcoreEditPartFactory3D There should really be more documentation here.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 06.12.2008
 */
public class EcoreEditPartFactory3D extends EcoreEditPartFactory {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecoretools.diagram.edit.parts.EcoreEditPartFactory#createEditPart(org.eclipse.gef.EditPart,
	 *      java.lang.Object)
	 */
	@Override
	public EditPart createEditPart(EditPart i_context, Object i_model) {

		if (i_model instanceof Diagram) {
			Diagram diagram = (Diagram) i_model;
			return new DiagramEditPart3D(diagram);
		}

		return super.createEditPart(i_context, i_model);
	}
}
