
package hu.bme.mit.incquery.srct;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SrctStandaloneSetup extends SrctStandaloneSetupGenerated{

	public static void doSetup() {
		new SrctStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

