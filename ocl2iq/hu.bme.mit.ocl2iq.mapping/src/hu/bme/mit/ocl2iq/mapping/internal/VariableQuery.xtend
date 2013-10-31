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

import java.util.Collections
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.ocl.expressions.Variable
import org.eclipse.emf.ecore.EParameter

/**
 * @author Bergmann Gabor
 *
 */
class VariableQuery extends BaseRelationQuery {
	val Variable<EClassifier, EParameter> variable
	new(GenManager genManager, Variable<EClassifier, EParameter> variable) {
		super(genManager, Collections::emptySet, Collections::emptySet, "")
		this.variable = variable
		this.inputs += variable.gen
		this.results += variable.gen
	}			
}