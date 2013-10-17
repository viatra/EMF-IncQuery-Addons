/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm;

import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine#getStates <em>States</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine#getEventPattern <em>Event Pattern</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine#getPriority <em>Priority</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine#getContext <em>Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getStateMachine()
 * @model
 * @generated
 */
public interface StateMachine extends EObject {
	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.incquery.cep.metamodels.internalsm.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getStateMachine_States()
	 * @model containment="true"
	 * @generated
	 */
	EList<State> getStates();

	/**
	 * Returns the value of the '<em><b>Event Pattern</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.cep.metamodels.cep.EventPattern#getStateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Pattern</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Pattern</em>' reference.
	 * @see #setEventPattern(EventPattern)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getStateMachine_EventPattern()
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.EventPattern#getStateMachine
	 * @model opposite="stateMachine" required="true"
	 * @generated
	 */
	EventPattern getEventPattern();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine#getEventPattern <em>Event Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Pattern</em>' reference.
	 * @see #getEventPattern()
	 * @generated
	 */
	void setEventPattern(EventPattern value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(int)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getStateMachine_Priority()
	 * @model
	 * @generated
	 */
	int getPriority();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(int value);

	/**
	 * Returns the value of the '<em><b>Context</b></em>' attribute.
	 * The literals are from the enumeration {@link hu.bme.mit.incquery.cep.metamodels.internalsm.EventProcessingContext}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' attribute.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.EventProcessingContext
	 * @see #setContext(EventProcessingContext)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getStateMachine_Context()
	 * @model
	 * @generated
	 */
	EventProcessingContext getContext();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine#getContext <em>Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' attribute.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.EventProcessingContext
	 * @see #getContext()
	 * @generated
	 */
	void setContext(EventProcessingContext value);

} // StateMachine
