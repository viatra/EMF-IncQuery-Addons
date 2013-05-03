package hu.bme.mit.incquery.cep.tests.evm.integration.main;
import hu.bme.mit.incquery.cep.runtime.evm.CepRuleSpecification;
import hu.bme.mit.incquery.cep.runtime.evm.EventPatternMatch;
import hu.bme.mit.incquery.cep.tests.evm.integration.evmspecific.ABCPatternMatch;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.evm.api.ActivationState;
import org.eclipse.incquery.runtime.evm.api.Job;
import org.eclipse.incquery.runtime.evm.specific.job.StatelessJob;
import org.eclipse.incquery.runtime.evm.specific.lifecycle.DefaultActivationLifeCycle;

public class RuleDefinitions {
	
	public static Set<CepRuleSpecification<EventPatternMatch>> getEventRules() {
		Set<CepRuleSpecification<EventPatternMatch>> ruleSpecs = new HashSet<CepRuleSpecification<EventPatternMatch>>();
		
		ruleSpecs.add(getABCPatternMatchRule());
		
		return ruleSpecs;
	}
	
	private static CepRuleSpecification<EventPatternMatch> getABCPatternMatchRule() {
		IMatchProcessor<ABCPatternMatch> processor = new IMatchProcessor<ABCPatternMatch>() {
			
			@Override
			public void process(ABCPatternMatch match) {
				System.out.println("Event pattern >>" + match.eventPattern().getId() + "<< matched!");
			}
		};
		
		Set<Job> jobs = new HashSet<Job>();
		jobs.add(new StatelessJob<ABCPatternMatch>(ActivationState.APPEARED, processor));
		
		CepRuleSpecification<EventPatternMatch> spec = new CepRuleSpecification<EventPatternMatch>(
				DefaultActivationLifeCycle.DEFAULT, jobs);
		
		return spec;
	}
}
