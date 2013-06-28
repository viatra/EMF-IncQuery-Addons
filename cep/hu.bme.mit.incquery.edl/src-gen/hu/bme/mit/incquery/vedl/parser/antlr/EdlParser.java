/*
* generated by Xtext
*/
package hu.bme.mit.incquery.vedl.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import hu.bme.mit.incquery.vedl.services.EdlGrammarAccess;

public class EdlParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private EdlGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected hu.bme.mit.incquery.vedl.parser.antlr.internal.InternalEdlParser createParser(XtextTokenStream stream) {
		return new hu.bme.mit.incquery.vedl.parser.antlr.internal.InternalEdlParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "PackageDeclaration";
	}
	
	public EdlGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(EdlGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
