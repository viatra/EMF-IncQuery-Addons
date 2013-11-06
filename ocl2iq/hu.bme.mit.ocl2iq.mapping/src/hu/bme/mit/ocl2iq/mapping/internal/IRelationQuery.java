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

import java.util.Set;

/**
 * @author Bergmann Gabor
 *
 */
public interface IRelationQuery {
	Set<String> getInputs();
	Set<String> getResults(); 
	String getCode();	
	
	/** optional */
	String getCodeNegated();
}
