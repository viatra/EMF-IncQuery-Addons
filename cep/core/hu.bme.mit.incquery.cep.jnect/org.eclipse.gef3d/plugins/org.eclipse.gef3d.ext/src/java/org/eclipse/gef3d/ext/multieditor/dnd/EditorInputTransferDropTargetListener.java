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
package org.eclipse.gef3d.ext.multieditor.dnd;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.Request;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.gef3d.ext.multieditor.IMultiEditor;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.EditorInputTransfer;
import org.eclipse.ui.part.EditorInputTransfer.EditorInputData;

/**
 * Drop target listener to be used by a multi editor to enable opening new
 * diagrams (or models) in the editor by simply dropping the editor input onto
 * the 3D scene. This listener is to be added to the viewer during
 * configuration, i.e. in {@link GraphicalEditor#configureGraphicalViewer()}
 * just like that:
 * <p>
 * <code><pre>
 * getGraphicalViewer().addDropTargetListener(
 * 		new EditorInputTransferDropTargetListener(this));
 * </pre></code>
 * </p>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Apr 15, 2009
 * @see ResourceTransferDropTargetListener
 */
public class EditorInputTransferDropTargetListener extends
		AbstractDropOnMultiEditorTargetListener {

	/**
	 * @param i_multiEditor, viewer is retrieved via
	 *            {@link IAdaptable#getAdapter(Class)}
	 */
	public EditorInputTransferDropTargetListener(IMultiEditor i_multiEditor) {
		super(i_multiEditor, EditorInputTransfer.getInstance());
	}

	/**
	 * {@inheritDoc}. Creates an {@link EditorInputDropRequest} and sets
	 * location of event if possible.
	 * 
	 * @see org.eclipse.gef.dnd.AbstractTransferDropTargetListener#createTargetRequest()
	 */
	@Override
	protected Request createTargetRequest() {
		EditorInputDropRequest request =
			new EditorInputDropRequest(getMultiEditor());
		DropTargetEvent event = getCurrentEvent();
		if (event != null) {
			request.setLocation(new Point(event.x, event.y));
		}
		return request;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.multieditor.dnd.AbstractDropOnMultiEditorTargetListener#acceptEvent(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	protected int acceptEvent(DropTargetEvent i_event) {

		if (i_event.data instanceof EditorInputTransfer.EditorInputData[]) {
			EditorInputTransfer.EditorInputData[] editorInputsData =
				(EditorInputData[]) i_event.data;

			for (EditorInputTransfer.EditorInputData data : editorInputsData)
				if (!getMultiEditor().acceptsInput(data.input)) {
					return DND.DROP_NONE;
				} else {
					return DND.DROP_COPY;
				}
		}

		if (EditorInputTransfer.getInstance().isSupportedType(
			i_event.currentDataType)) {
			return DND.DROP_COPY;
		} else {
			return DND.DROP_NONE;
		}

	}

	/**
	 * {@inheritDoc}.
	 * <p>
	 * Returns true if at least one editor input could be retrieved from the
	 * given event.
	 * 
	 * @see org.eclipse.gef3d.ext.multieditor.dnd.AbstractDropOnMultiEditorTargetListener#retrieveEventData(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	protected boolean retrieveEventData(DropTargetEvent i_event) {
		EditorInputDropRequest request =
			(EditorInputDropRequest) getTargetRequest();

		List<IEditorInput> editorInputs = null;

		if (i_event.data instanceof EditorInputTransfer.EditorInputData[]) {
			editorInputs = new ArrayList<IEditorInput>();
			EditorInputTransfer.EditorInputData[] editorInputsData =
				(EditorInputData[]) i_event.data;
			for (EditorInputTransfer.EditorInputData data : editorInputsData) {
				editorInputs.add(data.input);

			}
		}

		if (editorInputs == null || editorInputs.isEmpty()) {
			return false;
		}

		request.setEditorInputs(editorInputs);
		return true;

	}

}
