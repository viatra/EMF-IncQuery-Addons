package hu.bme.mit.incquery.cep.runtime.evaluation;

import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor;
import hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.enabledtransition.EnabledTransitionMatch;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.enabledtransition.EnabledTransitionMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.finishedstatemachine.FinishedStateMachineMatch;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.finishedstatemachine.FinishedStateMachineMatcher;
import hu.bme.mit.incquery.cep.runtime.evm.CepRuleInstance;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.MatchUpdateAdapter;
import org.eclipse.incquery.runtime.evm.api.Activation;
import org.eclipse.incquery.runtime.evm.api.ActivationState;
import org.eclipse.incquery.runtime.evm.api.Job;
import org.eclipse.incquery.runtime.evm.api.RuleSpecification;
import org.eclipse.incquery.runtime.evm.specific.job.StatelessJob;
import org.eclipse.incquery.runtime.evm.specific.lifecycle.DefaultActivationLifeCycle;
import org.eclipse.incquery.runtime.evm.specific.rule.SimpleMatcherRuleSpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;

import com.google.common.collect.Multimap;

public class ModelHandlerRules {
	private static ModelHandlerRules instance;
	private Set<RuleSpecification> modelHandlers;
	private List<CepRuleInstance<?>> eventHandlers;
	
	private ModelHandlerRules() {
		modelHandlers = new HashSet<RuleSpecification>();
		
		try {
			modelHandlers.add(getEnabledTransitionsRule());
			modelHandlers.add(getFinishedStateMachineRule());
		} catch (IncQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static ModelHandlerRules getIntance() {
		if (instance == null) {
			instance = new ModelHandlerRules();
		}
		return instance;
	}
	
	public void assignEventHandlers(List<CepRuleInstance<?>> e) {
		eventHandlers = e;
	}
	
	public Set<RuleSpecification> getModelHandlers() {
		return modelHandlers;
	}
	
	public RuleSpecification getFinishedStateMachineRule() throws IncQueryException {
		IMatchProcessor<FinishedStateMachineMatch> processor = new IMatchProcessor<FinishedStateMachineMatch>() {
			
			@Override
			public void process(FinishedStateMachineMatch match) {
				for (CepRuleInstance<?> ri : eventHandlers) {
					Collection<Activation> allActivations = ri.getAllActivations();
					Iterator<Activation> iterator = allActivations.iterator();
					while (iterator.hasNext()) {
						Activation a = iterator.next();
						ri.fire(a, EventModelManager.getInstance().getExecutionSchema().getContext());
					}
					
				}
				
				StateMachine sm = match.getSm();
				System.err.println("\tIQ: " + sm.getEventPattern().getId() + " MATCHED!");
				
				for (State s : sm.getStates()) {
					if (s instanceof FinalState) {
						CopyOnWriteArrayList<CurrentStateVisitor> currentVisitors = new CopyOnWriteArrayList<CurrentStateVisitor>();
						currentVisitors.addAll(s.getCurrentVisitors());
						for (CurrentStateVisitor cv : currentVisitors) {
							System.err.println("\tIQ: Events recorded by the CurrentStateVisitor: ");
							Object recordedEvents = cv.getEventCollection().getRecordedEvents();
							if (!(recordedEvents instanceof Multimap<?, ?>)) {
								continue;
							}
							@SuppressWarnings("unchecked")
							Multimap<String, Event> eventMap = (Multimap<String, Event>) cv.getEventCollection()
									.getRecordedEvents();
							for (Event event : eventMap.values()) {
								System.err.println("\t\t" + event.getTypeId());
							}
							
							s.getCurrentVisitors().remove(cv);
						}
					}
				}
			}
			
		};
		
		Set<Job> jobs = new HashSet<Job>();
		jobs.add(new StatelessJob<FinishedStateMachineMatch>(ActivationState.APPEARED, processor));
		
		SimpleMatcherRuleSpecification<FinishedStateMachineMatch> spec = new SimpleMatcherRuleSpecification<FinishedStateMachineMatch>(
				FinishedStateMachineMatcher.factory(), DefaultActivationLifeCycle.DEFAULT, jobs);
		
		return spec;
	}
	public RuleSpecification getEnabledTransitionsRule() throws IncQueryException {
		IMatchProcessor<EnabledTransitionMatch> processor = new IMatchProcessor<EnabledTransitionMatch>() {
			
			@Override
			public void process(EnabledTransitionMatch match) {
				Transition t = match.getT();
				StateMachine sm = (StateMachine) t.getPostState().eContainer();
				System.err.println("\tIQ: enabled transition in SM for pattern "
						+ sm.getEventPattern().getClass().getSimpleName());
				EventModelManager.getInstance().getStrategy().fireTransition(t);
			}
		};
		
		Set<Job> jobs = new HashSet<Job>();
		jobs.add(new StatelessJob<EnabledTransitionMatch>(ActivationState.APPEARED, processor));
		
		SimpleMatcherRuleSpecification<EnabledTransitionMatch> spec = new SimpleMatcherRuleSpecification<EnabledTransitionMatch>(
				EnabledTransitionMatcher.factory(), DefaultActivationLifeCycle.DEFAULT, jobs);
		
		return spec;
	}
}