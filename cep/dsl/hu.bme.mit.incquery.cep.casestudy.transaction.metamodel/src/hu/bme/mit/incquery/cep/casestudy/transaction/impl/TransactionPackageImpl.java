/**
 */
package hu.bme.mit.incquery.cep.casestudy.transaction.impl;

import hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent;
import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionFactory;
import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
     * @see hu.bme.mit.incquery.cep.casestudy.transaction.TransactionPackage#eNS_URI
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
    public EClass getCompoundTransactionEvent() {
        return compoundTransactionEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCompoundTransactionEvent_Timestamp() {
        return (EAttribute)compoundTransactionEventEClass.getEStructuralFeatures().get(0);
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
        compoundTransactionEventEClass = createEClass(COMPOUND_TRANSACTION_EVENT);
        createEAttribute(compoundTransactionEventEClass, COMPOUND_TRANSACTION_EVENT__TIMESTAMP);
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

        // Initialize classes, features, and operations; add parameters
        initEClass(compoundTransactionEventEClass, CompoundTransactionEvent.class, "CompoundTransactionEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCompoundTransactionEvent_Timestamp(), ecorePackage.getELong(), "timestamp", null, 0, 1, CompoundTransactionEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //TransactionPackageImpl
