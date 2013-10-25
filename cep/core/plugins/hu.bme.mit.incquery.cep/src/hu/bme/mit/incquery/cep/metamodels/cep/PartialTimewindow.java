/**
 */
package hu.bme.mit.incquery.cep.metamodels.cep;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Partial Timewindow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.PartialTimewindow#getStopEvent <em>Stop Event</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.PartialTimewindow#getCheckEvents <em>Check Events</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.PartialTimewindow#getStartEvent <em>Start Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getPartialTimewindow()
 * @model
 * @generated
 */
public interface PartialTimewindow extends Timewindow {
	/**
	 * Returns the value of the '<em><b>Stop Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stop Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stop Event</em>' reference.
	 * @see #setStopEvent(EventPattern)
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getPartialTimewindow_StopEvent()
	 * @model required="true"
	 * @generated
	 */
	EventPattern getStopEvent();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.cep.PartialTimewindow#getStopEvent <em>Stop Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stop Event</em>' reference.
	 * @see #getStopEvent()
	 * @generated
	 */
	void setStopEvent(EventPattern value);

	/**
	 * Returns the value of the '<em><b>Check Events</b></em>' reference list.
	 * The list contents are of type {@link hu.bme.mit.incquery.cep.metamodels.cep.EventPattern}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Check Events</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Check Events</em>' reference list.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getPartialTimewindow_CheckEvents()
	 * @model
	 * @generated
	 */
	EList<EventPattern> getCheckEvents();

	/**
	 * Returns the value of the '<em><b>Start Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Event</em>' reference.
	 * @see #setStartEvent(EventPattern)
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getPartialTimewindow_StartEvent()
	 * @model required="true"
	 * @generated
	 */
	EventPattern getStartEvent();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.cep.PartialTimewindow#getStartEvent <em>Start Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Event</em>' reference.
	 * @see #getStartEvent()
	 * @generated
	 */
	void setStartEvent(EventPattern value);

} // PartialTimewindow
