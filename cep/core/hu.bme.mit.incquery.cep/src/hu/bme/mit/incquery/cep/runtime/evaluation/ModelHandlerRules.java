package hu.bme.mit.incquery.cep.runtime.evaluation;

import hu.bme.mit.incquery.cep.api.ObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.api.SimpleObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken;
import hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InitState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TrapState;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.EnabledTransitionMatch;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.EnabledTransitionMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.FinishedStateMachineMatch;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.FinishedStateMachineMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.PartiallyMatchedEventPatternMatch;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.PartiallyMatchedEventPatternMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.TokenInTrapStateMatch;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.TokenInTrapStateMatcher;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.evm.api.Job;
import org.eclipse.incquery.runtime.evm.api.RuleSpecification;
import org.eclipse.incquery.runtime.evm.specific.Lifecycles;
import org.eclipse.incquery.runtime.evm.specific.Rules;
import org.eclipse.incquery.runtime.evm.specific.event.IncQueryActivationStateEnum;
import org.eclipse.incquery.runtime.evm.specific.job.StatelessJob;
import org.eclipse.incquery.runtime.evm.specific.lifecycle.DefaultActivationLifeCycle;
import org.eclipse.incquery.runtime.exception.IncQueryException;

public class ModelHandlerRules {
	private Map<RuleSpecification<?>, Integer> modelHandlers;
	private EventModelManager eventModelManager;

