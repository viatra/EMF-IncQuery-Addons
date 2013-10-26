/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm.util;

import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class InternalsmXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalsmXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		InternalsmPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the InternalsmResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new InternalsmResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new InternalsmResourceFactoryImpl());
		}
		return registrations;
	}

} //InternalsmXMLProcessor
