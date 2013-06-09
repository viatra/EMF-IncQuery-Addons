package hu.bme.mit.incquery.cep.runtime.evaluation;

import hu.bme.mit.incquery.cep.api.ObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmFactory;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.runtime.EventQueue;
import hu.bme.mit.incquery.cep.runtime.evaluation.strategy.EventProcessingStrategyFactory;
import hu.bme.mit.incquery.cep.runtime.evaluation.strategy.IEventProcessingStrategy;
import hu.bme.mit.incquery.cep.runtime.evaluation.strategy.Strategy;
import hu.bme.mit.incquery.cep.runtime.statemachine.StateMachineBuilder2;
import hu.bme.mit.incquery.cep.specific.evm.CepEventSourceSpecification;
import hu.bme.mit.incquery.cep.specific.evm.CepRealm;

import java.util.Collections;
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
import org.eclipse.incquery.runtime.api.IncQueryEngineManager;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.evm.api.Activation;
import org.eclipse.incquery.runtime.evm.api.Context;
import org.eclipse.incquery.runtime.evm.api.EventDrivenVM;
import org.eclipse.incquery.runtime.evm.api.ExecutionSchema;
import org.eclipse.incquery.runtime.evm.api.Job;
import org.eclipse.incquery.runtime.evm.api.RuleSpecification;
import org.eclipse.incquery.runtime.evm.api.Scheduler.ISchedulerFactory;
import org.eclipse.incquery.runtime.evm.specific.ExecutionSchemas;
import org.eclipse.incquery.runtime.evm.specific.Schedulers;
import org.eclipse.incquery.runtime.evm.specific.event.IncQueryActivationStateEnum;
import org.eclipse.incquery.runtime.evm.specific.lifecycle.DefaultActivationLifeCycle;
import org.eclipse.incquery.runtime.evm.specific.scheduler.UpdateCompleteBasedScheduler;
import org.eclipse.incquery.runtime.evm.specific.scheduler.UpdateCompleteBasedScheduler.UpdateCompleteBasedSchedulerFactory;
import org.eclipse.incquery.runtime.evm.update.UpdateCompleteProvider;
import org.eclipse.incquery.runtime.exception.IncQueryException;

import com.google.common.collect.Sets;

public class EventModelManager {
	private InternalExecutionModel model;
	private IncQueryEngine engine;
	private final InternalsmFactory SM_FACTORY = InternalsmFactory.eINSTANCE;
	private Resource smModelResource;
	private IEventProcessingStrategy strategy;
	private ExecutionSchema lowLevelExecutionSchema;
	private CepRealm realm;
	private UpdateCompleteProviderExtension updateCompleteProvider;
	private ExecutionSchema cepExecutionSchema;
	
	private final class UpdateCompleteProviderExtension extends UpdateCompleteProvider {
		protected void latestEventHandled() {
			updateCompleted();
		}
	}
	
	public EventModelManager(Strategy strategy) {
		model = SM_FACTORY.createInternalExecutionModel();
		this.strategy = EventProcessingStrategyFactory.getStrategy(strategy, this);
		this.realm = new CepRealm();
		
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
	}
	
	@SuppressWarnings("unchecked")
	public void assignEventPatterns(List<EventPattern> eventPatterns) {
		Set<RuleSpecification<?>> rules = new HashSet<RuleSpecification<?>>();
		
		for (EventPattern eventPattern : eventPatterns) {
			CepEventSourceSpecification sourceSpec = new CepEventSourceSpecification(eventPattern, this);
			
			Job<ObservedComplexEventPattern> job = new Job<ObservedComplexEventPattern>(
					IncQueryActivationStateEnum.FIRED) {
				@Override
				protected void execute(Activation<? extends ObservedComplexEventPattern> activation, Context context) {
					System.out.println("Complex event pattern disappeared:"
							+ activation.getAtom().getObservedEventPattern().getId());
				}
				@Override
				protected void handleError(Activation<? extends ObservedComplexEventPattern> activation,
						Exception exception, Context context) {
					// not gonna happen
				}
			};
			
			RuleSpecification<ObservedComplexEventPattern> ruleSpec = new RuleSpecification<ObservedComplexEventPattern>(
					sourceSpec, new DefaultActivationLifeCycle(), Sets.newHashSet(job));
			
			updateCompleteProvider = new UpdateCompleteProviderExtension();
			UpdateCompleteBasedSchedulerFactory schedulerFactory = new UpdateCompleteBasedScheduler.UpdateCompleteBasedSchedulerFactory(
					updateCompleteProvider);
			cepExecutionSchema = EventDrivenVM.createExecutionSchema(realm, schedulerFactory, Collections.EMPTY_SET);
			cepExecutionSchema.addRule(ruleSpec, false);
		}
		
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("cep", new XMIResourceFactoryImpl());
		ResourceSet resourceSet = new ResourceSetImpl();
		smModelResource = resourceSet.createResource(URI.createURI("cep/sm.cep"));
		smModelResource.getContents().add(model);
		
		try {
			engine = IncQueryEngineManager.getInstance().getIncQueryEngine(resourceSet);
			ISchedulerFactory schedulerFactory = Schedulers.getIQBaseSchedulerFactory(engine);
			
			rules.addAll(ModelHandlerRules.getIntance(this).getModelHandlers());
			lowLevelExecutionSchema = ExecutionSchemas.createIncQueryExecutionSchema(engine, schedulerFactory, rules);
			// engine.getLogger().setLevel(Level.DEBUG);
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
	}
	
	public StateMachine getStateMachine(EventPattern eventPattern) {
		return new StateMachineBuilder2(model, eventPattern).buildStateMachine();
	}
	private void refreshModel(Event event) {
		model.setLatestEvent(null);
		strategy.handleVisitorCreation(model, SM_FACTORY);
		model.setLatestEvent(event);
		updateCompleteProvider.latestEventHandled();
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
		return lowLevelExecutionSchema;
	}
	
	public CepRealm getRealm() {
		return realm;
	}
}