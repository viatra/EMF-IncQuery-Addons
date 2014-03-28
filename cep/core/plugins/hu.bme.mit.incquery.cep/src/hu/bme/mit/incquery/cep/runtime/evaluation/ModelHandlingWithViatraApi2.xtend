package hu.bme.mit.incquery.cep.runtime.evaluation

import hu.bme.mit.incquery.cep.api.ParameterizableComplexEventPattern
import hu.bme.mit.incquery.cep.api.evm.InTrapComplexEventPattern
import hu.bme.mit.incquery.cep.api.evm.ObservedComplexEventPattern
import hu.bme.mit.incquery.cep.api.runtime.EventModelManager
import hu.bme.mit.incquery.cep.metamodels.internalsm.State
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine
import hu.bme.mit.incquery.cep.metamodels.internalsm.TrapState
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.EnabledTransitionMatcher
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.FinishedStateMachineMatcher
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.TokenInTrapStateMatcher
import java.util.ArrayList
import java.util.Map
import org.eclipse.incquery.runtime.evm.api.RuleSpecification
import org.eclipse.incquery.runtime.evm.specific.ConflictResolvers
import org.eclipse.viatra2.emf.runtime.rules.EventDrivenTransformationRuleGroup
import org.eclipse.viatra2.emf.runtime.rules.eventdriven.EventDrivenTransformationRuleFactory
import org.eclipse.viatra2.emf.runtime.transformation.eventdriven.EventDrivenTransformation
import org.eclipse.viatra2.emf.runtime.transformation.eventdriven.RuleOrderBasedFixedPriorityResolver

class ModelHandlingWithViatraApi2 {
	extension EventDrivenTransformationRuleFactory ruleFactory = new EventDrivenTransformationRuleFactory

	@Property EventModelManager eventModelManager;
	@Property Map<RuleSpecification<?>, Integer> modelHandlers;

	new(EventModelManager eventModelManager) {
		this.eventModelManager = eventModelManager;
	}

	def getRules() {
		new EventDrivenTransformationRuleGroup(
			createEnabledTransitionRule,
			createFinishedStateMachineRule,
			createTokenInTrapStateRule
		)
	}

	def registerRules() {
		EventDrivenTransformation.forResource(eventModelManager.resourceSet).addRules(rules).create()
	}

	def registerRulesWithCustomPriorities() {
		val fixedPriorityResolver = ConflictResolvers.createFixedPriorityResolver();
		fixedPriorityResolver.setPriority(createEnabledTransitionRule.ruleSpecification, 100)
		fixedPriorityResolver.setPriority(createFinishedStateMachineRule.ruleSpecification, 50)
		fixedPriorityResolver.setPriority(createTokenInTrapStateRule.ruleSpecification, 0)

		EventDrivenTransformation.forResource(eventModelManager.resourceSet).addRules(rules).
			setConflictResolver(fixedPriorityResolver).create()
	}

	def registerRulesWithAutomatedPriorities() {
		val resolver = new RuleOrderBasedFixedPriorityResolver()
		resolver.setPrioritiesFromScratch(new ArrayList(rules.ruleSpecifications))

		EventDrivenTransformation.forResource(eventModelManager.resourceSet).addRules(rules).
			setConflictResolver(resolver).create()
	}

	val createEnabledTransitionRule = ruleFactory.createRule().name("enabled transition rule").precondition(
		EnabledTransitionMatcher::querySpecification).action [
		var eventPattern = ((t.eContainer() as State).eContainer() as StateMachine).getEventPattern();
		if (eventPattern instanceof ParameterizableComplexEventPattern) {
			if (!((eventPattern as ParameterizableComplexEventPattern).evaluateParameterBindigs(e))) {
				return;
			}
		}
		eventModelManager.strategy.fireTransition(t, et, e)
	].build

	val createFinishedStateMachineRule = ruleFactory.createRule().name("finished statemachine rule").
		precondition(FinishedStateMachineMatcher::querySpecification).action [
			eventModelManager.finalStatesForStatemachines.get(sm).eventTokens.remove(0)
			var observedPattern = new ObservedComplexEventPattern(sm.eventPattern)
			eventModelManager.callbackOnPatternRecognition(observedPattern)
			eventModelManager.realm.forwardObservedEventPattern(observedPattern)
		].build

	val createTokenInTrapStateRule = ruleFactory.createRule().name("trap state rule").precondition(
		TokenInTrapStateMatcher::querySpecification).action [
		var currentState = et.currentState
		if (!(currentState instanceof TrapState)) {
			return
		}
		
		System.out.println(
			"\t\t\t>>>>>>>>>Event token found in the trap state for pattern " +
				(et.currentState.eContainer as StateMachine).eventPattern.id)
				
		var eventPattern = (currentState.eContainer() as StateMachine).getEventPattern();
		var failedPattern = new InTrapComplexEventPattern(eventPattern)
		eventModelManager.realm.forwardFailedEventPattern(failedPattern)		
		currentState.eventTokens.clear
	].build
}
