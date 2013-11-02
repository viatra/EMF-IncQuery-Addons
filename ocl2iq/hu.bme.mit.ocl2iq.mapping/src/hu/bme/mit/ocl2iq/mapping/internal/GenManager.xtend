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

import java.util.Map
import org.eclipse.ocl.expressions.Variable
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EParameter
import java.util.Set
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EStructuralFeature
import com.google.common.collect.Sets
import java.util.SortedMap
import java.util.TreeMap
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EcorePackage
import com.google.common.collect.Maps

/**
 * @author Bergmann Gabor
 *
 */
class GenManager {
	val String rootPatternName	
	new(String rootPatternName) {
		this.rootPatternName = rootPatternName
	}
		
		
	val Set<String> usedVarNames = newHashSet
	val Map<String, EClassifier> name2type = newHashMap
	val Map<Variable<EClassifier, EParameter>, String> variable2name = newHashMap
	val Map<String, Variable<EClassifier, EParameter>> name2variable = newHashMap
	val Map<EStructuralFeature, String> tuplePart2name = newHashMap
	val Map<String, EStructuralFeature> name2tuplePart = newHashMap
	
	val Map<IRelationQuery, String> query2name = newHashMap
	val SortedMap<String, IRelationQuery> name2query = new TreeMap
	
	def dispatch String gen(EClass classifier) '''«classifier.name»'''
	def dispatch String gen(EDataType classifier) {
		val ecoreTypeName = ecoreDatatypes.get(classifier.instanceClass)
		if (ecoreTypeName == null) 
			'''«classifier.name»'''
		else 
			ecoreTypeName.name
	}
	def gen(EStructuralFeature feature) '''«feature.EContainingClass.gen».«feature.name»'''
	static val ecoreDatatypes = 
		EcorePackage::eINSTANCE.getEClassifiers().filter(typeof(EDataType)).toMap[instanceClass]
	
	def genParamsDeclared(Set<String> paramNames) {
		paramNames.map['''«it» : «toType.gen»'''].join(",\n")
	}
	def genParamsInvoked(Set<String> paramNames) {
		paramNames.join(",")
	}
	
	def registeredPatternNames() {
		name2query.entrySet
	}
	def registerQuery(IRelationQuery query, String patternName) {
		query2name.put(query, patternName)
		name2query.put(patternName, query)
	}
	def genPatternName(IRelationQuery query) {
		var patternName = query2name.get(query)
		if (patternName == null) {
			patternName = newQueryName	
			query.registerQuery(patternName)	
		}
		patternName
	}
	def genPatternDeclaration(IRelationQuery query) '''
		pattern «query.genPatternName»(
			«query.allParameters.genParamsDeclared»
		) {
			«query.gen»
		}
	'''
	def genPatternInvocation(IRelationQuery query) 
	'''«query.genPatternName»(«query.allParameters.genParamsInvoked»)'''

	def allParameters(IRelationQuery query) {
		Sets::union(query.inputs, query.results)
	}
	
	private def newQueryName() {
		var String patternName
		var nextSequence = 0;
		do {
			patternName = '''«rootPatternName»_«nextSequence»'''
			nextSequence = nextSequence + 1
		} while (name2query.containsKey(patternName))
		patternName
	}
	
	def gen(Variable<EClassifier, EParameter> variable) {
		var varCode = variable2name.get(variable)
		if (varCode == null) {
			varCode = newVarName(variable.type, variable.name)			
			variable2name.put(variable, varCode)
			name2variable.put(varCode, variable)
		}
		varCode
	}
	
	def newVarName(EClassifier type) {
		newVarName(type, type.name.toFirstLower)
	}
	def getVarNameForTuplePart(EStructuralFeature part) {
		var varCode = tuplePart2name.get(part)
		if (varCode == null) {
			varCode = newVarName(part.EType, part.name.toFirstLower)		
			tuplePart2name.put(part, varCode)
			name2tuplePart.put(varCode, part)
		}
		varCode	
	}
	def isKnownTuplePart(EStructuralFeature part) {
		tuplePart2name.containsKey(part)
	}
	
	private def newVarName(EClassifier type, String hint) {
		val sanitizedHint = '''«hint»'''.sanitize
		var varCode = sanitizedHint
		var nextSequence = 0;
		while (reserved.contains(varCode) || usedVarNames.contains(varCode)) {
			varCode = '''«sanitizedHint»_«nextSequence»'''
			nextSequence = nextSequence + 1
		}
		usedVarNames += varCode
		name2type.put(varCode, type)
		varCode
	}
	
	def String sanitize(CharSequence sequence) {
		sequence.toString.replaceAll("[^_0-9a-zA-Z]", "_")
	}
	
	def toType(String varCode) {
		name2type.get(varCode)
	}
	
	static val reserved = newHashSet(
		"void",
		"double",
		"float",
		"boolean",
		"long",
		"short",
		"byte",
		"int",
		"char",
		"package",
		"import",
		"uses",
		"static",
		"extension",
		"extends",
		"pattern",
		"private",
		"find",
		"neg",
		"check",
		"eval",
		"count",
		"true",
		"false",
		"TRUE",
		"FALSE",
		"if",
		"else",
		"switch",
		"case",
		"default",
		"for",
		"do",
		"while",
		"var",
		"val",
		"super",
		"new",
		"null",
		"try",
		"catch",
		"finally",
		"throw",
		"return",
		"typeof",
		"instanceof",
		"as"
	)
	
}