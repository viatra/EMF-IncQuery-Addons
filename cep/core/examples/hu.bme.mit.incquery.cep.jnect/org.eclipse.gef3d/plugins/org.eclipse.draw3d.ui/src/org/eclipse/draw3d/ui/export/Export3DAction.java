/*******************************************************************************
 * Copyright (c) 2009 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 *    Kristian Duske - moved to draw3d.ui and removed GEF dependencies
 ******************************************************************************/
package org.eclipse.draw3d.ui.export;

import org.eclipse.draw3d.Export3DOperation;
import org.eclipse.draw3d.IFigure3D;
import org.eclipse.draw3d.graphics3d.Graphics3DDescriptor;
import org.eclipse.draw3d.graphics3d.Graphics3DRegistry;
import org.eclipse.draw3d.ui.Draw3DUIPlugin;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

/**
 * This action exports a 3D diagram using a defined renderer. The action only
 * prepares an operation which does the export.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Feb 7, 2008
 */
public class Export3DAction extends Action {

	/**
	 * The base ID.
	 */
	public final static String ID = Export3DAction.class.getName();

	/**
	 * Returns the ID of this action.
	 * 
	 * @param rendererID
	 *            the current render ID
	 * @return the ID of this action
	 */
	public final static String actionID(String rendererID) {
		return ID + "_" + rendererID;
	}

	private Export3DFigureProvider m_provider;
	/**
	 * The renderer ID.
	 */
	private final String m_rendererId;

	/**
	 * Creates a new action that uses the renderer with the specified ID and the
	 * specified root figure provider.
	 * 
	 * @param i_rendererId
	 *            renderer id, must not be null
	 * @param i_provider
	 *            the provider for the root figure
	 */
	public Export3DAction(String i_rendererId,
			Export3DFigureProvider i_provider) {

		if (i_rendererId == null)
			throw new NullPointerException("i_rendererId must not be null");

		if (i_provider == null)
			throw new NullPointerException("i_provider must not be null");

		this.m_rendererId = i_rendererId;
		m_provider = i_provider;

		setId(actionID(m_rendererId));
		init();
	}
	
	/**
	 * Returns the export renderer ID.
	 * 
	 * @return the ID
	 */
	public String getRendererId() {

		return m_rendererId;
	}

	/**
	 * Initializes this action.
	 */
	protected void init() {

		if (m_rendererId != null) {
			Graphics3DDescriptor descr = Graphics3DRegistry
					.getRenderer(m_rendererId);

			if (descr != null) {
				setText("Export " + descr.getName());
				setToolTipText(descr.getDescription());
				setId(getId());
			} else {
				setEnabled(false);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {

		Shell shell = Draw3DUIPlugin.getDefault().getWorkbench()
				.getActiveWorkbenchWindow().getShell();

		FileDialog fd = new FileDialog(shell, SWT.SAVE);
		fd.setText("Export");
		String strExportFile = fd.open();

		if (strExportFile != null) {
			IFigure3D figure = m_provider.getFigure();

			Export3DOperation operation = new Export3DOperation(strExportFile,
					m_rendererId, figure);

			operation.run();
		}
	}
}
