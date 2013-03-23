/**
 */
package hu.bme.mit.incquery.metamodels.internalsm;

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
 *   <li>{@link hu.bme.mit.incquery.metamodels.internalsm.State#getOutTransitions <em>Out Transitions</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.metamodels.internalsm.State#getInTransitions <em>In Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.metamodels.internalsm.InternalsmPackage#getState()
 * @model
 * @generated
 */
public interface State extends EObject {
	/**
	 * Returns the value of the '<em><b>Out Transitions</b></em>' reference list.
	 * The list contents are of type {@link hu.bme.mit.incquery.metamodels.internalsm.Transition}.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.metamodels.internalsm.Transition#getInState <em>In State</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Transitions</em>' reference list.
	 * @see hu.bme.mit.incquery.metamodels.internalsm.InternalsmPackage#getState_OutTransitions()
	 * @see hu.bme.mit.incquery.metamodels.internalsm.Transition#getInState
	 * @model opposite="inState"
	 * @generated
	 */
	EList<Transition> getOutTransitions();

	/**
	 * Returns the value of the '<em><b>In Transitions</b></em>' reference list.
	 * The list contents are of type {@link hu.bme.mit.incquery.metamodels.internalsm.Transition}.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.metamodels.internalsm.Transition#getOutState <em>Out State</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Transitions</em>' reference list.
	 * @see hu.bme.mit.incquery.metamodels.internalsm.InternalsmPackage#getState_InTransitions()
	 * @see hu.bme.mit.incquery.metamodels.internalsm.Transition#getOutState
	 * @model opposite="outState"
	 * @generated
	 */
	EList<Transition> getInTransitions();

} // State
