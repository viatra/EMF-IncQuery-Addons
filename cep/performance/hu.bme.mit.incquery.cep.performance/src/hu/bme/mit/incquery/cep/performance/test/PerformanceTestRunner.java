package hu.bme.mit.incquery.cep.performance.test;

import org.junit.Test;

import hu.bme.mit.incquery.cep.performance.rules.R1;

public class PerformanceTestRunner {

	@Test
	public void main() {
		PerformanceTester tester = PerformanceTester.getInstance();

		tester.setup(new R1());
		tester.simulate();
		tester.dispose();
	}
}
