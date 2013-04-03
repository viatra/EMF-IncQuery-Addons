/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm.impl;

import hu.bme.mit.incquery.cep.metamodels.cep.CepPackage;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;

import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Machine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.StateMachineImpl#getStates <em>States</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.StateMachineImpl#getCurrentState <em>Current State</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.StateMachineImpl#getEventPattern <em>Event Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateMachineImpl extends EObjectImpl implements StateMachine {
	/**
	 * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStates()
	 * @generated
	 * @ordered
	 */
	protected EList<State> states;

	/**
	 * The cached value of the '{@link #getCurrentState() <em>Current State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentState()
	 * @generated
	 * @ordered
	 */
	protected State currentState;

	/**
	 * The cached value of the '{@link #getEventPattern() <em>Event Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventPattern()
	 * @generated
	 * @ordered
	 */
	protected EventPattern eventPattern;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateMachineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InternalsmPackage.Literals.STATE_MACHINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getStates() {
		if (states == null) {
			states = new EObjectContainmentEList<State>(State.class, this, InternalsmPackage.STATE_MACHINE__STATES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getCurrentState() {
		return currentState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCurrentState(State newCurrentState, NotificationChain msgs) {
		State oldCurrentState = currentState;
		currentState = newCurrentState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InternalsmPackage.STATE_MACHINE__CURRENT_STATE, oldCurrentState, newCurrentState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentState(State newCurrentState) {
		if (newCurrentState != currentState) {
			NotificationChain msgs = null;
			if (currentState != null)
				msgs = ((InternalEObject)currentState).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InternalsmPackage.STATE_MACHINE__CURRENT_STATE, null, msgs);
			if (newCurrentState != null)
				msgs = ((InternalEObject)newCurrentState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InternalsmPackage.STATE_MACHINE__CURRENT_STATE, null, msgs);
			msgs = basicSetCurrentState(newCurrentState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.STATE_MACHINE__CURRENT_STATE, newCurrentState, newCurrentState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventPattern getEventPattern() {
		if (eventPattern != null && eventPattern.eIsProxy()) {
			InternalEObject oldEventPattern = (InternalEObject)eventPattern;
			eventPattern = (EventPattern)eResolveProxy(oldEventPattern);
			if (eventPattern != oldEventPattern) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InternalsmPackage.STATE_MACHINE__EVENT_PATTERN, oldEventPattern, eventPattern));
			}
		}
		return eventPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventPattern basicGetEventPattern() {
		return eventPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEventPattern(EventPattern newEventPattern, NotificationChain msgs) {
		EventPattern oldEventPattern = eventPattern;
		eventPattern = newEventPattern;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InternalsmPackage.STATE_MACHINE__EVENT_PATTERN, oldEventPattern, newEventPattern);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventPattern(EventPattern newEventPattern) {
		if (newEventPattern != eventPattern) {
			NotificationChain msgs = null;
			if (eventPattern != null)
				msgs = ((InternalEObject)eventPattern).eInverseRemove(this, CepPackage.EVENT_PATTERN__STATE_MACHINES, EventPattern.class, msgs);
			if (newEventPattern != null)
				msgs = ((InternalEObject)newEventPattern).eInverseAdd(this, CepPackage.EVENT_PATTERN__STATE_MACHINES, EventPattern.class, msgs);
			msgs = basicSetEventPattern(newEventPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.STATE_MACHINE__EVENT_PATTERN, newEventPattern, newEventPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InternalsmPackage.STATE_MACHINE__EVENT_PATTERN:
				if (eventPattern != null)
					msgs = ((InternalEObject)eventPattern).eInverseRemove(this, CepPackage.EVENT_PATTERN__STATE_MACHINES, EventPattern.class, msgs);
				return basicSetEventPattern((EventPattern)otherEnd, msgs);
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
			case InternalsmPackage.STATE_MACHINE__STATES:
				return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
			case InternalsmPackage.STATE_MACHINE__CURRENT_STATE:
				return basicSetCurrentState(null, msgs);
			case InternalsmPackage.STATE_MACHINE__EVENT_PATTERN:
				return basicSetEventPattern(null, msgs);
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
			case InternalsmPackage.STATE_MACHINE__STATES:
				return getStates();
			case InternalsmPackage.STATE_MACHINE__CURRENT_STATE:
				return getCurrentState();
			case InternalsmPackage.STATE_MACHINE__EVENT_PATTERN:
				if (resolve) return getEventPattern();
				return basicGetEventPattern();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case InternalsmPackage.STATE_MACHINE__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends State>)newValue);
				return;
			case InternalsmPackage.STATE_MACHINE__CURRENT_STATE:
				setCurrentState((State)newValue);
				return;
			case InternalsmPackage.STATE_MACHINE__EVENT_PATTERN:
				setEventPattern((EventPattern)newValue);
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
			case InternalsmPackage.STATE_MACHINE__STATES:
				getStates().clear();
				return;
			case InternalsmPackage.STATE_MACHINE__CURRENT_STATE:
				setCurrentState((State)null);
				return;
			case InternalsmPackage.STATE_MACHINE__EVENT_PATTERN:
				setEventPattern((EventPattern)null);
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
			case InternalsmPackage.STATE_MACHINE__STATES:
				return states != null && !states.isEmpty();
			case InternalsmPackage.STATE_MACHINE__CURRENT_STATE:
				return currentState != null;
			case InternalsmPackage.STATE_MACHINE__EVENT_PATTERN:
				return eventPattern != null;
		}
		return super.eIsSet(featureID);
	}

} //StateMachineImpl
