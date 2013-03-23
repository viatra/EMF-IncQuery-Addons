/**
 */
package hu.bme.mit.incquery.metamodels.internalsm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.metamodels.internalsm.Transition#getInStates <em>In States</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.metamodels.internalsm.Transition#getGuard <em>Guard</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.metamodels.internalsm.Transition#getOutStates <em>Out States</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.metamodels.internalsm.InternalsmPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends EObject {
	/**
	 * Returns the value of the '<em><b>In States</b></em>' reference list.
	 * The list contents are of type {@link hu.bme.mit.incquery.metamodels.internalsm.State}.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.metamodels.internalsm.State#getOutTransitions <em>Out Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In States</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In States</em>' reference list.
	 * @see hu.bme.mit.incquery.metamodels.internalsm.InternalsmPackage#getTransition_InStates()
	 * @see hu.bme.mit.incquery.metamodels.internalsm.State#getOutTransitions
	 * @model opposite="outTransitions"
	 * @generated
	 */
	EList<State> getInStates();

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
	 * @see hu.bme.mit.incquery.metamodels.internalsm.InternalsmPackage#getTransition_Guard()
	 * @model
	 * @generated
	 */
	Guard getGuard();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.metamodels.internalsm.Transition#getGuard <em>Guard</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard</em>' reference.
	 * @see #getGuard()
	 * @generated
	 */
	void setGuard(Guard value);

	/**
	 * Returns the value of the '<em><b>Out States</b></em>' reference list.
	 * The list contents are of type {@link hu.bme.mit.incquery.metamodels.internalsm.State}.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.metamodels.internalsm.State#getInTransitions <em>In Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out States</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out States</em>' reference list.
	 * @see hu.bme.mit.incquery.metamodels.internalsm.InternalsmPackage#getTransition_OutStates()
	 * @see hu.bme.mit.incquery.metamodels.internalsm.State#getInTransitions
	 * @model opposite="inTransitions"
	 * @generated
	 */
	EList<State> getOutStates();

} // Transition
