/**
 */
package hu.bme.mit.incquery.cep.metamodels.cep.impl;

import hu.bme.mit.incquery.cep.metamodels.cep.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CepFactoryImpl extends EFactoryImpl implements CepFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static CepFactory init() {
        try {
            CepFactory theCepFactory = (CepFactory)EPackage.Registry.INSTANCE.getEFactory(CepPackage.eNS_URI);
            if (theCepFactory != null) {
                return theCepFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new CepFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CepFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case CepPackage.EVENT_PATTERN: return createEventPattern();
            case CepPackage.ATOMIC_EVENT_PATTERN: return createAtomicEventPattern();
            case CepPackage.COMPLEX_EVENT_PATTERN: return createComplexEventPattern();
            case CepPackage.EVENT: return createEvent();
            case CepPackage.TIMEWINDOW: return createTimewindow();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EventPattern createEventPattern() {
        EventPatternImpl eventPattern = new EventPatternImpl();
        return eventPattern;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AtomicEventPattern createAtomicEventPattern() {
        AtomicEventPatternImpl atomicEventPattern = new AtomicEventPatternImpl();
        return atomicEventPattern;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComplexEventPattern createComplexEventPattern() {
        ComplexEventPatternImpl complexEventPattern = new ComplexEventPatternImpl();
        return complexEventPattern;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Event createEvent() {
        EventImpl event = new EventImpl();
        return event;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Timewindow createTimewindow() {
        TimewindowImpl timewindow = new TimewindowImpl();
        return timewindow;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CepPackage getCepPackage() {
        return (CepPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static CepPackage getPackage() {
        return CepPackage.eINSTANCE;
    }

} //CepFactoryImpl
