package hu.bme.mit.incquery.cep.casestudy.transaction.gen.patterns.atomic;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

public class CompoundTransactionIncQueryEventPattern extends AtomicEventPatternImpl {
	public CompoundTransactionIncQueryEventPattern() {
		super();
		setType(hu.bme.mit.incquery.cep.casestudy.transaction.gen.events.CompoundTransactionIncQueryEvent.class
				.getCanonicalName());
		setId("CompoundTransactionIncQueryEventPattern");
	}

	public boolean checkStaticBindings() {
		return true;
	}
}
