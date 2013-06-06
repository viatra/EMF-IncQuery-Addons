/*******************************************************************************
 * Copyright (c) 2009 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim, Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.examples.uml2.clazz.providers;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.gef.RootEditPart;
import org.eclipse.gef3d.examples.uml2.clazz.edit.parts.UMLEditPartFactory3D;
import org.eclipse.gef3d.examples.uml2.clazz.part.UMLClassDiagramEditor3D;
import org.eclipse.gef3d.examples.uml2.usecase.part.UMLUseCaseDiagramEditor3D;
import org.eclipse.gef3d.gmf.runtime.core.service.ProviderAcceptor;
import org.eclipse.gef3d.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart3D;
import org.eclipse.gef3d.gmf.runtime.diagram.ui.services.editpart.DiagramRootEditPart3DProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.uml2.diagram.clazz.providers.UMLEditPartProvider;

/**
 * This provider uses an {@link UMLEditPartFactory3D}, it is installed in
 * <i>plugin.xml</i> at extension point
 * "org.eclipse.gmf.runtime.diagram.ui.editpartProviders".
 * 
 * @author Jens von Pilgrim
 * @author Kristian Duske
 * @version $Revision$
 * @since Apr 7, 2009
 */
public class UMLClassEditPartProvider3D extends UMLEditPartProvider {

	// public static String[] SUPPORTED_EDITORS =
	// { UMLClassDiagramEditor3D.class.getName() };

	/**
	 * Logger for this class
	 */
	private static final Logger log =
		Logger.getLogger(UMLClassEditPartProvider3D.class.getName());

	/**
	 * 
	 */
	public UMLClassEditPartProvider3D() {
		super(); // sets 2D factory

		setFactory(new UMLEditPartFactory3D());
		setAllowCaching(false);
	}

	/**
	 * Returns true if editor is accepts this provider, this is evaluated using
	 * the {@link ProviderAcceptor} retrieved from the operation. The acceptor
	 * must accept 3D providers, i.e.
	 * {@link ProviderAcceptor#evaluate3DAcceptance(org.eclipse.gmf.runtime.common.core.service.IProvider, IOperation)}
	 * must return true.
	 * 
	 * @see org.eclipse.uml2.diagram.clazz.providers.UMLEditPartProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
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

			// if (bIsAccepted!=bIsSupported) {
			// if (log.isLoggable(Level.INFO)) {
			// log.info("Warning, isSupported = " + bIsSupported +
			// ", acceptor says " + bIsAccepted +
			// ", acceptor: " + providerAcceptor +
			// ", model: " + op.getView().getElement()
			//							); //$NON-NLS-1$
			// }
			// }

			return bIsAccepted;

		}
		return false;
	}

	/**
	 * Returns null as the root edit part is expected to be created by a
	 * different provider in case of 3D, i.e. by {@link
	 * DiagramRootEditPart3DProvider.}
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider#createRootEditPart(org.eclipse.gmf.runtime.notation.Diagram)
	 */
	@Override
	public RootEditPart createRootEditPart(Diagram i_diagram) {
		if (log.isLoggable(Level.INFO)) {
			log.info("I don't want to create a root"); //$NON-NLS-1$
		}

		return null;
	}

}
