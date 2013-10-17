package hu.bme.mit.incquery.cep.runtime.evaluation.queries;

import hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.FinishedStateMachineMatch;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.util.FinishedStateMachineQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.rete.misc.DeltaMonitor;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * Generated pattern matcher API of the hu.bme.mit.incquery.cep.runtime.evaluation.queries.finishedStateMachine pattern, 
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)}, 
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link FinishedStateMachineMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern finishedStateMachine(sm : StateMachine, et : EventToken) {
 * 	StateMachine.states(sm, state);
 * 	find finalState(state, et);
 * 	EventToken.currentState(_, state);
 * }
 * </pre></code>
 * 
 * @see FinishedStateMachineMatch
 * @see FinishedStateMachineProcessor
 * @see FinishedStateMachineQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class FinishedStateMachineMatcher extends BaseMatcher<FinishedStateMachineMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<FinishedStateMachineMatcher> querySpecification() throws IncQueryException {
    return FinishedStateMachineQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine. 
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static FinishedStateMachineMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    FinishedStateMachineMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new FinishedStateMachineMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    } 	
    return matcher;
  }
  
  private final static int POSITION_SM = 0;
  
  private final static int POSITION_ET = 1;
  
  /**
   * Initializes the pattern matcher over a given EMF model root (recommended: Resource or ResourceSet). 
   * If a pattern matcher is already constructed with the same root, only a light-weight reference is returned.
   * The scope of pattern matching will be the given EMF model root and below (see FAQ for more precise definition).
   * The match set will be incrementally refreshed upon updates from this scope.
   * <p>The matcher will be created within the managed {@link IncQueryEngine} belonging to the EMF model root, so 
   * multiple matchers will reuse the same engine and benefit from increased performance and reduced memory footprint.
   * @param emfRoot the root of the EMF containment hierarchy where the pattern matcher will operate. Recommended: Resource or ResourceSet.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead, e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}
   * 
   */
  @Deprecated
  public FinishedStateMachineMatcher(final Notifier emfRoot) throws IncQueryException {
    this(IncQueryEngine.on(emfRoot));
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine. 
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead
   * 
   */
  @Deprecated
  public FinishedStateMachineMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @param pEt the fixed value of pattern parameter et, or null if not bound.
   * @return matches represented as a FinishedStateMachineMatch object.
   * 
   */
  public Collection<FinishedStateMachineMatch> getAllMatches(final StateMachine pSm, final EventToken pEt) {
    return rawGetAllMatches(new Object[]{pSm, pEt});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @param pEt the fixed value of pattern parameter et, or null if not bound.
   * @return a match represented as a FinishedStateMachineMatch object, or null if no match is found.
   * 
   */
  public FinishedStateMachineMatch getOneArbitraryMatch(final StateMachine pSm, final EventToken pEt) {
    return rawGetOneArbitraryMatch(new Object[]{pSm, pEt});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @param pEt the fixed value of pattern parameter et, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final StateMachine pSm, final EventToken pEt) {
    return rawHasMatch(new Object[]{pSm, pEt});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @param pEt the fixed value of pattern parameter et, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final StateMachine pSm, final EventToken pEt) {
    return rawCountMatches(new Object[]{pSm, pEt});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @param pEt the fixed value of pattern parameter et, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final StateMachine pSm, final EventToken pEt, final IMatchProcessor<? super FinishedStateMachineMatch> processor) {
    rawForEachMatch(new Object[]{pSm, pEt}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @param pEt the fixed value of pattern parameter et, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final StateMachine pSm, final EventToken pEt, final IMatchProcessor<? super FinishedStateMachineMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSm, pEt}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters. 
   * It can also be reset to track changes from a later point in time, 
   * and changes can even be acknowledged on an individual basis. 
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @param pEt the fixed value of pattern parameter et, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<FinishedStateMachineMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final StateMachine pSm, final EventToken pEt) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pSm, pEt});
  }
  
  /**
   * Returns a new (partial) Match object for the matcher. 
   * This can be used e.g. to call the matcher with a partial match. 
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @param pEt the fixed value of pattern parameter et, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public FinishedStateMachineMatch newMatch(final StateMachine pSm, final EventToken pEt) {
    return new FinishedStateMachineMatch.Immutable(pSm, pEt);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for sm.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<StateMachine> rawAccumulateAllValuesOfsm(final Object[] parameters) {
    Set<StateMachine> results = new HashSet<StateMachine>();
    rawAccumulateAllValues(POSITION_SM, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for sm.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<StateMachine> getAllValuesOfsm() {
    return rawAccumulateAllValuesOfsm(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for sm.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<StateMachine> getAllValuesOfsm(final FinishedStateMachineMatch partialMatch) {
    return rawAccumulateAllValuesOfsm(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for sm.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<StateMachine> getAllValuesOfsm(final EventToken pEt) {
    return rawAccumulateAllValuesOfsm(new Object[]{null, pEt});
  }
  
  /**
   * Retrieve the set of values that occur in matches for et.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<EventToken> rawAccumulateAllValuesOfet(final Object[] parameters) {
    Set<EventToken> results = new HashSet<EventToken>();
    rawAccumulateAllValues(POSITION_ET, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for et.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EventToken> getAllValuesOfet() {
    return rawAccumulateAllValuesOfet(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for et.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EventToken> getAllValuesOfet(final FinishedStateMachineMatch partialMatch) {
    return rawAccumulateAllValuesOfet(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for et.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EventToken> getAllValuesOfet(final StateMachine pSm) {
    return rawAccumulateAllValuesOfet(new Object[]{pSm, null});
  }
  
  @Override
  protected FinishedStateMachineMatch tupleToMatch(final Tuple t) {
    try {
    	return new FinishedStateMachineMatch.Immutable((hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine) t.get(POSITION_SM), (hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken) t.get(POSITION_ET));	
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in tuple not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected FinishedStateMachineMatch arrayToMatch(final Object[] match) {
    try {
    	return new FinishedStateMachineMatch.Immutable((hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine) match[POSITION_SM], (hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken) match[POSITION_ET]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected FinishedStateMachineMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return new FinishedStateMachineMatch.Mutable((hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine) match[POSITION_SM], (hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken) match[POSITION_ET]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
}
