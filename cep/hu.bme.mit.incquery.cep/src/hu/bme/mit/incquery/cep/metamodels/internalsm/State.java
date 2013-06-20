/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm;

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
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.State#getOutTransitions <em>Out Transitions</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.State#getInTransitions <em>In Transitions</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.State#getLabel <em>Label</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.State#getEventTokens <em>Event Tokens</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.State#getTimeConstraints <em>Time Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getState()
 * @model
 * @generated
 */
public interface State extends EObject {
	/**
	 * Returns the value of the '<em><b>Out Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.incquery.cep.metamodels.internalsm.Transition}.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Transition#getPreState <em>Pre State</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Transitions</em>' containment reference list.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getState_OutTransitions()
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.Transition#getPreState
	 * @model opposite="preState" containment="true"
	 *        extendedMetaData="wildcards='' name=''"
	 * @generated
	 */
	EList<Transition> getOutTransitions();

	/**
	 * Returns the value of the '<em><b>In Transitions</b></em>' reference list.
	 * The list contents are of type {@link hu.bme.mit.incquery.cep.metamodels.internalsm.Transition}.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Transition#getPostState <em>Post State</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Transitions</em>' reference list.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getState_InTransitions()
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.Transition#getPostState
	 * @model opposite="postState"
	 * @generated
	 */
	EList<Transition> getInTransitions();

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
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getState_Label()
	 * @model
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.State#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Event Tokens</b></em>' reference list.
	 * The list contents are of type {@link hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken}.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken#getCurrentState <em>Current State</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Tokens</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Tokens</em>' reference list.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getState_EventTokens()
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken#getCurrentState
	 * @model opposite="currentState"
	 * @generated
	 */
	EList<EventToken> getEventTokens();

	/**
	 * Returns the value of the '<em><b>Time Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Constraints</em>' containment reference list.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getState_TimeConstraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<TimeConstraint> getTimeConstraints();

} // State
