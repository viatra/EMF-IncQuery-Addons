/*
* generated by Xtext
*/
package hu.bme.mit.incquery.srct.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import hu.bme.mit.incquery.srct.services.SrctGrammarAccess;

public class SrctParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private SrctGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected hu.bme.mit.incquery.srct.parser.antlr.internal.InternalSrctParser createParser(XtextTokenStream stream) {
		return new hu.bme.mit.incquery.srct.parser.antlr.internal.InternalSrctParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "PackageDeclaration";
	}
	
	public SrctGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(SrctGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
