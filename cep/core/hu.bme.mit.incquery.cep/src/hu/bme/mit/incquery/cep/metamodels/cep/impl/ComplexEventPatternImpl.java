/**
 */
package hu.bme.mit.incquery.cep.metamodels.cep.impl;

import hu.bme.mit.incquery.cep.metamodels.cep.CepPackage;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.Timewindow;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Event Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.ComplexEventPatternImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.ComplexEventPatternImpl#getTimewindow <em>Timewindow</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.ComplexEventPatternImpl#getCompositionEvents <em>Composition Events</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComplexEventPatternImpl extends EventPatternImpl implements ComplexEventPattern {
	/**
	 * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected static final ComplexOperator OPERATOR_EDEFAULT = ComplexOperator.ORDERED;

	/**
	 * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected ComplexOperator operator = OPERATOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTimewindow() <em>Timewindow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimewindow()
	 * @generated
	 * @ordered
	 */
	protected Timewindow timewindow;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplexEventPatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CepPackage.Literals.COMPLEX_EVENT_PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexOperator getOperator() {
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperator(ComplexOperator newOperator) {
		ComplexOperator oldOperator = operator;
		operator = newOperator == null ? OPERATOR_EDEFAULT : newOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CepPackage.COMPLEX_EVENT_PATTERN__OPERATOR, oldOperator, operator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Timewindow getTimewindow() {
		return timewindow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimewindow(Timewindow newTimewindow, NotificationChain msgs) {
		Timewindow oldTimewindow = timewindow;
		timewindow = newTimewindow;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CepPackage.COMPLEX_EVENT_PATTERN__TIMEWINDOW, oldTimewindow, newTimewindow);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimewindow(Timewindow newTimewindow) {
		if (newTimewindow != timewindow) {
			NotificationChain msgs = null;
			if (timewindow != null)
				msgs = ((InternalEObject)timewindow).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CepPackage.COMPLEX_EVENT_PATTERN__TIMEWINDOW, null, msgs);
			if (newTimewindow != null)
				msgs = ((InternalEObject)newTimewindow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CepPackage.COMPLEX_EVENT_PATTERN__TIMEWINDOW, null, msgs);
			msgs = basicSetTimewindow(newTimewindow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CepPackage.COMPLEX_EVENT_PATTERN__TIMEWINDOW, newTimewindow, newTimewindow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EventPattern> getCompositionEvents() {
		if (compositionEvents == null) {
			compositionEvents = new EObjectContainmentEList<EventPattern>(EventPattern.class, this, CepPackage.COMPLEX_EVENT_PATTERN__COMPOSITION_EVENTS);
		}
		return compositionEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addCompositionEventPattern(EventPattern compositionEventPattern) {
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CepPackage.COMPLEX_EVENT_PATTERN__TIMEWINDOW:
				return basicSetTimewindow(null, msgs);
			case CepPackage.COMPLEX_EVENT_PATTERN__COMPOSITION_EVENTS:
				return ((InternalEList<?>)getCompositionEvents()).basicRemove(otherEnd, msgs);
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
			case CepPackage.COMPLEX_EVENT_PATTERN__OPERATOR:
				return getOperator();
			case CepPackage.COMPLEX_EVENT_PATTERN__TIMEWINDOW:
				return getTimewindow();
			case CepPackage.COMPLEX_EVENT_PATTERN__COMPOSITION_EVENTS:
				return getCompositionEvents();
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
			case CepPackage.COMPLEX_EVENT_PATTERN__OPERATOR:
				setOperator((ComplexOperator)newValue);
				return;
			case CepPackage.COMPLEX_EVENT_PATTERN__TIMEWINDOW:
				setTimewindow((Timewindow)newValue);
				return;
			case CepPackage.COMPLEX_EVENT_PATTERN__COMPOSITION_EVENTS:
				getCompositionEvents().clear();
				getCompositionEvents().addAll((Collection<? extends EventPattern>)newValue);
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
			case CepPackage.COMPLEX_EVENT_PATTERN__OPERATOR:
				setOperator(OPERATOR_EDEFAULT);
				return;
			case CepPackage.COMPLEX_EVENT_PATTERN__TIMEWINDOW:
				setTimewindow((Timewindow)null);
				return;
			case CepPackage.COMPLEX_EVENT_PATTERN__COMPOSITION_EVENTS:
				getCompositionEvents().clear();
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
			case CepPackage.COMPLEX_EVENT_PATTERN__OPERATOR:
				return operator != OPERATOR_EDEFAULT;
			case CepPackage.COMPLEX_EVENT_PATTERN__TIMEWINDOW:
				return timewindow != null;
			case CepPackage.COMPLEX_EVENT_PATTERN__COMPOSITION_EVENTS:
				return compositionEvents != null && !compositionEvents.isEmpty();
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
		result.append(" (operator: ");
		result.append(operator);
		result.append(')');
		return result.toString();
	}

} //ComplexEventPatternImpl
