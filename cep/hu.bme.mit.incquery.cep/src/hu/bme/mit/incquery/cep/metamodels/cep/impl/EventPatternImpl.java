/**
 */
package hu.bme.mit.incquery.cep.metamodels.cep.impl;

import hu.bme.mit.incquery.cep.metamodels.cep.CepPackage;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;

import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage;
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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.EventPatternImpl#getCompositionEvents <em>Composition Events</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.EventPatternImpl#getStateMachines <em>State Machines</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.EventPatternImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class EventPatternImpl extends EObjectImpl implements EventPattern {
	/**
	 * The cached value of the '{@link #getCompositionEvents() <em>Composition Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositionEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<EventPattern> compositionEvents;

	/**
	 * The cached value of the '{@link #getStateMachines() <em>State Machines</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateMachines()
	 * @generated
	 * @ordered
	 */
	protected EList<StateMachine> stateMachines;

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
	public EList<EventPattern> getCompositionEvents() {
		if (compositionEvents == null) {
			compositionEvents = new EObjectContainmentEList<EventPattern>(EventPattern.class, this, CepPackage.EVENT_PATTERN__COMPOSITION_EVENTS);
		}
		return compositionEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StateMachine> getStateMachines() {
		if (stateMachines == null) {
			stateMachines = new EObjectWithInverseResolvingEList<StateMachine>(StateMachine.class, this, CepPackage.EVENT_PATTERN__STATE_MACHINES, InternalsmPackage.STATE_MACHINE__EVENT_PATTERN);
		}
		return stateMachines;
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
	public boolean match(Event event) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRecognized() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CepPackage.EVENT_PATTERN__STATE_MACHINES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStateMachines()).basicAdd(otherEnd, msgs);
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
			case CepPackage.EVENT_PATTERN__COMPOSITION_EVENTS:
				return ((InternalEList<?>)getCompositionEvents()).basicRemove(otherEnd, msgs);
			case CepPackage.EVENT_PATTERN__STATE_MACHINES:
				return ((InternalEList<?>)getStateMachines()).basicRemove(otherEnd, msgs);
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
			case CepPackage.EVENT_PATTERN__COMPOSITION_EVENTS:
				return getCompositionEvents();
			case CepPackage.EVENT_PATTERN__STATE_MACHINES:
				return getStateMachines();
			case CepPackage.EVENT_PATTERN__ID:
				return getId();
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
			case CepPackage.EVENT_PATTERN__COMPOSITION_EVENTS:
				getCompositionEvents().clear();
				getCompositionEvents().addAll((Collection<? extends EventPattern>)newValue);
				return;
			case CepPackage.EVENT_PATTERN__STATE_MACHINES:
				getStateMachines().clear();
				getStateMachines().addAll((Collection<? extends StateMachine>)newValue);
				return;
			case CepPackage.EVENT_PATTERN__ID:
				setId((String)newValue);
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
			case CepPackage.EVENT_PATTERN__COMPOSITION_EVENTS:
				getCompositionEvents().clear();
				return;
			case CepPackage.EVENT_PATTERN__STATE_MACHINES:
				getStateMachines().clear();
				return;
			case CepPackage.EVENT_PATTERN__ID:
				setId(ID_EDEFAULT);
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
			case CepPackage.EVENT_PATTERN__COMPOSITION_EVENTS:
				return compositionEvents != null && !compositionEvents.isEmpty();
			case CepPackage.EVENT_PATTERN__STATE_MACHINES:
				return stateMachines != null && !stateMachines.isEmpty();
			case CepPackage.EVENT_PATTERN__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
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
		result.append(')');
		return result.toString();
	}

} //EventPatternImpl
