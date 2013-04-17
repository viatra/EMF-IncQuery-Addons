/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm.impl;

import hu.bme.mit.incquery.cep.metamodels.cep.Event;

import hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventCollection;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Collection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.EventCollectionImpl#getCurrentStateVisitor <em>Current State Visitor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class EventCollectionImpl extends EObjectImpl implements EventCollection {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventCollectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InternalsmPackage.Literals.EVENT_COLLECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CurrentStateVisitor getCurrentStateVisitor() {
		if (eContainerFeatureID() != InternalsmPackage.EVENT_COLLECTION__CURRENT_STATE_VISITOR) return null;
		return (CurrentStateVisitor)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCurrentStateVisitor(CurrentStateVisitor newCurrentStateVisitor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCurrentStateVisitor, InternalsmPackage.EVENT_COLLECTION__CURRENT_STATE_VISITOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentStateVisitor(CurrentStateVisitor newCurrentStateVisitor) {
		if (newCurrentStateVisitor != eInternalContainer() || (eContainerFeatureID() != InternalsmPackage.EVENT_COLLECTION__CURRENT_STATE_VISITOR && newCurrentStateVisitor != null)) {
			if (EcoreUtil.isAncestor(this, newCurrentStateVisitor))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCurrentStateVisitor != null)
				msgs = ((InternalEObject)newCurrentStateVisitor).eInverseAdd(this, InternalsmPackage.CURRENT_STATE_VISITOR__EVENT_COLLECTION, CurrentStateVisitor.class, msgs);
			msgs = basicSetCurrentStateVisitor(newCurrentStateVisitor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.EVENT_COLLECTION__CURRENT_STATE_VISITOR, newCurrentStateVisitor, newCurrentStateVisitor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRecordedEvents() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addEvent(Event event) {
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InternalsmPackage.EVENT_COLLECTION__CURRENT_STATE_VISITOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCurrentStateVisitor((CurrentStateVisitor)otherEnd, msgs);
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
			case InternalsmPackage.EVENT_COLLECTION__CURRENT_STATE_VISITOR:
				return basicSetCurrentStateVisitor(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case InternalsmPackage.EVENT_COLLECTION__CURRENT_STATE_VISITOR:
				return eInternalContainer().eInverseRemove(this, InternalsmPackage.CURRENT_STATE_VISITOR__EVENT_COLLECTION, CurrentStateVisitor.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InternalsmPackage.EVENT_COLLECTION__CURRENT_STATE_VISITOR:
				return getCurrentStateVisitor();
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
			case InternalsmPackage.EVENT_COLLECTION__CURRENT_STATE_VISITOR:
				setCurrentStateVisitor((CurrentStateVisitor)newValue);
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
			case InternalsmPackage.EVENT_COLLECTION__CURRENT_STATE_VISITOR:
				setCurrentStateVisitor((CurrentStateVisitor)null);
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
			case InternalsmPackage.EVENT_COLLECTION__CURRENT_STATE_VISITOR:
				return getCurrentStateVisitor() != null;
		}
		return super.eIsSet(featureID);
	}

} //EventCollectionImpl
