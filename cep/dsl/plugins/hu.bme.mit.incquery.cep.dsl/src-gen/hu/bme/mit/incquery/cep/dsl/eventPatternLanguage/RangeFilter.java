/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Range Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.RangeFilter#getNeg <em>Neg</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.RangeFilter#getRange <em>Range</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getRangeFilter()
 * @model
 * @generated
 */
public interface RangeFilter extends StaticBindingRule
{
  /**
   * Returns the value of the '<em><b>Neg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Neg</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Neg</em>' attribute.
   * @see #setNeg(String)
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getRangeFilter_Neg()
   * @model
   * @generated
   */
  String getNeg();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.RangeFilter#getNeg <em>Neg</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Neg</em>' attribute.
   * @see #getNeg()
   * @generated
   */
  void setNeg(String value);

  /**
   * Returns the value of the '<em><b>Range</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Range</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Range</em>' containment reference.
   * @see #setRange(Range)
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getRangeFilter_Range()
   * @model containment="true"
   * @generated
   */
  Range getRange();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.RangeFilter#getRange <em>Range</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Range</em>' containment reference.
   * @see #getRange()
   * @generated
   */
  void setRange(Range value);

} // RangeFilter
