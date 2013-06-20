/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm;

import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Guard#getTimeConstraint <em>Time Constraint</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Guard#getEventType <em>Event Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getGuard()
 * @model
 * @generated
 */
public interface Guard extends EObject {
	/**
	 * Returns the value of the '<em><b>Time Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Constraint</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Constraint</em>' containment reference.
	 * @see #setTimeConstraint(TimeConstraint)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getGuard_TimeConstraint()
	 * @model containment="true"
	 * @generated
	 */
	TimeConstraint getTimeConstraint();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Guard#getTimeConstraint <em>Time Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Constraint</em>' containment reference.
	 * @see #getTimeConstraint()
	 * @generated
	 */
	void setTimeConstraint(TimeConstraint value);

	/**
	 * Returns the value of the '<em><b>Event Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Type</em>' reference.
	 * @see #setEventType(AtomicEventPattern)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getGuard_EventType()
	 * @model required="true"
	 * @generated
	 */
	AtomicEventPattern getEventType();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Guard#getEventType <em>Event Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Type</em>' reference.
	 * @see #getEventType()
	 * @generated
	 */
	void setEventType(AtomicEventPattern value);

} // Guard
