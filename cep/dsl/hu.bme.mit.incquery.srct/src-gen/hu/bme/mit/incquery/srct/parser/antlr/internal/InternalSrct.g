/*
* generated by Xtext
*/
grammar InternalSrct;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package hu.bme.mit.incquery.srct.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package hu.bme.mit.incquery.srct.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import hu.bme.mit.incquery.srct.services.SrctGrammarAccess;

}

@parser::members {

 	private SrctGrammarAccess grammarAccess;
 	
    public InternalSrctParser(TokenStream input, SrctGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "PackageDeclaration";	
   	}
   	
   	@Override
   	protected SrctGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRulePackageDeclaration
entryRulePackageDeclaration returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getPackageDeclarationRule()); }
	 iv_rulePackageDeclaration=rulePackageDeclaration 
	 { $current=$iv_rulePackageDeclaration.current; } 
	 EOF 
;

// Rule PackageDeclaration
rulePackageDeclaration returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='package' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0()); 
	    }
		lv_name_1_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPackageDeclarationRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getPackageDeclarationAccess().getSourceModelSourceModelParserRuleCall_2_0()); 
	    }
		lv_sourceModel_2_0=ruleSourceModel		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPackageDeclarationRule());
	        }
       		set(
       			$current, 
       			"sourceModel",
        		lv_sourceModel_2_0, 
        		"SourceModel");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleQualifiedName
entryRuleQualifiedName returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getQualifiedNameRule()); } 
	 iv_ruleQualifiedName=ruleQualifiedName 
	 { $current=$iv_ruleQualifiedName.current.getText(); }  
	 EOF 
;

// Rule QualifiedName
ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
    }
(
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
    }
    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    { 
    newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
    }
)*)
    ;





// Entry rule entryRuleSourceModel
entryRuleSourceModel returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getSourceModelRule()); }
	 iv_ruleSourceModel=ruleSourceModel 
	 { $current=$iv_ruleSourceModel.current; } 
	 EOF 
;

// Rule SourceModel
ruleSourceModel returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getSourceModelAccess().getSourceModelAction_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getSourceModelAccess().getSourcesSourceParserRuleCall_1_0()); 
	    }
		lv_sources_1_0=ruleSource		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSourceModelRule());
	        }
       		add(
       			$current, 
       			"sources",
        		lv_sources_1_0, 
        		"Source");
	        afterParserOrEnumRuleCall();
	    }

)
)*)
;





// Entry rule entryRuleSource
entryRuleSource returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getSourceRule()); }
	 iv_ruleSource=ruleSource 
	 { $current=$iv_ruleSource.current; } 
	 EOF 
;

// Rule Source
ruleSource returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='source' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getSourceAccess().getSourceKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getSourceAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSourceRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)	otherlv_2='{' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getSourceAccess().getLeftCurlyBracketKeyword_2());
    }
(	otherlv_3='register' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getSourceAccess().getRegisterKeyword_3_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSourceAccess().getAdapterAdapterParserRuleCall_3_1_0()); 
	    }
		lv_adapter_4_0=ruleAdapter		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSourceRule());
	        }
       		add(
       			$current, 
       			"adapter",
        		lv_adapter_4_0, 
        		"Adapter");
	        afterParserOrEnumRuleCall();
	    }

)
))+	otherlv_5='}' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getSourceAccess().getRightCurlyBracketKeyword_4());
    }
)
;





// Entry rule entryRuleAdapter
entryRuleAdapter returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAdapterRule()); }
	 iv_ruleAdapter=ruleAdapter 
	 { $current=$iv_ruleAdapter.current; } 
	 EOF 
;

// Rule Adapter
ruleAdapter returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		lv_name_0_0=RULE_ID
		{
			newLeafNode(lv_name_0_0, grammarAccess.getAdapterAccess().getNameIDTerminalRuleCall_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAdapterRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"ID");
	    }

)
)
;





RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;

