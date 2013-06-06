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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.dnd.AbstractTransferDropTargetListener;
import org.eclipse.gef.requests.LocationRequest;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.gef3d.ext.multieditor.IMultiEditor;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.Transfer;

/**
 * Base listener implementation of listeners attached to a multi editor. This
 * base class can be used for listeners handling drag and drop of a multi
 * editor, in which the content or elements visualized (and edited) in the
 * editor are added to the editor by drag and drop gestures.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @version $Revision$
 * @since Jun 11, 2011
 */
public abstract class AbstractDropOnMultiEditorTargetListener extends
		AbstractTransferDropTargetListener {

	/**
	 * The multi editor associated with this listener. The editor is set in the
	 * constructor and must not be change.
	 */
	private IMultiEditor multiEditor;

	/**
	 * Constructs this listener and sets the multi editor, the transfer type,
	 * and the graphical viewer. The viewer is retrieved by calling
	 * {@link IAdaptable#getAdapter(Class)} of the multi editor with type
	 * {@link GraphicalViewer}; all editors derived from {@link GraphicalEditor}
	 * support this adapter type.
	 * 
	 * @param i_multiEditor the multi editor
	 * @param i_xfer the transfer type, must not be null
	 */
	public AbstractDropOnMultiEditorTargetListener(IMultiEditor i_multiEditor,
			Transfer i_xfer) {
		super(
			(GraphicalViewer) i_multiEditor.getAdapter(GraphicalViewer.class),
			i_xfer);
		if (getViewer() == null) {
			throw new NullPointerException(
				"Editor's viewer (retrieved via getAdapter(GraphicalViewer.class)) must not be null.");
		}
		multiEditor = i_multiEditor;
	}

	/**
	 * @return the multiEditor
	 */
	public IMultiEditor getMultiEditor() {
		return multiEditor;
	}

	/**
	 * {@inheritDoc}. Default implementation for multi editor related listeners
	 * is to set the location of the request. Of course, this is only possible
	 * if the request is of type {@link LocationRequest}, as this request
	 * provides a location property.
	 * 
	 * @see org.eclipse.gef.dnd.AbstractTransferDropTargetListener#updateTargetRequest()
	 */
	@Override
	protected void updateTargetRequest() {

		Request request = getTargetRequest();
		if (request instanceof LocationRequest) {
			DropTargetEvent event = getCurrentEvent();
			if (event != null)
				((LocationRequest) request).setLocation(new Point(event.x,
					event.y));
		}
	}

	/**
	 * Returns drag and drop operation type, if event is not accepted, 0 (
	 * {@link DND#DROP_NONE}) is returned.
	 * 
	 * @param i_event
	 * @return
	 */
	protected abstract int acceptEvent(DropTargetEvent i_event);

	/**
	 * Retrieves the event data and set appropriate (target) request properties.
	 * 
	 * @param i_event, must not be null
	 * @return returns true if event data were successfully evaluated
	 */
	protected abstract boolean retrieveEventData(DropTargetEvent i_event);

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.dnd.AbstractTransferDropTargetListener#handleDragOver()
	 */
	@Override
	protected void handleDragOver() {
		DropTargetEvent event = getCurrentEvent();
		if (event != null) {
			event.detail = acceptEvent(event);
		}

		super.handleDragOver();
	}

	/**
	 * {@inheritDoc}.
	 * 
	 * @see org.eclipse.gef.dnd.AbstractTransferDropTargetListener#handleDrop()
	 */
	@Override
	protected void handleDrop() {

		DropTargetEvent event = getCurrentEvent();
		if (event != null) {
			event.detail = acceptEvent(event);
			if (event.detail == DND.DROP_NONE) {
				return;
			}

			if (!retrieveEventData(event)) {
				event.detail = DND.DROP_NONE;
				return;
			}
		}
		try {
			super.handleDrop();
		} catch (Exception ex) {
			// TODO Implement catch block for Exception
			ex.printStackTrace();
		}
	}

}
