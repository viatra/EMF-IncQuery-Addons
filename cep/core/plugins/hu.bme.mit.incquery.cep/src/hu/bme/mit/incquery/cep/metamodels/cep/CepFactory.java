/**
 */
package hu.bme.mit.incquery.cep.metamodels.cep;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage
 * @generated
 */
public interface CepFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CepFactory eINSTANCE = hu.bme.mit.incquery.cep.metamodels.cep.impl.CepFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Atomic Event Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Atomic Event Pattern</em>'.
	 * @generated
	 */
	AtomicEventPattern createAtomicEventPattern();

	/**
	 * Returns a new object of class '<em>Complex Event Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complex Event Pattern</em>'.
	 * @generated
	 */
	ComplexEventPattern createComplexEventPattern();

	/**
	 * Returns a new object of class '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event</em>'.
	 * @generated
	 */
	Event createEvent();

	/**
	 * Returns a new object of class '<em>Timewindow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timewindow</em>'.
	 * @generated
	 */
	Timewindow createTimewindow();

	/**
	 * Returns a new object of class '<em>Partial Timewindow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Partial Timewindow</em>'.
	 * @generated
	 */
	PartialTimewindow createPartialTimewindow();

	/**
	 * Returns a new object of class '<em>Global Timewindow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Global Timewindow</em>'.
	 * @generated
	 */
	GlobalTimewindow createGlobalTimewindow();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CepPackage getCepPackage();

} //CepFactory
