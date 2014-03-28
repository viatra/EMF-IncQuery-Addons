package hu.bme.mit.incquery.cep.runtime.evaluation.queries;

import hu.bme.mit.incquery.cep.runtime.evaluation.queries.AtomicPatternTypeMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.EnabledTransitionMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.EventHandledByEventTokenMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.EventHandledByStateMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.FinalStateMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.FinishedStateMachineMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.GuardAtomicPatternMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.InitStateMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.LatestEventMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.PartiallyMatchedEventPatternMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.PreStateMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.StateWithCHECKTimeconstraintMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.StateWithSTARTTimeconstraintMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.StateWithSTOPTimeconstraintMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.StateWithTimeconstraintMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.TokenInTrapStateMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.TransitionMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;

@SuppressWarnings("all")
public final class EvaluationPatternsMatchers {
  private IncQueryEngine engine;
  
  public EvaluationPatternsMatchers(final IncQueryEngine engine) {
    this.engine = engine;
    
  }
  
  public StateWithCHECKTimeconstraintMatcher getStateWithCHECKTimeconstraintMatcher() throws IncQueryException {
    return StateWithCHECKTimeconstraintMatcher.on(engine);
  }
  
  public StateWithSTARTTimeconstraintMatcher getStateWithSTARTTimeconstraintMatcher() throws IncQueryException {
    return StateWithSTARTTimeconstraintMatcher.on(engine);
  }
  
  public TokenInTrapStateMatcher getTokenInTrapStateMatcher() throws IncQueryException {
    return TokenInTrapStateMatcher.on(engine);
  }
  
  public StateWithSTOPTimeconstraintMatcher getStateWithSTOPTimeconstraintMatcher() throws IncQueryException {
    return StateWithSTOPTimeconstraintMatcher.on(engine);
  }
  
  public EnabledTransitionMatcher getEnabledTransitionMatcher() throws IncQueryException {
    return EnabledTransitionMatcher.on(engine);
  }
  
  public InitStateMatcher getInitStateMatcher() throws IncQueryException {
    return InitStateMatcher.on(engine);
  }
  
  public TransitionMatcher getTransitionMatcher() throws IncQueryException {
    return TransitionMatcher.on(engine);
  }
  
  public FinishedStateMachineMatcher getFinishedStateMachineMatcher() throws IncQueryException {
    return FinishedStateMachineMatcher.on(engine);
  }
  
  public LatestEventMatcher getLatestEventMatcher() throws IncQueryException {
    return LatestEventMatcher.on(engine);
  }
  
  public FinalStateMatcher getFinalStateMatcher() throws IncQueryException {
    return FinalStateMatcher.on(engine);
  }
  
  public StateWithTimeconstraintMatcher getStateWithTimeconstraintMatcher() throws IncQueryException {
    return StateWithTimeconstraintMatcher.on(engine);
  }
  
  public AtomicPatternTypeMatcher getAtomicPatternTypeMatcher() throws IncQueryException {
    return AtomicPatternTypeMatcher.on(engine);
  }
  
  public PartiallyMatchedEventPatternMatcher getPartiallyMatchedEventPatternMatcher() throws IncQueryException {
    return PartiallyMatchedEventPatternMatcher.on(engine);
  }
  
  public EventHandledByEventTokenMatcher getEventHandledByEventTokenMatcher() throws IncQueryException {
    return EventHandledByEventTokenMatcher.on(engine);
  }
  
  public EventHandledByStateMatcher getEventHandledByStateMatcher() throws IncQueryException {
    return EventHandledByStateMatcher.on(engine);
  }
  
  public PreStateMatcher getPreStateMatcher() throws IncQueryException {
    return PreStateMatcher.on(engine);
  }
  
  public GuardAtomicPatternMatcher getGuardAtomicPatternMatcher() throws IncQueryException {
    return GuardAtomicPatternMatcher.on(engine);
  }
}
