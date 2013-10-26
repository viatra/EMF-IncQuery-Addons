/**
 */
package hu.bme.mit.incquery.cep.casestudy.transaction;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hu.bme.mit.incquery.cep.casestudy.transaction.TransactionPackage
 * @generated
 */
public interface TransactionFactory extends EFactory {
    /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    TransactionFactory eINSTANCE = hu.bme.mit.incquery.cep.casestudy.transaction.impl.TransactionFactoryImpl.init();

    /**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
	TransactionModel createTransactionModel();

				/**
	 * Returns a new object of class '<em>Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component</em>'.
	 * @generated
	 */
	Component createComponent();

				/**
	 * Returns a new object of class '<em>Component A</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component A</em>'.
	 * @generated
	 */
	ComponentA createComponentA();

				/**
	 * Returns a new object of class '<em>Component B</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component B</em>'.
	 * @generated
	 */
	ComponentB createComponentB();

				/**
	 * Returns a new object of class '<em>Component C</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component C</em>'.
	 * @generated
	 */
	ComponentC createComponentC();

				/**
	 * Returns a new object of class '<em>Compound Transaction Event</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compound Transaction Event</em>'.
	 * @generated
	 */
    CompoundTransactionEvent createCompoundTransactionEvent();

    /**
	 * Returns a new object of class '<em>Model Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Element</em>'.
	 * @generated
	 */
	ModelElement createModelElement();

				/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
    TransactionPackage getTransactionPackage();

} //TransactionFactory
