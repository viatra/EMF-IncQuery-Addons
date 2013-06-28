package hu.bme.mit.incquery.srct.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import hu.bme.mit.incquery.srct.services.SrctGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSrctParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'.'", "'source'", "'{'", "'}'", "'register'"
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
    public String getGrammarFileName() { return "../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g"; }


     
     	private SrctGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(SrctGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRulePackageDeclaration"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:60:1: entryRulePackageDeclaration : rulePackageDeclaration EOF ;
    public final void entryRulePackageDeclaration() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:61:1: ( rulePackageDeclaration EOF )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:62:1: rulePackageDeclaration EOF
            {
             before(grammarAccess.getPackageDeclarationRule()); 
            pushFollow(FOLLOW_rulePackageDeclaration_in_entryRulePackageDeclaration61);
            rulePackageDeclaration();

            state._fsp--;

             after(grammarAccess.getPackageDeclarationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePackageDeclaration68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePackageDeclaration"


    // $ANTLR start "rulePackageDeclaration"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:69:1: rulePackageDeclaration : ( ( rule__PackageDeclaration__Group__0 ) ) ;
    public final void rulePackageDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:73:2: ( ( ( rule__PackageDeclaration__Group__0 ) ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:74:1: ( ( rule__PackageDeclaration__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:74:1: ( ( rule__PackageDeclaration__Group__0 ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:75:1: ( rule__PackageDeclaration__Group__0 )
            {
             before(grammarAccess.getPackageDeclarationAccess().getGroup()); 
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:76:1: ( rule__PackageDeclaration__Group__0 )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:76:2: rule__PackageDeclaration__Group__0
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__Group__0_in_rulePackageDeclaration94);
            rule__PackageDeclaration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPackageDeclarationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePackageDeclaration"


    // $ANTLR start "entryRuleQualifiedName"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:88:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:89:1: ( ruleQualifiedName EOF )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:90:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName121);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName128); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:97:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:101:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:102:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:102:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:103:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:104:1: ( rule__QualifiedName__Group__0 )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:104:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName154);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleSourceModel"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:116:1: entryRuleSourceModel : ruleSourceModel EOF ;
    public final void entryRuleSourceModel() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:117:1: ( ruleSourceModel EOF )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:118:1: ruleSourceModel EOF
            {
             before(grammarAccess.getSourceModelRule()); 
            pushFollow(FOLLOW_ruleSourceModel_in_entryRuleSourceModel181);
            ruleSourceModel();

            state._fsp--;

             after(grammarAccess.getSourceModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSourceModel188); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSourceModel"


    // $ANTLR start "ruleSourceModel"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:125:1: ruleSourceModel : ( ( rule__SourceModel__Group__0 ) ) ;
    public final void ruleSourceModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:129:2: ( ( ( rule__SourceModel__Group__0 ) ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:130:1: ( ( rule__SourceModel__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:130:1: ( ( rule__SourceModel__Group__0 ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:131:1: ( rule__SourceModel__Group__0 )
            {
             before(grammarAccess.getSourceModelAccess().getGroup()); 
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:132:1: ( rule__SourceModel__Group__0 )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:132:2: rule__SourceModel__Group__0
            {
            pushFollow(FOLLOW_rule__SourceModel__Group__0_in_ruleSourceModel214);
            rule__SourceModel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSourceModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSourceModel"


    // $ANTLR start "entryRuleSource"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:144:1: entryRuleSource : ruleSource EOF ;
    public final void entryRuleSource() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:145:1: ( ruleSource EOF )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:146:1: ruleSource EOF
            {
             before(grammarAccess.getSourceRule()); 
            pushFollow(FOLLOW_ruleSource_in_entryRuleSource241);
            ruleSource();

            state._fsp--;

             after(grammarAccess.getSourceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSource248); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSource"


    // $ANTLR start "ruleSource"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:153:1: ruleSource : ( ( rule__Source__Group__0 ) ) ;
    public final void ruleSource() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:157:2: ( ( ( rule__Source__Group__0 ) ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:158:1: ( ( rule__Source__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:158:1: ( ( rule__Source__Group__0 ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:159:1: ( rule__Source__Group__0 )
            {
             before(grammarAccess.getSourceAccess().getGroup()); 
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:160:1: ( rule__Source__Group__0 )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:160:2: rule__Source__Group__0
            {
            pushFollow(FOLLOW_rule__Source__Group__0_in_ruleSource274);
            rule__Source__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSourceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSource"


    // $ANTLR start "entryRuleAdapter"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:172:1: entryRuleAdapter : ruleAdapter EOF ;
    public final void entryRuleAdapter() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:173:1: ( ruleAdapter EOF )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:174:1: ruleAdapter EOF
            {
             before(grammarAccess.getAdapterRule()); 
            pushFollow(FOLLOW_ruleAdapter_in_entryRuleAdapter301);
            ruleAdapter();

            state._fsp--;

             after(grammarAccess.getAdapterRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdapter308); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAdapter"


    // $ANTLR start "ruleAdapter"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:181:1: ruleAdapter : ( ( rule__Adapter__NameAssignment ) ) ;
    public final void ruleAdapter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:185:2: ( ( ( rule__Adapter__NameAssignment ) ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:186:1: ( ( rule__Adapter__NameAssignment ) )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:186:1: ( ( rule__Adapter__NameAssignment ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:187:1: ( rule__Adapter__NameAssignment )
            {
             before(grammarAccess.getAdapterAccess().getNameAssignment()); 
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:188:1: ( rule__Adapter__NameAssignment )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:188:2: rule__Adapter__NameAssignment
            {
            pushFollow(FOLLOW_rule__Adapter__NameAssignment_in_ruleAdapter334);
            rule__Adapter__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getAdapterAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAdapter"


    // $ANTLR start "rule__PackageDeclaration__Group__0"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:202:1: rule__PackageDeclaration__Group__0 : rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1 ;
    public final void rule__PackageDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:206:1: ( rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1 )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:207:2: rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__Group__0__Impl_in_rule__PackageDeclaration__Group__0368);
            rule__PackageDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDeclaration__Group__1_in_rule__PackageDeclaration__Group__0371);
            rule__PackageDeclaration__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__0"


    // $ANTLR start "rule__PackageDeclaration__Group__0__Impl"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:214:1: rule__PackageDeclaration__Group__0__Impl : ( 'package' ) ;
    public final void rule__PackageDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:218:1: ( ( 'package' ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:219:1: ( 'package' )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:219:1: ( 'package' )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:220:1: 'package'
            {
             before(grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0()); 
            match(input,11,FOLLOW_11_in_rule__PackageDeclaration__Group__0__Impl399); 
             after(grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__0__Impl"


    // $ANTLR start "rule__PackageDeclaration__Group__1"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:233:1: rule__PackageDeclaration__Group__1 : rule__PackageDeclaration__Group__1__Impl rule__PackageDeclaration__Group__2 ;
    public final void rule__PackageDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:237:1: ( rule__PackageDeclaration__Group__1__Impl rule__PackageDeclaration__Group__2 )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:238:2: rule__PackageDeclaration__Group__1__Impl rule__PackageDeclaration__Group__2
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__Group__1__Impl_in_rule__PackageDeclaration__Group__1430);
            rule__PackageDeclaration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDeclaration__Group__2_in_rule__PackageDeclaration__Group__1433);
            rule__PackageDeclaration__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__1"


    // $ANTLR start "rule__PackageDeclaration__Group__1__Impl"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:245:1: rule__PackageDeclaration__Group__1__Impl : ( ( rule__PackageDeclaration__NameAssignment_1 ) ) ;
    public final void rule__PackageDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:249:1: ( ( ( rule__PackageDeclaration__NameAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:250:1: ( ( rule__PackageDeclaration__NameAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:250:1: ( ( rule__PackageDeclaration__NameAssignment_1 ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:251:1: ( rule__PackageDeclaration__NameAssignment_1 )
            {
             before(grammarAccess.getPackageDeclarationAccess().getNameAssignment_1()); 
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:252:1: ( rule__PackageDeclaration__NameAssignment_1 )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:252:2: rule__PackageDeclaration__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__NameAssignment_1_in_rule__PackageDeclaration__Group__1__Impl460);
            rule__PackageDeclaration__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPackageDeclarationAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__1__Impl"


    // $ANTLR start "rule__PackageDeclaration__Group__2"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:262:1: rule__PackageDeclaration__Group__2 : rule__PackageDeclaration__Group__2__Impl ;
    public final void rule__PackageDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:266:1: ( rule__PackageDeclaration__Group__2__Impl )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:267:2: rule__PackageDeclaration__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__Group__2__Impl_in_rule__PackageDeclaration__Group__2490);
            rule__PackageDeclaration__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__2"


    // $ANTLR start "rule__PackageDeclaration__Group__2__Impl"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:273:1: rule__PackageDeclaration__Group__2__Impl : ( ( rule__PackageDeclaration__SourceModelAssignment_2 ) ) ;
    public final void rule__PackageDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:277:1: ( ( ( rule__PackageDeclaration__SourceModelAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:278:1: ( ( rule__PackageDeclaration__SourceModelAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:278:1: ( ( rule__PackageDeclaration__SourceModelAssignment_2 ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:279:1: ( rule__PackageDeclaration__SourceModelAssignment_2 )
            {
             before(grammarAccess.getPackageDeclarationAccess().getSourceModelAssignment_2()); 
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:280:1: ( rule__PackageDeclaration__SourceModelAssignment_2 )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:280:2: rule__PackageDeclaration__SourceModelAssignment_2
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__SourceModelAssignment_2_in_rule__PackageDeclaration__Group__2__Impl517);
            rule__PackageDeclaration__SourceModelAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPackageDeclarationAccess().getSourceModelAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__2__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:296:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:300:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:301:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__0553);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__0556);
            rule__QualifiedName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:308:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:312:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:313:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:313:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:314:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl583); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:325:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:329:1: ( rule__QualifiedName__Group__1__Impl )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:330:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__1612);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:336:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:340:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:341:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:341:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:342:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:343:1: ( rule__QualifiedName__Group_1__0 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:343:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl639);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:357:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:361:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:362:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__0674);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__0677);
            rule__QualifiedName__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:369:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:373:1: ( ( '.' ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:374:1: ( '.' )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:374:1: ( '.' )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:375:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,12,FOLLOW_12_in_rule__QualifiedName__Group_1__0__Impl705); 
             after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:388:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:392:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:393:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__1736);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:399:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:403:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:404:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:404:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:405:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl763); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__SourceModel__Group__0"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:420:1: rule__SourceModel__Group__0 : rule__SourceModel__Group__0__Impl rule__SourceModel__Group__1 ;
    public final void rule__SourceModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:424:1: ( rule__SourceModel__Group__0__Impl rule__SourceModel__Group__1 )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:425:2: rule__SourceModel__Group__0__Impl rule__SourceModel__Group__1
            {
            pushFollow(FOLLOW_rule__SourceModel__Group__0__Impl_in_rule__SourceModel__Group__0796);
            rule__SourceModel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SourceModel__Group__1_in_rule__SourceModel__Group__0799);
            rule__SourceModel__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SourceModel__Group__0"


    // $ANTLR start "rule__SourceModel__Group__0__Impl"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:432:1: rule__SourceModel__Group__0__Impl : ( () ) ;
    public final void rule__SourceModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:436:1: ( ( () ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:437:1: ( () )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:437:1: ( () )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:438:1: ()
            {
             before(grammarAccess.getSourceModelAccess().getSourceModelAction_0()); 
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:439:1: ()
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:441:1: 
            {
            }

             after(grammarAccess.getSourceModelAccess().getSourceModelAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SourceModel__Group__0__Impl"


    // $ANTLR start "rule__SourceModel__Group__1"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:451:1: rule__SourceModel__Group__1 : rule__SourceModel__Group__1__Impl ;
    public final void rule__SourceModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:455:1: ( rule__SourceModel__Group__1__Impl )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:456:2: rule__SourceModel__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SourceModel__Group__1__Impl_in_rule__SourceModel__Group__1857);
            rule__SourceModel__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SourceModel__Group__1"


    // $ANTLR start "rule__SourceModel__Group__1__Impl"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:462:1: rule__SourceModel__Group__1__Impl : ( ( rule__SourceModel__SourcesAssignment_1 )* ) ;
    public final void rule__SourceModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:466:1: ( ( ( rule__SourceModel__SourcesAssignment_1 )* ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:467:1: ( ( rule__SourceModel__SourcesAssignment_1 )* )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:467:1: ( ( rule__SourceModel__SourcesAssignment_1 )* )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:468:1: ( rule__SourceModel__SourcesAssignment_1 )*
            {
             before(grammarAccess.getSourceModelAccess().getSourcesAssignment_1()); 
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:469:1: ( rule__SourceModel__SourcesAssignment_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:469:2: rule__SourceModel__SourcesAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__SourceModel__SourcesAssignment_1_in_rule__SourceModel__Group__1__Impl884);
            	    rule__SourceModel__SourcesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getSourceModelAccess().getSourcesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SourceModel__Group__1__Impl"


    // $ANTLR start "rule__Source__Group__0"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:483:1: rule__Source__Group__0 : rule__Source__Group__0__Impl rule__Source__Group__1 ;
    public final void rule__Source__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:487:1: ( rule__Source__Group__0__Impl rule__Source__Group__1 )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:488:2: rule__Source__Group__0__Impl rule__Source__Group__1
            {
            pushFollow(FOLLOW_rule__Source__Group__0__Impl_in_rule__Source__Group__0919);
            rule__Source__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Source__Group__1_in_rule__Source__Group__0922);
            rule__Source__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Source__Group__0"


    // $ANTLR start "rule__Source__Group__0__Impl"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:495:1: rule__Source__Group__0__Impl : ( 'source' ) ;
    public final void rule__Source__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:499:1: ( ( 'source' ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:500:1: ( 'source' )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:500:1: ( 'source' )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:501:1: 'source'
            {
             before(grammarAccess.getSourceAccess().getSourceKeyword_0()); 
            match(input,13,FOLLOW_13_in_rule__Source__Group__0__Impl950); 
             after(grammarAccess.getSourceAccess().getSourceKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Source__Group__0__Impl"


    // $ANTLR start "rule__Source__Group__1"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:514:1: rule__Source__Group__1 : rule__Source__Group__1__Impl rule__Source__Group__2 ;
    public final void rule__Source__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:518:1: ( rule__Source__Group__1__Impl rule__Source__Group__2 )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:519:2: rule__Source__Group__1__Impl rule__Source__Group__2
            {
            pushFollow(FOLLOW_rule__Source__Group__1__Impl_in_rule__Source__Group__1981);
            rule__Source__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Source__Group__2_in_rule__Source__Group__1984);
            rule__Source__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Source__Group__1"


    // $ANTLR start "rule__Source__Group__1__Impl"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:526:1: rule__Source__Group__1__Impl : ( ( rule__Source__NameAssignment_1 ) ) ;
    public final void rule__Source__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:530:1: ( ( ( rule__Source__NameAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:531:1: ( ( rule__Source__NameAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:531:1: ( ( rule__Source__NameAssignment_1 ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:532:1: ( rule__Source__NameAssignment_1 )
            {
             before(grammarAccess.getSourceAccess().getNameAssignment_1()); 
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:533:1: ( rule__Source__NameAssignment_1 )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:533:2: rule__Source__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Source__NameAssignment_1_in_rule__Source__Group__1__Impl1011);
            rule__Source__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSourceAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Source__Group__1__Impl"


    // $ANTLR start "rule__Source__Group__2"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:543:1: rule__Source__Group__2 : rule__Source__Group__2__Impl rule__Source__Group__3 ;
    public final void rule__Source__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:547:1: ( rule__Source__Group__2__Impl rule__Source__Group__3 )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:548:2: rule__Source__Group__2__Impl rule__Source__Group__3
            {
            pushFollow(FOLLOW_rule__Source__Group__2__Impl_in_rule__Source__Group__21041);
            rule__Source__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Source__Group__3_in_rule__Source__Group__21044);
            rule__Source__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Source__Group__2"


    // $ANTLR start "rule__Source__Group__2__Impl"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:555:1: rule__Source__Group__2__Impl : ( '{' ) ;
    public final void rule__Source__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:559:1: ( ( '{' ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:560:1: ( '{' )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:560:1: ( '{' )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:561:1: '{'
            {
             before(grammarAccess.getSourceAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,14,FOLLOW_14_in_rule__Source__Group__2__Impl1072); 
             after(grammarAccess.getSourceAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Source__Group__2__Impl"


    // $ANTLR start "rule__Source__Group__3"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:574:1: rule__Source__Group__3 : rule__Source__Group__3__Impl rule__Source__Group__4 ;
    public final void rule__Source__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:578:1: ( rule__Source__Group__3__Impl rule__Source__Group__4 )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:579:2: rule__Source__Group__3__Impl rule__Source__Group__4
            {
            pushFollow(FOLLOW_rule__Source__Group__3__Impl_in_rule__Source__Group__31103);
            rule__Source__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Source__Group__4_in_rule__Source__Group__31106);
            rule__Source__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Source__Group__3"


    // $ANTLR start "rule__Source__Group__3__Impl"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:586:1: rule__Source__Group__3__Impl : ( ( ( rule__Source__Group_3__0 ) ) ( ( rule__Source__Group_3__0 )* ) ) ;
    public final void rule__Source__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:590:1: ( ( ( ( rule__Source__Group_3__0 ) ) ( ( rule__Source__Group_3__0 )* ) ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:591:1: ( ( ( rule__Source__Group_3__0 ) ) ( ( rule__Source__Group_3__0 )* ) )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:591:1: ( ( ( rule__Source__Group_3__0 ) ) ( ( rule__Source__Group_3__0 )* ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:592:1: ( ( rule__Source__Group_3__0 ) ) ( ( rule__Source__Group_3__0 )* )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:592:1: ( ( rule__Source__Group_3__0 ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:593:1: ( rule__Source__Group_3__0 )
            {
             before(grammarAccess.getSourceAccess().getGroup_3()); 
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:594:1: ( rule__Source__Group_3__0 )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:594:2: rule__Source__Group_3__0
            {
            pushFollow(FOLLOW_rule__Source__Group_3__0_in_rule__Source__Group__3__Impl1135);
            rule__Source__Group_3__0();

            state._fsp--;


            }

             after(grammarAccess.getSourceAccess().getGroup_3()); 

            }

            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:597:1: ( ( rule__Source__Group_3__0 )* )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:598:1: ( rule__Source__Group_3__0 )*
            {
             before(grammarAccess.getSourceAccess().getGroup_3()); 
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:599:1: ( rule__Source__Group_3__0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==16) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:599:2: rule__Source__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__Source__Group_3__0_in_rule__Source__Group__3__Impl1147);
            	    rule__Source__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getSourceAccess().getGroup_3()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Source__Group__3__Impl"


    // $ANTLR start "rule__Source__Group__4"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:610:1: rule__Source__Group__4 : rule__Source__Group__4__Impl ;
    public final void rule__Source__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:614:1: ( rule__Source__Group__4__Impl )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:615:2: rule__Source__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Source__Group__4__Impl_in_rule__Source__Group__41180);
            rule__Source__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Source__Group__4"


    // $ANTLR start "rule__Source__Group__4__Impl"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:621:1: rule__Source__Group__4__Impl : ( '}' ) ;
    public final void rule__Source__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:625:1: ( ( '}' ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:626:1: ( '}' )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:626:1: ( '}' )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:627:1: '}'
            {
             before(grammarAccess.getSourceAccess().getRightCurlyBracketKeyword_4()); 
            match(input,15,FOLLOW_15_in_rule__Source__Group__4__Impl1208); 
             after(grammarAccess.getSourceAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Source__Group__4__Impl"


    // $ANTLR start "rule__Source__Group_3__0"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:650:1: rule__Source__Group_3__0 : rule__Source__Group_3__0__Impl rule__Source__Group_3__1 ;
    public final void rule__Source__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:654:1: ( rule__Source__Group_3__0__Impl rule__Source__Group_3__1 )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:655:2: rule__Source__Group_3__0__Impl rule__Source__Group_3__1
            {
            pushFollow(FOLLOW_rule__Source__Group_3__0__Impl_in_rule__Source__Group_3__01249);
            rule__Source__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Source__Group_3__1_in_rule__Source__Group_3__01252);
            rule__Source__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Source__Group_3__0"


    // $ANTLR start "rule__Source__Group_3__0__Impl"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:662:1: rule__Source__Group_3__0__Impl : ( 'register' ) ;
    public final void rule__Source__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:666:1: ( ( 'register' ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:667:1: ( 'register' )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:667:1: ( 'register' )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:668:1: 'register'
            {
             before(grammarAccess.getSourceAccess().getRegisterKeyword_3_0()); 
            match(input,16,FOLLOW_16_in_rule__Source__Group_3__0__Impl1280); 
             after(grammarAccess.getSourceAccess().getRegisterKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Source__Group_3__0__Impl"


    // $ANTLR start "rule__Source__Group_3__1"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:681:1: rule__Source__Group_3__1 : rule__Source__Group_3__1__Impl ;
    public final void rule__Source__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:685:1: ( rule__Source__Group_3__1__Impl )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:686:2: rule__Source__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Source__Group_3__1__Impl_in_rule__Source__Group_3__11311);
            rule__Source__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Source__Group_3__1"


    // $ANTLR start "rule__Source__Group_3__1__Impl"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:692:1: rule__Source__Group_3__1__Impl : ( ( rule__Source__AdapterAssignment_3_1 ) ) ;
    public final void rule__Source__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:696:1: ( ( ( rule__Source__AdapterAssignment_3_1 ) ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:697:1: ( ( rule__Source__AdapterAssignment_3_1 ) )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:697:1: ( ( rule__Source__AdapterAssignment_3_1 ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:698:1: ( rule__Source__AdapterAssignment_3_1 )
            {
             before(grammarAccess.getSourceAccess().getAdapterAssignment_3_1()); 
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:699:1: ( rule__Source__AdapterAssignment_3_1 )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:699:2: rule__Source__AdapterAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Source__AdapterAssignment_3_1_in_rule__Source__Group_3__1__Impl1338);
            rule__Source__AdapterAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getSourceAccess().getAdapterAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Source__Group_3__1__Impl"


    // $ANTLR start "rule__PackageDeclaration__NameAssignment_1"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:714:1: rule__PackageDeclaration__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__PackageDeclaration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:718:1: ( ( ruleQualifiedName ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:719:1: ( ruleQualifiedName )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:719:1: ( ruleQualifiedName )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:720:1: ruleQualifiedName
            {
             before(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__PackageDeclaration__NameAssignment_11377);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__NameAssignment_1"


    // $ANTLR start "rule__PackageDeclaration__SourceModelAssignment_2"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:729:1: rule__PackageDeclaration__SourceModelAssignment_2 : ( ruleSourceModel ) ;
    public final void rule__PackageDeclaration__SourceModelAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:733:1: ( ( ruleSourceModel ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:734:1: ( ruleSourceModel )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:734:1: ( ruleSourceModel )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:735:1: ruleSourceModel
            {
             before(grammarAccess.getPackageDeclarationAccess().getSourceModelSourceModelParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleSourceModel_in_rule__PackageDeclaration__SourceModelAssignment_21408);
            ruleSourceModel();

            state._fsp--;

             after(grammarAccess.getPackageDeclarationAccess().getSourceModelSourceModelParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__SourceModelAssignment_2"


    // $ANTLR start "rule__SourceModel__SourcesAssignment_1"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:744:1: rule__SourceModel__SourcesAssignment_1 : ( ruleSource ) ;
    public final void rule__SourceModel__SourcesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:748:1: ( ( ruleSource ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:749:1: ( ruleSource )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:749:1: ( ruleSource )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:750:1: ruleSource
            {
             before(grammarAccess.getSourceModelAccess().getSourcesSourceParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleSource_in_rule__SourceModel__SourcesAssignment_11439);
            ruleSource();

            state._fsp--;

             after(grammarAccess.getSourceModelAccess().getSourcesSourceParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SourceModel__SourcesAssignment_1"


    // $ANTLR start "rule__Source__NameAssignment_1"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:759:1: rule__Source__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Source__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:763:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:764:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:764:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:765:1: RULE_ID
            {
             before(grammarAccess.getSourceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Source__NameAssignment_11470); 
             after(grammarAccess.getSourceAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Source__NameAssignment_1"


    // $ANTLR start "rule__Source__AdapterAssignment_3_1"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:774:1: rule__Source__AdapterAssignment_3_1 : ( ruleAdapter ) ;
    public final void rule__Source__AdapterAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:778:1: ( ( ruleAdapter ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:779:1: ( ruleAdapter )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:779:1: ( ruleAdapter )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:780:1: ruleAdapter
            {
             before(grammarAccess.getSourceAccess().getAdapterAdapterParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleAdapter_in_rule__Source__AdapterAssignment_3_11501);
            ruleAdapter();

            state._fsp--;

             after(grammarAccess.getSourceAccess().getAdapterAdapterParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Source__AdapterAssignment_3_1"


    // $ANTLR start "rule__Adapter__NameAssignment"
    // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:789:1: rule__Adapter__NameAssignment : ( RULE_ID ) ;
    public final void rule__Adapter__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:793:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:794:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:794:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.srct.ui/src-gen/hu/bme/mit/incquery/srct/ui/contentassist/antlr/internal/InternalSrct.g:795:1: RULE_ID
            {
             before(grammarAccess.getAdapterAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Adapter__NameAssignment1532); 
             after(grammarAccess.getAdapterAccess().getNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__NameAssignment"

    // Delegated rules


 

    public static final BitSet FOLLOW_rulePackageDeclaration_in_entryRulePackageDeclaration61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageDeclaration68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__0_in_rulePackageDeclaration94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSourceModel_in_entryRuleSourceModel181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSourceModel188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SourceModel__Group__0_in_ruleSourceModel214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSource_in_entryRuleSource241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSource248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Source__Group__0_in_ruleSource274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdapter_in_entryRuleAdapter301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdapter308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Adapter__NameAssignment_in_ruleAdapter334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__0__Impl_in_rule__PackageDeclaration__Group__0368 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__1_in_rule__PackageDeclaration__Group__0371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__PackageDeclaration__Group__0__Impl399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__1__Impl_in_rule__PackageDeclaration__Group__1430 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__2_in_rule__PackageDeclaration__Group__1433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__NameAssignment_1_in_rule__PackageDeclaration__Group__1__Impl460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__2__Impl_in_rule__PackageDeclaration__Group__2490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__SourceModelAssignment_2_in_rule__PackageDeclaration__Group__2__Impl517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__0553 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__0556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__1612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl639 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__0674 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__0677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__QualifiedName__Group_1__0__Impl705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__1736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SourceModel__Group__0__Impl_in_rule__SourceModel__Group__0796 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__SourceModel__Group__1_in_rule__SourceModel__Group__0799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SourceModel__Group__1__Impl_in_rule__SourceModel__Group__1857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SourceModel__SourcesAssignment_1_in_rule__SourceModel__Group__1__Impl884 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_rule__Source__Group__0__Impl_in_rule__Source__Group__0919 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Source__Group__1_in_rule__Source__Group__0922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Source__Group__0__Impl950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Source__Group__1__Impl_in_rule__Source__Group__1981 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Source__Group__2_in_rule__Source__Group__1984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Source__NameAssignment_1_in_rule__Source__Group__1__Impl1011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Source__Group__2__Impl_in_rule__Source__Group__21041 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Source__Group__3_in_rule__Source__Group__21044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Source__Group__2__Impl1072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Source__Group__3__Impl_in_rule__Source__Group__31103 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Source__Group__4_in_rule__Source__Group__31106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Source__Group_3__0_in_rule__Source__Group__3__Impl1135 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__Source__Group_3__0_in_rule__Source__Group__3__Impl1147 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__Source__Group__4__Impl_in_rule__Source__Group__41180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Source__Group__4__Impl1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Source__Group_3__0__Impl_in_rule__Source__Group_3__01249 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Source__Group_3__1_in_rule__Source__Group_3__01252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Source__Group_3__0__Impl1280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Source__Group_3__1__Impl_in_rule__Source__Group_3__11311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Source__AdapterAssignment_3_1_in_rule__Source__Group_3__1__Impl1338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__PackageDeclaration__NameAssignment_11377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSourceModel_in_rule__PackageDeclaration__SourceModelAssignment_21408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSource_in_rule__SourceModel__SourcesAssignment_11439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Source__NameAssignment_11470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdapter_in_rule__Source__AdapterAssignment_3_11501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Adapter__NameAssignment1532 = new BitSet(new long[]{0x0000000000000002L});

}