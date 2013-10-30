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
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * A pattern group formed of all patterns defined in evaluationPatterns.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare 
 * an EMF-IncQuery engine for matching all patterns originally defined in file evaluationPatterns.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.bme.mit.incquery.cep.runtime.evaluation.queries, the group contains the definition of the following patterns: <ul>
 * <li>finishedStateMachine</li>
 * <li>finalState</li>
 * <li>latestEvent</li>
 * <li>stateWithTimeconstraint</li>
 * <li>stateWithSTOPTimeconstraint</li>
 * <li>stateWithSTARTTimeconstraint</li>
 * <li>stateWithCHECKTimeconstraint</li>
 * <li>transition</li>
 * <li>preState</li>
 * <li>guardAtomicPattern</li>
 * <li>eventHandledByEventToken</li>
 * <li>eventHandledByState</li>
 * <li>atomicPatternType</li>
 * <li>enabledTransition</li>
 * <li>tokenInTrapState</li>
 * <li>initState</li>
 * <li>partiallyMatchedEventPattern</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class EvaluationPatterns extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static EvaluationPatterns instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new EvaluationPatterns();
    }
    return INSTANCE;
    
  }
  
  private static EvaluationPatterns INSTANCE;
  
  private EvaluationPatterns() throws IncQueryException {
    querySpecifications.add(FinishedStateMachineMatcher.querySpecification());
    querySpecifications.add(StateWithCHECKTimeconstraintMatcher.querySpecification());
    querySpecifications.add(EventHandledByStateMatcher.querySpecification());
    querySpecifications.add(AtomicPatternTypeMatcher.querySpecification());
    querySpecifications.add(TokenInTrapStateMatcher.querySpecification());
    querySpecifications.add(EventHandledByEventTokenMatcher.querySpecification());
    querySpecifications.add(LatestEventMatcher.querySpecification());
    querySpecifications.add(StateWithTimeconstraintMatcher.querySpecification());
    querySpecifications.add(GuardAtomicPatternMatcher.querySpecification());
    querySpecifications.add(InitStateMatcher.querySpecification());
    querySpecifications.add(StateWithSTOPTimeconstraintMatcher.querySpecification());
    querySpecifications.add(EnabledTransitionMatcher.querySpecification());
    querySpecifications.add(PreStateMatcher.querySpecification());
    querySpecifications.add(PartiallyMatchedEventPatternMatcher.querySpecification());
    querySpecifications.add(FinalStateMatcher.querySpecification());
    querySpecifications.add(StateWithSTARTTimeconstraintMatcher.querySpecification());
    querySpecifications.add(TransitionMatcher.querySpecification());
    
  }
}
