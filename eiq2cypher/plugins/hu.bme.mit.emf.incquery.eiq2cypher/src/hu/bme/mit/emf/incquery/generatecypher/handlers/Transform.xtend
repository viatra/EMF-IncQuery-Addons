package hu.bme.mit.emf.incquery.generatecypher.handlers

import java.util.ArrayList
import java.util.HashMap
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.viatra2.patternlanguage.core.patternLanguage.CheckConstraint
import org.eclipse.viatra2.patternlanguage.core.patternLanguage.PathExpressionConstraint
import org.eclipse.viatra2.patternlanguage.core.patternLanguage.PathExpressionTail
import org.eclipse.viatra2.patternlanguage.core.patternLanguage.Pattern
import org.eclipse.viatra2.patternlanguage.core.patternLanguage.VariableValue
import org.eclipse.viatra2.patternlanguage.core.patternLanguage.impl.VariableImpl
import org.eclipse.viatra2.patternlanguage.eMFPatternLanguage.EClassifierConstraint
import org.eclipse.viatra2.patternlanguage.eMFPatternLanguage.ReferenceType
import org.eclipse.viatra2.patternlanguage.eMFPatternLanguage.impl.ClassTypeImpl
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.impl.JvmOperationImpl
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.xbase.XBinaryOperation
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XNullLiteral
import org.eclipse.xtext.xbase.XNumberLiteral
import org.eclipse.xtext.xbase.XCastedExpression

class Transform implements IGenerator {

