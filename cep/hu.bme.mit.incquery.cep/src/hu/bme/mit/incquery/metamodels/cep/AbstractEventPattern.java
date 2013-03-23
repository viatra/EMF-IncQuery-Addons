/**
 */
package hu.bme.mit.incquery.metamodels.cep;

import hu.bme.mit.incquery.metamodels.internalsm.State;

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
 *   <li>{@link hu.bme.mit.incquery.metamodels.cep.AbstractEventPattern#getCompositionEvents <em>Composition Events</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.metamodels.cep.AbstractEventPattern#getCurrentState <em>Current State</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.metamodels.cep.CepPackage#getAbstractEventPattern()
 * @model abstract="true"
 * @generated
 */
public interface AbstractEventPattern extends EObject {
	/**
	 * Returns the value of the '<em><b>Composition Events</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.incquery.metamodels.cep.AbstractEventPattern}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composition Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composition Events</em>' containment reference list.
	 * @see hu.bme.mit.incquery.metamodels.cep.CepPackage#getAbstractEventPattern_CompositionEvents()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractEventPattern> getCompositionEvents();

	/**
	 * Returns the value of the '<em><b>Current State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current State</em>' reference.
	 * @see #setCurrentState(State)
	 * @see hu.bme.mit.incquery.metamodels.cep.CepPackage#getAbstractEventPattern_CurrentState()
	 * @model required="true"
	 * @generated
	 */
	State getCurrentState();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.metamodels.cep.AbstractEventPattern#getCurrentState <em>Current State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current State</em>' reference.
	 * @see #getCurrentState()
	 * @generated
	 */
	void setCurrentState(State value);

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
