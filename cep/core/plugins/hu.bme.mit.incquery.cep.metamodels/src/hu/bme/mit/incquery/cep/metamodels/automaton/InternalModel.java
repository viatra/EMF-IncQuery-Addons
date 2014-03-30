/**
 */
package hu.bme.mit.incquery.cep.metamodels.automaton;

import hu.bme.mit.incquery.cep.metamodels.cep.Event;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Internal Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.automaton.InternalModel#getAutomata <em>Automata</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.automaton.InternalModel#getLatestEvent <em>Latest Event</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.automaton.InternalModel#getEventTokens <em>Event Tokens</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.automaton.AutomatonPackage#getInternalModel()
 * @model
 * @generated
 */
public interface InternalModel extends EObject {
    /**
     * Returns the value of the '<em><b>Automata</b></em>' containment reference list.
     * The list contents are of type {@link hu.bme.mit.incquery.cep.metamodels.automaton.Automaton}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Automata</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Automata</em>' containment reference list.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.AutomatonPackage#getInternalModel_Automata()
     * @model containment="true"
     * @generated
     */
    EList<Automaton> getAutomata();

    /**
     * Returns the value of the '<em><b>Latest Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Latest Event</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Latest Event</em>' containment reference.
     * @see #setLatestEvent(Event)
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.AutomatonPackage#getInternalModel_LatestEvent()
     * @model containment="true"
     * @generated
     */
    Event getLatestEvent();

    /**
     * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.automaton.InternalModel#getLatestEvent <em>Latest Event</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Latest Event</em>' containment reference.
     * @see #getLatestEvent()
     * @generated
     */
    void setLatestEvent(Event value);

    /**
     * Returns the value of the '<em><b>Event Tokens</b></em>' containment reference list.
     * The list contents are of type {@link hu.bme.mit.incquery.cep.metamodels.automaton.EventToken}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Event Tokens</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Event Tokens</em>' containment reference list.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.AutomatonPackage#getInternalModel_EventTokens()
     * @model containment="true"
     * @generated
     */
    EList<EventToken> getEventTokens();

} // InternalModel
