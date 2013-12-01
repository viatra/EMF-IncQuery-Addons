package hu.bme.mit.incquery.cep.casestudy.transaction.mapping;

import hu.bme.mit.incquery.cep.api.ICepAdapter;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentA_AppearedMatch;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentA_AppearedMatcher;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentB_AppearedMatch;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentB_AppearedMatcher;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentC_AppearedMatch;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentC_AppearedMatcher;
import java.util.Collection;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra2.emf.runtime.rules.EventDrivenTransformationRuleGroup;
import org.eclipse.viatra2.emf.runtime.rules.eventdriven.EventDrivenTransformationRuleFactory;
import org.eclipse.viatra2.emf.runtime.rules.eventdriven.EventDrivenTransformationRuleFactory.EventDrivenTransformationBuilder;
import org.eclipse.viatra2.emf.runtime.transformation.eventdriven.EventDrivenTransformation;
import org.eclipse.viatra2.emf.runtime.transformation.eventdriven.EventDrivenTransformationRule;
import org.eclipse.viatra2.emf.runtime.transformation.eventdriven.InconsistentEventSemanticsException;

@SuppressWarnings("all")
public class IncQuery2ViatraCep {
  private ICepAdapter adapter;
  
  private ResourceSet resourceSet;
  
  private EventDrivenTransformation transformation;
  
  public IncQuery2ViatraCep(final ResourceSet resourceSet, final ICepAdapter adapter) {
    this.resourceSet = resourceSet;
    this.adapter = adapter;
    
  }
  
  public EventDrivenTransformationRuleGroup getRules() {
    EventDrivenTransformationRuleGroup ruleGroup = new EventDrivenTransformationRuleGroup(
    	createcomponentA_MappingRule(), 
    	createcomponentB_MappingRule(), 
    	createcomponentC_MappingRule()
    );
    return ruleGroup;
    
  }
  
  public void registerRules() {
    transformation = EventDrivenTransformation.forResource(resourceSet).addRules(getRules()).create();
  }
  
  public EventDrivenTransformationRule<ComponentA_AppearedMatch,ComponentA_AppearedMatcher> createcomponentA_MappingRule() {
    try{
    EventDrivenTransformationBuilder<ComponentA_AppearedMatch,ComponentA_AppearedMatcher>builder = new EventDrivenTransformationRuleFactory().createRule();
    		builder.precondition(hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentA_AppearedMatcher.querySpecification());
    IMatchProcessor<ComponentA_AppearedMatch>		 action = new IMatchProcessor<ComponentA_AppearedMatch>() {
    		public void process(final hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentA_AppearedMatch matchedPattern) {
    			try {
    Collection<ComponentA_AppearedMatch>				allMatches = hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentA_AppearedMatcher.on(transformation.getIqEngine()).getAllMatches();
    				for (hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentA_AppearedMatch match : allMatches) {
    					hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentA_IQEvent event = new hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentA_IQEvent(null);
    event.setTransactionId((java.lang.String)matchedPattern.get(1));
    event.setCustomerId((java.lang.String)matchedPattern.get(2));
    					event.setIncQueryPattern(match);
    					adapter.push(event);
    				}
    		} catch (IncQueryException e) {
    			e.printStackTrace();
    		}
    								}
    							};							
    								builder.action(action);
    								return builder.build();
    							} catch (IncQueryException e) {
    								e.printStackTrace();
    							} catch (InconsistentEventSemanticsException e) {
    								e.printStackTrace();
    							}
    							return null;
    
  }
  
  public EventDrivenTransformationRule<ComponentB_AppearedMatch,ComponentB_AppearedMatcher> createcomponentB_MappingRule() {
    try{
    EventDrivenTransformationBuilder<ComponentB_AppearedMatch,ComponentB_AppearedMatcher>builder = new EventDrivenTransformationRuleFactory().createRule();
    		builder.precondition(hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentB_AppearedMatcher.querySpecification());
    IMatchProcessor<ComponentB_AppearedMatch>		 action = new IMatchProcessor<ComponentB_AppearedMatch>() {
    		public void process(final hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentB_AppearedMatch matchedPattern) {
    			try {
    Collection<ComponentB_AppearedMatch>				allMatches = hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentB_AppearedMatcher.on(transformation.getIqEngine()).getAllMatches();
    				for (hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentB_AppearedMatch match : allMatches) {
    					hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentB_IQEvent event = new hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentB_IQEvent(null);
    event.setTransactionId((java.lang.String)matchedPattern.get(1));
    					event.setIncQueryPattern(match);
    					adapter.push(event);
    				}
    		} catch (IncQueryException e) {
    			e.printStackTrace();
    		}
    								}
    							};							
    								builder.action(action);
    								return builder.build();
    							} catch (IncQueryException e) {
    								e.printStackTrace();
    							} catch (InconsistentEventSemanticsException e) {
    								e.printStackTrace();
    							}
    							return null;
    
  }
  
  public EventDrivenTransformationRule<ComponentC_AppearedMatch,ComponentC_AppearedMatcher> createcomponentC_MappingRule() {
    try{
    EventDrivenTransformationBuilder<ComponentC_AppearedMatch,ComponentC_AppearedMatcher>builder = new EventDrivenTransformationRuleFactory().createRule();
    		builder.precondition(hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentC_AppearedMatcher.querySpecification());
    IMatchProcessor<ComponentC_AppearedMatch>		 action = new IMatchProcessor<ComponentC_AppearedMatch>() {
    		public void process(final hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentC_AppearedMatch matchedPattern) {
    			try {
    Collection<ComponentC_AppearedMatch>				allMatches = hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentC_AppearedMatcher.on(transformation.getIqEngine()).getAllMatches();
    				for (hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentC_AppearedMatch match : allMatches) {
    					hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentC_IQEvent event = new hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentC_IQEvent(null);
    event.setTransactionId((java.lang.String)matchedPattern.get(1));
    event.setSupplierId((java.lang.String)matchedPattern.get(2));
    					event.setIncQueryPattern(match);
    					adapter.push(event);
    				}
    		} catch (IncQueryException e) {
    			e.printStackTrace();
    		}
    								}
    							};							
    								builder.action(action);
    								return builder.build();
    							} catch (IncQueryException e) {
    								e.printStackTrace();
    							} catch (InconsistentEventSemanticsException e) {
    								e.printStackTrace();
    							}
    							return null;
    
  }
}
