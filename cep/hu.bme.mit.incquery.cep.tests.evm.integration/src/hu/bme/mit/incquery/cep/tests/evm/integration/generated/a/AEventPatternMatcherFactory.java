package hu.bme.mit.incquery.cep.tests.evm.integration.generated.a;

import hu.bme.mit.incquery.cep.internal.Activator;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;

import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IMatcherFactory;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;

public class AEventPatternMatcherFactory extends BaseGeneratedMatcherFactory<AEventPatternMatcher> {
	
	public AEventPatternMatcherFactory() throws IncQueryException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected String getBundleName() {
		return Activator.getDefault().getBundle().getSymbolicName();
	}
	
	@Override
	protected String patternName() {
		return "hu.bme.mit.incquery.cep.tests.evm.integration.patterns.APattern";
	}
	
	@Override
	protected AEventPatternMatcher instantiate(IncQueryEngine engine) throws IncQueryException {
		return new AEventPatternMatcher(engine);
	}
	
	public static IMatcherFactory<AEventPatternMatcher> instance() throws IncQueryException {
		try {
			return LazyHolder.INSTANCE;
		} catch (ExceptionInInitializerError err) {
			processInitializerError(err);
			throw err;
		}
	}
	
	private static class LazyHolder {
		private final static AEventPatternMatcherFactory INSTANCE = make();
		
		public static AEventPatternMatcherFactory make() {
			try {
				return new AEventPatternMatcherFactory();
			} catch (IncQueryException ex) {
				throw new RuntimeException(ex);
			}
			
		}
	}
	
	public EventPattern getEventPattern() {
		return null;
	}
}
