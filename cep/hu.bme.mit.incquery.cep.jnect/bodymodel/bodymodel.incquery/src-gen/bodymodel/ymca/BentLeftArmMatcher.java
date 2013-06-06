package bodymodel.ymca;

import bodymodel.ymca.BentLeftArmMatch;
import bodymodel.ymca.util.BentLeftArmQuerySpecification;
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
import org.jnect.bodymodel.LeftElbow;
import org.jnect.bodymodel.LeftHand;
import org.jnect.bodymodel.LeftShoulder;

/**
 * Generated pattern matcher API of the bodymodel.ymca.bentLeftArm pattern, 
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)}, 
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link BentLeftArmMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}QueryExplorer(display = true)
 * pattern bentLeftArm(LH:LeftHand, // hand 
 * 					LE:LeftElbow, // elbow
 * 					LS:LeftShoulder // shoulder
 * ) {
 * 	// indicate coordinates to be used for check calculation
 * 	PositionedElement.x(LH,LHX);
 * 	PositionedElement.y(LH,LHY);
 * 	PositionedElement.z(LH,LHZ);
 * 	PositionedElement.x(LE,LEX);
 * 	PositionedElement.y(LE,LEY);
 * 	PositionedElement.z(LE,LEZ);
 * 	PositionedElement.x(LS,LSX);
 * 	PositionedElement.y(LS,LSY);
 * 	PositionedElement.z(LS,LSZ);
 * 	// check that the angle between the lower arm (H-E)
 * 	// and upper arm (S-E) is around PI/2 (90')
 * 	check({
 * 		// we need to "wire" attribute values into the check expression
 * 		var float angleBetween = VectorMaths::angleBetween(
 * 			VectorMaths::createVector(
 * 				MovingAverageCalculator::getCalculator("LHX").addValue(LHX).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("LHY").addValue(LHY).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("LHZ").addValue(LHZ).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("LEX").addValue(LEX).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("LEY").addValue(LEY).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("LEZ").addValue(LEZ).movingAvg
 * 			),
 * 			VectorMaths::createVector(
 * 				MovingAverageCalculator::getCalculator("LSX").addValue(LSX).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("LSY").addValue(LSY).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("LSZ").addValue(LSZ).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("LEX").addValue(LEX).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("LEY").addValue(LEY).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("LEZ").addValue(LEZ).movingAvg
 * 			)
 * 		)
 * 		// System::out.println(angleBetween)
 * 		Math::abs(Math::PI/2 - angleBetween) {@literal <} YMCAConstants::angleTolerance
 * 	});
 * }
 * </pre></code>
 * 
 * @see BentLeftArmMatch
 * @see BentLeftArmProcessor
 * @see BentLeftArmQuerySpecification
 * 
 */
public class BentLeftArmMatcher extends BaseMatcher<BentLeftArmMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine. 
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static BentLeftArmMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    BentLeftArmMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new BentLeftArmMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    } 	
    return matcher;
  }
  
  private final static int POSITION_LH = 0;
  
  private final static int POSITION_LE = 1;
  
  private final static int POSITION_LS = 2;
  
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
  public BentLeftArmMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public BentLeftArmMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @return matches represented as a BentLeftArmMatch object.
   * 
   */
  public Collection<BentLeftArmMatch> getAllMatches(final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS) {
    return rawGetAllMatches(new Object[]{pLH, pLE, pLS});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @return a match represented as a BentLeftArmMatch object, or null if no match is found.
   * 
   */
  public BentLeftArmMatch getOneArbitraryMatch(final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS) {
    return rawGetOneArbitraryMatch(new Object[]{pLH, pLE, pLS});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS) {
    return rawHasMatch(new Object[]{pLH, pLE, pLS});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS) {
    return rawCountMatches(new Object[]{pLH, pLE, pLS});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final IMatchProcessor<? super BentLeftArmMatch> processor) {
    rawForEachMatch(new Object[]{pLH, pLE, pLS}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final IMatchProcessor<? super BentLeftArmMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pLH, pLE, pLS}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters. 
   * It can also be reset to track changes from a later point in time, 
   * and changes can even be acknowledged on an individual basis. 
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<BentLeftArmMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pLH, pLE, pLS});
  }
  
  /**
   * Returns a new (partial) Match object for the matcher. 
   * This can be used e.g. to call the matcher with a partial match. 
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public BentLeftArmMatch newMatch(final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS) {
    return new BentLeftArmMatch.Immutable(pLH, pLE, pLS);
    
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
  public Set<LeftHand> getAllValuesOfLH(final BentLeftArmMatch partialMatch) {
    return rawAccumulateAllValuesOfLH(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for LH.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<LeftHand> getAllValuesOfLH(final LeftElbow pLE, final LeftShoulder pLS) {
    return rawAccumulateAllValuesOfLH(new Object[]{null, pLE, pLS});
  }
  
  /**
   * Retrieve the set of values that occur in matches for LE.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<LeftElbow> rawAccumulateAllValuesOfLE(final Object[] parameters) {
    Set<LeftElbow> results = new HashSet<LeftElbow>();
    rawAccumulateAllValues(POSITION_LE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for LE.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<LeftElbow> getAllValuesOfLE() {
    return rawAccumulateAllValuesOfLE(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for LE.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<LeftElbow> getAllValuesOfLE(final BentLeftArmMatch partialMatch) {
    return rawAccumulateAllValuesOfLE(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for LE.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<LeftElbow> getAllValuesOfLE(final LeftHand pLH, final LeftShoulder pLS) {
    return rawAccumulateAllValuesOfLE(new Object[]{pLH, null, pLS});
  }
  
  /**
   * Retrieve the set of values that occur in matches for LS.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<LeftShoulder> rawAccumulateAllValuesOfLS(final Object[] parameters) {
    Set<LeftShoulder> results = new HashSet<LeftShoulder>();
    rawAccumulateAllValues(POSITION_LS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for LS.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<LeftShoulder> getAllValuesOfLS() {
    return rawAccumulateAllValuesOfLS(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for LS.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<LeftShoulder> getAllValuesOfLS(final BentLeftArmMatch partialMatch) {
    return rawAccumulateAllValuesOfLS(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for LS.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<LeftShoulder> getAllValuesOfLS(final LeftHand pLH, final LeftElbow pLE) {
    return rawAccumulateAllValuesOfLS(new Object[]{pLH, pLE, null});
  }
  
  @Override
  protected BentLeftArmMatch tupleToMatch(final Tuple t) {
    try {
    	return new BentLeftArmMatch.Immutable((org.jnect.bodymodel.LeftHand) t.get(POSITION_LH), (org.jnect.bodymodel.LeftElbow) t.get(POSITION_LE), (org.jnect.bodymodel.LeftShoulder) t.get(POSITION_LS));	
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in tuple not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected BentLeftArmMatch arrayToMatch(final Object[] match) {
    try {
    	return new BentLeftArmMatch.Immutable((org.jnect.bodymodel.LeftHand) match[POSITION_LH], (org.jnect.bodymodel.LeftElbow) match[POSITION_LE], (org.jnect.bodymodel.LeftShoulder) match[POSITION_LS]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected BentLeftArmMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return new BentLeftArmMatch.Mutable((org.jnect.bodymodel.LeftHand) match[POSITION_LH], (org.jnect.bodymodel.LeftElbow) match[POSITION_LE], (org.jnect.bodymodel.LeftShoulder) match[POSITION_LS]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<BentLeftArmMatcher> querySpecification() throws IncQueryException {
    return BentLeftArmQuerySpecification.instance();
  }
}
