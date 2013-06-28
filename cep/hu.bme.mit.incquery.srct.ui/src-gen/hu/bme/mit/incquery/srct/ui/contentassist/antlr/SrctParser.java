/*
* generated by Xtext
*/
package hu.bme.mit.incquery.srct.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import hu.bme.mit.incquery.srct.services.SrctGrammarAccess;

public class SrctParser extends AbstractContentAssistParser {
	
	@Inject
	private SrctGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected hu.bme.mit.incquery.srct.ui.contentassist.antlr.internal.InternalSrctParser createParser() {
		hu.bme.mit.incquery.srct.ui.contentassist.antlr.internal.InternalSrctParser result = new hu.bme.mit.incquery.srct.ui.contentassist.antlr.internal.InternalSrctParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getPackageDeclarationAccess().getGroup(), "rule__PackageDeclaration__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
					put(grammarAccess.getSourceModelAccess().getGroup(), "rule__SourceModel__Group__0");
					put(grammarAccess.getSourceAccess().getGroup(), "rule__Source__Group__0");
					put(grammarAccess.getSourceAccess().getGroup_3(), "rule__Source__Group_3__0");
					put(grammarAccess.getPackageDeclarationAccess().getNameAssignment_1(), "rule__PackageDeclaration__NameAssignment_1");
					put(grammarAccess.getPackageDeclarationAccess().getSourceModelAssignment_2(), "rule__PackageDeclaration__SourceModelAssignment_2");
					put(grammarAccess.getSourceModelAccess().getSourcesAssignment_1(), "rule__SourceModel__SourcesAssignment_1");
					put(grammarAccess.getSourceAccess().getNameAssignment_1(), "rule__Source__NameAssignment_1");
					put(grammarAccess.getSourceAccess().getAdapterAssignment_3_1(), "rule__Source__AdapterAssignment_3_1");
					put(grammarAccess.getAdapterAccess().getNameAssignment(), "rule__Adapter__NameAssignment");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			hu.bme.mit.incquery.srct.ui.contentassist.antlr.internal.InternalSrctParser typedParser = (hu.bme.mit.incquery.srct.ui.contentassist.antlr.internal.InternalSrctParser) parser;
			typedParser.entryRulePackageDeclaration();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public SrctGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(SrctGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
