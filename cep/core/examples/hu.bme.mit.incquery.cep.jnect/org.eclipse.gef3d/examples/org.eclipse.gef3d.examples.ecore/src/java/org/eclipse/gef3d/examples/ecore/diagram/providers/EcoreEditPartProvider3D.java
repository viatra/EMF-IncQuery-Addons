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
package org.eclipse.gef3d.examples.ecore.diagram.providers;

import org.eclipse.emf.ecoretools.diagram.providers.EcoreEditPartProvider;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef3d.examples.ecore.diagram.parts.EcoreEditPartFactory3D;
import org.eclipse.gef3d.gmf.runtime.core.service.ProviderAcceptor;
import org.eclipse.gef3d.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart3D;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.notation.Diagram;

/**
 * EcoreEditPartProvider3D There should really be more documentation here.
 * 
 * @author Kristian Duske
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 05.01.2009
 */
public class EcoreEditPartProvider3D extends EcoreEditPartProvider {

	/**
	 * Creates a new edit part provider for the 3D Ecore editor.
	 */
	public EcoreEditPartProvider3D() {
		super(); // super constructor sets a 2D factory
		// which is here replaced by a 3D version:
		setFactory(new EcoreEditPartFactory3D());
		setAllowCaching(true);
	}

	/**
	 * Returns true if editor is accepts this provider, this is evaluated using
	 * the {@link ProviderAcceptor} retrieved from the operation. The acceptor
	 * must accept 3D providers, i.e.
	 * {@link ProviderAcceptor#evaluate3DAcceptance(org.eclipse.gmf.runtime.common.core.service.IProvider, IOperation)}
	 * must return true.
	 * 
	 * @see org.eclipse.emf.ecoretools.diagram.providers.EcoreEditPartProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
	 */
	@Override
	public synchronized boolean provides(IOperation i_operation) {
		if (i_operation instanceof CreateGraphicEditPartOperation) {
			// ProviderAcceptor providerAcceptor =
			// ProviderAcceptor.retrieveProviderAcceptor(i_operation);
			boolean bIsAccepted =
				ProviderAcceptor.evaluate3DAcceptance(this, i_operation);
			// boolean bIsSupported = isSupported();
			// CreateGraphicEditPartOperation op =
			// (CreateGraphicEditPartOperation) i_operation;

			bIsAccepted &= super.provides(i_operation);

			return bIsAccepted;

		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider#createRootEditPart(org.eclipse.gmf.runtime.notation.Diagram)
	 */
	@Override
	public RootEditPart createRootEditPart(Diagram i_diagram) {

		return new DiagramRootEditPart3D();
	}
}
