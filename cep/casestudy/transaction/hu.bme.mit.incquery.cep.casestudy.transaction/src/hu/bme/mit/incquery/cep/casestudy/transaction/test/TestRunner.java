package hu.bme.mit.incquery.cep.casestudy.transaction.test;

import hu.bme.mit.incquery.cep.casestudy.transaction.rules.R1;

import org.junit.Test;

public class TestRunner {

	@Test
	public void main() {
		BareJavaTester tester = new BareJavaTester();

		tester.initializeEngine(new R1());
		tester.acquireAdapter();
		tester.simulate();
	}
}
