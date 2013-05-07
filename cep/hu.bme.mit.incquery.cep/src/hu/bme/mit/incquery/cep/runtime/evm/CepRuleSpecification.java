package hu.bme.mit.incquery.cep.runtime.evm;

import hu.bme.mit.incquery.cep.runtime.evaluation.ModelHandlerRules;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.incquery.runtime.evm.api.ActivationLifeCycle;
import org.eclipse.incquery.runtime.evm.api.Job;
import org.eclipse.incquery.runtime.evm.api.RuleInstance;
import org.eclipse.incquery.runtime.evm.api.RuleSpecification;
import org.eclipse.incquery.runtime.evm.api.event.Atom;
import org.eclipse.incquery.runtime.evm.api.event.EventSource;
import org.eclipse.incquery.runtime.evm.specific.event.IncQueryEventSource;

public class CepRuleSpecification<Match extends EventPatternMatch> extends RuleSpecification {
	
	public CepRuleSpecification(final ActivationLifeCycle lifeCycle, final Set<Job> jobs) {
		super(lifeCycle, jobs);
	}
	
	@Override
	protected RuleInstance instantiateRule(EventSource eventSource, Atom filter) {
		CepRuleInstance<Match> ruleInstance = null;
		if (eventSource instanceof IncQueryEventSource) {
			try {
				ruleInstance = new CepRuleInstance<Match>(this, filter);
				ruleInstance.prepareInstance();
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}
		} else {
			eventSource.getLogger().error(
					"Cannot instantiate rule with EvenSource " + eventSource + "! Should be IncQueryEventSource.");
		}
		
		List<CepRuleInstance<?>> list = new ArrayList<CepRuleInstance<?>>();
		list.add(ruleInstance);
		ModelHandlerRules.getIntance().assignEventHandlers(list);
		
		return ruleInstance;
	}
}