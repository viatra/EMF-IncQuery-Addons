/**
 */
package hu.bme.mit.incquery.cep.casestudy.transaction.impl;

import hu.bme.mit.incquery.cep.casestudy.transaction.Component;
import hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent;
import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionModel;
import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

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
	 * The cached value of the '{@link #getLatestComponentEvent() <em>Latest Component Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatestComponentEvent()
	 * @generated
	 * @ordered
	 */
	protected Component latestComponentEvent;

	/**
	 * The cached value of the '{@link #getCompoundTransactionEvents() <em>Compound Transaction Events</em>}' reference list.
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
		if (latestComponentEvent != null && latestComponentEvent.eIsProxy()) {
			InternalEObject oldLatestComponentEvent = (InternalEObject)latestComponentEvent;
			latestComponentEvent = (Component)eResolveProxy(oldLatestComponentEvent);
			if (latestComponentEvent != oldLatestComponentEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TransactionPackage.TRANSACTION_MODEL__LATEST_COMPONENT_EVENT, oldLatestComponentEvent, latestComponentEvent));
			}
		}
		return latestComponentEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component basicGetLatestComponentEvent() {
		return latestComponentEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLatestComponentEvent(Component newLatestComponentEvent) {
		Component oldLatestComponentEvent = latestComponentEvent;
		latestComponentEvent = newLatestComponentEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransactionPackage.TRANSACTION_MODEL__LATEST_COMPONENT_EVENT, oldLatestComponentEvent, latestComponentEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CompoundTransactionEvent> getCompoundTransactionEvents() {
		if (compoundTransactionEvents == null) {
			compoundTransactionEvents = new EObjectResolvingEList<CompoundTransactionEvent>(CompoundTransactionEvent.class, this, TransactionPackage.TRANSACTION_MODEL__COMPOUND_TRANSACTION_EVENTS);
		}
		return compoundTransactionEvents;
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
				if (resolve) return getLatestComponentEvent();
				return basicGetLatestComponentEvent();
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
