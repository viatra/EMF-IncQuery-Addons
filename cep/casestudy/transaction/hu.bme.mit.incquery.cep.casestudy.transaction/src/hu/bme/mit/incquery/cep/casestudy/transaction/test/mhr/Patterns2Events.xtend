package hu.bme.mit.incquery.cep.casestudy.transaction.test.mhr

import hu.bme.mit.incquery.cep.api.ICepAdapter
import hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentA_IQEvent
import hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentB_IQEvent
import hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentC_IQEvent
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.LatestEventComponentAMatcher
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.LatestEventComponentBMatcher
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.LatestEventComponentCMatcher
import java.util.Map
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.incquery.runtime.evm.api.RuleSpecification
import org.eclipse.viatra2.emf.runtime.rules.EventDrivenTransformationRuleGroup
import org.eclipse.viatra2.emf.runtime.rules.eventdriven.EventDrivenTransformationRuleFactory
import org.eclipse.viatra2.emf.runtime.transformation.eventdriven.EventDrivenTransformation
import hu.bme.mit.incquery.cep.casestudy.transaction.test.IncQueryTester

class Patterns2Events {
	extension EventDrivenTransformationRuleFactory ruleFactory = new EventDrivenTransformationRuleFactory

	@Property Map<RuleSpecification<?>, Integer> modelHandlers;
	@Property ICepAdapter adapter;
	@Property ResourceSet resourceSet;

	new(IncQueryTester incQueryTest) {
		this.adapter = incQueryTest.getAdapter
		this.resourceSet = incQueryTest.getResourceSet
	}

	def getRules() {
		new EventDrivenTransformationRuleGroup(
			createLatestComponentARule,
			createLatestComponentBRule,
			createLatestComponentCRule
		)
	}

	def registerRules() {
		EventDrivenTransformation.forResource(resourceSet).addRules(rules).create()
	}

	val createLatestComponentARule = ruleFactory.createRule().name("latest component A").precondition(
		LatestEventComponentAMatcher::querySpecification).action [
		var event = new ComponentA_IQEvent(null)
		event.setCustomerId(te.customerId)
		event.setTransactionId(te.transactionId)
		adapter.push(event)
	].build

	val createLatestComponentBRule = ruleFactory.createRule().name("latest component B").precondition(
		LatestEventComponentBMatcher::querySpecification).action [
		var event = new ComponentB_IQEvent(null)
		event.setTransactionId(te.transactionId)
		adapter.push(event)
	].build

	val createLatestComponentCRule = ruleFactory.createRule().name("latest component C").precondition(
		LatestEventComponentCMatcher::querySpecification).action [
		var event = new ComponentC_IQEvent(null)
		event.setSupplierId(te.supplierId)
		event.setTransactionId(te.transactionId)
		adapter.push(event)
	].build
}
