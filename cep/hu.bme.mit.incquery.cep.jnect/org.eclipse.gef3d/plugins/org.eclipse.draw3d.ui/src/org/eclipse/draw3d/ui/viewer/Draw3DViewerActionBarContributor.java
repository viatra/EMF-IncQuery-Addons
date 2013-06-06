/*******************************************************************************
 * Copyright (c) 2009 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.ui.viewer;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.draw3d.graphics3d.Graphics3DDescriptor;
import org.eclipse.draw3d.graphics3d.Graphics3DRegistry;
import org.eclipse.draw3d.graphics3d.Graphics3DType;
import org.eclipse.draw3d.ui.export.Export3DAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.actions.LabelRetargetAction;
import org.eclipse.ui.actions.RetargetAction;
import org.eclipse.ui.part.EditorActionBarContributor;

/**
 * Contributes the export action.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 09.06.2009
 */
public class Draw3DViewerActionBarContributor extends
		EditorActionBarContributor {

	private Collection<RetargetAction> m_retargetActions = new HashSet<RetargetAction>();

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.EditorActionBarContributor#setActiveEditor(org.eclipse.ui.IEditorPart)
	 */
	@Override
	public void setActiveEditor(IEditorPart i_targetEditor) {

		if (i_targetEditor instanceof Draw3DViewer) {
			Draw3DViewer viewer = (Draw3DViewer) i_targetEditor;
			Collection<Export3DAction> actions = viewer.getExportActions();

			for (Export3DAction action : actions)
				getActionBars().setGlobalActionHandler(action.getId(), action);
		} else
			getActionBars().clearGlobalActionHandlers();

		for (RetargetAction action : m_retargetActions)
			action.setEnabled(i_targetEditor instanceof Draw3DViewer);

		getActionBars().updateActionBars();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.EditorActionBarContributor#init(org.eclipse.ui.IActionBars,
	 *      org.eclipse.ui.IWorkbenchPage)
	 */
	@Override
	public void init(IActionBars i_bars, IWorkbenchPage i_page) {

		for (Graphics3DDescriptor descr : Graphics3DRegistry
				.getRenderersForType(Graphics3DType.EXPORT)) {

			String actionId = Export3DAction.actionID(descr.getRendererID());
			LabelRetargetAction action = new LabelRetargetAction(actionId,
					descr.getDescription());

			m_retargetActions.add(action);
			i_page.addPartListener(action);
		}

		super.init(i_bars, i_page);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.EditorActionBarContributor#dispose()
	 */
	@Override
	public void dispose() {

		for (RetargetAction action : m_retargetActions)
			getPage().removePartListener(action);

		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.EditorActionBarContributor#contributeToToolBar(org.eclipse.jface.action.IToolBarManager)
	 */
	@Override
	public void contributeToToolBar(IToolBarManager i_toolBarManager) {

		for (RetargetAction action : m_retargetActions)
			i_toolBarManager.add(action);
	}
}
