/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint#getId <em>Id</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint#getType <em>Type</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint#getExpectedLength <em>Expected Length</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint#getStartTimeStamp <em>Start Time Stamp</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint#getStopTimeStamp <em>Stop Time Stamp</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getTimeConstraint()
 * @model
 * @generated
 */
public interface TimeConstraint extends EObject {
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
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getTimeConstraint_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintType
	 * @see #setType(TimeConstraintType)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getTimeConstraint_Type()
	 * @model
	 * @generated
	 */
	TimeConstraintType getType();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintType
	 * @see #getType()
	 * @generated
	 */
	void setType(TimeConstraintType value);

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
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getTimeConstraint_ExpectedLength()
	 * @model required="true"
	 * @generated
	 */
	long getExpectedLength();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint#getExpectedLength <em>Expected Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expected Length</em>' attribute.
	 * @see #getExpectedLength()
	 * @generated
	 */
	void setExpectedLength(long value);

	/**
	 * Returns the value of the '<em><b>Start Time Stamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Time Stamp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Time Stamp</em>' attribute.
	 * @see #setStartTimeStamp(long)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getTimeConstraint_StartTimeStamp()
	 * @model
	 * @generated
	 */
	long getStartTimeStamp();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint#getStartTimeStamp <em>Start Time Stamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Time Stamp</em>' attribute.
	 * @see #getStartTimeStamp()
	 * @generated
	 */
	void setStartTimeStamp(long value);

	/**
	 * Returns the value of the '<em><b>Stop Time Stamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stop Time Stamp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stop Time Stamp</em>' attribute.
	 * @see #setStopTimeStamp(long)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getTimeConstraint_StopTimeStamp()
	 * @model
	 * @generated
	 */
	long getStopTimeStamp();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint#getStopTimeStamp <em>Stop Time Stamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stop Time Stamp</em>' attribute.
	 * @see #getStopTimeStamp()
	 * @generated
	 */
	void setStopTimeStamp(long value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void handleTimeConstraint();

} // TimeConstraint
