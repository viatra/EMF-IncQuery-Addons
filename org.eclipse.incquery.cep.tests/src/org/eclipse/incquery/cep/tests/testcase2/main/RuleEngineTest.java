package org.eclipse.incquery.cep.tests.testcase2.main;

import java.util.Set;

import org.apache.log4j.Level;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.incquery.runtime.api.EngineManager;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.evm.api.Activation;
import org.eclipse.incquery.runtime.evm.api.Context;
import org.eclipse.incquery.runtime.evm.api.EventDrivenVM;
import org.eclipse.incquery.runtime.evm.api.RuleEngine;
import org.eclipse.incquery.runtime.evm.api.RuleInstance;
import org.eclipse.incquery.runtime.evm.api.RuleSpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.junit.Test;

public class RuleEngineTest {
	
	@Test
	public void test() throws IncQueryException {
		ResourceSet rs = new ResourceSetImpl();
		IncQueryEngine engine = EngineManager.getInstance().getIncQueryEngine(rs);
		
		engine.getLogger().setLevel(Level.DEBUG);
		
		RuleEngine createRuleEngine = EventDrivenVM.createRuleEngine(engine);
		
		// todo own impl
		// RuleSpecification<IPatternMatch> spec = new
		// RuleSpecification<IPatternMatch>() {
		//
		// @Override
		// protected RuleInstance<IPatternMatch> instantiateRule(IncQueryEngine
		// engine) {
		// // TODO Auto-generated method stub
		// return null;
		// }
		// };
		//
		// createRuleEngine.addRule(spec);
		//
		// Context ctx = Context.create();
		//
		// Set<Activation<IPatternMatch>> activations =
		// createRuleEngine.getActivations(spec);
		// for (Activation<IPatternMatch> activation : activations) {
		// activation.fire(ctx);
		// }
	}
}