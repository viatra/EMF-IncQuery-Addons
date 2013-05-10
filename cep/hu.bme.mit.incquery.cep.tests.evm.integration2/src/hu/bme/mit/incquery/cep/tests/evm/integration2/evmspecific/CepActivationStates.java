package hu.bme.mit.incquery.cep.tests.evm.integration2.evmspecific;

import org.eclipse.incquery.runtime.evm.api.event.ActivationState;

public enum CepActivationStates implements ActivationState {
	IS_NOT, IS;
	
	@Override
	public boolean isInactive() {
		return this.equals(IS_NOT);
	}
}
