/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModel#getPackagedModel <em>Packaged Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getEventModel()
 * @model
 * @generated
 */
public interface EventModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Packaged Model</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Packaged Model</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Packaged Model</em>' containment reference.
   * @see #setPackagedModel(PackagedModel)
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getEventModel_PackagedModel()
   * @model containment="true"
   * @generated
   */
  PackagedModel getPackagedModel();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModel#getPackagedModel <em>Packaged Model</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Packaged Model</em>' containment reference.
   * @see #getPackagedModel()
   * @generated
   */
  void setPackagedModel(PackagedModel value);

} // EventModel
