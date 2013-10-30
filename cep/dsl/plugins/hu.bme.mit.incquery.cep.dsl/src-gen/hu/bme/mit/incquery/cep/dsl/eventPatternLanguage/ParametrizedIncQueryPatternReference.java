/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parametrized Inc Query Pattern Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParametrizedIncQueryPatternReference#getIqpattern <em>Iqpattern</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParametrizedIncQueryPatternReference#getParameterList <em>Parameter List</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getParametrizedIncQueryPatternReference()
 * @model
 * @generated
 */
public interface ParametrizedIncQueryPatternReference extends EObject
{
  /**
   * Returns the value of the '<em><b>Iqpattern</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Iqpattern</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Iqpattern</em>' reference.
   * @see #setIqpattern(Pattern)
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getParametrizedIncQueryPatternReference_Iqpattern()
   * @model
   * @generated
   */
  Pattern getIqpattern();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParametrizedIncQueryPatternReference#getIqpattern <em>Iqpattern</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Iqpattern</em>' reference.
   * @see #getIqpattern()
   * @generated
   */
  void setIqpattern(Pattern value);

  /**
   * Returns the value of the '<em><b>Parameter List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter List</em>' containment reference.
   * @see #setParameterList(PatternCallParameterList)
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getParametrizedIncQueryPatternReference_ParameterList()
   * @model containment="true"
   * @generated
   */
  PatternCallParameterList getParameterList();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParametrizedIncQueryPatternReference#getParameterList <em>Parameter List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parameter List</em>' containment reference.
   * @see #getParameterList()
   * @generated
   */
  void setParameterList(PatternCallParameterList value);

} // ParametrizedIncQueryPatternReference
