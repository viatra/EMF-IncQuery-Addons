/**
 */
package hu.bme.mit.incquery.cep.model.cep;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Processing Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.model.cep.EventProcessingModel#getEventPatterns <em>Event Patterns</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.model.cep.CepPackage#getEventProcessingModel()
 * @model
 * @generated
 */
public interface EventProcessingModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Event Patterns</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.incquery.cep.model.cep.AbstractEventPattern}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Patterns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Patterns</em>' containment reference list.
	 * @see hu.bme.mit.incquery.cep.model.cep.CepPackage#getEventProcessingModel_EventPatterns()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractEventPattern> getEventPatterns();

} // EventProcessingModel
