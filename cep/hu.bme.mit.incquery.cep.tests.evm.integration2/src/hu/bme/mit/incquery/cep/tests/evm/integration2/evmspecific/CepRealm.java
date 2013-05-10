package hu.bme.mit.incquery.cep.tests.evm.integration2.evmspecific;

import hu.bme.mit.incquery.cep.api.ObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.api.SimpleObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.tests.evm.integration2.APattern;

import java.util.Set;

import org.eclipse.incquery.runtime.evm.api.event.EventRealm;

import com.google.common.collect.Sets;

public class CepRealm implements EventRealm {
	
	private Set<CepEventSource> sources = Sets.newHashSet();
	
	public void addSource(CepEventSource cepEventSource) {
		sources.add(cepEventSource);
	}
	
	public void generateEvent(CepEventType type) {
		ObservedComplexEventPattern op = new SimpleObservedComplexEventPattern(new APattern());
		
		for (CepEventSource source : sources) {
			source.pushEvent(type, op);
		}
	}
	
}
