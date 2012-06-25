package hu.bme.mit.emf.incquery.generatecypher.internal;

import org.eclipse.xtext.ui.XtextExecutableExtensionFactory;
import org.osgi.framework.Bundle;

public class GenerateCypherExecutableExtensionFactory extends
		XtextExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return GenerateCypherPlugin.getInstance().getBundle();
	}
}
