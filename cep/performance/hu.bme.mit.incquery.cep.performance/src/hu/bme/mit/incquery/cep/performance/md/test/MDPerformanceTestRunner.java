package hu.bme.mit.incquery.cep.performance.md.test;

import hu.bme.mit.incquery.cep.performance.rules.R1;

import java.io.IOException;

import org.junit.Test;

public class MDPerformanceTestRunner {

	@Test
	public void main() throws IOException {
		MDPerformanceTester tester = MDPerformanceTester.getInstance();

		tester.setup(new R1());
		tester.simulate();

		tester.dispose();
	}
}
