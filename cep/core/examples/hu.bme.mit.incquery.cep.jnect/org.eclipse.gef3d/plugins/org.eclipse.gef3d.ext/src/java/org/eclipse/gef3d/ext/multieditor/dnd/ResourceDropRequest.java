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
package org.eclipse.gef3d.ext.multieditor.dnd;

import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.gef3d.ext.multieditor.IMultiEditor;

/**
 * ResourceDropRequest There should really be more documentation here.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @version $Revision$
 * @since Jun 11, 2011
 */
public class ResourceDropRequest extends AbstractDropOnMultiEditorRequest {

	/**
	 * The resources dropped onto the multi editor, get/set via getter/setter.
	 */
	List<IResource> resources;

	/**
	 * @param i_multiEditor
	 */
	public ResourceDropRequest(IMultiEditor i_multiEditor) {
		super(i_multiEditor);
	}

	/**
	 * @return the resources
	 */
	public List<IResource> getResources() {
		return resources;
	}

	/**
	 * Called by {@link ResourceTransferDropTargetListener} when the drop
	 * actually occurred (that is after the mouse button has been released).
	 * 
	 * @param i_resources the resources to set
	 */
	public void setResources(List<IResource> i_resources) {
		resources = i_resources;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("ResourceDropRequest");
		if (getLocation() != null) {
			result.append(" at ").append(getLocation().toString());
		}
		if (resources != null) {
			result.append(" with input ").append(resources.toString());
		} else {
			result.append(" w/o resource information");
		}
		return result.toString();
	}

}
