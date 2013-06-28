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
package org.eclipse.gef3d.factories;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw3d.ChopboxAnchor3D;
import org.eclipse.gef.GraphicalEditPart;


/**
 * A single anchor instance is returned by all creation methods. This assumes
 * that all instances created by this factory are used for the same figure.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Apr 22, 2008
 */
public class SingleAnchorConnectionAnchorFactory extends
		AbstractConnectionAnchorFactory {

	/**
	 * 
	 * ChopboxAnchor3DFactory sharing a single {@link ChopboxAnchor3D}. This
	 * type of anchor can be used in all modes, thus the mode doesn't matter
	 * here.
	 *
	 * @author 	Jens von Pilgrim
	 * @version	$Revision$
	 * @since 	Apr 22, 2008
		 */
	public static class ChopboxAnchor3DFactory extends SingleAnchorConnectionAnchorFactory {

		/**
		 * @param host
		 */
		public ChopboxAnchor3DFactory(GraphicalEditPart host) {
			super(new ChopboxAnchor3D(host.getFigure()));
		}
		
	}
	
	
	
	protected ConnectionAnchor sharedProduct;

	
	
	/**
	 * @param i_sharedProduct must not be null
	 */
	public SingleAnchorConnectionAnchorFactory(ConnectionAnchor i_sharedProduct) {
		this(i_sharedProduct, null);
	}
	
	/**
	 * @param i_sharedProduct must not be null
	 * @param i_mode
	 */
	public SingleAnchorConnectionAnchorFactory(ConnectionAnchor i_sharedProduct, DisplayMode i_mode) {
		super(i_mode);
		if (i_sharedProduct == null) // parameter precondition
			throw new NullPointerException("i_sharedProduct must not be null");

		sharedProduct = i_sharedProduct;
	}

	/**
	 * Returns the shared connection anchor instance.
	 * <p>
	 * {@inheritDoc}
	 * 
	 * @param i_EditPart the edit part's figure must equal the shared connection
	 *            anchor's owner.
	 * @see org.eclipse.gef3d.factories.AbstractConnectionAnchorFactory#createConnectionAnchor(org.eclipse.gef.GraphicalEditPart)
	 */
	@Override
	public ConnectionAnchor createConnectionAnchor(GraphicalEditPart i_EditPart) {

		if (sharedProduct.getOwner() != i_EditPart.getFigure()) {
			throw new IllegalStateException(
					"Shared connection achor's figure differs from given edit part's figure");
		}

		return sharedProduct;
	}

}
