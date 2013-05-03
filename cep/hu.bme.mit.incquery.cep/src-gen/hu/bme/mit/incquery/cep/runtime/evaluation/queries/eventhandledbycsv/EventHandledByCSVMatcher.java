package hu.bme.mit.incquery.cep.runtime.evaluation.queries.eventhandledbycsv;

import hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventCollection;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.eventhandledbycsv.EventHandledByCSVMatch;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.eventhandledbycsv.EventHandledByCSVMatcherFactory;
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
 * Generated pattern matcher API of the hu.bme.mit.incquery.cep.runtime.evaluation.queries.eventHandledByCSV pattern, 
 * providing pattern-specific query methods.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern eventHandledByCSV(e, csv) {
 * 	CurrentStateVisitor.eventCollection(csv,e);
 * }
 * </pre></code>
 * 
 * @see EventHandledByCSVMatch
 * @see EventHandledByCSVMatcherFactory
 * @see EventHandledByCSVProcessor
 * 
 */
public class EventHandledByCSVMatcher extends BaseGeneratedMatcher<EventHandledByCSVMatch> {
  private final static int POSITION_E = 0;
  
  private final static int POSITION_CSV = 1;
  
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
  public EventHandledByCSVMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public EventHandledByCSVMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, factory());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pE the fixed value of pattern parameter e, or null if not bound.
   * @param pCsv the fixed value of pattern parameter csv, or null if not bound.
   * @return matches represented as a EventHandledByCSVMatch object.
   * 
   */
  public Collection<EventHandledByCSVMatch> getAllMatches(final EventCollection pE, final CurrentStateVisitor pCsv) {
    return rawGetAllMatches(new Object[]{pE, pCsv});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pE the fixed value of pattern parameter e, or null if not bound.
   * @param pCsv the fixed value of pattern parameter csv, or null if not bound.
   * @return a match represented as a EventHandledByCSVMatch object, or null if no match is found.
   * 
   */
  public EventHandledByCSVMatch getOneArbitraryMatch(final EventCollection pE, final CurrentStateVisitor pCsv) {
    return rawGetOneArbitraryMatch(new Object[]{pE, pCsv});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pE the fixed value of pattern parameter e, or null if not bound.
   * @param pCsv the fixed value of pattern parameter csv, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final EventCollection pE, final CurrentStateVisitor pCsv) {
    return rawHasMatch(new Object[]{pE, pCsv});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pE the fixed value of pattern parameter e, or null if not bound.
   * @param pCsv the fixed value of pattern parameter csv, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final EventCollection pE, final CurrentStateVisitor pCsv) {
    return rawCountMatches(new Object[]{pE, pCsv});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pE the fixed value of pattern parameter e, or null if not bound.
   * @param pCsv the fixed value of pattern parameter csv, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final EventCollection pE, final CurrentStateVisitor pCsv, final IMatchProcessor<? super EventHandledByCSVMatch> processor) {
    rawForEachMatch(new Object[]{pE, pCsv}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pE the fixed value of pattern parameter e, or null if not bound.
   * @param pCsv the fixed value of pattern parameter csv, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final EventCollection pE, final CurrentStateVisitor pCsv, final IMatchProcessor<? super EventHandledByCSVMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pE, pCsv}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters. 
   * It can also be reset to track changes from a later point in time, 
   * and changes can even be acknowledged on an individual basis. 
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pE the fixed value of pattern parameter e, or null if not bound.
   * @param pCsv the fixed value of pattern parameter csv, or null if not bound.
   * @return the delta monitor.
   * 
   */
  public DeltaMonitor<EventHandledByCSVMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final EventCollection pE, final CurrentStateVisitor pCsv) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pE, pCsv});
  }
  
  /**
   * Returns a new (partial) Match object for the matcher. 
   * This can be used e.g. to call the matcher with a partial match. 
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pE the fixed value of pattern parameter e, or null if not bound.
   * @param pCsv the fixed value of pattern parameter csv, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public EventHandledByCSVMatch newMatch(final EventCollection pE, final CurrentStateVisitor pCsv) {
    return new EventHandledByCSVMatch.Immutable(pE, pCsv);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for e.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<EventCollection> rawAccumulateAllValuesOfe(final Object[] parameters) {
    Set<EventCollection> results = new HashSet<EventCollection>();
    rawAccumulateAllValues(POSITION_E, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for e.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EventCollection> getAllValuesOfe() {
    return rawAccumulateAllValuesOfe(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for e.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EventCollection> getAllValuesOfe(final EventHandledByCSVMatch partialMatch) {
    return rawAccumulateAllValuesOfe(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for e.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EventCollection> getAllValuesOfe(final CurrentStateVisitor pCsv) {
    return rawAccumulateAllValuesOfe(new Object[]{null, pCsv});
  }
  
  /**
   * Retrieve the set of values that occur in matches for csv.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<CurrentStateVisitor> rawAccumulateAllValuesOfcsv(final Object[] parameters) {
    Set<CurrentStateVisitor> results = new HashSet<CurrentStateVisitor>();
    rawAccumulateAllValues(POSITION_CSV, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for csv.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<CurrentStateVisitor> getAllValuesOfcsv() {
    return rawAccumulateAllValuesOfcsv(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for csv.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<CurrentStateVisitor> getAllValuesOfcsv(final EventHandledByCSVMatch partialMatch) {
    return rawAccumulateAllValuesOfcsv(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for csv.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<CurrentStateVisitor> getAllValuesOfcsv(final EventCollection pE) {
    return rawAccumulateAllValuesOfcsv(new Object[]{pE, null});
  }
  
  @Override
  protected EventHandledByCSVMatch tupleToMatch(final Tuple t) {
    try {
    	return new EventHandledByCSVMatch.Immutable((hu.bme.mit.incquery.cep.metamodels.internalsm.EventCollection) t.get(POSITION_E), (hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor) t.get(POSITION_CSV));	
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in tuple not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected EventHandledByCSVMatch arrayToMatch(final Object[] match) {
    try {
    	return new EventHandledByCSVMatch.Immutable((hu.bme.mit.incquery.cep.metamodels.internalsm.EventCollection) match[POSITION_E], (hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor) match[POSITION_CSV]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected EventHandledByCSVMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return new EventHandledByCSVMatch.Mutable((hu.bme.mit.incquery.cep.metamodels.internalsm.EventCollection) match[POSITION_E], (hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor) match[POSITION_CSV]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  /**
   * @return the singleton instance of the factory of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IMatcherFactory<EventHandledByCSVMatcher> factory() throws IncQueryException {
    return EventHandledByCSVMatcherFactory.instance();
  }
}
