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

package hu.bme.mit.ocl2iq.mapping.internal;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author Bergmann Gabor
 *
 */
public class BaseRelationQuery implements IRelationQuery {

	protected final Set<String> inputs;
	protected final Set<String> results;
	protected final String code;
	@Extension protected final GenManager genManager;
	
	public BaseRelationQuery(GenManager genManager, Set<String> inputs, Set<String> results, CharSequence code) {
		super();
		this.genManager = genManager;
		this.inputs = new HashSet<String>(inputs);
		this.results = new HashSet<String>(results);
		this.code = code.toString();
	}

	@Override
	public Set<String> getInputs() {
		return inputs;
	}
	
	@Override
	public Set<String> getResults() {
		return results;
	}
	
	@Override
	public String gen() {
		return code;
	}

}
