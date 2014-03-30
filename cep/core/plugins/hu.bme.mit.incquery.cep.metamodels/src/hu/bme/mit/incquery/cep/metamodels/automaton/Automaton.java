/**
 */
package hu.bme.mit.incquery.cep.metamodels.automaton;

import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Automaton</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.automaton.Automaton#getStates <em>States</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.automaton.Automaton#getEventPattern <em>Event Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.automaton.AutomatonPackage#getAutomaton()
 * @model
 * @generated
 */
public interface Automaton extends EObject {
    /**
     * Returns the value of the '<em><b>States</b></em>' containment reference list.
     * The list contents are of type {@link hu.bme.mit.incquery.cep.metamodels.automaton.State}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>States</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>States</em>' containment reference list.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.AutomatonPackage#getAutomaton_States()
     * @model containment="true"
     * @generated
     */
    EList<State> getStates();

    /**
     * Returns the value of the '<em><b>Event Pattern</b></em>' reference.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.cep.metamodels.cep.EventPattern#getAutomaton <em>Automaton</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Event Pattern</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Event Pattern</em>' reference.
     * @see #setEventPattern(EventPattern)
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.AutomatonPackage#getAutomaton_EventPattern()
     * @see hu.bme.mit.incquery.cep.metamodels.cep.EventPattern#getAutomaton
     * @model opposite="automaton" required="true"
     * @generated
     */
    EventPattern getEventPattern();

    /**
     * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.automaton.Automaton#getEventPattern <em>Event Pattern</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Event Pattern</em>' reference.
     * @see #getEventPattern()
     * @generated
     */
    void setEventPattern(EventPattern value);

} // Automaton
