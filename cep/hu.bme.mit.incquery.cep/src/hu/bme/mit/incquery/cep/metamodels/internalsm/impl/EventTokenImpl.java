/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm.impl;

import hu.bme.mit.incquery.cep.metamodels.internalsm.EventCollection;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Token</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.EventTokenImpl#getCurrentState <em>Current State</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.EventTokenImpl#getEventCollection <em>Event Collection</em>}</li>
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
	 * The cached value of the '{@link #getEventCollection() <em>Event Collection</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventCollection()
	 * @generated
	 * @ordered
	 */
	protected EventCollection eventCollection;

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
	public EventCollection getEventCollection() {
		return eventCollection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEventCollection(EventCollection newEventCollection, NotificationChain msgs) {
		EventCollection oldEventCollection = eventCollection;
		eventCollection = newEventCollection;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InternalsmPackage.EVENT_TOKEN__EVENT_COLLECTION, oldEventCollection, newEventCollection);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventCollection(EventCollection newEventCollection) {
		if (newEventCollection != eventCollection) {
			NotificationChain msgs = null;
			if (eventCollection != null)
				msgs = ((InternalEObject)eventCollection).eInverseRemove(this, InternalsmPackage.EVENT_COLLECTION__CURRENT_STATE_VISITOR, EventCollection.class, msgs);
			if (newEventCollection != null)
				msgs = ((InternalEObject)newEventCollection).eInverseAdd(this, InternalsmPackage.EVENT_COLLECTION__CURRENT_STATE_VISITOR, EventCollection.class, msgs);
			msgs = basicSetEventCollection(newEventCollection, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.EVENT_TOKEN__EVENT_COLLECTION, newEventCollection, newEventCollection));
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
			case InternalsmPackage.EVENT_TOKEN__EVENT_COLLECTION:
				if (eventCollection != null)
					msgs = ((InternalEObject)eventCollection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InternalsmPackage.EVENT_TOKEN__EVENT_COLLECTION, null, msgs);
				return basicSetEventCollection((EventCollection)otherEnd, msgs);
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
			case InternalsmPackage.EVENT_TOKEN__EVENT_COLLECTION:
				return basicSetEventCollection(null, msgs);
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
			case InternalsmPackage.EVENT_TOKEN__EVENT_COLLECTION:
				return getEventCollection();
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
			case InternalsmPackage.EVENT_TOKEN__CURRENT_STATE:
				setCurrentState((State)newValue);
				return;
			case InternalsmPackage.EVENT_TOKEN__EVENT_COLLECTION:
				setEventCollection((EventCollection)newValue);
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
			case InternalsmPackage.EVENT_TOKEN__EVENT_COLLECTION:
				setEventCollection((EventCollection)null);
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
			case InternalsmPackage.EVENT_TOKEN__EVENT_COLLECTION:
				return eventCollection != null;
		}
		return super.eIsSet(featureID);
	}

} //EventTokenImpl
