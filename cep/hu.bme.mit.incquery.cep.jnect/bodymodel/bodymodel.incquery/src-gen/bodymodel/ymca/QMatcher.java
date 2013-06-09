package bodymodel.ymca;

import bodymodel.ymca.QMatch;
import bodymodel.ymca.util.QQuerySpecification;
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
import org.jnect.bodymodel.LeftFoot;
import org.jnect.bodymodel.LeftHand;
import org.jnect.bodymodel.LeftShoulder;
import org.jnect.bodymodel.RightElbow;
import org.jnect.bodymodel.RightFoot;
import org.jnect.bodymodel.RightHand;
import org.jnect.bodymodel.RightShoulder;

/**
 * Generated pattern matcher API of the bodymodel.ymca.Q pattern, 
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)}, 
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link QMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern Q(RH:RightHand, 
 * 		  RE:RightElbow, 
 * 		  RS:RightShoulder,
 * 		  LH:LeftHand, 
 * 		  LE:LeftElbow, 
 * 		  LS:LeftShoulder,
 * 		  LF:LeftFoot,
 * 		  RF:RightFoot,
 * 		  H:Head
 * ) {
 * 	// both arms are bent
 * 	find bentRightArm(RH,RE,RS);
 * 	find bentLeftArm(LH,LE,LS);
 * 	// both hands below the head
 * 	neg find rightHandAboveHead(RH,H);
 * 	neg find leftHandAboveHead(LH,H);
 * 	// hands are close
 * 	find handsAreClose(LH,RH);
 * 	// right leg is straight 
 * 	// TODO
 * 	// right foot is far away from left foot
 * 	find feetAreApart(LF,RF);
 * }
 * </pre></code>
 * 
 * @see QMatch
 * @see QProcessor
 * @see QQuerySpecification
 * 
 */
