/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm;

import hu.bme.mit.incquery.cep.metamodels.cep.Event;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.EventCollection#getEventToken <em>Event Token</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getEventCollection()
 * @model abstract="true"
 * @generated
 */
public interface EventCollection extends EObject {
	/**
	 * Returns the value of the '<em><b>Event Token</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken#getEventCollection <em>Event Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Token</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Token</em>' container reference.
	 * @see #setEventToken(EventToken)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getEventCollection_EventToken()
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken#getEventCollection
	 * @model opposite="eventCollection" required="true" transient="false"
	 * @generated
	 */
	EventToken getEventToken();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.EventCollection#getEventToken <em>Event Token</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Token</em>' container reference.
	 * @see #getEventToken()
	 * @generated
	 */
	void setEventToken(EventToken value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	Object getRecordedEvents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addEvent(Event event);

} // EventCollection
