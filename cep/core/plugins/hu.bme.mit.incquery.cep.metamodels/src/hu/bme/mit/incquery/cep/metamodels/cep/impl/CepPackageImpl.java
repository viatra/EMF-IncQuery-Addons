/**
 */
package hu.bme.mit.incquery.cep.metamodels.cep.impl;

import hu.bme.mit.incquery.cep.metamodels.automaton.AutomatonPackage;

import hu.bme.mit.incquery.cep.metamodels.automaton.impl.AutomatonPackageImpl;

import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.CepFactory;
import hu.bme.mit.incquery.cep.metamodels.cep.CepPackage;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;
import hu.bme.mit.incquery.cep.metamodels.cep.Timewindow;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CepPackageImpl extends EPackageImpl implements CepPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass eventPatternEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass atomicEventPatternEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass complexEventPatternEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass eventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass iEventSourceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass timewindowEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private CepPackageImpl() {
        super(eNS_URI, CepFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link CepPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static CepPackage init() {
        if (isInited) return (CepPackage)EPackage.Registry.INSTANCE.getEPackage(CepPackage.eNS_URI);

        // Obtain or create and register package
        CepPackageImpl theCepPackage = (CepPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CepPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CepPackageImpl());

        isInited = true;

        // Obtain or create and register interdependencies
        AutomatonPackageImpl theAutomatonPackage = (AutomatonPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AutomatonPackage.eNS_URI) instanceof AutomatonPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AutomatonPackage.eNS_URI) : AutomatonPackage.eINSTANCE);

        // Create package meta-data objects
        theCepPackage.createPackageContents();
        theAutomatonPackage.createPackageContents();

        // Initialize created meta-data
        theCepPackage.initializePackageContents();
        theAutomatonPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theCepPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(CepPackage.eNS_URI, theCepPackage);
        return theCepPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEventPattern() {
        return eventPatternEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEventPattern_Automaton() {
        return (EReference)eventPatternEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEventPattern_Id() {
        return (EAttribute)eventPatternEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAtomicEventPattern() {
        return atomicEventPatternEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAtomicEventPattern_Type() {
        return (EAttribute)atomicEventPatternEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getComplexEventPattern() {
        return complexEventPatternEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComplexEventPattern_CompositionEvents() {
        return (EReference)complexEventPatternEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getComplexEventPattern__AddCompositionEventPattern__EventPattern() {
        return complexEventPatternEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getComplexEventPattern__EvaluateParameterBindigs__Event() {
        return complexEventPatternEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEvent() {
        return eventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEvent_Type() {
        return (EAttribute)eventEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEvent_Timestamp() {
        return (EAttribute)eventEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEvent_Source() {
        return (EReference)eventEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIEventSource() {
        return iEventSourceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getIEventSource__GetId() {
        return iEventSourceEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTimewindow() {
        return timewindowEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTimewindow_Length() {
        return (EAttribute)timewindowEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CepFactory getCepFactory() {
        return (CepFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        eventPatternEClass = createEClass(EVENT_PATTERN);
        createEReference(eventPatternEClass, EVENT_PATTERN__AUTOMATON);
        createEAttribute(eventPatternEClass, EVENT_PATTERN__ID);

        atomicEventPatternEClass = createEClass(ATOMIC_EVENT_PATTERN);
        createEAttribute(atomicEventPatternEClass, ATOMIC_EVENT_PATTERN__TYPE);

        complexEventPatternEClass = createEClass(COMPLEX_EVENT_PATTERN);
        createEReference(complexEventPatternEClass, COMPLEX_EVENT_PATTERN__COMPOSITION_EVENTS);
        createEOperation(complexEventPatternEClass, COMPLEX_EVENT_PATTERN___ADD_COMPOSITION_EVENT_PATTERN__EVENTPATTERN);
        createEOperation(complexEventPatternEClass, COMPLEX_EVENT_PATTERN___EVALUATE_PARAMETER_BINDIGS__EVENT);

        eventEClass = createEClass(EVENT);
        createEAttribute(eventEClass, EVENT__TYPE);
        createEAttribute(eventEClass, EVENT__TIMESTAMP);
        createEReference(eventEClass, EVENT__SOURCE);

        iEventSourceEClass = createEClass(IEVENT_SOURCE);
        createEOperation(iEventSourceEClass, IEVENT_SOURCE___GET_ID);

        timewindowEClass = createEClass(TIMEWINDOW);
        createEAttribute(timewindowEClass, TIMEWINDOW__LENGTH);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        AutomatonPackage theAutomatonPackage = (AutomatonPackage)EPackage.Registry.INSTANCE.getEPackage(AutomatonPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        atomicEventPatternEClass.getESuperTypes().add(this.getEventPattern());
        complexEventPatternEClass.getESuperTypes().add(this.getEventPattern());

        // Initialize classes, features, and operations; add parameters
        initEClass(eventPatternEClass, EventPattern.class, "EventPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getEventPattern_Automaton(), theAutomatonPackage.getAutomaton(), theAutomatonPackage.getAutomaton_EventPattern(), "automaton", null, 0, 1, EventPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEventPattern_Id(), ecorePackage.getEString(), "id", null, 0, 1, EventPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(atomicEventPatternEClass, AtomicEventPattern.class, "AtomicEventPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAtomicEventPattern_Type(), ecorePackage.getEString(), "type", null, 0, 1, AtomicEventPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(complexEventPatternEClass, ComplexEventPattern.class, "ComplexEventPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getComplexEventPattern_CompositionEvents(), this.getEventPattern(), null, "compositionEvents", null, 0, 1, ComplexEventPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        EOperation op = initEOperation(getComplexEventPattern__AddCompositionEventPattern__EventPattern(), null, "addCompositionEventPattern", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getEventPattern(), "compositionEventPattern", 1, 1, IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getComplexEventPattern__EvaluateParameterBindigs__Event(), ecorePackage.getEBoolean(), "evaluateParameterBindigs", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getEvent(), "event", 1, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(eventEClass, Event.class, "Event", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getEvent_Type(), ecorePackage.getEString(), "type", null, 1, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEvent_Timestamp(), ecorePackage.getELong(), "timestamp", null, 1, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getEvent_Source(), this.getIEventSource(), null, "source", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(iEventSourceEClass, IEventSource.class, "IEventSource", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEOperation(getIEventSource__GetId(), ecorePackage.getEString(), "getId", 1, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(timewindowEClass, Timewindow.class, "Timewindow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTimewindow_Length(), ecorePackage.getELong(), "length", null, 1, 1, Timewindow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //CepPackageImpl
