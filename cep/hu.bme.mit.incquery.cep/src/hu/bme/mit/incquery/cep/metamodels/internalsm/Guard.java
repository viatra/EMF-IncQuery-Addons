/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm;

import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.cep.Timewindow;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Guard#getEventType <em>Event Type</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Guard#getTimewindow <em>Timewindow</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getGuard()
 * @model
 * @generated
 */
public interface Guard extends EObject {
	/**
	 * Returns the value of the '<em><b>Event Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Type</em>' attribute.
	 * @see #setEventType(Class)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getGuard_EventType()
	 * @model
	 * @generated
	 */
	Class<? extends Event> getEventType();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Guard#getEventType <em>Event Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Type</em>' attribute.
	 * @see #getEventType()
	 * @generated
	 */
	void setEventType(Class<? extends Event> value);

	/**
	 * Returns the value of the '<em><b>Timewindow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timewindow</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timewindow</em>' containment reference.
	 * @see #setTimewindow(Timewindow)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getGuard_Timewindow()
	 * @model containment="true"
	 * @generated
	 */
	Timewindow getTimewindow();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Guard#getTimewindow <em>Timewindow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timewindow</em>' containment reference.
	 * @see #getTimewindow()
	 * @generated
	 */
	void setTimewindow(Timewindow value);

} // Guard
