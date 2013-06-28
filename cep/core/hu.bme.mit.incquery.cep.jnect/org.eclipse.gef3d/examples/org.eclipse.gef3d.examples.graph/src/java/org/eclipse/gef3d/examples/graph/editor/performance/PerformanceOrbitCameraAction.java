/*
 * Type:    de.feu.gef3d.samples.multieditor.actions.FilterTraceLevelAction
 * File:  	FilterTraceLevelAction.java
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

import java.util.Timer;
import java.util.logging.Logger;

import org.eclipse.draw3d.IScene;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.ui.IWorkbenchPart;

/**
 * FilterTraceLevelAction There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Feb 4, 2008
 * @see $HeadURL$
 */
public class PerformanceOrbitCameraAction extends WorkbenchPartAction {

	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger
			.getLogger(PerformanceOrbitCameraAction.class.getName());

	public static String ID = "org.eclipse.gef3d.performance.PerformanceOrbitCamera";

	Timer timer = new Timer();
	
	/**
	 * @param i_part
	 * @param i_style
	 */
	public PerformanceOrbitCameraAction(IWorkbenchPart i_part, int i_style) {
		super(i_part, AS_PUSH_BUTTON);
		setId(ID);
//		this.setChecked(false);

	}

	/**
	 * @param i_part
	 */
	public PerformanceOrbitCameraAction(IWorkbenchPart i_part) {
		super(i_part);
		setId(ID);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#calculateEnabled()
	 */
	@Override
	protected boolean calculateEnabled() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		GraphicalViewer viewer = getEditPartViewer();
		if (viewer instanceof IScene) {
			IScene scene = (IScene) viewer;
			Camera360DegreeOrbit orbiter = new Camera360DegreeOrbit(scene);

			
			timer.schedule(orbiter, 1, 1);


		}
		
		
	}

	
	protected GraphicalViewer getEditPartViewer() {
		return (GraphicalViewer) getWorkbenchPart().getAdapter(
				GraphicalViewer.class);
	}

}
