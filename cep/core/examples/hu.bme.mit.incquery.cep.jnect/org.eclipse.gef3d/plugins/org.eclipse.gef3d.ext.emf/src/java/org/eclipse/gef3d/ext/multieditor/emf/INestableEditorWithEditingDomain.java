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
package org.eclipse.gef3d.ext.multieditor.emf;

import org.eclipse.gef3d.ext.multieditor.INestableEditor;

/**
 * {@link INestableEditor} using the same
 * {@link org.eclipse.emf.edit.domain.EditingDomain} as its nesting multi
 * editor.
 * <p>
 * {@link #setEditingDomainID(String)} is intended to be called after nested
 * editor has been created but before it was initialized. Usually, it is called
 * in {@link org.eclipse.gef3d.ext.multieditor.AbstractMultiEditor3D}'s
 * <code>configureNestableEditor(INestableEditor)</code> method.
 * </p>
 * <p>
 * The
 * {@link org.eclipse.gef3d.gmf.runtime.diagram.ui.parts.AbstractMultiGMFEditor3D}
 * uses a default domain id "org.eclipse.gef3d.ext.multieditor", see
 * {@link org.eclipse.gef3d.gmf.runtime.diagram.ui.parts.AbstractMultiGMFEditor3D@getDomainID}.
 * Its plugin also registers a factory for automatically creating a domain
 * for that id.
 * </p>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Sep 22, 2009
 */
public interface INestableEditorWithEditingDomain extends INestableEditor {

	/**
	 * Sets the editing domain ID used by GMF editors to retrieve a shared
	 * editing domain. In case of GMF, a shared editing domain is necessary in
	 * order to share the same resource set in all nested editors. In GMF's
	 * <code>DiagramDocumentEditor#createEditingDomain()</code>, a new editing
	 * domain is created on the fly. However, this also happens in
	 * <code>DiagramDocumentEditor#doSetInput(org.eclipse.ui.IEditorInput, boolean)</code>
	 * -- in that case the document provider creates the domain in
	 * {@link EcoreDocumentProvider#createEditingDomain()} (the latter is
	 * private, so no chance for overriding it).
	 * <p>
	 * Unfortunately it is often not that simple to let a GMF based editor use
	 * an externally defined editing domain.
	 * </p>
	 * <p>
	 * <em>Important:</em>: Ensure to override
	 * <code>DiagramDocumentEditor#getEditingDomainID()</code> , as this default
	 * implementation simply returns null
	 * </p>
	 * 
	 * @param i_editingDomainID
	 * @return true, if domain id is actually used
	 * @see http://bugs.eclipse.org/189974
	 * @see org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor
	 */
	public void setEditingDomainID(String i_editingDomainID);

}
