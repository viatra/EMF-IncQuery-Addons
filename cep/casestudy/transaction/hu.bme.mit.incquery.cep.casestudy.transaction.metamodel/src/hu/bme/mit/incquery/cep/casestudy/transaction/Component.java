/**
 */
package hu.bme.mit.incquery.cep.casestudy.transaction;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.casestudy.transaction.Component#getTransactionId <em>Transaction Id</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.casestudy.transaction.Component#getTimestamp <em>Timestamp</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.casestudy.transaction.TransactionPackage#getComponent()
 * @model
 * @generated
 */
public interface Component extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Transaction Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transaction Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transaction Id</em>' attribute.
	 * @see #setTransactionId(String)
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.TransactionPackage#getComponent_TransactionId()
	 * @model required="true"
	 * @generated
	 */
	String getTransactionId();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.casestudy.transaction.Component#getTransactionId <em>Transaction Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transaction Id</em>' attribute.
	 * @see #getTransactionId()
	 * @generated
	 */
	void setTransactionId(String value);

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
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.TransactionPackage#getComponent_Timestamp()
	 * @model
	 * @generated
	 */
	long getTimestamp();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.casestudy.transaction.Component#getTimestamp <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timestamp</em>' attribute.
	 * @see #getTimestamp()
	 * @generated
	 */
	void setTimestamp(long value);

} // Component
