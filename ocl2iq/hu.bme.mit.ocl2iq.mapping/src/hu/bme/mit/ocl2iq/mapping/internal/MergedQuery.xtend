/*******************************************************************************
 * Copyright (c) 2004-2013 Gabor Bergmann and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Gabor Bergmann - initial API and implementation
 *******************************************************************************/

package hu.bme.mit.ocl2iq.mapping.internal

import java.util.Set
import java.util.Collections
import com.google.common.collect.Collections2
import com.google.common.collect.Sets

/**
 * @author Bergmann Gabor
 *
 */
class MergedQuery extends BaseRelationQuery {
	val IRelationQuery mainParent
	val IRelationQuery secondaryParent
	
	new(GenManager genManager, IRelationQuery mainParent, IRelationQuery secondaryParent) {
		super(genManager, 
			Sets::union(
				Sets::difference(mainParent.inputs, secondaryParent.results), 
				Sets::difference(secondaryParent.inputs, mainParent.results) 
			),
			mainParent.results,
			'''
				«secondaryParent.gen»
				«mainParent.gen»
			'''
		)
		this.mainParent = mainParent
		this.secondaryParent = secondaryParent
	}	
}