/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm.impl;

import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TimeConstraintImpl#getId <em>Id</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TimeConstraintImpl#getType <em>Type</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TimeConstraintImpl#getExpectedLength <em>Expected Length</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TimeConstraintImpl#getStartTimeStamp <em>Start Time Stamp</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TimeConstraintImpl#getStopTimeStamp <em>Stop Time Stamp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimeConstraintImpl extends EObjectImpl implements TimeConstraint {
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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final TimeConstraintType TYPE_EDEFAULT = TimeConstraintType.START;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected TimeConstraintType type = TYPE_EDEFAULT;

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
	 * The default value of the '{@link #getStartTimeStamp() <em>Start Time Stamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartTimeStamp()
	 * @generated
	 * @ordered
	 */
	protected static final long START_TIME_STAMP_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getStartTimeStamp() <em>Start Time Stamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartTimeStamp()
	 * @generated
	 * @ordered
	 */
	protected long startTimeStamp = START_TIME_STAMP_EDEFAULT;

	/**
	 * The default value of the '{@link #getStopTimeStamp() <em>Stop Time Stamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStopTimeStamp()
	 * @generated
	 * @ordered
	 */
	protected static final long STOP_TIME_STAMP_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getStopTimeStamp() <em>Stop Time Stamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStopTimeStamp()
	 * @generated
	 * @ordered
	 */
	protected long stopTimeStamp = STOP_TIME_STAMP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InternalsmPackage.Literals.TIME_CONSTRAINT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.TIME_CONSTRAINT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeConstraintType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(TimeConstraintType newType) {
		TimeConstraintType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.TIME_CONSTRAINT__TYPE, oldType, type));
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
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.TIME_CONSTRAINT__EXPECTED_LENGTH, oldExpectedLength, expectedLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getStartTimeStamp() {
		return startTimeStamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartTimeStamp(long newStartTimeStamp) {
		long oldStartTimeStamp = startTimeStamp;
		startTimeStamp = newStartTimeStamp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.TIME_CONSTRAINT__START_TIME_STAMP, oldStartTimeStamp, startTimeStamp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getStopTimeStamp() {
		return stopTimeStamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStopTimeStamp(long newStopTimeStamp) {
		long oldStopTimeStamp = stopTimeStamp;
		stopTimeStamp = newStopTimeStamp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.TIME_CONSTRAINT__STOP_TIME_STAMP, oldStopTimeStamp, stopTimeStamp));
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
			case InternalsmPackage.TIME_CONSTRAINT__ID:
				return getId();
			case InternalsmPackage.TIME_CONSTRAINT__TYPE:
				return getType();
			case InternalsmPackage.TIME_CONSTRAINT__EXPECTED_LENGTH:
				return getExpectedLength();
			case InternalsmPackage.TIME_CONSTRAINT__START_TIME_STAMP:
				return getStartTimeStamp();
			case InternalsmPackage.TIME_CONSTRAINT__STOP_TIME_STAMP:
				return getStopTimeStamp();
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
			case InternalsmPackage.TIME_CONSTRAINT__ID:
				setId((String)newValue);
				return;
			case InternalsmPackage.TIME_CONSTRAINT__TYPE:
				setType((TimeConstraintType)newValue);
				return;
			case InternalsmPackage.TIME_CONSTRAINT__EXPECTED_LENGTH:
				setExpectedLength((Long)newValue);
				return;
			case InternalsmPackage.TIME_CONSTRAINT__START_TIME_STAMP:
				setStartTimeStamp((Long)newValue);
				return;
			case InternalsmPackage.TIME_CONSTRAINT__STOP_TIME_STAMP:
				setStopTimeStamp((Long)newValue);
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
			case InternalsmPackage.TIME_CONSTRAINT__ID:
				setId(ID_EDEFAULT);
				return;
			case InternalsmPackage.TIME_CONSTRAINT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case InternalsmPackage.TIME_CONSTRAINT__EXPECTED_LENGTH:
				setExpectedLength(EXPECTED_LENGTH_EDEFAULT);
				return;
			case InternalsmPackage.TIME_CONSTRAINT__START_TIME_STAMP:
				setStartTimeStamp(START_TIME_STAMP_EDEFAULT);
				return;
			case InternalsmPackage.TIME_CONSTRAINT__STOP_TIME_STAMP:
				setStopTimeStamp(STOP_TIME_STAMP_EDEFAULT);
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
			case InternalsmPackage.TIME_CONSTRAINT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case InternalsmPackage.TIME_CONSTRAINT__TYPE:
				return type != TYPE_EDEFAULT;
			case InternalsmPackage.TIME_CONSTRAINT__EXPECTED_LENGTH:
				return expectedLength != EXPECTED_LENGTH_EDEFAULT;
			case InternalsmPackage.TIME_CONSTRAINT__START_TIME_STAMP:
				return startTimeStamp != START_TIME_STAMP_EDEFAULT;
			case InternalsmPackage.TIME_CONSTRAINT__STOP_TIME_STAMP:
				return stopTimeStamp != STOP_TIME_STAMP_EDEFAULT;
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
		result.append(", type: ");
		result.append(type);
		result.append(", expectedLength: ");
		result.append(expectedLength);
		result.append(", startTimeStamp: ");
		result.append(startTimeStamp);
		result.append(", stopTimeStamp: ");
		result.append(stopTimeStamp);
		result.append(')');
		return result.toString();
	}

} //TimeConstraintImpl
