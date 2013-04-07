/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm;

import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.EventCollection#getCurrentStateVisitor <em>Current State Visitor</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getEventCollection()
 * @model abstract="true"
 * @generated
 */
public interface EventCollection extends EObject {
	/**
	 * Returns the value of the '<em><b>Current State Visitor</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor#getEventCollection <em>Event Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current State Visitor</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current State Visitor</em>' container reference.
	 * @see #setCurrentStateVisitor(CurrentStateVisitor)
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage#getEventCollection_CurrentStateVisitor()
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor#getEventCollection
	 * @model opposite="eventCollection" required="true" transient="false"
	 * @generated
	 */
	CurrentStateVisitor getCurrentStateVisitor();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.EventCollection#getCurrentStateVisitor <em>Current State Visitor</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current State Visitor</em>' container reference.
	 * @see #getCurrentStateVisitor()
	 * @generated
	 */
	void setCurrentStateVisitor(CurrentStateVisitor value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	Object getRecordedEvents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addEvent(Event event);

} // EventCollection
