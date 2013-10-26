package hu.bme.mit.incquery.cep.casestudy.transaction.test;

import org.junit.Test;

import hu.bme.mit.incquery.cep.casestudy.transaction.rules.R1;

public class TestRunner {
	
	@Test
	public void main() {
		BareJavaTester tester = new BareJavaTester();

		tester.initializeEngine(new R1());
		tester.acquireAdapter();
		tester.simulate();
	}
}
