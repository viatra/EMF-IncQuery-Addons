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
 * Generic classes for enabling intermodel models, i.e. models connecting elements
 * of other models.
 * The main problem with intermodels is that usually the inter models connections
 * are unidirectional only, that is the connected models are not to be modified
 * by the intermodel. A typical example of intermodel models are trace models.
 * The source and target models are not to be changed by the trace model.
 * <p>
 * Since the connected models are not to be altered by the intermodel or the 
 * editor, their model elements cannot be connected directly. What does that mean?
 * Let's look at a simple trace as a example. A given trace <i>t</i> connects
 * a source model element <i>m_source</i> with a target model element <i>m_target</i>.
 * From an editors perspective, the trace is a connection between two nodes.
 * As defined by GEF's design, that means that the nodes, here the edit parts of
 * the source and target elements, are expected to return the trace as a connection
 * (in methods {@link GraphicalEditPart#getSourceConnections()} and
 * {@link GraphicalEditPart#getTargetConnections()}. Since the real source and
 * target models don't know anything about the trace, they cannot return the
 * trace here.
 * <p>
 * There may exists two solution to this problem:
 * <ol>
 * <li>The edit parts managing the source and target elements are extended to
 * handle the trace as well. This is the best solution if the source of these edit
 * parts is available or the edit parts can be replaced by extended version. In 
 * this case, "only" the edit parts are to be extended and the traces can directly
 * connect the model elements.
 * </li>
 * <li>If the edit parts cannot be altered, the solution proposed here can be
 * used. Each model edit part is used as a model element for a connected
 * element adapter. This adapter encapsulates the real model edit parts. From the intermodel
 * point of view, these adapter serve as new model elements. The advantage of this
 * technique is that the original model elements and their edit parts are not changed. 
 * The disadvantage is that the edit parts or the model elements serve as anchors.
 * That is, the edit parts of the models must be created prior the traces and their
 * edit parts are to be displayed. This may be a problem in some cases.</li>
 * </ol>
 * <p>
 * The following diagram illustrates how the connected element adapter is used to
 * encapsulate the models:
 * 
 * <pre>
 *                            model                           nested         model
 *  ConnectedElementEditPart ------ ConnectedElementAdapter  ----- EditPart --- Object
 *                                        |                                       |
 *            mapped source adapter model |                                       |
 *            +---------------------------+                                       |                                                                               
 *            |                                 source                            |
 *            |    model        +-------------------------------------------------+
 *  TraceEditPart  ------ Trace +                                                  
 *            |                 +-------------------------------------------------+
 *            |                                 target                            |
 *            +---------------------------+                                       | 
 *            mapped target adapter model |                                       |
 *                                        |                                       |
 *  ConnectedElementEditPart ------ ConnectedElementAdapter  ----- EditPart --- Object
 *                            model                           nested         model
 * </pre>
 * 
 * 
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	Feb 25, 2008
 */
package org.eclipse.gef3d.ext.intermodel;

import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.GraphicalEditPart;

