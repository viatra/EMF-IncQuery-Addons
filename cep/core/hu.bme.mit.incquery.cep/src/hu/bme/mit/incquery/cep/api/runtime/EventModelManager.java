package hu.bme.mit.incquery.cep.api.runtime;

import hu.bme.mit.incquery.cep.api.EventPatternAutomatonOptions;
import hu.bme.mit.incquery.cep.api.eventprocessingstrategy.EventProcessingStrategyFactory;
import hu.bme.mit.incquery.cep.api.eventprocessingstrategy.IEventProcessingStrategy;
import hu.bme.mit.incquery.cep.api.evm.CepActivationStates;
import hu.bme.mit.incquery.cep.api.evm.CepEventSourceSpecification;
import hu.bme.mit.incquery.cep.api.evm.CepEventType;
import hu.bme.mit.incquery.cep.api.evm.CepRealm;
import hu.bme.mit.incquery.cep.api.evm.ObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventProcessingContext;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken;
import hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InitState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmFactory;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;
import hu.bme.mit.incquery.cep.runtime.evaluation.ModelHandlerRules2;
import hu.bme.mit.incquery.cep.runtime.evaluation.StateMachineBuilder;
import hu.bme.mit.incquery.cep.utils.Logger;
import hu.bme.mit.incquery.cep.utils.SMUtils;

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
import org.eclipse.emf.ecore.EObject;
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
	private final InternalsmFactory SM_FACTORY = InternalsmFactory.eINSTANCE;

	private InternalExecutionModel model;
	private Resource smModelResource;
	private ResourceSet resourceSet;

	private IncQueryEngine engine;
	private IEventProcessingStrategy strategy;
	private ExecutionSchema lowLevelExecutionSchema;
	private ExecutionSchema topLevelExecutionSchema;
	private UpdateCompleteProviderExtension updateCompleteProvider;

	private Map<StateMachine, Boolean> wasEnabledForTheLatestEvent = new LinkedHashMap<StateMachine, Boolean>();

	private CepRealm realm;

	// TODO cache objects - they are required to move in a separate class with
	// the ability to modify them for a given SM
	private Map<StateMachine, FinalState> finalStatesForStatemachines = new LinkedHashMap<StateMachine, FinalState>();
	private Map<StateMachine, InitState> initStatesForStatemachines = new LinkedHashMap<StateMachine, InitState>();

	private final class UpdateCompleteProviderExtension extends UpdateCompleteProvider {
		protected void latestEventHandled() {
			updateCompleted();
		}
	}

	private void prepareModel() {
		model = SM_FACTORY.createInternalExecutionModel();
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("cep", new XMIResourceFactoryImpl());
		resourceSet = new ResourceSetImpl();
		smModelResource = resourceSet.createResource(URI.createURI("cep/sm.cep"));
		smModelResource.getContents().add(model);
	}

	public EventModelManager() {
		prepareModel();

		Adapter adapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification notification) {
				if (notification.getEventType() != Notification.ADD) {
					return;
				}
				Object newValue = notification.getNewValue();
				if (newValue instanceof Event) {
					Event event = (Event) newValue;
					Logger.log("DIAG: Event " + event.getClass().getName() + " captured...");
					refreshModel(event);
				}
			}
		};
		EventQueue.getInstance().eAdapters().add(adapter);

		// default Context and Strategy - can be overridden via setEventProcessingContext()
		this.strategy = EventProcessingStrategyFactory.getStrategy(EventProcessingContext.CHRONICLE, this);
		this.realm = new CepRealm();
	}

	public void setEventProcessingContext(EventProcessingContext context) {
		this.strategy = EventProcessingStrategyFactory.getStrategy(context, this);
	}

	public void assignEventPatterns(Map<EventPattern, EventPatternAutomatonOptions> eventPatternsWithOptions) {
		Set<RuleSpecification<?>> rules = new HashSet<RuleSpecification<?>>();

		for (EventPattern eventPattern : eventPatternsWithOptions.keySet()) {
			EventPatternAutomatonOptions options = eventPatternsWithOptions.get(eventPattern);
			StateMachine stateMachine = getStateMachine(eventPattern, options);

			wasEnabledForTheLatestEvent.put(stateMachine, true);

			CepEventSourceSpecification sourceSpec = new CepEventSourceSpecification(stateMachine);

			Job<ObservedComplexEventPattern> job = new Job<ObservedComplexEventPattern>(CepActivationStates.ACTIVE) {

				protected void execute(Activation<? extends ObservedComplexEventPattern> activation, Context context) {
					Logger.log(">>>>>>>>>>>>>>>CEP: Complex event pattern appeared: "
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

			@SuppressWarnings("unchecked")
			RuleSpecification<ObservedComplexEventPattern> ruleSpec = new RuleSpecification<ObservedComplexEventPattern>(
					sourceSpec, lifeCycle, Sets.newHashSet(job));

			updateCompleteProvider = new UpdateCompleteProviderExtension();
			UpdateCompleteBasedSchedulerFactory schedulerFactory = new UpdateCompleteBasedScheduler.UpdateCompleteBasedSchedulerFactory(
					updateCompleteProvider);
			topLevelExecutionSchema = EventDrivenVM.createExecutionSchema(realm, schedulerFactory,
					Collections.<RuleSpecification<?>> emptySet());
			topLevelExecutionSchema.addRule(ruleSpec);
		}

		try {
			engine = IncQueryEngineManager.getInstance().getIncQueryEngine(resourceSet);
			ISchedulerFactory schedulerFactory = Schedulers.getIQBaseSchedulerFactory(engine.getBaseIndex());

			//ModelHandlerRules mhr = new ModelHandlerRules(this);
			ModelHandlerRules2 mhr = new ModelHandlerRules2(this);
			FixedPriorityConflictResolver fixedPriorityResolver = ConflictResolvers.createFixedPriorityResolver();

			for (RuleSpecification<?> ruleSpec : mhr.getModelHandlers().keySet()) {
				rules.add(ruleSpec);
				fixedPriorityResolver.setPriority(ruleSpec, mhr.getModelHandlers().get(ruleSpec));
			}

			lowLevelExecutionSchema = ExecutionSchemas.createIncQueryExecutionSchema(engine, schedulerFactory, rules);
			// lowLevelExecutionSchema.getLogger().setLevel(Level.DEBUG);
			lowLevelExecutionSchema.setConflictResolver(fixedPriorityResolver);

			engine.getLogger().setLevel(Level.OFF);

		} catch (IncQueryException e) {
			e.printStackTrace();
		}

		// initialize init state cache
		for (InitState is : initStatesForStatemachines.values()) {
			if (is.getEventTokens().isEmpty()) {
				EventToken cv = SM_FACTORY.createEventToken();
				cv.setCurrentState(is);
				model.getEventTokens().add(cv);
			}
		}
	}

	public void assignEventPatterns(List<EventPattern> eventPatterns) {
		Map<EventPattern, EventPatternAutomatonOptions> eventsWithOptions = new LinkedHashMap<EventPattern, EventPatternAutomatonOptions>();

		for (EventPattern ep : eventPatterns) {
			eventsWithOptions.put(ep, EventPatternAutomatonOptions.getDefault());
		}

		assignEventPatterns(eventsWithOptions);
	}

	public void assignEventPattern(EventPattern eventPattern) {
		Map<EventPattern, EventPatternAutomatonOptions> eventsWithOptions = new LinkedHashMap<EventPattern, EventPatternAutomatonOptions>();

		EventPatternAutomatonOptions options = EventPatternAutomatonOptions.getDefault();

		eventsWithOptions.put(eventPattern, options);

		assignEventPatterns(eventsWithOptions);
	}

	public StateMachine getStateMachine(EventPattern eventPattern, EventPatternAutomatonOptions options) {
		StateMachine stateMachine = new StateMachineBuilder(model, eventPattern, options).buildStateMachine();
		FinalState finalState = null;
		InitState initState = null;
		for (State state : stateMachine.getStates()) {
			if (SMUtils.isFinal(state)) {
				finalState = (FinalState) state;
				break;
			}
		}

		if (finalState != null) {
			finalStatesForStatemachines.put(stateMachine, finalState);
		}

		for (State state : stateMachine.getStates()) {
			if (state instanceof InitState) {
				initState = (InitState) state;
				break;
			}
		}

		if (initState != null) {
			initStatesForStatemachines.put(stateMachine, initState);
		}

		return stateMachine;
	}

	private void refreshModel(Event event) {
		model.setLatestEvent(null);
		wasEnabledForTheLatestEvent.clear();
		strategy.handleInitTokenCreation(model, SM_FACTORY, null);
		model.setLatestEvent(event);
		updateCompleteProvider.latestEventHandled();
		strategy.handleSmResets(model, SM_FACTORY);
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
		EObject state = t.eContainer();
		if (!(state instanceof State)) {
			return;
		}

		EObject sm = ((State) state).eContainer();
		if (!(sm instanceof StateMachine)) {
			return;
		}

		wasEnabledForTheLatestEvent.put(((StateMachine) sm), true);
	}

	public void callbackOnPatternRecognition(ObservedComplexEventPattern observedPattern) {
		strategy.handleInitTokenCreation(model, SM_FACTORY, observedPattern);
	}

	public Map<StateMachine, InitState> getInitStatesForStatemachines() {
		return initStatesForStatemachines;
	}

	public Map<StateMachine, Boolean> getWasEnabledForTheLatestEvent() {
		return wasEnabledForTheLatestEvent;
	}
}