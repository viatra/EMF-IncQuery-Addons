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
package org.eclipse.gef3d.gmf.runtime.diagram.ui.services.editpart;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.eclipse.gef.RootEditPart;
import org.eclipse.gef3d.gmf.runtime.core.service.ProviderAcceptor;
import org.eclipse.gef3d.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart3D;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateRootEditPartOperation;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

/**
 * Provider creating only a root edit part, i.e. a {@link DiagramRootEditPart3D}.
 * It is registered with priority MEDIUM. It is using the {@link ProviderAcceptor}
 * in order to evaluate whether it has to provide anything.
 * 
 * @author Jens von Pilgrim
 * @author Kristian Duske
 * @version $Revision$
 * @since Apr 7, 2009
 */
public class DiagramRootEditPart3DProvider extends AbstractEditPartProvider {

	/**
	 * Logger for this class
	 */
	private static final Logger log =
		Logger.getLogger(DiagramRootEditPart3DProvider.class.getName());
	
	

	/**
	 * 
	 */
	public DiagramRootEditPart3DProvider() {
		if (log.isLoggable(Level.INFO)) {
			log.info("Created"); //$NON-NLS-1$
		}
	}
	
	/**
	 * Returns true if operation is {@link CreateRootEditPartOperation} and
	 * if {@link ProviderAcceptor#evaluate3DAcceptance(org.eclipse.gmf.runtime.common.core.service.IProvider, IOperation)}
	 * return true.
	 * 
	 * @see org.eclipse.uml2.diagram.clazz.providers.UMLEditPartProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
	 */
	@Override
	public synchronized boolean provides(IOperation i_operation) {
		if (i_operation instanceof CreateRootEditPartOperation) {
			boolean isAccepted = ProviderAcceptor.evaluate3DAcceptance(this, i_operation);
			return isAccepted;
		}
		return false;
	}
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider#getDiagramEditPartClass(org.eclipse.gmf.runtime.notation.View)
	 */
	@Override
	protected Class getDiagramEditPartClass(View i_view) {
		return null;
	}

	/**
	 * Returns a {@link DiagramRootEditPart3D}.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider#createRootEditPart(org.eclipse.gmf.runtime.notation.Diagram)
	 */
	@Override
	public RootEditPart createRootEditPart(Diagram i_diagram) {
		if (log.isLoggable(Level.INFO)) {
			log.info("Create Root!"); //$NON-NLS-1$
		}

		return new DiagramRootEditPart3D();
	}

}
