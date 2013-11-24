/**
 */
package hu.bme.mit.incquery.cep.casestudy.transaction.impl;

import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionComponentC;
import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component C</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.casestudy.transaction.impl.TransactionComponentCImpl#getSupplierId <em>Supplier Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransactionComponentCImpl extends ComponentImpl implements TransactionComponentC {
	/**
	 * The default value of the '{@link #getSupplierId() <em>Supplier Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupplierId()
	 * @generated
	 * @ordered
	 */
	protected static final String SUPPLIER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSupplierId() <em>Supplier Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupplierId()
	 * @generated
	 * @ordered
	 */
	protected String supplierId = SUPPLIER_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransactionComponentCImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TransactionPackage.Literals.TRANSACTION_COMPONENT_C;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSupplierId() {
		return supplierId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupplierId(String newSupplierId) {
		String oldSupplierId = supplierId;
		supplierId = newSupplierId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransactionPackage.TRANSACTION_COMPONENT_C__SUPPLIER_ID, oldSupplierId, supplierId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TransactionPackage.TRANSACTION_COMPONENT_C__SUPPLIER_ID:
				return getSupplierId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TransactionPackage.TRANSACTION_COMPONENT_C__SUPPLIER_ID:
				setSupplierId((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TransactionPackage.TRANSACTION_COMPONENT_C__SUPPLIER_ID:
				setSupplierId(SUPPLIER_ID_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TransactionPackage.TRANSACTION_COMPONENT_C__SUPPLIER_ID:
				return SUPPLIER_ID_EDEFAULT == null ? supplierId != null : !SUPPLIER_ID_EDEFAULT.equals(supplierId);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (supplierId: ");
		result.append(supplierId);
		result.append(')');
		return result.toString();
	}

} //TransactionComponentCImpl
