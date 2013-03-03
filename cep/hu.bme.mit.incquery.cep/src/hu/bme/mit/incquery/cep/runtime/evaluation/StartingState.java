package hu.bme.mit.incquery.cep.runtime.evaluation;

public abstract class StartingState implements IState {
	
	@Override
	public boolean isTimedOut() {
		return false;
	}
}
