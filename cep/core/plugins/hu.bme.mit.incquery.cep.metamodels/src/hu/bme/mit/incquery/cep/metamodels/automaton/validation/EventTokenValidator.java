/**
 *
 * $Id$
 */
package hu.bme.mit.incquery.cep.metamodels.automaton.validation;

import hu.bme.mit.incquery.cep.metamodels.automaton.State;

import hu.bme.mit.incquery.cep.metamodels.cep.Event;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link hu.bme.mit.incquery.cep.metamodels.automaton.EventToken}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface EventTokenValidator {
    boolean validate();

    boolean validateCurrentState(State value);
    boolean validateRecordedEvents(EList<Event> value);
}
