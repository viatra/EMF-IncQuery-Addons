/**
 */
package hu.bme.mit.incquery.cep.metamodels.cep;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Event Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern#getCompositionEvents <em>Composition Events</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getComplexEventPattern()
 * @model
 * @generated
 */
public interface ComplexEventPattern extends EventPattern {
    /**
     * Returns the value of the '<em><b>Composition Events</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Composition Events</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Composition Events</em>' containment reference.
     * @see #setCompositionEvents(EventPattern)
     * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getComplexEventPattern_CompositionEvents()
     * @model containment="true"
     * @generated
     */
    EventPattern getCompositionEvents();

    /**
     * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern#getCompositionEvents <em>Composition Events</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Composition Events</em>' containment reference.
     * @see #getCompositionEvents()
     * @generated
     */
    void setCompositionEvents(EventPattern value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model compositionEventPatternRequired="true"
     * @generated
     */
    void addCompositionEventPattern(EventPattern compositionEventPattern);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model required="true" eventRequired="true"
     * @generated
     */
    boolean evaluateParameterBindigs(Event event);

} // ComplexEventPattern
