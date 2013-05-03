/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm.impl;

import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TimeConstraintImpl#getExpectedLength <em>Expected Length</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TimeConstraintImpl#getStartState <em>Start State</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TimeConstraintImpl#getStopState <em>Stop State</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TimeConstraintImpl#getStartTimeStamp <em>Start Time Stamp</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TimeConstraintImpl#getStopTimeStamp <em>Stop Time Stamp</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TimeConstraintImpl#getIntermediateState <em>Intermediate State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimeConstraintImpl extends EObjectImpl implements TimeConstraint {
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
	 * The cached value of the '{@link #getStartState() <em>Start State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartState()
	 * @generated
	 * @ordered
	 */
	protected State startState;

	/**
	 * The cached value of the '{@link #getStopState() <em>Stop State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStopState()
	 * @generated
	 * @ordered
	 */
	protected State stopState;

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
	 * The cached value of the '{@link #getIntermediateState() <em>Intermediate State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediateState()
	 * @generated
	 * @ordered
	 */
	protected State intermediateState;

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
	public State getStartState() {
		if (startState != null && startState.eIsProxy()) {
			InternalEObject oldStartState = (InternalEObject)startState;
			startState = (State)eResolveProxy(oldStartState);
			if (startState != oldStartState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InternalsmPackage.TIME_CONSTRAINT__START_STATE, oldStartState, startState));
			}
		}
		return startState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetStartState() {
		return startState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStartState(State newStartState, NotificationChain msgs) {
		State oldStartState = startState;
		startState = newStartState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InternalsmPackage.TIME_CONSTRAINT__START_STATE, oldStartState, newStartState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartState(State newStartState) {
		if (newStartState != startState) {
			NotificationChain msgs = null;
			if (startState != null)
				msgs = ((InternalEObject)startState).eInverseRemove(this, InternalsmPackage.STATE__START_CONSTRAINTS, State.class, msgs);
			if (newStartState != null)
				msgs = ((InternalEObject)newStartState).eInverseAdd(this, InternalsmPackage.STATE__START_CONSTRAINTS, State.class, msgs);
			msgs = basicSetStartState(newStartState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.TIME_CONSTRAINT__START_STATE, newStartState, newStartState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getStopState() {
		if (stopState != null && stopState.eIsProxy()) {
			InternalEObject oldStopState = (InternalEObject)stopState;
			stopState = (State)eResolveProxy(oldStopState);
			if (stopState != oldStopState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InternalsmPackage.TIME_CONSTRAINT__STOP_STATE, oldStopState, stopState));
			}
		}
		return stopState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetStopState() {
		return stopState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStopState(State newStopState, NotificationChain msgs) {
		State oldStopState = stopState;
		stopState = newStopState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InternalsmPackage.TIME_CONSTRAINT__STOP_STATE, oldStopState, newStopState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStopState(State newStopState) {
		if (newStopState != stopState) {
			NotificationChain msgs = null;
			if (stopState != null)
				msgs = ((InternalEObject)stopState).eInverseRemove(this, InternalsmPackage.STATE__STOP_CONSTRAINTS, State.class, msgs);
			if (newStopState != null)
				msgs = ((InternalEObject)newStopState).eInverseAdd(this, InternalsmPackage.STATE__STOP_CONSTRAINTS, State.class, msgs);
			msgs = basicSetStopState(newStopState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.TIME_CONSTRAINT__STOP_STATE, newStopState, newStopState));
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
	public State getIntermediateState() {
		if (intermediateState != null && intermediateState.eIsProxy()) {
			InternalEObject oldIntermediateState = (InternalEObject)intermediateState;
			intermediateState = (State)eResolveProxy(oldIntermediateState);
			if (intermediateState != oldIntermediateState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InternalsmPackage.TIME_CONSTRAINT__INTERMEDIATE_STATE, oldIntermediateState, intermediateState));
			}
		}
		return intermediateState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetIntermediateState() {
		return intermediateState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIntermediateState(State newIntermediateState, NotificationChain msgs) {
		State oldIntermediateState = intermediateState;
		intermediateState = newIntermediateState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InternalsmPackage.TIME_CONSTRAINT__INTERMEDIATE_STATE, oldIntermediateState, newIntermediateState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntermediateState(State newIntermediateState) {
		if (newIntermediateState != intermediateState) {
			NotificationChain msgs = null;
			if (intermediateState != null)
				msgs = ((InternalEObject)intermediateState).eInverseRemove(this, InternalsmPackage.STATE__INTERMEDIATE_CONSTRAINTS, State.class, msgs);
			if (newIntermediateState != null)
				msgs = ((InternalEObject)newIntermediateState).eInverseAdd(this, InternalsmPackage.STATE__INTERMEDIATE_CONSTRAINTS, State.class, msgs);
			msgs = basicSetIntermediateState(newIntermediateState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.TIME_CONSTRAINT__INTERMEDIATE_STATE, newIntermediateState, newIntermediateState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InternalsmPackage.TIME_CONSTRAINT__START_STATE:
				if (startState != null)
					msgs = ((InternalEObject)startState).eInverseRemove(this, InternalsmPackage.STATE__START_CONSTRAINTS, State.class, msgs);
				return basicSetStartState((State)otherEnd, msgs);
			case InternalsmPackage.TIME_CONSTRAINT__STOP_STATE:
				if (stopState != null)
					msgs = ((InternalEObject)stopState).eInverseRemove(this, InternalsmPackage.STATE__STOP_CONSTRAINTS, State.class, msgs);
				return basicSetStopState((State)otherEnd, msgs);
			case InternalsmPackage.TIME_CONSTRAINT__INTERMEDIATE_STATE:
				if (intermediateState != null)
					msgs = ((InternalEObject)intermediateState).eInverseRemove(this, InternalsmPackage.STATE__INTERMEDIATE_CONSTRAINTS, State.class, msgs);
				return basicSetIntermediateState((State)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InternalsmPackage.TIME_CONSTRAINT__START_STATE:
				return basicSetStartState(null, msgs);
			case InternalsmPackage.TIME_CONSTRAINT__STOP_STATE:
				return basicSetStopState(null, msgs);
			case InternalsmPackage.TIME_CONSTRAINT__INTERMEDIATE_STATE:
				return basicSetIntermediateState(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InternalsmPackage.TIME_CONSTRAINT__EXPECTED_LENGTH:
				return getExpectedLength();
			case InternalsmPackage.TIME_CONSTRAINT__START_STATE:
				if (resolve) return getStartState();
				return basicGetStartState();
			case InternalsmPackage.TIME_CONSTRAINT__STOP_STATE:
				if (resolve) return getStopState();
				return basicGetStopState();
			case InternalsmPackage.TIME_CONSTRAINT__START_TIME_STAMP:
				return getStartTimeStamp();
			case InternalsmPackage.TIME_CONSTRAINT__STOP_TIME_STAMP:
				return getStopTimeStamp();
			case InternalsmPackage.TIME_CONSTRAINT__INTERMEDIATE_STATE:
				if (resolve) return getIntermediateState();
				return basicGetIntermediateState();
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
			case InternalsmPackage.TIME_CONSTRAINT__EXPECTED_LENGTH:
				setExpectedLength((Long)newValue);
				return;
			case InternalsmPackage.TIME_CONSTRAINT__START_STATE:
				setStartState((State)newValue);
				return;
			case InternalsmPackage.TIME_CONSTRAINT__STOP_STATE:
				setStopState((State)newValue);
				return;
			case InternalsmPackage.TIME_CONSTRAINT__START_TIME_STAMP:
				setStartTimeStamp((Long)newValue);
				return;
			case InternalsmPackage.TIME_CONSTRAINT__STOP_TIME_STAMP:
				setStopTimeStamp((Long)newValue);
				return;
			case InternalsmPackage.TIME_CONSTRAINT__INTERMEDIATE_STATE:
				setIntermediateState((State)newValue);
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
			case InternalsmPackage.TIME_CONSTRAINT__EXPECTED_LENGTH:
				setExpectedLength(EXPECTED_LENGTH_EDEFAULT);
				return;
			case InternalsmPackage.TIME_CONSTRAINT__START_STATE:
				setStartState((State)null);
				return;
			case InternalsmPackage.TIME_CONSTRAINT__STOP_STATE:
				setStopState((State)null);
				return;
			case InternalsmPackage.TIME_CONSTRAINT__START_TIME_STAMP:
				setStartTimeStamp(START_TIME_STAMP_EDEFAULT);
				return;
			case InternalsmPackage.TIME_CONSTRAINT__STOP_TIME_STAMP:
				setStopTimeStamp(STOP_TIME_STAMP_EDEFAULT);
				return;
			case InternalsmPackage.TIME_CONSTRAINT__INTERMEDIATE_STATE:
				setIntermediateState((State)null);
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
			case InternalsmPackage.TIME_CONSTRAINT__EXPECTED_LENGTH:
				return expectedLength != EXPECTED_LENGTH_EDEFAULT;
			case InternalsmPackage.TIME_CONSTRAINT__START_STATE:
				return startState != null;
			case InternalsmPackage.TIME_CONSTRAINT__STOP_STATE:
				return stopState != null;
			case InternalsmPackage.TIME_CONSTRAINT__START_TIME_STAMP:
				return startTimeStamp != START_TIME_STAMP_EDEFAULT;
			case InternalsmPackage.TIME_CONSTRAINT__STOP_TIME_STAMP:
				return stopTimeStamp != STOP_TIME_STAMP_EDEFAULT;
			case InternalsmPackage.TIME_CONSTRAINT__INTERMEDIATE_STATE:
				return intermediateState != null;
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
		result.append(" (expectedLength: ");
		result.append(expectedLength);
		result.append(", startTimeStamp: ");
		result.append(startTimeStamp);
		result.append(", stopTimeStamp: ");
		result.append(stopTimeStamp);
		result.append(')');
		return result.toString();
	}

} //TimeConstraintImpl
