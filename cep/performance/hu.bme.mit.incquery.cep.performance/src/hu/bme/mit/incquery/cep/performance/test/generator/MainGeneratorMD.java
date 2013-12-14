package hu.bme.mit.incquery.cep.performance.test.generator;

import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator;

import java.util.List;

import com.google.common.collect.Lists;

public class MainGeneratorMD {

	public static void main(String[] args) {
		List<String> atomicEvents = Lists.newArrayList("componentA", "componentB", "componentC", "componentD",
				"componentE", "componentF", "componentG");
		PermutationHelper<String> permutation = new PermutationHelper<String>();
		List<List<String>> perm = permutation.generatePerm2(atomicEvents, 1000);

		TemplateMD template = new TemplateMD();
		template.generate("src/testdata.vepl", perm, ComplexOperator.ORDERED);
	}
}