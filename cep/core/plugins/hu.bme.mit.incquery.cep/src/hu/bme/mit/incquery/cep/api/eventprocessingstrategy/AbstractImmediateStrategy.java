package hu.bme.mit.incquery.cep.api.eventprocessingstrategy;

import org.apache.log4j.Logger;

import hu.bme.mit.incquery.cep.api.runtime.EventModelManager;
import hu.bme.mit.incquery.cep.logging.LoggerUtils;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken;
import hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InitState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmFactory;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TrapState;

public abstract class AbstractImmediateStrategy extends AbstractEventProcessingStrategy {

    private final Logger logger = LoggerUtils.getInstance().getLogger();

    public AbstractImmediateStrategy(EventModelManager eventModelManager) {
        super(eventModelManager);
    }

    @Override
    public void handleSmResets(InternalExecutionModel model, InternalsmFactory SM_FACTORY) {
        for (StateMachine stateMachine : model.getStateMachines()) {
            if (needsReset(stateMachine)) {
                String id = stateMachine.getEventPattern().getId();
                logger.debug("\t\t\t>>>>>>>>>No suitable update in the SM : " + id + ". It's going to be reset.");

                for (State state : stateMachine.getStates()) {
                    if ((state instanceof InitState) || (state instanceof TrapState) || (state instanceof FinalState)) {
                        continue;
                    }

                    if (state.getEventTokens().isEmpty()) {
                        continue;
                    }

                    logger.debug("\t\t\t>>>>>>>>>>>>>>>>>>Deleting tokens from state: " + state.getLabel());

                    state.getEventTokens().clear();
                }

                model.setLatestEvent(null);

                InitState initState = getEventModelManager().getInitStatesForStatemachines().get(stateMachine);
                if (initState.getEventTokens().isEmpty()) {
                    EventToken cv = SM_FACTORY.createEventToken();
                    cv.setCurrentState(initState);
                    model.getEventTokens().add(cv);
                }
            }
        }

    }

    private boolean needsReset(StateMachine stateMachine) {
        return !(getEventModelManager().getWasEnabledForTheLatestEvent().containsKey(stateMachine));
    }

}
