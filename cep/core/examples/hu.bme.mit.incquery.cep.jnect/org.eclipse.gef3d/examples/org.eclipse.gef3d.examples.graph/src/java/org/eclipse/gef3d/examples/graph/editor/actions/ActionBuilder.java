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

import org.eclipse.draw3d.graphics3d.Graphics3DDescriptor;
import org.eclipse.draw3d.graphics3d.Graphics3DRegistry;
import org.eclipse.draw3d.graphics3d.Graphics3DType;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef3d.examples.graph.editor.GraphEditor3D;
import org.eclipse.gef3d.examples.graph.editor.performance.PerformanceOrbitCameraAction;
import org.eclipse.gef3d.ui.actions.Export3DAction;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.RetargetAction;

/**
 * ActionBuilder used in GraphEditor2D and GraphEditor3D to build actions.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Feb 7, 2008
 * @see GraphEditor3D#createActions
 */
public class ActionBuilder {

	/**
	 * @param registry
	 */
	public static void buildActions(ActionRegistry registry,
			IWorkbenchPart editor) {
		registry.registerAction(new RandomArrangeAction(editor));
		registry.registerAction(new PerformanceOrbitCameraAction(editor));

		for (Graphics3DDescriptor descr : Graphics3DRegistry
				.getRenderersForType(Graphics3DType.EXPORT)) {
			registry.registerAction(new Export3DAction(editor, descr
					.getRendererID()));
		}

	}
}
