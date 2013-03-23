/**
 */
package hu.bme.mit.incquery.cep.metamodels.cep;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Managed Pattern Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.ManagedPatternRepository#getEventPatterns <em>Event Patterns</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getManagedPatternRepository()
 * @model
 * @generated
 */
public interface ManagedPatternRepository extends EObject {
	/**
	 * Returns the value of the '<em><b>Event Patterns</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.incquery.cep.metamodels.cep.AbstractEventPattern}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Patterns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Patterns</em>' containment reference list.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getManagedPatternRepository_EventPatterns()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractEventPattern> getEventPatterns();

} // ManagedPatternRepository
