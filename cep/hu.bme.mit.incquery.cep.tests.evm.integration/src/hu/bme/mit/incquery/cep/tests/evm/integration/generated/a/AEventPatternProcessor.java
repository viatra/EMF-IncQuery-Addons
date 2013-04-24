package hu.bme.mit.incquery.cep.tests.evm.integration.generated.a;

import org.eclipse.incquery.runtime.api.IMatchProcessor;

public class AEventPatternProcessor implements IMatchProcessor<AEventPatternMatch> {
	
	@Override
	public void process(AEventPatternMatch match) {
		System.out.println("A EVENT PATTERN RECOGNIZED");
		
	}
}