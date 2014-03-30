/**
 */
package hu.bme.mit.incquery.cep.metamodels.automaton.impl;

import hu.bme.mit.incquery.cep.metamodels.automaton.Automaton;
import hu.bme.mit.incquery.cep.metamodels.automaton.AutomatonFactory;
import hu.bme.mit.incquery.cep.metamodels.automaton.AutomatonPackage;
import hu.bme.mit.incquery.cep.metamodels.automaton.EventToken;
import hu.bme.mit.incquery.cep.metamodels.automaton.FinalState;
import hu.bme.mit.incquery.cep.metamodels.automaton.Guard;
import hu.bme.mit.incquery.cep.metamodels.automaton.InitState;
import hu.bme.mit.incquery.cep.metamodels.automaton.InternalModel;
import hu.bme.mit.incquery.cep.metamodels.automaton.State;
import hu.bme.mit.incquery.cep.metamodels.automaton.Transition;
import hu.bme.mit.incquery.cep.metamodels.automaton.TrapState;

import hu.bme.mit.incquery.cep.metamodels.cep.CepPackage;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.CepPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AutomatonPackageImpl extends EPackageImpl implements AutomatonPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass internalModelEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass automatonEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass eventTokenEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass stateEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass initStateEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass finalStateEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass trapStateEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass transitionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass guardEClass = null;

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
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.AutomatonPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private AutomatonPackageImpl() {
        super(eNS_URI, AutomatonFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link AutomatonPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static AutomatonPackage init() {
        if (isInited) return (AutomatonPackage)EPackage.Registry.INSTANCE.getEPackage(AutomatonPackage.eNS_URI);

        // Obtain or create and register package
        AutomatonPackageImpl theAutomatonPackage = (AutomatonPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AutomatonPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AutomatonPackageImpl());

        isInited = true;

        // Obtain or create and register interdependencies
        CepPackageImpl theCepPackage = (CepPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CepPackage.eNS_URI) instanceof CepPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CepPackage.eNS_URI) : CepPackage.eINSTANCE);

        // Create package meta-data objects
        theAutomatonPackage.createPackageContents();
        theCepPackage.createPackageContents();

        // Initialize created meta-data
        theAutomatonPackage.initializePackageContents();
        theCepPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theAutomatonPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(AutomatonPackage.eNS_URI, theAutomatonPackage);
        return theAutomatonPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInternalModel() {
        return internalModelEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInternalModel_Automata() {
        return (EReference)internalModelEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInternalModel_LatestEvent() {
        return (EReference)internalModelEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInternalModel_EventTokens() {
        return (EReference)internalModelEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAutomaton() {
        return automatonEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAutomaton_States() {
        return (EReference)automatonEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAutomaton_EventPattern() {
        return (EReference)automatonEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEventToken() {
        return eventTokenEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEventToken_CurrentState() {
        return (EReference)eventTokenEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEventToken_RecordedEvents() {
        return (EReference)eventTokenEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getState() {
        return stateEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getState_InTransitions() {
        return (EReference)stateEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getState_OutTransitions() {
        return (EReference)stateEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getState_Label() {
        return (EAttribute)stateEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getState_EventTokens() {
        return (EReference)stateEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getState_LastProcessedEvent() {
        return (EReference)stateEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInitState() {
        return initStateEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFinalState() {
        return finalStateEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTrapState() {
        return trapStateEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTransition() {
        return transitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTransition_PreState() {
        return (EReference)transitionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTransition_PostState() {
        return (EReference)transitionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTransition_Guard() {
        return (EReference)transitionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGuard() {
        return guardEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGuard_EventType() {
        return (EReference)guardEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AutomatonFactory getAutomatonFactory() {
        return (AutomatonFactory)getEFactoryInstance();
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
        internalModelEClass = createEClass(INTERNAL_MODEL);
        createEReference(internalModelEClass, INTERNAL_MODEL__AUTOMATA);
        createEReference(internalModelEClass, INTERNAL_MODEL__LATEST_EVENT);
        createEReference(internalModelEClass, INTERNAL_MODEL__EVENT_TOKENS);

        automatonEClass = createEClass(AUTOMATON);
        createEReference(automatonEClass, AUTOMATON__STATES);
        createEReference(automatonEClass, AUTOMATON__EVENT_PATTERN);

        eventTokenEClass = createEClass(EVENT_TOKEN);
        createEReference(eventTokenEClass, EVENT_TOKEN__CURRENT_STATE);
        createEReference(eventTokenEClass, EVENT_TOKEN__RECORDED_EVENTS);

        stateEClass = createEClass(STATE);
        createEReference(stateEClass, STATE__IN_TRANSITIONS);
        createEReference(stateEClass, STATE__OUT_TRANSITIONS);
        createEAttribute(stateEClass, STATE__LABEL);
        createEReference(stateEClass, STATE__EVENT_TOKENS);
        createEReference(stateEClass, STATE__LAST_PROCESSED_EVENT);

        initStateEClass = createEClass(INIT_STATE);

        finalStateEClass = createEClass(FINAL_STATE);

        trapStateEClass = createEClass(TRAP_STATE);

        transitionEClass = createEClass(TRANSITION);
        createEReference(transitionEClass, TRANSITION__PRE_STATE);
        createEReference(transitionEClass, TRANSITION__POST_STATE);
        createEReference(transitionEClass, TRANSITION__GUARD);

        guardEClass = createEClass(GUARD);
        createEReference(guardEClass, GUARD__EVENT_TYPE);
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
        CepPackage theCepPackage = (CepPackage)EPackage.Registry.INSTANCE.getEPackage(CepPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        initStateEClass.getESuperTypes().add(this.getState());
        finalStateEClass.getESuperTypes().add(this.getState());
        trapStateEClass.getESuperTypes().add(this.getState());

        // Initialize classes, features, and operations; add parameters
        initEClass(internalModelEClass, InternalModel.class, "InternalModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getInternalModel_Automata(), this.getAutomaton(), null, "automata", null, 0, -1, InternalModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInternalModel_LatestEvent(), theCepPackage.getEvent(), null, "latestEvent", null, 0, 1, InternalModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInternalModel_EventTokens(), this.getEventToken(), null, "eventTokens", null, 0, -1, InternalModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(automatonEClass, Automaton.class, "Automaton", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getAutomaton_States(), this.getState(), null, "states", null, 0, -1, Automaton.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAutomaton_EventPattern(), theCepPackage.getEventPattern(), theCepPackage.getEventPattern_Automaton(), "eventPattern", null, 1, 1, Automaton.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(eventTokenEClass, EventToken.class, "EventToken", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getEventToken_CurrentState(), this.getState(), this.getState_EventTokens(), "currentState", null, 0, 1, EventToken.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getEventToken_RecordedEvents(), theCepPackage.getEvent(), null, "recordedEvents", null, 0, -1, EventToken.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(stateEClass, State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getState_InTransitions(), this.getTransition(), this.getTransition_PostState(), "inTransitions", null, 0, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getState_OutTransitions(), this.getTransition(), this.getTransition_PreState(), "outTransitions", null, 0, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getState_Label(), ecorePackage.getEString(), "label", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getState_EventTokens(), this.getEventToken(), this.getEventToken_CurrentState(), "eventTokens", null, 0, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getState_LastProcessedEvent(), theCepPackage.getEvent(), null, "lastProcessedEvent", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(initStateEClass, InitState.class, "InitState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(finalStateEClass, FinalState.class, "FinalState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(trapStateEClass, TrapState.class, "TrapState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(transitionEClass, Transition.class, "Transition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTransition_PreState(), this.getState(), this.getState_OutTransitions(), "preState", null, 0, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTransition_PostState(), this.getState(), this.getState_InTransitions(), "postState", null, 0, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTransition_Guard(), this.getGuard(), null, "guard", null, 0, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(guardEClass, Guard.class, "Guard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getGuard_EventType(), theCepPackage.getAtomicEventPattern(), null, "eventType", null, 1, 1, Guard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //AutomatonPackageImpl
