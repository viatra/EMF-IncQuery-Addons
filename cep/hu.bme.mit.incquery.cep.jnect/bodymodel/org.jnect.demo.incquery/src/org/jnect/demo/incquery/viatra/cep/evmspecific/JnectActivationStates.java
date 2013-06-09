package org.jnect.demo.incquery.viatra.cep.evmspecific;

import org.eclipse.incquery.runtime.evm.api.event.ActivationState;

public enum JnectActivationStates implements ActivationState {
	INACTIVE, ACTIVE;
	
	@Override
	public boolean isInactive() {
		return this.equals(INACTIVE);
	}
}
