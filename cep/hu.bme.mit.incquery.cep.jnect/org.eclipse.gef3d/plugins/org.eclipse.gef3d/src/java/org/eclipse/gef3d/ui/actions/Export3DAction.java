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
package org.eclipse.gef3d.ui.actions;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw3d.Export3DOperation;
import org.eclipse.draw3d.Figure3DHelper;
import org.eclipse.draw3d.IFigure3D;
import org.eclipse.draw3d.graphics3d.Graphics3DDescriptor;
import org.eclipse.draw3d.graphics3d.Graphics3DRegistry;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.gef3d.ui.parts.GraphicalViewer3DImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IWorkbenchPart;

/**
 * This action exports a 3D diagram using a defined renderer. The action only
 * prepares an operation which does the export.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Feb 7, 2008
 */
public class Export3DAction extends WorkbenchPartAction {

	public final static String ID = Export3DAction.class.getName();

	public String rendererID = null;

	public final static String actionID(String rendererID) {
		return ID + "_" + rendererID;
	}

	/**
	 * @param i_part
	 * @param i_rendererID renderer id, must not be null
	 */
	public Export3DAction(IWorkbenchPart i_part, String i_rendererID) {
		super(i_part);

		if (i_rendererID == null) // parameter precondition
			throw new NullPointerException("rendererID must not be null");

		this.rendererID = i_rendererID;
		setId(actionID(rendererID));
		init(); // now rendererID is set
	}

	/**
	 * @see org.eclipse.gef.ui.actions.EditorPartAction#init()
	 */
	protected void init() {
		if (rendererID != null) {
			// super.init();

			Graphics3DDescriptor descr = Graphics3DRegistry
					.getRenderer(rendererID);
			if (descr != null) {
				setText("Export " + descr.getName());
				setToolTipText(descr.getDescription());
				setId(getId());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#calculateEnabled()
	 */
	@Override
	protected boolean calculateEnabled() {
		return Graphics3DRegistry.getRenderer(rendererID) != null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {

		// Get the export file.

		FileDialog fd = new FileDialog(getWorkbenchPart().getSite().getShell(),
				SWT.SAVE);
		fd.setText("Export");
		String strExportFile = fd.open();

		if (strExportFile != null) {
			GraphicalViewer viewer = getEditPartViewer();
			LayerManager lm = (LayerManager)viewer.getEditPartRegistry().get(LayerManager.ID);
	    	IFigure figure = lm.getLayer(LayerConstants.PRINTABLE_LAYERS);
	    	IFigure3D fig3D;
	    	if (figure instanceof IFigure3D) {
	    		fig3D = (IFigure3D) figure;
	    	} else {
	    		fig3D = Figure3DHelper.getAncestor3D(figure);
	    	}
			
			Export3DOperation operation = new Export3DOperation(strExportFile,
					rendererID, fig3D);
//			IFigure3D) gv.getLightweightSystem3D()
//							.getRootFigure());

			operation.run();
		}

	}

	protected GraphicalViewer getEditPartViewer() {
		return (GraphicalViewer) getWorkbenchPart().getAdapter(
				GraphicalViewer.class);
	}

}
