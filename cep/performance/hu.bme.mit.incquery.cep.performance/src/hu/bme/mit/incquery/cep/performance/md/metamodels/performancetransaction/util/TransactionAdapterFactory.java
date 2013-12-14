/**
 */
package hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.util;

import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionPackage
 * @generated
 */
public class TransactionAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TransactionPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransactionAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TransactionPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransactionSwitch<Adapter> modelSwitch =
		new TransactionSwitch<Adapter>() {
			@Override
			public Adapter caseTransactionModel(TransactionModel object) {
				return createTransactionModelAdapter();
			}
			@Override
			public Adapter caseModelElement(ModelElement object) {
				return createModelElementAdapter();
			}
			@Override
			public Adapter caseComponent(Component object) {
				return createComponentAdapter();
			}
			@Override
			public Adapter caseTransactionComponentA(TransactionComponentA object) {
				return createTransactionComponentAAdapter();
			}
			@Override
			public Adapter caseTransactionComponentB(TransactionComponentB object) {
				return createTransactionComponentBAdapter();
			}
			@Override
			public Adapter caseTransactionComponentC(TransactionComponentC object) {
				return createTransactionComponentCAdapter();
			}
			@Override
			public Adapter caseTransactionComponentD(TransactionComponentD object) {
				return createTransactionComponentDAdapter();
			}
			@Override
			public Adapter caseTransactionComponentE(TransactionComponentE object) {
				return createTransactionComponentEAdapter();
			}
			@Override
			public Adapter caseTransactionComponentF(TransactionComponentF object) {
				return createTransactionComponentFAdapter();
			}
			@Override
			public Adapter caseTransactionComponentG(TransactionComponentG object) {
				return createTransactionComponentGAdapter();
			}
			@Override
			public Adapter caseTransactionComponentH(TransactionComponentH object) {
				return createTransactionComponentHAdapter();
			}
			@Override
			public Adapter caseTransactionComponentI(TransactionComponentI object) {
				return createTransactionComponentIAdapter();
			}
			@Override
			public Adapter caseTransactionComponentJ(TransactionComponentJ object) {
				return createTransactionComponentJAdapter();
			}
			@Override
			public Adapter caseCompoundTransactionEvent(CompoundTransactionEvent object) {
				return createCompoundTransactionEventAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionModel
	 * @generated
	 */
	public Adapter createTransactionModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.ModelElement <em>Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.ModelElement
	 * @generated
	 */
	public Adapter createModelElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.Component
	 * @generated
	 */
	public Adapter createComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentA <em>Component A</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentA
	 * @generated
	 */
	public Adapter createTransactionComponentAAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentB <em>Component B</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentB
	 * @generated
	 */
	public Adapter createTransactionComponentBAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentC <em>Component C</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentC
	 * @generated
	 */
	public Adapter createTransactionComponentCAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentD <em>Component D</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentD
	 * @generated
	 */
	public Adapter createTransactionComponentDAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentE <em>Component E</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentE
	 * @generated
	 */
	public Adapter createTransactionComponentEAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentF <em>Component F</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentF
	 * @generated
	 */
	public Adapter createTransactionComponentFAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentG <em>Component G</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentG
	 * @generated
	 */
	public Adapter createTransactionComponentGAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentH <em>Component H</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentH
	 * @generated
	 */
	public Adapter createTransactionComponentHAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentI <em>Component I</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentI
	 * @generated
	 */
	public Adapter createTransactionComponentIAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentJ <em>Component J</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentJ
	 * @generated
	 */
	public Adapter createTransactionComponentJAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.CompoundTransactionEvent <em>Compound Transaction Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.CompoundTransactionEvent
	 * @generated
	 */
	public Adapter createCompoundTransactionEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //TransactionAdapterFactory
