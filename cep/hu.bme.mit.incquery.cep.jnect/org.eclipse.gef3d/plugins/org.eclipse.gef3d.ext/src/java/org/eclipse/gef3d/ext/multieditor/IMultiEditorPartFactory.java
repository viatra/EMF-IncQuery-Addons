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

/**
 * Defines prepare methods required by multi factories in order to add
 * root (context) elements to the factory and associate these elements with
 * the factory used for that specific context.
 *
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	Nov 5, 2009
 */
public interface IMultiEditorPartFactory extends EditPartFactory {
	
	public final static int LOWEST_PRIORITY = Integer.MIN_VALUE;

	public final static int HIGHEST_PRIORITY = Integer.MAX_VALUE;


	/**
	 * Calls {@link #prepare(Object, EditPartFactory, int)} with
	 * {@link #LOWEST_PRIORITY}
	 * 
	 * @param model
	 * @param i_factory
	 */
	public void prepare(Object model, EditPartFactory i_factory);

	/**
	 * Prepares a factory for which no edit part was created yet. This is
	 * usually necessary only for the root model elements, i.e. the
	 * modelContainer.
	 * 
	 * @param model
	 * @param i_factory
	 */
	public void prepare(Object model, EditPartFactory i_factory, int i_weight);

}