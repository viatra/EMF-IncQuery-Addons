package hu.bme.mit.incquery.cep.casestudy.transactionpackage;

import hu.bme.mit.incquery.cep.api.AbstractEventInstance;
import hu.bme.mit.incquery.cep.api.ICepRule;
import hu.bme.mit.incquery.cep.api.evm.ObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentA;
import hu.bme.mit.incquery.cep.casestudy.transaction.jobs.R1Job;
import hu.bme.mit.incquery.cep.casestudy.transaction.rules.R1;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;

import java.util.List;

import org.eclipse.incquery.runtime.evm.api.Job;

import com.google.common.collect.Lists;

public final class TransactionCepPackage {
	private static TransactionCepPackage instance;
	private List<ICepRule> rules = Lists.newArrayList();
	private List<AbstractEventInstance> eventClasses = Lists.newArrayList();
	private List<EventPattern> eventPatterns = Lists.newArrayList();
	
	public static TransactionCepPackage getInstance() {
		if (instance == null) {
			instance = new TransactionCepPackage();
		}
		return instance;
	}

	private TransactionCepPackage() {
		// TODO generate domain code here
		rules.add(new R1());
	}

	public List<ICepRule> getRules() {
		return rules;
	}

	public List<AbstractEventInstance> getEventClasses() {
		return eventClasses;
	}

	public List<EventPattern> getEventPatterns() {
		return eventPatterns;
	}
	
	public ComponentA createComponentA(IEventSource eventSource){
		return new ComponentA(eventSource);
	}
}
