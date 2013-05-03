package hu.bme.mit.incquery.cep.runtime.evm;

import java.util.Set;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.evm.api.ActivationLifeCycle;
import org.eclipse.incquery.runtime.evm.api.Job;
import org.eclipse.incquery.runtime.evm.api.RuleInstance;
import org.eclipse.incquery.runtime.evm.api.RuleSpecification;
import org.eclipse.incquery.runtime.evm.api.event.Atom;
import org.eclipse.incquery.runtime.evm.api.event.EventSource;
import org.eclipse.incquery.runtime.evm.specific.event.IncQueryEventSource;

public class CepRuleSpecification extends RuleSpecification {
	
	public CepRuleSpecification(ActivationLifeCycle lifeCycle, Set<Job> jobs) {
		super(lifeCycle, jobs);
	}
	
	@Override
	protected RuleInstance instantiateRule(EventSource eventSource, Atom filter) {
		CepRuleInstance ruleInstance = null;
		if (eventSource instanceof IncQueryEventSource) {
			IncQueryEngine engine = ((IncQueryEventSource) eventSource).getEngine();
			try {
				ruleInstance = new CepRuleInstance(this, filter);
				ruleInstance.prepareAttributeMonitor();
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}
		} else {
			eventSource.getLogger().error(
					"Cannot instantiate rule with EvenSource " + eventSource + "! Should be IncQueryEventSource.");
		}
		return ruleInstance;
	}
	
}