public class QMatcher extends BaseMatcher<QMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine. 
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static QMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    QMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new QMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    } 	
    return matcher;
  }
  
  private final static int POSITION_RH = 0;
  
  private final static int POSITION_RE = 1;
  
  private final static int POSITION_RS = 2;
  
  private final static int POSITION_LH = 3;
  
  private final static int POSITION_LE = 4;
  
  private final static int POSITION_LS = 5;
  
  private final static int POSITION_LF = 6;
  
  private final static int POSITION_RF = 7;
  
  private final static int POSITION_H = 8;
  
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
  public QMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public QMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @param pLF the fixed value of pattern parameter LF, or null if not bound.
   * @param pRF the fixed value of pattern parameter RF, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @return matches represented as a QMatch object.
   * 
   */
  public Collection<QMatch> getAllMatches(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final LeftFoot pLF, final RightFoot pRF, final Head pH) {
    return rawGetAllMatches(new Object[]{pRH, pRE, pRS, pLH, pLE, pLS, pLF, pRF, pH});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @param pLF the fixed value of pattern parameter LF, or null if not bound.
   * @param pRF the fixed value of pattern parameter RF, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @return a match represented as a QMatch object, or null if no match is found.
   * 
   */
  public QMatch getOneArbitraryMatch(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final LeftFoot pLF, final RightFoot pRF, final Head pH) {
    return rawGetOneArbitraryMatch(new Object[]{pRH, pRE, pRS, pLH, pLE, pLS, pLF, pRF, pH});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @param pLF the fixed value of pattern parameter LF, or null if not bound.
   * @param pRF the fixed value of pattern parameter RF, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final LeftFoot pLF, final RightFoot pRF, final Head pH) {
    return rawHasMatch(new Object[]{pRH, pRE, pRS, pLH, pLE, pLS, pLF, pRF, pH});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @param pLF the fixed value of pattern parameter LF, or null if not bound.
   * @param pRF the fixed value of pattern parameter RF, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final LeftFoot pLF, final RightFoot pRF, final Head pH) {
    return rawCountMatches(new Object[]{pRH, pRE, pRS, pLH, pLE, pLS, pLF, pRF, pH});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @param pLF the fixed value of pattern parameter LF, or null if not bound.
   * @param pRF the fixed value of pattern parameter RF, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final LeftFoot pLF, final RightFoot pRF, final Head pH, final IMatchProcessor<? super QMatch> processor) {
    rawForEachMatch(new Object[]{pRH, pRE, pRS, pLH, pLE, pLS, pLF, pRF, pH}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @param pLF the fixed value of pattern parameter LF, or null if not bound.
   * @param pRF the fixed value of pattern parameter RF, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final LeftFoot pLF, final RightFoot pRF, final Head pH, final IMatchProcessor<? super QMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pRH, pRE, pRS, pLH, pLE, pLS, pLF, pRF, pH}, processor);
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
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @param pLF the fixed value of pattern parameter LF, or null if not bound.
   * @param pRF the fixed value of pattern parameter RF, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<QMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final LeftFoot pLF, final RightFoot pRF, final Head pH) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pRH, pRE, pRS, pLH, pLE, pLS, pLF, pRF, pH});
  }
  
  /**
   * Returns a new (partial) Match object for the matcher. 
   * This can be used e.g. to call the matcher with a partial match. 
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @param pLH the fixed value of pattern parameter LH, or null if not bound.
   * @param pLE the fixed value of pattern parameter LE, or null if not bound.
   * @param pLS the fixed value of pattern parameter LS, or null if not bound.
   * @param pLF the fixed value of pattern parameter LF, or null if not bound.
   * @param pRF the fixed value of pattern parameter RF, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public QMatch newMatch(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final LeftFoot pLF, final RightFoot pRF, final Head pH) {
    return new QMatch.Immutable(pRH, pRE, pRS, pLH, pLE, pLS, pLF, pRF, pH);
    
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
  public Set<RightHand> getAllValuesOfRH(final QMatch partialMatch) {
    return rawAccumulateAllValuesOfRH(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for RH.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightHand> getAllValuesOfRH(final RightElbow pRE, final RightShoulder pRS, final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final LeftFoot pLF, final RightFoot pRF, final Head pH) {
    return rawAccumulateAllValuesOfRH(new Object[]{null, pRE, pRS, pLH, pLE, pLS, pLF, pRF, pH});
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
  public Set<RightElbow> getAllValuesOfRE(final QMatch partialMatch) {
    return rawAccumulateAllValuesOfRE(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for RE.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightElbow> getAllValuesOfRE(final RightHand pRH, final RightShoulder pRS, final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final LeftFoot pLF, final RightFoot pRF, final Head pH) {
    return rawAccumulateAllValuesOfRE(new Object[]{pRH, null, pRS, pLH, pLE, pLS, pLF, pRF, pH});
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
  public Set<RightShoulder> getAllValuesOfRS(final QMatch partialMatch) {
    return rawAccumulateAllValuesOfRS(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for RS.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightShoulder> getAllValuesOfRS(final RightHand pRH, final RightElbow pRE, final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final LeftFoot pLF, final RightFoot pRF, final Head pH) {
    return rawAccumulateAllValuesOfRS(new Object[]{pRH, pRE, null, pLH, pLE, pLS, pLF, pRF, pH});
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
  public Set<LeftHand> getAllValuesOfLH(final QMatch partialMatch) {
    return rawAccumulateAllValuesOfLH(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for LH.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<LeftHand> getAllValuesOfLH(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final LeftElbow pLE, final LeftShoulder pLS, final LeftFoot pLF, final RightFoot pRF, final Head pH) {
    return rawAccumulateAllValuesOfLH(new Object[]{pRH, pRE, pRS, null, pLE, pLS, pLF, pRF, pH});
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
  public Set<LeftElbow> getAllValuesOfLE(final QMatch partialMatch) {
    return rawAccumulateAllValuesOfLE(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for LE.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<LeftElbow> getAllValuesOfLE(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final LeftHand pLH, final LeftShoulder pLS, final LeftFoot pLF, final RightFoot pRF, final Head pH) {
    return rawAccumulateAllValuesOfLE(new Object[]{pRH, pRE, pRS, pLH, null, pLS, pLF, pRF, pH});
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
  public Set<LeftShoulder> getAllValuesOfLS(final QMatch partialMatch) {
    return rawAccumulateAllValuesOfLS(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for LS.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<LeftShoulder> getAllValuesOfLS(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final LeftHand pLH, final LeftElbow pLE, final LeftFoot pLF, final RightFoot pRF, final Head pH) {
    return rawAccumulateAllValuesOfLS(new Object[]{pRH, pRE, pRS, pLH, pLE, null, pLF, pRF, pH});
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
  public Set<LeftFoot> getAllValuesOfLF(final QMatch partialMatch) {
    return rawAccumulateAllValuesOfLF(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for LF.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<LeftFoot> getAllValuesOfLF(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final RightFoot pRF, final Head pH) {
    return rawAccumulateAllValuesOfLF(new Object[]{pRH, pRE, pRS, pLH, pLE, pLS, null, pRF, pH});
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
  public Set<RightFoot> getAllValuesOfRF(final QMatch partialMatch) {
    return rawAccumulateAllValuesOfRF(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for RF.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightFoot> getAllValuesOfRF(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final LeftFoot pLF, final Head pH) {
    return rawAccumulateAllValuesOfRF(new Object[]{pRH, pRE, pRS, pLH, pLE, pLS, pLF, null, pH});
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
  public Set<Head> getAllValuesOfH(final QMatch partialMatch) {
    return rawAccumulateAllValuesOfH(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for H.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Head> getAllValuesOfH(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final LeftFoot pLF, final RightFoot pRF) {
    return rawAccumulateAllValuesOfH(new Object[]{pRH, pRE, pRS, pLH, pLE, pLS, pLF, pRF, null});
  }
  
  @Override
  protected QMatch tupleToMatch(final Tuple t) {
    try {
    	return new QMatch.Immutable((org.jnect.bodymodel.RightHand) t.get(POSITION_RH), (org.jnect.bodymodel.RightElbow) t.get(POSITION_RE), (org.jnect.bodymodel.RightShoulder) t.get(POSITION_RS), (org.jnect.bodymodel.LeftHand) t.get(POSITION_LH), (org.jnect.bodymodel.LeftElbow) t.get(POSITION_LE), (org.jnect.bodymodel.LeftShoulder) t.get(POSITION_LS), (org.jnect.bodymodel.LeftFoot) t.get(POSITION_LF), (org.jnect.bodymodel.RightFoot) t.get(POSITION_RF), (org.jnect.bodymodel.Head) t.get(POSITION_H));	
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in tuple not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected QMatch arrayToMatch(final Object[] match) {
    try {
    	return new QMatch.Immutable((org.jnect.bodymodel.RightHand) match[POSITION_RH], (org.jnect.bodymodel.RightElbow) match[POSITION_RE], (org.jnect.bodymodel.RightShoulder) match[POSITION_RS], (org.jnect.bodymodel.LeftHand) match[POSITION_LH], (org.jnect.bodymodel.LeftElbow) match[POSITION_LE], (org.jnect.bodymodel.LeftShoulder) match[POSITION_LS], (org.jnect.bodymodel.LeftFoot) match[POSITION_LF], (org.jnect.bodymodel.RightFoot) match[POSITION_RF], (org.jnect.bodymodel.Head) match[POSITION_H]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected QMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return new QMatch.Mutable((org.jnect.bodymodel.RightHand) match[POSITION_RH], (org.jnect.bodymodel.RightElbow) match[POSITION_RE], (org.jnect.bodymodel.RightShoulder) match[POSITION_RS], (org.jnect.bodymodel.LeftHand) match[POSITION_LH], (org.jnect.bodymodel.LeftElbow) match[POSITION_LE], (org.jnect.bodymodel.LeftShoulder) match[POSITION_LS], (org.jnect.bodymodel.LeftFoot) match[POSITION_LF], (org.jnect.bodymodel.RightFoot) match[POSITION_RF], (org.jnect.bodymodel.Head) match[POSITION_H]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<QMatcher> querySpecification() throws IncQueryException {
    return QQuerySpecification.instance();
  }
}