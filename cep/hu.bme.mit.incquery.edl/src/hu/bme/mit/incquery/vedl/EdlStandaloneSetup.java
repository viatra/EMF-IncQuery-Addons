
package hu.bme.mit.incquery.vedl;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class EdlStandaloneSetup extends EdlStandaloneSetupGenerated{

	public static void doSetup() {
		new EdlStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

