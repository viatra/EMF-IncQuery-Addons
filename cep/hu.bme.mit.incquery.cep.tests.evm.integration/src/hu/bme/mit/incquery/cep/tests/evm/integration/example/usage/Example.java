package hu.bme.mit.incquery.cep.tests.evm.integration.example.usage;

import hu.bme.mit.incquery.cep.tests.evm.integration.generated.a.AEventPatternMatch;
import hu.bme.mit.incquery.cep.tests.evm.integration.generated.a.AEventPatternMatcher;
import hu.bme.mit.incquery.cep.tests.evm.integration.generated.a.AEventPatternProcessor;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.evm.api.ActivationState;
import org.eclipse.incquery.runtime.evm.api.Job;
import org.eclipse.incquery.runtime.evm.api.RuleSpecification;
import org.eclipse.incquery.runtime.evm.specific.DefaultActivationLifeCycle;
import org.eclipse.incquery.runtime.evm.specific.SimpleMatcherRuleSpecification;
import org.eclipse.incquery.runtime.evm.specific.StatelessJob;
import org.eclipse.incquery.runtime.exception.IncQueryException;

public class Example {
	public static RuleSpecification<AEventPatternMatch> getAPatternMatchRule() throws IncQueryException {
		IMatchProcessor<AEventPatternMatch> processor = new AEventPatternProcessor();
		
		Set<Job<AEventPatternMatch>> jobs = new HashSet<Job<AEventPatternMatch>>();
		jobs.add(new StatelessJob<AEventPatternMatch>(ActivationState.APPEARED, processor));
		
		SimpleMatcherRuleSpecification<AEventPatternMatch, AEventPatternMatcher> spec = new SimpleMatcherRuleSpecification<AEventPatternMatch, AEventPatternMatcher>(
				AEventPatternMatcher.factory(), DefaultActivationLifeCycle.DEFAULT, jobs);
		
		return spec;
		
	}
}
