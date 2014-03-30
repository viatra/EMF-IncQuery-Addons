/**
 */
package hu.bme.mit.incquery.cep.metamodels.automaton;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.automaton.Transition#getPreState <em>Pre State</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.automaton.Transition#getPostState <em>Post State</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.automaton.Transition#getGuard <em>Guard</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.automaton.AutomatonPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends EObject {
    /**
     * Returns the value of the '<em><b>Pre State</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.cep.metamodels.automaton.State#getOutTransitions <em>Out Transitions</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Pre State</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Pre State</em>' container reference.
     * @see #setPreState(State)
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.AutomatonPackage#getTransition_PreState()
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.State#getOutTransitions
     * @model opposite="outTransitions" transient="false"
     * @generated
     */
    State getPreState();

    /**
     * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.automaton.Transition#getPreState <em>Pre State</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Pre State</em>' container reference.
     * @see #getPreState()
     * @generated
     */
    void setPreState(State value);

    /**
     * Returns the value of the '<em><b>Post State</b></em>' reference.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.cep.metamodels.automaton.State#getInTransitions <em>In Transitions</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Post State</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Post State</em>' reference.
     * @see #setPostState(State)
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.AutomatonPackage#getTransition_PostState()
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.State#getInTransitions
     * @model opposite="inTransitions"
     * @generated
     */
    State getPostState();

    /**
     * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.automaton.Transition#getPostState <em>Post State</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Post State</em>' reference.
     * @see #getPostState()
     * @generated
     */
    void setPostState(State value);

    /**
     * Returns the value of the '<em><b>Guard</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Guard</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Guard</em>' containment reference.
     * @see #setGuard(Guard)
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.AutomatonPackage#getTransition_Guard()
     * @model containment="true"
     * @generated
     */
    Guard getGuard();

    /**
     * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.automaton.Transition#getGuard <em>Guard</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Guard</em>' containment reference.
     * @see #getGuard()
     * @generated
     */
    void setGuard(Guard value);

} // Transition
