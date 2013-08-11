/**
 */
package hu.bme.mit.incquery.cep.metamodels.cep.impl;

import hu.bme.mit.incquery.cep.metamodels.cep.CepPackage;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.EventPatternImpl#getStateMachines <em>State Machines</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.EventPatternImpl#getId <em>Id</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.EventPatternImpl#getHoldingTime <em>Holding Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class EventPatternImpl extends EObjectImpl implements EventPattern {
	/**
	 * The cached value of the '{@link #getStateMachines() <em>State Machines</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateMachines()
	 * @generated
	 * @ordered
	 */
	protected StateMachine stateMachines;

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
	 * The default value of the '{@link #getHoldingTime() <em>Holding Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHoldingTime()
	 * @generated
	 * @ordered
	 */
	protected static final long HOLDING_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getHoldingTime() <em>Holding Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHoldingTime()
	 * @generated
	 * @ordered
	 */
	protected long holdingTime = HOLDING_TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventPatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CepPackage.Literals.EVENT_PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachine getStateMachines() {
		if (stateMachines != null && stateMachines.eIsProxy()) {
			InternalEObject oldStateMachines = (InternalEObject)stateMachines;
			stateMachines = (StateMachine)eResolveProxy(oldStateMachines);
			if (stateMachines != oldStateMachines) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CepPackage.EVENT_PATTERN__STATE_MACHINES, oldStateMachines, stateMachines));
			}
		}
		return stateMachines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachine basicGetStateMachines() {
		return stateMachines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStateMachines(StateMachine newStateMachines, NotificationChain msgs) {
		StateMachine oldStateMachines = stateMachines;
		stateMachines = newStateMachines;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CepPackage.EVENT_PATTERN__STATE_MACHINES, oldStateMachines, newStateMachines);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateMachines(StateMachine newStateMachines) {
		if (newStateMachines != stateMachines) {
			NotificationChain msgs = null;
			if (stateMachines != null)
				msgs = ((InternalEObject)stateMachines).eInverseRemove(this, InternalsmPackage.STATE_MACHINE__EVENT_PATTERN, StateMachine.class, msgs);
			if (newStateMachines != null)
				msgs = ((InternalEObject)newStateMachines).eInverseAdd(this, InternalsmPackage.STATE_MACHINE__EVENT_PATTERN, StateMachine.class, msgs);
			msgs = basicSetStateMachines(newStateMachines, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CepPackage.EVENT_PATTERN__STATE_MACHINES, newStateMachines, newStateMachines));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CepPackage.EVENT_PATTERN__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getHoldingTime() {
		return holdingTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHoldingTime(long newHoldingTime) {
		long oldHoldingTime = holdingTime;
		holdingTime = newHoldingTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CepPackage.EVENT_PATTERN__HOLDING_TIME, oldHoldingTime, holdingTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CepPackage.EVENT_PATTERN__STATE_MACHINES:
				if (stateMachines != null)
					msgs = ((InternalEObject)stateMachines).eInverseRemove(this, InternalsmPackage.STATE_MACHINE__EVENT_PATTERN, StateMachine.class, msgs);
				return basicSetStateMachines((StateMachine)otherEnd, msgs);
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
			case CepPackage.EVENT_PATTERN__STATE_MACHINES:
				return basicSetStateMachines(null, msgs);
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
			case CepPackage.EVENT_PATTERN__STATE_MACHINES:
				if (resolve) return getStateMachines();
				return basicGetStateMachines();
			case CepPackage.EVENT_PATTERN__ID:
				return getId();
			case CepPackage.EVENT_PATTERN__HOLDING_TIME:
				return getHoldingTime();
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
			case CepPackage.EVENT_PATTERN__STATE_MACHINES:
				setStateMachines((StateMachine)newValue);
				return;
			case CepPackage.EVENT_PATTERN__ID:
				setId((String)newValue);
				return;
			case CepPackage.EVENT_PATTERN__HOLDING_TIME:
				setHoldingTime((Long)newValue);
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
			case CepPackage.EVENT_PATTERN__STATE_MACHINES:
				setStateMachines((StateMachine)null);
				return;
			case CepPackage.EVENT_PATTERN__ID:
				setId(ID_EDEFAULT);
				return;
			case CepPackage.EVENT_PATTERN__HOLDING_TIME:
				setHoldingTime(HOLDING_TIME_EDEFAULT);
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
			case CepPackage.EVENT_PATTERN__STATE_MACHINES:
				return stateMachines != null;
			case CepPackage.EVENT_PATTERN__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case CepPackage.EVENT_PATTERN__HOLDING_TIME:
				return holdingTime != HOLDING_TIME_EDEFAULT;
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
		result.append(", holdingTime: ");
		result.append(holdingTime);
		result.append(')');
		return result.toString();
	}

} //EventPatternImpl
