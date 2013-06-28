/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm.impl;

import hu.bme.mit.incquery.cep.metamodels.cep.Event;

import hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Token</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.EventTokenImpl#getCurrentState <em>Current State</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.EventTokenImpl#getRecordedEvents <em>Recorded Events</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventTokenImpl extends EObjectImpl implements EventToken {
	/**
	 * The cached value of the '{@link #getCurrentState() <em>Current State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentState()
	 * @generated
	 * @ordered
	 */
	protected State currentState;

	/**
	 * The cached value of the '{@link #getRecordedEvents() <em>Recorded Events</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecordedEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> recordedEvents;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventTokenImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InternalsmPackage.Literals.EVENT_TOKEN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getCurrentState() {
		if (currentState != null && currentState.eIsProxy()) {
			InternalEObject oldCurrentState = (InternalEObject)currentState;
			currentState = (State)eResolveProxy(oldCurrentState);
			if (currentState != oldCurrentState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InternalsmPackage.EVENT_TOKEN__CURRENT_STATE, oldCurrentState, currentState));
			}
		}
		return currentState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetCurrentState() {
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InternalsmPackage.EVENT_TOKEN__CURRENT_STATE, oldCurrentState, newCurrentState);
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
				msgs = ((InternalEObject)currentState).eInverseRemove(this, InternalsmPackage.STATE__EVENT_TOKENS, State.class, msgs);
			if (newCurrentState != null)
				msgs = ((InternalEObject)newCurrentState).eInverseAdd(this, InternalsmPackage.STATE__EVENT_TOKENS, State.class, msgs);
			msgs = basicSetCurrentState(newCurrentState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.EVENT_TOKEN__CURRENT_STATE, newCurrentState, newCurrentState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> getRecordedEvents() {
		if (recordedEvents == null) {
			recordedEvents = new EObjectResolvingEList<Event>(Event.class, this, InternalsmPackage.EVENT_TOKEN__RECORDED_EVENTS);
		}
		return recordedEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InternalsmPackage.EVENT_TOKEN__CURRENT_STATE:
				if (currentState != null)
					msgs = ((InternalEObject)currentState).eInverseRemove(this, InternalsmPackage.STATE__EVENT_TOKENS, State.class, msgs);
				return basicSetCurrentState((State)otherEnd, msgs);
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
			case InternalsmPackage.EVENT_TOKEN__CURRENT_STATE:
				return basicSetCurrentState(null, msgs);
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
			case InternalsmPackage.EVENT_TOKEN__CURRENT_STATE:
				if (resolve) return getCurrentState();
				return basicGetCurrentState();
			case InternalsmPackage.EVENT_TOKEN__RECORDED_EVENTS:
				return getRecordedEvents();
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
			case InternalsmPackage.EVENT_TOKEN__CURRENT_STATE:
				setCurrentState((State)newValue);
				return;
			case InternalsmPackage.EVENT_TOKEN__RECORDED_EVENTS:
				getRecordedEvents().clear();
				getRecordedEvents().addAll((Collection<? extends Event>)newValue);
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
			case InternalsmPackage.EVENT_TOKEN__CURRENT_STATE:
				setCurrentState((State)null);
				return;
			case InternalsmPackage.EVENT_TOKEN__RECORDED_EVENTS:
				getRecordedEvents().clear();
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
			case InternalsmPackage.EVENT_TOKEN__CURRENT_STATE:
				return currentState != null;
			case InternalsmPackage.EVENT_TOKEN__RECORDED_EVENTS:
				return recordedEvents != null && !recordedEvents.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EventTokenImpl
