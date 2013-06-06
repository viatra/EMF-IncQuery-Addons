package bodymodel.ymca;

import bodymodel.ymca.BSMatch;
import bodymodel.ymca.util.BSQuerySpecification;
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
import org.jnect.bodymodel.LeftElbow;
import org.jnect.bodymodel.LeftHand;
import org.jnect.bodymodel.LeftShoulder;

/**
 * Generated pattern matcher API of the bodymodel.ymca.BS pattern, 
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)}, 
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link BSMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern BS(LH: LeftHand,
 * 					   LE: LeftElbow,
 * 					   LS: LeftShoulder,
 * 					   H: Head) 
 * {
 * 	find stretchedLeftArm(LH,LE,LS);
 * 	neg find leftHandAboveHead(LH,H);
 * }
 * </pre></code>
 * 
 * @see BSMatch
 * @see BSProcessor
 * @see BSQuerySpecification
 * 
 */
public class BSMatcher extends BaseMatcher<BSMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine. 
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static BSMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    BSMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new BSMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    } 	
    return matcher;
  }
  
  private final static int POSITION_LH = 0;
  
  private final static int POSITION_LE = 1;
  
  private final static int POSITION_LS = 2;
  
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
  public BSMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public BSMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @return matches represented as a BSMatch object.
   * 
   */
  public Collection<BSMatch> getAllMatches(final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final Head pH) {
    return rawGetAllMatches(new Object[]{pLH, pLE, pLS, pH});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @return a match represented as a BSMatch object, or null if no match is found.
   * 
   */
  public BSMatch getOneArbitraryMatch(final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final Head pH) {
    return rawGetOneArbitraryMatch(new Object[]{pLH, pLE, pLS, pH});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final Head pH) {
    return rawHasMatch(new Object[]{pLH, pLE, pLS, pH});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final Head pH) {
    return rawCountMatches(new Object[]{pLH, pLE, pLS, pH});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final Head pH, final IMatchProcessor<? super BSMatch> processor) {
    rawForEachMatch(new Object[]{pLH, pLE, pLS, pH}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final Head pH, final IMatchProcessor<? super BSMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pLH, pLE, pLS, pH}, processor);
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
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<BSMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final Head pH) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pLH, pLE, pLS, pH});
  }
  
  /**
   * Returns a new (partial) Match object for the matcher. 
   * This can be used e.g. to call the matcher with a partial match. 
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public BSMatch newMatch(final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final Head pH) {
    return new BSMatch.Immutable(pLH, pLE, pLS, pH);
    
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
  public Set<LeftHand> getAllValuesOfLH(final BSMatch partialMatch) {
    return rawAccumulateAllValuesOfLH(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for LH.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<LeftHand> getAllValuesOfLH(final LeftElbow pLE, final LeftShoulder pLS, final Head pH) {
    return rawAccumulateAllValuesOfLH(new Object[]{null, pLE, pLS, pH});
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
  public Set<LeftElbow> getAllValuesOfLE(final BSMatch partialMatch) {
    return rawAccumulateAllValuesOfLE(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for LE.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<LeftElbow> getAllValuesOfLE(final LeftHand pLH, final LeftShoulder pLS, final Head pH) {
    return rawAccumulateAllValuesOfLE(new Object[]{pLH, null, pLS, pH});
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
  public Set<LeftShoulder> getAllValuesOfLS(final BSMatch partialMatch) {
    return rawAccumulateAllValuesOfLS(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for LS.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<LeftShoulder> getAllValuesOfLS(final LeftHand pLH, final LeftElbow pLE, final Head pH) {
    return rawAccumulateAllValuesOfLS(new Object[]{pLH, pLE, null, pH});
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
  public Set<Head> getAllValuesOfH(final BSMatch partialMatch) {
    return rawAccumulateAllValuesOfH(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for H.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Head> getAllValuesOfH(final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS) {
    return rawAccumulateAllValuesOfH(new Object[]{pLH, pLE, pLS, null});
  }
  
  @Override
  protected BSMatch tupleToMatch(final Tuple t) {
    try {
    	return new BSMatch.Immutable((org.jnect.bodymodel.LeftHand) t.get(POSITION_LH), (org.jnect.bodymodel.LeftElbow) t.get(POSITION_LE), (org.jnect.bodymodel.LeftShoulder) t.get(POSITION_LS), (org.jnect.bodymodel.Head) t.get(POSITION_H));	
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in tuple not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected BSMatch arrayToMatch(final Object[] match) {
    try {
    	return new BSMatch.Immutable((org.jnect.bodymodel.LeftHand) match[POSITION_LH], (org.jnect.bodymodel.LeftElbow) match[POSITION_LE], (org.jnect.bodymodel.LeftShoulder) match[POSITION_LS], (org.jnect.bodymodel.Head) match[POSITION_H]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected BSMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return new BSMatch.Mutable((org.jnect.bodymodel.LeftHand) match[POSITION_LH], (org.jnect.bodymodel.LeftElbow) match[POSITION_LE], (org.jnect.bodymodel.LeftShoulder) match[POSITION_LS], (org.jnect.bodymodel.Head) match[POSITION_H]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<BSMatcher> querySpecification() throws IncQueryException {
    return BSQuerySpecification.instance();
  }
}
