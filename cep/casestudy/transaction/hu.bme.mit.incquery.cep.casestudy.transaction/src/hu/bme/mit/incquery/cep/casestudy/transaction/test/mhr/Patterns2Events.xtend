package hu.bme.mit.incquery.cep.casestudy.transaction.test.mhr

import hu.bme.mit.incquery.cep.api.ICepAdapter
import hu.bme.mit.incquery.cep.api.ParameterizableIncQueryPatternEventInstance
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentA_AppearedMatcher
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentB_AppearedMatcher
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentC_AppearedMatcher
import hu.bme.mit.incquery.cep.casestudy.transaction.test.IncQueryTester
import java.util.Map
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.incquery.runtime.evm.api.RuleSpecification
import org.eclipse.viatra2.emf.runtime.rules.EventDrivenTransformationRuleGroup
import org.eclipse.viatra2.emf.runtime.rules.eventdriven.EventDrivenTransformationRuleFactory
import org.eclipse.viatra2.emf.runtime.transformation.eventdriven.EventDrivenTransformation

@Deprecated
class Patterns2Events {
	extension EventDrivenTransformationRuleFactory ruleFactory = new EventDrivenTransformationRuleFactory

	@Property Map<RuleSpecification<?>, Integer> modelHandlers;
	@Property ICepAdapter adapter;
	@Property ResourceSet resourceSet;
	@Property EventDrivenTransformation transformation;

	new(IncQueryTester incQueryTest) {
		this.adapter = incQueryTest.getAdapter
		this.resourceSet = incQueryTest.getResourceSet
	}

	def getRules() {
		new EventDrivenTransformationRuleGroup(
			createLatestComponentARuleMapping,
			createLatestComponentBRuleMapping,
			createLatestComponentCRuleMapping
		)
	}

	def registerRules() {
		transformation = EventDrivenTransformation.forResource(resourceSet).addRules(rules).create()
	}

	val createLatestComponentARuleMapping = ruleFactory.createRule().precondition(
		ComponentA_AppearedMatcher::querySpecification).action [
			for(match : ComponentA_AppearedMatcher::on(transformation.iqEngine).allMatches){	
				var event = new ParameterizableIncQueryPatternEventInstance(null)
				event.setIncQueryPattern(match)
				adapter.push(event)
			}	
	].build
	
	val createLatestComponentBRuleMapping = ruleFactory.createRule().precondition(
		ComponentB_AppearedMatcher::querySpecification).action [
			for(match : ComponentB_AppearedMatcher::on(transformation.iqEngine).allMatches){	
				var event = new ParameterizableIncQueryPatternEventInstance(null)
				event.setIncQueryPattern(match)
				adapter.push(event)
			}	
	].build
	
	val createLatestComponentCRuleMapping = ruleFactory.createRule().precondition(
		ComponentC_AppearedMatcher::querySpecification).action [
			for(match : ComponentC_AppearedMatcher::on(transformation.iqEngine).allMatches){	
				var event = new ParameterizableIncQueryPatternEventInstance(null)
				event.setIncQueryPattern(match)
				adapter.push(event)
			}	
	].build
}
