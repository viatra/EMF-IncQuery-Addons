/**
 */
package hu.bme.mit.incquery.cep.metamodels.cep.impl;

import hu.bme.mit.incquery.cep.metamodels.automaton.Automaton;
import hu.bme.mit.incquery.cep.metamodels.automaton.AutomatonPackage;

import hu.bme.mit.incquery.cep.metamodels.cep.CepPackage;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.EventPatternImpl#getAutomaton <em>Automaton</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.EventPatternImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventPatternImpl extends MinimalEObjectImpl.Container implements EventPattern {
    /**
     * The cached value of the '{@link #getAutomaton() <em>Automaton</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAutomaton()
     * @generated
     * @ordered
     */
    protected Automaton automaton;

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
    public Automaton getAutomaton() {
        if (automaton != null && automaton.eIsProxy()) {
            InternalEObject oldAutomaton = (InternalEObject)automaton;
            automaton = (Automaton)eResolveProxy(oldAutomaton);
            if (automaton != oldAutomaton) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CepPackage.EVENT_PATTERN__AUTOMATON, oldAutomaton, automaton));
            }
        }
        return automaton;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Automaton basicGetAutomaton() {
        return automaton;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetAutomaton(Automaton newAutomaton, NotificationChain msgs) {
        Automaton oldAutomaton = automaton;
        automaton = newAutomaton;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CepPackage.EVENT_PATTERN__AUTOMATON, oldAutomaton, newAutomaton);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAutomaton(Automaton newAutomaton) {
        if (newAutomaton != automaton) {
            NotificationChain msgs = null;
            if (automaton != null)
                msgs = ((InternalEObject)automaton).eInverseRemove(this, AutomatonPackage.AUTOMATON__EVENT_PATTERN, Automaton.class, msgs);
            if (newAutomaton != null)
                msgs = ((InternalEObject)newAutomaton).eInverseAdd(this, AutomatonPackage.AUTOMATON__EVENT_PATTERN, Automaton.class, msgs);
            msgs = basicSetAutomaton(newAutomaton, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CepPackage.EVENT_PATTERN__AUTOMATON, newAutomaton, newAutomaton));
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
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CepPackage.EVENT_PATTERN__AUTOMATON:
                if (automaton != null)
                    msgs = ((InternalEObject)automaton).eInverseRemove(this, AutomatonPackage.AUTOMATON__EVENT_PATTERN, Automaton.class, msgs);
                return basicSetAutomaton((Automaton)otherEnd, msgs);
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
            case CepPackage.EVENT_PATTERN__AUTOMATON:
                return basicSetAutomaton(null, msgs);
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
            case CepPackage.EVENT_PATTERN__AUTOMATON:
                if (resolve) return getAutomaton();
                return basicGetAutomaton();
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
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case CepPackage.EVENT_PATTERN__AUTOMATON:
                setAutomaton((Automaton)newValue);
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
            case CepPackage.EVENT_PATTERN__AUTOMATON:
                setAutomaton((Automaton)null);
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
            case CepPackage.EVENT_PATTERN__AUTOMATON:
                return automaton != null;
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
