package hu.bme.mit.incquery.cep.runtime.evm;

import org.eclipse.incquery.runtime.evm.api.event.Atom;

public class CepAtom implements Atom {
	
	@Override
	public boolean isCompatibleWith(Atom other) {
		if (this == other) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isMutable() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
