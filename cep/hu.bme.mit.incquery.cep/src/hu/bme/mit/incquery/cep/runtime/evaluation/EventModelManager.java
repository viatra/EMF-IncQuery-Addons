package hu.bme.mit.incquery.cep.runtime.evaluation;

import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmFactory;
import hu.bme.mit.incquery.cep.runtime.EventQueue;
import hu.bme.mit.incquery.cep.runtime.evaluation.strategy.EventProcessingStrategyFactory;
import hu.bme.mit.incquery.cep.runtime.evaluation.strategy.IEventProcessingStrategy;
import hu.bme.mit.incquery.cep.runtime.evaluation.strategy.Strategy;
import hu.bme.mit.incquery.cep.runtime.evm.CepRuleSpecification;
import hu.bme.mit.incquery.cep.runtime.evm.EventPatternMatch;
import hu.bme.mit.incquery.cep.runtime.statemachine.StateMachineBuilder2;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.incquery.runtime.api.EngineManager;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.evm.api.EventDrivenVM;
import org.eclipse.incquery.runtime.evm.api.ExecutionSchema;
import org.eclipse.incquery.runtime.evm.api.RuleSpecification;
import org.eclipse.incquery.runtime.evm.api.Scheduler.ISchedulerFactory;
import org.eclipse.incquery.runtime.evm.api.event.EventSource;
import org.eclipse.incquery.runtime.evm.specific.Schedulers;
import org.eclipse.incquery.runtime.evm.specific.event.IncQueryEventSource;
import org.eclipse.incquery.runtime.exception.IncQueryException;

import com.google.common.base.Preconditions;

public class EventModelManager {
	private static EventModelManager instance;
	private InternalExecutionModel model;
	private IncQueryEngine engine;
	private final InternalsmFactory SM_FACTORY = InternalsmFactory.eINSTANCE;
	private Resource smModelResource;
	private IEventProcessingStrategy strategy;
	private ExecutionSchema executionSchema;
	
	@Deprecated
	public static EventModelManager getInstance(List<EventPattern> eventPatterns, Strategy strategy) {
		return getInstance(eventPatterns, strategy, null);
	}
	
	public static EventModelManager getInstance(List<EventPattern> eventPatterns, Strategy strategy,
			Set<CepRuleSpecification<EventPatternMatch>> eventPatternMatchRules) {
		if (instance == null) {
			instance = new EventModelManager(eventPatterns, strategy, eventPatternMatchRules);
		}
		return instance;
	}
	
	public static EventModelManager getInstance() {
		Preconditions.checkNotNull(instance, new Exception("The manager hasn't been initialized yet."));
		return instance;
	}
	
	private EventModelManager(List<EventPattern> eventPatterns, Strategy strategy,
			Set<CepRuleSpecification<EventPatternMatch>> eventPatternMatchRules) {
		model = SM_FACTORY.createInternalExecutionModel();
		this.strategy = EventProcessingStrategyFactory.getStrategy(strategy);
		
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
		
		for (EventPattern eventPattern : eventPatterns) {
			new StateMachineBuilder2(model, eventPattern).buildStateMachine();
		}
		
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("cep", new XMIResourceFactoryImpl());
		ResourceSet resourceSet = new ResourceSetImpl();
		smModelResource = resourceSet.createResource(URI.createURI("cep/sm.cep"));
		smModelResource.getContents().add(model);
		
		try {
			engine = EngineManager.getInstance().getIncQueryEngine(resourceSet);
			ISchedulerFactory schedulerFactory = Schedulers.getIQBaseSchedulerFactory(engine);
			EventSource iqEventSource = IncQueryEventSource.create(engine);
			
			Set<RuleSpecification> rules = new HashSet<RuleSpecification>();
			rules.addAll(ModelHandlerRules.getIntance().getModelHandlers());
			if (eventPatternMatchRules != null) {
				rules.addAll(eventPatternMatchRules);
			}
			
			executionSchema = EventDrivenVM.createExecutionSchema(iqEventSource, schedulerFactory, rules);
			// engine.getLogger().setLevel(Level.DEBUG);
		} catch (IncQueryException e) {
			// TODO handle error
			e.printStackTrace();
		}
	}
	
	private void refreshModel(Event event) {
		model.setLatestEvent(null);
		strategy.handleVisitorCreation(model, SM_FACTORY);
		model.setLatestEvent(event);
	}
	public InternalExecutionModel getModel() {
		return model;
	}
	
	public Resource getSmModelResource() {
		return smModelResource;
	}
	
	public IEventProcessingStrategy getStrategy() {
		return strategy;
	}
	
	public ExecutionSchema getExecutionSchema() {
		return executionSchema;
	}
}