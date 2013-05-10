package hu.bme.mit.incquery.cep.runtime.evaluation.queries;

import hu.bme.mit.incquery.cep.runtime.evaluation.queries.enabledtransition.EnabledTransitionMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.eventhandledbycsv.EventHandledByCSVMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.finalstate.FinalStateMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.finishedstatemachine.FinishedStateMachineMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.latestevent.LatestEventMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.prestate.PreStateMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.transition.TransitionMatcher;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

public final class GroupOfFileEvaluationPatterns extends BaseGeneratedPatternGroup {
  public GroupOfFileEvaluationPatterns() throws IncQueryException {
    matcherFactories.add(EnabledTransitionMatcher.factory());
    matcherFactories.add(FinalStateMatcher.factory());
    matcherFactories.add(TransitionMatcher.factory());
    matcherFactories.add(EventHandledByCSVMatcher.factory());
    matcherFactories.add(LatestEventMatcher.factory());
    matcherFactories.add(FinishedStateMachineMatcher.factory());
    matcherFactories.add(PreStateMatcher.factory());
    
  }
}
