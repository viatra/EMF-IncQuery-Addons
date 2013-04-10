package hu.bme.mit.incquery.cep.tests.evm.integration.example.usage;

import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor;
import hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.runtime.api.IEventPatternMatch;
import hu.bme.mit.incquery.cep.runtime.api.IEventPatternMatchProcessor;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.finishedstatemachine.FinishedStateMachineMatch;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.finishedstatemachine.FinishedStateMachineMatcher;
import hu.bme.mit.incquery.cep.tests.evm.integration.generated.a.AEventPatternMatch;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.evm.api.ActivationState;
import org.eclipse.incquery.runtime.evm.api.Job;
import org.eclipse.incquery.runtime.evm.api.RuleSpecification;
import org.eclipse.incquery.runtime.evm.specific.DefaultActivationLifeCycle;
import org.eclipse.incquery.runtime.evm.specific.SimpleMatcherRuleSpecification;
import org.eclipse.incquery.runtime.evm.specific.StatelessJob;
import org.eclipse.incquery.runtime.exception.IncQueryException;

import com.google.common.collect.Multimap;

public class Example {
	public RuleSpecification<AEventPatternMatch> getFinishedStateMachineRule() throws IncQueryException {
		IEventPatternMatchProcessor<AEventPatternMatch> processor = new IEventPatternMatchProcessor<AEventPatternMatch>() {
			
			@Override
			public void process(AEventPatternMatch match) {
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
		
		Set<Job<FinishedStateMachineMatch>> jobs = new HashSet<Job<FinishedStateMachineMatch>>();
		jobs.add(new StatelessJob<FinishedStateMachineMatch>(ActivationState.APPEARED, processor));
		
		SimpleMatcherRuleSpecification<FinishedStateMachineMatch, FinishedStateMachineMatcher> spec = new SimpleMatcherRuleSpecification<FinishedStateMachineMatch, FinishedStateMachineMatcher>(
				FinishedStateMachineMatcher.factory(), DefaultActivationLifeCycle.DEFAULT, jobs);
		
		return spec;
		
	}
}
