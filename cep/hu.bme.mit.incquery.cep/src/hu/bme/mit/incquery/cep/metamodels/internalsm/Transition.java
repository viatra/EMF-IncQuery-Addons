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
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Transition#getPreState <em>Pre State</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Transition#getGuard <em>Guard</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Transition#getPostState <em>Post State</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends EObject {
	/**
	 * Returns the value of the '<em><b>Pre State</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.State#getOutTransitions <em>Out Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pre State</em>' reference.
	 * @see #setPreState(State)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getTransition_PreState()
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.State#getOutTransitions
	 * @model opposite="outTransitions" required="true"
	 * @generated
	 */
	State getPreState();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Transition#getPreState <em>Pre State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pre State</em>' reference.
	 * @see #getPreState()
	 * @generated
	 */
	void setPreState(State value);

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
	 * Returns the value of the '<em><b>Post State</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.State#getInTransitions <em>In Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Post State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Post State</em>' reference.
	 * @see #setPostState(State)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getTransition_PostState()
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.State#getInTransitions
	 * @model opposite="inTransitions" required="true"
	 * @generated
	 */
	State getPostState();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Transition#getPostState <em>Post State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Post State</em>' reference.
	 * @see #getPostState()
	 * @generated
	 */
	void setPostState(State value);

} // Transition
