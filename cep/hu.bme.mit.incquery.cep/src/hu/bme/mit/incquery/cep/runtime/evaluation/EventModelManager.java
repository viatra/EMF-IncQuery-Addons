package hu.bme.mit.incquery.cep.runtime.evaluation;

import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmFactory;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;
import hu.bme.mit.incquery.cep.runtime.EventQueue;
import hu.bme.mit.incquery.cep.runtime.statemachine.AtomicPatternBuilder;
import hu.bme.mit.incquery.cep.runtime.statemachine.ComplexPatternBuilder;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.incquery.runtime.api.EngineManager;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.evm.api.Activation;
import org.eclipse.incquery.runtime.evm.api.Context;
import org.eclipse.incquery.runtime.evm.api.EventDrivenVM;
import org.eclipse.incquery.runtime.evm.api.RuleEngine;
import org.eclipse.incquery.runtime.evm.api.RuleSpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;

public class EventModelManager {
	private static EventModelManager instance;
	private InternalExecutionModel model;
	private IncQueryEngine engine;
	private RuleEngine ruleEngine;
	private Context context;
	private final InternalsmFactory SM_FACTORY = InternalsmFactory.eINSTANCE;
	
	private EventModelManager(List<EventPattern> eventPatterns) {
		model = SM_FACTORY.createInternalExecutionModel();
		
		Adapter adapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification notification) {
				Object newValue = notification.getNewValue();
				if (newValue instanceof Event) {
					Event event = (Event) newValue;
					System.err.println("DIAG: Event " + event.getClass().getName() + " captured...");
					refreshModel(event);
					evaluateRuleSpecifications();
				}
			}
		};
		EventQueue.getInstance().eAdapters().add(adapter);
		
		ComplexPatternBuilder complexBuilder = new ComplexPatternBuilder(model);
		AtomicPatternBuilder atomicBuilder = new AtomicPatternBuilder(model);
		
		for (EventPattern eventPattern : eventPatterns) {
			if (eventPattern instanceof AtomicEventPattern) {
				atomicBuilder.buildStateMachine((AtomicEventPattern) eventPattern);
			}
			if (eventPattern instanceof ComplexEventPattern) {
				complexBuilder.buildStateMachine((ComplexEventPattern) eventPattern);
			}
		}
		
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("cep", new XMIResourceFactoryImpl());
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource smModelResource = resourceSet.createResource(URI.createURI("cep/sm.cep"));
		smModelResource.getContents().add(model);
		
		// TODO this is required because of the non-containment relationship
		// between States and Transitions - shall be replaced by feature maps
		for (StateMachine sm : model.getStateMachines()) {
			for (State s : sm.getStates()) {
				for (Transition to : s.getOutTransitions()) {
					smModelResource.getContents().add(to);
				}
				for (Transition ti : s.getInTransitions()) {
					smModelResource.getContents().add(ti);
				}
			}
		}
		
		try {
			engine = EngineManager.getInstance().getIncQueryEngine(resourceSet);
			ruleEngine = EventDrivenVM.createRuleEngine(engine);
			registerModelHandlerRules();
			engine.getLogger().setLevel(Level.DEBUG);
			context = Context.create();
		} catch (IncQueryException e) {
			// TODO handle error
			e.printStackTrace();
		}
		
	}
	
	public static EventModelManager createEventModel(List<EventPattern> eventPatterns) {
		if (instance == null) {
			instance = new EventModelManager(eventPatterns);
		}
		return instance;
	}
	
	public void registerModelHandlerRules() {
		for (RuleSpecification<? extends IPatternMatch> ruleSpec : ModelHandlerRules.getIntance().getModelHandlers()) {
			ruleEngine.addRule(ruleSpec);
		}
	}
	
	private void evaluateRuleSpecifications() {
		for (Activation<? extends IPatternMatch> activation : ruleEngine.getActivations().values()) {
			activation.fire(context);
		}
	}
	
	private void refreshModel(Event event) {
		model.setLatestEvent(event);
	}
	
	public InternalExecutionModel getModel() {
		return model;
	}
}