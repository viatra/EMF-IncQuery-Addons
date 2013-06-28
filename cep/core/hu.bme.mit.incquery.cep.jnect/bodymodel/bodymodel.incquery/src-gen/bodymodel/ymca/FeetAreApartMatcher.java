package bodymodel.ymca;

import bodymodel.ymca.FeetAreApartMatch;
import bodymodel.ymca.util.FeetAreApartQuerySpecification;
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
import org.jnect.bodymodel.LeftFoot;
import org.jnect.bodymodel.RightFoot;

/**
 * Generated pattern matcher API of the bodymodel.ymca.feetAreApart pattern, 
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)}, 
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link FeetAreApartMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}QueryExplorer(display = true)
 * pattern feetAreApart(LF:LeftFoot,RF:RightFoot) {
 * 	LeftFoot.x(LF,LFX);
 * 	LeftFoot.y(LF,LFY);
 * 	LeftFoot.z(LF,LFZ);
 * 	RightFoot.x(RF,RFX);
 * 	RightFoot.y(RF,RFY);
 * 	RightFoot.z(RF,RFZ);
 * 	check( VectorMaths::lengthOf(
 * 		VectorMaths::createVector(
 * 			MovingAverageCalculator::getCalculator("LFX").addValue(LFX).movingAvg,
 * 			MovingAverageCalculator::getCalculator("LFY").addValue(LFY).movingAvg,
 * 			MovingAverageCalculator::getCalculator("LFZ").addValue(LFZ).movingAvg, 
 * 			MovingAverageCalculator::getCalculator("RFX").addValue(RFX).movingAvg,
 * 			MovingAverageCalculator::getCalculator("RFY").addValue(RFY).movingAvg,
 * 			MovingAverageCalculator::getCalculator("RFZ").addValue(RFZ).movingAvg
 * 		)) {@literal >} YMCAConstants::apartDistance );
 * }
 * </pre></code>
 * 
 * @see FeetAreApartMatch
 * @see FeetAreApartProcessor
 * @see FeetAreApartQuerySpecification
 * 
 */
public class FeetAreApartMatcher extends BaseMatcher<FeetAreApartMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine. 
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static FeetAreApartMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    FeetAreApartMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new FeetAreApartMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    } 	
    return matcher;
  }
  
  private final static int POSITION_LF = 0;
  
  private final static int POSITION_RF = 1;
  
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
  public FeetAreApartMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public FeetAreApartMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pLF the fixed value of pattern parameter LF, or null if not bound.
   * @param pRF the fixed value of pattern parameter RF, or null if not bound.
   * @return matches represented as a FeetAreApartMatch object.
   * 
   */
  public Collection<FeetAreApartMatch> getAllMatches(final LeftFoot pLF, final RightFoot pRF) {
    return rawGetAllMatches(new Object[]{pLF, pRF});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pLF the fixed value of pattern parameter LF, or null if not bound.
   * @param pRF the fixed value of pattern parameter RF, or null if not bound.
   * @return a match represented as a FeetAreApartMatch object, or null if no match is found.
   * 
   */
  public FeetAreApartMatch getOneArbitraryMatch(final LeftFoot pLF, final RightFoot pRF) {
    return rawGetOneArbitraryMatch(new Object[]{pLF, pRF});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pLF the fixed value of pattern parameter LF, or null if not bound.
   * @param pRF the fixed value of pattern parameter RF, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final LeftFoot pLF, final RightFoot pRF) {
    return rawHasMatch(new Object[]{pLF, pRF});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pLF the fixed value of pattern parameter LF, or null if not bound.
   * @param pRF the fixed value of pattern parameter RF, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final LeftFoot pLF, final RightFoot pRF) {
    return rawCountMatches(new Object[]{pLF, pRF});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pLF the fixed value of pattern parameter LF, or null if not bound.
   * @param pRF the fixed value of pattern parameter RF, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final LeftFoot pLF, final RightFoot pRF, final IMatchProcessor<? super FeetAreApartMatch> processor) {
    rawForEachMatch(new Object[]{pLF, pRF}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pLF the fixed value of pattern parameter LF, or null if not bound.
   * @param pRF the fixed value of pattern parameter RF, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final LeftFoot pLF, final RightFoot pRF, final IMatchProcessor<? super FeetAreApartMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pLF, pRF}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters. 
   * It can also be reset to track changes from a later point in time, 
   * and changes can even be acknowledged on an individual basis. 
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pLF the fixed value of pattern parameter LF, or null if not bound.
   * @param pRF the fixed value of pattern parameter RF, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<FeetAreApartMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final LeftFoot pLF, final RightFoot pRF) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pLF, pRF});
  }
  
  /**
   * Returns a new (partial) Match object for the matcher. 
   * This can be used e.g. to call the matcher with a partial match. 
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pLF the fixed value of pattern parameter LF, or null if not bound.
   * @param pRF the fixed value of pattern parameter RF, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public FeetAreApartMatch newMatch(final LeftFoot pLF, final RightFoot pRF) {
    return new FeetAreApartMatch.Immutable(pLF, pRF);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for LF.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<LeftFoot> rawAccumulateAllValuesOfLF(final Object[] parameters) {
    Set<LeftFoot> results = new HashSet<LeftFoot>();
    rawAccumulateAllValues(POSITION_LF, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for LF.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<LeftFoot> getAllValuesOfLF() {
    return rawAccumulateAllValuesOfLF(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for LF.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<LeftFoot> getAllValuesOfLF(final FeetAreApartMatch partialMatch) {
    return rawAccumulateAllValuesOfLF(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for LF.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<LeftFoot> getAllValuesOfLF(final RightFoot pRF) {
    return rawAccumulateAllValuesOfLF(new Object[]{null, pRF});
  }
  
  /**
   * Retrieve the set of values that occur in matches for RF.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<RightFoot> rawAccumulateAllValuesOfRF(final Object[] parameters) {
    Set<RightFoot> results = new HashSet<RightFoot>();
    rawAccumulateAllValues(POSITION_RF, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for RF.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightFoot> getAllValuesOfRF() {
    return rawAccumulateAllValuesOfRF(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for RF.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightFoot> getAllValuesOfRF(final FeetAreApartMatch partialMatch) {
    return rawAccumulateAllValuesOfRF(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for RF.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightFoot> getAllValuesOfRF(final LeftFoot pLF) {
    return rawAccumulateAllValuesOfRF(new Object[]{pLF, null});
  }
  
  @Override
  protected FeetAreApartMatch tupleToMatch(final Tuple t) {
    try {
    	return new FeetAreApartMatch.Immutable((org.jnect.bodymodel.LeftFoot) t.get(POSITION_LF), (org.jnect.bodymodel.RightFoot) t.get(POSITION_RF));	
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in tuple not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected FeetAreApartMatch arrayToMatch(final Object[] match) {
    try {
    	return new FeetAreApartMatch.Immutable((org.jnect.bodymodel.LeftFoot) match[POSITION_LF], (org.jnect.bodymodel.RightFoot) match[POSITION_RF]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected FeetAreApartMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return new FeetAreApartMatch.Mutable((org.jnect.bodymodel.LeftFoot) match[POSITION_LF], (org.jnect.bodymodel.RightFoot) match[POSITION_RF]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<FeetAreApartMatcher> querySpecification() throws IncQueryException {
    return FeetAreApartQuerySpecification.instance();
  }
}
