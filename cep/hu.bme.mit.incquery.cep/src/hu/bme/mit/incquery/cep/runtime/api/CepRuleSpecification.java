package hu.bme.mit.incquery.cep.runtime.api;

import java.util.Set;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.evm.api.ActivationLifeCycle;
import org.eclipse.incquery.runtime.evm.api.Job;
import org.eclipse.incquery.runtime.evm.api.RuleInstance;
import org.eclipse.incquery.runtime.evm.api.RuleSpecification;

public class CepRuleSpecification<Match extends EventPatternMatch> extends RuleSpecification<Match> {
	
	public CepRuleSpecification(ActivationLifeCycle lifeCycle, Set<Job<Match>> jobs) {
		super(lifeCycle, jobs);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected RuleInstance<Match> instantiateRule(IncQueryEngine engine) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
