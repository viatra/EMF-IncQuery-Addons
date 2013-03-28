package hu.bme.mit.incquery.cep.tests.testcasesmqueries.enabledtransition;

import com.google.common.base.Objects;

import hu.bme.mit.incquery.cep.metamodels.cep.Event;

import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the hu.bme.mit.incquery.cep.tests.testcasesmqueries.enabledTransition pattern.
 */
public class EnabledTransitionEvaluator1_1 implements IMatchChecker {
	/**
	 * The raw java code generated from the xbase xexpression by xtext.
	 */
	private Boolean evaluateXExpressionGenerated(final Class<?> guardEventType, final String eventId) {
		Class<?> _guardEventType = guardEventType;
		String _eventId = eventId;
		boolean _equals = Objects.equal(_guardEventType, _eventId);
		return Boolean.valueOf(_equals);
	}
	
	/**
	 * A wrapper method for calling the generated java method with the correct attributes.
	 */
	@Override
	public Boolean evaluateXExpression(final Tuple tuple, final Map<String, Integer> tupleNameMap) {
		int guardEventTypePosition = tupleNameMap.get("guardEventType");
		java.lang.Class<? extends Event> guardEventType = (java.lang.Class<? extends Event>) tuple
				.get(guardEventTypePosition);
		int eventIdPosition = tupleNameMap.get("eventId");
		java.lang.String eventId = (java.lang.String) tuple.get(eventIdPosition);
		return evaluateXExpressionGenerated(guardEventType, eventId);
	}
}
