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
package org.eclipse.gef3d.ext.reverselookup;

import org.eclipse.gef.EditPart;

/**
 * Interface used by {@link ReverseLookupManager} for looking up notation
 * elements, usually {@link EditPart}s, by their domain model element. In case
 * of {@link EditPart}, this often is the object returned by
 * {@link EditPart#getModel()}, but note that this is not always the case, e.g.,
 * if a notation model is used (such as in case of GMF or UML Diagram
 * Interchange).
 * 
 * These strategies are registered at the reverse lookup manager. If a strategy can
 * handle a given domain element, it returns a value greater then 0.
 * For more details, see {@link ReverseLookupManager}.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Sep 28, 2009
 * @see ReverseLookupManager
 */
public interface ILookupStrategy<NotationType> extends ILookupHelper {

	public NotationType findNotationByDomain(Object domainElement);

}
