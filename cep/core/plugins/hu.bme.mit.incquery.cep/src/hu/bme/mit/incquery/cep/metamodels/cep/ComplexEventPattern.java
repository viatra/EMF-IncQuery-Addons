/**
 */
package hu.bme.mit.incquery.cep.metamodels.cep;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Event Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern#getOperator <em>Operator</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern#getGlobalTimewindow <em>Global Timewindow</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern#getCompositionEvents <em>Composition Events</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern#getPartialTimeWindows <em>Partial Time Windows</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getComplexEventPattern()
 * @model
 * @generated
 */
public interface ComplexEventPattern extends EventPattern {
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
	 * Returns the value of the '<em><b>Global Timewindow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Timewindow</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Timewindow</em>' containment reference.
	 * @see #setGlobalTimewindow(GlobalTimewindow)
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getComplexEventPattern_GlobalTimewindow()
	 * @model containment="true"
	 * @generated
	 */
	GlobalTimewindow getGlobalTimewindow();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern#getGlobalTimewindow <em>Global Timewindow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Global Timewindow</em>' containment reference.
	 * @see #getGlobalTimewindow()
	 * @generated
	 */
	void setGlobalTimewindow(GlobalTimewindow value);

	/**
	 * Returns the value of the '<em><b>Composition Events</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.incquery.cep.metamodels.cep.EventPattern}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composition Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composition Events</em>' containment reference list.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getComplexEventPattern_CompositionEvents()
	 * @model containment="true"
	 * @generated
	 */
	EList<EventPattern> getCompositionEvents();

	/**
	 * Returns the value of the '<em><b>Partial Time Windows</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.incquery.cep.metamodels.cep.PartialTimewindow}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partial Time Windows</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partial Time Windows</em>' containment reference list.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepPackage#getComplexEventPattern_PartialTimeWindows()
	 * @model containment="true"
	 * @generated
	 */
	EList<PartialTimewindow> getPartialTimeWindows();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model compositionEventPatternRequired="true"
	 * @generated
	 */
	void addCompositionEventPattern(EventPattern compositionEventPattern);

} // ComplexEventPattern
