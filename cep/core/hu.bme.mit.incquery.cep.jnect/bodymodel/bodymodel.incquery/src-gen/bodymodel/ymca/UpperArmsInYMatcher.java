package bodymodel.ymca;

import bodymodel.ymca.UpperArmsInYMatch;
import bodymodel.ymca.util.UpperArmsInYQuerySpecification;
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
import org.jnect.bodymodel.LeftShoulder;
import org.jnect.bodymodel.RightElbow;
import org.jnect.bodymodel.RightShoulder;

/**
 * Generated pattern matcher API of the bodymodel.ymca.upperArmsInY pattern, 
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)}, 
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link UpperArmsInYMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}QueryExplorer(display = true)
 * pattern upperArmsInY(LE:LeftElbow,
 * 					 LS:LeftShoulder,
 * 					 RE:RightElbow,
 * 					 RS:RightShoulder
 * ) {
 * 	// indicate coordinates to be used for check calculation
 * 	PositionedElement.x(LE,LEX);
 * 	PositionedElement.y(LE,LEY);
 * 	PositionedElement.z(LE,LEZ);
 * 	PositionedElement.x(LS,LSX);
 * 	PositionedElement.y(LS,LSY);
 * 	PositionedElement.z(LS,LSZ);
 * 	PositionedElement.x(RE,REX);
 * 	PositionedElement.y(RE,REY);
 * 	PositionedElement.z(RE,REZ);
 * 	PositionedElement.x(RS,RSX);
 * 	PositionedElement.y(RS,RSY);
 * 	PositionedElement.z(RS,RSZ);
 * 	// check that the angle between the left upper arm (LE-LS)
 * 	// and right upper arm (RE-RS) is around PI/3 (60')
 * 	check({
 * 		// we need to "wire" attribute values into the check expression
 * 		var float angleBetween = VectorMaths::angleBetween(
 * 			VectorMaths::createVector(
 * 				MovingAverageCalculator::getCalculator("LEX").addValue(LEX).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("LEY").addValue(LEY).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("LEZ").addValue(LEZ).movingAvg,
 * 				MovingAverageCalculator::getCalculator("LSX").addValue(LSX).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("LSY").addValue(LSY).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("LSZ").addValue(LSZ).movingAvg
 * 			),
 * 			VectorMaths::createVector(
 * 				MovingAverageCalculator::getCalculator("REX").addValue(REX).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("REY").addValue(REY).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("REZ").addValue(REZ).movingAvg,
 * 				MovingAverageCalculator::getCalculator("RSX").addValue(RSX).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("RSY").addValue(RSY).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("RSZ").addValue(RSZ).movingAvg
 * 			)
 * 		)
 * 		// System::out.println(angleBetween)
 * 		Math::abs(Math::PI/3 - angleBetween) {@literal <} YMCAConstants::angleTolerance
 * 	});
 * }
 * </pre></code>
 * 
 * @see UpperArmsInYMatch
 * @see UpperArmsInYProcessor
 * @see UpperArmsInYQuerySpecification
 * 
 */
