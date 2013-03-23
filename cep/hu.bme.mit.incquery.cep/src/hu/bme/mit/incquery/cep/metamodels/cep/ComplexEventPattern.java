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
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern#getOperator <em>Operator</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern#getTimewindow <em>Timewindow</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getComplexEventPattern()
 * @model
 * @generated
 */
public interface ComplexEventPattern extends AbstractEventPattern {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator
	 * @see #setOperator(ComplexOperator)
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getComplexEventPattern_Operator()
	 * @model required="true"
	 * @generated
	 */
	ComplexOperator getOperator();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(ComplexOperator value);

	/**
	 * Returns the value of the '<em><b>Timewindow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timewindow</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timewindow</em>' containment reference.
	 * @see #setTimewindow(Timewindow)
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getComplexEventPattern_Timewindow()
	 * @model containment="true"
	 * @generated
	 */
	Timewindow getTimewindow();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern#getTimewindow <em>Timewindow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timewindow</em>' containment reference.
	 * @see #getTimewindow()
	 * @generated
	 */
	void setTimewindow(Timewindow value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model compositionEventPatternRequired="true"
	 * @generated
	 */
	void addCompositionEventPattern(AbstractEventPattern compositionEventPattern);

} // ComplexEventPattern
