/*
 * Type:    de.feu.gef3d.samples.multieditor.actions.MEActionBarContributor
 * File:  	MEActionBarContributor.java
 * Project:	de.feu.gef3d.samples.multieditor
 * Date: 	Feb 4, 2008
 * Author: 	Jens von Pilgrim
 * Version:	$Revision$
 * Changed: $Date$ by $Author$ 
 * URL:     $HeadURL$
 *
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.gef3d.examples.graph.editor.performance;

import org.eclipse.gef.ui.actions.ActionBarContributor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.actions.RetargetAction;

/**
 * MEActionBarContributor There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Feb 4, 2008
 * @see $HeadURL$
 */
public class PerformanceActionBarContributor extends ActionBarContributor {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.ui.actions.ActionBarContributor#buildActions()
	 */
	@Override
	protected void buildActions() {
		RetargetAction action = new RetargetAction(PerformanceOrbitCameraAction.ID,
				"Orbit 360°", Action.AS_PUSH_BUTTON);
		addRetargetAction(action);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.ui.actions.ActionBarContributor#declareGlobalActionKeys()
	 */
	@Override
	protected void declareGlobalActionKeys() {
		// TODO implement method MEActionBarContributor.declareGlobalActionKeys

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
		io_ToolBarManager.add(getAction(PerformanceOrbitCameraAction.ID));
	}

}
