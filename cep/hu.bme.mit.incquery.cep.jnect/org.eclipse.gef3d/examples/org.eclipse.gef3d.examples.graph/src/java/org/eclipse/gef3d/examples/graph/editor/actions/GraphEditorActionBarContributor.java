/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.examples.graph.editor.actions;

import java.util.List;

import org.eclipse.draw3d.Export3DOperation;
import org.eclipse.draw3d.graphics3d.Graphics3DDescriptor;
import org.eclipse.draw3d.graphics3d.Graphics3DRegistry;
import org.eclipse.draw3d.graphics3d.Graphics3DType;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.ui.actions.ActionBarContributor;
import org.eclipse.gef.ui.actions.ZoomComboContributionItem;
import org.eclipse.gef.ui.actions.ZoomInRetargetAction;
import org.eclipse.gef.ui.actions.ZoomOutRetargetAction;
import org.eclipse.gef3d.examples.graph.editor.performance.PerformanceOrbitCameraAction;
import org.eclipse.gef3d.ui.actions.Export3DAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.actions.RetargetAction;

/**
 * GraphEditorActionBarContributor There should really be more documentation
 * here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Feb 7, 2008
 */
public class GraphEditorActionBarContributor extends ActionBarContributor {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.ui.actions.ActionBarContributor#buildActions()
	 */
	@Override
	protected void buildActions() {
		RetargetAction action = new RetargetAction(RandomArrangeAction.ID,
				"Arrange Randomly", Action.AS_PUSH_BUTTON);
		addRetargetAction(action);

		action = new RetargetAction(PerformanceOrbitCameraAction.ID,
				"Orbit 360°", Action.AS_PUSH_BUTTON);
		addRetargetAction(action);

		for (Graphics3DDescriptor descr : Graphics3DRegistry
				.getRenderersForType(Graphics3DType.EXPORT)) {
			action = new RetargetAction(Export3DAction.actionID(descr
					.getRendererID()), descr.getName() + " Export",
					Action.AS_PUSH_BUTTON);
			addRetargetAction(action);
		}

		// addRetargetAction(new ZoomInRetargetAction());
		// addRetargetAction(new ZoomOutRetargetAction());

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.ui.actions.ActionBarContributor#declareGlobalActionKeys()
	 */
	@Override
	protected void declareGlobalActionKeys() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.EditorActionBarContributor#contributeToToolBar(org.eclipse.jface.action.IToolBarManager)
	 */
	@Override
	public void contributeToToolBar(IToolBarManager io_ToolBarManager) {
		super.contributeToToolBar(io_ToolBarManager);
		io_ToolBarManager.add(new Separator());
		io_ToolBarManager.add(getAction(RandomArrangeAction.ID));
		io_ToolBarManager.add(getAction(PerformanceOrbitCameraAction.ID));

		for (Graphics3DDescriptor descr : Graphics3DRegistry
				.getRenderersForType(Graphics3DType.EXPORT)) {
			
			io_ToolBarManager.add(getAction(Export3DAction.actionID(descr
					.getRendererID())));
		}
		

		io_ToolBarManager.add(new Separator());
		//
		// String[] astrZoomStrings = new String[] { ZoomManager.FIT_ALL,
		// ZoomManager.FIT_HEIGHT, ZoomManager.FIT_WIDTH };
		//
		// io_ToolBarManager.add(new ZoomComboContributionItem(
		//
		// getPage(), astrZoomStrings));
	}
}
