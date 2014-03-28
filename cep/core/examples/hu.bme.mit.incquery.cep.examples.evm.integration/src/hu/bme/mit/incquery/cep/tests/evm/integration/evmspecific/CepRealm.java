package hu.bme.mit.incquery.cep.tests.evm.integration.evmspecific;

import hu.bme.mit.incquery.cep.api.evm.ObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.tests.evm.integration.eventpatterns.APattern;

import java.util.Set;

import org.eclipse.incquery.runtime.evm.api.event.EventRealm;

import com.google.common.collect.Sets;

public class CepRealm implements EventRealm {
	
	private Set<CepEventSource> sources = Sets.newHashSet();
	
	public void addSource(CepEventSource cepEventSource) {
		sources.add(cepEventSource);
	}
	
	public void generateEvent(CepEventType type) {
		ObservedComplexEventPattern op = new ObservedComplexEventPattern(new APattern());
		
		for (CepEventSource source : sources) {
			source.pushEvent(type, op);
		}
	}
	
}
