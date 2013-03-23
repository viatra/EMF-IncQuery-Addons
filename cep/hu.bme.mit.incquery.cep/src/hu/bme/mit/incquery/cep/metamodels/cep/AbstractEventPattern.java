/**
 */
package hu.bme.mit.incquery.cep.metamodels.cep;

import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Event Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.AbstractEventPattern#getCompositionEvents <em>Composition Events</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.AbstractEventPattern#getStateMachine <em>State Machine</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getAbstractEventPattern()
 * @model abstract="true"
 * @generated
 */
public interface AbstractEventPattern extends EObject {
	/**
	 * Returns the value of the '<em><b>Composition Events</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.incquery.cep.metamodels.cep.AbstractEventPattern}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composition Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composition Events</em>' containment reference list.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getAbstractEventPattern_CompositionEvents()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractEventPattern> getCompositionEvents();

	/**
	 * Returns the value of the '<em><b>State Machine</b></em>' reference list.
	 * The list contents are of type {@link hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine}.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine#getEventPattern <em>Event Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Machine</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Machine</em>' reference list.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getAbstractEventPattern_StateMachine()
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine#getEventPattern
	 * @model opposite="eventPattern"
	 * @generated
	 */
	EList<StateMachine> getStateMachine();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model eventRequired="true"
	 * @generated
	 */
	boolean match(Event event);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isRecognized();

} // AbstractEventPattern
