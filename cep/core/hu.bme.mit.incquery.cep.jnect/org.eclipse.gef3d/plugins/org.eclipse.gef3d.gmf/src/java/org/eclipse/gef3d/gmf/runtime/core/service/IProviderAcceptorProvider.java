/*******************************************************************************
 * Copyright (c) 2009 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.gmf.runtime.core.service;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.parts.GraphicalEditor;

/**
 * Interface for classes which provide a {@link ProviderAcceptor}. This
 * interface is used by static retrieve methods in {@link ProviderAcceptor} and
 * is usually implemented by {@link EditPartViewer}s or {@link GraphicalEditor}
 * s.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since May 26, 2009
 */
public interface IProviderAcceptorProvider {

	/**
	 * Returns the provider acceptor.
	 * 
	 * @return
	 */
	ProviderAcceptor getProviderAcceptor();
}
