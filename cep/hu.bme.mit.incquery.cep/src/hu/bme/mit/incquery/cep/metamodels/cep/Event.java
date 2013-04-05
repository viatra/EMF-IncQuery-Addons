/**
 */
package hu.bme.mit.incquery.cep.metamodels.cep;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.Event#getTypeId <em>Type Id</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.Event#getTimestamp <em>Timestamp</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.Event#getEventSource <em>Event Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getEvent()
 * @model
 * @generated
 */
public interface Event extends EObject {
	/**
	 * Returns the value of the '<em><b>Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Id</em>' attribute.
	 * @see #setTypeId(String)
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getEvent_TypeId()
	 * @model required="true"
	 * @generated
	 */
	String getTypeId();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.cep.Event#getTypeId <em>Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Id</em>' attribute.
	 * @see #getTypeId()
	 * @generated
	 */
	void setTypeId(String value);

	/**
	 * Returns the value of the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timestamp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timestamp</em>' attribute.
	 * @see #setTimestamp(long)
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getEvent_Timestamp()
	 * @model required="true"
	 * @generated
	 */
	long getTimestamp();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.cep.Event#getTimestamp <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timestamp</em>' attribute.
	 * @see #getTimestamp()
	 * @generated
	 */
	void setTimestamp(long value);

	/**
	 * Returns the value of the '<em><b>Event Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Source</em>' reference.
	 * @see #setEventSource(IEventSource)
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getEvent_EventSource()
	 * @model
	 * @generated
	 */
	IEventSource getEventSource();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.cep.Event#getEventSource <em>Event Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Source</em>' reference.
	 * @see #getEventSource()
	 * @generated
	 */
	void setEventSource(IEventSource value);

} // Event
