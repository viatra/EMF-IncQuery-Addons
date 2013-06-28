/**
 */
package hu.bme.mit.incquery.vedl.edl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Context</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getContext()
 * @model
 * @generated
 */
public enum Context implements Enumerator
{
  /**
   * The '<em><b>Chronicle</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CHRONICLE_VALUE
   * @generated
   * @ordered
   */
  CHRONICLE(0, "Chronicle", "Chronicle"),

  /**
   * The '<em><b>Recent</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #RECENT_VALUE
   * @generated
   * @ordered
   */
  RECENT(1, "Recent", "Recent"),

  /**
   * The '<em><b>Unrestricted</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #UNRESTRICTED_VALUE
   * @generated
   * @ordered
   */
  UNRESTRICTED(2, "Unrestricted", "Unrestricted");

  /**
   * The '<em><b>Chronicle</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Chronicle</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CHRONICLE
   * @model name="Chronicle"
   * @generated
   * @ordered
   */
  public static final int CHRONICLE_VALUE = 0;

  /**
   * The '<em><b>Recent</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Recent</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #RECENT
   * @model name="Recent"
   * @generated
   * @ordered
   */
  public static final int RECENT_VALUE = 1;

  /**
   * The '<em><b>Unrestricted</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Unrestricted</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #UNRESTRICTED
   * @model name="Unrestricted"
   * @generated
   * @ordered
   */
  public static final int UNRESTRICTED_VALUE = 2;

  /**
   * An array of all the '<em><b>Context</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final Context[] VALUES_ARRAY =
    new Context[]
    {
      CHRONICLE,
      RECENT,
      UNRESTRICTED,
    };

  /**
   * A public read-only list of all the '<em><b>Context</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<Context> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Context</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Context get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      Context result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Context</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Context getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      Context result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Context</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Context get(int value)
  {
    switch (value)
    {
      case CHRONICLE_VALUE: return CHRONICLE;
      case RECENT_VALUE: return RECENT;
      case UNRESTRICTED_VALUE: return UNRESTRICTED;
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
  private Context(int value, String name, String literal)
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
  
} //Context
