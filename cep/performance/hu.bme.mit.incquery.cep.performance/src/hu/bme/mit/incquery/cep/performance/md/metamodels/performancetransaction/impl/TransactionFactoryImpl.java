/**
 */
package hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.impl;

import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.*;

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
public class TransactionFactoryImpl extends EFactoryImpl implements TransactionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransactionFactory init() {
		try {
			TransactionFactory theTransactionFactory = (TransactionFactory)EPackage.Registry.INSTANCE.getEFactory(TransactionPackage.eNS_URI);
			if (theTransactionFactory != null) {
				return theTransactionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TransactionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransactionFactoryImpl() {
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
			case TransactionPackage.TRANSACTION_MODEL: return createTransactionModel();
			case TransactionPackage.MODEL_ELEMENT: return createModelElement();
			case TransactionPackage.COMPONENT: return createComponent();
			case TransactionPackage.TRANSACTION_COMPONENT_A: return createTransactionComponentA();
			case TransactionPackage.TRANSACTION_COMPONENT_B: return createTransactionComponentB();
			case TransactionPackage.TRANSACTION_COMPONENT_C: return createTransactionComponentC();
			case TransactionPackage.TRANSACTION_COMPONENT_D: return createTransactionComponentD();
			case TransactionPackage.TRANSACTION_COMPONENT_E: return createTransactionComponentE();
			case TransactionPackage.TRANSACTION_COMPONENT_F: return createTransactionComponentF();
			case TransactionPackage.TRANSACTION_COMPONENT_G: return createTransactionComponentG();
			case TransactionPackage.TRANSACTION_COMPONENT_H: return createTransactionComponentH();
			case TransactionPackage.TRANSACTION_COMPONENT_I: return createTransactionComponentI();
			case TransactionPackage.TRANSACTION_COMPONENT_J: return createTransactionComponentJ();
			case TransactionPackage.COMPOUND_TRANSACTION_EVENT: return createCompoundTransactionEvent();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransactionModel createTransactionModel() {
		TransactionModelImpl transactionModel = new TransactionModelImpl();
		return transactionModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElement createModelElement() {
		ModelElementImpl modelElement = new ModelElementImpl();
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component createComponent() {
		ComponentImpl component = new ComponentImpl();
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransactionComponentA createTransactionComponentA() {
		TransactionComponentAImpl transactionComponentA = new TransactionComponentAImpl();
		return transactionComponentA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransactionComponentB createTransactionComponentB() {
		TransactionComponentBImpl transactionComponentB = new TransactionComponentBImpl();
		return transactionComponentB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransactionComponentC createTransactionComponentC() {
		TransactionComponentCImpl transactionComponentC = new TransactionComponentCImpl();
		return transactionComponentC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransactionComponentD createTransactionComponentD() {
		TransactionComponentDImpl transactionComponentD = new TransactionComponentDImpl();
		return transactionComponentD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransactionComponentE createTransactionComponentE() {
		TransactionComponentEImpl transactionComponentE = new TransactionComponentEImpl();
		return transactionComponentE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransactionComponentF createTransactionComponentF() {
		TransactionComponentFImpl transactionComponentF = new TransactionComponentFImpl();
		return transactionComponentF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransactionComponentG createTransactionComponentG() {
		TransactionComponentGImpl transactionComponentG = new TransactionComponentGImpl();
		return transactionComponentG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransactionComponentH createTransactionComponentH() {
		TransactionComponentHImpl transactionComponentH = new TransactionComponentHImpl();
		return transactionComponentH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransactionComponentI createTransactionComponentI() {
		TransactionComponentIImpl transactionComponentI = new TransactionComponentIImpl();
		return transactionComponentI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransactionComponentJ createTransactionComponentJ() {
		TransactionComponentJImpl transactionComponentJ = new TransactionComponentJImpl();
		return transactionComponentJ;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompoundTransactionEvent createCompoundTransactionEvent() {
		CompoundTransactionEventImpl compoundTransactionEvent = new CompoundTransactionEventImpl();
		return compoundTransactionEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransactionPackage getTransactionPackage() {
		return (TransactionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TransactionPackage getPackage() {
		return TransactionPackage.eINSTANCE;
	}

} //TransactionFactoryImpl
