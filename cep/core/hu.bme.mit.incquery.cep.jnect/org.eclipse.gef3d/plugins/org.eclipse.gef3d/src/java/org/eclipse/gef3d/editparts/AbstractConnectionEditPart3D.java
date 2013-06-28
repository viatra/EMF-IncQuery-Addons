/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation, (c) 2009 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 *    IBM Corporation - original 2D version
 ******************************************************************************/
package org.eclipse.gef3d.editparts;

import org.eclipse.draw2d.AnchorListener;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw3d.XYZAnchor;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;

/**
 * AbstractConnectionEditPart3D, abstract base class for 3D connections, fixes
 * some problems with default anchors.
 * 
 * <p>
 * This class contains a copied of {@link AbstractConnectionEditPart}, as the
 * default anchor instances are private in that class and we would need to
 * access these instances here. For details, see
 * bugzilla <a href="https://bugs.eclipse.org/290531">290531</a></p> 
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Sep 25, 2009
 */
public abstract class AbstractConnectionEditPart3D extends AbstractConnectionEditPart {
	
	public static final ConnectionAnchor DEFAULT_TARGET_ANCHOR_3D =
		new XYZAnchor.Immutable(new Vector3fImpl(100, 100, 100));

	public static final ConnectionAnchor DEFAULT_SOURCE_ANCHOR_3D =
		new XYZAnchor.Immutable(new Vector3fImpl(100, 100, 100));

	@Override
	protected ConnectionAnchor getTargetConnectionAnchor() {
		if (getTarget() != null) {
			if (getTarget() instanceof NodeEditPart) {
				NodeEditPart editPart = (NodeEditPart) getTarget();
				return editPart.getTargetConnectionAnchor(this);
			}
			IFigure f = ((GraphicalEditPart)getTarget()).getFigure();
			return new ChopboxAnchor(f);
		}
		return DEFAULT_TARGET_ANCHOR_3D;
	}
	
	@Override
	protected ConnectionAnchor getSourceConnectionAnchor() {
		if (getSource() != null) {
			if (getSource() instanceof NodeEditPart) {
				NodeEditPart editPart = (NodeEditPart) getSource();
				return editPart.getSourceConnectionAnchor(this);
			}
			IFigure f = ((GraphicalEditPart)getSource()).getFigure();
			return new ChopboxAnchor(f);
		}
		return DEFAULT_SOURCE_ANCHOR_3D;
	}

}
