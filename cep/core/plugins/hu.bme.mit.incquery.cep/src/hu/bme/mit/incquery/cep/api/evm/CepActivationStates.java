package hu.bme.mit.incquery.cep.api.evm;

import org.eclipse.incquery.runtime.evm.api.event.ActivationState;

public enum CepActivationStates implements ActivationState {
	INACTIVE, ACTIVE;
	
	@Override
	public boolean isInactive() {
		return this.equals(INACTIVE);
	}
}
