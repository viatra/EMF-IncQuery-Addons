/**
 */
package hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl;

import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.Component;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.CompoundTransactionEvent;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.ModelElement;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentA;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentB;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentC;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentD;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentE;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentF;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentG;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentH;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentI;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentJ;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionFactory;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionModel;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionPackage;

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
public class TransactionPackageImpl extends EPackageImpl implements TransactionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transactionModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transactionComponentAEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transactionComponentBEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transactionComponentCEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transactionComponentDEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transactionComponentEEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transactionComponentFEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transactionComponentGEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transactionComponentHEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transactionComponentIEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transactionComponentJEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compoundTransactionEventEClass = null;

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
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TransactionPackageImpl() {
		super(eNS_URI, TransactionFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TransactionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TransactionPackage init() {
		if (isInited) return (TransactionPackage)EPackage.Registry.INSTANCE.getEPackage(TransactionPackage.eNS_URI);

		// Obtain or create and register package
		TransactionPackageImpl theTransactionPackage = (TransactionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TransactionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TransactionPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theTransactionPackage.createPackageContents();

		// Initialize created meta-data
		theTransactionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTransactionPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TransactionPackage.eNS_URI, theTransactionPackage);
		return theTransactionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransactionModel() {
		return transactionModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransactionModel_LatestComponentEvent() {
		return (EReference)transactionModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransactionModel_LatestCompoundEvent() {
		return (EReference)transactionModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelElement() {
		return modelElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelElement_TransactionId() {
		return (EAttribute)modelElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponent() {
		return componentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransactionComponentA() {
		return transactionComponentAEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransactionComponentB() {
		return transactionComponentBEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransactionComponentC() {
		return transactionComponentCEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransactionComponentD() {
		return transactionComponentDEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransactionComponentE() {
		return transactionComponentEEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransactionComponentF() {
		return transactionComponentFEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransactionComponentG() {
		return transactionComponentGEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransactionComponentH() {
		return transactionComponentHEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransactionComponentI() {
		return transactionComponentIEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransactionComponentJ() {
		return transactionComponentJEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompoundTransactionEvent() {
		return compoundTransactionEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransactionFactory getTransactionFactory() {
		return (TransactionFactory)getEFactoryInstance();
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
		transactionModelEClass = createEClass(TRANSACTION_MODEL);
		createEReference(transactionModelEClass, TRANSACTION_MODEL__LATEST_COMPONENT_EVENT);
		createEReference(transactionModelEClass, TRANSACTION_MODEL__LATEST_COMPOUND_EVENT);

		modelElementEClass = createEClass(MODEL_ELEMENT);
		createEAttribute(modelElementEClass, MODEL_ELEMENT__TRANSACTION_ID);

		componentEClass = createEClass(COMPONENT);

		transactionComponentAEClass = createEClass(TRANSACTION_COMPONENT_A);

		transactionComponentBEClass = createEClass(TRANSACTION_COMPONENT_B);

		transactionComponentCEClass = createEClass(TRANSACTION_COMPONENT_C);

		transactionComponentDEClass = createEClass(TRANSACTION_COMPONENT_D);

		transactionComponentEEClass = createEClass(TRANSACTION_COMPONENT_E);

		transactionComponentFEClass = createEClass(TRANSACTION_COMPONENT_F);

		transactionComponentGEClass = createEClass(TRANSACTION_COMPONENT_G);

		transactionComponentHEClass = createEClass(TRANSACTION_COMPONENT_H);

		transactionComponentIEClass = createEClass(TRANSACTION_COMPONENT_I);

		transactionComponentJEClass = createEClass(TRANSACTION_COMPONENT_J);

		compoundTransactionEventEClass = createEClass(COMPOUND_TRANSACTION_EVENT);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		componentEClass.getESuperTypes().add(this.getModelElement());
		transactionComponentAEClass.getESuperTypes().add(this.getComponent());
		transactionComponentBEClass.getESuperTypes().add(this.getComponent());
		transactionComponentCEClass.getESuperTypes().add(this.getComponent());
		transactionComponentDEClass.getESuperTypes().add(this.getComponent());
		transactionComponentEEClass.getESuperTypes().add(this.getComponent());
		transactionComponentFEClass.getESuperTypes().add(this.getComponent());
		transactionComponentGEClass.getESuperTypes().add(this.getComponent());
		transactionComponentHEClass.getESuperTypes().add(this.getComponent());
		transactionComponentIEClass.getESuperTypes().add(this.getComponent());
		transactionComponentJEClass.getESuperTypes().add(this.getComponent());
		compoundTransactionEventEClass.getESuperTypes().add(this.getModelElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(transactionModelEClass, TransactionModel.class, "TransactionModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransactionModel_LatestComponentEvent(), this.getComponent(), null, "latestComponentEvent", null, 0, 1, TransactionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransactionModel_LatestCompoundEvent(), this.getCompoundTransactionEvent(), null, "latestCompoundEvent", null, 0, 1, TransactionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelElementEClass, ModelElement.class, "ModelElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelElement_TransactionId(), ecorePackage.getEString(), "transactionId", null, 0, 1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentEClass, Component.class, "Component", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(transactionComponentAEClass, TransactionComponentA.class, "TransactionComponentA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(transactionComponentBEClass, TransactionComponentB.class, "TransactionComponentB", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(transactionComponentCEClass, TransactionComponentC.class, "TransactionComponentC", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(transactionComponentDEClass, TransactionComponentD.class, "TransactionComponentD", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(transactionComponentEEClass, TransactionComponentE.class, "TransactionComponentE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(transactionComponentFEClass, TransactionComponentF.class, "TransactionComponentF", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(transactionComponentGEClass, TransactionComponentG.class, "TransactionComponentG", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(transactionComponentHEClass, TransactionComponentH.class, "TransactionComponentH", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(transactionComponentIEClass, TransactionComponentI.class, "TransactionComponentI", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(transactionComponentJEClass, TransactionComponentJ.class, "TransactionComponentJ", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compoundTransactionEventEClass, CompoundTransactionEvent.class, "CompoundTransactionEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //TransactionPackageImpl
