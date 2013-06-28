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

/**
 * 3D implementations of GEF's handle and feedback classes. 
 * 
 * <h3>What are Handles and Feedback Figure?<//h3>
 * Handles are small 
 * figures indicating selected figures and can be used for resizing a figure for
 * instance. Usually handles are small rectangles in a two-dimensional editor. Here,
 * handles are small cubes.
 * Feedback figures are figures used instead of a figure during an
 * edit operation, e.g. for resizing. Usually, FeedbackFigures are rectangles
 * or cubes with the initial size of the figures bounds. 
 * 
 * <h3>How are handles created and managed?</h3>
 * Selection edit policies initiate the creation of handles. A container's
 * layout policy delegates the selection request to the selected child. GEF's
 * {@link XYLayoutEditPolicy} (as well as GEF3D's {@link XY3DLayoutEditPolicy})
 * create appropriate edit policies of their children on the fly
 * (e.g. in {@link XY3DLayoutPolicy#createChildEditPolicy(EditPart)}. GEF3D
 * replaces a 2D {@link ResizableEditPolicy} with 3D version 
 * {@link ResizableEditPolicy3D}. This child edit policy is then responsible
 * for creating (and removing) the handles. While GEF uses handle kit classes
 * (e.g. {@link ResizableHandleKit})
 * with static methods, GEF3D uses a factory (factory and singleton pattern,
 * see {@link IHandleFactory} and its implementations.
 * <p>
 * Here's the (simplified) sequence, for example:
 * <ol>
 * 	<li>{@link ConstrainedLayoutEditPolicy#createChildEditPolicy(org.eclipse.gef.EditPart)},
 * 			often {@link XY3DLayoutEditPolicy#createChildEditPolicy(org.eclipse.gef.EditPart)}</li>
 *  <li>{@link ResizableEditPolicy}, {@link ResizableEditPolicy3D} respectively</li>
 *  <li>{@link ResizableHandleKit}, {@link IHandleFactory} and {@link ResizableHandle3DFactory} respectively</li>
 * <ol> 
 * 
 * <h3>Design Difference between GEF and GEF3D</h3>
 * GEF3D uses a handle factory (see {@link IHandleFactory} and implementations) 
 * to create the handles, while in GEF, the handles are created using a "kit"
 * class with static methods.  
 * 
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	Mar 25, 2008
 */
package org.eclipse.gef3d.handles;

import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.handles.ResizableHandleKit;
import org.eclipse.gef3d.editpolicies.ResizableEditPolicy3D;
import org.eclipse.gef3d.editpolicies.XY3DLayoutPolicy;