	public ModelHandlerRules(EventModelManager eventModelManager) {
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

	public Map<RuleSpecification<?>, Integer> getModelHandlers() {
		return modelHandlers;
	}

	public RuleSpecification<FinishedStateMachineMatch> getFinishedStateMachineRule() throws IncQueryException {
		IMatchProcessor<FinishedStateMachineMatch> processor = new IMatchProcessor<FinishedStateMachineMatch>() {

			@Override
			public void process(FinishedStateMachineMatch match) {
				StateMachine sm = match.getSm();
				// log(sm);

				FinalState finalState = eventModelManager.getFinalStatesForStatemachines().get(sm);

				finalState.getEventTokens().remove(0);

				// forward the observed pattern in a DTO
				ObservedComplexEventPattern observedPattern = new SimpleObservedComplexEventPattern(
						sm.getEventPattern());
				eventModelManager.getRealm().forwardObservedEventPattern(observedPattern);
			}

		};

		Set<Job<FinishedStateMachineMatch>> jobs = new HashSet<Job<FinishedStateMachineMatch>>();
		jobs.add(new StatelessJob<FinishedStateMachineMatch>(IncQueryActivationStateEnum.APPEARED, processor));

		RuleSpecification<FinishedStateMachineMatch> spec = Rules.newSimpleMatcherRuleSpecification(
		// FinishedStateMachineMatcher.querySpecification(),
		// Lifecycles.getDefault(false, false), jobs);
				FinishedStateMachineMatcher.querySpecification(), DefaultActivationLifeCycle.DEFAULT, jobs);

		return spec;
	}

	// private void log(StateMachine sm){
	// System.err.println("\tIQ: " + sm.getEventPattern().getId() +
	// " MATCHED!");
	// }
	//
	// private void log(EventToken et) {
	// System.err.println("\tIQ: Events recorded by the CurrentStateVisitor: ");
	// Object recordedEvents = et.getEventCollection().getRecordedEvents();
	// if (!(recordedEvents instanceof Multimap<?, ?>)) {
	// return;
	// }
	// @SuppressWarnings("unchecked")
	// Multimap<String, Event> eventMap = (Multimap<String, Event>)
	// et.getEventCollection().getRecordedEvents();
	// for (Event event : eventMap.values()) {
	// System.err.println("\t\t" + event.getTypeId());
	// }
	// }

	public RuleSpecification<EnabledTransitionMatch> getEnabledTransitionsRule() throws IncQueryException {
		IMatchProcessor<EnabledTransitionMatch> processor = new IMatchProcessor<EnabledTransitionMatch>() {

			@Override
			public void process(EnabledTransitionMatch match) {
				Transition t = match.getT();
				// log(t);
				EventToken et = match.getEt();
				eventModelManager.getStrategy().fireTransition(t, et);
			}
		};

		Set<Job<EnabledTransitionMatch>> jobs = new HashSet<Job<EnabledTransitionMatch>>();
		jobs.add(new StatelessJob<EnabledTransitionMatch>(IncQueryActivationStateEnum.APPEARED, processor));

		RuleSpecification<EnabledTransitionMatch> spec = Rules.newSimpleMatcherRuleSpecification(
		// EnabledTransitionMatcher.querySpecification(),
		// Lifecycles.getDefault(false, false), jobs);
				EnabledTransitionMatcher.querySpecification(), Lifecycles.getDefault(false, false), jobs);

		return spec;
	}

	// private void log(Transition t) {
	// StateMachine sm = (StateMachine) t.getPostState().eContainer();
	// System.err.println("\tIQ: enabled transition in SM for pattern "
	// + sm.getEventPattern().getClass().getSimpleName());
	// }

	public RuleSpecification<TokenInTrapStateMatch> getTokenInTrapStateRule() throws IncQueryException {
		IMatchProcessor<TokenInTrapStateMatch> processor = new IMatchProcessor<TokenInTrapStateMatch>() {

			@Override
			public void process(TokenInTrapStateMatch match) {
				EventToken et = match.getEt();
				State currentState = et.getCurrentState();
				if (!(currentState instanceof TrapState)) {
					return;
				}

				// TODO start timer
				System.out.println("\t\t\t>>>>>>>>>Event token found in the trap state for pattern "
						+ ((StateMachine) et.getCurrentState().eContainer()).getEventPattern().getId());

				currentState.getEventTokens().clear();
			}
		};

		Set<Job<TokenInTrapStateMatch>> jobs = new HashSet<Job<TokenInTrapStateMatch>>();
		jobs.add(new StatelessJob<TokenInTrapStateMatch>(IncQueryActivationStateEnum.APPEARED, processor));

		RuleSpecification<TokenInTrapStateMatch> spec = Rules.newSimpleMatcherRuleSpecification(
		// TokenInTrapStateMatcher.querySpecification(),
		// Lifecycles.getDefault(false, false), jobs);
				TokenInTrapStateMatcher.querySpecification(), Lifecycles.getDefault(false, false), jobs);

		return spec;
	}

	public RuleSpecification<PartiallyMatchedEventPatternMatch> getPartiallyMatchedEventPatternRule()
			throws IncQueryException {
		IMatchProcessor<PartiallyMatchedEventPatternMatch> processor = new IMatchProcessor<PartiallyMatchedEventPatternMatch>() {

			@Override
			public void process(PartiallyMatchedEventPatternMatch match) {
				EventToken et = match.getEt();
				State currentState = et.getCurrentState();
				if (currentState instanceof InitState) {
					return;
				}

				String id = ((StateMachine) et.getCurrentState().eContainer()).getEventPattern().getId();
				System.out.println("\t\t\t>>>>>>>>>Partially matched event pattern found: " + id
						+ " It's going to be reset.");

				currentState.getEventTokens().clear();
			}
		};

		Set<Job<PartiallyMatchedEventPatternMatch>> jobs = new HashSet<Job<PartiallyMatchedEventPatternMatch>>();
		jobs.add(new StatelessJob<PartiallyMatchedEventPatternMatch>(IncQueryActivationStateEnum.APPEARED, processor));

		RuleSpecification<PartiallyMatchedEventPatternMatch> spec = Rules.newSimpleMatcherRuleSpecification(
		// TokenInTrapStateMatcher.querySpecification(),
		// Lifecycles.getDefault(false, false), jobs);
				PartiallyMatchedEventPatternMatcher.querySpecification(), Lifecycles.getDefault(false, false), jobs);

		return spec;
	}
}