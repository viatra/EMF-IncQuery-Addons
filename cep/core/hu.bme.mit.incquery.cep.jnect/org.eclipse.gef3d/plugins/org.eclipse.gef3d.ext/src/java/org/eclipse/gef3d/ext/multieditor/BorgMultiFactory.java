/*******************************************************************************
 * Copyright (c) 2009 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.ext.multieditor;

import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef3d.ext.assimilator.BorgEditPartFactory;

/**
 * A borg factoy that nests a multi editor factory. This class can be used if
 * modifications not specific to a single (nested) factory are to be made on
 * created objects. Or, from a different perspective, if a multi editor factory
 * should assimilate the created edit parts. 
 * <p>
 * While it certainly is possible to nest a multi editor factory into a borg
 * factory or vice versa, the multi editor factory requires to prepare the
 * root elements. If a multi factory is nested into a borg factory, this
 * is not possible any more. This implementation delegates the prepare calls
 * to the nested multi factory.
 * </p>
 *
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	Nov 5, 2009
 */	
public class BorgMultiFactory extends BorgEditPartFactory implements
		IMultiEditorPartFactory {

	/**
	 * @param i_nestedFactory
	 */
	public BorgMultiFactory(IMultiEditorPartFactory i_nestedFactory) {
		super(i_nestedFactory);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.multieditor.IMultiEditorPartFactory#prepare(java.lang.Object,
	 *      org.eclipse.gef.EditPartFactory)
	 */
	public void prepare(Object i_model, EditPartFactory i_factory) {
		prepare(i_model, i_factory, IMultiEditorPartFactory.LOWEST_PRIORITY);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.multieditor.IMultiEditorPartFactory#prepare(java.lang.Object,
	 *      org.eclipse.gef.EditPartFactory, int)
	 */
	public void prepare(Object i_model, EditPartFactory i_factory,
		int i_weight) {
		((IMultiEditorPartFactory) nestedFactory).prepare(i_model,
			i_factory, i_weight);
	}

}