/**
 */
package hu.bme.mit.incquery.cep.metamodels.cep.impl;

import hu.bme.mit.incquery.cep.metamodels.cep.CepPackage;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Event Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.ComplexEventPatternImpl#getCompositionEvents <em>Composition Events</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComplexEventPatternImpl extends EventPatternImpl implements ComplexEventPattern {
    /**
     * The cached value of the '{@link #getCompositionEvents() <em>Composition Events</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCompositionEvents()
     * @generated
     * @ordered
     */
    protected EventPattern compositionEvents;

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
    public EventPattern getCompositionEvents() {
        return compositionEvents;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCompositionEvents(EventPattern newCompositionEvents, NotificationChain msgs) {
        EventPattern oldCompositionEvents = compositionEvents;
        compositionEvents = newCompositionEvents;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CepPackage.COMPLEX_EVENT_PATTERN__COMPOSITION_EVENTS, oldCompositionEvents, newCompositionEvents);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCompositionEvents(EventPattern newCompositionEvents) {
        if (newCompositionEvents != compositionEvents) {
            NotificationChain msgs = null;
            if (compositionEvents != null)
                msgs = ((InternalEObject)compositionEvents).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CepPackage.COMPLEX_EVENT_PATTERN__COMPOSITION_EVENTS, null, msgs);
            if (newCompositionEvents != null)
                msgs = ((InternalEObject)newCompositionEvents).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CepPackage.COMPLEX_EVENT_PATTERN__COMPOSITION_EVENTS, null, msgs);
            msgs = basicSetCompositionEvents(newCompositionEvents, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CepPackage.COMPLEX_EVENT_PATTERN__COMPOSITION_EVENTS, newCompositionEvents, newCompositionEvents));
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
    public boolean evaluateParameterBindigs(Event event) {
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
            case CepPackage.COMPLEX_EVENT_PATTERN__COMPOSITION_EVENTS:
                return basicSetCompositionEvents(null, msgs);
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
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case CepPackage.COMPLEX_EVENT_PATTERN__COMPOSITION_EVENTS:
                setCompositionEvents((EventPattern)newValue);
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
            case CepPackage.COMPLEX_EVENT_PATTERN__COMPOSITION_EVENTS:
                setCompositionEvents((EventPattern)null);
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
            case CepPackage.COMPLEX_EVENT_PATTERN__COMPOSITION_EVENTS:
                return compositionEvents != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
        switch (operationID) {
            case CepPackage.COMPLEX_EVENT_PATTERN___ADD_COMPOSITION_EVENT_PATTERN__EVENTPATTERN:
                addCompositionEventPattern((EventPattern)arguments.get(0));
                return null;
            case CepPackage.COMPLEX_EVENT_PATTERN___EVALUATE_PARAMETER_BINDIGS__EVENT:
                return evaluateParameterBindigs((Event)arguments.get(0));
        }
        return super.eInvoke(operationID, arguments);
    }

} //ComplexEventPatternImpl
