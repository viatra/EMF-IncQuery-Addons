package hu.bme.mit.incquery.cep.runtime.evaluation

import hu.bme.mit.incquery.cep.api.runtime.EventModelManager
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.EnabledTransitionMatch
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.EnabledTransitionMatcher
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.FinishedStateMachineMatch
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.FinishedStateMachineMatcher
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.TokenInTrapStateMatch
import java.util.LinkedHashMap
import java.util.Map
import org.eclipse.incquery.runtime.api.IMatchProcessor
import org.eclipse.incquery.runtime.evm.api.RuleSpecification
import org.eclipse.incquery.runtime.evm.specific.event.IncQueryActivationStateEnum
import org.eclipse.incquery.runtime.evm.specific.lifecycle.DefaultActivationLifeCycle
import org.eclipse.incquery.runtime.exception.IncQueryException

import static org.eclipse.incquery.runtime.evm.specific.Jobs.*
import static org.eclipse.incquery.runtime.evm.specific.Rules.*
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.TokenInTrapStateMatcher
import hu.bme.mit.incquery.cep.api.evm.SimpleObservedComplexEventPattern
import hu.bme.mit.incquery.cep.metamodels.internalsm.TrapState
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine

class ModelHandlerRules2 {
	private Map<RuleSpecification<?>, Integer> modelHandlers;
	private EventModelManager eventModelManager;

	new(EventModelManager eventModelManager) {
		this.eventModelManager = eventModelManager;

		modelHandlers = new LinkedHashMap<RuleSpecification<?>, Integer>();
		try {
			modelHandlers.put(getEnabledTransitionsRule(), 100);
			modelHandlers.put(getFinishedStateMachineRule(), 50);
			modelHandlers.put(getTokenInTrapStateRule(), 5);
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
	}

	def RuleSpecification<EnabledTransitionMatch> getEnabledTransitionsRule() throws IncQueryException {
		val IMatchProcessor<EnabledTransitionMatch> processor = [
			eventModelManager.strategy.fireTransition(t, et)
		]

		newMatcherRuleSpecification(
			EnabledTransitionMatcher::querySpecification,
			DefaultActivationLifeCycle::DEFAULT_NO_UPDATE_AND_DISAPPEAR,
			newHashSet(newRecordingJob(newStatelessJob(IncQueryActivationStateEnum::APPEARED, processor)))
		)
	}

	def RuleSpecification<FinishedStateMachineMatch> getFinishedStateMachineRule() throws IncQueryException{
		val IMatchProcessor<FinishedStateMachineMatch> processor = [
			eventModelManager.finalStatesForStatemachines.get(sm).eventTokens.remove(0)
			var observedPattern = new SimpleObservedComplexEventPattern(sm.eventPattern)
			eventModelManager.callbackOnPatternRecognition(observedPattern)
			eventModelManager.realm.forwardObservedEventPattern(observedPattern)
		]

		newMatcherRuleSpecification(
			FinishedStateMachineMatcher::querySpecification,
			DefaultActivationLifeCycle::DEFAULT,
			newHashSet(newRecordingJob(newStatelessJob(IncQueryActivationStateEnum::APPEARED, processor)))
		)
	}

	def RuleSpecification<TokenInTrapStateMatch> getTokenInTrapStateRule() throws IncQueryException {
		val IMatchProcessor<TokenInTrapStateMatch> processor = [
			var currentState = et.currentState
			if (!(currentState instanceof TrapState)) {
				return
			}
			System.out.println(
				"\t\t\t>>>>>>>>>Event token found in the trap state for pattern " +
					(et.currentState.eContainer as StateMachine).eventPattern.id)
					
			currentState.eventTokens.clear
		]

		newMatcherRuleSpecification(
			TokenInTrapStateMatcher::querySpecification,
			DefaultActivationLifeCycle::DEFAULT_NO_UPDATE_AND_DISAPPEAR,
			newHashSet(newRecordingJob(newStatelessJob(IncQueryActivationStateEnum::APPEARED, processor)))
		)
	}

	def getModelHandlers() {
		return modelHandlers;
	}

}
