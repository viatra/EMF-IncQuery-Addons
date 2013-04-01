package hu.bme.mit.incquery.cep.runtime.evaluation;

import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Action;
import hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Guard;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InitState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmFactory;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;
import hu.bme.mit.incquery.cep.runtime.EventQueue;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

public class EventModelManager {
	private static EventModelManager instance;
	private InternalExecutionModel model;
	private final InternalsmFactory SM_FACTORY = InternalsmFactory.eINSTANCE;
	
	private EventModelManager() {
		this.model = SM_FACTORY.createInternalExecutionModel();
		
		Adapter adapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification notification) {
				Object newValue = notification.getNewValue();
				if (newValue instanceof Event) {
					Event event = (Event) newValue;
					refreshModel(event);
					System.err.println("DIAG: Event " + event.getClass().getName() + " captured...");
					System.out.println("MODEL: LatestEvent: " + model.getLatestEvent().getId());
					evaluateOnInternalSM();
					// executeRecognizedPatterns();
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
	
	public InternalExecutionModel getModel() {
		return model;
	}
	
	private void refreshModel(Event event) {
		model.setLatestEvent(event);
	}
	
	/**
	 * TODO this shall be replaced with the IncQuery
	 */
	private void evaluateOnInternalSM() {
		for (StateMachine sm : model.getStateMachines()) {
			for (Transition t : sm.getCurrentState().getOutTransitions()) {
				if (SMUtils.isEnabled(t, model.getLatestEvent())) {
					SMUtils.fireTransition(sm, t);
				}
			}
		}
		executeRecognizedPatterns();
	}
	
	private void executeRecognizedPatterns() {
		List<StateMachine> smToDelete = new ArrayList<StateMachine>();
		
		for (StateMachine sm : model.getStateMachines()) {
			if (sm.getCurrentState() instanceof FinalState) {
				System.out.println(((FinalState) sm.getCurrentState()).getActions().get(0).getMsgToLog());
				smToDelete.add(sm);
			}
		}
		
		for (StateMachine stateMachine : smToDelete) {
			model.getStateMachines().remove(stateMachine);
		}
	}
	
	public void buildStateMachine(AtomicEventPattern pattern) {
		StateMachine sm = SM_FACTORY.createStateMachine();
		InitState initState = SM_FACTORY.createInitState();
		FinalState finalState = SM_FACTORY.createFinalState();
		finalState.setLabel("final");
		
		Action action = SM_FACTORY.createAction();
		action.setMsgToLog("\t\tCEP: Event pattern " + pattern.getId() + " recognized");
		finalState.getActions().add(action);
		
		Transition t1 = SM_FACTORY.createTransition();
		Guard g1 = SM_FACTORY.createGuard();
		g1.setEventType(pattern.getType());
		t1.setGuard(g1);
		
		t1.setPostState(finalState);
		
		initState.getOutTransitions().add(t1);
		
		sm.setCurrentState(initState);
		
		sm.setEventPattern(pattern);
		
		model.getStateMachines().add(sm);
	}
	
	public void buildStateMachine(ComplexEventPattern pattern) {
		StateMachine sm = SM_FACTORY.createStateMachine();
		InitState initState = SM_FACTORY.createInitState();
		FinalState finalState = SM_FACTORY.createFinalState();
		finalState.setLabel("final");
		
		Action action = SM_FACTORY.createAction();
		action.setMsgToLog("\t\tCEP: Event pattern " + pattern.getId() + " recognized");
		finalState.getActions().add(action);
		
		// only for ORDERED w/o timewin
		List<AtomicEventPattern> atomicEventPatterns = SMUtils.flattenComplexPatterns(pattern);
		List<State> states = new ArrayList<State>();
		
		for (int i = 0; i < atomicEventPatterns.size(); i++) {
			State latestState = null;
			
			if (!states.isEmpty()) {
				latestState = states.get(states.size() - 1);
			}
			
			State currentState = createState(atomicEventPatterns.get(i));
			states.add(currentState);
			
			if (i == 0) {
				createTransition(initState, currentState, createEventGuard(atomicEventPatterns.get(i)));
				continue;
			}
			
			if (i == atomicEventPatterns.size() - 1) {
				createTransition(latestState, finalState, createEventGuard(atomicEventPatterns.get(i)));
			}
			
			else {
				createTransition(latestState, currentState, createEventGuard(atomicEventPatterns.get(i)));
			}
		}
		
		sm.setCurrentState(initState);
		sm.setEventPattern(pattern);
		
		model.getStateMachines().add(sm);
	}
	
	private Transition createTransition(State preState, State postState, Guard guard) {
		Transition t = SM_FACTORY.createTransition();
		t.setGuard(guard);
		t.setPreState(preState);
		t.setPostState(postState);
		return t;
	}
	
	private State createState(AtomicEventPattern atomicEventPattern) {
		State s = SM_FACTORY.createState();
		return s;
	}
	
	private Guard createEventGuard(AtomicEventPattern atomicEventPattern) {
		Guard g = SM_FACTORY.createGuard();
		g.setEventType(atomicEventPattern.getType());
		return g;
	}
}