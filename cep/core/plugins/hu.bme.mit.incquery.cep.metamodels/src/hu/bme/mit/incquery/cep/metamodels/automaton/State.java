/**
 */
package hu.bme.mit.incquery.cep.metamodels.automaton;

import hu.bme.mit.incquery.cep.metamodels.cep.Event;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.automaton.State#getInTransitions <em>In Transitions</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.automaton.State#getOutTransitions <em>Out Transitions</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.automaton.State#getLabel <em>Label</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.automaton.State#getEventTokens <em>Event Tokens</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.automaton.State#getLastProcessedEvent <em>Last Processed Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.automaton.AutomatonPackage#getState()
 * @model
 * @generated
 */
public interface State extends EObject {
    /**
     * Returns the value of the '<em><b>In Transitions</b></em>' reference list.
     * The list contents are of type {@link hu.bme.mit.incquery.cep.metamodels.automaton.Transition}.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.cep.metamodels.automaton.Transition#getPostState <em>Post State</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>In Transitions</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>In Transitions</em>' reference list.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.AutomatonPackage#getState_InTransitions()
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.Transition#getPostState
     * @model opposite="postState"
     * @generated
     */
    EList<Transition> getInTransitions();

    /**
     * Returns the value of the '<em><b>Out Transitions</b></em>' containment reference list.
     * The list contents are of type {@link hu.bme.mit.incquery.cep.metamodels.automaton.Transition}.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.cep.metamodels.automaton.Transition#getPreState <em>Pre State</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Out Transitions</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Out Transitions</em>' containment reference list.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.AutomatonPackage#getState_OutTransitions()
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.Transition#getPreState
     * @model opposite="preState" containment="true"
     * @generated
     */
    EList<Transition> getOutTransitions();

    /**
     * Returns the value of the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Label</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Label</em>' attribute.
     * @see #setLabel(String)
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.AutomatonPackage#getState_Label()
     * @model
     * @generated
     */
    String getLabel();

    /**
     * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.automaton.State#getLabel <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Label</em>' attribute.
     * @see #getLabel()
     * @generated
     */
    void setLabel(String value);

    /**
     * Returns the value of the '<em><b>Event Tokens</b></em>' reference list.
     * The list contents are of type {@link hu.bme.mit.incquery.cep.metamodels.automaton.EventToken}.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.cep.metamodels.automaton.EventToken#getCurrentState <em>Current State</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Event Tokens</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Event Tokens</em>' reference list.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.AutomatonPackage#getState_EventTokens()
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.EventToken#getCurrentState
     * @model opposite="currentState"
     * @generated
     */
    EList<EventToken> getEventTokens();

    /**
     * Returns the value of the '<em><b>Last Processed Event</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Last Processed Event</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Last Processed Event</em>' reference.
     * @see #setLastProcessedEvent(Event)
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.AutomatonPackage#getState_LastProcessedEvent()
     * @model
     * @generated
     */
    Event getLastProcessedEvent();

    /**
     * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.automaton.State#getLastProcessedEvent <em>Last Processed Event</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Last Processed Event</em>' reference.
     * @see #getLastProcessedEvent()
     * @generated
     */
    void setLastProcessedEvent(Event value);

} // State
