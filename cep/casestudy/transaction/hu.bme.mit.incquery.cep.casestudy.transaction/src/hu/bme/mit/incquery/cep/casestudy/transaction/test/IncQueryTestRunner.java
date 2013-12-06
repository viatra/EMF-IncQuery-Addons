package hu.bme.mit.incquery.cep.casestudy.transaction.test;

import hu.bme.mit.incquery.cep.casestudy.transaction.rules.R1;

import org.junit.Test;

public class IncQueryTestRunner {

	@Test
	public void main() {
		IncQueryTester tester = IncQueryTester.getInstance();

		tester.setup(new R1());
		tester.simulate();
		tester.dispose();
	}
}
