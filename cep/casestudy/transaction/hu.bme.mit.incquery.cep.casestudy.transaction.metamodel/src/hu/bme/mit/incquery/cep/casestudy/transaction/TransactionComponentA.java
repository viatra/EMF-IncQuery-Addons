/**
 */
package hu.bme.mit.incquery.cep.casestudy.transaction;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component A</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.casestudy.transaction.TransactionComponentA#getCustomerId <em>Customer Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.casestudy.transaction.TransactionPackage#getTransactionComponentA()
 * @model
 * @generated
 */
public interface TransactionComponentA extends Component {
	/**
	 * Returns the value of the '<em><b>Customer Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customer Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customer Id</em>' attribute.
	 * @see #setCustomerId(String)
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.TransactionPackage#getTransactionComponentA_CustomerId()
	 * @model required="true"
	 * @generated
	 */
	String getCustomerId();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.casestudy.transaction.TransactionComponentA#getCustomerId <em>Customer Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Customer Id</em>' attribute.
	 * @see #getCustomerId()
	 * @generated
	 */
	void setCustomerId(String value);

} // TransactionComponentA
