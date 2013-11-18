/**
 */
package hu.bme.mit.incquery.cep.casestudy.transaction.impl;

import hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent;
import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compound Transaction Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.casestudy.transaction.impl.CompoundTransactionEventImpl#getTransactionId <em>Transaction Id</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.casestudy.transaction.impl.CompoundTransactionEventImpl#getCustomerId <em>Customer Id</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.casestudy.transaction.impl.CompoundTransactionEventImpl#getTimestampA <em>Timestamp A</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.casestudy.transaction.impl.CompoundTransactionEventImpl#getTimestampB <em>Timestamp B</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.casestudy.transaction.impl.CompoundTransactionEventImpl#getTimestampC <em>Timestamp C</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompoundTransactionEventImpl extends ModelElementImpl implements CompoundTransactionEvent {
	/**
	 * The default value of the '{@link #getTransactionId() <em>Transaction Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransactionId()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSACTION_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransactionId() <em>Transaction Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransactionId()
	 * @generated
	 * @ordered
	 */
	protected String transactionId = TRANSACTION_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getCustomerId() <em>Customer Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomerId()
	 * @generated
	 * @ordered
	 */
	protected static final String CUSTOMER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCustomerId() <em>Customer Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomerId()
	 * @generated
	 * @ordered
	 */
	protected String customerId = CUSTOMER_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimestampA() <em>Timestamp A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimestampA()
	 * @generated
	 * @ordered
	 */
	protected static final long TIMESTAMP_A_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTimestampA() <em>Timestamp A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimestampA()
	 * @generated
	 * @ordered
	 */
	protected long timestampA = TIMESTAMP_A_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimestampB() <em>Timestamp B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimestampB()
	 * @generated
	 * @ordered
	 */
	protected static final long TIMESTAMP_B_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTimestampB() <em>Timestamp B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimestampB()
	 * @generated
	 * @ordered
	 */
	protected long timestampB = TIMESTAMP_B_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimestampC() <em>Timestamp C</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimestampC()
	 * @generated
	 * @ordered
	 */
	protected static final long TIMESTAMP_C_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTimestampC() <em>Timestamp C</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimestampC()
	 * @generated
	 * @ordered
	 */
	protected long timestampC = TIMESTAMP_C_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompoundTransactionEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TransactionPackage.Literals.COMPOUND_TRANSACTION_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransactionId(String newTransactionId) {
		String oldTransactionId = transactionId;
		transactionId = newTransactionId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransactionPackage.COMPOUND_TRANSACTION_EVENT__TRANSACTION_ID, oldTransactionId, transactionId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomerId(String newCustomerId) {
		String oldCustomerId = customerId;
		customerId = newCustomerId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransactionPackage.COMPOUND_TRANSACTION_EVENT__CUSTOMER_ID, oldCustomerId, customerId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTimestampA() {
		return timestampA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimestampA(long newTimestampA) {
		long oldTimestampA = timestampA;
		timestampA = newTimestampA;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransactionPackage.COMPOUND_TRANSACTION_EVENT__TIMESTAMP_A, oldTimestampA, timestampA));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTimestampB() {
		return timestampB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimestampB(long newTimestampB) {
		long oldTimestampB = timestampB;
		timestampB = newTimestampB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransactionPackage.COMPOUND_TRANSACTION_EVENT__TIMESTAMP_B, oldTimestampB, timestampB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTimestampC() {
		return timestampC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimestampC(long newTimestampC) {
		long oldTimestampC = timestampC;
		timestampC = newTimestampC;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransactionPackage.COMPOUND_TRANSACTION_EVENT__TIMESTAMP_C, oldTimestampC, timestampC));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TransactionPackage.COMPOUND_TRANSACTION_EVENT__TRANSACTION_ID:
				return getTransactionId();
			case TransactionPackage.COMPOUND_TRANSACTION_EVENT__CUSTOMER_ID:
				return getCustomerId();
			case TransactionPackage.COMPOUND_TRANSACTION_EVENT__TIMESTAMP_A:
				return getTimestampA();
			case TransactionPackage.COMPOUND_TRANSACTION_EVENT__TIMESTAMP_B:
				return getTimestampB();
			case TransactionPackage.COMPOUND_TRANSACTION_EVENT__TIMESTAMP_C:
				return getTimestampC();
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
			case TransactionPackage.COMPOUND_TRANSACTION_EVENT__TRANSACTION_ID:
				setTransactionId((String)newValue);
				return;
			case TransactionPackage.COMPOUND_TRANSACTION_EVENT__CUSTOMER_ID:
				setCustomerId((String)newValue);
				return;
			case TransactionPackage.COMPOUND_TRANSACTION_EVENT__TIMESTAMP_A:
				setTimestampA((Long)newValue);
				return;
			case TransactionPackage.COMPOUND_TRANSACTION_EVENT__TIMESTAMP_B:
				setTimestampB((Long)newValue);
				return;
			case TransactionPackage.COMPOUND_TRANSACTION_EVENT__TIMESTAMP_C:
				setTimestampC((Long)newValue);
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
			case TransactionPackage.COMPOUND_TRANSACTION_EVENT__TRANSACTION_ID:
				setTransactionId(TRANSACTION_ID_EDEFAULT);
				return;
			case TransactionPackage.COMPOUND_TRANSACTION_EVENT__CUSTOMER_ID:
				setCustomerId(CUSTOMER_ID_EDEFAULT);
				return;
			case TransactionPackage.COMPOUND_TRANSACTION_EVENT__TIMESTAMP_A:
				setTimestampA(TIMESTAMP_A_EDEFAULT);
				return;
			case TransactionPackage.COMPOUND_TRANSACTION_EVENT__TIMESTAMP_B:
				setTimestampB(TIMESTAMP_B_EDEFAULT);
				return;
			case TransactionPackage.COMPOUND_TRANSACTION_EVENT__TIMESTAMP_C:
				setTimestampC(TIMESTAMP_C_EDEFAULT);
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
			case TransactionPackage.COMPOUND_TRANSACTION_EVENT__TRANSACTION_ID:
				return TRANSACTION_ID_EDEFAULT == null ? transactionId != null : !TRANSACTION_ID_EDEFAULT.equals(transactionId);
			case TransactionPackage.COMPOUND_TRANSACTION_EVENT__CUSTOMER_ID:
				return CUSTOMER_ID_EDEFAULT == null ? customerId != null : !CUSTOMER_ID_EDEFAULT.equals(customerId);
			case TransactionPackage.COMPOUND_TRANSACTION_EVENT__TIMESTAMP_A:
				return timestampA != TIMESTAMP_A_EDEFAULT;
			case TransactionPackage.COMPOUND_TRANSACTION_EVENT__TIMESTAMP_B:
				return timestampB != TIMESTAMP_B_EDEFAULT;
			case TransactionPackage.COMPOUND_TRANSACTION_EVENT__TIMESTAMP_C:
				return timestampC != TIMESTAMP_C_EDEFAULT;
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
		result.append(" (transactionId: ");
		result.append(transactionId);
		result.append(", customerId: ");
		result.append(customerId);
		result.append(", timestampA: ");
		result.append(timestampA);
		result.append(", timestampB: ");
		result.append(timestampB);
		result.append(", timestampC: ");
		result.append(timestampC);
		result.append(')');
		return result.toString();
	}

} //CompoundTransactionEventImpl
