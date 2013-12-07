package hu.bme.mit.incquery.cep.performance.test.generator;

import java.util.List;

import com.google.common.collect.Lists;

public class MainGenerator {

	public static void main(String[] args) {
		List<String> atomicEvents = Lists.newArrayList("componentA", "componentB", "componentC", "componentD",
				"componentE");
		PermutationHelper<String> permutation = new PermutationHelper<String>();
		List<List<String>> perm = permutation.generatePerm(atomicEvents);

		Template template = new Template();
		template.generate("src/testdata.vepl", perm);
	}
}