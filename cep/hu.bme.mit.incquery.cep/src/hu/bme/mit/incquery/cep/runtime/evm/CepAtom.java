package hu.bme.mit.incquery.cep.runtime.evm;

import org.eclipse.incquery.runtime.evm.api.event.Atom;

public class CepAtom<Match extends EventPatternMatch> implements Atom {
	
	private Match match;
	
	public CepAtom(Match match) {
		this.match = match;
	}
	
	public Match getMatch() {
		return match;
	}
	
	@Override
	public boolean isCompatibleWith(Atom other) {
		if (this == other) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isMutable() {
		return false;
	}
	
	@Override
	public boolean isEmpty() {
		return false;
	}
}
