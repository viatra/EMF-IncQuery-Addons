/*
 * generated by Xtext
 */
package hu.bme.mit.incquery.vedl.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import hu.bme.mit.incquery.vedl.ui.internal.EdlActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class EdlExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return EdlActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return EdlActivator.getInstance().getInjector(EdlActivator.HU_BME_MIT_INCQUERY_VEDL_EDL);
	}
	
}