package org.eclipse.gef3d.ext.multieditor.emf;

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

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gef3d.ext.multieditor.INestableEditor;

/**
 * {@link INestableEditor} using the same {@link ResourceSet} as its nesting
 * multi editor.
 * <p>
 * {@link #setResourceSet(ResourceSet)} is intended to be called after nested
 * editor has been created but before it was initialized. Usually, it is called
 * in {@link org.eclipse.gef3d.ext.multieditor.AbstractMultiEditor3D}'s
 * <code>configureNestableEditor(INestableEditor)</code> method.
 * </p>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Sep 22, 2009
 * @see org.eclipse.gef3d.ext.multieditor.emf.INestableEditorWithEditingDomain
 */
public interface INestableEditorWithResourceSet extends INestableEditor {

	/**
	 * Sets the given resource set, returns true if this set is actually used
	 * for loading or saving the models.
	 * 
	 * @param resourceSet
	 */
	void setResourceSet(ResourceSet resourceSet);

}
