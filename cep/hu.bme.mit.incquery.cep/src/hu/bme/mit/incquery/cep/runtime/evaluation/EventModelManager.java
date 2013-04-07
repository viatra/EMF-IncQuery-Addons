package hu.bme.mit.incquery.cep.runtime.evaluation;

import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmFactory;
import hu.bme.mit.incquery.cep.runtime.EventQueue;
import hu.bme.mit.incquery.cep.runtime.statemachine.StateMachineBuilder;

import java.util.List;
import java.util.Map;

import javax.naming.OperationNotSupportedException;

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
import org.eclipse.incquery.runtime.evm.api.EventDrivenVM;
import org.eclipse.incquery.runtime.evm.api.RuleEngine;
import org.eclipse.incquery.runtime.evm.api.RuleSpecification;
import org.eclipse.incquery.runtime.evm.specific.UpdateCompleteBasedScheduler;
import org.eclipse.incquery.runtime.evm.specific.UpdateCompleteBasedScheduler.UpdateCompleteBasedSchedulerFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;

public class EventModelManager {
	private static EventModelManager instance;
	private InternalExecutionModel model;
	private IncQueryEngine engine;
	private RuleEngine ruleEngine;
	private final InternalsmFactory SM_FACTORY = InternalsmFactory.eINSTANCE;
	
	public static EventModelManager getInstance(List<EventPattern> eventPatterns) {
		if (instance == null) {
			instance = new EventModelManager(eventPatterns);
		}
		return instance;
	}
	
	public static EventModelManager getInstance() throws OperationNotSupportedException {
		if (instance == null) {
			throw new OperationNotSupportedException();
		}
		return instance;
	}
	
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
				}
			}
		};
		EventQueue.getInstance().eAdapters().add(adapter);
		
		StateMachineBuilder smBuilder = new StateMachineBuilder(model);
		
		for (EventPattern eventPattern : eventPatterns) {
			smBuilder.buildStateMachine(eventPattern);
		}
		
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("cep", new XMIResourceFactoryImpl());
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource smModelResource = resourceSet.createResource(URI.createURI("cep/sm.cep"));
		smModelResource.getContents().add(model);
		
		try {
			engine = EngineManager.getInstance().getIncQueryEngine(resourceSet);
			UpdateCompleteBasedSchedulerFactory schedulerFactory = UpdateCompleteBasedScheduler
					.getIQBaseSchedulerFactory(engine);
			ruleEngine = EventDrivenVM.createExecutionSchema(engine, schedulerFactory);
			registerModelHandlerRules();
			engine.getLogger().setLevel(Level.DEBUG);
		} catch (IncQueryException e) {
			// TODO handle error
			e.printStackTrace();
		}
		
	}
	
	public void registerModelHandlerRules() {
		for (RuleSpecification<? extends IPatternMatch> ruleSpec : ModelHandlerRules.getIntance().getModelHandlers()) {
			ruleEngine.addRule(ruleSpec);
		}
	}
	
	private void refreshModel(Event event) {
		model.setLatestEvent(event);
	}
	
	public InternalExecutionModel getModel() {
		return model;
	}
}