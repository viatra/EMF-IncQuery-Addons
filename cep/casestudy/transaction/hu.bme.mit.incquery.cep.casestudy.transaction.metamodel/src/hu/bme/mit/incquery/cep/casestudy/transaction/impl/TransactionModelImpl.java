/**
 */
package hu.bme.mit.incquery.cep.casestudy.transaction.impl;

import hu.bme.mit.incquery.cep.casestudy.transaction.Component;
import hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent;
import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionModel;
import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.casestudy.transaction.impl.TransactionModelImpl#getLatestComponentEvent <em>Latest Component Event</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.casestudy.transaction.impl.TransactionModelImpl#getCompoundTransactionEvents <em>Compound Transaction Events</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransactionModelImpl extends MinimalEObjectImpl.Container implements TransactionModel {
	/**
	 * The cached value of the '{@link #getLatestComponentEvent() <em>Latest Component Event</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatestComponentEvent()
	 * @generated
	 * @ordered
	 */
	protected Component latestComponentEvent;

	/**
	 * The cached value of the '{@link #getCompoundTransactionEvents() <em>Compound Transaction Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompoundTransactionEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<CompoundTransactionEvent> compoundTransactionEvents;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransactionModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TransactionPackage.Literals.TRANSACTION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component getLatestComponentEvent() {
		return latestComponentEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLatestComponentEvent(Component newLatestComponentEvent, NotificationChain msgs) {
		Component oldLatestComponentEvent = latestComponentEvent;
		latestComponentEvent = newLatestComponentEvent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TransactionPackage.TRANSACTION_MODEL__LATEST_COMPONENT_EVENT, oldLatestComponentEvent, newLatestComponentEvent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLatestComponentEvent(Component newLatestComponentEvent) {
		if (newLatestComponentEvent != latestComponentEvent) {
			NotificationChain msgs = null;
			if (latestComponentEvent != null)
				msgs = ((InternalEObject)latestComponentEvent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TransactionPackage.TRANSACTION_MODEL__LATEST_COMPONENT_EVENT, null, msgs);
			if (newLatestComponentEvent != null)
				msgs = ((InternalEObject)newLatestComponentEvent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TransactionPackage.TRANSACTION_MODEL__LATEST_COMPONENT_EVENT, null, msgs);
			msgs = basicSetLatestComponentEvent(newLatestComponentEvent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransactionPackage.TRANSACTION_MODEL__LATEST_COMPONENT_EVENT, newLatestComponentEvent, newLatestComponentEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CompoundTransactionEvent> getCompoundTransactionEvents() {
		if (compoundTransactionEvents == null) {
			compoundTransactionEvents = new EObjectContainmentEList<CompoundTransactionEvent>(CompoundTransactionEvent.class, this, TransactionPackage.TRANSACTION_MODEL__COMPOUND_TRANSACTION_EVENTS);
		}
		return compoundTransactionEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TransactionPackage.TRANSACTION_MODEL__LATEST_COMPONENT_EVENT:
				return basicSetLatestComponentEvent(null, msgs);
			case TransactionPackage.TRANSACTION_MODEL__COMPOUND_TRANSACTION_EVENTS:
				return ((InternalEList<?>)getCompoundTransactionEvents()).basicRemove(otherEnd, msgs);
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
			case TransactionPackage.TRANSACTION_MODEL__LATEST_COMPONENT_EVENT:
				return getLatestComponentEvent();
			case TransactionPackage.TRANSACTION_MODEL__COMPOUND_TRANSACTION_EVENTS:
				return getCompoundTransactionEvents();
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
			case TransactionPackage.TRANSACTION_MODEL__LATEST_COMPONENT_EVENT:
				setLatestComponentEvent((Component)newValue);
				return;
			case TransactionPackage.TRANSACTION_MODEL__COMPOUND_TRANSACTION_EVENTS:
				getCompoundTransactionEvents().clear();
				getCompoundTransactionEvents().addAll((Collection<? extends CompoundTransactionEvent>)newValue);
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
			case TransactionPackage.TRANSACTION_MODEL__LATEST_COMPONENT_EVENT:
				setLatestComponentEvent((Component)null);
				return;
			case TransactionPackage.TRANSACTION_MODEL__COMPOUND_TRANSACTION_EVENTS:
				getCompoundTransactionEvents().clear();
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
			case TransactionPackage.TRANSACTION_MODEL__LATEST_COMPONENT_EVENT:
				return latestComponentEvent != null;
			case TransactionPackage.TRANSACTION_MODEL__COMPOUND_TRANSACTION_EVENTS:
				return compoundTransactionEvents != null && !compoundTransactionEvents.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TransactionModelImpl
