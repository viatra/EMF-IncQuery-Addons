/**
 */
package hu.bme.mit.incquery.cep.metamodels.cep.impl;

import hu.bme.mit.incquery.cep.metamodels.cep.CepPackage;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.PartialTimewindow;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Partial Timewindow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.PartialTimewindowImpl#getStopEvent <em>Stop Event</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.PartialTimewindowImpl#getCheckEvents <em>Check Events</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.PartialTimewindowImpl#getStartEvent <em>Start Event</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PartialTimewindowImpl extends TimewindowImpl implements PartialTimewindow {
	/**
	 * The cached value of the '{@link #getStopEvent() <em>Stop Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStopEvent()
	 * @generated
	 * @ordered
	 */
	protected EventPattern stopEvent;

	/**
	 * The cached value of the '{@link #getCheckEvents() <em>Check Events</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCheckEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<EventPattern> checkEvents;

	/**
	 * The cached value of the '{@link #getStartEvent() <em>Start Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartEvent()
	 * @generated
	 * @ordered
	 */
	protected EventPattern startEvent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartialTimewindowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CepPackage.Literals.PARTIAL_TIMEWINDOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventPattern getStopEvent() {
		if (stopEvent != null && stopEvent.eIsProxy()) {
			InternalEObject oldStopEvent = (InternalEObject)stopEvent;
			stopEvent = (EventPattern)eResolveProxy(oldStopEvent);
			if (stopEvent != oldStopEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CepPackage.PARTIAL_TIMEWINDOW__STOP_EVENT, oldStopEvent, stopEvent));
			}
		}
		return stopEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventPattern basicGetStopEvent() {
		return stopEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStopEvent(EventPattern newStopEvent) {
		EventPattern oldStopEvent = stopEvent;
		stopEvent = newStopEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CepPackage.PARTIAL_TIMEWINDOW__STOP_EVENT, oldStopEvent, stopEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EventPattern> getCheckEvents() {
		if (checkEvents == null) {
			checkEvents = new EObjectResolvingEList<EventPattern>(EventPattern.class, this, CepPackage.PARTIAL_TIMEWINDOW__CHECK_EVENTS);
		}
		return checkEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventPattern getStartEvent() {
		if (startEvent != null && startEvent.eIsProxy()) {
			InternalEObject oldStartEvent = (InternalEObject)startEvent;
			startEvent = (EventPattern)eResolveProxy(oldStartEvent);
			if (startEvent != oldStartEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CepPackage.PARTIAL_TIMEWINDOW__START_EVENT, oldStartEvent, startEvent));
			}
		}
		return startEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventPattern basicGetStartEvent() {
		return startEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartEvent(EventPattern newStartEvent) {
		EventPattern oldStartEvent = startEvent;
		startEvent = newStartEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CepPackage.PARTIAL_TIMEWINDOW__START_EVENT, oldStartEvent, startEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CepPackage.PARTIAL_TIMEWINDOW__STOP_EVENT:
				if (resolve) return getStopEvent();
				return basicGetStopEvent();
			case CepPackage.PARTIAL_TIMEWINDOW__CHECK_EVENTS:
				return getCheckEvents();
			case CepPackage.PARTIAL_TIMEWINDOW__START_EVENT:
				if (resolve) return getStartEvent();
				return basicGetStartEvent();
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
			case CepPackage.PARTIAL_TIMEWINDOW__STOP_EVENT:
				setStopEvent((EventPattern)newValue);
				return;
			case CepPackage.PARTIAL_TIMEWINDOW__CHECK_EVENTS:
				getCheckEvents().clear();
				getCheckEvents().addAll((Collection<? extends EventPattern>)newValue);
				return;
			case CepPackage.PARTIAL_TIMEWINDOW__START_EVENT:
				setStartEvent((EventPattern)newValue);
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
			case CepPackage.PARTIAL_TIMEWINDOW__STOP_EVENT:
				setStopEvent((EventPattern)null);
				return;
			case CepPackage.PARTIAL_TIMEWINDOW__CHECK_EVENTS:
				getCheckEvents().clear();
				return;
			case CepPackage.PARTIAL_TIMEWINDOW__START_EVENT:
				setStartEvent((EventPattern)null);
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
			case CepPackage.PARTIAL_TIMEWINDOW__STOP_EVENT:
				return stopEvent != null;
			case CepPackage.PARTIAL_TIMEWINDOW__CHECK_EVENTS:
				return checkEvents != null && !checkEvents.isEmpty();
			case CepPackage.PARTIAL_TIMEWINDOW__START_EVENT:
				return startEvent != null;
		}
		return super.eIsSet(featureID);
	}

} //PartialTimewindowImpl
