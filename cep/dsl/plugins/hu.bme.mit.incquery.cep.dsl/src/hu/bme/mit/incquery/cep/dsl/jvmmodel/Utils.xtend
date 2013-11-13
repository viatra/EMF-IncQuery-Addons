package hu.bme.mit.incquery.cep.dsl.jvmmodel

import com.google.common.collect.Lists
import com.google.common.collect.Maps
import com.google.inject.Inject
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AugmentedExpression
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.BranchExpression
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventExpression
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventPattern
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPattern
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventTypedParameterWithMultiplicity
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Expression
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsExpression
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ModelElement
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.MultiplicityExpression
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PatternCallParameter
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Rule
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.StaticBinding
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedExpression
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedMultiplicityExpression
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TypedParameter
import hu.bme.mit.incquery.cep.metamodels.cep.Event
import java.util.List
import java.util.Map
import java.util.Map.Entry
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend2.lib.StringConcatenation
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder

class Utils {
	@Inject extension IQualifiedNameProvider
	@Inject extension TypeReferenceSerializer typeReferenceSerializer
	@Inject private TypesFactory factory = TypesFactory.eINSTANCE;
	@Inject extension JvmTypesBuilder jvmTypesBuilder
	@Inject extension TypeReferences references

	def dispatch getComplexOperator(FollowsExpression expression) {
		return "ORDERED"
	}

	def dispatch getComplexOperator(BranchExpression expression) {
		return "UNORDERED"
	}

	def unwrapExpression(ComplexEventExpression expression) {
		switch (expression) {
			Expression:
				return expression
			AugmentedExpression: {
				switch (expression) {
					TimedExpression: return (expression as TimedExpression).expression
				}
				switch (expression) {
					MultiplicityExpression: return (expression as MultiplicityExpression).expression
				}
				switch (expression) {
					TimedMultiplicityExpression: return (expression as TimedMultiplicityExpression).expression
				}
			}
		}
	}

	def unwrapCompositionEventsWithParameterList(Expression expression) {
		switch (expression) {
			FollowsExpression: {
				var eventPatterns = Lists.newArrayList()

				var rootEps = expression.eventPatterns
				if (rootEps == null) {
					return eventPatterns
				}
				var rootEp = rootEps.get(0)
				if (rootEp == null) {
					return eventPatterns
				}
				if (rootEp.parameterList == null) {
					return eventPatterns
				}
				eventPatterns.add(rootEp)

				for (fe : expression.followerExpressions) {
					var typedEp = fe.eventPattern as EventTypedParameterWithMultiplicity
					if (typedEp.parameterList != null) {
						eventPatterns.add(typedEp)
					}
				}
				return eventPatterns
			}
			BranchExpression: {
				var eventPatterns = Lists.newArrayList()
				for (ep : expression.eventPatterns) {
					if (ep.parameterList != null) {
						eventPatterns.add(ep)
					}
				}
				return eventPatterns
			}
		}
	}

	def dispatch getAssignedEventPatterns(FollowsExpression expression) {
		var eventPatterns = newArrayList()

		var eps = expression.eventPatterns
		for (ep : eps) {
			eventPatterns.add(ep.eventPattern.type)
		}

		var fexpressions = expression.followerExpressions
		for (fe : fexpressions) {
			eventPatterns.add(
				((fe.eventPattern as EventTypedParameterWithMultiplicity).eventPattern.type as EventPattern))
		}

		eventPatterns
	}

	def dispatch getAssignedEventPatterns(BranchExpression expression) {
		var eventPatterns = newArrayList()

		var eps = expression.eventPatterns
		for (ep : eps) {
			eventPatterns.add((ep.eventPattern.type as EventPattern))
		}

		eventPatterns
	}

	def Iterable<? extends JvmMember> toAdvancedSetter(ModelElement element, String name, JvmTypeReference type,
		int index) {
		val advancedSetter = factory.createJvmOperation
		advancedSetter.simpleName = "set" + name.toFirstUpper
		advancedSetter.returnType = element.newTypeRef("void")
		advancedSetter.parameters.add(advancedSetter.toParameter(name, type))
		advancedSetter.setVisibility(JvmVisibility.PUBLIC)
		advancedSetter.setBody [
			append(
				'''
				this.«name» = «name»;
				getParameters().set(«index», «name»);''')
		]
		return Lists.newArrayList(advancedSetter)
	}

	def Iterable<? extends JvmMember> toImplementingBindingMethod(ComplexEventPattern pattern) {
		val method = factory.createJvmOperation
		method.simpleName = "evaluateParameterBindigs"
		method.setVisibility(JvmVisibility.PUBLIC)
		method.returnType = pattern.newTypeRef("boolean")
		method.parameters.add(method.toParameter("event", pattern.newTypeRef(Event)))
		val expression = pattern.complexEventExpression.unwrapExpression
		method.setBody [
			getParameterMapping(expression.unwrapCompositionEventsWithParameterList, method).append(
				'''
					return true;
				''')
		]

		method.addOverrideAnnotation(pattern)
		return Lists.newArrayList(method)
	}

	def getParameterMapping(ITreeAppendable appendable, List<EventTypedParameterWithMultiplicity> params, EObject ctx) {
		for (comEvent : params) {
			appendable.append(
				'''
					if(event instanceof «comEvent.eventPattern.type.getFqn(AtomicPatternFqnPurpose.EVENT)»){
				''').append(
				'''
					«referClass(appendable, ctx, Map, ctx.newTypeRef("String"), ctx.newTypeRef("Object"))»''').append(
				''' params = ''').append(
				'''«referClass(appendable, ctx, Maps)».newHashMap();
					''').append(
				'''
						«comEvent.evaluationBody»
						return evaluateParamBinding(params);
					}
				''')
		}
		appendable
	}

