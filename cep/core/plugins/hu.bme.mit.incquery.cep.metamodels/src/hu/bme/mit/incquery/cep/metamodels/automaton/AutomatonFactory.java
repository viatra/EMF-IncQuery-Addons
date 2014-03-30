/**
 */
package hu.bme.mit.incquery.cep.metamodels.automaton;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hu.bme.mit.incquery.cep.metamodels.automaton.AutomatonPackage
 * @generated
 */
public interface AutomatonFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    AutomatonFactory eINSTANCE = hu.bme.mit.incquery.cep.metamodels.automaton.impl.AutomatonFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Internal Model</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Internal Model</em>'.
     * @generated
     */
    InternalModel createInternalModel();

    /**
     * Returns a new object of class '<em>Automaton</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Automaton</em>'.
     * @generated
     */
    Automaton createAutomaton();

    /**
     * Returns a new object of class '<em>Event Token</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Event Token</em>'.
     * @generated
     */
    EventToken createEventToken();

    /**
     * Returns a new object of class '<em>State</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>State</em>'.
     * @generated
     */
    State createState();

    /**
     * Returns a new object of class '<em>Init State</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Init State</em>'.
     * @generated
     */
    InitState createInitState();

    /**
     * Returns a new object of class '<em>Final State</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Final State</em>'.
     * @generated
     */
    FinalState createFinalState();

    /**
     * Returns a new object of class '<em>Trap State</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Trap State</em>'.
     * @generated
     */
    TrapState createTrapState();

    /**
     * Returns a new object of class '<em>Transition</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Transition</em>'.
     * @generated
     */
    Transition createTransition();

    /**
     * Returns a new object of class '<em>Guard</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Guard</em>'.
     * @generated
     */
    Guard createGuard();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    AutomatonPackage getAutomatonPackage();

} //AutomatonFactory
