/**
 */
package hu.bme.mit.incquery.cep.casestudy.transaction.impl;

import hu.bme.mit.incquery.cep.casestudy.transaction.*;

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
			case TransactionPackage.COMPONENT: return createComponent();
			case TransactionPackage.TRANSACTION_COMPONENT_A: return createTransactionComponentA();
			case TransactionPackage.TRANSACTION_COMPONENT_B: return createTransactionComponentB();
			case TransactionPackage.TRANSACTION_COMPONENT_C: return createTransactionComponentC();
			case TransactionPackage.COMPOUND_TRANSACTION_EVENT: return createCompoundTransactionEvent();
			case TransactionPackage.MODEL_ELEMENT: return createModelElement();
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
	public CompoundTransactionEvent createCompoundTransactionEvent() {
		CompoundTransactionEventImpl compoundTransactionEvent = new CompoundTransactionEventImpl();
		return compoundTransactionEvent;
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
