package hu.bme.mit.incquery.cep.performance.mapping;

import hu.bme.mit.incquery.cep.api.ICepAdapter;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentAMatch;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentAMatcher;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentBMatch;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentBMatcher;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentCMatch;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentCMatcher;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentDMatch;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentDMatcher;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentEMatch;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentEMatcher;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentFMatch;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentFMatcher;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentGMatch;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentGMatcher;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentHMatch;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentHMatcher;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentIMatch;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentIMatcher;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentJMatch;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentJMatcher;
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
    	createcomponentC_MappingRule(), 
    	createcomponentD_MappingRule(), 
    	createcomponentE_MappingRule(), 
    	createcomponentF_MappingRule(), 
    	createcomponentG_MappingRule(), 
    	createcomponentH_MappingRule(), 
    	createcomponentI_MappingRule(), 
    	createcomponentJ_MappingRule()
    );
    return ruleGroup;
    
  }
  
  public void registerRules() {
    transformation = EventDrivenTransformation.forResource(resourceSet).addRules(getRules()).create();
  }
  
  public EventDrivenTransformationRule<ComponentAMatch,ComponentAMatcher> createcomponentA_MappingRule() {
    try{
    EventDrivenTransformationBuilder<ComponentAMatch,ComponentAMatcher>builder = new EventDrivenTransformationRuleFactory().createRule();
    		builder.precondition(hu.bme.mit.incquery.cep.performance.md.patterns.ComponentAMatcher.querySpecification());
    IMatchProcessor<ComponentAMatch>		 action = new IMatchProcessor<ComponentAMatch>() {
    		public void process(final hu.bme.mit.incquery.cep.performance.md.patterns.ComponentAMatch matchedPattern) {
    			try {
    Collection<ComponentAMatch>				allMatches = hu.bme.mit.incquery.cep.performance.md.patterns.ComponentAMatcher.on(transformation.getIqEngine()).getAllMatches();
    				for (hu.bme.mit.incquery.cep.performance.md.patterns.ComponentAMatch match : allMatches) {
    					hu.bme.mit.incquery.cep.performance.events.incquery.ComponentA_IQEvent event = new hu.bme.mit.incquery.cep.performance.events.incquery.ComponentA_IQEvent(null);
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
  
  public EventDrivenTransformationRule<ComponentBMatch,ComponentBMatcher> createcomponentB_MappingRule() {
    try{
    EventDrivenTransformationBuilder<ComponentBMatch,ComponentBMatcher>builder = new EventDrivenTransformationRuleFactory().createRule();
    		builder.precondition(hu.bme.mit.incquery.cep.performance.md.patterns.ComponentBMatcher.querySpecification());
    IMatchProcessor<ComponentBMatch>		 action = new IMatchProcessor<ComponentBMatch>() {
    		public void process(final hu.bme.mit.incquery.cep.performance.md.patterns.ComponentBMatch matchedPattern) {
    			try {
    Collection<ComponentBMatch>				allMatches = hu.bme.mit.incquery.cep.performance.md.patterns.ComponentBMatcher.on(transformation.getIqEngine()).getAllMatches();
    				for (hu.bme.mit.incquery.cep.performance.md.patterns.ComponentBMatch match : allMatches) {
    					hu.bme.mit.incquery.cep.performance.events.incquery.ComponentB_IQEvent event = new hu.bme.mit.incquery.cep.performance.events.incquery.ComponentB_IQEvent(null);
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
  
  public EventDrivenTransformationRule<ComponentCMatch,ComponentCMatcher> createcomponentC_MappingRule() {
    try{
    EventDrivenTransformationBuilder<ComponentCMatch,ComponentCMatcher>builder = new EventDrivenTransformationRuleFactory().createRule();
    		builder.precondition(hu.bme.mit.incquery.cep.performance.md.patterns.ComponentCMatcher.querySpecification());
    IMatchProcessor<ComponentCMatch>		 action = new IMatchProcessor<ComponentCMatch>() {
    		public void process(final hu.bme.mit.incquery.cep.performance.md.patterns.ComponentCMatch matchedPattern) {
    			try {
    Collection<ComponentCMatch>				allMatches = hu.bme.mit.incquery.cep.performance.md.patterns.ComponentCMatcher.on(transformation.getIqEngine()).getAllMatches();
    				for (hu.bme.mit.incquery.cep.performance.md.patterns.ComponentCMatch match : allMatches) {
    					hu.bme.mit.incquery.cep.performance.events.incquery.ComponentC_IQEvent event = new hu.bme.mit.incquery.cep.performance.events.incquery.ComponentC_IQEvent(null);
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
  
  public EventDrivenTransformationRule<ComponentDMatch,ComponentDMatcher> createcomponentD_MappingRule() {
    try{
    EventDrivenTransformationBuilder<ComponentDMatch,ComponentDMatcher>builder = new EventDrivenTransformationRuleFactory().createRule();
    		builder.precondition(hu.bme.mit.incquery.cep.performance.md.patterns.ComponentDMatcher.querySpecification());
    IMatchProcessor<ComponentDMatch>		 action = new IMatchProcessor<ComponentDMatch>() {
    		public void process(final hu.bme.mit.incquery.cep.performance.md.patterns.ComponentDMatch matchedPattern) {
    			try {
    Collection<ComponentDMatch>				allMatches = hu.bme.mit.incquery.cep.performance.md.patterns.ComponentDMatcher.on(transformation.getIqEngine()).getAllMatches();
    				for (hu.bme.mit.incquery.cep.performance.md.patterns.ComponentDMatch match : allMatches) {
    					hu.bme.mit.incquery.cep.performance.events.incquery.ComponentD_IQEvent event = new hu.bme.mit.incquery.cep.performance.events.incquery.ComponentD_IQEvent(null);
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
  
  public EventDrivenTransformationRule<ComponentEMatch,ComponentEMatcher> createcomponentE_MappingRule() {
    try{
    EventDrivenTransformationBuilder<ComponentEMatch,ComponentEMatcher>builder = new EventDrivenTransformationRuleFactory().createRule();
    		builder.precondition(hu.bme.mit.incquery.cep.performance.md.patterns.ComponentEMatcher.querySpecification());
    IMatchProcessor<ComponentEMatch>		 action = new IMatchProcessor<ComponentEMatch>() {
    		public void process(final hu.bme.mit.incquery.cep.performance.md.patterns.ComponentEMatch matchedPattern) {
    			try {
    Collection<ComponentEMatch>				allMatches = hu.bme.mit.incquery.cep.performance.md.patterns.ComponentEMatcher.on(transformation.getIqEngine()).getAllMatches();
    				for (hu.bme.mit.incquery.cep.performance.md.patterns.ComponentEMatch match : allMatches) {
    					hu.bme.mit.incquery.cep.performance.events.incquery.ComponentE_IQEvent event = new hu.bme.mit.incquery.cep.performance.events.incquery.ComponentE_IQEvent(null);
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
  
  public EventDrivenTransformationRule<ComponentFMatch,ComponentFMatcher> createcomponentF_MappingRule() {
    try{
    EventDrivenTransformationBuilder<ComponentFMatch,ComponentFMatcher>builder = new EventDrivenTransformationRuleFactory().createRule();
    		builder.precondition(hu.bme.mit.incquery.cep.performance.md.patterns.ComponentFMatcher.querySpecification());
    IMatchProcessor<ComponentFMatch>		 action = new IMatchProcessor<ComponentFMatch>() {
    		public void process(final hu.bme.mit.incquery.cep.performance.md.patterns.ComponentFMatch matchedPattern) {
    			try {
    Collection<ComponentFMatch>				allMatches = hu.bme.mit.incquery.cep.performance.md.patterns.ComponentFMatcher.on(transformation.getIqEngine()).getAllMatches();
    				for (hu.bme.mit.incquery.cep.performance.md.patterns.ComponentFMatch match : allMatches) {
    					hu.bme.mit.incquery.cep.performance.events.incquery.ComponentF_IQEvent event = new hu.bme.mit.incquery.cep.performance.events.incquery.ComponentF_IQEvent(null);
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
  
  public EventDrivenTransformationRule<ComponentGMatch,ComponentGMatcher> createcomponentG_MappingRule() {
    try{
    EventDrivenTransformationBuilder<ComponentGMatch,ComponentGMatcher>builder = new EventDrivenTransformationRuleFactory().createRule();
    		builder.precondition(hu.bme.mit.incquery.cep.performance.md.patterns.ComponentGMatcher.querySpecification());
    IMatchProcessor<ComponentGMatch>		 action = new IMatchProcessor<ComponentGMatch>() {
    		public void process(final hu.bme.mit.incquery.cep.performance.md.patterns.ComponentGMatch matchedPattern) {
    			try {
    Collection<ComponentGMatch>				allMatches = hu.bme.mit.incquery.cep.performance.md.patterns.ComponentGMatcher.on(transformation.getIqEngine()).getAllMatches();
    				for (hu.bme.mit.incquery.cep.performance.md.patterns.ComponentGMatch match : allMatches) {
    					hu.bme.mit.incquery.cep.performance.events.incquery.ComponentG_IQEvent event = new hu.bme.mit.incquery.cep.performance.events.incquery.ComponentG_IQEvent(null);
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
  
  public EventDrivenTransformationRule<ComponentHMatch,ComponentHMatcher> createcomponentH_MappingRule() {
    try{
    EventDrivenTransformationBuilder<ComponentHMatch,ComponentHMatcher>builder = new EventDrivenTransformationRuleFactory().createRule();
    		builder.precondition(hu.bme.mit.incquery.cep.performance.md.patterns.ComponentHMatcher.querySpecification());
    IMatchProcessor<ComponentHMatch>		 action = new IMatchProcessor<ComponentHMatch>() {
    		public void process(final hu.bme.mit.incquery.cep.performance.md.patterns.ComponentHMatch matchedPattern) {
    			try {
    Collection<ComponentHMatch>				allMatches = hu.bme.mit.incquery.cep.performance.md.patterns.ComponentHMatcher.on(transformation.getIqEngine()).getAllMatches();
    				for (hu.bme.mit.incquery.cep.performance.md.patterns.ComponentHMatch match : allMatches) {
    					hu.bme.mit.incquery.cep.performance.events.incquery.ComponentH_IQEvent event = new hu.bme.mit.incquery.cep.performance.events.incquery.ComponentH_IQEvent(null);
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
  
  public EventDrivenTransformationRule<ComponentIMatch,ComponentIMatcher> createcomponentI_MappingRule() {
    try{
    EventDrivenTransformationBuilder<ComponentIMatch,ComponentIMatcher>builder = new EventDrivenTransformationRuleFactory().createRule();
    		builder.precondition(hu.bme.mit.incquery.cep.performance.md.patterns.ComponentIMatcher.querySpecification());
    IMatchProcessor<ComponentIMatch>		 action = new IMatchProcessor<ComponentIMatch>() {
    		public void process(final hu.bme.mit.incquery.cep.performance.md.patterns.ComponentIMatch matchedPattern) {
    			try {
    Collection<ComponentIMatch>				allMatches = hu.bme.mit.incquery.cep.performance.md.patterns.ComponentIMatcher.on(transformation.getIqEngine()).getAllMatches();
    				for (hu.bme.mit.incquery.cep.performance.md.patterns.ComponentIMatch match : allMatches) {
    					hu.bme.mit.incquery.cep.performance.events.incquery.ComponentI_IQEvent event = new hu.bme.mit.incquery.cep.performance.events.incquery.ComponentI_IQEvent(null);
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
  
  public EventDrivenTransformationRule<ComponentJMatch,ComponentJMatcher> createcomponentJ_MappingRule() {
    try{
    EventDrivenTransformationBuilder<ComponentJMatch,ComponentJMatcher>builder = new EventDrivenTransformationRuleFactory().createRule();
    		builder.precondition(hu.bme.mit.incquery.cep.performance.md.patterns.ComponentJMatcher.querySpecification());
    IMatchProcessor<ComponentJMatch>		 action = new IMatchProcessor<ComponentJMatch>() {
    		public void process(final hu.bme.mit.incquery.cep.performance.md.patterns.ComponentJMatch matchedPattern) {
    			try {
    Collection<ComponentJMatch>				allMatches = hu.bme.mit.incquery.cep.performance.md.patterns.ComponentJMatcher.on(transformation.getIqEngine()).getAllMatches();
    				for (hu.bme.mit.incquery.cep.performance.md.patterns.ComponentJMatch match : allMatches) {
    					hu.bme.mit.incquery.cep.performance.events.incquery.ComponentJ_IQEvent event = new hu.bme.mit.incquery.cep.performance.events.incquery.ComponentJ_IQEvent(null);
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
