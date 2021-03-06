package hu.bme.mit.incquery.cep.api.runtime;

import hu.bme.mit.incquery.cep.api.CepJobs;
import hu.bme.mit.incquery.cep.api.EventPatternAutomatonOptions;
import hu.bme.mit.incquery.cep.api.ICepRule;
import hu.bme.mit.incquery.cep.api.eventprocessingstrategy.EventProcessingStrategyFactory;
import hu.bme.mit.incquery.cep.api.eventprocessingstrategy.IEventProcessingStrategy;
import hu.bme.mit.incquery.cep.api.evm.CepActivationStates;
import hu.bme.mit.incquery.cep.api.evm.CepEventSourceSpecification;
import hu.bme.mit.incquery.cep.api.evm.CepEventType;
import hu.bme.mit.incquery.cep.api.evm.CepRealm;
import hu.bme.mit.incquery.cep.api.evm.IObservableComplexEventPattern;
import hu.bme.mit.incquery.cep.logging.LoggerUtils;
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
import hu.bme.mit.incquery.cep.runtime.evaluation.ModelHandlingWithViatraApi2;
import hu.bme.mit.incquery.cep.runtime.evaluation.SMUtils;
import hu.bme.mit.incquery.cep.runtime.evaluation.StateMachineBuilder;
import hu.bme.mit.incquery.cep.streams.DefaultStreamManager;
import hu.bme.mit.incquery.cep.streams.EventStream;
import hu.bme.mit.incquery.cep.streams.IStreamManager;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.incquery.runtime.evm.api.ActivationLifeCycle;
import org.eclipse.incquery.runtime.evm.api.EventDrivenVM;
import org.eclipse.incquery.runtime.evm.api.ExecutionSchema;
import org.eclipse.incquery.runtime.evm.api.Job;
import org.eclipse.incquery.runtime.evm.api.RuleSpecification;
import org.eclipse.incquery.runtime.evm.api.event.EventType.RuleEngineEventType;
import org.eclipse.incquery.runtime.evm.specific.scheduler.UpdateCompleteBasedScheduler;
import org.eclipse.incquery.runtime.evm.specific.scheduler.UpdateCompleteBasedScheduler.UpdateCompleteBasedSchedulerFactory;
import org.eclipse.incquery.runtime.evm.update.UpdateCompleteProvider;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;

public class EventModelManager {
    private final InternalsmFactory SM_FACTORY = InternalsmFactory.eINSTANCE;

    private final Logger logger = LoggerUtils.getInstance().getLogger();

    private InternalExecutionModel model;
    private Resource smModelResource;
    private ResourceSet resourceSet;
    private IEventProcessingStrategy strategy;
    private ExecutionSchema topLevelExecutionSchema;
    private UpdateCompleteProviderExtension updateCompleteProvider;
    private Map<StateMachine, Boolean> wasEnabledForTheLatestEvent = new LinkedHashMap<StateMachine, Boolean>();
    private CepRealm realm;
    private IStreamManager streamManager;
    private Adapter eventAdapter;

    // cache
    private Map<StateMachine, FinalState> finalStatesForStatemachines = new LinkedHashMap<StateMachine, FinalState>();
    private Map<StateMachine, InitState> initStatesForStatemachines = new LinkedHashMap<StateMachine, InitState>();

    private final class UpdateCompleteProviderExtension extends UpdateCompleteProvider {
        protected void latestEventHandled() {
            updateCompleted();
        }
    }

