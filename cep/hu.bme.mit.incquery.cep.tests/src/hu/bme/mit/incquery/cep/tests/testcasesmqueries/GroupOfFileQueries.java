package hu.bme.mit.incquery.cep.tests.testcasesmqueries;

import hu.bme.mit.incquery.cep.tests.testcasesmqueries.enabledtransition.EnabledTransitionMatcher;
import hu.bme.mit.incquery.cep.tests.testcasesmqueries.event.EventMatcher;
import hu.bme.mit.incquery.cep.tests.testcasesmqueries.statemachine.StateMachineMatcher;
import hu.bme.mit.incquery.cep.tests.testcasesmqueries.transition.TransitionMatcher;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

public final class GroupOfFileQueries extends BaseGeneratedPatternGroup {
  public GroupOfFileQueries() throws IncQueryException {
    matcherFactories.add(StateMachineMatcher.factory());
    matcherFactories.add(EnabledTransitionMatcher.factory());
    matcherFactories.add(EventMatcher.factory());
    matcherFactories.add(TransitionMatcher.factory());
    
  }
}
