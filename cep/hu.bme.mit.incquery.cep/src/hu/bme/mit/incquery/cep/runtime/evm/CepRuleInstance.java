package hu.bme.mit.incquery.cep.runtime.evm;

import org.apache.log4j.Logger;
import org.eclipse.incquery.runtime.evm.api.RuleInstance;
import org.eclipse.incquery.runtime.evm.api.RuleSpecification;
import org.eclipse.incquery.runtime.evm.api.event.Atom;
import org.eclipse.incquery.runtime.evm.notification.AttributeMonitor;
import org.eclipse.incquery.runtime.evm.notification.IAttributeMonitorListener;

public class CepRuleInstance<Match extends EventPatternMatch> extends RuleInstance {
	
	protected CepRuleInstance(RuleSpecification specification, Atom filter) {
		super(specification, filter);
	}
	
	@Override
	protected AttributeMonitor prepareAttributeMonitor() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected IAttributeMonitorListener prepareAttributeMonitorListener() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected Logger getLogger() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
