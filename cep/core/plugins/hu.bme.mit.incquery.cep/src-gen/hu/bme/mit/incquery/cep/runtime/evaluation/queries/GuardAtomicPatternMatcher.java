package hu.bme.mit.incquery.cep.runtime.evaluation.queries;

import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Guard;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.GuardAtomicPatternMatch;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.util.GuardAtomicPatternQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.incquery.cep.runtime.evaluation.queries.guardAtomicPattern pattern, 
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)}, 
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link GuardAtomicPatternMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern guardAtomicPattern(guard : Guard, atomicPattern : AtomicEventPattern) {
 * 	Guard.eventType(guard, atomicPattern);
 * }
 * </pre></code>
 * 
 * @see GuardAtomicPatternMatch
 * @see GuardAtomicPatternProcessor
 * @see GuardAtomicPatternQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class GuardAtomicPatternMatcher extends BaseMatcher<GuardAtomicPatternMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<GuardAtomicPatternMatcher> querySpecification() throws IncQueryException {
    return GuardAtomicPatternQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine. 
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static GuardAtomicPatternMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    GuardAtomicPatternMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new GuardAtomicPatternMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    } 	
    return matcher;
  }
  
  private final static int POSITION_GUARD = 0;
  
  private final static int POSITION_ATOMICPATTERN = 1;
  
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
  public GuardAtomicPatternMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public GuardAtomicPatternMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pGuard the fixed value of pattern parameter guard, or null if not bound.
   * @param pAtomicPattern the fixed value of pattern parameter atomicPattern, or null if not bound.
   * @return matches represented as a GuardAtomicPatternMatch object.
   * 
   */
  public Collection<GuardAtomicPatternMatch> getAllMatches(final Guard pGuard, final AtomicEventPattern pAtomicPattern) {
    return rawGetAllMatches(new Object[]{pGuard, pAtomicPattern});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pGuard the fixed value of pattern parameter guard, or null if not bound.
   * @param pAtomicPattern the fixed value of pattern parameter atomicPattern, or null if not bound.
   * @return a match represented as a GuardAtomicPatternMatch object, or null if no match is found.
   * 
   */
  public GuardAtomicPatternMatch getOneArbitraryMatch(final Guard pGuard, final AtomicEventPattern pAtomicPattern) {
    return rawGetOneArbitraryMatch(new Object[]{pGuard, pAtomicPattern});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pGuard the fixed value of pattern parameter guard, or null if not bound.
   * @param pAtomicPattern the fixed value of pattern parameter atomicPattern, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Guard pGuard, final AtomicEventPattern pAtomicPattern) {
    return rawHasMatch(new Object[]{pGuard, pAtomicPattern});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pGuard the fixed value of pattern parameter guard, or null if not bound.
   * @param pAtomicPattern the fixed value of pattern parameter atomicPattern, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Guard pGuard, final AtomicEventPattern pAtomicPattern) {
    return rawCountMatches(new Object[]{pGuard, pAtomicPattern});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pGuard the fixed value of pattern parameter guard, or null if not bound.
   * @param pAtomicPattern the fixed value of pattern parameter atomicPattern, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Guard pGuard, final AtomicEventPattern pAtomicPattern, final IMatchProcessor<? super GuardAtomicPatternMatch> processor) {
    rawForEachMatch(new Object[]{pGuard, pAtomicPattern}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pGuard the fixed value of pattern parameter guard, or null if not bound.
   * @param pAtomicPattern the fixed value of pattern parameter atomicPattern, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Guard pGuard, final AtomicEventPattern pAtomicPattern, final IMatchProcessor<? super GuardAtomicPatternMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pGuard, pAtomicPattern}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters. 
   * It can also be reset to track changes from a later point in time, 
   * and changes can even be acknowledged on an individual basis. 
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pGuard the fixed value of pattern parameter guard, or null if not bound.
   * @param pAtomicPattern the fixed value of pattern parameter atomicPattern, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<GuardAtomicPatternMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final Guard pGuard, final AtomicEventPattern pAtomicPattern) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pGuard, pAtomicPattern});
  }
  
  /**
   * Returns a new (partial) Match object for the matcher. 
   * This can be used e.g. to call the matcher with a partial match. 
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pGuard the fixed value of pattern parameter guard, or null if not bound.
   * @param pAtomicPattern the fixed value of pattern parameter atomicPattern, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public GuardAtomicPatternMatch newMatch(final Guard pGuard, final AtomicEventPattern pAtomicPattern) {
    return new GuardAtomicPatternMatch.Immutable(pGuard, pAtomicPattern);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for guard.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Guard> rawAccumulateAllValuesOfguard(final Object[] parameters) {
    Set<Guard> results = new HashSet<Guard>();
    rawAccumulateAllValues(POSITION_GUARD, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for guard.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Guard> getAllValuesOfguard() {
    return rawAccumulateAllValuesOfguard(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for guard.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Guard> getAllValuesOfguard(final GuardAtomicPatternMatch partialMatch) {
    return rawAccumulateAllValuesOfguard(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for guard.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Guard> getAllValuesOfguard(final AtomicEventPattern pAtomicPattern) {
    return rawAccumulateAllValuesOfguard(new Object[]{null, pAtomicPattern});
  }
  
  /**
   * Retrieve the set of values that occur in matches for atomicPattern.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<AtomicEventPattern> rawAccumulateAllValuesOfatomicPattern(final Object[] parameters) {
    Set<AtomicEventPattern> results = new HashSet<AtomicEventPattern>();
    rawAccumulateAllValues(POSITION_ATOMICPATTERN, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for atomicPattern.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<AtomicEventPattern> getAllValuesOfatomicPattern() {
    return rawAccumulateAllValuesOfatomicPattern(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for atomicPattern.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<AtomicEventPattern> getAllValuesOfatomicPattern(final GuardAtomicPatternMatch partialMatch) {
    return rawAccumulateAllValuesOfatomicPattern(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for atomicPattern.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<AtomicEventPattern> getAllValuesOfatomicPattern(final Guard pGuard) {
    return rawAccumulateAllValuesOfatomicPattern(new Object[]{pGuard, null});
  }
  
  @Override
  protected GuardAtomicPatternMatch tupleToMatch(final Tuple t) {
    try {
    	return new GuardAtomicPatternMatch.Immutable((hu.bme.mit.incquery.cep.metamodels.internalsm.Guard) t.get(POSITION_GUARD), (hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern) t.get(POSITION_ATOMICPATTERN));	
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in tuple not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected GuardAtomicPatternMatch arrayToMatch(final Object[] match) {
    try {
    	return new GuardAtomicPatternMatch.Immutable((hu.bme.mit.incquery.cep.metamodels.internalsm.Guard) match[POSITION_GUARD], (hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern) match[POSITION_ATOMICPATTERN]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected GuardAtomicPatternMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return new GuardAtomicPatternMatch.Mutable((hu.bme.mit.incquery.cep.metamodels.internalsm.Guard) match[POSITION_GUARD], (hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern) match[POSITION_ATOMICPATTERN]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
}
