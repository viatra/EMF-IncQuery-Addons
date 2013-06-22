/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm.impl;

import hu.bme.mit.incquery.cep.metamodels.cep.CepPackage;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.CepPackageImpl;

import hu.bme.mit.incquery.cep.metamodels.internalsm.EventCollection;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken;
import hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Guard;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InitState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmFactory;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage;
import hu.bme.mit.incquery.cep.metamodels.internalsm.NumericCompareOperator;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintSpecification;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintType;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TrapState;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
public class InternalsmPackageImpl extends EPackageImpl implements InternalsmPackage {
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
	private EClass transitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass guardEClass = null;

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
	private EClass initStateEClass = null;

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
	private EClass stateMachineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalExecutionModelEClass = null;

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
	private EClass eventCollectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timeConstraintSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timeConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum numericCompareOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum timeConstraintTypeEEnum = null;

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
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private InternalsmPackageImpl() {
		super(eNS_URI, InternalsmFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link InternalsmPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static InternalsmPackage init() {
		if (isInited) return (InternalsmPackage)EPackage.Registry.INSTANCE.getEPackage(InternalsmPackage.eNS_URI);

		// Obtain or create and register package
		InternalsmPackageImpl theInternalsmPackage = (InternalsmPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof InternalsmPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new InternalsmPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		CepPackageImpl theCepPackage = (CepPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CepPackage.eNS_URI) instanceof CepPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CepPackage.eNS_URI) : CepPackage.eINSTANCE);

		// Create package meta-data objects
		theInternalsmPackage.createPackageContents();
		theCepPackage.createPackageContents();

		// Initialize created meta-data
		theInternalsmPackage.initializePackageContents();
		theCepPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theInternalsmPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(InternalsmPackage.eNS_URI, theInternalsmPackage);
		return theInternalsmPackage;
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
	public EReference getState_OutTransitions() {
		return (EReference)stateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getState_InTransitions() {
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
	public EReference getState_TimeConstraints() {
		return (EReference)stateEClass.getEStructuralFeatures().get(4);
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
	public EReference getTransition_Guard() {
		return (EReference)transitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransition_PostState() {
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
	public EClass getFinalState() {
		return finalStateEClass;
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
	public EClass getTrapState() {
		return trapStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateMachine() {
		return stateMachineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMachine_States() {
		return (EReference)stateMachineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMachine_EventPattern() {
		return (EReference)stateMachineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInternalExecutionModel() {
		return internalExecutionModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInternalExecutionModel_StateMachines() {
		return (EReference)internalExecutionModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInternalExecutionModel_LatestEvent() {
		return (EReference)internalExecutionModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInternalExecutionModel_EventTokens() {
		return (EReference)internalExecutionModelEClass.getEStructuralFeatures().get(2);
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
	public EReference getEventToken_EventCollection() {
		return (EReference)eventTokenEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventCollection() {
		return eventCollectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventCollection_EventToken() {
		return (EReference)eventCollectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimeConstraintSpecification() {
		return timeConstraintSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeConstraintSpecification_Id() {
		return (EAttribute)timeConstraintSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeConstraintSpecification_ExpectedLength() {
		return (EAttribute)timeConstraintSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeConstraintSpecification_StartTimestamp() {
		return (EAttribute)timeConstraintSpecificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeConstraintSpecification_StopTimestamp() {
		return (EAttribute)timeConstraintSpecificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimeConstraint() {
		return timeConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeConstraint_Type() {
		return (EAttribute)timeConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimeConstraint_TimeConstraintSpecification() {
		return (EReference)timeConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getNumericCompareOperator() {
		return numericCompareOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTimeConstraintType() {
		return timeConstraintTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalsmFactory getInternalsmFactory() {
		return (InternalsmFactory)getEFactoryInstance();
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
		stateEClass = createEClass(STATE);
		createEReference(stateEClass, STATE__OUT_TRANSITIONS);
		createEReference(stateEClass, STATE__IN_TRANSITIONS);
		createEAttribute(stateEClass, STATE__LABEL);
		createEReference(stateEClass, STATE__EVENT_TOKENS);
		createEReference(stateEClass, STATE__TIME_CONSTRAINTS);

		transitionEClass = createEClass(TRANSITION);
		createEReference(transitionEClass, TRANSITION__PRE_STATE);
		createEReference(transitionEClass, TRANSITION__GUARD);
		createEReference(transitionEClass, TRANSITION__POST_STATE);

		guardEClass = createEClass(GUARD);
		createEReference(guardEClass, GUARD__EVENT_TYPE);

		finalStateEClass = createEClass(FINAL_STATE);

		initStateEClass = createEClass(INIT_STATE);

		trapStateEClass = createEClass(TRAP_STATE);

		stateMachineEClass = createEClass(STATE_MACHINE);
		createEReference(stateMachineEClass, STATE_MACHINE__STATES);
		createEReference(stateMachineEClass, STATE_MACHINE__EVENT_PATTERN);

		internalExecutionModelEClass = createEClass(INTERNAL_EXECUTION_MODEL);
		createEReference(internalExecutionModelEClass, INTERNAL_EXECUTION_MODEL__STATE_MACHINES);
		createEReference(internalExecutionModelEClass, INTERNAL_EXECUTION_MODEL__LATEST_EVENT);
		createEReference(internalExecutionModelEClass, INTERNAL_EXECUTION_MODEL__EVENT_TOKENS);

		eventTokenEClass = createEClass(EVENT_TOKEN);
		createEReference(eventTokenEClass, EVENT_TOKEN__CURRENT_STATE);
		createEReference(eventTokenEClass, EVENT_TOKEN__EVENT_COLLECTION);

		eventCollectionEClass = createEClass(EVENT_COLLECTION);
		createEReference(eventCollectionEClass, EVENT_COLLECTION__EVENT_TOKEN);

		timeConstraintSpecificationEClass = createEClass(TIME_CONSTRAINT_SPECIFICATION);
		createEAttribute(timeConstraintSpecificationEClass, TIME_CONSTRAINT_SPECIFICATION__ID);
		createEAttribute(timeConstraintSpecificationEClass, TIME_CONSTRAINT_SPECIFICATION__EXPECTED_LENGTH);
		createEAttribute(timeConstraintSpecificationEClass, TIME_CONSTRAINT_SPECIFICATION__START_TIMESTAMP);
		createEAttribute(timeConstraintSpecificationEClass, TIME_CONSTRAINT_SPECIFICATION__STOP_TIMESTAMP);

		timeConstraintEClass = createEClass(TIME_CONSTRAINT);
		createEAttribute(timeConstraintEClass, TIME_CONSTRAINT__TYPE);
		createEReference(timeConstraintEClass, TIME_CONSTRAINT__TIME_CONSTRAINT_SPECIFICATION);

		// Create enums
		numericCompareOperatorEEnum = createEEnum(NUMERIC_COMPARE_OPERATOR);
		timeConstraintTypeEEnum = createEEnum(TIME_CONSTRAINT_TYPE);
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
		finalStateEClass.getESuperTypes().add(this.getState());
		initStateEClass.getESuperTypes().add(this.getState());
		trapStateEClass.getESuperTypes().add(this.getState());

		// Initialize classes and features; add operations and parameters
		initEClass(stateEClass, State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getState_OutTransitions(), this.getTransition(), this.getTransition_PreState(), "outTransitions", null, 0, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getState_InTransitions(), this.getTransition(), this.getTransition_PostState(), "inTransitions", null, 0, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getState_Label(), ecorePackage.getEString(), "label", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getState_EventTokens(), this.getEventToken(), this.getEventToken_CurrentState(), "eventTokens", null, 0, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getState_TimeConstraints(), this.getTimeConstraint(), null, "timeConstraints", null, 0, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transitionEClass, Transition.class, "Transition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransition_PreState(), this.getState(), this.getState_OutTransitions(), "preState", null, 1, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransition_Guard(), this.getGuard(), null, "guard", null, 0, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransition_PostState(), this.getState(), this.getState_InTransitions(), "postState", null, 1, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(guardEClass, Guard.class, "Guard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGuard_EventType(), theCepPackage.getAtomicEventPattern(), null, "eventType", null, 1, 1, Guard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(finalStateEClass, FinalState.class, "FinalState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(initStateEClass, InitState.class, "InitState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(trapStateEClass, TrapState.class, "TrapState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stateMachineEClass, StateMachine.class, "StateMachine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateMachine_States(), this.getState(), null, "states", null, 0, -1, StateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateMachine_EventPattern(), theCepPackage.getEventPattern(), theCepPackage.getEventPattern_StateMachines(), "eventPattern", null, 1, 1, StateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(internalExecutionModelEClass, InternalExecutionModel.class, "InternalExecutionModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInternalExecutionModel_StateMachines(), this.getStateMachine(), null, "stateMachines", null, 0, -1, InternalExecutionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInternalExecutionModel_LatestEvent(), theCepPackage.getEvent(), null, "latestEvent", null, 0, 1, InternalExecutionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInternalExecutionModel_EventTokens(), this.getEventToken(), null, "eventTokens", null, 0, -1, InternalExecutionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventTokenEClass, EventToken.class, "EventToken", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEventToken_CurrentState(), this.getState(), this.getState_EventTokens(), "currentState", null, 0, 1, EventToken.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEventToken_EventCollection(), this.getEventCollection(), this.getEventCollection_EventToken(), "eventCollection", null, 0, 1, EventToken.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventCollectionEClass, EventCollection.class, "EventCollection", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEventCollection_EventToken(), this.getEventToken(), this.getEventToken_EventCollection(), "eventToken", null, 1, 1, EventCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(eventCollectionEClass, ecorePackage.getEJavaObject(), "getRecordedEvents", 1, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = addEOperation(eventCollectionEClass, null, "addEvent", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCepPackage.getEvent(), "event", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(timeConstraintSpecificationEClass, TimeConstraintSpecification.class, "TimeConstraintSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimeConstraintSpecification_Id(), ecorePackage.getEString(), "id", null, 0, 1, TimeConstraintSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimeConstraintSpecification_ExpectedLength(), ecorePackage.getELong(), "expectedLength", null, 1, 1, TimeConstraintSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimeConstraintSpecification_StartTimestamp(), ecorePackage.getELong(), "startTimestamp", null, 0, 1, TimeConstraintSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimeConstraintSpecification_StopTimestamp(), ecorePackage.getELong(), "stopTimestamp", null, 0, 1, TimeConstraintSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(timeConstraintSpecificationEClass, null, "handleTimeConstraint", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(timeConstraintEClass, TimeConstraint.class, "TimeConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimeConstraint_Type(), this.getTimeConstraintType(), "type", null, 0, 1, TimeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTimeConstraint_TimeConstraintSpecification(), this.getTimeConstraintSpecification(), null, "timeConstraintSpecification", null, 1, 1, TimeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(numericCompareOperatorEEnum, NumericCompareOperator.class, "NumericCompareOperator");
		addEEnumLiteral(numericCompareOperatorEEnum, NumericCompareOperator.LESS_THAN);
		addEEnumLiteral(numericCompareOperatorEEnum, NumericCompareOperator.LESS_OR_EQUALS);
		addEEnumLiteral(numericCompareOperatorEEnum, NumericCompareOperator.EQUALS);
		addEEnumLiteral(numericCompareOperatorEEnum, NumericCompareOperator.MORE_OR_EQUALS);
		addEEnumLiteral(numericCompareOperatorEEnum, NumericCompareOperator.MORE_THAN);

		initEEnum(timeConstraintTypeEEnum, TimeConstraintType.class, "TimeConstraintType");
		addEEnumLiteral(timeConstraintTypeEEnum, TimeConstraintType.START);
		addEEnumLiteral(timeConstraintTypeEEnum, TimeConstraintType.STOP);
		addEEnumLiteral(timeConstraintTypeEEnum, TimeConstraintType.CHECK);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (getState_OutTransitions(), 
		   source, 
		   new String[] {
			 "wildcards", "",
			 "name", ""
		   });
	}

} //InternalsmPackageImpl
