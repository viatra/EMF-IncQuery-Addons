package hu.bme.mit.incquery.cep.runtime.evaluation;

import hu.bme.mit.incquery.cep.api.ObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken;
import hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InitState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmFactory;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TrapState;
import hu.bme.mit.incquery.cep.runtime.EventQueue;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.PartiallyMatchedEventPatternMatch;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.PartiallyMatchedEventPatternMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.strategy.EventProcessingStrategyFactory;
import hu.bme.mit.incquery.cep.runtime.evaluation.strategy.IEventProcessingStrategy;
import hu.bme.mit.incquery.cep.runtime.evaluation.strategy.Strategy;
import hu.bme.mit.incquery.cep.runtime.statemachine.StateMachineBuilder2;
import hu.bme.mit.incquery.cep.specific.evm.CepActivationStates;
import hu.bme.mit.incquery.cep.specific.evm.CepEventSourceSpecification;
import hu.bme.mit.incquery.cep.specific.evm.CepEventType;
import hu.bme.mit.incquery.cep.specific.evm.CepRealm;
import hu.bme.mit.incquery.resolver.LifoConflictResolver;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Level;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.IncQueryEngineManager;
import org.eclipse.incquery.runtime.evm.api.Activation;
import org.eclipse.incquery.runtime.evm.api.ActivationLifeCycle;
import org.eclipse.incquery.runtime.evm.api.Context;
import org.eclipse.incquery.runtime.evm.api.EventDrivenVM;
import org.eclipse.incquery.runtime.evm.api.ExecutionSchema;
import org.eclipse.incquery.runtime.evm.api.Job;
import org.eclipse.incquery.runtime.evm.api.RuleSpecification;
import org.eclipse.incquery.runtime.evm.api.Scheduler.ISchedulerFactory;
import org.eclipse.incquery.runtime.evm.api.event.EventType.RuleEngineEventType;
import org.eclipse.incquery.runtime.evm.specific.ConflictResolvers;
import org.eclipse.incquery.runtime.evm.specific.ExecutionSchemas;
import org.eclipse.incquery.runtime.evm.specific.Schedulers;
import org.eclipse.incquery.runtime.evm.specific.resolver.FixedPriorityConflictResolver;
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
	private ExecutionSchema topLevelExecutionSchema;
	private CepRealm realm;
	private UpdateCompleteProviderExtension updateCompleteProvider;
	private ResourceSet resourceSet;
	private Map<StateMachine, FinalState> finalStatesForStatemachines = new LinkedHashMap<StateMachine, FinalState>();
	private boolean wasEnabled = false;
	private boolean filterNoise;

	private final class UpdateCompleteProviderExtension extends UpdateCompleteProvider {
		protected void latestEventHandled() {
			updateCompleted();
		}
	}

	public EventModelManager(Strategy strategy) {
		model = SM_FACTORY.createInternalExecutionModel();
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("cep", new XMIResourceFactoryImpl());
		resourceSet = new ResourceSetImpl();
		smModelResource = resourceSet.createResource(URI.createURI("cep/sm.cep"));
		smModelResource.getContents().add(model);
		this.strategy = EventProcessingStrategyFactory.getStrategy(strategy, this);
		this.realm = new CepRealm();

		Adapter adapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification notification) {
				if (notification.getEventType() != Notification.ADD) {
					return;
				}
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

	@Deprecated
	@SuppressWarnings("unchecked")
	public void assignEventPatterns(List<EventPattern> eventPatterns) {
		Set<RuleSpecification<?>> rules = new HashSet<RuleSpecification<?>>();

		for (EventPattern eventPattern : eventPatterns) {
			CepEventSourceSpecification sourceSpec = new CepEventSourceSpecification(eventPattern, this);

			Job<ObservedComplexEventPattern> job = new Job<ObservedComplexEventPattern>(CepActivationStates.ACTIVE) {
				@Override
				protected void execute(Activation<? extends ObservedComplexEventPattern> activation, Context context) {
					System.err.println("Complex event pattern appeared: "
							+ activation.getAtom().getObservedEventPattern().getId());
				}

				@Override
				protected void handleError(Activation<? extends ObservedComplexEventPattern> activation,
						Exception exception, Context context) {
					// not gonna happen
				}
			};

			ActivationLifeCycle lifeCycle = ActivationLifeCycle.create(CepActivationStates.INACTIVE);
			lifeCycle.addStateTransition(CepActivationStates.INACTIVE, CepEventType.APPEARED,
					CepActivationStates.ACTIVE);
			lifeCycle.addStateTransition(CepActivationStates.ACTIVE, RuleEngineEventType.FIRE,
					CepActivationStates.INACTIVE);

			RuleSpecification<ObservedComplexEventPattern> ruleSpec = new RuleSpecification<ObservedComplexEventPattern>(
					sourceSpec, lifeCycle, Sets.newHashSet(job));

			updateCompleteProvider = new UpdateCompleteProviderExtension();
			UpdateCompleteBasedSchedulerFactory schedulerFactory = new UpdateCompleteBasedScheduler.UpdateCompleteBasedSchedulerFactory(
					updateCompleteProvider);
			topLevelExecutionSchema = EventDrivenVM.createExecutionSchema(realm, schedulerFactory,
					Collections.EMPTY_SET);
			topLevelExecutionSchema.addRule(ruleSpec, false);
		}

		try {
			engine = IncQueryEngineManager.getInstance().getIncQueryEngine(resourceSet);
			ISchedulerFactory schedulerFactory = Schedulers.getIQBaseSchedulerFactory(engine.getBaseIndex());

			ModelHandlerRules mhr = new ModelHandlerRules(this);
			FixedPriorityConflictResolver fixedPriorityResolver = ConflictResolvers.createFixedPriorityResolver();
			LifoConflictResolver lifoConflictResolver = new LifoConflictResolver();

			for (RuleSpecification<?> ruleSpec : mhr.getModelHandlers().keySet()) {
				rules.add(ruleSpec);
				fixedPriorityResolver.setPriority(ruleSpec, mhr.getModelHandlers().get(ruleSpec));
			}

			lowLevelExecutionSchema = ExecutionSchemas.createIncQueryExecutionSchema(engine, schedulerFactory, rules);
			// lowLevelExecutionSchema.getLogger().setLevel(Level.DEBUG);
			lowLevelExecutionSchema.setConflictResolver(fixedPriorityResolver);
			// lowLevelExecutionSchema.setConflictResolver(lifoConflictResolver);

			engine.getLogger().setLevel(Level.OFF);

		} catch (IncQueryException e) {
			e.printStackTrace();
		}
	}

	public void assignEventPattern(EventPattern eventPattern, boolean filterNoise) {
		Set<RuleSpecification<?>> rules = new HashSet<RuleSpecification<?>>();

		CepEventSourceSpecification sourceSpec = new CepEventSourceSpecification(eventPattern, this);

		Job<ObservedComplexEventPattern> job = new Job<ObservedComplexEventPattern>(CepActivationStates.ACTIVE) {
			@Override
			protected void execute(Activation<? extends ObservedComplexEventPattern> activation, Context context) {
				System.err.println("Complex event pattern appeared: "
						+ activation.getAtom().getObservedEventPattern().getId());
			}

			@Override
			protected void handleError(Activation<? extends ObservedComplexEventPattern> activation,
					Exception exception, Context context) {
				// not gonna happen
			}
		};

		ActivationLifeCycle lifeCycle = ActivationLifeCycle.create(CepActivationStates.INACTIVE);
		lifeCycle.addStateTransition(CepActivationStates.INACTIVE, CepEventType.APPEARED, CepActivationStates.ACTIVE);
		lifeCycle
				.addStateTransition(CepActivationStates.ACTIVE, RuleEngineEventType.FIRE, CepActivationStates.INACTIVE);

		RuleSpecification<ObservedComplexEventPattern> ruleSpec = new RuleSpecification<ObservedComplexEventPattern>(
				sourceSpec, lifeCycle, Sets.newHashSet(job));

		updateCompleteProvider = new UpdateCompleteProviderExtension();
		UpdateCompleteBasedSchedulerFactory schedulerFactory = new UpdateCompleteBasedScheduler.UpdateCompleteBasedSchedulerFactory(
				updateCompleteProvider);
		topLevelExecutionSchema = EventDrivenVM.createExecutionSchema(realm, schedulerFactory, Collections.EMPTY_SET);
		topLevelExecutionSchema.addRule(ruleSpec, false);

		try {
			engine = IncQueryEngineManager.getInstance().getIncQueryEngine(resourceSet);
			ISchedulerFactory schedulerFactory2 = Schedulers.getIQBaseSchedulerFactory(engine.getBaseIndex());

			ModelHandlerRules mhr = new ModelHandlerRules(this);
			FixedPriorityConflictResolver fixedPriorityResolver = ConflictResolvers.createFixedPriorityResolver();

			for (RuleSpecification<?> ruleSpec2 : mhr.getModelHandlers().keySet()) {
				rules.add(ruleSpec2);
				fixedPriorityResolver.setPriority(ruleSpec2, mhr.getModelHandlers().get(ruleSpec2));
			}

			// if (filterNoise) {
			// RuleSpecification<PartiallyMatchedEventPatternMatch>
			// partiallyMatchedEventPatternRule = mhr
			// .getPartiallyMatchedEventPatternRule();
			// rules.add(partiallyMatchedEventPatternRule);
			// fixedPriorityResolver.setPriority(partiallyMatchedEventPatternRule,
			// 1000);
			// }

			this.filterNoise = filterNoise;

			lowLevelExecutionSchema = ExecutionSchemas.createIncQueryExecutionSchema(engine, schedulerFactory2, rules);
			// lowLevelExecutionSchema.getLogger().setLevel(Level.DEBUG);
			lowLevelExecutionSchema.setConflictResolver(fixedPriorityResolver);
			// lowLevelExecutionSchema.setConflictResolver(lifoConflictResolver);

			engine.getLogger().setLevel(Level.OFF);

		} catch (IncQueryException e) {
			e.printStackTrace();
		}
	}

	public StateMachine getStateMachine(EventPattern eventPattern) {
		StateMachine stateMachine = new StateMachineBuilder2(model, eventPattern).buildStateMachine();
		FinalState finalState = null;
		for (State state : stateMachine.getStates()) {
			if (SMUtils.isFinal(state)) {
				finalState = (FinalState) state;
			}
		}

		if (finalState != null) {
			finalStatesForStatemachines.put(stateMachine, finalState);
		}

		return stateMachine;
	}

	private void refreshModel(Event event) {
		model.setLatestEvent(null);
		wasEnabled = false;
		strategy.handleVisitorCreation(model, SM_FACTORY);
		model.setLatestEvent(event);
		updateCompleteProvider.latestEventHandled();
		if (filterNoise && !wasEnabled) {
			StateMachine stateMachine = model.getStateMachines().get(0);
			
			String id = stateMachine.getEventPattern().getId();
			System.out.println("\t\t\t>>>>>>>>>PartiallyNo suitable update in the SM : " + id
					+ ". It's going to be reset.");
			
			for (State state : stateMachine.getStates()) {
				if ((state instanceof InitState) || (state instanceof TrapState) || (state instanceof FinalState)) {
					continue;
				}
				
				if(state.getEventTokens().isEmpty()){
					continue;
				}

				System.out.println("\t\t\t>>>>>>>>>>>>>>>>>>Deleting tokens from state: " + state.getLabel());

				state.getEventTokens().clear();
			}
		}
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

	public Map<StateMachine, FinalState> getFinalStatesForStatemachines() {
		return finalStatesForStatemachines;
	}

	public void callbackOnFiredToken(Transition t, EventToken eventTokenToMove) {
		wasEnabled = true;
	}
}