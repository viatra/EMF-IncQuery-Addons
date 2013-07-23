/*
 * generated by Xtext
 */
package hu.bme.mit.incquery.cep.dsl.ui;

import hu.bme.mit.incquery.cep.dsl.ui.syntaxhighlight.CepDslAntlrTokenToAttributeIdMapper;
import hu.bme.mit.incquery.cep.dsl.ui.syntaxhighlight.CepDslHighlightingConfiguration;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;

/**
 * Use this class to register components to be used within the IDE.
 */
public class EventPatternLanguageUiModule extends
		hu.bme.mit.incquery.cep.dsl.ui.AbstractEventPatternLanguageUiModule {
	public EventPatternLanguageUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return CepDslHighlightingConfiguration.class;
	}

	public Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
		return CepDslAntlrTokenToAttributeIdMapper.class;
	}
}
