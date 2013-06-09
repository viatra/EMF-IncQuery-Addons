package hu.bme.mit.incquery.cep.runtime.evaluation;

import hu.bme.mit.incquery.cep.api.ObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.api.SimpleObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor;
import hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.EnabledTransitionMatch;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.EnabledTransitionMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.FinishedStateMachineMatch;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.FinishedStateMachineMatcher;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.evm.api.Job;
import org.eclipse.incquery.runtime.evm.api.RuleSpecification;
import org.eclipse.incquery.runtime.evm.specific.Rules;
import org.eclipse.incquery.runtime.evm.specific.event.IncQueryActivationStateEnum;
import org.eclipse.incquery.runtime.evm.specific.job.StatelessJob;
import org.eclipse.incquery.runtime.evm.specific.lifecycle.DefaultActivationLifeCycle;
import org.eclipse.incquery.runtime.exception.IncQueryException;

import com.google.common.collect.Multimap;

public class ModelHandlerRules {
	private Set<RuleSpecification<?>> modelHandlers;
	private EventModelManager eventModelManager;

	public ModelHandlerRules(EventModelManager eventModelManager) {
		this.eventModelManager = eventModelManager;

		modelHandlers = new HashSet<RuleSpecification<?>>();
		try {
			modelHandlers.add(getEnabledTransitionsRule());
			modelHandlers.add(getFinishedStateMachineRule());
		} catch (IncQueryException e) {
			e.printStackTrace();
		}

	}

	public Set<RuleSpecification<?>> getModelHandlers() {
		return modelHandlers;
	}

	public RuleSpecification<FinishedStateMachineMatch> getFinishedStateMachineRule()
			throws IncQueryException {
		IMatchProcessor<FinishedStateMachineMatch> processor = new IMatchProcessor<FinishedStateMachineMatch>() {

			@Override
			public void process(FinishedStateMachineMatch match) {
				StateMachine sm = match.getSm();
				System.err.println("\tIQ: " + sm.getEventPattern().getId()
						+ " MATCHED!");

				// forward the observed pattern in a DTO
				ObservedComplexEventPattern observedPattern = new SimpleObservedComplexEventPattern(
						sm.getEventPattern());
				eventModelManager.getRealm().forwardObservedEventPattern(
						observedPattern);

				for (State s : sm.getStates()) {
					if (s instanceof FinalState) {
						CopyOnWriteArrayList<CurrentStateVisitor> currentVisitors = new CopyOnWriteArrayList<CurrentStateVisitor>();
						currentVisitors.addAll(s.getCurrentVisitors());
						for (CurrentStateVisitor cv : currentVisitors) {
							System.err
									.println("\tIQ: Events recorded by the CurrentStateVisitor: ");
							Object recordedEvents = cv.getEventCollection()
									.getRecordedEvents();
							if (!(recordedEvents instanceof Multimap<?, ?>)) {
								continue;
							}
							@SuppressWarnings("unchecked")
							Multimap<String, Event> eventMap = (Multimap<String, Event>) cv
									.getEventCollection().getRecordedEvents();
							for (Event event : eventMap.values()) {
								System.err.println("\t\t" + event.getTypeId());
							}

							s.getCurrentVisitors().remove(cv);
						}
					}
				}
			}

		};

		Set<Job<FinishedStateMachineMatch>> jobs = new HashSet<Job<FinishedStateMachineMatch>>();
		jobs.add(new StatelessJob<FinishedStateMachineMatch>(
				IncQueryActivationStateEnum.APPEARED, processor));

		RuleSpecification<FinishedStateMachineMatch> spec = Rules
				.newSimpleMatcherRuleSpecification(
						FinishedStateMachineMatcher.querySpecification(),
						DefaultActivationLifeCycle.DEFAULT, jobs);

		return spec;
	}

	public RuleSpecification<EnabledTransitionMatch> getEnabledTransitionsRule()
			throws IncQueryException {
		IMatchProcessor<EnabledTransitionMatch> processor = new IMatchProcessor<EnabledTransitionMatch>() {

			@Override
			public void process(EnabledTransitionMatch match) {
				Transition t = match.getT();
				StateMachine sm = (StateMachine) t.getPostState().eContainer();
				System.err
						.println("\tIQ: enabled transition in SM for pattern "
								+ sm.getEventPattern().getClass()
										.getSimpleName());
				eventModelManager.getStrategy().fireTransition(t);
			}
		};

		Set<Job<EnabledTransitionMatch>> jobs = new HashSet<Job<EnabledTransitionMatch>>();
		jobs.add(new StatelessJob<EnabledTransitionMatch>(
				IncQueryActivationStateEnum.APPEARED, processor));

		RuleSpecification<EnabledTransitionMatch> spec = Rules
				.newSimpleMatcherRuleSpecification(
						EnabledTransitionMatcher.querySpecification(),
						DefaultActivationLifeCycle.DEFAULT, jobs);

		return spec;
	}
}