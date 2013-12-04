package hu.bme.mit.incquery.cep.casestudy.transaction.test;

import hu.bme.mit.incquery.cep.casestudy.transaction.rules.R1;

import org.junit.Test;

public class TestRunner {

	@Test
	public void main() {
		//BareJavaTester tester = new BareJavaTester();
		IncQueryTester tester = IncQueryTester.getInstance();

		tester.initializeEngine(new R1());
		
		//tester.initializeEngine(new R1(engine)); - IncQuery integration desired form
		
		tester.simulate();
		tester.dispose();
	}
}
