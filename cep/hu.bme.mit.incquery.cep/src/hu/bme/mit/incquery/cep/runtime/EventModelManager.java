package hu.bme.mit.incquery.cep.runtime;

import hu.bme.mit.incquery.metamodels.cep.AbstractEventPattern;
import hu.bme.mit.incquery.metamodels.cep.AtomicEventPattern;
import hu.bme.mit.incquery.metamodels.cep.CepFactory;
import hu.bme.mit.incquery.metamodels.cep.ComplexEventPattern;
import hu.bme.mit.incquery.metamodels.cep.Event;
import hu.bme.mit.incquery.metamodels.cep.ManagedPatternRepository;
import hu.bme.mit.incquery.metamodels.internalsm.FinalState;
import hu.bme.mit.incquery.metamodels.internalsm.Guard;
import hu.bme.mit.incquery.metamodels.internalsm.InitState;
import hu.bme.mit.incquery.metamodels.internalsm.InternalsmFactory;
import hu.bme.mit.incquery.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.metamodels.internalsm.Transition;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

public class EventModelManager {
	private static EventModelManager instance;
	private ManagedPatternRepository model;
	private final CepFactory CEP_FACTORY = CepFactory.eINSTANCE;
	private final InternalsmFactory SM_FACTORY = InternalsmFactory.eINSTANCE;
	
	private EventModelManager() {
		this.model = CEP_FACTORY.createManagedPatternRepository();
		
		Adapter adapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification notification) {
				Object newValue = notification.getNewValue();
				if (newValue instanceof Event) {
					Event event = (Event) newValue;
					System.err.println("DIAG: Event " + event.getClass().getSimpleName() + " captured...");
					evaluateOnInternalSM(event);
				}
			}
		};
		EventQueue.getInstance().eAdapters().add(adapter);
	}
	
	public static EventModelManager getInstance() {
		if (instance == null) {
			instance = new EventModelManager();
		}
		return instance;
	}
	
	public ManagedPatternRepository getModel() {
		return model;
	}
	
	public void registerPatterns(List<AbstractEventPattern> eventPatterns) {
		// TODO generate the appropriate IncQuery patterns
	}
	
	private void evaluateOnInternalSM(Event event) {
		// TODO invoke IncQuery: fire all rules
		for (AbstractEventPattern ep : model.getEventPatterns()) {
			for (Transition t : ep.getStateMachine().getCurrentState().getOutTransitions()) {
				if (isEnabled(t, event)) {
					fireTransition(ep, t);
				}
			}
		}
		executeRecognizedPatterns();
	}
	
	private boolean isEnabled(Transition transition, Event event) {
		if (transition.getGuard().getEventType().equals(event.getClass())) {
			return true;
		}
		return false;
	}
	private void fireTransition(AbstractEventPattern ep, Transition t) {
		ep.getStateMachine().setCurrentState(t.getOutState());
	}
	
	private void executeRecognizedPatterns() {
		for (AbstractEventPattern ep : model.getEventPatterns()) {
			if (ep.getStateMachine().getCurrentState() instanceof FinalState) {
				System.out.println("CEP: PATTERN " + ep.getClass().getSimpleName() + " RECONIZED");
			}
		}
	}
	
	public void buildStateMachine(ComplexEventPattern pattern) {
		// TODO implement
	}
	
	public void buildStateMachine(AtomicEventPattern pattern) {
		StateMachine sm = SM_FACTORY.createStateMachine();
		InitState initState = SM_FACTORY.createInitState();
		FinalState finalState = SM_FACTORY.createFinalState();
		
		Transition t1 = SM_FACTORY.createTransition();
		Guard g1 = SM_FACTORY.createGuard();
		g1.setEventType(pattern.getType());
		t1.setGuard(g1);
		
		t1.setOutState(finalState);
		
		initState.getOutTransitions().add(t1);
		
		sm.setCurrentState(initState);
		
		pattern.setStateMachine(sm);
		
		model.getEventPatterns().add(pattern);
	}
}
