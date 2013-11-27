package hu.bme.mit.incquery.cep.dsl.jvmmodel;

import org.eclipse.viatra2.emf.runtime.rules.EventDrivenTransformationRuleGroup;
import org.eclipse.viatra2.emf.runtime.rules.eventdriven.EventDrivenTransformationRuleFactory;

public enum AtomicPatternFqnPurpose {
    PATTERN, EVENT, IQDTO;
    
    EventDrivenTransformationRuleGroup g;
    EventDrivenTransformationRuleFactory f;
}
