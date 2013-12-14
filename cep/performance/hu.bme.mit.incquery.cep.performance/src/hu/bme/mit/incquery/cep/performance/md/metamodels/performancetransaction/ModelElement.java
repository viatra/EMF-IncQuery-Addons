/**
 */
package hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.ModelElement#getTransactionId <em>Transaction Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionPackage#getModelElement()
 * @model
 * @generated
 */
public interface ModelElement extends EObject {
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
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionPackage#getModelElement_TransactionId()
	 * @model
	 * @generated
	 */
	String getTransactionId();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.ModelElement#getTransactionId <em>Transaction Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transaction Id</em>' attribute.
	 * @see #getTransactionId()
	 * @generated
	 */
	void setTransactionId(String value);

} // ModelElement
