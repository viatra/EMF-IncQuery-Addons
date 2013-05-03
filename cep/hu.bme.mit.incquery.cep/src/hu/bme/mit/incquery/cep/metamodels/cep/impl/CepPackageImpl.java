/**
 */
package hu.bme.mit.incquery.cep.metamodels.cep.impl;

import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.CepFactory;
import hu.bme.mit.incquery.cep.metamodels.cep.CepPackage;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;
import hu.bme.mit.incquery.cep.metamodels.cep.NumericCompareOperator;
import hu.bme.mit.incquery.cep.metamodels.cep.Timewindow;

import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage;

import hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum complexOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum numericCompareOperatorEEnum = null;

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
		InternalsmPackageImpl theInternalsmPackage = (InternalsmPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(InternalsmPackage.eNS_URI) instanceof InternalsmPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(InternalsmPackage.eNS_URI) : InternalsmPackage.eINSTANCE);

		// Create package meta-data objects
		theCepPackage.createPackageContents();
		theInternalsmPackage.createPackageContents();

		// Initialize created meta-data
		theCepPackage.initializePackageContents();
		theInternalsmPackage.initializePackageContents();

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
	public EReference getEventPattern_CompositionEvents() {
		return (EReference)eventPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventPattern_StateMachines() {
		return (EReference)eventPatternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventPattern_Id() {
		return (EAttribute)eventPatternEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventPattern_HoldingTime() {
		return (EAttribute)eventPatternEClass.getEStructuralFeatures().get(3);
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
	public EAttribute getComplexEventPattern_Operator() {
		return (EAttribute)complexEventPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComplexEventPattern_Timewindow() {
		return (EReference)complexEventPatternEClass.getEStructuralFeatures().get(1);
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
	public EAttribute getEvent_TypeId() {
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
	public EReference getEvent_EventSource() {
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
	public EEnum getComplexOperator() {
		return complexOperatorEEnum;
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
		createEReference(eventPatternEClass, EVENT_PATTERN__COMPOSITION_EVENTS);
		createEReference(eventPatternEClass, EVENT_PATTERN__STATE_MACHINES);
		createEAttribute(eventPatternEClass, EVENT_PATTERN__ID);
		createEAttribute(eventPatternEClass, EVENT_PATTERN__HOLDING_TIME);

		atomicEventPatternEClass = createEClass(ATOMIC_EVENT_PATTERN);
		createEAttribute(atomicEventPatternEClass, ATOMIC_EVENT_PATTERN__TYPE);

		complexEventPatternEClass = createEClass(COMPLEX_EVENT_PATTERN);
		createEAttribute(complexEventPatternEClass, COMPLEX_EVENT_PATTERN__OPERATOR);
		createEReference(complexEventPatternEClass, COMPLEX_EVENT_PATTERN__TIMEWINDOW);

		eventEClass = createEClass(EVENT);
		createEAttribute(eventEClass, EVENT__TYPE_ID);
		createEAttribute(eventEClass, EVENT__TIMESTAMP);
		createEReference(eventEClass, EVENT__EVENT_SOURCE);

		iEventSourceEClass = createEClass(IEVENT_SOURCE);

		timewindowEClass = createEClass(TIMEWINDOW);
		createEAttribute(timewindowEClass, TIMEWINDOW__LENGTH);

		// Create enums
		complexOperatorEEnum = createEEnum(COMPLEX_OPERATOR);
		numericCompareOperatorEEnum = createEEnum(NUMERIC_COMPARE_OPERATOR);
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
		InternalsmPackage theInternalsmPackage = (InternalsmPackage)EPackage.Registry.INSTANCE.getEPackage(InternalsmPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		atomicEventPatternEClass.getESuperTypes().add(this.getEventPattern());
		complexEventPatternEClass.getESuperTypes().add(this.getEventPattern());

		// Initialize classes and features; add operations and parameters
		initEClass(eventPatternEClass, EventPattern.class, "EventPattern", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEventPattern_CompositionEvents(), this.getEventPattern(), null, "compositionEvents", null, 0, -1, EventPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEventPattern_StateMachines(), theInternalsmPackage.getStateMachine(), theInternalsmPackage.getStateMachine_EventPattern(), "stateMachines", null, 0, 1, EventPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEventPattern_Id(), ecorePackage.getEString(), "id", null, 0, 1, EventPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEventPattern_HoldingTime(), ecorePackage.getELong(), "holdingTime", null, 0, 1, EventPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(atomicEventPatternEClass, AtomicEventPattern.class, "AtomicEventPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAtomicEventPattern_Type(), ecorePackage.getEString(), "type", null, 1, 1, AtomicEventPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(complexEventPatternEClass, ComplexEventPattern.class, "ComplexEventPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComplexEventPattern_Operator(), this.getComplexOperator(), "operator", null, 1, 1, ComplexEventPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComplexEventPattern_Timewindow(), this.getTimewindow(), null, "timewindow", null, 0, 1, ComplexEventPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(complexEventPatternEClass, null, "addCompositionEventPattern", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEventPattern(), "compositionEventPattern", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eventEClass, Event.class, "Event", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEvent_TypeId(), ecorePackage.getEString(), "typeId", null, 1, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_Timestamp(), ecorePackage.getELong(), "timestamp", null, 1, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvent_EventSource(), this.getIEventSource(), null, "eventSource", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iEventSourceEClass, IEventSource.class, "IEventSource", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(timewindowEClass, Timewindow.class, "Timewindow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimewindow_Length(), ecorePackage.getELong(), "length", null, 1, 1, Timewindow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(complexOperatorEEnum, ComplexOperator.class, "ComplexOperator");
		addEEnumLiteral(complexOperatorEEnum, ComplexOperator.ORDERED);
		addEEnumLiteral(complexOperatorEEnum, ComplexOperator.ORDERED_T);
		addEEnumLiteral(complexOperatorEEnum, ComplexOperator.UNORDERED);
		addEEnumLiteral(complexOperatorEEnum, ComplexOperator.UNORDERED_T);

		initEEnum(numericCompareOperatorEEnum, NumericCompareOperator.class, "NumericCompareOperator");

		// Create resource
		createResource(eNS_URI);
	}

} //CepPackageImpl
