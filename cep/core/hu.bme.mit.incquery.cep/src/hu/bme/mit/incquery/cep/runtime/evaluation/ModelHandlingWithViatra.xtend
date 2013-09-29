package hu.bme.mit.incquery.cep.runtime.evaluation

import hu.bme.mit.incquery.cep.api.evm.SimpleObservedComplexEventPattern
import hu.bme.mit.incquery.cep.api.runtime.EventModelManager
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine
import hu.bme.mit.incquery.cep.metamodels.internalsm.TrapState
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.EnabledTransitionMatcher
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.FinishedStateMachineMatcher
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.TokenInTrapStateMatcher
import java.util.Map
import org.eclipse.incquery.runtime.api.IncQueryEngineManager
import org.eclipse.incquery.runtime.evm.api.RuleSpecification
import org.eclipse.incquery.runtime.evm.specific.ConflictResolvers
import org.eclipse.incquery.runtime.evm.specific.ExecutionSchemas
import org.eclipse.incquery.runtime.evm.specific.Schedulers
import org.eclipse.viatra2.emf.runtime.rules.EventDrivenTransformationRuleGroup
import org.eclipse.viatra2.emf.runtime.rules.eventdriven.EventDrivenTransformationRuleFactory
import org.eclipse.viatra2.emf.runtime.transformation.eventdriven.EventDrivenTransformation

class ModelHandlingWithViatra {
	extension EventDrivenTransformation transformation
	extension EventDrivenTransformationRuleFactory ruleFactory = new EventDrivenTransformationRuleFactory

	@Property EventModelManager eventModelManager;
	@Property Map<RuleSpecification<?>, Integer> modelHandlers;

	new(EventModelManager eventModelManager) {
		this.eventModelManager = eventModelManager;
		transformation = new EventDrivenTransformation(eventModelManager.resourceSet)
	}

	def getRules() {
		new EventDrivenTransformationRuleGroup(
			createEnabledTransitionRule,
			createFinishedStateMachineRule,
			createTokenInTrapStateRule
		)
	}

	def registerRules() {
		val engine = IncQueryEngineManager.getInstance().getIncQueryEngine(eventModelManager.resourceSet);

		val schedulerFactory = Schedulers.getIQBaseSchedulerFactory(engine.getBaseIndex());
		val fixedPriorityResolver = ConflictResolvers.createFixedPriorityResolver();

		val executionSchema = ExecutionSchemas.createIncQueryExecutionSchema(engine, schedulerFactory,
			rules.ruleSpecifications);

		fixedPriorityResolver.setPriority(createEnabledTransitionRule.ruleSpecification, 100)
		fixedPriorityResolver.setPriority(createFinishedStateMachineRule.ruleSpecification, 50)
		fixedPriorityResolver.setPriority(createTokenInTrapStateRule.ruleSpecification, 0)

		executionSchema.setConflictResolver(fixedPriorityResolver);
	}

	val createEnabledTransitionRule = ruleFactory.createRule("enabled transition rule",
		EnabledTransitionMatcher::querySpecification) [
		eventModelManager.strategy.fireTransition(t, et)
	]

	val createFinishedStateMachineRule = ruleFactory.createRule("finished statemachine rule",
		FinishedStateMachineMatcher::querySpecification) [
		eventModelManager.finalStatesForStatemachines.get(sm).eventTokens.remove(0)
		var observedPattern = new SimpleObservedComplexEventPattern(sm.eventPattern)
		eventModelManager.callbackOnPatternRecognition(observedPattern)
		eventModelManager.realm.forwardObservedEventPattern(observedPattern)
	]

	val createTokenInTrapStateRule = ruleFactory.createRule("trap state rule",
		TokenInTrapStateMatcher::querySpecification) [
		var currentState = et.currentState
		if (!(currentState instanceof TrapState)) {
			return
		}
		System.out.println(
			"\t\t\t>>>>>>>>>Event token found in the trap state for pattern " +
				(et.currentState.eContainer as StateMachine).eventPattern.id)
		currentState.eventTokens.clear
	]
}