public class UpperArmsInYMatcher extends BaseMatcher<UpperArmsInYMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine. 
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static UpperArmsInYMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    UpperArmsInYMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new UpperArmsInYMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    } 	
    return matcher;
  }
  
  private final static int POSITION_LE = 0;
  
  private final static int POSITION_LS = 1;
  
  private final static int POSITION_RE = 2;
  
  private final static int POSITION_RS = 3;
  
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
  public UpperArmsInYMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public UpperArmsInYMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @return matches represented as a UpperArmsInYMatch object.
   * 
   */
  public Collection<UpperArmsInYMatch> getAllMatches(final LeftElbow pLE, final LeftShoulder pLS, final RightElbow pRE, final RightShoulder pRS) {
    return rawGetAllMatches(new Object[]{pLE, pLS, pRE, pRS});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @return a match represented as a UpperArmsInYMatch object, or null if no match is found.
   * 
   */
  public UpperArmsInYMatch getOneArbitraryMatch(final LeftElbow pLE, final LeftShoulder pLS, final RightElbow pRE, final RightShoulder pRS) {
    return rawGetOneArbitraryMatch(new Object[]{pLE, pLS, pRE, pRS});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final LeftElbow pLE, final LeftShoulder pLS, final RightElbow pRE, final RightShoulder pRS) {
    return rawHasMatch(new Object[]{pLE, pLS, pRE, pRS});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final LeftElbow pLE, final LeftShoulder pLS, final RightElbow pRE, final RightShoulder pRS) {
    return rawCountMatches(new Object[]{pLE, pLS, pRE, pRS});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final LeftElbow pLE, final LeftShoulder pLS, final RightElbow pRE, final RightShoulder pRS, final IMatchProcessor<? super UpperArmsInYMatch> processor) {
    rawForEachMatch(new Object[]{pLE, pLS, pRE, pRS}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final LeftElbow pLE, final LeftShoulder pLS, final RightElbow pRE, final RightShoulder pRS, final IMatchProcessor<? super UpperArmsInYMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pLE, pLS, pRE, pRS}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters. 
   * It can also be reset to track changes from a later point in time, 
   * and changes can even be acknowledged on an individual basis. 
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<UpperArmsInYMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final LeftElbow pLE, final LeftShoulder pLS, final RightElbow pRE, final RightShoulder pRS) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pLE, pLS, pRE, pRS});
  }
  
  /**
   * Returns a new (partial) Match object for the matcher. 
   * This can be used e.g. to call the matcher with a partial match. 
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public UpperArmsInYMatch newMatch(final LeftElbow pLE, final LeftShoulder pLS, final RightElbow pRE, final RightShoulder pRS) {
    return new UpperArmsInYMatch.Immutable(pLE, pLS, pRE, pRS);
    
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
  public Set<LeftElbow> getAllValuesOfLE(final UpperArmsInYMatch partialMatch) {
    return rawAccumulateAllValuesOfLE(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for LE.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<LeftElbow> getAllValuesOfLE(final LeftShoulder pLS, final RightElbow pRE, final RightShoulder pRS) {
    return rawAccumulateAllValuesOfLE(new Object[]{null, pLS, pRE, pRS});
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
  public Set<LeftShoulder> getAllValuesOfLS(final UpperArmsInYMatch partialMatch) {
    return rawAccumulateAllValuesOfLS(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for LS.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<LeftShoulder> getAllValuesOfLS(final LeftElbow pLE, final RightElbow pRE, final RightShoulder pRS) {
    return rawAccumulateAllValuesOfLS(new Object[]{pLE, null, pRE, pRS});
  }
  
  /**
   * Retrieve the set of values that occur in matches for RE.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<RightElbow> rawAccumulateAllValuesOfRE(final Object[] parameters) {
    Set<RightElbow> results = new HashSet<RightElbow>();
    rawAccumulateAllValues(POSITION_RE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for RE.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightElbow> getAllValuesOfRE() {
    return rawAccumulateAllValuesOfRE(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for RE.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightElbow> getAllValuesOfRE(final UpperArmsInYMatch partialMatch) {
    return rawAccumulateAllValuesOfRE(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for RE.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightElbow> getAllValuesOfRE(final LeftElbow pLE, final LeftShoulder pLS, final RightShoulder pRS) {
    return rawAccumulateAllValuesOfRE(new Object[]{pLE, pLS, null, pRS});
  }
  
  /**
   * Retrieve the set of values that occur in matches for RS.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<RightShoulder> rawAccumulateAllValuesOfRS(final Object[] parameters) {
    Set<RightShoulder> results = new HashSet<RightShoulder>();
    rawAccumulateAllValues(POSITION_RS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for RS.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightShoulder> getAllValuesOfRS() {
    return rawAccumulateAllValuesOfRS(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for RS.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightShoulder> getAllValuesOfRS(final UpperArmsInYMatch partialMatch) {
    return rawAccumulateAllValuesOfRS(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for RS.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightShoulder> getAllValuesOfRS(final LeftElbow pLE, final LeftShoulder pLS, final RightElbow pRE) {
    return rawAccumulateAllValuesOfRS(new Object[]{pLE, pLS, pRE, null});
  }
  
  @Override
  protected UpperArmsInYMatch tupleToMatch(final Tuple t) {
    try {
    	return new UpperArmsInYMatch.Immutable((org.jnect.bodymodel.LeftElbow) t.get(POSITION_LE), (org.jnect.bodymodel.LeftShoulder) t.get(POSITION_LS), (org.jnect.bodymodel.RightElbow) t.get(POSITION_RE), (org.jnect.bodymodel.RightShoulder) t.get(POSITION_RS));	
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in tuple not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected UpperArmsInYMatch arrayToMatch(final Object[] match) {
    try {
    	return new UpperArmsInYMatch.Immutable((org.jnect.bodymodel.LeftElbow) match[POSITION_LE], (org.jnect.bodymodel.LeftShoulder) match[POSITION_LS], (org.jnect.bodymodel.RightElbow) match[POSITION_RE], (org.jnect.bodymodel.RightShoulder) match[POSITION_RS]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected UpperArmsInYMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return new UpperArmsInYMatch.Mutable((org.jnect.bodymodel.LeftElbow) match[POSITION_LE], (org.jnect.bodymodel.LeftShoulder) match[POSITION_LS], (org.jnect.bodymodel.RightElbow) match[POSITION_RE], (org.jnect.bodymodel.RightShoulder) match[POSITION_RS]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<UpperArmsInYMatcher> querySpecification() throws IncQueryException {
    return UpperArmsInYQuerySpecification.instance();
  }
}
