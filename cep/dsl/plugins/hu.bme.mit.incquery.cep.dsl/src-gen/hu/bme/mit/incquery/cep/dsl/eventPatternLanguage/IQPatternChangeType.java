/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>IQ Pattern Change Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getIQPatternChangeType()
 * @model
 * @generated
 */
public enum IQPatternChangeType implements Enumerator
{
  /**
   * The '<em><b>NEW MATCH FOUND</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NEW_MATCH_FOUND_VALUE
   * @generated
   * @ordered
   */
  NEW_MATCH_FOUND(0, "NEW_MATCH_FOUND", "NEW_MATCH_FOUND"),

  /**
   * The '<em><b>EXISTING MATCH LOST</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #EXISTING_MATCH_LOST_VALUE
   * @generated
   * @ordered
   */
  EXISTING_MATCH_LOST(1, "EXISTING_MATCH_LOST", "EXISTING_MATCH_LOST");

  /**
   * The '<em><b>NEW MATCH FOUND</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>NEW MATCH FOUND</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #NEW_MATCH_FOUND
   * @model
   * @generated
   * @ordered
   */
  public static final int NEW_MATCH_FOUND_VALUE = 0;

  /**
   * The '<em><b>EXISTING MATCH LOST</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>EXISTING MATCH LOST</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #EXISTING_MATCH_LOST
   * @model
   * @generated
   * @ordered
   */
  public static final int EXISTING_MATCH_LOST_VALUE = 1;

  /**
   * An array of all the '<em><b>IQ Pattern Change Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final IQPatternChangeType[] VALUES_ARRAY =
    new IQPatternChangeType[]
    {
      NEW_MATCH_FOUND,
      EXISTING_MATCH_LOST,
    };

  /**
   * A public read-only list of all the '<em><b>IQ Pattern Change Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<IQPatternChangeType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>IQ Pattern Change Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static IQPatternChangeType get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      IQPatternChangeType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>IQ Pattern Change Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static IQPatternChangeType getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      IQPatternChangeType result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>IQ Pattern Change Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static IQPatternChangeType get(int value)
  {
    switch (value)
    {
      case NEW_MATCH_FOUND_VALUE: return NEW_MATCH_FOUND;
      case EXISTING_MATCH_LOST_VALUE: return EXISTING_MATCH_LOST;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private IQPatternChangeType(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //IQPatternChangeType
