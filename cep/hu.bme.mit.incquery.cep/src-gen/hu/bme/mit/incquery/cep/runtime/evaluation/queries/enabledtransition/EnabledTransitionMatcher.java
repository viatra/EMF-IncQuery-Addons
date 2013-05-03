package hu.bme.mit.incquery.cep.runtime.evaluation.queries.enabledtransition;

import hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.enabledtransition.EnabledTransitionMatch;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.enabledtransition.EnabledTransitionMatcherFactory;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.incquery.runtime.api.EngineManager;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IMatcherFactory;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.rete.misc.DeltaMonitor;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * Generated pattern matcher API of the hu.bme.mit.incquery.cep.runtime.evaluation.queries.enabledTransition pattern, 
 * providing pattern-specific query methods.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern enabledTransition(t : Transition, cv:CurrentStateVisitor) {
 * 	find latestEvent(e);
 * 	Event.typeId(e, eventId);
 * 	Transition.guard.eventType(t, eventId);
 * 	Transition.preState.currentVisitors(t, cv);
 * 	neg find eventHandledByCSV(e, cv);
 * }
 * </pre></code>
 * 
 * @see EnabledTransitionMatch
 * @see EnabledTransitionMatcherFactory
 * @see EnabledTransitionProcessor
 * 
 */
public class EnabledTransitionMatcher extends BaseGeneratedMatcher<EnabledTransitionMatch> {
  private final static int POSITION_T = 0;
  
  private final static int POSITION_CV = 1;
  
  /**
   * Initializes the pattern matcher over a given EMF model root (recommended: Resource or ResourceSet). 
   * If a pattern matcher is already constructed with the same root, only a lightweight reference is created.
   * The scope of pattern matching will be the given EMF model root and below (see FAQ for more precise definition).
   * The match set will be incrementally refreshed upon updates from this scope.
   * <p>The matcher will be created within the managed {@link IncQueryEngine} belonging to the EMF model root, so 
   * multiple matchers will reuse the same engine and benefit from increased performance and reduced memory footprint.
   * @param emfRoot the root of the EMF containment hierarchy where the pattern matcher will operate. Recommended: Resource or ResourceSet.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public EnabledTransitionMatcher(final Notifier emfRoot) throws IncQueryException {
    this(EngineManager.getInstance().getIncQueryEngine(emfRoot));
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine. 
   * If the pattern matcher is already constructed in the engine, only a lightweight reference is created.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public EnabledTransitionMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, factory());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pT the fixed value of pattern parameter t, or null if not bound.
   * @param pCv the fixed value of pattern parameter cv, or null if not bound.
   * @return matches represented as a EnabledTransitionMatch object.
   * 
   */
  public Collection<EnabledTransitionMatch> getAllMatches(final Transition pT, final CurrentStateVisitor pCv) {
    return rawGetAllMatches(new Object[]{pT, pCv});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pT the fixed value of pattern parameter t, or null if not bound.
   * @param pCv the fixed value of pattern parameter cv, or null if not bound.
   * @return a match represented as a EnabledTransitionMatch object, or null if no match is found.
   * 
   */
  public EnabledTransitionMatch getOneArbitraryMatch(final Transition pT, final CurrentStateVisitor pCv) {
    return rawGetOneArbitraryMatch(new Object[]{pT, pCv});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pT the fixed value of pattern parameter t, or null if not bound.
   * @param pCv the fixed value of pattern parameter cv, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Transition pT, final CurrentStateVisitor pCv) {
    return rawHasMatch(new Object[]{pT, pCv});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pT the fixed value of pattern parameter t, or null if not bound.
   * @param pCv the fixed value of pattern parameter cv, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Transition pT, final CurrentStateVisitor pCv) {
    return rawCountMatches(new Object[]{pT, pCv});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pT the fixed value of pattern parameter t, or null if not bound.
   * @param pCv the fixed value of pattern parameter cv, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Transition pT, final CurrentStateVisitor pCv, final IMatchProcessor<? super EnabledTransitionMatch> processor) {
    rawForEachMatch(new Object[]{pT, pCv}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pT the fixed value of pattern parameter t, or null if not bound.
   * @param pCv the fixed value of pattern parameter cv, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Transition pT, final CurrentStateVisitor pCv, final IMatchProcessor<? super EnabledTransitionMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pT, pCv}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters. 
   * It can also be reset to track changes from a later point in time, 
   * and changes can even be acknowledged on an individual basis. 
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pT the fixed value of pattern parameter t, or null if not bound.
   * @param pCv the fixed value of pattern parameter cv, or null if not bound.
   * @return the delta monitor.
   * 
   */
  public DeltaMonitor<EnabledTransitionMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final Transition pT, final CurrentStateVisitor pCv) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pT, pCv});
  }
  
  /**
   * Returns a new (partial) Match object for the matcher. 
   * This can be used e.g. to call the matcher with a partial match. 
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pT the fixed value of pattern parameter t, or null if not bound.
   * @param pCv the fixed value of pattern parameter cv, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public EnabledTransitionMatch newMatch(final Transition pT, final CurrentStateVisitor pCv) {
    return new EnabledTransitionMatch.Immutable(pT, pCv);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for t.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Transition> rawAccumulateAllValuesOft(final Object[] parameters) {
    Set<Transition> results = new HashSet<Transition>();
    rawAccumulateAllValues(POSITION_T, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for t.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Transition> getAllValuesOft() {
    return rawAccumulateAllValuesOft(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for t.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Transition> getAllValuesOft(final EnabledTransitionMatch partialMatch) {
    return rawAccumulateAllValuesOft(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for t.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Transition> getAllValuesOft(final CurrentStateVisitor pCv) {
    return rawAccumulateAllValuesOft(new Object[]{null, pCv});
  }
  
  /**
   * Retrieve the set of values that occur in matches for cv.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<CurrentStateVisitor> rawAccumulateAllValuesOfcv(final Object[] parameters) {
    Set<CurrentStateVisitor> results = new HashSet<CurrentStateVisitor>();
    rawAccumulateAllValues(POSITION_CV, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for cv.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<CurrentStateVisitor> getAllValuesOfcv() {
    return rawAccumulateAllValuesOfcv(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for cv.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<CurrentStateVisitor> getAllValuesOfcv(final EnabledTransitionMatch partialMatch) {
    return rawAccumulateAllValuesOfcv(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for cv.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<CurrentStateVisitor> getAllValuesOfcv(final Transition pT) {
    return rawAccumulateAllValuesOfcv(new Object[]{pT, null});
  }
  
  @Override
  protected EnabledTransitionMatch tupleToMatch(final Tuple t) {
    try {
    	return new EnabledTransitionMatch.Immutable((hu.bme.mit.incquery.cep.metamodels.internalsm.Transition) t.get(POSITION_T), (hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor) t.get(POSITION_CV));	
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in tuple not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected EnabledTransitionMatch arrayToMatch(final Object[] match) {
    try {
    	return new EnabledTransitionMatch.Immutable((hu.bme.mit.incquery.cep.metamodels.internalsm.Transition) match[POSITION_T], (hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor) match[POSITION_CV]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected EnabledTransitionMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return new EnabledTransitionMatch.Mutable((hu.bme.mit.incquery.cep.metamodels.internalsm.Transition) match[POSITION_T], (hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor) match[POSITION_CV]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  /**
   * @return the singleton instance of the factory of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IMatcherFactory<EnabledTransitionMatcher> factory() throws IncQueryException {
    return EnabledTransitionMatcherFactory.instance();
  }
}
