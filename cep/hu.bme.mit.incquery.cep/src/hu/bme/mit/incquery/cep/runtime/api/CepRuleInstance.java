package hu.bme.mit.incquery.cep.runtime.api;

import org.apache.log4j.Logger;
import org.eclipse.incquery.runtime.evm.api.RuleInstance;
import org.eclipse.incquery.runtime.evm.api.RuleSpecification;

public class CepRuleInstance<Match extends EventPatternMatch> extends RuleInstance<Match> {
	
	protected CepRuleInstance(RuleSpecification<Match> specification) {
		super(specification);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected Logger getLogger() {
		// TODO Auto-generated method stub
		return null;
	}
}
