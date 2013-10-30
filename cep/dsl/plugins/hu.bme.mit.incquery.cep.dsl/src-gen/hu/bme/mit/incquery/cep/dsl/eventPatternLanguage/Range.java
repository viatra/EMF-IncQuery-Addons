/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Range#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Range#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getRange()
 * @model
 * @generated
 */
public interface Range extends EObject
{
  /**
   * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lower Bound</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lower Bound</em>' attribute.
   * @see #setLowerBound(double)
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getRange_LowerBound()
   * @model
   * @generated
   */
  double getLowerBound();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Range#getLowerBound <em>Lower Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lower Bound</em>' attribute.
   * @see #getLowerBound()
   * @generated
   */
  void setLowerBound(double value);

  /**
   * Returns the value of the '<em><b>Upper Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Upper Bound</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Upper Bound</em>' attribute.
   * @see #setUpperBound(double)
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getRange_UpperBound()
   * @model
   * @generated
   */
  double getUpperBound();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Range#getUpperBound <em>Upper Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Upper Bound</em>' attribute.
   * @see #getUpperBound()
   * @generated
   */
  void setUpperBound(double value);

} // Range
