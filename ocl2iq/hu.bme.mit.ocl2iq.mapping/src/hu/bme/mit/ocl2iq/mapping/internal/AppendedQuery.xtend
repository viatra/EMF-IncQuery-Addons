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
import com.google.common.base.Preconditions

/**
 * TODO parent has 0 or multiple results?
 * @author Bergmann Gabor
 *
 */
class AppendedQuery extends BaseRelationQuery {
	val IRelationQuery parent
	
	new(GenManager genManager, IRelationQuery parent, Set<String> results, 
		(String) => CharSequence addendum
	) {
		super(genManager, parent.inputs, results, '''
			«parent.code»
			«addendum.apply(parent.results.head)»
		''')
		this.parent = parent
		Preconditions::checkArgument(parent.results.size == 1, 
			'''Can only append to single-result queries; multiple results «parent.results.join(",")» at «parent»''')
	}

	new(GenManager genManager, IRelationQuery parent, Set<String> results, 
		(String) => CharSequence addendum, (String) => CharSequence negatedAddendum
	) {
		this(genManager, parent, results, addendum)
		this.codeNegated = '''
			«parent.code»
			«negatedAddendum.apply(parent.results.head)»
		'''
	}

}