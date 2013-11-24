/**
 */
package hu.bme.mit.incquery.cep.casestudy.transaction;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compound Transaction Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent#getCustomerId <em>Customer Id</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent#getTimestampA <em>Timestamp A</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent#getTimestampB <em>Timestamp B</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent#getTimestampC <em>Timestamp C</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.casestudy.transaction.TransactionPackage#getCompoundTransactionEvent()
 * @model
 * @generated
 */
public interface CompoundTransactionEvent extends ModelElement {
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
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.TransactionPackage#getCompoundTransactionEvent_CustomerId()
	 * @model required="true"
	 * @generated
	 */
	String getCustomerId();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent#getCustomerId <em>Customer Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Customer Id</em>' attribute.
	 * @see #getCustomerId()
	 * @generated
	 */
	void setCustomerId(String value);

	/**
	 * Returns the value of the '<em><b>Timestamp A</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timestamp A</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timestamp A</em>' attribute.
	 * @see #setTimestampA(long)
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.TransactionPackage#getCompoundTransactionEvent_TimestampA()
	 * @model required="true"
	 * @generated
	 */
	long getTimestampA();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent#getTimestampA <em>Timestamp A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timestamp A</em>' attribute.
	 * @see #getTimestampA()
	 * @generated
	 */
	void setTimestampA(long value);

	/**
	 * Returns the value of the '<em><b>Timestamp B</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timestamp B</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timestamp B</em>' attribute.
	 * @see #setTimestampB(long)
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.TransactionPackage#getCompoundTransactionEvent_TimestampB()
	 * @model required="true"
	 * @generated
	 */
	long getTimestampB();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent#getTimestampB <em>Timestamp B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timestamp B</em>' attribute.
	 * @see #getTimestampB()
	 * @generated
	 */
	void setTimestampB(long value);

	/**
	 * Returns the value of the '<em><b>Timestamp C</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timestamp C</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timestamp C</em>' attribute.
	 * @see #setTimestampC(long)
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.TransactionPackage#getCompoundTransactionEvent_TimestampC()
	 * @model required="true"
	 * @generated
	 */
	long getTimestampC();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent#getTimestampC <em>Timestamp C</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timestamp C</em>' attribute.
	 * @see #getTimestampC()
	 * @generated
	 */
	void setTimestampC(long value);

} // CompoundTransactionEvent