	def getEvaluationBody(EventTypedParameterWithMultiplicity parameter) {
		var paramCalls = parameter.parameterList
		if (paramCalls == null) {
			return ''''''
		}
		var paramList = paramCalls.parameters
		if (paramList.empty) {
			return ''''''
		}

		var StringConcatenation retVal = ''''''

		var i = 0
		var max = paramList.size
		while (i < max) {
			var currentParam = paramList.get(i)
			if (!currentParam.ignorable) {
				retVal.append(
					'''Object value«i» = ((«parameter.eventPattern.type.getFqn(AtomicPatternFqnPurpose.EVENT)») event).getParameter(«i»);
						''')
				retVal.append(
					'''params.put("«currentParam.name»", value«i»);
						''')
			}
			i = i + 1
		}
		retVal
	}

	def isIgnorable(PatternCallParameter parameter) {
		if (parameter.name.equalsIgnoreCase("_")) {
			return true
		}
		return false
	}

	def addOverrideAnnotation(JvmOperation method, EObject context) {
		method.annotations += factory.createJvmAnnotationReference => [
			it.annotation = references.findDeclaredType(typeof(Override), context) as JvmAnnotationType
		]
	}

	def Iterable<? extends JvmMember> toBindingMethod1(ModelElement element) {
		val method = factory.createJvmOperation
		method.simpleName = "evaluateParamBinding"
		method.returnType = element.newTypeRef("boolean")
		method.parameters.add(
			method.toParameter("params",
				element.newTypeRef(Map, cloneWithProxies(element.newTypeRef(String)),
					cloneWithProxies(element.newTypeRef(Object)))))

		//referClass(null, method, Entry, method.newTypeRef(String), method.newTypeRef(Object))))
		method.setVisibility(JvmVisibility.PRIVATE)
		method.setBody [
			append(
				'''
				for (''').append(
				'''«referClass(element, Entry, element.newTypeRef("String"), element.newTypeRef("Object"))» ''').
				append(
					'''
					param : params.entrySet()) {
						if (!(evaluateParamBinding(param.getKey(), param.getValue()))) {
							return false;
						}
					}
					return true;''')
		]
		return Lists.newArrayList(method)
	}

	def Iterable<? extends JvmMember> toBindingMethod2(ModelElement element) {
		val method = factory.createJvmOperation
		method.simpleName = "evaluateParamBinding"
		method.returnType = element.newTypeRef("boolean")
		method.parameters.add(method.toParameter("paramName", element.newTypeRef("String")))
		method.parameters.add(method.toParameter("paramValue", element.newTypeRef("Object")))
		method.setVisibility(JvmVisibility.PRIVATE)
		method.setBody [
			append(
				'''
					Object value = paramValues.get(paramName);
					if (value == null) {
						paramValues.put(paramName, paramValue);
						return true;
					}
					return value.equals(paramValue);
				''')
		]
		return Lists.newArrayList(method)
	}

	def static isStaticallyBound(
		TypedParameter parameter,
		List<StaticBinding> staticBindings
	) {
		for (sb : staticBindings) {
			if(sb.parameter.equals(parameter)) return true
		}
		return false
	}

	def getJobClassName(Rule rule) {
		var className = rule.fullyQualifiedName.lastSegment
		var packageName = rule.fullyQualifiedName.skipLast(1)
		return packageName.append("jobs").append(className.toFirstUpper + "Job")
	}

	def getFqn(ModelElement element, AtomicPatternFqnPurpose purpose) {
		var className = element.fullyQualifiedName.lastSegment
		var packageName = element.fullyQualifiedName.skipLast(1)
		switch (purpose) {
			case AtomicPatternFqnPurpose.EVENT:
				return packageName.append("events").append(className.toFirstUpper)
			case AtomicPatternFqnPurpose.PATTERN:
				return packageName.append("patterns.atomic").append(className.toFirstUpper + "Pattern")
		}
	}

	def getFqn(ModelElement element) {
		var className = element.fullyQualifiedName.lastSegment
		var packageName = element.fullyQualifiedName.skipLast(1)

		switch element {
			ComplexEventPattern:
				return packageName.append("patterns.complex").append(className.toFirstUpper + "Pattern")
			Rule:
				return packageName.append("rules").append(className.toFirstUpper)
		}
	}

	def wildCardExtends(JvmTypeReference clone) {
		var result = factory.createJvmWildcardTypeReference();
		var upperBound = factory.createJvmUpperBound();
		upperBound.setTypeReference(clone);
		result.getConstraints().add(upperBound);
		return result;
	}

	def referClass(ITreeAppendable appendable, EObject ctx, Class<?> clazz, JvmTypeReference... typeArgs) {
		val ref = ctx.newTypeRef(clazz, typeArgs)
		if (ref != null) {
			appendable.serialize(ref, ctx)
		} else {

			//Class resolution error - error handling required here
			//A fallback to writing out the fqn of the class
			appendable.append(clazz.canonicalName)
		}
	}

	def serialize(ITreeAppendable appendable, JvmTypeReference ref, EObject ctx) {
		typeReferenceSerializer.serialize(ref, ctx, appendable)
	}

	def dispatch unwrapAction(Rule rule) {
		rule.action
	}

	def dispatch unwrapActionHandler(Rule rule) {
		rule.actionHandler
	}
}
