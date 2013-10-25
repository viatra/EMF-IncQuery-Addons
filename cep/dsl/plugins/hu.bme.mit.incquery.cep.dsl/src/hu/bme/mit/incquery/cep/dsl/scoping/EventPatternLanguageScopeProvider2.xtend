/*******************************************************************************
 * Copyright (c) 2010-2012, Zoltan Ujhelyi, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Zoltan Ujhelyi - initial API and implementation
 *******************************************************************************/
package hu.bme.mit.incquery.cep.dsl.scoping

import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEventPattern
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AtomicEventPatternImpl
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventModelImpl
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.xbase.scoping.LocalVariableScopeContext
import org.eclipse.xtext.xbase.scoping.XbaseScopeProvider

class EventPatternLanguageScopeProvider2 extends XbaseScopeProvider {

	override IScope createLocalVarScope(IScope parentScope, LocalVariableScopeContext scopeContext) {
		if (scopeContext != null && scopeContext.getContext() != null) {
			var context = scopeContext.getContext();
			if (context.eContainer instanceof AtomicEventPattern) {
					return Scopes.scopeFor((context.eContainer as AtomicEventPattern).parameters.parameters);
			}
		}

		return super.createLocalVarScope(parentScope, scopeContext);

	}
}
