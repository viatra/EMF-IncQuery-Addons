package hu.bme.mit.incquery.cep.runtime.evm;

import java.util.Set;

import org.eclipse.incquery.runtime.evm.api.ActivationLifeCycle;
import org.eclipse.incquery.runtime.evm.api.Job;
import org.eclipse.incquery.runtime.evm.api.RuleInstance;
import org.eclipse.incquery.runtime.evm.api.RuleSpecification;
import org.eclipse.incquery.runtime.evm.api.event.Atom;
import org.eclipse.incquery.runtime.evm.api.event.EventSource;

public class CepRuleSpecification extends RuleSpecification {
	
	public CepRuleSpecification(ActivationLifeCycle lifeCycle, Set<Job> jobs) {
		super(lifeCycle, jobs);
	}
	
	@Override
	protected RuleInstance instantiateRule(EventSource eventSource, Atom filter) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
