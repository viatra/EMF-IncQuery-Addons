/**
 */
package hu.bme.mit.incquery.cep.casestudy.transaction;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.casestudy.transaction.TransactionModel#getLatestComponentEvent <em>Latest Component Event</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.casestudy.transaction.TransactionModel#getLatestCompoundEvent <em>Latest Compound Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.casestudy.transaction.TransactionPackage#getTransactionModel()
 * @model
 * @generated
 */
public interface TransactionModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Latest Component Event</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Latest Component Event</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Latest Component Event</em>' containment reference.
	 * @see #setLatestComponentEvent(Component)
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.TransactionPackage#getTransactionModel_LatestComponentEvent()
	 * @model containment="true"
	 * @generated
	 */
	Component getLatestComponentEvent();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.casestudy.transaction.TransactionModel#getLatestComponentEvent <em>Latest Component Event</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Latest Component Event</em>' containment reference.
	 * @see #getLatestComponentEvent()
	 * @generated
	 */
	void setLatestComponentEvent(Component value);

	/**
	 * Returns the value of the '<em><b>Latest Compound Event</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Latest Compound Event</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Latest Compound Event</em>' containment reference.
	 * @see #setLatestCompoundEvent(CompoundTransactionEvent)
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.TransactionPackage#getTransactionModel_LatestCompoundEvent()
	 * @model containment="true"
	 * @generated
	 */
	CompoundTransactionEvent getLatestCompoundEvent();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.casestudy.transaction.TransactionModel#getLatestCompoundEvent <em>Latest Compound Event</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Latest Compound Event</em>' containment reference.
	 * @see #getLatestCompoundEvent()
	 * @generated
	 */
	void setLatestCompoundEvent(CompoundTransactionEvent value);

} // TransactionModel
