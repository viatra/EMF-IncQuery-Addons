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
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint#getTimeConstraintSpecification <em>Time Constraint Specification</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getTimeConstraint()
 * @model
 * @generated
 */
public interface TimeConstraint extends EObject {
	/**
	 * Returns the value of the '<em><b>Time Constraint Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Constraint Specification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Constraint Specification</em>' reference.
	 * @see #setTimeConstraintSpecification(TimeConstraintSpecification)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getTimeConstraint_TimeConstraintSpecification()
	 * @model required="true"
	 * @generated
	 */
	TimeConstraintSpecification getTimeConstraintSpecification();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint#getTimeConstraintSpecification <em>Time Constraint Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Constraint Specification</em>' reference.
	 * @see #getTimeConstraintSpecification()
	 * @generated
	 */
	void setTimeConstraintSpecification(TimeConstraintSpecification value);

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

} // TimeConstraint
