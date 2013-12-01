package hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample;

import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionComponentC;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentC_AppearedMatch;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.util.ComponentC_AppearedQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.componentC_Appeared pattern, 
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)}, 
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ComponentC_AppearedMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern componentC_Appeared(te, tId, sId){
 * 	TransactionModel.latestComponentEvent(_, te);
 * 	TransactionComponentC.transactionId(te, tId);
 * 	TransactionComponentC.supplierId(te, sId);
 * }
 * </pre></code>
 * 
 * @see ComponentC_AppearedMatch
 * @see ComponentC_AppearedProcessor
 * @see ComponentC_AppearedQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ComponentC_AppearedMatcher extends BaseMatcher<ComponentC_AppearedMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<ComponentC_AppearedMatcher> querySpecification() throws IncQueryException {
    return ComponentC_AppearedQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine. 
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ComponentC_AppearedMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ComponentC_AppearedMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ComponentC_AppearedMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    } 	
    return matcher;
  }
  
  private final static int POSITION_TE = 0;
  
  private final static int POSITION_TID = 1;
  
  private final static int POSITION_SID = 2;
  
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
  public ComponentC_AppearedMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ComponentC_AppearedMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pTe the fixed value of pattern parameter te, or null if not bound.
   * @param pTId the fixed value of pattern parameter tId, or null if not bound.
   * @param pSId the fixed value of pattern parameter sId, or null if not bound.
   * @return matches represented as a ComponentC_AppearedMatch object.
   * 
   */
  public Collection<ComponentC_AppearedMatch> getAllMatches(final TransactionComponentC pTe, final String pTId, final String pSId) {
    return rawGetAllMatches(new Object[]{pTe, pTId, pSId});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pTe the fixed value of pattern parameter te, or null if not bound.
   * @param pTId the fixed value of pattern parameter tId, or null if not bound.
   * @param pSId the fixed value of pattern parameter sId, or null if not bound.
   * @return a match represented as a ComponentC_AppearedMatch object, or null if no match is found.
   * 
   */
  public ComponentC_AppearedMatch getOneArbitraryMatch(final TransactionComponentC pTe, final String pTId, final String pSId) {
    return rawGetOneArbitraryMatch(new Object[]{pTe, pTId, pSId});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pTe the fixed value of pattern parameter te, or null if not bound.
   * @param pTId the fixed value of pattern parameter tId, or null if not bound.
   * @param pSId the fixed value of pattern parameter sId, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final TransactionComponentC pTe, final String pTId, final String pSId) {
    return rawHasMatch(new Object[]{pTe, pTId, pSId});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pTe the fixed value of pattern parameter te, or null if not bound.
   * @param pTId the fixed value of pattern parameter tId, or null if not bound.
   * @param pSId the fixed value of pattern parameter sId, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final TransactionComponentC pTe, final String pTId, final String pSId) {
    return rawCountMatches(new Object[]{pTe, pTId, pSId});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pTe the fixed value of pattern parameter te, or null if not bound.
   * @param pTId the fixed value of pattern parameter tId, or null if not bound.
   * @param pSId the fixed value of pattern parameter sId, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final TransactionComponentC pTe, final String pTId, final String pSId, final IMatchProcessor<? super ComponentC_AppearedMatch> processor) {
    rawForEachMatch(new Object[]{pTe, pTId, pSId}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pTe the fixed value of pattern parameter te, or null if not bound.
   * @param pTId the fixed value of pattern parameter tId, or null if not bound.
   * @param pSId the fixed value of pattern parameter sId, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final TransactionComponentC pTe, final String pTId, final String pSId, final IMatchProcessor<? super ComponentC_AppearedMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pTe, pTId, pSId}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters. 
   * It can also be reset to track changes from a later point in time, 
   * and changes can even be acknowledged on an individual basis. 
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pTe the fixed value of pattern parameter te, or null if not bound.
   * @param pTId the fixed value of pattern parameter tId, or null if not bound.
   * @param pSId the fixed value of pattern parameter sId, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<ComponentC_AppearedMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final TransactionComponentC pTe, final String pTId, final String pSId) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pTe, pTId, pSId});
  }
  
  /**
   * Returns a new (partial) Match object for the matcher. 
   * This can be used e.g. to call the matcher with a partial match. 
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pTe the fixed value of pattern parameter te, or null if not bound.
   * @param pTId the fixed value of pattern parameter tId, or null if not bound.
   * @param pSId the fixed value of pattern parameter sId, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ComponentC_AppearedMatch newMatch(final TransactionComponentC pTe, final String pTId, final String pSId) {
    return new ComponentC_AppearedMatch.Immutable(pTe, pTId, pSId);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for te.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<TransactionComponentC> rawAccumulateAllValuesOfte(final Object[] parameters) {
    Set<TransactionComponentC> results = new HashSet<TransactionComponentC>();
    rawAccumulateAllValues(POSITION_TE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for te.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<TransactionComponentC> getAllValuesOfte() {
    return rawAccumulateAllValuesOfte(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for te.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<TransactionComponentC> getAllValuesOfte(final ComponentC_AppearedMatch partialMatch) {
    return rawAccumulateAllValuesOfte(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for te.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<TransactionComponentC> getAllValuesOfte(final String pTId, final String pSId) {
    return rawAccumulateAllValuesOfte(new Object[]{null, pTId, pSId});
  }
  
  /**
   * Retrieve the set of values that occur in matches for tId.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOftId(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_TID, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for tId.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOftId() {
    return rawAccumulateAllValuesOftId(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for tId.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOftId(final ComponentC_AppearedMatch partialMatch) {
    return rawAccumulateAllValuesOftId(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for tId.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOftId(final TransactionComponentC pTe, final String pSId) {
    return rawAccumulateAllValuesOftId(new Object[]{pTe, null, pSId});
  }
  
  /**
   * Retrieve the set of values that occur in matches for sId.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOfsId(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_SID, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for sId.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfsId() {
    return rawAccumulateAllValuesOfsId(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for sId.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfsId(final ComponentC_AppearedMatch partialMatch) {
    return rawAccumulateAllValuesOfsId(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for sId.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfsId(final TransactionComponentC pTe, final String pTId) {
    return rawAccumulateAllValuesOfsId(new Object[]{pTe, pTId, null});
  }
  
  @Override
  protected ComponentC_AppearedMatch tupleToMatch(final Tuple t) {
    try {
    	return new ComponentC_AppearedMatch.Immutable((hu.bme.mit.incquery.cep.casestudy.transaction.TransactionComponentC) t.get(POSITION_TE), (java.lang.String) t.get(POSITION_TID), (java.lang.String) t.get(POSITION_SID));	
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in tuple not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected ComponentC_AppearedMatch arrayToMatch(final Object[] match) {
    try {
    	return new ComponentC_AppearedMatch.Immutable((hu.bme.mit.incquery.cep.casestudy.transaction.TransactionComponentC) match[POSITION_TE], (java.lang.String) match[POSITION_TID], (java.lang.String) match[POSITION_SID]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected ComponentC_AppearedMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return new ComponentC_AppearedMatch.Mutable((hu.bme.mit.incquery.cep.casestudy.transaction.TransactionComponentC) match[POSITION_TE], (java.lang.String) match[POSITION_TID], (java.lang.String) match[POSITION_SID]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
}
