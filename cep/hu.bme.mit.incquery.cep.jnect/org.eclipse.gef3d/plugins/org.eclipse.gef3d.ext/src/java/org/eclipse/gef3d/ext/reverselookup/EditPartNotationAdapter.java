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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.NodeEditPart;

/**
 * Simple edit part adapter, returning {@link EditPart#getModel()} and
 * {@link EditPart#getChildren()} + {@link NodeEditPart#getSourceConnections()}.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since May 23, 2009
 */
public class EditPartNotationAdapter implements INotationAdapter<EditPart> {

	/**
	 * The singleton instance. Since object is stateless, we can safely use the
	 * singleton pattern.
	 */
	public final static EditPartNotationAdapter INSTANCE =
		new EditPartNotationAdapter();

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.reverselookup.INotationAdapter#getDomainObject(java.lang.Object)
	 */
	public Object getDomainObject(EditPart notationElement) {
		return notationElement.getModel();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.reverselookup.INotationAdapter#getNotationChildren(java.lang.Object)
	 */
	public List<EditPart> getNotationChildren(EditPart notationElement) {
		List<EditPart> children;
		if (notationElement instanceof NodeEditPart) {
			NodeEditPart nodeEditPart = (NodeEditPart) notationElement;
			children =
				new ArrayList(nodeEditPart.getChildren().size()
					+ nodeEditPart.getSourceConnections().size());
			children.addAll(nodeEditPart.getChildren());
			children.addAll(nodeEditPart.getSourceConnections());
		} else {
			children = new ArrayList(notationElement.getChildren().size());
			children.addAll(notationElement.getChildren());
		}
		return children;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.reverselookup.ILookupHelper#handlesElement(java.lang.Object)
	 */
	public int handlesElement(Object i_modelElement) {
		return (i_modelElement instanceof EditPart) ? 1 : 0;
	}

}
