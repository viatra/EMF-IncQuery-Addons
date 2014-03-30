/**
 */
package hu.bme.mit.incquery.cep.metamodels.cep;

import hu.bme.mit.incquery.cep.metamodels.automaton.Automaton;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.EventPattern#getAutomaton <em>Automaton</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.EventPattern#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getEventPattern()
 * @model
 * @generated
 */
public interface EventPattern extends EObject {
    /**
     * Returns the value of the '<em><b>Automaton</b></em>' reference.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.incquery.cep.metamodels.automaton.Automaton#getEventPattern <em>Event Pattern</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Automaton</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Automaton</em>' reference.
     * @see #setAutomaton(Automaton)
     * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getEventPattern_Automaton()
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.Automaton#getEventPattern
     * @model opposite="eventPattern"
     * @generated
     */
    Automaton getAutomaton();

    /**
     * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.cep.EventPattern#getAutomaton <em>Automaton</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Automaton</em>' reference.
     * @see #getAutomaton()
     * @generated
     */
    void setAutomaton(Automaton value);

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getEventPattern_Id()
     * @model
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.cep.EventPattern#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

} // EventPattern
