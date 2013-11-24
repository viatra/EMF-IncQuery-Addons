/**
 */
package hu.bme.mit.incquery.cep.casestudy.transaction;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see hu.bme.mit.incquery.cep.casestudy.transaction.TransactionFactory
 * @model kind="package"
 * @generated
 */
public interface TransactionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "transaction";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "transaction.meta";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "hu.bme.mit.incquery.cep.casestudy.transaction";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TransactionPackage eINSTANCE = hu.bme.mit.incquery.cep.casestudy.transaction.impl.TransactionPackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.casestudy.transaction.impl.TransactionModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.TransactionModelImpl
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.TransactionPackageImpl#getTransactionModel()
	 * @generated
	 */
	int TRANSACTION_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Latest Component Event</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_MODEL__LATEST_COMPONENT_EVENT = 0;

	/**
	 * The feature id for the '<em><b>Compound Transaction Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_MODEL__COMPOUND_TRANSACTION_EVENTS = 1;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_MODEL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.casestudy.transaction.impl.ModelElementImpl <em>Model Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.ModelElementImpl
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.TransactionPackageImpl#getModelElement()
	 * @generated
	 */
	int MODEL_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>Transaction Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__TRANSACTION_ID = 0;

	/**
	 * The number of structural features of the '<em>Model Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Model Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.casestudy.transaction.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.ComponentImpl
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.TransactionPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>Transaction Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__TRANSACTION_ID = MODEL_ELEMENT__TRANSACTION_ID;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__TIMESTAMP = MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_OPERATION_COUNT = MODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.casestudy.transaction.impl.ComponentAImpl <em>Component A</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.ComponentAImpl
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.TransactionPackageImpl#getComponentA()
	 * @generated
	 */
	int COMPONENT_A = 2;

	/**
	 * The feature id for the '<em><b>Transaction Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_A__TRANSACTION_ID = COMPONENT__TRANSACTION_ID;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_A__TIMESTAMP = COMPONENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Customer Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_A__CUSTOMER_ID = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Component A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_A_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Component A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_A_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.casestudy.transaction.impl.ComponentBImpl <em>Component B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.ComponentBImpl
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.TransactionPackageImpl#getComponentB()
	 * @generated
	 */
	int COMPONENT_B = 3;

	/**
	 * The feature id for the '<em><b>Transaction Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_B__TRANSACTION_ID = COMPONENT__TRANSACTION_ID;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_B__TIMESTAMP = COMPONENT__TIMESTAMP;

	/**
	 * The number of structural features of the '<em>Component B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_B_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Component B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_B_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.casestudy.transaction.impl.ComponentCImpl <em>Component C</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.ComponentCImpl
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.TransactionPackageImpl#getComponentC()
	 * @generated
	 */
	int COMPONENT_C = 4;

	/**
	 * The feature id for the '<em><b>Transaction Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_C__TRANSACTION_ID = COMPONENT__TRANSACTION_ID;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_C__TIMESTAMP = COMPONENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Supplier Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_C__SUPPLIER_ID = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Component C</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_C_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Component C</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_C_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.casestudy.transaction.impl.CompoundTransactionEventImpl <em>Compound Transaction Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.CompoundTransactionEventImpl
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.TransactionPackageImpl#getCompoundTransactionEvent()
	 * @generated
	 */
	int COMPOUND_TRANSACTION_EVENT = 5;

	/**
	 * The feature id for the '<em><b>Transaction Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_TRANSACTION_EVENT__TRANSACTION_ID = MODEL_ELEMENT__TRANSACTION_ID;

	/**
	 * The feature id for the '<em><b>Customer Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_TRANSACTION_EVENT__CUSTOMER_ID = MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Timestamp A</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_TRANSACTION_EVENT__TIMESTAMP_A = MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Timestamp B</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_TRANSACTION_EVENT__TIMESTAMP_B = MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Timestamp C</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_TRANSACTION_EVENT__TIMESTAMP_C = MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Compound Transaction Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_TRANSACTION_EVENT_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Compound Transaction Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_TRANSACTION_EVENT_OPERATION_COUNT = MODEL_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.casestudy.transaction.TransactionModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.TransactionModel
	 * @generated
	 */
	EClass getTransactionModel();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.casestudy.transaction.TransactionModel#getLatestComponentEvent <em>Latest Component Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Latest Component Event</em>'.
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.TransactionModel#getLatestComponentEvent()
	 * @see #getTransactionModel()
	 * @generated
	 */
	EReference getTransactionModel_LatestComponentEvent();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.casestudy.transaction.TransactionModel#getCompoundTransactionEvents <em>Compound Transaction Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Compound Transaction Events</em>'.
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.TransactionModel#getCompoundTransactionEvents()
	 * @see #getTransactionModel()
	 * @generated
	 */
	EReference getTransactionModel_CompoundTransactionEvents();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.casestudy.transaction.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.casestudy.transaction.Component#getTimestamp <em>Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timestamp</em>'.
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.Component#getTimestamp()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_Timestamp();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.casestudy.transaction.ComponentA <em>Component A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component A</em>'.
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.ComponentA
	 * @generated
	 */
	EClass getComponentA();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.casestudy.transaction.ComponentA#getCustomerId <em>Customer Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Customer Id</em>'.
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.ComponentA#getCustomerId()
	 * @see #getComponentA()
	 * @generated
	 */
	EAttribute getComponentA_CustomerId();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.casestudy.transaction.ComponentB <em>Component B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component B</em>'.
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.ComponentB
	 * @generated
	 */
	EClass getComponentB();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.casestudy.transaction.ComponentC <em>Component C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component C</em>'.
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.ComponentC
	 * @generated
	 */
	EClass getComponentC();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.casestudy.transaction.ComponentC#getSupplierId <em>Supplier Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Supplier Id</em>'.
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.ComponentC#getSupplierId()
	 * @see #getComponentC()
	 * @generated
	 */
	EAttribute getComponentC_SupplierId();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent <em>Compound Transaction Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compound Transaction Event</em>'.
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent
	 * @generated
	 */
	EClass getCompoundTransactionEvent();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent#getCustomerId <em>Customer Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Customer Id</em>'.
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent#getCustomerId()
	 * @see #getCompoundTransactionEvent()
	 * @generated
	 */
	EAttribute getCompoundTransactionEvent_CustomerId();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent#getTimestampA <em>Timestamp A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timestamp A</em>'.
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent#getTimestampA()
	 * @see #getCompoundTransactionEvent()
	 * @generated
	 */
	EAttribute getCompoundTransactionEvent_TimestampA();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent#getTimestampB <em>Timestamp B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timestamp B</em>'.
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent#getTimestampB()
	 * @see #getCompoundTransactionEvent()
	 * @generated
	 */
	EAttribute getCompoundTransactionEvent_TimestampB();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent#getTimestampC <em>Timestamp C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timestamp C</em>'.
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent#getTimestampC()
	 * @see #getCompoundTransactionEvent()
	 * @generated
	 */
	EAttribute getCompoundTransactionEvent_TimestampC();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.casestudy.transaction.ModelElement <em>Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element</em>'.
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.ModelElement
	 * @generated
	 */
	EClass getModelElement();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.casestudy.transaction.ModelElement#getTransactionId <em>Transaction Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transaction Id</em>'.
	 * @see hu.bme.mit.incquery.cep.casestudy.transaction.ModelElement#getTransactionId()
	 * @see #getModelElement()
	 * @generated
	 */
	EAttribute getModelElement_TransactionId();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TransactionFactory getTransactionFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.casestudy.transaction.impl.TransactionModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.TransactionModelImpl
		 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.TransactionPackageImpl#getTransactionModel()
		 * @generated
		 */
		EClass TRANSACTION_MODEL = eINSTANCE.getTransactionModel();

		/**
		 * The meta object literal for the '<em><b>Latest Component Event</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSACTION_MODEL__LATEST_COMPONENT_EVENT = eINSTANCE.getTransactionModel_LatestComponentEvent();

		/**
		 * The meta object literal for the '<em><b>Compound Transaction Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSACTION_MODEL__COMPOUND_TRANSACTION_EVENTS = eINSTANCE.getTransactionModel_CompoundTransactionEvents();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.casestudy.transaction.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.ComponentImpl
		 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.TransactionPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Timestamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__TIMESTAMP = eINSTANCE.getComponent_Timestamp();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.casestudy.transaction.impl.ComponentAImpl <em>Component A</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.ComponentAImpl
		 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.TransactionPackageImpl#getComponentA()
		 * @generated
		 */
		EClass COMPONENT_A = eINSTANCE.getComponentA();

		/**
		 * The meta object literal for the '<em><b>Customer Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_A__CUSTOMER_ID = eINSTANCE.getComponentA_CustomerId();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.casestudy.transaction.impl.ComponentBImpl <em>Component B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.ComponentBImpl
		 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.TransactionPackageImpl#getComponentB()
		 * @generated
		 */
		EClass COMPONENT_B = eINSTANCE.getComponentB();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.casestudy.transaction.impl.ComponentCImpl <em>Component C</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.ComponentCImpl
		 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.TransactionPackageImpl#getComponentC()
		 * @generated
		 */
		EClass COMPONENT_C = eINSTANCE.getComponentC();

		/**
		 * The meta object literal for the '<em><b>Supplier Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_C__SUPPLIER_ID = eINSTANCE.getComponentC_SupplierId();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.casestudy.transaction.impl.CompoundTransactionEventImpl <em>Compound Transaction Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.CompoundTransactionEventImpl
		 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.TransactionPackageImpl#getCompoundTransactionEvent()
		 * @generated
		 */
		EClass COMPOUND_TRANSACTION_EVENT = eINSTANCE.getCompoundTransactionEvent();

		/**
		 * The meta object literal for the '<em><b>Customer Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOUND_TRANSACTION_EVENT__CUSTOMER_ID = eINSTANCE.getCompoundTransactionEvent_CustomerId();

		/**
		 * The meta object literal for the '<em><b>Timestamp A</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOUND_TRANSACTION_EVENT__TIMESTAMP_A = eINSTANCE.getCompoundTransactionEvent_TimestampA();

		/**
		 * The meta object literal for the '<em><b>Timestamp B</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOUND_TRANSACTION_EVENT__TIMESTAMP_B = eINSTANCE.getCompoundTransactionEvent_TimestampB();

		/**
		 * The meta object literal for the '<em><b>Timestamp C</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOUND_TRANSACTION_EVENT__TIMESTAMP_C = eINSTANCE.getCompoundTransactionEvent_TimestampC();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.casestudy.transaction.impl.ModelElementImpl <em>Model Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.ModelElementImpl
		 * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.TransactionPackageImpl#getModelElement()
		 * @generated
		 */
		EClass MODEL_ELEMENT = eINSTANCE.getModelElement();

		/**
		 * The meta object literal for the '<em><b>Transaction Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT__TRANSACTION_ID = eINSTANCE.getModelElement_TransactionId();

	}

} //TransactionPackage
