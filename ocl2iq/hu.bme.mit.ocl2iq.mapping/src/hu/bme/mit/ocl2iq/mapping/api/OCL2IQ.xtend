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

package hu.bme.mit.ocl2iq.mapping.api

import com.google.common.base.Preconditions
import com.google.common.collect.Sets
import hu.bme.mit.ocl2iq.mapping.internal.AppendedQuery
import hu.bme.mit.ocl2iq.mapping.internal.BaseRelationQuery
import hu.bme.mit.ocl2iq.mapping.internal.GenManager
import hu.bme.mit.ocl2iq.mapping.internal.IRelationQuery
import hu.bme.mit.ocl2iq.mapping.internal.MergedQuery
import hu.bme.mit.ocl2iq.mapping.internal.VariableQuery
import java.util.ArrayList
import java.util.Collections
import java.util.List
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EParameter
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.ocl.ecore.IteratorExp
import org.eclipse.ocl.ecore.LetExp
import org.eclipse.ocl.ecore.LiteralExp
import org.eclipse.ocl.ecore.OCLExpression
import org.eclipse.ocl.ecore.OperationCallExp
import org.eclipse.ocl.ecore.PrimitiveLiteralExp
import org.eclipse.ocl.ecore.PropertyCallExp
import org.eclipse.ocl.ecore.StringLiteralExp
import org.eclipse.ocl.ecore.TupleLiteralExp
import org.eclipse.ocl.ecore.VariableExp
import org.eclipse.ocl.expressions.Variable
import com.google.common.collect.Lists

/**
 * @author Bergmann Gabor
 *
 */
class OCL2IQ {
	val EClass context
	val OCLExpression oclRoot
	val String rootPatternName
	extension var GenManager genManager
	
	new(EClass context, OCLExpression oclRoot, String rootPatternName) {
		this.context = context;
		this.oclRoot = oclRoot;
		this.rootPatternName = rootPatternName.replaceAll("[^_0-9a-zA-Z]", "_")
		
		genManager = new GenManager(this.rootPatternName)
	}
		
	public def gen() {
		translate(oclRoot).registerQuery(rootPatternName)
		registeredPatternNames.map[value.genPatternDeclaration].join("\n")
	}
	// TODO if, enum/null/collection/tuple literal, operacio??
	private def dispatch IRelationQuery translate(IteratorExp expression) {
		Preconditions::checkArgument(expression.iterator.size == 1, '''Only single-iterator expressions supported; could not translate «expression»''') 
		val iteratorVariable = expression.iterator.head
		val sourceQuery = expression.source.translateAfterCast
		val bodyQuery = expression.body.translateAfterCast
		switch(expression.name) {
			case "collect" : mergeQuery( 
				bodyQuery, 
				iteratorVariable.translateAssignment(sourceQuery)
			)
			case "select" : mergeQuery( 
				iteratorVariable.translateAssignment(sourceQuery),
				bodyQuery.ponatePredicate 
			)
			case "reject" : mergeQuery( 
				iteratorVariable.translateAssignment(sourceQuery),
				bodyQuery.negatePredicate 
			)
			default :
				throw new IllegalArgumentException('''Iterator expression kind must be collect, select or reject instead of «expression.name» in «expression»''')
		}		
	}
	private def dispatch IRelationQuery translate(OperationCallExp expression) {
		val opName = expression.referredOperation.name
		val sourceQuery = expression.source.translateAfterCast
		val argumentQueries = expression.argument.map[translateAfterCast].myToList
		val allInputs = argumentQueries.map[inputs].fold(sourceQuery.inputs)[a,b|Sets::union(a,b)]
		
		val allArgumentQueries = (newHashSet(sourceQuery) + argumentQueries).map[reifyPredicate].myToList
		val allResults = allArgumentQueries.map[results].flatten.myToList
		val allResultsCasted = allResults.map['''(«it» as «toType.instanceClass.canonicalName»)''']
		
		// for simple comparisons, ponate the result as a predicate
		val opGen = switch(opName) {
			case "=" : "=="
			case "<>" : "!="
			default : null
		}
		if (opGen != null) 
			return new BaseRelationQuery(genManager, 
				allInputs, 
				Collections::emptySet, 
				'''
					«allArgumentQueries.map[gen].join»
					«opGen.genOpInfix(allResults)»;
				''')
				
		// otherwise, put the result into a boolean
		val resultVar = expression.type.newVarName
		new BaseRelationQuery(genManager, 
			allInputs, 
			Collections::singleton(resultVar), 
			'''
				«allArgumentQueries.map[gen].join»
				«resultVar» == eval(«opName.genOp(allResultsCasted)»);
			''')
	}
	
	
	private def genOp(String opName, List<String> arguments) {
		if (arguments.size == 2) { // infix ops
			val opGen = switch(opName) {
				case "and" : "&&"
				case "or" : "||"
				case "xor" : "^^"
				case "div" : "/"
				case "mod" : "%"
				case "concat" : "+"
				case "+" : opName
				case "-" : opName
				case "*" : opName
				case "/" : opName
				default : null
			}
			if (opGen != null) return opGen.genOpInfix(arguments);
		} 
		// prefix ops - TODO postfix
		val opGen = switch(opName) {
			case "not" : "!"
			default : opName
		}
		opGen.genOpPrefix(arguments);
	}
	private def genOpPrefix(String opGen, List<String> arguments) '''«opGen»(«arguments.join(", ")»)'''
	private def genOpInfix(String opGen, List<String> arguments) {
		arguments.join(''' «opGen» ''')	
	}

	
	
