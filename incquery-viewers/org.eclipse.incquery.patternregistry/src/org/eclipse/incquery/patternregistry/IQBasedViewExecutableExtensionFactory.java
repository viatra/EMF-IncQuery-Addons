package org.eclipse.incquery.patternregistry;

import org.eclipse.incquery.patternlanguage.emf.ui.EMFPatternLanguageExecutableExtensionFactory;
import org.osgi.framework.Bundle;

public class IQBasedViewExecutableExtensionFactory extends EMFPatternLanguageExecutableExtensionFactory {
	@Override
	protected Bundle getBundle() {
		return IQPatternRegistryPlugin.getDefault().getBundle();
	}

}
