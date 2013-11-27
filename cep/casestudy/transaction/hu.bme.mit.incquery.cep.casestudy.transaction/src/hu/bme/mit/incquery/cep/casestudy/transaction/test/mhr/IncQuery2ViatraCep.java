package hu.bme.mit.incquery.cep.casestudy.transaction.test.mhr;

import hu.bme.mit.incquery.cep.api.ICepAdapter;
import hu.bme.mit.incquery.cep.api.ParameterizableIncQueryPatternEventInstance;
import hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentA_IQEvent;
import hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentB_IQEvent;
import hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentC_IQEvent;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentA_AppearedMatch;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentA_AppearedMatcher;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentB_AppearedMatch;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentB_AppearedMatcher;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentC_AppearedMatch;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentC_AppearedMatcher;
import hu.bme.mit.incquery.cep.casestudy.transaction.test.IncQueryTester;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.evm.api.RuleSpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra2.emf.runtime.rules.EventDrivenTransformationRuleGroup;
import org.eclipse.viatra2.emf.runtime.rules.eventdriven.EventDrivenTransformationRuleFactory;
import org.eclipse.viatra2.emf.runtime.rules.eventdriven.EventDrivenTransformationRuleFactory.EventDrivenTransformationBuilder;
import org.eclipse.viatra2.emf.runtime.transformation.eventdriven.EventDrivenTransformation;
import org.eclipse.viatra2.emf.runtime.transformation.eventdriven.EventDrivenTransformationRule;
import org.eclipse.viatra2.emf.runtime.transformation.eventdriven.InconsistentEventSemanticsException;

public class IncQuery2ViatraCep {

	private Map<RuleSpecification<?>, Integer> modelHandlers;
	private ICepAdapter adapter;
	private ResourceSet resourceSet;
	private EventDrivenTransformation transformation;

	public IncQuery2ViatraCep(IncQueryTester incQueryTest) {
		this.adapter = incQueryTest.getAdapter();
		this.resourceSet = incQueryTest.getResourceSet();
	}

	public EventDrivenTransformationRuleGroup getRules() {
		EventDrivenTransformationRuleGroup ruleTroup = new EventDrivenTransformationRuleGroup(
				createLatestComponentARuleMapping(), createLatestComponentBRuleMapping(),
				createLatestComponentCRuleMapping());
		return ruleTroup;
	}

	public void registerRules() {
		transformation = EventDrivenTransformation.forResource(resourceSet).addRules(getRules()).create();
	}

	private EventDrivenTransformationRule<?,?> createLatestComponentCRuleMapping2() {
		try {
			EventDrivenTransformationBuilder builder = new EventDrivenTransformationRuleFactory().createRule();

			builder.precondition(ComponentA_AppearedMatcher.querySpecification());

			IMatchProcessor action = new IMatchProcessor<ComponentA_AppearedMatch>() {
				public void process(final ComponentA_AppearedMatch it) {
					Collection<ComponentA_AppearedMatch> allMatches;
					try {
						allMatches = ComponentA_AppearedMatcher.on(transformation.getIqEngine()).getAllMatches();

						for (ComponentA_AppearedMatch match : allMatches) {
							ParameterizableIncQueryPatternEventInstance event = new ParameterizableIncQueryPatternEventInstance(
									null);
							event.setIncQueryPattern(match);
							event.setType(ComponentA_IQEvent.class.getCanonicalName());
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
	
	private EventDrivenTransformationRule<ComponentA_AppearedMatch, ComponentA_AppearedMatcher> createLatestComponentCRuleMapping() {
		try {
			EventDrivenTransformationBuilder<ComponentA_AppearedMatch, ComponentA_AppearedMatcher> builder = new EventDrivenTransformationRuleFactory()
					.<ComponentA_AppearedMatch, ComponentA_AppearedMatcher> createRule();

			builder.precondition(ComponentA_AppearedMatcher.querySpecification());

			IMatchProcessor<ComponentA_AppearedMatch> action = new IMatchProcessor<ComponentA_AppearedMatch>() {
				public void process(final ComponentA_AppearedMatch it) {
					Collection<ComponentA_AppearedMatch> allMatches;
					try {
						allMatches = ComponentA_AppearedMatcher.on(transformation.getIqEngine()).getAllMatches();

						for (ComponentA_AppearedMatch match : allMatches) {
							ParameterizableIncQueryPatternEventInstance event = new ParameterizableIncQueryPatternEventInstance(
									null);
							event.setIncQueryPattern(match);
							event.setType(ComponentA_IQEvent.class.getCanonicalName());
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

	private EventDrivenTransformationRule<ComponentB_AppearedMatch, ComponentB_AppearedMatcher> createLatestComponentBRuleMapping() {
		try {
			EventDrivenTransformationBuilder<ComponentB_AppearedMatch, ComponentB_AppearedMatcher> builder = new EventDrivenTransformationRuleFactory()
					.<ComponentB_AppearedMatch, ComponentB_AppearedMatcher> createRule();

			builder.precondition(ComponentB_AppearedMatcher.querySpecification());

			IMatchProcessor<ComponentB_AppearedMatch> action = new IMatchProcessor<ComponentB_AppearedMatch>() {
				public void process(final ComponentB_AppearedMatch it) {
					Collection<ComponentB_AppearedMatch> allMatches;
					try {
						allMatches = ComponentB_AppearedMatcher.on(transformation.getIqEngine()).getAllMatches();

						for (ComponentB_AppearedMatch match : allMatches) {
							ParameterizableIncQueryPatternEventInstance event = new ParameterizableIncQueryPatternEventInstance(
									null);
							event.setIncQueryPattern(match);
							event.setType(ComponentB_IQEvent.class.getCanonicalName());
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

	private EventDrivenTransformationRule<ComponentC_AppearedMatch, ComponentC_AppearedMatcher> createLatestComponentARuleMapping() {
		try {
			EventDrivenTransformationBuilder<ComponentC_AppearedMatch, ComponentC_AppearedMatcher> builder = new EventDrivenTransformationRuleFactory()
					.<ComponentC_AppearedMatch, ComponentC_AppearedMatcher> createRule();

			builder.precondition(ComponentC_AppearedMatcher.querySpecification());

			IMatchProcessor<ComponentC_AppearedMatch> action = new IMatchProcessor<ComponentC_AppearedMatch>() {
				public void process(final ComponentC_AppearedMatch it) {
					Collection<ComponentC_AppearedMatch> allMatches;
					try {
						allMatches = ComponentC_AppearedMatcher.on(transformation.getIqEngine()).getAllMatches();

						for (ComponentC_AppearedMatch match : allMatches) {
							ParameterizableIncQueryPatternEventInstance event = new ParameterizableIncQueryPatternEventInstance(
									null);
							event.setIncQueryPattern(match);
							event.setType(ComponentC_IQEvent.class.getCanonicalName());
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

	public Map<RuleSpecification<?>, Integer> getModelHandlers() {
		return modelHandlers;
	}

	public void setModelHandlers(Map<RuleSpecification<?>, Integer> modelHandlers) {
		this.modelHandlers = modelHandlers;
	}

	public ICepAdapter getAdapter() {
		return adapter;
	}

	public void setAdapter(ICepAdapter adapter) {
		this.adapter = adapter;
	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	public void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}

	public EventDrivenTransformation getTransformation() {
		return transformation;
	}

	public void setTransformation(EventDrivenTransformation transformation) {
		this.transformation = transformation;
	}
}
