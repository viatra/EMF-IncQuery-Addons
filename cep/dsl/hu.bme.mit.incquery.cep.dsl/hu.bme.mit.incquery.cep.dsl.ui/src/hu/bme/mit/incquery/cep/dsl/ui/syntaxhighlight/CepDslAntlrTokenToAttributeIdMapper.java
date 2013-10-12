package hu.bme.mit.incquery.cep.dsl.ui.syntaxhighlight;

import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternChangeType;

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;

import com.google.common.base.Joiner;

public class CepDslAntlrTokenToAttributeIdMapper extends
		DefaultAntlrTokenToAttributeIdMapper {

	@Override
	protected String calculateId(String tokenName, int tokenType) {
		String calculateId = super.calculateId(tokenName, tokenType);

		if (getApostrophedKeyword(IQPatternChangeType.FOUND.getLiteral())
				.equals(tokenName)
				|| getApostrophedKeyword(IQPatternChangeType.LOST.getLiteral())
						.equals(tokenName)) {
			return CepDslHighlightingConfiguration.EDL_ENUM_ID;
		}

		return calculateId;

	}

	private String getApostrophedKeyword(String keyword) {
		final String APOSTROPHE = "'";
		Joiner joiner = Joiner.on("");
		return joiner.join(APOSTROPHE, keyword, APOSTROPHE);
	}
}
