/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Constraint Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintSpecification#getId <em>Id</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintSpecification#getExpectedLength <em>Expected Length</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintSpecification#getStartTimestamp <em>Start Timestamp</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintSpecification#getStopTimestamp <em>Stop Timestamp</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getTimeConstraintSpecification()
 * @model
 * @generated
 */
public interface TimeConstraintSpecification extends EObject {
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
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getTimeConstraintSpecification_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintSpecification#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Expected Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expected Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expected Length</em>' attribute.
	 * @see #setExpectedLength(long)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getTimeConstraintSpecification_ExpectedLength()
	 * @model required="true"
	 * @generated
	 */
	long getExpectedLength();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintSpecification#getExpectedLength <em>Expected Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expected Length</em>' attribute.
	 * @see #getExpectedLength()
	 * @generated
	 */
	void setExpectedLength(long value);

	/**
	 * Returns the value of the '<em><b>Start Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Timestamp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Timestamp</em>' attribute.
	 * @see #setStartTimestamp(long)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getTimeConstraintSpecification_StartTimestamp()
	 * @model
	 * @generated
	 */
	long getStartTimestamp();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintSpecification#getStartTimestamp <em>Start Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Timestamp</em>' attribute.
	 * @see #getStartTimestamp()
	 * @generated
	 */
	void setStartTimestamp(long value);

	/**
	 * Returns the value of the '<em><b>Stop Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stop Timestamp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stop Timestamp</em>' attribute.
	 * @see #setStopTimestamp(long)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getTimeConstraintSpecification_StopTimestamp()
	 * @model
	 * @generated
	 */
	long getStopTimestamp();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintSpecification#getStopTimestamp <em>Stop Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stop Timestamp</em>' attribute.
	 * @see #getStopTimestamp()
	 * @generated
	 */
	void setStopTimestamp(long value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void handleTimeConstraint();

} // TimeConstraintSpecification
