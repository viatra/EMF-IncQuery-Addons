/*******************************************************************************
 * Copyright (c) 2010 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.gmf.runtime.diagram.ui.parts;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef3d.ext.multieditor.AbstractMultiEditor3D;
import org.eclipse.gef3d.ext.multieditor.INestableEditor;
import org.eclipse.gef3d.ext.multieditor.emf.INestableEditorWithEditingDomain;
import org.eclipse.gef3d.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart3D;
import org.eclipse.gef3d.ui.parts.GraphicalViewer3D;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeTypes;

/**
 * Abstract multi editor for EMF/GMF based diagrams (i.e., nested GMF editors),
 * provides an editing domain. Actually, this editor is feature complete and can
 * directly be used as an editor. However, it is defined abstract, as it is not
 * registered via extension points to any file type. You will have to extend
 * this class and register your own editor to the extension point, e.g.,
 * <code><pre>
 * &lt;extension point="org.eclipse.ui.editors">
 *       &lt;editor
 *          class="org.eclipse.gef3d.examples.uml2.multi.part.MultiGraphicalEditor3D"
 *          default="false"
 *          extensions="umlclass,umlusc,umlact"
 *          id="org.eclipse.gef3d.examples.uml2.multi.part.MultiGraphicalEditor3D"
 *          name="Multi Editor 3D">
 *       &lt;/editor>
 * &lt;/extension>
 * </pre></code> This snippet is taken from the UML3D example, the class defined
 * there simply extends this class and is empty.
 * <p>
 * You may override the {@link #acceptsInput(org.eclipse.ui.IEditorInput)}
 * method, which by default accepts all input for which a nestable editor can be
 * retrieved, see
 * {@link AbstractMultiEditor3D#acceptsInput(org.eclipse.ui.IEditorInput)}.
 * </p>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since May 5, 2010
 */
public abstract class AbstractMultiGMFEditor3D extends AbstractMultiEditor3D {

	/**
	 * Default transactional editing domain id. This string is returned in
	 * {@link #getEditingDomainID()} by default, a factory of type
	 * |@link org.eclipse.gmf.runtime.diagram.core.DiagramEditingDomainFactory}
	 * for that id is
	 * registered to the plugin registry (see plugin.xml). 
	 */
	public static final String DEFAULT_MULTI_EDITOR_DOMAIN_ID = "org.eclipse.gef3d.ext.multieditor";
	
	/**
	 * Lazily created in {@link #createEditingDomainProvider()}, passed to
	 * clients via {@link #getAdapter(Class)}, class is
	 * {@link IEditingDomainProvider}.
	 */
	protected IEditingDomainProvider domainProvider;

	/**
	 * 
	 */
	public AbstractMultiGMFEditor3D() {
		// GMF specific:
		MapModeTypes.DEFAULT_MM = MapModeTypes.IDENTITY_MM;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.multieditor.AbstractMultiEditor3D#createRootEditPart()
	 */
	@Override
	protected RootEditPart createRootEditPart() {
		return new DiagramRootEditPart3D();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ui.parts.GraphicalEditor3DWithFlyoutPalette#doCreateGraphicalViewer()
	 */
	@Override
	protected GraphicalViewer3D doCreateGraphicalViewer() {
		return new DiagramGraphicalViewer3D();
	}

	/**
	 * {@inheritDoc} Supports the following types:
	 * <ul>
	 * <li>{@link IEditingDomainProvider} -- returns domain provider of this
	 * editor</li>
	 * </ul>
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette#getAdapter(java.lang.Class)
	 */
	@Override
	public Object getAdapter(Class type) {

		if (type == IEditingDomainProvider.class) {
			if (domainProvider == null)
				domainProvider = createEditingDomainProvider();
			return domainProvider;
		}

		return super.getAdapter(type);
	}

	/**
	 * Subclassses may override.
	 * 
	 * @return
	 * @see #getAdapter(Class)
	 */
	protected IEditingDomainProvider createEditingDomainProvider() {
		return new IEditingDomainProvider() {
			public EditingDomain getEditingDomain() {
				return AbstractMultiGMFEditor3D.this.getEditingDomain();
			}
		};
	}

	/**
	 * Returns the {@link TransactionalEditingDomain} previously created in
	 * {@link #createResourceSet()} and registered at
	 * {@link TransactionalEditingDomain.Registry} using id
	 * {@link #getEditingDomainID()}.
	 * 
	 * @return
	 */
	public TransactionalEditingDomain getEditingDomain() {
		return TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain(getEditingDomainID());
	}

	/**
	 * Returns default editing domain ID {@link #DEFAULT_MULTI_EDITOR_DOMAIN_ID}
	 * passed to nested editors in
	 * {@link #configureNestableEditor(INestableEditor)}. A factory for
	 * creating a domain for that id is registered via extension point
	 * "org.eclipse.emf.transaction.editingDomains".
	 * <p>
	 * Subclasses may override this method in order to provide a different
	 * domain id. In that case, ensure to add a factory to your plugin.xml:
	 * <code><pre>
	 * &lt;extension point="org.eclipse.emf.transaction.editingDomains">
	 * 	&lt;editingDomain id="my.domain.id" factory="my.domain.Factory"/>
	 * &lt;/extension>
	 * </pre></code>
	 * @return {@value #DEFAULT_MULTI_EDITOR_DOMAIN_ID}
	 */
	public String getEditingDomainID() {
		return AbstractMultiGMFEditor3D.DEFAULT_MULTI_EDITOR_DOMAIN_ID;
	}

	/**
	 * Configures nested editor right after it has been created and right before
	 * it is initialized. If nested editor is of type
	 * {@link INestableEditorWithEditingDomain} , the editing domain id (
	 * {@link #getEditingDomainID()}) is passed to the nested editor.
	 */
	@Override
	protected void configureNestableEditor(INestableEditor nestedEditor) {
		if (nestedEditor instanceof INestableEditorWithEditingDomain) {
			((INestableEditorWithEditingDomain) nestedEditor)
				.setEditingDomainID(getEditingDomainID());
		}
	}

}