	// extract the last segment of an URI, e.g.:
	// "/hu.bme.mit.inf.gs.dsl/model/SoaModel.ecore#//ServiceMethod/parameters" --> "parameters" 
	def extractURILastSegment(String s) {
		s.substring(s.lastIndexOf('/') + 1);
	}

	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
		for (r: resource.allContents.toIterable.filter(typeof(Pattern))) {
			try {
				// invoking query
				fsa.generateFile("query_" + r.name + ".cypher", r.compile)
			} catch (Exception e) {
				e.printStackTrace()
			}
		}
	}

	int tempCounter;
	HashMap<String, String> hm
	ArrayList<String> matchClauseMatches
	ArrayList<String> whereClauses

	def CharSequence compile(Pattern p) {
		// initializing variables
		hm = new HashMap<String, String>()
		matchClauseMatches = new ArrayList<String>()
		whereClauses = new ArrayList<String>()
		tempCounter = 0
		
		// collecting variables from the classifier constraint
		p.bodies.get(0).eAllContents.toIterable.filter(typeof(EClassifierConstraint)).forEach [
			var var_ = getVar().getVar() // var is a reserved word, using the getVar() method
			hm.put(var_, var_)
		]
		
		// collecting variables from the path expression constraints and building the MATCH clause
		p.bodies.get(0).eAllContents.toIterable.filter(typeof(PathExpressionConstraint)).forEach [
			// collecting return values

			var match = 
				processTailReturnValue(
					head.src.getVar(), 
					(head.dst as VariableValue).value.getVar(),
					head.tail,
					1
				)

			if (!match.empty) {
				matchClauseMatches.add("(" + head.src.getVar() + ")-" + match)
			}
		]
		
		// collecting expressions for the WHERE clause
		p.bodies.get(0).eAllContents.toIterable.filter(typeof(CheckConstraint)).forEach [
			if (expression instanceof XBinaryOperation) {
				var binaryOperation = expression as XBinaryOperation
				
				var formattedLeftOperand = formatOperand(binaryOperation.leftOperand);
				var formattedFeature = formatFeature(binaryOperation.feature);
				var formattedRightOperand = formatOperand(binaryOperation.rightOperand);
				
				var String s = '''«formattedLeftOperand» «formattedFeature» «formattedRightOperand»'''
				whereClauses.add(s)
			}
		]
		
		return
			startClause(p).toString() + 
			matchClause(p).toString() +
			whereClause(p).toString() +
			returnClause(p).toString()
	}
	
	def String formatOperand(EObject xExpression) {
		if (xExpression instanceof XNumberLiteral) {
			var xNumberLiteral = xExpression as XNumberLiteral
			return xNumberLiteral.value	
		}
		
		if (xExpression instanceof XFeatureCall) {
			var featureCall = xExpression as XFeatureCall
			if (featureCall.feature instanceof VariableImpl) {
				var variableImpl = featureCall.feature as VariableImpl
				return hm.get(variableImpl.name)
			}
		}
		
		if (xExpression instanceof XNullLiteral) {
			return "null"
		}
		
		if (xExpression instanceof XCastedExpression) {
			var xCastedException = xExpression as XCastedExpression
			formatOperand(xCastedException.target)
		}
	}
	
	// extracts the JvmOperationImpl operator from a feature (if it has any)
	def String formatFeature(JvmIdentifiableElement feature) {
		if (feature instanceof JvmOperationImpl) {
			var jvmOperationImpl = feature as JvmOperationImpl
			formatOperator(jvmOperationImpl.simpleName)
		}
	}
	
	// transforms JvmOperationImpl operator from simpleName to arithmetic sign
	def String formatOperator(String operator) {
		switch (operator) {
			case 'operator_greaterThan': '>'
			case 'operator_greaterEqualsThan': '>='
			case 'operator_lessThan': '<'
			case 'operator_lessEqualsThan' : '<='
			case 'operator_equals': '=='
			case 'operator_notEquals': '!='
		}
	}
	
	def String processTailReturnValue(String src, String dst, PathExpressionTail tail, int depth) { 		
		// must cast the objects to eMFPatternLanguage:ReferenceType
		var refname = (tail.type as ReferenceType).refname;
		// must cast the refname references to ecore:ENamedElement 		
		var name = (refname as ENamedElement).name

		if (tail.tail == null) { // reached the end of the path chain
			var outputName = ""
			if (refname instanceof EAttribute) {
				if (depth == 1) {
					outputName = src + "." + dst 
					hm.put(dst, outputName)					
					return "" // no match here 
				} else {
					tempCounter = tempCounter + 1
					outputName = "Temp" + tempCounter + "." + name
					hm.put(dst, outputName)
					return "[" + name + "]->(" + "Temp" + tempCounter + ")" 
				}
			}
			if (refname instanceof EReference) {
				outputName = name
				hm.put(dst, outputName)
				return "[" + name + "]->(" + name + ")"
			}			
		} else { // continue digging
			return "[" + name + "]->()-" + processTailReturnValue(src, dst, tail.tail, depth+1)
		}
	}
	
	// START clause
	def CharSequence startClause(Pattern p) '''
		START
			«FOR e:p.bodies.get(0).eAllContents.toIterable.filter(typeof(EClassifierConstraint)) SEPARATOR ", "»
				«FOR classType:e.eAllContents.toIterable.filter(typeof(ClassTypeImpl))»«e.getVar().getVar()»=node:__types__(className="«((classType as ClassTypeImpl).classname as EClass).name»")«ENDFOR»
			«ENDFOR»
	'''
	
	// MATCH clause
	def CharSequence matchClause(Pattern p) '''
		«IF !matchClauseMatches.empty»
		MATCH
			«FOR m:matchClauseMatches SEPARATOR ", "»
				«m»
			«ENDFOR»
		«ENDIF»
	'''	

	// WHERE clause
	def CharSequence whereClause(Pattern p) '''
		WHERE 1 = 1 
			«FOR w:whereClauses»
				AND «w»
			«ENDFOR»
		'''

	// RETURN clause
	def CharSequence returnClause(Pattern p) { // base on the list of the IncQuery query's parameters
		'''
		RETURN
			«FOR e:p.parameters SEPARATOR ", "»«hm.get(e.name)»«ENDFOR»
		'''	
	}
}
