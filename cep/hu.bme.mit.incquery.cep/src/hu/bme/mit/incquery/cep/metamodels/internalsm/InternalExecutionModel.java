/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Internal Execution Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel#getStateMachines <em>State Machines</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getInternalExecutionModel()
 * @model
 * @generated
 */
public interface InternalExecutionModel extends EObject {
	/**
	 * Returns the value of the '<em><b>State Machines</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Machines</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Machines</em>' containment reference list.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getInternalExecutionModel_StateMachines()
	 * @model containment="true"
	 * @generated
	 */
	EList<StateMachine> getStateMachines();

} // InternalExecutionModel
