/**
 */
package hu.bme.mit.incquery.cep.casestudy.transaction;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compound Transaction Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent#getTimestamp <em>Timestamp</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.casestudy.transaction.TransactionPackage#getCompoundTransactionEvent()
 * @model
 * @generated
 */
public interface CompoundTransactionEvent extends EObject {
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
     * @see hu.bme.mit.incquery.cep.casestudy.transaction.TransactionPackage#getCompoundTransactionEvent_Timestamp()
     * @model
     * @generated
     */
    long getTimestamp();

    /**
     * Sets the value of the '{@link hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent#getTimestamp <em>Timestamp</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Timestamp</em>' attribute.
     * @see #getTimestamp()
     * @generated
     */
    void setTimestamp(long value);

} // CompoundTransactionEvent
