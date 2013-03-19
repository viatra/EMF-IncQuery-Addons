package hu.bme.mit.obsolete.incquery.cep.eventmodel;

import java.util.List;

import javax.naming.OperationNotSupportedException;

/**
 * Complex pattern consisting of many {@link AtomicEventPattern}s. It is
 * recognized, i.e. fully matched if every AtomicEventPattern has been matched.
 * 
 * TODO
 * 	- remove OperationNotSupportedException from the signature by implementing 
 * 		the state-machine based evaluation as discussed with Istvan
 * 
 * @author Istvan David
 * 
 */
public class ComplexEventPattern extends AbstractEventPattern {
	private ComplexOperator operator;
	private Timewindow timewindow;
	
	public ComplexEventPattern(List<IEventPattern> compositionEventPatterns, ComplexOperator operator) {
		super();
		this.compositionEvents = compositionEventPatterns;
		this.operator = operator;
	}
	
	public ComplexEventPattern(List<IEventPattern> compositionEventPatterns, ComplexOperator operator,
			Timewindow timewindow) {
		super();
		this.compositionEvents = compositionEventPatterns;
		this.operator = operator;
		this.timewindow = timewindow;
	}
	
	public void addCompositionEventPattern(IEventPattern compositionEventPattern) {
		compositionEvents.add(compositionEventPattern);
	}
	
	@Override
	public boolean match(Event event) throws OperationNotSupportedException {
		if (!(compositionEvents.get(0) instanceof AtomicEventPattern)) {
			throw new OperationNotSupportedException();
		}
		AtomicEventPattern firstAtomicComponent = (AtomicEventPattern) compositionEvents.get(0);
		if (event.getClass().equals(firstAtomicComponent.getType())) {
			return true;
		}
		return false;
	}
	
	public ComplexOperator getOperator() {
		return operator;
	}
	
	public Timewindow getTimewindow() {
		return timewindow;
	}
}
