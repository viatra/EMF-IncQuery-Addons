package hu.bme.mit.incquery.cep.runtime.evaluation;

import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.enabledtransition.EnabledTransitionMatch;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.enabledtransition.EnabledTransitionMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.finishedstatemachine.FinishedStateMachineMatch;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.finishedstatemachine.FinishedStateMachineMatcher;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.evm.api.ActivationState;
import org.eclipse.incquery.runtime.evm.api.Job;
import org.eclipse.incquery.runtime.evm.api.RuleSpecification;
import org.eclipse.incquery.runtime.evm.specific.DefaultActivationLifeCycle;
import org.eclipse.incquery.runtime.evm.specific.SimpleMatcherRuleSpecification;
import org.eclipse.incquery.runtime.evm.specific.StatelessJob;
import org.eclipse.incquery.runtime.exception.IncQueryException;

public class ModelHandlerRules {
	private static ModelHandlerRules instance;
	private List<RuleSpecification<? extends IPatternMatch>> modelHandlers;
	
	private ModelHandlerRules() {
		modelHandlers = new ArrayList<RuleSpecification<? extends IPatternMatch>>();
		
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
	
	public List<RuleSpecification<? extends IPatternMatch>> getModelHandlers() {
		return modelHandlers;
	}
	public RuleSpecification<FinishedStateMachineMatch> getFinishedStateMachineRule() throws IncQueryException {
		IMatchProcessor<FinishedStateMachineMatch> processor = new IMatchProcessor<FinishedStateMachineMatch>() {
			
			@Override
			public void process(FinishedStateMachineMatch match) {
				StateMachine sm = match.getSm();
				System.err.println("IQ: " + sm.getEventPattern().getId() + " MATCHED!");
				if (sm.eContainer() instanceof InternalExecutionModel) {
					InternalExecutionModel model = (InternalExecutionModel) sm.eContainer();
					model.getStateMachines().remove(sm);
				}
			}
		};
		
		Set<Job<FinishedStateMachineMatch>> jobs = new HashSet<Job<FinishedStateMachineMatch>>();
		jobs.add(new StatelessJob<FinishedStateMachineMatch>(ActivationState.APPEARED, processor));
		
		SimpleMatcherRuleSpecification<FinishedStateMachineMatch, IncQueryMatcher<FinishedStateMachineMatch>> spec = new SimpleMatcherRuleSpecification(
				FinishedStateMachineMatcher.factory(), DefaultActivationLifeCycle.DEFAULT, jobs);
		
		return spec;
	}
	public RuleSpecification<EnabledTransitionMatch> getEnabledTransitionsRule() throws IncQueryException {
		IMatchProcessor<EnabledTransitionMatch> processor = new IMatchProcessor<EnabledTransitionMatch>() {
			
			@Override
			public void process(EnabledTransitionMatch match) {
				Transition t = match.getT();
				if (t.getPreState().eContainer() instanceof StateMachine) {
					StateMachine sm = (StateMachine) t.getPreState().eContainer();
					SMUtils.fireTransition(sm, t);
				}
			}
		};
		
		Set<Job<EnabledTransitionMatch>> jobs = new HashSet<Job<EnabledTransitionMatch>>();
		jobs.add(new StatelessJob<EnabledTransitionMatch>(ActivationState.APPEARED, processor));
		
		SimpleMatcherRuleSpecification<EnabledTransitionMatch, IncQueryMatcher<EnabledTransitionMatch>> spec = new SimpleMatcherRuleSpecification(
				EnabledTransitionMatcher.factory(), DefaultActivationLifeCycle.DEFAULT_NO_UPDATE, jobs);
		
		return spec;
	}
}