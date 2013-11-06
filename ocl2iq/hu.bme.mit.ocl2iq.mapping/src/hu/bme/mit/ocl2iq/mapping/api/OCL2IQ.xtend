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
import com.google.common.collect.Lists
import com.google.common.collect.Sets
import hu.bme.mit.ocl2iq.mapping.internal.AppendedQuery
import hu.bme.mit.ocl2iq.mapping.internal.BaseRelationQuery
import hu.bme.mit.ocl2iq.mapping.internal.GenManager
import hu.bme.mit.ocl2iq.mapping.internal.IRelationQuery
import hu.bme.mit.ocl2iq.mapping.internal.MergedQuery
import hu.bme.mit.ocl2iq.mapping.internal.VariableQuery
import java.util.ArrayList
import java.util.Collections
import java.util.HashMap
import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EParameter
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.ocl.ecore.IfExp
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
	// TODO type, enum/null/collection literal, operacio??
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
	private def dispatch IRelationQuery translate(IfExp expression) {
		val thenQuery = expression.thenExpression.translateAfterCast
		val elseQuery = expression.elseExpression.translateAfterCast
		val condition = expression.condition.translateAfterCast
		disjunctionPredicate(
			mergeQuery(thenQuery, condition.ponatePredicate),
			mergeQuery(elseQuery, condition.negatePredicate)
		)
	}
	private def dispatch IRelationQuery translate(OperationCallExp expression) {
		val opName = expression.referredOperation.name
		val sourceQuery = expression.source.translateAfterCast
		val argumentQueries = expression.argument.map[translateAfterCast].eager
		val allArgumentQueries = (newHashSet(sourceQuery) + argumentQueries)
		val allInputs = argumentQueries.map[inputs].fold(sourceQuery.inputs)[a,b|Sets::union(a,b)]
		
		// for simple logical operations on predicates
		if (allArgumentQueries.exists[results.empty]) { // only use this form if any parameters are boolean predicates
			switch(opName) {
				case "and" : return allArgumentQueries.map[negatePredicate].reduce[a,b|disjunctionPredicate(a,b)].negatePredicate
				case "or" : return allArgumentQueries.map[ponatePredicate].reduce[a,b|disjunctionPredicate(a,b)]
			}
		}
		switch(opName) { // this one should be used always ?
			case "implies" : return disjunctionPredicate(allArgumentQueries.head.negatePredicate, allArgumentQueries.last.ponatePredicate)
		}
				
		// otherwise, operate on result values (reified in case of booleans)		
		val allArgumentQueriesReified = allArgumentQueries.map[reifyPredicate].eager
		val allResults = allArgumentQueriesReified.map[results].flatten.eager
		val allResultsCasted = allResults.map['''(«it» as «toType.instanceClass.canonicalName»)''']
		
		// for simple comparisons, ponate the result as a predicate
		val opGen = switch(opName) {
			case "=" : "=="->"!="
			case "<>" : "!="->"=="
			default : null
		}
		if (opGen != null) 
			return makeQuery( 
				allInputs, 
				Collections::emptySet, 
				'''
					«allArgumentQueriesReified.map[code].join»
					«opGen.key.genOpInfix(allResults)»;
				''') => [
					codeNegated = '''
						«allArgumentQueriesReified.map[code].join»
						«opGen.value.genOpInfix(allResults)»;
					'''.toString
				]
				
		// otherwise, put the result into a boolean
		val resultVar = expression.type.newVarName
		makeQuery( 
			allInputs, 
			Collections::singleton(resultVar), 
			'''
				«allArgumentQueriesReified.map[code].join»
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
		makeQuery( Collections::emptySet, Collections::singleton(resultVar), '''
			«resultVar» == «literalGen»;
		''')
	}
	private def dispatch IRelationQuery translate(TupleLiteralExp expression) {
		val partsToTranslatedExps =
			expression.part.map[attribute.varNameForTuplePart -> value.translateAfterCast.reifyPredicate].eager
		val allInputs = partsToTranslatedExps.map[value.inputs].flatten.toSet
		val allResults = partsToTranslatedExps.map[key].toSet
		makeQuery( allInputs, allResults, '''
			«partsToTranslatedExps.map[value.code].join»
			«partsToTranslatedExps.map['''«key» == «value.results.head»;'''].join("\n")»
		''')
	}
	private def dispatch IRelationQuery translate(PropertyCallExp expression) {
		val sourceQuery = expression.source.translateAfterCast // make sure to translate tupe parts before property access 
		val feature = expression.getReferredProperty()
		if (feature.knownTuplePart) {
			val result = feature.varNameForTuplePart
			makeQuery( sourceQuery.inputs, Collections::singleton(result), '''
				«sourceQuery.code»
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
	
	// TODO order of multiple results?
	private def IRelationQuery disjunctionPredicate(IRelationQuery original1, IRelationQuery original2) {
		Preconditions::checkArgument(original1.results.size == original2.results.size, 
			'''disjuction branches must have the same number of results''')
		val resultList1 = original1.results.sort
		val resultList2 = original2.results.sort
		val resultList2iter = resultList2.iterator
		val result12Aux = new HashMap<String, String>
		val result22Aux = new HashMap<String, String>
		for (result1: resultList1) {
			val result2 = resultList2iter.next
			val type = lowestCommonSupertype(result1.toType, result2.toType)
			val auxResult = type.newVarName
			result12Aux.put(result1, auxResult) 
			result22Aux.put(result2, auxResult) 
		}
		
		val auxDisjunction = makeQuery( 
			Sets::union(original1.inputs, original2.inputs), result12Aux.values.toSet, '''
				«original1.code»
				«original1.results.map[it + " == " + result12Aux.get(it) + ";"].join("\n")»
			} or {
				«original2.code»
				«original2.results.map[it + " == " + result22Aux.get(it) + ";"].join("\n")»
			''') 	
		makeQuery( 
			auxDisjunction.inputs, auxDisjunction.results, 
			'''find «auxDisjunction.genPatternInvocation»;'''
		) => [
			codeNegated = 
				if (original1.results.size != 0) null else '''
					«original1.negatePredicate.code»
					«original2.negatePredicate.code»
				'''
		]
	}
	
	def private lowestCommonSupertype(EClassifier classifier1, EClassifier classifier2) {
		if (classifier1 instanceof EDataType && classifier2 instanceof EDataType) {
			if ((classifier1 as EDataType).instanceClass == (classifier2 as EDataType).instanceClass)
				return classifier1
			else throw new IllegalArgumentException(
				'''No common supertype of EDataTypes: «classifier1.name» vs. «classifier2.name»''')
		} else if (classifier1 instanceof EClass && classifier2 instanceof EClass) {
			val supers = lowestCommonSupertypesInternal(classifier1 as EClass, classifier2 as EClass)			
			if (supers.size > 1) supers.remove(EcorePackage::eINSTANCE.EObject)
			
			if (supers.size == 1) supers.head else supers.sortBy[EAllSuperTypes.size].head // TODO choice?
		} else throw new IllegalArgumentException(
			'''No common supertype of EClass and EDataType: «classifier1.name» vs. «classifier2.name»''');
	}
	def private Set<EClass> lowestCommonSupertypesInternal(EClass class1, EClass class2) {
		if (class1.isSuperTypeOf(class2)) return newHashSet(class1)
		if (class1.ESuperTypes.empty) return newHashSet(EcorePackage::eINSTANCE.EObject)
		class1.ESuperTypes.map[lowestCommonSupertypesInternal(class2)].flatten.toSet
	}
	
	private def BaseRelationQuery makeQuery(
		Set<String> inputs, 
		Set<String> results,
		String code
	) {
		new BaseRelationQuery(genManager, inputs, results, code)
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
			new AppendedQuery(genManager, originalQuery, Collections::emptySet, ['''
				true == «it»;
			'''], ['''
				false == «it»;
			'''])		
	}
	private def IRelationQuery negatePredicate(IRelationQuery originalQuery) {
		if (originalQuery.results.empty) { // simple predicate query
			val negatedCode = originalQuery.codeNegated
			if (negatedCode != null) { // this was already prepared
				makeQuery( 
					originalQuery.inputs, Collections::emptySet, 
					originalQuery.codeNegated
				) => [codeNegated = originalQuery.code]
			} else { // no pre-generated negated code, must apply NAC
				makeQuery( 
					originalQuery.inputs, Collections::emptySet, 
					'''neg find «originalQuery.genPatternInvocation»;'''
				) => [codeNegated = originalQuery.code]
			} 
		} else  // reified into boolean value
			new AppendedQuery(genManager, originalQuery, Collections::emptySet, ['''
				false == «it»;
			'''], ['''
				true == «it»;
			'''])		
	}
	private def IRelationQuery reifyPredicate(IRelationQuery originalQuery) {
		if (originalQuery.results.empty) { // simple predicate query, needs to be reified
			val countVariable = EcorePackage::eINSTANCE.EInt.newVarName
			val reificationVariable = EcorePackage::eINSTANCE.EBoolean.newVarName
			makeQuery( 
				originalQuery.allParameters, Collections::singleton(reificationVariable), 
				'''
					«countVariable» == count find «originalQuery.genPatternInvocation»;
					«reificationVariable» == eval(«countVariable» > 0);
				'''
			)
		} else  // already reified into boolean value
			originalQuery		
	}
	
	def <T> List<T> eager(Iterable<T> iterable) {
		Lists.newArrayList(iterable);
	}

}