	private def dispatch IRelationQuery translate(PrimitiveLiteralExp expression) {
		val resultVar = expression.type.newVarName
		val literalGen = if (expression instanceof StringLiteralExp) 
							'''"«(expression as StringLiteralExp).stringSymbol»"''' 
						else expression.toString
		new BaseRelationQuery(genManager, Collections::emptySet, Collections::singleton(resultVar), '''
			«resultVar» == «literalGen»;
		''')
	}
	private def dispatch IRelationQuery translate(TupleLiteralExp expression) {
		val partsToTranslatedExps =
			expression.part.map[attribute.varNameForTuplePart -> value.translateAfterCast.reifyPredicate].myToList
		val allInputs = partsToTranslatedExps.map[value.inputs].flatten.toSet
		val allResults = partsToTranslatedExps.map[key].toSet
		new BaseRelationQuery(genManager, allInputs, allResults, '''
			«partsToTranslatedExps.map[value.gen].join»
			«partsToTranslatedExps.map['''«key» == «value.results.head»;'''].join("\n")»
		''')
	}
	private def dispatch IRelationQuery translate(PropertyCallExp expression) {
		val sourceQuery = expression.source.translateAfterCast // make sure to translate tupe parts before property access 
		val feature = expression.getReferredProperty()
		if (feature.knownTuplePart) {
			val result = feature.varNameForTuplePart
			new BaseRelationQuery(genManager, sourceQuery.inputs, Collections::singleton(result), '''
				«sourceQuery.gen»
			''')
		} else {
			val eType = feature.getEType()
			val result = eType.newVarName
			appendQuery(sourceQuery, result) ['''
				«feature.gen»(«it», «result»);
			''']
		}
	}
	private def dispatch IRelationQuery translate(VariableExp expression) {
		new VariableQuery(genManager, expression.referredVariable)
	}
	private def dispatch IRelationQuery translate(LetExp expression) {
		val initializer = expression.variable.translateInitializer
		val body = expression.in.translateAfterCast
		mergeQuery( 
			body, 
			initializer
		)
	}
	private def IRelationQuery translateAfterCast(org.eclipse.ocl.expressions.OCLExpression<EClassifier> expression) {
		translate(expression as OCLExpression)
	}
	private def IRelationQuery translateInitializer(Variable<EClassifier, EParameter> variable) {
		variable.translateAssignment(variable.initExpression.translateAfterCast)
	}
	private def IRelationQuery translateAssignment(Variable<EClassifier, EParameter> variable, IRelationQuery query) {
		appendQuery(query, variable.gen) ['''
			«variable.gen» == «it»;
		''']
	}
	
	private def AppendedQuery appendQuery(IRelationQuery sourceQuery, 
		CharSequence resultVarName,
		(String) => CharSequence addendum
	) {
		new AppendedQuery(genManager, sourceQuery.reifyPredicate, Collections::singleton(resultVarName.toString), addendum)
	}
	private def MergedQuery mergeQuery(
		IRelationQuery mainQuery, 
		IRelationQuery secondaryQuery
	) {
		new MergedQuery(genManager, mainQuery, secondaryQuery) 
	}
	private def IRelationQuery ponatePredicate(IRelationQuery originalQuery) {
		if (originalQuery.results.empty) // simple predicate query
			originalQuery
		else  // reified into boolean value
			new AppendedQuery(genManager, originalQuery, Collections::emptySet) ['''
				true == «it»;
			''']		
	}
	private def IRelationQuery negatePredicate(IRelationQuery originalQuery) {
		if (originalQuery.results.empty) // simple predicate query
			new BaseRelationQuery(genManager, 
				originalQuery.allParameters, Collections::emptySet, 
				'''neg find «originalQuery.genPatternInvocation»;'''
			)
		else  // reified into boolean value
			new AppendedQuery(genManager, originalQuery, Collections::emptySet) ['''
				false == «it»;
			''']		
	}
	private def IRelationQuery reifyPredicate(IRelationQuery originalQuery) {
		if (originalQuery.results.empty) { // simple predicate query, needs to be reified
			val countVariable = EcorePackage::eINSTANCE.EInt.newVarName
			val reificationVariable = EcorePackage::eINSTANCE.EBoolean.newVarName
			new BaseRelationQuery(genManager, 
				originalQuery.allParameters, Collections::singleton(reificationVariable), 
				'''
					«countVariable» == count find «originalQuery.genPatternInvocation»;
					«reificationVariable» == eval(«countVariable» > 0);
				'''
			)
		} else  // already reified into boolean value
			originalQuery		
	}
	
	def <T> List<T> myToList(Iterable<T> iterable) {
		Lists.newArrayList(iterable);
	}

}