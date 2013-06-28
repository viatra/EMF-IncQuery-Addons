/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm.impl;

import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintSpecification;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Constraint Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TimeConstraintSpecificationImpl#getId <em>Id</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TimeConstraintSpecificationImpl#getExpectedLength <em>Expected Length</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TimeConstraintSpecificationImpl#getStartTimestamp <em>Start Timestamp</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TimeConstraintSpecificationImpl#getStopTimestamp <em>Stop Timestamp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimeConstraintSpecificationImpl extends EObjectImpl implements TimeConstraintSpecification {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getExpectedLength() <em>Expected Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpectedLength()
	 * @generated
	 * @ordered
	 */
	protected static final long EXPECTED_LENGTH_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getExpectedLength() <em>Expected Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpectedLength()
	 * @generated
	 * @ordered
	 */
	protected long expectedLength = EXPECTED_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartTimestamp() <em>Start Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartTimestamp()
	 * @generated
	 * @ordered
	 */
	protected static final long START_TIMESTAMP_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getStartTimestamp() <em>Start Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartTimestamp()
	 * @generated
	 * @ordered
	 */
	protected long startTimestamp = START_TIMESTAMP_EDEFAULT;

	/**
	 * The default value of the '{@link #getStopTimestamp() <em>Stop Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStopTimestamp()
	 * @generated
	 * @ordered
	 */
	protected static final long STOP_TIMESTAMP_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getStopTimestamp() <em>Stop Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStopTimestamp()
	 * @generated
	 * @ordered
	 */
	protected long stopTimestamp = STOP_TIMESTAMP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeConstraintSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InternalsmPackage.Literals.TIME_CONSTRAINT_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.TIME_CONSTRAINT_SPECIFICATION__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getExpectedLength() {
		return expectedLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpectedLength(long newExpectedLength) {
		long oldExpectedLength = expectedLength;
		expectedLength = newExpectedLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.TIME_CONSTRAINT_SPECIFICATION__EXPECTED_LENGTH, oldExpectedLength, expectedLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getStartTimestamp() {
		return startTimestamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartTimestamp(long newStartTimestamp) {
		long oldStartTimestamp = startTimestamp;
		startTimestamp = newStartTimestamp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.TIME_CONSTRAINT_SPECIFICATION__START_TIMESTAMP, oldStartTimestamp, startTimestamp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getStopTimestamp() {
		return stopTimestamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStopTimestamp(long newStopTimestamp) {
		long oldStopTimestamp = stopTimestamp;
		stopTimestamp = newStopTimestamp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.TIME_CONSTRAINT_SPECIFICATION__STOP_TIMESTAMP, oldStopTimestamp, stopTimestamp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void handleTimeConstraint() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InternalsmPackage.TIME_CONSTRAINT_SPECIFICATION__ID:
				return getId();
			case InternalsmPackage.TIME_CONSTRAINT_SPECIFICATION__EXPECTED_LENGTH:
				return getExpectedLength();
			case InternalsmPackage.TIME_CONSTRAINT_SPECIFICATION__START_TIMESTAMP:
				return getStartTimestamp();
			case InternalsmPackage.TIME_CONSTRAINT_SPECIFICATION__STOP_TIMESTAMP:
				return getStopTimestamp();
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
			case InternalsmPackage.TIME_CONSTRAINT_SPECIFICATION__ID:
				setId((String)newValue);
				return;
			case InternalsmPackage.TIME_CONSTRAINT_SPECIFICATION__EXPECTED_LENGTH:
				setExpectedLength((Long)newValue);
				return;
			case InternalsmPackage.TIME_CONSTRAINT_SPECIFICATION__START_TIMESTAMP:
				setStartTimestamp((Long)newValue);
				return;
			case InternalsmPackage.TIME_CONSTRAINT_SPECIFICATION__STOP_TIMESTAMP:
				setStopTimestamp((Long)newValue);
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
			case InternalsmPackage.TIME_CONSTRAINT_SPECIFICATION__ID:
				setId(ID_EDEFAULT);
				return;
			case InternalsmPackage.TIME_CONSTRAINT_SPECIFICATION__EXPECTED_LENGTH:
				setExpectedLength(EXPECTED_LENGTH_EDEFAULT);
				return;
			case InternalsmPackage.TIME_CONSTRAINT_SPECIFICATION__START_TIMESTAMP:
				setStartTimestamp(START_TIMESTAMP_EDEFAULT);
				return;
			case InternalsmPackage.TIME_CONSTRAINT_SPECIFICATION__STOP_TIMESTAMP:
				setStopTimestamp(STOP_TIMESTAMP_EDEFAULT);
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
			case InternalsmPackage.TIME_CONSTRAINT_SPECIFICATION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case InternalsmPackage.TIME_CONSTRAINT_SPECIFICATION__EXPECTED_LENGTH:
				return expectedLength != EXPECTED_LENGTH_EDEFAULT;
			case InternalsmPackage.TIME_CONSTRAINT_SPECIFICATION__START_TIMESTAMP:
				return startTimestamp != START_TIMESTAMP_EDEFAULT;
			case InternalsmPackage.TIME_CONSTRAINT_SPECIFICATION__STOP_TIMESTAMP:
				return stopTimestamp != STOP_TIMESTAMP_EDEFAULT;
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
		result.append(" (id: ");
		result.append(id);
		result.append(", expectedLength: ");
		result.append(expectedLength);
		result.append(", startTimestamp: ");
		result.append(startTimestamp);
		result.append(", stopTimestamp: ");
		result.append(stopTimestamp);
		result.append(')');
		return result.toString();
	}

} //TimeConstraintSpecificationImpl
