package hu.bme.mit.incquery.cep.casestudy.java.test;

import hu.bme.mit.incquery.cep.casestudy.transaction.rules.R1;

import org.junit.Test;

public class JavaTestRunner {

	@Test
	public void main() {
		JavaTester tester = JavaTester.getInstance();

		tester.setup(new R1());
		tester.simulate();
		tester.dispose();
	}
}
