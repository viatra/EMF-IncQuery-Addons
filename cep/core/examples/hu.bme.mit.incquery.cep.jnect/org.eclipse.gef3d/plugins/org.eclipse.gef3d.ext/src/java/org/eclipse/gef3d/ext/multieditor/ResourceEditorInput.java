/*******************************************************************************
 * Copyright (c) 2011 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.ext.multieditor;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.model.IWorkbenchAdapter;
import org.eclipse.ui.part.FileEditorInput;

/**
 * Adapter for making an {@link IResource} a suitable input for an editor. This
 * class is very similiar to {@link FileEditorInput}, except that a resource is
 * used instead of a file.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @version $Revision$
 * @since Jun 11, 2011
 * @see http://blog.eclipse-tips.com/2008/06/opening-editor-without-ifile.html
 */
public class ResourceEditorInput implements IEditorInput {

	/**
	 * Immutable resource property, set in constructor.
	 */
	private IResource resource;

	/**
	 * @param i_resource must not be null
	 */
	public ResourceEditorInput(IResource i_resource) {
		if (i_resource == null) // parameter precondition
			throw new NullPointerException("i_resource must not be null");

		resource = i_resource;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return resource.hashCode();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object i_obj) {
		if (this == i_obj) {
			return true;
		}
		if (!(i_obj instanceof ResourceEditorInput)) {
			return false;
		}
		ResourceEditorInput other = (ResourceEditorInput) i_obj;
		return resource.equals(other.getResource());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IEditorInput#exists()
	 */
	public boolean exists() {
		return resource.exists();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IEditorInput#getImageDescriptor()
	 */
	public ImageDescriptor getImageDescriptor() {

		ImageDescriptor imageDescriptor =
			(ImageDescriptor) resource.getAdapter(ImageDescriptor.class);
		if (imageDescriptor == null)
			ImageDescriptor.getMissingImageDescriptor();
		return imageDescriptor;
		// TODO return real image descriptor
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IEditorInput#getName()
	 */
	public String getName() {
		return resource.getName();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IEditorInput#getPersistable()
	 */
	public IPersistableElement getPersistable() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IEditorInput#getToolTipText()
	 */
	public String getToolTipText() {
		return resource.getFullPath().makeRelative().toString();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	public Object getAdapter(Class i_adapter) {
		if (IWorkbenchAdapter.class.equals(i_adapter)) {
			return new IWorkbenchAdapter() {

				public Object[] getChildren(Object o) {
					return new Object[0];
				}

				public ImageDescriptor getImageDescriptor(Object object) {
					return ResourceEditorInput.this.getImageDescriptor();
				}

				public String getLabel(Object o) {
					return ResourceEditorInput.this.getName();
				}

				public Object getParent(Object o) {
					return ResourceEditorInput.this.getResource().getParent();
				}
			};
		}

		return null;
	}

	/**
	 * Getter for the resource.
	 * 
	 * @return the resource, does never return null.
	 */
	public IResource getResource() {
		return resource;
	}

}
