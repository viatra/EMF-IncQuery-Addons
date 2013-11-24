/**
 */
package hu.bme.mit.incquery.cep.casestudy.transaction;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component C</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.casestudy.transaction.TransactionComponentC#getSupplierId <em>Supplier Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.casestudy.transaction.TransactionPackage#getTransactionComponentC()
 * @model
 * @generated
 */
public interface TransactionComponentC extends Component {
	/**
	 * Returns the value of the '<em><b>Supplier Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supplier Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supplier Id</em>' attribute.
	 * @see #setSupplierId(String)
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.TransactionPackage#getTransactionComponentC_SupplierId()
	 * @model required="true"
	 * @generated
	 */
	String getSupplierId();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.casestudy.transaction.TransactionComponentC#getSupplierId <em>Supplier Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Supplier Id</em>' attribute.
	 * @see #getSupplierId()
	 * @generated
	 */
	void setSupplierId(String value);

} // TransactionComponentC
