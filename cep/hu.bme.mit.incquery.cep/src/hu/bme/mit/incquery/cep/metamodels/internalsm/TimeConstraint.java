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
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint#getExpectedLength <em>Expected Length</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint#getStartState <em>Start State</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint#getStopState <em>Stop State</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint#getStartTimeStamp <em>Start Time Stamp</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint#getStopTimeStamp <em>Stop Time Stamp</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint#getIntermediateState <em>Intermediate State</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getTimeConstraint()
 * @model
 * @generated
 */
public interface TimeConstraint extends EObject {
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
	 * Returns the value of the '<em><b>Start State</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.State#getStartConstraints <em>Start Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start State</em>' reference.
	 * @see #setStartState(State)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getTimeConstraint_StartState()
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.State#getStartConstraints
	 * @model opposite="startConstraints" required="true"
	 * @generated
	 */
	State getStartState();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint#getStartState <em>Start State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start State</em>' reference.
	 * @see #getStartState()
	 * @generated
	 */
	void setStartState(State value);

	/**
	 * Returns the value of the '<em><b>Stop State</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.State#getStopConstraints <em>Stop Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stop State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stop State</em>' reference.
	 * @see #setStopState(State)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getTimeConstraint_StopState()
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.State#getStopConstraints
	 * @model opposite="stopConstraints" required="true"
	 * @generated
	 */
	State getStopState();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint#getStopState <em>Stop State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stop State</em>' reference.
	 * @see #getStopState()
	 * @generated
	 */
	void setStopState(State value);

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
	 * Returns the value of the '<em><b>Intermediate State</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.State#getIntermediateConstraints <em>Intermediate Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intermediate State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate State</em>' reference.
	 * @see #setIntermediateState(State)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getTimeConstraint_IntermediateState()
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.State#getIntermediateConstraints
	 * @model opposite="intermediateConstraints"
	 * @generated
	 */
	State getIntermediateState();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint#getIntermediateState <em>Intermediate State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intermediate State</em>' reference.
	 * @see #getIntermediateState()
	 * @generated
	 */
	void setIntermediateState(State value);

} // TimeConstraint
