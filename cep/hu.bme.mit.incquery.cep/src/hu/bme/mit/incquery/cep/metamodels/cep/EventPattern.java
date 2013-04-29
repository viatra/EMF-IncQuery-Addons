/**
 */
package hu.bme.mit.incquery.cep.metamodels.cep;

import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.EventPattern#getCompositionEvents <em>Composition Events</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.EventPattern#getStateMachines <em>State Machines</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.EventPattern#getId <em>Id</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.EventPattern#getHoldingTime <em>Holding Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getEventPattern()
 * @model abstract="true"
 * @generated
 */
public interface EventPattern extends EObject {
	/**
	 * Returns the value of the '<em><b>Composition Events</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.incquery.cep.metamodels.cep.EventPattern}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composition Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composition Events</em>' containment reference list.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getEventPattern_CompositionEvents()
	 * @model containment="true"
	 * @generated
	 */
	EList<EventPattern> getCompositionEvents();
	
	/**
	 * Returns the value of the '<em><b>State Machines</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine#getEventPattern <em>Event Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Machines</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Machines</em>' reference.
	 * @see #setStateMachines(StateMachine)
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getEventPattern_StateMachines()
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine#getEventPattern
	 * @model opposite="eventPattern"
	 * @generated
	 */
	StateMachine getStateMachines();
	
	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.cep.EventPattern#getStateMachines <em>State Machines</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Machines</em>' reference.
	 * @see #getStateMachines()
	 * @generated
	 */
	void setStateMachines(StateMachine value);
	
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getEventPattern_Id()
	 * @model
	 * @generated
	 */
	String getId();
	
	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.cep.EventPattern#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Holding Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Holding Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Holding Time</em>' attribute.
	 * @see #setHoldingTime(long)
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getEventPattern_HoldingTime()
	 * @model
	 * @generated
	 */
	long getHoldingTime();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.cep.EventPattern#getHoldingTime <em>Holding Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Holding Time</em>' attribute.
	 * @see #getHoldingTime()
	 * @generated
	 */
	void setHoldingTime(long value);
	
} // EventPattern
