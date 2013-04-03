package hu.bme.mit.incquery.cep.tests.jobs;

import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;
import hu.bme.mit.incquery.cep.runtime.evaluation.SMUtils;
import hu.bme.mit.incquery.cep.tests.testcasesmqueries.cevent.CEventMatch;
import hu.bme.mit.incquery.cep.tests.testcasesmqueries.cevent.CEventMatcher;
import hu.bme.mit.incquery.cep.tests.testcasesmqueries.enabledtransition.EnabledTransitionMatch;
import hu.bme.mit.incquery.cep.tests.testcasesmqueries.enabledtransition.EnabledTransitionMatcher;
import hu.bme.mit.incquery.cep.tests.testcasesmqueries.finishedstatemachine.FinishedStateMachineMatch;
import hu.bme.mit.incquery.cep.tests.testcasesmqueries.finishedstatemachine.FinishedStateMachineMatcher;
import hu.bme.mit.incquery.cep.tests.testcasesmqueries.transition.TransitionMatch;
import hu.bme.mit.incquery.cep.tests.testcasesmqueries.transition.TransitionMatcher;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.evm.api.ActivationState;
import org.eclipse.incquery.runtime.evm.api.Job;
import org.eclipse.incquery.runtime.evm.api.RuleSpecification;
import org.eclipse.incquery.runtime.evm.specific.DefaultActivationLifeCycle;
import org.eclipse.incquery.runtime.evm.specific.SimpleMatcherRuleSpecification;
import org.eclipse.incquery.runtime.evm.specific.StatelessJob;
import org.eclipse.incquery.runtime.exception.IncQueryException;

public class RulesAndJobs {
	private static RulesAndJobs instance;
	
	private RulesAndJobs() {}
	
	public static RulesAndJobs getIntance() {
		if (instance == null) {
			instance = new RulesAndJobs();
		}
		return instance;
	}
	
	public RuleSpecification<FinishedStateMachineMatch> getFinishedStateMachineRule() throws IncQueryException {
		IMatchProcessor<FinishedStateMachineMatch> processor = new IMatchProcessor<FinishedStateMachineMatch>() {
			
			@Override
			public void process(FinishedStateMachineMatch match) {
				StateMachine sm = match.getSm();
				System.out.println("IQ: " + sm.getEventPattern().getId() + " MATCHED!");
				if (sm.eContainer() instanceof InternalExecutionModel) {
					InternalExecutionModel model = (InternalExecutionModel) sm.eContainer();
					model.getStateMachines().remove(sm);
				}
			}
		};
		
		Set<Job<FinishedStateMachineMatch>> jobs = new HashSet<Job<FinishedStateMachineMatch>>();
		jobs.add(new StatelessJob<FinishedStateMachineMatch>(ActivationState.APPEARED, processor));
		
		SimpleMatcherRuleSpecification<FinishedStateMachineMatch, IncQueryMatcher<FinishedStateMachineMatch>> spec = new SimpleMatcherRuleSpecification(
				FinishedStateMachineMatcher.factory(), DefaultActivationLifeCycle.DEFAULT_NO_UPDATE, jobs);
		
		return spec;
	}
	
	public RuleSpecification<EnabledTransitionMatch> getEnabledTransitionsRule() throws IncQueryException {
		IMatchProcessor<EnabledTransitionMatch> processor = new IMatchProcessor<EnabledTransitionMatch>() {
			
			@Override
			public void process(EnabledTransitionMatch match) {
				Transition t = match.getT();
				System.out.println("IQ: enabled transition: " + t.getPreState().getClass().getCanonicalName() + "->"
						+ t.getPostState().getClass().getCanonicalName());
				
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
	public RuleSpecification<TransitionMatch> getTransitionRule() throws IncQueryException {
		IMatchProcessor<TransitionMatch> processor = new IMatchProcessor<TransitionMatch>() {
			
			@Override
			public void process(TransitionMatch match) {
				System.out.println("IQ:  transition");
				Transition t = match.getT();
			}
		};
		
		Set<Job<TransitionMatch>> jobs = new HashSet<Job<TransitionMatch>>();
		jobs.add(new StatelessJob<TransitionMatch>(ActivationState.APPEARED, processor));
		
		SimpleMatcherRuleSpecification<TransitionMatch, IncQueryMatcher<TransitionMatch>> spec = new SimpleMatcherRuleSpecification(
				TransitionMatcher.factory(), DefaultActivationLifeCycle.DEFAULT_NO_UPDATE, jobs);
		
		return spec;
	}
	
	public RuleSpecification<CEventMatch> getCEventRule() throws IncQueryException {
		IMatchProcessor<CEventMatch> processor = new IMatchProcessor<CEventMatch>() {
			
			@Override
			public void process(CEventMatch match) {
				System.out.println("IQ: C EVENT ARRIVED!");
			}
		};
		
		Set<Job<CEventMatch>> jobs = new HashSet<Job<CEventMatch>>();
		jobs.add(new StatelessJob<CEventMatch>(ActivationState.APPEARED, processor));
		
		SimpleMatcherRuleSpecification<CEventMatch, IncQueryMatcher<CEventMatch>> spec = new SimpleMatcherRuleSpecification(
				CEventMatcher.factory(), DefaultActivationLifeCycle.DEFAULT_NO_UPDATE, jobs);
		
		return spec;
	}
}