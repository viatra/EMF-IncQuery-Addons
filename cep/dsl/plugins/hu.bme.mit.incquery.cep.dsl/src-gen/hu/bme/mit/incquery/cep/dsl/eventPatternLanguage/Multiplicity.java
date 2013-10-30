/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Multiplicity#getMultiplicity <em>Multiplicity</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getMultiplicity()
 * @model
 * @generated
 */
public interface Multiplicity extends EObject
{
  /**
   * Returns the value of the '<em><b>Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multiplicity</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multiplicity</em>' attribute.
   * @see #setMultiplicity(int)
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getMultiplicity_Multiplicity()
   * @model
   * @generated
   */
  int getMultiplicity();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Multiplicity#getMultiplicity <em>Multiplicity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiplicity</em>' attribute.
   * @see #getMultiplicity()
   * @generated
   */
  void setMultiplicity(int value);

} // Multiplicity
