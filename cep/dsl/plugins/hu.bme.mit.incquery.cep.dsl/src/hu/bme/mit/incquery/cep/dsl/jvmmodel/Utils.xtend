package hu.bme.mit.incquery.cep.dsl.jvmmodel

import com.google.inject.Inject
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AugmentedExpression
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.BranchExpression
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventExpression
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventPattern
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventTypedParameterWithMultiplicity
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Expression
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsExpression
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ModelElement
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.MultiplicityExpression
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.OnAppearRule
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Rule
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.StaticBinding
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedExpression
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedMultiplicityExpression
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TypedParameter
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPattern
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FailDiagnosticRule

class Utils {
	@Inject extension IQualifiedNameProvider
	@Inject extension TypeReferenceSerializer typeReferenceSerializer
	@Inject private TypesFactory factory = TypesFactory.eINSTANCE;
	@Inject extension JvmTypesBuilder

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
			OnAppearRule:
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
	
	def dispatch unwrapAction(OnAppearRule rule) {
		rule.action
	}

	def dispatch unwrapAction(FailDiagnosticRule rule) {
		rule.action
	}

	def dispatch unwrapActionHandler(OnAppearRule rule) {
		rule.actionHandler
	}

	def dispatch unwrapActionHandler(FailDiagnosticRule rule) {
		rule.actionHandler
	}
}
