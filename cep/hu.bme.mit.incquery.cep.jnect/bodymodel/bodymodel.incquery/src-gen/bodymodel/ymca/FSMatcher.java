package bodymodel.ymca;

import bodymodel.ymca.FSMatch;
import bodymodel.ymca.util.FSQuerySpecification;
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
import org.jnect.bodymodel.Head;
import org.jnect.bodymodel.RightElbow;
import org.jnect.bodymodel.RightHand;
import org.jnect.bodymodel.RightShoulder;

/**
 * Generated pattern matcher API of the bodymodel.ymca.FS pattern, 
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)}, 
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link FSMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * // "control powerpoint with awt.Robot" demo
 * 
 *  
 * pattern FS(RH: RightHand,
 * 					  RE: RightElbow,
 * 					  RS: RightShoulder,
 * 					   H: Head) 
 * {
 * 	find stretchedRightArm(RH,RE,RS);
 * 	neg find rightHandAboveHead(RH,H);
 * }
 * </pre></code>
 * 
 * @see FSMatch
 * @see FSProcessor
 * @see FSQuerySpecification
 * 
 */
public class FSMatcher extends BaseMatcher<FSMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine. 
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static FSMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    FSMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new FSMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    } 	
    return matcher;
  }
  
  private final static int POSITION_RH = 0;
  
  private final static int POSITION_RE = 1;
  
  private final static int POSITION_RS = 2;
  
  private final static int POSITION_H = 3;
  
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
  public FSMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public FSMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @return matches represented as a FSMatch object.
   * 
   */
  public Collection<FSMatch> getAllMatches(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final Head pH) {
    return rawGetAllMatches(new Object[]{pRH, pRE, pRS, pH});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @return a match represented as a FSMatch object, or null if no match is found.
   * 
   */
  public FSMatch getOneArbitraryMatch(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final Head pH) {
    return rawGetOneArbitraryMatch(new Object[]{pRH, pRE, pRS, pH});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final Head pH) {
    return rawHasMatch(new Object[]{pRH, pRE, pRS, pH});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final Head pH) {
    return rawCountMatches(new Object[]{pRH, pRE, pRS, pH});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final Head pH, final IMatchProcessor<? super FSMatch> processor) {
    rawForEachMatch(new Object[]{pRH, pRE, pRS, pH}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final Head pH, final IMatchProcessor<? super FSMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pRH, pRE, pRS, pH}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters. 
   * It can also be reset to track changes from a later point in time, 
   * and changes can even be acknowledged on an individual basis. 
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<FSMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final Head pH) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pRH, pRE, pRS, pH});
  }
  
  /**
   * Returns a new (partial) Match object for the matcher. 
   * This can be used e.g. to call the matcher with a partial match. 
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public FSMatch newMatch(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final Head pH) {
    return new FSMatch.Immutable(pRH, pRE, pRS, pH);
    
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
  public Set<RightHand> getAllValuesOfRH(final FSMatch partialMatch) {
    return rawAccumulateAllValuesOfRH(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for RH.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightHand> getAllValuesOfRH(final RightElbow pRE, final RightShoulder pRS, final Head pH) {
    return rawAccumulateAllValuesOfRH(new Object[]{null, pRE, pRS, pH});
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
  public Set<RightElbow> getAllValuesOfRE(final FSMatch partialMatch) {
    return rawAccumulateAllValuesOfRE(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for RE.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightElbow> getAllValuesOfRE(final RightHand pRH, final RightShoulder pRS, final Head pH) {
    return rawAccumulateAllValuesOfRE(new Object[]{pRH, null, pRS, pH});
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
  public Set<RightShoulder> getAllValuesOfRS(final FSMatch partialMatch) {
    return rawAccumulateAllValuesOfRS(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for RS.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightShoulder> getAllValuesOfRS(final RightHand pRH, final RightElbow pRE, final Head pH) {
    return rawAccumulateAllValuesOfRS(new Object[]{pRH, pRE, null, pH});
  }
  
  /**
   * Retrieve the set of values that occur in matches for H.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Head> rawAccumulateAllValuesOfH(final Object[] parameters) {
    Set<Head> results = new HashSet<Head>();
    rawAccumulateAllValues(POSITION_H, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for H.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Head> getAllValuesOfH() {
    return rawAccumulateAllValuesOfH(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for H.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Head> getAllValuesOfH(final FSMatch partialMatch) {
    return rawAccumulateAllValuesOfH(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for H.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Head> getAllValuesOfH(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS) {
    return rawAccumulateAllValuesOfH(new Object[]{pRH, pRE, pRS, null});
  }
  
  @Override
  protected FSMatch tupleToMatch(final Tuple t) {
    try {
    	return new FSMatch.Immutable((org.jnect.bodymodel.RightHand) t.get(POSITION_RH), (org.jnect.bodymodel.RightElbow) t.get(POSITION_RE), (org.jnect.bodymodel.RightShoulder) t.get(POSITION_RS), (org.jnect.bodymodel.Head) t.get(POSITION_H));	
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in tuple not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected FSMatch arrayToMatch(final Object[] match) {
    try {
    	return new FSMatch.Immutable((org.jnect.bodymodel.RightHand) match[POSITION_RH], (org.jnect.bodymodel.RightElbow) match[POSITION_RE], (org.jnect.bodymodel.RightShoulder) match[POSITION_RS], (org.jnect.bodymodel.Head) match[POSITION_H]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected FSMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return new FSMatch.Mutable((org.jnect.bodymodel.RightHand) match[POSITION_RH], (org.jnect.bodymodel.RightElbow) match[POSITION_RE], (org.jnect.bodymodel.RightShoulder) match[POSITION_RS], (org.jnect.bodymodel.Head) match[POSITION_H]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<FSMatcher> querySpecification() throws IncQueryException {
    return FSQuerySpecification.instance();
  }
}
