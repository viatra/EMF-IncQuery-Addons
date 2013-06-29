package hu.bme.mit.incquery.vedl.ui.syntaxcoloring;

import hu.bme.mit.incquery.vedl.edl.Context;
import hu.bme.mit.incquery.vedl.edl.IQPatternChangeType;

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;

import com.google.common.base.Joiner;

public class EdlAntlrTokenToAttributeIdMapper extends DefaultAntlrTokenToAttributeIdMapper {

	@Override
	protected String calculateId(String tokenName, int tokenType) {
		// TODO Auto-generated method stub
		String calculateId = super.calculateId(tokenName, tokenType);

		if (getApostrophedKeyword(IQPatternChangeType.FOUND.getLiteral()).equals(tokenName)
				|| getApostrophedKeyword(IQPatternChangeType.LOST.getLiteral()).equals(tokenName)) {
			return EdlHighlightingConfiguration.EDL_ENUM_ID;
		}

		if (getApostrophedKeyword(Context.CHRONICLE.getLiteral()).equals(tokenName)
				|| getApostrophedKeyword(Context.RECENT.getLiteral()).equals(tokenName)
				|| getApostrophedKeyword(Context.UNRESTRICTED.getLiteral()).equals(tokenName)) {
			return EdlHighlightingConfiguration.EDL_ENUM_ID;
		}

		return calculateId;

	}

	private String getApostrophedKeyword(String keyword) {
		final String APOSTROPHE = "'";
		Joiner joiner = Joiner.on("");
		return joiner.join(APOSTROPHE, keyword, APOSTROPHE);
	}
}
