package hu.bme.mit.incquery.cep.casestudy.transaction.mapping;

import hu.bme.mit.incquery.cep.api.ICepAdapter;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentAMatch;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentAMatcher;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentBMatch;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentBMatcher;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentCMatch;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentCMatcher;
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
    	createcomponentA_Appeared_MappingRule(), 
    	createcomponentB_Appeared_MappingRule(), 
    	createcomponentC_Appeared_MappingRule()
    );
    return ruleGroup;
    
  }
  
  public void registerRules() {
    transformation = EventDrivenTransformation.forResource(resourceSet).addRules(getRules()).create();
  }
  
  public EventDrivenTransformationRule<ComponentAMatch,ComponentAMatcher> createcomponentA_Appeared_MappingRule() {
    try{
    EventDrivenTransformationBuilder<ComponentAMatch,ComponentAMatcher>builder = new EventDrivenTransformationRuleFactory().createRule();
    		builder.precondition(hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentAMatcher.querySpecification());
    IMatchProcessor<ComponentAMatch>		 action = new IMatchProcessor<ComponentAMatch>() {
    		public void process(final hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentAMatch matchedPattern) {
    			try {
    Collection<ComponentAMatch>				allMatches = hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentAMatcher.on(transformation.getIqEngine()).getAllMatches();
    				for (hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentAMatch match : allMatches) {
    					hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentA_Appeared_IQEvent event = new hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentA_Appeared_IQEvent(null);
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
  
  public EventDrivenTransformationRule<ComponentBMatch,ComponentBMatcher> createcomponentB_Appeared_MappingRule() {
    try{
    EventDrivenTransformationBuilder<ComponentBMatch,ComponentBMatcher>builder = new EventDrivenTransformationRuleFactory().createRule();
    		builder.precondition(hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentBMatcher.querySpecification());
    IMatchProcessor<ComponentBMatch>		 action = new IMatchProcessor<ComponentBMatch>() {
    		public void process(final hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentBMatch matchedPattern) {
    			try {
    Collection<ComponentBMatch>				allMatches = hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentBMatcher.on(transformation.getIqEngine()).getAllMatches();
    				for (hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentBMatch match : allMatches) {
    					hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentB_Appeared_IQEvent event = new hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentB_Appeared_IQEvent(null);
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
  
  public EventDrivenTransformationRule<ComponentCMatch,ComponentCMatcher> createcomponentC_Appeared_MappingRule() {
    try{
    EventDrivenTransformationBuilder<ComponentCMatch,ComponentCMatcher>builder = new EventDrivenTransformationRuleFactory().createRule();
    		builder.precondition(hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentCMatcher.querySpecification());
    IMatchProcessor<ComponentCMatch>		 action = new IMatchProcessor<ComponentCMatch>() {
    		public void process(final hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentCMatch matchedPattern) {
    			try {
    Collection<ComponentCMatch>				allMatches = hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentCMatcher.on(transformation.getIqEngine()).getAllMatches();
    				for (hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentCMatch match : allMatches) {
    					hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentC_Appeared_IQEvent event = new hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentC_Appeared_IQEvent(null);
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
