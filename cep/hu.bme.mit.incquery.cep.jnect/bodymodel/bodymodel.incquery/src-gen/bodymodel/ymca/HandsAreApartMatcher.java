package bodymodel.ymca;

import bodymodel.ymca.HandsAreApartMatch;
import bodymodel.ymca.util.HandsAreApartQuerySpecification;
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
import org.jnect.bodymodel.LeftHand;
import org.jnect.bodymodel.RightHand;

/**
 * Generated pattern matcher API of the bodymodel.ymca.handsAreApart pattern, 
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)}, 
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link HandsAreApartMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}QueryExplorer(display = true)
 * pattern handsAreApart(LH:LeftHand,RH:RightHand) {
 * 	LeftHand.x(LH,LHX);
 * 	LeftHand.y(LH,LHY);
 * 	LeftHand.z(LH,LHZ);
 * 	RightHand.x(RH,RHX);
 * 	RightHand.y(RH,RHY);
 * 	RightHand.z(RH,RHZ);
 * 	check( VectorMaths::lengthOf(
 * 		VectorMaths::createVector(
 * 			MovingAverageCalculator::getCalculator("LHX").addValue(LHX).movingAvg,
 * 			MovingAverageCalculator::getCalculator("LHY").addValue(LHY).movingAvg,
 * 			MovingAverageCalculator::getCalculator("LHZ").addValue(LHZ).movingAvg, 
 * 			MovingAverageCalculator::getCalculator("RHX").addValue(RHX).movingAvg,
 * 			MovingAverageCalculator::getCalculator("RHY").addValue(RHY).movingAvg,
 * 			MovingAverageCalculator::getCalculator("RHZ").addValue(RHZ).movingAvg
 * 		)) {@literal >} YMCAConstants::apartDistance );
 * }
 * </pre></code>
 * 
 * @see HandsAreApartMatch
 * @see HandsAreApartProcessor
 * @see HandsAreApartQuerySpecification
 * 
 */
public class HandsAreApartMatcher extends BaseMatcher<HandsAreApartMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine. 
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static HandsAreApartMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    HandsAreApartMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new HandsAreApartMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    } 	
    return matcher;
  }
  
  private final static int POSITION_LH = 0;
  
  private final static int POSITION_RH = 1;
  
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
  public HandsAreApartMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public HandsAreApartMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @return matches represented as a HandsAreApartMatch object.
   * 
   */
  public Collection<HandsAreApartMatch> getAllMatches(final LeftHand pLH, final RightHand pRH) {
    return rawGetAllMatches(new Object[]{pLH, pRH});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @return a match represented as a HandsAreApartMatch object, or null if no match is found.
   * 
   */
  public HandsAreApartMatch getOneArbitraryMatch(final LeftHand pLH, final RightHand pRH) {
    return rawGetOneArbitraryMatch(new Object[]{pLH, pRH});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final LeftHand pLH, final RightHand pRH) {
    return rawHasMatch(new Object[]{pLH, pRH});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final LeftHand pLH, final RightHand pRH) {
    return rawCountMatches(new Object[]{pLH, pRH});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final LeftHand pLH, final RightHand pRH, final IMatchProcessor<? super HandsAreApartMatch> processor) {
    rawForEachMatch(new Object[]{pLH, pRH}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final LeftHand pLH, final RightHand pRH, final IMatchProcessor<? super HandsAreApartMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pLH, pRH}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters. 
   * It can also be reset to track changes from a later point in time, 
   * and changes can even be acknowledged on an individual basis. 
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<HandsAreApartMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final LeftHand pLH, final RightHand pRH) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pLH, pRH});
  }
  
  /**
   * Returns a new (partial) Match object for the matcher. 
   * This can be used e.g. to call the matcher with a partial match. 
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public HandsAreApartMatch newMatch(final LeftHand pLH, final RightHand pRH) {
    return new HandsAreApartMatch.Immutable(pLH, pRH);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for LH.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<LeftHand> rawAccumulateAllValuesOfLH(final Object[] parameters) {
    Set<LeftHand> results = new HashSet<LeftHand>();
    rawAccumulateAllValues(POSITION_LH, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for LH.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<LeftHand> getAllValuesOfLH() {
    return rawAccumulateAllValuesOfLH(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for LH.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<LeftHand> getAllValuesOfLH(final HandsAreApartMatch partialMatch) {
    return rawAccumulateAllValuesOfLH(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for LH.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<LeftHand> getAllValuesOfLH(final RightHand pRH) {
    return rawAccumulateAllValuesOfLH(new Object[]{null, pRH});
  }
  
  /**
   * Retrieve the set of values that occur in matches for RH.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<RightHand> rawAccumulateAllValuesOfRH(final Object[] parameters) {
    Set<RightHand> results = new HashSet<RightHand>();
    rawAccumulateAllValues(POSITION_RH, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for RH.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightHand> getAllValuesOfRH() {
    return rawAccumulateAllValuesOfRH(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for RH.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightHand> getAllValuesOfRH(final HandsAreApartMatch partialMatch) {
    return rawAccumulateAllValuesOfRH(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for RH.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightHand> getAllValuesOfRH(final LeftHand pLH) {
    return rawAccumulateAllValuesOfRH(new Object[]{pLH, null});
  }
  
  @Override
  protected HandsAreApartMatch tupleToMatch(final Tuple t) {
    try {
    	return new HandsAreApartMatch.Immutable((org.jnect.bodymodel.LeftHand) t.get(POSITION_LH), (org.jnect.bodymodel.RightHand) t.get(POSITION_RH));	
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in tuple not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected HandsAreApartMatch arrayToMatch(final Object[] match) {
    try {
    	return new HandsAreApartMatch.Immutable((org.jnect.bodymodel.LeftHand) match[POSITION_LH], (org.jnect.bodymodel.RightHand) match[POSITION_RH]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected HandsAreApartMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return new HandsAreApartMatch.Mutable((org.jnect.bodymodel.LeftHand) match[POSITION_LH], (org.jnect.bodymodel.RightHand) match[POSITION_RH]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<HandsAreApartMatcher> querySpecification() throws IncQueryException {
    return HandsAreApartQuerySpecification.instance();
  }
}
