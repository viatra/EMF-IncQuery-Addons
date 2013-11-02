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

package hu.bme.mit.ocl2iq.mapping.api;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;

/**
 * @author Bergmann Gabor
 *
 */
public class OCLParseControl {
	public OCLExpression parse(EClass classifierContext, String constraint) throws ParserException{
		OCL ocl = OCL.newInstance();
		final Helper helper = ocl.createOCLHelper();
		helper.setContext(classifierContext);
		return helper.createQuery(constraint);		
	}

}


