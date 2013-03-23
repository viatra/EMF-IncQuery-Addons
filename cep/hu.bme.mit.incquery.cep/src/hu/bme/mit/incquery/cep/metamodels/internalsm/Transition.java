/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Transition#getInState <em>In State</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Transition#getGuard <em>Guard</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Transition#getOutState <em>Out State</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends EObject {
	/**
	 * Returns the value of the '<em><b>In State</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.State#getOutTransitions <em>Out Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In State</em>' reference.
	 * @see #setInState(State)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getTransition_InState()
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.State#getOutTransitions
	 * @model opposite="outTransitions" required="true"
	 * @generated
	 */
	State getInState();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Transition#getInState <em>In State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In State</em>' reference.
	 * @see #getInState()
	 * @generated
	 */
	void setInState(State value);

	/**
	 * Returns the value of the '<em><b>Guard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard</em>' reference.
	 * @see #setGuard(Guard)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getTransition_Guard()
	 * @model
	 * @generated
	 */
	Guard getGuard();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Transition#getGuard <em>Guard</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard</em>' reference.
	 * @see #getGuard()
	 * @generated
	 */
	void setGuard(Guard value);

	/**
	 * Returns the value of the '<em><b>Out State</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.State#getInTransitions <em>In Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out State</em>' reference.
	 * @see #setOutState(State)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getTransition_OutState()
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.State#getInTransitions
	 * @model opposite="inTransitions" required="true"
	 * @generated
	 */
	State getOutState();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Transition#getOutState <em>Out State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out State</em>' reference.
	 * @see #getOutState()
	 * @generated
	 */
	void setOutState(State value);

} // Transition
