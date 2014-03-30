/**
 */
package hu.bme.mit.incquery.cep.metamodels.automaton.impl;

import hu.bme.mit.incquery.cep.metamodels.automaton.Automaton;
import hu.bme.mit.incquery.cep.metamodels.automaton.AutomatonPackage;
import hu.bme.mit.incquery.cep.metamodels.automaton.EventToken;
import hu.bme.mit.incquery.cep.metamodels.automaton.InternalModel;

import hu.bme.mit.incquery.cep.metamodels.cep.Event;

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
 * An implementation of the model object '<em><b>Internal Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.automaton.impl.InternalModelImpl#getAutomata <em>Automata</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.automaton.impl.InternalModelImpl#getLatestEvent <em>Latest Event</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.automaton.impl.InternalModelImpl#getEventTokens <em>Event Tokens</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InternalModelImpl extends MinimalEObjectImpl.Container implements InternalModel {
    /**
     * The cached value of the '{@link #getAutomata() <em>Automata</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAutomata()
     * @generated
     * @ordered
     */
    protected EList<Automaton> automata;

    /**
     * The cached value of the '{@link #getLatestEvent() <em>Latest Event</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLatestEvent()
     * @generated
     * @ordered
     */
    protected Event latestEvent;

    /**
     * The cached value of the '{@link #getEventTokens() <em>Event Tokens</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEventTokens()
     * @generated
     * @ordered
     */
    protected EList<EventToken> eventTokens;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected InternalModelImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return AutomatonPackage.Literals.INTERNAL_MODEL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Automaton> getAutomata() {
        if (automata == null) {
            automata = new EObjectContainmentEList<Automaton>(Automaton.class, this, AutomatonPackage.INTERNAL_MODEL__AUTOMATA);
        }
        return automata;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Event getLatestEvent() {
        return latestEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetLatestEvent(Event newLatestEvent, NotificationChain msgs) {
        Event oldLatestEvent = latestEvent;
        latestEvent = newLatestEvent;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AutomatonPackage.INTERNAL_MODEL__LATEST_EVENT, oldLatestEvent, newLatestEvent);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLatestEvent(Event newLatestEvent) {
        if (newLatestEvent != latestEvent) {
            NotificationChain msgs = null;
            if (latestEvent != null)
                msgs = ((InternalEObject)latestEvent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AutomatonPackage.INTERNAL_MODEL__LATEST_EVENT, null, msgs);
            if (newLatestEvent != null)
                msgs = ((InternalEObject)newLatestEvent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AutomatonPackage.INTERNAL_MODEL__LATEST_EVENT, null, msgs);
            msgs = basicSetLatestEvent(newLatestEvent, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AutomatonPackage.INTERNAL_MODEL__LATEST_EVENT, newLatestEvent, newLatestEvent));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<EventToken> getEventTokens() {
        if (eventTokens == null) {
            eventTokens = new EObjectContainmentEList<EventToken>(EventToken.class, this, AutomatonPackage.INTERNAL_MODEL__EVENT_TOKENS);
        }
        return eventTokens;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case AutomatonPackage.INTERNAL_MODEL__AUTOMATA:
                return ((InternalEList<?>)getAutomata()).basicRemove(otherEnd, msgs);
            case AutomatonPackage.INTERNAL_MODEL__LATEST_EVENT:
                return basicSetLatestEvent(null, msgs);
            case AutomatonPackage.INTERNAL_MODEL__EVENT_TOKENS:
                return ((InternalEList<?>)getEventTokens()).basicRemove(otherEnd, msgs);
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
            case AutomatonPackage.INTERNAL_MODEL__AUTOMATA:
                return getAutomata();
            case AutomatonPackage.INTERNAL_MODEL__LATEST_EVENT:
                return getLatestEvent();
            case AutomatonPackage.INTERNAL_MODEL__EVENT_TOKENS:
                return getEventTokens();
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
            case AutomatonPackage.INTERNAL_MODEL__AUTOMATA:
                getAutomata().clear();
                getAutomata().addAll((Collection<? extends Automaton>)newValue);
                return;
            case AutomatonPackage.INTERNAL_MODEL__LATEST_EVENT:
                setLatestEvent((Event)newValue);
                return;
            case AutomatonPackage.INTERNAL_MODEL__EVENT_TOKENS:
                getEventTokens().clear();
                getEventTokens().addAll((Collection<? extends EventToken>)newValue);
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
            case AutomatonPackage.INTERNAL_MODEL__AUTOMATA:
                getAutomata().clear();
                return;
            case AutomatonPackage.INTERNAL_MODEL__LATEST_EVENT:
                setLatestEvent((Event)null);
                return;
            case AutomatonPackage.INTERNAL_MODEL__EVENT_TOKENS:
                getEventTokens().clear();
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
            case AutomatonPackage.INTERNAL_MODEL__AUTOMATA:
                return automata != null && !automata.isEmpty();
            case AutomatonPackage.INTERNAL_MODEL__LATEST_EVENT:
                return latestEvent != null;
            case AutomatonPackage.INTERNAL_MODEL__EVENT_TOKENS:
                return eventTokens != null && !eventTokens.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //InternalModelImpl
