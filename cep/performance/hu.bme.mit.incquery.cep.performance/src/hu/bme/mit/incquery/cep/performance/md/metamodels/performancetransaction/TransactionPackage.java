/**
 */
package hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction;

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
 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionFactory
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
	String eNAME = "performancetransaction";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "performance.transaction.meta";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "hu.bme.mit.incquery.cep.performance.md.transaction";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TransactionPackage eINSTANCE = hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionModelImpl
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getTransactionModel()
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
	 * The feature id for the '<em><b>Latest Compound Event</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_MODEL__LATEST_COMPOUND_EVENT = 1;

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
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.ModelElementImpl <em>Model Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.ModelElementImpl
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getModelElement()
	 * @generated
	 */
	int MODEL_ELEMENT = 1;

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
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.ComponentImpl
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 2;

	/**
	 * The feature id for the '<em><b>Transaction Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__TRANSACTION_ID = MODEL_ELEMENT__TRANSACTION_ID;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_OPERATION_COUNT = MODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentAImpl <em>Component A</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentAImpl
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getTransactionComponentA()
	 * @generated
	 */
	int TRANSACTION_COMPONENT_A = 3;

	/**
	 * The feature id for the '<em><b>Transaction Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_A__TRANSACTION_ID = COMPONENT__TRANSACTION_ID;

	/**
	 * The number of structural features of the '<em>Component A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_A_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Component A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_A_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentBImpl <em>Component B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentBImpl
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getTransactionComponentB()
	 * @generated
	 */
	int TRANSACTION_COMPONENT_B = 4;

	/**
	 * The feature id for the '<em><b>Transaction Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_B__TRANSACTION_ID = COMPONENT__TRANSACTION_ID;

	/**
	 * The number of structural features of the '<em>Component B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_B_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Component B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_B_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentCImpl <em>Component C</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentCImpl
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getTransactionComponentC()
	 * @generated
	 */
	int TRANSACTION_COMPONENT_C = 5;

	/**
	 * The feature id for the '<em><b>Transaction Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_C__TRANSACTION_ID = COMPONENT__TRANSACTION_ID;

	/**
	 * The number of structural features of the '<em>Component C</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_C_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Component C</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_C_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentDImpl <em>Component D</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentDImpl
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getTransactionComponentD()
	 * @generated
	 */
	int TRANSACTION_COMPONENT_D = 6;

	/**
	 * The feature id for the '<em><b>Transaction Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_D__TRANSACTION_ID = COMPONENT__TRANSACTION_ID;

	/**
	 * The number of structural features of the '<em>Component D</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_D_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Component D</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_D_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentEImpl <em>Component E</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentEImpl
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getTransactionComponentE()
	 * @generated
	 */
	int TRANSACTION_COMPONENT_E = 7;

	/**
	 * The feature id for the '<em><b>Transaction Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_E__TRANSACTION_ID = COMPONENT__TRANSACTION_ID;

	/**
	 * The number of structural features of the '<em>Component E</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_E_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Component E</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_E_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentFImpl <em>Component F</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentFImpl
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getTransactionComponentF()
	 * @generated
	 */
	int TRANSACTION_COMPONENT_F = 8;

	/**
	 * The feature id for the '<em><b>Transaction Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_F__TRANSACTION_ID = COMPONENT__TRANSACTION_ID;

	/**
	 * The number of structural features of the '<em>Component F</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_F_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Component F</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_F_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentGImpl <em>Component G</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentGImpl
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getTransactionComponentG()
	 * @generated
	 */
	int TRANSACTION_COMPONENT_G = 9;

	/**
	 * The feature id for the '<em><b>Transaction Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_G__TRANSACTION_ID = COMPONENT__TRANSACTION_ID;

	/**
	 * The number of structural features of the '<em>Component G</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_G_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Component G</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_G_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentHImpl <em>Component H</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentHImpl
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getTransactionComponentH()
	 * @generated
	 */
	int TRANSACTION_COMPONENT_H = 10;

	/**
	 * The feature id for the '<em><b>Transaction Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_H__TRANSACTION_ID = COMPONENT__TRANSACTION_ID;

	/**
	 * The number of structural features of the '<em>Component H</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_H_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Component H</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_H_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentIImpl <em>Component I</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentIImpl
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getTransactionComponentI()
	 * @generated
	 */
	int TRANSACTION_COMPONENT_I = 11;

	/**
	 * The feature id for the '<em><b>Transaction Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_I__TRANSACTION_ID = COMPONENT__TRANSACTION_ID;

	/**
	 * The number of structural features of the '<em>Component I</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_I_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Component I</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_I_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentJImpl <em>Component J</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentJImpl
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getTransactionComponentJ()
	 * @generated
	 */
	int TRANSACTION_COMPONENT_J = 12;

	/**
	 * The feature id for the '<em><b>Transaction Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_J__TRANSACTION_ID = COMPONENT__TRANSACTION_ID;

	/**
	 * The number of structural features of the '<em>Component J</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_J_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Component J</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_COMPONENT_J_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.CompoundTransactionEventImpl <em>Compound Transaction Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.CompoundTransactionEventImpl
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getCompoundTransactionEvent()
	 * @generated
	 */
	int COMPOUND_TRANSACTION_EVENT = 13;

	/**
	 * The feature id for the '<em><b>Transaction Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_TRANSACTION_EVENT__TRANSACTION_ID = MODEL_ELEMENT__TRANSACTION_ID;

	/**
	 * The number of structural features of the '<em>Compound Transaction Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_TRANSACTION_EVENT_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Compound Transaction Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_TRANSACTION_EVENT_OPERATION_COUNT = MODEL_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionModel
	 * @generated
	 */
	EClass getTransactionModel();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionModel#getLatestComponentEvent <em>Latest Component Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Latest Component Event</em>'.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionModel#getLatestComponentEvent()
	 * @see #getTransactionModel()
	 * @generated
	 */
	EReference getTransactionModel_LatestComponentEvent();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionModel#getLatestCompoundEvent <em>Latest Compound Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Latest Compound Event</em>'.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionModel#getLatestCompoundEvent()
	 * @see #getTransactionModel()
	 * @generated
	 */
	EReference getTransactionModel_LatestCompoundEvent();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.ModelElement <em>Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element</em>'.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.ModelElement
	 * @generated
	 */
	EClass getModelElement();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.ModelElement#getTransactionId <em>Transaction Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transaction Id</em>'.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.ModelElement#getTransactionId()
	 * @see #getModelElement()
	 * @generated
	 */
	EAttribute getModelElement_TransactionId();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentA <em>Component A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component A</em>'.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentA
	 * @generated
	 */
	EClass getTransactionComponentA();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentB <em>Component B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component B</em>'.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentB
	 * @generated
	 */
	EClass getTransactionComponentB();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentC <em>Component C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component C</em>'.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentC
	 * @generated
	 */
	EClass getTransactionComponentC();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentD <em>Component D</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component D</em>'.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentD
	 * @generated
	 */
	EClass getTransactionComponentD();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentE <em>Component E</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component E</em>'.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentE
	 * @generated
	 */
	EClass getTransactionComponentE();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentF <em>Component F</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component F</em>'.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentF
	 * @generated
	 */
	EClass getTransactionComponentF();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentG <em>Component G</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component G</em>'.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentG
	 * @generated
	 */
	EClass getTransactionComponentG();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentH <em>Component H</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component H</em>'.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentH
	 * @generated
	 */
	EClass getTransactionComponentH();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentI <em>Component I</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component I</em>'.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentI
	 * @generated
	 */
	EClass getTransactionComponentI();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentJ <em>Component J</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component J</em>'.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentJ
	 * @generated
	 */
	EClass getTransactionComponentJ();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.CompoundTransactionEvent <em>Compound Transaction Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compound Transaction Event</em>'.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.CompoundTransactionEvent
	 * @generated
	 */
	EClass getCompoundTransactionEvent();

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
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionModelImpl
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getTransactionModel()
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
		 * The meta object literal for the '<em><b>Latest Compound Event</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSACTION_MODEL__LATEST_COMPOUND_EVENT = eINSTANCE.getTransactionModel_LatestCompoundEvent();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.ModelElementImpl <em>Model Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.ModelElementImpl
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getModelElement()
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

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.ComponentImpl
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentAImpl <em>Component A</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentAImpl
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getTransactionComponentA()
		 * @generated
		 */
		EClass TRANSACTION_COMPONENT_A = eINSTANCE.getTransactionComponentA();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentBImpl <em>Component B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentBImpl
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getTransactionComponentB()
		 * @generated
		 */
		EClass TRANSACTION_COMPONENT_B = eINSTANCE.getTransactionComponentB();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentCImpl <em>Component C</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentCImpl
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getTransactionComponentC()
		 * @generated
		 */
		EClass TRANSACTION_COMPONENT_C = eINSTANCE.getTransactionComponentC();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentDImpl <em>Component D</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentDImpl
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getTransactionComponentD()
		 * @generated
		 */
		EClass TRANSACTION_COMPONENT_D = eINSTANCE.getTransactionComponentD();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentEImpl <em>Component E</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentEImpl
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getTransactionComponentE()
		 * @generated
		 */
		EClass TRANSACTION_COMPONENT_E = eINSTANCE.getTransactionComponentE();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentFImpl <em>Component F</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentFImpl
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getTransactionComponentF()
		 * @generated
		 */
		EClass TRANSACTION_COMPONENT_F = eINSTANCE.getTransactionComponentF();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentGImpl <em>Component G</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentGImpl
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getTransactionComponentG()
		 * @generated
		 */
		EClass TRANSACTION_COMPONENT_G = eINSTANCE.getTransactionComponentG();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentHImpl <em>Component H</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentHImpl
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getTransactionComponentH()
		 * @generated
		 */
		EClass TRANSACTION_COMPONENT_H = eINSTANCE.getTransactionComponentH();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentIImpl <em>Component I</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentIImpl
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getTransactionComponentI()
		 * @generated
		 */
		EClass TRANSACTION_COMPONENT_I = eINSTANCE.getTransactionComponentI();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentJImpl <em>Component J</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionComponentJImpl
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getTransactionComponentJ()
		 * @generated
		 */
		EClass TRANSACTION_COMPONENT_J = eINSTANCE.getTransactionComponentJ();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.CompoundTransactionEventImpl <em>Compound Transaction Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.CompoundTransactionEventImpl
		 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl.TransactionPackageImpl#getCompoundTransactionEvent()
		 * @generated
		 */
		EClass COMPOUND_TRANSACTION_EVENT = eINSTANCE.getCompoundTransactionEvent();

	}

} //TransactionPackage