    public EventModelManager() {
        prepareModel();

        eventAdapter = new AdapterImpl() {
            @Override
            public void notifyChanged(Notification notification) {
                if (notification.getEventType() != Notification.ADD) {
                    return;
                }
                Object newValue = notification.getNewValue();
                if (newValue instanceof Event) {
                    Event event = (Event) newValue;
                    logger.debug("EventModelManager: Event " + event.getClass().getName() + " captured...");
                    refreshModel(event);
                }
            }
        };
        // EventQueue.getInstance().eAdapters().add(eventAdapter);

        streamManager = DefaultStreamManager.getInstance(this);

        this.strategy = EventProcessingStrategyFactory.getStrategy(EventProcessingContext.CHRONICLE, this);
        this.realm = new CepRealm();
        initializeSchema();
        initializeLowLevelModelHandling();
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

    private void initializeSchema() {
        updateCompleteProvider = new UpdateCompleteProviderExtension();
        UpdateCompleteBasedSchedulerFactory schedulerFactory = new UpdateCompleteBasedScheduler.UpdateCompleteBasedSchedulerFactory(
                updateCompleteProvider);
        topLevelExecutionSchema = EventDrivenVM.createExecutionSchema(realm, schedulerFactory,
                Collections.<RuleSpecification<?>> emptySet());
    }

    private void initializeLowLevelModelHandling() {
        ModelHandlingWithViatraApi2 mhrViatraApi2 = new ModelHandlingWithViatraApi2(this);
        mhrViatraApi2.registerRulesWithCustomPriorities();
    }

    public void addRules(List<ICepRule> rules) {
        Preconditions.checkArgument(!rules.isEmpty());
        for (ICepRule rule : rules) {
            addSingleRule(rule);
        }
        initializeStateMachines();
    }

    public void addRule(ICepRule rule) {
        addSingleRule(rule);
        initializeStateMachines();
    }

    public void addSingleRule(ICepRule rule) {
        Preconditions.checkArgument(!rule.getEventPatterns().isEmpty());
        for (EventPattern eventPattern : rule.getEventPatterns()) {
            EventPatternAutomatonOptions options = new EventPatternAutomatonOptions(this.strategy.getContext(),
                    eventPattern.getPriority());

            StateMachine stateMachine = getStateMachine(eventPattern, options);

            wasEnabledForTheLatestEvent.put(stateMachine, true);

            CepEventSourceSpecification sourceSpec = new CepEventSourceSpecification(stateMachine);

            Job<IObservableComplexEventPattern> job = rule.getJob();
            if (job == null) {
                job = CepJobs.getDefaultJob();
            }
            @SuppressWarnings("unchecked")
            RuleSpecification<IObservableComplexEventPattern> ruleSpec = new RuleSpecification<IObservableComplexEventPattern>(
                    sourceSpec, getDefaultLifeCycle(), Sets.newHashSet(job));
            topLevelExecutionSchema.addRule(ruleSpec);
        }
    }

    private ActivationLifeCycle getDefaultLifeCycle() {
        ActivationLifeCycle lifeCycle = ActivationLifeCycle.create(CepActivationStates.INACTIVE);
        lifeCycle.addStateTransition(CepActivationStates.INACTIVE, CepEventType.APPEARED, CepActivationStates.ACTIVE);
        lifeCycle
                .addStateTransition(CepActivationStates.ACTIVE, RuleEngineEventType.FIRE, CepActivationStates.INACTIVE);
        return lifeCycle;
    }

    private void initializeStateMachines() {
        for (InitState is : initStatesForStatemachines.values()) {
            if (is.getEventTokens().isEmpty()) {
                EventToken cv = SM_FACTORY.createEventToken();
                cv.setCurrentState(is);
                model.getEventTokens().add(cv);
            }
        }
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

    public void callbackOnPatternRecognition(IObservableComplexEventPattern observedPattern) {
        strategy.handleInitTokenCreation(model, SM_FACTORY, observedPattern);
    }

    public Map<StateMachine, InitState> getInitStatesForStatemachines() {
        return initStatesForStatemachines;
    }

    public Map<StateMachine, Boolean> getWasEnabledForTheLatestEvent() {
        return wasEnabledForTheLatestEvent;
    }

    public ResourceSet getResourceSet() {
        return resourceSet;
    }

    public void setEventProcessingContext(EventProcessingContext context) {
        this.strategy = EventProcessingStrategyFactory.getStrategy(context, this);
    }

    public void setDebuggingLevel(Level level) {
        topLevelExecutionSchema.getLogger().setLevel(level);
    }

    public void setCepDebugLevel(Level level) {
        LoggerUtils.getInstance().getLogger().setLevel(level);
    }

    public IStreamManager getStreamManager() {
        return streamManager;
    }

    public void setStreamManager(IStreamManager streamManager) {
        this.streamManager = streamManager;
    }

    public void registerNewEventStream(EventStream newEventStream) {
        newEventStream.eAdapters().add(eventAdapter);
    }
}