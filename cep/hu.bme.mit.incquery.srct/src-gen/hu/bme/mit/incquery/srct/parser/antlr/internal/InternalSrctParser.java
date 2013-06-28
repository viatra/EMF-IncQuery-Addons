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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSrctParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'.'", "'source'", "'{'", "'register'", "'}'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalSrctParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSrctParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSrctParser.tokenNames; }
    public String getGrammarFileName() { return "../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g"; }



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



    // $ANTLR start "entryRulePackageDeclaration"
    // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:67:1: entryRulePackageDeclaration returns [EObject current=null] : iv_rulePackageDeclaration= rulePackageDeclaration EOF ;
    public final EObject entryRulePackageDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDeclaration = null;


        try {
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:68:2: (iv_rulePackageDeclaration= rulePackageDeclaration EOF )
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:69:2: iv_rulePackageDeclaration= rulePackageDeclaration EOF
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
    // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:76:1: rulePackageDeclaration returns [EObject current=null] : (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_sourceModel_2_0= ruleSourceModel ) ) ) ;
    public final EObject rulePackageDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_sourceModel_2_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:79:28: ( (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_sourceModel_2_0= ruleSourceModel ) ) ) )
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:80:1: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_sourceModel_2_0= ruleSourceModel ) ) )
            {
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:80:1: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_sourceModel_2_0= ruleSourceModel ) ) )
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:80:3: otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_sourceModel_2_0= ruleSourceModel ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_rulePackageDeclaration122); 

                	newLeafNode(otherlv_0, grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0());
                
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:84:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:85:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:85:1: (lv_name_1_0= ruleQualifiedName )
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:86:3: lv_name_1_0= ruleQualifiedName
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

            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:102:2: ( (lv_sourceModel_2_0= ruleSourceModel ) )
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:103:1: (lv_sourceModel_2_0= ruleSourceModel )
            {
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:103:1: (lv_sourceModel_2_0= ruleSourceModel )
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:104:3: lv_sourceModel_2_0= ruleSourceModel
            {
             
            	        newCompositeNode(grammarAccess.getPackageDeclarationAccess().getSourceModelSourceModelParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleSourceModel_in_rulePackageDeclaration164);
            lv_sourceModel_2_0=ruleSourceModel();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPackageDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"sourceModel",
                    		lv_sourceModel_2_0, 
                    		"SourceModel");
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


    // $ANTLR start "entryRuleQualifiedName"
    // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:128:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:129:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:130:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName201);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName212); 

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
    // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:137:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:140:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:141:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:141:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:141:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName252); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:148:1: (kw= '.' this_ID_2= RULE_ID )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:149:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,12,FOLLOW_12_in_ruleQualifiedName271); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName286); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop1;
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


    // $ANTLR start "entryRuleSourceModel"
    // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:169:1: entryRuleSourceModel returns [EObject current=null] : iv_ruleSourceModel= ruleSourceModel EOF ;
    public final EObject entryRuleSourceModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSourceModel = null;


        try {
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:170:2: (iv_ruleSourceModel= ruleSourceModel EOF )
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:171:2: iv_ruleSourceModel= ruleSourceModel EOF
            {
             newCompositeNode(grammarAccess.getSourceModelRule()); 
            pushFollow(FOLLOW_ruleSourceModel_in_entryRuleSourceModel333);
            iv_ruleSourceModel=ruleSourceModel();

            state._fsp--;

             current =iv_ruleSourceModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSourceModel343); 

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
    // $ANTLR end "entryRuleSourceModel"


    // $ANTLR start "ruleSourceModel"
    // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:178:1: ruleSourceModel returns [EObject current=null] : ( () ( (lv_sources_1_0= ruleSource ) )* ) ;
    public final EObject ruleSourceModel() throws RecognitionException {
        EObject current = null;

        EObject lv_sources_1_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:181:28: ( ( () ( (lv_sources_1_0= ruleSource ) )* ) )
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:182:1: ( () ( (lv_sources_1_0= ruleSource ) )* )
            {
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:182:1: ( () ( (lv_sources_1_0= ruleSource ) )* )
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:182:2: () ( (lv_sources_1_0= ruleSource ) )*
            {
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:182:2: ()
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:183:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSourceModelAccess().getSourceModelAction_0(),
                        current);
                

            }

            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:188:2: ( (lv_sources_1_0= ruleSource ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:189:1: (lv_sources_1_0= ruleSource )
            	    {
            	    // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:189:1: (lv_sources_1_0= ruleSource )
            	    // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:190:3: lv_sources_1_0= ruleSource
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSourceModelAccess().getSourcesSourceParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSource_in_ruleSourceModel398);
            	    lv_sources_1_0=ruleSource();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSourceModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"sources",
            	            		lv_sources_1_0, 
            	            		"Source");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "ruleSourceModel"


    // $ANTLR start "entryRuleSource"
    // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:214:1: entryRuleSource returns [EObject current=null] : iv_ruleSource= ruleSource EOF ;
    public final EObject entryRuleSource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSource = null;


        try {
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:215:2: (iv_ruleSource= ruleSource EOF )
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:216:2: iv_ruleSource= ruleSource EOF
            {
             newCompositeNode(grammarAccess.getSourceRule()); 
            pushFollow(FOLLOW_ruleSource_in_entryRuleSource435);
            iv_ruleSource=ruleSource();

            state._fsp--;

             current =iv_ruleSource; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSource445); 

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
    // $ANTLR end "entryRuleSource"


    // $ANTLR start "ruleSource"
    // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:223:1: ruleSource returns [EObject current=null] : (otherlv_0= 'source' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'register' ( (lv_adapter_4_0= ruleAdapter ) ) )+ otherlv_5= '}' ) ;
    public final EObject ruleSource() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_adapter_4_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:226:28: ( (otherlv_0= 'source' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'register' ( (lv_adapter_4_0= ruleAdapter ) ) )+ otherlv_5= '}' ) )
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:227:1: (otherlv_0= 'source' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'register' ( (lv_adapter_4_0= ruleAdapter ) ) )+ otherlv_5= '}' )
            {
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:227:1: (otherlv_0= 'source' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'register' ( (lv_adapter_4_0= ruleAdapter ) ) )+ otherlv_5= '}' )
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:227:3: otherlv_0= 'source' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'register' ( (lv_adapter_4_0= ruleAdapter ) ) )+ otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleSource482); 

                	newLeafNode(otherlv_0, grammarAccess.getSourceAccess().getSourceKeyword_0());
                
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:231:1: ( (lv_name_1_0= RULE_ID ) )
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:232:1: (lv_name_1_0= RULE_ID )
            {
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:232:1: (lv_name_1_0= RULE_ID )
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:233:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSource499); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSourceAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSourceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleSource516); 

                	newLeafNode(otherlv_2, grammarAccess.getSourceAccess().getLeftCurlyBracketKeyword_2());
                
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:253:1: (otherlv_3= 'register' ( (lv_adapter_4_0= ruleAdapter ) ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:253:3: otherlv_3= 'register' ( (lv_adapter_4_0= ruleAdapter ) )
            	    {
            	    otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleSource529); 

            	        	newLeafNode(otherlv_3, grammarAccess.getSourceAccess().getRegisterKeyword_3_0());
            	        
            	    // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:257:1: ( (lv_adapter_4_0= ruleAdapter ) )
            	    // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:258:1: (lv_adapter_4_0= ruleAdapter )
            	    {
            	    // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:258:1: (lv_adapter_4_0= ruleAdapter )
            	    // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:259:3: lv_adapter_4_0= ruleAdapter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSourceAccess().getAdapterAdapterParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAdapter_in_ruleSource550);
            	    lv_adapter_4_0=ruleAdapter();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSourceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"adapter",
            	            		lv_adapter_4_0, 
            	            		"Adapter");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleSource564); 

                	newLeafNode(otherlv_5, grammarAccess.getSourceAccess().getRightCurlyBracketKeyword_4());
                

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
    // $ANTLR end "ruleSource"


    // $ANTLR start "entryRuleAdapter"
    // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:287:1: entryRuleAdapter returns [EObject current=null] : iv_ruleAdapter= ruleAdapter EOF ;
    public final EObject entryRuleAdapter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdapter = null;


        try {
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:288:2: (iv_ruleAdapter= ruleAdapter EOF )
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:289:2: iv_ruleAdapter= ruleAdapter EOF
            {
             newCompositeNode(grammarAccess.getAdapterRule()); 
            pushFollow(FOLLOW_ruleAdapter_in_entryRuleAdapter600);
            iv_ruleAdapter=ruleAdapter();

            state._fsp--;

             current =iv_ruleAdapter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdapter610); 

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
    // $ANTLR end "entryRuleAdapter"


    // $ANTLR start "ruleAdapter"
    // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:296:1: ruleAdapter returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleAdapter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:299:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:300:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:300:1: ( (lv_name_0_0= RULE_ID ) )
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:301:1: (lv_name_0_0= RULE_ID )
            {
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:301:1: (lv_name_0_0= RULE_ID )
            // ../hu.bme.mit.incquery.srct/src-gen/hu/bme/mit/incquery/srct/parser/antlr/internal/InternalSrct.g:302:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAdapter651); 

            			newLeafNode(lv_name_0_0, grammarAccess.getAdapterAccess().getNameIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAdapterRule());
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
    // $ANTLR end "ruleAdapter"

    // Delegated rules


 

    public static final BitSet FOLLOW_rulePackageDeclaration_in_entryRulePackageDeclaration75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageDeclaration85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rulePackageDeclaration122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rulePackageDeclaration143 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleSourceModel_in_rulePackageDeclaration164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName201 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName252 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleQualifiedName271 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName286 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleSourceModel_in_entryRuleSourceModel333 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSourceModel343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSource_in_ruleSourceModel398 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ruleSource_in_entryRuleSource435 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSource445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleSource482 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSource499 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSource516 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSource529 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAdapter_in_ruleSource550 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_16_in_ruleSource564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdapter_in_entryRuleAdapter600 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdapter610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAdapter651 = new BitSet(new long[]{0x0000000000000002L});

}