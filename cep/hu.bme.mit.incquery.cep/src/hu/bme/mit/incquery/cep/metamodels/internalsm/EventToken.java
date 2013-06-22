/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Token</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken#getCurrentState <em>Current State</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken#getEventCollection <em>Event Collection</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getEventToken()
 * @model
 * @generated
 */
public interface EventToken extends EObject {
	/**
	 * Returns the value of the '<em><b>Current State</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.State#getEventTokens <em>Event Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current State</em>' reference.
	 * @see #setCurrentState(State)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getEventToken_CurrentState()
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.State#getEventTokens
	 * @model opposite="eventTokens"
	 * @generated
	 */
	State getCurrentState();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken#getCurrentState <em>Current State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current State</em>' reference.
	 * @see #getCurrentState()
	 * @generated
	 */
	void setCurrentState(State value);

	/**
	 * Returns the value of the '<em><b>Event Collection</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.EventCollection#getEventToken <em>Event Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Collection</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Collection</em>' containment reference.
	 * @see #setEventCollection(EventCollection)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getEventToken_EventCollection()
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.EventCollection#getEventToken
	 * @model opposite="eventToken" containment="true"
	 * @generated
	 */
	EventCollection getEventCollection();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken#getEventCollection <em>Event Collection</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Collection</em>' containment reference.
	 * @see #getEventCollection()
	 * @generated
	 */
	void setEventCollection(EventCollection value);

} // EventToken
