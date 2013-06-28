package hu.bme.mit.incquery.vedl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import hu.bme.mit.incquery.vedl.services.EdlGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEdlParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'.'", "'.*'", "'uses-incquery-patterns'", "'uses-eventsources'", "'EventModel'", "'{'", "'}'", "'AtomicEvent'", "'()'", "'source'", "':'", "'id'", "'parameterFilters'", "'IQPatternEvent'", "'IQPatternRef'", "'ChangeType'", "'ComplexEvent'", "'('", "')'", "'@Context'", "'@SamplingTime'", "'@Priority'", "'in'", "','", "']'", "'['", "'<'", "'=<'", "'=='", "'!='", "'>='", "'>'", "'contains'", "'startsWith'", "'endsWith'", "'not'", "'FOUND'", "'LOST'", "'Chronicle'", "'Recent'", "'Unrestricted'"
    };
    public static final int RULE_ID=5;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__51=51;
    public static final int T__16=16;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=4;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=6;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalEdlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEdlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEdlParser.tokenNames; }
    public String getGrammarFileName() { return "../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g"; }



     	private EdlGrammarAccess grammarAccess;
     	
        public InternalEdlParser(TokenStream input, EdlGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "PackageDeclaration";	
       	}
       	
       	@Override
       	protected EdlGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRulePackageDeclaration"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:68:1: entryRulePackageDeclaration returns [EObject current=null] : iv_rulePackageDeclaration= rulePackageDeclaration EOF ;
    public final EObject entryRulePackageDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDeclaration = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:69:2: (iv_rulePackageDeclaration= rulePackageDeclaration EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:70:2: iv_rulePackageDeclaration= rulePackageDeclaration EOF
            {
             newCompositeNode(grammarAccess.getPackageDeclarationRule()); 
            pushFollow(FOLLOW_rulePackageDeclaration_in_entryRulePackageDeclaration75);
            iv_rulePackageDeclaration=rulePackageDeclaration();

            state._fsp--;

             current =iv_rulePackageDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePackageDeclaration85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePackageDeclaration"


    // $ANTLR start "rulePackageDeclaration"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:77:1: rulePackageDeclaration returns [EObject current=null] : (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_usages_2_0= ruleUsage ) )* ( (lv_model_3_0= ruleModel ) ) ) ;
    public final EObject rulePackageDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_usages_2_0 = null;

        EObject lv_model_3_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:80:28: ( (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_usages_2_0= ruleUsage ) )* ( (lv_model_3_0= ruleModel ) ) ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:81:1: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_usages_2_0= ruleUsage ) )* ( (lv_model_3_0= ruleModel ) ) )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:81:1: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_usages_2_0= ruleUsage ) )* ( (lv_model_3_0= ruleModel ) ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:81:3: otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_usages_2_0= ruleUsage ) )* ( (lv_model_3_0= ruleModel ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_rulePackageDeclaration122); 

                	newLeafNode(otherlv_0, grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0());
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:85:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:86:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:86:1: (lv_name_1_0= ruleQualifiedName )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:87:3: lv_name_1_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_rulePackageDeclaration143);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPackageDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:103:2: ( (lv_usages_2_0= ruleUsage ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=14 && LA1_0<=15)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:104:1: (lv_usages_2_0= ruleUsage )
            	    {
            	    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:104:1: (lv_usages_2_0= ruleUsage )
            	    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:105:3: lv_usages_2_0= ruleUsage
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPackageDeclarationAccess().getUsagesUsageParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleUsage_in_rulePackageDeclaration164);
            	    lv_usages_2_0=ruleUsage();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPackageDeclarationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"usages",
            	            		lv_usages_2_0, 
            	            		"Usage");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:121:3: ( (lv_model_3_0= ruleModel ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:122:1: (lv_model_3_0= ruleModel )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:122:1: (lv_model_3_0= ruleModel )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:123:3: lv_model_3_0= ruleModel
            {
             
            	        newCompositeNode(grammarAccess.getPackageDeclarationAccess().getModelModelParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleModel_in_rulePackageDeclaration186);
            lv_model_3_0=ruleModel();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPackageDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"model",
                    		lv_model_3_0, 
                    		"Model");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePackageDeclaration"


    // $ANTLR start "entryRuleDOUBLE"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:147:1: entryRuleDOUBLE returns [String current=null] : iv_ruleDOUBLE= ruleDOUBLE EOF ;
    public final String entryRuleDOUBLE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOUBLE = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:148:2: (iv_ruleDOUBLE= ruleDOUBLE EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:149:2: iv_ruleDOUBLE= ruleDOUBLE EOF
            {
             newCompositeNode(grammarAccess.getDOUBLERule()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_entryRuleDOUBLE223);
            iv_ruleDOUBLE=ruleDOUBLE();

            state._fsp--;

             current =iv_ruleDOUBLE.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDOUBLE234); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDOUBLE"


    // $ANTLR start "ruleDOUBLE"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:156:1: ruleDOUBLE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleDOUBLE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:159:28: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:160:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:160:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:160:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )?
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDOUBLE274); 

            		current.merge(this_INT_0);
                
             
                newLeafNode(this_INT_0, grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_0()); 
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:167:1: (kw= '.' this_INT_2= RULE_INT )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:168:2: kw= '.' this_INT_2= RULE_INT
                    {
                    kw=(Token)match(input,12,FOLLOW_12_in_ruleDOUBLE293); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDOUBLEAccess().getFullStopKeyword_1_0()); 
                        
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDOUBLE308); 

                    		current.merge(this_INT_2);
                        
                     
                        newLeafNode(this_INT_2, grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_1_1()); 
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDOUBLE"


    // $ANTLR start "entryRuleQualifiedName"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:188:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:189:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:190:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName356);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName367); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:197:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:200:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:201:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:201:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:201:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName407); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:208:1: (kw= '.' this_ID_2= RULE_ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==12) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:209:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,12,FOLLOW_12_in_ruleQualifiedName426); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName441); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleQualifiedNameWithWildcard"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:229:1: entryRuleQualifiedNameWithWildcard returns [String current=null] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:230:2: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:231:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard489);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();

            state._fsp--;

             current =iv_ruleQualifiedNameWithWildcard.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard500); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildcard"


    // $ANTLR start "ruleQualifiedNameWithWildcard"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:238:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:241:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:242:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:242:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:243:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard547);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:253:1: (kw= '.*' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:254:2: kw= '.*'
                    {
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleQualifiedNameWithWildcard566); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1()); 
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedNameWithWildcard"


    // $ANTLR start "entryRuleUsage"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:267:1: entryRuleUsage returns [EObject current=null] : iv_ruleUsage= ruleUsage EOF ;
    public final EObject entryRuleUsage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUsage = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:268:2: (iv_ruleUsage= ruleUsage EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:269:2: iv_ruleUsage= ruleUsage EOF
            {
             newCompositeNode(grammarAccess.getUsageRule()); 
            pushFollow(FOLLOW_ruleUsage_in_entryRuleUsage608);
            iv_ruleUsage=ruleUsage();

            state._fsp--;

             current =iv_ruleUsage; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUsage618); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUsage"


    // $ANTLR start "ruleUsage"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:276:1: ruleUsage returns [EObject current=null] : (this_IQUsage_0= ruleIQUsage | this_EventSourceUsage_1= ruleEventSourceUsage ) ;
    public final EObject ruleUsage() throws RecognitionException {
        EObject current = null;

        EObject this_IQUsage_0 = null;

        EObject this_EventSourceUsage_1 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:279:28: ( (this_IQUsage_0= ruleIQUsage | this_EventSourceUsage_1= ruleEventSourceUsage ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:280:1: (this_IQUsage_0= ruleIQUsage | this_EventSourceUsage_1= ruleEventSourceUsage )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:280:1: (this_IQUsage_0= ruleIQUsage | this_EventSourceUsage_1= ruleEventSourceUsage )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            else if ( (LA5_0==15) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:281:5: this_IQUsage_0= ruleIQUsage
                    {
                     
                            newCompositeNode(grammarAccess.getUsageAccess().getIQUsageParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleIQUsage_in_ruleUsage665);
                    this_IQUsage_0=ruleIQUsage();

                    state._fsp--;

                     
                            current = this_IQUsage_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:291:5: this_EventSourceUsage_1= ruleEventSourceUsage
                    {
                     
                            newCompositeNode(grammarAccess.getUsageAccess().getEventSourceUsageParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEventSourceUsage_in_ruleUsage692);
                    this_EventSourceUsage_1=ruleEventSourceUsage();

                    state._fsp--;

                     
                            current = this_EventSourceUsage_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUsage"


    // $ANTLR start "entryRuleIQUsage"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:307:1: entryRuleIQUsage returns [EObject current=null] : iv_ruleIQUsage= ruleIQUsage EOF ;
    public final EObject entryRuleIQUsage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIQUsage = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:308:2: (iv_ruleIQUsage= ruleIQUsage EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:309:2: iv_ruleIQUsage= ruleIQUsage EOF
            {
             newCompositeNode(grammarAccess.getIQUsageRule()); 
            pushFollow(FOLLOW_ruleIQUsage_in_entryRuleIQUsage727);
            iv_ruleIQUsage=ruleIQUsage();

            state._fsp--;

             current =iv_ruleIQUsage; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIQUsage737); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIQUsage"


    // $ANTLR start "ruleIQUsage"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:316:1: ruleIQUsage returns [EObject current=null] : (otherlv_0= 'uses-incquery-patterns' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) ) ;
    public final EObject ruleIQUsage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:319:28: ( (otherlv_0= 'uses-incquery-patterns' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:320:1: (otherlv_0= 'uses-incquery-patterns' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:320:1: (otherlv_0= 'uses-incquery-patterns' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:320:3: otherlv_0= 'uses-incquery-patterns' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleIQUsage774); 

                	newLeafNode(otherlv_0, grammarAccess.getIQUsageAccess().getUsesIncqueryPatternsKeyword_0());
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:324:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:325:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:325:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:326:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard
            {
             
            	        newCompositeNode(grammarAccess.getIQUsageAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_ruleIQUsage795);
            lv_importedNamespace_1_0=ruleQualifiedNameWithWildcard();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIQUsageRule());
            	        }
                   		set(
                   			current, 
                   			"importedNamespace",
                    		lv_importedNamespace_1_0, 
                    		"QualifiedNameWithWildcard");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIQUsage"


    // $ANTLR start "entryRuleEventSourceUsage"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:350:1: entryRuleEventSourceUsage returns [EObject current=null] : iv_ruleEventSourceUsage= ruleEventSourceUsage EOF ;
    public final EObject entryRuleEventSourceUsage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventSourceUsage = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:351:2: (iv_ruleEventSourceUsage= ruleEventSourceUsage EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:352:2: iv_ruleEventSourceUsage= ruleEventSourceUsage EOF
            {
             newCompositeNode(grammarAccess.getEventSourceUsageRule()); 
            pushFollow(FOLLOW_ruleEventSourceUsage_in_entryRuleEventSourceUsage831);
            iv_ruleEventSourceUsage=ruleEventSourceUsage();

            state._fsp--;

             current =iv_ruleEventSourceUsage; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventSourceUsage841); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEventSourceUsage"


    // $ANTLR start "ruleEventSourceUsage"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:359:1: ruleEventSourceUsage returns [EObject current=null] : (otherlv_0= 'uses-eventsources' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) ) ;
    public final EObject ruleEventSourceUsage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:362:28: ( (otherlv_0= 'uses-eventsources' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:363:1: (otherlv_0= 'uses-eventsources' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:363:1: (otherlv_0= 'uses-eventsources' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:363:3: otherlv_0= 'uses-eventsources' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleEventSourceUsage878); 

                	newLeafNode(otherlv_0, grammarAccess.getEventSourceUsageAccess().getUsesEventsourcesKeyword_0());
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:367:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:368:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:368:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:369:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard
            {
             
            	        newCompositeNode(grammarAccess.getEventSourceUsageAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_ruleEventSourceUsage899);
            lv_importedNamespace_1_0=ruleQualifiedNameWithWildcard();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEventSourceUsageRule());
            	        }
                   		set(
                   			current, 
                   			"importedNamespace",
                    		lv_importedNamespace_1_0, 
                    		"QualifiedNameWithWildcard");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEventSourceUsage"


    // $ANTLR start "entryRuleModel"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:393:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
        	
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:397:2: (iv_ruleModel= ruleModel EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:398:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel941);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel951); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:408:1: ruleModel returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotations ) )* otherlv_1= 'EventModel' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_events_4_0= ruleEvent ) )* otherlv_5= '}' ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_events_4_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:412:28: ( ( ( (lv_annotations_0_0= ruleAnnotations ) )* otherlv_1= 'EventModel' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_events_4_0= ruleEvent ) )* otherlv_5= '}' ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:413:1: ( ( (lv_annotations_0_0= ruleAnnotations ) )* otherlv_1= 'EventModel' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_events_4_0= ruleEvent ) )* otherlv_5= '}' )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:413:1: ( ( (lv_annotations_0_0= ruleAnnotations ) )* otherlv_1= 'EventModel' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_events_4_0= ruleEvent ) )* otherlv_5= '}' )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:413:2: ( (lv_annotations_0_0= ruleAnnotations ) )* otherlv_1= 'EventModel' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_events_4_0= ruleEvent ) )* otherlv_5= '}'
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:413:2: ( (lv_annotations_0_0= ruleAnnotations ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=31 && LA6_0<=33)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:414:1: (lv_annotations_0_0= ruleAnnotations )
            	    {
            	    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:414:1: (lv_annotations_0_0= ruleAnnotations )
            	    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:415:3: lv_annotations_0_0= ruleAnnotations
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getAnnotationsAnnotationsParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAnnotations_in_ruleModel1001);
            	    lv_annotations_0_0=ruleAnnotations();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_0_0, 
            	            		"Annotations");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleModel1014); 

                	newLeafNode(otherlv_1, grammarAccess.getModelAccess().getEventModelKeyword_1());
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:435:1: ( (lv_name_2_0= RULE_ID ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:436:1: (lv_name_2_0= RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:436:1: (lv_name_2_0= RULE_ID )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:437:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModel1031); 

            			newLeafNode(lv_name_2_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getModelRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleModel1048); 

                	newLeafNode(otherlv_3, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_3());
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:457:1: ( (lv_events_4_0= ruleEvent ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==19||LA7_0==25||LA7_0==28||(LA7_0>=31 && LA7_0<=33)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:458:1: (lv_events_4_0= ruleEvent )
            	    {
            	    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:458:1: (lv_events_4_0= ruleEvent )
            	    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:459:3: lv_events_4_0= ruleEvent
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getEventsEventParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEvent_in_ruleModel1069);
            	    lv_events_4_0=ruleEvent();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"events",
            	            		lv_events_4_0, 
            	            		"Event");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleModel1082); 

                	newLeafNode(otherlv_5, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleEvent"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:490:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:491:2: (iv_ruleEvent= ruleEvent EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:492:2: iv_ruleEvent= ruleEvent EOF
            {
             newCompositeNode(grammarAccess.getEventRule()); 
            pushFollow(FOLLOW_ruleEvent_in_entryRuleEvent1122);
            iv_ruleEvent=ruleEvent();

            state._fsp--;

             current =iv_ruleEvent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEvent1132); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEvent"


    // $ANTLR start "ruleEvent"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:499:1: ruleEvent returns [EObject current=null] : (this_AbstractAtomicEvent_0= ruleAbstractAtomicEvent | this_ComplexEvent_1= ruleComplexEvent ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractAtomicEvent_0 = null;

        EObject this_ComplexEvent_1 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:502:28: ( (this_AbstractAtomicEvent_0= ruleAbstractAtomicEvent | this_ComplexEvent_1= ruleComplexEvent ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:503:1: (this_AbstractAtomicEvent_0= ruleAbstractAtomicEvent | this_ComplexEvent_1= ruleComplexEvent )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:503:1: (this_AbstractAtomicEvent_0= ruleAbstractAtomicEvent | this_ComplexEvent_1= ruleComplexEvent )
            int alt8=2;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:504:5: this_AbstractAtomicEvent_0= ruleAbstractAtomicEvent
                    {
                     
                            newCompositeNode(grammarAccess.getEventAccess().getAbstractAtomicEventParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAbstractAtomicEvent_in_ruleEvent1179);
                    this_AbstractAtomicEvent_0=ruleAbstractAtomicEvent();

                    state._fsp--;

                     
                            current = this_AbstractAtomicEvent_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:514:5: this_ComplexEvent_1= ruleComplexEvent
                    {
                     
                            newCompositeNode(grammarAccess.getEventAccess().getComplexEventParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleComplexEvent_in_ruleEvent1206);
                    this_ComplexEvent_1=ruleComplexEvent();

                    state._fsp--;

                     
                            current = this_ComplexEvent_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEvent"


    // $ANTLR start "entryRuleAbstractAtomicEvent"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:530:1: entryRuleAbstractAtomicEvent returns [EObject current=null] : iv_ruleAbstractAtomicEvent= ruleAbstractAtomicEvent EOF ;
    public final EObject entryRuleAbstractAtomicEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractAtomicEvent = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:531:2: (iv_ruleAbstractAtomicEvent= ruleAbstractAtomicEvent EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:532:2: iv_ruleAbstractAtomicEvent= ruleAbstractAtomicEvent EOF
            {
             newCompositeNode(grammarAccess.getAbstractAtomicEventRule()); 
            pushFollow(FOLLOW_ruleAbstractAtomicEvent_in_entryRuleAbstractAtomicEvent1241);
            iv_ruleAbstractAtomicEvent=ruleAbstractAtomicEvent();

            state._fsp--;

             current =iv_ruleAbstractAtomicEvent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractAtomicEvent1251); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractAtomicEvent"


    // $ANTLR start "ruleAbstractAtomicEvent"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:539:1: ruleAbstractAtomicEvent returns [EObject current=null] : (this_AtomicEvent_0= ruleAtomicEvent | this_IQPatternEvent_1= ruleIQPatternEvent ) ;
    public final EObject ruleAbstractAtomicEvent() throws RecognitionException {
        EObject current = null;

        EObject this_AtomicEvent_0 = null;

        EObject this_IQPatternEvent_1 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:542:28: ( (this_AtomicEvent_0= ruleAtomicEvent | this_IQPatternEvent_1= ruleIQPatternEvent ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:543:1: (this_AtomicEvent_0= ruleAtomicEvent | this_IQPatternEvent_1= ruleIQPatternEvent )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:543:1: (this_AtomicEvent_0= ruleAtomicEvent | this_IQPatternEvent_1= ruleIQPatternEvent )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19||(LA9_0>=31 && LA9_0<=33)) ) {
                alt9=1;
            }
            else if ( (LA9_0==25) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:544:5: this_AtomicEvent_0= ruleAtomicEvent
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractAtomicEventAccess().getAtomicEventParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAtomicEvent_in_ruleAbstractAtomicEvent1298);
                    this_AtomicEvent_0=ruleAtomicEvent();

                    state._fsp--;

                     
                            current = this_AtomicEvent_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:554:5: this_IQPatternEvent_1= ruleIQPatternEvent
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractAtomicEventAccess().getIQPatternEventParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleIQPatternEvent_in_ruleAbstractAtomicEvent1325);
                    this_IQPatternEvent_1=ruleIQPatternEvent();

                    state._fsp--;

                     
                            current = this_IQPatternEvent_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractAtomicEvent"


    // $ANTLR start "entryRuleAtomicEvent"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:570:1: entryRuleAtomicEvent returns [EObject current=null] : iv_ruleAtomicEvent= ruleAtomicEvent EOF ;
    public final EObject entryRuleAtomicEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicEvent = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:571:2: (iv_ruleAtomicEvent= ruleAtomicEvent EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:572:2: iv_ruleAtomicEvent= ruleAtomicEvent EOF
            {
             newCompositeNode(grammarAccess.getAtomicEventRule()); 
            pushFollow(FOLLOW_ruleAtomicEvent_in_entryRuleAtomicEvent1360);
            iv_ruleAtomicEvent=ruleAtomicEvent();

            state._fsp--;

             current =iv_ruleAtomicEvent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtomicEvent1370); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtomicEvent"


    // $ANTLR start "ruleAtomicEvent"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:579:1: ruleAtomicEvent returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotations ) )* otherlv_1= 'AtomicEvent' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '()' otherlv_4= '{' otherlv_5= 'source' otherlv_6= ':' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'id' otherlv_9= ':' ( (lv_id_10_0= RULE_STRING ) ) otherlv_11= 'parameterFilters' otherlv_12= '{' ( (lv_parameterFilters_13_0= ruleParameterFilter ) )+ otherlv_14= '}' otherlv_15= '}' ) ;
    public final EObject ruleAtomicEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_id_10_0=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_parameterFilters_13_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:582:28: ( ( ( (lv_annotations_0_0= ruleAnnotations ) )* otherlv_1= 'AtomicEvent' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '()' otherlv_4= '{' otherlv_5= 'source' otherlv_6= ':' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'id' otherlv_9= ':' ( (lv_id_10_0= RULE_STRING ) ) otherlv_11= 'parameterFilters' otherlv_12= '{' ( (lv_parameterFilters_13_0= ruleParameterFilter ) )+ otherlv_14= '}' otherlv_15= '}' ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:583:1: ( ( (lv_annotations_0_0= ruleAnnotations ) )* otherlv_1= 'AtomicEvent' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '()' otherlv_4= '{' otherlv_5= 'source' otherlv_6= ':' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'id' otherlv_9= ':' ( (lv_id_10_0= RULE_STRING ) ) otherlv_11= 'parameterFilters' otherlv_12= '{' ( (lv_parameterFilters_13_0= ruleParameterFilter ) )+ otherlv_14= '}' otherlv_15= '}' )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:583:1: ( ( (lv_annotations_0_0= ruleAnnotations ) )* otherlv_1= 'AtomicEvent' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '()' otherlv_4= '{' otherlv_5= 'source' otherlv_6= ':' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'id' otherlv_9= ':' ( (lv_id_10_0= RULE_STRING ) ) otherlv_11= 'parameterFilters' otherlv_12= '{' ( (lv_parameterFilters_13_0= ruleParameterFilter ) )+ otherlv_14= '}' otherlv_15= '}' )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:583:2: ( (lv_annotations_0_0= ruleAnnotations ) )* otherlv_1= 'AtomicEvent' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '()' otherlv_4= '{' otherlv_5= 'source' otherlv_6= ':' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'id' otherlv_9= ':' ( (lv_id_10_0= RULE_STRING ) ) otherlv_11= 'parameterFilters' otherlv_12= '{' ( (lv_parameterFilters_13_0= ruleParameterFilter ) )+ otherlv_14= '}' otherlv_15= '}'
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:583:2: ( (lv_annotations_0_0= ruleAnnotations ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=31 && LA10_0<=33)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:584:1: (lv_annotations_0_0= ruleAnnotations )
            	    {
            	    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:584:1: (lv_annotations_0_0= ruleAnnotations )
            	    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:585:3: lv_annotations_0_0= ruleAnnotations
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAtomicEventAccess().getAnnotationsAnnotationsParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAnnotations_in_ruleAtomicEvent1416);
            	    lv_annotations_0_0=ruleAnnotations();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAtomicEventRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_0_0, 
            	            		"Annotations");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleAtomicEvent1429); 

                	newLeafNode(otherlv_1, grammarAccess.getAtomicEventAccess().getAtomicEventKeyword_1());
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:605:1: ( (lv_name_2_0= RULE_ID ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:606:1: (lv_name_2_0= RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:606:1: (lv_name_2_0= RULE_ID )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:607:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicEvent1446); 

            			newLeafNode(lv_name_2_0, grammarAccess.getAtomicEventAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAtomicEventRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleAtomicEvent1463); 

                	newLeafNode(otherlv_3, grammarAccess.getAtomicEventAccess().getLeftParenthesisRightParenthesisKeyword_3());
                
            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleAtomicEvent1475); 

                	newLeafNode(otherlv_4, grammarAccess.getAtomicEventAccess().getLeftCurlyBracketKeyword_4());
                
            otherlv_5=(Token)match(input,21,FOLLOW_21_in_ruleAtomicEvent1487); 

                	newLeafNode(otherlv_5, grammarAccess.getAtomicEventAccess().getSourceKeyword_5());
                
            otherlv_6=(Token)match(input,22,FOLLOW_22_in_ruleAtomicEvent1499); 

                	newLeafNode(otherlv_6, grammarAccess.getAtomicEventAccess().getColonKeyword_6());
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:639:1: ( (otherlv_7= RULE_ID ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:640:1: (otherlv_7= RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:640:1: (otherlv_7= RULE_ID )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:641:3: otherlv_7= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAtomicEventRule());
            	        }
                    
            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicEvent1519); 

            		newLeafNode(otherlv_7, grammarAccess.getAtomicEventAccess().getSourceSourceCrossReference_7_0()); 
            	

            }


            }

            otherlv_8=(Token)match(input,23,FOLLOW_23_in_ruleAtomicEvent1531); 

                	newLeafNode(otherlv_8, grammarAccess.getAtomicEventAccess().getIdKeyword_8());
                
            otherlv_9=(Token)match(input,22,FOLLOW_22_in_ruleAtomicEvent1543); 

                	newLeafNode(otherlv_9, grammarAccess.getAtomicEventAccess().getColonKeyword_9());
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:660:1: ( (lv_id_10_0= RULE_STRING ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:661:1: (lv_id_10_0= RULE_STRING )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:661:1: (lv_id_10_0= RULE_STRING )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:662:3: lv_id_10_0= RULE_STRING
            {
            lv_id_10_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAtomicEvent1560); 

            			newLeafNode(lv_id_10_0, grammarAccess.getAtomicEventAccess().getIdSTRINGTerminalRuleCall_10_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAtomicEventRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_10_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_11=(Token)match(input,24,FOLLOW_24_in_ruleAtomicEvent1577); 

                	newLeafNode(otherlv_11, grammarAccess.getAtomicEventAccess().getParameterFiltersKeyword_11());
                
            otherlv_12=(Token)match(input,17,FOLLOW_17_in_ruleAtomicEvent1589); 

                	newLeafNode(otherlv_12, grammarAccess.getAtomicEventAccess().getLeftCurlyBracketKeyword_12());
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:686:1: ( (lv_parameterFilters_13_0= ruleParameterFilter ) )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:687:1: (lv_parameterFilters_13_0= ruleParameterFilter )
            	    {
            	    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:687:1: (lv_parameterFilters_13_0= ruleParameterFilter )
            	    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:688:3: lv_parameterFilters_13_0= ruleParameterFilter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAtomicEventAccess().getParameterFiltersParameterFilterParserRuleCall_13_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameterFilter_in_ruleAtomicEvent1610);
            	    lv_parameterFilters_13_0=ruleParameterFilter();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAtomicEventRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"parameterFilters",
            	            		lv_parameterFilters_13_0, 
            	            		"ParameterFilter");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            otherlv_14=(Token)match(input,18,FOLLOW_18_in_ruleAtomicEvent1623); 

                	newLeafNode(otherlv_14, grammarAccess.getAtomicEventAccess().getRightCurlyBracketKeyword_14());
                
            otherlv_15=(Token)match(input,18,FOLLOW_18_in_ruleAtomicEvent1635); 

                	newLeafNode(otherlv_15, grammarAccess.getAtomicEventAccess().getRightCurlyBracketKeyword_15());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtomicEvent"


    // $ANTLR start "entryRuleIQPatternEvent"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:720:1: entryRuleIQPatternEvent returns [EObject current=null] : iv_ruleIQPatternEvent= ruleIQPatternEvent EOF ;
    public final EObject entryRuleIQPatternEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIQPatternEvent = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:721:2: (iv_ruleIQPatternEvent= ruleIQPatternEvent EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:722:2: iv_ruleIQPatternEvent= ruleIQPatternEvent EOF
            {
             newCompositeNode(grammarAccess.getIQPatternEventRule()); 
            pushFollow(FOLLOW_ruleIQPatternEvent_in_entryRuleIQPatternEvent1671);
            iv_ruleIQPatternEvent=ruleIQPatternEvent();

            state._fsp--;

             current =iv_ruleIQPatternEvent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIQPatternEvent1681); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIQPatternEvent"


    // $ANTLR start "ruleIQPatternEvent"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:729:1: ruleIQPatternEvent returns [EObject current=null] : (otherlv_0= 'IQPatternEvent' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '()' otherlv_3= '{' otherlv_4= 'IQPatternRef' otherlv_5= ':' ( (lv_iqpattern_6_0= ruleIQPattern ) ) otherlv_7= 'ChangeType' otherlv_8= ':' ( (lv_changeType_9_0= ruleIQPatternChangeType ) ) otherlv_10= '}' ) ;
    public final EObject ruleIQPatternEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_iqpattern_6_0 = null;

        Enumerator lv_changeType_9_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:732:28: ( (otherlv_0= 'IQPatternEvent' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '()' otherlv_3= '{' otherlv_4= 'IQPatternRef' otherlv_5= ':' ( (lv_iqpattern_6_0= ruleIQPattern ) ) otherlv_7= 'ChangeType' otherlv_8= ':' ( (lv_changeType_9_0= ruleIQPatternChangeType ) ) otherlv_10= '}' ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:733:1: (otherlv_0= 'IQPatternEvent' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '()' otherlv_3= '{' otherlv_4= 'IQPatternRef' otherlv_5= ':' ( (lv_iqpattern_6_0= ruleIQPattern ) ) otherlv_7= 'ChangeType' otherlv_8= ':' ( (lv_changeType_9_0= ruleIQPatternChangeType ) ) otherlv_10= '}' )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:733:1: (otherlv_0= 'IQPatternEvent' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '()' otherlv_3= '{' otherlv_4= 'IQPatternRef' otherlv_5= ':' ( (lv_iqpattern_6_0= ruleIQPattern ) ) otherlv_7= 'ChangeType' otherlv_8= ':' ( (lv_changeType_9_0= ruleIQPatternChangeType ) ) otherlv_10= '}' )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:733:3: otherlv_0= 'IQPatternEvent' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '()' otherlv_3= '{' otherlv_4= 'IQPatternRef' otherlv_5= ':' ( (lv_iqpattern_6_0= ruleIQPattern ) ) otherlv_7= 'ChangeType' otherlv_8= ':' ( (lv_changeType_9_0= ruleIQPatternChangeType ) ) otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleIQPatternEvent1718); 

                	newLeafNode(otherlv_0, grammarAccess.getIQPatternEventAccess().getIQPatternEventKeyword_0());
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:737:1: ( (lv_name_1_0= RULE_ID ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:738:1: (lv_name_1_0= RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:738:1: (lv_name_1_0= RULE_ID )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:739:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIQPatternEvent1735); 

            			newLeafNode(lv_name_1_0, grammarAccess.getIQPatternEventAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIQPatternEventRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleIQPatternEvent1752); 

                	newLeafNode(otherlv_2, grammarAccess.getIQPatternEventAccess().getLeftParenthesisRightParenthesisKeyword_2());
                
            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleIQPatternEvent1764); 

                	newLeafNode(otherlv_3, grammarAccess.getIQPatternEventAccess().getLeftCurlyBracketKeyword_3());
                
            otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleIQPatternEvent1776); 

                	newLeafNode(otherlv_4, grammarAccess.getIQPatternEventAccess().getIQPatternRefKeyword_4());
                
            otherlv_5=(Token)match(input,22,FOLLOW_22_in_ruleIQPatternEvent1788); 

                	newLeafNode(otherlv_5, grammarAccess.getIQPatternEventAccess().getColonKeyword_5());
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:771:1: ( (lv_iqpattern_6_0= ruleIQPattern ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:772:1: (lv_iqpattern_6_0= ruleIQPattern )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:772:1: (lv_iqpattern_6_0= ruleIQPattern )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:773:3: lv_iqpattern_6_0= ruleIQPattern
            {
             
            	        newCompositeNode(grammarAccess.getIQPatternEventAccess().getIqpatternIQPatternParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleIQPattern_in_ruleIQPatternEvent1809);
            lv_iqpattern_6_0=ruleIQPattern();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIQPatternEventRule());
            	        }
                   		set(
                   			current, 
                   			"iqpattern",
                    		lv_iqpattern_6_0, 
                    		"IQPattern");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_7=(Token)match(input,27,FOLLOW_27_in_ruleIQPatternEvent1821); 

                	newLeafNode(otherlv_7, grammarAccess.getIQPatternEventAccess().getChangeTypeKeyword_7());
                
            otherlv_8=(Token)match(input,22,FOLLOW_22_in_ruleIQPatternEvent1833); 

                	newLeafNode(otherlv_8, grammarAccess.getIQPatternEventAccess().getColonKeyword_8());
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:797:1: ( (lv_changeType_9_0= ruleIQPatternChangeType ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:798:1: (lv_changeType_9_0= ruleIQPatternChangeType )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:798:1: (lv_changeType_9_0= ruleIQPatternChangeType )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:799:3: lv_changeType_9_0= ruleIQPatternChangeType
            {
             
            	        newCompositeNode(grammarAccess.getIQPatternEventAccess().getChangeTypeIQPatternChangeTypeEnumRuleCall_9_0()); 
            	    
            pushFollow(FOLLOW_ruleIQPatternChangeType_in_ruleIQPatternEvent1854);
            lv_changeType_9_0=ruleIQPatternChangeType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIQPatternEventRule());
            	        }
                   		set(
                   			current, 
                   			"changeType",
                    		lv_changeType_9_0, 
                    		"IQPatternChangeType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_10=(Token)match(input,18,FOLLOW_18_in_ruleIQPatternEvent1866); 

                	newLeafNode(otherlv_10, grammarAccess.getIQPatternEventAccess().getRightCurlyBracketKeyword_10());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIQPatternEvent"


    // $ANTLR start "entryRuleComplexEvent"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:827:1: entryRuleComplexEvent returns [EObject current=null] : iv_ruleComplexEvent= ruleComplexEvent EOF ;
    public final EObject entryRuleComplexEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexEvent = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:828:2: (iv_ruleComplexEvent= ruleComplexEvent EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:829:2: iv_ruleComplexEvent= ruleComplexEvent EOF
            {
             newCompositeNode(grammarAccess.getComplexEventRule()); 
            pushFollow(FOLLOW_ruleComplexEvent_in_entryRuleComplexEvent1902);
            iv_ruleComplexEvent=ruleComplexEvent();

            state._fsp--;

             current =iv_ruleComplexEvent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComplexEvent1912); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComplexEvent"


    // $ANTLR start "ruleComplexEvent"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:836:1: ruleComplexEvent returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotations ) )* otherlv_1= 'ComplexEvent' ( (lv_name_2_0= RULE_ID ) ) ( (lv_paramlist_3_0= ruleCEParamlist ) ) otherlv_4= '{' otherlv_5= '}' ) ;
    public final EObject ruleComplexEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_paramlist_3_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:839:28: ( ( ( (lv_annotations_0_0= ruleAnnotations ) )* otherlv_1= 'ComplexEvent' ( (lv_name_2_0= RULE_ID ) ) ( (lv_paramlist_3_0= ruleCEParamlist ) ) otherlv_4= '{' otherlv_5= '}' ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:840:1: ( ( (lv_annotations_0_0= ruleAnnotations ) )* otherlv_1= 'ComplexEvent' ( (lv_name_2_0= RULE_ID ) ) ( (lv_paramlist_3_0= ruleCEParamlist ) ) otherlv_4= '{' otherlv_5= '}' )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:840:1: ( ( (lv_annotations_0_0= ruleAnnotations ) )* otherlv_1= 'ComplexEvent' ( (lv_name_2_0= RULE_ID ) ) ( (lv_paramlist_3_0= ruleCEParamlist ) ) otherlv_4= '{' otherlv_5= '}' )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:840:2: ( (lv_annotations_0_0= ruleAnnotations ) )* otherlv_1= 'ComplexEvent' ( (lv_name_2_0= RULE_ID ) ) ( (lv_paramlist_3_0= ruleCEParamlist ) ) otherlv_4= '{' otherlv_5= '}'
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:840:2: ( (lv_annotations_0_0= ruleAnnotations ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=31 && LA12_0<=33)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:841:1: (lv_annotations_0_0= ruleAnnotations )
            	    {
            	    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:841:1: (lv_annotations_0_0= ruleAnnotations )
            	    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:842:3: lv_annotations_0_0= ruleAnnotations
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getComplexEventAccess().getAnnotationsAnnotationsParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAnnotations_in_ruleComplexEvent1958);
            	    lv_annotations_0_0=ruleAnnotations();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getComplexEventRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_0_0, 
            	            		"Annotations");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleComplexEvent1971); 

                	newLeafNode(otherlv_1, grammarAccess.getComplexEventAccess().getComplexEventKeyword_1());
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:862:1: ( (lv_name_2_0= RULE_ID ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:863:1: (lv_name_2_0= RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:863:1: (lv_name_2_0= RULE_ID )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:864:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleComplexEvent1988); 

            			newLeafNode(lv_name_2_0, grammarAccess.getComplexEventAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getComplexEventRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:880:2: ( (lv_paramlist_3_0= ruleCEParamlist ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:881:1: (lv_paramlist_3_0= ruleCEParamlist )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:881:1: (lv_paramlist_3_0= ruleCEParamlist )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:882:3: lv_paramlist_3_0= ruleCEParamlist
            {
             
            	        newCompositeNode(grammarAccess.getComplexEventAccess().getParamlistCEParamlistParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleCEParamlist_in_ruleComplexEvent2014);
            lv_paramlist_3_0=ruleCEParamlist();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getComplexEventRule());
            	        }
                   		set(
                   			current, 
                   			"paramlist",
                    		lv_paramlist_3_0, 
                    		"CEParamlist");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleComplexEvent2026); 

                	newLeafNode(otherlv_4, grammarAccess.getComplexEventAccess().getLeftCurlyBracketKeyword_4());
                
            otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleComplexEvent2038); 

                	newLeafNode(otherlv_5, grammarAccess.getComplexEventAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComplexEvent"


    // $ANTLR start "entryRuleCEParamlist"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:914:1: entryRuleCEParamlist returns [EObject current=null] : iv_ruleCEParamlist= ruleCEParamlist EOF ;
    public final EObject entryRuleCEParamlist() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCEParamlist = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:915:2: (iv_ruleCEParamlist= ruleCEParamlist EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:916:2: iv_ruleCEParamlist= ruleCEParamlist EOF
            {
             newCompositeNode(grammarAccess.getCEParamlistRule()); 
            pushFollow(FOLLOW_ruleCEParamlist_in_entryRuleCEParamlist2074);
            iv_ruleCEParamlist=ruleCEParamlist();

            state._fsp--;

             current =iv_ruleCEParamlist; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCEParamlist2084); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCEParamlist"


    // $ANTLR start "ruleCEParamlist"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:923:1: ruleCEParamlist returns [EObject current=null] : ( () otherlv_1= '(' ( (lv_params_2_0= ruleParamWithType ) )* otherlv_3= ')' ) ;
    public final EObject ruleCEParamlist() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_params_2_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:926:28: ( ( () otherlv_1= '(' ( (lv_params_2_0= ruleParamWithType ) )* otherlv_3= ')' ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:927:1: ( () otherlv_1= '(' ( (lv_params_2_0= ruleParamWithType ) )* otherlv_3= ')' )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:927:1: ( () otherlv_1= '(' ( (lv_params_2_0= ruleParamWithType ) )* otherlv_3= ')' )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:927:2: () otherlv_1= '(' ( (lv_params_2_0= ruleParamWithType ) )* otherlv_3= ')'
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:927:2: ()
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:928:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCEParamlistAccess().getCEParamlistAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleCEParamlist2130); 

                	newLeafNode(otherlv_1, grammarAccess.getCEParamlistAccess().getLeftParenthesisKeyword_1());
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:937:1: ( (lv_params_2_0= ruleParamWithType ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:938:1: (lv_params_2_0= ruleParamWithType )
            	    {
            	    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:938:1: (lv_params_2_0= ruleParamWithType )
            	    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:939:3: lv_params_2_0= ruleParamWithType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCEParamlistAccess().getParamsParamWithTypeParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParamWithType_in_ruleCEParamlist2151);
            	    lv_params_2_0=ruleParamWithType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCEParamlistRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"params",
            	            		lv_params_2_0, 
            	            		"ParamWithType");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            otherlv_3=(Token)match(input,30,FOLLOW_30_in_ruleCEParamlist2164); 

                	newLeafNode(otherlv_3, grammarAccess.getCEParamlistAccess().getRightParenthesisKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCEParamlist"


    // $ANTLR start "entryRuleParamWithType"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:967:1: entryRuleParamWithType returns [EObject current=null] : iv_ruleParamWithType= ruleParamWithType EOF ;
    public final EObject entryRuleParamWithType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParamWithType = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:968:2: (iv_ruleParamWithType= ruleParamWithType EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:969:2: iv_ruleParamWithType= ruleParamWithType EOF
            {
             newCompositeNode(grammarAccess.getParamWithTypeRule()); 
            pushFollow(FOLLOW_ruleParamWithType_in_entryRuleParamWithType2200);
            iv_ruleParamWithType=ruleParamWithType();

            state._fsp--;

             current =iv_ruleParamWithType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParamWithType2210); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParamWithType"


    // $ANTLR start "ruleParamWithType"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:976:1: ruleParamWithType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleParamWithType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:979:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:980:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:980:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:980:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:980:2: ( (lv_name_0_0= RULE_ID ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:981:1: (lv_name_0_0= RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:981:1: (lv_name_0_0= RULE_ID )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:982:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParamWithType2252); 

            			newLeafNode(lv_name_0_0, grammarAccess.getParamWithTypeAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getParamWithTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleParamWithType2269); 

                	newLeafNode(otherlv_1, grammarAccess.getParamWithTypeAccess().getColonKeyword_1());
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1002:1: ( (otherlv_2= RULE_ID ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1003:1: (otherlv_2= RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1003:1: (otherlv_2= RULE_ID )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1004:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getParamWithTypeRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParamWithType2289); 

            		newLeafNode(otherlv_2, grammarAccess.getParamWithTypeAccess().getTypeAbstractAtomicEventCrossReference_2_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParamWithType"


    // $ANTLR start "entryRuleParameterFilter"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1023:1: entryRuleParameterFilter returns [EObject current=null] : iv_ruleParameterFilter= ruleParameterFilter EOF ;
    public final EObject entryRuleParameterFilter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterFilter = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1024:2: (iv_ruleParameterFilter= ruleParameterFilter EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1025:2: iv_ruleParameterFilter= ruleParameterFilter EOF
            {
             newCompositeNode(grammarAccess.getParameterFilterRule()); 
            pushFollow(FOLLOW_ruleParameterFilter_in_entryRuleParameterFilter2325);
            iv_ruleParameterFilter=ruleParameterFilter();

            state._fsp--;

             current =iv_ruleParameterFilter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterFilter2335); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterFilter"


    // $ANTLR start "ruleParameterFilter"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1032:1: ruleParameterFilter returns [EObject current=null] : ( ( (lv_attributeName_0_0= RULE_ID ) ) ( (lv_paramFilterRule_1_0= ruleParameterFilterRule ) ) ) ;
    public final EObject ruleParameterFilter() throws RecognitionException {
        EObject current = null;

        Token lv_attributeName_0_0=null;
        EObject lv_paramFilterRule_1_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1035:28: ( ( ( (lv_attributeName_0_0= RULE_ID ) ) ( (lv_paramFilterRule_1_0= ruleParameterFilterRule ) ) ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1036:1: ( ( (lv_attributeName_0_0= RULE_ID ) ) ( (lv_paramFilterRule_1_0= ruleParameterFilterRule ) ) )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1036:1: ( ( (lv_attributeName_0_0= RULE_ID ) ) ( (lv_paramFilterRule_1_0= ruleParameterFilterRule ) ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1036:2: ( (lv_attributeName_0_0= RULE_ID ) ) ( (lv_paramFilterRule_1_0= ruleParameterFilterRule ) )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1036:2: ( (lv_attributeName_0_0= RULE_ID ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1037:1: (lv_attributeName_0_0= RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1037:1: (lv_attributeName_0_0= RULE_ID )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1038:3: lv_attributeName_0_0= RULE_ID
            {
            lv_attributeName_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParameterFilter2377); 

            			newLeafNode(lv_attributeName_0_0, grammarAccess.getParameterFilterAccess().getAttributeNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getParameterFilterRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"attributeName",
                    		lv_attributeName_0_0, 
                    		"ID");
            	    

            }


            }

            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1054:2: ( (lv_paramFilterRule_1_0= ruleParameterFilterRule ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1055:1: (lv_paramFilterRule_1_0= ruleParameterFilterRule )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1055:1: (lv_paramFilterRule_1_0= ruleParameterFilterRule )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1056:3: lv_paramFilterRule_1_0= ruleParameterFilterRule
            {
             
            	        newCompositeNode(grammarAccess.getParameterFilterAccess().getParamFilterRuleParameterFilterRuleParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleParameterFilterRule_in_ruleParameterFilter2403);
            lv_paramFilterRule_1_0=ruleParameterFilterRule();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getParameterFilterRule());
            	        }
                   		set(
                   			current, 
                   			"paramFilterRule",
                    		lv_paramFilterRule_1_0, 
                    		"ParameterFilterRule");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterFilter"


    // $ANTLR start "entryRuleIQPattern"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1080:1: entryRuleIQPattern returns [EObject current=null] : iv_ruleIQPattern= ruleIQPattern EOF ;
    public final EObject entryRuleIQPattern() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIQPattern = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1081:2: (iv_ruleIQPattern= ruleIQPattern EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1082:2: iv_ruleIQPattern= ruleIQPattern EOF
            {
             newCompositeNode(grammarAccess.getIQPatternRule()); 
            pushFollow(FOLLOW_ruleIQPattern_in_entryRuleIQPattern2439);
            iv_ruleIQPattern=ruleIQPattern();

            state._fsp--;

             current =iv_ruleIQPattern; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIQPattern2449); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIQPattern"


    // $ANTLR start "ruleIQPattern"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1089:1: ruleIQPattern returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleIQPattern() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1092:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1093:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1093:1: ( (lv_name_0_0= RULE_ID ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1094:1: (lv_name_0_0= RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1094:1: (lv_name_0_0= RULE_ID )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1095:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIQPattern2490); 

            			newLeafNode(lv_name_0_0, grammarAccess.getIQPatternAccess().getNameIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIQPatternRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIQPattern"


    // $ANTLR start "entryRuleAnnotations"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1119:1: entryRuleAnnotations returns [EObject current=null] : iv_ruleAnnotations= ruleAnnotations EOF ;
    public final EObject entryRuleAnnotations() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotations = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1120:2: (iv_ruleAnnotations= ruleAnnotations EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1121:2: iv_ruleAnnotations= ruleAnnotations EOF
            {
             newCompositeNode(grammarAccess.getAnnotationsRule()); 
            pushFollow(FOLLOW_ruleAnnotations_in_entryRuleAnnotations2530);
            iv_ruleAnnotations=ruleAnnotations();

            state._fsp--;

             current =iv_ruleAnnotations; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotations2540); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnotations"


    // $ANTLR start "ruleAnnotations"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1128:1: ruleAnnotations returns [EObject current=null] : (this_ContextAnnotation_0= ruleContextAnnotation | this_SamplingAnnotation_1= ruleSamplingAnnotation | this_PriorityAnnotation_2= rulePriorityAnnotation ) ;
    public final EObject ruleAnnotations() throws RecognitionException {
        EObject current = null;

        EObject this_ContextAnnotation_0 = null;

        EObject this_SamplingAnnotation_1 = null;

        EObject this_PriorityAnnotation_2 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1131:28: ( (this_ContextAnnotation_0= ruleContextAnnotation | this_SamplingAnnotation_1= ruleSamplingAnnotation | this_PriorityAnnotation_2= rulePriorityAnnotation ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1132:1: (this_ContextAnnotation_0= ruleContextAnnotation | this_SamplingAnnotation_1= ruleSamplingAnnotation | this_PriorityAnnotation_2= rulePriorityAnnotation )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1132:1: (this_ContextAnnotation_0= ruleContextAnnotation | this_SamplingAnnotation_1= ruleSamplingAnnotation | this_PriorityAnnotation_2= rulePriorityAnnotation )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt14=1;
                }
                break;
            case 32:
                {
                alt14=2;
                }
                break;
            case 33:
                {
                alt14=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1133:5: this_ContextAnnotation_0= ruleContextAnnotation
                    {
                     
                            newCompositeNode(grammarAccess.getAnnotationsAccess().getContextAnnotationParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleContextAnnotation_in_ruleAnnotations2587);
                    this_ContextAnnotation_0=ruleContextAnnotation();

                    state._fsp--;

                     
                            current = this_ContextAnnotation_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1143:5: this_SamplingAnnotation_1= ruleSamplingAnnotation
                    {
                     
                            newCompositeNode(grammarAccess.getAnnotationsAccess().getSamplingAnnotationParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleSamplingAnnotation_in_ruleAnnotations2614);
                    this_SamplingAnnotation_1=ruleSamplingAnnotation();

                    state._fsp--;

                     
                            current = this_SamplingAnnotation_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1153:5: this_PriorityAnnotation_2= rulePriorityAnnotation
                    {
                     
                            newCompositeNode(grammarAccess.getAnnotationsAccess().getPriorityAnnotationParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_rulePriorityAnnotation_in_ruleAnnotations2641);
                    this_PriorityAnnotation_2=rulePriorityAnnotation();

                    state._fsp--;

                     
                            current = this_PriorityAnnotation_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnotations"


    // $ANTLR start "entryRuleContextAnnotation"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1169:1: entryRuleContextAnnotation returns [EObject current=null] : iv_ruleContextAnnotation= ruleContextAnnotation EOF ;
    public final EObject entryRuleContextAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContextAnnotation = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1170:2: (iv_ruleContextAnnotation= ruleContextAnnotation EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1171:2: iv_ruleContextAnnotation= ruleContextAnnotation EOF
            {
             newCompositeNode(grammarAccess.getContextAnnotationRule()); 
            pushFollow(FOLLOW_ruleContextAnnotation_in_entryRuleContextAnnotation2676);
            iv_ruleContextAnnotation=ruleContextAnnotation();

            state._fsp--;

             current =iv_ruleContextAnnotation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContextAnnotation2686); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContextAnnotation"


    // $ANTLR start "ruleContextAnnotation"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1178:1: ruleContextAnnotation returns [EObject current=null] : (otherlv_0= '@Context' otherlv_1= '(' ( (lv_context_2_0= ruleContext ) ) otherlv_3= ')' ) ;
    public final EObject ruleContextAnnotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Enumerator lv_context_2_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1181:28: ( (otherlv_0= '@Context' otherlv_1= '(' ( (lv_context_2_0= ruleContext ) ) otherlv_3= ')' ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1182:1: (otherlv_0= '@Context' otherlv_1= '(' ( (lv_context_2_0= ruleContext ) ) otherlv_3= ')' )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1182:1: (otherlv_0= '@Context' otherlv_1= '(' ( (lv_context_2_0= ruleContext ) ) otherlv_3= ')' )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1182:3: otherlv_0= '@Context' otherlv_1= '(' ( (lv_context_2_0= ruleContext ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleContextAnnotation2723); 

                	newLeafNode(otherlv_0, grammarAccess.getContextAnnotationAccess().getContextKeyword_0());
                
            otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleContextAnnotation2735); 

                	newLeafNode(otherlv_1, grammarAccess.getContextAnnotationAccess().getLeftParenthesisKeyword_1());
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1190:1: ( (lv_context_2_0= ruleContext ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1191:1: (lv_context_2_0= ruleContext )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1191:1: (lv_context_2_0= ruleContext )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1192:3: lv_context_2_0= ruleContext
            {
             
            	        newCompositeNode(grammarAccess.getContextAnnotationAccess().getContextContextEnumRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleContext_in_ruleContextAnnotation2756);
            lv_context_2_0=ruleContext();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getContextAnnotationRule());
            	        }
                   		set(
                   			current, 
                   			"context",
                    		lv_context_2_0, 
                    		"Context");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,30,FOLLOW_30_in_ruleContextAnnotation2768); 

                	newLeafNode(otherlv_3, grammarAccess.getContextAnnotationAccess().getRightParenthesisKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContextAnnotation"


    // $ANTLR start "entryRuleSamplingAnnotation"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1220:1: entryRuleSamplingAnnotation returns [EObject current=null] : iv_ruleSamplingAnnotation= ruleSamplingAnnotation EOF ;
    public final EObject entryRuleSamplingAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSamplingAnnotation = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1221:2: (iv_ruleSamplingAnnotation= ruleSamplingAnnotation EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1222:2: iv_ruleSamplingAnnotation= ruleSamplingAnnotation EOF
            {
             newCompositeNode(grammarAccess.getSamplingAnnotationRule()); 
            pushFollow(FOLLOW_ruleSamplingAnnotation_in_entryRuleSamplingAnnotation2804);
            iv_ruleSamplingAnnotation=ruleSamplingAnnotation();

            state._fsp--;

             current =iv_ruleSamplingAnnotation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSamplingAnnotation2814); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSamplingAnnotation"


    // $ANTLR start "ruleSamplingAnnotation"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1229:1: ruleSamplingAnnotation returns [EObject current=null] : (otherlv_0= '@SamplingTime' otherlv_1= '(' ( (lv_sampling_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final EObject ruleSamplingAnnotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_sampling_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1232:28: ( (otherlv_0= '@SamplingTime' otherlv_1= '(' ( (lv_sampling_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1233:1: (otherlv_0= '@SamplingTime' otherlv_1= '(' ( (lv_sampling_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1233:1: (otherlv_0= '@SamplingTime' otherlv_1= '(' ( (lv_sampling_2_0= RULE_INT ) ) otherlv_3= ')' )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1233:3: otherlv_0= '@SamplingTime' otherlv_1= '(' ( (lv_sampling_2_0= RULE_INT ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleSamplingAnnotation2851); 

                	newLeafNode(otherlv_0, grammarAccess.getSamplingAnnotationAccess().getSamplingTimeKeyword_0());
                
            otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleSamplingAnnotation2863); 

                	newLeafNode(otherlv_1, grammarAccess.getSamplingAnnotationAccess().getLeftParenthesisKeyword_1());
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1241:1: ( (lv_sampling_2_0= RULE_INT ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1242:1: (lv_sampling_2_0= RULE_INT )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1242:1: (lv_sampling_2_0= RULE_INT )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1243:3: lv_sampling_2_0= RULE_INT
            {
            lv_sampling_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSamplingAnnotation2880); 

            			newLeafNode(lv_sampling_2_0, grammarAccess.getSamplingAnnotationAccess().getSamplingINTTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSamplingAnnotationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"sampling",
                    		lv_sampling_2_0, 
                    		"INT");
            	    

            }


            }

            otherlv_3=(Token)match(input,30,FOLLOW_30_in_ruleSamplingAnnotation2897); 

                	newLeafNode(otherlv_3, grammarAccess.getSamplingAnnotationAccess().getRightParenthesisKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSamplingAnnotation"


    // $ANTLR start "entryRulePriorityAnnotation"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1271:1: entryRulePriorityAnnotation returns [EObject current=null] : iv_rulePriorityAnnotation= rulePriorityAnnotation EOF ;
    public final EObject entryRulePriorityAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePriorityAnnotation = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1272:2: (iv_rulePriorityAnnotation= rulePriorityAnnotation EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1273:2: iv_rulePriorityAnnotation= rulePriorityAnnotation EOF
            {
             newCompositeNode(grammarAccess.getPriorityAnnotationRule()); 
            pushFollow(FOLLOW_rulePriorityAnnotation_in_entryRulePriorityAnnotation2933);
            iv_rulePriorityAnnotation=rulePriorityAnnotation();

            state._fsp--;

             current =iv_rulePriorityAnnotation; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePriorityAnnotation2943); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePriorityAnnotation"


    // $ANTLR start "rulePriorityAnnotation"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1280:1: rulePriorityAnnotation returns [EObject current=null] : (otherlv_0= '@Priority' otherlv_1= '(' ( (lv_priority_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final EObject rulePriorityAnnotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_priority_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1283:28: ( (otherlv_0= '@Priority' otherlv_1= '(' ( (lv_priority_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1284:1: (otherlv_0= '@Priority' otherlv_1= '(' ( (lv_priority_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1284:1: (otherlv_0= '@Priority' otherlv_1= '(' ( (lv_priority_2_0= RULE_INT ) ) otherlv_3= ')' )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1284:3: otherlv_0= '@Priority' otherlv_1= '(' ( (lv_priority_2_0= RULE_INT ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_rulePriorityAnnotation2980); 

                	newLeafNode(otherlv_0, grammarAccess.getPriorityAnnotationAccess().getPriorityKeyword_0());
                
            otherlv_1=(Token)match(input,29,FOLLOW_29_in_rulePriorityAnnotation2992); 

                	newLeafNode(otherlv_1, grammarAccess.getPriorityAnnotationAccess().getLeftParenthesisKeyword_1());
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1292:1: ( (lv_priority_2_0= RULE_INT ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1293:1: (lv_priority_2_0= RULE_INT )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1293:1: (lv_priority_2_0= RULE_INT )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1294:3: lv_priority_2_0= RULE_INT
            {
            lv_priority_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_rulePriorityAnnotation3009); 

            			newLeafNode(lv_priority_2_0, grammarAccess.getPriorityAnnotationAccess().getPriorityINTTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPriorityAnnotationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"priority",
                    		lv_priority_2_0, 
                    		"INT");
            	    

            }


            }

            otherlv_3=(Token)match(input,30,FOLLOW_30_in_rulePriorityAnnotation3026); 

                	newLeafNode(otherlv_3, grammarAccess.getPriorityAnnotationAccess().getRightParenthesisKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePriorityAnnotation"


    // $ANTLR start "entryRuleParameterFilterRule"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1322:1: entryRuleParameterFilterRule returns [EObject current=null] : iv_ruleParameterFilterRule= ruleParameterFilterRule EOF ;
    public final EObject entryRuleParameterFilterRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterFilterRule = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1323:2: (iv_ruleParameterFilterRule= ruleParameterFilterRule EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1324:2: iv_ruleParameterFilterRule= ruleParameterFilterRule EOF
            {
             newCompositeNode(grammarAccess.getParameterFilterRuleRule()); 
            pushFollow(FOLLOW_ruleParameterFilterRule_in_entryRuleParameterFilterRule3062);
            iv_ruleParameterFilterRule=ruleParameterFilterRule();

            state._fsp--;

             current =iv_ruleParameterFilterRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterFilterRule3072); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterFilterRule"


    // $ANTLR start "ruleParameterFilterRule"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1331:1: ruleParameterFilterRule returns [EObject current=null] : (this_RangeFilter_0= ruleRangeFilter | this_NumericFilter_1= ruleNumericFilter | this_LiteralFilter_2= ruleLiteralFilter ) ;
    public final EObject ruleParameterFilterRule() throws RecognitionException {
        EObject current = null;

        EObject this_RangeFilter_0 = null;

        EObject this_NumericFilter_1 = null;

        EObject this_LiteralFilter_2 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1334:28: ( (this_RangeFilter_0= ruleRangeFilter | this_NumericFilter_1= ruleNumericFilter | this_LiteralFilter_2= ruleLiteralFilter ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1335:1: (this_RangeFilter_0= ruleRangeFilter | this_NumericFilter_1= ruleNumericFilter | this_LiteralFilter_2= ruleLiteralFilter )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1335:1: (this_RangeFilter_0= ruleRangeFilter | this_NumericFilter_1= ruleNumericFilter | this_LiteralFilter_2= ruleLiteralFilter )
            int alt15=3;
            switch ( input.LA(1) ) {
            case 47:
                {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==34) ) {
                    alt15=1;
                }
                else if ( ((LA15_1>=44 && LA15_1<=46)) ) {
                    alt15=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;
                }
                }
                break;
            case 34:
                {
                alt15=1;
                }
                break;
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
                {
                alt15=2;
                }
                break;
            case 44:
            case 45:
            case 46:
                {
                alt15=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1336:5: this_RangeFilter_0= ruleRangeFilter
                    {
                     
                            newCompositeNode(grammarAccess.getParameterFilterRuleAccess().getRangeFilterParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleRangeFilter_in_ruleParameterFilterRule3119);
                    this_RangeFilter_0=ruleRangeFilter();

                    state._fsp--;

                     
                            current = this_RangeFilter_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1346:5: this_NumericFilter_1= ruleNumericFilter
                    {
                     
                            newCompositeNode(grammarAccess.getParameterFilterRuleAccess().getNumericFilterParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleNumericFilter_in_ruleParameterFilterRule3146);
                    this_NumericFilter_1=ruleNumericFilter();

                    state._fsp--;

                     
                            current = this_NumericFilter_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1356:5: this_LiteralFilter_2= ruleLiteralFilter
                    {
                     
                            newCompositeNode(grammarAccess.getParameterFilterRuleAccess().getLiteralFilterParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleLiteralFilter_in_ruleParameterFilterRule3173);
                    this_LiteralFilter_2=ruleLiteralFilter();

                    state._fsp--;

                     
                            current = this_LiteralFilter_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterFilterRule"


    // $ANTLR start "entryRuleRangeFilter"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1372:1: entryRuleRangeFilter returns [EObject current=null] : iv_ruleRangeFilter= ruleRangeFilter EOF ;
    public final EObject entryRuleRangeFilter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeFilter = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1373:2: (iv_ruleRangeFilter= ruleRangeFilter EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1374:2: iv_ruleRangeFilter= ruleRangeFilter EOF
            {
             newCompositeNode(grammarAccess.getRangeFilterRule()); 
            pushFollow(FOLLOW_ruleRangeFilter_in_entryRuleRangeFilter3208);
            iv_ruleRangeFilter=ruleRangeFilter();

            state._fsp--;

             current =iv_ruleRangeFilter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRangeFilter3218); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRangeFilter"


    // $ANTLR start "ruleRangeFilter"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1381:1: ruleRangeFilter returns [EObject current=null] : ( ( (lv_neg_0_0= ruleNegationOpartor ) )? otherlv_1= 'in' ( (lv_range_2_0= ruleRange ) ) ) ;
    public final EObject ruleRangeFilter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_neg_0_0 = null;

        EObject lv_range_2_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1384:28: ( ( ( (lv_neg_0_0= ruleNegationOpartor ) )? otherlv_1= 'in' ( (lv_range_2_0= ruleRange ) ) ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1385:1: ( ( (lv_neg_0_0= ruleNegationOpartor ) )? otherlv_1= 'in' ( (lv_range_2_0= ruleRange ) ) )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1385:1: ( ( (lv_neg_0_0= ruleNegationOpartor ) )? otherlv_1= 'in' ( (lv_range_2_0= ruleRange ) ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1385:2: ( (lv_neg_0_0= ruleNegationOpartor ) )? otherlv_1= 'in' ( (lv_range_2_0= ruleRange ) )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1385:2: ( (lv_neg_0_0= ruleNegationOpartor ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==47) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1386:1: (lv_neg_0_0= ruleNegationOpartor )
                    {
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1386:1: (lv_neg_0_0= ruleNegationOpartor )
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1387:3: lv_neg_0_0= ruleNegationOpartor
                    {
                     
                    	        newCompositeNode(grammarAccess.getRangeFilterAccess().getNegNegationOpartorParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNegationOpartor_in_ruleRangeFilter3264);
                    lv_neg_0_0=ruleNegationOpartor();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRangeFilterRule());
                    	        }
                           		set(
                           			current, 
                           			"neg",
                            		lv_neg_0_0, 
                            		"NegationOpartor");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleRangeFilter3277); 

                	newLeafNode(otherlv_1, grammarAccess.getRangeFilterAccess().getInKeyword_1());
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1407:1: ( (lv_range_2_0= ruleRange ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1408:1: (lv_range_2_0= ruleRange )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1408:1: (lv_range_2_0= ruleRange )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1409:3: lv_range_2_0= ruleRange
            {
             
            	        newCompositeNode(grammarAccess.getRangeFilterAccess().getRangeRangeParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleRange_in_ruleRangeFilter3298);
            lv_range_2_0=ruleRange();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRangeFilterRule());
            	        }
                   		set(
                   			current, 
                   			"range",
                    		lv_range_2_0, 
                    		"Range");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRangeFilter"


    // $ANTLR start "entryRuleRange"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1433:1: entryRuleRange returns [EObject current=null] : iv_ruleRange= ruleRange EOF ;
    public final EObject entryRuleRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRange = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1434:2: (iv_ruleRange= ruleRange EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1435:2: iv_ruleRange= ruleRange EOF
            {
             newCompositeNode(grammarAccess.getRangeRule()); 
            pushFollow(FOLLOW_ruleRange_in_entryRuleRange3334);
            iv_ruleRange=ruleRange();

            state._fsp--;

             current =iv_ruleRange; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRange3344); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRange"


    // $ANTLR start "ruleRange"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1442:1: ruleRange returns [EObject current=null] : (this_OpenOpen_0= ruleOpenOpen | this_OpenClosed_1= ruleOpenClosed | this_ClosedClosed_2= ruleClosedClosed | this_ClosedOpen_3= ruleClosedOpen ) ;
    public final EObject ruleRange() throws RecognitionException {
        EObject current = null;

        EObject this_OpenOpen_0 = null;

        EObject this_OpenClosed_1 = null;

        EObject this_ClosedClosed_2 = null;

        EObject this_ClosedOpen_3 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1445:28: ( (this_OpenOpen_0= ruleOpenOpen | this_OpenClosed_1= ruleOpenClosed | this_ClosedClosed_2= ruleClosedClosed | this_ClosedOpen_3= ruleClosedOpen ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1446:1: (this_OpenOpen_0= ruleOpenOpen | this_OpenClosed_1= ruleOpenClosed | this_ClosedClosed_2= ruleClosedClosed | this_ClosedOpen_3= ruleClosedOpen )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1446:1: (this_OpenOpen_0= ruleOpenOpen | this_OpenClosed_1= ruleOpenClosed | this_ClosedClosed_2= ruleClosedClosed | this_ClosedOpen_3= ruleClosedOpen )
            int alt17=4;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1447:5: this_OpenOpen_0= ruleOpenOpen
                    {
                     
                            newCompositeNode(grammarAccess.getRangeAccess().getOpenOpenParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleOpenOpen_in_ruleRange3391);
                    this_OpenOpen_0=ruleOpenOpen();

                    state._fsp--;

                     
                            current = this_OpenOpen_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1457:5: this_OpenClosed_1= ruleOpenClosed
                    {
                     
                            newCompositeNode(grammarAccess.getRangeAccess().getOpenClosedParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleOpenClosed_in_ruleRange3418);
                    this_OpenClosed_1=ruleOpenClosed();

                    state._fsp--;

                     
                            current = this_OpenClosed_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1467:5: this_ClosedClosed_2= ruleClosedClosed
                    {
                     
                            newCompositeNode(grammarAccess.getRangeAccess().getClosedClosedParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleClosedClosed_in_ruleRange3445);
                    this_ClosedClosed_2=ruleClosedClosed();

                    state._fsp--;

                     
                            current = this_ClosedClosed_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1477:5: this_ClosedOpen_3= ruleClosedOpen
                    {
                     
                            newCompositeNode(grammarAccess.getRangeAccess().getClosedOpenParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleClosedOpen_in_ruleRange3472);
                    this_ClosedOpen_3=ruleClosedOpen();

                    state._fsp--;

                     
                            current = this_ClosedOpen_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRange"


    // $ANTLR start "entryRuleOpenOpen"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1493:1: entryRuleOpenOpen returns [EObject current=null] : iv_ruleOpenOpen= ruleOpenOpen EOF ;
    public final EObject entryRuleOpenOpen() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOpenOpen = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1494:2: (iv_ruleOpenOpen= ruleOpenOpen EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1495:2: iv_ruleOpenOpen= ruleOpenOpen EOF
            {
             newCompositeNode(grammarAccess.getOpenOpenRule()); 
            pushFollow(FOLLOW_ruleOpenOpen_in_entryRuleOpenOpen3507);
            iv_ruleOpenOpen=ruleOpenOpen();

            state._fsp--;

             current =iv_ruleOpenOpen; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpenOpen3517); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpenOpen"


    // $ANTLR start "ruleOpenOpen"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1502:1: ruleOpenOpen returns [EObject current=null] : (otherlv_0= '(' ( (lv_lowerBound_1_0= ruleDOUBLE ) ) otherlv_2= ',' ( (lv_upperBound_3_0= ruleDOUBLE ) ) otherlv_4= ')' ) ;
    public final EObject ruleOpenOpen() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_lowerBound_1_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_3_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1505:28: ( (otherlv_0= '(' ( (lv_lowerBound_1_0= ruleDOUBLE ) ) otherlv_2= ',' ( (lv_upperBound_3_0= ruleDOUBLE ) ) otherlv_4= ')' ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1506:1: (otherlv_0= '(' ( (lv_lowerBound_1_0= ruleDOUBLE ) ) otherlv_2= ',' ( (lv_upperBound_3_0= ruleDOUBLE ) ) otherlv_4= ')' )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1506:1: (otherlv_0= '(' ( (lv_lowerBound_1_0= ruleDOUBLE ) ) otherlv_2= ',' ( (lv_upperBound_3_0= ruleDOUBLE ) ) otherlv_4= ')' )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1506:3: otherlv_0= '(' ( (lv_lowerBound_1_0= ruleDOUBLE ) ) otherlv_2= ',' ( (lv_upperBound_3_0= ruleDOUBLE ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleOpenOpen3554); 

                	newLeafNode(otherlv_0, grammarAccess.getOpenOpenAccess().getLeftParenthesisKeyword_0());
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1510:1: ( (lv_lowerBound_1_0= ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1511:1: (lv_lowerBound_1_0= ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1511:1: (lv_lowerBound_1_0= ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1512:3: lv_lowerBound_1_0= ruleDOUBLE
            {
             
            	        newCompositeNode(grammarAccess.getOpenOpenAccess().getLowerBoundDOUBLEParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleDOUBLE_in_ruleOpenOpen3575);
            lv_lowerBound_1_0=ruleDOUBLE();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOpenOpenRule());
            	        }
                   		set(
                   			current, 
                   			"lowerBound",
                    		lv_lowerBound_1_0, 
                    		"DOUBLE");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,35,FOLLOW_35_in_ruleOpenOpen3587); 

                	newLeafNode(otherlv_2, grammarAccess.getOpenOpenAccess().getCommaKeyword_2());
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1532:1: ( (lv_upperBound_3_0= ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1533:1: (lv_upperBound_3_0= ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1533:1: (lv_upperBound_3_0= ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1534:3: lv_upperBound_3_0= ruleDOUBLE
            {
             
            	        newCompositeNode(grammarAccess.getOpenOpenAccess().getUpperBoundDOUBLEParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleDOUBLE_in_ruleOpenOpen3608);
            lv_upperBound_3_0=ruleDOUBLE();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOpenOpenRule());
            	        }
                   		set(
                   			current, 
                   			"upperBound",
                    		lv_upperBound_3_0, 
                    		"DOUBLE");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,30,FOLLOW_30_in_ruleOpenOpen3620); 

                	newLeafNode(otherlv_4, grammarAccess.getOpenOpenAccess().getRightParenthesisKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpenOpen"


    // $ANTLR start "entryRuleOpenClosed"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1562:1: entryRuleOpenClosed returns [EObject current=null] : iv_ruleOpenClosed= ruleOpenClosed EOF ;
    public final EObject entryRuleOpenClosed() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOpenClosed = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1563:2: (iv_ruleOpenClosed= ruleOpenClosed EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1564:2: iv_ruleOpenClosed= ruleOpenClosed EOF
            {
             newCompositeNode(grammarAccess.getOpenClosedRule()); 
            pushFollow(FOLLOW_ruleOpenClosed_in_entryRuleOpenClosed3656);
            iv_ruleOpenClosed=ruleOpenClosed();

            state._fsp--;

             current =iv_ruleOpenClosed; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpenClosed3666); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpenClosed"


    // $ANTLR start "ruleOpenClosed"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1571:1: ruleOpenClosed returns [EObject current=null] : (otherlv_0= '(' ( (lv_lowerBound_1_0= ruleDOUBLE ) ) otherlv_2= ',' ( (lv_upperBound_3_0= ruleDOUBLE ) ) otherlv_4= ']' ) ;
    public final EObject ruleOpenClosed() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_lowerBound_1_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_3_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1574:28: ( (otherlv_0= '(' ( (lv_lowerBound_1_0= ruleDOUBLE ) ) otherlv_2= ',' ( (lv_upperBound_3_0= ruleDOUBLE ) ) otherlv_4= ']' ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1575:1: (otherlv_0= '(' ( (lv_lowerBound_1_0= ruleDOUBLE ) ) otherlv_2= ',' ( (lv_upperBound_3_0= ruleDOUBLE ) ) otherlv_4= ']' )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1575:1: (otherlv_0= '(' ( (lv_lowerBound_1_0= ruleDOUBLE ) ) otherlv_2= ',' ( (lv_upperBound_3_0= ruleDOUBLE ) ) otherlv_4= ']' )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1575:3: otherlv_0= '(' ( (lv_lowerBound_1_0= ruleDOUBLE ) ) otherlv_2= ',' ( (lv_upperBound_3_0= ruleDOUBLE ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleOpenClosed3703); 

                	newLeafNode(otherlv_0, grammarAccess.getOpenClosedAccess().getLeftParenthesisKeyword_0());
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1579:1: ( (lv_lowerBound_1_0= ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1580:1: (lv_lowerBound_1_0= ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1580:1: (lv_lowerBound_1_0= ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1581:3: lv_lowerBound_1_0= ruleDOUBLE
            {
             
            	        newCompositeNode(grammarAccess.getOpenClosedAccess().getLowerBoundDOUBLEParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleDOUBLE_in_ruleOpenClosed3724);
            lv_lowerBound_1_0=ruleDOUBLE();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOpenClosedRule());
            	        }
                   		set(
                   			current, 
                   			"lowerBound",
                    		lv_lowerBound_1_0, 
                    		"DOUBLE");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,35,FOLLOW_35_in_ruleOpenClosed3736); 

                	newLeafNode(otherlv_2, grammarAccess.getOpenClosedAccess().getCommaKeyword_2());
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1601:1: ( (lv_upperBound_3_0= ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1602:1: (lv_upperBound_3_0= ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1602:1: (lv_upperBound_3_0= ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1603:3: lv_upperBound_3_0= ruleDOUBLE
            {
             
            	        newCompositeNode(grammarAccess.getOpenClosedAccess().getUpperBoundDOUBLEParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleDOUBLE_in_ruleOpenClosed3757);
            lv_upperBound_3_0=ruleDOUBLE();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOpenClosedRule());
            	        }
                   		set(
                   			current, 
                   			"upperBound",
                    		lv_upperBound_3_0, 
                    		"DOUBLE");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,36,FOLLOW_36_in_ruleOpenClosed3769); 

                	newLeafNode(otherlv_4, grammarAccess.getOpenClosedAccess().getRightSquareBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpenClosed"


    // $ANTLR start "entryRuleClosedClosed"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1631:1: entryRuleClosedClosed returns [EObject current=null] : iv_ruleClosedClosed= ruleClosedClosed EOF ;
    public final EObject entryRuleClosedClosed() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClosedClosed = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1632:2: (iv_ruleClosedClosed= ruleClosedClosed EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1633:2: iv_ruleClosedClosed= ruleClosedClosed EOF
            {
             newCompositeNode(grammarAccess.getClosedClosedRule()); 
            pushFollow(FOLLOW_ruleClosedClosed_in_entryRuleClosedClosed3805);
            iv_ruleClosedClosed=ruleClosedClosed();

            state._fsp--;

             current =iv_ruleClosedClosed; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClosedClosed3815); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClosedClosed"


    // $ANTLR start "ruleClosedClosed"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1640:1: ruleClosedClosed returns [EObject current=null] : (otherlv_0= '[' ( (lv_lowerBound_1_0= ruleDOUBLE ) ) otherlv_2= ',' ( (lv_upperBound_3_0= ruleDOUBLE ) ) otherlv_4= ')' ) ;
    public final EObject ruleClosedClosed() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_lowerBound_1_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_3_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1643:28: ( (otherlv_0= '[' ( (lv_lowerBound_1_0= ruleDOUBLE ) ) otherlv_2= ',' ( (lv_upperBound_3_0= ruleDOUBLE ) ) otherlv_4= ')' ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1644:1: (otherlv_0= '[' ( (lv_lowerBound_1_0= ruleDOUBLE ) ) otherlv_2= ',' ( (lv_upperBound_3_0= ruleDOUBLE ) ) otherlv_4= ')' )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1644:1: (otherlv_0= '[' ( (lv_lowerBound_1_0= ruleDOUBLE ) ) otherlv_2= ',' ( (lv_upperBound_3_0= ruleDOUBLE ) ) otherlv_4= ')' )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1644:3: otherlv_0= '[' ( (lv_lowerBound_1_0= ruleDOUBLE ) ) otherlv_2= ',' ( (lv_upperBound_3_0= ruleDOUBLE ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_37_in_ruleClosedClosed3852); 

                	newLeafNode(otherlv_0, grammarAccess.getClosedClosedAccess().getLeftSquareBracketKeyword_0());
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1648:1: ( (lv_lowerBound_1_0= ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1649:1: (lv_lowerBound_1_0= ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1649:1: (lv_lowerBound_1_0= ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1650:3: lv_lowerBound_1_0= ruleDOUBLE
            {
             
            	        newCompositeNode(grammarAccess.getClosedClosedAccess().getLowerBoundDOUBLEParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleDOUBLE_in_ruleClosedClosed3873);
            lv_lowerBound_1_0=ruleDOUBLE();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getClosedClosedRule());
            	        }
                   		set(
                   			current, 
                   			"lowerBound",
                    		lv_lowerBound_1_0, 
                    		"DOUBLE");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,35,FOLLOW_35_in_ruleClosedClosed3885); 

                	newLeafNode(otherlv_2, grammarAccess.getClosedClosedAccess().getCommaKeyword_2());
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1670:1: ( (lv_upperBound_3_0= ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1671:1: (lv_upperBound_3_0= ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1671:1: (lv_upperBound_3_0= ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1672:3: lv_upperBound_3_0= ruleDOUBLE
            {
             
            	        newCompositeNode(grammarAccess.getClosedClosedAccess().getUpperBoundDOUBLEParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleDOUBLE_in_ruleClosedClosed3906);
            lv_upperBound_3_0=ruleDOUBLE();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getClosedClosedRule());
            	        }
                   		set(
                   			current, 
                   			"upperBound",
                    		lv_upperBound_3_0, 
                    		"DOUBLE");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,30,FOLLOW_30_in_ruleClosedClosed3918); 

                	newLeafNode(otherlv_4, grammarAccess.getClosedClosedAccess().getRightParenthesisKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClosedClosed"


    // $ANTLR start "entryRuleClosedOpen"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1700:1: entryRuleClosedOpen returns [EObject current=null] : iv_ruleClosedOpen= ruleClosedOpen EOF ;
    public final EObject entryRuleClosedOpen() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClosedOpen = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1701:2: (iv_ruleClosedOpen= ruleClosedOpen EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1702:2: iv_ruleClosedOpen= ruleClosedOpen EOF
            {
             newCompositeNode(grammarAccess.getClosedOpenRule()); 
            pushFollow(FOLLOW_ruleClosedOpen_in_entryRuleClosedOpen3954);
            iv_ruleClosedOpen=ruleClosedOpen();

            state._fsp--;

             current =iv_ruleClosedOpen; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClosedOpen3964); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClosedOpen"


    // $ANTLR start "ruleClosedOpen"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1709:1: ruleClosedOpen returns [EObject current=null] : (otherlv_0= '[' ( (lv_lowerBound_1_0= ruleDOUBLE ) ) otherlv_2= ',' ( (lv_upperBound_3_0= ruleDOUBLE ) ) otherlv_4= ']' ) ;
    public final EObject ruleClosedOpen() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_lowerBound_1_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_3_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1712:28: ( (otherlv_0= '[' ( (lv_lowerBound_1_0= ruleDOUBLE ) ) otherlv_2= ',' ( (lv_upperBound_3_0= ruleDOUBLE ) ) otherlv_4= ']' ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1713:1: (otherlv_0= '[' ( (lv_lowerBound_1_0= ruleDOUBLE ) ) otherlv_2= ',' ( (lv_upperBound_3_0= ruleDOUBLE ) ) otherlv_4= ']' )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1713:1: (otherlv_0= '[' ( (lv_lowerBound_1_0= ruleDOUBLE ) ) otherlv_2= ',' ( (lv_upperBound_3_0= ruleDOUBLE ) ) otherlv_4= ']' )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1713:3: otherlv_0= '[' ( (lv_lowerBound_1_0= ruleDOUBLE ) ) otherlv_2= ',' ( (lv_upperBound_3_0= ruleDOUBLE ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_37_in_ruleClosedOpen4001); 

                	newLeafNode(otherlv_0, grammarAccess.getClosedOpenAccess().getLeftSquareBracketKeyword_0());
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1717:1: ( (lv_lowerBound_1_0= ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1718:1: (lv_lowerBound_1_0= ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1718:1: (lv_lowerBound_1_0= ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1719:3: lv_lowerBound_1_0= ruleDOUBLE
            {
             
            	        newCompositeNode(grammarAccess.getClosedOpenAccess().getLowerBoundDOUBLEParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleDOUBLE_in_ruleClosedOpen4022);
            lv_lowerBound_1_0=ruleDOUBLE();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getClosedOpenRule());
            	        }
                   		set(
                   			current, 
                   			"lowerBound",
                    		lv_lowerBound_1_0, 
                    		"DOUBLE");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,35,FOLLOW_35_in_ruleClosedOpen4034); 

                	newLeafNode(otherlv_2, grammarAccess.getClosedOpenAccess().getCommaKeyword_2());
                
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1739:1: ( (lv_upperBound_3_0= ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1740:1: (lv_upperBound_3_0= ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1740:1: (lv_upperBound_3_0= ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1741:3: lv_upperBound_3_0= ruleDOUBLE
            {
             
            	        newCompositeNode(grammarAccess.getClosedOpenAccess().getUpperBoundDOUBLEParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleDOUBLE_in_ruleClosedOpen4055);
            lv_upperBound_3_0=ruleDOUBLE();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getClosedOpenRule());
            	        }
                   		set(
                   			current, 
                   			"upperBound",
                    		lv_upperBound_3_0, 
                    		"DOUBLE");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,36,FOLLOW_36_in_ruleClosedOpen4067); 

                	newLeafNode(otherlv_4, grammarAccess.getClosedOpenAccess().getRightSquareBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClosedOpen"


    // $ANTLR start "entryRuleNumericFilter"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1769:1: entryRuleNumericFilter returns [EObject current=null] : iv_ruleNumericFilter= ruleNumericFilter EOF ;
    public final EObject entryRuleNumericFilter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericFilter = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1770:2: (iv_ruleNumericFilter= ruleNumericFilter EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1771:2: iv_ruleNumericFilter= ruleNumericFilter EOF
            {
             newCompositeNode(grammarAccess.getNumericFilterRule()); 
            pushFollow(FOLLOW_ruleNumericFilter_in_entryRuleNumericFilter4103);
            iv_ruleNumericFilter=ruleNumericFilter();

            state._fsp--;

             current =iv_ruleNumericFilter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericFilter4113); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumericFilter"


    // $ANTLR start "ruleNumericFilter"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1778:1: ruleNumericFilter returns [EObject current=null] : ( ( (lv_operator_0_0= ruleNumericOperator ) ) ( (lv_value_1_0= ruleDOUBLE ) ) ) ;
    public final EObject ruleNumericFilter() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_operator_0_0 = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1781:28: ( ( ( (lv_operator_0_0= ruleNumericOperator ) ) ( (lv_value_1_0= ruleDOUBLE ) ) ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1782:1: ( ( (lv_operator_0_0= ruleNumericOperator ) ) ( (lv_value_1_0= ruleDOUBLE ) ) )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1782:1: ( ( (lv_operator_0_0= ruleNumericOperator ) ) ( (lv_value_1_0= ruleDOUBLE ) ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1782:2: ( (lv_operator_0_0= ruleNumericOperator ) ) ( (lv_value_1_0= ruleDOUBLE ) )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1782:2: ( (lv_operator_0_0= ruleNumericOperator ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1783:1: (lv_operator_0_0= ruleNumericOperator )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1783:1: (lv_operator_0_0= ruleNumericOperator )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1784:3: lv_operator_0_0= ruleNumericOperator
            {
             
            	        newCompositeNode(grammarAccess.getNumericFilterAccess().getOperatorNumericOperatorParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleNumericOperator_in_ruleNumericFilter4159);
            lv_operator_0_0=ruleNumericOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNumericFilterRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_0_0, 
                    		"NumericOperator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1800:2: ( (lv_value_1_0= ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1801:1: (lv_value_1_0= ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1801:1: (lv_value_1_0= ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1802:3: lv_value_1_0= ruleDOUBLE
            {
             
            	        newCompositeNode(grammarAccess.getNumericFilterAccess().getValueDOUBLEParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleDOUBLE_in_ruleNumericFilter4180);
            lv_value_1_0=ruleDOUBLE();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNumericFilterRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"DOUBLE");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumericFilter"


    // $ANTLR start "entryRuleNumericOperator"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1826:1: entryRuleNumericOperator returns [String current=null] : iv_ruleNumericOperator= ruleNumericOperator EOF ;
    public final String entryRuleNumericOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNumericOperator = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1827:2: (iv_ruleNumericOperator= ruleNumericOperator EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1828:2: iv_ruleNumericOperator= ruleNumericOperator EOF
            {
             newCompositeNode(grammarAccess.getNumericOperatorRule()); 
            pushFollow(FOLLOW_ruleNumericOperator_in_entryRuleNumericOperator4217);
            iv_ruleNumericOperator=ruleNumericOperator();

            state._fsp--;

             current =iv_ruleNumericOperator.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericOperator4228); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumericOperator"


    // $ANTLR start "ruleNumericOperator"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1835:1: ruleNumericOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '<' | kw= '=<' | kw= '==' | kw= '!=' | kw= '>=' | kw= '>' ) ;
    public final AntlrDatatypeRuleToken ruleNumericOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1838:28: ( (kw= '<' | kw= '=<' | kw= '==' | kw= '!=' | kw= '>=' | kw= '>' ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1839:1: (kw= '<' | kw= '=<' | kw= '==' | kw= '!=' | kw= '>=' | kw= '>' )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1839:1: (kw= '<' | kw= '=<' | kw= '==' | kw= '!=' | kw= '>=' | kw= '>' )
            int alt18=6;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt18=1;
                }
                break;
            case 39:
                {
                alt18=2;
                }
                break;
            case 40:
                {
                alt18=3;
                }
                break;
            case 41:
                {
                alt18=4;
                }
                break;
            case 42:
                {
                alt18=5;
                }
                break;
            case 43:
                {
                alt18=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1840:2: kw= '<'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleNumericOperator4266); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNumericOperatorAccess().getLessThanSignKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1847:2: kw= '=<'
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleNumericOperator4285); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNumericOperatorAccess().getEqualsSignLessThanSignKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1854:2: kw= '=='
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleNumericOperator4304); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNumericOperatorAccess().getEqualsSignEqualsSignKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1861:2: kw= '!='
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleNumericOperator4323); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNumericOperatorAccess().getExclamationMarkEqualsSignKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1868:2: kw= '>='
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleNumericOperator4342); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNumericOperatorAccess().getGreaterThanSignEqualsSignKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1875:2: kw= '>'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleNumericOperator4361); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNumericOperatorAccess().getGreaterThanSignKeyword_5()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumericOperator"


    // $ANTLR start "entryRuleLiteralFilter"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1888:1: entryRuleLiteralFilter returns [EObject current=null] : iv_ruleLiteralFilter= ruleLiteralFilter EOF ;
    public final EObject entryRuleLiteralFilter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralFilter = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1889:2: (iv_ruleLiteralFilter= ruleLiteralFilter EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1890:2: iv_ruleLiteralFilter= ruleLiteralFilter EOF
            {
             newCompositeNode(grammarAccess.getLiteralFilterRule()); 
            pushFollow(FOLLOW_ruleLiteralFilter_in_entryRuleLiteralFilter4401);
            iv_ruleLiteralFilter=ruleLiteralFilter();

            state._fsp--;

             current =iv_ruleLiteralFilter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralFilter4411); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralFilter"


    // $ANTLR start "ruleLiteralFilter"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1897:1: ruleLiteralFilter returns [EObject current=null] : ( ( (lv_neg_0_0= ruleNegationOpartor ) )? ( (lv_operator_1_0= ruleLiteralOperator ) ) ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleLiteralFilter() throws RecognitionException {
        EObject current = null;

        Token lv_value_2_0=null;
        AntlrDatatypeRuleToken lv_neg_0_0 = null;

        AntlrDatatypeRuleToken lv_operator_1_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1900:28: ( ( ( (lv_neg_0_0= ruleNegationOpartor ) )? ( (lv_operator_1_0= ruleLiteralOperator ) ) ( (lv_value_2_0= RULE_STRING ) ) ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1901:1: ( ( (lv_neg_0_0= ruleNegationOpartor ) )? ( (lv_operator_1_0= ruleLiteralOperator ) ) ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1901:1: ( ( (lv_neg_0_0= ruleNegationOpartor ) )? ( (lv_operator_1_0= ruleLiteralOperator ) ) ( (lv_value_2_0= RULE_STRING ) ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1901:2: ( (lv_neg_0_0= ruleNegationOpartor ) )? ( (lv_operator_1_0= ruleLiteralOperator ) ) ( (lv_value_2_0= RULE_STRING ) )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1901:2: ( (lv_neg_0_0= ruleNegationOpartor ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==47) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1902:1: (lv_neg_0_0= ruleNegationOpartor )
                    {
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1902:1: (lv_neg_0_0= ruleNegationOpartor )
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1903:3: lv_neg_0_0= ruleNegationOpartor
                    {
                     
                    	        newCompositeNode(grammarAccess.getLiteralFilterAccess().getNegNegationOpartorParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNegationOpartor_in_ruleLiteralFilter4457);
                    lv_neg_0_0=ruleNegationOpartor();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLiteralFilterRule());
                    	        }
                           		set(
                           			current, 
                           			"neg",
                            		lv_neg_0_0, 
                            		"NegationOpartor");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1919:3: ( (lv_operator_1_0= ruleLiteralOperator ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1920:1: (lv_operator_1_0= ruleLiteralOperator )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1920:1: (lv_operator_1_0= ruleLiteralOperator )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1921:3: lv_operator_1_0= ruleLiteralOperator
            {
             
            	        newCompositeNode(grammarAccess.getLiteralFilterAccess().getOperatorLiteralOperatorParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleLiteralOperator_in_ruleLiteralFilter4479);
            lv_operator_1_0=ruleLiteralOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLiteralFilterRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_1_0, 
                    		"LiteralOperator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1937:2: ( (lv_value_2_0= RULE_STRING ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1938:1: (lv_value_2_0= RULE_STRING )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1938:1: (lv_value_2_0= RULE_STRING )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1939:3: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLiteralFilter4496); 

            			newLeafNode(lv_value_2_0, grammarAccess.getLiteralFilterAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLiteralFilterRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralFilter"


    // $ANTLR start "entryRuleLiteralOperator"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1963:1: entryRuleLiteralOperator returns [String current=null] : iv_ruleLiteralOperator= ruleLiteralOperator EOF ;
    public final String entryRuleLiteralOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLiteralOperator = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1964:2: (iv_ruleLiteralOperator= ruleLiteralOperator EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1965:2: iv_ruleLiteralOperator= ruleLiteralOperator EOF
            {
             newCompositeNode(grammarAccess.getLiteralOperatorRule()); 
            pushFollow(FOLLOW_ruleLiteralOperator_in_entryRuleLiteralOperator4538);
            iv_ruleLiteralOperator=ruleLiteralOperator();

            state._fsp--;

             current =iv_ruleLiteralOperator.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralOperator4549); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralOperator"


    // $ANTLR start "ruleLiteralOperator"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1972:1: ruleLiteralOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'contains' | kw= 'startsWith' | kw= 'endsWith' ) ;
    public final AntlrDatatypeRuleToken ruleLiteralOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1975:28: ( (kw= 'contains' | kw= 'startsWith' | kw= 'endsWith' ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1976:1: (kw= 'contains' | kw= 'startsWith' | kw= 'endsWith' )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1976:1: (kw= 'contains' | kw= 'startsWith' | kw= 'endsWith' )
            int alt20=3;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt20=1;
                }
                break;
            case 45:
                {
                alt20=2;
                }
                break;
            case 46:
                {
                alt20=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1977:2: kw= 'contains'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleLiteralOperator4587); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLiteralOperatorAccess().getContainsKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1984:2: kw= 'startsWith'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleLiteralOperator4606); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLiteralOperatorAccess().getStartsWithKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:1991:2: kw= 'endsWith'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleLiteralOperator4625); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLiteralOperatorAccess().getEndsWithKeyword_2()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralOperator"


    // $ANTLR start "entryRuleNegationOpartor"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2004:1: entryRuleNegationOpartor returns [String current=null] : iv_ruleNegationOpartor= ruleNegationOpartor EOF ;
    public final String entryRuleNegationOpartor() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNegationOpartor = null;


        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2005:2: (iv_ruleNegationOpartor= ruleNegationOpartor EOF )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2006:2: iv_ruleNegationOpartor= ruleNegationOpartor EOF
            {
             newCompositeNode(grammarAccess.getNegationOpartorRule()); 
            pushFollow(FOLLOW_ruleNegationOpartor_in_entryRuleNegationOpartor4666);
            iv_ruleNegationOpartor=ruleNegationOpartor();

            state._fsp--;

             current =iv_ruleNegationOpartor.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNegationOpartor4677); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNegationOpartor"


    // $ANTLR start "ruleNegationOpartor"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2013:1: ruleNegationOpartor returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'not' ;
    public final AntlrDatatypeRuleToken ruleNegationOpartor() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2016:28: (kw= 'not' )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2018:2: kw= 'not'
            {
            kw=(Token)match(input,47,FOLLOW_47_in_ruleNegationOpartor4714); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getNegationOpartorAccess().getNotKeyword()); 
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNegationOpartor"


    // $ANTLR start "ruleIQPatternChangeType"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2031:1: ruleIQPatternChangeType returns [Enumerator current=null] : ( (enumLiteral_0= 'FOUND' ) | (enumLiteral_1= 'LOST' ) ) ;
    public final Enumerator ruleIQPatternChangeType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2033:28: ( ( (enumLiteral_0= 'FOUND' ) | (enumLiteral_1= 'LOST' ) ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2034:1: ( (enumLiteral_0= 'FOUND' ) | (enumLiteral_1= 'LOST' ) )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2034:1: ( (enumLiteral_0= 'FOUND' ) | (enumLiteral_1= 'LOST' ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==48) ) {
                alt21=1;
            }
            else if ( (LA21_0==49) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2034:2: (enumLiteral_0= 'FOUND' )
                    {
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2034:2: (enumLiteral_0= 'FOUND' )
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2034:4: enumLiteral_0= 'FOUND'
                    {
                    enumLiteral_0=(Token)match(input,48,FOLLOW_48_in_ruleIQPatternChangeType4767); 

                            current = grammarAccess.getIQPatternChangeTypeAccess().getFOUNDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getIQPatternChangeTypeAccess().getFOUNDEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2040:6: (enumLiteral_1= 'LOST' )
                    {
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2040:6: (enumLiteral_1= 'LOST' )
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2040:8: enumLiteral_1= 'LOST'
                    {
                    enumLiteral_1=(Token)match(input,49,FOLLOW_49_in_ruleIQPatternChangeType4784); 

                            current = grammarAccess.getIQPatternChangeTypeAccess().getLOSTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getIQPatternChangeTypeAccess().getLOSTEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIQPatternChangeType"


    // $ANTLR start "ruleContext"
    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2050:1: ruleContext returns [Enumerator current=null] : ( (enumLiteral_0= 'Chronicle' ) | (enumLiteral_1= 'Recent' ) | (enumLiteral_2= 'Unrestricted' ) ) ;
    public final Enumerator ruleContext() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2052:28: ( ( (enumLiteral_0= 'Chronicle' ) | (enumLiteral_1= 'Recent' ) | (enumLiteral_2= 'Unrestricted' ) ) )
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2053:1: ( (enumLiteral_0= 'Chronicle' ) | (enumLiteral_1= 'Recent' ) | (enumLiteral_2= 'Unrestricted' ) )
            {
            // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2053:1: ( (enumLiteral_0= 'Chronicle' ) | (enumLiteral_1= 'Recent' ) | (enumLiteral_2= 'Unrestricted' ) )
            int alt22=3;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt22=1;
                }
                break;
            case 51:
                {
                alt22=2;
                }
                break;
            case 52:
                {
                alt22=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2053:2: (enumLiteral_0= 'Chronicle' )
                    {
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2053:2: (enumLiteral_0= 'Chronicle' )
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2053:4: enumLiteral_0= 'Chronicle'
                    {
                    enumLiteral_0=(Token)match(input,50,FOLLOW_50_in_ruleContext4829); 

                            current = grammarAccess.getContextAccess().getChronicleEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getContextAccess().getChronicleEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2059:6: (enumLiteral_1= 'Recent' )
                    {
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2059:6: (enumLiteral_1= 'Recent' )
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2059:8: enumLiteral_1= 'Recent'
                    {
                    enumLiteral_1=(Token)match(input,51,FOLLOW_51_in_ruleContext4846); 

                            current = grammarAccess.getContextAccess().getRecentEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getContextAccess().getRecentEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2065:6: (enumLiteral_2= 'Unrestricted' )
                    {
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2065:6: (enumLiteral_2= 'Unrestricted' )
                    // ../hu.bme.mit.incquery.edl/src-gen/hu/bme/mit/incquery/vedl/parser/antlr/internal/InternalEdl.g:2065:8: enumLiteral_2= 'Unrestricted'
                    {
                    enumLiteral_2=(Token)match(input,52,FOLLOW_52_in_ruleContext4863); 

                            current = grammarAccess.getContextAccess().getUnrestrictedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getContextAccess().getUnrestrictedEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContext"

    // Delegated rules


    protected DFA8 dfa8 = new DFA8(this);
    protected DFA17 dfa17 = new DFA17(this);
    static final String DFA8_eotS =
        "\21\uffff";
    static final String DFA8_eofS =
        "\21\uffff";
    static final String DFA8_minS =
        "\1\23\3\35\2\uffff\1\62\2\4\5\36\3\23";
    static final String DFA8_maxS =
        "\1\41\3\35\2\uffff\1\64\2\4\5\36\3\41";
    static final String DFA8_acceptS =
        "\4\uffff\1\1\1\2\13\uffff";
    static final String DFA8_specialS =
        "\21\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\4\5\uffff\1\4\2\uffff\1\5\2\uffff\1\1\1\2\1\3",
            "\1\6",
            "\1\7",
            "\1\10",
            "",
            "",
            "\1\11\1\12\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\17",
            "\1\20",
            "\1\4\10\uffff\1\5\2\uffff\1\1\1\2\1\3",
            "\1\4\10\uffff\1\5\2\uffff\1\1\1\2\1\3",
            "\1\4\10\uffff\1\5\2\uffff\1\1\1\2\1\3"
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "503:1: (this_AbstractAtomicEvent_0= ruleAbstractAtomicEvent | this_ComplexEvent_1= ruleComplexEvent )";
        }
    }
    static final String DFA17_eotS =
        "\25\uffff";
    static final String DFA17_eofS =
        "\25\uffff";
    static final String DFA17_minS =
        "\1\35\2\4\2\14\4\4\1\43\1\14\1\43\1\14\1\4\2\uffff\1\4\2\uffff"+
        "\2\36";
    static final String DFA17_maxS =
        "\1\45\2\4\2\43\4\4\1\43\1\44\1\43\1\44\1\4\2\uffff\1\4\2\uffff"+
        "\2\44";
    static final String DFA17_acceptS =
        "\16\uffff\1\2\1\1\1\uffff\1\4\1\3\2\uffff";
    static final String DFA17_specialS =
        "\25\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\1\7\uffff\1\2",
            "\1\3",
            "\1\4",
            "\1\5\26\uffff\1\6",
            "\1\7\26\uffff\1\10",
            "\1\11",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\6",
            "\1\15\21\uffff\1\17\5\uffff\1\16",
            "\1\10",
            "\1\20\21\uffff\1\22\5\uffff\1\21",
            "\1\23",
            "",
            "",
            "\1\24",
            "",
            "",
            "\1\17\5\uffff\1\16",
            "\1\22\5\uffff\1\21"
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "1446:1: (this_OpenOpen_0= ruleOpenOpen | this_OpenClosed_1= ruleOpenClosed | this_ClosedClosed_2= ruleClosedClosed | this_ClosedOpen_3= ruleClosedOpen )";
        }
    }
 

    public static final BitSet FOLLOW_rulePackageDeclaration_in_entryRulePackageDeclaration75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageDeclaration85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rulePackageDeclaration122 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rulePackageDeclaration143 = new BitSet(new long[]{0x000000038001C000L});
    public static final BitSet FOLLOW_ruleUsage_in_rulePackageDeclaration164 = new BitSet(new long[]{0x000000038001C000L});
    public static final BitSet FOLLOW_ruleModel_in_rulePackageDeclaration186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_entryRuleDOUBLE223 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDOUBLE234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDOUBLE274 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleDOUBLE293 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDOUBLE308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName356 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName407 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleQualifiedName426 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName441 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard489 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard547 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleQualifiedNameWithWildcard566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUsage_in_entryRuleUsage608 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUsage618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIQUsage_in_ruleUsage665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventSourceUsage_in_ruleUsage692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIQUsage_in_entryRuleIQUsage727 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIQUsage737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleIQUsage774 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_ruleIQUsage795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventSourceUsage_in_entryRuleEventSourceUsage831 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventSourceUsage841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleEventSourceUsage878 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_ruleEventSourceUsage899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel941 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotations_in_ruleModel1001 = new BitSet(new long[]{0x0000000380010000L});
    public static final BitSet FOLLOW_16_in_ruleModel1014 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModel1031 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleModel1048 = new BitSet(new long[]{0x00000003920C0000L});
    public static final BitSet FOLLOW_ruleEvent_in_ruleModel1069 = new BitSet(new long[]{0x00000003920C0000L});
    public static final BitSet FOLLOW_18_in_ruleModel1082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_entryRuleEvent1122 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEvent1132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractAtomicEvent_in_ruleEvent1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexEvent_in_ruleEvent1206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractAtomicEvent_in_entryRuleAbstractAtomicEvent1241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractAtomicEvent1251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomicEvent_in_ruleAbstractAtomicEvent1298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIQPatternEvent_in_ruleAbstractAtomicEvent1325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomicEvent_in_entryRuleAtomicEvent1360 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtomicEvent1370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotations_in_ruleAtomicEvent1416 = new BitSet(new long[]{0x0000000380080000L});
    public static final BitSet FOLLOW_19_in_ruleAtomicEvent1429 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicEvent1446 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleAtomicEvent1463 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleAtomicEvent1475 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleAtomicEvent1487 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleAtomicEvent1499 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicEvent1519 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleAtomicEvent1531 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleAtomicEvent1543 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAtomicEvent1560 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleAtomicEvent1577 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleAtomicEvent1589 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleParameterFilter_in_ruleAtomicEvent1610 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_18_in_ruleAtomicEvent1623 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleAtomicEvent1635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIQPatternEvent_in_entryRuleIQPatternEvent1671 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIQPatternEvent1681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleIQPatternEvent1718 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIQPatternEvent1735 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleIQPatternEvent1752 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleIQPatternEvent1764 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleIQPatternEvent1776 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleIQPatternEvent1788 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleIQPattern_in_ruleIQPatternEvent1809 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleIQPatternEvent1821 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleIQPatternEvent1833 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_ruleIQPatternChangeType_in_ruleIQPatternEvent1854 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleIQPatternEvent1866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexEvent_in_entryRuleComplexEvent1902 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComplexEvent1912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotations_in_ruleComplexEvent1958 = new BitSet(new long[]{0x0000000390000000L});
    public static final BitSet FOLLOW_28_in_ruleComplexEvent1971 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleComplexEvent1988 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_ruleCEParamlist_in_ruleComplexEvent2014 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleComplexEvent2026 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleComplexEvent2038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCEParamlist_in_entryRuleCEParamlist2074 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCEParamlist2084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleCEParamlist2130 = new BitSet(new long[]{0x0000000040000020L});
    public static final BitSet FOLLOW_ruleParamWithType_in_ruleCEParamlist2151 = new BitSet(new long[]{0x0000000040000020L});
    public static final BitSet FOLLOW_30_in_ruleCEParamlist2164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamWithType_in_entryRuleParamWithType2200 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParamWithType2210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParamWithType2252 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleParamWithType2269 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParamWithType2289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterFilter_in_entryRuleParameterFilter2325 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterFilter2335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParameterFilter2377 = new BitSet(new long[]{0x0000FFC400000000L});
    public static final BitSet FOLLOW_ruleParameterFilterRule_in_ruleParameterFilter2403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIQPattern_in_entryRuleIQPattern2439 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIQPattern2449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIQPattern2490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotations_in_entryRuleAnnotations2530 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotations2540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextAnnotation_in_ruleAnnotations2587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSamplingAnnotation_in_ruleAnnotations2614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePriorityAnnotation_in_ruleAnnotations2641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextAnnotation_in_entryRuleContextAnnotation2676 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContextAnnotation2686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleContextAnnotation2723 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleContextAnnotation2735 = new BitSet(new long[]{0x001C000000000000L});
    public static final BitSet FOLLOW_ruleContext_in_ruleContextAnnotation2756 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleContextAnnotation2768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSamplingAnnotation_in_entryRuleSamplingAnnotation2804 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSamplingAnnotation2814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleSamplingAnnotation2851 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleSamplingAnnotation2863 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSamplingAnnotation2880 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleSamplingAnnotation2897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePriorityAnnotation_in_entryRulePriorityAnnotation2933 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePriorityAnnotation2943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rulePriorityAnnotation2980 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_rulePriorityAnnotation2992 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_rulePriorityAnnotation3009 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_rulePriorityAnnotation3026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterFilterRule_in_entryRuleParameterFilterRule3062 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterFilterRule3072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeFilter_in_ruleParameterFilterRule3119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericFilter_in_ruleParameterFilterRule3146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralFilter_in_ruleParameterFilterRule3173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeFilter_in_entryRuleRangeFilter3208 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRangeFilter3218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegationOpartor_in_ruleRangeFilter3264 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleRangeFilter3277 = new BitSet(new long[]{0x0000002020000000L});
    public static final BitSet FOLLOW_ruleRange_in_ruleRangeFilter3298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRange_in_entryRuleRange3334 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRange3344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpenOpen_in_ruleRange3391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpenClosed_in_ruleRange3418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedClosed_in_ruleRange3445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedOpen_in_ruleRange3472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpenOpen_in_entryRuleOpenOpen3507 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpenOpen3517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleOpenOpen3554 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_ruleOpenOpen3575 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleOpenOpen3587 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_ruleOpenOpen3608 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleOpenOpen3620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpenClosed_in_entryRuleOpenClosed3656 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpenClosed3666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleOpenClosed3703 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_ruleOpenClosed3724 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleOpenClosed3736 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_ruleOpenClosed3757 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleOpenClosed3769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedClosed_in_entryRuleClosedClosed3805 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClosedClosed3815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleClosedClosed3852 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_ruleClosedClosed3873 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleClosedClosed3885 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_ruleClosedClosed3906 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleClosedClosed3918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedOpen_in_entryRuleClosedOpen3954 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClosedOpen3964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleClosedOpen4001 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_ruleClosedOpen4022 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleClosedOpen4034 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_ruleClosedOpen4055 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleClosedOpen4067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericFilter_in_entryRuleNumericFilter4103 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericFilter4113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericOperator_in_ruleNumericFilter4159 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_ruleNumericFilter4180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericOperator_in_entryRuleNumericOperator4217 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericOperator4228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleNumericOperator4266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleNumericOperator4285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleNumericOperator4304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleNumericOperator4323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleNumericOperator4342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleNumericOperator4361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralFilter_in_entryRuleLiteralFilter4401 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralFilter4411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegationOpartor_in_ruleLiteralFilter4457 = new BitSet(new long[]{0x0000FFC400000000L});
    public static final BitSet FOLLOW_ruleLiteralOperator_in_ruleLiteralFilter4479 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLiteralFilter4496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralOperator_in_entryRuleLiteralOperator4538 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralOperator4549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleLiteralOperator4587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleLiteralOperator4606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleLiteralOperator4625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegationOpartor_in_entryRuleNegationOpartor4666 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNegationOpartor4677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleNegationOpartor4714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleIQPatternChangeType4767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleIQPatternChangeType4784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleContext4829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleContext4846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleContext4863 = new BitSet(new long[]{0x0000000000000002L});

}