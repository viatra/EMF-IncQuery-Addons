package org.jnect.demo.incquery.viatra.cep.evmspecific;

import java.util.Set;

import org.eclipse.incquery.runtime.evm.api.event.EventRealm;

import com.google.common.collect.Sets;

public class JnectRealm implements EventRealm {
	
	private Set<JnectEventSource> sources = Sets.newHashSet();
	
	public void addSource(JnectEventSource cepEventSource) {
		sources.add(cepEventSource);
	}
	
//	public void generateEvent(JnectEventType type) {
//		ObservedComplexEventPattern op = new SimpleObservedComplexEventPattern(new APattern());
//		
//		for (JnectEventSource source : sources) {
//			source.pushEvent(type, op);
//		}
//	}
	
}
