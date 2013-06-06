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
package org.eclipse.gef3d.examples.uml2.multi.part;

import org.eclipse.gef3d.ext.multieditor.INestableEditor;
import org.eclipse.gef3d.gmf.runtime.diagram.ui.parts.AbstractMultiGMFEditor3D;

/**
 * Multi 3D editor, content is displayed (and edited) using nested editors.
 * This editor actually is independent from UML2, as nested editors are searched
 * via the extension registry. That is, all content can be displayed with this
 * editor if an {@link INestableEditor} is registered for that type of content.
 * However, the multi editor itself has to be registered to some extensions,
 * and this editor here is registered to the uml-diagram extensions.
 * 
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Apr 14, 2009
 */
public class MultiGraphicalEditor3D extends AbstractMultiGMFEditor3D {
	
		
		
}
