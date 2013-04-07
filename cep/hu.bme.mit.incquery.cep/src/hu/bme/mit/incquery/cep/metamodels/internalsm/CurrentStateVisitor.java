/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Current State Visitor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor#getCurrentState <em>Current State</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor#getEventCollection <em>Event Collection</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getCurrentStateVisitor()
 * @model
 * @generated
 */
public interface CurrentStateVisitor extends EObject {
	/**
	 * Returns the value of the '<em><b>Current State</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.State#getCurrentVisitors <em>Current Visitors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current State</em>' reference.
	 * @see #setCurrentState(State)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getCurrentStateVisitor_CurrentState()
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.State#getCurrentVisitors
	 * @model opposite="currentVisitors"
	 * @generated
	 */
	State getCurrentState();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor#getCurrentState <em>Current State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current State</em>' reference.
	 * @see #getCurrentState()
	 * @generated
	 */
	void setCurrentState(State value);

	/**
	 * Returns the value of the '<em><b>Event Collection</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.EventCollection#getCurrentStateVisitor <em>Current State Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Collection</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Collection</em>' containment reference.
	 * @see #setEventCollection(EventCollection)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getCurrentStateVisitor_EventCollection()
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.EventCollection#getCurrentStateVisitor
	 * @model opposite="currentStateVisitor" containment="true"
	 * @generated
	 */
	EventCollection getEventCollection();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor#getEventCollection <em>Event Collection</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Collection</em>' containment reference.
	 * @see #getEventCollection()
	 * @generated
	 */
	void setEventCollection(EventCollection value);

} // CurrentStateVisitor
